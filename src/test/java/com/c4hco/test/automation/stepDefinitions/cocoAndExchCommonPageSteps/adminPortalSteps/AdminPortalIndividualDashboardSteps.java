package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalIndividualDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class AdminPortalIndividualDashboardSteps {

    AdminPortalIndividualDashboardPage adminPortalIndividualDashboardPage = new AdminPortalIndividualDashboardPage(WebDriverManager.getDriver());

    @And("I validate Primary Member title on Individual dashboard")
    public void iCheckTitleIndividual() {adminPortalIndividualDashboardPage.checkingTitleIndividual();}
    @And("I validate selected Member data on the left side")
    public void iValidateSelectedMemberData() {adminPortalIndividualDashboardPage.validateSelectedMemberData();}
}

