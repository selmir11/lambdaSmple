package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.EthnicityAndRacePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EthnicityAndRacePageSteps {
    EthnicityAndRacePage ethnicityAndRacePage = new EthnicityAndRacePage(WebDriverManager.getDriver());

    @And("I select {string} ethnicity option")
    public void iSelectMemberEthnicity(String memberEthnicity){ethnicityAndRacePage.ethnicitySelection(memberEthnicity);}

    @And("I select {string} race option")
    public void iSelectMemberRace(String memberRace){ethnicityAndRacePage.raceSelection(memberRace);}

    @And("I click continue on the Ethnicity and race page")
    public void clickContinue(){ethnicityAndRacePage.clickSaveAndContinueButton();}

    @Then("I verify {string} text on the Ethnicity And Race page")
    public void verifyEthnicityAndRacePageText(String Language)  { ethnicityAndRacePage.verifyTextOnEthnicityAndRace(Language); }
}
