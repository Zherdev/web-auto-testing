/*
 * FifthTest
 *
 * Ivan Zherdev, 2019
 */

package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(FifthTest.class);

    @Test
    public void test1() {

        TinkoffTariffPage tinkoffTariff = app.tinkoffTariff;
        tinkoffTariff.open();

        tinkoffTariff.chooseNothing();

        assertEquals(0, tinkoffTariff.getPrice());
        logger.info("Стоимость равна 0");

        assertEquals(true, tinkoffTariff.orderSimButton.isEnabled());
        logger.info("Кнопка заказа sim активна");
    }

}
