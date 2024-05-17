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

    @FindBy(css = "div#bar-notification > div > p")
    private WebElement confirmMessageWebElement;

    @FindBy(css = "div#bar-notification > div > p > a")
    private WebElement linkInsideConfirmMessageWebElement;

    @FindBy(className = "close")
    private WebElement closeConfirmMessageWebElement;

    @FindBy(className = "wishlist-qty")
    private WebElement wishListQuantityWebElement;

    @FindBy(className = "cart-qty")
    private WebElement shoppingCartQuantityWebElement;

    @FindBy(className = "ico-cart")
    private WebElement shoppingCartMenuWebElement;

    @FindBy(id = "flyout-cart")
    private WebElement shoppingCartModalWebElement;

    @FindBy(className = "cart-button")
    private WebElement goToCartButtonWebElement;

    @FindBy(css = "body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(1) > a")
    private WebElement computerMenuWebElement;

    @FindBy(linkText = "/electronics")
    private WebElement electronicsMenuWebElement;

    @FindBy(linkText = "/desktops")
    private WebElement desktopsMenuCategoryWebElement;

    @FindBy(css = "body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(1) > ul > li:nth-child(2) > a")
    private WebElement notebooksMenuCategoryWebElement;

    @FindBy(css = "#main > div > div.center-2 > div > div.page-body > div.products-container > " +
            "div.products-wrapper > div > div > div:nth-child(2) > div > div.details > div.add-info > " +
            "div.buttons > button.button-2.add-to-wishlist-button")
    private WebElement addToWishListForSecondProductWebElement;

    @FindBy(css = "#main > div > div.center-2 > div > div.page-body > div.products-container > " +
            "div.products-wrapper > div > div > div:nth-child(3) > div > div.details > div.add-info > " +
            "div.buttons > button.button-2.add-to-wishlist-button")
    private WebElement addToWishListForThirdProductWebElement;

    @FindBy(css = "#main > div > div.center-2 > div > div.page-body > div.products-container > " +
            "div.products-wrapper > div > div > div:nth-child(4) > div > div.details > div.add-info > " +
            "div.buttons > button.button-2.product-box-add-to-cart-button")
    private WebElement addToShoppingCartForFourthProductWebElement;

    @FindBy(css = "#main > div > div.center-2 > div > div.page-body > div.products-container > " +
            "div.products-wrapper > div > div > div:nth-child(5) > div > div.details > div.add-info > " +
            "div.buttons > button.button-2.product-box-add-to-cart-button")
    private WebElement addToShoppingCartForFifthProductWebElement;

    @FindBy(css = "#main > div > div.center-2 > div > div.page-body > div.products-container > " +
            "div.products-wrapper > div > div > div:nth-child(6) > div > div.details > div.add-info > " +
            "div.buttons > button.button-2.product-box-add-to-cart-button")
    private WebElement addToShoppingCartForSixthProductWebElement;

    // *************************************************************************************************

    public String getConfirmMessageForAddingProductToWishList() {

        Wait.getWait().until(ExpectedConditions.visibilityOf(confirmMessageWebElement));
        Wait.getWait().until(ExpectedConditions
                .attributeContains(linkInsideConfirmMessageWebElement, "href", "/wishlist"));
        return confirmMessageWebElement.getText();
    }

    public String getConfirmMessageForAddingProductToShoppingCart() {

        Wait.getWait().until(ExpectedConditions.visibilityOf(confirmMessageWebElement));
        Wait.getWait().until(ExpectedConditions
                    .attributeContains(linkInsideConfirmMessageWebElement, "href", "/cart"));
        return confirmMessageWebElement.getText();
    }

    public void closeConfirmMessage() {
        Wait.getWait().until(ExpectedConditions.elementToBeClickable(closeConfirmMessageWebElement)).click();
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

    public String getClassValueOfShoppingCartModal() {

        Wait.getWait().until(ExpectedConditions.attributeContains(shoppingCartModalWebElement, "class", "active"));
        return shoppingCartModalWebElement.getAttribute("class");
    }

    public void navigateToShoppingCartPage() {
        Wait.getWait().until(ExpectedConditions.elementToBeClickable(goToCartButtonWebElement)).click();
    }

    // ---------------------------------------------------------------------------------

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

    public void addToWishListProductWithNumber(int productNumber) throws InterruptedException {

        switch (productNumber) {

            case 2:
                Wait.getWait().until(ExpectedConditions
                        .elementToBeClickable(addToWishListForSecondProductWebElement)).click();
                Thread.sleep(1000);
                break;

            case 3:
                Wait.getWait().until(ExpectedConditions
                        .elementToBeClickable(addToWishListForThirdProductWebElement)).click();
                Thread.sleep(1000);
                break;
        }
    }

    public void addToShoppingCartProductWithNumber(int productNumber) throws InterruptedException {

        switch (productNumber) {

            case 4:
                Wait.getWait().until(ExpectedConditions
                        .elementToBeClickable(addToShoppingCartForFourthProductWebElement)).click();
                Thread.sleep(1000);
                break;

            case 5:
                Wait.getWait().until(ExpectedConditions
                        .elementToBeClickable(addToShoppingCartForFifthProductWebElement)).click();
                Thread.sleep(1000);
                break;

            case 6:
                Wait.getWait().until(ExpectedConditions
                        .elementToBeClickable(addToShoppingCartForSixthProductWebElement)).click();
                Thread.sleep(1000);
                break;
        }
    }
}
