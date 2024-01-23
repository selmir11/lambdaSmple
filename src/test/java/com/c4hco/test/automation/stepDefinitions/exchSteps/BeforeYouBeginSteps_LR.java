package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.BeforeYouBegin;
import io.cucumber.java.en.Then;

public class BeforeYouBeginSteps_LR {

    BeforeYouBegin begin = new BeforeYouBegin();

@Then("I click on continue with  application on Before you begin page")
    public void clickContinueWithApplication(){
    begin.continueWithApplication();

}
}
