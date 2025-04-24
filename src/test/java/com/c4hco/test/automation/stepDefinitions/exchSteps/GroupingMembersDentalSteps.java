package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.GroupingMembersDentalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class GroupingMembersDentalSteps {
    GroupingMembersDentalPage groupingMembersDental = new GroupingMembersDentalPage(WebDriverManager.getDriver());

    @Then("I click on dental edit enrollment groups link")
    public void clickOnEditDentalGroupinglink(){
           groupingMembersDental.clickOnEditDentalGroupinglink();
    }

    @Then("I click continue on grouping Members Dental page")
    public void clickContinue() {groupingMembersDental.clickContinue();}

    @And( "I click Go Back on the Dental Grouping page" )
    public void clickGoBack() {groupingMembersDental.clickGoBack();}

    @Then("I validate that there are {int} default dental groups")
    public void validateDefaultDentalGroups(int defaultGrps){
        groupingMembersDental.validateDefaultDentalGroups(defaultGrps);
    }

    @And("I verify text on Dental grouping page")
    public void medicalGroupingEnglish(){
        groupingMembersDental.verifyDentalGroupingPageVerbiage();
    }

    @And ("I click save and exit from the dental grouping page")
    public void clickSaveExit(){groupingMembersDental.clickSaveAndExit();}


    }


