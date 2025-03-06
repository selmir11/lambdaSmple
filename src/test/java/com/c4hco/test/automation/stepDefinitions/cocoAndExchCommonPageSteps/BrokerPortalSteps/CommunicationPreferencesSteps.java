package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.CommunicationPreferencesPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CommunicationPreferencesSteps {
    CommunicationPreferencesPage communicationPreferencesPage = new CommunicationPreferencesPage(WebDriverManager.getDriver());

    @Then("I click Continue on the Communication Preferences page")
    public void iClickContinueCommunicationsPreferencesPage(){
        communicationPreferencesPage.clickContinueCommunicationPreferencesPage();
    }

    @Then("I click Go Back on the Communication Preferences page")
    public void iClickGoBackCommunicationsPreferencesPage(){
        communicationPreferencesPage.clickGoBackCommunicationPreferencesPage();
    }

    @Then("I validate the Communication Preferences page title")
    public void iValidateCommunicationsPreferencesPageTitle(){
        communicationPreferencesPage.validateCommunicationPreferencesPageTitle();
    }

    @And("I validate the field labels on the Communication Preferences page")
    public void iValidateFieldLabelsCommunicationPreferencesPage(){
        communicationPreferencesPage.validateFieldLabels();
    }

    @And("I validate the email field shows my email")
    public void iValidateEmailFieldAutoPopulated(){
        communicationPreferencesPage.validateEmailAutoPopulated();
    }

    @And("I validate the phone number field shows my phone number")
    public void iValidatePhoneNumberFieldAutoPopulated(){
        communicationPreferencesPage.validatePhoneNumberAutoPopulated();
    }

    @Then("I validate the required fields error messages")
    public void iValidateRequiredFieldsErrorMessages(){
        communicationPreferencesPage.validateRequiredFieldsErrorMessages();
    }

    @Then("I validate the valid entries error messages")
    public void iValidateValidErrorMessages(){
        communicationPreferencesPage.validateValidErrorMessages();
    }

}
