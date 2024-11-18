package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.CRMPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages.CRMContactPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CRMContactPageSteps {
    CRMContactPage crmContactPage = new CRMContactPage(WebDriverManager.getDriver());

    @Then("I open the MVRDVR Tab on contact page")
    public void openMVRDVRTab(){crmContactPage.openMVRDVRTab();}

    @Then("I open the {string} MVR")
    public void openMVRDetails(String mvrType){crmContactPage.openMVRByTypeName(mvrType);}

    @Then("I open the {string} DVR number {int} in the CRM")
    public void iOpenDVRDetails(String dvrType, int typeNumber){crmContactPage.openDVRByTypeName(dvrType, typeNumber);}

// ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line

    @And("I verify the {string} DVR number {int} is {string} in the CRM")
    public void iVerifyStatus(String dvrType, int typeNumber, String status){crmContactPage.verifyStatus(dvrType, typeNumber, status);}
}
