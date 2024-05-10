package com.giant.coursework.tests;

import com.giant.coursework.pages.DashboardPage;
import com.giant.coursework.pages.LoginPage;
import com.giant.coursework.pages.WelcomePage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class LoginTests {

    private final WelcomePage welcomePage;
    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;

    public LoginTests() {

        welcomePage = new WelcomePage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }

    @AfterMethod
    public void afterEach() {
        dashboardPage.logout();
    }

    @Test
    public void successfulLoginTest() {

        welcomePage.navigateToLoginPage();
        loginPage.login("gen@em.com", "$€1€n1uM");

        Assert.assertTrue(dashboardPage.getWelcomeText().equals("Welcome to our store")
                && dashboardPage.logoutMenuWebElement.isDisplayed());
    }
}
