/*
 * TinkoffTariffPage
 *
 * Ivan Zherdev, 2019
 */

package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.Button;
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

    public Button orderSimButton;

    public TinkoffTariffPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        logger.info("Открываем Тарифы Тинькофф Мобайла");
        driver.navigate().to("https://www.tinkoff.ru/mobile-operator/tariffs/");
        isLoadedByTitleContains("Тарифы");
        orderSimButton = new Button(driver, "Заказать сим-карту");
        logger.info("done");
    }

    /** @param region впервые устанавливает данный регион */
    public void setRegion(String region) {
        logger.info("Устанавливаем регион " + region);
        driver.findElement(By.xpath(
                "//span[contains(@class, 'MvnoRegionConfirmation__optionRejection')]"))
                .click();
        driver.findElement(By.xpath(
                "//div[contains(text(), '" + region + "')]")).click();
        logger.info("done");
    }

    /** @param region переключает на данный регион */
    public void switchToRegion(String region) {
        logger.info("Меняем регион на " +  region);
        driver.findElement(By.xpath(
                "//div[contains(@class, 'MvnoRegionConfirmation__title')]"))
                .click();
        driver.findElement(By.xpath(
                "//div[contains(text(), '" + region + "')]"))
                .click();
        logger.info("done");
    }

    /** @param region проверяет, что данный регион выбран */
    public void checkRegion(String region) {
        logger.info("Проверяем, что выбран регион " + region);
        wait.ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(d -> {
                    WebElement elem = driver.findElement(
                            By.xpath("//div[contains(@class, 'MvnoRegionConfirmation__title')]"));
                    assertEquals(region, elem.getText());
                    return true;
                });
        logger.info("ok");
    }

    /** @return цену тарифа */
    public int getPrice() {
        int res = Integer.valueOf(driver.findElement(By.xpath(
                "//h3[contains(@class, '__amountTitle')]"))
                .getText().replaceAll("\\D+",""));
        logger.info("Цена тарифа: " + res);
        return res;
    }

    /** Метод chooseAll() выбирает максимальный тариф */
    public void chooseAll() {
        logger.info("Выбираем максимальный тариф");

        Select internet = new Select(driver, "Интернет");
        Select calls = new Select(driver, "Звонки");

        internet.selectByText("Безлимитный интернет");
        calls.selectByText("Безлимитные минуты");

        CheckBox modem = new CheckBox(driver, "Режим модема");
        CheckBox sms = new CheckBox(driver, "Безлимитные СМС");

        modem.setActive(true);
        sms.setActive(true);

        logger.info("done");
    }

    /** Метод chooseNothing() выбирает минимальный тариф */
    public void chooseNothing() {
        logger.info("Выбираем минимальный тариф");

        Select internet = new Select(driver, "Интернет");
        Select calls = new Select(driver, "Звонки");

        internet.selectByText("0 ГБ");
        calls.selectByText("0 минут");

        CheckBox messengers = new CheckBox(driver, "Мессенджеры");
        CheckBox sms = new CheckBox(driver, "Безлимитные СМС");
        CheckBox social = new CheckBox(driver, "Социальные сети");
        CheckBox music = new CheckBox(driver, "Музыка");
        CheckBox video = new CheckBox(driver, "Видео");

        messengers.setActive(false);
        sms.setActive(false);
        social.setActive(false);
        music.setActive(false);
        video.setActive(false);

        logger.info("done");
    }

}
