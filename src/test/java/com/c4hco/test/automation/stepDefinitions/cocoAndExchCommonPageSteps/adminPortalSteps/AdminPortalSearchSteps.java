package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalSearchPage;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdminPortalSearchSteps {

    AdminPortalSearchPage adminPortalSearchPage = new AdminPortalSearchPage(WebDriverManager.getDriver());
    BasicActions basicActions = new BasicActions(WebDriverManager.getDriver());

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

    @And("I check {string} user type to search on Admin Portal dashboard")
    public void checkUserTypeToSearch(String selectUserTypeToSearch) {
        adminPortalSearchPage.checkUserTypeToSearch(selectUserTypeToSearch);
    }

    @Then("I click search button on admin portal")
    public void clickSearchOnAdminPortal() {
        adminPortalSearchPage.clickSearchButtonOnAdminPortal();
    }

    @Then("I verify title text on the Individual search page")
    public void iVerifyTextOnTheIndividualSearchPageForTitle() {
        String searchTitle;
    }

    @Then("I enter account number for individual")
    public void enterAcctIdIndividual(){
          adminPortalSearchPage.iEnterAcctIdIndividual("8150738600");
    }










}


// ############################## VALIDATION STEPS #########################



