package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.FindACertifiedBrokerPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;
import org.testng.asserts.SoftAssert;

public class FindACertifiedBrokerSteps {
    FindACertifiedBrokerPage findACertifiedBrokerPage = new FindACertifiedBrokerPage(WebDriverManager.getDriver());

    @Then("I enter {string} into the broker location search box")
    public void IEnterIntoTheBrokerLocationSearchBox(String Location) {
        findACertifiedBrokerPage.searchForBrokerLocation(Location);
    }

    @Then("I enter {string} into the broker language search box")
    public void IEnterIntoTheBrokerLanguageSearchBox(String Language) {
        findACertifiedBrokerPage.searchForBrokerLanguage(Language);
    }

    @Then("I clear the broker location search box")
    public void IClearTheBrokerLocationSearchBox(){
        findACertifiedBrokerPage.clearSearchForBrokerLocation();
    }

    @Then("I verify the over 50 search results error is displayed in {string}")
    public void IVerifyTheOver50SearchResultsErrorDisplayed(String language) {
        findACertifiedBrokerPage.validateOver50SearchResultsErrorExists(language);
    }

    @Then("I verify the over 50 search results error does not display")
    public void IVerifyTheOver50SearchResultsErrorDoesNotDisplay() {
        findACertifiedBrokerPage.validateOver50SearchResultsErrorDoesNotExist();
    }
}
