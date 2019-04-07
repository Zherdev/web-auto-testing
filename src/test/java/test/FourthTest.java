/*
 * FourthTest
 *
 * Ivan Zherdev, 2019
 */

package test;

import org.junit.Test;
import page.TinkoffTariffPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Четвертый тест, ДЗ к лецкии 7, задание 2.2.
 * Смена региона.
 *
 * @author Ivan Zherdev
 */
public class FourthTest extends BaseRunner {

    @Test
    public void test1() {
        int moscowPrice;
        int krasnodarPrice;

        TinkoffTariffPage tinkoffTariff = app.tinkoffTariff;
        tinkoffTariff.open();

        tinkoffTariff.setRegion("Москва");
        tinkoffTariff.checkRegion("Москва и Московская область");

        tinkoffTariff.refresh();
        tinkoffTariff.checkRegion("Москва и Московская область");


        moscowPrice = tinkoffTariff.getPrice();
        tinkoffTariff.switchToRegion("Краснодар");
        krasnodarPrice = tinkoffTariff.getPrice();

        assertNotEquals(moscowPrice, krasnodarPrice);

        tinkoffTariff.chooseAll();
        krasnodarPrice = tinkoffTariff.getPrice();
        tinkoffTariff.switchToRegion("Москва");
        tinkoffTariff.chooseAll();
        moscowPrice = tinkoffTariff.getPrice();

        assertEquals(moscowPrice, krasnodarPrice);
    }

}
