package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AuthorizeAssisterOrganizationPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class AuthorizeAssisterOrganizationSteps {
    AuthorizeAssisterOrganizationPage authorizeAssisterOrganizationPage = new AuthorizeAssisterOrganizationPage(WebDriverManager.getDriver());

    @Then("I authorize my assister's site ID {string} or {string}")
    public void iAuthorizeAssisterSiteId(String StgSiteID, String QaSiteID){
        authorizeAssisterOrganizationPage.authorizeAssisterSiteID(StgSiteID, QaSiteID);
    }

    @And ("I validate the authorization success message")
    public void iValidateAuthorizationSuccessText(){
        authorizeAssisterOrganizationPage.validateAuthorizationSuccessText();
    }

    @Then("I click Go Back on the Authorize Assister Organization page")
    public void iClickGoBackAssister(){
        authorizeAssisterOrganizationPage.clickAssisterGoBack();
    }
}
