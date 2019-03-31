/*
 * FirstTest
 *
 * Ivan Zherdev, 2019
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import page.TinkoffVacanciesPage;

import static org.junit.Assert.assertEquals;

/**
 * Первый тест, ДЗ к лецкии 6, задание 2.1.
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
