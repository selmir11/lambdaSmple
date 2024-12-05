package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.CRMPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages.CRMContactPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CRMContactPageSteps {
    CRMContactPage crmContactPage = new CRMContactPage(WebDriverManager.getDriver());

    @Then("I open the {string} Tab on contact page")
    public void iOpenCrmTab(String tabType){crmContactPage.openCrmTab(tabType);}

    @Then("I open the {string} MVR")
    public void openMVRDetails(String mvrType){crmContactPage.openMVRByTypeName(mvrType);}

    @Then("I open the {string} DVR number {int} in the CRM")
    public void iOpenDVRDetails(String dvrType, int typeNumber){crmContactPage.openDVRByTypeName(dvrType, typeNumber);}

    @Then("I change the sort of Status Reason DVR to A to Z in the CRM")
    public void iSortStatusAToZ(){crmContactPage.sortStatusAToZ();}

// ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line

    @And("I verify the {string} DVR number {int} is {string} in the CRM")
    public void iVerifyStatus(String dvrType, int typeNumber, String status){crmContactPage.verifyStatus(dvrType, typeNumber, status);}

    @And("I verify the Individual Contact data in the CRM")
    public void iVerifyContactData(){crmContactPage.verifyContactData();}

    @And("I verify the contact type is {string}")
    public void iVerifyContactType(String contactType){crmContactPage.verifyContactType(contactType);}
}
