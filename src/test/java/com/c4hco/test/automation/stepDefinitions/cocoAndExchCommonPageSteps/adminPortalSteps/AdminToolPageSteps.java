package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages.AdminLceToolPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdminToolPageSteps {
    AdminLceToolPage adminLceToolPage = new AdminLceToolPage(WebDriverManager.getDriver());

    @And("I look up with account id on admin tool page")
    public void lookUpWithAccId(){
        adminLceToolPage.lookUpAccId();
    }

    @Then("I validate the plan year dropdown options as last 4years")
    public void validatePlanYrDropdown(){
        adminLceToolPage.validatePlanYearOptions();
    }

    @And("I change effective date to {string} of {string} from admin portal")
    public void changeEffDate(String monthDate, String planYear){
            adminLceToolPage.changeEffectiveDate(monthDate, planYear);
    }

    @And("I validate Admin Lce container title text")
    public void iValidatePageTitle() {
        adminLceToolPage.verifyAdminLceContainerTitle();      }

    @Then("I logout from Admin Portal LCE")
    public void iLogoutAdminPortal() {
        adminLceToolPage.logoutFromAdminLce();
    }
    @And("I initiate incoming page")
    public void iInitiateIncomingPage() {
        adminLceToolPage.initiateIncomingPage();
    }
}
