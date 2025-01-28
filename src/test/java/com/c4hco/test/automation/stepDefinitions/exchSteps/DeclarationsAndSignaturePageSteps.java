package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DeclarationsAndSignaturePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DeclarationsAndSignaturePageSteps {
    DeclarationsAndSignaturePage declarationsAndSignaturePage = new DeclarationsAndSignaturePage(WebDriverManager.getDriver());

    @And("I Declare as Tax Household {int}")
    public void iDeclareNSign(int taxHouseHold) {declarationsAndSignaturePage.enterSignature(taxHouseHold);}

    @Then("I click Continue on the Declarations And Signature Page")
    public void iClickContinue(){declarationsAndSignaturePage.submitApplication();}

    @And("I wait for hold on content to disappear")
    public void iWaitForHoldOnContentToDisappear(){
        declarationsAndSignaturePage.waitForHoldOnContentToDisappear();
    }

    @Then("I verify the text on Declarations and Signature page in {string}")
    public void verifyTextEnglishAndSpanish(String languageOption){
        verifyTextEnglishAndSpanishInDASPage(languageOption);
    }

}
