package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class GroupingMembersMedicalPage {
    @FindBy(css = ".container .header-1")
    WebElement medicalEnrollmentGroupPageTitle;
    @FindBy(css = ".container .body-text-1")
    List<WebElement> groupingPageText;
    @FindBy(css = ".th-title")
    WebElement medicalGroup1;
    @FindBy(css = ".mb-2 .link-text-1")
    WebElement editMyEnrollmentGroupsButton;
    @FindBy(css = ".row .btn-secondary")
    List<WebElement> backAndSaveAndExitButtons;
    @FindBy(id = "SHP-MedicalGroupingMembers-Continue")
    WebElement continueButton;
    @FindBy(id = "globe-image")
    WebElement glodeImageDropdown;

    private BasicActions basicActions;
    public GroupingMembersMedicalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    SoftAssert softAssert = new SoftAssert();
    public void clickContinue(){
        continueButton.click();
    }

    public void clickGoBackButtonOnGroupingMembersMedicalPage(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(backAndSaveAndExitButtons.get(1), 30));
        basicActions.waitForElementToBeClickable(backAndSaveAndExitButtons.get(1),10);
        backAndSaveAndExitButtons.get(1).click();
    }
    public void clickOnEditMedicalGroupinglink(){
        basicActions.waitForElementToBeClickable(editMyEnrollmentGroupsButton,30);
        editMyEnrollmentGroupsButton.click();
    }

    //--------------------------validations------------------------
    public void verifyMedicalGroupingPage(){
        softAssert.assertEquals(medicalEnrollmentGroupPageTitle, "Medical Enrollment Groups");
        softAssert.assertEquals(groupingPageText.get(0),"It may be cheaper to separate your household into groups and enroll in different plans. We suggest the following groups, but you can use what works best for you.");
        softAssert.assertEquals(groupingPageText.get(1),"Remember: Costs within a group count towards each group’s deductible and out of pocket maximum.");
        softAssert.assertEquals(medicalGroup1,"Medical Group # 1");
        softAssert.assertEquals(editMyEnrollmentGroupsButton,"Edit my enrollment groups");
        softAssert.assertEquals(backAndSaveAndExitButtons.get(0),"Go Back");
        softAssert.assertEquals(backAndSaveAndExitButtons.get(1),"Save and Exit");
        softAssert.assertEquals(continueButton,"Continue");
        softAssert.assertTrue(glodeImageDropdown.isEnabled());
    }

}
