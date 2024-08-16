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

    @And("I enter first tax payer signature on the Financial Help Agreements page")
    public void enterFirstAgreementSignatureEX(){financialHelpAgreementsPage.enterFirstTaxPayerSignature();}
    @And("I enter second tax payer signature on the Financial Help Agreements page")
    public void enterSecondAgreementSignatureEX(){financialHelpAgreementsPage.enterSecondTaxPayerSignature();}
    @And("I click continue on Financial Help Agreements page")
    public void continueInitialPaymentCoCo(){
        financialHelpAgreementsPage.clickContinue();
    }
}
