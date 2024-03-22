package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EditGroupingMembersDentalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EditGroupingMembersDentalPageSteps {
    EditGroupingMembersDentalPage editGroupingMembersDentalPage = new EditGroupingMembersDentalPage(WebDriverManager.getDriver());

    @And("I click Cancel button on Edit Grouping Members Dental page")
    public void editGroupingDentalPage(){
        editGroupingMembersDentalPage.cancelEditGroupingMembers();
    }
    @And("I validate there is create new dental group link")
    public void presenceOfCreateNewGroup(){
        editGroupingMembersDentalPage.ivalidateImOnEditGroupingDentalPage();
    }
    @And("I count {int} Dental groups on this page")
    public void numberOfGroups(int groups){
        editGroupingMembersDentalPage.iGetNumberOfGroups(groups);
    }
    @Then("I drag and drop a member to make new dental group")
    public void dragMemberToDiffGroup() throws InterruptedException {
        editGroupingMembersDentalPage.dragAndDropMembersCreateGroup();
    }
    @Then("I click save button to save the dental groups")
    public void saveGroups(){
        editGroupingMembersDentalPage.iClickSaveButton();
    }
    @Then("I get error dental message as groups are invalid")
    public void errorMessage(){
        editGroupingMembersDentalPage.errorMessageOnGrouping();
    }
    @Then("I click on create new group button on dental edit enrollment groups page")
    public void clickCreateNewGroup(){
        editGroupingMembersDentalPage.iCreateNewGroup();
    }

    @Then("I drag and drop both the children into the third dental group")
    public void groupChildrenTogether()  {
        editGroupingMembersDentalPage.dragAndDropChildrenToSeparateGroup();
    }
    @And("I validated message on success enrollment dental grouping pop-up")
    public void groupingSuccessMessage(){
        editGroupingMembersDentalPage.iValidateSuccessMessage();
    }
    @Then("I click on continue button on dental success pop-up")
    public void IContinue() {
        editGroupingMembersDentalPage.iClickContinueOnSuccessPopup();
    }
    @Then("I verify dental tool tip on the link- what works best for you")
    public void validateToolTipText() {
        editGroupingMembersDentalPage.validateToolTipText();
    }
}
