package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.CRMPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages.CRMMVRPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class CRMMVRPageSteps {

    CRMMVRPage crmMVRPage = new CRMMVRPage(WebDriverManager.getDriver());

    @Then("I check that the MVR has a status of {string}")
    public void checkMVRStatus(String status){crmMVRPage.checkMVRStatus(status);}

    @Then("I check the {string} MVR title for {string}")
    public void iCheckMVRTitle(String mvrType, String memPrefix){crmMVRPage.checkMVRTitle(mvrType, memPrefix);}
}
