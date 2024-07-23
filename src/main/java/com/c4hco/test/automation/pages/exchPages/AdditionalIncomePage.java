package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;
import com.c4hco.test.automation.Dto.SharedData;

import java.util.List;


public class AdditionalIncomePage {

    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "AdditionalIncome-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(id = "AdditionalIncome-GoBack")
    WebElement backBtn;

    @FindBy(css = ".additional-income-row button")
    List<WebElement> addtlIncomeOptionsCheckbox;

    @FindBy(css = ".checkbox-description .body-text-1")
    List<WebElement> addtlIncomeOptionsName;

    @FindBy(css = ".monetary-input-container input")
    List<WebElement> addtlIncomeAmount;

    @FindBy(css = "lib-input .error-message")
    List<WebElement> addtlIncomeAmountError;

    @FindBy(css = ".col .form-select")
    List<WebElement> additlIncomeFrequency;

    @FindBy(css = "lib-dropdown .error-message")
    List<WebElement> additlIncomeFrequencyError;

    @FindBy(css = ".header-1")
    WebElement hdr_Income;

    @FindBy(css = ".header-2")
    WebElement hdr_AdditionalIncome;

    @FindBy(css = "lib-list-error .error-message")
    WebElement additlIncomeSelectError;

    @FindBy(css = ".body-text-1")
    List <WebElement> txtAdditionalIncomeText;

    @FindBy(id = "ELIG-AdditionalIncome-CAPG-amountInput")
    WebElement txtCapitalGainsAmount;

    @FindBy(id = "ELIG-AdditionalIncome-IFRP-amountInput")
    WebElement txtIncomeFromRentalPropertyAmount;

    @FindBy(id = "ELIG-AdditionalIncome-PENS-amountInput")
    WebElement txtPrivateRetirementIncomeAmount;

    @FindBy(id = "ELIG-AdditionalIncome-CAPG-frequencySelect")
    WebElement selectCAPGFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-IFRP-frequencySelect")
    WebElement selectIFRPFrequency;
    
    @FindBy(id = "ELIG-AdditionalIncome-PENS-frequencySelect")
    WebElement selectPENSFrequency;

    private BasicActions basicActions;
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    public AdditionalIncomePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void selectAddtlIncomeOption(String addtlIncomeOption, String Amount, String Frequency) {
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 10);

        switch (addtlIncomeOption) {
            case "Capital Gains":
                addtlIncomeOptionsCheckbox.get(1).click();
                basicActions.waitForElementToBeClickable(txtCapitalGainsAmount, 10);
                txtCapitalGainsAmount.sendKeys(Amount);

                Select dropdown = new Select(selectCAPGFrequency);
                dropdown.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Income from rental property":
                addtlIncomeOptionsCheckbox.get(2).click();
                basicActions.waitForElementToBeClickable(txtIncomeFromRentalPropertyAmount, 10);
                txtIncomeFromRentalPropertyAmount.sendKeys(Amount);

                Select dropdown3 = new Select(selectIFRPFrequency);
                dropdown3.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Private Retirement income":
                addtlIncomeOptionsCheckbox.get(4).click();
                basicActions.waitForElementToBeClickable(txtPrivateRetirementIncomeAmount, 10);
                txtPrivateRetirementIncomeAmount.sendKeys(Amount);

                Select dropdown5 = new Select(selectPENSFrequency);
                dropdown5.selectByVisibleText(" " + Frequency + " ");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlIncomeOption);
        }
    }
// TO DO: update below code - seperate clicking on save and continue
    public void selectNoneAddtlIncomeOption(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 10);
        addtlIncomeOptionsCheckbox.get(12).click();
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
    }
    public void clickContinue(){
        basicActions.waitForElementListToBePresent(addtlIncomeOptionsCheckbox, 10);
        basicActions.waitForElementToBePresentWithRetries(hdr_Income, 20);
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueBtn, 20);
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void verifyTextOnAdditionalIncomeWithErrors(String language) {
        basicActions.waitForElementToBePresent(saveAndContinueBtn, 10);
        switch (language) {
            case "English":
                verifyTextOnAdditionalIncomeWithErrorsEnglish();
                break;
            case "Spanish":
                verifyTextOnAdditionalIncomeWithErrorsSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void verifyTextOnAdditionalIncomeWithErrorsEnglish(){
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase( "Income: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_AdditionalIncome.getText(), "Additional income sources");
        softAssert.assertEquals(txtAdditionalIncomeText.get(0).getText(), "Did you receive any of the following income?");
        softAssert.assertEquals(txtAdditionalIncomeText.get(1).getText(), "Select all that apply, and enter the amount of income received.");
        softAssert.assertEquals(addtlIncomeOptionsName.get(0).getText(), "Alimony Received");
        addtlIncomeOptionsCheckbox.get(0).click();
        softAssert.assertEquals(addtlIncomeAmount.get(0).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(0).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        softAssert.assertEquals(addtlIncomeOptionsName.get(1).getText(), "Capital Gains");
        addtlIncomeOptionsCheckbox.get(1).click();
        softAssert.assertEquals(addtlIncomeAmount.get(1).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(1).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        softAssert.assertEquals(addtlIncomeOptionsName.get(2).getText(), "Income from rental property");
        addtlIncomeOptionsCheckbox.get(2).click();
        softAssert.assertEquals(addtlIncomeAmount.get(2).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(2).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        softAssert.assertEquals(addtlIncomeOptionsName.get(3).getText(), "Pension");
        addtlIncomeOptionsCheckbox.get(3).click();
        softAssert.assertEquals(addtlIncomeAmount.get(3).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(3).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        softAssert.assertEquals(addtlIncomeOptionsName.get(4).getText(), "Private Retirement income");
        addtlIncomeOptionsCheckbox.get(4).click();
        softAssert.assertEquals(addtlIncomeAmount.get(4).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(4).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        softAssert.assertEquals(addtlIncomeOptionsName.get(5).getText(), "Income from Social Security");
        addtlIncomeOptionsCheckbox.get(5).click();
        softAssert.assertEquals(addtlIncomeAmount.get(5).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(5).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        softAssert.assertEquals(addtlIncomeOptionsName.get(6).getText(), "Unemployment insurance benefit");
        addtlIncomeOptionsCheckbox.get(6).click();
        softAssert.assertEquals(addtlIncomeAmount.get(6).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(6).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        softAssert.assertEquals(addtlIncomeOptionsName.get(7).getText(), "Investment Income");
        addtlIncomeOptionsCheckbox.get(7).click();
        softAssert.assertEquals(addtlIncomeAmount.get(7).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(7).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        softAssert.assertEquals(addtlIncomeOptionsName.get(8).getText(), "Cash Support");
        addtlIncomeOptionsCheckbox.get(8).click();
        softAssert.assertEquals(addtlIncomeAmount.get(8).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(8).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        softAssert.assertEquals(addtlIncomeOptionsName.get(9).getText(), "Untaxed foreign income");
        addtlIncomeOptionsCheckbox.get(9).click();
        softAssert.assertEquals(addtlIncomeAmount.get(9).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(9).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        softAssert.assertEquals(addtlIncomeOptionsName.get(10).getText(), "Royalty income");
        addtlIncomeOptionsCheckbox.get(10).click();
        softAssert.assertEquals(addtlIncomeAmount.get(10).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(10).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        softAssert.assertEquals(addtlIncomeOptionsName.get(11).getText(), "Taxable income from Tribal Sources");
        addtlIncomeOptionsCheckbox.get(11).click();
        softAssert.assertEquals(addtlIncomeAmount.get(11).getAttribute("placeholder"), "amount");
        softAssert.assertEquals(additlIncomeFrequency.get(11).getText(), "Select Option\nAnnually\nEvery 2 weeks\nMonthly\nTwice a month\nWeekly");
        clickContinue();
        softAssert.assertEquals(addtlIncomeAmountError.get(0).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(0).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeAmountError.get(1).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(1).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeAmountError.get(2).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(2).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeAmountError.get(3).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(3).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeAmountError.get(4).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(4).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeAmountError.get(5).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(5).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeAmountError.get(6).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(6).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeAmountError.get(7).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(7).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeAmountError.get(8).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(8).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeAmountError.get(9).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(9).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeAmountError.get(10).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(10).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeAmountError.get(11).getText(), "Amount is required");
        softAssert.assertEquals(additlIncomeFrequencyError.get(11).getText(), "Please select one of the options below");
        softAssert.assertEquals(addtlIncomeOptionsName.get(12).getText(), "None of these");
        addtlIncomeOptionsCheckbox.get(12).click();
        softAssert.assertEquals(backBtn.getText(), "  Go Back");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and Continue");
        softAssert.assertAll();
    }

    public void verifyTextOnAdditionalIncomeWithErrorsSpanish(){
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_AdditionalIncome.getText(), "Otras fuentes de ingreso");
        softAssert.assertEquals(txtAdditionalIncomeText.get(0).getText(), "\u00BFRecibi\u00F3 alguno de los ingresos siguientes?");
        softAssert.assertEquals(txtAdditionalIncomeText.get(1).getText(), "Seleccione todo lo que corresponda y registre la cantidad de ingreso que recibe.");
        softAssert.assertEquals(addtlIncomeOptionsName.get(0).getText(), "Pensi\u00F3n alimenticia recibida");
        addtlIncomeOptionsCheckbox.get(0).click();
        softAssert.assertEquals(addtlIncomeAmount.get(0).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(0).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        softAssert.assertEquals(addtlIncomeOptionsName.get(1).getText(), "Ganancias de capital");
        addtlIncomeOptionsCheckbox.get(1).click();
        softAssert.assertEquals(addtlIncomeAmount.get(1).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(1).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        softAssert.assertEquals(addtlIncomeOptionsName.get(2).getText(), "Ingresos por renta de propiedades");
        addtlIncomeOptionsCheckbox.get(2).click();
        softAssert.assertEquals(addtlIncomeAmount.get(2).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(2).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        softAssert.assertEquals(addtlIncomeOptionsName.get(3).getText(), "Pensi\u00F3n");
        addtlIncomeOptionsCheckbox.get(3).click();
        softAssert.assertEquals(addtlIncomeAmount.get(3).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(3).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        softAssert.assertEquals(addtlIncomeOptionsName.get(4).getText(), "Ingresos privados por retiro");
        addtlIncomeOptionsCheckbox.get(4).click();
        softAssert.assertEquals(addtlIncomeAmount.get(4).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(4).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        softAssert.assertEquals(addtlIncomeOptionsName.get(5).getText(), "Ingresos por el Seguro Social");
        addtlIncomeOptionsCheckbox.get(5).click();
        softAssert.assertEquals(addtlIncomeAmount.get(5).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(5).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        softAssert.assertEquals(addtlIncomeOptionsName.get(6).getText(), "Beneficio del seguro de desempleo");
        addtlIncomeOptionsCheckbox.get(6).click();
        softAssert.assertEquals(addtlIncomeAmount.get(6).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(6).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        softAssert.assertEquals(addtlIncomeOptionsName.get(7).getText(), "Ingresos derivados de inversiones");
        addtlIncomeOptionsCheckbox.get(7).click();
        softAssert.assertEquals(addtlIncomeAmount.get(7).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(7).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        softAssert.assertEquals(addtlIncomeOptionsName.get(8).getText(), "Apoyo en efectivo");
        addtlIncomeOptionsCheckbox.get(8).click();
        softAssert.assertEquals(addtlIncomeAmount.get(8).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(8).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        softAssert.assertEquals(addtlIncomeOptionsName.get(9).getText(), "Ingresos obtenidos en el extranjero no gravados");
        addtlIncomeOptionsCheckbox.get(9).click();
        softAssert.assertEquals(addtlIncomeAmount.get(9).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(9).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        softAssert.assertEquals(addtlIncomeOptionsName.get(10).getText(), "Ingresos por regal\u00EDas");
        addtlIncomeOptionsCheckbox.get(10).click();
        softAssert.assertEquals(addtlIncomeAmount.get(10).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(10).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        softAssert.assertEquals(addtlIncomeOptionsName.get(11).getText(), "Ingresos gravables de origen tribal");
        addtlIncomeOptionsCheckbox.get(11).click();
        softAssert.assertEquals(addtlIncomeAmount.get(11).getAttribute("placeholder"), "cantidad");
        softAssert.assertEquals(additlIncomeFrequency.get(11).getText(), "Seleccionar opci\u00F3n\nAnualmente\nCada dos semanas\nMensualmente\nDos veces por mes\nSemanalmente");
        clickContinue();
        softAssert.assertEquals(addtlIncomeAmountError.get(0).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(0).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeAmountError.get(1).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(1).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeAmountError.get(2).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(2).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeAmountError.get(3).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(3).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeAmountError.get(4).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(4).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeAmountError.get(5).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(5).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeAmountError.get(6).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(6).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeAmountError.get(7).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(7).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeAmountError.get(8).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(8).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeAmountError.get(9).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(9).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeAmountError.get(10).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(10).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeAmountError.get(11).getText(), "Esta cantidad es obligatoria");
        softAssert.assertEquals(additlIncomeFrequencyError.get(11).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(addtlIncomeOptionsName.get(12).getText(), "Ninguna de las anteriores");
        addtlIncomeOptionsCheckbox.get(12).click();
        softAssert.assertEquals(backBtn.getText(), "  Volver");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertAll();
    }

    public void selectAddtlIncomeOptionOnly(String addtlIncomeOption) {
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 10);
        switch (addtlIncomeOption) {
            case "Alimony Received":
                addtlIncomeOptionsCheckbox.get(0).click();
                break;
            case "Capital Gains":
                addtlIncomeOptionsCheckbox.get(1).click();
                break;
            case "Income from rental property":
                addtlIncomeOptionsCheckbox.get(2).click();
                break;
            case "Pension":
                addtlIncomeOptionsCheckbox.get(3).click();
                break;
            case "Private Retirement income":
                addtlIncomeOptionsCheckbox.get(4).click();
                break;
            case "Income from Social Security":
                addtlIncomeOptionsCheckbox.get(5).click();
                break;
            case "Unemployment insurance benefit":
                addtlIncomeOptionsCheckbox.get(6).click();
                break;
            case "Investment Income":
                addtlIncomeOptionsCheckbox.get(7).click();
                break;
            case "Cash Support":
                addtlIncomeOptionsCheckbox.get(8).click();
                break;
            case "Untaxed foreign income":
                addtlIncomeOptionsCheckbox.get(9).click();
                break;
            case "Royalty income":
                addtlIncomeOptionsCheckbox.get(10).click();
                break;
            case "Taxable income from Tribal Sources":
                addtlIncomeOptionsCheckbox.get(11).click();
                break;
            case "None of these":
                addtlIncomeOptionsCheckbox.get(12).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlIncomeOption);
        }
    }

    public void verifyAddtlIncomeOptionAmt1Error(String language){
        switch (language) {
            case "English":
                verifyAddtlIncomeOptionAmt1ErrorEnglish();
                break;
            case "Spanish":
                verifyAddtlIncomeOptionAmt1ErrorSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyAddtlIncomeOptionAmt1ErrorEnglish(){
        basicActions.waitForElementListToBePresent(addtlIncomeAmountError,20);
        softAssert.assertEquals(addtlIncomeAmountError.get(0).getText(), "Amount is required");
        softAssert.assertAll();
    }

    public void verifyAddtlIncomeOptionAmt1ErrorSpanish(){
        basicActions.waitForElementListToBePresent(addtlIncomeAmountError,20);
        softAssert.assertEquals(addtlIncomeAmountError.get(0).getText(), "Esta cantidad es obligatoria");
        softAssert.assertAll();
    }

    public void verifyAddtlIncomeOptionFreq1Error(String language){
        switch (language) {
            case "English":
                basicActions.waitForElementListToBePresent(addtlIncomeAmountError,20);
                softAssert.assertEquals(additlIncomeFrequencyError.get(0).getText(), "Please select one of the options below");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementListToBePresent(addtlIncomeAmountError,20);
                softAssert.assertEquals(additlIncomeFrequencyError.get(0).getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyAddtlIncomeOptionNoError(){
        basicActions.waitForElementListToDisappear(addtlIncomeAmountError, 10);
        basicActions.waitForElementListToDisappear(additlIncomeFrequencyError, 10);
        softAssert.assertAll();
    }

    public void verifyAddtlIncomeEnteredData(String addtlIncomeOption, String Amount, String Frequency){
//        Frequency will have a number ex: "3: Monthly"
        switch (addtlIncomeOption) {
            case "Private Retirement income":
                basicActions.waitForElementToBePresent(txtPrivateRetirementIncomeAmount,20);
                softAssert.assertEquals(txtPrivateRetirementIncomeAmount.getAttribute("value"), Amount);
                softAssert.assertEquals(selectPENSFrequency.getAttribute("value"), Frequency);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlIncomeOption);
        }
    }

    public void verifyAddtlIncomePageNoError(){
        basicActions.waitForElementToDisappear(additlIncomeSelectError, 10);
        softAssert.assertAll();
    }

    public void verifyAddtlIncomePageError(String language){
        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(additlIncomeSelectError,20);
                softAssert.assertEquals(additlIncomeSelectError.getText(), "Please select one or more of the options below");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(additlIncomeSelectError,20);
                softAssert.assertEquals(additlIncomeSelectError.getText(), "Seleccione una o m\u00E1s de las siguientes opciones");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

}
