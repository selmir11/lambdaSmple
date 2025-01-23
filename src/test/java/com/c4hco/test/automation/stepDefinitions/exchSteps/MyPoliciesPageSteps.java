package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MyPoliciesPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MyPoliciesPageSteps {
    MyPoliciesPage myPoliciesPage = new MyPoliciesPage(WebDriverManager.getDriver());

    @And("I validate {string} details on my policies page")
    public void validateMedPlanDetails(String planType){
        myPoliciesPage.validatePlanDetails(planType);
    }

    @And("I click View Plan History link from {string} plan card")
    public void clickViewPlanHistory(String planType){
        myPoliciesPage.clickViewPlanHistory(planType);
    }

    @And("I validate {string} plan details from plan history")
    public void medPlanDetailsPlanHistory(String planType){
            myPoliciesPage.validatePlanDetailsPlanHistory(planType);
    }

    @And("I click on to Back to Current Plan Details button")
    public void clickBackToCurrentPlans(){
        myPoliciesPage.clickBackButton();
    }

    @And("I click on {string} button")
    public void clickMedicalPlansCancelButton(String btnDetail){
        myPoliciesPage.clickPlanCancelButton(btnDetail);
    }

    @Then("I click on Future Plans")
    public void clickFuturePlans(){
        myPoliciesPage.clickFuturePlans();
    }

    @Then("I click on Current Plans")
    public void clickCurrentPlans(){
        myPoliciesPage.clickCurrentPlans();
    }

}
