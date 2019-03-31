/*
 * FirstTest
 *
 * Ivan Zherdev, 2019
 */

package test;

import org.junit.Test;
import page.TinkoffVacanciesPage;

/**
 * Первый тест, ДЗ к лецкии 6, задание 2.1, Тинькофф Вакансии.
 * Прокликивание полей формы, проверка сообщений о незаполненных полях.
 *
 * @author Ivan Zherdev
 */
public class FirstTest extends BaseRunner {

    @Test
    public void test1() {
        TinkoffVacanciesPage tinkoffVacancies = new TinkoffVacanciesPage(driver);
        tinkoffVacancies.open();

        tinkoffVacancies.name.click();
        tinkoffVacancies.clickNothing();

        tinkoffVacancies.birthday.click();
        tinkoffVacancies.clickNothing();
        tinkoffVacancies.checkError(tinkoffVacancies.birthday, "Поле обязательное");

        tinkoffVacancies.city.click();
        tinkoffVacancies.clickNothing();

        tinkoffVacancies.email.click();
        tinkoffVacancies.clickNothing();

        tinkoffVacancies.phone.click();
        tinkoffVacancies.clickNothing();

        tinkoffVacancies.socialLink.click();
        tinkoffVacancies.clickNothing();

        tinkoffVacancies.agreement.click();
        tinkoffVacancies.clickNothing();
        tinkoffVacancies.checkError(tinkoffVacancies.agreement, "Поле обязательное");
    }

}
