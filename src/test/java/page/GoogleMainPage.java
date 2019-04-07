/*
 * GoogleMainPage
 *
 * Ivan Zherdev, 2019
 */

package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс GoogleMainPage представляет собой главную страницу Google.
 *
 * @author Ivan Zherdev
 */
public class GoogleMainPage extends Page {

    @FindBy(name = "q")
    public WebElement searchField;

    public GoogleMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        logger.info("Открываем Google.ru");
        driver.navigate().to("https://www.google.ru/");
        isLoadedByTitleContains("Google");
        logger.info("done");
    }

    /**
     * Метод typeResquest(...) вводит запрос в Google.
     *
     * @param request текст запроса
     */
    public void typeRequest(String request) {
        logger.info("Ищем в Google: " + request);
                wait.ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(d -> {
                    searchField.click();
                    searchField.clear();
                    /* В Chrome не действует .clear() */
                    searchField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    searchField.sendKeys(Keys.BACK_SPACE);
                    searchField.sendKeys(request);
                    return true;
                });
        logger.info("done");
    }

    /**
     * Метод chooseVariant(String text) кликает по одному из предложенных
     * поисковых запросов.
     *
     * @param text содержание предложенного запроса
     */
    public void clickVariant(String text) {
        logger.info("Выбираем вариант: " + text);
        driver.findElement(By.xpath("//b[text() = ' " + text + "']")).click();
        logger.info("done");
    }

}