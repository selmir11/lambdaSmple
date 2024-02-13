package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.ManageWhoHelpsYouPage;
import io.cucumber.java.en.Then;

public class ManageWhoHelpsYouSteps {
    ManageWhoHelpsYouPage manageWhoHelpsYouPage = new ManageWhoHelpsYouPage();

    @Then("I click Continue on my own button from Manage who helps you page")
    public void iClickContinueOnOwnButton() {
        manageWhoHelpsYouPage.clickContinueOnOwnButton();
    }

    @Then("I click the back button from Manage who helps you page")
    public void iClickBackButton() { manageWhoHelpsYouPage.clickBackButton(); }





}
