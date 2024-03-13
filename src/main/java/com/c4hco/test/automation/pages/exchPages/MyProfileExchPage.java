package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyProfileExchPage {


    @FindBy(css = ".bottom_buttons_container button")
    List<WebElement> MyProfileButtonExch; /// Go back, Make changes, Save buttons

    private BasicActions basicActions;

    public MyProfileExchPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void backToWelcomeButtonExch() {
        basicActions.waitForElementToBeClickable(MyProfileButtonExch.get(0), 5);
        MyProfileButtonExch.get(0).click();
    }

    public void clickMakeChangesButton() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 15);
        MyProfileButtonExch.get(1).click();
    }

    public void clickSaveButton() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 15);
        MyProfileButtonExch.get(1).click();
    }
}