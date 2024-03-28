package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.FinancialHelpAgreementsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class FinancialHelpAgreementsPageSteps {
    FinancialHelpAgreementsPage financialHelpAgreementsPage = new FinancialHelpAgreementsPage(WebDriverManager.getDriver());

    @And("I select the Terms and Use checkbox")
    public void selectTermsUsecheckbox() {  financialHelpAgreementsPage.selectTermsUsecheckbox();}

    @Then("I click continue on the Financial Help Agreements page")
    public void  setContinueButton() { financialHelpAgreementsPage.setContinueButton();}

    @And("I fill out the Financial Help Agreements Signature field")
    public void enterSignature() { financialHelpAgreementsPage.enterSignature();
    }
}
