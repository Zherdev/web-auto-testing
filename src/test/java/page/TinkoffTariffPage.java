/*
 * TinkoffTariffPage
 *
 * Ivan Zherdev, 2019
 */

package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.CheckBox;
import utils.Select;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Класс TinkoffTariffPage представляет собой страницу Тарифы Тинькофф Мобайла.
 *
 * @author Ivan Zherdev
 */
public class TinkoffTariffPage extends Page {

    public TinkoffTariffPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://www.tinkoff.ru/mobile-operator/tariffs/");
        isLoadedByTitleContains("Тарифы");
    }

    /** @param region впервые устанавливает данный регион */
    public void setRegion(String region) {
        driver.findElement(By.xpath(
                "//span[contains(@class, 'MvnoRegionConfirmation__optionRejection')]"))
                .click();
        driver.findElement(By.xpath(
                "//div[contains(text(), '" + region + "')]")).click();
    }

    /** @param region переключает на данный регион */
    public void switchToRegion(String region) {
        driver.findElement(By.xpath(
                "//div[contains(@class, 'MvnoRegionConfirmation__title')]"))
                .click();
        driver.findElement(By.xpath(
                "//div[contains(text(), '" + region + "')]"))
                .click();

    }

    /** @param region проверяет, что данный регион выбран */
    public void checkRegion(String region) {
        wait.ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(d -> {
                    WebElement elem = driver.findElement(
                            By.xpath("//div[contains(@class, 'MvnoRegionConfirmation__title')]"));
                    assertEquals(region, elem.getText());
                    return true;
                });
    }

    /** @return цену тарифа */
    public String getPrice() {
        return driver.findElement(By.xpath(
                "//h3[contains(@class, '__amountTitle')]")).getText();
    }

    /** Метод chooseAll() выбирает максимальный тариф */
    public void chooseAll() {
        Select internet = new Select(driver, "Интернет");
        Select calls = new Select(driver, "Звонки");

        internet.selectByText("Безлимитный интернет");
        calls.selectByText("Безлимитные минуты");

        CheckBox modem = new CheckBox(driver, "Режим модема");
        CheckBox sms = new CheckBox(driver, "Безлимитные СМС");

        modem.setActive(true);
        sms.setActive(true);
    }
}
