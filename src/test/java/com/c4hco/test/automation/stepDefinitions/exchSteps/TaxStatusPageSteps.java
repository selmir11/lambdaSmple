package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TaxStatusPage;
import io.cucumber.java.en.And;


public class TaxStatusPageSteps {
    TaxStatusPage taxStatusPage = new TaxStatusPage();

    @And("I select the option {string} to claim as dependent")
    public void selectDependantClaim(String claimAsDependentOption){
        taxStatusPage.claimAsDependent(claimAsDependentOption);
    }

    @And("I select the option {string} to file federal income tax return next year")
    public void selectFedIncomeTaxReturn(String fileFedIncomeTaxReturnOption){
        taxStatusPage.fileFedIncomeTaxReturn(fileFedIncomeTaxReturnOption);
    }

    @And("I select {string} tax filing status")
    public void selectTaxFilingStatus(String taxFilingOption){
        taxStatusPage.selectTaxFilingOption(taxFilingOption);
    }

    @And("I select {string} to claim dependents")
    public void selectDependents(String dependentsOption){
        taxStatusPage.selectDependentsOption(dependentsOption);
    }

    @And("I click save and continue on tax status page")
    public void iClickSaveAndContinue(String dependentsOption){
        taxStatusPage.selectSaveAndContinue();
    }

   // @Then("My marital status is {string} and I am filing with no dependents")
  //  public void filingNoDependents(String FilingStatus){taxStatusPage.notClaimedNoDependents(FilingStatus);}
}
