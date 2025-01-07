package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps.adminPortalSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages.AdminLceToolPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminToolPageSteps {
    AdminLceToolPage adminLceToolPage = new AdminLceToolPage(WebDriverManager.getDriver());

    @And("I look up with account id on admin tool page")
    public void lookUpWithAccId(){
        adminLceToolPage.lookUpAccId();
    }

    @Then("I validate the plan year dropdown options as last 4years")
    public void validatePlanYrDropdown(){
        adminLceToolPage.validatePlanYearOptions();
    }

    @And("I change effective date to {string} of {string} from admin portal")
    public void changeEffDate(String monthDate, String planYear){
            adminLceToolPage.changeEffectiveDate(monthDate, planYear);
    }

    @And("I validate Admin Lce container title text")
    public void iValidatePageTitle() {
        adminLceToolPage.verifyAdminLceContainerTitle();      }

    @Then("I logout from Admin Portal LCE")
    public void iLogoutAdminPortal() {
        adminLceToolPage.logoutFromAdminLce();
    }
    @And("I initiate incoming page")
    public void iInitiateIncomingPage() {
        adminLceToolPage.initiateIncomingPage();
    }

    // new admin LCE page steps - Expected to release in QA by mid-Feb
    @Then("I navigate to admin lce url")
    public void iNavigateToAdminLceUrl() {
        adminLceToolPage.navigatetoLCE();
    }

    @Then("I verify Title for admin LCE page")
    public void iVerifyTitleForAdminLCEPage() {
      adminLceToolPage.verifyAdminLceTitle();
    }

    @Then("I enter an account ID in {string} {string} accountID field")
    public void iEnterAnAccountIDInAccountIDField(String accountIdSTG, String accountIdQA) {
        adminLceToolPage.enterAccountIdToAnyENV(accountIdSTG,accountIdQA);
    }

    @Then("I click on Look up button")
    public void iClickOnLookUpButton() {
        adminLceToolPage.clickLookUpButton();
    }

    @Then("I click on verify select plan year to edit message is displaying on admin lce page")
    public void iClickOnVerifySelectPlanYearToEditMessageIsDisplayingOnAdminLcePage() {
        adminLceToolPage.validateSelectPlanYearMessage();
    }

    @Then("I verify current year and previous three financial years are displaying in applictaion data")
    public void iVerifyCurrentYearAndPreviousFinancialYearsAreDisplayingInApplictaionData() {
        adminLceToolPage.verifyapplicationyearsData();
    }

    @Then("I click on application data dropdown arrow")
    public void iClickOnApplicationDataDropdownArrow() {
       adminLceToolPage.clickAppDataDropdown();
    }

    @Then("I verify no application data message is displayed")
    public void iVerifyNoApplicationDataMessageIsDisplayed(List<WebElement> appDatatext, String expectedMessage) {
        adminLceToolPage.validateMessageFound(appDatatext,expectedMessage);
    }
}
