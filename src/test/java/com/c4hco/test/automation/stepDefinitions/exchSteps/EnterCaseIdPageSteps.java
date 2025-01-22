package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EnterCaseIdPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EnterCaseIdPageSteps {
    EnterCaseIdPage enterCaseIdPage = new EnterCaseIdPage(WebDriverManager.getDriver());

    @And("I validate the verbiage on the Enter Case ID page in {string}")
    public void iValidateTheVerbiageOnTheEnterCaseIDPageInEnglish(String language) {
        enterCaseIdPage.validateTheVerbiageOnEnterCaseIdPage(language);
    }

    @Then("I enter valid {string},{string},{string} details in enterCaseID page")
    public void iEnterCaseIDdetails(String CaseID, String Zipcode, String Lastname) {
        enterCaseIdPage.enterCaseIDdetails(CaseID, Zipcode, Lastname);
    }

    @And("I click on Back button on Loadby1B result page")
    public void iClickOnBackButton() {
        enterCaseIdPage.goBackonLoad1Bresult();
    }

}
