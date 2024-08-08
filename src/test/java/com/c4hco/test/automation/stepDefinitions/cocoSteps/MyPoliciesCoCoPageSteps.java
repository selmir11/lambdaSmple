package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MyPoliciesCoCoPage;
import com.c4hco.test.automation.pages.exchPages.MyPoliciesPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class MyPoliciesCoCoPageSteps {

    MyPoliciesCoCoPage myPoliciesCoCoPage = new MyPoliciesCoCoPage(WebDriverManager.getDriver());

    @And("Validate selected medical plan for {string} is {string}")
    public void validateMedPlanDetails(String memberName, String planName){
        myPoliciesCoCoPage.VerifyPlanDetails(memberName,planName);
    }

}
