package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EditGroupingMembersDentalPage {


    @FindBy(id = "SOL-ManageGroupingMembers-EditDentalTitle")
    WebElement pageTitle1;
    @FindBy(id = "SOL-ManageGroupingMembers-EditDentalGroupsTitle")
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
    @FindBy(id = "SOL-ManageGroupingMembers-DragAMemberNotEnrolling")
    List<WebElement> dragAMemberNotEnrolling;

    @FindBy(css = ".container div:nth-child(2) div span u")
    WebElement whatWorksBestLink;

    @FindBy(css = "ngb-tooltip-window .tooltip-inner")
    WebElement tootlTip;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "SOL-ManageGroupingMembers-DragAMember")
    List<WebElement> dragAMemberHere;

    @FindBy(id ="SOL-ManageGroupingMembers-CreateANewGroup")
    WebElement createNewGroupLink;

    @FindBy(id ="SOL-ManageGroupingMembers-SaveGroups")
    WebElement saveButtonOnEditDentalGroupingPage;

    @FindBy(id = "SOL-ManageGroupingMembers-PopUp-Continue")
    WebElement ctnBtnSuccessModal;

    @FindBy(id="SOL-ManageGroupingMembers-ResetTheGroups")
    WebElement resetButtonOnEditDentalGroupingPage;

    @FindBy(id="SOL-ManageGroupingMembers-GoBack")
    WebElement goBackButtononEditDentalGroupingPage;

    @FindBy(id = "SOL-ManageGroupingMembers-MemberDetails")
    List<WebElement> manageGroupingMember;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    Actions builder;

    public EditGroupingMembersDentalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        builder  = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void validateToolTipText(){
        String expectedToolTipText = "Household members can only be grouped together if they are all immediate family members who live in the same rating area and could be covered by a single insurance plan. Immediate family members include spouses, children under the age of 26, and collateral dependents (non-married, disabled tax dependents of a group member). Frequently, \"living in the same rating area\" means that all of the individuals live at the same physical address or within the same zip code. You might not be able to group members of your household if they are not considered immediate family members. For assistance, please call our Service Center at 855-752-6749.";
        basicActions.waitForElementToBePresent(whatWorksBestLink, 10);
        softAssert.assertEquals(whatWorksBestLink.getText(), "what works best for you.");
        builder.moveToElement(whatWorksBestLink).perform();
        softAssert.assertEquals(tootlTip.getText(), expectedToolTipText, "Actual Text::"+tootlTip.getText()+"::did not match");
        softAssert.assertAll();
    }

    public void createNewDentalGroups(List<String> groupingList) {
        basicActions.waitForElementToDisappear(spinner, 80);
        removeSuggestedGroups();
        for (String group : groupingList) {
            basicActions.waitForElementToBePresentWithRetries(createNewGroupLink, 50);
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

    public void iClickSaveButton(){
        softAssert.assertTrue(saveButtonOnEditDentalGroupingPage.isEnabled());
        basicActions.waitForElementToBePresent(saveButtonOnEditDentalGroupingPage,20);
        basicActions.scrollToElement(saveButtonOnEditDentalGroupingPage);
        saveButtonOnEditDentalGroupingPage.click();
    }

    public void iClickContinueOnSuccessPopup(){
        basicActions.waitForElementToBePresent(ctnBtnSuccessModal, 20);
        ctnBtnSuccessModal.click();
    }

    public void validatePageText() {
        basicActions.waitForElementToBePresent(pageTitle1, 10);
        softAssert.assertEquals(pageTitle1.getText() + " " + pageTitle2.getText(), "Edit Dental Enrollment Groups");
        softAssert.assertEquals(para1.getText(), "In some cases, households may benefit from separating members into different groups. This may be the case if your household members have different coverage needs or different eligibility. We suggest the following groups, but you can use what works best for you.");
        softAssert.assertEquals(para2.getText(), "Drag and drop your household members into groups of your choice. You can also place them in the Not Enrolling box if you no longer want that person to enroll in a plan.");
        softAssert.assertEquals(groupingQtn.getText(), "Which household members can be grouped together?");
        softAssert.assertEquals(groupingTxt.getText(), "Household members can be grouped together if:");
        softAssert.assertEquals(theyAreAllText.getText() + " " + immFamilyMemTxt.getText(), "They are all immediate family members.");
        softAssert.assertEquals(theyAllText.getText() + " " + physicalAddressTxt.getText() + " " + sameZipTxt.getText(), "They all live at the same physical address or within the same zip code.");
        softAssert.assertEquals(containerTxtList.get(0).getText(), "Dental Group #1");
        softAssert.assertEquals(containerTxtList.get(containerTxtList.size() - 1).getText(), "Not Enrolling");
        softAssert.assertEquals(dragAMemberHere.get(0).getText(), "Drag a member here to add to the group");
        softAssert.assertEquals(dragAMemberNotEnrolling.get(0).getText(), "Drag a member here to mark them as not enrolling");
        softAssert.assertEquals(resetButtonOnEditDentalGroupingPage.getText(), "Reset to suggested groups");
        softAssert.assertEquals(createNewGroupLink.getText(), "Create a new group");
        softAssert.assertEquals(goBackButtononEditDentalGroupingPage.getText(), "Go back");
        softAssert.assertEquals(saveButtonOnEditDentalGroupingPage.getText(), "Save groups");
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

