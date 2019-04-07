/*
 * BaseRunner
 *
 * Ivan Zherdev, 2019
 */

package test;

import app.Application;
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

    protected String baseUrl;
    public Application app;

    @Before
    public void setUp() {
        baseUrl = "https://www.tinkoff.ru/career/vacancies/";
        app = new Application();
    }

    @After
    public void tearDown() {
        app.quit();
    }
}
