package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalSearchPage;
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
    public void changeEffectiveDateForAccount(){
        adminPortalSearchPage.searchForUser();
        adminPortalSearchPage.clickEmailLinkFrmSrchResults();
    }

    @And("I click {string} from application links dropdown")
    public void selectOptionFromApplicationLinks(String appLinksDropdownOption){
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
            default:
                throw new IllegalArgumentException("Invalid header option : " + HeaderValidation);
        }
    }

    @Then("I click acct in Search Results table on admin portal")
    public void iClickAccountLinkSearchResults() {
        adminPortalSearchPage.clickAccountLinkSearchResults();
    }


}
