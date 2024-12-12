package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalIndividualDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages.AdminPortalIndividualDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;

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
    @Then("I validate data for Agency Summary: {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iValidateDataForAgencySummary(String name, String license, String thin, String agent, String email, String website, String phone, String preferredLanguage) {
        adminPortalIndividualDashboardPage.agencySummaryValidation(name, license, thin, agent, email, website, phone, preferredLanguage);
    }
    @Then("I click on manage plan button on admin portal Individual dashboard")
    public void iClickManagePlanButton() {
        adminPortalIndividualDashboardPage.clickManagePlan();
    }
    @And("I Validate the correct enrolled plans are displayed on admin portal individual page")
    public void iverifyPlanDetails(List<String> data) {
        adminPortalIndividualDashboardPage.verifyPlanDetails(data);
    }
    @Then("I validate Selected Member data on the far left side")
    public void iValidateSelectedMemberData() {
        adminPortalIndividualDashboardPage.validateSelectedMemberData();    }
    @And("I Verify Payload Information Container")
    public void iVerifyPayloadInformationContainer() {
        adminPortalIndividualDashboardPage.verifyPayloadsContainer();   }
    @Then("I verify the option in years displays")
    public void iVerifyYears() {
        adminPortalIndividualDashboardPage.verifyYears();   }
    @And("I verify container {string} and {string} is displayed")
    public void iVerifyContainerTitleAndDefaultYearIsDisplayed(String containerTitle, String defaultYear) {
        adminPortalIndividualDashboardPage.verifyContainerTitleAndDefaultYearIsDisplayed(containerTitle, defaultYear);  }
    @And("I verify Program Manager information Account Summary")
    public void iVerifyProgramManagerInformationAccountSummary() {
        adminPortalIndividualDashboardPage.VerifyProgramManagerInformationAccountSummary(); }
    @And("I validate all program manager dashboard container titles are displayed")
    public void iValidateProgramManagerDashboardContainerTitles() {
        adminPortalIndividualDashboardPage.validateProgramManagerDashboardContainerTitles();    }
    @And("I verify Program Manager contract status")
    public void iVerifyProgramManagerContractStatus() {
        adminPortalIndividualDashboardPage.VerifyProgramManagerContractStatus(); }
    @And("I verify Program Manager Account Activity Container")
    public void iVerifyBrokerAccountActivityContainer() {
        adminPortalIndividualDashboardPage.VerifyProgramManagerAccountActivityContainer();  }
    @And("I Verify Program Manager Client Information : {string}")
    public void iVerifyBrokerClientInformationContainer(String text) {
        adminPortalIndividualDashboardPage.VerifyProgramManagerClientInformationContainer(text);    }
    @Then("I Verify organization Information Container {string} {string} or {string} {string}")
    public void iVerifyProgramManagerOrganizationInformation(String idSTG, String idQA, String nameSTG, String nameQA) {
        adminPortalIndividualDashboardPage.VerifyProgramManagerOrganizationInformation(idSTG, idQA, nameSTG, nameQA);  }

    @And("I click Go Back on admin portal program manager dashboard")
    public void iClickGoBackOnAdminPortalBrokerDashboard() {
        adminPortalIndividualDashboardPage.clickGoBackONAdminPortalProgramManager();    }
    @Then("I verify Renewal status label and data {string} is displayed or {string} is displayed")
    public void iVerifyStatusIsDisplayed(String containerStatusStaging, String containerStatusQa) {
        adminPortalIndividualDashboardPage.verifyStatusIsDisplayed(containerStatusStaging, containerStatusQa);        }
    @And("I validate {string} {string} as {string} and {string} {string} as {string}")
    public void iValidateMedicalAndDentalPlans(String renewalMedical, String medicalCoverage, String medPlanData, String renewalDental, String dentalCoverage, String dentPlanData) {
        adminPortalIndividualDashboardPage.validateMedicalAndDentalPlans(renewalMedical, medicalCoverage, medPlanData, renewalDental, dentalCoverage, dentPlanData);    }

    @And("I validate individual dashboard container titles: {string} {string} {string} {string} {string} {string} are displayed")
    public void iValidateIndividualDashboardContainerTitlesAreDisplayed(String PlansContainer,String summaryContainer ,String eligibilityContainer,String renewalsContainer,String reportsContainer,String payloadsContainer) {
        adminPortalIndividualDashboardPage.validateIndividualDashboardContainerTitles(PlansContainer,summaryContainer ,eligibilityContainer,renewalsContainer,reportsContainer,payloadsContainer);
    }
    @And("I select year {string} from Manage Plan container on Individual dashboard")
    public void iSelectMedicalPlanYear(String planYear) {
        adminPortalIndividualDashboardPage.selectMedicalPlanYear(planYear);
    }
    @And("I validate {string} {string} as {string}")
    public void iValidateMedicalPlan(String renewalMedical, String medicalCoverage, String medPlanData) {
        adminPortalIndividualDashboardPage.validateMedicalPlan(renewalMedical, medicalCoverage, medPlanData);
    }
    @Then("I verify Renewal status is displayed")
    public void iVerifyStatusIsDisplayed() {
        adminPortalIndividualDashboardPage.verifyStatusIsDisplayed();        }
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
        adminPortalIndividualDashboardPage.verifyStatusCanceledIsDisplayed(containerStatus);        }

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
        adminPortalIndividualDashboardPage.validateTitleRowClientInformation(fNameClient, lNameClient, eClient, phClient);  }

    @And("I validate {string} first row - first client data {string} or {string}")
    public void iValidateFirstRowClientData(String clientInfo, String firstClientSTG, String firstClientQA) {
        adminPortalIndividualDashboardPage.validateFirstRowClientData(clientInfo, firstClientSTG, firstClientQA);  }

    @And("I validate {string} second row - first client data {string} or {string}")
    public void iValidateSecondRowClientData(String clientInfo, String secondClientSTG, String secondClientQA) {
        adminPortalIndividualDashboardPage.validateSecondRowClientData(clientInfo, secondClientSTG, secondClientQA);  }

}

