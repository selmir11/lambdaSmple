package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MemberIdProofingPage;
import io.cucumber.java.en.*;

public class MemberIdProofingPageSteps {
    MemberIdProofingPage memberIdProofingPage = new MemberIdProofingPage();

    @Then("I answer all Id proofing questions and click continue")
    public void iSelectMemberIdProofingOptions(){
        memberIdProofingPage.selectFirstOptionToAll();
    }

}
