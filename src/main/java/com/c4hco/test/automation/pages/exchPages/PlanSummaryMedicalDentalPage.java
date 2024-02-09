package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanSummaryMedicalDentalPage {
    private BasicActions basicActions;

    public PlanSummaryMedicalDentalPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }
    @FindBy(id = "SHP-PlanSummary-Continue")
    WebElement continueBtnOnPlanSummary;

    public void continuePlanSummaryPage(){
        basicActions.waitForElementToBeClickable(continueBtnOnPlanSummary,10);
        continueBtnOnPlanSummary.click();
    }
}
