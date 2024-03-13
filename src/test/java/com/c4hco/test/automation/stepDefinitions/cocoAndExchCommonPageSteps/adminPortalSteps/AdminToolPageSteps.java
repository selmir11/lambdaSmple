package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminLceToolPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class AdminToolPageSteps {
    AdminLceToolPage adminLceToolPage = new AdminLceToolPage(WebDriverManager.getDriver());

    @And("I look up with account id on admin tool page")
    public void lookUpWithAccId(){
        adminLceToolPage.lookUpAccId();
    }

    @And("I change effective date to {string} of current year from admin portal")
    public void changeEffDate(String monthDate){
            adminLceToolPage.changeEffectiveDate(monthDate);
    }
}
