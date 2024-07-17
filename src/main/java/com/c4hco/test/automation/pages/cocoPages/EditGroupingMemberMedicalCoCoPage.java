package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditGroupingMemberMedicalCoCoPage {

    private BasicActions basicActions;

    Actions builder;

    @FindBy(id = "SHP-EditMedicalGroupingMembers-Cancel")
    WebElement cancelButtonOnEditEnrollmentPage;
    @FindBy(id = "SHP-EditMedicalGroupingMembers-CreateANewGroup")
    WebElement createNewGroupLink;

    @FindBy(css = ".container .groupHeading")
    List<WebElement> noOfmedicalGroups;

    @FindBy(id ="SHP-EditMedicalGroupingMembers-Save")
    WebElement saveButtonOnEditGroupingPage;

    @FindBy(css = ".m-4")
    List<WebElement> successMessage;

    @FindBy(id = "SHP-EditMedicalGroupingMembers-Continue")
    WebElement successContinue;

    @FindBy(xpath = "//div[@class='dragHere']/parent::div")
    List<WebElement> dragAMemberHere;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    SoftAssert softAssert = new SoftAssert();

    public EditGroupingMemberMedicalCoCoPage(WebDriver webDriver) {
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

    public void iClickSaveButton(){
        softAssert.assertTrue(saveButtonOnEditGroupingPage.isEnabled());
        basicActions.waitForElementToBePresent(saveButtonOnEditGroupingPage,20);
        basicActions.scrollToElement(saveButtonOnEditGroupingPage);
        saveButtonOnEditGroupingPage.click();
    }

    public void iValidateSuccessMessage() {
        basicActions.waitForElementListToBePresent(successMessage, 10);
        softAssert.assertEquals(successMessage.get(0).getText(), "Success");
        softAssert.assertEquals(successMessage.get(1).getText(), "Success! Your enrollment groupings are valid and have been successfully saved. Click 'Continue' to go on.");
        softAssert.assertAll();
    }

    public void iClickContinueOnSuccessPopup() {
        basicActions.waitForElementToBePresent(successContinue,20);
        successContinue.click();
    }

    public void createNewGroup(List<String> grouping) {
        basicActions.waitForElementToDisappear(spinner, 20);
        while (grouping.size()+1 != dragAMemberHere.size()) {
            basicActions.scrollToElement(createNewGroupLink);
            createNewGroupLink.click();
        }
        for (int i = grouping.size() - 1; i > 0; i--) {
            String[] groupDetail = grouping.get(i).split(":");
            String[] Names = groupDetail[0].split(",");

            for (String Name : Names) {
                WebElement dragElement = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'" + Name + "')]"));
                WebElement dropElement = dragAMemberHere.get(i + 1);
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
