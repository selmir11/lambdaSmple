package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;
import com.c4hco.test.automation.pages.cocoPages.FamilyOverviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class FamilyOverviewSteps {
    FamilyOverviewPage familyOverviewPage = new FamilyOverviewPage();

    @Then("I click Primary EditUpdate on the Family Overview page")
    public void iClickPrimaryEditUpdateLink(){ familyOverviewPage.clickPrimaryEditUpdateLink(); }


















}
