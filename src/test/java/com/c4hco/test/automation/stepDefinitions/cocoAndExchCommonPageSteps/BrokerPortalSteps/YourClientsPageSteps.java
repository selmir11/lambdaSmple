package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BrokerPortalSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages.YourClientsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class YourClientsPageSteps {
    YourClientsPage yourClientsPage = new YourClientsPage(WebDriverManager.getDriver());

    @Then("I validate the Your Clients page title")
    public void iValidateYourClientsPageTitle(){
        yourClientsPage.validateYourClientsPageTitle();
    }

    @And("I click on {string} tab")
    public void iClickOnTab(String userTab) {
        yourClientsPage.clickUserTab(userTab);
    }

    @And("I click print button")
    public void iClickPrintButton() {yourClientsPage.clickPrintButton();}

    @Then("I verify that Print button is visible and enable")
    public void iVerifyThatPrintButtonIsVisibleAndEnable() {yourClientsPage.verifyPrintButtonIsDisplayed();}


    @And("I search for clients")
    public void iSearchForClients() {
        yourClientsPage.searchForClient();
    }

    @Then("I click on first client search result")
    public void IClickOnFirstClientSearchResult() {
        yourClientsPage.clickClientResult();
    }

    @Then("I verify that my client's current status is {string}")
    public void iVerifyCurrentClientStatus(String expectedClientStatus) {
        yourClientsPage.verifyCurrentClientStatus(expectedClientStatus);
    }

    @And("I verify my client's name is displayed")
    public void iVerifyClientFullName() {
        yourClientsPage.verifyClientFullName();
    }

    @And("I verify my client's second subscriber's name")
    public void iVerifySecondSubscriberName() {
        yourClientsPage.verifySecondSubscriberName();
    }

    @Then("I verify that my client's second subscriber status is POLICY SUBMITTED")
    public void iVerifySecondClientStatus() {
        yourClientsPage.verifySecondClientStatus();
    }

    @And("I verify my client's third subscriber's name")
    public void iVerifyThirdSubscriberName() {
        yourClientsPage.verifyThirdSubscriberName();
    }

    @Then("I verify that my client's third subscriber status is POLICY SUBMITTED")
    public void iVerifyThirdClientStatus() {
        yourClientsPage.verifyThirdClientStatus();
    }

    @And("I click {string} the client")
    public void iClickTheClient(String option) {
        yourClientsPage.clickOptionToHandelClient(option);
    }

    @Then("I click {string} remove client")
    public void iClickRemoveClient(String popupOption) {
        yourClientsPage.clickPOPUPOption(popupOption);
    }
    @Then("I validate The Client is removed successfully")
    public void IValidateTheClientIsRemovedSuccessfully() {
        yourClientsPage.validateClientIsRemoved();
    }

    @Then("I select the client searched")
    public void iSelectTheClientSearched() {
        yourClientsPage.selectTheClient();
    }

    @And("I select the {string} option from the header of the broker container")
    public void iSelectTheOptionFromTheHeaderOfTheBrokerContainer(String optionSelected) {
        yourClientsPage.selectOptionFromBrokerContainer(optionSelected);
    }

    @Then("I click on broker userName and logout")
    public void iClickOnBrokerUserNameAndLogout() {
        yourClientsPage.logoutFromBrokerAccount();
    }

    @Then("I select all clients checkbox")
    public void iSelectAllClientsCheckbox() {
        yourClientsPage.selectAllTheClientsCheckBox();
    }

    @Then("I validate the premium amount displayed for my client")
    public void iValidateClientPremium(){
        yourClientsPage.validateClientPremiumAmount();
    }

    @And("I search for the secondary client on the same household")
    public void iSearchForTheSecondaryClientOnTheSameHousehold() {
        yourClientsPage.searchForTheSecondaryClient();
    }

    @Then("I verify that the client name match the primary contact")
    public void iVerifyThatTheClientNameMatchThePrimaryContact() {
        yourClientsPage.verifyClientNameAsPrimary();
    }
}

