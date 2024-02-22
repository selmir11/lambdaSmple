package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EthnicityAndRacePage {
    private BasicActions basicActions;

    public EthnicityAndRacePage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(css = "[id='ethnicity-show-options-container']  button")
    List<WebElement> ethnicityButton;

    @FindBy(xpath = "//*[contains(@id, 'ELIG-Race-')]")
    List<WebElement> raceButton;

    @FindBy(id = "ELIG-RaceEthnicity-SaveAndContinue")
    WebElement saveAndContinueButton;

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
        }
    }

}
