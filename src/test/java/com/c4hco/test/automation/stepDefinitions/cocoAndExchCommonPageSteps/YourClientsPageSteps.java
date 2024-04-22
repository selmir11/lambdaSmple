package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.YourClientsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class YourClientsPageSteps {
    YourClientsPage yourClientsPage = new YourClientsPage(WebDriverManager.getDriver());
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
}

