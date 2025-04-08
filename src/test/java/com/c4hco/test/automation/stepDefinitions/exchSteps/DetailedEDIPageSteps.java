package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DetailedEDIPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DetailedEDIPageSteps {

    DetailedEDIPage detailedEDIPage = new DetailedEDIPage(WebDriverManager.getDriver());
    @And("I verify Detailed EDI headers data")
    public void i_verify_detailed_edi_headers_data() {
        detailedEDIPage.verifyEDIHeaders();
    }
    @And("I verify Detailed Outbound Transactions table header order")
    public void iVerifyDetailedOutboundTransactionsTableHeaderOrder() {
        detailedEDIPage.verifyEDITableHeaders();
    }

    @And("I verify Outbound Transactions data")
    public void iVerifyOutboundTransactionsData() {
        detailedEDIPage.verifyEDIData();
    }

    @Then("I validate sorting is working as expected for all columns")
    public void iValidateSortingIsWorkingAsExpectedForAllColumns() {
        detailedEDIPage.verifySort();
    }

    @Then("I select plan year for {string}")
    public void iSelectPlanYearFor(String year) {
        detailedEDIPage.selectPlanYear(year);
    }

    @Then("I click on search button on EDI report page")
    public void iClickOnSearchButtonOnEDIReportPage() {
        detailedEDIPage.clickSearchButton();
    }
}
