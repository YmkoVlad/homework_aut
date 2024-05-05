package com.at_lesson;

import com.at_lesson.pages.CartPage;
import com.at_lesson.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Facebook extends BaseTest {

    @Test
    public void verifyAddProductInCartByTitle() {
        MainPage mainPage = new MainPage(driver);
        CartPage cartPage = new CartPage(driver);
        mainPage.openUrl();
        String nameProductMainPage = mainPage.getNameProduct(0);
        mainPage.clickAddtoCartBtn(0);
        String nameProductInCart = cartPage.getNameProductInCart(0);
        Assert.assertEquals(nameProductMainPage, nameProductInCart);
    }

    @Test
    public void verifyAddAllProductInCartByTitle() {
        MainPage mainPage = new MainPage(driver);
        CartPage cartPage = new CartPage(driver);
        mainPage.openUrl();
        List<String> allProductNameByMainPage = mainPage.getAllNameProduct();
        mainPage.clickAddtoCartBtnAll();
        List<String> allProductNameByCartPage = cartPage.getAllNameProductInCart();
        Assert.assertEquals(allProductNameByMainPage, allProductNameByCartPage);
    }

    @Test
    public void verifyAddFiltByCountProduct() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl();
        int sizeAllProductByMainPage = mainPage.getAllNameProduct().size();
        System.out.println(sizeAllProductByMainPage);
        mainPage.clickFilterBtnBySize(1);
        Thread.sleep(1000);  //не придумал пока ожидалки TODO доделать ожидалку
        int sizeAllProductByMainPageAfterFilter = mainPage.getAllNameProduct().size();
        System.out.println(sizeAllProductByMainPageAfterFilter);
        Assert.assertTrue(sizeAllProductByMainPage > sizeAllProductByMainPageAfterFilter, "Size filter doesn't workgi");
    }

    @Test
    public void verifyAddFiltByTitel() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl();
        int countProductbyTitle = mainPage.countProductByTitile();
        mainPage.clickFilterBtnBySize(1);
        Thread.sleep(2000);  //не придумал пока ожидалки TODO доделать ожидалку
        int countProductbyTitleAfterFilter = mainPage.countProductByTitile();
        Assert.assertTrue(countProductbyTitle > countProductbyTitleAfterFilter,"Size filter doesn't workgi");

    }


}
