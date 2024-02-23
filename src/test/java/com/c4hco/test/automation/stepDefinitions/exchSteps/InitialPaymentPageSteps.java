package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.InitialPaymentPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class InitialPaymentPageSteps {
    InitialPaymentPage initialPaymentPage = new InitialPaymentPage(WebDriverManager.getDriver());

    @Then("I select make payment button to pay the premium")
    public void makePayment(){
        initialPaymentPage.selectMakePaymentButton();
    }
}
