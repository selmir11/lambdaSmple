package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.CRMPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages.CRMSearchResultsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class CRMSearchResultsPageSteps {

    CRMSearchResultsPage crmSearchResultsPage = new CRMSearchResultsPage(WebDriverManager.getDriver());

    @Then("I open the searched user's contact page")
    public void openContactByName(){crmSearchResultsPage.openResultByName();}

    //This function is used to select the first search results IF the search results page is displayed after searching from the dashboard. Since it does not always display, we needed a way to work around it.
    @Then("I handle the search results page")
    public void openContactIfSearchResultsDisplays(){crmSearchResultsPage.handleSearchResultsPage();}
}
