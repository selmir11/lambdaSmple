package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.WhoAreYou_LR;
import io.cucumber.java.en.*;

public class WhoAreYouSteps_LR {
    WhoAreYou_LR who = new WhoAreYou_LR();

    @Then("I check who are you question")
    public void checkWhoAreYouBox(){
        who.checkMember();
    }
    @And("I enter the details of the member and continue")
    public void entermemberDetails(){
        who.enterAddress1();
        who.enterCity();
        who.enterZip();
        who.selectState();
        who.selectCounty();
        who.enterDOB();
        who.enterSSN();
        who.clickSaveContinue();
    }

}
