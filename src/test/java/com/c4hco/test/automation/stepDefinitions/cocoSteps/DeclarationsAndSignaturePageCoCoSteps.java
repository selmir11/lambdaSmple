package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.DeclarationsAndSignaturePageCoCo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DeclarationsAndSignaturePageCoCoSteps {
    DeclarationsAndSignaturePageCoCo declarationsAndSignaturePageCoCo = new DeclarationsAndSignaturePageCoCo(WebDriverManager.getDriver());

    @And("I enter a valid signature")
    public void enterSignature() {declarationsAndSignaturePageCoCo.enterSignatureinCoCo();}


    @And("I select Go Back on the Declarations and Signature page")
    public void clickGoBackButton(){declarationsAndSignaturePageCoCo.goBack();}

    @And("I click Continue on the Declarations And Signature Page CoCo")
    public void selectContinueDeclarations(){declarationsAndSignaturePageCoCo.submitApplicationCoCo();}

    @And("I enter a OBO signature on the Declarations And Signature Page CoCo")
    public void enterOBOSignature() {declarationsAndSignaturePageCoCo.enterOBOSignature();}





    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the CoCo Declarations And Signature page in {string}")
    public void iVerifyTextOnDeclarationsAndSignaturePage(String language){declarationsAndSignaturePageCoCo.verifyHeadersDeclarationsAndSignaturePage(language);}

    @Then("I verify Declarations And Signature CoCo error format")
    public void iVerifyErrorFormat(){declarationsAndSignaturePageCoCo.verifyErrorFormat();}
}
