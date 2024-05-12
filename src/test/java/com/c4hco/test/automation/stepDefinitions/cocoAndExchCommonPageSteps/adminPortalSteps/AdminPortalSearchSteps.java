package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalSearchPage;
import com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.BasicSteps;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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
    public void iEnterAnToSearchUser(String userdata,String type) {
        adminPortalSearchPage.enterUserData(userdata,type);
    }

    @Then("I click on Search Button")
    public void iClickOnSearch() {
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
    public void iValidateAppLinksIsNotDisplay(String option)    {
            adminPortalSearchPage.validateAppLinksIsNotDisplay(option); }

    @Then("I enter an accountId in any Env {string} {string} to search user")
    public void iEnterAnAccountIdInAnyEnvToSearchUser(String stgAccountId, String qaAccountId) {
        adminPortalSearchPage.enterAccountIdToAnyENV(stgAccountId,qaAccountId);
    }
}

