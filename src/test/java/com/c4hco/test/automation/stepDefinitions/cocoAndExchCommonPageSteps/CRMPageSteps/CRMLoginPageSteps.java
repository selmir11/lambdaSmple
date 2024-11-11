package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.CRMPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages.CRMLoginPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class CRMLoginPageSteps {
    CRMLoginPage crmLoginPage = new CRMLoginPage(WebDriverManager.getDriver());

    @Then("I log into the CRM system")
    public void openCRM(){crmLoginPage.openCRM();}
}
