package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MyPoliciesPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class MyPoliciesPageSteps {
    MyPoliciesPage myPoliciesPage = new MyPoliciesPage(WebDriverManager.getDriver());

    @And("I validate med details on my policies page with policy and financial start date {string} and end date {string}")
    public void validateMedPlanDetails(){
        myPoliciesPage.validateEnrolledMedicalPlanDetails();
    }

    @And("I validate den details on my policies page with policy and financial start date {string} and end date {string}")
    public void validateDentalPlanDetails() {
        myPoliciesPage.validateDentalPlanDetails();
    }

    @And("I click View Plan History link from medical plan card")
    public void clickViewPlanHistory(){
        // To DO: Update this step -
        // get total links for all memebers - only 2 cards always? 1med and 1 -dental?
        // click on all the links and validate you go to a diff page, validate details and come back.
        myPoliciesPage.clickViewPlanHistoryFromMed();
    }

    @And("I click View Plan History link from dental plan card")
    public void clickViewPlanHistoryDental(){
        // To DO: Update this step -
        // click on all the links and validate you go to a diff page, validate details and come back.
        myPoliciesPage.clickViewPlanHistoryFromDental();
    }

    @And("I validate medical plan details from plan history")
    public void medPlanDetailsPlanHistory(){
            myPoliciesPage.validateMedPlanDetailsFromPlanHistory();
    }

    @And("I click on to Back to Current Plan Details button")
    public void clickBackToCurrentPlans(){
        myPoliciesPage.clickBackButton();
    }

    @And("I validate dental plan details from plan history")
    public void dentalPlanDetailsPlanHistory(){
        myPoliciesPage.validateDentalPlanDetailsFromPlanHistory();
    }

    @And("I click on {string} button")
    public void clickMedicalPlansCancelButton(String btnDetail){
        myPoliciesPage.clickPlanCancelButton(btnDetail);
    }

    @And ("Validate medical plan details from my policies page")
    public void medicalPlanValidationsOnMypoliciesPage(String startDate){
        myPoliciesPage.medicalValidations();
    }
    @And ("Validate dental plan details from my policies page")
    public void dentalPlanValidationsOnMypoliciesPage(){
        myPoliciesPage.dentalValidations();
    }
}
