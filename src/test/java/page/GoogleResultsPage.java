/*
 * GoogleResultsPage
 *
 * Ivan Zherdev, 2019
 */

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Класс GoogleResultsPage представляет страницу с результатами поиска Google.
 *
 * @author Ivan Zherdev
 */
public class GoogleResultsPage extends Page {

    public GoogleResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickSearchResultByLinkContains(String url) {
        Actions actions = new Actions(driver);
        WebElement link = driver.findElement(By.xpath("//cite[contains(text(), '" + url + "')]"));
        actions.moveToElement(link).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).perform();
    }

}