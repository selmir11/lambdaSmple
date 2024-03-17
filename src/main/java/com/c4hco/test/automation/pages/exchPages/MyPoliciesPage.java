package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Dto.PolicyMember;
import com.c4hco.test.automation.utils.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MyPoliciesPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public MyPoliciesPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".current-policy .txt-name")
    List<WebElement> memberNames;  // Gives names of all members - both medical and dental

    @FindBy(css = ".current-policy .current-policy-container")
    List<WebElement> cardsList;

    @FindBy(css = ".current-policy-data .pDate span:nth-child(2)")
    List<WebElement> planStartAndEndDate; // update this locator - split and have one for plan start date and one for plan end date

    @FindBy(css = ".current-policy-container .header-3")
    List<WebElement> planNames; // Both medical and dental plan names for all members

    @FindBy(id = "viewPlanHistoryLink_0")
    WebElement viewPlanHistoryLinkMedical; // To DO:: Update the locators in this file

    @FindBy(id = "viewPlanHistoryLink_1")
    WebElement viewPlanHistoryLinkDental; // Update locator - will only work when we have 1medical, 1dental and 1 memeber

    @FindBy(css = "app-plan-details .container .header-2")
    WebElement planHistoryTitle;

    @FindBy(css = "table .body-text-1")
    List<WebElement> tableRecord; // TO DO:: Check if this works with multiple members and multiple groups

    @FindBy(id="backToCurrentPlanDetailsButton")
    WebElement backToCurPlansBtn;

    @FindBy(xpath = "//span[contains(., 'Monthly Premium')]/following-sibling::span")
    List<WebElement> premiumAmt;

    @FindBy(xpath = "//div[contains(./span, 'Exchange Policy Number:')]/following-sibling::div/span")
    List<WebElement> EAPID; //exchange policy number for both medical and dental

    PolicyMember primaryMember = SharedData.getSubscriber();

    public void validateEnrolledMedicalPlanDetails(){
        // TO DO: Add other low priority validations as well
        // **** Works when only one member with one medical plan **** //
        // Exchange policy num - get from DB
        basicActions.waitForElementListToBePresent(memberNames, 10);
        softAssert.assertEquals(memberNames.get(0).getText(), primaryMember.getSignature(), "Name did not match on medical card");

        softAssert.assertEquals(planStartAndEndDate.get(0).getText(), primaryMember.getMedicalPlanStartDate(), "medical plan date did not match");
        softAssert.assertEquals(planStartAndEndDate.get(1).getText(), primaryMember.getMedicalPlanEndDate(), "medical plan end date did not match");

        softAssert.assertEquals(planNames.get(0).getText(), primaryMember.getMedicalPlan(), "medical plan name did not match");

        softAssert.assertEquals(premiumAmt.get(0).getText(), primaryMember.getMedicalPremiumAmt(), "medical premium did not match");

        softAssert.assertAll();
    }

    public void validateDentalPlanDetails(){
        // **** Works when only one member with one medical plan and one dental plan **** //
        basicActions.waitForElementListToBePresent(memberNames, 10);
        softAssert.assertEquals(memberNames.get(1).getText(), primaryMember.getSignature(), "member name on dental card did not match");
        softAssert.assertEquals(planNames.get(1).getText(), primaryMember.getDentalPlan() ,
                "dental plan name did not match. Actual on page::"+planNames.get(1).getText()+"::Expected::"+primaryMember.getDentalPlan());
        softAssert.assertEquals(planStartAndEndDate.get(2).getText(), primaryMember.getDentalPlanStartDate(), "Dental start date didn't match");
        softAssert.assertEquals(planStartAndEndDate.get(3).getText(), primaryMember.getDentalPlanEndDate(), "Dental end date didnt match");

        softAssert.assertEquals(premiumAmt.get(1).getText(), primaryMember.getDentalPremiumAmt(), "Dental premium did not match");

        softAssert.assertAll();
    }

    public void clickViewPlanHistoryFromMed(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkMedical, 10);
        viewPlanHistoryLinkMedical.click();
    }

    public void validateMedPlanDetailsFromPlanHistory(){
        basicActions.waitForElementToBePresent(planHistoryTitle, 10);
        basicActions.waitForElementListToBePresent(tableRecord, 10);
        softAssert.assertTrue(tableRecord.get(0).getText().equals(primaryMember.getSignature()));
        softAssert.assertTrue(tableRecord.get(1).getText().equals(primaryMember.getMedicalPlan()));
        softAssert.assertTrue(tableRecord.get(2).getText().equals(primaryMember.getMedicalPremiumAmt()));
//        softAssert.assertTrue(tableRecord.get(3).getText().equals()); // financial help
        softAssert.assertTrue(tableRecord.get(4).getText().equals(primaryMember.getMedicalPlanStartDate()));
        softAssert.assertTrue(tableRecord.get(5).getText().equals(primaryMember.getMedicalPlanEndDate()));
        softAssert.assertAll();
    }

    public void clickViewPlanHistoryFromDental(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkDental, 10);
        viewPlanHistoryLinkDental.click();
    }

    public void validateDentalPlanDetailsFromPlanHistory(){
        basicActions.waitForElementToBePresent(planHistoryTitle, 10);
        basicActions.waitForElementListToBePresent(tableRecord, 10);
        softAssert.assertEquals(tableRecord.get(0).getText(), primaryMember.getSignature(), "Name did not match");
        softAssert.assertEquals(tableRecord.get(1).getText(), primaryMember.getDentalPlan(), "Dental plan did not match");
        softAssert.assertEquals(tableRecord.get(2).getText(), primaryMember.getDentalPremiumAmt(), "Dental premium did not match" );
//        softAssert.assertTrue(tableRecord.get(3).getText().equals()); //  financial help
        softAssert.assertEquals(tableRecord.get(4).getText(), primaryMember.getDentalPlanStartDate(), "dental plan start date did not match");
        softAssert.assertEquals(tableRecord.get(5).getText(), primaryMember.getDentalPlanEndDate(), "dental plan end date did not match");
        softAssert.assertAll();
    }

    public void clickBackButton(){
        basicActions.waitForElementToBePresent(backToCurPlansBtn, 10);
        backToCurPlansBtn.click();
    }

}
