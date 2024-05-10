package com.giant.coursework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "Email")
    private WebElement emailWebElement;

    @FindBy(id = "Password")
    private WebElement passwordWebElement;

    @FindBy(id = "RememberMe")
    private WebElement rememberMeWebElement;

    @FindBy(linkText = "/passwordrecovery")
    private WebElement forgotPasswordWebElement;

    @FindBy(className = "login-button")
    private WebElement loginButtonWebElement;

    @FindBy(className = "register-button")
    private WebElement registerButtonWebElement;


    public void login(String email, String password) {

        emailWebElement.clear();
        emailWebElement.sendKeys(email);

        passwordWebElement.clear();
        passwordWebElement.sendKeys(password);

        loginButtonWebElement.click();
    }

    public void navigateToRegisterPage() {
        registerButtonWebElement.click();
    }
}
