package com.c4hco.test.automation.stepDefinitions.databaseSteps.OPS;

import com.c4hco.test.automation.database.DbValidations.ManagePlanDBValidation;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DBManagePlanSteps {
    BasicActions actions = BasicActions.getInstance();
    ManagePlanDBValidation managePlanDBValidation= new ManagePlanDBValidation(WebDriverManager.getDriver());
    @Then("I validate current Medical plan Data for the year {string} DB")
    public void iValidateCurrentMedicalPlanDataForTheYearDB(String year) {
        managePlanDBValidation.validateCurrentMedicalPlanDataDB(year);
    }

    @Then("I validate current medical member details table DB")
    public void iValidateCurrentMedicalMemberDetailsTableDB() {
        managePlanDBValidation.validateCurrentMedicalMemberDetailsTableDB();
    }

    @Then("I validate current medical coverage details table DB")
    public void iValidateCurrentMedicalCoverageDetailsTableDB() {
        managePlanDBValidation.validateCurrentMedicalCoverageDetailsTableDB();
    }


    @Then("I validate current financial details table DB")
    public void iValidateCurrentFinancialDetailsTableDB() {
        managePlanDBValidation.validateCurrentFinancialDetailsTableDB();
    }

    @Then("I validate current Dental plan Data for the year {string} DB")
    public void iValidateCurrentDentalPlanDataForTheYearDB(String year) {
        managePlanDBValidation.validateCurrentDentalPlanDataForTheYearDB(year);
    }

    @Then("I validate current dental member details table DB")
    public void iValidateCurrentDentalMemberDetailsTableDB() {
        managePlanDBValidation.validateCurrentDentalMemberDetailsTableDB();
    }

    @Then("I validate current dental coverage details table DB")
    public void iValidateCurrentDentalCoverageDetailsTableDB() {
        managePlanDBValidation.validateCurrentDentalCoverageDetailsTableDB();
    }

    @Then("I validate current dental financial details table DB")
    public void iValidateCurrentDentalFinancialDetailsTableDB() {
        managePlanDBValidation.validateCurrentDentalFinancialDetailsTableDB();
    }

    @Then("I validate current {string} all details table in DB for {int} members on AP Manage Plans")
    public void iValidateCurrentAllDetailsTableDB(String planType, Integer memberNum) {
        actions.wait(5000);
        managePlanDBValidation.validateCurrentMembersDetailsTableDB(planType, memberNum);
        managePlanDBValidation.validateCurrentCoverageDetailsTableDB(planType, memberNum);
        managePlanDBValidation.validateCurrentFinancialDetailsTableDB(planType, memberNum);
    }

    @Then("I validate current {string} all details table in DB for {int} members {string} LCE on AP Manage Plans")
    public void iValidateCurrentAllDetailsTableLceDB(String planType, Integer memberNum, String lceType) {
        actions.wait(5000);
        managePlanDBValidation.validateCurrentMembersDetailsTableLceDB(planType, memberNum, lceType);
        managePlanDBValidation.validateCurrentCoverageDetailsTableLceDB(planType, memberNum, lceType);
        managePlanDBValidation.validateCurrentFinancialDetailsTableLceDB(planType, memberNum, lceType);
    }

    @Then("I validate previous {string} all details table in DB for {int} members on policy {string} for DB row {int} on AP Manage Plans")
    public void iValidatePreviousAllDetailsTableDB(String planType, Integer memberNum, String tableIndex, Integer dbRowAdjust) {
        actions.wait(5000);
        managePlanDBValidation.validatePreviousMembersDetailsTableDB(planType, memberNum, tableIndex, dbRowAdjust);
        managePlanDBValidation.validatePreviousCoverageDetailsTableDB(planType, memberNum, tableIndex, dbRowAdjust);
        managePlanDBValidation.validatePreviousFinancialDetailsTableDB(planType, memberNum, tableIndex, dbRowAdjust);
    }

    @Then("I validate current {string} plan summary in DB for {int} members on AP Manage Plans")
    public void iValidateCurrentPlanSummaryDB(String planType, Integer memberNum) throws Exception {
        actions.wait(5000);
        managePlanDBValidation.validateCurrentPlanSummaryDB(planType, memberNum);
    }

    @Then("I validate current {string} plan summary in DB for {int} members {string} LCE on AP Manage Plans")
    public void iValidateCurrentPlanSummaryLceDB(String planType, Integer memberNum, String lceType) throws Exception {
        actions.wait(5000);
        managePlanDBValidation.validateCurrentPlanSummaryLceDB(planType, memberNum, lceType);
    }

    @Then("I validate previous financial period {string} plan summary in DB for {int} policy {int} members on AP Manage Plans")
    public void iValidatePreviousPlanSummaryDB(String planType, Integer policyNumber, Integer memberNum) throws Exception {
        actions.wait(5000);
        managePlanDBValidation.validatePreviousPlanSummaryDB(planType, policyNumber, memberNum);
    }

    @Then("I validate termed {string} all details table in DB for {int} on AP Manage Plans")
    public void iValidateTermedAllDetailsTableInDBForOnAPManagePlans(String planType, int memberNum) {
        actions.wait(5000);
        managePlanDBValidation.validateTermedMembersDetailsTableDB(planType, memberNum);
        managePlanDBValidation.validateTermedCoverageDetailsTableDB(planType, memberNum);
        managePlanDBValidation.validateTermedFinancialDetailsTableDB(planType, memberNum);
    }


    ////////////////////////////Plans Container Individual Dashboard//////////////////////////
    @And("I verify Plan container for year {string} against the DB on the Individual dashboard")
    public void iVerifyPlanContainer(String planYear) {managePlanDBValidation.verifyPlanContainer(planYear);}
    @And("I verify Plan container for year {string} against the DB on the CoCo dashboard")
    public void iVerifyPlanContainerCoCo(String planYear) {managePlanDBValidation.verifyPlanContainerCoCo(planYear);}
}
