package com.c4hco.test.automation.stepDefinitions.databaseSteps.OPS;

import com.c4hco.test.automation.database.DbValidations.ManagePlanDBValidation;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
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

    @Then("I validate current {string} all details table in DB for {int} on AP Manage Plans")
    public void iValidateCurrentMedicalAllDetailsTableDB(String planType, Integer memberNum) {
        actions.wait(5000);
        managePlanDBValidation.validateCurrentMedicalMembersDetailsTableDB(planType, memberNum);
        managePlanDBValidation.validateCurrentMedicalCoverageDetailsTableDB(planType, memberNum);
        managePlanDBValidation.validateCurrentMedicalFinancialDetailsTableDB(planType, memberNum);
    }

    @Then("I validate previous {string} all details table in DB for {int} on AP Manage Plans")
    public void iValidatePreviousMedicalAllDetailsTableDB(String planType, Integer memberNum) {
        actions.wait(5000);
        managePlanDBValidation.validatePreviousMedicalMembersDetailsTableDB(planType, memberNum);
        managePlanDBValidation.validatePreviousMedicalCoverageDetailsTableDB(planType, memberNum);
        managePlanDBValidation.validatePreviousMedicalFinancialDetailsTableDB(planType, memberNum);
    }
}
