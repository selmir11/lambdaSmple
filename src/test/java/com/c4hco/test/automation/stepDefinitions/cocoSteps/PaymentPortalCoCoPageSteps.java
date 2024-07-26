package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.PaymentPortalCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class PaymentPortalCoCoPageSteps {
    PaymentPortalCoCoPage paymentPortalCoCoPage = new PaymentPortalCoCoPage(WebDriverManager.getDriver());

    @Then("I click all done from payment portal page")
    public void clickAllDone(){
        paymentPortalCoCoPage.clickAllDone();
    }
}
