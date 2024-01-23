package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.cocoPages.LoginPage;
import com.c4hco.test.automation.pages.exchPages.ExCreateAccount;
import com.c4hco.test.automation.pages.exchPages.ExchLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Thread.sleep;

public class ExLoginPageSteps {
    LoginPage loginPage = new LoginPage();
    ExchLogin exLoginPage = new ExchLogin();

//    @Given("I am on login page")
//    public void validateHeaderLoginPage() throws InterruptedException {
//        //loginPage.openPage();
//        //exLoginPage.validateLoginPage();
//    };
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
