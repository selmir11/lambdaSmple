package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.*;
import java.util.*;

import java.util.List;

public class DeductionsCoCoPage {
    private BasicActions basicActions;

    Actions actions = new Actions(WebDriverManager.getDriver());

    SoftAssert softAssert = new SoftAssert();

    public DeductionsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css= ".header-1")
    WebElement hdr_Deductions;

    @FindBy(css= ".header-2")
    WebElement hdr_Deductions2;

    @FindBy(css = "div.parent-position > div:nth-child(1)")
    WebElement expensesQuestion;

    @FindBy(css = "div.parent-position > div:nth-child(2)")
    WebElement selectSentence;

    @FindBy(css = "lib-checkbox-control label")
    List<WebElement> deductionOptionBox;

    @FindBy(css = "app-show-options button")
    List<WebElement> deductionButton;

    @FindBy(css = "#ELIG-Deductions-AOSS-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement alimonyText;

    @FindBy(id = "ELIG-Deductions-AOSS-amountInput")
    WebElement alimonyAmount;

    @FindBy(id = "ELIG-Deductions-AOSS-frequencySelect")
    WebElement alimonyFrequency;

    @FindBy(css = "#ELIG-Deductions-DPAC-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement domesticProductionText;

    @FindBy(id = "ELIG-Deductions-DPAC-amountInput")
    WebElement domesticProductionAmount;

    @FindBy(id = "ELIG-Deductions-DPAC-frequencySelect")
    WebElement domesticProductionFrequency;

    @FindBy(css = "#ELIG-Deductions-HSAC-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement hsaText;

    @FindBy(id = "ELIG-Deductions-HSAC-amountInput")
    WebElement hsaAmount;

    @FindBy(id = "ELIG-Deductions-HSAC-frequencySelect")
    WebElement hsaFrequency;

    @FindBy(css = "#ELIG-Deductions-PRAC-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement pretaxRetirementText;

    @FindBy(id = "ELIG-Deductions-PRAC-amountInput")
    WebElement pretaxRetirementAmount;

    @FindBy(id = "ELIG-Deductions-PRAC-frequencySelect")
    WebElement pretaxRetirementFrequency;

    @FindBy(css = "#ELIG-Deductions-STAF-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement schoolTuitionText;

    @FindBy(id = "ELIG-Deductions-STAF-amountInput")
    WebElement schoolTuitionAmount;

    @FindBy(id = "ELIG-Deductions-STAF-frequencySelect")
    WebElement schoolTuitionFrequency;

    @FindBy(css = "#ELIG-Deductions-SETX-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement selfemploymentTaxText;

    @FindBy(id = "ELIG-Deductions-SETX-amountInput")
    WebElement selfemploymentTaxAmount;

    @FindBy(id = "ELIG-Deductions-SETX-frequencySelect")
    WebElement selfemploymentTaxFrequency;

    @FindBy(css = "#ELIG-Deductions-STLI-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement studentLoanText;

    @FindBy(id = "ELIG-Deductions-STLI-amountInput")
    WebElement studentLoanAmount;

    @FindBy(id = "ELIG-Deductions-STLI-frequencySelect")
    WebElement studentLoanFrequency;

    @FindBy(css = "#ELIG-Deductions-SEHI-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement selfemploymentInsuranceText;

    @FindBy(id = "ELIG-Deductions-SEHI-amountInput")
    WebElement selfemploymentInsuranceAmount;

    @FindBy(id = "ELIG-Deductions-SEHI-frequencySelect")
    WebElement selfemploymentInsuranceFrequency;

    @FindBy(css = "#ELIG-Deductions-SERP-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement selfemploymentRetirementText;

    @FindBy(id = "ELIG-Deductions-SERP-amountInput")
    WebElement selfemploymentRetirementAmount;

    @FindBy(id = "ELIG-Deductions-SERP-frequencySelect")
    WebElement selfemploymentRetirementFrequency;

    @FindBy(css = "#ELIG-Deductions-MOVE-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement movingExpensesText;

    @FindBy(id = "ELIG-Deductions-MOVE-amountInput")
    WebElement movingExpensesAmount;

    @FindBy(id = "ELIG-Deductions-MOVE-frequencySelect")
    WebElement movingExpensesFrequency;

    @FindBy(css = "#ELIG-Deductions-NoDeductions-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement noneOfTheseText;

    @FindBy(css = "lib-error-msg > div")
    List<WebElement> hdrError;

    @FindBy(css = "lib-input .error-message")
    List<WebElement> deductionsAmountError;

    @FindBy(css = "lib-dropdown .error-message")
    List<WebElement> deductionsFrequencyError;

    @FindBy(css = ".input-error-message lib-fi svg")
    WebElement ErrorIcon;

    @FindBy(css = ".error-message")
    WebElement ErrorMessage;

    @FindBy(id = "Deductions-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "Deductions-GoBack")
    WebElement backButton;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(xpath = "//*[name()='svg' and contains(@class, 'feather-alert-circle')]")
    WebElement errorIconCircle;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBePresentWithRetries(hdr_Deductions,60);
        basicActions.waitForElementToBePresentWithRetries(hdr_Deductions2,60);
        basicActions.waitForElementToBePresentWithRetries(saveAndContinueButton, 60);
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

    public void selectDeductionAmountOnly(String deductionOption, String amount) {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 10);

        selectDeductionOptionOnly(deductionOption);
        enterAmount(deductionOption, amount);
    }

    public void selectDeductionOptionOnly(String deductionOption) {
        basicActions.wait(3000);
        basicActions.waitForElementToDisappear(spinner, 15);
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
        optionToIndex.put("All Deductions", -1);

        List<WebElement> updatedDeductionButtons = basicActions.getDriver().findElements(By.cssSelector("app-show-options button"));
        basicActions.waitForElementListToBePresentWithRetries(updatedDeductionButtons, 10);
        if ("All Deductions".equals(deductionOption)) {
            for (int i = 0; i < updatedDeductionButtons.size(); i++) {
                if (i != optionToIndex.get("None of these")) {
                    basicActions.clickElementWithRetries(updatedDeductionButtons.get(i), 5);
                }
            }
        } else {
            Integer index = optionToIndex.get(deductionOption);
            basicActions.clickElementWithRetries(updatedDeductionButtons.get(index), 5);
        }
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
        basicActions.wait(500);
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

    public void verifyAddtlMemHeadersDeductionsPage(String language){
        basicActions.waitForElementToBePresentWithRetries(hdr_Deductions,90);
        basicActions.waitForElementToBePresent(hdr_Deductions2,90);
        basicActions.waitForElementToBePresent(saveAndContinueButton,90);
        basicActions.waitForElementToBePresent(backButton,90);
        switch (language){
            case "English":
                softAssert.assertTrue(hdr_Deductions.getText().equalsIgnoreCase( "Income: " + basicActions.getMemFirstLastNames("Spouse")));
                softAssert.assertEquals(hdr_Deductions.getCssValue("font-size"), "36px");
                softAssert.assertEquals(hdr_Deductions.getCssValue("font-weight"), "700");
                softAssert.assertEquals(hdr_Deductions.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(hdr_Deductions2.getText(), "Deductions");
                softAssert.assertEquals(hdr_Deductions2.getCssValue("font-size"), "28px");
                softAssert.assertEquals(hdr_Deductions2.getCssValue("font-weight"), "700");
                softAssert.assertEquals(hdr_Deductions2.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertTrue(hdr_Deductions.getText().equalsIgnoreCase("Ingresos: " + basicActions.getMemFirstLastNames("Spouse")));
                softAssert.assertEquals(hdr_Deductions.getCssValue("font-size"), "36px");
                softAssert.assertEquals(hdr_Deductions.getCssValue("font-weight"), "700");
                softAssert.assertEquals(hdr_Deductions.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(hdr_Deductions2.getText(), "Deducciones");
                softAssert.assertEquals(hdr_Deductions2.getCssValue("font-size"), "28px");
                softAssert.assertEquals(hdr_Deductions2.getCssValue("font-weight"), "700");
                softAssert.assertEquals(hdr_Deductions2.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersDeductionsPageEnglish(){
        basicActions.waitForElementToBePresentWithRetries(hdr_Deductions,120);
        basicActions.waitForElementToBePresentWithRetries(hdr_Deductions2,120);
        softAssert.assertTrue(hdr_Deductions.getText().equalsIgnoreCase( "Income: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_Deductions.getCssValue("font-size"), "36px");
        softAssert.assertEquals(hdr_Deductions.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_Deductions.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(hdr_Deductions2.getText(), "Deductions");
        softAssert.assertEquals(hdr_Deductions2.getCssValue("font-size"), "28px");
        softAssert.assertEquals(hdr_Deductions2.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_Deductions2.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
    }

    public void verifyHeadersDeductionsPageSpanish(){
        basicActions.waitForElementToBePresentWithRetries(hdr_Deductions,90);
        basicActions.waitForElementToBePresentWithRetries(hdr_Deductions2,90);
        basicActions.waitForElementToBePresentWithRetries(saveAndContinueButton,90);
        basicActions.waitForElementToBePresentWithRetries(backButton,90);
        softAssert.assertTrue(hdr_Deductions.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_Deductions.getCssValue("font-size"), "36px");
        softAssert.assertEquals(hdr_Deductions.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_Deductions.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(hdr_Deductions2.getText(), "Deducciones");
        softAssert.assertEquals(hdr_Deductions2.getCssValue("font-size"), "28px");
        softAssert.assertEquals(hdr_Deductions2.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_Deductions2.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
    }

    public void verifyDeductionsOptionAmtError(String language){
        switch (language) {
            case "English":
                basicActions.waitForElementListToBePresent(deductionsAmountError,20);
                softAssert.assertEquals(deductionsAmountError.get(0).getText(), "Amount is required");
                softAssert.assertEquals(hdrError.get(1).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementListToBePresent(deductionsAmountError,20);
                softAssert.assertEquals(deductionsAmountError.get(0).getText(), "Esta cantidad es obligatoria");
                softAssert.assertEquals(hdrError.get(1).getCssValue("margin"), "2px 0px 4px");
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
                softAssert.assertEquals(hdrError.get(1).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementListToBePresent(deductionsFrequencyError,20);
                softAssert.assertEquals(deductionsFrequencyError.get(0).getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(hdrError.get(1).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyDeductionsOptionHdrError(String language){
        basicActions.waitForElementListToBePresent(hdrError,20);
        switch (language) {
            case "English":
                softAssert.assertEquals(hdrError.get(0).getText(), "Please select one or more of the options below");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(hdrError.get(0).getText(), "Seleccione una o m\u00E1s de las siguientes opciones");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyDeductionsOptionNoError(){
        basicActions.waitForElementListToDisappear(deductionsAmountError, 10);
        basicActions.waitForElementListToDisappear(deductionsFrequencyError, 10);
        basicActions.waitForElementListToDisappear(hdrError, 10);
        softAssert.assertAll();
    }

    public void verifyDeductionsEnteredData(String deductionsOption, String Amount, String Frequency){
//        Frequency will have a number ex: "1: Annually", "3: Monthly", "5: Weekly"
        WebElement inputAmount = getDeductionInputField(deductionsOption);
        WebElement inputFrequency = getDeductionFrequencyField(deductionsOption);
        basicActions.waitForElementToBePresent(inputAmount,20);
        softAssert.assertEquals(inputAmount.getAttribute("value"), Amount);
        softAssert.assertEquals(inputFrequency.getAttribute("value"), Frequency);
        softAssert.assertAll();
    }

    public void verifyDeductionsText(String language){
        basicActions.waitForElementToBePresent(expensesQuestion,20);
        switch (language) {
            case "English":
                softAssert.assertEquals(expensesQuestion.getText(), "Do you have any of the following expenses?");
                softAssert.assertEquals(expensesQuestion.getCssValue("font-weight"), "700");
                softAssert.assertEquals(expensesQuestion.getCssValue("font-size"), "16px");
                softAssert.assertEquals(expensesQuestion.getCssValue("line-height"), "28px");
                softAssert.assertEquals(expensesQuestion.getCssValue("color"), "rgba(43, 49, 60, 1)");
                softAssert.assertEquals(selectSentence.getText(), "Select all that apply, and enter the amount of each expense.");
                softAssert.assertEquals(alimonyText.getText(), "Alimony or spousal support paid out");
                softAssert.assertEquals(domesticProductionText.getText(), "Domestic production activities");
                softAssert.assertEquals(hsaText.getText(), "Health Savings Account contribution");
                softAssert.assertEquals(pretaxRetirementText.getText(), "Pre-tax retirement account contribution");
                softAssert.assertEquals(schoolTuitionText.getText(), "School tuition and fees");
                softAssert.assertEquals(selfemploymentTaxText.getText(), "Self-employment tax");
                softAssert.assertEquals(studentLoanText.getText(), "Student loan interest");
                softAssert.assertEquals(selfemploymentInsuranceText.getText(), "Self-employment health insurance");
                softAssert.assertEquals(selfemploymentRetirementText.getText(), "Self-employment retirement plan");
                softAssert.assertEquals(movingExpensesText.getText(), "Moving expenses");
                softAssert.assertEquals(noneOfTheseText.getText(), "None of these");
                softAssert.assertAll();
                verifyBaseTextFormatting(selectSentence);
                verifyBaseTextFormatting(alimonyText);
                verifyBaseTextFormatting(domesticProductionText);
                verifyBaseTextFormatting(hsaText);
                verifyBaseTextFormatting(pretaxRetirementText);
                verifyBaseTextFormatting(schoolTuitionText);
                verifyBaseTextFormatting(selfemploymentTaxText);
                verifyBaseTextFormatting(studentLoanText);
                verifyBaseTextFormatting(selfemploymentInsuranceText);
                verifyBaseTextFormatting(selfemploymentRetirementText);
                verifyBaseTextFormatting(movingExpensesText);
                verifyBaseTextFormatting(noneOfTheseText);
                break;
            case "Spanish":
                softAssert.assertEquals(expensesQuestion.getText(), "\u00bfTiene alguno de los siguientes gastos?");
                softAssert.assertEquals(expensesQuestion.getCssValue("font-weight"), "700");
                softAssert.assertEquals(expensesQuestion.getCssValue("font-size"), "16px");
                softAssert.assertEquals(expensesQuestion.getCssValue("line-height"), "28px");
                softAssert.assertEquals(expensesQuestion.getCssValue("color"), "rgba(43, 49, 60, 1)");
                softAssert.assertEquals(selectSentence.getText(), "Seleccione todos los que correspondan, e ingrese la cantidad de cada gasto.");
                softAssert.assertEquals(alimonyText.getText(), "Pensi\u00f3n alimenticia o apoyo conyugal que paga");
                softAssert.assertEquals(domesticProductionText.getText(), "Actividades de producci\u00f3n para el mercado interno");
                softAssert.assertEquals(hsaText.getText(), "Aporte a cuenta de ahorros de salud");
                softAssert.assertEquals(pretaxRetirementText.getText(), "Aporte a la cuenta de retiro antes de impuestos");
                softAssert.assertEquals(schoolTuitionText.getText(), "Colegiatura y cuotas escolares");
                softAssert.assertEquals(selfemploymentTaxText.getText(), "Impuesto al trabajo independiente");
                softAssert.assertEquals(studentLoanText.getText(), "Inter\u00e9s por pr\u00e9stamo de estudiante");
                softAssert.assertEquals(selfemploymentInsuranceText.getText(), "Seguro de salud de trabajador independiente");
                softAssert.assertEquals(selfemploymentRetirementText.getText(), "Plan de retiro como trabajador independiente");
                softAssert.assertEquals(movingExpensesText.getText(), "Gastos de mudanza");
                softAssert.assertEquals(noneOfTheseText.getText(), "Ninguna de las anteriores");
                softAssert.assertAll();
                verifyBaseTextFormatting(selectSentence);
                verifyBaseTextFormatting(alimonyText);
                verifyBaseTextFormatting(domesticProductionText);
                verifyBaseTextFormatting(hsaText);
                verifyBaseTextFormatting(pretaxRetirementText);
                verifyBaseTextFormatting(schoolTuitionText);
                verifyBaseTextFormatting(selfemploymentTaxText);
                verifyBaseTextFormatting(studentLoanText);
                verifyBaseTextFormatting(selfemploymentInsuranceText);
                verifyBaseTextFormatting(selfemploymentRetirementText);
                verifyBaseTextFormatting(movingExpensesText);
                verifyBaseTextFormatting(noneOfTheseText);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyBaseTextFormatting(WebElement BaseText){
        softAssert.assertEquals(BaseText.getCssValue("font-weight"), "400");
        softAssert.assertEquals(BaseText.getCssValue("font-size"), "16px");
        softAssert.assertEquals(BaseText.getCssValue("line-height"), "28px");
        softAssert.assertEquals(BaseText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertAll();
    }

    public void verifyDeductionsNavigationButtons(String language){
        basicActions.waitForElementToBePresent(backButton, 15);
        switch (language) {
            case ("English"):
                softAssert.assertEquals(backButton.getText(), "Go back");
                softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(backButton.getCssValue("line-height"), "32px");
                softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
                softAssert.assertEquals(backButton.getCssValue("background-color"), "rgba(252, 252, 252, 1)");
                softAssert.assertEquals(saveAndContinueButton.getText(), "Save and continue");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("line-height"), "32px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("color"), "rgba(252, 252, 252, 1)");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
                softAssert.assertAll();
                break;
            case ("Spanish"):
                softAssert.assertEquals(backButton.getText(), "Volver");
                softAssert.assertEquals(backButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(backButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(backButton.getCssValue("line-height"), "32px");
                softAssert.assertEquals(backButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
                softAssert.assertEquals(backButton.getCssValue("background-color"), "rgba(252, 252, 252, 1)");
                softAssert.assertEquals(saveAndContinueButton.getText(), "Guardar y continuar");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("line-height"), "32px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("color"), "rgba(252, 252, 252, 1)");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyDeductionsOptionCheckboxCOCO(String state){
        switch (state){
            case "Selected":
                verifySelectedStateOfCheckboxesCOCO();
                break;
            case "Hover":
                verifyHoverStateOfCheckboxesCOCO();
                break;
            case "Focus":
                verifyFocusStateOfCheckboxesCOCO();
                break;
            case "Not Selected":
                verifyNotSelectedStateOfCheckboxesCOCO();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + state);
        }
    }

    public void verifyNotSelectedStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresentWithRetries(deductionButton, 15);
        for (int i = 0; i < deductionButton.size(); i++) {
            WebElement element1 = deductionButton.get(i);
            WebElement element2 = deductionOptionBox.get(i);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(55, 55, 55)");
            softAssert.assertAll();
        }
    }

    public void verifyFocusStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresent(deductionButton, 15);
        for (int i = 0; i < deductionButton.size(); i++) {
            WebElement element = deductionButton.get(i);
            element.sendKeys(Keys.SHIFT);
            basicActions.wait(300);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element.getCssValue("box-shadow"), "rgb(112, 163, 0) 0px 0px 7px 3px");
            softAssert.assertAll();
            hdr_Deductions.click();
        }
    }

    public void verifyHoverStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresent(deductionButton, 15);
        for (int i = 0; i < deductionButton.size(); i++) {
            WebElement element = deductionButton.get(i);
            actions.moveToElement(element).perform();
            basicActions.wait(300);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertAll();
            hdr_Deductions.click();
        }
    }

    public void verifySelectedStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresent(deductionButton, 15);
        for (int i = 0; i < deductionButton.size(); i++) {
            WebElement element1 = deductionButton.get(i);
            WebElement element2 = deductionOptionBox.get(i);
            element1.click();
            hdr_Deductions.click();
            basicActions.wait(300);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container checked"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(112, 163, 0, 1)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(112, 163, 0)");
            softAssert.assertAll();
            element1.click();
            hdr_Deductions.click();
        }
    }

    public void verifyErrorFormat(String incomeType) {
        basicActions.waitForElementToBePresent(hdr_Deductions2, 15);
        WebElement elementAmount;
        WebElement elementFrequency;
        switch (incomeType) {
            case "Alimony Received":
                elementAmount = alimonyAmount;
                elementFrequency = alimonyFrequency;
                break;
            case "Domestic production activities":
                elementAmount = domesticProductionAmount;
                elementFrequency = domesticProductionFrequency;
                break;
            case "HSA":
                elementAmount = hsaAmount;
                elementFrequency = hsaFrequency;
                break;
            case "Pre-tax retirement":
                elementAmount = pretaxRetirementAmount;
                elementFrequency = pretaxRetirementFrequency;
                break;
            case "School tuition":
                elementAmount = schoolTuitionAmount;
                elementFrequency = schoolTuitionFrequency;
                break;
            case "Self-employment tax":
                elementAmount = selfemploymentTaxAmount;
                elementFrequency = selfemploymentTaxFrequency;
                break;
            case "Student loan":
                elementAmount = studentLoanAmount;
                elementFrequency = studentLoanFrequency;
                break;
            case "Self-employment health insurance":
                elementAmount = selfemploymentInsuranceAmount;
                elementFrequency = selfemploymentInsuranceFrequency;
                break;
            case "Self-employment retirement":
                elementAmount = selfemploymentRetirementAmount;
                elementFrequency = selfemploymentRetirementFrequency;
                break;
            case "Moving expenses":
                elementAmount = movingExpensesAmount;
                elementFrequency = movingExpensesFrequency;
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + incomeType);
        }
        verifyElementStyles(elementAmount);
        verifyElementStyles(elementFrequency);
        softAssert.assertAll();
    }

    public void verifyElementStyles(WebElement element) {
        softAssert.assertEquals(element.getCssValue("border-radius"), "6px", element + " Border radius mismatch");
        softAssert.assertEquals(element.getCssValue("border-color"), "rgb(150, 0, 0)", element + " Border color mismatch");
        softAssert.assertEquals(element.getCssValue("background-color"), "rgba(255, 255, 255, 1)", element + " Background color mismatch");
        softAssert.assertEquals(element.getCssValue("color"), "rgba(150, 0, 0, 1)", element + " Text color mismatch");
        softAssert.assertEquals(element.getCssValue("border"), "1px solid rgb(150, 0, 0)", element + " Border mismatch");
    }

    public void validateErrorMessageAndItsProperties(DataTable dataTable){
        basicActions.waitForElementToBePresent(ErrorIcon,10);
        basicActions.waitForElementToBePresent(ErrorMessage,10);

        List<Map<String,String>> data = dataTable.asMaps();
        softAssert.assertTrue(ErrorIcon.isDisplayed(),"Error Icon is not visible in the page");
        softAssert.assertTrue(ErrorMessage.isDisplayed(),"Error Message is not visible in the page");
        softAssert.assertEquals(ErrorMessage.getText(), data.get(0).get("Text"));
        softAssert.assertEquals(ErrorMessage.getCssValue("font-size"), data.get(0).get("fontSize"));
        softAssert.assertEquals(ErrorMessage.getCssValue("font-family"), data.get(0).get("fontFamily"));
        softAssert.assertEquals(ErrorMessage.getCssValue("font-weight"), data.get(0).get("fontWeight"));
        softAssert.assertEquals(ErrorMessage.getCssValue("color"), data.get(0).get("color"));
        softAssert.assertAll();
    }

    private WebElement getDeductionInputField(String deductionsOption) {
        switch (deductionsOption) {
            case "Alimony":
                return alimonyAmount;
            case "Domestic production":
                return domesticProductionAmount;
            case "HSA":
                return hsaAmount;
            case "Pre-tax retirement":
                return pretaxRetirementAmount;
            case "School tuition":
                return schoolTuitionAmount;
            case "Self-employment tax":
                return selfemploymentTaxAmount;
            case "Student loan":
                return studentLoanAmount;
            case "Self-employment health insurance":
                return selfemploymentInsuranceAmount;
            case "Self-employment retirement":
                return selfemploymentRetirementAmount;
            case "Moving expenses":
                return movingExpensesAmount;
            default:
                throw new IllegalArgumentException("Invalid option: " + deductionsOption);
        }
    }

    private WebElement getDeductionFrequencyField(String deductionsOption) {
        switch (deductionsOption) {
            case "Alimony":
                return alimonyFrequency;
            case "Domestic production":
                return domesticProductionFrequency;
            case "HSA":
                return hsaFrequency;
            case "Pre-tax retirement":
                return pretaxRetirementFrequency;
            case "School tuition":
                return schoolTuitionFrequency;
            case "Self-employment tax":
                return selfemploymentTaxFrequency;
            case "Student loan":
                return studentLoanFrequency;
            case "Self-employment health insurance":
                return selfemploymentInsuranceFrequency;
            case "Self-employment retirement":
                return selfemploymentRetirementFrequency;
            case "Moving expenses":
                return movingExpensesFrequency;
            default:
                throw new IllegalArgumentException("Invalid option: " + deductionsOption);
        }
    }

    public void verifyMinMax(String deductionsOption, String language){
        WebElement inputAmount = getDeductionInputField(deductionsOption);
        String amountPlaceholder = language.equalsIgnoreCase("Spanish") ? "cantidad" : "amount";
        basicActions.waitForElementToBePresent(inputAmount,10);
        softAssert.assertEquals(inputAmount.getAttribute("min"), "0.01");
        softAssert.assertEquals(inputAmount.getAttribute("max"), "999999999.99");
        softAssert.assertEquals(inputAmount.getAttribute("placeholder"), amountPlaceholder);
        softAssert.assertAll();
    }

    public void verifyErrorIcon(String errorLine) {

        switch (errorLine) {
            case "Amount is required":
                basicActions.waitForElementToBePresent(errorIconCircle, 10);
                softAssert.assertEquals(errorIconCircle.getAttribute("width"), "24");
                softAssert.assertEquals(errorIconCircle.getAttribute("height"), "24");
                softAssert.assertEquals(errorIconCircle.getAttribute("stroke-width"), "2");
                softAssert.assertEquals(errorIconCircle.getAttribute("stroke-linecap"), "round");
        }
        softAssert.assertAll();
    }
}
