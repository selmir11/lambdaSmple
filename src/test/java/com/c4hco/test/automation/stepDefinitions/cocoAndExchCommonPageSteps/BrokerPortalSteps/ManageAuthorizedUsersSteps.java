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

    @Then("I click the Add Authorized User link")
    public void iClickAddAuthorizedUserLink(){
        manageAuthorizedUsersPage.clickAddAuthorizedUserLink();
    }

    @Then("I click the Resend Invite link")
    public void iClickResendInviteLink(){
        manageAuthorizedUsersPage.clickResendInviteLink();
    }

    @And("I verify the Invite Sent confirmation message")
    public void iVerifyInviteSentMessage(){
        manageAuthorizedUsersPage.verifyInviteSentMessage();
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

    @And("I verify the admin staff details displayed")
    public void iVerifyAdminStaffDetails(){
        manageAuthorizedUsersPage.verifyAdminStaffDetails();
    }

    @Then("I click the Remove link for admin staff")
    public void iClickRemoveLinkAdminStaff(){
        manageAuthorizedUsersPage.clickRemoveLinkAdminStaff();
    }

    @And("I verify the admin staff invite is removed")
    public void iVerifyAdminStaffRemoved(){
        manageAuthorizedUsersPage.verifyAdminStaffRemoved();
    }
}
