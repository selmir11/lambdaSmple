package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MaEligibleMembersSelfEmploymentExpensesPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import java.util.List;

public class MaEligibleMembersSelfEmploymentExpensesSteps {

    MaEligibleMembersSelfEmploymentExpensesPage maEligibleMembersSelfEmploymentExpensesPage = new MaEligibleMembersSelfEmploymentExpensesPage(WebDriverManager.getDriver());

    @Then("I select {string} for self-employed question and Continue on Self-Employed MA page")
    public void iAnswerSelfEmployed(String yesNo) {
        maEligibleMembersSelfEmploymentExpensesPage.answerSelfEmployed(yesNo);
    }

    @Then("I validate the Page Text on the Self-Employment MA page in {string}")
    public void iValidateTextOnSelfEMPLanguagePage(String language, List<String> dataText) {
        maEligibleMembersSelfEmploymentExpensesPage.validateMaSelfEmploymentPage(language,dataText);
    }


}
