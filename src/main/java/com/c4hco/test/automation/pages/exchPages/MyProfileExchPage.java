package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyProfileExchPage {


    @FindBy(css = ".bottom_buttons_container button")
    List<WebElement> backToWelcomeButtonExch;

    private BasicActions basicActions;
    public MyProfileExchPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void backToWelcomeButtonExch() {
        basicActions.waitForElementToBeClickable(backToWelcomeButtonExch.get(0), 5);
        backToWelcomeButtonExch.get(0).click();
    }
}
