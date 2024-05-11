package com.at_lesson.listeners;

import com.at_lesson.utils.ScreanShotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListneres implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("=======================================================");
        System.out.println("Test " + result.getMethod().getMethodName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("=======================================================");
        System.out.println("Test " + result.getMethod().getMethodName() + " Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        WebDriver driver;
        System.out.println("=======================================================");
        System.out.println("Test " + result.getMethod().getMethodName() + " Failure");
//        ScreanShotUtils.takeScreenshot(driver);
//        System.out.println(driver.getPageSource());
    }
}
