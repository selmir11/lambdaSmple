package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.BeforeYouBeginPage;
import io.cucumber.java.en.Then;

public class BeforeYouBeginSteps {

    BeforeYouBeginPage beforeYouBeginPage = new BeforeYouBeginPage();

@Then("I click on continue with  application button on Before you begin page")
    public void iClickContinueWithApplicationButton(){
    beforeYouBeginPage.clickContinueWithApplicationButton();

}
}
