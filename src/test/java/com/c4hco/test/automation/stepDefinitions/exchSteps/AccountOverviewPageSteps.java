package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AccountOverviewPage;
import com.c4hco.test.automation.pages.exchPages.GmailNotices;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class AccountOverviewPageSteps {
    AccountOverviewPage accountOverviewPage = new AccountOverviewPage(WebDriverManager.getDriver());
    GmailNotices gmailNotices = new GmailNotices(WebDriverManager.getDriver());

    @And("I click on the Username Link Exch")
    public void clickuserNameExchLink(){accountOverviewPage.clickuserNameExchLink();}

    @Then("I apply for the current year")
    public void iApplyForCurrentYear(){accountOverviewPage.clickApplyForCurrentYear();}

    @Then("I click on ClickHere link for {string}")
    public void clickHere(String clickOption) {accountOverviewPage.clickHereLinks(clickOption);}

    @Then("I click on make changes button")
    public void clickMakeChanges(){
        accountOverviewPage.iClickOnMakeChanges();
    }

    // ================VALIDATION METHODS================//
    @And("I validate the page is in {string}")
    public void iVerifyLanguageText(String language){accountOverviewPage.verifyLanguageText(language);}

    @And("I Validate the correct enrolled plans are displayed on account overview page")
    public void validatePlanInfo(){
        accountOverviewPage.verifyMemberNames();
    }
    @Given("I set the test scenario details")
    public void ivalidateScenarioDetails(List<Map<String, String>> expectedResult){
        accountOverviewPage.setScenarioDetails(expectedResult);
    }

    @Given("I set the dynamic policy, coverage and financial dates for {string} plan")
    public void iSetDates(String planType, List<Map<String, String>> expectedResult){
        accountOverviewPage.setDates(planType, expectedResult);
    }

    @And("I verify the gmail Notices")
    public void GmailNotices() {
       gmailNotices.verifyNotices();
    }

    @Then("Validate {string} displayed as Primary person in Account Overview Page")
    public void ivalidateFirstMemberName(String memberName){
        accountOverviewPage.validateUsername(memberName );
    }

    @Then("I validate text in Account Overview Page")
    public void ivalidateTextInAccountOverivewPage(List<String> Validationtext){accountOverviewPage.validateText(Validationtext);}

    @Then("I click the Verify My Information button on Account Overview Page")
    public void iClickVerifyMyInformationButton(){accountOverviewPage.clickMyInfoButton();}

    @Then("I validate that the Verify My Information section does not display")
    public void iVerifySelfAttestButtonDoesNotExist(){accountOverviewPage.verifyMyInfoButtonDoesNotExist();}

    @Then("I validate the text of the Self Attestation container")
    public void iVerifySelfAttestContainerText(){accountOverviewPage.verifySelfAttestationContainer();}
}

