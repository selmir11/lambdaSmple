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
    public void clickContinue(){
        groupingMembersMedical.clickContinue();
    }

}
