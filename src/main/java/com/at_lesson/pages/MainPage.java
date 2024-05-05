package com.at_lesson.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BasePage {

    @FindBy(css = "p[class = 'sc-124al1g-4 eeXMBo']")
    private List<WebElement> allNameProductCSS;
    @FindBy(xpath = "//*[text() = 'Add to cart']")
    private List<WebElement> addBtnInCartXPATH;
    @FindBy(xpath = "//button[@class='sc-1h98xa9-0 gFkyvN']")
    private WebElement openCartBtnXPATH;
    @FindBy(xpath = "//span[@class = 'checkmark']")
    private List<WebElement> filterBtnBySize;
    @FindBy(xpath = "//main[@class ='sc-ebmerl-4 iliWeY']//p")
    private WebElement titelNumberOfProductsXPATH;
    @FindBy(css = ".sc-124al1g-1.csvtPz")
    private WebElement titelNumberOfProductsCSS;


    private String url = "https://react-shopping-cart-67954.firebaseapp.com/";


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openUrl() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    public CartPage clickAddtoCartBtn(int indexBtn) {
        waitElementIsClickable(addBtnInCartXPATH.get(indexBtn));
        addBtnInCartXPATH.get(indexBtn).click();
        return new CartPage(driver);
    }

    public String getNameProduct(int index) {
        waitElementIsVisible(allNameProductCSS.get(index));
        return allNameProductCSS.get(index).getText();
    }

    public List<String> getAllNameProduct() {
        waitElementIsVisible(allNameProductCSS.get(0));
        List<WebElement> allNameProductCSS = this.allNameProductCSS;
        return allNameProductCSS.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public CartPage clickAddtoCartBtnAll() {
        waitElementIsClickable(addBtnInCartXPATH.get(0));
        for (WebElement element : addBtnInCartXPATH) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
        return new CartPage(driver);
    }

    public MainPage clickFilterBtnBySize(int indexBtn) {
        waitElementIsClickable(filterBtnBySize.get(0));
        filterBtnBySize.get(indexBtn).click();
        return new MainPage(driver);
    }

    public int countProductByTitile() {
        waitElementIsClickable(allNameProductCSS.get(0));
        String strTitleAllProduct = titelNumberOfProductsXPATH.getText();
        return Integer.valueOf(strTitleAllProduct.replaceAll("\\D+", ""));
    }

}
 