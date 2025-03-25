package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

    @FindBy(css = "div.income-details-left.margin-left-32")
    WebElement incomeName;

    @FindBy(css = "#edit-deductions-button > svg")
    WebElement deductionsEditIcon;

    @FindBy(css = "div.body-text-1.income-details-row.margin-left-32.ng-star-inserted")
    WebElement noDeductionName;

    @FindBy(xpath = "//div[@class='total-income-width']/preceding-sibling::div[1]/div[1]")
    WebElement deductionName;

    @FindBy(css = "div.total-income-width div span")
    WebElement totalAnnualIncome;

    @FindBy(css = "div.total-income-width div em")
    WebElement totalAnnualIncomeDescription;

    @FindBy(css = "div.margin.ng-untouched.ng-pristine.ng-invalid div:nth-child(6) div")
    WebElement projectedIncomeHeader;

    @FindBy(css = "div.row.label-row.ng-star-inserted div label span")
    WebElement projectedIncomeText;

    @FindBy(css = "lib-option-buttons button")
    List<WebElement> projectedIncomeButtons;

    @FindBy(id = "ELIG-summaryDetails-incomeAmountInput")
    WebElement projectedIncomeInput;

    @FindBy(id = "pageId-GoBack")
    WebElement goBackButton;

    @FindBy(id = "pageId-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "ELIG-summaryDetails-NoButton")
    WebElement projectedIncomeNo;

    @FindBy(id = "ELIG-summaryDetails-YesButton")
    WebElement projectedIncomeYes;

    @FindBy(css = "#ELIG-summaryDetails-incomeAmountInput-container > div.row.label-row.ng-star-inserted > div > label")
    WebElement enterProjectedIncomeText;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(css = ".input-error-message lib-fi svg")
    WebElement ErrorIcon;

    @FindBy(css = ".input-error-message span")
    WebElement ErrorMessage;

    @FindBy(xpath = "//lib-fi[@id='edit-deductions-button']//following::div")
    WebElement deductionAmt;

    @FindBy(xpath = "//div[@class='margin-bottom-16 income-details-row']//following::div")
    WebElement totalIncomeAmt;

    @FindBy(xpath = "//div[@class='body-text-1 income-details-row ng-star-inserted']//following-sibling::div")
    WebElement incomeAmtFrmEmployer;

    @FindBy(xpath = "//div[@class='body-text-1 income-details-row margin-top-sm ng-star-inserted']//following-sibling::div")
    WebElement additionaIncomeAmt;

    public void clickprojectedIncomeNo() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBeClickableWithRetries(projectedIncomeNo, 15);
        projectedIncomeNo.click();
        projectedIncomeNo.click();
    }

    public void clickGoBackButton() {
        basicActions.waitForElementToDisappear(spinner, 15);
        basicActions.waitForElementToBeClickableWithRetries(goBackButton, 15);
        goBackButton.click();
    }

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBePresent(hdr_Income, 30);
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueButton, 30);
        saveAndContinueButton.click();
    }

    public void selectProjectedIncome(String projectedIncome) {
        switch (projectedIncome) {
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

    public void enterProjectedIncomeAmountCoCo(String amount) {
        basicActions.waitForElementToBePresent(projectedIncomeInput, 10);
        projectedIncomeInput.sendKeys(amount);
    }

    public void selectEditIcon(String type) {
        basicActions.waitForElementToBePresent(incomeEditIcon, 15);
        switch (type) {
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
    public void verifyHeadersIncomeSummaryPage(String language) {
        switch (language) {
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

    public void verifyHeadersIncomeSummaryPageEnglish() {
        basicActions.wait(500);
        basicActions.waitForElementToBePresentWithRetries(hdr_Income, 60);
        basicActions.waitForElementToBePresentWithRetries(hdr_IncomeSummary, 60);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Income: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()), "Found: " + hdr_Income.getText() + " Expecting: Income: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(hdr_Income.getCssValue("font-size"), "36px");
        softAssert.assertEquals(hdr_Income.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_Income.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(hdr_IncomeSummary.getText(), "Summary");
        softAssert.assertEquals(hdr_IncomeSummary.getCssValue("font-size"), "28px");
        softAssert.assertEquals(hdr_IncomeSummary.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_IncomeSummary.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
    }

    public void verifyHeadersIncomeSummaryPageSpanish() {
        basicActions.wait(250);
        basicActions.waitForElementToBePresentWithRetries(hdr_Income, 60);
        basicActions.waitForElementToBePresentWithRetries(hdr_IncomeSummary, 60);
        String actualText = hdr_Income.getText().replace("\u00A0", " ").trim();
        String expectedText = "Ingresos: " + basicActions.getMemFirstLastNames("Primary").replace("\u00A0", " ").trim();
        softAssert.assertTrue(actualText.equalsIgnoreCase(expectedText), "Header text mismatch! Expected: '" + expectedText + "', but found: '" + actualText + "'");
        softAssert.assertEquals(hdr_Income.getCssValue("font-size"), "36px");
        softAssert.assertEquals(hdr_Income.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_Income.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(hdr_IncomeSummary.getText(), "Resumen");
        softAssert.assertEquals(hdr_IncomeSummary.getCssValue("font-size"), "28px");
        softAssert.assertEquals(hdr_IncomeSummary.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_IncomeSummary.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
    }

    public void verifyTotalAnnualIncome(String Amount) {
        basicActions.waitForElementToBePresentWithRetries(totalAnnualIncome, 15);
        basicActions.waitForElementToDisappear(spinner, 30);
        softAssert.assertTrue(totalAnnualIncome.getText().contains(Amount), "Amount is incorrect");
        softAssert.assertEquals(totalAnnualIncome.getCssValue("font-weight"), "700");
        softAssert.assertEquals(totalAnnualIncome.getCssValue("font-size"), "19px");
        softAssert.assertEquals(totalAnnualIncome.getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertAll();
    }

    public void verifyTotalAnnualIncomeDescription(String language) {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresentWithRetries(totalAnnualIncomeDescription, 15);
        softAssert.assertEquals(totalAnnualIncomeDescription.getCssValue("font-weight"), "400");
        softAssert.assertEquals(totalAnnualIncomeDescription.getCssValue("font-size"), "14px");
        softAssert.assertEquals(totalAnnualIncomeDescription.getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(totalAnnualIncomeDescription.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
        switch (language) {
            case "English":
                softAssert.assertEquals(totalAnnualIncomeDescription.getText(), "Income minus Deductions = Total annual income");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(totalAnnualIncomeDescription.getText(), "Ingreso menos deducciones = Ingreso anual total");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyProjectedIncomeText(String language) {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresentWithRetries(projectedIncomeHeader, 15);
        softAssert.assertEquals(projectedIncomeHeader.getCssValue("font-weight"), "700");
        softAssert.assertEquals(projectedIncomeHeader.getCssValue("font-size"), "19px");
        softAssert.assertEquals(projectedIncomeHeader.getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(projectedIncomeHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(projectedIncomeText.getCssValue("font-weight"), "400");
        softAssert.assertEquals(projectedIncomeText.getCssValue("font-size"), "16px");
        softAssert.assertEquals(projectedIncomeText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(projectedIncomeText.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
        switch (language) {
            case "English":
                softAssert.assertEquals(projectedIncomeHeader.getText(), "Projected Income");
                softAssert.assertEquals(projectedIncomeText.getText(), "Based on the income information you've provided so far, we've calculated your annual income as listed above. Do you expect your income to be different than the amount we calculated above for 2025?");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(projectedIncomeHeader.getText(), "Ingresos que proyecta");
                softAssert.assertEquals(projectedIncomeText.getText(), "\u00bfConforme a la informaci\u00f3n que ha proporcionado, hemos calculado su ingreso anual como se menciona anteriormente. \u00bfEspera que sus ingresos sean diferentes a la cantidad que calculamos anteriormente para 2025?");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyEditIcon() {
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

    public void verifyIncomeName(String income, String language) {
        basicActions.waitForElementToDisappear(spinner, 15);
        basicActions.waitForElementToBeClickable(goBackButton, 30);
        switch (language) {
            case "English":
                verifyIncomeNameEnglish(income);
                break;
            case "Spanish":
                verifyIncomeNameSpanish(income);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyIncomeNameEnglish(String income) {
        basicActions.waitForElementToDisappear(spinner, 15);
        switch (income) {
            case "None":
                softAssert.assertEquals(incomeName.getText(), "No income reported");
                break;
            case "All Jobs/Employers":
                softAssert.assertEquals(incomeName.getText(), "All Jobs/Employers");
                break;
            case "Alimony Received":
                softAssert.assertEquals(incomeName.getText(), "Alimony Received");
                break;
            case "Capital Gains":
                softAssert.assertEquals(incomeName.getText(), "Capital Gains");
                break;
            case "Income from rental property":
                softAssert.assertEquals(incomeName.getText(), "Income from rental property");
                break;
            case "Pension":
                softAssert.assertEquals(incomeName.getText(), "Pension");
                break;
            case "Private Retirement Income":
                softAssert.assertEquals(incomeName.getText(), "Private Retirement Income");
                break;
            case "Income from Social Security":
                softAssert.assertEquals(incomeName.getText(), "Income from Social Security");
                break;
            case "Unemployment Insurance Benefit":
                softAssert.assertEquals(incomeName.getText(), "Unemployment Insurance Benefit");
                break;
            case "Investment Income":
                softAssert.assertEquals(incomeName.getText(), "Investment Income");
                break;
            case "Cash Support":
                softAssert.assertEquals(incomeName.getText(), "Cash Support");
                break;
            case "Untaxed Foreign Income":
                softAssert.assertEquals(incomeName.getText(), "Untaxed Foreign Income");
                break;
            case "Royalty Income":
                softAssert.assertEquals(incomeName.getText(), "Royalty Income");
                break;
            case "Taxable income from Tribal Sources":
                softAssert.assertEquals(incomeName.getText(), "Taxable income from Tribal Sources");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + income);
        }
        softAssert.assertEquals(incomeName.getCssValue("font-size"), "16px");
        softAssert.assertEquals(incomeName.getCssValue("font-weight"), "400");
        softAssert.assertEquals(incomeName.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(incomeName.getCssValue("margin-left"), "32px");
        softAssert.assertAll();
    }

    public void verifyIncomeNameSpanish(String income) {
        basicActions.waitForElementToDisappear(spinner, 15);
        switch (income) {
            case "None":
                softAssert.assertEquals(incomeName.getText(), "No se declara ning\u00fan ingreso");
                break;
            case "All Jobs/Employers":
                softAssert.assertEquals(incomeName.getText(), "Ingresos laborales");
                break;
            case "Alimony Received":
                softAssert.assertEquals(incomeName.getText(), "Pensi\u00f3n alimenticia recibida");
                break;
            case "Capital Gains":
                softAssert.assertEquals(incomeName.getText(), "Ganancias de capital");
                break;
            case "Income from rental property":
                softAssert.assertEquals(incomeName.getText(), "Ingresos por renta de propiedades");
                break;
            case "Pension":
                softAssert.assertEquals(incomeName.getText(), "Pensi\u00f3n");
                break;
            case "Private Retirement Income":
                softAssert.assertEquals(incomeName.getText(), "Ingresos privados por retiro");
                break;
            case "Income from Social Security":
                softAssert.assertEquals(incomeName.getText(), "Ingresos por el Seguro Social");
                break;
            case "Unemployment Insurance Benefit":
                softAssert.assertEquals(incomeName.getText(), "Beneficio del seguro de desempleo");
                break;
            case "Investment Income":
                softAssert.assertEquals(incomeName.getText(), "Ingresos derivados de inversiones");
                break;
            case "Cash Support":
                softAssert.assertEquals(incomeName.getText(), "Apoyo en efectivo");
                break;
            case "Untaxed Foreign Income":
                softAssert.assertEquals(incomeName.getText(), "Ingresos extranjeros no gravados");
                break;
            case "Royalty Income":
                softAssert.assertEquals(incomeName.getText(), "Ingresos por regal\u00edas");
                break;
            case "Taxable income from Tribal Sources":
                softAssert.assertEquals(incomeName.getText(), "Ingresos gravables de origen tribal");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + income);
        }
        softAssert.assertEquals(incomeName.getCssValue("font-size"), "16px");
        softAssert.assertEquals(incomeName.getCssValue("font-weight"), "400");
        softAssert.assertEquals(incomeName.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(incomeName.getCssValue("margin-left"), "32px");
        softAssert.assertAll();
    }

    public void verifyDeductionName(String deduction, String language) {
        basicActions.waitForElementToDisappear(spinner, 15);
        switch (language) {
            case "English":
                verifyDeductionNameEnglish(deduction);
                break;
            case "Spanish":
                verifyDeductionNameSpanish(deduction);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyDeductionNameEnglish(String deduction) {
        basicActions.waitForElementToDisappear(spinner, 15);
        switch (deduction) {
            case "None":
                softAssert.assertEquals(noDeductionName.getText(), "No deductions reported");
                softAssert.assertEquals(noDeductionName.getCssValue("font-size"), "16px");
                softAssert.assertEquals(noDeductionName.getCssValue("font-weight"), "400");
                softAssert.assertEquals(noDeductionName.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(noDeductionName.getCssValue("margin-left"), "32px");
                return;
            case "Alimony or spousal support paid out":
                softAssert.assertEquals(deductionName.getText(), "Alimony or spousal support paid out");
                break;
            case "Domestic production activities":
                softAssert.assertEquals(deductionName.getText(), "Domestic production activities");
                break;
            case "Health Savings Account contribution":
                softAssert.assertEquals(deductionName.getText(), "Health Savings Account contribution");
                break;
            case "Pre-tax retirement account contribution":
                softAssert.assertEquals(deductionName.getText(), "Pre-tax retirement account contribution");
                break;
            case "School tuition and fees":
                softAssert.assertEquals(deductionName.getText(), "School tuition and fees");
                break;
            case "Self-employment tax":
                softAssert.assertEquals(deductionName.getText(), "Self-employment tax");
                break;
            case "Student loan interest":
                softAssert.assertEquals(deductionName.getText(), "Student loan interest");
                break;
            case "Self-employment health insurance":
                softAssert.assertEquals(deductionName.getText(), "Self-employment health insurance");
                break;
            case "Self-employment retirement plan":
                softAssert.assertEquals(deductionName.getText(), "Self-employment retirement plan");
                break;
            case "Moving expenses":
                softAssert.assertEquals(deductionName.getText(), "Moving expenses");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + deduction);
        }
        softAssert.assertEquals(deductionName.getCssValue("font-size"), "16px");
        softAssert.assertEquals(deductionName.getCssValue("font-weight"), "400");
        softAssert.assertEquals(deductionName.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(deductionName.getCssValue("margin-left"), "32px");
        softAssert.assertAll();

    }

    public void verifyDeductionNameSpanish(String deduction) {
        basicActions.waitForElementToDisappear(spinner, 15);
        switch (deduction) {
            case "None":
                softAssert.assertEquals(noDeductionName.getText(), "No se declaran deducciones");
                softAssert.assertEquals(noDeductionName.getCssValue("font-size"), "16px");
                softAssert.assertEquals(noDeductionName.getCssValue("font-weight"), "400");
                softAssert.assertEquals(noDeductionName.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(noDeductionName.getCssValue("margin-left"), "32px");
                return;
            case "Alimony or spousal support paid out":
                softAssert.assertEquals(deductionName.getText(), "Pensi\u00f3n alimenticia o apoyo conyugal que paga");
                break;
            case "Domestic production activities":
                softAssert.assertEquals(deductionName.getText(), "Actividades de producci\u00f3n para el mercado interno");
                break;
            case "Health Savings Account contribution":
                softAssert.assertEquals(deductionName.getText(), "Aporte a cuenta de ahorros de salud");
                break;
            case "Pre-tax retirement account contribution":
                softAssert.assertEquals(deductionName.getText(), "Aporte a la cuenta de retiro antes de impuestos");
                break;
            case "School tuition and fees":
                softAssert.assertEquals(deductionName.getText(), "Colegiatura y cuotas escolares");
                break;
            case "Self-employment tax":
                softAssert.assertEquals(deductionName.getText(), "Impuesto al trabajo independiente");
                break;
            case "Student loan interest":
                softAssert.assertEquals(deductionName.getText(), "Inter\u00e9s por pr\u00e9stamo de estudiante");
                break;
            case "Self-employment health insurance":
                softAssert.assertEquals(deductionName.getText(), "Seguro de salud de trabajador independiente");
                break;
            case "Self-employment retirement plan":
                softAssert.assertEquals(deductionName.getText(), "Plan de retiro como trabajador independiente");
                break;
            case "Moving expenses":
                softAssert.assertEquals(deductionName.getText(), "Gastos de mudanza");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + deduction);
        }
        softAssert.assertEquals(deductionName.getCssValue("font-size"), "16px");
        softAssert.assertEquals(deductionName.getCssValue("font-weight"), "400");
        softAssert.assertEquals(deductionName.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(deductionName.getCssValue("margin-left"), "32px");
        softAssert.assertAll();

    }

    public void verifyProjectedIncomePromptText(String language) {
        basicActions.waitForElementToDisappear(spinner, 15);
        basicActions.waitForElementToBePresent(enterProjectedIncomeText, 15);
        switch (language) {
            case "English":
                softAssert.assertEquals(enterProjectedIncomeText.getText(), "Enter your projected income in 2025.");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(enterProjectedIncomeText.getText(), "Indique los ingresos que proyecta tener en 2025.");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertEquals(enterProjectedIncomeText.getCssValue("font-size"), "16px");
        softAssert.assertEquals(enterProjectedIncomeText.getCssValue("font-weight"), "400");
        softAssert.assertEquals(enterProjectedIncomeText.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(enterProjectedIncomeText.getCssValue("margin-left"), "32px");
        softAssert.assertAll();
    }

    public void verifyErrorFormat(String incomeType) {
        basicActions.waitForElementToBePresent(projectedIncomeNo, 15);
        switch (incomeType) {
            case "Projected Income":
                verifyElementStyles(projectedIncomeYes);
                verifyElementStyles(projectedIncomeNo);
                softAssert.assertAll();
                break;
            case "Income Input":
                verifyElementInputStyles(projectedIncomeInput);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + incomeType);
        }
    }

    public void verifyElementStyles(WebElement element) {
        softAssert.assertEquals(element.getCssValue("border-radius"), "4px", element + " Border radius mismatch");
        softAssert.assertEquals(element.getCssValue("border-color"), "rgb(150, 0, 0)", element + " Border color mismatch");
        softAssert.assertEquals(element.getCssValue("background-color"), "rgba(255, 255, 255, 1)", element + " Background color mismatch");
        softAssert.assertEquals(element.getCssValue("color"), "rgba(150, 0, 0, 1)", element + " Text color mismatch");
        softAssert.assertEquals(element.getCssValue("border"), "2px solid rgb(150, 0, 0)", element + " Border mismatch");
    }

    public void verifyElementInputStyles(WebElement element) {
        softAssert.assertEquals(element.getCssValue("border-radius"), "6px", element + " Border radius mismatch");
        softAssert.assertEquals(element.getCssValue("border-color"), "rgb(150, 0, 0)", element + " Border color mismatch");
        softAssert.assertEquals(element.getCssValue("background-color"), "rgba(255, 255, 255, 1)", element + " Background color mismatch");
        softAssert.assertEquals(element.getCssValue("color"), "rgba(150, 0, 0, 1)", element + " Text color mismatch");
        softAssert.assertEquals(element.getCssValue("border"), "1px solid rgb(150, 0, 0)", element + " Border mismatch");
    }

    public void clickOnProjectedIncomeInputFieldAndClickOutOfIt() {
        basicActions.waitForElementToBePresent(projectedIncomeInput, 15);
        projectedIncomeInput.click();
        projectedIncomeText.click();
    }

    public void validateErrorMessageAndItsProperties(DataTable dataTable) {
        basicActions.waitForElementToBePresent(ErrorIcon, 20);
        basicActions.waitForElementToBePresent(ErrorMessage, 10);

        List<Map<String, String>> data = dataTable.asMaps();
        softAssert.assertTrue(ErrorIcon.isDisplayed(), "Error Icon is not visible in the page");
        softAssert.assertTrue(ErrorMessage.isDisplayed(), "Error Message is not visible in the page");
        softAssert.assertEquals(ErrorMessage.getText(), data.get(0).get("Text"));
        softAssert.assertEquals(ErrorMessage.getCssValue("font-size"), data.get(0).get("fontSize"));
        softAssert.assertEquals(ErrorMessage.getCssValue("font-family"), data.get(0).get("fontFamily"));
        softAssert.assertEquals(ErrorMessage.getCssValue("font-weight"), data.get(0).get("fontWeight"));
        softAssert.assertEquals(ErrorMessage.getCssValue("color"), data.get(0).get("color"));
        softAssert.assertEquals(ErrorMessage.getCssValue("line-height"), data.get(0).get("lineHeight"));
        softAssert.assertEquals(ErrorMessage.getCssValue("text-align"), data.get(0).get("textAlign"));
        softAssert.assertAll();
    }

    public void validateLabelTextAndItsProperties(DataTable dataTable) {
        basicActions.waitForElementToBePresent(enterProjectedIncomeText, 10);

        List<Map<String, String>> data = dataTable.asMaps();
        softAssert.assertTrue(enterProjectedIncomeText.isDisplayed(), "Enter your projected income text is not visible in the page");
        softAssert.assertEquals(enterProjectedIncomeText.getText(), data.get(0).get("Text"));
        softAssert.assertEquals(enterProjectedIncomeText.getCssValue("font-size"), data.get(0).get("fontSize"));
        softAssert.assertEquals(enterProjectedIncomeText.getCssValue("font-family"), data.get(0).get("fontFamily"));
        softAssert.assertEquals(enterProjectedIncomeText.getCssValue("font-weight"), data.get(0).get("fontWeight"));
        softAssert.assertEquals(enterProjectedIncomeText.getCssValue("color"), data.get(0).get("color"));
        softAssert.assertEquals(enterProjectedIncomeText.getCssValue("line-height"), data.get(0).get("lineHeight"));
        softAssert.assertEquals(enterProjectedIncomeText.getCssValue("text-align"), data.get(0).get("textAlign"));
        softAssert.assertAll();
    }

    public void verifyNoErrors() {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(ErrorMessage, 10);
        softAssert.assertFalse(basicActions.waitForElementPresence(ErrorMessage, 10));
        softAssert.assertAll();
    }

    public void verifyDeductionAmount(String amount) {
        basicActions.waitForElementToDisappear(spinner, 30);
        softAssert.assertEquals(deductionAmt.getText(), amount);
        softAssert.assertAll();
    }

    public void verifyIncomeAmountCalculations(String EmploymentIncome, String AdditionalIncome, String DeductionAmt) {
        basicActions.waitForElementToDisappear(spinner, 30);
        double employmentIncome = (Double.parseDouble(EmploymentIncome.replaceAll("[^0-9]", "")))/100;
        double additionalIncome = (Double.parseDouble(AdditionalIncome.replaceAll("[^0-9]", "")))/100;
        double deductionAmount = (Double.parseDouble(DeductionAmt.replaceAll("[^0-9]", "")))/100;
        // Calculate expected total annual income
        double expectedTotalIncome = ((employmentIncome + additionalIncome) - deductionAmount) ;
        // Format as US Dollar currency
        NumberFormat currencyFormatCalculated = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedCalculatedAmount = currencyFormatCalculated.format(expectedTotalIncome);
        // Calculate expected total annual income from UI
        double IncomeFrmEmployerValue = Double.parseDouble(incomeAmtFrmEmployer.getText().replaceAll("[^0-9]", ""));
        double additionaIncomeAmtValue = Double.parseDouble(additionaIncomeAmt.getText().replaceAll("[^0-9]", ""));
        double deductionAmtValue = Double.parseDouble(deductionAmt.getText().replaceAll("[^0-9]", ""));
        double expectedTotalIncomeFromWeb = ((IncomeFrmEmployerValue + additionaIncomeAmtValue) - deductionAmtValue) /100;
        // Format as US Dollar currency
        NumberFormat currencyFormatRetrievd = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedCalculatedAmountFrmWeb = currencyFormatRetrievd.format(expectedTotalIncomeFromWeb);
        softAssert.assertEquals(formattedCalculatedAmountFrmWeb, formattedCalculatedAmount, "Expected Amount Does not Match");
        System.out.println("Expected Income From Web = " + formattedCalculatedAmountFrmWeb + "\nExpected Income Calculated = " + formattedCalculatedAmount);
        softAssert.assertAll();
    }
}
