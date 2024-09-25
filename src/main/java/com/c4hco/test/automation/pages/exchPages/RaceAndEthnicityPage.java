package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RaceAndEthnicityPage {
    private BasicActions basicActions;

    public RaceAndEthnicityPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()),this);
    }

    @FindBy(css = "button[role='checkbox'].checkbox-mark")
    List<WebElement> raceEthnicityButton;

    @FindBy(css = "lib-navigations-buttons.btn-primary-action-button")
    WebElement saveAndContinueButton;

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

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        saveAndContinueButton.click();
    }
}
