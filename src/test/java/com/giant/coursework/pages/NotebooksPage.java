package com.giant.coursework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotebooksPage extends BasePage {

    @FindBy(css = ".page-title>h1")
    private WebElement pageTitleWebElement;

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


    public String getPageTitle() {
        return pageTitleWebElement.getText();
    }

    public void addToWishListProductWithNumber(int productNumber) {

        switch (productNumber) {

            case 2:
                addToWishListForSecondProductWebElement.click();
                break;

            case 3:
                addToWishListForThirdProductWebElement.click();
                break;
        }
    }

    public void addToShoppingCartProductWithNumber(int productNumber) {

        switch (productNumber) {

            case 4:
                addToShoppingCartForFourthProductWebElement.click();
                break;

            case 5:
                addToShoppingCartForFifthProductWebElement.click();
                break;

            case 6:
                addToShoppingCartForSixthProductWebElement.click();
                break;
        }
    }
}
