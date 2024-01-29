package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AccountOverviewPage;
import io.cucumber.java.en.*;

public class AccountOverviewPageSteps {
    AccountOverviewPage accountOverviewPage = new AccountOverviewPage();
    @And("I apply for 2024")
    public void iApplyFor2024(){
        accountOverviewPage.clickApply2024();
    }
}
