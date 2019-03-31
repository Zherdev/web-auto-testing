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

public class Select extends org.openqa.selenium.support.ui.Select {

    public Select(WebDriver driver, String name) {
        super(driver.findElement(
                By.xpath("//span[contains(text(), '" + name + "')]/ancestor::div/select")));
    }

    /** @param text текст выбираемой опции селектора */
    public void selectByText(String text) {
        super.selectByVisibleText(text);
    }

    /** @return текущее выбранное значение селектора */
    public WebElement getSelectedOption() {
        return super.getFirstSelectedOption();
    }
}
