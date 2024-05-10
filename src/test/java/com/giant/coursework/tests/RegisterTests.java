package com.giant.coursework.tests;

import com.giant.coursework.models.Birthday;
import com.giant.coursework.pages.LoginPage;
import com.giant.coursework.pages.RegisterPage;
import com.giant.coursework.pages.WelcomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTests {

    private final WelcomePage welcomePage;
    private final LoginPage loginPage;
    private final RegisterPage registerPage;

    public RegisterTests() {

        welcomePage = new WelcomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test
    public void successfulRegistrationTest() {

        welcomePage.navigateToLoginPage();
        loginPage.navigateToRegisterPage();

        Assert.assertEquals("nopCommerce demo store. Register",
                                         registerPage.getPageTitle());

        registerPage.register('M',
                            "Giga",
                            "Giant",
                                     new Birthday("21",
                                                "11",
                                                 "2015"),
                               "gen@email.com",
                         "Lufthansa",
                            false,
                            "$€1€n1uM",
                       "$€1€n1uM");

        Assert.assertEquals("Your registration completed",
                                         registerPage.getResultMessage());
    }
}
