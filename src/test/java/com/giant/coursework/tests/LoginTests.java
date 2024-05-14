package com.giant.coursework.tests;

import com.giant.coursework.pages.DashboardPage;
import com.giant.coursework.pages.LoginPage;
import com.giant.coursework.pages.WelcomePage;
import com.giant.coursework.utils.Driver;
import com.giant.coursework.utils.GlobalConfigs;

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
        Driver.getDriver().close();
    }

    @Test
    public void successfulLoginTest() {

        welcomePage.navigateToLoginPage();

        loginPage.login(GlobalConfigs.EMAIL, "$€1€n1uM");

        Assert.assertTrue(dashboardPage.getWelcomeText().equals("Welcome to our store")
                && dashboardPage.logoutMenuIsDisplayed());
    }
}
