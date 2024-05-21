package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.HouseholdPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class HouseHoldPageSteps {
    HouseholdPage houseHoldPage = new HouseholdPage(WebDriverManager.getDriver());

    @Then("I click continue on family overview page")
    public void iClickContinue(){
        houseHoldPage.clickContinue();
    }

    @Then("I click Add Another Family Member")
    public void iClickAddFamilyMember(){houseHoldPage.clickAddMember();}

    @Then("I click edit basic information icon for member {int}")
    public void iclickBasicInformationIcon(int index){
        houseHoldPage.clickBasicInfoMember1Button(index);
    }

    @Then("I verify the family overview table is present")
    public void IVerifyTablePresent(){
        houseHoldPage.iVerifyFamilyOverviewTablePresent();
    }

    @And("I click the edit income {int}")
    public void iClickEditIncomeLink(int Index){
        houseHoldPage.iClickEditIncomeLink(Index);}

    @Then("I click on the Member Row {int}")
    public void iEditPrimaryMember(int Index){
        houseHoldPage.iEditPrimaryMember(Index);
    }

    @And("I click on the table dropdown")
    public void iClickTableItem(){
        houseHoldPage.iClickTableItem();}

}

