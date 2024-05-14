package com.at_lesson.pages;

import com.at_lesson.utils.DriverManager;
import com.at_lesson.utils.MyWaiters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
    @FindBy(xpath = "//b[text()='follow me on Linkedin.']")
    private WebElement linkLinkedinXPATH;


    private String url = "https://react-shopping-cart-67954.firebaseapp.com/";


    public MainPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    public void openUrl() {
        DriverManager.getDriver().get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    //кликает по кнопке добавить в корзину по индексу, из массива
    public CartPage clickAddtoCartBtn(int indexBtn) {
        MyWaiters.waitElementIsClickable(addBtnInCartXPATH.get(indexBtn));
        addBtnInCartXPATH.get(indexBtn).click();
        return new CartPage();
    }

    //Отдает заголовок продукта по индексу, из массива
    public String getNameProduct(int index) {
        MyWaiters.waitElementIsVisible(allNameProductCSS.get(index));
        return allNameProductCSS.get(index).getText();
    }

    //Создает массив из заголовков карточек продукта на странице
    public List<String> getAllNameProduct() {
        MyWaiters.waitElementIsVisible(allNameProductCSS.get(0));
        List<WebElement> allNameProductCSS = this.allNameProductCSS;
        return allNameProductCSS.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    //Добавляет все продукты на странице в корзину
    public CartPage clickAddtoCartBtnAll() {
        MyWaiters.waitElementIsClickable(addBtnInCartXPATH.get(0));
        for (WebElement element : addBtnInCartXPATH) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
        }
        return new CartPage();
    }

    //кликает по кнопке филтр, по индексу из массива
    public MainPage clickFilterBtnBySize(int indexBtn) {
        MyWaiters.waitElementIsClickable(filterBtnBySize.get(0));
        filterBtnBySize.get(indexBtn).click();
        return new MainPage();
    }

    //Отдает количество продуктов на странице по заголовку
    public int countProductByTitile() {
        MyWaiters.waitElementIsClickable(allNameProductCSS.get(0));
        String strTitleAllProduct = titelNumberOfProductsXPATH.getText();
        return Integer.valueOf(strTitleAllProduct.replaceAll("\\D+", ""));
    }

    //тестовый метод
    public String getTextFilterBtn(int indexBtn) {
        MyWaiters.waitElementIsClickable(filterBtnBySize.get(0));
        return filterBtnBySize.get(indexBtn).getText();
    }

    //Кликает по кнопке фильтр, находя её из массива по тексту элемента
    public MainPage clickFilterBtnByText(String btnName) {
        MyWaiters.waitElementIsClickable(filterBtnBySize.get(0));
        for (int i = 0; i < filterBtnBySize.size(); i++) {
            if (filterBtnBySize.get(i).getText().equals(btnName)) {
                filterBtnBySize.get(i).click();
                return new MainPage();
            }
        }
        return new MainPage();
    }


}
 