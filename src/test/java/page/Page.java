/*
 * Page
 *
 * Ivan Zherdev, 2019
 */

package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс Page представляет собой страницу какого-либо сайта.
 *
 * @author Ivan Zherdev
 */
public class Page {

    protected Logger logger = LoggerFactory.getLogger(Page.class);

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
     * Метод switchToWindowByName(String windowName) переключается на вкладку по имени.
     *
     * @param windowName имя вкладки
     */
    public void switchToWindowByName(String windowName){
        logger.info("Переключаемся на вкладку " + windowName);
        wait.until(d -> {
            boolean check = false;
            for (String title : driver.getWindowHandles()) {
                driver.switchTo().window(title);
                check = d.getTitle().equals(windowName);
            }
            return check;
        });
        logger.info("done");
    }

    /** @return заголовок страницы */
    public String getTitle() {
        logger.info("Заголовок страницы: " + driver.getTitle());
        return driver.getTitle();
    }

    /** Закрывает страницу */
    public void closeCurrentTab() {
        logger.info("Закрываем страницу " + driver.getTitle());
        driver.close();
        logger.info("done");
    }

    /** @return url страницы */
    public String getCurrentUrl() {
        logger.info("URL страницы: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    /**
     * Метод switchToWindowByNumber(int windowNumber) переключается на вкладку по номеру.
     *
     * @param windowNumber имя вкладки
     */
    public void switchToWindowByNumber(int windowNumber){
        logger.info("Переключаемся на вкладку по номеру " + windowNumber);
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[windowNumber]);
        logger.info("done");
    }

    /**
     * Метод switchToMainTab() переключает на главную (первую) вкладку.
     */
    public void switchToMainTab(){
        logger.info("Переключаемся на главную (первую) вкладку");
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        logger.info("done");
    }

    /** Обновляет страницу */
    public void refresh() {
        logger.info("Обновляем страницу");
        driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
        logger.info("done");
    }

    /**
     * @deprecated используется в ДЗ к лекции 6
     *
     * Метод typeValue(...) очищает поле и вводит в него значение.
     *
     * @param element элемент (поле для ввода)
     * @param value значение
     */
    public void typeValue(WebElement element, String value){
        logger.info("Вводим в поле текст " + value);
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
        logger.info("done");
    }

}
