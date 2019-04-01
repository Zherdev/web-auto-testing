/*
 * Button
 *
 * Ivan Zherdev, 2019
 */

package utils;

import org.openqa.selenium.*;

/**
 * Класс Button предназначен для работы с кнопками на веб-странице.
 *
 * @author Ivan Zherdev
 */
public class Button {

    private WebElement button;

    public Button(WebDriver driver, String name) {
        button = driver.findElement(
                By.xpath("//div[contains(text(), '" + name + "')]/../.."));
    }

    /** @return вкл/выкл */
    public boolean isEnabled() {
        return button.isEnabled();
    }

}
