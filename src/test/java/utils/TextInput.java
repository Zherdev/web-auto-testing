/*
 * TextInput
 *
 * Ivan Zherdev, 2019
 */

package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс TextInput предназначен для работы с полями ввода текста
 * на веб-странице.
 *
 * @author Ivan Zherdev
 */
public class TextInput {

    private WebElement field;
    private WebDriverWait wait;

    public TextInput(WebDriver driver, String name) {
        field = driver.findElement(
                By.xpath("//span[contains(text(), '" + name + "')]/../../input"));
        wait = new WebDriverWait(driver, 10);
    }

    /** @param text текст вводится в поле */
    public void typeText(String text) {
        wait.ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(d -> {
                    field.click();
                    field.clear();
                    /* В Chrome не действует .clear() */
                    field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    field.sendKeys(Keys.BACK_SPACE);
                    field.sendKeys(text);
                    return true;
                });
    }

    /** @return текущее значение поля */
    public String getText() {
        return field.getAttribute("value");
    }
}
