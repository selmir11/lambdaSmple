package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EditGroupingMembersMedicalPage {
    @FindBy(id ="SHP-EditMedicalGroupingMembers-Cancel")
    WebElement canceButtonOnEditEnrollmentPage;
    @FindBy(id ="SHP-EditMedicalGroupingMembers-CreateANewGroup")
    WebElement createNewGroupLink;

    @FindBy(css = ".cdk-drag")
    List<WebElement> groupingMemebers;

    @FindBy(css ="div.dragHere")
    List<WebElement> dragAMemberHere;
    @FindBy(css = ".row .redTxt")
    WebElement errorText;
    @FindBy(css = ".container .groupHeading")
    List<WebElement> noOfmedicalGroups;
    @FindBy(id="SHP-EditMedicalGroupingMembers-CreateANewGroup")
    WebElement createNewGroup;
    @FindBy(id ="SHP-EditMedicalGroupingMembers-Save")
    WebElement saveButtonOnEditGroupingPage;

    @FindBy(id = "SHP-EditMedicalGroupingMembers-ResetTheGroups")
    WebElement resetgroupsButton;
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    Actions builder;
    public EditGroupingMembersMedicalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        builder  = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
     public void ivalidateImOnEditGroupingMedicalPage(){
         createNewGroup.isDisplayed();
         createNewGroup.isEnabled();
     }
    public void cancelEditGroupingMembers(){
        basicActions.waitForElementToBePresent(canceButtonOnEditEnrollmentPage,20);
        basicActions.waitForElementToBeClickable(canceButtonOnEditEnrollmentPage,10);
        canceButtonOnEditEnrollmentPage.click();
        basicActions.waitForElementToDisappear(createNewGroupLink,10);
    }
    public void iGetNumberOfGroups(int groups){
       softAssert.assertEquals(noOfmedicalGroups.size(),groups);
    }
    public void dragAndDropMembersCreateGroup() throws InterruptedException {
        basicActions.waitForElementToBePresent(groupingMemebers.get(3),10);
        basicActions.waitForElementToBePresent(dragAMemberHere.get(1),10 );
          builder.clickAndHold(groupingMemebers.get(3))
                .moveToElement(dragAMemberHere.get(1))
                .release(dragAMemberHere.get(1)).build()
                .perform();
          Thread.sleep(3000);
    }
    public void iClickresetGroupsButton(){
        resetgroupsButton.isEnabled();
    }
      public void iClickSaveButton(){
        softAssert.assertTrue(saveButtonOnEditGroupingPage.isEnabled());
        basicActions.waitForElementToBePresent(saveButtonOnEditGroupingPage,20);
        basicActions.waitForElementToBeClickable(saveButtonOnEditGroupingPage,20);
        saveButtonOnEditGroupingPage.click();
    }
    public void errorMessageOnGrouping(){
        basicActions.waitForElementToBePresent(errorText,10);
        softAssert.assertEquals(errorText.getText(),"The group(s) highlighted below in red are not valid groupings. Please move around your members to create valid groups.");
        softAssert.assertAll();
    }


}
