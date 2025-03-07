package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.AddAuthorizedUsersPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddAuthorizedUsersSteps {
    AddAuthorizedUsersPage addAuthorizedUsersPage = new AddAuthorizedUsersPage(WebDriverManager.getDriver());

    @And("I enter the email address for the new admin staff")
    public void iEnterAdminStaffEmail(){
        addAuthorizedUsersPage.enterAdminStaffEmail();
    }

    @Then("I click Save and Submit on the Add Authorized Users page")
    public void iClickSaveSubmitAddAuthorizedUsersPage(){
        addAuthorizedUsersPage.clickSaveSubmitAddAuthorizedUsersPage();
    }
}
