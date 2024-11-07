package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.HouseholdPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class HouseHoldPageSteps {
    HouseholdPage houseHoldPage = new HouseholdPage( WebDriverManager.getDriver() );

    @Then("I click continue on family overview page")
    public void iClickContinue() {houseHoldPage.clickContinue();    }

    @Then("I click Add Another Family Member")
    public void iClickAddFamilyMember() {
        houseHoldPage.clickAddMember();
    }

    @Then("I verify the family overview table is present")
    public void IVerifyTablePresent() {houseHoldPage.iVerifyFamilyOverviewTablePresent();}

    @And("I click on {string} to edit information from household page")
    public void clickMemberToEdit(String memName){houseHoldPage.clickMember(memName);}

    @And("I click plus icon next to member on household page for {string}")
    public void iClickTableItem(String namePrefix) {houseHoldPage.iClickTableItem(namePrefix);}

    @And("I click the edit income icon on household page for {string}")
    public void iClickEditIncomeLink(String namePrefix) {houseHoldPage.iClickEditIncomeLink(namePrefix);}

    @Then("I click edit basic information icon on household page for {string}")
    public void iclickBasicInformationIcon(String namePrefix) {houseHoldPage.clickBasicInfoMemberButton(namePrefix);}

    @Then("I click on Remove this Member")
    public void iClickRemoveMember() {houseHoldPage.clickRemoveMember();}

    @Then("I click on {string} in the Remove Member frame")
    public void iClickOptionOnRemoveWindow(String option) {houseHoldPage.clickOptionOnRemoveWindow(option);}

    @Then("I validate no errors are displayed on family overview page")
    public void iValidateNoErrosDisplayed() {houseHoldPage.verifyNoErrorMessage_Household();}
}


