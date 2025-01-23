package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ManagePlans.AdminPortalManagePlansPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
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
    @And("I click Save Button Medical")
    public void iClickSaveButtonMedical() {
        adminPortalManagePlansPage.clickSaveButton();
    }
    @And("I click Save Button Dental")
    public void iClickSaveButtonDental() {
        adminPortalManagePlansPage.clickSaveButtonDental();
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

    @Then("I update the APTC value for")
    public void iUpdateTheAPTCValueFor(List<String> memberaptctDtList) {
        adminPortalManagePlansPage.addAPTCvalue(memberaptctDtList);
    }
    @And("I validate Invalid monetary amount for Premium error is displaying")
    public void iValidateInvalidMonetaryAmountForPremium() {
        adminPortalManagePlansPage.validatePremiumErrors();
    }

    @Then("I update the premium value for")
    public void iUpdateThePremiumValueFor(List<String> memberpremiumList) {
        adminPortalManagePlansPage.addpremiumvalue(memberpremiumList);
    }

    @Then("I should see the Invalid monetary amount for APTC error for")
    public void iShouldSeeTheInvalidMonetaryAmountForAPTCErrorFor(DataTable table) {
        adminPortalManagePlansPage.validateErrorMessages(table);
    }

    @And("I validate APTC entered exceeds EHB amount error is displaying for {string}")
    public void iValidateAPTCEnteredExceedsEHBAmountErrorIsDisplayingFor(String planType) {
        adminPortalManagePlansPage.validateEHBErrors(planType);
    }

    @Then("I verify it displays coverage start date error")
    public void iVerifyItDisplaysCoverageStartDateError() {
        adminPortalManagePlansPage.validateCoverageStartDateErrors();
    }

    @Then("I verify it displays financial start date error")
    public void iVerifyItDisplaysFinancialStartDateError() {
        adminPortalManagePlansPage.validateFinancialStartDateErrors();
    }

    @Then("I verify it displays coverage end date error")
    public void iVerifyItDisplaysCoverageEndDateError() {
        adminPortalManagePlansPage.validateCoverageEndDateErrors();
    }

    @Then("I verify it displays financial end date error")
    public void iVerifyItDisplaysFinancialEndDateError() {
        adminPortalManagePlansPage.validateFinancialEndDateErrors();
    }

    @Then("I click on Dental button to display only medical view")
    public void iClickOnDentalButtonToDisplayOnlyMedicalView() {
        adminPortalManagePlansPage.clickDentalButton();
    }

    @Then("I click on Medical button to display only Dental view")
    public void iClickOnMedicalButtonToDisplayOnlyDentalView() {
        adminPortalManagePlansPage.clickMedicalButton();}

    @And("I update the medical Plan for the UI")
    public void iUpdateTheMedicalPlanForTheUI() {
        adminPortalManagePlansPage.updateTheMedicalPlanForTheUI();
    }


    @And("I validate the {string} coverage details table title columns")
    public void iValidateTheCoverageDetailsTableTitleColumns(String planType) {
        adminPortalManagePlansPage.validateTheCoverageDetailsTableTitleColumns(planType);
    }

    @And("I update the Medical coverage details Table for the UI")
    public void iUpdateTheMedicalCoverageDetailsTableForTheUI() {
        adminPortalManagePlansPage.updateTheMedicalCoverageDetailsTableForTheUI();
    }

    @And("I validate the {string} financial details table title columns")
    public void iValidateTheFinancialDetailsTableTitleColumns(String planType) {
        adminPortalManagePlansPage.validateTheFinancialDetailsTableTitleColumns(planType);
    }

    @And("I update the Medical financial details Table for the UI")
    public void iUpdateTheMedicalFinancialDetailsTableForTheUI() {
        adminPortalManagePlansPage.updateTheMedicalFinancialDetailsTableForTheUI();}


    @And("I update the Medical member details Table for the UI")
    public void iUpdateTheMedicalMemberDetailsTableForTheUI() {
        adminPortalManagePlansPage.updateTheMedicalMemberDetailsTableForTheUI();
    }

    @And("I validate the {string} member details Table title columns")
    public void iValidateTheMemberDetailsTableTitleColumns(String planType) {
        adminPortalManagePlansPage.validateTheMemberDetailsTableTitleColumns(planType);
    }

    @And("I update the dental Plan for the UI")
    public void iUpdateTheDentalPlanForTheUI() {
        adminPortalManagePlansPage.updateTheDentalPlanForTheUI();
    }

    @And("I update the dental member details Table for the UI")
    public void iUpdateTheDentalMemberDetailsTableForTheUI() {
        adminPortalManagePlansPage.updateTheDentalMemberDetailsTableForTheUI();
    }


    @And("I update the dental coverage details Table for the UI")
    public void iUpdateTheDentalCoverageDetailsTableForTheUI() {
        adminPortalManagePlansPage.updateTheDentalCoverageDetailsTableForTheUI();
    }

    @And("I update the dental financial details Table for the UI")
    public void iUpdateTheDentalFinancialDetailsTableForTheUI() {
        adminPortalManagePlansPage.updateTheDentalFinancialDetailsTableForTheUI();

    }
    @And("I validate simplified plans {string} and {string} and labels on Manage page")
    public void iSimplifiedContainerTitleLabels(String simplifyPlanMedical, String simplifyPlanDental) {
        adminPortalManagePlansPage.simplifiedContainerTitleLabels(simplifyPlanMedical, simplifyPlanDental);      }

    @Then("I click checked {string} to see only medical plan data")
    public void iClickCheckedToSeeOnlyOnePlanData(String planType) {
        adminPortalManagePlansPage.clickCheckedToSeeOnlyMedicalPlanData(planType);
    }
    @Then("I check current Simplified Medical container labels")
    public void iVerifyLabelsSimplifiedMedical() {
        adminPortalManagePlansPage.verifyLabelsSimplifiedMedical();       }
    @And("I check plan name: {string} {string} {string} or plan name: {string} {string} {string}")
    public void iValidateSimplifyViewMedicalData(String planNameSTG, String policyCoverageSTG, String latestApplicationDateSTG, String planNameQA, String policyCoverageQA, String latestApplicationDateQA) {
        adminPortalManagePlansPage.validateSimplifyViewMedicalData(planNameSTG, policyCoverageSTG, latestApplicationDateSTG, planNameQA, policyCoverageQA, latestApplicationDateQA);  }
    @Then("I validate {string} or {string} data for HIOS ID on manage plans")
    public void iValidateStringDataForHIOSIDOnManagePlans(String hiosIdSTG, String hiosIdQA) {
        adminPortalManagePlansPage.validateDataForHIOSID(hiosIdSTG, hiosIdQA);
    }
    @Then("I validate member table data row {string}, {string}, {string}, {string}, {string}, {string} or {string}, {string}, {string}, {string}, {string}, {string}")
    public void iValidateMemberTableDataRow(String rowNumberSTG, String personIdSTG, String nameSTG, String birthSTG, String relationSTG, String tobaccoSTG, String rowNumberQA, String personIdDataQA, String nameQA, String birthQA, String relationQA, String tobaccoQA) {
        adminPortalManagePlansPage.iValidateMemberTableDataRowOne(rowNumberSTG, personIdSTG, nameSTG, birthSTG, relationSTG, tobaccoSTG, rowNumberQA, personIdDataQA, nameQA, birthQA, relationQA, tobaccoQA);
    }
    @Then("I validate member table data row two {string}, {string}, {string}, {string}, {string}, {string} or {string}, {string}, {string}, {string}, {string}, {string}")
    public void iValidateMemberTableDataRawTwo(String rowNumberSTG, String personIdSTG, String nameSTG, String birthSTG, String relationSTG, String tobaccoSTG, String rowNumberQA, String personIdDataQA, String nameQA, String birthQA, String relationQA, String tobaccoQA) {
        adminPortalManagePlansPage.iValidateMemberTableDataRowTwo(rowNumberSTG, personIdSTG, nameSTG, birthSTG, relationSTG, tobaccoSTG, rowNumberQA, personIdDataQA, nameQA, birthQA, relationQA, tobaccoQA);
    }

    @And("I validate {string} coverage table data on Simplified View {string}, {string}, {string}, {string}, {string}, {string} or {string}, {string}, {string}, {string}, {string}, {string}")
    public void iValidateCoverageTableDataOnSimplifiedView(String type, String rowSTG, String coverageStartSTG, String coverageEndSTG, String statusSTG, String effectuatedSTG, String reasonSTG, String rowQA, String coverageStartQA, String coverageEndQA, String statusQA, String effectuatedQA, String reasonQA) {
        adminPortalManagePlansPage.iValidateCoverageTableDataRowOne(type, rowSTG, coverageStartSTG, coverageEndSTG, statusSTG, effectuatedSTG, reasonSTG, rowQA, coverageStartQA, coverageEndQA, statusQA, effectuatedQA, reasonQA);
    }
    @Then("I validate {string} coverage table data row two on Simplified View {string}, {string}, {string}, {string}, {string}, {string} or {string}, {string}, {string}, {string}, {string}, {string}")
    public void iValidateCoverageTableDataRowTwo(String type, String rowTwoSTG, String coverageStartRowTwoSTG, String coverageEndRowTwoSTG, String statusRowTwoSTG, String effectuatedRowTwoSTG, String reasonRowTwoSTG, String rowTwoQA, String coverageStartRowTwoQA, String coverageEndRowTwoQA, String statusRowTwoQA, String effectuatedRowTwoQA, String reasonRowTwoQA) {
        adminPortalManagePlansPage.validateCoverageTableDataRowTwo(type, rowTwoSTG, coverageStartRowTwoSTG, coverageEndRowTwoSTG, statusRowTwoSTG, effectuatedRowTwoSTG, reasonRowTwoSTG, rowTwoQA, coverageStartRowTwoQA, coverageEndRowTwoQA, statusRowTwoQA, effectuatedRowTwoQA, reasonRowTwoQA);
    }
    @And("I validate {string} financial table data on Simplified View {string}, {string}, {string}, {string}, {string} or {string}, {string}, {string}, {string}, {string}")
    public void iValidateFinancialTableDataOnSimplifiedView(String type, String rowSTG, String financialStartSTG, String financialEndSTG, String premiumSTG, String APTCSTG, String rowQA, String financialStartQA, String financialEndQA, String premiumQA, String APTCQA) {
        adminPortalManagePlansPage.iValidateFinancialTableDataRowOne(type, rowSTG, financialStartSTG, financialEndSTG, premiumSTG, APTCSTG, rowQA, financialStartQA, financialEndQA, premiumQA, APTCQA);
    }
    @Then("I validate {string} financial table data row two on Simplified View {string}, {string}, {string}, {string}, {string} or {string}, {string}, {string}, {string}, {string}")
    public void iValidateFinancialTableDataRowTwo(String type, String rowTwoSTG, String financialStartRowTwoSTG, String financialEndRowTwoSTG, String premiumRowTwoSTG, String APTCRowTwoSTG, String rowTwoQA, String financialStartRowTwoQA, String financialEndRowTwoQA, String premiumRowTwoQA, String APTCRowTwoQA) {
        adminPortalManagePlansPage.validateFinancialTableDataRowTwo(type, rowTwoSTG, financialStartRowTwoSTG, financialEndRowTwoSTG, premiumRowTwoSTG, APTCRowTwoSTG, rowTwoQA, financialStartRowTwoQA, financialEndRowTwoQA, premiumRowTwoQA, APTCRowTwoQA);
    }
    @Then("I unchecked Medical button on CoCo manage plan")
    public void iUncheckedFromPlanType() {
        adminPortalManagePlansPage.uncheckedMedicalCoCo();
    }
    @And("I validate and click Go Back button")
    public void iInspectAndClickGoBackButton() {
        adminPortalManagePlansPage.verifyAndClickGoBackButton();       }
    @Then("I click Go Back button on Simplified View")
    public void iClickGoBackButtonOnSimplifiedView() {
        adminPortalManagePlansPage.clickGoBackButtonOnSimplifiedView();       }
    @Then("I check current Simplified Medical container labels CoCo")
    public void iVerifyLabelsSimplifiedMedicalCoCo() {
        adminPortalManagePlansPage.verifyLabelsSimplifiedMedicalCoCo();       }
}

