/*
 * BaseRunner
 *
 * Ivan Zherdev, 2019
 */

package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Класс test.BaseRunner является родительским для всех тестов.
 *
 * @author Ivan Zherdev
 */
public class BaseRunner {
    protected WebDriver driver;
    protected String baseUrl;
    public String browserName = System.getProperty("browser");

    @Before
    public void setUp() {
        driver = BrowsersFactory.valueOf(browserName).create();
        baseUrl = "https://www.tinkoff.ru/career/vacancies/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
