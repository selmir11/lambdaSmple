package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.GoodNewsMAPage;
import io.cucumber.java.en.Then;

public class GoodNewsMAPageSteps {

    GoodNewsMAPage GoodNewsMAPage = new GoodNewsMAPage();

    @Then("I click on No Thanks on good news page")
    public void iClickNoThanks() {
        GoodNewsMAPage.iClickNoThanks();
    }
}
