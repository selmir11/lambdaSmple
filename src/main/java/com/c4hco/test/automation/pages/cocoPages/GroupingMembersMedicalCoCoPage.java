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

    @FindBy(id = "SOL-ViewGroupingMembers-Continue")
    WebElement continueButton;

    @FindBy(css = "#SOL-ViewGroupingMembers-MedicalGroup")
    List<WebElement> noOfGroups;

    @FindBy(css = "#SOL-ViewGroupingMembers-EditMyEnrollmentGroups")
    WebElement editMyEnrollmentGroupsButton;

    @FindBy(id="SOL-MedicalGroupingMembers-SaveAndExit")
    WebElement saveAndExitBtn;

    @FindBy(id="SOL-MedicalGroupingMembers-GoBack")
    WebElement goBackBtn;

    @FindBy(css=".container .header-1")
    WebElement header;

    @FindBy(css=".col-9.body-text-1")
    WebElement bodyText;

    @FindBy(css=".imp-message.body-text-1")
    WebElement helpText;

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
        basicActions.waitForElementToDisappear( spinner,25 );
        basicActions.waitForElementToBePresent(continueButton, 20);
        basicActions.waitForElementToBeClickable(continueButton, 30);
        continueButton.click();
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
        basicActions.waitForElementToDisappear( spinner,50 );
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
        softAssert.assertEquals(header.getText(), "Medical Enrollment Groups","header mismatch");
        softAssert.assertEquals(bodyText.getText(), "It may be cheaper to separate your household into groups and enroll in different plans. We suggest the following groups, but you can use what works best for you.", "bodyText did not match");
        softAssert.assertEquals(helpText.getText(), "Remember: Costs within a group count towards each group\u2019s deductible and out of pocket maximum.", "Help text did not match");
        softAssert.assertEquals(editMyEnrollmentGroupsButton.getText(), "Edit my enrollment groups", "Edit Enrollment link text did not match");
        softAssert.assertEquals(medicalGroupTitle.get(0).getText(), "Medical Group # 1","medical group title mismatch");
        softAssert.assertAll();
    }
}
