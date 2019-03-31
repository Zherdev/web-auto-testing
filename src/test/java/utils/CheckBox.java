/*
 * CheckBox
 *
 * Ivan Zherdev, 2019
 */

package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Класс CheckBox предназначен для работы с чекбоксами на веб-странице.
 *
 * @author Ivan Zherdev
 */
public class CheckBox {

    private WebDriver driver;
    private WebElement checkbox;

    public CheckBox(WebDriver driver, String name) {
        this.driver = driver;
        checkbox = driver.findElement(
                By.xpath("//label[contains(text(), '" + name + "')]/..//input"));
    }

    /** @return состояние чекбокса */
    public Boolean isSelected() {
        return checkbox.isSelected();
    }

    /**
     * Меняет состояние чекбокса.
     *
     * @param status вкл/выкл
     */
    public void setActive(Boolean status) {
        if (status != isSelected()) {
            checkbox.click();
        }
    }

    /** @return текст связанный с чекбоксом */
    public String getText() {
        return checkbox.findElement(By.xpath(".//ancestor::div/label")).getText();
    }

}
