package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MemberIdProofingPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class MemberIdProofingPageSteps {
    MemberIdProofingPage memberIdProofingPage = new MemberIdProofingPage(WebDriverManager.getDriver());

    @Then("I answer all Id proofing questions and click continue")
    public void iSelectMemberIdProofingOptionsAndContinue(){
        memberIdProofingPage.selectFirstOptionToAllAndContinue();
    }
    @Then("I select first option to all Id proofing questions")
    public void iSelectMemberIdProofingOptions(){
        memberIdProofingPage.selectFirstOptionToAll();
    }
    @Then("I click Member ID Proofing continue button")
    public void iClickContinueButton(){
        memberIdProofingPage.saveAndContinue();
    }

    @And("I validate the verbiage on the Identity Proofing - Initial page in {string}")
    public void iValidateTheVerbiageOnTheIdentityProofingInitialPageIn(String language) {
        memberIdProofingPage.validateTheVerbiageOnTheIdentityProofingInitialPage(language);
    }
}
