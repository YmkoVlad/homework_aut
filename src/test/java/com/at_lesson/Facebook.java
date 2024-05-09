package com.at_lesson;

import com.at_lesson.pages.CartPage;
import com.at_lesson.pages.MainPage;
import com.at_lesson.utils.ScreanShotUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;

public class Facebook extends BaseTest {

    @Test
    public void verifyAddProductInCartByTitle() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl();
        String nameProductMainPage = mainPage.getNameProduct(0);
        CartPage cartPage = mainPage.clickAddtoCartBtn(0);
        String nameProductInCart = cartPage.getNameProductInCart(0);
        Assert.assertEquals(nameProductMainPage, nameProductInCart);
        ScreanShotUtils.takeScreenshot(driver);
    }

    @Test
    public void verifyAddAllProductInCartByTitle() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl();
        List<String> allProductNameByMainPage = mainPage.getAllNameProduct();
        CartPage cartPage = mainPage.clickAddtoCartBtnAll();
        List<String> allProductNameByCartPage = cartPage.getAllNameProductInCart();
        Assert.assertEquals(allProductNameByMainPage, allProductNameByCartPage);
        ScreanShotUtils.takeScreenshot(driver);
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
        ScreanShotUtils.takeScreenshot(driver);
    }

    @Test
    public void verifyAddFiltByTitel() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openUrl();
        int countProductbyTitle = mainPage.countProductByTitile();
        mainPage.clickFilterBtnBySize(1);
        Thread.sleep(2000);  //не придумал пока ожидалки TODO доделать ожидалку
        int countProductbyTitleAfterFilter = mainPage.countProductByTitile();
        Assert.assertTrue(countProductbyTitle > countProductbyTitleAfterFilter, "Size filter doesn't workgi");
        ScreanShotUtils.takeScreenshot(driver);
    }


}
