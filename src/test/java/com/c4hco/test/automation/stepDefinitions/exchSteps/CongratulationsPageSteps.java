package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.CongratulationsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class CongratulationsPageSteps {
    CongratulationsPage congratulationsPage = new CongratulationsPage(WebDriverManager.getDriver());

    @And("I click continue button on Congratulations page")
    public void iClickContinue(){
        congratulationsPage.clickSaveContinue();
    }

    @And("I validate the verbiage on the RIDP - Congratulations page in {string}")
    public void iValidateTheVerbiageOnTheRIDPCongratulationsPage(String language) {
        congratulationsPage.validateTheVerbiageOnTheRIDPCongratulationsPage(language);
    }
}
