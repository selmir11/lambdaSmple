package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages.AdminPortalProgramManagerPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdminPortalProgramManagerDashboardSteps {
    AdminPortalProgramManagerPage adminPortalProgramManagerPage = new AdminPortalProgramManagerPage(WebDriverManager.getDriver());
    @And("I click the {string} on the AP program manager dashboard")
    public void iClickTheOnTheAPProgramManagerDashboard(String option) {
        adminPortalProgramManagerPage.clickTheOnTheAPProgramManagerDashboard(option);

    }
    @Then("I update the email adresse {string} @outlook.com of the program manager")
    public void iUpdateTheEmailAdresseOutlookComOfTheProgramManager(String emailBase) {
        adminPortalProgramManagerPage.updateTheEmailAdresseOutlookComOfTheProgramManager(emailBase);
    }

    @Then("I click the save options {string} on the AP program manager dashboard")
    public void iClickTheSaveOptionsOnTheAPProgramManagerDashboard(String option) {
        adminPortalProgramManagerPage.clickTheSaveOptionsOnTheAPProgramManagerDashboard( option);
    }

    @And("I validate the Update successful text is displayed")
    public void iValidateTheUpdateSuccessfulTextIsDisplayed() {
        adminPortalProgramManagerPage.validateTheUpdateSuccessfulTextIsDisplayed();
    }


}
