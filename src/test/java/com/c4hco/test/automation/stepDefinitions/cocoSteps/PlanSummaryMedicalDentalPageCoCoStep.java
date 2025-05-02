package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.PlanSummaryMedicalDentalCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class PlanSummaryMedicalDentalPageCoCoStep {

    PlanSummaryMedicalDentalCoCoPage planSummaryMedicalDentalCoCoPage = new PlanSummaryMedicalDentalCoCoPage( WebDriverManager.getDriver() );

    @And("I click continue on coco plan summary page")
    public void continueButton() {
        planSummaryMedicalDentalCoCoPage.continueButton();
    }

    @Then("I click Go Back on coco plan summary page")
    public void clickGoBackStartShoppingPage() {
        planSummaryMedicalDentalCoCoPage.iclickGoBack();
    }

    @And("I validate the {string} text on the Plan Summary COCO page")
    public void validateTextPlanSummaryCOCOPage(String language) {
        planSummaryMedicalDentalCoCoPage.validateTextPlanSummaryCOCOPage( language );
    }

    @And("I set medical premium amount")
    public void setMedicalPremiumAmount() {
        planSummaryMedicalDentalCoCoPage.setPlansPremiumAmtCoco();
    }

    @And("I click the Save and Exit button on the Plan Summary page")
    public void clickSaveAndExitButtonPlanSummary() {
        planSummaryMedicalDentalCoCoPage.clickSaveAndExitButtonPlanSummary();
    }
}


        