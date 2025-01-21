package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.CompletedPeakApplicationPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class completedPeakApplicationSteps {
    CompletedPeakApplicationPage completedApplicationPage = new CompletedPeakApplicationPage(WebDriverManager.getDriver());
    @And("I click on save and continue button")
    public void selectSaveAndContinue(){
        completedApplicationPage.clickSaveAndContinueButton();
    }

    @And("I validate the verbiage on Let us guide you page in {string}")
    public void iValidateTheVerbiageOnLetUsGuideYouPage(String language) {
        completedApplicationPage.validateTheVerbiageOnLetUsGuideYouPage(language);
    }

    @And("I select {string} option on the Let us guide you page")
    public void iSelectOptionOnTheLetUsGuideYouPage(String option) {
        completedApplicationPage.iSelectOption(option);
    }

    @Then("I click on back button in Completed Peak Application page")
    public void iclickonbackbutton(){
        //WIP
        completedApplicationPage.backButton();
    }

}
