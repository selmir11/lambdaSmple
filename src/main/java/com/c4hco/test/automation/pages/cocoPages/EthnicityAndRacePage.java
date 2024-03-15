package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Dto.SharedData;
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

    @FindBy(id = "ELIG-RaceEthnicity-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "ELIG-RaceEthnicity-GoBack")
    WebElement goBackButton;


    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        saveAndContinueButton.click();
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

    public void verifyTextOnEthnicityAndRaceEnglish(){
        softAssert.assertEquals(hdrEthnicityAndRace.getText(), "Ethnicity and Race: " +
                Character.toUpperCase(SharedData.getSubscriber().getFirstName().charAt(0)) + SharedData.getSubscriber().getFirstName().substring(1) + " " +
                Character.toUpperCase(SharedData.getSubscriber().getLastName().charAt(0)) + SharedData.getSubscriber().getLastName().substring(1));
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
        softAssert.assertEquals(saveAndContinueButton.getText(), "Save and Continue");
        softAssert.assertAll();
    }

}
