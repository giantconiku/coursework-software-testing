package com.giant.coursework.tests;

import com.giant.coursework.enums.DashboardMenu;
import com.giant.coursework.enums.DashboardMenuCategory;
import com.giant.coursework.pages.*;
import com.giant.coursework.utils.Driver;
import com.giant.coursework.utils.GlobalConfigs;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DashboardTests {

    private final WelcomePage welcomePage;
    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;
    private final NotebooksPage notebooksPage;

    public DashboardTests() {

        welcomePage = new WelcomePage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        notebooksPage = new NotebooksPage();
    }

    @AfterMethod
    public void afterEach() {
        Driver.getDriver().close();
    }

    @Test
    public void successfulNotebooksAdditionToWishListAndToShoppingCartTest() throws InterruptedException {

        welcomePage.navigateToLoginPage();
        loginPage.login(GlobalConfigs.EMAIL, "$€1€n1uM");

        // -----------------------------------------------------------------------

        dashboardPage.hoverOverMenu(DashboardMenu.COMPUTERS, DashboardMenuCategory.NOTEBOOKS);
        Assert.assertEquals(notebooksPage.getPageTitle(), "Notebooks");

        notebooksPage.addToWishListProductWithNumber(2);
        Assert.assertEquals(notebooksPage.getConfirmMessageForAddingProductToWishList(),
                "The product has been added to your wishlist");

        notebooksPage.closeConfirmMessage();

        notebooksPage.addToWishListProductWithNumber(3);
        Assert.assertEquals(notebooksPage.getConfirmMessageForAddingProductToWishList(),
                "The product has been added to your wishlist");

        notebooksPage.closeConfirmMessage();

        notebooksPage.addToShoppingCartProductWithNumber(4);
        Assert.assertEquals(notebooksPage.getConfirmMessageForAddingProductToShoppingCart(),
                "The product has been added to your shopping cart");

        notebooksPage.closeConfirmMessage();

        notebooksPage.addToShoppingCartProductWithNumber(5);
        Assert.assertEquals(notebooksPage.getConfirmMessageForAddingProductToShoppingCart(),
                "The product has been added to your shopping cart");

        notebooksPage.closeConfirmMessage();

        notebooksPage.addToShoppingCartProductWithNumber(6);
        Assert.assertEquals(notebooksPage.getConfirmMessageForAddingProductToShoppingCart(),
                "The product has been added to your shopping cart");

        notebooksPage.closeConfirmMessage();

        Assert.assertEquals(notebooksPage.getWishListQuantity(), "(2)");
        Assert.assertEquals(notebooksPage.getShoppingCartQuantity(), "(3)");
    }
}
