package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.EditGroupingMembersMedicalPage;
import io.cucumber.java.en.*;
public class EditGroupingMembersMedicalPageSteps {
    EditGroupingMembersMedicalPage editGroupingMembersMedicalPage = new EditGroupingMembersMedicalPage();

    @And("I click Cancel button on Edit Grouping Members Medical page")
    public void editGroupingMedicalPage(){
        editGroupingMembersMedicalPage.cancelEditGroupingMembers();
    }
}
