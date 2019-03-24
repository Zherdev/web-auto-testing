/*
 * BrowsersFactory
 *
 * Ivan Zherdev, 2019
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public enum BrowsersFactory {
    chrome {
        public WebDriver create() {
            System.out.println("Запускаем браузер Chrome...");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            return new ChromeDriver(options);
        }
    },

    firefox {
        public WebDriver create() {
            System.out.println("Запускаем браузер Firefox...");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,
                               "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
                               "./src/test/resources/firefox_log.log");
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);

            return new FirefoxDriver(options);
        }
    },

    opera {
        public WebDriver create() {
            System.out.println("Запускаем браузер Opera...");
            OperaOptions options = new OperaOptions();
            options.setBinary(System.getProperty("opera-binary"));
            options.addArguments("--disable-notifications");

            return  new OperaDriver(options);
        }
    };

    public WebDriver create() {
        return null;
    }

}
