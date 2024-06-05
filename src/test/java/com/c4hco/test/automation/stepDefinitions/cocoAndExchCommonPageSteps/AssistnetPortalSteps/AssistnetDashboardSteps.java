package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.AssistnetPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AssistnetPortalPages.AssistnetDashboardPage;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ChatWidgetPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AssistnetDashboardSteps {
    AssistnetDashboardPage assistnetDashboardPage = new AssistnetDashboardPage(WebDriverManager.getDriver());
    @And("I click on view My Clients button")
    public void iClickOnViewMyClientsButton() {
        assistnetDashboardPage.ClickOnViewMyClients();
    }

    @Then("I verify that Print button is visible and enable in Assistent portal")
    public void iVerifyThatPrintButtonIsVisibleAndEnableInAssistentPortal() {
        assistnetDashboardPage.verifyPrintButtonInAP();
    }

    @And("I click on username dropdown")
    public void iClickOnUsernameDropdown() {
        assistnetDashboardPage.ClickOnUsernameDropdown();
    }

    @Then("I click sign out from the assistnet Dashboard")
    public void iClickSignOutFromTheAssistnetDashboard() {
        assistnetDashboardPage.ClickSignOutFromTheAP();
    }
}
