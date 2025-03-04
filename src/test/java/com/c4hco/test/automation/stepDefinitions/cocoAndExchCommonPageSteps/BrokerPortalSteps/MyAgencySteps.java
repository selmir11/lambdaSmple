package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.MyAgencyPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MyAgencySteps {
    MyAgencyPage myAgencyPage = new MyAgencyPage(WebDriverManager.getDriver());

    @Then("I approve the agency invite")
    public void myAgencyApproveInvite(){
        myAgencyPage.approveAgencyInvite();
    }

    @Then("I deny the agency invite")
    public void myAgencyDenyInvite(){
        myAgencyPage.denyAgencyInvite();
    }

    @Then("I verify the current agency invitation details are {string}, {string} and {string}")
    public void iVerifyAgencyInviteStatus(String agencyInviteName, String agencyPhone, String inviteStatus){
        myAgencyPage.verifyAgencyInviteStatus(agencyInviteName, agencyPhone, inviteStatus);
    }

    @And("I verify there are no agency invites")
    public void iVerifyNoPendingAgencyInvites(){
        myAgencyPage.verifyNoPendingAgencyInvites();
    }

    @Then("I click Go Back on the My Agency page")
    public void clickGoBackManageAssocBrokersPage(){
        myAgencyPage.clickGoBackManageAssocBrokers();
    }

    @Then("I approve the second agency invite")
    public void approveSecondInvite(){
        myAgencyPage.approveSecondAgencyInvite();
    }

    @And("I verify the unable to accept more than one agency invite error message")
    public void verifyUnableAcceptMultipleInvites(){
        myAgencyPage.verifyUnableToAcceptMultipleInvites();
    }

    @Then("I click OK to the agency invite error message")
    public void clickOkAgencyErrorMessage(){
        myAgencyPage.clickOkAgencyInviteErrorMessage();
    }
}
