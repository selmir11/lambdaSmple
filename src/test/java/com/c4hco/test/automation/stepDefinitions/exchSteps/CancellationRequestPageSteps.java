package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.CancellationRequestPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class CancellationRequestPageSteps {
    CancellationRequestPage cancellationRequestPage = new CancellationRequestPage(WebDriverManager.getDriver());

    @Then("Validate text in the {string} Cancellation Page in {string} Language")
    public void ValidateTextInCancellationPage(String pageDetail,String language){
        cancellationRequestPage.ValidateCancellationPageText(pageDetail,language);
    }
}
