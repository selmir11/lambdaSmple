package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;
import com.c4hco.test.automation.pages.exchPages.ExchLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static java.lang.Thread.sleep;

public class ExLoginPageSteps {
    LoginPage loginPage = new LoginPage();
    ExchLogin exLoginPage = new ExchLogin();

    @Then("I enter user name")
    public void enterUserName(){
        exLoginPage.username();
    };
    @And("I enter password")
    public void enterPassword(){
        exLoginPage.enterPwd();
    }
    @Then("I Click Sign In")
    public void clickSignin() throws InterruptedException {

        exLoginPage.signIn();
        Thread.sleep(5000);

    }
}
