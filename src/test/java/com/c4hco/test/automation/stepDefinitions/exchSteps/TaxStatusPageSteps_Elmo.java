package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TaxStatusPage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class TaxStatusPageSteps_Elmo {
    TaxStatusPage_Elmo taxStatusPage_Elmo = new TaxStatusPage_Elmo(WebDriverManager.getDriver());

    @Then("I select {string} for will you be claimed as dependent question")
    public void iSelectClaimedAsDependentOption(String claimedAsDependent){
        taxStatusPage_Elmo.selectClaimedAsDependent(claimedAsDependent);}

    @Then("I select {string} for will file tax return question")
    public void iSelectFileTaxReturnOption(String willFileTaxReturn){
        taxStatusPage_Elmo.selectWillFileTaxReturn(willFileTaxReturn);}

    @Then("I select the {string} tax filing option on the Tax Status Elmo page")
    public void iSelectTaxFilingOption(String filingOption){
        taxStatusPage_Elmo.selectFilingStatus(filingOption);
    }

    @Then("I select {string} as filing jointly with option on the Tax Status Elmo page")
    public void iSelectFilingJointlyWithOption(String filingJointlyOption){
        taxStatusPage_Elmo.selectFilingJointlyWithOption(filingJointlyOption);
    }

    @Then("I select {string} for will claim dependents question")
    public void iSelectWillClaimDependentsOption(String willClaimDependents){
        taxStatusPage_Elmo.selectWillClaimDependents(willClaimDependents);}

    @Then("I click Save and Continue on Tax Status Elmo page")
    public void iClickSaveAndContinue(){taxStatusPage_Elmo.clickSaveAndContinue();}



    /////////////////////////////////// Validation steps ///////////////////////////////////

    @Then("I verify Tax checkbox in {string} state")
    public void iVerifyStateOfTaxCheckboxes(String state){
        taxStatusPage_Elmo.verifyTaxCheckboxes(state);}
}
