package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.PaymentSelectionPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class PaymentSelectionPageSteps {
    PaymentSelectionPage paymentSelectionPage = new PaymentSelectionPage(WebDriverManager.getDriver());

    @And("I click continue on payment selection page")
    public void clickContinueOnMakePayment(){
        paymentSelectionPage.clickContinueOnPaymentPage();
    }

    @And("I Verify the text on payment selection page")
    public void paymentModeSelection(){
        paymentSelectionPage.verifyTextWithCheckPayment();
    }
}
