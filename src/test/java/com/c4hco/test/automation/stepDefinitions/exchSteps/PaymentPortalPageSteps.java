package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.PaymentPortalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class PaymentPortalPageSteps {
    PaymentPortalPage paymentPortalPage = new PaymentPortalPage(WebDriverManager.getDriver());

    @Then("I click all done from payment portal page")
    public void clickAllDone(){
       paymentPortalPage.clickAllDone();
    }

    @Then("I click all done from payment portal page OBO")
    public void clickAllDoneObo(){
       paymentPortalPage.clickAllDoneObo();
    }

    @Then("I click Pay Now button payment portal page")
    public void clickPayNowButton(){paymentPortalPage.clickPayNowButton();
    }
    @Then("I enter user password on payment portal page")
    public void password() {paymentPortalPage.password();
    }

    @Then("I click continue on payment portal page")
    public void clickContinue() {paymentPortalPage.clickContinue();
    }
    @Then("I click Pay Later button payment portal page")
    public void clickPayLaterButton() {paymentPortalPage.clickPayLaterButton();
    }
    @Then("I click Pay Later Continue")
    public void clickPayLaterContinue() {paymentPortalPage.clickPayLaterContinue();
    }
    @Then("I verify text for disabled issuers on Payment Portal Page")
    public void verifyDisabledTextonPaymentPage()  {paymentPortalPage.verifyDisabledTextonPaymentPage();
    }

}
