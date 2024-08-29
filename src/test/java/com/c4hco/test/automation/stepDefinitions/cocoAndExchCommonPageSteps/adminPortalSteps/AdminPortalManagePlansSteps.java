package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ManagePlans.AdminPortalManagePlansPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdminPortalManagePlansSteps {

    AdminPortalManagePlansPage adminPortalManagePlansPage = new AdminPortalManagePlansPage(WebDriverManager.getDriver());


    @Then("I validate blue bar on Manage page")
    public void iValidateBluBar() {
        adminPortalManagePlansPage.validateBluBar();
    }

    @And("I validate title and labels on Manage page")
    public void iContainerTitleLabels() {
        adminPortalManagePlansPage.containerTitleLabels();      }

    @Then("I check default year displays")
    public void iCheckDefaultCurrentYear() {
        adminPortalManagePlansPage.checkDefaultCurrentYear();
    }

    @Then("I verify both buttons Medical and Dental is checked")
    public void iVerifyButtonsCheckedBoth() {
        adminPortalManagePlansPage.verifyButtonsCheckedBoth();
    }

    @And("I validate buttons displayed on Manage page")
    public void iResetMakeChangeButtonsDisplayed() {
        adminPortalManagePlansPage.resetMakeChangeButtonsDisplayed();
    }
    @And("I validate {string} medical button displays on Manage page")
    public void iVerifySaveButtonDisplayed(String saveMed) {
        adminPortalManagePlansPage.verifySaveButtonDisplayed(saveMed);
    }

    @Then("I click Make Changes Medical button")
    public void iClickMakeChangesMedical() {
        adminPortalManagePlansPage.clickMakeChangesMedical();
    }
    @And("I click Reset Changes Medical")
    public void iClickResetChangesMedical() {
        adminPortalManagePlansPage.clickResetChangesMedical();      }
    @Then("I click Make Changes Dental button")
    public void iClickMakeChangesDental() {
        adminPortalManagePlansPage.clickMakeChangesDental();
    }
    @And("I validate {string} dental button displays on Manage page")
    public void iVerifySaveDentalButtonDisplayed(String save) {
        adminPortalManagePlansPage.verifySaveDentalButtonDisplayed(save);
    }
    @And("I click Reset Changes Dental")
    public void iClickResetChangesDental() {
        adminPortalManagePlansPage.clickResetChangesDental();      }
    @Then("I click Manage Plans button")
    public void iClickManagePlans() {
        adminPortalManagePlansPage.clickManagePlans();      }
    @Then("I validate medical and dental buttons does not display on Manage page")
    public void iValidateChangeButtonsNotDisplay() {
        adminPortalManagePlansPage.validateChangeButtonsNotDisplay();       }
    @And("I verify Medical button checked")
    public void iVerifyMedicalButtonChecked() {
        adminPortalManagePlansPage.verifyMedicalButtonChecked();        }
    @And("I validate buttons displayed on CoCo Manage page")
    public void iResetMakeChangeButtonsCocoDisplayed() {
        adminPortalManagePlansPage.resetMakeChangeButtonsCocoDisplayed();       }
    @And("I validate title and labels on Manage page Coco account")
    public void iContainerTitleLabelsCoco() {
        adminPortalManagePlansPage.containerTitleLabelsCoco();
    }

}

