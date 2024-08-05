package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.PaymentPortalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class PaymentPortalPageSteps {
    PaymentPortalPage paymentPortalPage = new PaymentPortalPage(WebDriverManager.getDriver());

//    @Then("I click all done from payment portal page")
//    public void clickAllDone(){
//        paymentPortalPage.clickAllDone();
//    }
}
