package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.GroupingMembersDentalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class GroupingMembersDentalSteps {
    GroupingMembersDentalPage groupingMembersDental = new GroupingMembersDentalPage(WebDriverManager.getDriver());



    @Then("I click on dental edit enrollment groups link")
    public void clickOnEditDentalGroupinglink(){
        groupingMembersDental.clickOnEditDentalGroupinglink();
    }

    @Then("I click continue on grouping Members Dental page")
    public void clickContinue(){
        groupingMembersDental.clickContinue();
    }

}
