package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.QlceConfirmationPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;
import java.util.List;

public class QlceConfirmationPageSteps {

    QlceConfirmationPage qlceConfirmationPage = new QlceConfirmationPage(WebDriverManager.getDriver());

    @Then("I select {string} QLCE on tell us about life changes page")
    public void selectQlceType(String qlceOption){
        qlceConfirmationPage.selectQLCE(qlceOption);
    }

    @Then("I select {string} QLCE on tell us about life changes page for {string}")
    public void selectQLCEforMember(String qlceOption, String selectMember) {
        qlceConfirmationPage.selectQLCEforMember(qlceOption, selectMember);
    }

    // WIP- rewrite this step
    @Then("I select Birth QLCE on tell us about life changes page")
    public void selectQlceTypeforlastmemebr(){
        qlceConfirmationPage.selectBirthLCE();
    }

    @Then("I click on Save and Continue")
    public void saveAndContinue(){
        qlceConfirmationPage.saveAndContinue();
    }

    @And("I validate the verbiage on the Tell us about life changes page")
    public void iValidateTheVerbiageOnTheTellUsAboutLifeChangesPage(List<String> data) {
        qlceConfirmationPage.validateTheVerbiageOnTellUsAboutLifeChangesPage(data);
    }
    @Then("I click on back button on Tell us about life changes page")
    public void iClickBackButton(){
        qlceConfirmationPage.clickBackButton();
    }

    @And("I set pregnancy event date as {string}")
    public void setPregnancyEventDate(String eventDateType) {
        qlceConfirmationPage.setPregnancyEventDate(eventDateType);
    }
    @When("I select birth and check member and {string} as event date on QLCE")
    public void iSelectBirthAndCheckMemberAndAsEventDateOnQLCE(String firstDateOfCurrentMonth) {
        qlceConfirmationPage.selectBirthOptionWithEventDate(firstDateOfCurrentMonth);
    }

    @Then ("I select {string} on elgibility for pregnancy coverage")
    public void iSelectForElgibilityForPregnancyCoverage(String elgibility) {
        qlceConfirmationPage.selectElgibilityPregnancyCoverage(elgibility);
    }

    @Then ("I set pregnancy date {string} on elgibility for pregnancy coverage")
    public void setFutureBirthEventDate(String eventDateType) {
        qlceConfirmationPage.setFutureBirthEventDate(eventDateType);
    }
    @Then("I select this date {string} on elgibility for pregnancy coverage for {string}")
    public void iSelectForElgibilityForPregnancyCoverageFor(String elgibility, String selectMember) {
        qlceConfirmationPage.selectElgibilityPregnancyCoverageForMember(elgibility, selectMember);
    }
}
