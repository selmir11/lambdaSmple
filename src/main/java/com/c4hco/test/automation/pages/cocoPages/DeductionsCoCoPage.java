package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DeductionsCoCoPage {
    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public DeductionsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css= ".header-1")
    WebElement hdr_Deductions;

    @FindBy(css= ".header-2")
    WebElement hdr_Deductions2;

    @FindBy(css = "app-show-options button")
    List<WebElement> deductionButton;

    @FindBy(id = "ELIG-Deductions-AOSS-amountInput")
    WebElement alimonyAmount;

    @FindBy(id = "ELIG-Deductions-AOSS-frequencySelect")
    WebElement alimonyFrequency;

    @FindBy(id = "Deductions-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "Deductions-GoBack")
    WebElement backButton;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBePresentWithRetries(hdr_Deductions,30);
        basicActions.waitForElementToBePresentWithRetries(hdr_Deductions2,30);
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueButton, 30);
        saveAndContinueButton.click();
    }

    public void clickBackButton() {
        basicActions.waitForElementToBeClickable(backButton, 50);
        backButton.click();
    }

    public void selectNoneDeductionsOption(){
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        basicActions.waitForElementListToBePresent(deductionButton, 30);
        deductionButton.get(10).click();
    }

    public void selectDeductionOption(String deductionOption, String Amount, String Frequency){
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 10);

        switch (deductionOption) {
            case "Alimony":
                deductionButton.get(0).click();
                basicActions.waitForElementToBeClickable(alimonyAmount, 10);
                alimonyAmount.sendKeys(Amount);

                Select dropdown = new Select(alimonyFrequency);
                dropdown.selectByVisibleText(" " + Frequency + " ");
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + deductionOption);
        }
    }

    
    //////////////////////////////////////////////VALIDATION METHODS//////////////////////////////////////////////////
    public void verifyHeadersDeductionsPage(String language){
        switch (language){
            case "English":
                verifyHeadersDeductionsPageEnglish();
                break;
            case "Spanish":
                verifyHeadersDeductionsPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersDeductionsPageEnglish(){
        basicActions.waitForElementToBePresent(hdr_Deductions,15);
        softAssert.assertTrue(hdr_Deductions.getText().equalsIgnoreCase( "Income: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_Deductions2.getText(), "Deductions");
        softAssert.assertAll();
    }

    public void verifyHeadersDeductionsPageSpanish(){
        basicActions.waitForElementToBePresent(hdr_Deductions,90);
        basicActions.waitForElementToBePresent(hdr_Deductions2,90);
        basicActions.waitForElementToBePresent(saveAndContinueButton,90);
        basicActions.waitForElementToBePresent(backButton,90);
        softAssert.assertTrue(hdr_Deductions.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_Deductions2.getText(), "Deducciones");
        softAssert.assertAll();
    }
}
