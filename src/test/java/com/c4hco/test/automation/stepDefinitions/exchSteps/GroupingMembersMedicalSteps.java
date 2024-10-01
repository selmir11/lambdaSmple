package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.GroupingMembersMedicalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;
public class GroupingMembersMedicalSteps {
    GroupingMembersMedicalPage groupingMembersMedical = new GroupingMembersMedicalPage(WebDriverManager.getDriver());

    @And("I verify text on Medical grouping page")
    public void medicalGroupingEnglish(){
        groupingMembersMedical.verifyMedicalGroupingPageVerbiage();
    }

    @Then("I click on edit enrollment groups link")
    public void clickOnEditEnrollmentgroupsLink(){
        groupingMembersMedical.clickOnEditMedicalGroupinglink();
    }

    @Then("I click continue on grouping Members Medical page")
    public void clickContinue(){groupingMembersMedical.clickContinue();
    }

    @Then("I validate that there are {int} default groups with different zipcodes")
    public void validateNumberOfGroups(int groups){
    groupingMembersMedical.getUniqueZipCodes(groups);
    }

    @Then("I verify that members are grouped together based on zipcodes")
    public void verifyMembersInGroups(){
        groupingMembersMedical.verifyGroupingMembersWithZipcodes();
    }

    @Then("I validate that there are {int} default groups")
    public void verifyNumberOfDefaultGroups(int groups){
        groupingMembersMedical.noOfMedicalGroups(groups);
    }

    @And ("I click Go Back on the Medical Grouping page")
    public void clickGoBack(){groupingMembersMedical.clickGoBackButton();}


    @And ("I get the details of medical group Members")
    public void setTheGroupDetails(){groupingMembersMedical.setTheGroupDetails();}


}


