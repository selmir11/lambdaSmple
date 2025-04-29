package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalSearchPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

public class AdminPortalSearchSteps {

    AdminPortalSearchPage adminPortalSearchPage = new AdminPortalSearchPage(WebDriverManager.getDriver());

    @Then("I click create account on admin portal")
    public void createAcctOnAdminPortal() {
        adminPortalSearchPage.clickCreateAccount();
    }

    @Then("logout from Admin Portal")
    public void logoutAdminPortal() {
        adminPortalSearchPage.logoutFromAdmin();
    }

    @And("I search for the user with account id")
    public void searchWithAccId() {
        adminPortalSearchPage.searchWithAccId();
    }

    @And("I search for user and click email from search results")
    public void searchAndClickUser() {
        adminPortalSearchPage.searchForUser();
        adminPortalSearchPage.clickEmailLinkFrmSrchResults();
    }

    @And("I click {string} from application links dropdown")
    public void selectOptionFromApplicationLinks(String appLinksDropdownOption) {
        adminPortalSearchPage.clickFromApplicationLinksDropdown(appLinksDropdownOption);
    }

    @Then("I validate {string} for Admin Portal")
    public void HeaderValidation(String HeaderValidation) {

        switch (HeaderValidation) {
            case "Logo":
                adminPortalSearchPage.ConnectForHealthLogoDisplay();
                break;
            case "clicking on logo navigates Connect For Health":
                adminPortalSearchPage.navigateConnectForHealthPage();
                break;
            case "TitleTextValidate":
                adminPortalSearchPage.titleTextValidate();
                break;
            case "UserName Display":
                adminPortalSearchPage.userNameDisplay();
                break;
            case "PersonSymbol Display":
                adminPortalSearchPage.PersonSymbolDisplay();
                break;
            case "UserDropdown Display":
                adminPortalSearchPage.UserDropDownDisplay();
                break;
            case "accountInformation Display":
                adminPortalSearchPage.accountInformationDisplay();
                break;
            case "Logoutbutton Display":
                adminPortalSearchPage.logoutButtonDisplay();
                break;
            case "Admin Portal Text Display":
                adminPortalSearchPage.adminPortalTextDisplay();
                break;
            case "applicationLinkText Display":
                adminPortalSearchPage.applicationLinksTextDisplay();
                break;
            case "applicationlinkarrow Display":
                adminPortalSearchPage.applinkdroodowndisplay();
                break;
            default:
                throw new IllegalArgumentException("Invalid header option : " + HeaderValidation);
        }
    }

    @And("I click Colorado Connect to search user")
    public void iClickColoradoConnectToSearchUser() {
        adminPortalSearchPage.selectCocoIndiviual();
    }

    @Then("I enter an {string} {string} to search user")
    public void iEnterAnToSearchUser(String userdata, String type) {
        adminPortalSearchPage.enterUserData(userdata, type);
    }

    @And("I enter an {string} in any env {string} {string} to search user")
    public void iEnterAnInAnyEnvToSearchUser(String userdata, String QAType, String STGType) {
        adminPortalSearchPage.enterUserDataAnyENV(userdata, QAType, STGType);
    }

    @Then("I click on Search button in AP dashboard page")
    public void iClickOnSearchButtonInAPDashboardPage() {
        adminPortalSearchPage.clickSearch();
    }

    @Then("I select the first record from the search results")
    public void iselectthefirstrecordfromthesearchresults() {
        adminPortalSearchPage.selectRecord();
    }

    @And("I select {string} checkbox on Admin Portal Dashboard")
    public void iClickColoradoConnectCheckbox(String selectUserTypeToSearch) {
        adminPortalSearchPage.SelectUserTypeToSearch(selectUserTypeToSearch);
    }

    @Then("I click acct first row from Search Results table in admin portal")
    public void iClickAccountLinkFirstRowFromSearchResults() {
        adminPortalSearchPage.clickAccountLinkFirstRowFromSearchResults();
    }

    @And("I validate {string} application link not display")
    public void iValidateAppLinksIsNotDisplay(String option) {
        adminPortalSearchPage.validateAppLinksIsNotDisplay(option);
    }

    @Then("I enter an accountId in any Env {string} {string} to search user")
    public void iEnterAnAccountIdInAnyEnvToSearchUser(String stgAccountId, String qaAccountId) {
        adminPortalSearchPage.enterAccountIdToAnyENV(stgAccountId, qaAccountId);
    }

    @Then("I logout from Admin Portal")
    public void iLogoutAdminPortal() {
        adminPortalSearchPage.logoutFromAdminPortalParentPage();
    }

    @Then("I verify error for required at least one search criteria on admin portal search page")
    public void iVerifyErrorForRequiredAtLeastOneSearchCriteriaOnAdminPortalSearchPage() {
        adminPortalSearchPage.requiredSearchCriteria();
    }

    @When("I select {string}")
    public void iSelect(String text) {
        adminPortalSearchPage.selectSortOption(text);
    }

    @Then("I validate the list is sorted in order by {string} and {string}")
    public void iValidateTheListIsSortedInOrderByAnd(String category, String sortOrder) {
        adminPortalSearchPage.verifysort(category, sortOrder);
    }

    @When("I click on reset button on admin portal search page")
    public void iClickOnResetButtonOnOnAdminPortalSearchPage() {
        adminPortalSearchPage.clickResetButton();
    }

    @Then("I validate message for over hundred records")
    public void iValidateMessageForOverHundredRecords() {
        adminPortalSearchPage.morethan100records();
    }

    @Then("I verify account results for {string} on admin portal search page")
    public void iVerifyAccountResultsForOnAdminPortalSearchPage(String category) {
        adminPortalSearchPage.verifyAccountDetails(category);
    }

    @When("I enter the following data for QA or STG:")
    public void iEnterTheFollowingDataForQAOrSTG(DataTable dataTable) {
        adminPortalSearchPage.entersearchdata(dataTable);
    }

    @Then("I verify account created successfully message displays")
    public void iVerifyAccountCreatedSuccessfullyMessageDisplays() {
            adminPortalSearchPage.accountCreatedMessage();
        }

    @Then("I verify data in the fields on the admin portal search page should be blank")
    public void iVerifyDataInTheFieldsOnTheAdminPortalSearchPageShouldBeBlank(DataTable dataTable) {
        adminPortalSearchPage.verifyblankfield(dataTable);
    }

    @Then("I click on Reset button in AP dashboard page")
    public void iClickOnResetButtonInAPDashboardPage() {
        adminPortalSearchPage.clickResetAdminPortal();
    }

    @Then("I select the first broker record from the search results")
    public void iSelectTheFirstBrokerRecordFromTheSearchResults() {
        adminPortalSearchPage.selectTheFirstBrokerRecordFromTheSearchResults();
    }
    @And("I validate the buttons on the Individual Search page")
    public void iValidateOrganizationDetailsButtons() {
        adminPortalSearchPage.validateCoCoDashboardButtons();
    }

    @Then("I search for the {string} generated")
    public void iSearchForTheGenerated(String brokerPortal) {
        adminPortalSearchPage.searchForTheBrokerGenerated(brokerPortal);
    }

    @Then("I search for the {string} title")
    public void iSearchForTitle(String title) {
        adminPortalSearchPage.validateSearchTitle(title);
    }
    @Then("I click on Search button in CBMS Case ID Search page")
    public void iClickOnSearchCBMSPage() {
        adminPortalSearchPage.clickCBMSSearchButton();        }
    @Then("I click on Reset button in CBMS Case ID Search page")
    public void iClickOnResetCBMSPage() {
        adminPortalSearchPage.clickCBMSResetButton();       }

    @Then("I verify Title for CBMS page")
    public void iVerifyTitleForCBMSPage() {
        adminPortalSearchPage.verifyCBMSTitle();        }

    @And("I validate CBMS ID search labels are displayed as expected")
    public void iValidateCBMSIDSearchLabelsAreDisplayedAsExpected() {
        adminPortalSearchPage.verifySearchLabels();     }

    @And("I validate errors for required fields are displayed")
    public void iValidateErrorsForAreDispalyed() {
        adminPortalSearchPage.verifyRequiredFieldsErrors();
    }

    @Then("I click {string} arrow on admin portal")
    public void iClickDropDownArrow(String arrow) {
        adminPortalSearchPage.clickDropDownArrow(arrow);
    }

    @Then("I validate {string} and style properties")
    public void iValidateAndStyleProperties(String headerName, List<Map<String, String>> styles) {
        adminPortalSearchPage.verifyHeaderDisplayAndStyles(headerName);
        adminPortalSearchPage.verifyElementStyles(headerName, styles);
    }

    @Then("I verify search results for {string} on admin portal search page")
    public void iVerifySearchResultsForOnAdminPortalSearchPage(String category, List<Map<String,String>> expectedValues) {
        adminPortalSearchPage.verifySearchResult(category,expectedValues);
    }

    @Then("I verify default value in sort by filter dropdown")
    public void iVerifyDefaultValueInSortByFilterDropdown(String text) {
        adminPortalSearchPage.verifyDefaultSortBy(text);
    }

    @And("I verify Sort By field values")
    public void iVerifySortByFieldValues(List<String> values) {
        adminPortalSearchPage.verifyDropDownValues(values);
    }

    @Then("I validate the list is sorted in order by {string} and {string} for duplicate matches")
    public void iValidateTheListIsSortedInOrderByAndForDuplicateMatches(String category, String sort) {
        adminPortalSearchPage.verifySortascdesc(category,sort);
    }

    @Then("I validate the list is sorted by account ID in {string} order")
    public void iValidateTheListIsSortedByAnd(String sortOrder) {
        adminPortalSearchPage.verifySortByAcct(sortOrder);
    }

    @When("I select option as {string}")
    public void iSelectOptionAs(String value) {
        adminPortalSearchPage.selectSortByOption(value);
    }
}
