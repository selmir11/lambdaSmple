package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.PrescreenPage;
import com.c4hco.test.automation.pages.exchPages.ExCreateAccount;
import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.java.en.*;

public class EXCreateAccountPageSteps {
    LoginPage loginPage = new LoginPage();
    PrescreenPage prescreenPage = new PrescreenPage();
    ExCreateAccount exCreateAccount = new ExCreateAccount();

    BasicActions basicActions = new BasicActions();

//    @Given ("I open the login page on the login portal")
//    public void open_the_login_page_on_the_login_portal(){
//        loginPage.openPage();
//    }


//    @When("I click create a new account on login page")
//    public void iClickCreateNewAccount() {
//        loginPage.clickCreateAccount();
//    }


//    @Then("I click create my account from pre-screen page")
//    public void clickPreScreenCreateAccount()  {
//        prescreenPage.clickCreateAccountLink();
//    };

//    @And("I enter the member details")
//    public void enterMemberDetails() {
//        exCreateAccount.createExAccount();
//    }

//    @Then ("I click on submit button")
//    public void clickSubmit() throws InterruptedException {
//        exCreateAccount.submit();
//    }

    @Then("Close browser")
    public void close_browser() {
        basicActions.closeBrowser();
    }
    @Then("Close current browser tab")
    public void closeBrowserTab() {
        basicActions.closeBrowserTab();
    }

}
