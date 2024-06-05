package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.DashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DashboardPageSteps {
    DashboardPage dashboardPage = new DashboardPage(WebDriverManager.getDriver());

    @Then("I click Broker Dashboard")
    public void iClickBrokerDashboard(){
        dashboardPage.clickBrokerDashboard();
    }

    @And("I click the C4U Link")
    public void iClickCompleteProfile(){
        dashboardPage.clickC4ULink();
    }


}
