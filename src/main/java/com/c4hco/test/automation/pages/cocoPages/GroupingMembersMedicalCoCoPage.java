package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.ScenarioDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class GroupingMembersMedicalCoCoPage {

    private BasicActions basicActions;

    @FindBy(css = "#SOL-ViewGroupingMembers-Continue")
    WebElement continueButton;

    @FindBy(css = "#SOL-ViewGroupingMembers-MedicalGroup")
    List<WebElement> noOfGroups;

    @FindBy(css = "#SOL-ViewGroupingMembers-EditMyEnrollmentGroups")
    WebElement editMyEnrollmentGroupsButton;

    @FindBy(id="SOL-ViewGroupingMembers-SaveAndExit")
    WebElement saveAndExitBtn;

    @FindBy(id="SOL-ViewGroupingMembers-GoBack")
    WebElement goBackBtn;

    @FindBy(id="SOL-ViewGroupingMembers-MedicalEnrollmentTitle")
    WebElement header;

    @FindBy(id = "SOL-ViewGroupingMembers-GroupsMedicalTitle")
    WebElement groupsTitle;

    @FindBy(id="SOL-ViewGroupingMembers-EnrollmentGroups1stParagraph")
    WebElement firstParaTxt;

    @FindBy(id="SOL-ViewGroupingMembers-EnrollmentGroups2ndParagraph")
    WebElement secondParaTxt;

    @FindBy(css=".c4-type-header-sm")
    List<WebElement> medicalGroupTitle;

    @FindBy(css="#loader-icon .fa-spinner")
    WebElement spinner;

    SoftAssert softAssert = new SoftAssert();

    public GroupingMembersMedicalCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickContinue() {
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresent(goBackBtn, 10);
        basicActions.waitForElementToBePresent(saveAndExitBtn, 10);
        basicActions.waitForElementToBePresent(continueButton, 20);
        basicActions.waitForElementToBeClickableWithRetries(continueButton, 30);
        basicActions.click(continueButton);
    }

    public void noOfMedicalGroups(int totalGroups) {
        basicActions.waitForElementListToBePresent(noOfGroups, 10);
        int groupsSize = noOfGroups.size();
        if(SharedData.getScenarioDetails()!=null){
            SharedData.getScenarioDetails().setTotalGroups(groupsSize);
        }
        ScenarioDetails scenarioDetails = new ScenarioDetails();
        scenarioDetails.setTotalGroups(groupsSize);
        SharedData.setScenarioDetails(scenarioDetails);
        softAssert.assertEquals(groupsSize, totalGroups, "There are 2 groups");
        softAssert.assertAll();
        if(!(SharedData.getScenarioDetails() == null)) {
            SharedData.getScenarioDetails().setTotalGroups(groupsSize);
        }
    }

    public void clickOnEditMedicalGroupinglink() {
        basicActions.waitForElementToDisappear( spinner,80 );
        basicActions.waitForElementToBePresent(editMyEnrollmentGroupsButton, 40);
        editMyEnrollmentGroupsButton.click();
    }

    public void clickGoBackBtn(){
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementToBePresent(goBackBtn, 10);
        goBackBtn.click();
    }

    public void clickSaveAndExitBtn(){
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementToBePresent(saveAndExitBtn, 10);
        saveAndExitBtn.click();
    }

    public void validateBtnTxt(String goBackTxt, String saveExitTxt, String continueBtnTxt){
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementToBePresent(goBackBtn, 10);
        basicActions.waitForElementToBePresent(saveAndExitBtn, 10);
        basicActions.waitForElementToBePresent(continueButton, 10);
        softAssert.assertEquals(goBackBtn.getText(), goBackTxt);
        softAssert.assertEquals(saveAndExitBtn.getText(), saveExitTxt);
        softAssert.assertEquals(continueButton.getText(), continueBtnTxt);
        softAssert.assertAll();
    }

    public void validateTextOnPage(){
        basicActions.waitForElementListToBePresent(medicalGroupTitle, 10);
        softAssert.assertEquals(header.getText()+" "+groupsTitle.getText(), "Medical Enrollment Groups","header mismatch");
        softAssert.assertEquals(firstParaTxt.getText(), "Enrollment groups let you choose who enrolls in the same plan together. Remember that costs within a group count towards each group’s deductible and out-of-pocket maximum. In some cases, changing your enrollment groups may make coverage more affordable for your household.", "Text from first paragraph did not match");
        softAssert.assertEquals(secondParaTxt.getText(), "We\u2019ve set up suggested groups based on who is in your family, where they live, and what they\u2019re eligible for, but you can choose to move them into groups of your choice.", "Text from second paragraph did not match");
        softAssert.assertEquals(editMyEnrollmentGroupsButton.getText(), "Edit my suggested groups", "Edit Enrollment link text did not match");
        softAssert.assertEquals(medicalGroupTitle.get(0).getText(), "Medical Group #1","medical group title mismatch");
        softAssert.assertAll();
    }
}
