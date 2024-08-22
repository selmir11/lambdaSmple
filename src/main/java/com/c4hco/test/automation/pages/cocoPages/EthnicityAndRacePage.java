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

    @FindBy(css = ".body-text-1")
    List<WebElement> EthnicityAndRaceText;

    @FindBy(css = ".header-1")
    WebElement hdrEthnicityAndRace;

    @FindBy(css = "p.error-text")
    List<WebElement> errorMessages;

    @FindBy(css = ".svg-inline--fa.fa-exclamation-circle")
    List<WebElement> exclamationMarkIcon;

    @FindBy(id = "ELIG-RaceEthnicity-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "ELIG-RaceEthnicity-GoBack")
    WebElement goBackButton;


    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBePresent(hdrEthnicityAndRace, 90);
        basicActions.waitForElementListToBePresentWithRetries(EthnicityAndRaceText, 90);
        basicActions.waitForElementListToBePresent(raceButton, 90);
        basicActions.waitForElementListToBePresent(ethnicityButton, 90);
        basicActions.waitForElementToBePresent(goBackButton, 90);
        basicActions.waitForElementToBePresentWithRetries(saveAndContinueButton, 90);
        basicActions.scrollToElement(saveAndContinueButton);
        basicActions.scrollToElement(hdrEthnicityAndRace);
        basicActions.scrollToElement(saveAndContinueButton);
        saveAndContinueButton.click();
    }

    public void clickGoBackButton() {
        basicActions.waitForElementToBeClickable(goBackButton, 30);
        goBackButton.click();
    }

    public void ethnicitySelection(String ethnicity){
        basicActions.waitForElementListToBePresent(ethnicityButton, 30);
        switch (ethnicity) {
            case "Hispanic/Latino":
                ethnicityButton.get(0).click();
                break;
            case "Non-Hispanic/Latino":
                ethnicityButton.get(1).click();
                break;
            case "I prefer not to answer":
                ethnicityButton.get(2).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + ethnicity);
        }
    }

    public void raceSelection(String race){
        basicActions.waitForElementListToBePresent(raceButton, 30);
        switch (race) {
            case "American Indian/Alaskan Native":
                raceButton.get(0).click();
                break;
            case "Asian":
                raceButton.get(1).click();
                break;
            case "Black/African American":
                raceButton.get(2).click();
                break;
            case "Native Hawaiian/Other Pacific Islander":
                raceButton.get(3).click();
                break;
            case "White/Caucasian":
                raceButton.get(4).click();
                break;
            case "Not listed":
                raceButton.get(5).click();
                break;
            case "I prefer not to answer":
                raceButton.get(6).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + race);
        }
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
        softAssert.assertEquals(hdrEthnicityAndRace.getText(), "Ethnicity and Race: " +
                Character.toUpperCase(SharedData.getPrimaryMember().getFirstName().charAt(0)) + SharedData.getPrimaryMember().getFirstName().substring(1) + " " +
                Character.toUpperCase(SharedData.getPrimaryMember().getLastName().charAt(0)) + SharedData.getPrimaryMember().getLastName().substring(1));
        softAssert.assertEquals(EthnicityAndRaceText.get(0).getText(), "Hispanic/Latino");
        softAssert.assertEquals(EthnicityAndRaceText.get(1).getText(), "Non-Hispanic/Latino");
        softAssert.assertEquals(EthnicityAndRaceText.get(2).getText(), "I prefer not to answer");
        softAssert.assertEquals(EthnicityAndRaceText.get(3).getText(), "American Indian/Alaskan Native");
        softAssert.assertEquals(EthnicityAndRaceText.get(4).getText(), "Asian");
        softAssert.assertEquals(EthnicityAndRaceText.get(5).getText(), "Black/African American");
        softAssert.assertEquals(EthnicityAndRaceText.get(6).getText(), "Native Hawaiian/Other Pacific Islander");
        softAssert.assertEquals(EthnicityAndRaceText.get(7).getText(), "White/Caucasian");
        softAssert.assertEquals(EthnicityAndRaceText.get(8).getText(), "Not listed");
        softAssert.assertEquals(EthnicityAndRaceText.get(9).getText(), "I prefer not to answer");
        softAssert.assertEquals(goBackButton.getText(), " Go Back");
        softAssert.assertEquals(saveAndContinueButton.getText(), "Save and continue");
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
    }