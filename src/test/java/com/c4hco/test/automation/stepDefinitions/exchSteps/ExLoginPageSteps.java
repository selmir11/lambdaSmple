//package com.c4hco.test.automation.stepDefinitions.exchSteps;
//
//import com.c4hco.test.automation.pages.exchPages.ExchLogin;
//import com.c4hco.test.automation.utils.WebDriverManager;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//
//public class ExLoginPageSteps {
//    ExchLogin exLoginPage = new ExchLogin(WebDriverManager.getDriver());
//
//    @Then("I enter user name")
//    public void enterUserName(){
//        exLoginPage.username();
//    };
//    @And("I enter password")
//    public void enterPassword(){
//        exLoginPage.enterPwd();
//    }
//    @Then("I Click Sign In")
//    public void clickSignin() throws InterruptedException {
//
//        exLoginPage.signIn();
//        // TO DO::: REMOVE THIS THREAD.SLEEP
//        Thread.sleep(5000);
//
//    }
//}
