package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class GroupingMembersDentalPage {

    @FindBy(id = "SOL-ViewGroupingMembers-EditMyEnrollmentGroups")
    WebElement editMyEnrollmentGroupsLink;

    @FindBy(id = "SOL-ViewGroupingMembers-Continue")
    WebElement continueButton;

    @FindBy(id = "SOL-ViewGroupingMembers-GoBack")
    WebElement goBackButton;

    @FindBy(id = "SOL-ViewGroupingMembers-SaveAndExit")
    WebElement saveExitButton;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(css = "#SOL-ViewGroupingMembers-DentalGroup")
    List<WebElement> groupTitle;

    @FindBy(id="SOL-ViewGroupingMembers-DentalEnrollmentTitle")
    WebElement dentalEnrPageTitle;

    @FindBy(id="SOL-ViewGroupingMembers-GroupsDentalTitle")
    WebElement dentalGroupsTitle;

    @FindBy(id = "SOL-ViewGroupingMembers-EnrollmentGroups1stParagraph")
    WebElement groupingPagePara1Dental;
    @FindBy(id = "SOL-ViewGroupingMembers-EnrollmentGroups2ndParagraph")
    WebElement groupingPagePara2Dental;

    @FindBy(css = ".c4-type-header-sm")
    List<WebElement> dentalGroupTitle;
    @FindBy(id="SOL-ViewGroupingMembers-EditMyEnrollmentGroups")
    WebElement editMyEnrollmentGroupsButton;
    @FindBy(id = "globe-image")
    WebElement globeImageDropdown;

    private BasicActions basicActions;

    public GroupingMembersDentalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    SoftAssert softAssert = new SoftAssert();

    public void clickContinue()  {
        basicActions.waitForElementToDisappear(spinner,30);
        basicActions.waitForElementToBePresentWithRetries(continueButton,30);
        List<MemberDetails> memberInfoDetails = basicActions.getAllDentalEligibleMemInfo();
        for (MemberDetails memDet : memberInfoDetails){
            basicActions.waitForElementListToBePresent(groupTitle,10);
            WebElement memGroupInfo = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),'"+memDet.getFirstName()+"')]/ancestor-or-self::div[@class='group-member__container']/div[@class='c4-type-header-sm group-member__Header']"));
            Assert.assertTrue(basicActions.waitForElementToBePresentWithRetries(memGroupInfo,10));
            basicActions.scrollToElement(memGroupInfo);
            memDet.setDenGroupInd(memGroupInfo.getText().replace("Dental Group #",""));
        }
        basicActions.scrollToElement(continueButton);
        continueButton.click();
    }
    public void clickContinueWithRetries() {
        basicActions.waitForElementToDisappear(spinner,30);
        basicActions.waitForElementToBePresentWithRetries(continueButton,30);
        basicActions.clickElementWithRetries(continueButton, 10);
    }

    public void clickGoBack() {
        basicActions.waitForElementToDisappear(spinner,15);
        basicActions.scrollToElement( goBackButton);
        basicActions.waitForElementToBeClickable( goBackButton,15 );
        goBackButton.click();

    }

    public void clickOnEditDentalGroupinglink() {
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresent(editMyEnrollmentGroupsLink, 10);
        basicActions.clickElementWithRetries(editMyEnrollmentGroupsLink, 10);
    }

    public void clickSaveAndExit(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresent( saveExitButton,20 );
        basicActions.scrollToElement( saveExitButton );
        saveExitButton.click();;
    }

    public void validateDefaultDentalGroups(int defaultExpectedGroups){
        basicActions.waitForElementListToBePresent(groupTitle, 10);
        Assert.assertEquals(groupTitle.size(), defaultExpectedGroups, "Group size did not match!!");
    }

    public void verifyDentalGroupingPageVerbiage() {
        basicActions.waitForElementToBePresent(dentalEnrPageTitle, 10);
        softAssert.assertEquals(dentalEnrPageTitle.getText()+" "+dentalGroupsTitle.getText(), "Dental Enrollment Groups");
        softAssert.assertEquals(groupingPagePara1Dental.getText(), "Enrollment groups let you choose who enrolls in the same plan together. Remember that costs within a group count towards each group’s deductible and out-of-pocket maximum. In some cases, changing your enrollment groups may make coverage more affordable for your household.");
        softAssert.assertEquals(groupingPagePara2Dental.getText(), "We\u2019ve set up suggested groups based on who is in your family, where they live, and what they\u2019re eligible for, but you can choose to move them into groups of your choice.");
        softAssert.assertEquals(dentalGroupTitle.get(0).getText(),"Dental Group #1");

        softAssert.assertEquals(editMyEnrollmentGroupsButton.getText(), "Edit my suggested groups");
        softAssert.assertEquals(goBackButton.getText(), "Go back");
        softAssert.assertEquals(saveExitButton.getText(), "Save and exit");
        softAssert.assertEquals(continueButton.getText(), "Continue");
        softAssert.assertTrue(globeImageDropdown.isEnabled());
        softAssert.assertAll();
    }

}




