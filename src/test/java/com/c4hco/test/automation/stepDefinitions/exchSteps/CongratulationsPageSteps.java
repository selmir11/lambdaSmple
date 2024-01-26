package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.CongratulationsPage;
import io.cucumber.java.en.*;

public class CongratulationsPageSteps {
    CongratulationsPage congratulationsPage = new CongratulationsPage();

    @And("I click continue button on Congratulations page")
    public void iClickContinue(){
        congratulationsPage.clickSaveContinue();
    }
}
