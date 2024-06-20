package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class PlanSummaryMedicalDentalCoCoPage {

    private BasicActions basicActions;

    public PlanSummaryMedicalDentalCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "PlanSummary-Continue")
    WebElement continueBtnOnPlanSummary;

    @FindBy(id="PlanSummary-MedicalPremiumAmount_0")
    WebElement medicalPremiumAfterAPTCAmt;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void continueButton(){
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(medicalPremiumAfterAPTCAmt, 10);
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary, 15);
        basicActions.scrollToElement(continueBtnOnPlanSummary);
        basicActions.click(continueBtnOnPlanSummary);
    }
}
