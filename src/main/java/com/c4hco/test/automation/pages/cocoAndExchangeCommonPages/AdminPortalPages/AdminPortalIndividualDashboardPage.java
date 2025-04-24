package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class AdminPortalIndividualDashboardPage {

    public BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AdminPortalIndividualDashboardPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//p[normalize-space()='Reports']")
    WebElement reportsTitle;
    @FindBy(css = "body app-root h2:nth-child(2)")
    WebElement memberPrimary;
    @FindBy(css = ".dashboardHeader1")
    WebElement agencyContainerTitle;
    @FindBy(css = ".dashboardHeader2")
    WebElement memberAcctId;
    @FindBy(css = ".container-fluid .reports-container .link-section span:nth-child(1)")
    List<WebElement> reportViewButtons;
    @FindBy(css = ".search-input-and-label .search-input")
    List<WebElement> searchAgencynputList;
    @FindBy(css = "tr[id='agency-name'] td[class='group-box-input']")
    WebElement agencyName;
    @FindBy(css = "tr[id='agency-license-number'] td[class='group-box-input']")
    WebElement stateLicenseNumber;
    @FindBy(css = "tr[id='agency-tin-ein'] td[class='group-box-input']")
    WebElement agencyThin;
    @FindBy(id = "agency-agent")
    WebElement agencyAgent;
    @FindBy(css = "#agency-email > td.group-box-input")
    WebElement agencyEmail;
    @FindBy(id = "agency-website")
    WebElement agencyWebsite;
    @FindBy(css = "tr[id='agency-address'] td[class='group-box-input']")
    WebElement agencyAddress;
    @FindBy(css = "tr[id='agency-prim-phone'] td[class='group-box-input']")
    WebElement agencyPhone;
    @FindBy(css = "tr[id='agency-language'] td[class='group-box-input']")
    WebElement agencyPreferredLanguage;
    @FindBy(css = "label[for='selected-member-checkbox']")
    WebElement selectedMember;
    @FindBy(css = "#full-name")
    WebElement memberFullName;

   @FindBy(xpath = "//app-account-summary//div[1]/h6[1]")
    WebElement txtMember1QA;
    @FindBy(xpath = "//app-account-summary//div[2]/h6[1]")
    WebElement txtMember2QA;

    @FindBy(xpath = "//app-account-summary//div[3]/h6[1]")
    List<WebElement> txtMember3QA;

    @FindBy(xpath = "//app-individual-dashboard[1]//div[1]/h6[2]")
    WebElement txtPrimaryRelationAgeQA;
    @FindBy(xpath = "//app-individual-dashboard[1]//div[2]/h6[2]")
    WebElement txtSecondaryRelationAgeQA;
    @FindBy(xpath = "//div[@class='household-members']//div[3]//hr[1]")
    List< WebElement> txtThirdRelationAgeQA;
    @FindBy(xpath = "//div[@class='username-container']")
    WebElement membername;

    @FindBy(xpath = "//div[@class='full-name-container']")
    WebElement memberfullName;

    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#phone-number")
    WebElement memberPhone;
    @FindBy(css = "#email-address")
    WebElement memberEmail;
    @FindBy(css = "#dob")
    WebElement memberDob;
    @FindBy(xpath = "//*[@id=\"app-individual-selected-member-75\"]/div/div[6]")
    WebElement memberAddress;
    @FindBy(css = "div[class='group-box summary-container'] p[class='group-title']")
    WebElement summaryTitle;
    @FindBy(xpath = "//p[normalize-space()='Eligibility']")
    WebElement eligibilityTitle;
    @FindBy(xpath = "//h2[@class='dashboardHeader-renewal']")
    WebElement renewalsTitle;
    @FindBy(xpath = "//p[normalize-space()='Payloads']")
    WebElement payloadsTitle;
    @FindBy(css = ".dropdown")
    WebElement payloadsYears;
    @FindBy(css = ".subheader-planyear")
    WebElement renewalsYear;

    @FindBy(xpath = "//td[@id='username']")
    WebElement pmUsername;
    @FindBy(id = "prim-phone")
    WebElement pmPhone;
    @FindBy(css = "#program-manager-contract > h2")
    WebElement contractStatus;
    @FindBy(id = "manage-contract")
    WebElement manageContract;
    @FindBy(css = "div[class='group-box summary-container'] p[class='group-title']")
    WebElement profileSummary;
    @FindBy(css = "div[id='program-manager-contract'] p[class='group-title']")
    WebElement contractInfo;
    @FindBy(css = "div[class='group-box activity-container'] p[class='group-title']")
    WebElement activityContainer;
    @FindBy(css = "div[class='group-box client-container'] p[class='group-title']")
    WebElement clientContainer;
    @FindBy(css = "div[class='group-box organization-container'] p[class='group-title']")
    WebElement organizationContainer;
    @FindBy(css = ".btn-second-action-button.view-report")
    WebElement viewReportButton;
    @FindBy(css = "div[class='nodata'] p")
    WebElement noClients;
    @FindBy(xpath = "//button[@class='btn-second-action-button dashboard-button']")
    WebElement goBack;
    @FindBy(css = "label[for='organization-id']")
    WebElement lblGroupID;
    @FindBy(xpath = "//p[@id='id']")
    WebElement groupID;
    @FindBy(css = "label[for='name']")
    WebElement lablOrgName;
    @FindBy(xpath = "//p[@id='name']")
    WebElement orgName;
    @FindBy(xpath = "//div[.='Renewal Status: PENDING']")
    WebElement renewalsStatus;
    @FindBy(css = "#medicalData > span")
    WebElement renewalMed;
    @FindBy(css = "#medicalData > div > span.body-text-coverage")
    WebElement renewalMedCoverage;
    @FindBy(xpath = "//*[@id='medicalData']/div/span[2]")
    WebElement coverageMedPlan;
    @FindBy(css = "#dentalData > span")
    WebElement renewalDental;
    @FindBy(css = "#dentalData > div > span.body-text-coverage")
    WebElement renewalDentalCoverage;
    @FindBy(xpath = "//*[@id='dentalData']/div/span[2]")
    WebElement coverageDentalPlan;
    @FindBy(xpath = "//app-individual-renewals/div/div[2]")
    WebElement noRenewalReason;
    @FindBy(xpath = "//app-individual-renewals/div/div[3]")
    WebElement cancelledReason;
    @FindBy(xpath = "//app-individual-renewals/div/div[2]")
    WebElement renewalsMessage;
    @FindBy(xpath = "//app-individual-renewals/div/div[2]")
    WebElement renewalStatusAnyEnvironment;
    @FindBy(xpath = "//div[.='Renewal Status: CANCELED']")
    WebElement renewalCanceled;
    @FindBy(css = "div[class='group-box summary-container'] p[class='group-title']")
    WebElement profileTitle;
    @FindBy(css = "div[id='program-manager-contract'] p[class='group-title']")
    WebElement contractTitle;
    @FindBy(css = "div[class='group-box activity-container'] p[class='group-title']")
    WebElement accountActivityTitle;
    @FindBy(css = "div[class='group-box client-container'] p[class='group-title']")
    WebElement clientTitle;
    @FindBy(css = "div[class='group-box organization-container'] p[class='group-title']")
    WebElement organizationTitle;
    @FindBy(css = "body app-root th:nth-child(1)")
    WebElement firstNameClient;
    @FindBy(css = "body app-root th:nth-child(2)")
    WebElement lastNameClient;
    @FindBy(css = "body app-root th:nth-child(4)")
    WebElement phoneClient;
    @FindBy(css = "body app-root th:nth-child(3)")
    WebElement emailClient;
    @FindBy(xpath = "//*[@id=\"program-manager-client-info-table\"]/tr[1]")
    WebElement firstRowClientData;
    @FindBy(xpath = "//*[@id=\"program-manager-client-info-table\"]/tr[2]")
    WebElement secondRowClientData;

    //Manage account access
    @FindBy(xpath = "(//p[normalize-space()=\"Suspend user's account\"])[1]")
    WebElement txtSuspAcct;

    @FindBy(xpath = "(//p[normalize-space()=\"Reset user's password\"])[1]")
    WebElement txtResetPassw;

    @FindBy(xpath = "//p[@id='account-status']")
    WebElement accountStatus;

    @FindBy(xpath = "(//input[@name='account-option'])[1]")
    WebElement selectsuspendoractiavteaccount;

    @FindBy(xpath = "(//input[@name='account-option'])[2]")
    WebElement selectResetPassword;

    @FindBy(xpath = "//button[@id='btn-save']")
    WebElement save;

    @FindBy(xpath = "//p[@class='content-message']")
    WebElement successfulUpdatemessage;

    @FindBy(css = "app-account-summary .group-title")
    WebElement accountSummaryTitle;

    @FindBy(css = "app-account-summary .title ")
    List<WebElement> unameAndNameTitles;

    @FindBy(css = "app-account-summary .individual-name")
    List<WebElement> individualNames;

    @FindBy(css = "app-account-summary .household-members-title")
    WebElement hhMemTitle;

    @FindBy(css = "app-account-summary .member-name")
    List<WebElement> memNamesList;

    @FindBy(css = ".button-section button a")
    List<WebElement> accSummaryBtns;
    @FindBy(xpath = "//app-individual-eligibility//app-plan-year-dropdown//app-drop-down-select//div[contains(@class, 'drop-down-option')]")
    WebElement eligibilityYear;
    @FindBy(xpath = "//button[@class='btn-second-action-button view-elibility-1']")
    WebElement viewDetailedEligibility;
    @FindBy(xpath = "//span[normalize-space()='Household level application and eligibility data']")
    WebElement householdTableTitle;
    @FindBy(xpath = "//span[normalize-space()='Member level eligibility data']")
    WebElement memberTableTitle;
    @FindBy(xpath = "//span[normalize-space()='Life change events']")
    WebElement lceTableTitle;
    @FindBy(xpath = "//th[normalize-space()='Life Change Event']")
    WebElement lceEvent;
    @FindBy(xpath = "//th[normalize-space()='Impacted Members']")
    WebElement membersImpacted;
    @FindBy(xpath = "//th[normalize-space()='Date of Event']")
    WebElement lceDate;
    @FindBy(xpath = "//td[@id='eventType']")
    WebElement lceEventData;
    @FindBy(xpath = "//div[6]//table[1]//tr[2]//td[1]")
    WebElement membersImpactedData;
    @FindBy(xpath = "//td[@id='eventDate']")
    WebElement lceDateData;
    @FindBy(xpath = "//div[@class='no-eligibility']")
    WebElement NoData;
    @FindBy(xpath = "//button[normalize-space()='Tax Household 2']")
    WebElement householdSecond;
    @FindBy(css = "#householdSelect")
    WebElement householdDropdown;
    @FindBy(xpath = "//th[normalize-space()='Member']")
    WebElement memberTitle;
    @FindBy(xpath = "//th[normalize-space()='CSR']")
    WebElement csrTitle;
    @FindBy(xpath = "//th[normalize-space()='Relationship to the Primary Account Holder']")
    WebElement relationshipTitle;
    @FindBy(xpath = "//th[normalize-space()='Tax Filer Status']")
    WebElement taxTitle;
    @FindBy(xpath = "//td[@id='memberName']")
    WebElement member;
    @FindBy(xpath = "//th[normalize-space()='Date of Event']")
    WebElement csr;
    @FindBy(xpath = "//td[@id='relationship']")
    WebElement relationship;
    @FindBy(xpath = "//td[@id='taxFilerType']")
    WebElement tax;
    @FindBy(xpath = "//td[normalize-space()='Application ID:']")
    WebElement applicationId;
    @FindBy(css = ".selected-member-header")
    WebElement selectedMemberLabel;
    @FindBy(css = "#app-individual-selected-member-80 > div")
    WebElement selectedMemberData;
    @FindBy(css = "#account-status")
    WebElement suspended;
    @FindBy(css = "#account-status")
    WebElement passwordReset;

    @FindBy(xpath = "//*[@class='member-prop-container']/label")
    List<WebElement> selectedMemberLabelTxt;

    @FindBy(xpath = "//*[@class='member-prop-container']/span")
    List<WebElement> selectedMemberDataTxt;

    @FindBy(xpath = "//a[contains(text(),'Manage Account Details')]")
    WebElement btnManageAccountDetails;

    ////////////////////////////Plans Container//////////////////////////
    @FindBy(xpath = "//p[normalize-space()='Plans']")
    WebElement plansTitle;
    @FindBy(id = "Individual Dashboard-Manage Plans")
    WebElement managePlanButton;
    @FindBy(css = ".drop-down-option.drop-down-option-selected")
    WebElement dpdCurrentYearMP;
    @FindBy(xpath = "//app-individual-plans//app-drop-down-select//div[2]/div")
    List<WebElement> planYearSelectorOptions;
    @FindBy(xpath = "//p[contains(text(),'There is no active policy data.')]")
    WebElement noActivePolicyTxt;

    public void clickBtnOnAccSummContainer(String btnName) {
        basicActions.waitForElementListToBePresent(accSummaryBtns, 10);
        switch (btnName) {
            case "Manage Account Details":
                accSummaryBtns.get(1).click();
                break;
            case "Manage Account Access":
                accSummaryBtns.get(0).click();
                break;
            default:
                Assert.fail("Invalid argument passed");
        }
        basicActions.switchtoactiveTab();

    }

    public void validateAccSummaryContainer() {
        basicActions.waitForElementToBePresent(accountSummaryTitle, 10);
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        softAssert.assertEquals(accountSummaryTitle.getText(), "Account Summary", "Account Summary Title did not match!");
        softAssert.assertEquals(unameAndNameTitles.get(0).getText(), "Username:", "Username Text did not match");
        softAssert.assertEquals(unameAndNameTitles.get(1).getText(), "Full Name:", "Full name text did not match");
        if( primaryMem.getIncorrectEmail() !=  null) {
            softAssert.assertEquals(individualNames.get(0).getText(), primaryMem.getIncorrectEmail(), "Email Id did not match");
        }
        else {
            softAssert.assertEquals(individualNames.get(0).getText(), primaryMem.getEmailId(), "Email Id did not match");
        }
        softAssert.assertEquals(individualNames.get(1).getText(), primaryMem.getCompleteFullName(), "Name of primary person did not match");
        softAssert.assertEquals(hhMemTitle.getText(), "Household Members", "Household Members title did not match");
        List<String> memberNamesUi = new ArrayList<>();
        List<String> memberNamesSharedData = basicActions.getAllMemFirstNames();

        for (WebElement memName : memNamesList) {
            memberNamesUi.add(memName.getText());

            WebElement memInfo = basicActions.getDriver().findElement(By.xpath("//app-account-summary//*[contains(@class, 'member-name')][contains(text(),'" + memName.getText() + "')]/following-sibling::*"));
            List<MemberDetails> allMembers = basicActions.getAllMem();

            for (MemberDetails mem : allMembers) {
                if (mem.getCompleteFullName().contains(memName.getText())) {
                    String relation = mem.getRelation_to_subscriber();
                    softAssert.assertEquals(memInfo.getText(), relation.toUpperCase() + " / Age " + basicActions.getAge(mem.getDob()), "Member Info did not match");
                }
            }
        }
        softAssert.assertEqualsNoOrder(memberNamesUi.toArray(), memberNamesSharedData.toArray(), "The member names do not match.");
        softAssert.assertAll();
    }


    public void enterAgencyData(String agencyData, String type) {
        switch (agencyData) {
            case "agencyName":
                searchAgencynputList.get(0).sendKeys(type);
                break;
            case "stateLicenseNumber":
                searchAgencynputList.get(1).sendKeys(type);
                break;
            case "agencyEmail":
                searchAgencynputList.get(2).sendKeys(type);
                break;
            case "businessAddressCity":
                searchAgencynputList.get(3).sendKeys(type);
                break;
            case "businessAddressZip":
                searchAgencynputList.get(4).sendKeys(type);
                break;
            default:
                throw new IllegalArgumentException("Invalid header option : " + agencyData);
        }
    }

    public void verifyContainerTitle() {
        basicActions.waitForElementToBePresent(reportsTitle, 20);
        softAssert.assertTrue(reportsTitle.isDisplayed());
        softAssert.assertAll();
    }

    public void viewReportLinks(String searchText) {
        basicActions.waitForElementListToBePresentWithRetries(reportViewButtons, 60);
        WebElement viewButton = basicActions.getDriver().findElement(By.xpath("//span[contains(normalize-space(), '" + searchText + "')]//following::span[1]"));
        viewButton.click();
        basicActions.switchtoactiveTab();
    }

    public void verifyPrimaryHolder() {
        basicActions.wait(250);
        basicActions.waitForElementToBePresent(memberPrimary, 100);
        softAssert.assertTrue(memberPrimary.isDisplayed());
        basicActions.waitForElementToBePresent(memberAcctId, 100);
        softAssert.assertTrue(memberAcctId.isDisplayed());

        if (SharedData.getPrimaryMember().getSignature() != null) {
            softAssert.assertEquals(memberPrimary.getText(), "Primary Account Holder: " + SharedData.getPrimaryMember().getSignature());
            int commaIndex = memberAcctId.getText().indexOf(',');
            String accountIdFromHeader = memberAcctId.getText().substring(0, commaIndex).trim();
            softAssert.assertEquals(accountIdFromHeader, "Account ID:" + SharedData.getPrimaryMember().getAccount_id());
        }
        softAssert.assertAll();
    }

    public void verifyAgencyContainerTitle() {
        basicActions.waitForElementToBePresent(agencyContainerTitle, 10);
        softAssert.assertTrue(agencyContainerTitle.isDisplayed());
        basicActions.waitForElementToBePresent(memberAcctId, 10);
        softAssert.assertTrue(memberAcctId.isDisplayed());
        softAssert.assertAll();
    }

    public void agencySummaryValidation(String name, String license, String thin, String agent, String email, String website, String phone, String preferredLanguage) {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(agencyName, 10));
        softAssert.assertEquals(agencyName.getText(), name);
        softAssert.assertEquals(stateLicenseNumber.getText(), license);
        softAssert.assertEquals(agencyThin.getText(), thin);
        softAssert.assertEquals(agencyAgent.getText(), agent);
        softAssert.assertEquals(agencyEmail.getText(), email);
        softAssert.assertEquals(agencyWebsite.getText(), website);
        softAssert.assertEquals(agencyPhone.getText(), phone);
        softAssert.assertEquals(agencyPreferredLanguage.getText(), preferredLanguage);
        softAssert.assertTrue(agencyAddress.isDisplayed());
        softAssert.assertAll();
    }

    public void validateSelectedMemberData() {
        basicActions.switchToParentPage("C4HCO Admin Portal");
        basicActions.waitForElementToBePresent(selectedMember, 30);
        softAssert.assertTrue(selectedMember.isDisplayed());
        softAssert.assertTrue(memberFullName.isDisplayed());
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertTrue(memberEmail.isDisplayed());
        softAssert.assertTrue(memberPhone.isDisplayed());
        softAssert.assertTrue(memberDob.isDisplayed());
        softAssert.assertTrue(memberAddress.isDisplayed());
        softAssert.assertAll();
    }

    public void validateIndividualDashboardContainerTitles(String PlansContainer, String summaryContainer, String eligibilityContainer, String renewalsContainer, String reportsContainer, String payloadsContainer) {
        basicActions.waitForElementToBePresent(plansTitle, 30);
        softAssert.assertEquals(plansTitle.getText(), PlansContainer);
        softAssert.assertEquals(summaryTitle.getText(), summaryContainer);
        softAssert.assertEquals(eligibilityTitle.getText(), eligibilityContainer);
        softAssert.assertEquals(renewalsTitle.getText(), renewalsContainer);
        softAssert.assertEquals(reportsTitle.getText(), reportsContainer);
        softAssert.assertEquals(payloadsTitle.getText(), payloadsContainer);
        softAssert.assertAll();
    }

    public void verifyPayloadsContainer() {
        basicActions.waitForElementToBePresent(payloadsTitle, 30);
        softAssert.assertTrue(payloadsTitle.isDisplayed());
        softAssert.assertAll();
        WebElement table = basicActions.getDriver().findElement(By.cssSelector(".group-content"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        String[][] QAExpectedData = {
                {"10/21/2020 11:49", "NES", "QLCE", "47015183", "", "Contact", "80123", "View"},
                {"10/21/2020 11:37", "NES", "QLCE", "47015183", "", "Contact", "80123", "View"},
        };
        String[][] STGExpectedData = {
                {"08/27/2020 15:21", "NES", "QLCE", "42119771", "", "JingleheimerSchmidt", "80222"},
                {"08/27/2020 15:17", "NES", "QLCE", "42119771", "", "JingleheimerSchmidt", "80205"},
                {"08/27/2020 15:13", "NES", "QLCE", "42119771", "", "JingleheimerSchmidt", "80205"},
                {"06/01/2020 14:31", "NES", "QLCE", "42119771", "", "JingleheimerSchmidt", "80911"},
                {"06/01/2020 14:22", "NES", "QLCE", "42119771", "", "JingleheimerSchmidt", "80205"},
        };

        if (SharedData.getEnv().equals("qa")) {
            for (int i = 0; i < QAExpectedData.length; i++) {
                List<WebElement> cells = rows.get(i + 1).findElements(By.tagName("td"));
                for (int j = 0; j < QAExpectedData[i].length; j++) {
                    String cellText = cells.get(j).getText();
                    softAssert.assertEquals(cellText, QAExpectedData[i][j], "Mismatch found in row " + (i + 1) + ", column " + (j + 1));
                    softAssert.assertAll();
                }
            }
        } else {
            for (int i = 0; i < STGExpectedData.length; i++) {
                List<WebElement> cells = rows.get(i + 1).findElements(By.tagName("td"));
                for (int j = 0; j < STGExpectedData[i].length; j++) {
                    String cellText = cells.get(j).getText();
                    softAssert.assertEquals(cellText, STGExpectedData[i][j], "Mismatch found in row " + (i + 1) + ", column " + (j + 1));
                    softAssert.assertAll();
                }
            }
        }
    }

    public void verifyYears() {
        basicActions.waitForElementToBePresent(payloadsYears, 30);
        softAssert.assertEquals(payloadsYears.getText(), "All Payloads");
        softAssert.assertAll();
    }

    public void verifyContainerTitleAndDefaultYearIsDisplayed(String containerTitle, String defaultYear) {
        basicActions.waitForElementToBePresent(renewalsTitle, 10);
        softAssert.assertEquals(renewalsTitle.getText(), containerTitle);
        softAssert.assertEquals(renewalsYear.getText(), defaultYear);
        softAssert.assertAll();
    }

    public void VerifyProgramManagerInformationAccountSummary() {
        basicActions.waitForElementToBePresent(pmUsername, 20);
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(pmUsername.getText(), "profile@test.com");
            softAssert.assertEquals(pmPhone.getText(), "333-333-3333 ext12345");
        } else {
            softAssert.assertEquals(pmUsername.getText(), "c4assistorportal+d0GLweQ7R@gmail.com");
            softAssert.assertEquals(pmPhone.getText(), "236-521-3426");
        }
        softAssert.assertAll();
    }

    public void validateProgramManagerDashboardContainerTitles() {
        basicActions.waitForElementToBePresent(profileSummary, 30);
        softAssert.assertTrue(profileSummary.isDisplayed());
        softAssert.assertEquals(contractInfo.getText(), "Contract Information");
        softAssert.assertEquals(activityContainer.getText(), "Account Activity Report");
        softAssert.assertEquals(clientContainer.getText(), "Client Information");
        softAssert.assertEquals(organizationContainer.getText(), "Organization Information");
        softAssert.assertAll();
    }

    public void VerifyProgramManagerContractStatus() {
        softAssert.assertEquals(contractStatus.getText(), "Contract Status: APPROVED");
        softAssert.assertEquals(manageContract.getText(), "Manage Contract");
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(contractStatus.getText(), "Contract Status: APPROVED");
        } else {
            softAssert.assertEquals(contractStatus.getText(), "Contract Status: APPROVED");
        }
        softAssert.assertAll();
    }

    public void VerifyProgramManagerAccountActivityContainer() {
        basicActions.waitForElementToBePresent(viewReportButton, 30);
        softAssert.assertEquals(viewReportButton.getText(), "View Report");
        softAssert.assertAll();
    }

    public void VerifyProgramManagerClientInformationContainer(String text) {
        basicActions.waitForElementToBePresent(noClients, 20);
        softAssert.assertTrue(noClients.isDisplayed());
        softAssert.assertEquals(noClients.getText(), text);
        softAssert.assertAll();
    }

    public void VerifyProgramManagerOrganizationInformation(String idSTG, String idQA, String nameSTG, String nameQA) {
        softAssert.assertEquals(lblGroupID.getText(), "Organization Group ID:");
        softAssert.assertEquals(lablOrgName.getText(), "Organization Name:");
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(groupID.getText(), idSTG);
            softAssert.assertEquals(orgName.getText(), nameSTG);
        } else {
            softAssert.assertEquals(groupID.getText(), idQA);
            softAssert.assertEquals(orgName.getText(), nameQA);
        }
        softAssert.assertAll();
    }

    public void clickGoBackONAdminPortalProgramManager() {
        basicActions.waitForElementToBePresent(goBack, 20);
        goBack.click();
    }

    public void verifyStatusIsDisplayed(String containerStatusStaging, String containerStatusQa) {
        basicActions.waitForElementToBePresent(renewalStatusAnyEnvironment, 10);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(renewalStatusAnyEnvironment.getText(), containerStatusStaging);
        } else {
            softAssert.assertEquals(renewalStatusAnyEnvironment.getText(), containerStatusQa);
        }
        softAssert.assertAll();
    }

    public void validateMedicalAndDentalPlans(String renewalMedical, String medicalCoverage, String medPlanData, String renewalDent, String dentalCoverage, String dentPlanData) {
        basicActions.waitForElementToBePresent(renewalMed, 10);
        softAssert.assertEquals(renewalMed.getText(), renewalMedical);
        softAssert.assertEquals(renewalMedCoverage.getText(), medicalCoverage);
        softAssert.assertEquals(coverageMedPlan.getText(), medPlanData);
        softAssert.assertEquals(renewalDental.getText(), renewalDent);
        softAssert.assertEquals(renewalDentalCoverage.getText(), dentalCoverage);
        softAssert.assertEquals(coverageDentalPlan.getText(), dentPlanData);
        softAssert.assertAll();
    }

    public void validateMedicalPlan(String renewalMedical, String medicalCoverage, String medPlanData) {
        basicActions.waitForElementToBePresent(renewalMed, 10);
        softAssert.assertEquals(renewalMed.getText(), renewalMedical);
        softAssert.assertEquals(renewalMedCoverage.getText(), medicalCoverage);
        softAssert.assertEquals(coverageMedPlan.getText(), medPlanData);
        softAssert.assertAll();
    }

    public void verifyStatusIsDisplayed() {
        basicActions.waitForElementToBePresent(renewalsStatus, 10);
        softAssert.assertTrue(renewalsStatus.isDisplayed());
        softAssert.assertAll();
    }

    public void validateMedicalOnlyPlan(String medicalCoverage, String medicalCoverageStg, String medicalCoverageQa) {
        basicActions.waitForElementToBePresent(renewalMedCoverage, 10);
        softAssert.assertEquals(renewalMedCoverage.getText(), medicalCoverage);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(coverageMedPlan.getText(), medicalCoverageStg);
        } else {
            softAssert.assertEquals(coverageMedPlan.getText(), medicalCoverageQa);
        }
        softAssert.assertAll();
    }

    public void validateDentalOnlyPlans(String dentalCoverage, String dentalCoverageStg, String dentalCoverageQa) {
        basicActions.waitForElementToBePresent(renewalDental, 10);
        softAssert.assertEquals(renewalDentalCoverage.getText(), dentalCoverage);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(coverageDentalPlan.getText(), dentalCoverageStg);
        } else {
            softAssert.assertEquals(coverageDentalPlan.getText(), dentalCoverageQa);
        }
        softAssert.assertAll();
    }

    public void verifyMessageNoRenewal() {
        basicActions.waitForElementToBePresent(renewalsMessage, 20);
        softAssert.assertTrue(renewalsMessage.isDisplayed());
        softAssert.assertAll();
    }

    public void verifyNoRenewalReasonDependant() {
        basicActions.waitForElementToBePresent(noRenewalReason, 10);
        softAssert.assertEquals(noRenewalReason.getText(), "Account is not eligible for Renewal this year.\n" +
                "\n" +
                "Renewal Action: System Exclusion: OVER_25_DEPENDENT");
        softAssert.assertAll();
    }

    public void verifyNoRenewalReasonCatastrophic() {
        basicActions.waitForElementToBePresent(noRenewalReason, 10);
        softAssert.assertEquals(noRenewalReason.getText(), "Account is not eligible for Renewal this year.\n" +
                "\n" +
                "Renewal Action: System Exclusion: OVER_29_CATASTROPHIC");
        softAssert.assertAll();
    }

    public void verifyNoRenewalReasonCustomerOptPut() {
        basicActions.waitForElementToBePresent(cancelledReason, 10);
        softAssert.assertEquals(cancelledReason.getText(), "Renewal Action: CUSTOMER_OPT_OUT");
        softAssert.assertAll();
    }

    public void verifyNoRenewalReasonSystemCancel() {
        basicActions.waitForElementToBePresent(noRenewalReason, 10);
        softAssert.assertEquals(cancelledReason.getText(), "Renewal Action: SYSTEM_CANCEL_DUE_TO_TERM");
        softAssert.assertEquals(noRenewalReason.getText(), "Renewal Status: CANCELED");
        softAssert.assertAll();
    }

    public void verifyStatusCanceledIsDisplayed(String status) {
        basicActions.waitForElementToBePresent(renewalCanceled, 10);
        softAssert.assertEquals(renewalCanceled.getText(), status);
        softAssert.assertAll();
    }

    ///////Manage account Access///////
    public void VerifyAccountAccessDetails() {
        basicActions.waitForElementToBePresent(txtSuspAcct, 30);
        softAssert.assertEquals(txtSuspAcct.getText(), "Suspend user's account");
        basicActions.waitForElementToBePresent(txtResetPassw, 30);
        softAssert.assertEquals(txtResetPassw.getText(), "Reset user's password");
        softAssert.assertAll();
    }

    public void validateAccountStatus() {
        basicActions.waitForElementToBePresent(accountStatus, 30);
        softAssert.assertEquals(accountStatus.getText(), "Account Status: Active");
        softAssert.assertAll();
    }

    public void selectResetandSave() {
        basicActions.waitForElementToBePresent(selectResetPassword, 30);
        selectResetPassword.click();
        save.click();
    }

    public void verifyuccessmessage() {
        basicActions.waitForElementToBePresent(successfulUpdatemessage, 50);
        softAssert.assertEquals(successfulUpdatemessage.getText(), "Successful Update");
        softAssert.assertAll();
    }

    public void selectCheckbox() {
        basicActions.waitForElementToBePresent(selectsuspendoractiavteaccount, 30);
        selectsuspendoractiavteaccount.click();
        save.click();
    }

    public void validatePMDashboardContainerTitles(String profile, String contract, String accountActivity, String clientInfo, String organizationInfo) {
        basicActions.waitForElementToBePresent(profileTitle, 30);
        softAssert.assertEquals(profileTitle.getText(), profile);
        softAssert.assertEquals(contractTitle.getText(), contract);
        softAssert.assertEquals(accountActivityTitle.getText(), accountActivity);
        softAssert.assertEquals(clientTitle.getText(), clientInfo);
        softAssert.assertEquals(organizationTitle.getText(), organizationInfo);
        softAssert.assertAll();
    }

    public void validateTitleRowClientInformation(String fNameClient, String lNameClient, String eClient, String phClient) {
        basicActions.waitForElementToBePresent(firstNameClient, 30);
        softAssert.assertEquals(firstNameClient.getText(), fNameClient);
        softAssert.assertEquals(lastNameClient.getText(), lNameClient);
        softAssert.assertEquals(emailClient.getText(), eClient);
        softAssert.assertEquals(phoneClient.getText(), phClient);
        softAssert.assertAll();
    }

    public void validateFirstRowClientData(String clientInfo, String firstClientSTG, String firstClientQA) {
        basicActions.waitForElementToBePresent(clientTitle, 30);
        softAssert.assertEquals(clientTitle.getText(), clientInfo);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(firstRowClientData.getText(), firstClientSTG);
        } else {
            softAssert.assertEquals(firstRowClientData.getText(), firstClientQA);
        }
        softAssert.assertAll();
    }

    public void validateSecondRowClientData(String clientInfo, String secondClientSTG, String secondClientQA) {
        basicActions.waitForElementToBePresent(clientTitle, 30);
        softAssert.assertEquals(clientTitle.getText(), clientInfo);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(secondRowClientData.getText(), secondClientSTG);
        } else {
            softAssert.assertEquals(secondRowClientData.getText(), secondClientQA);
        }
        softAssert.assertAll();
    }

    public void verifyTitleAndDefaultYear(String eligTitle, String eligYear) {
        basicActions.waitForElementToBePresent(eligibilityTitle, 10);
        softAssert.assertEquals(eligibilityTitle.getText(), eligTitle);
        softAssert.assertEquals(eligibilityYear.getText(), eligYear);
        softAssert.assertAll();
    }

    public void clickEligibilityButtonOnIndividualDashboard() {
        basicActions.waitForElementToBeClickable(viewDetailedEligibility, 30);
        basicActions.click(viewDetailedEligibility);
        basicActions.switchtoactiveTab();
    }

    public void verifyEligibilityContainer(String tableName) {
        basicActions.wait(5000);
        basicActions.waitForElementToBePresent(applicationId, 50);
        softAssert.assertEquals(householdTableTitle.getText(), tableName);
        softAssert.assertAll();
        WebElement table = basicActions.getDriver().findElement(By.xpath("//table[@class='elig-summary-table']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        String[][] QAExpectedData = {
                {"Submitted on:", "06/22/2023 1:53 PM"},
                {"Application Purpose:", "INITIAL_DETERMINATION"},
                {"Total APTC:", "N/A"},
                {"ARP Eligibility:", "No"},
                {"Quick Submit:", "No"}
        };
        String[][] STGExpectedData = {
                {"Submitted on:", "06/06/2024 9:44 AM"},
                {"Application Purpose:", "UPDATE_DETERMINATION"},
                {"Total APTC:", "$263.61/month"},
                {"ARP Eligibility:", "No"},
                {"Quick Submit:", "No"},
        };
        String[][] expectedData = (SharedData.getEnv().equals("qa")) ? QAExpectedData : STGExpectedData;
        for (int i = 0; i < expectedData.length; i++) {
            List<WebElement> cells = rows.get(i + 1).findElements(By.tagName("td"));
            for (int j = 0; j < expectedData[i].length; j++) {
                String cellText = cells.get(j).getText();
                System.out.println(cellText);
                softAssert.assertEquals(cellText, expectedData[i][j], "Mismatch found in row " + (i + 1) + ", column " + (j + 1));
            }
        }
        softAssert.assertAll();
}

    public void verifyEligibilityContainerMultipleHouseholds() {
        basicActions.waitForElementToBePresent(householdTableTitle, 30);
        softAssert.assertTrue(householdTableTitle.isDisplayed());
        softAssert.assertAll();
        WebElement table = basicActions.getDriver().findElement(By.xpath("//table[@class='elig-summary-table']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

            String[][] QAExpectedData = {
                    {"Submitted on:", "12/12/2024 11:36 AM"},
                    {"Application Purpose:", "INITIAL_DETERMINATION"},
                    {"Total APTC:", "$533.32/month"},
                    {"ARP Eligibility:", "No"},
                    {"Quick Submit:", "No"}
            };
            String[][] STGExpectedData = {
                    {"Submitted on:", "04/07/2023 12:33 PM"},
                    {"Application Purpose:", "QUALIFIED_LIFE_CHANGE_EVENT"},
                    {"Total APTC:", "$710.84/month"},
                    {"ARP Eligibility:", "No"},
                    {"Quick Submit:", "No"},
            };
        String[][] expectedData = (SharedData.getEnv().equals("qa")) ? QAExpectedData : STGExpectedData;
        for (int i = 0; i < expectedData.length; i++) {
                List<WebElement> cells = rows.get(i + 1).findElements(By.tagName("td"));
                for (int j = 0; j < expectedData[i].length; j++) {
                String cellText = cells.get(j).getText();
                System.out.println(cellText);
                softAssert.assertEquals(cellText, expectedData[i][j], "Mismatch found in row " + (i + 1) + ", column " + (j + 1));
            }
       }
               softAssert.assertAll();

    }
    public void validateLCEColumns(String lceTitle, String event, String members, String date) {
        basicActions.waitForElementToBePresent(lceTableTitle, 30);
        softAssert.assertEquals(lceTableTitle.getText(), lceTitle);
        softAssert.assertEquals(lceEvent.getText(), event);
        softAssert.assertEquals(membersImpacted.getText(), members);
        softAssert.assertEquals(lceDate.getText(), date);
        softAssert.assertAll();
    }

    public void verifyMemberTableColumns(String memberLevelTitleData, String member, String csr, String relationship, String tax) {
        basicActions.waitForElementToBePresent(memberTableTitle, 30);
        softAssert.assertEquals(memberTableTitle.getText(), memberLevelTitleData);
        softAssert.assertEquals(memberTitle.getText(), member);
        softAssert.assertEquals(csrTitle.getText(), csr);
        softAssert.assertEquals(relationshipTitle.getText(), relationship);
        softAssert.assertEquals(taxTitle.getText(), tax);
        softAssert.assertAll();
    }

    public void validateLCEdata(String eventSTG, String dateSTG, String eventQA, String dateQA) {
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(lceEventData.getText(), eventSTG);
            softAssert.assertEquals(lceDateData.getText(), dateSTG);
        } else {
            softAssert.assertEquals(lceEventData.getText(), eventQA);
            softAssert.assertEquals(lceDateData.getText(), dateQA);
            softAssert.assertAll();
        }
    }

    public void checkMessageIsDisplayed(String textMessage) {
        basicActions.waitForElementToBePresent(NoData, 10);
        softAssert.assertEquals(NoData.getText(), textMessage);
        softAssert.assertAll();
    }

    public void selectHousehold() {
        basicActions.waitForElementToBeClickable(householdDropdown, 20);
        basicActions.click(householdDropdown);
        basicActions.waitForElementToBePresent(householdSecond, 50);
        householdSecond.click();
    }

    public void validateMemberLevelData(String memberSTG, String relationshipSTG, String taxSTG, String memberQA, String relationshipQA, String taxQA) {
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(member.getText(), memberSTG);
            softAssert.assertEquals(relationship.getText(), relationshipSTG);
            softAssert.assertEquals(tax.getText(), taxSTG);
        } else {
            softAssert.assertEquals(member.getText(), memberQA);
            softAssert.assertEquals(relationship.getText(), relationshipQA);
            softAssert.assertEquals(tax.getText(), taxQA);
            softAssert.assertAll();
        }
    }

    public void VerifyIndividualAccountSummary() {
        basicActions.waitForElementToBePresent(accountSummaryTitle,100);
        softAssert.assertEquals(accountSummaryTitle.getText(),"Account Summary");
        basicActions.waitForElementToBePresent(memberFullName,60);
        if (SharedData.getEnv().equals("qa")){
            softAssert.assertEquals(membername.getText(),"Username:MGC4testing+atzgwcwwiTest@outlook.com");
            softAssert.assertEquals(memberfullName.getText(),"Full Name:srptcijuoyTestMember atzgwcwwiTest");
            softAssert.assertEquals(txtMember1QA.getText(),"srptcijuoyTestMember");
            softAssert.assertEquals(txtMember2QA.getText(),"akjcqruqnxhfxfgookhl");
            softAssert.assertEquals(txtPrimaryRelationAgeQA.getText(),"SELF / Age 40");
            softAssert.assertEquals(txtSecondaryRelationAgeQA.getText(),"WIFE / Age 45");
            softAssert.assertTrue(txtMember3QA.isEmpty(),"Third member is displayed when it should not be.");
            softAssert.assertTrue(txtThirdRelationAgeQA.isEmpty(),"Third member age is displayed when it should not be.");
            softAssert.assertAll();
        }else{
            softAssert.assertEquals(membername.getText(),"Username:judejewel@test.com");
            softAssert.assertEquals(memberfullName.getText(),"Full Name:Jude Jewel");
            softAssert.assertEquals(txtMember1QA.getText(),"Jude");
            softAssert.assertEquals(txtMember2QA.getText(),"Jenny");
            softAssert.assertEquals(txtPrimaryRelationAgeQA.getText(),"SELF / Age 45");
            softAssert.assertEquals(txtSecondaryRelationAgeQA.getText(),"SON / Age 17");
            softAssert.assertTrue(txtMember3QA.isEmpty(),"Third member is displayed when it should not be.");
            softAssert.assertTrue(txtThirdRelationAgeQA.isEmpty(),"Third member age is displayed when it should not be.");
        }
        softAssert.assertAll();
    }

    public void VerifyCocoIndividualAccountSummary(){
        basicActions.waitForElementToBePresent(accountSummaryTitle,100);
        softAssert.assertEquals(accountSummaryTitle.getText(),"Account Summary");
        basicActions.waitForElementToBePresent(memberFullName,60);
        if (SharedData.getEnv().equals("qa")){
            softAssert.assertEquals(membername.getText(),"Username:MGC4Test+apindzmqbhflapeliz@gmail.com");
            softAssert.assertEquals(memberfullName.getText(),"Full Name:apelizafbrl apindzmqbhfl");
            softAssert.assertEquals(txtMember1QA.getText(),"apelizafbrl");
            softAssert.assertEquals(txtMember2QA.getText(),"test");
            softAssert.assertEquals(txtPrimaryRelationAgeQA.getText(),"SELF / Age 38");
            softAssert.assertEquals(txtSecondaryRelationAgeQA.getText(),"SPOUSE / Age 1");
            softAssert.assertTrue(txtMember3QA.isEmpty(),"Third member is displayed when it should not be.");
            softAssert.assertTrue(txtThirdRelationAgeQA.isEmpty(),"Third member age is displayed when it should not be.");
            softAssert.assertAll();
        }else{
            softAssert.assertEquals(membername.getText(),"Username:MGC4Test+apindkhkbtgkapeliz@gmail.com");
            softAssert.assertEquals(memberfullName.getText(),"Full Name:apelizabmum apindkhkbtgk");
            softAssert.assertEquals(txtMember1QA.getText(),"apelizabmum");
            softAssert.assertEquals(txtMember2QA.getText(),"FrVQbD");
            softAssert.assertEquals(txtPrimaryRelationAgeQA.getText(),"SELF / Age 34");
            softAssert.assertEquals(txtSecondaryRelationAgeQA.getText(),"SPOUSE / Age 33");
            softAssert.assertTrue(txtMember3QA.isEmpty(),"Third member is displayed when it should not be.");
            softAssert.assertTrue(txtThirdRelationAgeQA.isEmpty(),"Third member age is displayed when it should not be.");
        }
        softAssert.assertAll();
    }
    public void validateCoCoSelectedMemberData(List<Map<String, String>> selectedMemberData){
        basicActions.switchToParentPage("C4HCO Admin Portal");

        basicActions.waitForElementToBePresent(selectedMemberLabel, 300);
        softAssert.assertTrue(selectedMemberLabel.isDisplayed());

        String fullNameData = null;
        String userNameData = null;
        String memberPhoneData = null;
        String memberEmailData = null;
        String memberDobData = null;
        String memberAddressData = null;

        if (SharedData.getEnv().equals("staging")) {
            fullNameData = selectedMemberData.get(0).get("staging full name");
            userNameData = selectedMemberData.get(0).get("staging user name");
            memberPhoneData = selectedMemberData.get(0).get("staging member phone");
            memberEmailData = selectedMemberData.get(0).get("staging member email");
            memberDobData = selectedMemberData.get(0).get("staging member dob");
            memberAddressData = selectedMemberData.get(0).get("staging member address");
        }else {
            fullNameData = selectedMemberData.get(0).get("qa full name");
            userNameData = selectedMemberData.get(0).get("qa user name");
            memberPhoneData = selectedMemberData.get(0).get("qa member phone");
            memberEmailData = selectedMemberData.get(0).get("qa member email");
            memberDobData = selectedMemberData.get(0).get("qa member dob");
            memberAddressData = selectedMemberData.get(0).get("qa member address");
            }
        softAssert.assertEquals(memberFullName.getText(), fullNameData);
        softAssert.assertEquals(userName.getText(), userNameData);
        softAssert.assertEquals(memberPhone.getText(), memberPhoneData);
        softAssert.assertEquals(memberEmail.getText(), memberEmailData);
        softAssert.assertEquals(memberDob.getText(), memberDobData);
        softAssert.assertEquals(memberAddress.getText(), memberAddressData);
        softAssert.assertAll();
    }
    public void validateAccountSuspended() {
        basicActions.waitForElementToBePresent(accountStatus, 30);
        softAssert.assertEquals(suspended.getText(), "Account Status: Suspended");
    }
    public void validateAccountPasswordReset() {
        basicActions.waitForElementToBePresent(accountStatus, 30);
        softAssert.assertEquals(passwordReset.getText(), "Account Status: Password Reset");
        softAssert.assertAll();
    }
    public void validateCoCoDashboardContainerTitles(String PlansContainer, String summaryContainer, String reportsContainer) {
        basicActions.waitForElementToBePresent(plansTitle, 30);
        softAssert.assertEquals(plansTitle.getText(), PlansContainer);
        softAssert.assertEquals(summaryTitle.getText(), summaryContainer);
         softAssert.assertEquals(reportsTitle.getText(), reportsContainer);
        softAssert.assertAll();
    }

    public void VerifyOriginalSidebarDetails() {
        basicActions.waitForElementToBePresent(selectedMember, 30);
        verifyFullName();
        verifyUserName();
        verifyPhoneNumber();
        verifyEmail();
        verifyDOB();
        verifyResidentailAddress();
        softAssert.assertAll();
    }

    private void verifyResidentailAddress() {
        softAssert.assertEquals(selectedMemberLabelTxt.get(5).getText(), "Residential Address:", "Label not match");
        softAssert.assertTrue(selectedMemberDataTxt.get(5).isDisplayed());
        String AddressLine1 =  SharedData.getPrimaryMember().getResAddress().getAddressLine1();
        String AddressCounty =  SharedData.getPrimaryMember().getResAddress().getAddressCity();
        String AddressState =  SharedData.getPrimaryMember().getResAddress().getAddressState();
        String AddressZipcode =  SharedData.getPrimaryMember().getResAddress().getAddressZipcode();
        String ResAddress = AddressLine1 +"\n"+AddressCounty +", "+AddressState +" "+AddressZipcode ;
        softAssert.assertEquals(selectedMemberDataTxt.get(5).getText(),ResAddress, "Residential Address name not match");
    }

    private void verifyDOB() {
        softAssert.assertEquals(selectedMemberLabelTxt.get(4).getText(), "Date of Birth:", "Label not match");
        softAssert.assertTrue(selectedMemberDataTxt.get(4).isDisplayed());
        softAssert.assertEquals(selectedMemberDataTxt.get(4).getText(), basicActions.changeDateFormat(SharedData.getPrimaryMember().getDob(),
                "MMddyyyy", "MM/dd/yyyy"), "DOB did not match!");
    }

    private void verifyEmail() {
        softAssert.assertEquals(selectedMemberLabelTxt.get(3).getText(), "Email:", "Email Label not match");
        softAssert.assertTrue(selectedMemberDataTxt.get(3).isDisplayed());
        softAssert.assertEquals(selectedMemberDataTxt.get(3).getText(), SharedData.getPrimaryMember().getEmailId(), "Email not match");
    }

    private void verifyPhoneNumber() {
        String formatedPhoneNumber = SharedData.getPrimaryMember().getPhoneNumber().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
        softAssert.assertEquals(selectedMemberLabelTxt.get(2).getText(), "Phone Number:", "Phone Number Label not match");
        softAssert.assertTrue(selectedMemberDataTxt.get(2).isDisplayed());
        softAssert.assertEquals(selectedMemberDataTxt.get(2).getText(),formatedPhoneNumber, "Phone Number not match");
    }

    public void verifyUserName() {
        basicActions.waitForElementListToBePresent(selectedMemberLabelTxt,30);
        softAssert.assertEquals(selectedMemberLabelTxt.get(1).getText(), "Username:", "Username Label not match");
        softAssert.assertTrue(selectedMemberDataTxt.get(1).isDisplayed());
        if(SharedData.getPrimaryMember().getIncorrectEmail() != null){
            softAssert.assertEquals(selectedMemberDataTxt.get(1).getText(), SharedData.getPrimaryMember().getIncorrectEmail() , "Username not match");
        }
        else {
            softAssert.assertEquals(selectedMemberDataTxt.get(1).getText(), SharedData.getPrimaryMember().getEmailId() , "Username not match");
        }
        softAssert.assertAll();
    }

    private void verifyFullName() {
        softAssert.assertEquals(selectedMemberLabelTxt.get(0).getText(), "Full Name:", "Full Name Label not match");
        softAssert.assertTrue(selectedMemberDataTxt.get(0).isDisplayed());
        softAssert.assertEquals(selectedMemberDataTxt.get(0).getText(), SharedData.getPrimaryMember().getCompleteFullName(), "Full name not match");
    }

    public void clickManageAccountDetails() {
        basicActions.waitForElementToBeClickable(btnManageAccountDetails, 10);
        basicActions.click(btnManageAccountDetails);
        basicActions.switchtoactiveTab();
    }



    ////////////////////////////Plans Container//////////////////////////
    public void clickManagePlan() {
        basicActions.waitForElementToBeClickable(managePlanButton, 10);
        basicActions.click(managePlanButton);
        basicActions.switchtoactiveTab();
    }

    public void selectMedicalPlanYear(String planYear) {
        basicActions.waitForElementToBeClickable(dpdCurrentYearMP, 10);
        basicActions.scrollToElement(dpdCurrentYearMP);
        basicActions.selectValueFromDropdown(dpdCurrentYearMP, planYearSelectorOptions, planYear);
        basicActions.wait(50);
    }

    public void verifyPlanContainerNoActive() {
        basicActions.waitForElementToBePresent(managePlanButton, 60);
        softAssert.assertEquals("There is no active policy data.", noActivePolicyTxt.getText(), "Mismatch in There is no active policy data.");
        softAssert.assertEquals("Manage Plans", managePlanButton.getText(), "Mismatch in Manage Plans");
    }

}


