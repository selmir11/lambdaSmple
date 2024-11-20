package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MaEligibleMembersMedicalConditionPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class MaEligibleMembersMedicalConditionSteps {

    MaEligibleMembersMedicalConditionPage maEligibleMembersMedicalConditionPage = new MaEligibleMembersMedicalConditionPage(WebDriverManager.getDriver());

    @Then("I select {string} for medical condition or disability question and Continue on Medical Condition MA page")
    public void iAnswerDisability(String yesNo) {maEligibleMembersMedicalConditionPage.answerDisability(yesNo);}

}
