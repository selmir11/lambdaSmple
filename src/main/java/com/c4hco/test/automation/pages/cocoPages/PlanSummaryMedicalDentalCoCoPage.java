package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PlanSummaryMedicalDentalCoCoPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public PlanSummaryMedicalDentalCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "PlanSummary-Continue")
    WebElement continueBtnOnPlanSummary;

    @FindBy(id = "PlanSummary-SaveAndExit")
    WebElement planSummaryMedicalSaveExit;

    @FindBy(id="PlanSummary-MedicalPremiumAmount_0")
    WebElement medicalPremiumAfterAPTCAmt;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "PlanSummary-GoBack")
    WebElement goBackbtn;

    @FindBy(xpath = "//a[@id='PlanSummary-medicalDentalPDF']/em")
    WebElement txtmedicalDentalPDF;

    @FindBy(xpath = "//div[@class='summary-container'] //p[@class='title-text']")
    List<WebElement> txttitle;

    @FindBy(css = ".th-title.header-2")
    WebElement txtPlanHeader;

    @FindBy(css = ".float-start.link-text-2")
    WebElement txtViewPlanDetails;

    @FindBy(xpath = "//span[@class='plan-amount']/following-sibling::span")
    WebElement txtPlanamnt;

    @FindBy(xpath = "//span[@id='PlanSummary-TotalAmountYouPay']/following-sibling::span")
    WebElement txtTotalAmountYouPay;

    @FindBy(xpath ="(//div[@class='plan-card plan-summary-card']/div)[1]")
    WebElement txtTotalofMedicalPlan;

    @FindBy(xpath ="((//div[@class='plan-card plan-summary-card']/div)[2] //span)[1]")
    WebElement txtPremiumsBeforeSaving;

    @FindBy(xpath ="((//div[@class='plan-card plan-summary-card']/div)[3] //span)[1]")
    WebElement txtMoneyYouSave;

    @FindBy(id = "PlanSummary-SaveAndExit")
    WebElement SvaeandExitbtn;

    @FindBy(xpath ="((//div[@class='plan-card plan-summary-card']/div)[4] //span)[1]")
    WebElement txtAmountyouPay;
    @FindBy(id = "PlanSummary-TotalAmountYouPay")
    WebElement totalAmountYouPay;
    @FindBy(id = "PlanSummary-TotalPremiumBeforeSavings")
    WebElement premiumBeforeSaving;
    @FindBy(xpath = "//*[contains(text(),\"Medical Plans\")]")
    WebElement planSummaryMedicalplanheading;

    @FindBy(xpath = "//*[contains(text(),\"Planes m\u00e9dicos\")]")
    WebElement planSummaryMedicalplanheadingSpanish;

    @FindBy(xpath = "//*[contains(text(),\"Total of Medical Plans\")]")
    WebElement planSummaryMedicalplanTotalHeading;

    @FindBy(xpath = "//*[contains(text(),\"View Plan Details\")]")
    WebElement planSummaryMedicalViewPlanLink;

    @FindBy(xpath = "//*[contains(text(),\"Ver los detalles del plan\")]")
    WebElement planSummaryMedicalViewPlanLinkSpanish;

    @FindBy(xpath = "//span[normalize-space()='Premiums Before Savings']")
    WebElement planSummaryMedicalpremium;

    @FindBy(xpath = "//span[normalize-space()='Primas Antes de los Descuentos']")
    WebElement planSummaryMedicalpremiumSpanish;

    @FindBy(xpath = "//*[contains(text(),\"Money you save\")]")
    WebElement planSummaryMedicalpremiumcredit;

    @FindBy(xpath = "//*[contains(text(),\"Dinero que ahorra\")]")
    WebElement planSummaryMedicalpremiumcreditSpanish;

    @FindBy(xpath = "//*[contains(text(),\"Amount You Pay\")]")
    WebElement planSummaryMedicalAmtyoupay;

    @FindBy(xpath = "//*[contains(text(),\"Cantidad que paga\")]")
    WebElement planSummaryMedicalAmtyoupaySpanish;

    @FindBy(css = ".summary-container p")
    List<WebElement> planSummaryHeading;

    @FindBy(id = "PlanSummary-medicalDentalPDF")
    WebElement linkSummaryPDF;

    @FindBy(id = "PlanSummary-MedicalPlanChangePlan_0")
    WebElement planSummaryMedicalChangeplanLink;


    public void continueButton(){
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(medicalPremiumAfterAPTCAmt, 10);
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary, 15);
        basicActions.scrollToElement(continueBtnOnPlanSummary);
        basicActions.click(continueBtnOnPlanSummary);
    }

    public void iclickGoBack(){
        basicActions.waitForElementToDisappear(spinner,120);
        basicActions.waitForElementToBePresentWithRetries(goBackbtn,50);
        basicActions.scrollToElement(continueBtnOnPlanSummary);
        goBackbtn.click();
    }

    public void validateTextPlanSummaryCOCOPage(String language){
        basicActions.waitForElementToDisappear( spinner,20 );
        switch(language){
            case "English":
                verifyEnglishTextPlanSummaryCOCOPage();
                break;
            case "Spanish":
                verifySpanishTextPlanSummaryCOCOPage();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);

        }

    }

    public void verifyEnglishTextPlanSummaryCOCOPage(){
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementListToBePresent(planSummaryHeading,20);
        softAssert.assertEquals( linkSummaryPDF.getText(), "Download PDF");
        softAssert.assertEquals(planSummaryHeading.get(0).getText(), "Here are your plans");
        softAssert.assertEquals(planSummaryHeading.get(1).getText(), "and what they will cost");
        softAssert.assertEquals(planSummaryMedicalplanheading.getText(), "Medical Plans");
        softAssert.assertEquals(planSummaryMedicalChangeplanLink.getText(),"Change Plan");
        softAssert.assertEquals(planSummaryMedicalViewPlanLink.getText(), "View Plan Details");
        softAssert.assertEquals(txtTotalofMedicalPlan.getText(), "Total of Medical Plans");
        softAssert.assertEquals(planSummaryMedicalpremium.getText(), "Premiums Before Savings");
        softAssert.assertEquals(planSummaryMedicalpremiumcredit.getText(), "Money you save");
        softAssert.assertEquals(planSummaryMedicalAmtyoupay.getText(), "Amount You Pay");
        softAssert.assertEquals(goBackbtn.getText(),"Go Back");
        softAssert.assertEquals(planSummaryMedicalSaveExit.getText(),"Save and Exit");
        softAssert.assertEquals(continueBtnOnPlanSummary.getText(),"Continue");
        softAssert.assertAll();
    }
    public void verifySpanishTextPlanSummaryCOCOPage(){
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementListToBePresent(planSummaryHeading,20);
        softAssert.assertEquals( linkSummaryPDF.getText(), "Descargar PDF");
        softAssert.assertEquals(planSummaryHeading.get(0).getText(), "Aqu\u00ed est\u00e1n sus planes");
        softAssert.assertEquals(planSummaryHeading.get(1).getText(), "y lo que costar\u00e1n");
        softAssert.assertEquals(planSummaryMedicalplanheadingSpanish.getText(),"Planes m\u00e9dicos"); // Medical Plans
        softAssert.assertEquals(planSummaryMedicalChangeplanLink.getText(),"Cambiar de Plan"); // Change Plan
        softAssert.assertEquals(planSummaryMedicalViewPlanLinkSpanish.getText(),"Ver los detalles del plan");// View Plan Details
        softAssert.assertEquals(txtTotalofMedicalPlan.getText(),"Costo Total de los Planes M\u00e9dicos"); //Total of Medical Plans
        softAssert.assertEquals(planSummaryMedicalpremiumSpanish.getText(),"Primas Antes de los Descuentos"); // Premiums Before Savings
        softAssert.assertEquals(planSummaryMedicalpremiumcreditSpanish.getText(),"Dinero que ahorra"); // Money you save
        softAssert.assertEquals(planSummaryMedicalAmtyoupaySpanish.getText(),"Cantidad que paga"); //Amount Pay
        softAssert.assertEquals(goBackbtn.getText(),"Volver");
        softAssert.assertEquals(planSummaryMedicalSaveExit.getText(),"Guardar y Salir");
        softAssert.assertEquals(continueBtnOnPlanSummary.getText(),"Continuar");
        softAssert.assertAll();
    }
    public void setPlansPremiumAmtCoco() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToDisappear(spinner, 25);
        basicActions.waitForElementToBePresent(txtPremiumsBeforeSaving, 40);
        List<MemberDetails> memberslist = basicActions.getAllMedicalEligibleMemInfo();
        String  ses = SharedData.getSes();
        String openEnrolment = SharedData.getIsOpenEnrollment();
        String amountYouPay = totalAmountYouPay.getText().replace("$", "");
        for(MemberDetails member: memberslist) {
        if(ses.equals("yes") && openEnrolment.equals("yes")){
            //assuming we have budget for allocation - WIP
            softAssert.assertEquals(totalAmountYouPay.getText(), medicalPremiumAfterAPTCAmt.getText(), "Amount doesn't match");
            softAssert.assertEquals(amountYouPay, "0.00", "Amount is not equal to zero");
        }else {
            member.setAptcAmt("0.00");
            softAssert.assertEquals(totalAmountYouPay.getText(), premiumBeforeSaving.getText(), "Amount doesn't match");
        }
        member.setMedicalPremiumAmt(amountYouPay);
        member.setTotalMedAmtAfterReduction(amountYouPay);
        softAssert.assertAll();
    }}

    public void clickSaveAndExitButtonPlanSummary() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresentWithRetries(planSummaryMedicalSaveExit, 20);
        basicActions.scrollToElement(planSummaryMedicalSaveExit);
        planSummaryMedicalSaveExit.click();
    }
}
