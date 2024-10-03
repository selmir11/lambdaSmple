package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EthnicityAndRacePage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public EthnicityAndRacePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "[id='ethnicity-show-options-container']  button")
    List<WebElement> ethnicityButton;

    @FindBy(xpath = "//*[contains(@id, 'ELIG-Race-')]")
    List<WebElement> raceButton;

    @FindBy(css = ".header-1")
    WebElement hdrEthnicityAndRace;

    @FindBy(css = "p.error-text")
    List<WebElement> errorMessages;

    @FindBy(css = ".svg-inline--fa.fa-exclamation-circle")
    List<WebElement> exclamationMarkIcon;

    @FindBy(id = "ELIG-RaceEthnicity-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    // NEW ELMO page
    @FindBy(css = "button[role='checkbox'].checkbox-mark")
    List<WebElement> raceEthnicityButton;

    @FindBy(css = "lib-navigations-buttons.btn-primary-action-button")
    WebElement saveAndContinue_Button;

    @FindBy(css = "Lib-navigations-buttons.btn-second-action-button")
    WebElement goBackButton;

    @FindBy(css = ".c4-type-header-lg.race_ethnicity_title")
    WebElement hdrRaceAndEthnicity;

    @FindBy(css = ".c4-type-body-md-bold.race_ethnicity_content")
    WebElement subHdrRaceAndEthnicity;

    @FindBy(css = ".input-error-message.select-all-text")
    WebElement selectAllThatApplyText;

    @FindBy(css = ".checkbox-label")
    List<WebElement> RaceAndEthnicityTypesText;

    @FindBy(css = ".subheading-labels")
    List<WebElement> RaceAndEthnicityExamplesText;

    @FindBy(css = "input#notListedReason")
    WebElement notListedReason;



    public void clickGoBackButton() {
        basicActions.waitForElementToBeClickable(goBackButton, 30);
        goBackButton.click();
    }


    public void verifyTextOnEthnicityAndRace(String language) {
        basicActions.waitForElementToBePresent(saveAndContinueButton, 10);
        switch (language) {
            case "English":
                verifyTextOnEthnicityAndRaceEnglish();
                break;
            //case "Spanish":
            //    verifyTextOnEthnicityAndRaceSpanish();
            //    break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void verifyErrorMessagesEthnicityAndRace(String language) {
        basicActions.waitForElementListToBePresent(errorMessages, 10);
        switch (language) {
            case "English":
                verifyErrorMessagesEthnicityAndRaceEnglish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateTheSelectionOfOptions(String Section) {
        basicActions.waitForElementToBePresent(hdrEthnicityAndRace, 10);
        switch (Section) {
            case "Ethnicity":
                validateTheSelectionOfOptionsEthnicity();
                break;
            case "Race":
                validateTheSelectionOfOptionsRace();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + Section);
        }
    }

    public void verifyTextOnEthnicityAndRaceEnglish() {
            softAssert.assertEquals(hdrRaceAndEthnicity.getText(), "Race and Ethnicity: " +
                    Character.toUpperCase(SharedData.getPrimaryMember().getFirstName().charAt(0)) + SharedData.getPrimaryMember().getFirstName().substring(1) + " " +
                    Character.toUpperCase(SharedData.getPrimaryMember().getLastName().charAt(0)) + SharedData.getPrimaryMember().getLastName().substring(1));
            softAssert.assertEquals(hdrRaceAndEthnicity.getCssValue("font-size"), "36px");
            softAssert.assertEquals(hdrRaceAndEthnicity.getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(subHdrRaceAndEthnicity.getText(), "Selecting this person's race and ethnicity helps us improve service to all Coloradans. We use this information to make sure everyone gets fair access to coverage. Providing this information will not impact eligibility, plan options, or costs.");
            softAssert.assertEquals(subHdrRaceAndEthnicity.getCssValue("font-size"), "16px");
            softAssert.assertEquals(subHdrRaceAndEthnicity.getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(selectAllThatApplyText.getText(), "Select all that apply");
            softAssert.assertEquals(selectAllThatApplyText.getCssValue("font-size"), "14px");
            softAssert.assertEquals(selectAllThatApplyText.getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(0).getText(), "Asian or Asian American");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(0).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(1).getText(), "Black or African American");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(1).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(2).getText(), "Hispanic or Latino");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(2).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(3).getText(), "Indigenous or Native American");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(3).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(4).getText(), "Middle Eastern or North African");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(4).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(5).getText(), "Native Hawaiian or Pacific Islander");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(5).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(6).getText(), "White or European");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(6).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(7).getText(), "Not listed");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(7).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(8).getText(), "Prefer not to answer");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(8).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(8).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(notListedReason.getAttribute("placeholder"), "Your race and ethnicity");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(0).getText(), "Examples: Chinese, Filipino, Japanese, Korean, South Asian, Vietnamese, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(0).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(1).getText(), "Examples: Ethiopian, Haitian, Nigerian, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(1).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(2).getText(), "Examples: Colombian, Cuban, Mexican, Puerto Rican, Salvadoran, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(2).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(3).getText(), "Examples: Alaskan Natives, Blackfeet Tribe, Inupiat Traditional Government, Navajo Nation, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(3).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(4).getText(), "Examples: Egyptian, Iranian, Israeli, Lebanese, Moroccan, Palestinian, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(4).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(5).getText(), "Examples: Chamorro, Guamanian, Samoan, Tongan, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(5).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(6).getText(), "Examples: English, French, German, Irish, Italian, Polish, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(6).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(7).getText(), "Please fill in the blank with your race and ethnicity");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(7).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(goBackButton.getText(), "< Go back");
            softAssert.assertEquals(saveAndContinue_Button.getText(), "Save and continue");
            softAssert.assertAll();
        }

    public void verifyErrorMessagesEthnicityAndRaceEnglish() {
        softAssert.assertEquals(errorMessages.get(0).getText(), "Ethnicity is required");
        softAssert.assertTrue(exclamationMarkIcon.get(0).isDisplayed());
        softAssert.assertEquals(errorMessages.get(1).getText(), "Race is required (select all that apply)");
        softAssert.assertTrue(exclamationMarkIcon.get(1).isDisplayed());
        softAssert.assertAll();
    }

    public void validateTheSelectionOfOptionsEthnicity() {
        for (int i = 0; i < 3; i++) {
            ethnicityButton.get(i).click();
        }

        //Only 1 ethnicity option can be selected at a time
        int selectedCount = 0;
        for (WebElement button : ethnicityButton) {
            if (button.getAttribute("class").contains("race-ethnicity-check-box-selected")) {
                selectedCount++;
            }
        }

        //Verify that only one option is selected
        if (selectedCount != 1) {
            throw new AssertionError("Expected only one ethnicity option to be selected, but found " + selectedCount);
        }
    }

    public void validateTheSelectionOfOptionsRace() {
        for (int i = 0; i < 6; i++) {
            raceButton.get(i).click();
        }

        //For race options, more than 1 option can be selected (up to 6), but only if the 'I prefer not to answer' option is not selected
        //If 'I prefer not to answer' is selected, then all other race options will be unselected
        for (int i = 0; i < 6; i++) {
            if (!raceButton.get(i).getAttribute("class").contains("race-ethnicity-check-box-selected")) {
                throw new AssertionError("Race option " + (i + 1) + " is not selected.");
            }
        }

        raceButton.get(6).click();

        if (!raceButton.get(6).getAttribute("class").contains("race-ethnicity-check-box-selected")) {
            throw new AssertionError("Race option 7 is not selected.");
        }

            for (int i = 0; i < 6; i++) {
                if (raceButton.get(i).getAttribute("class").contains("race-ethnicity-check-box-selected")) {
                    throw new AssertionError("Race option " + (i + 1) + " is selected, but it shouldn't be.");
                }
            }
        }

        // NEW ELMO page
    public void raceEthnicitySelection(String raceEthnicity){
        basicActions.waitForElementListToBePresent(raceEthnicityButton, 40);
        switch (raceEthnicity) {
            case "Asian or Asian American":
                raceEthnicityButton.get(0).click();
                break;
            case "Black or African American":
                raceEthnicityButton.get(1).click();
                break;
            case "Hispanic or Latino":
                raceEthnicityButton.get(2).click();
                break;
            case "Indigenous or Native American":
                raceEthnicityButton.get(3).click();
                break;
            case "Middle Eastern or North African":
                raceEthnicityButton.get(4).click();
                break;
            case "Native Hawaiian or Pacific Islander":
                raceEthnicityButton.get(5).click();
                break;
            case "White or European":
                raceEthnicityButton.get(6).click();
                break;
            case "Not listed":
                raceEthnicityButton.get(7).click();
                break;
            case "Prefer not to answer":
                raceEthnicityButton.get(8).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + raceEthnicity);
        }
    }

    public void clickSaveAndContinue() {
        basicActions.waitForElementToBeClickable(saveAndContinue_Button, 30);
        saveAndContinue_Button.click();
    }
    }