package com.at_lesson;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Facebook {
    WebDriver driver;

    private final String firstProductNameCSS = "div[class='sc-124al1g-2 dwOYCh'] p[class='sc-124al1g-4 eeXMBo']"; //cssSelector
    private final String firstBtnAddProductXPATH = "//button[@class = 'sc-124al1g-0 jCsgpZ'][1]"; //xpath,
    // cssSelector div[class='sc-124al1g-2 dwOYCh'] button[class='sc-124al1g-0 jCsgpZ']
    //xpath //div[@class = 'sc-124al1g-2 dwOYCh']//button
    private final String productInCartCSS = "div[class = 'sc-1h98xa9-1 kQlqIC'] p[class = 'sc-11uohgb-2 elbkhN']"; //cssSelector
    private final String allNameProductCSS = "p[class = 'sc-124al1g-4 eeXMBo']"; //cssSelector
    private final String allNameProductXPATH = "//p[@class='sc-124al1g-4 eeXMBo']"; //xpath
    private final String addBtnInCartXPATH = "//*[text() = 'Add to cart']"; //xpath
    private final String closeCartBtnCSS = "button[class='sc-1h98xa9-0 gFkyvN']"; //cssSelector
    private final String allNameProductInCartCSS = "p[class = 'sc-11uohgb-2 elbkhN']"; //cssSelector
    private final String openCartBtnXPATH = "//button[@class='sc-1h98xa9-0 gFkyvN']"; //xpath
    private final String filterBtnSizeSXPATH ="//span[text()='S']"; //xpath
    private final String titelNumberOfProductsXPATH = "//main[@class ='sc-ebmerl-4 iliWeY']//p"; //xpath
    private final String titelNumberOfProductsCSS = ".sc-124al1g-1.csvtPz"; //cssSelector



    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void addFirstProduct() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        WebElement firstProductWebElement = driver.findElement(By.cssSelector(firstProductNameCSS));
        String stringNameFirstProduct = firstProductWebElement.getText();

        WebElement firstAddBtnWebElement = driver.findElement(By.xpath(firstBtnAddProductXPATH));
        firstAddBtnWebElement.click();

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(productInCartCSS)));

        WebElement firstProductNameInCart = driver.findElement(By.cssSelector(productInCartCSS));
        String stringNameFirstProductInCart = firstProductNameInCart.getText();

        Assert.assertTrue(stringNameFirstProduct.equals(stringNameFirstProductInCart),"The added product in the cart is different");
    }

    @Test
    public void addFullProductInCart() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        List<WebElement> allNameProductWebElemnts = driver.findElements(By.cssSelector(allNameProductCSS));
        List<String> allNameProductStr = allNameProductWebElemnts.stream().map(WebElement::getText).collect(Collectors.toList());

        List<WebElement> webElementList = driver.findElements(By.xpath(addBtnInCartXPATH));
        for (WebElement element1 : webElementList) {
            element1.click();
            driver.findElement(By.cssSelector(closeCartBtnCSS)).click();
        }
        driver.findElement(By.xpath(openCartBtnXPATH)).click();
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(productInCartCSS)));

        List<WebElement> allNameProductWebElemntsInCart = driver.findElements(By.cssSelector(allNameProductInCartCSS));
        List<String> allNameProductInCartStr = allNameProductWebElemntsInCart.stream().map(WebElement::getText).collect(Collectors.toList());

        Assert.assertTrue(allNameProductStr.equals(allNameProductInCartStr),"Not all products are in the cart");
    }

    @Test
    public void taskThree() throws InterruptedException {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        List<WebElement> webElementProductsAllSize = driver.findElements(By.cssSelector(allNameProductCSS));

        driver.findElement(By.xpath(filterBtnSizeSXPATH)).click();
        Thread.sleep(1000);

        List<WebElement> webElementProductsSSize = driver.findElements(By.xpath(allNameProductXPATH));

        Assert.assertTrue(webElementProductsAllSize.size() > webElementProductsSSize.size(), "Size filter doesn't workgi");
    }



    @Test
    public void taskFour() throws InterruptedException {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        WebElement webElentTitleAllProduct = driver.findElement(By.xpath(titelNumberOfProductsXPATH));

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(titelNumberOfProductsCSS)));

        String strTitleAllProduct = webElentTitleAllProduct.getText();
        int number = Integer.valueOf(strTitleAllProduct.replaceAll("\\D+", ""));

        driver.findElement(By.xpath(filterBtnSizeSXPATH)).click();
        Thread.sleep(1000);

        String strTitleAllProductTwo = webElentTitleAllProduct.getText();
        int number2 = Integer.valueOf(strTitleAllProductTwo.replaceAll("\\D+", ""));

        Assert.assertTrue(number > number2, "Size filter doesn't work");
    }


    @AfterTest
    public void closeSession() {
        driver.quit();
    }


}
