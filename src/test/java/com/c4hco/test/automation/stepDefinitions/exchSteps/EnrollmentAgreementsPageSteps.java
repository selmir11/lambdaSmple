package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EnrollmentAgreementsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class EnrollmentAgreementsPageSteps {
    EnrollmentAgreementsPage enrollmentAgreementsPage = new EnrollmentAgreementsPage(WebDriverManager.getDriver());

    @And("I select {string} agreement checkbox")
    public void selectAgreementCheckboxCoCo(String checkboxOption){
        enrollmentAgreementsPage.selectAgreementsCheckbox(checkboxOption);
    }

    @And("I enter householder signature on the Enrollment Agreements page")
    public void enterAgreementSignatureCoCo(){enrollmentAgreementsPage.enterSignature();}

    @And("I click continue on Enrollment Agreements page")
    public void continueInitialPaymentCoCo(){
        enrollmentAgreementsPage.clickContinue();
    }
}
