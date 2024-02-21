package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplicationHistoryPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class ApplicationHistoryPageSteps {
    ApplicationHistoryPage applicationHistoryPage = new ApplicationHistoryPage(WebDriverManager.getDriver());

    @Then("I click on view results and shop")
    public void clickViewResultsNSHop(){
        applicationHistoryPage.clickViewResults();
    }
}
