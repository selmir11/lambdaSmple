package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EditGroupingMembersMedicalPage {

    @FindBy(id = "SOL-ManageGroupingMembers-EditMedicalTitle")
    WebElement pageTitle1;
    @FindBy(id = "SOL-ManageGroupingMembers-EditMedicalGroupsTitle")
    WebElement pageTitle2;
    @FindBy(id = "SOL-ManageGroupingMembers-EditEnrollmentGroups1stParagraph")
    WebElement para1;
    @FindBy(id = "SOL-ManageGroupingMembers-EditEnrollmentGroups2ndParagraph")
    WebElement para2;
    @FindBy(id = "SOL-ManageGroupingMembers-EditEnrollmentGroupedTogetherQuestion")
    WebElement groupingQtn;
    @FindBy(id = "SOL-ManageGroupingMembers-EditEnrollmentGroupedTogether")
    WebElement groupingTxt;
    @FindBy(id = "SOL-ManageGroupingMembers-EditEnrollmentTheyAreAll")
    WebElement theyAreAllText;
    @FindBy(id = "SOL-ManageGroupingMembers-EditEnrollmentImmediateFamily")
    WebElement immFamilyMemTxt;
    @FindBy(id = "SOL-ManageGroupingMembers-EditEnrollmentTheyAll")
    WebElement theyAllText;
    @FindBy(id = "SOL-ManageGroupingMembers-EditEnrollmentPhysicalAddress")
    WebElement physicalAddressTxt;
    @FindBy(id = "SOL-ManageGroupingMembers-EditEnrollmentZipcode")
    WebElement sameZipTxt;
    @FindBy(css = ".cdk-drop-list .c4-type-header-sm")
    List<WebElement> containerTxtList;
    @FindBy(id = "SOL-ManageGroupingMembers-DragAMember")
    List<WebElement> dragAMemberHere;
    @FindBy(id = "SOL-ManageGroupingMembers-DragAMemberNotEnrolling")
    List<WebElement> dragAMemberNotEnrolling;
    @FindBy(id = "SOL-ManageGroupingMembers-ResetTheGroups")
    WebElement resetGroupsButton;
    @FindBy(id = "SOL-EditMedicalGroupingMembers-Cancel")
    WebElement cancelButtonOnEditEnrollmentPage;
    @FindBy(id = "SOL-ManageGroupingMembers-CreateANewGroup")
    WebElement createNewGroupLink;
    @FindBy(css = "div.cdk-drag")
    List<WebElement> groupingMembers;
    @FindBy(id = "SOL-ManageGroupingMembers-SaveGroups")
    WebElement saveButtonOnEditGroupingPage;
    @FindBy(id = "SOL-ManageGroupingMembers-GoBack")
    WebElement goBackButton;


    @FindBy(id = "SOL-ManageGroupingMembers-EditEnrollmentGroupNotValid")
    WebElement errorText;
    @FindBy(css = ".container .groupHeading")
    List<WebElement> noOfmedicalGroups;
    @FindBy(css = ".m-4")
    List<WebElement> successMessage;
    @FindBy(id = "SOL-ManageGroupingMembers-PopUp-Continue")
    WebElement successContinue;
    @FindBy(css = ".container div:nth-child(2) div span u")
    WebElement whatWorksBestLink;
    @FindBy(css = "ngb-tooltip-window .tooltip-inner")
    WebElement tootlTip;

    @FindBy(id = "SOL-ManageGroupingMembers-MemberDetails")
    List<WebElement> manageGroupingMember;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    Actions builder;

    public EditGroupingMembersMedicalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        builder = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void ivalidateImOnEditGroupingMedicalPage() {
        createNewGroupLink.isDisplayed();
        createNewGroupLink.isEnabled();
    }

    public void iCreateNewGroup() {
        basicActions.waitForElementToBePresent(createNewGroupLink, 10);
        createNewGroupLink.click();
    }

    public void cancelEditGroupingMembers() {
        basicActions.waitForElementToBePresent(cancelButtonOnEditEnrollmentPage, 20);
        basicActions.waitForElementToBeClickable(cancelButtonOnEditEnrollmentPage, 10);
        cancelButtonOnEditEnrollmentPage.click();
        basicActions.waitForElementToDisappear(createNewGroupLink, 10);
    }

    public void iGetNumberOfGroups(int groups) {
        softAssert.assertEquals(noOfmedicalGroups.size(), groups);
        softAssert.assertAll();
    }

    public void dragAndDropMembersCreateGroup() {
        basicActions.waitForElementToBePresent(groupingMembers.get(3), 10);
        basicActions.waitForElementToBePresent(dragAMemberHere.get(1), 10);
        builder.clickAndHold(groupingMembers.get(3))
                .moveToElement(dragAMemberHere.get(1))
                .release(dragAMemberHere.get(1)).build()
                .perform();
        basicActions.wait(3000);
    }

    public void groupParentWith26YearOldChild() {
        basicActions.waitForElementListToBePresent(groupingMembers, 10);
        builder.clickAndHold(groupingMembers.get(0))
                .moveToElement(dragAMemberHere.get(1))
                .release(dragAMemberHere.get(1)).build().perform();
        basicActions.wait(3000);
    }

    public void iClickresetGroupsButton() {
        basicActions.waitForElementToBePresent(resetGroupsButton, 20);
        resetGroupsButton.click();
    }

    public void iClickSaveButton() {
        basicActions.waitForElementToDisappear( spinner,50 );
        basicActions.waitForElementToBePresentWithRetries(saveButtonOnEditGroupingPage, 60);
        softAssert.assertTrue(saveButtonOnEditGroupingPage.isEnabled());
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveButtonOnEditGroupingPage);
        saveButtonOnEditGroupingPage.click();
    }

    public void errorMessageOnGrouping() {
        basicActions.waitForElementToBePresent(errorText, 10);
        softAssert.assertEquals(errorText.getText(), "This group is not valid. Make sure all members meet the grouping criteria listed above.");
        softAssert.assertAll();
    }

    public void dragAndDropChildrenToSeparateGroup() {
        basicActions.waitForElementToBePresent(groupingMembers.get(2), 10);
        basicActions.waitForElementToBePresent(dragAMemberHere.get(3), 10);
        builder.clickAndHold(groupingMembers.get(1))
                .moveToElement(dragAMemberHere.get(3))
                .release(dragAMemberHere.get(3)).build()
                .perform();
        basicActions.wait(2000);
        basicActions.waitForElementToBePresent(groupingMembers.get(1), 10);
        basicActions.waitForElementToBePresent(dragAMemberHere.get(3), 10);
        builder.clickAndHold(groupingMembers.get(1))
                .moveToElement(dragAMemberHere.get(3))
                .release(dragAMemberHere.get(3)).build()
                .perform();
        basicActions.wait(3000);
    }

    public void iValidateSuccessMessage() {
        basicActions.waitForElementListToBePresent(successMessage, 10);
        softAssert.assertEquals(successMessage.get(0).getText(), "Success!");
        softAssert.assertEquals(successMessage.get(1).getText(), "Your enrollment groups are valid and have been successfully saved.");
        softAssert.assertAll();
    }

    public void iClickContinueOnSuccessPopup() {
        basicActions.waitForElementToBePresent(successContinue, 20);
        successContinue.click();
    }

    public void validateToolTipText() {
        String expectedToolTipText = "Household members can only be grouped together if they are all immediate family members who live in the same rating area and could be covered by a single insurance plan. Immediate family members include spouses, children under the age of 26, and collateral dependents (non-married, disabled tax dependents of a group member). Frequently, \"living in the same rating area\" means that all of the individuals live at the same physical address or within the same zip code. You might not be able to group members of your household if they are not considered immediate family members. For assistance, please call our Service Center at 855-752-6749.";
        basicActions.waitForElementToBePresent(whatWorksBestLink, 10);
        softAssert.assertEquals(whatWorksBestLink.getText(), "what works best for you.");
        builder.moveToElement(whatWorksBestLink).perform();
        softAssert.assertEquals(tootlTip.getText(), expectedToolTipText, "Actual Text::" + tootlTip.getText() + "::did not match");
        softAssert.assertAll();
    }

    public void dragAndDropMemberToCreateGroup(String Grouping) {
        switch (Grouping) {
            case "Create Group":
                basicActions.waitForElementToBePresent(groupingMembers.get(2), 10);
                basicActions.waitForElementToBePresent(dragAMemberHere.get(1), 10);
                builder.clickAndHold(groupingMembers.get(2))
                        .moveToElement(dragAMemberHere.get(1))
                        .release(dragAMemberHere.get(1)).build()
                        .perform();
                basicActions.wait(3000);
                break;
            case "Not Enrolling":
                basicActions.waitForElementToBePresent(groupingMembers.get(1), 10);
                basicActions.waitForElementToBePresent(dragAMemberNotEnrolling.get(0), 10);
                builder.clickAndHold(groupingMembers.get(1))
                        .moveToElement(dragAMemberNotEnrolling.get(0))
                        .release(dragAMemberNotEnrolling.get(0)).build()
                        .perform();
                basicActions.wait(3000);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + Grouping);
        }
    }

    public void ivalidateResetGroupLink() {
        resetGroupsButton.isDisplayed();
        resetGroupsButton.isEnabled();
    }

    public void createNewGroup(List<String> grouping) {
        basicActions.waitForElementToDisappear(spinner, 20);
        removeSuggestedGroups();
        for (String group : grouping) {
            basicActions.waitForElementToBePresent(createNewGroupLink, 10);
            basicActions.scrollToElement(createNewGroupLink);
            createNewGroupLink.click();
            String[] groupDetail = group.split(":");
            String[] Names = groupDetail[0].split(",");
            for (String Name : Names) {
                WebElement dragElement = basicActions.getDriver().findElement(By.xpath("//*[contains(text(),'" + Name + "')]"));
                WebElement dropElement = dragAMemberHere.get(dragAMemberHere.size() - 1);
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

    public void validatePageText() {
        basicActions.waitForElementToBePresent(pageTitle1, 10);
        softAssert.assertEquals(pageTitle1.getText() + " " + pageTitle2.getText(), "Edit Medical Enrollment Groups");
        softAssert.assertEquals(para1.getText(), "In some cases, households may benefit from separating members into different groups. This may be the case if your household members have different coverage needs or different eligibility. We suggest the following groups, but you can use what works best for you.");
        softAssert.assertEquals(para2.getText(), "Drag and drop your household members into groups of your choice. You can also place them in the Not Enrolling box if you no longer want that person to enroll in a plan.");
        softAssert.assertEquals(groupingQtn.getText(), "Which household members can be grouped together?");
        softAssert.assertEquals(groupingTxt.getText(), "Household members can be grouped together if:");
        softAssert.assertEquals(theyAreAllText.getText() + " " + immFamilyMemTxt.getText(), "They are all immediate family members.");
        softAssert.assertEquals(theyAllText.getText() + " " + physicalAddressTxt.getText() + " " + sameZipTxt.getText(), "They all live at the same physical address or within the same zip code.");
        softAssert.assertEquals(containerTxtList.get(0).getText(), "Medical Group #1");
        softAssert.assertEquals(containerTxtList.get(containerTxtList.size() - 1).getText(), "Not Enrolling");
        softAssert.assertEquals(dragAMemberHere.get(0).getText(), "Drag a member here to add to the group");
        softAssert.assertEquals(dragAMemberNotEnrolling.get(0).getText(), "Drag a member here to mark them as not enrolling");
        softAssert.assertEquals(resetGroupsButton.getText(), "Reset to suggested groups");
        softAssert.assertEquals(createNewGroupLink.getText(), "Create a new group");
        softAssert.assertEquals(goBackButton.getText(), "Go back");
        softAssert.assertEquals(saveButtonOnEditGroupingPage.getText(), "Save groups");
        softAssert.assertAll();
    }

    private void removeSuggestedGroups() {
        basicActions.waitForElementListToBePresent(manageGroupingMember,10);
        for (WebElement dragElement : manageGroupingMember) {
            WebElement dropElement = dragAMemberNotEnrolling.get(0);

            basicActions.scrollToElement(dragElement);
            basicActions.scrollToElement(dropElement);

            builder.clickAndHold(dragElement)
                    .moveToElement(dropElement)
                    .release(dropElement).build()
                    .perform();

            basicActions.wait(3000);
        }

        List<WebElement> closeIcons = basicActions.getDriver().findElements(By.xpath("//i[contains(@class,'float-end')]"));
        for (WebElement closeIcon : closeIcons) {
            closeIcon.click();
        }
    }


}

