package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.Apply2024_LR;
import io.cucumber.java.en.*;

public class Apply2024Steps_LR {
    Apply2024_LR apply = new Apply2024_LR();

    @Then("I Verify the header on myAccountOverview page")
    public void I_verify_header(){
        apply.verifyHeader();
    }

    @And("I apply for 2024")
    public void I_apply_for_2024(){
        apply.clickApply2024();
        System.out.println("Clicked on apply 2024.");
    }
}
