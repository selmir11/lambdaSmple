package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.GroupingMembersMedicalCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class GroupingMembersMedicalCoCoSteps {

    GroupingMembersMedicalCoCoPage groupingMembersCoCoMedical = new GroupingMembersMedicalCoCoPage(WebDriverManager.getDriver());

    @Then("I click continue on grouping Members Medical coco page")
    public void clickContinue(){
        groupingMembersCoCoMedical.clickContinue();
    }

    @And("I click continue on coco medical grouping page")
    public void iClickContinue() {groupingMembersCoCoMedical.iClickContinue();}

    @Then("I click on edit enrollment groups link in coco page")
    public void clickOnEditEnrollmentgroupsLink(){
        groupingMembersCoCoMedical.clickOnEditMedicalGroupinglink();
    }

    @And("I click Go Back on the Medical Grouping page coco")
    public void clickGoBack(){groupingMembersCoCoMedical.clickGoBackBtn();}

    @And("I click save and exit on Medical Grouping page coco")
    public void clickSaveAndExit(){groupingMembersCoCoMedical.clickSaveAndExitBtn();}

    @Then("I validate the text on {string} {string} and {string} buttons on medical grouping page coco")
    public void validateButtonText(String goBackTxt, String saveExitTxt, String continueBtnTxt){groupingMembersCoCoMedical.validateBtnTxt(goBackTxt, saveExitTxt, continueBtnTxt);}

    @Then("I validate text on the medical grouping page coco")
    public void validateTextOnPage() {groupingMembersCoCoMedical.validateTextOnPage();}

    @Then("I validate that there are {int} default groups in coco page")
    public void verifyNumberOfDefaultGroups(int groups){
        groupingMembersCoCoMedical.noOfMedicalGroups(groups);
    }

}
