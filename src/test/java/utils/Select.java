/*
 * Select
 *
 * Ivan Zherdev, 2019
 */

/**
 * Класс Select предназначен для работы с селектами на веб-странице.
 *
 * @author Ivan Zherdev
 */
package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Select {

    private WebDriver driver;
    private WebElement select;

    public Select(WebDriver driver, String name) {
        this.driver = driver;
        select = driver.findElement(
                By.xpath("//span[contains(text(), '" + name + "')]/ancestor::div/select"));
    }

    /** @param text текст выбираемой опции селектора */
    public void selectByText(String text) {
        select.findElement(By.xpath(".//../div")).click();
        WebElement choice = driver.findElement(
                By.xpath("//span[contains(@class, 'list__item-text') " +
                         "and contains(text(), '" + text + "')]"));
        choice.click();
    }

    /** @return текущее выбранное значение селектора */
    public String getSelectedOption() {
        return select.findElement(
                By.xpath(".//..//span[contains(@class, 'ui-select__title-flex-text')]")).getText();
    }
}
