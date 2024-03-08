package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfileExchPage {


    @FindBy(xpath = "//button[contains(@class,'btn-second-action-button btn-back-to-welcome')]")
    public WebElement backToWelcomeButtonExch;

    private BasicActions basicActions;
    public MyProfileExchPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void backToWelcomeButtonExch() {
        basicActions.waitForElementToBeClickable(backToWelcomeButtonExch, 5);
        backToWelcomeButtonExch.click();
    }
}
