package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.FindExpertHelpPage;
import io.cucumber.java.en.*;

public class FindExpertHelpPageSteps {
    FindExpertHelpPage findExpertHelpPage = new FindExpertHelpPage();

    @Then("I click Continue on my own button from Find Expert Help page")
    public void iClickContinueOnOwnButton() {
        findExpertHelpPage.clickContinueOnOwnButton();
    }

}
