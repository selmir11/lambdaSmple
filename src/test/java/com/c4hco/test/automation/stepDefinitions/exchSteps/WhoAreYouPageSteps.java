package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.WhoAreYouPage;
import io.cucumber.java.en.*;

public class WhoAreYouPageSteps {
    WhoAreYouPage whoAreYouPage = new WhoAreYouPage();

    @Then("I select {string} from the who are you question")
    public void checkWhoAreYouBox(String whoAreYouOption){
        whoAreYouPage.checkWhoAreYouOption(whoAreYouOption);
    }
    @And("I enter the details of the member and continue")
    public void iEnterMemberDetails(){
        whoAreYouPage.enterMemberDetails();
//
//        whoAreYouPage.enterAddress1();
//        whoAreYouPage.enterCity();
//        whoAreYouPage.enterZip();
//        whoAreYouPage.selectState();
//        whoAreYouPage.selectCounty();
//        whoAreYouPage.enterDOB();
//        whoAreYouPage.enterSSN();
//        whoAreYouPage.clickSaveContinue();
    }

}
