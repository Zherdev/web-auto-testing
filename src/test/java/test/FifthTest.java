/*
 * FifthTest
 *
 * Ivan Zherdev, 2019
 */

package test;

import org.junit.Test;
import page.TinkoffTariffPage;
import utils.Button;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Пятый тест, ДЗ к лецкии 7, задание 2.3.
 * Активная кнопка.
 *
 * @author Ivan Zherdev
 */
public class FifthTest extends BaseRunner {

    @Test
    public void test1() {

        TinkoffTariffPage tinkoffTariff = new TinkoffTariffPage(driver);
        tinkoffTariff.open();

        tinkoffTariff.chooseNothing();

        assertEquals(0, tinkoffTariff.getPrice());

        Button button = new Button(driver, "Заказать сим-карту");
        assertEquals(true, button.isEnabled());
    }

}
