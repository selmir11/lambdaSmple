package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.FindExpertHelpPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class FindExpertHelpPageSteps {
    FindExpertHelpPage findExpertHelpPage = new FindExpertHelpPage(WebDriverManager.getDriver());

    @Then("I click Continue on my own button from Find Expert Help page")
    public void iClickContinueOnOwnButton() {
        findExpertHelpPage.clickContinueOnOwnButton();
    }
    @Then("I click the back button from Find Expert Help page")
    public void iClickBackButton() {
        findExpertHelpPage.clickBackButton();
    }
}
