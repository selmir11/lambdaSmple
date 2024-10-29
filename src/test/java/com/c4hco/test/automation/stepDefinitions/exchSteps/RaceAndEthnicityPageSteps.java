package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.RaceAndEthnicityPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class RaceAndEthnicityPageSteps {

    RaceAndEthnicityPage RaceAndEthnicityPage = new RaceAndEthnicityPage(WebDriverManager.getDriver());

    @And("I select {string} for race and ethnicity for {string}")
    public void selectRaceEthnicity(String memberRaceEthnicity, String memPrefix){RaceAndEthnicityPage.raceEthnicitySelection(memberRaceEthnicity, memPrefix);}

    @And("I click continue on the Race and Ethnicity page")
    public void clickContinue(){RaceAndEthnicityPage.clickSaveAndContinueButton();}

    @And("I click Go back on the Race and Ethnicity page")
    public void clickGoBackButton(){RaceAndEthnicityPage.clickGoBackButton();}

    @Then("I verify text on the Race and Ethnicity page in {string}")
    public void verifyRaceEthnicityPageText(String language)  { RaceAndEthnicityPage.verifyTextOnRaceAndEthnicityPage(language); }

    @Then("I validate the error messages on the Race and Ethnicity in {string}")
    public void verifyErrorMessagesOnTheRaceAndEthnicity(String Language) {
        RaceAndEthnicityPage.verifyErrorMessagesRaceAndEthnicity(Language);
    }

    @Then("I validate the text box input and checkbox selection")
    public void validateTextBoxAndCheckboxSelection() {
        RaceAndEthnicityPage.validateTextBoxInputAndCheckboxSelection();
    }

    @And("I select Not listed for race and ethnicity and enter {string} in the text box")
    public void selectNotListedAndEnterText(String customText) {
        RaceAndEthnicityPage.selectNotListedAndEnterText(customText);
    }
  }
