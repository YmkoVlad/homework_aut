package com.at_lesson.pages;

import com.at_lesson.utils.DriverManager;
import com.at_lesson.utils.MyWaiters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    @FindBy(css = "p[class = 'sc-11uohgb-2 elbkhN']")
    private List<WebElement> allNameProductInCartCSS;
    @FindBy(css = "button[class='sc-1h98xa9-0 gFkyvN']")
    private WebElement closeCartBtnCSS;


    public CartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    public String getNameProductInCart(int index) {
        MyWaiters.waitElementIsVisible(allNameProductInCartCSS.get(index));
        return allNameProductInCartCSS.get(index).getText();
    }

    public List<String> getAllNameProductInCart() {
        MyWaiters.waitElementIsVisible(allNameProductInCartCSS.get(0));
        List<WebElement> allNameProductCSS = this.allNameProductInCartCSS;
        return allNameProductCSS.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
