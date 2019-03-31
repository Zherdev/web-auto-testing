/*
 * SecondTest
 *
 * Ivan Zherdev, 2019
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import page.TinkoffVacanciesPage;

import static org.junit.Assert.assertEquals;

/**
 * Второй тест, ДЗ к лекции 6, задание 2.2.
 * Ввод невалидных значений, проверка сообщений о неправильном заполнении полей.
 *
 * @author Ivan Zherdev
 */
public class SecondTest extends BaseRunner {

    @Test
    public void test1() {
        TinkoffVacanciesPage tinkoffVacancies = new TinkoffVacanciesPage(driver);
        tinkoffVacancies.open();

        tinkoffVacancies.typeValue(tinkoffVacancies.name, "123 abc ./#@");
        tinkoffVacancies.clickNothing();
        tinkoffVacancies.checkError(tinkoffVacancies.name,
                "Допустимо использовать только буквы русского алфавита и дефис");

        tinkoffVacancies.typeValue(tinkoffVacancies.name, "ОдноСлово");
        tinkoffVacancies.clickNothing();
        tinkoffVacancies.checkError(tinkoffVacancies.name,
                "Необходимо ввести фамилию и имя через пробел");

        tinkoffVacancies.typeValue(tinkoffVacancies.name, "");
        for (int i = 0; i < 140; i++) {
            tinkoffVacancies.name.sendKeys("Ы");
        }
        tinkoffVacancies.clickNothing();
        tinkoffVacancies.checkError(tinkoffVacancies.name, "Максимальное количество символов – 133");

        tinkoffVacancies.typeValue(tinkoffVacancies.birthday, "99999999");
        tinkoffVacancies.clickNothing();
        tinkoffVacancies.checkError(tinkoffVacancies.birthday, "Поле заполнено некорректно");

        tinkoffVacancies.typeValue(tinkoffVacancies.birthday, "01012300");
        tinkoffVacancies.clickNothing();
        tinkoffVacancies.checkError(tinkoffVacancies.birthday, "Мы не нанимаем пришельцев из будущего");

        tinkoffVacancies.typeValue(tinkoffVacancies.email, "абырвалг");
        tinkoffVacancies.clickNothing();
        tinkoffVacancies.checkError(tinkoffVacancies.email, "Введите корректный адрес эл. почты");

        tinkoffVacancies.typeValue(tinkoffVacancies.phone, "0000000000");
        tinkoffVacancies.clickNothing();
        tinkoffVacancies.checkError(tinkoffVacancies.phone, "Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9");
        }

}
