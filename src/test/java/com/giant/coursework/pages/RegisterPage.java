package com.giant.coursework.pages;

import com.giant.coursework.models.Birthday;
import com.giant.coursework.utils.Driver;
import com.giant.coursework.utils.Wait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterPage extends BasePage {

    @FindBy(name = "Gender")
    private List<WebElement> genderWebElements;

//    @FindBy(id = "gender-male")
//    private WebElement maleRadioWebElement;
//
//    @FindBy(id = "gender-female")
//    private WebElement femaleRadioWebElement;

    @FindBy(id = "FirstName")
    private WebElement firstNameWebElement;

    @FindBy(id = "LastName")
    private WebElement lastNameWebElement;

    @FindBy(name = "DateOfBirthDay")
    private WebElement dateOfBirthDaySelectWebElement;

    @FindBy(name = "DateOfBirthMonth")
    private WebElement dateOfBirthMonthSelectWebElement;

    @FindBy(name = "DateOfBirthYear")
    private WebElement dateOfBirthYearSelectWebElement;

    @FindBy(id = "Email")
    private WebElement emailWebElement;

    @FindBy(id = "Company")
    private WebElement companyNameWebElement;

    @FindBy(id = "Newsletter")
    private WebElement newsletterWebElement;

    @FindBy(id = "Password")
    private WebElement passwordWebElement;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordWebElement;

    @FindBy(id = "register-button")
    private WebElement registerButtonWebElement;

    @FindBy(className = "result")
    private WebElement resultWebElement;

    // *************************************************************************************************

    public void register(char gender,
                         String firstName,
                         String lastName,
                         Birthday birthday,
                         String email,
                         String companyName,
                         boolean newsletter,
                         String password,
                         String confirmPassword) {

        selectGender(gender);
        firstNameWebElement.sendKeys(firstName);
        lastNameWebElement.sendKeys(lastName);
        birthdaySelects(dateOfBirthDaySelectWebElement, birthday.getBirthDay());
        birthdaySelects(dateOfBirthMonthSelectWebElement, birthday.getBirthMonth());
        birthdaySelects(dateOfBirthYearSelectWebElement, birthday.getBirthYear());
        emailWebElement.sendKeys(email);

        companyNameWebElement.sendKeys(companyName);

        if(newsletter) {
            newsletterWebElement.click();
        }

        passwordWebElement.sendKeys(password);
        confirmPasswordWebElement.sendKeys(confirmPassword);

        registerButtonWebElement.click();
    }

    private void selectGender(char gender) {

        if (gender == 'F') {
            genderWebElements.get(1).click();
        } else {
            genderWebElements.get(0).click();
        }
    }

    private void birthdaySelects(WebElement selectWebElement, String value) {

        Select select = new Select(selectWebElement);
        select.selectByValue(value);
    }

    public String getPageTitle() {

        Wait.getWait().until(ExpectedConditions.titleIs("nopCommerce demo store. Register"));
        return Driver.getDriver().getTitle();
    }

    public String getResultMessage() {

        Wait.getWait().until(ExpectedConditions.visibilityOf(resultWebElement));
        return resultWebElement.getText();
    }
}
