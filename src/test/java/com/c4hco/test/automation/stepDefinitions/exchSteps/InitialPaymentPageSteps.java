package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.InitialPaymentPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class InitialPaymentPageSteps {
    // TO DO: Refactor to combine initials payment page and payment selection page - so we can click multiple make payments from one method.
    InitialPaymentPage initialPaymentPage = new InitialPaymentPage(WebDriverManager.getDriver());

    @Then("I select make payment button to pay the premium")
    public void makePayment(){
        initialPaymentPage.selectMakePaymentButton();
    }

    @Then("I select second make payment button to pay the premium")
    public void makeSecondPayment(){
        initialPaymentPage.clickSecondMakePaymentButton();
    }

    @And("I click continue on initial payment page")
    public void clickContinue(){
        initialPaymentPage.clickContinue();
    }
}
