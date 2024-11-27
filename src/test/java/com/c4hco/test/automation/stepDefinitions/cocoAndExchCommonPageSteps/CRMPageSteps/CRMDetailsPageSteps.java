package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.CRMPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages.CRMDetailsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class CRMDetailsPageSteps {
    CRMDetailsPage crmDetailsPage = new CRMDetailsPage(WebDriverManager.getDriver());

    @And("I verify the Individual Details data in the CRM")
    public void iVerifyContactData(){crmDetailsPage.verifyDetailsData();}
}
