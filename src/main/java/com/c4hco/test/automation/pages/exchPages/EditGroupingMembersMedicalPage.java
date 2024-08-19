package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EditGroupingMembersMedicalPage {
    @FindBy(id ="SHP-EditMedicalGroupingMembers-Cancel")
    WebElement cancelButtonOnEditEnrollmentPage;
    @FindBy(id ="SHP-EditMedicalGroupingMembers-CreateANewGroup")
    WebElement createNewGroupLink;

    @FindBy(css = "div.cdk-drag")
    List<WebElement> groupingMemebers;

    @FindBy(xpath = "//div[@class='dragHere']/parent::div")
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
    @FindBy(css = ".m-4")
    List<WebElement> successMessage;
    @FindBy(id="SHP-EditMedicalGroupingMembers-Continue")
    WebElement successContinue;

    @FindBy(css = ".container div:nth-child(2) div span u")
    WebElement whatWorksBestLink;

    @FindBy(css = "ngb-tooltip-window .tooltip-inner")
    WebElement tootlTip;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    Actions builder;

    public EditGroupingMembersMedicalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        builder  = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
        Assert.assertTrue(basicActions.waitForAngular(10), "page did not load in 10 seconds");    }

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
    public void groupParentWith26YearOldChild(){
        basicActions.waitForElementListToBePresent(groupingMemebers,10);
        builder.clickAndHold(groupingMemebers.get(1))
                .moveToElement(dragAMemberHere.get(1))
                .release(dragAMemberHere.get(1)).build().perform();
        basicActions.wait(3000);
    }

    public void iClickresetGroupsButton(){
        basicActions.waitForElementToBePresent(resetgroupsButton,20);
        resetgroupsButton.click();
    }
      public void iClickSaveButton(){
        softAssert.assertTrue(saveButtonOnEditGroupingPage.isEnabled());
        basicActions.waitForElementToBePresent(saveButtonOnEditGroupingPage,20);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveButtonOnEditGroupingPage);
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
     public void iValidateSuccessMessage() {
         basicActions.waitForElementListToBePresent(successMessage,10);
         softAssert.assertEquals(successMessage.get(0).getText(), "Success");
         softAssert.assertEquals(successMessage.get(1).getText(), "Success! Your enrollment groupings are valid and have been successfully saved. Click 'Continue' to go on.");
         softAssert.assertAll();
    }
     public void iClickContinueOnSuccessPopup(){
        basicActions.waitForElementToBePresent(successContinue, 20);
         successContinue.click();
     }

    public void validateToolTipText(){
        String expectedToolTipText = "Household members can only be grouped together if they are all immediate family members who live in the same rating area and could be covered by a single insurance plan. Immediate family members include spouses, children under the age of 26, and collateral dependents (non-married, disabled tax dependents of a group member). Frequently, \"living in the same rating area\" means that all of the individuals live at the same physical address or within the same zip code. You might not be able to group members of your household if they are not considered immediate family members. For assistance, please call our Service Center at 855-752-6749.";
        basicActions.waitForElementToBePresent(whatWorksBestLink, 10);
        softAssert.assertEquals(whatWorksBestLink.getText(), "what works best for you.");
        builder.moveToElement(whatWorksBestLink).perform();
        softAssert.assertEquals(tootlTip.getText(), expectedToolTipText, "Actual Text::"+tootlTip.getText()+"::did not match");
        softAssert.assertAll();
    }

    public void dragAndDropMemberToCreateGroup(String Grouping) {
        switch (Grouping) {
            case "Create Group":
                basicActions.waitForElementToBePresent(groupingMemebers.get(2), 10);
                basicActions.waitForElementToBePresent(dragAMemberHere.get(2), 10);
                builder.clickAndHold(groupingMemebers.get(2))
                        .moveToElement(dragAMemberHere.get(2))
                        .release(dragAMemberHere.get(2)).build()
                        .perform();
                basicActions.wait(3000);
                break;
            case "Unassigned Member":
                basicActions.waitForElementToBePresent(groupingMemebers.get(1), 10);
                basicActions.waitForElementToBePresent(dragAMemberHere.get(0), 10);
                builder.clickAndHold(groupingMemebers.get(1))
                        .moveToElement(dragAMemberHere.get(0))
                        .release(dragAMemberHere.get(0)).build()
                        .perform();
                basicActions.wait(3000);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + Grouping);
        }
    }
    public void ivalidateResetGroupLink(){
        resetgroupsButton.isDisplayed();
        resetgroupsButton.isEnabled();
    }

    public void createNewGroup(List<String> grouping) {
        basicActions.waitForElementToDisappear(spinner, 20);
        for(String group: grouping){
            createNewGroupLink.click();
            basicActions.scrollToElement(createNewGroupLink);
            String[] groupDetail =  group.split(":");
            String[] Names = groupDetail[0].split(",");
            for(String Name: Names){
                WebElement dragElement = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'" + Name + "')]"));
                WebElement dropElement = dragAMemberHere.get(dragAMemberHere.size()-1);
                basicActions.wait(3000);
                basicActions.scrollToElement(dragElement);
                // Scroll the drop element into view
                basicActions.scrollToElement(dropElement);
                // Perform drag and drop using JavaScript
                builder.clickAndHold(dragElement)
                        .moveToElement(dropElement)
                        .release(dropElement).build()
                        .perform();
                basicActions.wait(3000);
            }
        }
    }

}

