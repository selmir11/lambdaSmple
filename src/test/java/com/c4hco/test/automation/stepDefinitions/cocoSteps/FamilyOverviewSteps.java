package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.FamilyOverviewPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class FamilyOverviewSteps {
    FamilyOverviewPage familyOverviewPage = new FamilyOverviewPage(WebDriverManager.getDriver());

    @Then("I click Primary EditUpdate on the Family Overview page")
    public void iClickPrimaryEditUpdateLink(){ familyOverviewPage.clickPrimaryEditUpdateLink(); }

    @Then("I validate Total Income equals to annual income")
    public void validateTotalIncomeAmount(){ familyOverviewPage.validateTotalIncomeEqualsAnnualIncome(); }

    @And("I select continue on the Family Overview page")
    public void selectContinueFamOverview(){familyOverviewPage.clickContinueButton();}

    @Then("I click Manage who helps you on the Family Overview page")
    public void clickManageWhoHelpsYouFamilyOverview(){ familyOverviewPage.clickManageWhoHelpsYouButton(); }

    @Then("I verify button text Manage who helps you in {string}")
    public void verifyButtonTextManageWhoHelpsYou(String language) { familyOverviewPage.verifyTextManageWhoHelpsYouButton(language); }










}
