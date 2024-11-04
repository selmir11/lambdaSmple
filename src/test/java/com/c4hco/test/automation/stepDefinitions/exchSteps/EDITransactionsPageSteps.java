package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EDITransactionsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EDITransactionsPageSteps {
    EDITransactionsPage ediTransactionsPage = new EDITransactionsPage(WebDriverManager.getDriver());

    @And("I verify EDI Transactions headers data")
    public void iVerifyEDITransactionsHeadersData() {
        ediTransactionsPage.verifyEDITransactionHeaders();
    }

    @Then("I select {string} coverage type dropdown")
    public void iSelectCoverageTypeDropdown(String text) {
        ediTransactionsPage.SelectCoveragetypedropdowns(text);
    }


    @Then("I select {string} to search EDI transactions")
    public void iSelectToSearchEDITransactions(String year) {
        ediTransactionsPage.selectYearToAnyENV(year);
    }

    @Then("I validate only {string} records present for the user")
    public void iValidateOnlyRecordsPresentForTheUser(String InsuranceType) {
        ediTransactionsPage.validateInsuranceRecordsDisplay(InsuranceType);
    }

    @Then("I validate {string} transactions present for the user")
    public void iValidateTransactionsPresentForTheUser(String validationOption) {
        ediTransactionsPage.validateMedicalAndDentalRecords(validationOption);
    }
}

