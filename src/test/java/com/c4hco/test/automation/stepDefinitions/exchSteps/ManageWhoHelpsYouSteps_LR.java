package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ManageWhoHelpsYou_LR;
import io.cucumber.java.en.*;

public class ManageWhoHelpsYouSteps_LR {
    ManageWhoHelpsYou_LR OnOwn    = new ManageWhoHelpsYou_LR();

    @Then("I select Continue on my own")
    public void selectContinueOnOwn() throws InterruptedException {
        OnOwn.continueOnOwn();
    }

}
