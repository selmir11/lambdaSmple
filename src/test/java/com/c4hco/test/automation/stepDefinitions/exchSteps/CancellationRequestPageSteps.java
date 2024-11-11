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

    @Then("I click continue on Cancellation Request page")
    public void i_click_continue_on_Cancellation_Request_page(){
        cancellationRequestPage.clickContinuebtn();
    }

    @Then("Validate validation message displayed in expected Language")
    public void ValidateValidationMessage(List<String> data){
        cancellationRequestPage.verifyValidationMessageText(data);
    }

    @Then("I cancel the active plan detail")
    public void i_cancel_the_active_plan_detail(){
        cancellationRequestPage.cancelActivePlan();
    }
    @Then("I affirm and cancel the active plan")
    public void cancelPlan(){
        cancellationRequestPage.cancelPlan();
    }

    @Then("I click Okay on Thank you popup")
    public void okaybtn(){
        cancellationRequestPage.okaybtn();
    }


    @Then("I validate Confirmation popup message displayed in expected Language")
    public void validateConfirmationPpopupInExpectedLanguage(List<String> data) throws InterruptedException {
        cancellationRequestPage.cancellationPlanPoupMessage(data);
    }

}
