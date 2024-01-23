package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.FamilyOverviewClickContinue_LR;
import io.cucumber.java.en.*;

public class FamilyOverviewClickContinueSteps_LR {
    FamilyOverviewClickContinue_LR familyOverview = new FamilyOverviewClickContinue_LR();

    @Then("I click continue on family overview page")
    public void familyOverviewSteps(){
        familyOverview.clickContinue();
    }
}
