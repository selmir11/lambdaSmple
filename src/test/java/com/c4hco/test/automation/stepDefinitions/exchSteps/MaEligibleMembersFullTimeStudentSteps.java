package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MaEligibleMembersFullTimeStudentPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class MaEligibleMembersFullTimeStudentSteps {

    MaEligibleMembersFullTimeStudentPage maEligibleMembersFullTimeStudentPage = new MaEligibleMembersFullTimeStudentPage(WebDriverManager.getDriver());

    @Then("I select {string} for attending school full-time question and Continue on Full-Time Student MA page")
    public void iAnswerStudent(String yesNo) {maEligibleMembersFullTimeStudentPage.answerStudent(yesNo);}

}
