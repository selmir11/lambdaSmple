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

    @FindBy(css = ".current-policy- .txt-name")
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

    public void validateEnrolledMedicalPlanDetails(){
        // **** Works when only one member with one medical plan **** //
        softAssert.assertTrue(memberNames.get(0).getText().equals(SharedData.getFirstName()+" "+SharedData.getLastName()));

        softAssert.assertTrue(planStartAndEndDate.get(0).getText().equals(SharedData.getSelectedMedicalPlanStartDate()));
        softAssert.assertTrue(planStartAndEndDate.get(1).getText().equals(SharedData.getSelectedMedicalPlanEndDate()));

        softAssert.assertTrue(planNames.get(0).getText().equals(SharedData.getfirstPlanNameOnMedicalResultsPage()));

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

        softAssert.assertTrue(memberNames.get(1).getText().equals(SharedData.getFirstName()+" "+SharedData.getLastName()));
        softAssert.assertTrue(planNames.get(1).getText().equals(SharedData.getFirstPlanNameOnDentalResultsPage()));
        softAssert.assertTrue(planStartAndEndDate.get(2).getText().equals(SharedData.getSelectedDentalPlanStartDate()));
        softAssert.assertTrue(planStartAndEndDate.get(3).getText().equals(SharedData.getSelectedDentalPlanEndDate()));

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

    public void clickViewPlanHistoryFromDental(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkDental, 10);
        viewPlanHistoryLinkDental.click();
    }


}
