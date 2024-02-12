package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TellUsAboutYourselfCoCoPage {

    @FindBy (id = "birthDate")
    WebElement memberDOBTbox;

    @FindBy (css = "app-male-female-option .button")
    List<WebElement> genderButton;

    @FindBy (css = "app-yes-no-option .button")
    List<WebElement> applyButton;

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
        basicActions.waitForElementListToBePresent(genderButton, 30);
        genderButton.get(1).click();
    }

    public void clickGenderFemaleButton() {
        basicActions.waitForElementListToBePresent(genderButton, 30);
        genderButton.get(0).click();
    }

    public void clickYesButton() {
        basicActions.waitForElementListToBePresent(applyButton, 30);
        applyButton.get(0).click();
    }

    public void clickNoButton() {
        basicActions.waitForElementListToBePresent(applyButton, 30);
        applyButton.get(1).click();
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
