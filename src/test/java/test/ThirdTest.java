/*
 * ThirdTest
 *
 * Ivan Zherdev, 2019
 */

package test;

import org.junit.Test;
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

        googleResults.switchToMainTab();
        googleResults.closeCurrentTab();

        googleResults.switchToWindowByName("Тарифы Тинькофф Мобайла");
        assertEquals(googleResults.getCurrentUrl(),
                "https://www.tinkoff.ru/mobile-operator/tariffs/");
    }
}
