package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MaEligibleMembersCareTakerPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class MaEligibleMembersCareTakerSteps {

    MaEligibleMembersCareTakerPage maEligibleMembersCareTakerForMAPage = new MaEligibleMembersCareTakerPage(WebDriverManager.getDriver());

    @Then("I select {string} for under the age of 19 question and Continue on ParentCaretaker MA page")
    public void iAnswerUnder19(String yesNo) {maEligibleMembersCareTakerForMAPage.answerUnder19(yesNo);}

    @Then( "I validate the {String} text on the Caretaker page" )
    public void textCaretaker(String language) {maEligibleMembersCareTakerForMAPage.textCaretaker(language);}


}