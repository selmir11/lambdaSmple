package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.FindExpertHelpPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;


public class FindExpertHelpSteps {
        FindExpertHelpPage findExpertHelpPage = new FindExpertHelpPage(WebDriverManager.getDriver());

        @Then("I verify Find Expert Help header Text in {string}")
        public void IVerifyFindExpertHelpHeaderTextIn(String Language) {
                findExpertHelpPage.verifyHeaderPage(Language);
        }

        @Then("I verify Manage who helps you header text in {string}")
        public void IVerifyManageWhoHelpsYouHeaderText(String Language){
                findExpertHelpPage.verifyManageWhoHelpsYouHeaderText(Language);
        }

        @Then("I verify Find Expert Help page {string} title Text in {string}")
        public void i_verify_find_expert_help_page_title_text_in(String Marketplace, String Language) {
                findExpertHelpPage.verifyTitlePage(Marketplace, Language);
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

        @Then("I validate the Find a Broker button {string} displayed")
        public void iValidateTheFindABrokerButtonDisplayed(String expectedState){
                findExpertHelpPage.validateFindABrokerButtonExists(expectedState);
        }

        @Then("I validate the Change Broker button {string} displayed")
        public void iValidateTheChangeBrokerButtonDisplayed(String expectedState){
                findExpertHelpPage.validateChangeBrokerButtonExists(expectedState);
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

        @And("I validate current Broker text exists")
        public void iValidateCurrentBrokerTextExists() {
                findExpertHelpPage.validateBrokerExists();
        }

        @And("I validate the current broker table header labels")
        public void iValidateCurrentBrokerTableHeaderLabels(){
                findExpertHelpPage.validateCurrentBrokerTableHeader();
        }

        @And("I validate my broker details in the current broker table are {string}, {string}, {string}, {string}, {string}, {string}, {string}")
        public void iValidateBrokerDetailsCurrentBrokerTable(String brokerName, String agencyName, String licenseNumber, String zipCode, String phoneNumber, String type, String status){
                findExpertHelpPage.validateBrokerDetailsCurrentBrokerTable(brokerName, agencyName, licenseNumber, zipCode, phoneNumber, type, status);
        }

        @Then("I click the back button from Find Expert Help page")
        public void iClickBackButton() {
                findExpertHelpPage.clickBackButton();
        }

        @Then("I click Continue on my own button from Manage who helps you page")
        public void iClickContinueOnOwnButton() {
                findExpertHelpPage.clickContinueOnMyOwnButton();
        }

        @And("I validate no broker is authorized")

        public void iValidateNoBrokerIsAuthorized() {
                findExpertHelpPage.validateNoBrokerIsAuthorized();
        }

        @Then("I validate the Continue with my application button {string} displayed")
        public void iValidateContinueWithMyApplicationButtonExists(String expectedState){
                findExpertHelpPage.validateContinueWithMyApplicationButtonExists(expectedState);
        }

        @Then("I validate the Continue on my own button {string} displayed")
        public void iValidateContinueOnMyOwnButtonExists(String expectedState){
                findExpertHelpPage.validateContinueOnMyOwnButtonExists(expectedState);
        }
}