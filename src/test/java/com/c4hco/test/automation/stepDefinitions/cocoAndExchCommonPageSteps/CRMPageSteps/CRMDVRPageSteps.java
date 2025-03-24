package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.CRMPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages.CRMDVRPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CRMDVRPageSteps {

    CRMDVRPage crmDVRPage = new CRMDVRPage(WebDriverManager.getDriver());

    @Then("I check the {string} DVR title in the CRM")
    public void iCheckDVRTitle(String dvrType){crmDVRPage.checkDVRTitle(dvrType);}

    @Then("I check the {string} DVR Name and Doc Type in the CRM")
    public void iCheckDVRNameDocType(String dvrType){crmDVRPage.checkDVRNameDocType(dvrType);}

    @Then("I get the time and date of DVR in the CRM")
    public void iGetDvrTimeDate(){crmDVRPage.getDvrTimeDate();}

    @And("I verify time and date of DVR is {string} in the CRM")
    public void iCompareLastTwoDvrDateTimes(String matchType){crmDVRPage.compareLastTwoDvrDateTimes(matchType);}

    @Then("I click Deactivate button in CRM")
    public void iClickDeactivateButtonInCRM() {
        crmDVRPage.clickDeactivateButtonInCRM();    }
}
