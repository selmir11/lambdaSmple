package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.TobaccoUsageCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class TobaccoUsageCoCoPageSteps {
    TobaccoUsageCoCoPage tobaccoUsageCoCoPage = new TobaccoUsageCoCoPage(WebDriverManager.getDriver());

    @And("I click Continue on the Tobacco Usage Page CoCo")
    public void selectContinueTobaccoUsage(){tobaccoUsageCoCoPage.selectContinueTobacco();}

}
