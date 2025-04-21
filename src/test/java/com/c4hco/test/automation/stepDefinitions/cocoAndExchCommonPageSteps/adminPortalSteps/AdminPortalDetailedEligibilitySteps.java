package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages.AdminPortalDetailedEligibilityPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;

public class AdminPortalDetailedEligibilitySteps {

    AdminPortalDetailedEligibilityPage adminPortalDetailedEligibilityPage =  new AdminPortalDetailedEligibilityPage(WebDriverManager.getDriver());

    @And("I validate primary holder name and account ID on view details eligibility")
    public void iValidatePrimaryHolderNameAndAccountIDOnViewDetailsEligibility(List<Map<String, String>> data) {
        adminPortalDetailedEligibilityPage.verifyPrimaryHolderandAcctDetailsOnEligiblity(data);
    }

    @Then("I validate Detailed Eligibility header")
    public void iValidateDetailedEligibilityHeader() {
        adminPortalDetailedEligibilityPage.verifyDetailedEligibilityHeader();
    }

    @Then("I validate Household level application and eligibility data header")
    public void iValidateHouseholdLevelApplicationAndEligibilityDataHeader() {
        adminPortalDetailedEligibilityPage.validateHouseHoldHeader();
    }

    @And("I validate Household level container label name and details on detailed eligibility")
    public void iValidateHouseholdLevelContainerLabelNameAndDetailsOnDetailedEligibility(DataTable tabledata) {
        adminPortalDetailedEligibilityPage.householdDetails(tabledata);
    }

   @Then("I validate member level eligibility header")
    public void iValidateMemberLevelEligibilityHeader() {
        adminPortalDetailedEligibilityPage.validateMemberLevelHeader();
    }

    @And("I validate member level table label and details")
    public void iValidateMemberLevelTableLabelAndDetails(List<Map<String, String>>  data) {
        adminPortalDetailedEligibilityPage.validateMemberLevelDetails(data);
    }

    @Then("I validate LCE eligibility header")
    public void iValidateLCEEligibilityHeader() {
        adminPortalDetailedEligibilityPage.validateLCEHeader();
    }

    @And("I validate LCE table label and details on detailed eligibility")
    public void iValidateLCETableLabelAndDetailsOnDetailedEligibility(List<Map<String, String>>  data) {
        adminPortalDetailedEligibilityPage.validateLCDetails(data);
    }

    @Then("I validate previous application container header on view detailed eligiblity")
    public void iValidatePreviousApplicationContainerHeaderOnViewDetailedEligiblity() {
        adminPortalDetailedEligibilityPage.validatePreviousApplnHeader();
    }

    @Then("I validate Previous application container details")
    public void iValidatePreviousApplicationContainerDetails(List<Map<String ,String>> data) {
        adminPortalDetailedEligibilityPage.validatePreviousContainerDetails(data);
    }

    @Then("I validate Previous application container order")
    public void iValidatePreviousApplicationContainerOrder() {
        adminPortalDetailedEligibilityPage.validatePreviousApplicationOrder();
    }
}

