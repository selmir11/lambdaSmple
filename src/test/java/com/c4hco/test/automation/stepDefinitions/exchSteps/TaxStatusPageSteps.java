package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TaxStatusPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class TaxStatusPageSteps {
    TaxStatusPage taxStatusPage = new TaxStatusPage(WebDriverManager.getDriver());

    @Then("I select {string} for will you be claimed as dependent question")
    public void iSelectClaimedAsDependentOption(String claimedAsDependent){taxStatusPage.selectClaimedAsDependent(claimedAsDependent);}

    @Then("I select {string} for will file tax return question")
    public void iSelectFileTaxReturnOption(String willFileTaxReturn){taxStatusPage.selectWillFileTaxReturn(willFileTaxReturn);}

    @Then("I select the {string} tax filing option on the Tax Status page")
    public void iSelectTaxFilingOption(String filingOption){taxStatusPage.selectFilingStatus(filingOption);}

    @Then("I select {string} as filing jointly with option on the Tax Status page")
    public void iSelectFilingJointlyWithOption(String filingJointlyOption){taxStatusPage.selectFilingJointlyWithOption(filingJointlyOption);}

    @And("I enter data for filing jointly with enter the name question on the Tax Status page")
    public void iEnterFilingJointlyWithEnterTheNameQuestion(List<Map<String, String>> nameData){taxStatusPage.enterFilingJointlyWithEnterTheNameQuestion(nameData);}

    @Then("I select {string} for will claim dependents question")
    public void iSelectWillClaimDependentsOption(String willClaimDependents){taxStatusPage.selectWillClaimDependents(willClaimDependents);}

    @Then("I select {string} for who will claim as dependent question")
    public void iSelectWhoWillClaimYou(String memPrefix){taxStatusPage.selectWhoWillClaimYou(memPrefix);}

    @Then("I click Save and Continue on Tax Status page")
    public void iClickSaveAndContinue(){taxStatusPage.clickSaveAndContinue();}

    @Then("I click Go back on Tax Status page")
    public void iClickGoBack(){taxStatusPage.clickGoBack();}

    @And("I enter data for who will claim as dependent enter the name question on the Tax Status page")
    public void iEnterDataEnterTheNameQuestion(List<Map<String, String>> nameData){taxStatusPage.enterDataEnterTheNameQuestion(nameData);}

    @Then("I select {string} for who will be claimed as dependent question on the Tax Status page")
    public void iSelectWhoWillBeClaimed(String memPrefix){taxStatusPage.selectWhoWillBeClaimed(memPrefix);}

    @Then("I check Exceptional circumstances checkbox on the Tax Status page")
    public void iCheckExceptionalCircumstances( ){taxStatusPage.checkExceptionalCircumstances();}

    @And("I enter data for who will be claimed as dependent enter the name question on the Tax Status page")
    public void iEnterWhoWillBeClaimedDataEnterTheNameQuestion(List<Map<String, String>> nameData){taxStatusPage.enterWhoWillBeClaimedDataEnterTheNameQuestion(nameData);}

    @Then("I enter date of {string} for Someone else's DOB on Tax Status page")
    public void iEnterDobForSomeoneElse(String dobDate){taxStatusPage.enterDobForSomeoneElse(dobDate);}

    @Then("I click on the {string} help link on Tax Status page")
    public void iClickHelp(String helpBtn){taxStatusPage.clickHelp(helpBtn);}

    @Then("I click on Contact Us link in Help Drawer on the Tax Status page")
    public void iClickHelpContactUs(){taxStatusPage.clickHelpContactUs();}



    /////////////////////////////////// Validation steps ///////////////////////////////////

    @Then("I verify Tax checkbox in {string} state")
    public void iVerifyStateOfTaxCheckboxes(String state){taxStatusPage.verifyTaxCheckboxes(state);}

    @And("I verify the header for {string} Member on the Tax Status page in {string}")
    public void iVerifyHeadersOtherHealthCoveragePage(String member, String language){taxStatusPage.verifyHeadersTaxStatusPage(member, language);}

    @And("I verify will you be claimed question on the Tax Status page for {string} in {string}")
    public void iVerifyWillYouBeClaimedAsDependentQuestion(String memPrefix,String language){taxStatusPage.verifyWillYouBeClaimedAsDependentQuestion(memPrefix,language);}

    @And("I verify will you be claimed Yes {string} and No {string} selected on the Tax Status page")
    public void iVerifyWillYouBeClaimedAsDependentAnswers(String yesStatus, String noStatus){taxStatusPage.verifyWillYouBeClaimedAsDependentAnswers(yesStatus, noStatus);}

    @And("I verify will you be claimed error on the Tax Status page for {string} in {string}")
    public void iVerifyClaimedDependentErrors(String memPrefix,String language){taxStatusPage.verifyClaimedDependentErrors(memPrefix,language);}

    @And("I verify file tax return question on the Tax Status page for {string} in {string}")
    public void iVerifyFileTaxReturnQuestion(String memPrefix,String language){taxStatusPage.verifyFileTaxReturnQuestion(memPrefix,language);}

    @And("I verify file tax return error on the Tax Status page for {string} in {string}")
    public void iVerifyFileTaxReturnErrors(String memPrefix,String language){taxStatusPage.verifyFileTaxReturnErrors(memPrefix,language);}

    @And("I verify file tax return Yes {string} and No {string} selected on the Tax Status page")
    public void iVerifyFileTaxReturnAnswers(String yesStatus, String noStatus){taxStatusPage.verifyFileTaxReturnAnswers(yesStatus, noStatus);}

    @And("I verify who will claim you question on the Tax Status page for {string} in {string}")
    public void iVerifyWhoWillClaimYouQuestion(String memPrefix,String language){taxStatusPage.verifyWhoWillClaimYouQuestion(memPrefix, language);}

    @And("I verify who will claim you question on the Tax Status page for selected for {string}")
    public void iVerifyOnlyMemPrefixSelected(String memPrefix){taxStatusPage.verifyOnlyMemPrefixSelected(memPrefix);}

    @And("I verify enter the name question on the Tax Status page for {string} in {string}")
    public void iVerifyEnterTheNameQuestion(String memPrefix,String language){taxStatusPage.verifyEnterTheNameQuestion(memPrefix,language);}

    @And("I verify who will claim you error on the Tax Status page for {string} in {string}")
    public void iVerifyWhoWillClaimYouErrors(String memPrefix,String language){taxStatusPage.verifyWhoWillClaimYouErrors(memPrefix,language);}

    @And("I verify for who will claim as dependent enter the name question on the Tax Status page data")
    public void iVerifyEnterTheNameAnswers(List<Map<String, String>> nameData){taxStatusPage.verifyEnterTheNameAnswers(nameData);}

    @And("I verify error messages with date {string} for who will claim as dependent enter the name question on the Tax Status page data in {string}")
    public void iVerifyEnterTheNameErrors(String dateError, String language){taxStatusPage.verifyEnterTheNameErrors(dateError, language);}

    @And("I verify Save and Back buttons on the Tax Status page in {string}")
    public void iVerifySaveBackBtns(String language){taxStatusPage.verifySaveBackBtns(language);}

    @And("I verify select tax filing status question on the Tax Status page in {string}")
    public void iVerifySelectTaxFilingStatusQuestion(String language){taxStatusPage.verifySelectTaxFilingStatusQuestion(language);}

    @And("I verify select tax filing status error on the Tax Status page in {string}")
    public void iVerifySelectTaxFilingStatusErrors(String language){taxStatusPage.verifySelectTaxFilingStatusErrors(language);}

    @And("I verify who will you be filing jointly with question on the Tax Status page for {string} in {string}")
    public void iVerifyFilingJointlyWithQuestionn(String memPrefix,String language,List<Map<String, String>> expectedMembers){taxStatusPage.verifyFilingJointlyWithQuestion(memPrefix,language,expectedMembers);}

    @And("I verify who will you be filing jointly with error on the Tax Status page for {string} in {string}")
    public void iVerifyFilingJointlyWithErrors(String memPrefix,String language){taxStatusPage.verifyFilingJointlyWithErrors(memPrefix,language);}

    @And("I verify who will you be filing jointly with {string} selected on the Tax Status page in {string}")
    public void iVerifyFilingJointlyWithAnswers(String memOption,String language,List<Map<String, String>> expectedMembers){taxStatusPage.verifyFilingJointlyWithAnswers(memOption,language,expectedMembers);}

    @And("I verify filing jointly with enter the name question on the Tax Status page in {string}")
    public void iVerifyFilingJointlyWithEnterTheNameQuestion(String language){taxStatusPage.verifyFilingJointlyWithEnterTheNameQuestion(language);}

    @And("I verify error messages with date {string} for filing jointly with enter the name question on the Tax Status page data in {string}")
    public void iVerifyFilingJointlyWithNameErrors(String dateError, String language){taxStatusPage.verifyFilingJointlyWithNameErrors(dateError, language);}

    @And("I verify will you claim dependents question on the Tax Status page for {string} in {string}")
    public void iVerifyWillYouClaimDependentsQuestion(String memPrefix,String language){taxStatusPage.verifyWillYouClaimDependentsQuestion(memPrefix,language);}

    @And("I verify will you claim dependents error on the Tax Status page for {string} in {string}")
    public void iVerifyWillYouClaimDependentsErrors(String memPrefix,String language){taxStatusPage.verifyWillYouClaimDependentsErrors(memPrefix,language);}

    @And("I verify will you claim dependents Yes {string} and No {string} selected on the Tax Status page")
    public void iVerifyWillYouClaimDependentsAnswers(String yesStatus, String noStatus){taxStatusPage.verifyWillYouClaimDependentsAnswers(yesStatus, noStatus);}

    @And("I verify who will be claimed question on the Tax Status page for {string} in {string}")
    public void iVerifyWhoClaimedQuestion(String memPrefix,String language){taxStatusPage.verifyWhoClaimedQuestion(memPrefix,language);}

    @And("I verify who will be claimed error on the Tax Status page for {string} in {string}")
    public void iVerifyWhoClaimedErrors(String memPrefix,String language){taxStatusPage.verifyWhoClaimedErrors(memPrefix,language);}

    @And("I verify who will be claimed with enter the name question on the Tax Status page in {string}")
    public void iVerifyWhoClaimedWithEnterTheNameQuestion(String language){taxStatusPage.verifyWhoClaimedWithEnterTheNameQuestion(language);}

    @And("I verify error messages with date {string} for who will be claimed with enter the name question on the Tax Status page data in {string}")
    public void iVerifyWhoClaimedWithNameErrors(String dateError, String language){taxStatusPage.verifyWhoClaimedWithNameErrors(dateError, language);}

    @And("I verify select tax filing status {string} selected on the Tax Status page")
    public void iVerifySelectTaxFilingStatusAnswer(String option){taxStatusPage.verifySelectTaxFilingStatusAnswer(option);}

    @And("I verify who will be claimed does not show enter the name question on the Tax Status page")
    public void iVerifyWhoClaimedNoEnterTheNameQuestion(){taxStatusPage.verifyWhoClaimedNoEnterTheNameQuestion();}

    @And("I verify who will be claimed enter the name question on the Tax Status page data")
    public void iVerifyWhoClaimedEnterTheNameQuestion(List<Map<String, String>> nameData){taxStatusPage.verifyWhoClaimedEnterTheNameAnswers(nameData);}

    @And("I verify Exceptional circumstances checkbox {string} selected on the Tax Status page")
    public void iVerifyExceptionalCircumstancesCheck(String status){taxStatusPage.verifyExceptionalCircumstancesCheck(status);}

    @And("I verify filing jointly with enter the name question on the Tax Status page")
    public void iVerifyFilingJointlyWithEnterTheNameQuestion(List<Map<String, String>> nameData){taxStatusPage.verifyFilingJointlyWithEnterTheNameAnswers(nameData);}

    @And("I verify tax_return_id is {string} as last ID for {string} on the Tax Status page")
    public void iVerifyTaxReturnId(String matchType, String memPrefix){taxStatusPage.verifyTaxReturnId(matchType,memPrefix);}

    @And("I verify tax_return_id for {string} is {string} compared to {string} on the Tax Status page")
    public void iCompareTaxReturnId(String memPrefix, String matchType, String memPrefix2){taxStatusPage.compareTaxReturnId(memPrefix, matchType, memPrefix2);}

    @And("I verify no errors show on the Tax Status page")
    public void iVerifyNoErrors(){taxStatusPage.verifyNoErrors();}

    @And("I verify the help drawer {string} text on Tax Status page")
    public void iVerifyHelpDrawerTxt(String helpTxt){taxStatusPage.verifyHelpDrawerTxt(helpTxt);}

}
