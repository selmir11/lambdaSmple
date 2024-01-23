package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MemberIdProofing_LR;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.FindBy;

public class memberIdProofingSteps_LR {
    MemberIdProofing_LR idProofing = new MemberIdProofing_LR();

    @Then("I answer all Id proofing questions and click continue")
    public void memberidProofing(){
        idProofing.selectEmployerName();
        idProofing.selectHomeAddress();
        idProofing.selectBank();
        idProofing.clickSaveContinue();
    }

}
