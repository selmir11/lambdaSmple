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

import java.math.BigDecimal;
import java.util.List;


public class PlanSummaryMedicalDentalPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public PlanSummaryMedicalDentalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "PlanSummary-Continue")
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
    WebElement medicalPremiumAfterAPTCAmt;

    @FindBy(id="PlanSummary-MedicalPremiumReductionAmount_0")
    WebElement medicalAPTCAmt;

    @FindBy(id="PlanSummary-DentalPremiumAmount_0")
    WebElement dentalPlanPremiumAmt;

    @FindBy(id = "PlanSummary-TotalAmountYouSave")
    WebElement aPTCPlanSummary;

    public void verifyAPTCPlanSummaryAmt(String aPTCPlanSummaryAmt){
        basicActions.waitForElementToBePresent(aPTCPlanSummary,10);
        softAssert.assertEquals(aPTCPlanSummary.getText(),aPTCPlanSummaryAmt);
        softAssert.assertAll();
    }
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
    
    public void continuePlanSummaryPage(){
        basicActions.waitForElementToBePresent(medicalPremiumAfterAPTCAmt, 10);
        setPlansPremiumAmt();
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary, 15);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", continueBtnOnPlanSummary);
    }

    public void setPlansPremiumAmt(){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        Boolean isGettingFinancialHelp = subscriber.getFinancialHelp();
        if(!isGettingFinancialHelp){
            subscriber.setMedicalAptcAmt("0");
            String medPremiumMinusAPTC = medicalPremiumAfterAPTCAmt.getText().replace("$","");
            subscriber.setTotalMedAmtAfterReduction(medPremiumMinusAPTC);
            subscriber.setMedicalPremiumAmt(medPremiumMinusAPTC);
        }else {
            String medAPTCAmt = medicalAPTCAmt.getText().replace("$","");
            subscriber.setMedicalAptcAmt(medAPTCAmt);
            String medPremiumMinusAPTC = medicalPremiumAfterAPTCAmt.getText().replace("$", "");
            subscriber.setTotalMedAmtAfterReduction(medPremiumMinusAPTC);
            BigDecimal bigDecimalmedPremiumMinusAPTC = new BigDecimal(medPremiumMinusAPTC);
            BigDecimal bigDecimalmedAPTCAmt = new BigDecimal(medAPTCAmt);

            BigDecimal totalMedicalPremium = bigDecimalmedPremiumMinusAPTC.add(bigDecimalmedAPTCAmt);
            System.out.println(totalMedicalPremium);
            subscriber.setMedicalPremiumAmt(String.valueOf(totalMedicalPremium));
        }
        subscriber.setDentalAptcAmt("$0");
        subscriber.setDentalPremiumAmt(dentalPlanPremiumAmt.getText());
        SharedData.setPrimaryMember(subscriber);
    }
}
