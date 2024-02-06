package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPage;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import io.cucumber.java.en.*;

import java.time.Duration;

import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.waitFor;

public class AdminPageSteps {
        AdminPage adminPage = new AdminPage();
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
        createAccountPage.implicitWait(2000);
        adminPage.navigateToPreviousPage();
        createAccountPage.waitForClickablility(adminPage.dropdownArrow, Duration.ofSeconds(2000));
        adminPage.dropdownArrow.click();
        createAccountPage.waitForVisibility(adminPage.logoutAdmin, Duration.ofSeconds(2000));
        adminPage.logoutAdmin.click();
        createAccountPage.implicitWait(2000);
       // adminPage.closeBrowser();
    }
}
