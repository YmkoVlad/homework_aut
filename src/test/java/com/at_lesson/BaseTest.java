package com.at_lesson;

import com.at_lesson.enums.Capability;
import com.at_lesson.listeners.ElementActionListener;
import com.at_lesson.listeners.TestListneres;
import com.at_lesson.utils.DriverFactory;
import com.at_lesson.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.sql.Driver;
import java.time.Duration;
@Listeners(TestListneres.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.createDriver(PropertyReader.getConfigPropery(Capability.BROWSER));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementActionListener());
        driver = decorator.decorate(driver);
    }

    @AfterTest
    public void closeSession() {
        driver.quit();
    }


}
