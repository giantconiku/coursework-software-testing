package com.giant.coursework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckoutPage extends BasePage {

    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement billingAddressFirstNameWebElement;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement billingAddressLastNameWebElement;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement billingAddressEmailWebElement;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement billingAddressCountrySelectWebElement;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement billingAddressCityWebElement;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement billingAddressFirstAddressWebElement;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement billingAddressZipCodeWebElement;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement billingAddressPhoneNumberWebElement;

    @FindBy(css = "button[name='save']")
    private WebElement continueToShippingMethodWebElement;

    @FindBy(name = "shippingoption")
    private List<WebElement> shippingMethodWebElements;

    @FindBy(css = "button.shipping-method-next-step-button")
    private WebElement continueToPaymentMethodWebElement;

    @FindBy(name = "paymentmethod")
    private List<WebElement> paymentMethodWebElements;

    @FindBy(css = "button.payment-method-next-step-button")
    private WebElement continueToPaymentInfoWebElement;

    @FindBy(css = "button.payment-info-next-step-button")
    private WebElement continueToConfirmOrderWebElement;

    @FindBy(css = ".value-summary > strong")
    private WebElement totalWebElement;

    @FindBy(css = "button.confirm-order-next-step-button")
    private WebElement confirmOrderWebElement;

    @FindBy(tagName = "strong")
    private WebElement orderConfirmMessageWebElement;

    @FindBy(css = ".order-number > strong")
    private WebElement orderNumberWebElement;

    // *******************************************************************************

    public String getBillingAddressFirstName() {
        return billingAddressFirstNameWebElement.getText();
    }

    public String getBillingAddressLastName() {
        return billingAddressLastNameWebElement.getText();
    }

    public String getBillingAddressEmail() {
        return billingAddressEmailWebElement.getText();
    }

    public void fillBillingAddressForm(String country,
                                       String city,
                                       String firstAddress,
                                       String zipCode,
                                       String phoneNumber) {

        countrySelect(country);
        billingAddressCityWebElement.sendKeys(city);
        billingAddressFirstAddressWebElement.sendKeys(firstAddress);
        billingAddressZipCodeWebElement.sendKeys(zipCode);
        billingAddressPhoneNumberWebElement.sendKeys(phoneNumber);
    }

    private void countrySelect(String text) {

        Select select = new Select(billingAddressCountrySelectWebElement);
        select.selectByVisibleText(text);
    }

    public void continueToShippingMethodStep() {
        continueToShippingMethodWebElement.click();
    }

    public void selectShippingMethod(String shippingMethodAbbreviation) {

        if (shippingMethodAbbreviation.equals("G")) {
            shippingMethodWebElements.get(0).click();
        } else if (shippingMethodAbbreviation.equals("NDA")){
            shippingMethodWebElements.get(1).click();
        } else {
            shippingMethodWebElements.get(2).click();
        }
    }

    public void continueToPaymentMethodStep() {
        continueToPaymentMethodWebElement.click();
    }

    public void selectPaymentMethod(String paymentMethodAbbreviation) {

        if (paymentMethodAbbreviation.equals("C/MO")) {
            paymentMethodWebElements.get(0).click();
        } else {
            paymentMethodWebElements.get(1).click();
        }
    }

    public void continueToPaymentInfoStep() {
        continueToPaymentInfoWebElement.click();
    }

    public void continueToConfirmOrderStep() {
        continueToConfirmOrderWebElement.click();
    }

    public int getTotal() {
        return Integer.parseInt(totalWebElement.getText());
    }

    public void confirmOrder() {
        confirmOrderWebElement.click();
    }

    public String getOrderConfirmMessage() {
        return orderConfirmMessageWebElement.getText();
    }

    public String getOrderNumber() {

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(orderNumberWebElement.getText());

        if (matcher.find()) {
            return matcher.group();
        } else {
            return "";
        }
    }
}
