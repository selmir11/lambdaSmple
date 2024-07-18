package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.CongratulationsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CongratulationsCoCoPageSteps {
    CongratulationsCoCoPage congratulationsCoCoPage = new CongratulationsCoCoPage(WebDriverManager.getDriver());
    @And("I click continue button on Congratulations page CoCo")
    public void iClickContinueCogratsCoCo(){
        congratulationsCoCoPage.clickSaveContinueCongratsCoCo();
    }

    @Then("I validate the text on the congratulations page coco")
    public void validateCongratulationsPageText(){
        congratulationsCoCoPage.validatePageText();
    }
}
