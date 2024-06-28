package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.GroupingMembersMedicalCoCoPage;
import com.c4hco.test.automation.pages.exchPages.GroupingMembersMedicalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class GroupingMembersMedicalCoCoSteps {

    GroupingMembersMedicalCoCoPage groupingMembersCoCoMedical = new GroupingMembersMedicalCoCoPage(WebDriverManager.getDriver());

    @Then("I click continue on grouping Members Medical coco page")
    public void clickContinue(){
        groupingMembersCoCoMedical.clickContinue();
    }

    @Then("I validate that there are {int} default groups in coco page")
    public void verifyNumberOfDefaultGroups(int groups){
        groupingMembersCoCoMedical.noOfMedicalGroups(groups);
    }
}
