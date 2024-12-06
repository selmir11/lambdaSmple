package com.c4hco.test.automation.stepDefinitions.databaseSteps.OPS;

import com.c4hco.test.automation.database.DbValidations.ManagePlanDBValidation;
import io.cucumber.java.en.Then;

public class DBManagePlanSteps {
    ManagePlanDBValidation managePlanDBValidation= new ManagePlanDBValidation();
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
}
