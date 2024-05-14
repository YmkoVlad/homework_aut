package com.at_lesson.testngexample;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class TestNgTest extends BaseTest {

//    @BeforeMethod
//    public void beforeMethodBase() {
//        System.out.println("beforeMethod");
//    }
//    @BeforeClass
//    public void beforeClassBase() {
//        System.out.println("beforeClass");
//    }
//
//    @BeforeTest
//    public void beforeTestBase() {
//        System.out.println("beforeTest");
//    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][]{
                {"Ivan", "123", "Password is to short"},
                {"", "123123", "Username is empty"},
                {"Ivan", "", "Password is empty"}
        };
    }


    @Test(dataProvider = "data")
    public void fistTest(String name, String password, String errorMessage) throws InterruptedException {
        System.out.println(name + " " + password + " " + errorMessage);
        Thread.sleep(5000);
    }

    @Parameters({"key"})
    @Test
    public void secondTest(String key) throws InterruptedException {
        System.out.println("SecondTest " + key);
        Thread.sleep(5000);
    }

    int count = 0;

    @Test
    public void threeTest() {
        count++;
        assertEquals(3, count);
    }
}
