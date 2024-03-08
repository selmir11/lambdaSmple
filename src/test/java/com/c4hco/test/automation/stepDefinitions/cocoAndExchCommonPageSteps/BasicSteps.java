package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.Dimension;

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
            case "Add Member":
                pageUrl = "nes/addMember";
                break;
            case "Account Overview":
                pageUrl = "/nes/accountOverview";
                break;
            case "My Account Overview":
                pageUrl = "nes/myAccountOverview";
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
            case "Additional income":
                pageUrl = "IncomePortal/additionalIncome";
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
            case "Grouping Members Medical":
                pageUrl = "groupingMembersMedical";
				break;
            case "Edit Grouping Members Medical":
                pageUrl = "PreShoppingPortal/editGroupingMembersMedical";
                break;
            case "Spanish":
                pageUrl = "lang=es";
                break;
            case "CoCo Additional information for yourself":
                pageUrl = "coco/member-details-portal/member-additional-information";
                break;
            case "CoCo Family Overview":
                pageUrl = "coco/WelcomePortal/familyOverview";
                break;
            case "Before you begin":
                pageUrl = "nes/beforeYouBegin";
                break;
            case "FindExpertHelpCoco":
                pageUrl = "broker-portal/individual/find-expert-help?cocoUser=true";
                break;
            case "Find Expert Help Exch":
                pageUrl = "broker-portal/individual/find-expert-help?";
                 break;
            case "CoCo Deductions":
                pageUrl = "coco/income-portal/deductions";
                break;
            case "Who Are You":
                pageUrl = "nes/idProofing";
                break;
            case "Report a life change":
                pageUrl = "nes/lifeChangeEvents";
                break;
            case "EXCH Declarations and Signature":
                pageUrl = "nes/declarationAndSignature";
                break;
            case "Identity Proofing - Initial Questions":
                pageUrl = "nes/memberIdProofing";
                break;
            case "Identify Proofing - Congratulations":
                pageUrl = "nes/IdProofingSecondaryRequest";
                break;
            case "CoCo Declarations and Signature":
                pageUrl = "WelcomePortal/declarationsAndSignature";
                break;
            case "Compare":
                pageUrl = "compare";
                break;
            case "RIDP - Congratulations":
                pageUrl = "nes/IdProofingSecondaryRequest";
                break;
            case "Tell us about life changes":
                pageUrl = "nes/qlceConfirmation";
                break;
            case "dentalCompare":
                pageUrl = "dentalCompare";
                break;
            case "Employment Income":
                pageUrl = "employmentInfo";
                break;
            case "Application History":
                pageUrl = "nes/applicationHistory";
                break;
            case "Dental Plan Results":
                pageUrl = "dentalPlanResults";
                break;
            case "Add Address":
                pageUrl = "nes/addAddress";
                break;
            case "Citizenship":
                pageUrl = "nes/lawfulPresence";
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
            case "We Can Help":
                pageUrl = "/we-can-help/";
                break;
            case "Podemos ayudar":
                pageUrl = "/es/podemos-ayudar/";
                break;
            case "Financial Help":
                pageUrl = "/financial-help/get-financial-help/";
                break;
            case "Faqs":
                pageUrl = "faqs";
                break;
            case "Customer Service":
                pageUrl = "customer-service";
                break;
            case "Facebook":
                pageUrl = "facebook.com/connectforhealthco";
                break;
            case "X":
                pageUrl = "twitter.com/C4HCO";
                break;
            case "YouTube":
                pageUrl = "youtube.com/user/ConnectForHealthCO";
                break;
            case "Instagram":
                pageUrl = "instagram.com/c4hco/";
                break;
            case "LinkedIn":
                pageUrl = "linkedin.com/company/connect-for-health-colorado";
                break;
            case "Threads":
                pageUrl = "threads.net/@c4hco";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + pageUrl);
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

    @And("I set the browser resolution to 1920 x 1080")
    public void setResolution(){basicActions.getDriver().manage().window().setSize(new Dimension(1920, 1080));}
}
