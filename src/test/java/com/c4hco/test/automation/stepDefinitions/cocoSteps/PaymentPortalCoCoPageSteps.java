package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.PaymentPortalCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class PaymentPortalCoCoPageSteps {
    PaymentPortalCoCoPage paymentPortalCoCoPage = new PaymentPortalCoCoPage(WebDriverManager.getDriver());

    @Then("I click all done from payment portal page coco")
    public void clickAllDoneCoCo(){
        paymentPortalCoCoPage.clickAllDoneCoCo();
    }

    @Then("I click all done obo from payment portal page coco")
    public void clickAllDoneOboCoCo(){
        paymentPortalCoCoPage.clickAllDoneOboCoCo();
    }

    @Then("I verify text for disabled issuers on Payment Portal Page CoCo")
    public void verifyDisabledTextonPaymentPageCoCO()  {paymentPortalCoCoPage.verifyDisabledTextonPaymentPageCoCO();
    }
}
