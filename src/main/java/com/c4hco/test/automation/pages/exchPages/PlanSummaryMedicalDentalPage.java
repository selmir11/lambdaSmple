package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Dto.PolicyMember;
import com.c4hco.test.automation.utils.Dto.SharedData;
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

    // locator in stg is diff - @FindBy(id = "SHP-PlanSummary-Continue")
    @FindBy(id = "PlanSummary-Continue")
    WebElement continueBtnOnPlanSummary;

    @FindBy(id="PlanSummary-MedicalPremiumAmount_0")
    WebElement medicalPlanPremiumAmt;

    @FindBy(id="PlanSummary-DentalPremiumAmount_0")
    WebElement dentalPlanPremiumAmt;

    public void continuePlanSummaryPage(){
        basicActions.waitForElementToBePresent(medicalPlanPremiumAmt, 10);
        setPlansPremiumAmt();
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary, 15);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", continueBtnOnPlanSummary);
    }

    public void setPlansPremiumAmt(){
        PolicyMember subscriber = SharedData.getSubscriber();
        subscriber.setMedicalPremiumAmt(medicalPlanPremiumAmt.getText());
        subscriber.setDentalPremiumAmt(dentalPlanPremiumAmt.getText());
        SharedData.setSubscriber(subscriber);
    }
}
