package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;
import com.c4hco.test.automation.Dto.SharedData;

import java.util.List;


public class AdditionalIncomePage {

    Actions actions = new Actions(WebDriverManager.getDriver());

    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "AdditionalIncome-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(id = "AdditionalIncome-GoBack")
    WebElement backBtn;

    @FindBy(css = ".additional-income-row button")
    List<WebElement> addtlIncomeOptionsCheckbox;

    @FindBy(css = "lib-checkbox-control span")
    List<WebElement> addtlIncomeOptionsName;

    @FindBy(css = "lib-checkbox-control label")
    List<WebElement> addtlincomeoptionBox;

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

    @FindBy(css = "lib-error-msg > div")
    List<WebElement> hdrError;

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

    @FindBy(css = "lib-help-icon a")
    List<WebElement> helpLnk;

    @FindBy(css = ".help-label")
    WebElement helpSide;

    @FindBy(css = ".drawer-controls > div > div > a > svg")
    WebElement helpCloseSide;

    @FindBy(css = ".drawer-heading .body-text-1")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = ".drawer-heading .drawer-title")
    WebElement helpDrawerHeaderAddtionalIncome;

    @FindBy(css = "div.drawer-text-content.body-text-1 > b")
    List<WebElement> helpDrawerMainHeaders;

    @FindBy(css = ".drawer-text-content.body-text-1")
    WebElement helpDrawerParagraphs;

    @FindBy(css = "div.drawer-text-content.body-text-1 > p")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = "div.drawer-text-content.body-text-1 > ul > li")
    List<WebElement> helpDrawerBodySubParagraphs;

    @FindBy(css = ".drawer-text-content.body-text-1 a")
    WebElement helpDrawerParagraphLink;

    @FindBy(css = "ul > li:nth-child(1) > a")
    WebElement helpDrawerAlimonyRecievedLink;

    @FindBy(css = "ul > li:nth-child(2) > a")
    WebElement helpDrawerCapitalGainsLink;

    @FindBy(css = "ul > li:nth-child(3) > a")
    WebElement helpDrawerIncomeRentalPropertyLink;

    @FindBy(css = "ul > li:nth-child(4) > a")
    WebElement helpDrawerPensionLink;

    @FindBy(css = "ul > li:nth-child(5) > a")
    WebElement helpDrawerPrivateRetirementIncomeLink;

    @FindBy(css = "ul > li:nth-child(6) > a")
    WebElement helpDrawerUnemploymentInsuranceBenefitLink;

    @FindBy(css = "ul > li:nth-child(7) > a")
    WebElement helpDrawerInvestmentIncomeLink;

    @FindBy(css = "ul > li:nth-child(9) > a")
    WebElement helpDrawerUntaxedForeignIncomeLink;

    @FindBy(css = "ul > li:nth-child(10) > a")
    WebElement helpDrawerRoyaltyIncomeLink;

    @FindBy(css = "ul > li:nth-child(11) > a")
    WebElement helpDrawerTitle2IncomeLink;

    @FindBy(css = ".drawer-footer h3")
    WebElement helpDrawerFooter;

    @FindBy(css = ".drawer-footer h3 a")
    WebElement helpDrawerContactUsLink;

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

    public void clickNoneAddtlIncomeOption(){
        basicActions.waitForElementListToBePresent(addtlIncomeOptionsCheckbox, 10);
        addtlIncomeOptionsCheckbox.get(12).click();
    }

    public void clickContinue(){
        basicActions.waitForElementListToBePresent(addtlIncomeOptionsCheckbox, 30);
        basicActions.waitForElementToBePresentWithRetries(hdr_Income, 20);
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueBtn, 20);
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
    }

    public void clickHelpIcon(String label) {
        basicActions.waitForElementListToBePresent(helpLnk, 10);
        switch(label){
            case "Help me understand":
                helpLnk.get(0).click();
                break;
            case "side help":
                helpSide.click();
                break;
            case "close side help":
                helpCloseSide.click();
                break;
            case "Alimony Received":
                helpLnk.get(1).click();
                break;
            case "Capital Gains":
                helpLnk.get(2).click();
                break;
            case "Income from rental property":
                helpLnk.get(3).click();
                break;
            case "Pension":
                helpLnk.get(4).click();
                break;
            case "Private Retirement income":
                helpLnk.get(5).click();
                break;
            case "Income from Social Security":
                helpLnk.get(6).click();
                break;
            case "Unemployment insurance benefit":
                helpLnk.get(7).click();
                break;
            case "Investment Income":
                helpLnk.get(8).click();
                break;
            case "Cash Support":
                helpLnk.get(9).click();
                break;
            case "Untaxed foreign income":
                helpLnk.get(10).click();
                break;
            case "Royalty income":
                helpLnk.get(11).click();
                break;
            case "Taxable income from Tribal Sources":
                helpLnk.get(12).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + label);
        }
    }

    public void clickHelpContactUsNavigation(String lnkName) {
        switch (lnkName){
            case "Contact Us":
                basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
                helpDrawerContactUsLink.click();
                break;
            case "Item":
                basicActions.scrollToElement(helpDrawerParagraphLink);
                helpDrawerParagraphLink.click();
                break;
            case "Alimony Received":
                basicActions.scrollToElement(helpDrawerAlimonyRecievedLink);
                helpDrawerAlimonyRecievedLink.click();
                break;
            case "Capital Gains":
                basicActions.scrollToElement(helpDrawerCapitalGainsLink);
                helpDrawerCapitalGainsLink.click();
                break;
            case "Income from Rental":
                basicActions.scrollToElement(helpDrawerIncomeRentalPropertyLink);
                helpDrawerIncomeRentalPropertyLink.click();
                break;
            case "Pension":
                basicActions.scrollToElement(helpDrawerPensionLink);
                helpDrawerPensionLink.click();
                break;
            case "Private Retirement Income":
                basicActions.scrollToElement(helpDrawerPrivateRetirementIncomeLink);
                helpDrawerPrivateRetirementIncomeLink.click();
                break;
            case "Unemployment Insurance":
                basicActions.scrollToElement(helpDrawerUnemploymentInsuranceBenefitLink);
                helpDrawerUnemploymentInsuranceBenefitLink.click();
                break;
            case "Investment Income":
                basicActions.scrollToElement(helpDrawerInvestmentIncomeLink);
                helpDrawerInvestmentIncomeLink.click();
                break;
            case "Untaxed Foreign Income":
                basicActions.scrollToElement(helpDrawerUntaxedForeignIncomeLink);
                helpDrawerUntaxedForeignIncomeLink.click();
                break;
            case "Royalty Income":
                basicActions.scrollToElement(helpDrawerRoyaltyIncomeLink);
                helpDrawerRoyaltyIncomeLink.click();
                break;
            case "Title II Income":
                basicActions.scrollToElement(helpDrawerTitle2IncomeLink);
                helpDrawerTitle2IncomeLink.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + lnkName);
        }
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void verifyHeadersAdditionalIncomePage(String language){
        switch (language){
            case "English":
                verifyHeadersAdditionalIncomePageEnglish();
                break;
            case "Spanish":
                verifyHeadersAdditionalIncomePageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersAdditionalIncomePageEnglish(){
        basicActions.wait(250);
        basicActions.waitForElementToBePresentWithRetries(hdr_Income,60);
        basicActions.waitForElementToBePresentWithRetries(hdr_AdditionalIncome,60);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase( "Income: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_AdditionalIncome.getText(), "Additional income sources");
        softAssert.assertAll();
    }

    public void verifyHeadersAdditionalIncomePageSpanish(){
        basicActions.waitForElementToBePresent(hdr_Income,15);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_AdditionalIncome.getText(), "Otras fuentes de ingreso");
        softAssert.assertAll();
    }

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
        softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
        softAssert.assertEquals(additlIncomeFrequencyError.get(0).getText(), "Please select one of the options below");
        softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
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
        softAssert.assertEquals(backBtn.getText(), "Go back");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
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
        softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
        softAssert.assertEquals(additlIncomeFrequencyError.get(0).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
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
        softAssert.assertEquals(backBtn.getText(), "Volver");
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

    public void validateHelpVerbiage(String helpText, String language) {
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 30);
        basicActions.waitForElementToBePresent(helpDrawerHeaderAddtionalIncome, 30);
        switch (helpText){
            case "Full":switch (language) {
                case "English":
                    validateGeneralHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateGeneralHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Alimony Received":switch (language) {
                case "English":
                    validateAlimonyReceivedHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateAlimonyReceivedHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Capital Gains":switch (language) {
                case "English":
                    validateCapitalGainsHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateCapitalGainsHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Income from rental property":switch (language) {
                case "English":
                    validateRentalIncomeHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateRentalIncomeHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Pension":switch (language) {
                case "English":
                    validatePensionHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validatePensionHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Private Retirement income":switch (language) {
                case "English":
                    validatePrivateRetirementHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validatePrivateRetirementHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Income from Social Security":switch (language) {
                case "English":
                    validateSocialSecurityHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateSocialSecurityHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Unemployment insurance benefit":switch (language) {
                case "English":
                    validateUnemploymentHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateUnemploymentHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Investment Income":switch (language) {
                case "English":
                    validateInvestmentHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateInvestmentHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Cash Support":switch (language) {
                case "English":
                    validateCashSupportHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateCashSupportHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Untaxed foreign income":switch (language) {
                case "English":
                    validateUntaxedForeignHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateUntaxedForeignHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Royalty income":switch (language) {
                case "English":
                    validateRoyaltyIncomeHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateRoyaltyIncomeHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Taxable income from Tribal Sources":switch (language) {
                case "English":
                    validateTribalSourcesHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateTribalSourcesHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            default:
                throw new IllegalArgumentException("Invalid option: " + helpText);
        }

    }

    public void validateGeneralHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Additions");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Tell us about any additional income this person may receive.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(0).getText(), "Alimony Received\nAmounts received from a spouse or a former spouse under a divorce or separation agreement (including a divorce decree, a separate maintenance decree, or a written separation agreement) may be considered alimony for federal tax purposes. For more information, see:\nhttps://www.irs.gov/taxtopics/tc452\n\nIf your divorce or separation was finalized on or before December 31, 2018, you should include alimony you received in your Additional Income Sources. If your divorce or separation was finalized on or after January 1, 2019, do not include alimony you receive in your Additional Income Sources.");
        softAssert.assertEquals(helpDrawerAlimonyRecievedLink.getText(), "https://www.irs.gov/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(1).getText(), "Capital Gains\nCapital gain is a rise in the value of a capital asset (investment or real estate) that gives it a higher worth than the purchase price. The gain is not realized until the asset is sold. For more information, see:\nhttps://www.irs.gov/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerCapitalGainsLink.getText(), "https://www.irs.gov/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(2).getText(), "Income from Rental Property\nCash or the fair market value of property or services you receive for the use of real estate or personal property is taxable to you as rental income. For more information, see:\nhttps://www.irs.gov/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerIncomeRentalPropertyLink.getText(), "https://www.irs.gov/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(3).getText(), "Pension\nIt is possible that you must report income from pension and annuity plans on your federal income tax return. Any such income that you report on your tax return must be entered here. For more information, see:\nhttps://www.irs.gov/publications/p575");
        softAssert.assertEquals(helpDrawerPensionLink.getText(), "https://www.irs.gov/publications/p575");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(4).getText(), "Private Retirement Income\nPrivate retirement income can include IRAs, 401(k), 403(b), and 457(b) withdrawals and distributions, not Social Security. For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerPrivateRetirementIncomeLink.getText(), "https://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(5).getText(), "Unemployment Insurance Benefit\nUnemployment compensation generally includes any amounts received under the unemployment compensation laws of the United States or of a state, including state unemployment insurance benefits. For more information, see:\nhttps://www.irs.gov/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerUnemploymentInsuranceBenefitLink.getText(), "https://www.irs.gov/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(6).getText(), "Investment Income\nInvestment income includes dividends and other gains as reflected on lines 9 and 14 of 1040, as well as interest income (Line 8). For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerInvestmentIncomeLink.getText(), "https://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(7).getText(), "Cash Support\nIf you receive any income in cash from any source, you must report it here.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(8).getText(), "Untaxed Foreign Income\nForeign earned income is income you receive for services you perform in a foreign country during a period your tax home is in a foreign country and during which you meet either the bona fide residence test or the physical presence test.\nFor more information, see:\nhttps://www.irs.gov/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerUntaxedForeignIncomeLink.getText(), "https://www.irs.gov/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(9).getText(), "Royalty Income\nRoyalty income is a payment received for the use and exploitation of artistic or literary works, patents and mineral rights. For more information, see:\nhttps://www.irs.gov/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerRoyaltyIncomeLink.getText(), "https://www.irs.gov/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(10).getText(), "Title II Income\nTitle II benefits are the monthly benefits that are issued by the Social Security Administration for disability claims. For more information, see:\nhttps://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerTitle2IncomeLink.getText(), "https://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(11).getText(), "Taxable Income from Tribal Sources\nOnly include the taxable portion of income you receive from an American Indian or Alaska Native tribal source. Common types of income include:\n\u2022 Per capita payments from the tribe that come from natural resources, usage rights, leases or royalties.\n\u2022 Payments from natural resources, farming, ranching, fishing, leases, or royalties from land designated as Indian land by the Department of Interior (including reservations and former reservations).\n\u2022 Money from selling things that have cultural significance.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Adiciones");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Indique cualquier ingreso adicional que esta persona pueda recibir.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(0).getText(), "Pensi\u00F3n alimenticia recibida\nCantidades recibidas del c\u00F3nyuge o exc\u00F3nyuge por acuerdo de divorcio o separaci\u00F3n (incluyendo una sentencia de divorcio, una sentencia de separaci\u00F3n por manutenci\u00F3n o un acuerdo de separaci\u00F3n por escrito) pueden ser consideradas pensi\u00F3n alimenticia cuando declare sus impuestos federales sobre los ingresos. Para m\u00E1s informaci\u00F3n visite:\nhttps://www.irs.gov/es/taxtopics/tc452\n\nSi su divorcio o separaci\u00F3n finaliz\u00F3 en o antes del 31 de diciembre de 2018, debe incluir la pensi\u00F3n alimenticia que recibi\u00F3 en sus Otras fuentes de ingreso. Si su divorcio o separaci\u00F3n finaliz\u00F3 en o despu\u00E9s del 1\u00BA de enero de 2019, no incluya la pensi\u00F3n alimenticia que recibi\u00F3 en sus Otras fuentes de ingreso.");
        softAssert.assertEquals(helpDrawerAlimonyRecievedLink.getText(), "https://www.irs.gov/es/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(1).getText(), "Ganancias de capital\nGanancias de capital es un aumento de un bien capital (inversi\u00F3n o bienes ra\u00EDces) que le proporciona un mayor valor al precio de compra. La ganancia se obtiene hasta que se vende la propiedad. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerCapitalGainsLink.getText(), "https://www.irs.gov/es/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(2).getText(), "Ingresos por renta de propiedades\nEl efectivo o valor razonable de mercado de la propiedad o servicios que recibe por el uso del bien o propiedad personal le es sujeto a impuestos como ingreso por rentas. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerIncomeRentalPropertyLink.getText(), "https://www.irs.gov/es/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(3).getText(), "Pensi\u00F3n\nEs posible que deba reportar ingresos por planes de pensi\u00F3n y anualidad en su declaraci\u00F3n de impuestos sobre los ingresos. Cualquier ingreso que reporte en su declaraci\u00F3n de impuestos debe ingresarlo aqu\u00ED. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerPensionLink.getText(), "https://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(4).getText(), "Ingresos privados por retiro\nLos ingresos privados por retiro pueden incluir retiros y aportes a IRA, 401(k), 403(b) y 457(b), no Seguro Social. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerPrivateRetirementIncomeLink.getText(), "https://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(5).getText(), "Beneficio del seguro de desempleo\nLa compensaci\u00F3n por desempleo generalmente incluye cualquier cantidad recibida bajo las leyes de compensaci\u00F3n por desempleo de Estados Unidos o de un estado, incluyendo el seguro de beneficios estatales por desempleo. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerUnemploymentInsuranceBenefitLink.getText(), "https://www.irs.gov/es/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(6).getText(), "Ingresos derivados de inversiones\nLos ingresos derivados de inversiones incluyen los dividendos y otras ganancias, como se reflejan tanto en las l\u00EDneas 9 y 14 del 1040, como en los ingresos por intereses (l\u00EDnea 8). Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p550");
        softAssert.assertEquals(helpDrawerInvestmentIncomeLink.getText(), "https://www.irs.gov/es/publications/p550");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(7).getText(), "Apoyo en efectivo\nSi obtiene un ingreso en efectivo de cualquier fuente, debe reportarlo aqu\u00ED.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(8).getText(), "Ingresos obtenidos en el extranjero no gravados\nEl ingreso extranjero obtenido es ingreso que recibe por servicios otorgados en un pa\u00EDs extranjero durante un per\u00EDodo en el que su residencia fiscal es en un pa\u00EDs extranjero y durante el que cumple ya sea con el criterio de la residencia leg\u00EDtima o de presencia f\u00EDsica. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerUntaxedForeignIncomeLink.getText(), "https://www.irs.gov/es/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(9).getText(), "Ingresos por regal\u00EDas\nEl ingreso por regal\u00EDas es un pago recibido por el uso y utilizaci\u00F3n de trabajos art\u00EDsticos o literarios, derechos de patente y de minerales. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerRoyaltyIncomeLink.getText(), "https://www.irs.gov/es/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(10).getText(), "Ingresos del T\u00EDtulo II\nLos beneficios del T\u00EDtulo II son los beneficios mensuales que emite la Administraci\u00F3n del Seguro Social para reclamos por discapacidad. Para m\u00E1s informaci\u00F3n, ver:\nhttps://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerTitle2IncomeLink.getText(), "https://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(11).getText(), "Ingresos gravables de origen tribal\nIncluya \u00FAnicamente la parte de los ingresos reportados que recibi\u00F3 de origen tribal como ind\u00EDgena norteamericano o nativo de Alaska. Tipos de ingresos comunes son:\n\u2022 Pagos per c\u00E1pita de la tribu proveniente de recursos naturales, derechos de uso, arrendamientos o regal\u00EDas.\n\u2022 Pagos provenientes de recursos naturales, agricultura, ganader\u00EDa, pesca, arrendamientos o regal\u00EDas de tierras designadas como tierras en fideicomiso ind\u00EDgenas por el Departamento del Interior (incluidas reservas ind\u00EDgenas y antiguas reservas ind\u00EDgenas).\n\u2022 Dinero de la venta de patrimonio de significado cultural.");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateAlimonyReceivedHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Alimony Received");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Amounts received from a spouse or a former spouse under a divorce or separation agreement (including a divorce decree, a separate maintenance decree, or a written separation agreement) may be considered alimony for federal tax purposes. For more information, see:\nhttps://www.irs.gov/taxtopics/tc452\n\nIf your divorce or separation was finalized on or before December 31, 2018, you should include alimony you received in your Additional Income Sources. If your divorce or separation was finalized on or after January 1, 2019, do not include alimony you receive in your Additional Income Sources.");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateAlimonyReceivedHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Pensi\u00F3n alimenticia recibida");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Cantidades recibidas del c\u00F3nyuge o exc\u00F3nyuge por acuerdo de divorcio o separaci\u00F3n (incluyendo una sentencia de divorcio, una sentencia de separaci\u00F3n por manutenci\u00F3n o un acuerdo de separaci\u00F3n por escrito) pueden ser consideradas pensi\u00F3n alimenticia cuando declare sus impuestos federales sobre los ingresos. Para m\u00E1s informaci\u00F3n visite:\nhttps://www.irs.gov/es/taxtopics/tc452\n\nSi su divorcio o separaci\u00F3n finaliz\u00F3 en o antes del 31 de diciembre de 2018, debe incluir la pensi\u00F3n alimenticia que recibi\u00F3 en sus Otras fuentes de ingreso. Si su divorcio o separaci\u00F3n finaliz\u00F3 en o despu\u00E9s del 1\u00BA de enero de 2019, no incluya la pensi\u00F3n alimenticia que recibi\u00F3 en sus Otras fuentes de ingreso.");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/taxtopics/tc452");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateCapitalGainsHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Capital Gains");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Capital gain is a rise in the value of a capital asset (investment or real estate) that gives it a higher worth than the purchase price. The gain is not realized until the asset is sold. For more information, see:\nhttps://www.irs.gov/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateCapitalGainsHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ganancias de capital");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Ganancias de capital es un aumento de un bien capital (inversi\u00F3n o bienes ra\u00EDces) que le proporciona un mayor valor al precio de compra. La ganancia se obtiene hasta que se vende la propiedad. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/taxtopics/tc409");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateRentalIncomeHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Income from Rental Property");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Cash or the fair market value of property or services you receive for the use of real estate or personal property is taxable to you as rental income. For more information, see:\nhttps://www.irs.gov/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateRentalIncomeHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos por renta de propiedades");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "El efectivo o valor razonable de mercado de la propiedad o servicios que recibe por el uso del bien o propiedad personal le es sujeto a impuestos como ingreso por rentas. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/taxtopics/tc414");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validatePensionHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Pension");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "It is possible that you must report income from pension and annuity plans on your federal income tax return. Any such income that you report on your tax return must be entered here. For more information, see:\nhttps://www.irs.gov/publications/p575");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/publications/p575");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validatePensionHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Pensi\u00F3n");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Es posible que deba reportar ingresos por planes de pensi\u00F3n y anualidad en su declaraci\u00F3n de impuestos sobre los ingresos. Cualquier ingreso que reporte en su declaraci\u00F3n de impuestos debe ingresarlo aqu\u00ED. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/publications/p575");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validatePrivateRetirementHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Private Retirement Income");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Private retirement income can include IRAs, 401(k), 403(b), and 457(b) withdrawals and distributions, not Social Security. For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validatePrivateRetirementHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos privados por retiro");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Los ingresos privados por retiro pueden incluir retiros y aportes a IRA, 401(k), 403(b) y 457(b), no Seguro Social. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/publications/p575");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateSocialSecurityHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Title II Income");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Title II benefits are the monthly benefits that are issued by the Social Security Administration for disability claims. For more information, see:\nhttps://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateSocialSecurityHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos del T\u00EDtulo II");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Los beneficios del T\u00EDtulo II son los beneficios mensuales que emite la Administraci\u00F3n del Seguro Social para reclamos por discapacidad. Para m\u00E1s informaci\u00F3n, ver:\nhttps://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.disability-benefits-help.org/glossary/title-ii-benefits");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateUnemploymentHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Unemployment Insurance Benefit");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Unemployment compensation generally includes any amounts received under the unemployment compensation laws of the United States or of a state, including state unemployment insurance benefits. For more information, see:\nhttps://www.irs.gov/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateUnemploymentHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Beneficio del seguro de desempleo");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "La compensaci\u00F3n por desempleo generalmente incluye cualquier cantidad recibida bajo las leyes de compensaci\u00F3n por desempleo de Estados Unidos o de un estado, incluyendo el seguro de beneficios estatales por desempleo. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/individuals/employees/unemployment-compensation");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateInvestmentHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Investment Income");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Investment income includes dividends and other gains as reflected on lines 9 and 14 of 1040, as well as interest income (Line 8). For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateInvestmentHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos derivados de inversiones");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Los ingresos derivados de inversiones incluyen los dividendos y otras ganancias, como se reflejan tanto en las l\u00EDneas 9 y 14 del 1040, como en los ingresos por intereses (l\u00EDnea 8). Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p550");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/publications/p550");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateCashSupportHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Cash Support");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "If you receive any income in cash from any source, you must report it here.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateCashSupportHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Apoyo en efectivo");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Si obtiene un ingreso en efectivo de cualquier fuente, debe reportarlo aqu\u00ED.");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateUntaxedForeignHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Untaxed Foreign Income");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Foreign earned income is income you receive for services you perform in a foreign country during a period your tax home is in a foreign country and during which you meet either the bona fide residence test or the physical presence test. For more information, see:\nhttps://www.irs.gov/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateUntaxedForeignHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos obtenidos en el extranjero no gravados");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "El ingreso extranjero obtenido es ingreso que recibe por servicios otorgados en un pa\u00EDs extranjero durante un per\u00EDodo en el que su residencia fiscal es en un pa\u00EDs extranjero y durante el que cumple ya sea con el criterio de la residencia leg\u00EDtima o de presencia f\u00EDsica. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateRoyaltyIncomeHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Royalty Income");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Royalty income is a payment received for the use and exploitation of artistic or literary works, patents and mineral rights. For more information, see:\nhttps://www.irs.gov/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateRoyaltyIncomeHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos por regal\u00EDas");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "El ingreso por regal\u00EDas es un pago recibido por el uso y utilizaci\u00F3n de trabajos art\u00EDsticos o literarios, derechos de patente y de minerales. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/forms-pubs/about-form-1099-misc");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateTribalSourcesHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Taxable Income from Tribal Sources");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Only include the taxable portion of income you receive from an American Indian or Alaska Native tribal source. Common types of income include:\n\u2022 Per capita payments from the tribe that come from natural resources, usage rights, leases or royalties.\n\u2022 Payments from natural resources, farming, ranching, fishing, leases, or royalties from land designated as Indian land by the Department of Interior (including reservations and former reservations).\n\u2022 Money from selling things that have cultural significance.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateTribalSourcesHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos gravables de origen tribal");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Incluya \u00FAnicamente la parte de los ingresos reportados que recibi\u00F3 de origen tribal como ind\u00EDgena norteamericano o nativo de Alaska. Tipos de ingresos comunes son:\n\u2022 Pagos per c\u00E1pita de la tribu proveniente de recursos naturales, derechos de uso, arrendamientos o regal\u00EDas.\n\u2022 Pagos provenientes de recursos naturales, agricultura, ganader\u00EDa, pesca, arrendamientos o regal\u00EDas de tierras designadas como tierras en fideicomiso ind\u00EDgenas por el Departamento del Interior (incluidas reservas ind\u00EDgenas y antiguas reservas ind\u00EDgenas).\n\u2022 Dinero de la venta de patrimonio de significado cultural.");
        basicActions.waitForElementToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter);
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyAddtlIncomeOptionCheckbox(String state){
        switch (state){
            case "Selected":
                verifySelectedStateOfCheckboxes();
                break;
            case "Hover":
                verifyHoverStateOfCheckboxes();
                break;
            case "Focus":
                verifyFocusStateOfCheckboxes();
                break;
            case "Not Selected":
                verifyNotSelectedStateOfCheckboxes();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + state);
        }
    }

    public void verifyNotSelectedStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(addtlIncomeOptionsCheckbox, 15);
        for (int i = 0; i < addtlIncomeOptionsCheckbox.size(); i++) {
            WebElement element1 = addtlIncomeOptionsCheckbox.get(i);
            WebElement element2 = addtlincomeoptionBox.get(i);
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

    public void verifyFocusStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(addtlIncomeOptionsCheckbox, 15);
        for (int i = 0; i < addtlIncomeOptionsCheckbox.size(); i++) {
            WebElement element = addtlIncomeOptionsCheckbox.get(i);
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
            hdr_Income.click();
        }
    }

    public void verifyHoverStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(addtlIncomeOptionsCheckbox, 15);
        for (int i = 0; i < addtlIncomeOptionsCheckbox.size(); i++) {
            WebElement element = addtlIncomeOptionsCheckbox.get(i);
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
            hdr_Income.click();
        }
    }

    public void verifySelectedStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(addtlIncomeOptionsCheckbox, 15);
        for (int i = 0; i < addtlIncomeOptionsCheckbox.size(); i++) {
            WebElement element1 = addtlIncomeOptionsCheckbox.get(i);
            WebElement element2 = addtlincomeoptionBox.get(i);
            element1.click();
            hdr_Income.click();
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
            hdr_Income.click();
        }
    }
    public void clickOnBackButton() {
        basicActions.waitForElementToBePresent(backBtn,20);
        backBtn.click();
    }

}
