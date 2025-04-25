package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EditGroupingMemberMedicalCoCoPage {

    private BasicActions basicActions;

    Actions builder;

    @FindBy(id = "SOL-EditMedicalGroupingMembers-Cancel")
    WebElement cancelButtonOnEditEnrollmentPage;

   @FindBy(id = "SOL-ManageGroupingMembers-CreateANewGroup")
    WebElement createNewGroupLink;

    @FindBy(id = "SOL-ManageGroupingMembers-GoBack")
    WebElement goBackButtonOnEditEnrollmentPage;

    @FindBy(css = ".container .groupHeading")
    List<WebElement> noOfmedicalGroups;

    @FindBy(id ="SOL-ManageGroupingMembers-SaveGroups")
    WebElement saveButtonOnEditGroupingPage;

    @FindBy(id = "SOL-ManageGroupingMembers-ResetTheGroups")
    WebElement resetButtonOnEditEnrollmentPage;

    @FindBy(id = "SOL-ManageGroupingMembers-PopUpHeader")
    WebElement successHeader;

    @FindBy(id = "SOL-ManageGroupingMembers-PopUpMessage")
    WebElement successMsg;

    @FindBy(id = "SOL-ManageGroupingMembers-PopUp-Continue")
    WebElement successContinue;

    @FindBy(id = "SOL-ManageGroupingMembers-DragAMember")
    List<WebElement> dragAMemberHere;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    SoftAssert softAssert = new SoftAssert();

    public EditGroupingMemberMedicalCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        builder = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void iClickSaveButton(){
        softAssert.assertTrue(saveButtonOnEditGroupingPage.isEnabled());
        basicActions.waitForElementToBePresent(saveButtonOnEditGroupingPage,20);
        basicActions.scrollToElement(saveButtonOnEditGroupingPage);
        saveButtonOnEditGroupingPage.click();
    }

    public void iValidateSuccessMessage() {
        basicActions.waitForElementToBePresent(successHeader, 30);
        softAssert.assertEquals(successHeader.getText(), "Success!");
        softAssert.assertEquals(successMsg.getText(), "Your enrollment groups are valid and have been successfully saved.");
        softAssert.assertAll();
    }

    public void iClickContinueOnSuccessPopup() {
        basicActions.waitForElementToBePresent(successContinue,20);
        successContinue.click();
    }

    public void createNewGroup(List<String> grouping) {
        basicActions.waitForElementToDisappear(spinner, 70);
        basicActions.waitForElementToBePresent(createNewGroupLink, 70);
        basicActions.scrollToElement(createNewGroupLink);

        while (dragAMemberHere.size()<grouping.size()) {
            basicActions.scrollToElement(createNewGroupLink);
            createNewGroupLink.click();
        }

        for (int i = grouping.size() - 1; i >= 0; i--) {
            String[] groupDetail = grouping.get(i).split(":");
            String[] Names = groupDetail[0].split(",");

            for (String Name : Names) {
                WebElement dragElement = basicActions.getDriver()
                        .findElement(By.xpath("//*[@id='SOL-ManageGroupingMembers-MemberDetails']/span[contains(text(), '" + Name + "')]"));

                WebElement dropElement = dragAMemberHere.get(i);

                basicActions.scrollToElement(dragElement);
                basicActions.scrollToElement(dropElement);

                builder.clickAndHold(dragElement)
                        .moveToElement(dropElement)
                        .release(dropElement).build()
                        .perform();

                basicActions.wait(3000);
            }
        }
    }

    public void relationshipsInGroups(List<String> relation) {
        List<MemberDetails> membersList = basicActions.getAllMedicalEligibleMemInfo();
        for (int i = relation.size() - 1; i >= 0; i--) {
            String[] groupDetail = relation.get(i).split(":");
            String Name = groupDetail[0];
            String relationshipToSubscriber = groupDetail[1];

            for (MemberDetails member : membersList) {
                if (member.getFirstName().contains(Name)) {
                    member.setRelation_to_subscriber(relationshipToSubscriber);
                }
            }
        }
    }
}
