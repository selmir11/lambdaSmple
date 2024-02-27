package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class EditGroupingMembersMedicalPage {
    @FindBy(id ="SHP-EditMedicalGroupingMembers-Cancel")
    WebElement canceButtonOnEditEnrollmentPage;
    @FindBy(id ="SHP-EditMedicalGroupingMembers-CreateANewGroup")
    WebElement createNewGroupLink;
    private BasicActions basicActions;
    public EditGroupingMembersMedicalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void cancelEditGroupingMembers(){
        basicActions.waitForElementToBePresent(canceButtonOnEditEnrollmentPage,20);
        basicActions.waitForElementToBeClickable(canceButtonOnEditEnrollmentPage,10);
        canceButtonOnEditEnrollmentPage.click();
        basicActions.waitForElementToDisappear(createNewGroupLink,10);
    }
}
