package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPage;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Utils;
import io.cucumber.java.en.*;

import java.time.Duration;



public class AdminPageSteps {
        AdminPage adminPage = new AdminPage();
        Utils utils = new Utils();
        BasicActions basicActions = new BasicActions();
        CreateAccountPage createAccountPage = new CreateAccountPage();

    @Then("I click create account on admin portal")
    public void i_click_create_account_on_admin_portal() {
        adminPage.clickCreateAccount();
    }



    @Then("logout from Admin Portal")
    public void logout_from_admin_portal() {
        adminPage.logoutFromAdmin();

    }
}
