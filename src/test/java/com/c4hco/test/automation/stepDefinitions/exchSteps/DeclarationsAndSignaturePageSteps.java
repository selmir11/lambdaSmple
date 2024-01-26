package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DeclarationsAndSignaturePage;
import io.cucumber.java.en.And;

public class DeclarationsAndSignaturePageSteps {
    DeclarationsAndSignaturePage declarationsAndSignaturePage = new DeclarationsAndSignaturePage();

    @And("I Declare and sign")
    public void iDeclareNSign() {
        declarationsAndSignaturePage.enterSignature();
        declarationsAndSignaturePage.submitApplication();

    }


}
