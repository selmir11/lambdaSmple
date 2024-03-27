package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.YourClientsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;

public class YourClientsPageSteps {
    YourClientsPage yourClientsPage = new YourClientsPage(WebDriverManager.getDriver());
    @And("I click on {string} tab")
    public void iClickOnTab(String userTab) {
        yourClientsPage.clickUserTab(userTab);
    }

    @And("I click print button")
    public void iClickPrintButton() {yourClientsPage.clickPrintButton();}

    @Then("I verify that Print button is visible and enable")
    public void iVerifyThatPrintButtonIsVisibleAndEnable() {yourClientsPage.verifyPrintButtonIsDisplayed();}


}
