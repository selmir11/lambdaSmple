package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class GroupingMembersDentalPage {
    @FindBy(css = ".container .header-1")
    WebElement dentalEnrollmentGroupPageTitle;
    @FindBy(css = ".container .body-text-1")
    List<WebElement> groupingPageText;
    @FindBy(css = ".th-title")
    WebElement dentalGroup1;
    @FindBy(id = "SHP-DentalGroupingMembers-EditMyEnrollmentGroups")
    WebElement editMyEnrollmentGroupsLink;
    @FindBy(css = ".row .btn-secondary")
    List<WebElement> backAndSaveAndExitButtons;
    @FindBy(id = "SHP-DentalGroupingMembers-Continue")
    WebElement continueButton;
    @FindBy(id = "globe-image")
    WebElement glodeImageDropdown;

    private BasicActions basicActions;
    public GroupingMembersDentalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    SoftAssert softAssert = new SoftAssert();
    public void clickContinue(){
        basicActions.waitForElementToBePresent(continueButton,10);
        basicActions.waitForElementToBeClickable(continueButton,30);
        continueButton.click();
    }
    
    public void clickOnEditDentalGroupinglink(){
        basicActions.waitForElementToBePresent(editMyEnrollmentGroupsLink,10);
        basicActions.waitForElementToBeClickable(editMyEnrollmentGroupsLink,30);
        editMyEnrollmentGroupsLink.click();
    }

    //--------------------------validations------------------------
    public void verifyDentalGroupingPageVerbiage(){
        basicActions.waitForElementToBePresent(dentalEnrollmentGroupPageTitle,10);
        softAssert.assertEquals(dentalEnrollmentGroupPageTitle.getText(), "Medical Enrollment Groups");
        softAssert.assertEquals(groupingPageText.get(0).getText(),"It may be cheaper to separate your household into groups and enroll in different plans. We suggest the following groups, but you can use what works best for you.");
        softAssert.assertEquals(groupingPageText.get(1).getText(),"Remember: Costs within a group count towards each group's deductible and out of pocket maximum.");
       // softAssert.assertEquals(dentalGroup1.getText(),"Dental Group # 1");
        softAssert.assertEquals(editMyEnrollmentGroupsLink,"Edit my enrollment groups");
        softAssert.assertEquals(backAndSaveAndExitButtons.get(0).getText(),"Go Back");
        softAssert.assertEquals(backAndSaveAndExitButtons.get(1).getText(),"Save and Exit");
        softAssert.assertEquals(continueButton.getText(),"Continue");
        softAssert.assertTrue(glodeImageDropdown.isEnabled());
        softAssert.assertAll();
    }

}
