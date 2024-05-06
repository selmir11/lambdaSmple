package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.FindExpertHelpPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;
import org.testng.asserts.SoftAssert;

public class FindExpertHelpSteps {
        FindExpertHelpPage findExpertHelpPage = new FindExpertHelpPage(WebDriverManager.getDriver());

        @Then("I verify Find Expert Help header Text in {string}")
        public void IVerifyFindExpertHelpHeaderTextIn(String Language) {
                findExpertHelpPage.verifyHeaderPage(Language);
        }

        @Then("I verify Find Expert Help page title Text in {string}")
        public void i_verify_find_expert_help_page_title_text_in(String Language) {
                findExpertHelpPage.verifyTitlePage(Language);
        }

        @Then("I verify Find Expert Help page Text in {string}")
        public void IVerifyFindExpertHelpPageTextIn (String Language) {
                findExpertHelpPage.verifyPageText(Language);
        }

        @Then("I verify Find Expert Help buttons in {string}")
        public void i_verify_find_expert_help_buttons_in(String Language) {
                findExpertHelpPage.verifyButtontext(Language);
        }

        @And("I click on Find a Broker")
        public void iClickOnFindABroker() {
                findExpertHelpPage.clickFindBroker();
        }

        @Then("I Search authorized Broker {string}")
        public void iSearchAuthorizedBroker(String brokerName) {
                findExpertHelpPage.searchForBrokerName(brokerName);
        }

        @And("I click on Search button")
        public void iClickOnSearchButton() {
                findExpertHelpPage.clickSearchButton();
        }

        @And("I click more details from the first broker result container")
        public void iClickMoreDetailsInTheBrokerResultContainer() {
                findExpertHelpPage.clickMoreDetailsInTheBrokerContainer();
        }

        @Then("I click Authorized broker")
        public void iClickAuthorizedBroker() {
                findExpertHelpPage.clickAuthorizedBroker();
        }



        @And("I validate current Broker text exists")
        public void iValidateCurrentBrokerTextExists() {
                findExpertHelpPage.validateBrokerExists();
        }

        @Then("I validate the Find a Broker button {string} displayed")
        public void iValidateTheFindABrokerButtonDisplayed(String expectedState){
                findExpertHelpPage.validateFindABrokerButtonExists(expectedState);
        }

        @Then("I validate the Have a Broker call you button is displayed")
        public void iValidateTheHaveABrokerCallYouButtonExists(){
                findExpertHelpPage.validateHaveABrokerCallYouButtonExists();
        }

        @Then("I validate the Find an Assister button is displayed")
        public void iValidateTheFindAnAssisterButtonExists(){
                findExpertHelpPage.validateFindAnAssisterButtonExists();
        }

        @Then("I validate the Authorize Assister Organization button {string} displayed")
        public void iValidateTheAuthorizeAssisterOrganizationButtonDisplayed(String expectedState){
                findExpertHelpPage.validateAuthorizeAssisterOrganizationButtonExists(expectedState);
        }
}
