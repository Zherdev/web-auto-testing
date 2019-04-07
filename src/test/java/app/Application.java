/*
 * Application
 *
 * Ivan Zherdev, 2019
 */

package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import page.GoogleMainPage;
import page.GoogleResultsPage;
import page.TinkoffTariffPage;
import page.TinkoffVacanciesPage;
import test.BrowsersFactory;
import utils.CustomListener;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Основной класс приложения.
 *
 * @author Ivan Zherdev
 */
public class Application {

    private WebDriver driver;

    public GoogleMainPage googleMain;
    public GoogleResultsPage googleResults;
    public TinkoffTariffPage tinkoffTariff;
    public TinkoffVacanciesPage tinkoffVacancies;

    public final String browserName = System.getProperty("browser") == null ?
            "chrome" : System.getProperty("browser");

    public Application() {
        driver = new EventFiringWebDriver(getDriver());
        ((EventFiringWebDriver) driver).register(new CustomListener(Application.class));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        googleMain = new GoogleMainPage(driver);
        googleResults = new GoogleResultsPage(driver);
        tinkoffTariff = new TinkoffTariffPage(driver);
        tinkoffVacancies = new TinkoffVacanciesPage(driver);
    }

    public void quit() {
        driver.quit();
        driver = null;
    }

    private WebDriver getDriver() {
        return BrowsersFactory.valueOf(browserName).create();
    }

}
