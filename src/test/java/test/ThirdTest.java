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
        GoogleMainPage googleMain = new GoogleMainPage(driver);
        googleMain.open();

        googleMain.typeResquest("мобайл тинькофф");
        googleMain.clickVariant("тарифы");

        GoogleResultsPage googleResults = new GoogleResultsPage(driver);
        googleResults.clickSearchResultByLinkContains(
                "https://www.tinkoff.ru/mobile-operator/tariffs/");

        /* Переключаемся на открывшуюся вкладку */
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);

        assertEquals(driver.getTitle(), "Тарифы Тинькофф Мобайла");

        googleResults.switchToMainTab();
        driver.close();

        googleResults.switchToWindow("Тарифы Тинькофф Мобайла");
        assertEquals(driver.getCurrentUrl(),
                "https://www.tinkoff.ru/mobile-operator/tariffs/");
    }
}
