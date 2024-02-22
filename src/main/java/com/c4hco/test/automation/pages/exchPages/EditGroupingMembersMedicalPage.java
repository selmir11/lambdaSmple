package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class EditGroupingMembersMedicalPage {
    @FindBy(id ="SHP-EditMedicalGroupingMembers-Cancel")
    WebElement cancelarButton;
    @FindBy(id ="editMyEnrollmentGroupsEnglishAndSpanishButton")
    WebElement createNewGroupLink;
    private BasicActions basicActions;
    public EditGroupingMembersMedicalPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    public void cancelEditGroupingMembers(){
        basicActions.waitForElementToBeClickable(cancelarButton,10);
        cancelarButton.click();
        basicActions.waitForElementToDisappear(createNewGroupLink,10);
    }
}
