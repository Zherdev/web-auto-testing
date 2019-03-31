/*
 * Page
 *
 * Ivan Zherdev, 2019
 */

package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс Page представляет собой страницу какого-либо сайта.
 *
 * @author Ivan Zherdev
 */
public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public boolean isLoadedByTitleContains(String substring) {
        wait.until(d -> d.getTitle().contains(substring));
        return true;
    }

    public void clickByXPath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    /**
     * Метод switchToWindow(String windowName) переключается на вкладку по имени.
     *
     * @param windowName имя вкладки
     */
    public void switchToWindow(String windowName){
        wait.until(d -> {
            boolean check = false;
            for (String title : driver.getWindowHandles()) {
                driver.switchTo().window(title);
                check = d.getTitle().equals(windowName);
            }
            return check;
        });
    }

    /**
     * Метод switchToMainTab() переключает на главную (первую) вкладку.
     */
    public void switchToMainTab(){
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }

}
