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

    @FindBy(id ="SHP-EditMedicalGroupingMembers-Save")
    WebElement saveButtonOnEditGroupingPage;
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    Actions builder;
    public EditGroupingMembersMedicalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        builder  = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void cancelEditGroupingMembers(){
        basicActions.waitForElementToBePresent(canceButtonOnEditEnrollmentPage,20);
        basicActions.waitForElementToBeClickable(canceButtonOnEditEnrollmentPage,10);
        canceButtonOnEditEnrollmentPage.click();
        basicActions.waitForElementToDisappear(createNewGroupLink,10);
    }
    //Actions builder = new Actions(basicActions.getDriver());
    public void dragAndDropMembersCreateGroup(){
          builder.clickAndHold(groupingMemebers.get(3))
                .moveToElement(dragAMemberHere.get(2))
                .release(dragAMemberHere.get(2))
                .build().perform();
    }
    public void getElementCoordi(){
    Point point   = groupingMemebers.get(3).getLocation();
    System.out.println(point);
    }

    public void iClickSaveButton(){
        saveButtonOnEditGroupingPage.click();
    }
    public void errorMessageOnGrouping(){
        softAssert.assertEquals(errorText,"The group(s) highlighted below in red are not valid groupings. Please move around your members to create valid groups.");
    }


}
