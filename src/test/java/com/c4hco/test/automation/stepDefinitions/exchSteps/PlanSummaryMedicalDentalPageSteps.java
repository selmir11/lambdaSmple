package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.PlanSummaryMedicalDentalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class PlanSummaryMedicalDentalPageSteps {
    PlanSummaryMedicalDentalPage planSummaryMedicalDentalPage = new PlanSummaryMedicalDentalPage(WebDriverManager.getDriver());

   @And("I click continue on plan summary page")
    public void continueButton(){
       planSummaryMedicalDentalPage.continueButton();
    }

    @And("I continue on plan summary page")
    public void continuePlanSummaryPage(){
        planSummaryMedicalDentalPage.continuePlanSummaryPage();
    }

    @And("I verify medical and dental text on Plan Summary page")
    public void verifyTextPlanSummaryPage() {
       planSummaryMedicalDentalPage.verifyTextPlanSummaryPage();
    }


    @And("I validate the APTC Credit on the Summary page is {string}")
    public void verifyAPTCPlanSummaryAmt (String aPTCPlanSummaryAmt ) {
        planSummaryMedicalDentalPage.verifyAPTCPlanSummaryAmt(aPTCPlanSummaryAmt); }


}
