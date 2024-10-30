package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.*;
import java.util.*;

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

    @FindBy(id = "ELIG-Deductions-DPAC-amountInput")
    WebElement domesticProductionAmount;

    @FindBy(id = "ELIG-Deductions-DPAC-frequencySelect")
    WebElement domesticProductionFrequency;

    @FindBy(id = "ELIG-Deductions-HSAC-amountInput")
    WebElement hsaAmount;

    @FindBy(id = "ELIG-Deductions-HSAC-frequencySelect")
    WebElement hsaFrequency;

    @FindBy(id = "ELIG-Deductions-PRAC-amountInput")
    WebElement pretaxRetirementAmount;

    @FindBy(id = "ELIG-Deductions-PRAC-frequencySelect")
    WebElement pretaxRetirementFrequency;

    @FindBy(id = "ELIG-Deductions-STAF-amountInput")
    WebElement schoolTuitionAmount;

    @FindBy(id = "ELIG-Deductions-STAF-frequencySelect")
    WebElement schoolTuitionFrequency;

    @FindBy(id = "ELIG-Deductions-SETX-amountInput")
    WebElement selfemploymentTaxAmount;

    @FindBy(id = "ELIG-Deductions-SETX-frequencySelect")
    WebElement selfemploymentTaxFrequency;

    @FindBy(id = "ELIG-Deductions-STLI-amountInput")
    WebElement studentLoanAmount;

    @FindBy(id = "ELIG-Deductions-STLI-frequencySelect")
    WebElement studentLoanFrequency;

    @FindBy(id = "ELIG-Deductions-SEHI-amountInput")
    WebElement selfemploymentInsuranceAmount;

    @FindBy(id = "ELIG-Deductions-SEHI-frequencySelect")
    WebElement selfemploymentInsuranceFrequency;

    @FindBy(id = "ELIG-Deductions-SERP-amountInput")
    WebElement selfemploymentRetirementAmount;

    @FindBy(id = "ELIG-Deductions-SERP-frequencySelect")
    WebElement selfemploymentRetirementFrequency;

    @FindBy(id = "ELIG-Deductions-MOVE-amountInput")
    WebElement movingExpensesAmount;

    @FindBy(id = "ELIG-Deductions-MOVE-frequencySelect")
    WebElement movingExpensesFrequency;

    @FindBy(css = "lib-list-error > lib-error-msg > div")
    WebElement hdrError;

    @FindBy(css = "lib-input .error-message")
    List<WebElement> deductionsAmountError;

    @FindBy(css = "lib-dropdown .error-message")
    List<WebElement> deductionsFrequencyError;

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
    
    public void selectDeductionOption(String deductionOption, String amount, String frequency) {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 10);

        selectDeductionOptionOnly(deductionOption);
        enterAmount(deductionOption, amount);
        selectFrequency(deductionOption, frequency);
    }

    public void selectDeductionOptionOnly(String deductionOption) {
        basicActions.waitForElementListToBePresentWithRetries(deductionButton, 10);

        Map<String, Integer> optionToIndex = new HashMap<>();
        optionToIndex.put("Alimony", 0);
        optionToIndex.put("Domestic production", 1);
        optionToIndex.put("HSA", 2);
        optionToIndex.put("Pre-tax retirement", 3);
        optionToIndex.put("School tuition", 4);
        optionToIndex.put("Self-employment tax", 5);
        optionToIndex.put("Student loan", 6);
        optionToIndex.put("Self-employment health insurance", 7);
        optionToIndex.put("Self-employment retirement", 8);
        optionToIndex.put("Moving expenses", 9);
        optionToIndex.put("None of these", 10);

        Integer index = optionToIndex.get(deductionOption);
        List<WebElement> updatedDeductionButtons = basicActions.getDriver().findElements(By.cssSelector("app-show-options button"));
        basicActions.waitForElementListToBePresentWithRetries(updatedDeductionButtons,10);
        basicActions.clickElementWithRetries(updatedDeductionButtons.get(index),5);
    }

    private void enterAmount(String deductionOption, String amount) {
        switch (deductionOption) {
            case "Alimony":
                basicActions.waitForElementToBeClickable(alimonyAmount, 10);
                alimonyAmount.sendKeys(amount);
                break;
            case "Domestic production":
                basicActions.waitForElementToBeClickable(domesticProductionAmount, 10);
                domesticProductionAmount.sendKeys(amount);
                break;
            case "HSA":
                basicActions.waitForElementToBeClickable(hsaAmount, 10);
                hsaAmount.sendKeys(amount);
                break;
            case "Pre-tax retirement":
                basicActions.waitForElementToBeClickable(pretaxRetirementAmount, 10);
                pretaxRetirementAmount.sendKeys(amount);
                break;
            case "School tuition":
                basicActions.waitForElementToBeClickable(schoolTuitionAmount, 10);
                schoolTuitionAmount.sendKeys(amount);
                break;
            case "Self-employment tax":
                basicActions.waitForElementToBeClickable(selfemploymentTaxAmount, 10);
                selfemploymentTaxAmount.sendKeys(amount);
                break;
            case "Student loan":
                basicActions.waitForElementToBeClickable(studentLoanAmount, 10);
                studentLoanAmount.sendKeys(amount);
                break;
            case "Self-employment health insurance":
                basicActions.waitForElementToBeClickable(selfemploymentInsuranceAmount, 10);
                selfemploymentInsuranceAmount.sendKeys(amount);
                break;
            case "Self-employment retirement":
                basicActions.waitForElementToBeClickable(selfemploymentRetirementAmount, 10);
                selfemploymentRetirementAmount.sendKeys(amount);
                break;
            case "Moving expenses":
                basicActions.waitForElementToBeClickable(movingExpensesAmount, 10);
                movingExpensesAmount.sendKeys(amount);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + deductionOption);
        }
    }

    private void selectFrequency(String deductionOption, String frequency) {
        switch (deductionOption) {
            case "Alimony":
                selectFrequencyFromDropdown(alimonyFrequency, frequency);
                break;
            case "Domestic production":
                selectFrequencyFromDropdown(domesticProductionFrequency, frequency);
                break;
            case "HSA":
                selectFrequencyFromDropdown(hsaFrequency, frequency);
                break;
            case "Pre-tax retirement":
                selectFrequencyFromDropdown(pretaxRetirementFrequency, frequency);
                break;
            case "School tuition":
                selectFrequencyFromDropdown(schoolTuitionFrequency, frequency);
                break;
            case "Self-employment tax":
                selectFrequencyFromDropdown(selfemploymentTaxFrequency, frequency);
                break;
            case "Student loan":
                selectFrequencyFromDropdown(studentLoanFrequency, frequency);
                break;
            case "Self-employment health insurance":
                selectFrequencyFromDropdown(selfemploymentInsuranceFrequency, frequency);
                break;
            case "Self-employment retirement":
                selectFrequencyFromDropdown(selfemploymentRetirementFrequency, frequency);
                break;
            case "Moving expenses":
                selectFrequencyFromDropdown(movingExpensesFrequency, frequency);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + deductionOption);
        }
    }

    private void selectFrequencyFromDropdown(WebElement frequencyDropdown, String frequency) {
        Select dropdown = new Select(frequencyDropdown);
        dropdown.selectByVisibleText(" " + frequency + " ");
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

    public void verifyDeductionsOptionAmtError(String language){
        switch (language) {
            case "English":
                basicActions.waitForElementListToBePresent(deductionsAmountError,20);
                softAssert.assertEquals(deductionsAmountError.get(0).getText(), "Amount is required");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementListToBePresent(deductionsAmountError,20);
                softAssert.assertEquals(deductionsAmountError.get(0).getText(), "Esta cantidad es obligatoria");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyDeductionsOptionFreqError(String language){
        switch (language) {
            case "English":
                basicActions.waitForElementListToBePresent(deductionsFrequencyError,20);
                softAssert.assertEquals(deductionsFrequencyError.get(0).getText(), "Please select one of the options below");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementListToBePresent(deductionsFrequencyError,20);
                softAssert.assertEquals(deductionsFrequencyError.get(0).getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyDeductionsOptionHdrError(String language){
        basicActions.waitForElementToBePresent(hdrError,20);
        switch (language) {
            case "English":
                softAssert.assertEquals(hdrError.getText(), "Please select one or more of the options below");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(hdrError.getText(), "Seleccione una o m\u00E1s de las siguientes opciones");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyDeductionsOptionNoError(){
        basicActions.waitForElementListToDisappear(deductionsAmountError, 10);
        basicActions.waitForElementListToDisappear(deductionsFrequencyError, 10);
        basicActions.waitForElementToDisappear(hdrError, 10);
        softAssert.assertAll();
    }

    public void verifyDeductionsEnteredData(String addtlIncomeOption, String Amount, String Frequency){
//        Frequency will have a number ex: "1: Annually", "3: Monthly", "5: Weekly"
        switch (addtlIncomeOption) {
            case "Domestic production":
                basicActions.waitForElementToBePresent(domesticProductionAmount,20);
                softAssert.assertEquals(domesticProductionAmount.getAttribute("value"), Amount);
                softAssert.assertEquals(domesticProductionFrequency.getAttribute("value"), Frequency);
                softAssert.assertAll();
                break;
            case "School tuition":
                basicActions.waitForElementToBePresent(schoolTuitionAmount,20);
                softAssert.assertEquals(schoolTuitionAmount  .getAttribute("value"), Amount);
                softAssert.assertEquals(schoolTuitionFrequency.getAttribute("value"), Frequency);
                softAssert.assertAll();
                break;
            case "Student loan":
                basicActions.waitForElementToBePresent(studentLoanAmount,20);
                softAssert.assertEquals(studentLoanAmount  .getAttribute("value"), Amount);
                softAssert.assertEquals(studentLoanFrequency.getAttribute("value"), Frequency);
                softAssert.assertAll();
                break;
            case "Pre-tax retirement":
                basicActions.waitForElementToBePresent(pretaxRetirementAmount,20);
                softAssert.assertEquals(pretaxRetirementAmount  .getAttribute("value"), Amount);
                softAssert.assertEquals(pretaxRetirementFrequency.getAttribute("value"), Frequency);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlIncomeOption);
        }
    }
}
