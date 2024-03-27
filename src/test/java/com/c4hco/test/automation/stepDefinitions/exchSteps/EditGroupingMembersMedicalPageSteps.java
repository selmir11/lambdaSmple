package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EditGroupingMembersMedicalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EditGroupingMembersMedicalPageSteps {
    EditGroupingMembersMedicalPage editGroupingMembersMedicalPage = new EditGroupingMembersMedicalPage(WebDriverManager.getDriver());

    @And("I click Cancel button on Edit Grouping Members Medical page")
    public void editGroupingMedicalPage(){
        editGroupingMembersMedicalPage.cancelEditGroupingMembers();
    }
    @And("I validate there is create new group link")
    public void presenceOfCreateNewGroup(){
        editGroupingMembersMedicalPage.ivalidateImOnEditGroupingMedicalPage();
    }
    @And("I count {int} medical groups on this page")
    public void numberOfGroups(int groups){
        editGroupingMembersMedicalPage.iGetNumberOfGroups(groups);
    }
    @Then("I drag and drop a member to make new group")
    public void dragMemberToDiffGroup(){
        editGroupingMembersMedicalPage.dragAndDropMembersCreateGroup();
    }
    @Then("I drag and drop a member to group with 26 year old")
    public void groupInvalidParentAnd26Yearold(){
        editGroupingMembersMedicalPage.groupParentWith26YearOldChild();
    }
    @Then("I click save button to save the groups")
    public void saveGroups(){
        editGroupingMembersMedicalPage.iClickSaveButton();
    }
    @Then("I get error message as groups are invalid")
    public void errorMessage(){
        editGroupingMembersMedicalPage.errorMessageOnGrouping();
    }
    @Then("I click on create new group button on edit enrollment groups page")
    public void clickCreateNewGroup(){
        editGroupingMembersMedicalPage.iCreateNewGroup();
    }

    @Then("I drag and drop both the children into the third group")
    public void groupChildrenTogether()  {
        editGroupingMembersMedicalPage.dragAndDropChildrenToSeparateGroup();
    }
    @And("I validated message on success enrollment grouping pop-up")
    public void groupingSuccessMessage(){
        editGroupingMembersMedicalPage.iValidateSuccessMessage();
    }
    @Then("I click on continue button on success pop-up")
    public void IContinue() {
        editGroupingMembersMedicalPage.iClickContinueOnSuccessPopup();
    }
    @Then("I verify tool tip on the link- what works best for you")
    public void validateToolTipText() {
        editGroupingMembersMedicalPage.validateToolTipText();
    }
}
