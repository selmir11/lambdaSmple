package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MaEligibleMembersMedicalExpensesPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class MaEligibleMembersMedicalExpensesSteps {

    MaEligibleMembersMedicalExpensesPage maEligibleMembersMedicalExpensesPage = new MaEligibleMembersMedicalExpensesPage(WebDriverManager.getDriver());

    @Then("I select {string} for medical expenses question and Continue on Medical Expenses MA page")
    public void iAnswerUnder19(String yesNo) {maEligibleMembersMedicalExpensesPage.answerUnder19(yesNo);}

}
