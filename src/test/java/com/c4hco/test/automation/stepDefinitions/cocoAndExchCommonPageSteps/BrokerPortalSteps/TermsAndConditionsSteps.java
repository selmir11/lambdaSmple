package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.TermsAndConditionsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TermsAndConditionsSteps {
    TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(WebDriverManager.getDriver());

    @Then("I click Submit on the Broker Portal Terms page")
    public void iClickSubmitBrokerPortalTermsPage(){
        termsAndConditionsPage.clickSubmitBrokerPortalTermsPage();
    }

    @Then("I click Go to my Dashboard")
    public void iClickGoToMyDashboard(){
        termsAndConditionsPage.clickGoToMyDashboard();
    }
}
