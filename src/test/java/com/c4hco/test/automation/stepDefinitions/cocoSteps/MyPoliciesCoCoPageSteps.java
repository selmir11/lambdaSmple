package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MyPoliciesCoCoPage;
import com.c4hco.test.automation.pages.exchPages.MyPoliciesPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

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
}
