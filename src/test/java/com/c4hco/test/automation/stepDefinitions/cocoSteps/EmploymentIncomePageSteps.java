package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.EmploymentIncomePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class EmploymentIncomePageSteps {
    EmploymentIncomePage employmentIncomePage = new EmploymentIncomePage(WebDriverManager.getDriver());

    @And("I select {string} employment option")
    public void iSelectMemberEmployment(String memberEmployment){employmentIncomePage.answerEmploymentQs(memberEmployment);}

    @And("I enter {string} income amount")
    public void iEnterIncomeAmount(String incomeAmount){employmentIncomePage.enterIncomeAmount(incomeAmount);}

    @And("I select {string} income frequency option")
    public void iSelectIncomeFrequency(String incomeFrequency){employmentIncomePage.selectIncomeFrequency(incomeFrequency);}

    @And("I select {string} income seasonal option")
    public void iSelectIncomeSeasonal(String incomeSeasonal){employmentIncomePage.answerIsIncomeSeasonalQs(incomeSeasonal);}

    @And("I select {string} income changes option")
    public void iSelectIncomeChanges(String incomeChanges){employmentIncomePage.answerIncomeChangesQs(incomeChanges);}

    @And("I click continue on the Employment income page")
    public void clickContinue(){employmentIncomePage.clickSaveAndContinueButton();}
}
