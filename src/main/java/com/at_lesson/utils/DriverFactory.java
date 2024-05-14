package com.at_lesson.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);

    public static WebDriver createDriver(String browser) {
        LOGGER.debug("Browser is chrome");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equals("firefox")) {
            LOGGER.debug("Browser is firefox");
            System.setProperty("webdriver.firefox.driver", "C:/ChromeDriver/geckodriver.exe");
            LOGGER.debug("Options are created");
            return new FirefoxDriver();
        }
        return null;
    }
}
