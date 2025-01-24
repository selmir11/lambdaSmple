package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MemberIdProofingPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class MemberIdProofingPageSteps {
    MemberIdProofingPage memberIdProofingPage = new MemberIdProofingPage(WebDriverManager.getDriver());

    @Then("I answer all Id proofing questions and click continue")
    public void iSelectMemberIdProofingOptions(){
        memberIdProofingPage.selectFirstOptionToAll();
    }

    @Then("I answer all Id proofing questions required for uploading documents and click continue")
    public void iSelectMemberIdProofingOptionsToUploadDocuments(){
        memberIdProofingPage.selectRequiredOptionsToUploadDocuments();
    }

    @And("I validate the verbiage on the Identity Proofing - Initial page in {string}")
    public void iValidateTheVerbiageOnTheIdentityProofingInitialPageIn(String language) {
        memberIdProofingPage.validateTheVerbiageOnTheIdentityProofingInitialPage(language);
    }

    @Then("I answer the wrong Id proofing answers and click continue")
    public void iAnswerTheWrongIdProofingAnswersAndClickContinue() {
        memberIdProofingPage.answerTheWrongIdProofingAnswersAndClickContinue();
    }

    @And("I validate the id proofing error message is displayed")
    public void iValidateTheIdProofingErrorMessageIsDisplayed() {
        memberIdProofingPage.validateTheIdProofingErrorMessageIsDisplayed();
    }
}
