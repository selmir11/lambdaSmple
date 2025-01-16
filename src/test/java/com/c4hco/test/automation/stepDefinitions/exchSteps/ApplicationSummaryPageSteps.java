package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationSummaryPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ApplicationSummaryPageSteps {

    ApplicationSummaryPage applicationSummaryPage = new ApplicationSummaryPage(WebDriverManager.getDriver());

    @Then("I select the Basic Edit link")
    public void iclickEditBasicLink() {applicationSummaryPage.clickEditBasicLink();
    }

    @Then("I select the Edit Income link")
    public void iclickEditIncomelink() {
        applicationSummaryPage.clickEditIncomelink();

    }

    @Then("I back button on the Application Summary page")
    public void iClickBackButton() {applicationSummaryPage.clickBackButton();}




    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line

    @And("I verify Existing health insurance is {string} on the Application Summary page in {string}")
    public void iVerifyExistingHealthInsurance(String OhcData, String language) {applicationSummaryPage.verifyExistingHealthInsurance(OhcData, language);}




}
