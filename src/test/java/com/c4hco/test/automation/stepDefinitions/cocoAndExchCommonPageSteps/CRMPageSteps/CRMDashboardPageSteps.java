package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.CRMPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages.CRMDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class CRMDashboardPageSteps {
    CRMDashboardPage crmDashboardPage = new CRMDashboardPage(WebDriverManager.getDriver());

    @Then("I search for user via Email and open first option")
    public void searchUserViaEmail(){crmDashboardPage.CRMDashboardSearchUserEmailandOpenFirst();}
}
