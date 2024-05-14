package com.at_lesson;

import com.at_lesson.enums.Capability;
import com.at_lesson.listeners.ElementActionListener;
import com.at_lesson.listeners.TestListneres;
import com.at_lesson.utils.DriverFactory;
import com.at_lesson.utils.DriverManager;
import com.at_lesson.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.*;

import java.sql.Driver;
import java.time.Duration;

@Listeners(TestListneres.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
    }

}
