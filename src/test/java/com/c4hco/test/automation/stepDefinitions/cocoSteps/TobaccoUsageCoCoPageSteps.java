package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.TobaccoUsageCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TobaccoUsageCoCoPageSteps {
    TobaccoUsageCoCoPage tobaccoUsageCoCoPage = new TobaccoUsageCoCoPage(WebDriverManager.getDriver());

    @And("I click Continue on the Tobacco Usage Page CoCo")
    public void selectContinueTobaccoUsage(){tobaccoUsageCoCoPage.selectContinueTobacco();}

    @Then("I verify text on Tobacco Usage Page CoCo")
    public void verifyTextOnTobaccoPage()  {
        tobaccoUsageCoCoPage.verifyTextOnTobaccoPage();
    }

}
