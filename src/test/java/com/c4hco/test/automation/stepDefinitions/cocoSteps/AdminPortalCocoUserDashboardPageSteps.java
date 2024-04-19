package com.c4hco.test.automation.stepDefinitions.cocoSteps;
import com.c4hco.test.automation.pages.cocoPages.AdminPortalCocoUserDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class AdminPortalCocoUserDashboardPageSteps {

    AdminPortalCocoUserDashboardPage adminPortalCocoUserDashboardPage = new AdminPortalCocoUserDashboardPage(WebDriverManager.getDriver());

    @Then("I click on {string} button")
    public void iClickOnButton(String DashboardButtons) {
        adminPortalCocoUserDashboardPage.clickFromDashboardButtons(DashboardButtons);
    }

    @Then("I click on view button for {string} report")
    public void iClickOnViewButtonForreport(String searchText) {
        adminPortalCocoUserDashboardPage.viewReportLinks(searchText);
    }
}
