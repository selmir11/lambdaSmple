package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.BeforeYouBeginPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class BeforeYouBeginSteps {

    BeforeYouBeginPage beforeYouBeginPage = new BeforeYouBeginPage(WebDriverManager.getDriver());

    //this has double spaces, 'with  application'

    /**
     * This then statement has double spaces, 'with  application' use the correct then statement with single spaces
     * @deprecated see {@link BeforeYouBeginSteps#iClickContinueWithApplicationButton()}
     */
    @Deprecated
    @Then("I click on continue with  application button on Before you begin page")
    public void iClickContinueWithApplicationButtonDep() {
        beforeYouBeginPage.clickContinueWithApplicationButton();
    }

    @Then("I click on Before you begin continue with application button")
    public void iClickContinueWithApplicationButton() {
        beforeYouBeginPage.clickContinueWithApplicationButton();
    }

    @And("I validate the verbiage on the Before you begin page in {string}")
    public void iValidateTheVerbiageOnTheBeforeYouBeginPageIn(String language) {
        beforeYouBeginPage.validateTheVerbiageOnBeforeYouBeginPage(language);
    }
}
