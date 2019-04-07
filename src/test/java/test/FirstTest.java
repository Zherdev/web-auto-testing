/*
 * FirstTest
 *
 * Ivan Zherdev, 2019
 */

package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.Page;
import page.TinkoffVacanciesPage;

/**
 * Первый тест, ДЗ к лецкии 6, задание 2.1, Тинькофф Вакансии.
 * Прокликивание полей формы, проверка сообщений о незаполненных полях.
 *
 * @author Ivan Zherdev
 */
public class FirstTest extends BaseRunner {

    private Logger logger = LoggerFactory.getLogger(FirstTest.class);

    @Test
    public void test1() {
        TinkoffVacanciesPage tinkoffVacancies = app.tinkoffVacancies;
        tinkoffVacancies.open();

        logger.info("Кликаем по ФИО");
        tinkoffVacancies.name.click();
        tinkoffVacancies.clickNothing();

        logger.info("Кликаем по дате рождения");
        tinkoffVacancies.birthday.click();
        tinkoffVacancies.clickNothing();
        tinkoffVacancies.checkError(tinkoffVacancies.birthday, "Поле обязательное");

        logger.info("Кликаем по городу");
        tinkoffVacancies.city.click();
        tinkoffVacancies.clickNothing();

        logger.info("Кликаем по e-mail");
        tinkoffVacancies.email.click();
        tinkoffVacancies.clickNothing();

        logger.info("Кликаем по телефону");
        tinkoffVacancies.phone.click();
        tinkoffVacancies.clickNothing();

        logger.info("Кликаем по соц.");
        tinkoffVacancies.socialLink.click();
        tinkoffVacancies.clickNothing();

        logger.info("Кликаем по согласию");
        tinkoffVacancies.agreement.click();
        tinkoffVacancies.clickNothing();
        tinkoffVacancies.checkError(tinkoffVacancies.agreement, "Поле обязательное");
    }

}
