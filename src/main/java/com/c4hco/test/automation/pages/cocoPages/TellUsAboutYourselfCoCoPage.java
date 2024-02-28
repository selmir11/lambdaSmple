package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
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

    @FindBy (id = "ELIG-MemberDetails-GoBack")
    WebElement goBackButton;

    private BasicActions basicActions;

    public TellUsAboutYourselfCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void enterMemberDOBTbox(String dateOfBirth) {
        basicActions.waitForElementToBeClickable(memberDOBTbox, 30);
        memberDOBTbox.sendKeys(dateOfBirth);
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
        basicActions.waitForElementListToBePresent(genderButton, 30);
        switch (gender) {
            case "Male":
                genderButton.get(1).click();
                break;
            case "Female":
                genderButton.get(0).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + gender);
        }
    }

    public void applyingForCoverage(String applying) {
        basicActions.waitForElementListToBePresent(applyButton, 30);
        switch (applying) {
            case "Yes":
                applyButton.get(0).click();
                break;
            case "No":
                applyButton.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + applying);
        }
    }

    public void clickGoBackButton() {
        basicActions.waitForElementToBeClickable(goBackButton, 30);
        goBackButton.click();
    }

}
