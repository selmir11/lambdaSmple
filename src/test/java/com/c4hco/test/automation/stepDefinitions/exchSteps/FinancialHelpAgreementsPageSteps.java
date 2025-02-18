package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.FinancialHelpAgreementsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class FinancialHelpAgreementsPageSteps {
    FinancialHelpAgreementsPage financialHelpAgreementsPage = new FinancialHelpAgreementsPage(WebDriverManager.getDriver());
    @And("I select the terms and agreements checkbox")
    public void selectTermsAndAgreementCheckboxEX(){
        financialHelpAgreementsPage.selectTermsAgreementsCheckbox();
    }

    @And("I enter householder signature on the Financial Help Agreements page")
    public void enterAgreementSignatureEX(){financialHelpAgreementsPage.enterSignature();}

    @And("I enter {string} signature on the Financial Help Agreements page")
    public void enterAgreementSignatureTwoTaxHoldersEX(String taxHolder){
        financialHelpAgreementsPage.enterTaxPayersSignature(taxHolder);}

    @And("I click continue on Financial Help Agreements page")
    public void continueInitialPaymentCoCo(){
        financialHelpAgreementsPage.clickContinue();
    }

    @And("I select {string} agreement checkbox on the Financial Agreements page")
    public void selectAgreementCheckbox(String checkboxOption){
        financialHelpAgreementsPage.selectAgreementsCheckbox(checkboxOption);
    }
    @And("I verify text on Financial agreement page")
    public void FinancialAgreementEnglish() {
        financialHelpAgreementsPage.verifyFinancialAgreementPageVerbiage();
    }
}
