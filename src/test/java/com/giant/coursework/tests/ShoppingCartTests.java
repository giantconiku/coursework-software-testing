package com.giant.coursework.tests;

import com.giant.coursework.enums.DashboardMenu;
import com.giant.coursework.enums.DashboardMenuCategory;
import com.giant.coursework.pages.*;
import com.giant.coursework.utils.Driver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ShoppingCartTests {

    private final WelcomePage welcomePage;
    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;
    private final NotebooksPage notebooksPage;
    private final ShoppingCartPage shoppingCartPage;
    private final CheckoutPage checkoutPage;

    public ShoppingCartTests() {

        welcomePage = new WelcomePage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        notebooksPage = new NotebooksPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();
    }

    @AfterMethod
    public void afterEach() {
        Driver.getDriver().close();
    }

    @Test
    public void successfulOrderTest(){

        welcomePage.navigateToLoginPage();
        loginPage.login("giga@em.com", "giga1234");

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

        // ------------------------------------------------------------------------------------

        notebooksPage.hoverOverShoppingCartMenu();
        Assert.assertTrue(notebooksPage.goToCartButtonIsDisplayed());

        notebooksPage.navigateToShoppingCartPage();
        Assert.assertEquals(shoppingCartPage.getPageTitle(), "Shopping cart");

        Assert.assertTrue(shoppingCartPage.continueShoppingButtonIsDisplayed() &&
                                   shoppingCartPage.estimateShippingButtonIsDisplayed());

        Assert.assertEquals(shoppingCartPage.calculateSubTotalFromTable(), shoppingCartPage.getTotal());

        int shoppingCardPageTotal = shoppingCartPage.getTotal();

        shoppingCartPage.agreeWithTermsOfService();
        shoppingCartPage.navigateToCheckoutPage();

        Assert.assertEquals(checkoutPage.getBillingAddressFirstName(), "Giga");
        Assert.assertEquals(checkoutPage.getBillingAddressLastName(), "Giant");
        Assert.assertEquals(checkoutPage.getBillingAddressEmail(), "gigagiant@email.com");

        checkoutPage.fillBillingAddressForm("Albania",
                                               "Tirane",
                                         "Tirane",
                                            "1001",
                                        "0685224152");

        checkoutPage.continueToShippingMethodStep();
        checkoutPage.selectShippingMethod("NDA");

        checkoutPage.continueToPaymentMethodStep();
        checkoutPage.selectPaymentMethod("C/MO");

        checkoutPage.continueToPaymentInfoStep();
        checkoutPage.continueToConfirmOrderStep();

        Assert.assertEquals(checkoutPage.getTotal(), shoppingCardPageTotal);

        checkoutPage.confirmOrder();

        Assert.assertEquals(checkoutPage.getOrderConfirmMessage(), "Your order has been successfully processed!");
        Assert.assertNotEquals(checkoutPage.getOrderNumber(), "");
    }
}
