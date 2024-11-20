package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationResultsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class ApplicationResultsPageSteps {
    ApplicationResultsPage applicationResultsPage = new ApplicationResultsPage(WebDriverManager.getDriver());

    @Then("I click continue on application results page")
    public void iClickContinueOnApplicationResult(){
        applicationResultsPage.clickBtnContinue();
    }

    @Then("I validate that my Tax Household's {int} APTC value is {string}")
    public void validateTHHAPTC(int THHNum, String expectedAPTC){applicationResultsPage.validateAPTCByTHH(THHNum, expectedAPTC);}

    @Then("I change views to Tax Household {int}")
    public void changeTaxHouseholdDropdown(int THHNum){applicationResultsPage.changeTaxHouseHold(THHNum);}

    @Then("I verify text that the member don't qualify for a health plan on the app results page")
    public void verifyTextDoNotQualifyForHealthPlan () {
        applicationResultsPage.verifyTextNotQualifyForPlanOnAppResultsPage();
    }

    @Then("I verify text that the member eligible for MA on the app results page")
    public void verifyTextMAEligibility() {
        applicationResultsPage.verifyTextMAEligibility();
    }

    @And("I verify that the APTC amount does not appear on the app results page")
    public void validateAPTCNotAppearing() { applicationResultsPage.validateAPTCNotAppearing();}

    @Then("I validate Primary Member not qualified for health coverage")
    public void verifyPrimaryMemberNotQualifyForHealthPlan () {
        applicationResultsPage.verifyPrimaryMemberNotQualified();
    }

    @Then("I verify pop up text on the application results page {string}")
    public void verifyPopUpTextOnTheApplicationResults(String Language) {
        applicationResultsPage.verifyPopUpTextOnTheApplicationResults(Language);
    }

    @Then("I click Back to App Results button on the pop up")
    public void iClickBackToAppResultApplicationResultPopup(){
        applicationResultsPage.clickBtnBackPopup();
    }

    @Then("I verify the member is not eligible for a Qualified Health Plan")
    public void iVerifyTheMemberIsNotEligibleForAQualifiedHealthPlan(String Text) {
        applicationResultsPage.validateTextOnPage(Text);
    }

    @Then("I click View Application Summary link")
    public void iClickViewApplicationSummary(){
        applicationResultsPage.clickViewApplicationSummary();
    }

    @Then("I validate the member application results")
    public void iValidateMemberResults(List<String> expectedValues){applicationResultsPage.validateMemberResults(expectedValues);}

    @Then("I click the provide documents link on the app results page")
    public void iClickProvideDocsLink(){applicationResultsPage.clickProvideDocsLink();}
}
