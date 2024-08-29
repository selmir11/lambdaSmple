package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EnrollmentAgreementsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class EnrollmentAgreementsPageSteps {
    EnrollmentAgreementsPage enrollmentAgreementsPage = new EnrollmentAgreementsPage(WebDriverManager.getDriver());
    // old function  - remove after 8/29/24
    @And("I select {string} agreement checkbox")
    public void selectAgreementCheckboxCoCo(String checkboxOption){
        enrollmentAgreementsPage.selectAgreementsCheckbox(checkboxOption);
    }
    ////////////////////////////

    // new route - 8/28/24  - EXCH
    @And("I select the {string} agreement checkbox")
    public void selectAgreementCheckboxExch(String checkboxOption){
        enrollmentAgreementsPage.selectAgreementsCheckbox(checkboxOption);
    }

    @And("I enter householder signature on the Enrollment Agreements page")
    public void enterAgreementSignatureCoCo(){enrollmentAgreementsPage.enterSignature();}

    // old function  - remove after 8/29/24
    @And("I click continue on Enrollment Agreements page")
    public void continueInitialPaymentCoCo(){
        enrollmentAgreementsPage.clickContinue();
    }

    //////////////////////////////

    // new route - 8/28/24 - EXCH
    @And("I click submit enrollment on Enrollment Agreements page")
    public void submitEnrollmentEXCH(){
        enrollmentAgreementsPage.clickSubmitEnrollment();
    }

    @And("I click Go Back on the Enrollment Agreements page")
    public void goBackEnrollmentAgreements() {enrollmentAgreementsPage.clickGoBack();}
}
