package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalSearchPage;
import com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BasicSteps;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

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

    @And("I search for user and click email from search results")
    public void changeEffectiveDateForAccount() {
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
}



