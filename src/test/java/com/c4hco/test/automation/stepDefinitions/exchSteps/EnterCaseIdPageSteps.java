package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EnterCaseIdPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EnterCaseIdPageSteps {
    EnterCaseIdPage enterCaseIdPage = new EnterCaseIdPage();

    @And("I validate the elements on the Enter Case ID page in english")
    public void iValidateTheElementsOnTheEnterCaseIDPageInEnglish() {
        enterCaseIdPage.validateTheElementsOnEnterCaseIdPageEn();
    }

    @And("I validate the elements on the Enter Case ID page in spanish")
    public void iValidateTheElementsOnTheEnterCaseIDPageInSpanish() {
        enterCaseIdPage.validateTheElementsOnEnterCaseIdPageEs();
    }
}
