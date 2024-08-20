package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorExchPage {
    private BasicActions basicActions;
    public ErrorExchPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".btn-primary-action-button")
    public WebElement backToWelcomeButton;

    public void backToWelcomeButton() {
        basicActions.waitForElementToBeClickable(backToWelcomeButton, 5);
        backToWelcomeButton.click();
    }
}
