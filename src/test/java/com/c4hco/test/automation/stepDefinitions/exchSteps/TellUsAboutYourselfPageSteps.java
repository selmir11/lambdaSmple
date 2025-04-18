package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TellUsAboutYourselfPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

import java.util.List;

public class TellUsAboutYourselfPageSteps {
    TellUsAboutYourselfPage tellUsAboutYourselfPage = new TellUsAboutYourselfPage(WebDriverManager.getDriver());

    @Then("I select {string} as sex option")
    public void userSexQuestion(String Sex) {
        tellUsAboutYourselfPage.userSexQuestion(Sex);
    }
    @Then("I update the demographic changes")
    public void setIncorrectEntities(List<String> incorrectEntities){
        tellUsAboutYourselfPage.iSetIncorrectentities(incorrectEntities);
    }

    @And("I select {string} as pregnancy option")
    public void userPregnancyQuestion(String Pregnant) {
        tellUsAboutYourselfPage.userPregnantQuestion(Pregnant);
    }

    @Then("I select {string} to Are You Applying")
    public void isUserApplyingForInsurance(String YNApplying) {
        tellUsAboutYourselfPage.isUserApplyingForHealthInsurance(YNApplying);
    }

    @Then("I click continue on Tell us about yourself page")
    public void clickContinue() {
        tellUsAboutYourselfPage.saveAndContinue();
    }

    @Then("I update SSN number to new SSN number {string}")
    public void updateSSN(String newSsn) {
        tellUsAboutYourselfPage.iUpdateSSN(newSsn);
    }

    @Then("I update full name of member with prefix {string}")
    public void updateName(String namePrefix) {
        tellUsAboutYourselfPage.updateFullName(namePrefix);
    }

    @Then("I update Full Name to new Name")
    public void iUpdateName() {
        tellUsAboutYourselfPage.updateName();
    }

    @Then("I update DOB to new DOB of {string}")
    public void iUpdateDOB(String newDob) {
        tellUsAboutYourselfPage.updateDOB(newDob);
    }

    @And("I validate SSA Error for SSN {string} on Tell us about yourself page")
    public void iValidateSsaError(String SSN) {tellUsAboutYourselfPage.validateSsaError(SSN);}

    @Then("I click I don't have a Social Security Number box and {string} on Tell us about yourself page")
    public void iClickNoSsnBox(String applied) {tellUsAboutYourselfPage.clickNoSsnBox(applied);}

    @Then("I click Back on Tell us about yourself page")
    public void clickBackButton() {
        tellUsAboutYourselfPage.clickBackButton();
    }

    @And("I validate restrict multiple field edits pop up text on Tell us about yourself page")
    public void iValidateRestrictMultipleField(List<String> validationText) {
        tellUsAboutYourselfPage.validateRestrictMultipleFieldEditsError(validationText);
    }

    @Then("I click {string} close button under restrict multiple field edits pop up on Tell us about yourself page")
    public void iClickCloseRestrictedFieldPopup(String language) {
        tellUsAboutYourselfPage.closeRestrictMultipleFieldEditsErrorPopup(language);
    }

    @Then("I click on please click here link to change primary contact")
    public void iClickPrimaryContactChange() { tellUsAboutYourselfPage.iClickPrimaryContactChangeLink();}
    @Then("I click on please click here link to add new person")
    public void iClickToAddNewPerson() { tellUsAboutYourselfPage.iClickLinkToAddNewPerson();}

    @Then("I select new relationship of members to primary")
    public void iSelectNewRelationship(List<String> relationship) {
        tellUsAboutYourselfPage.selectNewRelationship(relationship);
    }

    @Then ("I select the number of expected babies at {string}")
    public void iSelectNewRelationshipWith(String babiesDue) {
        tellUsAboutYourselfPage.iSelectNumberOfBabies(babiesDue);
    }
    @Then ("I select the expected birth due date at Future Date {string}")
    public void setPregnancyEventDate(String eventDateType) {
        tellUsAboutYourselfPage.setPregnancyEventDate(eventDateType);
    }
}
