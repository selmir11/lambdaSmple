package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EditGroupingMembersDentalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class EditGroupingMembersDentalPageSteps {
    EditGroupingMembersDentalPage editGroupingMembersDentalPage = new EditGroupingMembersDentalPage(WebDriverManager.getDriver());




    @Then("I verify dental tool tip on the link- what works best for you")
    public void validateToolTipText() {
        editGroupingMembersDentalPage.validateToolTipText();
    }
}
