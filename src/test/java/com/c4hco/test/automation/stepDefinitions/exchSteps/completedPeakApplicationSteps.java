package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.CompletedPeakApplicationPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class completedPeakApplicationSteps {
    CompletedPeakApplicationPage completedApplicationPage = new CompletedPeakApplicationPage(WebDriverManager.getDriver());

    @And("I click on save and continue button")
    public void selectSaveAndContinue() {
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
    public void iClickOnBackButton() {
        completedApplicationPage.backButton();
    }

    /// ////////////////////////VALIDATION STEPS///////////////////////////////////

    @And("I validate that error {string} is thrown while clicking on Continue button")
    public void iValidateErrorThrown(String errMsg) {
        completedApplicationPage.errMsgValidation(errMsg);
    }

    @When("I click on back button on the Let us guide you page")
    public void clickOnBackBtn(){
        completedApplicationPage.clickOnBackBtn();
    }

    @Then("I verify the text on Let us guide you page in {string}")
    public void verifyEnglishAndSpanishTextInLetUsGuide(String languageOption){
        completedApplicationPage.verifyEnglishAndSpanishTextInLetUsGuidePage(languageOption);
    }
}