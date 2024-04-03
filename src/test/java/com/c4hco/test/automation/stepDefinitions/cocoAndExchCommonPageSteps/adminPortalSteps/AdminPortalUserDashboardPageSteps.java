package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalUserDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class AdminPortalUserDashboardPageSteps {

AdminPortalUserDashboardPage adminPortalUserDashboardPage = new AdminPortalUserDashboardPage(WebDriverManager.getDriver());

    @Then("I click on {string} button")
    public void iClickOnButton(String DashboardButtons) {
        adminPortalUserDashboardPage.clickFromDashboardButtons(DashboardButtons);
    }
    @Then("I click on view button for EDI Transaction report")
    public void iClickOnViewButtonForEDITransactionReport() {
        adminPortalUserDashboardPage.clickEDITransaction();
    }

    @Then("I click on view button for Detailed EDI report")
    public void iClickOnViewButtonForEDIDetailReport() {
        adminPortalUserDashboardPage.clickEDIDetails();
    }

    @Then("I click on view button for Account Activity report")
    public void iClickOnViewButtonForAccountActivityReport() {
        adminPortalUserDashboardPage.clickAccountActivity();
    }
}
