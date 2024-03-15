package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.SharedData;
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


    public void validateEnrolledMedicalPlanDetails(){
        // **** Works when only one member with one medical plan **** //
        basicActions.waitForElementListToBePresent(memberNames, 10);
        softAssert.assertEquals(memberNames.get(0).getText(), SharedData.getSubscriber().getFirstName()+" "+SharedData.getSubscriber().getLastName(), "Name did not match on medical card");

        softAssert.assertEquals(planStartAndEndDate.get(0).getText(), SharedData.getSelectedMedicalPlanStartDate(), "medical plan date did not match");
        softAssert.assertEquals(planStartAndEndDate.get(1).getText(), SharedData.getSelectedMedicalPlanEndDate(), "medical plan end date did not match");

        softAssert.assertEquals(planNames.get(0).getText(), SharedData.getfirstPlanNameOnMedicalResultsPage(), "medical plan name did not match");

        // financial start date
        // monthly premium label
        // monthly premium
        // if no financial help - set financial help as 0$ and if fin help is 0 - total amount paid - same as monthly premium
        // Exchange policy num - get from DB
        // subscriber name
        // last updated on label
        // last updated on - today - or skip this?
        // view plan history hyperlink

        softAssert.assertAll();
    }

    public void validateDentalPlanDetails(){
        // **** Works when only one member with one medical plan and one dental plan **** //
        basicActions.waitForElementListToBePresent(memberNames, 10);
        softAssert.assertEquals(memberNames.get(1).getText(), SharedData.getSubscriber().getFirstName()+" "+SharedData.getSubscriber().getLastName(), "member name on dental card did not match");
        softAssert.assertEquals(planNames.get(1).getText(), SharedData.getFirstPlanNameOnDentalResultsPage(),
                "dental plan start date did not match. Actual on pagr::"+planNames.get(1).getText()+"::Expected::"+SharedData.getFirstPlanNameOnDentalResultsPage());
        softAssert.assertEquals(planStartAndEndDate.get(2).getText(), SharedData.getSelectedDentalPlanStartDate(), "Dental start date didn't match");
        softAssert.assertEquals(planStartAndEndDate.get(3).getText(), SharedData.getSelectedDentalPlanEndDate(), "Dental end date didnt match");

        // ----Dental---////
        // financial start date
        // monthly premium label
        // monthly premium
        // if no financial help - set financial help as 0$ and if fin help is 0 - total amount paid - same as monthly premium
        // Exchange policy num - get from DB
        // subscriber name
        // last updated on label
        // last updated on - today - or skip this?
        // view plan history hyperlink
        softAssert.assertAll();

    }

    public void clickViewPlanHistoryFromMed(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkMedical, 10);
        viewPlanHistoryLinkMedical.click();
    }

    public void validateMedPlanDetailsFromPlanHistory(){
        basicActions.waitForElementToBePresent(planHistoryTitle, 10);
        basicActions.waitForElementListToBePresent(tableRecord, 10);
        softAssert.assertTrue(tableRecord.get(0).getText().equals(SharedData.getSubscriber().getFirstName()+" "+SharedData.getSubscriber().getLastName()));
        softAssert.assertTrue(tableRecord.get(1).getText().equals(SharedData.getfirstPlanNameOnMedicalResultsPage()));
//        // -- premium, financial help
//        softAssert.assertTrue(tableRecord.get(2).getText().equals()));
//        softAssert.assertTrue(tableRecord.get(3).getText().equals());
        softAssert.assertTrue(tableRecord.get(4).getText().equals(SharedData.getSelectedMedicalPlanStartDate()));
        softAssert.assertTrue(tableRecord.get(5).getText().equals(SharedData.getSelectedMedicalPlanEndDate()));
        softAssert.assertAll();
    }

    public void clickViewPlanHistoryFromDental(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkDental, 10);
        viewPlanHistoryLinkDental.click();
    }

    public void validateDentalPlanDetailsFromPlanHistory(){
        basicActions.waitForElementToBePresent(planHistoryTitle, 10);
        basicActions.waitForElementListToBePresent(tableRecord, 10);
        softAssert.assertTrue(tableRecord.get(0).getText().equals(SharedData.getSubscriber().getFirstName()+" "+SharedData.getSubscriber().getLastName()));
        softAssert.assertTrue(tableRecord.get(1).getText().equals(SharedData.getFirstPlanNameOnDentalResultsPage()));
//        // -- premium, financial help
//        softAssert.assertTrue(tableRecord.get(2).getText().equals()));
//        softAssert.assertTrue(tableRecord.get(3).getText().equals());
        softAssert.assertTrue(tableRecord.get(4).getText().equals(SharedData.getSelectedDentalPlanStartDate()));
        softAssert.assertTrue(tableRecord.get(5).getText().equals(SharedData.getSelectedDentalPlanEndDate()));
        softAssert.assertAll();
    }


    public void clickBackButton(){
        basicActions.waitForElementToBePresent(backToCurPlansBtn, 10);
        backToCurPlansBtn.click();
    }


}
