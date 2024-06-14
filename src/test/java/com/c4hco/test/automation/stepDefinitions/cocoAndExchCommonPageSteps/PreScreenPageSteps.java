package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.PrescreenPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class PreScreenPageSteps {
        PrescreenPage prescreenPage = new PrescreenPage(WebDriverManager.getDriver());

        @And("I click create my account from pre-screen page")
        public void iClickCreateAccountLink(){
            prescreenPage.clickCreateAccountLink();
        }

    @Then("I verify sign in button is displayed")
    public void iVerifySignInButtonIsDisplayed() {
            prescreenPage.verifySignInDisplayed();
    }

    @Then("I click on Help me understand what I qualify for button")
    public void iClickOnHelpMeUnderstandWhatIQualifyForButton() {
            prescreenPage.clickOnHelpMeUnderstandWhatIQualifyFor();
    }


    // =================VALIDATION STEPS==============//


    }
