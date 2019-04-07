/*
 * ThirdTest
 *
 * Ivan Zherdev, 2019
 */

package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.GoogleMainPage;
import page.GoogleResultsPage;

import static org.junit.Assert.assertEquals;

/**
 * Третий тест, ДЗ к лецкии 7, задание 2.1.
 * Переключение между вкладками.
 *
 * @author Ivan Zherdev
 */
public class ThirdTest extends BaseRunner {

    private Logger logger = LoggerFactory.getLogger(ThirdTest.class);

    @Test
    public void test1() {
        GoogleMainPage googleMain = app.googleMain;
        googleMain.open();

        googleMain.typeRequest("мобайл тинькофф");
        googleMain.clickVariant("тарифы");

        GoogleResultsPage googleResults = app.googleResults;
        googleResults.clickSearchResultByLinkContains(
                "https://www.tinkoff.ru/mobile-operator/tariffs/");

        /* Переключаемся на открывшуюся вкладку */
        googleResults.switchToWindowByNumber(1);

        assertEquals(googleResults.getTitle(), "Тарифы Тинькофф Мобайла");
        logger.info("Проверили заголовок");

        googleResults.switchToMainTab();
        googleResults.closeCurrentTab();

        googleResults.switchToWindowByName("Тарифы Тинькофф Мобайла");
        assertEquals(googleResults.getCurrentUrl(),
                "https://www.tinkoff.ru/mobile-operator/tariffs/");
        logger.info("Проверили URL");
    }
}
