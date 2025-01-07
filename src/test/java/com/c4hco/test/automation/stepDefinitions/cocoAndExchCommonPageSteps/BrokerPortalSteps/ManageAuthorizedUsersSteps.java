package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.ManageAuthorizedUsersPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ManageAuthorizedUsersSteps {
    ManageAuthorizedUsersPage manageAuthorizedUsersPage = new ManageAuthorizedUsersPage(WebDriverManager.getDriver());

    @Then("I validate the Manage Authorized Users page title")
    public void iValidateManageAuthorizedUsersPageTitle(){
        manageAuthorizedUsersPage.validateManageAuthorizedUsersPageTitle();
    }

    @And("I search for an authorized user {string}")
    public void iSearchForAuthorizedUserNamed(String authorizedUserName){
        manageAuthorizedUsersPage.searchForAuthorizedUserNamed(authorizedUserName);
    }

    @Then("I verify the expected number of rows displayed in the search results is {int}")
    public void iVerifySearchResultsRowCount(int expectedRowCount){
        manageAuthorizedUsersPage.verifySearchResultsRowCount(expectedRowCount);
    }

    @And("I clear the search box on the Manage Authorized Users page")
    public void iClearSearchBox(){
        manageAuthorizedUsersPage.clearSearchBox();
    }
}
