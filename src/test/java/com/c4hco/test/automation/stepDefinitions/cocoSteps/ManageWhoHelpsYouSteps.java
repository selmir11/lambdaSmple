package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.ManageWhoHelpsYouPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class ManageWhoHelpsYouSteps {
    ManageWhoHelpsYouPage manageWhoHelpsYouPage = new ManageWhoHelpsYouPage(WebDriverManager.getDriver());

    @Then("I click Continue on my own button from Manage who helps you page")
    public void iClickContinueOnOwnButton() {
        manageWhoHelpsYouPage.clickContinueOnOwnButton();
    }

    @Then("I click the back button from Manage who helps you page")
    public void iClickBackButton() { manageWhoHelpsYouPage.clickBackButton(); }





}
