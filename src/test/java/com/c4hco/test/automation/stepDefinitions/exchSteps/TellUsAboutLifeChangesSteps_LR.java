package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TellUsAboutLifeChanges_LR;
import io.cucumber.java.en.*;

public class TellUsAboutLifeChangesSteps_LR {

    TellUsAboutLifeChanges_LR lifeChanges = new TellUsAboutLifeChanges_LR();

    @Then("I select birth QLCE on tell us about life changes page")
    public void birthLifeChange(){
        lifeChanges.selectLCE("Birth");
        lifeChanges.saveNContinue();
    }
}
