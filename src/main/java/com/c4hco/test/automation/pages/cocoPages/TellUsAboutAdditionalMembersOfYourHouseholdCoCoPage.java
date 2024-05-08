package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.management.relation.Relation;
import java.util.ArrayList;
import java.util.List;

public class TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage {

    @FindBy(css = "div.header-1.content-center.content-margin")
    WebElement PageTitle;

    @FindBy(css = "input#firstName")
    WebElement txtFirstName;

    @FindBy(css = "input#middleName")
    WebElement txtMiddleName;

    @FindBy(css = "input#lastName")
    WebElement txtLastName;

    @FindBy(id = "suffix-text1")
    WebElement Selectsuffix;

    @FindBy(id = "birthDate")
    WebElement MemberDOB;

    @FindBy(css = "app-male-female-option .button")
    List<WebElement> genderButton;

    @FindBy(css = "app-yes-no-option .button")
    List<WebElement> applyButton;

    @FindBy(css = "span.body-text-1")
    List<WebElement> textValidation;

    @FindBy(css = "select.input-select")
    WebElement RelationshipOption;

    @FindBy(id = "ELIG-MemberDetails-SaveAndContinue")
    WebElement SaveandContinueButton;

    private BasicActions basicActions;

    public TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }


    public void enterMemberDOB(String dateOfBirth) {
        basicActions.waitForElementToBeClickable(MemberDOB, 30);
        MemberDOB.sendKeys(dateOfBirth);
    }

    public void clickSaveandContinueButton() {
        basicActions.waitForElementToBeClickable(SaveandContinueButton, 30);
        SaveandContinueButton.click();
    }

    public void setRelationshipOption(String Relation){
        basicActions.waitForElementToBePresent(RelationshipOption, 15);

        Select dropdown = new Select(RelationshipOption);
        dropdown.selectByVisibleText(Relation);
    }

    public static String getUniqueString(int length) {
        return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
    }

    public void specificAdditionalMemberDetailsCoCo(String dateOfBirth, String gender, String Relation, String applying) {

        String frstName = getUniqueString(8);
        String mdlName = getUniqueString(8);
        String lastName = getUniqueString(12);
        basicActions.waitForElementToBePresent(txtFirstName, 30);
        txtFirstName.sendKeys(frstName);
        txtMiddleName.sendKeys(mdlName);
        txtLastName.sendKeys(lastName);
        enterMemberDOB(dateOfBirth);
        genderSelection(gender);
        applyingForCoverage(applying);
        setRelationshipOption(Relation);
        clickSaveandContinueButton();

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
}