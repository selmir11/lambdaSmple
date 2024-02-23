package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
public class GroupingMembersMedicalPage {
    @FindBy(xpath = "//*[@class=\"th-title\"]")
    WebElement medicalGroup1;
    @FindBy(xpath = "//*[@class=\"header-1 mb-3\"]")
    WebElement medicalEnrollmentGroupPageTitle;
    @FindBy(xpath = "//*[@class=\"col-9 body-text-1\"]")
    WebElement groupingPageText;
    @FindBy(xpath = "//*[@class=\"imp-message body-text-1\"]")
    WebElement rememberText;
    @FindBy(id="SHP-MedicalGroupingMembers-EditMyEnrollmentGroups")
    WebElement editMyEnrollmentGroupsButton;
    @FindBy(xpath = "//div/button[@id='SHP-MedicalGroupingMembers-GoBack']")
    WebElement goBackButton;
    @FindBy(id= "SHP-MedicalGroupingMembers-SaveAndExit")
    WebElement saveAndExitButton;
    @FindBy(id = "SHP-MedicalGroupingMembers-Continue")
    WebElement continueButton;
    @FindBy(id = "globe-image")
    WebElement glodeImageDropdown;

    private BasicActions basicActions;
    public GroupingMembersMedicalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }
    SoftAssert softAssert = new SoftAssert();
    public void clickContinue(){
        continueButton.click();
    }

    public void clickGoBackButtonOnGroupingMembersMedicalPage(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(goBackButton, 30));
        basicActions.waitForElementToBeClickable(goBackButton,10);
        goBackButton.click();
    }
    public void clickOnEditMedicalGroupinglink(){
        basicActions.waitForElementToBeClickable(editMyEnrollmentGroupsButton,30);
        editMyEnrollmentGroupsButton.click();
    }

    //--------------------------validations------------------------
    public void verifyMedicalGroupingPage(){
        softAssert.assertEquals(medicalEnrollmentGroupPageTitle, "Medical Enrollment Groups");
        softAssert.assertEquals(groupingPageText,"It may be cheaper to separate your household into groups and enroll in different plans. We suggest the following groups, but you can use what works best for you.");
        softAssert.assertEquals(rememberText,"Remember: Costs within a group count towards each group’s deductible and out of pocket maximum.");
        softAssert.assertEquals(medicalGroup1,"Medical Group # 1");
        softAssert.assertEquals(editMyEnrollmentGroupsButton,"Edit my enrollment groups");
        softAssert.assertEquals(goBackButton,"Go Back");
        softAssert.assertEquals(saveAndExitButton,"Save and Exit");
        softAssert.assertEquals(continueButton,"Continue");
        softAssert.assertTrue(glodeImageDropdown.isEnabled());
    }

}
