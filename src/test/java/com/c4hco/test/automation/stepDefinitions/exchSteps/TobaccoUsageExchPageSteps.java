package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.cocoPages.TobaccoUsageCoCoPage;
import com.c4hco.test.automation.pages.exchPages.TobaccoUsageExchPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class TobaccoUsageExchPageSteps {
    TobaccoUsageExchPage tobaccoUsageExchPage = new TobaccoUsageExchPage(WebDriverManager.getDriver());

    @And("I click Continue on the Tobacco Usage Page Exch")
    public void selectContinueTobaccoUsage(){tobaccoUsageExchPage.selectContinueTobacco();}
}
