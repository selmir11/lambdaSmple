package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.DentalPlansResultsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class DentalPlansResultsPageSteps {
    DentalPlansResultsPage dentalPlansResultsPage = new DentalPlansResultsPage(WebDriverManager.getDriver());

    @Then("I select first dental plan")
    public void selectDentalPlan(){
        dentalPlansResultsPage.selectFirstDentalPlan();
    }
    @Then("I click continue on dental plan results page")
    public void iClickContinueOnDentalResultsPage(){
        dentalPlansResultsPage.iclickContinueOnDentalResultsPage();
    }

    @Then("I click on back button on dental Plan Results")
    public void clickGoBackButton(){
        dentalPlansResultsPage.clickGoBack();
    }


}
