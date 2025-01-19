package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.FindACertifiedBrokerPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class FindACertifiedBrokerSteps {
    FindACertifiedBrokerPage findACertifiedBrokerPage = new FindACertifiedBrokerPage(WebDriverManager.getDriver());

    @Then("I validate the Find a Certified Broker near you page title in {string}")
    public void iValidateFindABrokerPageTitle(String language){
        findACertifiedBrokerPage.FindABrokerPageTitle(language);
    }

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

    @Then("I enter the new agency license number into the Find a Broker search")
    public void IEnterNewLicenseNumberSearchBox() {
        findACertifiedBrokerPage.enterNewLicenseNumberSearch();
    }

    @Then("I clear the broker location search box")
    public void IClearTheBrokerLocationSearchBox(){
        findACertifiedBrokerPage.clearSearchForBrokerLocation();
    }

    @Then("I enter {string} into the broker language search box")
    public void IEnterIntoTheBrokerLanguageSearchBox(String Language) {
        findACertifiedBrokerPage.searchForBrokerLanguage(Language);
    }

    @And("I click on Search button in find certified broker page")
    public void iClickOnSearchButton() {
        findACertifiedBrokerPage.clickSearchButton();
    }

    @Then("I click Go Back on the Find a Certified Broker page")
    public void iClickGoBackButton(){
        findACertifiedBrokerPage.clickGoBackButton();
    }

    @And("I click more details from the first broker result container")
    public void iClickMoreDetailsInTheBrokerResultContainer() {
        findACertifiedBrokerPage.clickMoreDetailsInTheBrokerContainer();
    }

    @And("I click more details on the first broker result")
    public void iClickMoreDetailsBrokerResult() {
        findACertifiedBrokerPage.clickMoreDetailsBroker();
    }

    @And("I click hide details")
    public void iClickHideDetails(){
        findACertifiedBrokerPage.clickHideDetails();
    }

    @And("I validate the agency details are hidden")
    public  void iValidateAgencyDetailsAreHidden(){
        findACertifiedBrokerPage.validateAgencyDetailsHidden();
    }

    @Then("I click Authorized broker")
    public void iClickAuthorizedBroker() {
        findACertifiedBrokerPage.clickAuthorizedBroker();
    }
    @Then("I click Authorize button in container")
    public void iClickAuthorizeButton() {
        findACertifiedBrokerPage.clickAuthorizeButton();
    }


    @And ("I sort the results {string}")
    public void iSortTheResults(String sortOption){
        findACertifiedBrokerPage.clickResultsSort(sortOption);
    }

    @Then("I validate broker name is {string}")
    public void iValidateBrokerName(String brokerName){
        findACertifiedBrokerPage.validateBrokerDisplayedName(brokerName);
    }

    @Then("I validate agency name is {string}")
    public void iValidateAgencyName(String agencyName){
        findACertifiedBrokerPage.validateAgencyDisplayedName(agencyName);
    }

    @Then("I validate agency address is {string}")
    public void iValidateAgencyAddress(String address){
        findACertifiedBrokerPage.validateAgencyAddress(address);
    }

    @Then("I validate agency address is hidden")
    public void iValidateAgencyAddressHidden(){
        findACertifiedBrokerPage.validateAgencyAddressHidden();
    }

    @Then("I validate agency city state and zip is {string}")
    public void iValidateAgencyCityStateZip(String cityStateZip){
        findACertifiedBrokerPage.validateAgencyCityStateZip(cityStateZip);
    }

    @Then("I validate the new agency address")
    public void iValidateNewAgencyAddress(){
        findACertifiedBrokerPage.validateNewAgencyAddress();
    }

    @Then("I validate the agency details field labels in {string}")
    public void iValidateAgencyDetailsFieldLabels(String language){
        findACertifiedBrokerPage.validateAgencyDetailsLabels(language);
    }

    @Then("I validate the agency details {string}, {string}, {string}, {string}, {string}, {string}")
    public void iValidateAgencyDetails(String emailAddress, String expectedPhoneNumber, String availability, String officeHours, String expectedLicenseNumber, String agencyLanguage){
        findACertifiedBrokerPage.validateAgencyDetails(emailAddress, expectedPhoneNumber, availability, officeHours, expectedLicenseNumber, agencyLanguage);
    }

    @Then("I validate the new agency details {string}, {string}, {string}, {string}, {string}")
    public void iValidateNewAgencyDetails(String emailAddress, String expectedPhoneNumber, String availability, String officeHours, String agencyLanguage){
        findACertifiedBrokerPage.validateNewAgencyDetails(emailAddress, expectedPhoneNumber, availability, officeHours, agencyLanguage);
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

    @And("I click the right pagination arrow button {int} times")
    public void IClickTheRightPaginationArrowButton(int numberTimes){
        findACertifiedBrokerPage.clickRightPaginationArrowButtonFindBroker(numberTimes);
    }

    @And("I click the left pagination arrow button {int} times")
    public void IClickTheLeftPaginationArrowButton(int numberTimes){
        findACertifiedBrokerPage.clickLeftPaginationArrowButtonFindBroker(numberTimes);
    }

    @Then("I verify the current result page is {string}")
    public void IVerifyCurrentResultPage(String currentPage){
        findACertifiedBrokerPage.verifyCurrentBrokerResultsPage(currentPage);}

    @And("I validate the have a {string} broker call you text in {string}")
    public void iValidateHaveBrokerCallYouText(String marketplace, String language){
        findACertifiedBrokerPage.validateBrokerContactYouText(marketplace, language);
    }

    @And("I validate the button and field text in {string}")
    public void iValidateButtonAndFieldText(String language){
        findACertifiedBrokerPage.validateButtonAndFieldText(language);
    }

    @Then ("I click the Authorize broker button")
    public void iClickAuthorizeBrokerButton (){
        findACertifiedBrokerPage.clickAuthorizeBrokerButton();
    }

    @Then ("I click the {string} button on the Authorize a broker modal")
    public void iClickAuthorizeBrokerOptionButton (String buttonOption){
        findACertifiedBrokerPage.clickAuthorizeBrokerOptionButton(buttonOption);
    }

    @And("I validate the text to authorize a new broker {string} with {string} or keep the same broker {string} with {string} in {string} for {string}")
    public void iValidateChangeBrokerText(String newBrokerName, String newBrokerAgency, String currentBrokerName, String currentBrokerAgency, String language, String marketplace) {
        findACertifiedBrokerPage.validateChangeBrokerText(newBrokerName, newBrokerAgency, currentBrokerName, currentBrokerAgency, language, marketplace);
    }

    @And("I validate the text to authorize a new broker in {string}")
    public void iValidateAuthorizeBrokerText(String language) {
        findACertifiedBrokerPage.validateAuthorizeBrokerText(language);
    }

    @And("I click on {string} in the warning container to authorize new or keep the same broker")
    public void iClickChangeBrokerOption(String changeBrokerOption) {
        findACertifiedBrokerPage.clickChangeBrokerOption(changeBrokerOption);
    }

    @Then("I click Continue with my application")
    public void iClickContinueWithMyApplication() {
        findACertifiedBrokerPage.ClickContinueWithMyApplication();
    }
}
