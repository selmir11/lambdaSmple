package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.FindACertifiedBrokerPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class FindACertifiedBrokerSteps {
    FindACertifiedBrokerPage findACertifiedBrokerPage = new FindACertifiedBrokerPage(WebDriverManager.getDriver());

    @Then("I Search authorized Broker {string}")
    public void iSearchAuthorizedBroker(String brokerName) {
        findACertifiedBrokerPage.searchForBrokerName(brokerName);
    }

    @Then("I clear the broker search box")
    public void IClearTheBrokerSearchBox(){
        findACertifiedBrokerPage.clearSearchForBroker();
    }

    @Then("I enter {string} into the broker location search box")
    public void IEnterIntoTheBrokerLocationSearchBox(String Location) {
        findACertifiedBrokerPage.searchForBrokerLocation(Location);
    }

    @Then("I clear the broker location search box")
    public void IClearTheBrokerLocationSearchBox(){
        findACertifiedBrokerPage.clearSearchForBrokerLocation();
    }

    @Then("I enter {string} into the broker language search box")
    public void IEnterIntoTheBrokerLanguageSearchBox(String Language) {
        findACertifiedBrokerPage.searchForBrokerLanguage(Language);
    }

    @And("I click on Search button")
    public void iClickOnSearchButton() {
        findACertifiedBrokerPage.clickSearchButton();
    }

    @And("I click more details from the first broker result container")
    public void iClickMoreDetailsInTheBrokerResultContainer() {
        findACertifiedBrokerPage.clickMoreDetailsInTheBrokerContainer();
    }

    @Then("I click Authorized broker")
    public void iClickAuthorizedBroker() {
        findACertifiedBrokerPage.clickAuthorizedBroker();
    }

    @Then("I verify the over 50 search results error is displayed in {string}")
    public void IVerifyTheOver50SearchResultsErrorDisplayed(String language) {
        findACertifiedBrokerPage.validateOver50SearchResultsErrorExists(language);
    }

    @Then("I verify the over 50 search results error does not display")
    public void IVerifyTheOver50SearchResultsErrorDoesNotDisplay() {
        findACertifiedBrokerPage.validateOver50SearchResultsErrorDoesNotExist();
    }

    @Then("I verify that a total of {string} results displays in {string}")
    public void IVerifyThatATotalOfResultsDisplays(String expectedCount, String language) {
        findACertifiedBrokerPage.validateTotalBrokerResultCountExists(expectedCount, language);
    }

}
