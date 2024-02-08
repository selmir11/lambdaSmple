package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class BasicSteps {
    BasicActions basicActions = new BasicActions();

    @And("I validate I am on the {string} page")
    public void iValidatePage(String page){
        String pageUrl= " ";
        switch(page){
            case "Login":
                pageUrl = "/login-portal/login";
                break;
            case "Prescreen":
                pageUrl = "/prescreen";
                break;
            case "Account Overview":
                 pageUrl = "nes/accountOverview";
                break;
            case "Find Expert Help":
                pageUrl = "find-expert-help";
                break;
            case "Start Shopping":
                pageUrl = "PreShoppingPortal/startShopping";
                break;
            case "Deductions":
                pageUrl = "/IncomePortal/deductions";
                break;
            case "Financial Help":
                pageUrl = "IncomePortal/financialHelp";
                break;
            case "Income Summary":
                pageUrl = "IncomePortal/summaryDetails";
                break;
            case "Create Account":
                pageUrl = "createAccount";
                break;
        }
        Assert.assertTrue("expected page::"+ pageUrl+"::did not load", basicActions.getUrlWithWait(pageUrl, 30).contains(pageUrl));
    }
}
