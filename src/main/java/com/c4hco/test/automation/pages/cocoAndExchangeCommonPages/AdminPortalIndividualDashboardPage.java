package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.List;
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
    @FindBy(id = "Individual Dashboard-Manage Plans")
    WebElement managePlanButton;
    @FindBy(css = "div.medical-plan-container.plan-container-fill div.plan-info-container>div")
    WebElement medicalPlan;
    @FindBy(css = "div.dental-plan-container.plan-container-fill div.plan-info-container>div")
    WebElement dentalPlan;
    @FindBy(css = "div.manage-plans-title.header-2")
    WebElement managePlanHeader;
    @FindBy(css = "label[for='selected-member-checkbox']")
    WebElement selectedMember;
    @FindBy(css = "#full-name")
    WebElement memberFullName;
    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#phone-number")
    WebElement memberPhone;
    @FindBy(css = "#email-address")
    WebElement memberEmail;
    @FindBy(css = "#dob")
    WebElement memberDob;
    @FindBy(css = "body app-root div:nth-child(6)")
    WebElement memberAddress;
    @FindBy(xpath = "//p[normalize-space()='Plans']")
    WebElement plansTitle;
    @FindBy(css = "div[class='group-box summary-container'] p[class='group-title']")
    WebElement summaryTitle;
    @FindBy(xpath = "//p[normalize-space()='Eligibility']")
    WebElement eligibilityTitle;
    @FindBy(css = ".dashboardHeader-renewal")
    WebElement renewalsTitle;
    @FindBy(xpath = "//p[normalize-space()='Payloads']")
    WebElement payloadsTitle;
    @FindBy(css = ".dropdown")
    WebElement payloadsYears;
    @FindBy(css = ".subheader-planyear")
    WebElement renewalsYear;
    @FindBy(xpath = "//div[.='There is no Renewal data for this year']")
    WebElement noRenewalsText;
    @FindBy(xpath = "//td[@id='username']")
    WebElement pmUsername;
    @FindBy(xpath = "//input[@id='program-manager-email-input']")
    WebElement emailProgramManager;
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
    @FindBy(xpath = "//th[normalize-space()='First Name']")
    WebElement clientFirstName;
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
    @FindBy(css = ".drop-down-option.drop-down-option-selected")
    WebElement dpdCurrentYearMP;
    @FindBy(css = "#groupBox1 > app-plan-year-dropdown > div")
    List<WebElement> planYearSelectorOptions;
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
            default: throw new IllegalArgumentException("Invalid header option : " + agencyData);
        }
    }

    public void verifyContainerTitle() {
        basicActions.waitForElementToBePresent(reportsTitle, 20);
        softAssert.assertTrue(reportsTitle.isDisplayed());
        softAssert.assertAll();    }
    public void viewReportLinks(String searchText) {
        basicActions.waitForElementListToBePresentWithRetries(reportViewButtons, 60);
        WebElement viewButton = basicActions.getDriver().findElement(By.xpath("//span[contains(normalize-space(), '" + searchText + "')]//following::span[1]"));
        viewButton.click();
        basicActions.switchtoactiveTab();    }
    public void verifyPrimaryHolder() {
        basicActions.waitForElementToBePresent(memberPrimary, 10);
        softAssert.assertTrue(memberPrimary.isDisplayed());
        basicActions.waitForElementToBePresent(memberAcctId, 10);
        softAssert.assertTrue(memberAcctId.isDisplayed());
        softAssert.assertAll();    }
    public void verifyAgencyContainerTitle() {
        basicActions.waitForElementToBePresent(agencyContainerTitle, 10);
        softAssert.assertTrue(agencyContainerTitle.isDisplayed());
        basicActions.waitForElementToBePresent(memberAcctId, 10);
        softAssert.assertTrue(memberAcctId.isDisplayed());
        softAssert.assertAll();    }
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

    public void clickManagePlan() {
        basicActions.waitForElementToBeClickable(managePlanButton, 10);
        basicActions.click(managePlanButton);
        basicActions.switchtoactiveTab();
    }
    public void verifyPlanDetails(List<String> data) {
        basicActions.waitForElementToBePresent(managePlanHeader, 20);
        softAssert.assertEquals(managePlanHeader.getText(), data.get(0));
        basicActions.waitForElementToBePresent(medicalPlan, 20);
        softAssert.assertEquals(medicalPlan.getText(), data.get(1));
        basicActions.waitForElementToBePresent(dentalPlan, 20);
        softAssert.assertEquals(dentalPlan.getText(), data.get(2));
        softAssert.assertAll();    }
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
        softAssert.assertAll();    }
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
        softAssert.assertAll();    }
    public void verifyContainerTitleAndDefaultYearIsDisplayed(String containerTitle, String defaultYear) {
        basicActions.waitForElementToBePresent(renewalsTitle, 10);
        softAssert.assertEquals(renewalsTitle.getText(), containerTitle);
        softAssert.assertEquals(renewalsYear.getText(), defaultYear);
        softAssert.assertAll();    }
    public void VerifyProgramManagerInformationAccountSummary() {
        basicActions.waitForElementToBePresent(pmUsername, 20);
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(pmUsername.getText(), "profile@test.com");
            softAssert.assertEquals(pmPhone.getText(), "333-333-3333 ext12345");
        } else {
            softAssert.assertEquals(pmUsername.getText(), "c4assistorportal+d0GLweQ7R@gmail.com");
            softAssert.assertEquals(pmPhone.getText(), "236-521-3426");
        }
        softAssert.assertAll();    }
    public void validateProgramManagerDashboardContainerTitles() {
        basicActions.waitForElementToBePresent(profileSummary, 30);
        softAssert.assertTrue(profileSummary.isDisplayed());
        softAssert.assertEquals(contractInfo.getText(), "Contract Information");
        softAssert.assertEquals(activityContainer.getText(), "Account Activity Report");
        softAssert.assertEquals(clientContainer.getText(), "Client Information");
        softAssert.assertEquals(organizationContainer.getText(), "Organization Information");
        softAssert.assertAll();    }
    public void VerifyProgramManagerContractStatus() {
        softAssert.assertEquals(contractStatus.getText(), "Contract Status: APPROVED");
        softAssert.assertEquals(manageContract.getText(), "Manage Contract");
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(contractStatus.getText(), "Contract Status: APPROVED");
        } else {
        softAssert.assertEquals(contractStatus.getText(), "Contract Status: APPROVED");
        }
        softAssert.assertAll();    }
    public void VerifyProgramManagerAccountActivityContainer() {
        basicActions.waitForElementToBePresent(viewReportButton, 30);
        softAssert.assertEquals(viewReportButton.getText(), "View Report");
        softAssert.assertAll(); }
    public void VerifyProgramManagerClientInformationContainer(String text) {
        basicActions.waitForElementToBePresent(noClients, 20);
        softAssert.assertTrue(noClients.isDisplayed());
        softAssert.assertEquals(noClients.getText(), text);
        softAssert.assertAll();    }
    public void VerifyProgramManagerOrganizationInformation() {
        softAssert.assertEquals(lblGroupID.getText(), "Organization Group ID:");
        softAssert.assertEquals(groupID.getText(), "75509083");
        softAssert.assertEquals(lablOrgName.getText(), "Organization Name:");
        softAssert.assertEquals(orgName.getText(), "aphsccbfxfotjudmvlafzowdjfb");
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(groupID.getText(), "130474819");
            softAssert.assertEquals(orgName.getText(), "profiletest");
        } else {
            softAssert.assertEquals(groupID.getText(), "60288219");
            softAssert.assertEquals(orgName.getText(), "apdrhhfmqdupyqdgcpgrveupznk");
        }
            softAssert.assertAll(); }
    public void clickGoBackONAdminPortalProgramManager() {
        basicActions.waitForElementToBePresent(goBack, 20);
        goBack.click();    }
    public void verifyStatusIsDisplayed(String containerStatusStaging, String containerStatusQa) {
        basicActions.waitForElementToBePresent(renewalStatusAnyEnvironment, 10);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(renewalStatusAnyEnvironment.getText(), containerStatusStaging);
        }else{
        softAssert.assertEquals(renewalStatusAnyEnvironment.getText(), containerStatusQa);
        }
        softAssert.assertAll();    }
    public void validateMedicalAndDentalPlans(String renewalMedical, String medicalCoverage, String medPlanData, String renewalDent, String dentalCoverage, String dentPlanData) {
        basicActions.waitForElementToBePresent(renewalMed, 10);
        softAssert.assertEquals(renewalMed.getText(), renewalMedical);
        softAssert.assertEquals(renewalMedCoverage.getText(), medicalCoverage);
        softAssert.assertEquals(coverageMedPlan.getText(), medPlanData);
        softAssert.assertEquals(renewalDental.getText(), renewalDent);
        softAssert.assertEquals(renewalDentalCoverage.getText(), dentalCoverage);
        softAssert.assertEquals(coverageDentalPlan.getText(), dentPlanData);
        softAssert.assertAll();    }
    public void selectMedicalPlanYear(String planYear) {
        basicActions.waitForElementToBeClickable(dpdCurrentYearMP, 10);
        basicActions.scrollToElement(dpdCurrentYearMP);
        dpdCurrentYearMP.click();
        basicActions.selectValueFromDropdown(dpdCurrentYearMP, planYearSelectorOptions, planYear);
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
        softAssert.assertAll();    }
    public void validateMedicalOnlyPlan(String medicalCoverage, String medicalCoverageStg, String medicalCoverageQa) {
        basicActions.waitForElementToBePresent(renewalMedCoverage, 10);
        softAssert.assertEquals(renewalMedCoverage.getText(), medicalCoverage);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(coverageMedPlan.getText(), medicalCoverageStg);
        }else{
            softAssert.assertEquals(coverageMedPlan.getText(), medicalCoverageQa);
        }
        softAssert.assertAll();    }
    public void validateDentalOnlyPlans(String dentalCoverage, String dentalCoverageStg, String dentalCoverageQa) {
        basicActions.waitForElementToBePresent(renewalDental, 10);
        softAssert.assertEquals(renewalDentalCoverage.getText(), dentalCoverage);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(coverageDentalPlan.getText(), dentalCoverageStg);
        }else {
            softAssert.assertEquals(coverageDentalPlan.getText(), dentalCoverageQa);
        }
        softAssert.assertAll(); }
    public void verifyMessageNoRenewal() {
        basicActions.waitForElementToBePresent(renewalsMessage, 20);
        softAssert.assertTrue(renewalsMessage.isDisplayed());
        softAssert.assertAll();     }
    public void verifyNoRenewalReasonDependant() {
        basicActions.waitForElementToBePresent(noRenewalReason, 10);
        softAssert.assertEquals(noRenewalReason.getText(), "Account is not eligible for Renewal this year.\n" +
                "\n" +
                "Renewal Action: System Exclusion: OVER_25_DEPENDENT");
        softAssert.assertAll();     }
    public void verifyNoRenewalReasonCatastrophic() {
        basicActions.waitForElementToBePresent(noRenewalReason, 10);
        softAssert.assertEquals(noRenewalReason.getText(), "Account is not eligible for Renewal this year.\n" +
                "\n" +
                "Renewal Action: System Exclusion: OVER_29_CATASTROPHIC");
        softAssert.assertAll();     }
    public void verifyNoRenewalReasonCustomerOptPut() {
        basicActions.waitForElementToBePresent(cancelledReason, 10);
        softAssert.assertEquals(cancelledReason.getText(), "Renewal Action: CUSTOMER_OPT_OUT");
        softAssert.assertAll();     }
    public void verifyNoRenewalReasonSystemCancel() {
        basicActions.waitForElementToBePresent(noRenewalReason, 10);
        softAssert.assertEquals(cancelledReason.getText(), "Renewal Action: SYSTEM_CANCEL_DUE_TO_TERM");
        softAssert.assertEquals(noRenewalReason.getText(), "Renewal Status: CANCELED");
        softAssert.assertAll();     }
    public void verifyStatusCanceledIsDisplayed(String status) {
        basicActions.waitForElementToBePresent(renewalCanceled, 10);
        softAssert.assertEquals(renewalCanceled.getText(), status);
        softAssert.assertAll();    }
    public void validatePMDashboardContainerTitles(String profile, String contract, String accountActivity, String clientInfo, String organizationInfo) {
        basicActions.waitForElementToBePresent(profileTitle, 30);
        softAssert.assertEquals(profileTitle.getText(), profile);
        softAssert.assertEquals(contractTitle.getText(), contract);
        softAssert.assertEquals(accountActivityTitle.getText(), accountActivity);
        softAssert.assertEquals(clientTitle.getText(), clientInfo);
        softAssert.assertEquals(organizationTitle.getText(), organizationInfo);
        softAssert.assertAll();     }
    public void validateTitleRowClientInformation(String fNameClient, String lNameClient, String eClient, String phClient) {
        basicActions.waitForElementToBePresent(firstNameClient, 30);
        softAssert.assertEquals(firstNameClient.getText(), fNameClient);
        softAssert.assertEquals(lastNameClient.getText(), lNameClient);
        softAssert.assertEquals(emailClient.getText(), eClient);
        softAssert.assertEquals(phoneClient.getText(), phClient);
        softAssert.assertAll();     }
    public void validateFirstRowClientData(String clientInfo, String firstClientSTG, String firstClientQA) {
        basicActions.waitForElementToBePresent(clientTitle, 30);
        softAssert.assertEquals(clientTitle.getText(), clientInfo);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(firstRowClientData.getText(), firstClientSTG);
        }else{
            softAssert.assertEquals(firstRowClientData.getText(), firstClientQA);
        }
        softAssert.assertAll();     }
    public void validateSecondRowClientData(String clientInfo, String secondClientSTG, String secondClientQA) {
        basicActions.waitForElementToBePresent(clientTitle, 30);
        softAssert.assertEquals(clientTitle.getText(), clientInfo);
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(secondRowClientData.getText(), secondClientSTG);
        }else{
            softAssert.assertEquals(secondRowClientData.getText(), secondClientQA);
        }
        softAssert.assertAll();     }
}

