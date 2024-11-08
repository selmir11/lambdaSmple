package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
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
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );
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

    @FindBy(xpath = "//span[contains(@id,'PlanSummary-MedicalPlanName_1')]")
    WebElement planSummaryNoMedicalPlanSingle;
    @FindBy(xpath = "//span[normalize-space()='No dental plan selected for this group.']")
    WebElement planSummaryNoDentalPlan;


    @FindBy(id = "PlanSummary-MedicalPremiumAmount_0")
    WebElement medicalPremiumAfterAPTCAmt;

    @FindBy(css = "#PlanSummary-MedicalPremiumReductionAmount_0")
    List<WebElement> medicalAPTCAmt;

    @FindBy(id = "PlanSummary-DentalPremiumAmount_0")
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

    @FindBy(id = "PlanSummary-AmountYouPayHelpText")
    WebElement toolTipText;

    @FindBy(id = "ngb-tooltip-38")
    WebElement toolTipInformation;

    public void verifyAPTCPlanSummaryAmt(String aPTCPlanSummaryAmt) {
        basicActions.waitForElementToBePresent( aPTCPlanSummary, 10 );
        softAssert.assertEquals( aPTCPlanSummary.getText(), aPTCPlanSummaryAmt );
        softAssert.assertAll();
    }

    public void verifyTextPlanSummaryPage() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementListToBePresent( planSummaryHeading, 20 );

        softAssert.assertEquals( planSummaryHeading.get( 0 ).getText(), "Here are your plans" );
        softAssert.assertEquals( planSummaryHeading.get( 1 ).getText(), "and what they will cost" );

        softAssert.assertTrue( planSummaryMedicalplanheading.isDisplayed(), "Medical plan heading did not match" );
        softAssert.assertTrue( planSummaryDentalplanheading.isDisplayed(), "Dental plan heading did not match" );

        softAssert.assertTrue( planSummaryMedicalpremium.isDisplayed(), "Premiums Before Savings did not display" );
        softAssert.assertTrue( planSummaryDentalpremium.isDisplayed(), "Premiums Before Savings did not display" );

        softAssert.assertTrue( planSummaryMedicalpremiumcredit.isDisplayed(), "Money you save did not display" );
        softAssert.assertTrue( planSummaryDentalpremiumcredit.isDisplayed(), "Money you save did not display" );

        softAssert.assertTrue( planSummaryMedicalAmtyoupay.isDisplayed(), "Amount you pay did not display" );
        softAssert.assertTrue( planSummaryDentalAmtyoupay.isDisplayed(), "Amount you pay did not display" );

        softAssert.assertAll();
    }

    public void verifyPlanSummaryPage() {
        basicActions.waitForElementListToBePresent( planSummaryHeading, 30 );

        softAssert.assertTrue( planSummaryNoMedicalPlan.isDisplayed(), "No medical plan selected is not display" );
        softAssert.assertTrue( planSummaryNoDentalPlan.isDisplayed(), "No dental plan selected is not display" );

        softAssert.assertAll();
    }

    public void verifyNoMedicalSingle() {
        basicActions.waitForElementToDisappear( spinner, 40 );
        basicActions.scrollToElement( planSummaryNoMedicalPlanSingle );
        softAssert.assertTrue( planSummaryNoMedicalPlanSingle.isDisplayed(), "No medical plan selected for this group." );
        softAssert.assertAll();
    }


    public void continueButton() {
        basicActions.waitForElementToDisappear( spinner, 5500 );
        basicActions.waitForElementToBePresent( medicalPremiumAfterAPTCAmt, 10 );
        basicActions.waitForElementToBePresent( continueBtnOnPlanSummary, 15 );
        ((JavascriptExecutor) basicActions.getDriver()).executeScript( "arguments[0].click()", continueBtnOnPlanSummary );
    }

   
    public void continuePlanSummaryPage(){
        setPlansPremiumAmt();
        getmedGroup1MemNames();
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary, 30);
        basicActions.waitForElementToBePresent(medicalPremiumAfterAPTCAmt, 10);
        basicActions.scrollToElement( continueBtnOnPlanSummary );
        ((JavascriptExecutor) basicActions.getDriver()).executeScript( "arguments[0].click()", continueBtnOnPlanSummary );
    }

    public void goBackPlanSummaryPage() {
        basicActions.waitForElementToBeClickableWithRetries( goBackButton, 15 );
        basicActions.scrollToElement( goBackButton );
        basicActions.click( goBackButton );
    }

    public void getmedGroup1MemNames() {
        List<MemberDetails> memberslist = SharedData.getMembers();
        MemberDetails subscriber = SharedData.getPrimaryMember();
        String names = medicalgroup1MemberNames.getText();
        String[] name = names.split( "\\s*(,|and)\\s*" );
        for (String memName : name) {
            String memFirstLastName = memName.trim();
            String[] separateFirstLastNames = memFirstLastName.split( " " );
            String memFirstName = separateFirstLastNames[0];
            String memLastName = separateFirstLastNames[separateFirstLastNames.length - 1];
            if (subscriber.getFirstName().equals( memFirstName ) && subscriber.getLastName().equals( memLastName )) {
                subscriber.setMedicalPlan( medicalPlanName.getText() );
                subscriber.setDentalPlan( dentalPlanName.getText() );
                continue;
            }
            for (int i = 0; i < memberslist.size(); i++) {
                String Fname = memberslist.get( i ).getFirstName();
                String Lname = memberslist.get( i ).getLastName();
                if (Fname.equals( memFirstName ) && Lname.equals( memLastName )) {
                    memberslist.get( i ).setMedicalPlan( medicalPlanName.getText() );
                    memberslist.get( i ).setDentalPlan( dentalPlanName.getText() );
                }
            }
        }
    }

    public void verifyContinueButtonIsDisabled() {
        basicActions.waitForElementToBePresent( continueBtnOnPlanSummary, 20 );
        String buttonClass = continueBtnOnPlanSummary.getAttribute( "class" );
        softAssert.assertTrue( buttonClass.contains( "button-disabled" ), "Continue button is enabled, but it should be disabled." );
        softAssert.assertAll();
    }

    public void validateToolTipLanguageTextSummaryPage(String language) {
        switch (language) {
            case "English":
                basicActions.waitForElementToDisappear( spinner, 20 );
                validateToolTipTextEnglish();
                break;
            case "Spanish":
                basicActions.waitForElementToDisappear( spinner, 20 );
                validateToolTipTextSpanish();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );
        }
    }

    public void validateToolTipTextEnglish() {
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementToBePresentWithRetries( toolTipText, 30 );
        basicActions.click( toolTipText );
        basicActions.waitForElementToBePresentWithRetries( toolTipInformation, 20 );
        softAssert.assertEquals( toolTipInformation.isDisplayed(), "This refers to your monthly premium after financial help has been applied. This is the amount you must pay your insurance company each month. It keeps your insurance active and helps cover the cost of services included in your plan." );
    }


    public void validateToolTipTextSpanish() {
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementToBePresentWithRetries( toolTipText, 30 );
        basicActions.click( toolTipText );
        basicActions.waitForElementToBePresentWithRetries( toolTipInformation, 20 );
        softAssert.assertEquals( toolTipInformation.isDisplayed(), "Se refiere a su prima mensual una vez aplicada la ayuda financiera. Es la cantidad que debe pagar cada mes a su compa\u00F1\u00EDa de seguros. Mantiene su seguro activo y ayuda a cubrir el costo de los servicios incluidos en su plan." );
    }

    private void setPlansPremiumAmt(){
        basicActions.waitForElementToDisappear(spinner, 20);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        List<MemberDetails> memberslist = basicActions.getAllMem();
        Boolean isGettingFinancialHelp = subscriber.getFinancialHelp();
        basicActions.waitForElementToDisappear(spinner, 15);
        basicActions.wait(3000);
        basicActions.waitForElementToBePresent(medicalPremiumAfterAPTCAmt, 10);

        if(medicalAPTCAmt.isEmpty()){//NFA
            basicActions.waitForElementListToBePresent(medicalAPTCAmt, 10);
            for(MemberDetails member: memberslist){
                //getting group details
                int groupLocatorIndex = Integer.parseInt(member.getMedGroupInd())-1;

                //Medical Plan Premium details
                WebElement medPremAfterAPTCAmtEle = basicActions.getDriver().findElement(By.id("PlanSummary-MedicalPremiumAmount_"+groupLocatorIndex+""));
                WebElement medicalPlanNameEle = basicActions.getDriver().findElement(By.id("PlanSummary-MedicalPlanName_"+groupLocatorIndex+""));

                String medPremiumAfterReduction = medPremAfterAPTCAmtEle.getText().replace("$", "");

                member.setMedicalPlan(medicalPlanNameEle.getText());
                member.setMedicalAptcAmt("0");
                member.setTotalMedAmtAfterReduction(medPremiumAfterReduction);
                member.setMedicalPremiumAmt(medPremiumAfterReduction);

                //Dental Plan Premium details
                WebElement dentalPremiumAfterAPTCAmntEle = basicActions.getDriver().findElement(By.id("PlanSummary-DentalPremiumAmount_"+groupLocatorIndex+""));
                WebElement dentalPlanNameEle = basicActions.getDriver().findElement(By.id("PlanSummary-DentalPlanName_"+groupLocatorIndex+""));
                member.setTotalDentalPremAfterReduction(dentalPremiumAfterAPTCAmntEle.getText().replace("$", ""));
                member.setDentalAptcAmt("0.00");
                member.setDentalPremiumAmt(member.getTotalDentalPremAfterReduction());
                member.setDentalPlan(dentalPlanNameEle.getText());
            }
        }
        else {
            //FA
            basicActions.waitForElementListToBePresent(medicalAPTCAmt, 10);
            for(MemberDetails member: memberslist){
                //getting group details
                int groupLocatorIndex = Integer.parseInt(member.getMedGroupInd())-1;

                //Medical Plan Premium details
                WebElement medPremAfterAPTCAmtEle = basicActions.getDriver().findElement(By.id("PlanSummary-MedicalPremiumAmount_"+groupLocatorIndex+""));
                WebElement medAPTCAmtEle = basicActions.getDriver().findElement(By.id("PlanSummary-MedicalPremiumReductionAmount_"+groupLocatorIndex+""));
                WebElement medicalPlanNameEle = basicActions.getDriver().findElement(By.id("PlanSummary-MedicalPlanName_"+groupLocatorIndex+""));

                String medPremiumAfterReduction = medPremAfterAPTCAmtEle.getText().replace("$", "");
                String medAPTCAmt = medAPTCAmtEle.getText().replace("$", "");

                BigDecimal bigDecimalMedAPTCAmt = new BigDecimal(medAPTCAmt.replace(",",""));
                BigDecimal bigDecimalMedPremiumMinusAPTC = new BigDecimal(medPremiumAfterReduction);
                BigDecimal totalMedicalPremium = bigDecimalMedPremiumMinusAPTC.add(bigDecimalMedAPTCAmt);
                subscriber.setMedicalPremiumAmt(String.valueOf(totalMedicalPremium));

                member.setMedicalPlan(medicalPlanNameEle.getText());
                member.setMedicalAptcAmt(medAPTCAmt);
                member.setTotalMedAmtAfterReduction(medPremiumAfterReduction);
                member.setMedicalPremiumAmt(totalMedicalPremium.toString());

                //Dental Plan Premium details
                WebElement dentalPremiumAfterAPTCAmntEle = basicActions.getDriver().findElement(By.id("PlanSummary-DentalPremiumAmount_"+groupLocatorIndex+""));
                WebElement dentalPlanNameEle = basicActions.getDriver().findElement(By.id("PlanSummary-DentalPlanName_"+groupLocatorIndex+""));
                member.setTotalDentalPremAfterReduction(dentalPremiumAfterAPTCAmntEle.getText().replace("$", ""));
                member.setDentalAptcAmt("0.00");
                member.setDentalPremiumAmt(member.getTotalDentalPremAfterReduction());
                member.setDentalPlan(dentalPlanNameEle.getText());
            }
        }
    }
}
