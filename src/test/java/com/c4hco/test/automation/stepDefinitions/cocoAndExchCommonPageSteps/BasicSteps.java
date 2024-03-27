package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
                pageUrl = "nes/accountOverview";
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
                pageUrl = "AdminPortal"; // update this url - url will have AdminPortal even if we fail to login
                break;
            case "Admin search":
                pageUrl = "/AdminPortal/search";
                break;
            case "Application Results":
                pageUrl = "nes/applicationResults";
                break;
            case "Application Results CoCo":
                pageUrl = "coco/ApplicationResultsPortal/applicationResults";
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
            case "Edit Grouping Members Dental":
                pageUrl = "PreShoppingPortal/editGroupingMembersDental";
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
            case "CoCo life change event":
                pageUrl = "coco/lce-portal/lces";
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
            case "forgotPassword":
                pageUrl = "login-portal/forgotPassword";
                break;
            case "forgotUsername":
                pageUrl = "login-portal/forgotEmail";
                break;
            case "MFA":
                pageUrl = "login-portal/mfa";
                break;
            case "Plan Summary":
                pageUrl = "/planSummaryMedicalDental/";
                break;
            case "My Policies":
                pageUrl = "/EnrollmentPortal/myPolicies";
                break;
            case "Tell us about yourself":
                pageUrl = "nes/nesBrokerRedirect?lang=en&planYearClicked=true";
                break;
            case "Family Overview":
                pageUrl = "nes/household";
                break;
            case "Tax status":
                pageUrl = "nes/taxReturns";
                break;
            case "Employment Summary":
                pageUrl = "/employmentInfo/summary";
                break;
            case "Other Health Insurance":
                pageUrl = "nes/otherHealthInsuranceBegin";
                break;
            case "ESI":
                pageUrl = "otherHealthInsurance/employerSponsored";
                break;
            case "HRA":
                pageUrl = "nes/memberHra";
                break;
            case "Medicare":
                pageUrl = "nes/medicare";
                break;
            case "VA Healthcare":
                pageUrl = "nes/vaHealth";
                break;
            case "COBRA":
                pageUrl = "nes/cobra";
                break;
            case "Retiree Health Plan":
                pageUrl = "nes/retireeHealth";
                break;
            case "TRICARE":
                pageUrl = "nes/tricare";
                break;
            case "Peace Corps":
                pageUrl = "nes/peaceCorps";
                break;
            case "Individual Insurance":
                pageUrl = "nes/individualInsurance";
                break;
            case "Enrollment Agreements":
                pageUrl = "PaymentPortal/enrollmentAgreements";
                break;
            case "Good News":
                pageUrl = "nes/applyMA";
                break;
            case "Broker Dashboard" :
                pageUrl = "/broker-portal/broker";
                break;
            default:
                System.out.println("undefined page ");
                break;
        }
        Assert.assertTrue("expected page::"+ pageUrl+"::did not load", basicActions.getUrlWithWait(pageUrl, 45).contains(pageUrl));
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
            case "Admin LCE":
                pageUrl = "/nes/adminLce";
                break;
            case "CBMS Search":
                pageUrl = "/AdminPortal/applinks/cbms-search";
                break;
            case "Document LookUp":
                pageUrl = "/AdminPortal/applinks/doc-lookup";
                break;
            case "Okta Console":
                pageUrl = "https://extconnectforhealth-admin.oktapreview.com/admin/users";
                break;
            case "On Behalf Of(OBO)":
                pageUrl = "/coco/WelcomePortal/welcome";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + pageUrl);
        }
        // TO DO :: Move this code to be re-usable - move to basicActions.
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

    @Then("I validate I am on active tab")
    public void iValidateIAmOnActiveTab() {
        basicActions.switchtoChildWindow();
    }
}
