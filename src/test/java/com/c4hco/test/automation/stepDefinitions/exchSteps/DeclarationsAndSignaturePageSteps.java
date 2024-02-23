package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DeclarationsAndSignaturePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class DeclarationsAndSignaturePageSteps {
    DeclarationsAndSignaturePage declarationsAndSignaturePage = new DeclarationsAndSignaturePage(WebDriverManager.getDriver());

    @And("I Declare and sign")
    public void iDeclareNSign() {
        declarationsAndSignaturePage.enterSignature();
        declarationsAndSignaturePage.submitApplication();
    }

    @And("I wait for hold on content to disappear")
    public void iWaitForHoldOnContentToDisappear(){
        declarationsAndSignaturePage.waitForHoldOnContentToDisappear();
    }


}
