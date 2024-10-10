package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EditGroupingMembersDentalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class EditGroupingMembersDentalPageSteps {
    EditGroupingMembersDentalPage editGroupingMembersDentalPage = new EditGroupingMembersDentalPage(WebDriverManager.getDriver());

    @Then("I verify dental tool tip on the link- what works best for you")
    public void validateToolTipText() {
        editGroupingMembersDentalPage.validateToolTipText();
    }

    @Then("I create new group in edit dental grouping page and drag members to the new group")
    public void createNewGroupAndAddMembers(List<String> grouping) {
        editGroupingMembersDentalPage.createNewDentalGroups(grouping);
    }

    @And("I click save button to save the dental groups")
    public void saveGroups(){
        editGroupingMembersDentalPage.iClickSaveButton();
    }

    @And("I click on continue button on success pop-up from edit grouping dental page")
    public void IContinue() {
        editGroupingMembersDentalPage.iClickContinueOnSuccessPopup();
    }

    @Then("I validate the text on the edit dental grouping page")
    public void validateTxtOnPage(){
        editGroupingMembersDentalPage.validatePageText();
    }
}
