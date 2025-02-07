package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MaEligibleMembersMedicalConditionPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class MaEligibleMembersMedicalConditionSteps {

    MaEligibleMembersMedicalConditionPage maEligibleMembersMedicalConditionPage = new MaEligibleMembersMedicalConditionPage(WebDriverManager.getDriver());

    @Then("I select {string} for medical condition or disability question and Continue on Medical Condition MA page")
    public void iAnswerDisability(String yesNo) {maEligibleMembersMedicalConditionPage.answerDisability(yesNo);}

    @And("I click member on the Medical Condition MA page")
    public void iClickMember() {maEligibleMembersMedicalConditionPage.iClickMember();}

    @Then("I select {string} for medical condition or disability question on Medical Condition MA page")
    public void iAnswerDisabilityOnly(String yesNo) {maEligibleMembersMedicalConditionPage.answerDisabilityOnly(yesNo);}
    
    @And("I validate the {string} text on the Medical Condition MA page")
    public void iValidateMedicalConditionText(String language) {maEligibleMembersMedicalConditionPage.iValidateMedicalConditionText( language );}

    @And("I click continue on the Medical Condition MA page")
    public void iContinue() {maEligibleMembersMedicalConditionPage.iContinue();}


}
