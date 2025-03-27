package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.DetailedEDICoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DetailedEDIPageSteps {

    DetailedEDICoCoPage detailedEDICoCoPage = new DetailedEDICoCoPage(WebDriverManager.getDriver());
    @And("I verify Detailed EDI headers data for coco")
        public void i_verify_detailed_edi_headers_data() {
        detailedEDICoCoPage.verifyEDIHeaders();
        }
        @And("I verify Detailed Outbound Transactions table header order for coco")
        public void iVerifyDetailedOutboundTransactionsTableHeaderOrder() {
            detailedEDICoCoPage.verifyEDITableHeaders();
        }

        @And("I verify Outbound Transactions data for coco")
        public void iVerifyOutboundTransactionsData() {
            detailedEDICoCoPage.verifyEDIData();
        }

        @Then("I validate sorting is working as expected for all columns for coco")
        public void iValidateSortingIsWorkingAsExpectedForAllColumns() {
            detailedEDICoCoPage.verifySort();
        }

    }



