package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.HouseholdPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class HouseHoldPageSteps {
    HouseholdPage houseHoldPage = new HouseholdPage( WebDriverManager.getDriver() );

    @Then("I click continue on family overview page")
    public void iClickContinue() {
        houseHoldPage.clickContinue();
    }

    @Then("I click Add Another Family Member")
    public void iClickAddFamilyMember() {
        houseHoldPage.clickAddMember();
    }

    @Then("I click edit basic information icon for member {int}")
    public void iclickBasicInformationIcon(int index) {
        houseHoldPage.clickBasicInfoMember1Button( index );
    }

    @Then("I verify the family overview table is present")
    public void IVerifyTablePresent() {
        houseHoldPage.iVerifyFamilyOverviewTablePresent();
    }

    // WIP need to modify step. int we are passing is not being used.
    @And("I click the edit income {int}")
    public void iClickEditIncomeLink(int index) {
        houseHoldPage.iClickEditIncomeLink( index );
    }

    @Then("I click on Member Row {int}")
    public void iEditMember(int index) {houseHoldPage.iEditMember(index); }

    @And("I click on the table dropdown {int}")
    public void iClickTableItem(int index) {
        houseHoldPage.iClickTableItem( index );
    }

    @And("I click on {string} to edit information from household page")
    public void clickMemberToEdit(String memName){
        houseHoldPage.clickMember(memName);
    }

    // This one is used by others - retaining until we can get them moved off to the one above
    @Then("I click on the Member Row {int}")
    public void iEditPrimaryMember(int index) {houseHoldPage.iEditPrimaryMember(index);
    }

    @Then("I click on Remove this Member")
    public void iClickRemoveMember() {houseHoldPage.clickRemoveMember();
    }

    @Then("I click on {string} in the Remove Member frame")
    public void iClickOptionOnRemoveWindow(String option) {houseHoldPage.clickOptionOnRemoveWindow(option);
    }

    @Then("I validate no errors are displayed on family overview page")
    public void iValidateNoErrosDisplayed() {houseHoldPage.verifyNoErrorMessage_Household();
    }
}


