package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class IncomeSummaryCoCoPage {

    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    public IncomeSummaryCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".header-1")
    WebElement hdr_Income;

    @FindBy(css = ".header-2")
    WebElement hdr_IncomeSummary;

    @FindBy(css = "#edit-income-button > svg")
    WebElement incomeEditIcon;

    @FindBy(css = "#edit-deductions-button > svg")
    WebElement deductionsEditIcon;

    @FindBy(css = "div.total-income-width div span")
    WebElement totalAnnualIncome;

    @FindBy(css = "lib-option-buttons button")
    List<WebElement> projectedIncomeButtons;

    @FindBy(id = "ELIG-summaryDetails-incomeAmountInput")
    WebElement projectedIncomeInput;

    @FindBy(id = "pageId-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "ELIG-summaryDetails-NoButton")
    WebElement projectedIncomeNo;

    @FindBy(id = "ELIG-summaryDetails-YesButton")
    WebElement getProjectedIncomeYes;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void clickprojectedIncomeNo(){
        basicActions.waitForElementToDisappear(spinner,20);
        basicActions.waitForElementToBeClickableWithRetries( projectedIncomeNo,15 );
        projectedIncomeNo.click();
        projectedIncomeNo.click();
    }

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBePresent(hdr_Income, 30);
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueButton, 30);
        saveAndContinueButton.click();
    }

    public void selectProjectedIncome(String projectedIncome){
        switch(projectedIncome){
            case "Yes":
                basicActions.waitForElementListToBePresent(projectedIncomeButtons, 15);
                projectedIncomeButtons.get(0).click();
                break;
            case "No":
                basicActions.waitForElementListToBePresentWithRetries(projectedIncomeButtons, 15);
                projectedIncomeButtons.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + projectedIncomeButtons);
        }
    }

    public void enterProjectedIncomeAmountCoCo(String amount){
        basicActions.waitForElementToBePresent(projectedIncomeInput, 10);
        projectedIncomeInput.sendKeys(amount);
    }

    public void selectEditIcon(String type){
        basicActions.waitForElementToBePresent(incomeEditIcon, 15);
        switch(type){
            case "Income":
                incomeEditIcon.click();
                break;
            case "Deductions":
                deductionsEditIcon.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + projectedIncomeButtons);
        }
    }

    
    
    //////////////////////////////////////////////VALIDATION METHODS//////////////////////////////////////////////////
    public void verifyHeadersIncomeSummaryPage(String language){
        switch (language){
            case "English":
                verifyHeadersIncomeSummaryPageEnglish();
                break;
            case "Spanish":
                verifyHeadersIncomeSummaryPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersIncomeSummaryPageEnglish(){
        basicActions.waitForElementToBePresent(hdr_Income,15);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase( "Income: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_IncomeSummary.getText(), "Summary");
        softAssert.assertAll();
    }

    public void verifyHeadersIncomeSummaryPageSpanish(){
        basicActions.waitForElementToBePresent(hdr_Income,15);
        basicActions.waitForElementToBePresent(hdr_IncomeSummary,15);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_IncomeSummary.getText(), "Resumen");
        softAssert.assertAll();
    }

    public void verifyTotalAnnualIncome(String Amount){
        basicActions.waitForElementToBePresentWithRetries(totalAnnualIncome, 10);
        basicActions.waitForElementToDisappear(spinner, 15);
        softAssert.assertTrue(totalAnnualIncome.getText().contains(Amount), "Amount is incorrect");
        softAssert.assertAll();
    }

    public void verifyEditIcon(){
        basicActions.waitForElementToBePresent(incomeEditIcon, 10);
        basicActions.waitForElementToDisappear(spinner, 15);
        softAssert.assertEquals(incomeEditIcon.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(incomeEditIcon.getCssValue("width"), "14px");
        softAssert.assertEquals(incomeEditIcon.getCssValue("height"), "14px");
        softAssert.assertEquals(incomeEditIcon.getCssValue("top"), "auto");
        softAssert.assertEquals(incomeEditIcon.getCssValue("left"), "auto");
        softAssert.assertEquals(deductionsEditIcon.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(deductionsEditIcon.getCssValue("width"), "14px");
        softAssert.assertEquals(deductionsEditIcon.getCssValue("height"), "14px");
        softAssert.assertEquals(deductionsEditIcon.getCssValue("top"), "auto");
        softAssert.assertEquals(deductionsEditIcon.getCssValue("left"), "auto");
        softAssert.assertAll();
    }
    
}
