package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.c4hco.test.automation.utils.SharedData.getFirstName;
import static com.c4hco.test.automation.utils.SharedData.getLastName;


public class AdditionalIncomePage {

    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "AdditionalIncome-SaveAndContinue")
    WebElement saveAndContinueBtn;
    @FindBy(id = "AdditionalIncome-GoBack")
    WebElement backBtn;
    @FindBy(css = ".additional-income-row button")
    List<WebElement> addtlIncomeOptionsCheckbox;
    @FindBy(xpath = "//span[@class='body-text-1']")
    List<WebElement> addtlIncomeOptionsName;
    @FindBy(xpath = "//div[@class='col monetary-input-container']//input")
    List<WebElement> addtlIncomeAmount;
    @FindBy(xpath = "//*[@errormessagekey='amountIsRequired']")
    List<WebElement> addtlIncomeAmountError;
    @FindBy(xpath = "//*[@controlname='frequency']")
    List<WebElement> additlIncomeFrequency;
    @FindBy(xpath = "//*[@errormessagekey='selectOneOptionBelow']//*[@class='error-message']")
    List<WebElement> additlIncomeFrequencyError;
    @FindBy(xpath = "//*[contains(@class, 'header-1')]")
    WebElement hdr_Income;
    @FindBy(xpath = "//*[contains(@class, 'header-2')]")
    WebElement hdr_AdditionalIncome;
    @FindBy(xpath = "//div[contains(@class, 'body-text-1')][1]")
    WebElement txtDoyoureceiveQs_ELMO;
    @FindBy(xpath = "//div[contains(@class, 'body-text-1')][2]")
    WebElement txtSelectAll_ELMO;
    @FindBy(id = "ELIG-AdditionalIncome-CAPG-amountInput")
    WebElement txtCapitalGainsAmount;

    @FindBy(id = "ELIG-AdditionalIncome-CAPG-frequencySelect")
    WebElement selectCAPGFrequency;
    private BasicActions basicActions;
	
    public AdditionalIncomePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public BasicActions getDriver(){
        return BasicActions.getInstance();
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
        }
    }

    public void selectNoneAddtlIncomeOption(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 10);
        addtlIncomeOptionsCheckbox.get(12).click();
        saveAndContinueBtn.click();
    }
        public void clickContinue(){saveAndContinueBtn.click();}

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void verifyTextOnAdditionalIncomeWithErrors(String Language) {
        basicActions.waitForElementToBePresent(saveAndContinueBtn, 10);
        String header = saveAndContinueBtn.getText();
        switch (Language) {
            case "English":
                softAssert.assertEquals(hdr_Income.getText(), "Income: " + getFirstName() + " " + getLastName());
                softAssert.assertEquals(hdr_AdditionalIncome.getText(), "Additional income sources");
                softAssert.assertEquals(txtDoyoureceiveQs_ELMO.getText(), "Did you receive any of the following income?");
                softAssert.assertEquals(txtSelectAll_ELMO.getText(), "Select all that apply, and enter the amount of income received.");
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
                saveAndContinueBtn.click();
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
                break;
            case "Spanish":
                softAssert.assertEquals(hdr_Income.getText(), "Ingresos: " + getFirstName() + " " + getLastName());
                softAssert.assertEquals(hdr_AdditionalIncome.getText(), "Otras fuentes de ingreso");
                softAssert.assertEquals(txtDoyoureceiveQs_ELMO.getText(), "\u00BFRecibi\u00F3 alguno de los ingresos siguientes?");
                softAssert.assertEquals(txtSelectAll_ELMO.getText(), "Seleccione todo lo que corresponda y registre la cantidad de ingreso que recibe.");
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
                saveAndContinueBtn.click();
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
                break;
        }
    }

}
