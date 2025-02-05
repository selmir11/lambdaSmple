package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MaEligibleMembersFullTimeStudentPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class MaEligibleMembersFullTimeStudentSteps {

    MaEligibleMembersFullTimeStudentPage maEligibleMembersFullTimeStudentPage = new MaEligibleMembersFullTimeStudentPage(WebDriverManager.getDriver());

    @Then("I select {string} for attending school full-time question and Continue on Full-Time Student MA page")
    public void iAnswerStudent(String yesNo) {maEligibleMembersFullTimeStudentPage.answerStudent(yesNo);}

    @And ("I validate the {String} text on the FullTime Student page")
    public void iValidateStudentText(String language) {maEligibleMembersFullTimeStudentPage.iValidateStudentText(language);}

    @And( "And I click continue on the FullTime Student page" )
    public void iContinue() {maEligibleMembersFullTimeStudentPage.iContinue();}

}
