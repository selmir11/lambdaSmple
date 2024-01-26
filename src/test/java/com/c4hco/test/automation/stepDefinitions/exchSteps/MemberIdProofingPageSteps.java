package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MemberIdProofingPage;
import io.cucumber.java.en.*;

public class MemberIdProofingPageSteps {
    MemberIdProofingPage memberIdProofingPage = new MemberIdProofingPage();

    @Then("I answer all Id proofing questions and click continue")
    public void iSelectMemberIdProofingOptions(){
        // select all first available options
        // TO DO - combine all to one method
        memberIdProofingPage.selectFirstOptionToAll();
//        memberIdProofingPage.selectEmployerName();
//        memberIdProofingPage.selectHomeAddress();
//        memberIdProofingPage.selectBank();
//        memberIdProofingPage.clickSaveContinue();
    }

}
