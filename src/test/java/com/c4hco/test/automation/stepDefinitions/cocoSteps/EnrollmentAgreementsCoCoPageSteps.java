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

    @And("I click go back on the enrollment agreements page coco")
    public void clickGoBack(){
        enrollmentAgreementsCoCoPage.clickBackBtn();
    }

    @Then("I validate the page text on the enrollment agreements page coco")
    public void validatePageText(){
        enrollmentAgreementsCoCoPage.validatePageText();
    }

    // new code for 8/29/24 code move to STG
    @And("I select the {string} agreement checkbox CoCo")
    public void selectAgreementSigCheckboxCoCo(String checkboxOption){
        enrollmentAgreementsCoCoPage.selectAgreementCheckboxCoCo(checkboxOption);
    }

    // new code for 8/29/24 code move to STG
    @And("I select submit enrollment button on the Enrollment Agreements CoCo page")
    public void clickSubmitEnrollment(){
        enrollmentAgreementsCoCoPage.clickSubmitEnrollment();
    }




}
