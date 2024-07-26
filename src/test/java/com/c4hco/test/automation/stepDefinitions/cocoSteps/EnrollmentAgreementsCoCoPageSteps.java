package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.EnrollmentAgreementsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EnrollmentAgreementsCoCoPageSteps {
    EnrollmentAgreementsCoCoPage enrollmentAgreementsCoCoPage = new EnrollmentAgreementsCoCoPage(WebDriverManager.getDriver());

    @And("I select {string} agreement checkbox CoCo")
    public void selectAgreementCheckboxCoCo(String checkboxOption){
        enrollmentAgreementsCoCoPage.selectAgreementsCheckboxCoCo(checkboxOption);
    }

    @And("I enter householder signature on the Enrollment Agreements page CoCo")
    public void enterAgreementSignatureCoCo(){enrollmentAgreementsCoCoPage.enterSignatureAgreementsCoCo();}

    @And("I select continue button on the Enrollment Agreements CoCo page")
    public void continueInitialPaymentCoCo(){
        enrollmentAgreementsCoCoPage.selectContinueCoCo();
    }

    @Then("I validate the page text on the enrollment agreements page coco")
    public void validatePageText(){
        enrollmentAgreementsCoCoPage.validatePageText();
    }
}
