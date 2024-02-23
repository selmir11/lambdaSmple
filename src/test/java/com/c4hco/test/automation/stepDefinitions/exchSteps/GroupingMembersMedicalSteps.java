package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.GroupingMembersMedicalPage;
import io.cucumber.java.en.*;
public class GroupingMembersMedicalSteps {
    GroupingMembersMedicalPage groupingMembersMedical = new GroupingMembersMedicalPage();

    @And("I verify text on Medical grouping page")
    public void medicalGroupingEnglish(){
        groupingMembersMedical.verifyMedicalGroupingPage();;
        //groupingMembersMedical.clickContinue();
    }
    @Then("I click on edit enrollment groups link")
    public void clickOnEditEnrollmentgroupsLink(){
        groupingMembersMedical.clickOnEditMedicalGroupinglink();
    }
    @Then("I click on go back button on grouping members page")
    public void clickGoBackButton(){
        groupingMembersMedical.clickGoBackButtonOnGroupingMembersMedicalPage();
    }

}
