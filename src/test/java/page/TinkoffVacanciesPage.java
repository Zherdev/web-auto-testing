/*
 * TinkoffVacanciesPage
 *
 * Ivan Zherdev, 2019
 */

package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

/**
 * Класс TinkoffVacanciesPage представляет собой страницу Тинькофф Вакансии.
 *
 * @author Ivan Zherdev
 */
public class TinkoffVacanciesPage extends Page {

    @FindBy(xpath = "//*[@name='name']")
    public WebElement name;

    @FindBy(xpath = "//*[@name='birthday']")
    public WebElement birthday;

    @FindBy(xpath = "//*[@name='city']")
    public WebElement city;

    @FindBy(xpath = "//*[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//*[@name='phone']")
    public WebElement phone;

    @FindBy(xpath = "//*[@name='socialLink0']")
    public WebElement socialLink;

    @FindBy(xpath = "//label[contains(@for, 'agreement')]")
    public WebElement agreement;

    public TinkoffVacanciesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        logger.info("Открываем Тинкофф Вакансии");
        driver.navigate().to("https://www.tinkoff.ru/career/vacancies/");
        isLoadedByTitleContains("Вакансии");
        logger.info("done");
    }

    /** Клик никуда. */
    public void clickNothing() {
        logger.info("Кликаем никуда");
        clickByXPath("//div[contains(@data-qa-file, 'CareerLayout')]");
        logger.info("done");
    }

    /**
     * Метод checkError(...) производит assertEquals с текстом ошибки.
     *
     * @param element элемент, ошибка под которым проверяется
     * @param errorText текст ошибки
     */
    public void checkError(WebElement element, String errorText) {
        logger.info("Проверяем ошибку " + errorText);
        assertEquals(errorText, element.findElement(
                By.xpath(".//ancestor::div/div[contains(@data-qa-file, 'UIFormRowError')]")).getText());
        logger.info("ok");
    }

}
