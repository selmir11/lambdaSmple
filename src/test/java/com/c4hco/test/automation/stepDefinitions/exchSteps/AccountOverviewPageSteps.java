package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AccountOverviewPage;
import io.cucumber.java.en.*;

public class AccountOverviewPageSteps {
    AccountOverviewPage accountOverviewPage = new AccountOverviewPage();

    @Then("I apply for the current year")
    public void iApplyForCurrentYear(){accountOverviewPage.clickApplyForCurrentYear();}
}
