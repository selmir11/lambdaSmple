package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ManagePlans.AdminPortalManagePlansPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class AdminPortalManagePlansSteps {

    AdminPortalManagePlansPage adminPortalManagePlansPage = new AdminPortalManagePlansPage(WebDriverManager.getDriver());


    @Then("I validate blue bar on Manage page")
    public void iValidateBluBar() {
        adminPortalManagePlansPage.validateBluBar();
    }

    @And("I validate title and labels on Manage page")
    public void iContainerTitleLabels() {
        adminPortalManagePlansPage.containerTitleLabels();      }

    @Then("I check default year displays")
    public void iCheckDefaultCurrentYear() {
        adminPortalManagePlansPage.checkDefaultCurrentYear();       }

    @Then("I verify both buttons Medical and Dental is checked")
    public void iVerifyButtonsCheckedBoth() {
        adminPortalManagePlansPage.verifyButtonsCheckedBoth();
    }

    @And("I validate buttons displayed on Manage page")
    public void iResetMakeChangeButtonsDisplayed() {
        adminPortalManagePlansPage.resetMakeChangeButtonsDisplayed();
    }
    @And("I validate {string} medical button displays on Manage page")
    public void iVerifySaveButtonDisplayed(String saveMed) {
        adminPortalManagePlansPage.verifySaveButtonDisplayed(saveMed);      }
    @Then("I click Make Changes Medical button")
    public void iClickMakeChangesMedical() {
        adminPortalManagePlansPage.clickMakeChangesMedical();
    }
    @And("I click Reset Changes Medical")
    public void iClickResetChangesMedical() {
        adminPortalManagePlansPage.clickResetChangesMedical();      }
    @Then("I click Make Changes Dental button")
    public void iClickMakeChangesDental() {
        adminPortalManagePlansPage.clickMakeChangesDental();
    }
    @And("I validate {string} dental button displays on Manage page")
    public void iVerifySaveDentalButtonDisplayed(String save) {
        adminPortalManagePlansPage.verifySaveDentalButtonDisplayed(save);
    }
    @And("I click Reset Changes Dental")
    public void iClickResetChangesDental() {
        adminPortalManagePlansPage.clickResetChangesDental();      }
    @Then("I validate medical and dental buttons does not display on Manage page")
    public void iValidateChangeButtonsNotDisplay() {
        adminPortalManagePlansPage.validateChangeButtonsNotDisplay();       }
    @And("I verify Medical button checked")
    public void iVerifyMedicalButtonChecked() {
        adminPortalManagePlansPage.verifyMedicalButtonChecked();        }
    @And("I validate buttons displayed on CoCo Manage page")
    public void iResetMakeChangeButtonsCocoDisplayed() {
        adminPortalManagePlansPage.resetMakeChangeButtonsCocoDisplayed();       }
    @And("I validate title and labels on Manage page Coco account")
    public void iContainerTitleLabelsCoco() {
        adminPortalManagePlansPage.containerTitleLabelsCoco();
    }
    @Then("I check for Previous Medical container message display")
    public void iCheckPreviousFinancialMedical() {
        adminPortalManagePlansPage.checkPreviousFinancialMedicalMessage();       }
    @Then("I check for Previous Dental container message display")
    public void iCheckPreviousFinancialDental() {
        adminPortalManagePlansPage.checkPreviousFinancialDentalMessage();       }
    @Then("I verify Years in dropdown starting from {string} as expected")
    public void iValidateYearsDropdown(String lowerYear){
        adminPortalManagePlansPage.validateYearsDropdown(lowerYear);        }
    @Then("I update the premium amount to {string} on Manage Plans page")
    public void iUpdatePremiumAmount(String premiumAmountValue){
        adminPortalManagePlansPage.updatePremiumAmount(premiumAmountValue);
    }
    @Then("I update the APTC amount to {string} on Manage Plans page")
    public void iUpdateAptcAmount(String aptcAmountValue){
        adminPortalManagePlansPage.updateAptcAmount(aptcAmountValue);
    }
    @And("I click Save Button Medical")
    public void iClickSaveButtonMedical() {
        adminPortalManagePlansPage.clickSaveButton();
    }

    @And("I update the Coverage Start date of member")
    public void coverageStartDate(List<String> memberCoverageStrtDtList) {
        adminPortalManagePlansPage.memberCoverageStrtDate(memberCoverageStrtDtList);
    }
    @And("I update the Financial Start date of member")
    public void financialStartDate(List<String> memberFinancialStrtDtList) {
        adminPortalManagePlansPage.memberFinancialStrtDate(memberFinancialStrtDtList);
    }
    @And ("I select the reason to confirm the changes")
    public void iselectTheReason (){
        adminPortalManagePlansPage.selectReasonForTheChange();
    }
    @And("I check current Medical container labels and data display")
    public void iVerifyLabelsDataMedical() {
        adminPortalManagePlansPage.verifyLabelsDataMedical();       }
    @Then("I check current Dental container labels and data display")
    public void iVerifyLabelsDataDental() {
        adminPortalManagePlansPage.verifyLabelsDataDental();       }
    @And("I collapse year dropdown")
    public void iCollapsYearDropdown() {
        adminPortalManagePlansPage.collapsYearDropdown();       }

    @And("I select {string} from the SelectPolicy Dropdown to update the dates")
    public void iSelectMemberNameFromPolicyDropdown(String MemberName){
        adminPortalManagePlansPage.selectMemberNameFromPolicyDropdown( MemberName);
    }

    @Then("I update the coverage end date")
    public void iUpdateTheCoverageEndDate(List<String> memberCoverageEndDTList) {
        adminPortalManagePlansPage.updateTheCoverageEndDate(memberCoverageEndDTList);
    }

    @And("I update the financial end date")
    public void iUpdateTheFinancialEndDate(List<String> memberFinancialEndDTList) {
        adminPortalManagePlansPage.updateTheFinancialEndDate(memberFinancialEndDTList);
    }
    @And("I select the {string} plan year on manage plan")
    public void iSelectThePlanYearOnManagePlan(String planYear) {
        adminPortalManagePlansPage.selectThePlanYearOnManagePlan(planYear);
    }
    @Then("I update my account_id any Env STG {string} QA {string}")
    public void iUpdateMyAccount_idAnyEnv(String stgAccountId, String qaAccountId) {
        adminPortalManagePlansPage.UpdateMyAccount_idAnyEnv(stgAccountId,qaAccountId);
    }

    @Then("I validate the text of the Medical Dental container")
    public void iValidateTheTextOfTheMedicalDentalContainer() {
        adminPortalManagePlansPage.validateTheTextOfTheMedicalContainer();
    }
    @Then("I select the {int} {string} policy Plan")
    public void iSelectThePolicyPlan(int policyNumber, String planType) {
        adminPortalManagePlansPage.selectTheMedPolicyPlan(policyNumber,planType);
    }

    @And("I select Plans Med Active Policy")
    public void iSelectPlansMedActivePolicy() {
        adminPortalManagePlansPage.selectPlansMedActivePolicy();
    }


    @And("I select Plans Dental Active Policy")
    public void iSelectPlansDentalActivePolicy() {
        adminPortalManagePlansPage.selectPlansDenActivePolicy();
    }

    @And("I update the second medical and dental policy for the year UI")
    public void iUpdateTheSecondMedicalAndDentalPolicyForTheYearUI() {
        adminPortalManagePlansPage.updateTheSecondMedicalPoliciyForTheYearUI();
    }

    @Then("I unchecked {string} from plan type")
    public void iUncheckedFromPlanType(String planType) {
        adminPortalManagePlansPage.uncheckedFromPlanType(planType);
    }
    @Then("I click Search button in AP blue header")
    public void iClickSearchInAdminPortalBlueHeader() {
        adminPortalManagePlansPage.clickSearchInAdminPortalBlueHeader();
    }

}

