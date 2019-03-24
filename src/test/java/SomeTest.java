/*
 * SomeTest
 *
 * Ivan Zherdev, 2019
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;

/**
 * Класс под тесты
 *
 * @author Ivan Zherdev
 */
public class SomeTest extends BaseRunner {

    /**
     * Проверка сообщений о незаполненных полях формы.
     */
    @Test
    public void test1() {
        System.out.println("Первый тест.");
        driver.get(baseUrl);

        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("f");
        driver.findElement(By.name("name")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Поле обязательное", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());

        driver.findElement(By.name("birthday")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Поле обязательное", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).getText());

        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys("f");
        driver.findElement(By.name("city")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Поле обязательное", driver
                .findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/form/div[3]/div/div[2]")).getText());

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("f");
        driver.findElement(By.name("email")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Поле обязательное", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[2]")).getText());

        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("2");
        driver.findElement(By.name("phone")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Поле обязательное", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")).getText());

        driver.findElement(By.name("socialLink0")).click();
        driver.findElement(By.name("socialLink0")).clear();
        driver.findElement(By.name("socialLink0")).sendKeys("f");
        driver.findElement(By.name("socialLink0")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();

        driver.findElement(By.cssSelector("svg.ui-icon-checkbox.ui-checkbox__icon")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Поле обязательное", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условиями передачи информации'])[1]/following::div[1]")).getText());
    }

    /**
     * Проверка сообщений о неправильном заполнении полей формы.
     */
    @Test
    public void test2() {
        System.out.println("Второй тест.");
        driver.get(baseUrl);

        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("123 abc ./#@");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Допустимо использовать только буквы русского алфавита и дефис", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());

        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        for (int i = 0; i < 20; i++) {
            driver.findElement(By.name("name")).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(By.name("name")).sendKeys("ОдноСлово");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Необходимо ввести фамилию и имя через пробел", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());

        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        for (int i = 0; i < 20; i++) {
            driver.findElement(By.name("name")).sendKeys(Keys.BACK_SPACE);
        }
        for (int i = 0; i < 140; i++) {
            driver.findElement(By.name("name")).sendKeys("Ы");
        }
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Максимальное количество символов – 133", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());

        driver.findElement(By.name("birthday")).click();
        driver.findElement(By.name("birthday")).clear();
        driver.findElement(By.name("birthday")).sendKeys("99999999");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Поле заполнено некорректно", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).getText());

        driver.findElement(By.name("birthday")).click();
        driver.findElement(By.name("birthday")).clear();
        for (int i = 0; i < 20; i++) {
            driver.findElement(By.name("birthday")).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(By.name("birthday")).sendKeys("01012300");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Мы не нанимаем пришельцев из будущего", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).getText());

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("абырвалг");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Введите корректный адрес эл. почты", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[2]")).getText());

        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone"))
                .sendKeys("0000000000");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div"))
                .click();
        assertEquals("Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")).getText());
    }


}
