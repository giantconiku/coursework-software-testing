package com.giant.coursework.pages;

import com.giant.coursework.utils.Wait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    @FindBy(className = "ico-logout")
    private WebElement logoutMenuWebElement;

    @FindBy(css = ".topic-block-title>h2")
    private WebElement welcomeHeaderWebElement;

    // *************************************************************************************************

    public void logout() {
        logoutMenuWebElement.click();
    }

    public String getWelcomeText() {

        Wait.getWait().until(ExpectedConditions.visibilityOf(welcomeHeaderWebElement));
        return welcomeHeaderWebElement.getText();
    }

    public boolean logoutMenuIsDisplayed() {
        return logoutMenuWebElement.isDisplayed();
    }
}
