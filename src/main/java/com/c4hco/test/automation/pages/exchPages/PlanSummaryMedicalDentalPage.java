package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class PlanSummaryMedicalDentalPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public PlanSummaryMedicalDentalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SHP-PlanSummary-Continue")
    WebElement continueBtnOnPlanSummary;

    @FindBy(xpath = "//*[contains(text(),\"Here are your plans\")]")
    WebElement planSummaryHeadingOne;

    @FindBy(xpath = "//*[contains(text(),\"and what they will cost\")]")
    WebElement planSummaryHeadingTwo;

    @FindBy(xpath = "//*[contains(text(),\"Medical Plans\")]")
    WebElement planSummaryMedicalplanheading;

    @FindBy(xpath = "//*[contains(text(),\"Premiums Before Savings\")]")
    WebElement planSummaryMedicalpremium;

    @FindBy(xpath = "//*[contains(text(),\"Money you save\")]")
    WebElement planSummaryMedicalpremiumcredit;

    @FindBy(xpath = "//*[contains(text(),\"Amount you pay\")]")
    WebElement planSummaryMedicalAmtyoupay;

    @FindBy(xpath = "//*[contains(text(),\"Dental Plans\")]")
    WebElement planSummaryDentalplanheading;

    @FindBy(xpath = "//*[contains(text(),\"Premiums Before Savings\")]")
    WebElement planSummaryDentalpremium;

    @FindBy(xpath = "//*[contains(text(),\"Money you save\")]")
    WebElement planSummaryDentalpremiumcredit;

    @FindBy(xpath = "//*[contains(text(),\"Amount you pay\")]")
    WebElement planSummaryDentalAmtyoupay;



    public void verifyTextPlanSummaryPage(){
        basicActions.waitForElementToBePresent(planSummaryHeadingOne,10);
        softAssert.assertEquals(planSummaryHeadingOne.getText(), "Here are your plans");
        softAssert.assertEquals(planSummaryHeadingTwo.getText(), "and what they will cost");
        softAssert.assertEquals(planSummaryMedicalplanheading.getText(), "Medical Plans");
        softAssert.assertEquals(planSummaryDentalplanheading.getText(), "Dental Plans");
        softAssert.assertEquals(planSummaryMedicalpremium.getText(), "Premiums Before Savings");
        softAssert.assertEquals(planSummaryDentalpremium.getText(), "Premiums Before Savings");
        softAssert.assertEquals(planSummaryMedicalpremiumcredit.getText(), "Money you save");
        softAssert.assertEquals(planSummaryDentalpremiumcredit.getText(), "Money you save");
        softAssert.assertEquals(planSummaryMedicalAmtyoupay.getText(), "Amount you pay");
        softAssert.assertEquals(planSummaryDentalAmtyoupay.getText(), "Amount you pay");
        softAssert.assertAll();
    }
    public void continuePlanSummaryPage(){
        basicActions.waitForElementToBePresent(continueBtnOnPlanSummary,10);
        basicActions.waitForElementToBeClickable(continueBtnOnPlanSummary,10);
        continueBtnOnPlanSummary.click();
    }
}
