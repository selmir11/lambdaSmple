package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class GroupingMembersDentalPage {

    @FindBy(id = "SHP-DentalGroupingMembers-EditMyEnrollmentGroups")
    WebElement editMyEnrollmentGroupsLink;

    @FindBy(id = "SHP-DentalGroupingMembers-Continue")
    WebElement continueButton;


    private BasicActions basicActions;

    public GroupingMembersDentalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    SoftAssert softAssert = new SoftAssert();

    public void clickContinue() {
        basicActions.wait(3000);
        basicActions.waitForElementToBePresent(continueButton, 30);
        basicActions.waitForElementToBeClickable(continueButton, 30);
        continueButton.click();
    }

    public void clickOnEditDentalGroupinglink() {
        basicActions.waitForElementToBePresent(editMyEnrollmentGroupsLink, 10);
        basicActions.waitForElementToBeClickable(editMyEnrollmentGroupsLink, 30);
        editMyEnrollmentGroupsLink.click();
    }
}




