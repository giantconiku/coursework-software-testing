package com.giant.coursework.tests;

import com.giant.coursework.pages.*;
import com.giant.coursework.utils.Driver;
import com.giant.coursework.utils.GlobalConfigs;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ShoppingCartTests {

    private final WelcomePage welcomePage;
    private final LoginPage loginPage;
    private final NotebooksPage notebooksPage;
    private final ShoppingCartPage shoppingCartPage;
    private final CheckoutPage checkoutPage;

    public ShoppingCartTests() {

        welcomePage = new WelcomePage();
        loginPage = new LoginPage();
        notebooksPage = new NotebooksPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();
    }

    @AfterMethod
    public void afterEach() {
        Driver.getDriver().close();
    }

    @Test
    public void successfulOrderTest() {

        welcomePage.navigateToLoginPage();
        loginPage.login(GlobalConfigs.EMAIL, "$€1€n1uM");

        // ------------------------------------------------------------------------------------

        notebooksPage.hoverOverShoppingCartMenu();
        Assert.assertEquals(notebooksPage.getClassValueOfShoppingCartModal(), "flyout-cart active");

        notebooksPage.navigateToShoppingCartPage();
        Assert.assertEquals(shoppingCartPage.getPageTitle(), "Shopping cart");

        Assert.assertTrue(shoppingCartPage.continueShoppingButtonIsDisplayed() &&
                                   shoppingCartPage.estimateShippingButtonIsDisplayed());

        double shoppingCardPageTotal = shoppingCartPage.getTotal();

        Assert.assertEquals(shoppingCartPage.calculateSubTotalFromTable(), shoppingCardPageTotal);

        shoppingCartPage.agreeWithTermsOfService();
        shoppingCartPage.navigateToCheckoutPage();

        Assert.assertEquals(checkoutPage.getBillingAddressFirstName(), "Giga");
        Assert.assertEquals(checkoutPage.getBillingAddressLastName(), "Giant");
        Assert.assertEquals(checkoutPage.getBillingAddressEmail(), GlobalConfigs.EMAIL);

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
