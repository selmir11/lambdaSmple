package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class EmploymentSummaryPage {
    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;
    public EmploymentSummaryPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".header-1")
    WebElement hdr_Income;

    @FindBy(css = ".header-2")
    WebElement hdr_Employment;

    @FindBy(id = "EmploymentSummary-SaveAndContinue")
    WebElement btnContinue;

    @FindBy(xpath = "//*[starts-with(@id,'edit')]")
    WebElement lnkEditIncome;

    public void clickContinue(){
        basicActions.waitForElementToBePresent(btnContinue,30);
        basicActions.waitForElementToBePresent(lnkEditIncome,30);
        basicActions.waitForElementToBeClickable(btnContinue, 30);
        basicActions.scrollToElement(btnContinue);
        btnContinue.click();
    }

    public void clickEditIncome(int Index){
        basicActions.waitForElementToBePresent(lnkEditIncome,10);
        Index -=1;
        lnkEditIncome.click();

    }



    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    public void verifyHeadersEmploymentSummaryPage(String language){
        switch (language){
            case "English":
                verifyHeadersEmploymentSummaryPageEnglish();
                break;
            case "Spanish":
                verifyHeadersEmploymentSummaryPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersEmploymentSummaryPageEnglish(){
        basicActions.waitForElementToBePresent(hdr_Income,15);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Income: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(hdr_Employment.getText(),"Employment");
        softAssert.assertAll();
    }

    public void verifyHeadersEmploymentSummaryPageSpanish(){
        basicActions.waitForElementToBePresent(hdr_Income,15);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(hdr_Employment.getText(),"Ingresos por empleo");
        softAssert.assertAll();
    }

}
