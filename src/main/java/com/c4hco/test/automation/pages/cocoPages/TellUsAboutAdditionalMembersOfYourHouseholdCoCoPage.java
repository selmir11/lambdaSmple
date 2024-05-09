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
import org.testng.asserts.SoftAssert;

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

    @FindBy(id = "ELIG-MemberDetails-GoBack")
    WebElement GoBackButton;

    @FindBy(id = "ELIG-MemberDetails-SaveAndContinue")
    WebElement SaveandContinueButton;

    SoftAssert softAssert = new SoftAssert();
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

    public void specificAdditionalMemberDetailsCoCo(String DOB, String gender, String Relation, String applying) {

        String frstName = getUniqueString(8);
        String mdlName = getUniqueString(8);
        String lastName = getUniqueString(12);
        basicActions.waitForElementToBePresent(txtFirstName, 30);
        txtFirstName.sendKeys(frstName);
        txtMiddleName.sendKeys(mdlName);
        txtLastName.sendKeys(lastName);

        List<MemberDetails> memberList = SharedData.getMembers();

        if (memberList == null) {
            memberList = new ArrayList<>();
        }

        MemberDetails member = new MemberDetails();
        member.setFirstName(frstName);
        member.setLastName(lastName);
        member.setMiddleName(mdlName);
        member.setDob(DOB);
        member.setSignature(frstName+" "+lastName);
        member.setFullName(frstName+" "+mdlName.charAt(0)+". "+lastName);
        memberList.add(member);

        SharedData.setMembers(memberList);

        enterMemberDOB(DOB);
        genderSelection(gender);
        applyingForCoverage(applying);
        setRelationshipOption(Relation);
        //clickSaveandContinueButton();

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
///////Page Validation-------------------------------------------------------------------------------------
    ///Text validation
    public void verifyTextOnTellUsAboutAdditionalMembersOfYourHouseholdPage(){
        basicActions.waitForElementToBePresent(PageTitle,10);
        softAssert.assertEquals(PageTitle.getText(), "Tell us about additional members of your household");
        specificAdditionalMemberDetailsCoCo("01011982","Male", "Spouse", "Yes");
        softAssert.assertEquals(textValidation.get(0).getText(), "First name");
        softAssert.assertEquals(textValidation.get(1).getText(), "Middle name or initial (optional)");
        softAssert.assertEquals(textValidation.get(2).getText(), "Last name");
        softAssert.assertEquals(textValidation.get(3).getText(), "Suffix optional");
        softAssert.assertEquals(textValidation.get(4).getText(), "Date of birth");
        softAssert.assertEquals(textValidation.get(5).getText(), "Sex");
        softAssert.assertEquals(textValidation.get(6).getText(), SharedData.getMembers().get(0).getFirstName()+" "+SharedData.getMembers().get(0).getLastName()+" is "+Character.toUpperCase(SharedData.getPrimaryMember().getFirstName().charAt(0)) + SharedData.getPrimaryMember().getFirstName().substring(1) + " " +
                Character.toUpperCase(SharedData.getPrimaryMember().getLastName().charAt(0)) + SharedData.getPrimaryMember().getLastName().substring(1)+"'s?");
        softAssert.assertEquals(RelationshipOption.getText(), "Select Option\nSpouse\nParent or Guardian\nChild or Other dependent\nSibling\nStepparent\nStepchild\nPartner\nOther Relative\nUnrelated");
        softAssert.assertEquals(textValidation.get(7).getText(), "Are you applying for health insurance?");
        softAssert.assertEquals(GoBackButton.getText(), " Go Back");
        softAssert.assertEquals(SaveandContinueButton.getText(), "Save and Continue");
        softAssert.assertAll();
    }
}