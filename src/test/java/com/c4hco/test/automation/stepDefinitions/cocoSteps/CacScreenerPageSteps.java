package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.CacScreenerPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CacScreenerPageSteps {
    CacScreenerPage cacScreenerPage = new CacScreenerPage(WebDriverManager.getDriver());

    @Then("I click continue signing in on the CAC Screener page")
    public void iClickSaveAndContinue(){cacScreenerPage.clickSaveAndContinue();}

    @Then("I click on {string} option for {string} on CAC Screener page")
    public void iAnswerQuestions(String answer, String question) { cacScreenerPage.answerQuestions(answer, question); }

    @Then("I click See results button on the CAC Screener page")
    public void iClickSeeResults(){cacScreenerPage.clickSeeResults();}

    @Then("I click Retake quiz button on the CAC Screener page")
    public void iClickRetakeQuiz(){cacScreenerPage.clickRetakeQuiz();}





    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    @And("I validate CAC Screener questions are {string} in {string}")
    public void iValidateQuestionsDisabledEnabled(String status, String language) { cacScreenerPage.QuestionsDisabledEnabled(status, language); }

    @And("I validate results option for {string} on CAC Screener page displays in {string}")
    public void iValidateSearchResults(String screenerOption, String language) { cacScreenerPage.validateSearchResults(screenerOption, language); }

    @And("I validate results option for {string} on CAC Screener page does not display")
    public void iValidateResultsNotDisplay(String screenerOption) { cacScreenerPage.validateResultsNotDisplay(screenerOption); }

    @And("I validate {string} option for {string} on CAC Screener page is {string}")
    public void iValidateQuestions(String answer, String question, String status) { cacScreenerPage.validateQuestions(answer, question, status); }

    @And("I validate the {string} text for CAC Screener page in {string}")
    public void iValidatePageText(String section, String language) { cacScreenerPage.validatePageText(section, language); }

    @And("I validate CAC Screener See results is {string}")
    public void iValidateSeeResultsDisabledEnabled(String status) { cacScreenerPage.SeeResultsDisabledEnabled(status); }



}