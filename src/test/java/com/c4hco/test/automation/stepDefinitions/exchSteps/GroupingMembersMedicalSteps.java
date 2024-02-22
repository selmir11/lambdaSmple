package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.GroupingMembersMedical;
import io.cucumber.java.en.*;
public class GroupingMembersMedicalSteps {
    GroupingMembersMedical groupingMembersMedical = new GroupingMembersMedical();

    @And("I verify text on Medical grouping page")
    public void medicalGroupingEnglish(){
        groupingMembersMedical.verifyMedicalGroupingPage();;
        //groupingMembersMedical.clickContinue();
    }
    @Then("I Select the global Image dropdown to toggle to Spanish language")
    public void clickGlobalImageDropdown(){
        groupingMembersMedical.selectGlobalImageDropdown();
        groupingMembersMedical.selectSpanishLanguage();
    }
    @And("I verify text in Spanish on grouping page")
    public void medicalGroupingSpanish(){
        groupingMembersMedical.verifySpanishTextMedicalGroupingPage();
    }

    @Then("I click on edit enrollment groups link")
    public void editEnrollmentgroupsInSpanish(){
        groupingMembersMedical.clickOnEditMedicalGroupinglink();
    }
    @Then("I click on go back button on grouping members page")
    public void clickGoBackButton(){
        groupingMembersMedical.clickGoBackButton();
    }
    @Then("I signout on Medical Grouping Page")
    public void signOutGroupingPage(){
        groupingMembersMedical.clickSignOut();
    }
}
