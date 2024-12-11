package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.CRMPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages.CRMDashboardPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class CRMDashboardPageSteps {
    CRMDashboardPage crmDashboardPage = new CRMDashboardPage(WebDriverManager.getDriver());

    @Then("I search for user's Email")
    public void searchUserViaEmail(){crmDashboardPage.CRMDashboardSearchUserEmailandOpenFirst();}

    @Then("I search for {string} name")
    public void searchBrokerViaName(String brokerType){crmDashboardPage.CRMDashboardSearchBrokerNameandOpenFirst(brokerType);}

    @Then("I search for user by Email Staging {string} QA {string} in CRM")
    public void iSearchByUserEmail(String stageEmail, String qaEmail){crmDashboardPage.searchByUserEmail(stageEmail, qaEmail);}

    @Then("I click the Go Back arrow in CRM")
    public void iClickGoBack(){crmDashboardPage.clickGoBack();}

    @Then("I sign out of CRM")
    public void iSignOutOfCrm(){crmDashboardPage.signOutOfCrm();}
}
