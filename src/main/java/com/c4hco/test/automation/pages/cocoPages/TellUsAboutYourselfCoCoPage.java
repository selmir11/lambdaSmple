package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TellUsAboutYourselfCoCoPage {

    @FindBy (id = "birthDate")
    WebElement memberDOBTbox;

    @FindBy (id = "ELIG-memberDetails-MaleButton")
    WebElement genderMaleButton;

    @FindBy (id = "ELIG-memberDetails-FemaleButton")
    WebElement genderFemaleButton;

    @FindBy (xpath = "//*[contains(@class, 'yes-button')]")
    WebElement yesButton;

    @FindBy (xpath = "//*[contains(@class, 'no-button')]")
    WebElement noButton;

    @FindBy (id = "ELIG-MemberDetails-SaveAndContinue")
    WebElement saveAndContinueButton;




    private BasicActions basicActions;

    public TellUsAboutYourselfCoCoPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void enterMemberDOBTbox(String dateOfBirth) {
        basicActions.waitForElementToBeClickable(memberDOBTbox, 30);
        memberDOBTbox.sendKeys(dateOfBirth);
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

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        saveAndContinueButton.click();
    }

    public void specificMemberDetailsCoCo(String dateOfBirth, String gender, String applying) {
        enterMemberDOBTbox(dateOfBirth);
        genderSelection(gender);
        applyingForCoverage(applying);
        clickSaveAndContinueButton();
    }

    public void genderSelection(String gender) {
        switch (gender) {
            case "Male":
                clickGenderMaleButton();
                break;
            case "Female":
                clickGenderFemaleButton();
                break;
        }
    }

    public void applyingForCoverage(String applying) {
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
