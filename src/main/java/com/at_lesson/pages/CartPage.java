package com.at_lesson.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage{

    @FindBy(css = "p[class = 'sc-11uohgb-2 elbkhN']")
    private List<WebElement> allNameProductInCartCSS;
    @FindBy(css = "button[class='sc-1h98xa9-0 gFkyvN']")
    private WebElement closeCartBtnCSS;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getNameProductInCart(int index){
        waitElementIsVisible(allNameProductInCartCSS.get(index));
        return allNameProductInCartCSS.get(index).getText();
    }

    public List<String> getAllNameProductInCart() {
        waitElementIsVisible(allNameProductInCartCSS.get(0));
        List<WebElement> allNameProductCSS = this.allNameProductInCartCSS;
        return  allNameProductCSS.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
