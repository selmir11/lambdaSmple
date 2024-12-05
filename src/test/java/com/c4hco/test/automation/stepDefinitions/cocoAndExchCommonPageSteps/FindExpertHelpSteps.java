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

        @Then("I click on change the existing broker")
        public void iClickChangeBrokerButton(){
                findExpertHelpPage.clickChangeBrokerButton();
        }

        @Then("I validate the Have a Broker call you button is displayed")
        public void iValidateTheHaveABrokerCallYouButtonExists(){
                findExpertHelpPage.validateHaveABrokerCallYouButtonExists();
        }

        @Then("I validate the Find an Assister button is displayed")
        public void iValidateTheFindAnAssisterButtonExists(){
                findExpertHelpPage.validateFindAnAssisterButtonExists();
        }

        @Then("I validate the Authorize Assister Organization button {string}")
        public void iValidateTheAuthorizeAssisterOrganizationButtonDisplayed(String expectedState){
                findExpertHelpPage.validateAuthorizeAssisterOrganizationButtonExists(expectedState);
        }

        @Then("I click the Authorize Assister Organization button")
        public void iClickAuthorizeAsssiterOrgButton(){
                findExpertHelpPage.clickAuthorizeAsssiterOrgButton();
        }

        @And("I validate the Change Assister button {string}")
        public void iValidateChangeAssisterButtonExists(String expectedState){
                findExpertHelpPage.validateChangeAssisterButtonExists(expectedState);
        }

        @Then("I Remove my current Assister")
        public void iClickRemoveAsssiterButton(){
                findExpertHelpPage.clickRemoveAsssiterButtonButton();
        }

        @And("I {string} my decision to remove my current assister")
        public void iClickRemoveAssisterPopUp(String removalOption){
                findExpertHelpPage.clickRemoveAssisterPopUp(removalOption);
        }

        @And("I validate current Broker text exists")
        public void iValidateCurrentBrokerTextExists() {
                findExpertHelpPage.validateBrokerExists();
        }

        @And("I save the broker's details")
        public void iSaveBrokerDetails() {
                findExpertHelpPage.saveBrokerDetails();
        }

        @And("I validate the current assister text exists")
        public void iValidateCurrentAssisterTextExists() {
                findExpertHelpPage.validateAssisterExists();
        }

        @And("I validate the current broker table header labels")
        public void iValidateCurrentBrokerTableHeaderLabels(){
                findExpertHelpPage.validateCurrentBrokerTableHeader();
        }

        @And("I validate the current assister table header labels")
        public void iValidateCurrentAssisterTableHeaderLabels(){
                findExpertHelpPage.validateCurrentAssisterTableHeader();
        }

        @And("I validate my broker details in the current broker table are {string}, {string}, {string}, {string}, {string}, {string}, {string}")
        public void iValidateBrokerDetailsCurrentBrokerTable(String brokerName, String agencyName, String licenseNumber, String zipCode, String phoneNumber, String type, String status){
                findExpertHelpPage.validateBrokerDetailsCurrentBrokerTable(brokerName, agencyName, licenseNumber, zipCode, phoneNumber, type, status);
        }

        @And("I validate my assister details in the current assister table are {string}, {string} or {string}, {string}, {string}, Assister, Approved")
        public void iValidateAssisterDetailsCurrentAssisterTable(String orgName, String siteIdStg, String siteIdQa, String zipCode, String phoneNumber){
                findExpertHelpPage.validateAssisterDetailsCurrentAssisterTable(orgName, siteIdStg, siteIdQa, zipCode, phoneNumber);
        }

        @Then("I click the back button from Find Expert Help page")
        public void iClickBackButton() {
                findExpertHelpPage.clickBackButton();
        }

        @Then("I click Continue on my own button from Manage who helps you page")
        public void iClickContinueOnOwnButton() {findExpertHelpPage.clickContinueOnMyOwnButton();
        }

        @Then("I Remove my current Broker")
        public void iRemoveMyCurrentBroker(){
                findExpertHelpPage.clickRemoveBrokerButton();
        }

        @And("I {string} my decision to remove my current broker")
        public void iClickRemoveBrokerPopUp(String removalOption){
                findExpertHelpPage.clickRemoveBrokerPopUp(removalOption);
        }

        @And("I verify the remove broker text in {string}")
        public void iVerifyRemoveBrokerPopUpText(String language){
                findExpertHelpPage.verifyRemoveBrokerPopUpText(language);
        }

        @And("I validate the Previous Broker Assister text")
        public void iValidatePreviousBrokerAssisterText(){
                findExpertHelpPage.validatePreviousBrokerAssisterText();
        }
        @And("I validate the Previous Broker Assister table header labels")
        public void iValidatePreviousBrokerAssisterTableLabels(){
                findExpertHelpPage.validatePreviousBrokerAssisterTableLabels();
        }

        @Then("I validate the Assister details in the Previous Broker Assister table are {string}, {string}, or {string}, {string}, {string}, Assister")
        public void iValidateAssisterDetailsPrevBrokerAssisterTable(String name, String siteIdStg, String siteIdQa, String zip, String phoneNumber){
                findExpertHelpPage.validateAssisterPrevBrokerAssisterTable(name, siteIdStg, siteIdQa, zip, phoneNumber);
        }

        @Then ("I validate the details in the Previous Broker Assister table are {string}, {string}, {string}, {string}, {string}")
        public void iValidatePreviousBrokerAssisterTableData(String name, String licenseSiteId, String zip, String phoneNumber, String type){
                findExpertHelpPage.validatePreviousBrokerAssisterTableData(name, licenseSiteId, zip, phoneNumber, type);
        }

        @And("I validate the Previous Broker Assister table is not displayed")
        public void iValidatePreviousBrokerAssisterTableAbsent(){
                findExpertHelpPage.validatePreviousBrokerAssisterTableAbsent();
        }

        @Then("I verify the previous brokers and assisters are listed in alphabetical order")
        public void iValidatePreviousBrokerAssisterTableAlphabeticalOrder(){
                findExpertHelpPage.validatePreviousBrokerAssisterTableAlphabeticalOrder();
        }

        @And("I validate no broker is authorized")
        public void iValidateNoBrokerIsAuthorized() {findExpertHelpPage.validateNoBrokerIsAuthorized();}

        @And("I validate no assister is authorized")
        public void iValidateNoAssisterIsAuthorized() {findExpertHelpPage.validateNoAssisterIsAuthorized();}

        @Then("I validate the Continue with my application button is displayed in {string}")
        public void iValidateContinueWithMyApplicationButtonExists(String language){
                findExpertHelpPage.validateContinueWithMyApplicationButtonExists(language);
        }

        @Then("I validate the Continue on my own button {string}")
        public void iValidateContinueOnMyOwnButtonExists(String expectedState){
                findExpertHelpPage.validateContinueOnMyOwnButtonExists(expectedState);
        }

        @Then("I verify the Enroll on my own section text in {string}")
        public void iVerifyEnrollOnMyOwnText(String language){
                findExpertHelpPage.verifyEnrollOnMyOwnText(language);
        }

        @Then("I verify the Enroll on my own section text is not displayed")
        public void iVerifyEnrollOnMyOwnTextIsNotDisplayed(){
                findExpertHelpPage.verifyEnrollOnMyOwnTextIsNotDisplayed();
        }

        @Then("I verify that the broker change and remove buttons are disabled")
        public void iVerifyBrokerButtonsDisabled(){
                findExpertHelpPage.verifyBrokerButtonsDisabled();
        }

        @Then("I verify that the assister change and remove buttons are disabled")
        public void iVerifyAssisterButtonsDisabled(){
                findExpertHelpPage.verifyAssisterButtonsDisabled();
        }
}