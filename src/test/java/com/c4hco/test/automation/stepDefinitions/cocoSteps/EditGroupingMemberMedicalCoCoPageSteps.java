package com.c4hco.test.automation.stepDefinitions.cocoSteps;


import com.c4hco.test.automation.pages.cocoPages.EditGroupingMemberMedicalCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;


public class EditGroupingMemberMedicalCoCoPageSteps {

    EditGroupingMemberMedicalCoCoPage editGroupingMembersMedicalCoCoPage = new EditGroupingMemberMedicalCoCoPage(WebDriverManager.getDriver());

    @Then("I create new group in edit medical grouping coco page and drag members to the new group")
    public void createNewGroupAndAddMembers(List<String> grouping) {
        editGroupingMembersMedicalCoCoPage.createNewGroup(grouping);
    }
    @And("I redifine the relationships based on groups")
    public void reassignRelationships(List<String> relation){
        editGroupingMembersMedicalCoCoPage.relationshipsInGroups(relation);
    }
    @Then("I click save button to save the groups in CoCo Page")
    public void saveGroups(){
        editGroupingMembersMedicalCoCoPage.iClickSaveButton();
    }

    @And("I validated message on success enrollment grouping pop-up in CoCo Page")
    public void groupingSuccessMessage(){editGroupingMembersMedicalCoCoPage.iValidateSuccessMessage();
    }

    @Then("I click on continue button on success pop-up in CoCo Page")
    public void IContinue() {
        editGroupingMembersMedicalCoCoPage.iClickContinueOnSuccessPopup();
    }

}
