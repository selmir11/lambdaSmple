package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EnterCaseIdPage;
import io.cucumber.java.en.And;

public class EnterCaseIdPageSteps {
    EnterCaseIdPage enterCaseIdPage = new EnterCaseIdPage();

    @And("I validate the verbiage on the Enter Case ID page in {string}")
    public void iValidateTheVerbiageOnTheEnterCaseIDPageInEnglish(String language) {
        enterCaseIdPage.validateTheVerbiageOnEnterCaseIdPage(language);
    }
}
