package com.giant.coursework.pages;

import com.giant.coursework.utils.Driver;
import com.giant.coursework.utils.GlobalConfigs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

    @FindBy(className = "ico-login")
    private WebElement loginMenuWebElement;

    public void navigateToLoginPage() {

        navigateToWelcomePage();
        loginMenuWebElement.click();
    }

    private void navigateToWelcomePage() {
        Driver.getDriver().get(GlobalConfigs.URL);
    }
}
