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
     * Метод typeValue(...) очищает поле и вводит в него значение.
     *
     * @param element элемент (поле для ввода)
     * @param value значение
     */
    public void typeValue(WebElement element, String value){
        wait.ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(d -> {
                    element.click();
                    element.clear();
                    /* В Chrome не действует .clear() */
                    element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    element.sendKeys(Keys.BACK_SPACE);
                    element.sendKeys(value);
                    return true;
                });
    }

}