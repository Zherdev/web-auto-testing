/*
 * FirstTest
 *
 * Ivan Zherdev, 2019
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;

/**
 * Первый тест.
 * Проверка сообщений о незаполненных полях формы.
 *
 * @author Ivan Zherdev
 */
public class FirstTest extends BaseRunner {

    @Test
    public void test1() {
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

}
