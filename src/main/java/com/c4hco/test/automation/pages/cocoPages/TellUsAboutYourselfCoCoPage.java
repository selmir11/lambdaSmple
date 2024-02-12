package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TellUsAboutYourselfCoCoPage {

    @FindBy (id = "birthDate")
    public WebElement memberDOBTbox;

    @FindBy (xpath = "//*[contains(text(),'Male')]")
    WebElement genderMaleButton;

    @FindBy (xpath = "//*[contains(text(),'Female')]")
    WebElement genderFemaleButton;

    @FindBy (xpath = "//*[contains(@class, 'yes-button')]")
    WebElement yesButton;

    @FindBy (xpath = "//*[contains(@class, 'no-button')]")
    WebElement noButton;




    private BasicActions basicActions;

    public TellUsAboutYourselfCoCoPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickGenderMaleButton() {
        basicActions.waitForElementToBeClickable(genderMaleButton, 30);
        genderMaleButton.click();
    }

    public void clickGenderFemaleButton() {
        basicActions.waitForElementToBeClickable(genderFemaleButton, 30);
        genderFemaleButton.click();
    }

    public void clickYesButton() {
        basicActions.waitForElementToBeClickable(yesButton, 30);
        yesButton.click();
    }

    public void clickNoButton() {
        basicActions.waitForElementToBeClickable(noButton, 30);
        noButton.click();
    }

    public void specificMemberDetails(String dateOfBirth, String gender, String applying) {
        memberDOBTbox.sendKeys(dateOfBirth);
        switch (gender) {
            case "Male":
                clickGenderMaleButton();
                break;
            case "Female":
                clickGenderFemaleButton();
                break;
        }
        switch (applying) {
            case "Yes":
                clickYesButton();
                break;
            case "No":
                clickNoButton();
                break;
        }
    }

}
