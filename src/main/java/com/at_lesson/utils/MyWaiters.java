package com.at_lesson.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyWaiters {

    public static WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitElementIsClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
