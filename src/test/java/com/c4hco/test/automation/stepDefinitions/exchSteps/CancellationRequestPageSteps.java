package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.CancellationRequestPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;


public class CancellationRequestPageSteps {
    CancellationRequestPage cancellationRequestPage = new CancellationRequestPage(WebDriverManager.getDriver());

    @Then("Validate text in the Cancellation Page in {string} Language")
    public void ValidateTextInCancellationPage(String language, List<String> data){
        cancellationRequestPage.ValidateCancellationPageText(language,data);
    }

    @Then("I click Go Back on medical plan Cancellation Page")
    public void i_click_go_back_on_medical_plan_cancellation_page() {
        cancellationRequestPage.clickGoBackbtn();
    }


}
