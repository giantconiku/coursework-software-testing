package com.giant.coursework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(css = ".page-title>h1")
    private WebElement pageTitleWebElement;

    @FindBy(name = "continueshopping")
    private WebElement continueShoppingButtonWebElement;

    @FindBy(id = "open-estimate-shipping-popup")
    private WebElement estimateShippingButtonWebElement;

    @FindBy(css = "#shopping-cart-form > div.table-wrapper > table > tbody > tr:nth-child(1) > td.subtotal > span")
    private WebElement firstSubTotalWebElement;

    @FindBy(css = "#shopping-cart-form > div.table-wrapper > table > tbody > tr:nth-child(2) > td.subtotal > span")
    private WebElement secondSubTotalWebElement;

    @FindBy(css = "#shopping-cart-form > div.table-wrapper > table > tbody > tr:nth-child(3) > td.subtotal > span")
    private WebElement thirdSubTotalWebElement;

    @FindBy(css = ".value-summary > strong")
    private WebElement totalWebElement;

    @FindBy(id = "termsofservice")
    private WebElement termsOfServiceCheckBoxWebElement;

    @FindBy(id = "checkout")
    private WebElement checkoutButtonWebElement;

    public String getPageTitle() {
        return pageTitleWebElement.getText();
    }

    public boolean continueShoppingButtonIsDisplayed() {
        return continueShoppingButtonWebElement.isDisplayed();
    }

    public boolean estimateShippingButtonIsDisplayed() {
        return estimateShippingButtonWebElement.isDisplayed();
    }

    public int calculateSubTotalFromTable() {
        return Integer.parseInt(firstSubTotalWebElement.getText()) +
                Integer.parseInt(secondSubTotalWebElement.getText()) +
                Integer.parseInt(thirdSubTotalWebElement.getText());
    }

    public int getTotal() {
        return Integer.parseInt(totalWebElement.getText());
    }

    public void agreeWithTermsOfService() {
        termsOfServiceCheckBoxWebElement.click();
    }

    public void navigateToCheckoutPage() {
        checkoutButtonWebElement.click();
    }
}
