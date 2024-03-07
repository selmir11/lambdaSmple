package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.PaymentSelectionCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class PaymentSelectionCoCoPageSteps {
    PaymentSelectionCoCoPage paymentSelectionCoCoPage = new PaymentSelectionCoCoPage(WebDriverManager.getDriver());

    @And("I select Continue button on the Payment Selection CoCo page")
    public void paymentSelectionCoCo(){
        paymentSelectionCoCoPage.paymentSelectionContinueCoCo();
    }
}
