package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MyPoliciesCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MyPoliciesCoCoPageSteps {

    MyPoliciesCoCoPage myPoliciesCoCoPage = new MyPoliciesCoCoPage(WebDriverManager.getDriver());

    @And("I validate enrolled medical plans details on my policies page coco")
    public void validateMyPlans(){
        myPoliciesCoCoPage.validateEnrolledPlanDetails();
    }

    @And("I click view Plan History link from medical plan card in coco")
    public void clickViewPlanHistory(){
        myPoliciesCoCoPage.clickViewPlanHistoryLink();
    }

    @And("I validate medical plan details from plan history in coco")
    public void medicalPlanDetailsPlanHistory(){
        myPoliciesCoCoPage.validateMedPlanDetailsFromPlanHistoryCoco();
    }

    @Then("I click on Future Plans CoCo")
    public void clickFuturePlansCoCo(){
        myPoliciesCoCoPage.clickFuturePlansCoCo();
    }

    @Then("I click on Current Plans CoCo")
    public void clickCurrentPlansCoCo(){myPoliciesCoCoPage.clickCurrentPlansCoCo();
    }

    @Then("I click on Cancel Medical Plans CoCo")
    public void cancelMedicalPlanbtnCoCo() {
        myPoliciesCoCoPage.cancelMedicalPlanbtnCoCo();
    }


}
