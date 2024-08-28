package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.EDIReportPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EDIReportPageSteps {

    EDIReportPage ediReportPage = new EDIReportPage(WebDriverManager.getDriver());
    @And("I verify Detailed EDI headers data")
    public void i_verify_detailed_edi_headers_data() {
        ediReportPage.verifyEDIHeaders();
    }
    @And("I verify Detailed Outbound Transactions table header order")
    public void iVerifyDetailedOutboundTransactionsTableHeaderOrder() {
        ediReportPage.verifyEDITableHeaders();
    }

    @And("I verify Outbound Transactions data")
    public void iVerifyOutboundTransactionsData() {
        ediReportPage.verifyEDIData();
    }

    @Then("I validate sorting is working as expected for all columns")
    public void iValidateSortingIsWorkingAsExpectedForAllColumns() {
       ediReportPage.verifySort();
    }
}

