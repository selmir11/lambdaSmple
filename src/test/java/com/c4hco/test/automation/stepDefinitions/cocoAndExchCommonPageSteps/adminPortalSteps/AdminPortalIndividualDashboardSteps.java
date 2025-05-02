package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages.AdminPortalIndividualDashboardPage;

import java.util.List;
import java.util.Map;

public class AdminPortalIndividualDashboardSteps {

    AdminPortalIndividualDashboardPage adminPortalIndividualDashboardPage = new AdminPortalIndividualDashboardPage(WebDriverManager.getDriver());

    @Then("I verify Reports container title")
    public void iVerifyContainerTitle() {
        adminPortalIndividualDashboardPage.verifyContainerTitle();
    }

    @Then("I click on view button for {string} report")
    public void iClickOnViewButtonForreport(String searchText) {
        adminPortalIndividualDashboardPage.viewReportLinks(searchText);
    }

    @Then("I verify Primary account holder and account number displays")
    public void iVerifyPrimaryAccountHolderDisplays() {
        adminPortalIndividualDashboardPage.verifyPrimaryHolder();
    }

    @And("I search for Agency using {string} {string} on Agency dashboard")
    public void iSearchForAgency(String agencyData, String type) {
        adminPortalIndividualDashboardPage.enterAgencyData(agencyData, type);
    }

    @Then("I verify Agency name and account number displays")
    public void iVerifyAgencyContainerTitle() {
        adminPortalIndividualDashboardPage.verifyAgencyContainerTitle();
    }

    @Then("I validate data for Agency Summary: {string} {string} {string} {string} {string} {string}")
    public void iValidateDataForAgencySummary(String name, String thin, String agent, String email, String website, String phone) {
        adminPortalIndividualDashboardPage.agencySummaryValidation(name, thin, agent, email, website, phone);
    }

    @Then("I validate Selected Member data on the far left side")
    public void iValidateSelectedMemberData() {
        adminPortalIndividualDashboardPage.validateSelectedMemberData();
    }

    @And("I Verify Payload Information Container")
    public void iVerifyPayloadInformationContainer() {
        adminPortalIndividualDashboardPage.verifyPayloadsContainer();
    }

    @Then("I verify the option in years displays")
    public void iVerifyYears() {
        adminPortalIndividualDashboardPage.verifyYears();
    }

    @And("I verify container {string} and {string} is displayed")
    public void iVerifyContainerTitleAndDefaultYearIsDisplayed(String containerTitle, String defaultYear) {
        adminPortalIndividualDashboardPage.verifyContainerTitleAndDefaultYearIsDisplayed(containerTitle, defaultYear);
    }

    @And("I verify Program Manager information Account Summary")
    public void iVerifyProgramManagerInformationAccountSummary() {
        adminPortalIndividualDashboardPage.VerifyProgramManagerInformationAccountSummary();
    }

    @And("I validate all program manager dashboard container titles are displayed")
    public void iValidateProgramManagerDashboardContainerTitles() {
        adminPortalIndividualDashboardPage.validateProgramManagerDashboardContainerTitles();
    }

    @And("I verify Program Manager contract status")
    public void iVerifyProgramManagerContractStatus() {
        adminPortalIndividualDashboardPage.VerifyProgramManagerContractStatus();
    }

    @And("I verify Program Manager Account Activity Container")
    public void iVerifyBrokerAccountActivityContainer() {
        adminPortalIndividualDashboardPage.VerifyProgramManagerAccountActivityContainer();
    }

    @And("I Verify Program Manager Client Information : {string}")
    public void iVerifyBrokerClientInformationContainer(String text) {
        adminPortalIndividualDashboardPage.VerifyProgramManagerClientInformationContainer(text);
    }

    @Then("I Verify organization Information Container {string} {string} or {string} {string}")
    public void iVerifyProgramManagerOrganizationInformation(String idSTG, String idQA, String nameSTG, String nameQA) {
        adminPortalIndividualDashboardPage.VerifyProgramManagerOrganizationInformation(idSTG, idQA, nameSTG, nameQA);
    }

    @And("I click Go Back on admin portal program manager dashboard")
    public void iClickGoBackOnAdminPortalBrokerDashboard() {
        adminPortalIndividualDashboardPage.clickGoBackONAdminPortalProgramManager();
    }

    @Then("I verify Renewal status label and data {string} is displayed or {string} is displayed")
    public void iVerifyStatusIsDisplayed(String containerStatusStaging, String containerStatusQa) {
        adminPortalIndividualDashboardPage.verifyStatusIsDisplayed(containerStatusStaging, containerStatusQa);
    }

    @And("I validate {string} {string} as {string} and {string} {string} as {string}")
    public void iValidateMedicalAndDentalPlans(String renewalMedical, String medicalCoverage, String medPlanData, String renewalDental, String dentalCoverage, String dentPlanData) {
        adminPortalIndividualDashboardPage.validateMedicalAndDentalPlans(renewalMedical, medicalCoverage, medPlanData, renewalDental, dentalCoverage, dentPlanData);
    }

    @And("I validate individual dashboard container titles: {string} {string} {string} {string} {string} {string} are displayed")
    public void iValidateIndividualDashboardContainerTitlesAreDisplayed(String PlansContainer, String summaryContainer, String eligibilityContainer, String renewalsContainer, String reportsContainer, String payloadsContainer) {
        adminPortalIndividualDashboardPage.validateIndividualDashboardContainerTitles(PlansContainer, summaryContainer, eligibilityContainer, renewalsContainer, reportsContainer, payloadsContainer);
    }

    @And("I validate {string} {string} as {string}")
    public void iValidateMedicalPlan(String renewalMedical, String medicalCoverage, String medPlanData) {
        adminPortalIndividualDashboardPage.validateMedicalPlan(renewalMedical, medicalCoverage, medPlanData);
    }

    @Then("I verify Renewal status is displayed")
    public void iVerifyStatusIsDisplayed() {
        adminPortalIndividualDashboardPage.verifyStatusIsDisplayed();
    }

    @And("I validate only {string} as {string} or {string}")
    public void iValidateMedicalOnlyPlan(String medicalCoverage, String medicalCoverageStg, String medicalCoverageQa) {
        adminPortalIndividualDashboardPage.validateMedicalOnlyPlan(medicalCoverage, medicalCoverageStg, medicalCoverageQa);
    }

    @And("I validate Dental plan only {string} as {string} or {string}")
    public void iValidateDentalOnlyPlans(String dentalCoverage, String dentalCoverageStg, String dentalCoverageQa) {
        adminPortalIndividualDashboardPage.validateDentalOnlyPlans(dentalCoverage, dentalCoverageStg, dentalCoverageQa);
    }

    @And("I verify No Renewal message displays")
    public void iVerifyNoRenewalMessage() {
        adminPortalIndividualDashboardPage.verifyMessageNoRenewal();
    }

    @Then("I verify reason for no renewal as Renewal Action: System Exclusion: OVER_25_DEPENDENT")
    public void iVerifyNoRenewalReason() {
        adminPortalIndividualDashboardPage.verifyNoRenewalReasonDependant();
    }

    @Then("I verify reason for no renewal where Renewal Action: OVER_29_CATASTROPHIC")
    public void iVerifyNoRenewalReasonOverAgeCatastrophic() {
        adminPortalIndividualDashboardPage.verifyNoRenewalReasonCatastrophic();
    }

    @Then("I verify reason for no renewal where Renewal Action: CUSTOMER_OPT_OUT")
    public void iVerifyNoRenewalReasonCustomerOptPut() {
        adminPortalIndividualDashboardPage.verifyNoRenewalReasonCustomerOptPut();
    }

    @Then("I verify reason for no renewal where Renewal Action: SYSTEM_CANCEL_DUE_TO_TERM")
    public void iVerifyNoRenewalReasonSystemCancel() {
        adminPortalIndividualDashboardPage.verifyNoRenewalReasonSystemCancel();
    }

    @Then("I verify Renewal status {string} is displayed")
    public void iVerifyCanceledStatusIsDisplayed(String containerStatus) {
        adminPortalIndividualDashboardPage.verifyStatusCanceledIsDisplayed(containerStatus);
    }

    @Then("I verify Account Access details")
    public void iVerifyAccountAccessDetails() {
        adminPortalIndividualDashboardPage.VerifyAccountAccessDetails();
    }

    @And("I verify Account status is active")
    public void iVerifyAccountStatusIsActive() {
        adminPortalIndividualDashboardPage.validateAccountStatus();
    }

    @When("I check on Reset user's password checkbox and click on save")
    public void iCheckOnResetUserSPasswordCheckboxAndClickOnSave() {
        adminPortalIndividualDashboardPage.selectResetandSave();
    }

    @Then("I verify success message is displaying")
    public void iVerifySuccessMessageIsDisplaying() {
        adminPortalIndividualDashboardPage.verifyuccessmessage();
    }

    @When("I check on checkbox account and click on save")
    public void iCheckOnCheckboxAccountAndClickOnSave() {
        adminPortalIndividualDashboardPage.selectCheckbox();
    }

    @And("I validate individual dashboard container titles: {string} {string} {string} {string} {string} are displayed")
    public void iValidatePMDashboardContainerTitlesAreDisplayed(String profile, String contract, String accountActivity, String clientInfo, String organizationInfo) {
        adminPortalIndividualDashboardPage.validatePMDashboardContainerTitles(profile, contract, accountActivity, clientInfo, organizationInfo);
    }

    @Then("I validate Client Information title row {string} {string} {string} {string}")
    public void iValidateTitleRowClientInformation(String fNameClient, String lNameClient, String eClient, String phClient) {
        adminPortalIndividualDashboardPage.validateTitleRowClientInformation(fNameClient, lNameClient, eClient, phClient);
    }

    @And("I validate {string} first row - first client data {string} or {string}")
    public void iValidateFirstRowClientData(String clientInfo, String firstClientSTG, String firstClientQA) {
        adminPortalIndividualDashboardPage.validateFirstRowClientData(clientInfo, firstClientSTG, firstClientQA);
    }

    @And("I validate {string} second row - first client data {string} or {string}")
    public void iValidateSecondRowClientData(String clientInfo, String secondClientSTG, String secondClientQA) {
        adminPortalIndividualDashboardPage.validateSecondRowClientData(clientInfo, secondClientSTG, secondClientQA);
    }

    @Then("I validate content from Account Summary Container")
    public void validateAccSummaryContainer() {
        adminPortalIndividualDashboardPage.validateAccSummaryContainer();
    }

    @And("I click {string} from account summary container")
    public void clickBtnOnAccSumm(String button) {
        adminPortalIndividualDashboardPage.clickBtnOnAccSummContainer(button);
    }
    @And("I check {string} table data")
    public void iCheckEligibilityTableData(String tableName) {
        adminPortalIndividualDashboardPage.verifyEligibilityContainer(tableName);
    }
    @And("I check Household level application and eligibility data table")
    public void iVerifyEligibilityContainerMultipleHouseholds() {
        adminPortalIndividualDashboardPage.verifyEligibilityContainerMultipleHouseholds();
    }
    @And("I click View Detailed Eligibility button on Individual dashboard")
    public void iClickEligibilityButtonOnIndividualDashboard() {
        adminPortalIndividualDashboardPage.clickEligibilityButtonOnIndividualDashboard();       }
    @And("I check {string} columns {string} {string} {string}")
    public void iValidateLCEColumns(String lceTitle, String event, String members, String date) {
        adminPortalIndividualDashboardPage.validateLCEColumns(lceTitle, event, members, date);  }
    @And("I check {string} {string} or {string} {string}")
    public void iValidateLCEdata(String eventSTG, String dateSTG, String eventQA, String dateQA) {
        adminPortalIndividualDashboardPage.validateLCEdata(eventSTG, dateSTG, eventQA, dateQA);  }
    @Then("I check message {string} is displayed")
    public void iCheckMessageIsDisplayed(String textMessage) {
        adminPortalIndividualDashboardPage.checkMessageIsDisplayed(textMessage);        }
    @And("I select tax household")
    public void iSelectTaxHousehold() {
        adminPortalIndividualDashboardPage.selectHousehold();       }
    @And("I check {string} columns {string} {string} {string} {string}")
    public void iValidateMemberColumns(String memberLevelTitleData, String member, String csr, String relationship, String tax) {
        adminPortalIndividualDashboardPage.verifyMemberTableColumns(memberLevelTitleData, member, csr, relationship, tax);  }
    @And("I check {string} {string} {string} or {string} {string} {string}")
    public void iValidateMemberLevelData(String memberSTG, String relationshipSTG, String taxSTG, String memberQA, String relationshipQA, String taxQA) {
        adminPortalIndividualDashboardPage.validateMemberLevelData(memberSTG, relationshipSTG, taxSTG, memberQA, relationshipQA, taxQA);  }

    @Then("I verify individual Account Summary details")
    public void iVerifyIndividualAccountSummaryDetails() {
        adminPortalIndividualDashboardPage.VerifyIndividualAccountSummary();
    }

    @Then("I verify coco individual Account Summary details")
    public void iVerifyCocoIndividualAccountSummaryDetails() {
        adminPortalIndividualDashboardPage.VerifyCocoIndividualAccountSummary();
    }
    @And("I validate CoCo Selected Member data on the far left side")
    public void iValidateCoCoSelectedMemberData(List<Map<String, String>> selectedMemberData) {
        adminPortalIndividualDashboardPage.validateCoCoSelectedMemberData(selectedMemberData);
    }
    @Then("I verify Account status is suspended")
    public void iValidateAccountSuspended() {
        adminPortalIndividualDashboardPage.validateAccountSuspended();
    }
    @And("I verify Account status is Password Reset")
    public void iValidateAccountPasswordReset() {
        adminPortalIndividualDashboardPage.validateAccountPasswordReset();
    }
    @And("I validate CoCo dashboard container titles: {string} {string} {string} are displayed")
    public void iValidateIndividualDashboardContainerTitlesAreDisplayed(String PlansContainer, String summaryContainer, String reportsContainer) {
        adminPortalIndividualDashboardPage.validateCoCoDashboardContainerTitles(PlansContainer, summaryContainer, reportsContainer);
    }

    @Then("I validate Selected Member label and member data on the far left side")
    public void iValidateSelectedMemberLabelAndMemberDataOnTheFarLeftSide() {
        adminPortalIndividualDashboardPage.VerifyOriginalSidebarDetails();
    }

    @Then("I click on manage account details button on admin portal Individual dashboard")
    public void iClickOnManageAccountDetailsButtonOnAdminPortalIndividualDashboard() {
        adminPortalIndividualDashboardPage.clickManageAccountDetails();
    }
    @Then("I validate user name on Selected Member data on the far left side")
    public void iValidateUserNameOnSelectedMemberDataOnTheFarLeftSide() {
        adminPortalIndividualDashboardPage.verifyUserName();
    }


    ////////////////////////////Plans Container//////////////////////////
    @Then("I click on manage plan button on admin portal Individual dashboard")
    public void iClickManagePlanButton() {
        adminPortalIndividualDashboardPage.clickManagePlan();
    }

    @And("I select year {string} from Manage Plan container on Individual dashboard")
    public void iSelectMedicalPlanYear(String planYear) {
        adminPortalIndividualDashboardPage.selectMedicalPlanYear(planYear);
    }

    @And("I verify Plan container with no active plan on the Individual dashboard")
    public void iVerifyPlanContainerNoActive() {adminPortalIndividualDashboardPage.verifyPlanContainerNoActive();}

    @Then("I verify color font format etc for elements of Account Summary container")
    public void iVerifyColorFontFormatEtcForElementsOfAccountSummaryContainer(List<String> pageTexts) {
        adminPortalIndividualDashboardPage.verifyColorFontFormatEtcForElementsOfAccountSummaryContainer(pageTexts);
    }

    @Then("I verify height width and color of line under each household members")
    public void iVerifyHeightWidthAndColorOfLineUnderEachHouseholdMembers() {
        adminPortalIndividualDashboardPage.verifyHeightWidthAndColorOfLineUnderEachHouseholdMembers();
    }
}

