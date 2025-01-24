package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.AssistnetPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AssistnetPortalPages.AssistnetDashboardPage;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ChatWidgetPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AssistnetDashboardSteps {
    AssistnetDashboardPage assistnetDashboardPage = new AssistnetDashboardPage(WebDriverManager.getDriver());
    @And("I click on view My Clients button")
    public void iClickOnViewMyClientsButton() {
        assistnetDashboardPage.ClickOnViewMyClients();
    }

    @Then("I verify that Print button is visible and enable in Assistent portal")
    public void iVerifyThatPrintButtonIsVisibleAndEnableInAssistentPortal() {
        assistnetDashboardPage.verifyPrintButtonInAP();
    }

    @And("I click on username dropdown")
    public void iClickOnUsernameDropdown() {
        assistnetDashboardPage.ClickOnUsernameDropdown();
    }

    @Then("I click sign out from the assistnet Dashboard")
    public void iClickSignOutFromTheAssistnetDashboard() {
        assistnetDashboardPage.ClickSignOutFromTheAP();
    }

    @And("I click Edit button on assistnet dashboard Page")
    public void iClickEditButtonOnAssistnetDashboardPage() {
        assistnetDashboardPage.ClickEditButtonOnAssistnetDashboardPage();
    }

    @Then("I Verify Username is not Editable")
    public void iVerifyUsernameIsNotEditable() {
        assistnetDashboardPage.verifyUsernameIsNotEditable();
    }

    @And("I edit basic details information {string} {string}")
    public void iEditBasicDetailsInformation(String username, String email) {
        assistnetDashboardPage.editBasicDetails(username,email);
    }

    @Then("I verify the first Name {string} AP")
    public void iVerifyTheFirstNameAP(String firstnameText) {
        assistnetDashboardPage.verifyTheFirstNameAP(firstnameText);
    }

    @And("I edit basic details and Click Save {string}")
    public void iEditBasicDetailsAndClickSave(String email) {
        assistnetDashboardPage.editBasicDetailsAndClickSave(email);
    }


    @Then("I click cancel button in AP dashboard")
    public void iClickCancelButtonInAPDashboard() {
        assistnetDashboardPage.clickCancelBtnInAP();
    }

    @Then("I click save button in AP dashboard")
    public void iClickSaveButtonInAPDashboard() {
        assistnetDashboardPage.clickSaveBtnInAP();
    }

    @And("I click on Add New Organization button")
    public void iClickAddNewOrganizationButton(){
        assistnetDashboardPage.clickAddNewOrganization();
    }

    @And("I click the edit button for my organization")
    public void iClickEditOrganizationButton(){
        assistnetDashboardPage.clickEditOrganization();
    }

    @And("I validate the updated organization name is listed")
    public void iValidateUpdatedOrgNameListed(){
        assistnetDashboardPage.validateUpdatedOrgNameListed();
    }

    @Then("I validate the email is updated correctly")
    public void iValidateTheEmailIsUpdatedCorrectly() {
        assistnetDashboardPage.validateTheEmailIsUpdatedCorrectly();
    }

    @Then("I click Complete Profile on assistnet dashboard page")
    public void iClickCompleteProfileOnAssistnetDashboardPage() {
        assistnetDashboardPage.clickCompleteProfileOnAssistnetDashboardPage();
    }

    @And("I validate the save and continue is displayed")
    public void iValidateTheSaveAndContinueIsDisplayed() {
        assistnetDashboardPage.validateTheSaveAndContinueIsDisplayed();
    }

    @Then("I click save and continue on my information assistnet Page")
    public void iClickSaveAndContinueOnMyInformationAssistnetPage() {
        assistnetDashboardPage.clickSaveAndContinueOnMyInformationAssistnetPage();
    }

    @And("I click go back to my dashboard button from assistNet Dashboared Page")
    public void iClickGoBackToMyDashboardButtonFromAssistNetDashboaredPage() {
        assistnetDashboardPage.clickGoBackToMyDashboardButtonFromAssistNetDashboaredPage();
    }

    @And("I verify the Program Manager Dashboard welcome text")
    public void iVerifyPMDashboardWelcomeText() {
        assistnetDashboardPage.verifyPMDashboardWelcomeText();
    }

    @Then("I verify the program manager certification status is {string}")
    public void iVerifyPMCertStatus(String certStatus) {
        assistnetDashboardPage.verifyPMCertificationStatus(certStatus);
    }

    @And("I save the program manager's account number")
    public void iSavePmAccount() {
        assistnetDashboardPage.savePmAccount();
    }
}
