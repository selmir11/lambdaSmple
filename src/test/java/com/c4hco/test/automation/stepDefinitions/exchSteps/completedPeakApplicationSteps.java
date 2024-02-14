package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.CompletedPeakApplicationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class completedPeakApplicationSteps {
    CompletedPeakApplicationPage completedApplicationPage = new CompletedPeakApplicationPage();
    @Then("I select No Thanks option from guide you section")
    public void iSelectNoThanks(){
        completedApplicationPage.selectNoThanksOption();
    }
    @And("I click on save and continue button")
    public void selectSaveAndContinue(){
        completedApplicationPage.clickSaveAndContinueButton();
    }

    @Then("I should see the header text {string} on Let us guide you page")
    public void verifyHeaderText(String expectedHeaderText) {
        completedApplicationPage.verifyPageHeaderLetUsGuideYouText(expectedHeaderText);
    }

    @And("I should see the enrollment info message {string}")
    public void verifyEnrollmentInfoMessage(String expectedBodyText) {
        completedApplicationPage.verifyEnrollmentInfoMessageText(expectedBodyText);
    }

    @And("I should see the case ID info message {string}")
    public void verifyCaseIdInfoMessage(String expectedCaseIdText) {
        completedApplicationPage.verifyCaseIDInfoMessageText(expectedCaseIdText);
    }

    @And("I should see the yes radio button text {string}")
    public void verifyYesRadioButtonText(String expectedYesRadioButtonText) {
        completedApplicationPage.verifyYesImNewText(expectedYesRadioButtonText);
    }

    @And("I should see the no radio button text {string}")
    public void verifyNoRadioButtonText(String expectedNoRadioButtonText) {
        completedApplicationPage.verifyNoThanksRadioButtonText(expectedNoRadioButtonText);
    }

    @And("I should see the text on the Back button {string}")
    public void verifyBackButtonText(String expectedBackButtonText) {
        completedApplicationPage.verifyBackButtonLinkText(expectedBackButtonText);
    }

    @And("I should see the text on the Continue button {string}")
    public void verifyContinueButtonText(String expectedContinueButtonText) {
        completedApplicationPage.isSaveAndContinueButtonInteractable();
    }

    @When("I switch to {string}")
    public void iSwitchTo(String switchTo) {
        completedApplicationPage.selectLocale(switchTo);

    }

    @Then("I should see the header text {string}")
    public void iShouldSeeTheHeaderTextOnPermitanosGuiarloPage(String expectedHeaderText) {
        completedApplicationPage.verifyPageHeaderPermitanosGuiarlo(expectedHeaderText);
    }

    @And("I should see the enrollment info message in Spanish {string}")
    public void iShouldSeeTheEnrollmentInfoMessageInSpanish(String expectedBodyText) {
        completedApplicationPage.verifyEnrollmentInfoMessageEs(expectedBodyText);
    }

    @And("I should see the case ID info message in Spanish {string}")
    public void iShouldSeeTheCaseIDInfoMessageInSpanish(String expectedCaseIdText) {
        completedApplicationPage.verifyCaseIDInfoMessageEs(expectedCaseIdText);
    }

    @And("I should see the yes radio button text in Spanish {string}")
    public void iShouldSeeTheYesRadioButtonTextInSpanish(String expectedYesRadioButtonText) {
        completedApplicationPage.verifyYesImNewTextEs(expectedYesRadioButtonText);
    }

    @And("I should see the no radio button in Spanish {string}")
    public void iShouldSeeTheNoRadioButtonInSpanish(String expectedNoRadioButtonText) {
        completedApplicationPage.verifyNoGraciasEs(expectedNoRadioButtonText);
    }

    @And("I should see the text on the back button in Spanish {string}")
    public void iShouldSeeTheTextOnTheBackButtonInSpanish(String expectedBackButtonText) {
        completedApplicationPage.verifyBackButtonEs(expectedBackButtonText);
    }

    @And("I should see the text on the Continue button in Spanish {string}")
    public void iShouldSeeTheTextOnTheContinueButtonInSpanish(String expectedSaveButtonText) {
        completedApplicationPage.isSaveAndContinueButtonInteractableEs();
    }
}
