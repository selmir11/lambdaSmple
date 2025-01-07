package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LugyPage;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LugySteps {

    LugyPage lugyPage = new LugyPage(WebDriverManager.getDriver());

    @Then("I select Tell us about your household {string} option in Let us guide you Page")
    public void iSelectTellUsAboutYourHouseholdOptionInLetUsGuideYouPage(String LugyOptions) {
        lugyPage.selectTellUsAboutYourHouseholdOptionInLetUsGuideYouPage(LugyOptions);
    }

    @Then("I select continue on Let us guide you Page")
    public void iSelectContinueOnLetUsGuideYouPage() {
        lugyPage.selectContinueOnLetUsGuideYouPage();
    }

    @And("I select the number of {string} people are in your household")
    public void iSelectTheNumberOfPeopleAreInYourHousehold(String houseHoldNr) {
        lugyPage.selectTheNumberOfPeopleAreInYourHousehold(houseHoldNr);
    }

    @Then("I select {string} is anyone in your household age 19 or under")
    public void iSelectIsAnyoneInYourHouseholdAgeOrUnder(String option) {
        lugyPage.selectIsAnyoneInYourHouseholdAgeOrUnder(option);
    }

    @Then("I select {string} is there pregnant in your household")
    public void iSelectIsTherePregnantInYourHousehold(String option) {
        lugyPage.selectIsTherePregnentInYourHousehold(option);
    }

    @Then("I select {string} income and {string} option in let us guide you page")
    public void iSelectIncomeAndOptionInLetUsGuideYouPage(String amount, String option) {
        lugyPage.selectIncomeAndOptionInLetUsGuideYouPage(amount, option);
    }

    @Then("I click Apply for Financial Help in Let us guide you Page")
    public void iClickApplyForFinancialHelpInLetUsGuideYouPage() {
        lugyPage.clickApplyForFinancialHelpInLetUsGuideYouPage();
    }

    @Then("I validate Apply for Financial Help is displayed in Let us guide you Page")
    public void iValidateApplyForFinancialHelpIsDisplayedInLetUsGuideYouPage() {
        lugyPage.validateApplyForFinancialHelpIsDisplayedInLetUsGuideYouPage();

    }

    @Then("I click Apply for Health First Colorado in Let us guide you Page")
    public void iClickApplyForHealthFirstColoradoInLetUsGuideYouPage() {
        lugyPage.clickApplyForHealthFirstColoradoInLetUsGuideYouPage();
    }
}
