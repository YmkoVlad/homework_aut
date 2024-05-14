package com.at_lesson;

import com.at_lesson.pages.CartPage;
import com.at_lesson.pages.MainPage;
import com.at_lesson.testngexample.LoggerTest;
import com.at_lesson.utils.ScreanShotUtils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;

public class Facebook extends BaseTest {

    @Test
    public void verifyAddProductInCartByTitle() {
        MainPage mainPage = new MainPage();
        mainPage.openUrl();
        String nameProductMainPage = mainPage.getNameProduct(0);
        CartPage cartPage = mainPage.clickAddtoCartBtn(0);
        String nameProductInCart = cartPage.getNameProductInCart(0);
        Assert.assertEquals(nameProductMainPage, nameProductInCart);
        ScreanShotUtils.takeScreenshot();
    }

    @Test
    public void verifyAddAllProductInCartByTitle() {
        MainPage mainPage = new MainPage();
        mainPage.openUrl();
        List<String> allProductNameByMainPage = mainPage.getAllNameProduct();
        CartPage cartPage = mainPage.clickAddtoCartBtnAll();
        List<String> allProductNameByCartPage = cartPage.getAllNameProductInCart();
        Assert.assertEquals(allProductNameByMainPage, allProductNameByCartPage);
        ScreanShotUtils.takeScreenshot();
    }

    @Test
    public void verifyAddFiltByCountProduct() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openUrl();
        int sizeAllProductByMainPage = mainPage.getAllNameProduct().size();
        mainPage.clickFilterBtnBySize(1);
        Thread.sleep(1000);  //не придумал пока ожидалки TODO доделать ожидалку
        int sizeAllProductByMainPageAfterFilter = mainPage.getAllNameProduct().size();
        Assert.assertTrue(sizeAllProductByMainPage > sizeAllProductByMainPageAfterFilter, "Size filter doesn't workgi");
        ScreanShotUtils.takeScreenshot();
    }

    @Test
    public void verifyAddFiltByTitel() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openUrl();
        int countProductbyTitle = mainPage.countProductByTitile();
        mainPage.clickFilterBtnBySize(1);
        Thread.sleep(2000);  //не придумал пока ожидалки TODO доделать ожидалку
        int countProductbyTitleAfterFilter = mainPage.countProductByTitile();
        Assert.assertTrue(countProductbyTitle > countProductbyTitleAfterFilter, "Size filter doesn't workgi");
        ScreanShotUtils.takeScreenshot();
    }


    // cам Дата провайдер
    @DataProvider(name = "filterBySize")
    public Object[][] getData() {
        return new Object[][]{
                {"XS", 1},
                {"S", 2},
                {"M", 1},
                {"ML", 2},
                {"L", 10},
                {"XL", 10},
                {"XXL", 4}
        };
    }

    // 2. Создайте свой датапровайдер и используйте в тесте
    //тест с датапровайдером
    @Test(dataProvider = "filterBySize")
    public void verifyFilterByClickBtn(String size, int numberOfProducts) throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openUrl();
        mainPage.clickFilterBtnByText(size);
        Thread.sleep(1000);
        mainPage.countProductByTitile();
        Assert.assertEquals(mainPage.countProductByTitile(), numberOfProducts);

    }


}
