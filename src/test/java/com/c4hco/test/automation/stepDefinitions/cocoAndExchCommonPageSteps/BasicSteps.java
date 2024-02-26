package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class BasicSteps {
    BasicActions basicActions = new BasicActions(WebDriverManager.getDriver());

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
            case "CoCo Welcome":
                pageUrl = "/coco/WelcomePortal";
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
            case "planSummaryMedicalDental":
                pageUrl ="planSummaryMedicalDental";
                break;
            case "Create Account":
                pageUrl = "createAccount";
                break;
            case "Admin dashboard":
                pageUrl = "AdminPortal";
                break;
            case "Application Results":
                pageUrl = "ApplicationResultsPortal/applicationResults";
                break;
            case "My Profile":
                pageUrl = "UserProfileAdmin/profile";
                break;
            case "My Documents":
                pageUrl = "MyDocuments/home";
                break;
            case "Let us guide you":
                pageUrl = "nes/completedPeakApplication";
                break;
            case "Enter Case ID":
                pageUrl = "nes/enterCaseId";
                break;
            case "Medical Plan Results":
                pageUrl = "medicalPlanResults";
                break;
            case "Spanish":
                pageUrl = "lang=es";
                break;
            case "CoCo Additional information for yourself":
                pageUrl = "coco/member-details-portal/member-additional-information";
                break;
            case "CoCo Family Overview":
                pageUrl = "coco/WelcomePortal/familyOverview";
            case "Before you begin":
                pageUrl = "nes/beforeYouBegin";
                break;
            case "FindExpertHelpCoco":
                pageUrl = "broker-portal/individual/find-expert-help?cocoUser=true";
                break;
            default:
                System.out.println("undefined page ");
        }
        Assert.assertTrue("expected page::"+ pageUrl+"::did not load", basicActions.getUrlWithWait(pageUrl, 30).contains(pageUrl));
    }
    @And("I validate I am on the {string} page and close tab")
    public void iValidatePageAndClose(String page){
        String pageUrl= " ";
        switch(page){
            case "Privacy Policy":
                pageUrl = "/InformationPortal/privacyPolicy";
                break;
            case "Terms Of Use":
                pageUrl = "/InformationPortal/termsOfUse";
                break;
            case "Contact Us":
                pageUrl = "/InformationPortal/contactUs";
                break;
        }
        String origin = basicActions.getDriver().getWindowHandle();
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
            if (basicActions.getDriver().getTitle().equals(page)) {
                Assert.assertTrue("expected page::"+ pageUrl+"::did not load", basicActions.getUrlWithWait(pageUrl, 30).contains(pageUrl));
            }
        }
        basicActions.closeBrowserTab();
        basicActions.getDriver().switchTo().window(origin);
    }

    @And("I refresh the page")
    public void refreshPage(){
        basicActions.refreshPage();
    }
}
