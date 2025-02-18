package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AuthorizeAssisterOrganizationPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class AuthorizeAssisterOrganizationSteps {
    AuthorizeAssisterOrganizationPage authorizeAssisterOrganizationPage = new AuthorizeAssisterOrganizationPage(WebDriverManager.getDriver());

    @Then("I validate the Authorize Assister Organization page title in {string}")
    public void iValidateAuthAssisterOrgPageTitle(String language){
        authorizeAssisterOrganizationPage.validateAuthAssisterOrgPageTitle(language);
    }

    @And("I validate the Authorize Assister Organization page informational text in {string}")
    public void iValidateAuthAssisterOrgPageInformationalText(String language){
        authorizeAssisterOrganizationPage.validateAuthAssisterOrgPageInformationalText(language);
    }

    @And("I validate the Authorize Assister Site ID field text in {string}")
    public void iValidateAuthAssisterSiteIdFieldText(String language){
        authorizeAssisterOrganizationPage.validateAuthAssisterSiteIdFieldTextText(language);
    }

    @And("I validate the Authorize button is displayed in {string}")
    public void iValidateAuthorizeAssisterButton(String language){
        authorizeAssisterOrganizationPage.validateAuthorizeAssisterButton(language);
    }

    @And("I validate the Authorize Assister Organization page Go Back button is displayed in {string}")
    public void iValidateGoBackButton(String language){
        authorizeAssisterOrganizationPage.validateGoBackButton(language);
    }

    @And("I validate the valid Assister site ID error message text in {string}")
    public void iValidateValidAssisterSiteIdErrorText(String language){
        authorizeAssisterOrganizationPage.validateValidAssisterSiteIdErrorText(language);
    }

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

    @Then("I click on change the existing assister")
    public void iClickOnChangeTheExistingAssister() {
        authorizeAssisterOrganizationPage.clickOnChangeTheExistingAssister();
    }

    @And("I validate the warning text to authorize new or keep the same assister")
    public void iValidateTheWarningTextToAuthorizeNewOrKeepTheSameAssister() {
        authorizeAssisterOrganizationPage.validateTheWarningTextToAuthorizeNewOrKeepTheSameAssister();
    }

    @Then("I click on {string} in the warning container to authorize new or keep the same assister")
    public void iClickOnInTheWarningContainerToAuthorizeNewOrKeepTheSameAssister(String btnType) {
        authorizeAssisterOrganizationPage.clickOnInTheWarningContainerToAuthorizeNewOrKeepTheSameAssister(btnType);
    }
}
