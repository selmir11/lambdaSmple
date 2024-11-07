package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
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

    @FindBy(id = "PlanSummary-GoBack")
    WebElement goBackButton;

    @FindBy(css = ".summary-container p")
    List<WebElement> planSummaryHeading;

    @FindBy(xpath = "//*[contains(text(),\"Medical Plans\")]")
    WebElement planSummaryMedicalplanheading;

    @FindBy(xpath = "//span[normalize-space()='Premiums Before Savings']")
    WebElement planSummaryMedicalpremium;

    @FindBy(xpath = "//*[contains(text(),\"Money you save\")]")
    WebElement planSummaryMedicalpremiumcredit;

    @FindBy(xpath = "//*[contains(text(),\"Amount you pay\")]")
    WebElement planSummaryMedicalAmtyoupay;

    @FindBy(xpath = "//*[contains(text(),\"Dental Plans\")]")
    WebElement planSummaryDentalplanheading;

    @FindBy(xpath = "//span[normalize-space()='Premiums Before Savings']")
    WebElement planSummaryDentalpremium;

    @FindBy(xpath = "//*[contains(text(),\"Money you save\")]")
    WebElement planSummaryDentalpremiumcredit;

    @FindBy(xpath = "//*[contains(text(),\"Amount you pay\")]")
    WebElement planSummaryDentalAmtyoupay;

    @FindBy(xpath = "//span[normalize-space()='No medical plan selected for this group.']")
    WebElement planSummaryNoMedicalPlan;
    
    @FindBy(xpath="//span[contains(@id,'PlanSummary-MedicalPlanName_1')]")
    WebElement planSummaryNoMedicalPlanSingle;
    @FindBy(xpath = "//span[normalize-space()='No dental plan selected for this group.']")
    WebElement planSummaryNoDentalPlan;


    @FindBy(id="PlanSummary-MedicalPremiumAmount_0")
    WebElement medicalPremiumAfterAPTCAmt;

    @FindBy(css = "#PlanSummary-MedicalPremiumReductionAmount_0")
    List<WebElement> medicalAPTCAmt;

    @FindBy(id="PlanSummary-DentalPremiumAmount_0")
    WebElement dentalPlanPremiumAmt;

    @FindBy(css = "span#PlanSummary-TotalAmountYouSave")
    WebElement aPTCPlanSummary;
    @FindBy(css = "#PlanSummary-MedicalPlanName_0")
    WebElement medicalPlanName;
    @FindBy(css = "#PlanSummary-DentalPlanName_0")
    WebElement dentalPlanName;
    @FindBy(css = "#PlanSummary-MedicalGroupFullName_0")
    WebElement medicalgroup1MemberNames;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void verifyAPTCPlanSummaryAmt(String aPTCPlanSummaryAmt){
        basicActions.waitForElementToBePresent(aPTCPlanSummary,10);
        softAssert.assertEquals(aPTCPlanSummary.getText(),aPTCPlanSummaryAmt);
        softAssert.assertAll();
    }
    public void verifyTextPlanSummaryPage(){
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementListToBePresent(planSummaryHeading,20);

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

    public void verifyPlanSummaryPage(){
        basicActions.waitForElementListToBePresent(planSummaryHeading,30);

        softAssert.assertTrue(planSummaryNoMedicalPlan.isDisplayed(), "No medical plan selected is not display");
        softAssert.assertTrue(planSummaryNoDentalPlan.isDisplayed(), "No dental plan selected is not display");

        softAssert.assertAll();
    }

    public void verifyNoMedicalSingle(){
       basicActions.waitForElementToDisappear( spinner,40 );
       basicActions.scrollToElement( planSummaryNoMedicalPlanSingle );
        softAssert.assertTrue(planSummaryNoMedicalPlanSingle.isDisplayed(), "No medical plan selected for this group.");
        softAssert.assertAll();
    }

    public void continuePlanSummaryPage(){
        setPlansPremiumAmt();
        getmedGroup1MemNames();
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary, 30);
        basicActions.waitForElementToBePresent(medicalPremiumAfterAPTCAmt, 10);
        basicActions.scrollToElement( continueBtnOnPlanSummary );
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", continueBtnOnPlanSummary);
    }

    public void goBackPlanSummaryPage(){
        basicActions.waitForElementToBeClickableWithRetries( goBackButton,15 );
        basicActions.scrollToElement( goBackButton );
        basicActions.click (goBackButton );
    }

    public void getmedGroup1MemNames() {
        List<MemberDetails> memberslist = SharedData.getMembers();
        MemberDetails subscriber = SharedData.getPrimaryMember();
        String names = medicalgroup1MemberNames.getText();
        String[] name = names.split("\\s*(,|and)\\s*");
        for (String memName : name) {
            String memFirstLastName = memName.trim();
            String[] separateFirstLastNames = memFirstLastName.split(" ");
            String memFirstName = separateFirstLastNames[0];
            String memLastName = separateFirstLastNames[separateFirstLastNames.length - 1];
            if (subscriber.getFirstName().equals(memFirstName) && subscriber.getLastName().equals(memLastName)) {
                subscriber.setMedicalPlan(medicalPlanName.getText());
                subscriber.setDentalPlan(dentalPlanName.getText());
                continue;
            }
            for (int i = 0; i < memberslist.size(); i++) {
                String Fname = memberslist.get(i).getFirstName();
                String Lname = memberslist.get(i).getLastName();
                if (Fname.equals(memFirstName) && Lname.equals(memLastName)) {
                    memberslist.get(i).setMedicalPlan(medicalPlanName.getText());
                    memberslist.get(i).setDentalPlan(dentalPlanName.getText());
                }
            }
        }
    }

    public void setPlansPremiumAmt() {
        basicActions.waitForElementToDisappear(spinner, 20);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        List<MemberDetails> memberslist = SharedData.getMembers();
        Boolean isGettingFinancialHelp = subscriber.getFinancialHelp();
        basicActions.waitForElementToDisappear(spinner, 15);
        basicActions.wait(3000);
        basicActions.waitForElementToBePresent(medicalPremiumAfterAPTCAmt, 10);

        if(!isGettingFinancialHelp){//NFA
            subscriber.setMedicalAptcAmt("0");
            String medPremiumMinusAPTC = medicalPremiumAfterAPTCAmt.getText().replace("$","");
            subscriber.setTotalMedAmtAfterReduction(medPremiumMinusAPTC);
            subscriber.setMedicalPremiumAmt(medPremiumMinusAPTC);
            if (memberslist != null) {
                for (int i = 0; i < memberslist.size(); i++) {
                    memberslist.get(i).setTotalMedAmtAfterReduction(medPremiumMinusAPTC);
                    memberslist.get(i).setMedicalPremiumAmt(medPremiumMinusAPTC);
                }
            }
        }else {
            //FA
            basicActions.waitForElementListToBePresent(medicalAPTCAmt, 10);
            String medAPTCAmt = medicalAPTCAmt.get(0).getText().replace("$","");
            subscriber.setMedicalAptcAmt(medAPTCAmt);
            String medPremiumMinusAPTC = medicalPremiumAfterAPTCAmt.getText().replace("$", "");
            subscriber.setTotalMedAmtAfterReduction(medPremiumMinusAPTC);
            BigDecimal bigDecimalmedPremiumMinusAPTC = new BigDecimal(medPremiumMinusAPTC);
            BigDecimal bigDecimalmedAPTCAmt = new BigDecimal(medAPTCAmt);

            BigDecimal totalMedicalPremium = bigDecimalmedPremiumMinusAPTC.add(bigDecimalmedAPTCAmt);
            subscriber.setMedicalPremiumAmt(String.valueOf(totalMedicalPremium));
            if(memberslist !=null){
            for (int i = 0; i < memberslist.size(); i++) { // set premiums for member
                memberslist.get(i).setMedicalPremiumAmt(String.valueOf(totalMedicalPremium));
                memberslist.get(i).setDentalPremiumAmt(dentalPlanPremiumAmt.getText().replace("$", ""));
                memberslist.get(i).setMedicalAptcAmt(medAPTCAmt);
                memberslist.get(i).setTotalMedAmtAfterReduction(String.valueOf(bigDecimalmedPremiumMinusAPTC));
                memberslist.get(i).setTotalDentalPremAfterReduction(dentalPlanPremiumAmt.getText().replace("$", ""));
                memberslist.get(i).setDentalAptcAmt("0.00");
            }
            }
        }
        subscriber.setDentalAptcAmt("$0");
        subscriber.setDentalPremiumAmt(dentalPlanPremiumAmt.getText().replace("$", ""));
        subscriber.setTotalDentalPremAfterReduction(dentalPlanPremiumAmt.getText().replace("$", ""));
        SharedData.setPrimaryMember(subscriber);
    }


    public void verifyContinueButtonIsDisabled() {
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary, 20);
        String buttonClass = continueBtnOnPlanSummary.getAttribute("class");
        softAssert.assertTrue(buttonClass.contains("button-disabled"), "Continue button is enabled, but it should be disabled.");
        softAssert.assertAll();
    }
}
