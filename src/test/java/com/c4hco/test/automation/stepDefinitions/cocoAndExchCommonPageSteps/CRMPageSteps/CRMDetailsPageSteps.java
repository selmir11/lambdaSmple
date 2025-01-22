package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.CRMPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages.CRMDetailsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class CRMDetailsPageSteps {
    CRMDetailsPage crmDetailsPage = new CRMDetailsPage(WebDriverManager.getDriver());

    @And("I verify the Individual Details data in the CRM")
    public void iVerifyContactData(){crmDetailsPage.verifyDetailsData();}

    @And("I verify the broker authorization start date is today")
    public void iVerifyBrokerAuthStartDate(){crmDetailsPage.verifyBrokerAuthStartDate();}

    @And("I verify the broker authorization end date is today")
    public void iVerifyBrokerAuthEndDate(){crmDetailsPage.verifyBrokerAuthEndDate();}

    @And("I verify that the broker authorization end date is blank")
    public void iVerifyBrokerAuthBlankEndDate(){crmDetailsPage.verifyBrokerAuthBlankEndDate();}

    @And("I verify the new license number and effective dates")
    public void iVerifyBrokerLicense(){crmDetailsPage.verifyBrokerLicense();}
}
