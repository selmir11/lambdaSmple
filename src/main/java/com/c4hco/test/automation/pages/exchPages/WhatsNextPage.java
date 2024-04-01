package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatsNextPage {
    private BasicActions basicActions;

    public WhatsNextPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SOL-WhatsNext-Okay")
    WebElement welcomeBtn;

    public void clickWelcomeBtn(){
        // TO DO:: Sometimes, feedback survey is popping - intercepting the click - pls have a solution for this
        // TO DO:: sometimes, there is a loading spinner - make sure we wait until that disappears
        basicActions.waitForElementToBePresent(welcomeBtn, 10);
        basicActions.waitForElementToBeClickable(welcomeBtn, 20);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", welcomeBtn);
    }
}
