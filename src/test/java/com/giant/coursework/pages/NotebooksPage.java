package com.giant.coursework.pages;

import com.giant.coursework.utils.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotebooksPage extends BasePage {

    @FindBy(css = ".page-title>h1")
    private WebElement pageTitleWebElement;

    // *************************************************************************************************

    public String getPageTitle() {
        return Wait.getWait().until(ExpectedConditions.visibilityOf(pageTitleWebElement)).getText();
    }
}
