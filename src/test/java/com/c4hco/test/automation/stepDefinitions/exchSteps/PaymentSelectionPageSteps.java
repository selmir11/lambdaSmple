package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.PaymentSelectionPage;
import io.cucumber.java.en.*;

public class PaymentSelectionPageSteps {
    PaymentSelectionPage paymentSelectionPage = new PaymentSelectionPage();

    @And("I Verify the text on payment selection page and signout")
    public void paymentModeSelection(){
        paymentSelectionPage.PaybyCheckPageVerification();
        paymentSelectionPage.signOutOnPaymentSelectionPage();
    }
}
