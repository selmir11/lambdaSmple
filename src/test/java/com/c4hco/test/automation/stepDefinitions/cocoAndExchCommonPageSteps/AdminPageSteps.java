package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPage;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import com.c4hco.test.automation.utils.Utils;
import io.cucumber.java.en.*;

import java.time.Duration;



public class AdminPageSteps {
        AdminPage adminPage = new AdminPage();
        Utils utils = new Utils();
        CreateAccountPage createAccountPage = new CreateAccountPage();

    @Then("I click create account on admin portal")
    public void i_click_create_account_on_admin_portal() {
        adminPage.clickCreateAccount();
    }

    @And("I validate I am on Admin dashboard")
    public void i_validate_i_am_on_admin_dashboard() {
        adminPage.validateAdminPage();
    }

    @Then("logout from Admin Portal")
    public void logout_from_admin_portal() {
        utils.implicitWait(2000);
        adminPage.navigateToPreviousPage();
        utils.waitForClickablility(adminPage.dropdownArrow, Duration.ofSeconds(2000));
        adminPage.dropdownArrow.click();
        utils.waitForVisibility(adminPage.logoutAdmin, Duration.ofSeconds(2000));
        adminPage.logoutAdmin.click();
        utils.implicitWait(2000);
       // adminPage.closeBrowser();
    }
}
