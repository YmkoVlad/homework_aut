package com.at_lesson.listeners;

import com.at_lesson.utils.DriverManager;
import com.at_lesson.utils.ScreanShotUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListneres implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(TestListneres.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Test" + result.getMethod().getMethodName() + " Started");

//        System.out.println("=======================================================");
//        System.out.println("Test " + result.getMethod().getMethodName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test " + result.getMethod().getMethodName() + " Success");

//        System.out.println("=======================================================");
//        System.out.println("Test " + result.getMethod().getMethodName() + " Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("Test " + result.getMethod().getMethodName() + " Failure");
        ScreanShotUtils.takeScreenshot();
        LOGGER.info(DriverManager.getDriver().getPageSource());

//        System.out.println("=======================================================");
//        System.out.println("Test " + result.getMethod().getMethodName() + " Failure");
//        ScreanShotUtils.takeScreenshot();
//        System.out.println(DriverManager.getDriver().getPageSource());
    }

    @Override
    public void onFinish(ITestContext context) {
        DriverManager.quitDriver();
        LOGGER.info("Test " + context.getName() + " quitDriver");
    }


}
