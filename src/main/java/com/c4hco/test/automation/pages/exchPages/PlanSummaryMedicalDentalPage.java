package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanSummaryMedicalDentalPage {
    private BasicActions basicActions;

    public PlanSummaryMedicalDentalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SHP-PlanSummary-Continue")
    WebElement continueBtnOnPlanSummary;

    public void continuePlanSummaryPage(){
        // Intermittent Failure noticed
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary, 10);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", continueBtnOnPlanSummary);
    }
}
