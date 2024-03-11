package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AdminPortalSearchPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class AdminPortalSearchSteps {

    AdminPortalSearchPage adminPortalSearchPage = new AdminPortalSearchPage(WebDriverManager.getDriver());

    @And("I search for user and click email from search results")
    public void changeEffectiveDateForAccount(){
        adminPortalSearchPage.searchForUser();
        adminPortalSearchPage.clickEmailLinkFrmSrchResults();
    }

    @And("I click {string} from application links dropdown")
    public void selectOptionFromApplicationLinks(String appLinksDropdownOption){
        adminPortalSearchPage.clickFromApplicationLinksDropdown(appLinksDropdownOption);
    }


}
