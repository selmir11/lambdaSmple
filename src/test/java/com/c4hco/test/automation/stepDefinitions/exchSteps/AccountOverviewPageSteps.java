package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AccountOverviewPage;
import io.cucumber.java.en.*;

public class AccountOverviewPageSteps {
    AccountOverviewPage accountOverviewPage = new AccountOverviewPage();

    @Then("I validate account overview page is loaded")
    public void iValidateAccountOverviewPageLoads(){
        accountOverviewPage.verifyAccountOverviewPageUrl();
    }

//    @Then("I Verify the header on myAccountOverview page")
//    public void I_verify_header(){
//        apply.verifyHeader();
//    }

    @And("I apply for 2024")
    public void iApplyFor2024(){
        accountOverviewPage.clickApply2024();
    }
}
