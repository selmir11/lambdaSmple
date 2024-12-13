package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.EthnicityAndRacePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EthnicityAndRacePageSteps {

    EthnicityAndRacePage ethnicityAndRacePage = new EthnicityAndRacePage(WebDriverManager.getDriver());

    @And("I click Go Back on the Race and Ethnicity page")
    public void clickGoBack(){ethnicityAndRacePage.clickGoBackButton();}

    @Then("I verify text on the Ethnicity And Race page in {string}")
    public void verifyEthnicityAndRacePageText(String Language)  { ethnicityAndRacePage.verifyTextOnEthnicityAndRace(Language); }

    @Then("I validate the error messages on the Ethnicity and Race page in {string}")
    public void verifyErrorMessagesOnTheEthnicityAndRacePage(String Language) {
        ethnicityAndRacePage.verifyErrorMessagesEthnicityAndRace(Language);
    }

    @And("I click save and continue on the Race and Ethnicity page")
    public void iClickContinue(){ethnicityAndRacePage.clickSaveAndContinue();}

    @Then("I validate the text box input and checkbox selection behavior")
    public void validateTextBoxAndCheckboxSelection() {
        ethnicityAndRacePage.validateTextBoxInputAndCheckboxSelection();
    }

    @And("I select Not listed for race and ethnicity option and enter {string} in the text box")
    public void selectNotListedAndEnterText(String customText) {
        ethnicityAndRacePage.selectNotListedAndEnterCustomText(customText);
    }
    @And("I select {string} for race and ethnicity option for {string}")
    public void iSelectMemberRaceEthnicity(String memberRaceEthnicity, String memPrefix){ethnicityAndRacePage.raceEthnicitySelectionMembers(memberRaceEthnicity, memPrefix);}
}
