/*
 * GoogleMainPage
 *
 * Ivan Zherdev, 2019
 */

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.navigate().to("https://www.google.ru/");
        isLoadedByTitleContains("Google");
    }

    /**
     * Метод chooseVariant(String text) кликает по одному из предложенных
     * поисковых запросов.
     *
     * @param text содержание предложенного запроса
     */
    public void clickVariant(String text) {
        driver.findElement(By.xpath("//b[text() = ' " + text + "']")).click();
    }

}