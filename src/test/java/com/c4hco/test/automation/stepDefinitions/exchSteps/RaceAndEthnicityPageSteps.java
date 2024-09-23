package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.RaceAndEthnicityPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class RaceAndEthnicityPageSteps {

    RaceAndEthnicityPage RaceAndEthnicityPage = new RaceAndEthnicityPage(WebDriverManager.getDriver());

    @And("I select {string} for race and ethnicity")
    public void iSelectMemberRaceEthnicity(String memberRaceEthnicity){RaceAndEthnicityPage.raceEthnicitySelection(memberRaceEthnicity);}

    @And("I click continue on the Race and Ethnicity page")
    public void clickContinue(){RaceAndEthnicityPage.clickSaveAndContinueButton();}

}
