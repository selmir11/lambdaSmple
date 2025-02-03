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

    @Then("I click on the first client in my list")
    public void IClickOnFirstClient() {
        yourClientsPage.clickFirstClient();
    }

    @And("I search for a client named {string}")
    public void ISearchClientNamed(String clientName) {
        yourClientsPage.searchClientNamed(clientName);
    }

    @And("I clear the client search box to reset my list")
    public void IResetClientSearch() {
        yourClientsPage.resetClientSearchBox();
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

    @Then("I validate the Remove Client modal title")
    public void iValidateRemoveClientModalTitle() {
        yourClientsPage.validateRemoveClientModalTitle();
    }

    @Then("I validate the Remove Client modal client count text")
    public void iValidateRemoveClientModalCountText() {
        yourClientsPage.validateRemoveClientModalCountText();
    }

    @Then("I validate the Remove Client modal confirmation text")
    public void iValidateRemoveClientModalConfirmationText() {
        yourClientsPage.validateRemoveClientModalConfirmationText();
    }

    @Then("I validate the Remove Client modal client count matches the selected client count")
    public void iValidateRemoveClientCountMatchesSelectedClients() {
        yourClientsPage.validateRemoveClientCountMatchesSelectedClients();
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

    @And("I save the number of clients selected")
    public void iSaveSelectedClientCount() {
        yourClientsPage.saveSelectedClientCount();
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

    @Then("I validate the search box cannot contain special characters")
    public void iVerifySearchBoxSpecialCharacters() {
        yourClientsPage.validateSearchBoxSpecialCharacters();
    }

    @Then("I validate numbers are not allowed in the search box")
    public void iVerifySearchBoxNumbers() {
        yourClientsPage.validateNumbersNotAllowedSearchBox();
    }

    @Then("I validate spaces are not allowed in the search box")
    public void iVerifySearchBoxSpaces() {
        yourClientsPage.validateSpacesNotAllowedSearchBox();
    }

    @Then("I verify the current client list result page is {string}")
    public void iVerifyCurrentClientListPage(String currentPage) {
        yourClientsPage.verifyCurrentClientListPage(currentPage);
    }

    @And("I click the client list right pagination arrow button")
    public void iClickRightPaginationArrowButton() {
        yourClientsPage.clickRightPaginationArrowButton();
    }

    @And("I click the client list left pagination arrow button")
    public void iClickLeftPaginationArrowButton() {
        yourClientsPage.clickLeftPaginationArrowButton();
    }

    @Then("I verify the clients are listed in alphabetical order")
    public void iVerifyClientsAlphabeticalOrder() {
        yourClientsPage.verifyClientsAlphabeticalOrder();
    }

    @Then("I validate the {string} option is displayed")
    public void iValidateClientOptionsDisplayed(String clientOption) {
        yourClientsPage.validateClientOptionsDisplayed(clientOption);
    }

    @Then("I validate the {string} option is not displayed")
    public void iValidateClientOptionsNotDisplayed(String clientOption) {
        yourClientsPage.validateClientOptionsNotDisplayed(clientOption);
    }

    @And("I validate the {string} header option is not displayed")
    public void iValidateHeaderOptionsNotDisplayed(String headerOption) {
        yourClientsPage.validateHeaderOptionsNotDisplayed(headerOption);
    }

    @And("I validate the {string} header option is displayed")
    public void iValidateHeaderOptionsDisplayed(String headerOption) {
        yourClientsPage.validateHeaderOptionsDisplayed(headerOption);
    }

    @Then("I verify that a total of {string} clients have been selected")
    public void iValidateTotalSelectedClientCount(String expectedCount) {
        yourClientsPage.validateTotalSelectedClientCount(expectedCount);
    }

    @Then("I select a random client's checkbox")
    public void iSelectRandomClientCheckbox() {
        yourClientsPage.selectRandomClientCheckbox();
    }

    @And("I verify that the check all clients checkbox is disabled")
    public void iVerifyCheckAllClientsCheckboxDisabled() {
        yourClientsPage.verifyCheckAllClientsCheckboxDisabled();
    }

    @And("I validate the Client Transfer Successful message")
    public void iValidateClientTransferSuccessfulMessage() {
        yourClientsPage.validateClientTransferSuccessfulMessage();
    }

    @Then("I click the Transfer All Clients button")
    public void iClickTransferAllClientsButton() {
        yourClientsPage.clickTransferAllClients();
    }

    @Then("I verify existing client details {string}, {string}, {string}, {string} or {string}")
    public void iVerifyExistingClientDetails(String clientName, String clientZip, String phoneNumber, String clientAccountStg, String clientAccountQA) {
        yourClientsPage.verifyExistingClientDetails(clientName, clientZip, phoneNumber, clientAccountStg, clientAccountQA);
    }

    @Then("I verify existing client plan details {string}, {string}, {string}")
    public void iVerifyExistingClientPlanDetails(String planYear, String eligResults, String issuerName) {
        yourClientsPage.verifyExistingClientPlanDetails(planYear, eligResults, issuerName);
    }

    @Then("I verify the existing secondary client details {string}, {string}, {string}, {string}, {string}")
    public void iVerifyExistingSecondaryClientDetails(String clientName, String clientZip, String planYear, String eligResults, String issuerName) {
        yourClientsPage.verifyExistingSecondaryClientDetails(clientName, clientZip, planYear, eligResults, issuerName);
    }


    @And("I validate the MVR container text in the dashboard Page")
    public void iValidateTheMVRContainerTextInTheDashboardPage() {
        yourClientsPage.validateTheMVRContainerTextInTheDashboardPage();
    }

    @Then("I validate the I can't search for special characters on Search Bar")
    public void iValidateTheICanTSearchForSpecialCharactersOnSearchBar() {
        yourClientsPage.validateTheICanTSearchForSpecialCharactersOnSearchBar();
    }

    @Then("I search for STG {string} QA {string} in search mvr container")
    public void iSearchForSTGQAInSearchMvrContainer(String STGClient, String QAClient) {
        yourClientsPage.searchForInSearchMvrContainer(STGClient, QAClient);
    }

    @And("I clear the MVR search box in broker dashboard page")
    public void iClearTheMVRSearchBoxInBrokerDashboardPage() {
        yourClientsPage.clearTheMVRSearchBoxInBrokerDashboardPage();
    }

    @And("I click the right pagination arrow button {int} times in mvr container")
    public void iClickTheRightPaginationArrowButtonTimesInMvrContainer(int numberTime) {
        yourClientsPage.clickTheRightPaginationArrowButtonTimesInMvrContainer(numberTime);
    }

    @Then("I verify the current result page is {string} in mvr container")
    public void iVerifyTheCurrentResultPageIsInMvrContainer(String currentPage) {
        yourClientsPage.verifyTheCurrentResultPageIsInMvrContainer(currentPage);
    }

    @And("I click the left pagination arrow button {int} times in mvr container")
    public void iClickTheLeftPaginationArrowButtonTimesInMvrContainer(int numberTime) {
        yourClientsPage.clickTheLeftPaginationArrowButtonTimesInMvrContainer(numberTime);
    }

    @And("I validate the result contains {string}")
    public void iValidateTheResultContains(String search) {
        yourClientsPage.validateTheResultContains(search);
    }

    @Then("I validate the mvr container is not displayed")
    public void iValidateTheMvrContainerIsNotDisplayed() {
        yourClientsPage.validateTheMvrContainerIsNotDisplayed();
    }

    @And("I validate the first name {string} last Name {string} Type {string} Due Date {string} and action Type {string}")
    public void iValidateTheFirstNameLastNameTypeDueDateAndActionType(String firstName, String lastName, String Type,String DueDate, String actionType) {
        yourClientsPage.validateTheFirstNameLastNameTypeDueDateAndActionType(firstName,lastName,Type, DueDate, actionType);
    }

    @Then("I click verify info button on MVR container")
    public void iClickVerifyInfoButtonOnMVRContainer() {
        yourClientsPage.clickVerifyInfoButtonOnMVRContainer();
    }

    @Then("I search for the client created in search mvr container")
    public void iSearchForTheClientCreatedInSearchMvrContainer() {
        yourClientsPage.searchForTheClientCreatedInSearchMvrContainer();
    }

    @And("I validate the MVR Type {string} and action Type {string}")
    public void iValidateTheMVRTypeAndActionType(String mvrType,  String actionButton) {
        yourClientsPage.validateTheMVRTypeAndActionType(mvrType, actionButton);
    }

    @And("I validate the client data on the MVR container {string}")
    public void iValidateTheClientDataOnTheMVRContainer(String  actionBtn) {
        yourClientsPage.validateTheClientDataOnTheMVRContainer(actionBtn);
    }
}

