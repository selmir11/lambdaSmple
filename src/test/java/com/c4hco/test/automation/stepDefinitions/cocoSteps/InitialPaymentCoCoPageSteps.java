package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.InitialPaymentCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class InitialPaymentCoCoPageSteps {
    InitialPaymentCoCoPage initialPaymentCoCoPage = new InitialPaymentCoCoPage(WebDriverManager.getDriver());

    @And("I select make payment button to pay the premium CoCo")
    public void makePaymentCoCo(){
        initialPaymentCoCoPage.selectMakePaymentBtnCoCo();
    }

    @And("I select continue button on the Initial Payment CoCo page")
    public void continueInitialPaymentCoCo(){
        initialPaymentCoCoPage.selectContinueCoCo();
    }
}
