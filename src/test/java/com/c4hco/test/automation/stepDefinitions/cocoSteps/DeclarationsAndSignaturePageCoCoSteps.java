package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.DeclarationsAndSignaturePageCoCo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
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

    @Then("I enter invalid signature name on the Declarations And Signature Page CoCo")
    public void iEnterInvalidSignatureName(){
        declarationsAndSignaturePageCoCo.enterInvalidSignatureName();
    }



    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the CoCo Declarations And Signature page in {string}")
    public void iVerifyTextOnDeclarationsAndSignaturePage(String language){declarationsAndSignaturePageCoCo.verifyHeadersDeclarationsAndSignaturePage(language);}

    @Then("I verify Declarations And Signature CoCo error format")
    public void iVerifyErrorFormat(){declarationsAndSignaturePageCoCo.verifyErrorFormat();}

    @Then("I verify the username electronic signature label along with the signature input box in {string}")
    public void iVerifyElectronicSignatureLabelAndInputBox(String language){declarationsAndSignaturePageCoCo.verifyElectronicSignatureLabelAndInputBox(language);}

    @Then("I verify the error message {string} when I click on continue button without entering the value in Electronic signature input box")
    public void iVerifyErrorMessageWithoutEnteringAnythingInInputSignatureBox(String expectedErrorMsg){declarationsAndSignaturePageCoCo.verifyErrorMessageWithoutEnteringAnythingInInputSignatureBox(expectedErrorMsg);}

    @Then("I verify validation text for error message on the CoCo Declarations and Signature page")
    public void iverifyPageText(DataTable dataTable){
        declarationsAndSignaturePageCoCo.validateErrorMessageAndStyleProp(dataTable);
    }

    @Then("I verify the label text style above the Error message on CoCo Declarations and Signature page")
    public void iverifyLabelText(DataTable dataTable){
        declarationsAndSignaturePageCoCo.validateLabelTextAndStyleProp(dataTable);
    }

    @Then("I verify the text on CoCo Declarations and Signature page in {string}")
    public void verifyTextEnglishAndSpanish(String languageOption){
        declarationsAndSignaturePageCoCo.verifyTextEnglishAndSpanishInDASPage(languageOption);
    }
}
