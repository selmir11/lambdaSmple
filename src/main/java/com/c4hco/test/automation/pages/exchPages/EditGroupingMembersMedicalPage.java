package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EditGroupingMembersMedicalPage {
    @FindBy(id ="SHP-EditMedicalGroupingMembers-Cancel")
    WebElement cancelButtonOnEditEnrollmentPage;
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

    @FindBy(id = "ngb-tool-0")
    WebElement whatworksbestforyou;

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
     public void iCreateNewGroup(){
        basicActions.waitForElementToBePresent(createNewGroup,10);
        createNewGroup.click();
     }
    public void cancelEditGroupingMembers(){
        basicActions.waitForElementToBePresent(cancelButtonOnEditEnrollmentPage,20);
        basicActions.waitForElementToBeClickable(cancelButtonOnEditEnrollmentPage,10);
        cancelButtonOnEditEnrollmentPage.click();
        basicActions.waitForElementToDisappear(createNewGroupLink,10);
    }

    public void iGetNumberOfGroups(int groups){
       softAssert.assertEquals(noOfmedicalGroups.size(),groups);
       softAssert.assertAll();
    }

    public void dragAndDropMembersCreateGroup() {
        basicActions.waitForElementToBePresent(groupingMemebers.get(3),10);
        basicActions.waitForElementToBePresent(dragAMemberHere.get(1),10 );
          builder.clickAndHold(groupingMemebers.get(3))
                .moveToElement(dragAMemberHere.get(1))
                .release(dragAMemberHere.get(1)).build()
                .perform();
          basicActions.wait(3000);
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

    public void dragAndDropChildrenToSeparateGroup() {
        basicActions.waitForElementToBePresent(groupingMemebers.get(2),10);
        basicActions.waitForElementToBePresent(dragAMemberHere.get(3),10 );
        builder.clickAndHold(groupingMemebers.get(1))
                .moveToElement(dragAMemberHere.get(3))
                .release(dragAMemberHere.get(3)).build()
                .perform();
            basicActions.wait(2000);
            basicActions.waitForElementToBePresent(groupingMemebers.get(1),10);
        basicActions.waitForElementToBePresent(dragAMemberHere.get(3),10 );
        builder.clickAndHold(groupingMemebers.get(1))
                .moveToElement(dragAMemberHere.get(3))
                .release(dragAMemberHere.get(3)).build()
                .perform();
         basicActions.wait(3000);
    }

    public void ValidateTheVerbiagewhatworksbestforyou(){
        case "what works best for you":
            ValidateTheVerbiagewhatworksbestforyou();
            break;
        default:
{
    public void ValidateTheVerbiagewhatworksbestforyou()
        basicActions.waitForElementToBePresent(whatworksbestforyou, 10);
        softAssert.assertEquals(whatworksbestforyou.getText(), "Household members can only be grouped together if they are all immediate family members who live in the same rating area and could be covered by a single insurance plan. Immediate family members include spouses, children under the age of 26, and collateral dependents (non-married, disabled tax dependents of a group member). Frequently, living in the same rating area means that all of the individuals live at the same physical address or within the same zip code. You might not be able to group members of your household if they are not considered immediate family members. For assistance, please call our Service Center at 855-752-6749. ");
    }
}

