/*
 * CustomListener
 *
 * Ivan Zherdev, 2019
 */

package utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Класс CustomListener предназначен для логгирования.
 *
 * @author Ivan Zherdev
 */
public class CustomListener extends AbstractWebDriverEventListener {

    Logger logger;

    public CustomListener(Class classAttr) {
        logger = LoggerFactory.getLogger(classAttr);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Обращение к элементу " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Найден элемент " + by);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File file = new File("target", "screen-" +
                System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.error(file.getAbsolutePath());
    }

}
