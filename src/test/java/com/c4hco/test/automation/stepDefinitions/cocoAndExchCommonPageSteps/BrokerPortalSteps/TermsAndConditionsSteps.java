package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.TermsAndConditionsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TermsAndConditionsSteps {
    TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(WebDriverManager.getDriver());

    @Then("I validate the Terms and Conditions page title")
    public void iValidateTermsPageTitle(){
        termsAndConditionsPage.validateTermsPageTitle();
    }

    @And("I validate the Terms and Conditions text")
    public void iValidateTermsConditionsText(){
        termsAndConditionsPage.validateTermsConditionsText();
    }

    @And("I validate the Submit button is disabled")
    public void iValidateSubmitButtonDisabled(){
        termsAndConditionsPage.validateSubmitButtonDisabled();
    }

    @And("I validate the error message text for the mandatory terms and conditions agreement")
    public void iValidateTermsAgreementError(){
        termsAndConditionsPage.validateTermsAgreementError();
    }

    @And("I validate the Term and Conditions checkbox text")
    public void iValidateTermsCheckboxText(){
        termsAndConditionsPage.validateTermsCheckboxText();
    }

    @Then("I click Submit on the Broker Portal Terms page")
    public void iClickSubmitBrokerPortalTermsPage(){
        termsAndConditionsPage.clickSubmitBrokerPortalTermsPage();
    }

    @Then("I click the checkbox to agree to the Broker Portal Terms and Conditions")
    public void iAgreeBrokerPortalTermsPage(){
        termsAndConditionsPage.agreeBrokerPortalTermsPage();
    }

    @Then("I click Go Back on the Terms and Conditions page")
    public void iClickGoBackTermsConditions(){
        termsAndConditionsPage.clickGoBackTermsConditions();
    }

    @Then("I click Go to my Dashboard")
    public void iClickGoToMyDashboard(){
        termsAndConditionsPage.clickGoToMyDashboard();
    }
}
