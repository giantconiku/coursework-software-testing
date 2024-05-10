package com.giant.coursework.tests;

import com.giant.coursework.enums.DashboardMenu;
import com.giant.coursework.enums.DashboardMenuCategory;
import com.giant.coursework.pages.DashboardPage;
import com.giant.coursework.pages.LoginPage;
import com.giant.coursework.pages.NotebooksPage;
import com.giant.coursework.pages.WelcomePage;
import com.giant.coursework.utils.Driver;
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
    public void successfulNotebooksAdditionToWishListAndShoppingCartTest() {

        welcomePage.navigateToLoginPage();
        loginPage.login("gen@em.com", "$€1€n1uM");

        dashboardPage.hoverOverMenu(DashboardMenu.COMPUTERS, DashboardMenuCategory.NOTEBOOKS);
        Assert.assertEquals(notebooksPage.getPageTitle(), "NoteBooks");

        notebooksPage.addToWishListProductWithNumber(2);
        Assert.assertEquals(notebooksPage.getConfirmMessage(), "The product has been added to your wishlist");

        notebooksPage.addToWishListProductWithNumber(3);
        Assert.assertEquals(notebooksPage.getConfirmMessage(), "The product has been added to your wishlist");

        notebooksPage.addToShoppingCartProductWithNumber(4);
        Assert.assertEquals(notebooksPage.getConfirmMessage(), "The product has been added to your shopping cart");

        notebooksPage.addToShoppingCartProductWithNumber(5);
        Assert.assertEquals(notebooksPage.getConfirmMessage(), "The product has been added to your shopping cart");

        notebooksPage.addToShoppingCartProductWithNumber(6);
        Assert.assertEquals(notebooksPage.getConfirmMessage(), "The product has been added to your shopping cart");

        Assert.assertEquals(notebooksPage.getWishListQuantity(), "2");
        Assert.assertEquals(notebooksPage.getShoppingCartQuantity(), "3");
    }
}
