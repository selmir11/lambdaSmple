package com.c4hco.test.automation.pages.cocoPages;

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

    @FindBy(id = "PlanSummary-MedicalPlanChangePlan_0")
    WebElement txtMedicalPlanChange;

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

    public void continueButton(){
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(medicalPremiumAfterAPTCAmt, 10);
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary, 15);
        basicActions.scrollToElement(continueBtnOnPlanSummary);
        basicActions.click(continueBtnOnPlanSummary);
    }

    public void iclickGoBack(){
        basicActions.waitForElementToDisappear(spinner,20);
        basicActions.waitForElementToBePresent(goBackbtn,10);
        basicActions.scrollToElement(continueBtnOnPlanSummary);
        goBackbtn.click();
    }

    public void verifyTextinPlanSummary(List<String> textDetails){
        basicActions.waitForElementToDisappear(spinner,20);
        softAssert.assertEquals(txtmedicalDentalPDF.getText(),textDetails.get(0));
        softAssert.assertEquals(txttitle.get(0).getText(),textDetails.get(1));
        softAssert.assertEquals(txttitle.get(1).getText(),textDetails.get(2));
        softAssert.assertEquals(txtPlanHeader.getText(),textDetails.get(3));
        softAssert.assertEquals(txtMedicalPlanChange.getText(),textDetails.get(4));
        softAssert.assertEquals(txtPlanamnt.getText(),textDetails.get(5));
        softAssert.assertEquals(txtTotalAmountYouPay.getText(),textDetails.get(5));
        softAssert.assertEquals(txtTotalofMedicalPlan.getText(),textDetails.get(6));
        softAssert.assertEquals(txtPremiumsBeforeSaving.getText(),textDetails.get(7));
        softAssert.assertEquals(txtMoneyYouSave.getText(),textDetails.get(8));
        softAssert.assertEquals(txtAmountyouPay.getText(),textDetails.get(9));
        softAssert.assertEquals(goBackbtn.getText(),textDetails.get(10));
        softAssert.assertEquals(SvaeandExitbtn.getText(),textDetails.get(11));
        softAssert.assertEquals(continueBtnOnPlanSummary.getText(),textDetails.get(12));
        softAssert.assertAll();
    }
}
