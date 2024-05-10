package com.giant.coursework.pages;

import com.giant.coursework.enums.DashboardMenu;
import com.giant.coursework.enums.DashboardMenuCategory;
import com.giant.coursework.utils.Action;
import com.giant.coursework.utils.Driver;
import com.giant.coursework.utils.Wait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage {

    protected BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "ico-logout")
    public WebElement logoutMenuWebElement;

    @FindBy(className = "content")
    private WebElement confirmMessageWebElement;

    @FindBy(className = "wishlist-qty")
    private WebElement wishListQuantityWebElement;

    @FindBy(className = "cart-qty")
    private WebElement shoppingCartQuantityWebElement;

    @FindBy(className = "ico-cart")
    private WebElement shoppingCartMenuWebElement;

    @FindBy(className = "cart-button")
    private WebElement goToCartButtonWebElement;

    // ----------------------------------------------

    @FindBy(linkText = "/computers")
    private WebElement computerMenuWebElement;

    @FindBy(linkText = "/electronics")
    private WebElement electronicsMenuWebElement;

    @FindBy(linkText = "/desktops")
    private WebElement desktopsMenuCategoryWebElement;

    @FindBy(linkText = "/notebooks")
    private WebElement notebooksMenuCategoryWebElement;

    // ******************************************************

    public void logout() {
        logoutMenuWebElement.click();
    }

    public String getConfirmMessage() {

        Wait.getWait().until(ExpectedConditions.visibilityOf(confirmMessageWebElement));
        return confirmMessageWebElement.getText();
    }

    public String getWishListQuantity() {
        return wishListQuantityWebElement.getText();
    }

    public String getShoppingCartQuantity() {
        return shoppingCartQuantityWebElement.getText();
    }

    public void hoverOverShoppingCartMenu() {
        hover(shoppingCartMenuWebElement);
    }

    public boolean goToCartButtonIsDisplayed() {
        return goToCartButtonWebElement.isDisplayed();
    }

    public void navigateToShoppingCartPage() {
        goToCartButtonWebElement.click();
    }

    // ----------------------------------------------

    public void hoverOverMenu(DashboardMenu menuName, DashboardMenuCategory categoryName) {

        switch (menuName) {

            case COMPUTERS:
                hover(computerMenuWebElement);
                break;

            case ELECTRONICS:
                hover(electronicsMenuWebElement);
                break;
        }

        navigateToCategoryPage(categoryName);
    }

    private void navigateToCategoryPage(DashboardMenuCategory categoryName) {

        switch (categoryName) {

            case DESKTOPS:
                desktopsMenuCategoryWebElement.click();
                break;

            case NOTEBOOKS:
                notebooksMenuCategoryWebElement.click();
                break;
        }
    }

    private void hover(WebElement webElement) {

        Action.getAction().moveToElement(webElement).build().perform();
    }
}
