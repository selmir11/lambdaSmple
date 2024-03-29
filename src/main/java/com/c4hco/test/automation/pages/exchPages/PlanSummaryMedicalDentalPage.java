package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class PlanSummaryMedicalDentalPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public PlanSummaryMedicalDentalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    // locator in stg is diff - @FindBy(id = "PlanSummary-Continue")
    //@FindBy(xpath = "//button[@id='PlanSummary-Continue']")
    //WebElement continueBtnOnPlanSummary;
    @FindBy(className = "btn-primary")
    WebElement continueBtnOnPlanSummary;
    @FindBy(css = ".summary-container p")
    List<WebElement> planSummaryHeading;

    @FindBy(xpath = "//div[@class='shopping-parent-container']")
    WebElement planSummaryMedicalplanheading;

    @FindBy(xpath = "//span[normalize-space()='Premiums Before Savings']")
    WebElement planSummaryMedicalpremium;

    @FindBy(xpath = "//*[contains(text(),\"Money you save\")]")
    WebElement planSummaryMedicalpremiumcredit;

    @FindBy(xpath = "//*[contains(text(),\"Amount you pay\")]")
    WebElement planSummaryMedicalAmtyoupay;

    @FindBy(xpath = "//th[normalize-space()='Dental Plans']")
    WebElement planSummaryDentalplanheading;

    @FindBy(xpath = "//span[normalize-space()='Premiums Before Savings']")
    WebElement planSummaryDentalpremium;

    @FindBy(xpath = "//*[contains(text(),\"Money you save\")]")
    WebElement planSummaryDentalpremiumcredit;

    @FindBy(xpath = "//*[contains(text(),\"Amount you pay\")]")
    WebElement planSummaryDentalAmtyoupay;

    @FindBy(id="PlanSummary-MedicalPremiumAmount_0")
    WebElement medicalPlanPremiumAmt;

    @FindBy(id="PlanSummary-DentalPremiumAmount_0")
    WebElement dentalPlanPremiumAmt;

    public void verifyTextPlanSummaryPage(){
        basicActions.waitForElementListToBePresent(planSummaryHeading,10);

        softAssert.assertEquals(planSummaryHeading.get(0).getText(), "Here are your plans");
        softAssert.assertEquals(planSummaryHeading.get(1).getText(), "and what they will cost");

        softAssert.assertTrue(planSummaryMedicalplanheading.isDisplayed(), "Medical plan heading did not match");
        softAssert.assertTrue(planSummaryDentalplanheading.isDisplayed(), "Dental plan heading did not match");

        softAssert.assertTrue(planSummaryMedicalpremium.isDisplayed(), "Premiums Before Savings did not display");
        softAssert.assertTrue(planSummaryDentalpremium.isDisplayed(), "Premiums Before Savings did not display");

        softAssert.assertTrue(planSummaryMedicalpremiumcredit.isDisplayed(), "Money you save did not display");
        softAssert.assertTrue(planSummaryDentalpremiumcredit.isDisplayed(), "Money you save did not display");

        softAssert.assertTrue(planSummaryMedicalAmtyoupay.isDisplayed(), "Amount you pay did not display");
        softAssert.assertTrue(planSummaryDentalAmtyoupay.isDisplayed(), "Amount you pay did not display");
        softAssert.assertAll();
    }
    
    public void clickContinueBtnOnPlanSummary(){
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary, 500);
        continueBtnOnPlanSummary.click();
    }
    public void continuePlanSummaryPage(){
        basicActions.waitForElementToBePresent(medicalPlanPremiumAmt, 10);
        setPlansPremiumAmt();
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary, 15);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", continueBtnOnPlanSummary);
    }

    public void setPlansPremiumAmt(){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setMedicalPremiumAmt(medicalPlanPremiumAmt.getText());
        subscriber.setDentalPremiumAmt(dentalPlanPremiumAmt.getText());
        SharedData.setPrimaryMember(subscriber);
    }
}
