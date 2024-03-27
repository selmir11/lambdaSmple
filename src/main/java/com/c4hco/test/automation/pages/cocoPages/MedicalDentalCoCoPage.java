package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicalDentalCoCoPage {
    private BasicActions basicActions;

    public MedicalDentalCoCoPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

//    @FindBy(id = "SHP-PlanSummary-Continue")
    @FindBy(id = "PlanSummary-Continue")
    WebElement continueButton;

    public void clickContinueButton() {
        basicActions.waitForElementToBeClickable(continueButton, 100);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", continueButton);
    }
}
