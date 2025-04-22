package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ExclusionReasonPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ExclusionReasonPageSteps {
    ExclusionReasonPage exclusionReasonPage = new ExclusionReasonPage(WebDriverManager.getDriver());
    @And("I verify Exclusion Report headers data")
    public void i_verify_Exclusion_Report_headers_data() {
        exclusionReasonPage.verifyExclusionReportHeaders();
    }
    @And("I verify Exclusion Report table header order")
    public void iVerifyExclusionReporttableHeaderOrder() {
        exclusionReasonPage.verifyExclusionReasonReportTableHeaders();
    }

    @And("I verify Exclusion Report data")
    public void iVerifyOutboundTransactionsData() {
        exclusionReasonPage.verifyExclusionReasonData();
    }

    @Then("I validate sorting is working as expected for all columns for exclusion report")
    public void iValidateSortingIsWorkingAsExpectedForAllColumns() {
        exclusionReasonPage.verifySort();
    }

    @Then("I select {string} to search exclusion report")
    public void iSelectToSearchExclusionReport(String year) {
        exclusionReasonPage.selectYearToAnyENV(year);
    }
}
