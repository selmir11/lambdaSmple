package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MaEligibleMembersOutOfStatePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MaEligibleMembersOutOfStateSteps {

    MaEligibleMembersOutOfStatePage maEligibleMembersOutOfStateForMAPage = new MaEligibleMembersOutOfStatePage(WebDriverManager.getDriver());

    @Then("I select {string} temporarily absent from Colorado question and Continue on Out Of State MA page")
    public void iAnswerAbsent(String yesNo) {maEligibleMembersOutOfStateForMAPage.answerAbsent(yesNo);}

    @And( "I validate the {string} text on the Out of State MA page" )
    public void textCaretaker(String language) {maEligibleMembersOutOfStateForMAPage.textOutofStateMA(language);}

    @And ("I click continue on the Out of State MA page")
    public void iContinue() {maEligibleMembersOutOfStateForMAPage.iContinue();}

}
