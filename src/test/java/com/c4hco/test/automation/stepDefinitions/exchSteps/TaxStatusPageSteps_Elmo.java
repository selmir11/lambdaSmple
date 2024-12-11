package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TaxStatusPage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class TaxStatusPageSteps_Elmo {
    TaxStatusPage_Elmo taxStatusPage_Elmo = new TaxStatusPage_Elmo(WebDriverManager.getDriver());

    @Then("I select {string} for will you be claimed as dependent question")
    public void iSelectClaimedAsDependentOption(String claimedAsDependent){taxStatusPage_Elmo.selectClaimedAsDependent(claimedAsDependent);}

    @Then("I select {string} for will file tax return question")
    public void iSelectFileTaxReturnOption(String willFileTaxReturn){taxStatusPage_Elmo.selectWillFileTaxReturn(willFileTaxReturn);}

    @Then("I select the {string} tax filing option on the Tax Status Elmo page")
    public void iSelectTaxFilingOption(String filingOption){
        taxStatusPage_Elmo.selectFilingStatus(filingOption);
    }

    @Then("I select {string} as filing jointly with option on the Tax Status Elmo page")
    public void iSelectFilingJointlyWithOption(String filingJointlyOption){taxStatusPage_Elmo.selectFilingJointlyWithOption(filingJointlyOption);}

    @Then("I select {string} for will claim dependents question")
    public void iSelectWillClaimDependentsOption(String willClaimDependents){taxStatusPage_Elmo.selectWillClaimDependents(willClaimDependents);}

    @Then("I select {string} for who will claim as dependent question")
    public void iSelectWhoWillClaimYou(String memPrefix){taxStatusPage_Elmo.selectWhoWillClaimYou(memPrefix);}

    @Then("I click Save and Continue on Tax Status Elmo page")
    public void iClickSaveAndContinue(){taxStatusPage_Elmo.clickSaveAndContinue();}

    @And("I enter data for enter the name question on the Tax Status Elmo page")
    public void iEnterDataEnterTheNameQuestion(List<Map<String, String>> nameData){taxStatusPage_Elmo.enterDataEnterTheNameQuestion(nameData);}

    @Then("I select {string} for who will be claimed as dependent question")
    public void iSelectWhoWillBeClaimed(String memPrefix){taxStatusPage_Elmo.selectWhoWillBeClaimed(memPrefix);}



    /////////////////////////////////// Validation steps ///////////////////////////////////

    @Then("I verify Tax checkbox in {string} state")
    public void iVerifyStateOfTaxCheckboxes(String state){taxStatusPage_Elmo.verifyTaxCheckboxes(state);}

    @And("I verify the header for {string} Member on the Tax Status Elmo page in {string}")
    public void iVerifyHeadersOtherHealthCoveragePage(String member, String language){taxStatusPage_Elmo.verifyHeadersTaxStatusPage(member, language);}

    @And("I verify will you be claimed question on the Tax Status Elmo page for {string} in {string}")
    public void iVerifyWillYouBeClaimedAsDependentQuestion(String memPrefix,String language){taxStatusPage_Elmo.verifyWillYouBeClaimedAsDependentQuestion(memPrefix,language);}

    @And("I verify will you be claimed Yes {string} and No {string} selected on the Tax Status Elmo page")
    public void iVerifyWillYouBeClaimedAsDependentAnswers(String yesStatus, String noStatus){taxStatusPage_Elmo.verifyWillYouBeClaimedAsDependentAnswers(yesStatus, noStatus);}

    @And("I verify file tax return question on the Tax Status Elmo page for {string} in {string}")
    public void iVerifyFileTaxReturnQuestion(String memPrefix,String language){taxStatusPage_Elmo.verifyFileTaxReturnQuestion(memPrefix,language);}

    @And("I verify file tax return Yes {string} and No {string} selected on the Tax Status Elmo page")
    public void iVerifyFileTaxReturnAnswers(String yesStatus, String noStatus){taxStatusPage_Elmo.verifyFileTaxReturnAnswers(yesStatus, noStatus);}

    @And("I verify who will claim you question on the Tax Status Elmo page for {string} in {string}")
    public void iVerifyWhoWillClaimYouQuestion(String memPrefix,String language){taxStatusPage_Elmo.verifyWhoWillClaimYouQuestion(memPrefix, language);}

    @And("I verify who will claim you question on the Tax Status Elmo page for selected for {string}")
    public void iVerifyOnlyMemPrefixSelected(String memPrefix){taxStatusPage_Elmo.verifyOnlyMemPrefixSelected(memPrefix);}

    @And("I verify enter the name question on the Tax Status Elmo page for {string} in {string}")
    public void iVerifyEnterTheNameQuestion(String memPrefix,String language){taxStatusPage_Elmo.verifyEnterTheNameQuestion(memPrefix,language);}

    @And("I verify enter the name question on the Tax Status Elmo page data")
    public void iVerifyEnterTheNameQuestion(List<Map<String, String>> nameData){taxStatusPage_Elmo.verifyEnterTheNameAnswers(nameData);}

    @And("I verify Save and Back buttons on the Tax Status Elmo page in {string}")
    public void iVerifySaveBackBtns(String language){taxStatusPage_Elmo.verifySaveBackBtns(language);}

    @And("I verify select tax filing status question on the Tax Status Elmo page in {string}")
    public void iVerifySelectTaxFilingStatusQuestion(String language){taxStatusPage_Elmo.verifySelectTaxFilingStatusQuestion(language);}

    @And("I verify who will you be filing jointly with question on the Tax Status Elmo page for {string} in {string}")
    public void iVerifyFilingJointlyWithQuestionn(String memPrefix,String language){taxStatusPage_Elmo.verifyFilingJointlyWithQuestion(memPrefix,language);}

    @And("I verify who will you be filing jointly with {string} selected on the Tax Status Elmo page for {string} in {string}")
    public void iVerifyFilingJointlyWithAnswers(String memOption,String memPrefix,String language){taxStatusPage_Elmo.verifyFilingJointlyWithAnswers(memOption,memPrefix,language);}

    @And("I verify filing jointly with enter the name question on the Tax Status Elmo page in {string}")
    public void iVerifyFilingJointlyWithEnterTheNameQuestion(String language){taxStatusPage_Elmo.verifyFilingJointlyWithEnterTheNameQuestion(language);}

    @And("I verify will you claim dependents question on the Tax Status Elmo page for {string} in {string}")
    public void iVerifyWillYouClaimDependentsQuestion(String memPrefix,String language){taxStatusPage_Elmo.verifyWillYouClaimDependentsQuestion(memPrefix,language);}

    @And("I verify will you claim dependents Yes {string} and No {string} selected on the Tax Status Elmo page")
    public void iVerifyWillYouClaimDependentsAnswers(String yesStatus, String noStatus){taxStatusPage_Elmo.verifyWillYouClaimDependentsAnswers(yesStatus, noStatus);}

    @And("I verify who will be claimed question on the Tax Status Elmo page for {string} in {string}")
    public void iVerifyWhoClaimedQuestion(String memPrefix,String language){taxStatusPage_Elmo.verifyWhoClaimedQuestion(memPrefix,language);}

    @And("I verify who will be claimed with enter the name question on the Tax Status Elmo page in {string}")
    public void iVerifyWhoClaimedWithEnterTheNameQuestion(String language){taxStatusPage_Elmo.verifyWhoClaimedWithEnterTheNameQuestion(language);}

    @And("I verify select tax filing status {string} selected on the Tax Status Elmo page")
    public void iVerifySelectTaxFilingStatusAnswer(String option){taxStatusPage_Elmo.verifySelectTaxFilingStatusAnswer(option);}

    @And("I verify who will be claimed does not show enter the name question on the Tax Status Elmo page")
    public void iVerifyWhoClaimedNoEnterTheNameQuestion(){taxStatusPage_Elmo.verifyWhoClaimedNoEnterTheNameQuestion();}

    @And("I verify who will be claimed enter the name question on the Tax Status Elmo page data")
    public void iVerifyWhoClaimedEnterTheNameQuestion(List<Map<String, String>> nameData){taxStatusPage_Elmo.verifyWhoClaimedEnterTheNameAnswers(nameData);}

}
