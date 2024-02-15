package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DentalPlansResultsPage;
import io.cucumber.java.en.Then;

public class DentalPlansResultsPageSteps {
    DentalPlansResultsPage dentalPlansResultsPage = new DentalPlansResultsPage();

    @Then("I select first dental plan and continue")
    public void selectDentalPlan(){
        dentalPlansResultsPage.selectFirstDentalPlan();
    }

    @Then("I click on back button on dental Plan Results")
    public void clickGoBackButton(){
        dentalPlansResultsPage.clickGoBack();
    }


}
