package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TellUsAboutYourselfPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class TellUsAboutYourselfPageSteps {
    TellUsAboutYourselfPage tellUsAboutYourselfPage = new TellUsAboutYourselfPage(WebDriverManager.getDriver());

    @Then("I select {string} as sex option")
    public void userSexQuestion(String Sex) {
        tellUsAboutYourselfPage.userSexQuestion(Sex);
    }

    @Then("I select {string} to Are You Applying")
    public void isUserApplyingForInsurance(String YNApplying) {
        tellUsAboutYourselfPage.isUserApplyingForHealthInsurance(YNApplying);
    }

    @Then("I click continue on Tell us about yourself page")
    public void clickContinue() {
        tellUsAboutYourselfPage.saveAndContinue();
    }

    @Then("I update SSN number to new SSN number {string}")
    public void updateSSN(String newSsn) {
        tellUsAboutYourselfPage.iUpdateSSN(newSsn);

    }

    @Then("I update Full Name to new Name")
    public void iUpdateName() {
        tellUsAboutYourselfPage.updateName();
    }

    @Then("I update DOB to new DOB of {string}")
    public void iUpdateDOB(String newDob) {
        tellUsAboutYourselfPage.updateDOB(newDob);
    }


}
