package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AdminLceToolPage;
import com.c4hco.test.automation.pages.exchPages.AdminPortalSearchPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class AdminPortalSteps {

    AdminPortalSearchPage adminPortalSearchPage = new AdminPortalSearchPage(WebDriverManager.getDriver());
    AdminLceToolPage adminLceToolPage = new AdminLceToolPage(WebDriverManager.getDriver());

    @And("I Change Effective Date for account to first of January from admin portal")
    public void changeEffectiveDateForAccount(){
        adminPortalSearchPage.changeEffectiveDate();
        adminLceToolPage.lookUp();
    }
}
