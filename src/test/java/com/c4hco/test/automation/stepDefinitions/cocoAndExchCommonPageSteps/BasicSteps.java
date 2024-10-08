package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

public class BasicSteps {
    BasicActions basicActions = new BasicActions(WebDriverManager.getDriver());
    BasicActions actions = BasicActions.getInstance();

    @And("I validate I am on the {string} page")
    public void iValidatePage(String page) {
        String pageUrl = " ";
        switch (page) {
            case "Login":
                pageUrl = "/login-portal/login";
                break;
            case "Admin Login":
                pageUrl = "login-portal/login/adminUsers";
                break;
                case "Program Manager Login":
                pageUrl = "login-portal/login/programManagers";
                break;
                case "Broker Portal Login":
                pageUrl = "login-portal/login/brokers";
                break;
            case "Prescreen":
                pageUrl = "/prescreen";
                break;
            case "Add Member":
                pageUrl = "nes/addMember";
                break;
                case "Pay now":
                pageUrl = "PaymentPortal/payNow";
                break;
            case "Account Overview":
                basicActions.wait(3000);
                pageUrl = "nes/accountOverview";
                break;
            case "My Account Overview":
                pageUrl = "nes/myAccountOverview";
                break;
            case "CAC Screener":
                pageUrl = "/coco/WelcomePortal/cacScreener";
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
            case "CoCo Start Shopping":
                pageUrl = "coco/PreShoppingPortal/startShopping";
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
                basicActions.wait(3000);
                pageUrl = "IncomePortal/summaryDetails";
                break;
            case "Employment Info":
                basicActions.wait(3000);
                pageUrl = "IncomePortal/member";
                break;
            case "planSummaryMedicalDental":
                pageUrl = "planSummaryMedicalDental";
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
                case "Individual CoCo":
                pageUrl = "/AdminPortal/coco/individual/";
                break;
            case "Application Results":
                pageUrl = "nes/applicationResults";
                break;
            case "Application Results CoCo":
                pageUrl = "coco/ApplicationResultsPortal/applicationResults";
                break;
            case "My Profile":
                basicActions.wait(3000);
                pageUrl = "UserProfileAdmin/profile";
                break;
            case "Forgot my password":
                pageUrl = "login-portal/forgotPassword";
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
            case "CoCo Medical Plan Results":
                pageUrl = "coco/PlanSelectionPortal/medicalPlanResults";
                break;
            case "Medical Plan Detail":
                pageUrl = "medicalPlanCarrierDetails";
                break;
            case "Grouping Members Medical":
                pageUrl = "viewGroupingMembers";
                break;
            case "CoCo Grouping Members Medical":
                pageUrl = "coco/PreShoppingPortal/viewGroupingMembers";
                break;
            case "Grouping Members Dental":
                pageUrl = "PreShoppingPortal/viewGroupingMembers";
                break;
            case "Edit Grouping Members Medical":
                pageUrl = "PreShoppingPortal/manageGroupingMembers";
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
                pageUrl = "/broker-portal/individual/find-expert-help?lang=en";
                break;
                case "Find Expert Help Exch OBO":
                pageUrl = "broker-portal/obo/find-expert-help";
                break;
            case "Find Expert Help Exch Spanish":
                pageUrl = "broker-portal/individual/find-expert-help?lang=es";
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
            case "Medical Plan Compare":
                pageUrl = "PlanSelectionPortal/compare";
                break;
            case "Tell us about life changes":
                pageUrl = "nes/qlceConfirmation";
                break;
            case "Dental Grouping":
                pageUrl = "viewGroupingMembers/";
                break;
            case "Dental Plan Compare":
                pageUrl = "dentalCompare";
                break;
            case "Dental Plan Detail":
                pageUrl = "dentalPlanCarrierDetails";
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
                pageUrl = "planSummaryMedicalDental";
                break;
            case "Coco Plan Summary":
                pageUrl = "coco/PlanSelectionPortal/planSummaryMedicalDental";
                break;
            case "My Policies":
                pageUrl = "/EnrollmentPortal/myPolicies";
                break;
            case "Tell us about yourself":
                pageUrl = "nes/nesBrokerRedirect?lang=en&planYearClicked=true";
                break;
            case "Additional Information for Yourself":
                pageUrl = "nes/addAddress";
                break;
            case "Family Overview":
                pageUrl = "nes/household";
                break;
            case "Tax status":
                pageUrl = "nes/taxReturns";
                break;
            case "Tax status dependent":
                pageUrl = "nes/taxReturn";
                break;
            case "Employment Summary":
                pageUrl = "/employmentInfo/summary";
                break;
            case "Elmo Other Health Coverage":
                pageUrl = "/otherHealthCoverage";
                break;
            case "Elmo COBRA":
                pageUrl = "/otherHealthCoverage/cobra";
                break;
            case "ESI":
                pageUrl = "otherHealthCoverage/employerSponsored";
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
            case "CoCo Enrollment Agreements":
                pageUrl = "coco/PaymentPortal/enrollmentAgreements";
                break;
            case "Good News":
                pageUrl = "nes/applyMA";
                break;
            case "Broker Dashboard":
                pageUrl = "/broker-portal/broker";
                break;
            case "Agency Dashboard":
                pageUrl = "/broker-portal/agency";
                break;
            case "My Plans CoCo":
                pageUrl = "coco/EnrollmentPortal/myPolicies";
                break;
            case "Financial Help Agreements" :
                pageUrl = "PaymentPortal/agreements";
                break;
            case "Payment Selection" :
                pageUrl = "PaymentPortal/paymentSelection";
                break;
            case "Initial Payment" :
                pageUrl = "PaymentPortal/initialPayment";
                break;
            case "Admin Portal search" :
                pageUrl = "AdminPortal/search";
                break;
            case "Congratulations - What's Next?":
                pageUrl = "whatsnext";
                break;
            case "Application Summary":
                pageUrl = "selectMember";
                break;
            case "Account Activity":
                pageUrl = "/activity-report";
                break;
            case "Detailed EDI":
                pageUrl = "/detailed-edi";
                break;
            case "EDI Transactions":
                pageUrl = "/edi-transactions";
                break;
            case "Elmo Race and Ethnicity" :
                pageUrl = "/member-details-portal/race-ethnicity/";
                break;
            case "Ethnicity and Race" :
                pageUrl = "/member-details-portal/race-ethnicity/";
                break;
            case "CoCo Tell us about yourself" :
                pageUrl = "/coco/member-details-portal/member-details/";
                break;
            case "CoCo Tell us about additional members" :
                pageUrl = "/coco/member-details-portal/additional-member-details";
                break;
            case "CoCo Additional info for additional member" :
                pageUrl = "/coco/member-details-portal/member-additional-information/";
                break;
            case "Elmo Ohi Retiree":
                pageUrl = "/otherHealthCoverage/retiree";
                break;
            case "Elmo Ohi Medicare":
                pageUrl = "/otherHealthCoverage/medicare";
                break;
            case "Elmo Ohi VA Healthcare":
                pageUrl = "/otherHealthCoverage/va";
                break;
            case "Elmo Ohi Individual Insurance":
                pageUrl = "/otherHealthCoverage/individual";
                break;
            case "Elmo Ohi Peace Corps":
                pageUrl = "/otherHealthCoverage/peaceCorps";
				break;
            case "Elmo Ohi Tricare":
                pageUrl = "/otherHealthCoverage/tricare";
                break;
            case "CoCo Employment Income":
                pageUrl = "/employmentInfo";
                break;
            case "CoCo Additional Income":
                pageUrl = "coco/income-portal/additionalIncome";
                break;
            case "CoCo Income Summary":
                pageUrl = "coco/income-portal/summaryDetails";
                break;
            case "CoCo Dependent Overview":
                pageUrl = "coco/member-details-portal/dependent-overview";
                break;
            case "Cancellation Request":
                pageUrl = "EnrollmentPortal/cancellationRequest";
                break;
            case "English":
                pageUrl = "lang=en";
                break;
            case "Admin LCE":
                pageUrl = "/nes/adminLce";
                break;
            case "Admin Portal individual dashboard" :
                pageUrl = "/AdminPortal/individual/";
                break;
            case "LUGY Find expert help" :
                pageUrl = "broker-portal/find-expert-help";
                break;
            case "Agency dashboard" :
                pageUrl = "AdminPortal/agency";
                break;
            case "AP Broker dashboard" :
                pageUrl = "AdminPortal/broker";
                break;
            case "Broker Portal C4U link" :
                pageUrl = "https://c4hco.csod.com/login/render.aspx?id=defaultclp";
                break;
            case "Broker Portal Your Clients" :
                pageUrl = "/view-clients";
                break;
            case "assistnet dashboard" :
                pageUrl = "assistnet-portal/program-manager";
                break;
            case "Error" :
                pageUrl = "/error";
                break;
            case "Unauthorized" :
                pageUrl = "/unauthorized";
                break;
            case "Admin Portal Exclusion Reason Report" :
                pageUrl = "/exclusions";
                break;
            case "Admin Portal EDI Transactions" :
                pageUrl = "edi-transactions";
                break;
            case "Admin Portal Detailed EDI" :
                pageUrl = "/detailed-edi";
                break;
            case "Access Gateway" :
                pageUrl = "/AdminPortal/";
                break;
            case "Elmo HRA" :
                pageUrl = "otherHealthCoverage/hra";
                break;
            case "Program Manager" :
                pageUrl = "/AdminPortal/programManager/";
                break;
            case "Application Summary Completed" :
                pageUrl = "applicationSummary";
                break;
            case "Application Details" :
                pageUrl = "oboApplSummary";
                break;
                case "Medical Enrollment Groups" :
                pageUrl = "PreShoppingPortal/viewGroupingMembers";
                break;
            case "Manage Plans" :
                pageUrl = "/policies";
                break;
            default:
                System.out.println("undefined page ");
                break;
        }
        Assert.assertTrue( basicActions.getUrlWithWait(pageUrl, 45).contains(pageUrl), "expected page::" + pageUrl + "::did not load");
    }

    @And("I validate I am on the {string} page and close tab")
    public void iValidatePageAndClose(String page) {
        String pageUrl = " ";
        switch (page) {
            case "Privacy Policy":
                pageUrl = "/InformationPortal/privacyPolicy";
                break;
            case "Terms Of Use":
                pageUrl = "/InformationPortal/termsOfUse";
                break;
            case "ELIG Terms of Use":
                pageUrl = "/terms-of-use/";
                break;
            case "Contact Us":
                pageUrl = "/InformationPortal/contactUs";
                break;
            case "ELIG Contact Us":
                pageUrl = "/contact-us/";
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
                pageUrl = "facebook.com/*connectforhealthco";
                break;
            case "X":
                pageUrl = "x.com/i/flow/login?redirect_after_login=%2FC4HCO";
                break;
            case "YouTube":
                pageUrl = "youtube.com/user/ConnectForHealthCO";
                break;
            case "Instagram":
                pageUrl = "instagram.com/c4hco/";
                break;
            case "LinkedIn":
                pageUrl = "www.linkedin.com%2Fcompany%2Fconnect-for-health-colorado";
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
            case "Employer Coverage":
                pageUrl = "healthcare.gov/downloads/employer-coverage-tool.pdf";
                break;
            case "Medicare DOI":
                pageUrl = "senior-health-care-medicare";
                break;
            case "Alimony Received":
                pageUrl = "https://www.irs.gov/taxtopics/tc452";
                break;
            case "Capital Gains":
                pageUrl = "https://www.irs.gov/taxtopics/tc409";
                break;
            case "Income from Rental":
                pageUrl = "https://www.irs.gov/taxtopics/tc414";
                break;
            case "Pension":
                pageUrl = "https://www.irs.gov/publications/p575";
                break;
            case "Private Retirement Income":
                pageUrl = "https://www.irs.gov/pub/irs-pdf/p575.pdf";
                break;
            case "Unemployment Insurance":
                pageUrl = "https://www.irs.gov/individuals/employees/unemployment-compensation";
                break;
            case "Investment Income":
                pageUrl = "https://www.irs.gov/pub/irs-pdf/p550.pdf";
                break;
            case "Untaxed Foreign Income":
                pageUrl = "https://www.irs.gov/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income";
                break;
            case "Royalty Income":
                pageUrl = "https://www.irs.gov/forms-pubs/about-form-1099-misc";
                break;
            case "Title II Income":
                pageUrl = "https://www.disability-benefits-help.org/glossary/title-ii-benefits";
                break;
            case "Alimony paid out":
                pageUrl = "https://www.irs.gov/taxtopics/tc452";
                break;
            case "Domestic production activities":
                pageUrl = "https://www.irs.gov/pub/irs-pdf/i8903.pdf";
                break;
            case "Pre-tax retirement contribution":
                pageUrl = "https://www.irs.gov/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit";
                break;
            case "School tuition":
                pageUrl = "https://www.irs.gov/taxtopics/tc513";
                break;
            case "School tuition: Self-Employed 1":
                pageUrl = "https://www.irs.gov/pub/irs-pdf/f1040sc.pdf";
                break;
            case "School tuition: Self-Employed 2":
                pageUrl = "https://www.irs.gov/pub/irs-pdf/f1040sf.pdf";
                break;
            case "School tuition: Armed Forces 1":
                pageUrl = "https://www.irs.gov/pub/irs-pdf/f1040s1.pdf";
                break;
            case "School tuition: Armed Forces 2":
                pageUrl = "https://www.irs.gov/pub/irs-pdf/f2106.pdf";
                break;
            case "School tuition: Disability 1":
                pageUrl = "https://www.irs.gov/pub/irs-pdf/f1040sa.pdf";
                break;
            case "School tuition: Disability 2":
                pageUrl = "https://www.irs.gov/pub/irs-pdf/f2106.pdf";
                break;
            case "Self-employment tax":
                pageUrl = "https://www.irs.gov/individuals/international-taxpayers/self-employment-tax";
                break;
            case "Student Loan Interest":
                pageUrl = "https://www.irs.gov/taxtopics/tc456";
                break;
            case "Self-employment Health Insurance":
                pageUrl = "https://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/";
                break;
            case "Self-Employment Retirement Plan":
                pageUrl = "https://www.irs.gov/retirement-plans/retirement-plans-for-self-employed-people";
                break;
            case "Moving Expenses":
                pageUrl = "https://www.irs.gov/forms-pubs/about-form-3903";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + pageUrl);
        }
        // TO DO :: Move this code to be re-usable - move to basicActions.
        String origin = basicActions.getDriver().getWindowHandle();
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
            if (basicActions.getDriver().getTitle().equals(page)) {
                Assert.assertTrue(basicActions.getUrlWithWait(pageUrl, 50).contains(pageUrl), "expected page::"+ pageUrl+"::did not load");
            }
        }
        basicActions.closeBrowserTab();
        basicActions.getDriver().switchTo().window(origin);
    }
    @And("I close current tab and switch back to previous tab")
    public void closeCurrentTabAndSwitchToPrevious() {
        basicActions.closeBrowserTab();
        basicActions.switchtoPreviousTab();
    }

    @And("I refresh the page")
    public void refreshPage() {
        basicActions.refreshPage();
    }

    @And("I go to the previous browser page")
    public void goBack() {
        basicActions.goBack();
    }

    @And("I switch to the tab number {int}")
    public void switchTab(int tabNumber) { basicActions.switchTabs(tabNumber);}

    @And("I set the browser resolution to {int} x {int}")
    public void setResolution(int width, int height) {
        basicActions.getDriver().manage().window().setSize(new Dimension(width, height));
    }

    @And("I set the browser resolution to Maximized")
    public void setResolutionMax(){basicActions.getDriver().manage().window().maximize();}

    @And("I change the C4 url to {string}")
    public void iChangeToNewUrl(String page){basicActions.changeToNewUrl(page);}

    @Then("I click Go Back button from chrome browser")
    public void iClickGoBackButtonFromChromeBrowser() {
        basicActions.clickBackButtonFromBrowser();
    }

    @Then("I wait for {int} milliseconds")
    public void iWait(int waitTime) {actions.wait(waitTime);}
}
