package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DeclarationsAndSignature_LR;
import io.cucumber.java.en.And;

public class DeclarationsAndSignatureSteps_LR {
    DeclarationsAndSignature_LR sign = new DeclarationsAndSignature_LR();

    @And("I Declare and sign")
    public void declareNSign() throws InterruptedException {
        sign.enterSignature();
        sign.submitApplication();

    }


}
