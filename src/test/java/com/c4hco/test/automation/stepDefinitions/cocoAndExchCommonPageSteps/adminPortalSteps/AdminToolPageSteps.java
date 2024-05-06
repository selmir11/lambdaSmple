package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminLceToolPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdminToolPageSteps {
    AdminLceToolPage adminLceToolPage = new AdminLceToolPage(WebDriverManager.getDriver());

    @And("I look up with account id on admin tool page")
    public void lookUpWithAccId(){
        adminLceToolPage.lookUpAccId();
    }

    @And("I change effective date to {string} of current year from admin portal")
    public void changeEffDate(String monthDate){
            adminLceToolPage.changeEffectiveDate(monthDate);
    }

    @And("I validate page title")
    public void iValidateTitleAdminLceTool() {adminLceToolPage.validatePageTitle();}

    @And("I validate page title text")
    public void iValidatePageTitle() {
        adminLceToolPage.titleText();      }
    @And("I validate  Account Number text displays")
    public void iValidateAccountNumberText() {
        adminLceToolPage.validateAccountNumberText();      }
    @Then("logout from Admin Portal LCE")
    public void logoutAdminPortal() {
        adminLceToolPage.logoutFromAdminLce();
    }
}
