package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.FamilyOverviewPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class FamilyOverviewSteps {
    FamilyOverviewPage familyOverviewPage = new FamilyOverviewPage(WebDriverManager.getDriver());

    @Then("I click Primary EditUpdate on the Family Overview page")
    public void iClickPrimaryEditUpdateLink(){ familyOverviewPage.clickPrimaryEditUpdateLink(); }

    @And("I select continue on the Family Overview page")
    public void selectContinueFamOverview(){familyOverviewPage.clickContinueButton();}
















}
