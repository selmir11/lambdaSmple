package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.DeclarationsAndSignaturePageCoCo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DeclarationsAndSignaturePageCoCoSteps {
    DeclarationsAndSignaturePageCoCo declarationsAndSignaturePageCoCo = new DeclarationsAndSignaturePageCoCo(WebDriverManager.getDriver());

    @And("I enter a valid signature")
    public void enterSignature() {declarationsAndSignaturePageCoCo.enterSignatureCoCo();}

    @And("I click Continue on the Declarations And Signature Page CoCo")
    public void clickContinueButton(){declarationsAndSignaturePageCoCo.submitApplicationCoCo();}

}
