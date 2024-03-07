package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.CongratulationsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class CongratulationsCoCoPageSteps {
    CongratulationsCoCoPage congratulationsCoCoPage = new CongratulationsCoCoPage(WebDriverManager.getDriver());

    @And("I click continue button on Congratulations page CoCo")
    public void iClickContinueCogratsCoCo(){
        congratulationsCoCoPage.clickSaveContinueCongratsCoCo();
    }
}
