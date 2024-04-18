package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TaxStatusPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;


public class TaxStatusPageSteps {
    TaxStatusPage taxStatusPage = new TaxStatusPage(WebDriverManager.getDriver());

    @And("I select the option {string} to claim as dependent")
    public void selectDependantClaim(String claimAsDependentOption){
        taxStatusPage.claimAsDependent(claimAsDependentOption);
    }

    //The Option is based on the order that the Radio Buttons appear on the page, starting with 1.
    @And("I select the {string} option for Who Will Claim as Dependent")
    public void selectWhoWillClaim(String IDByOrder){taxStatusPage.whoWillClaimDependent(IDByOrder);}

    @And("I select the option {string} to file federal income tax return next year")
    public void selectFedIncomeTaxReturn(String fileFedIncomeTaxReturnOption){
        taxStatusPage.fileFedIncomeTaxReturn(fileFedIncomeTaxReturnOption);
    }

    @And("I select {string} tax filing status")
    public void selectTaxFilingStatus(String taxFilingOption){
        taxStatusPage.selectTaxFilingOption(taxFilingOption);
    }

    @And("I select spouse to file taxes jointly")
    public void iSelectFileTaxesJointlyWith(){
        taxStatusPage.selectFileTaxesJointlyWith();
    }

    @And("I select {string} to claim dependents")
    public void selectDependents(String dependentsOption){
        taxStatusPage.selectDependentsOption(dependentsOption);
    }

    //The Option is based on the order that the Radio Buttons appear on the page, starting with 1.
    @And("I select the {string} option for Who Will Claim as Dependents")
    public void iCheckDependentClaimed(String IDByOrder){taxStatusPage.checkDependentClaimed(IDByOrder);}

    @And("I click save and continue on tax status page")
    public void iClickSaveAndContinue(){
        taxStatusPage.selectSaveAndContinue();
    }
}
