package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
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
import java.util.Map;


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

    @FindBy(id = "ELIG-AdditionalIncome-ALMR-amountInput")
    WebElement txtAlimonyReceivedAmount;

    @FindBy(id = "ELIG-AdditionalIncome-CAPG-amountInput")
    WebElement txtCapitalGainsAmount;

    @FindBy(id = "ELIG-AdditionalIncome-IFRP-amountInput")
    WebElement txtIncomeFromRentalPropertyAmount;

    @FindBy(id = "ELIG-AdditionalIncome-PENS-amountInput")
    WebElement txtPrivateRetirementIncomeAmount;

    @FindBy(id = "ELIG-AdditionalIncome-ALMR-frequencySelect")
    WebElement selectALMRFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-CAPG-frequencySelect")
    WebElement selectCAPGFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-IFRP-frequencySelect")
    WebElement selectIFRPFrequency;
    
    @FindBy(id = "ELIG-AdditionalIncome-PENS-frequencySelect")
    WebElement selectPENSFrequency;

    @FindBy(css = "lib-help-icon a")
    List<WebElement> helpLnk;

    @FindBy(id = "Help.Button")
    WebElement helpSide;

    @FindBy(css = ".header-close-link")
    WebElement helpCloseLink;

    @FindBy(css = ".title-row .c4-text-body-200")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = ".title-row .title")
    WebElement helpDrawerHeaderAddtionalIncome;

    @FindBy(css = ".c4-text-body-200")
    List<WebElement> helpDrawerHeaders;

    @FindBy(css = "div.section-help-content-container > p")
    List<WebElement> helpDrawerNewParagraphs;

    @FindBy(css = "div.help-main-content > p")
    WebElement helpDrawerNewIconsParagraphs;

    @FindBy(css = "div.section-help-content-inner-container > span")
    WebElement helpParagraphUnderTaxableIncomeHeader;

    @FindBy(css = "div.section-help-content-inner-container > ul")
    WebElement helpListUnderTaxableIncomeHeader;

    @FindBy(css = "lib-help-window-link > a")
    List<WebElement> helpDrawerBodyNewLinks;
    @FindBy(css = ".help-footer .c4-type-links-md")
    List<WebElement> helpDrawerFooter;

    @FindBy(css = ".help-footer .clickable")
    WebElement helpDrawerContactUsLink;

    @FindBy(css = ".error-message")
    List<WebElement> ActiveErrorMessage;

    @FindBy(css = ".error-icon .error-icon")
    List<WebElement> ActiveErrorIcon;

    @FindBy(xpath = "//input[@type='text']")
    WebElement ActiveInputTextField;

    @FindBy(id = "ELIG-AdditionalIncome-PENS-amountInput")
    WebElement txtPensionIncomeAmount;

    @FindBy(id = "ELIG-AdditionalIncome-RETR-amountInput")
    WebElement txtPrivateRetrIncomeAmount;

    @FindBy(id = "ELIG-AdditionalIncome-RETR-frequencySelect")
    WebElement selectRETRFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-TTWI-amountInput")
    WebElement txtSocialSecurityIncome;

    @FindBy(id = "ELIG-AdditionalIncome-TTWI-frequencySelect")
    WebElement selectTTWIFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-UNEP-amountInput")
    WebElement txtUnemploymentInsuranceBenefitIncome;

    @FindBy(id = "ELIG-AdditionalIncome-UNEP-frequencySelect")
    WebElement selectUNEPFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-INVI-amountInput")
    WebElement txtInvestmentIncome;

    @FindBy(id = "ELIG-AdditionalIncome-INVI-frequencySelect")
    WebElement selectINVIFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-CASP-amountInput")
    WebElement txtCashSupportIncome;

    @FindBy(id = "ELIG-AdditionalIncome-CASP-frequencySelect")
    WebElement selectCASPFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-UTFI-amountInput")
    WebElement txtUntaxedForeignIncome;

    @FindBy(id = "ELIG-AdditionalIncome-UTFI-frequencySelect")
    WebElement selectUTFIFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-RLTI-amountInput")
    WebElement txtRoyaltyIncomeAmount;

    @FindBy(id = "ELIG-AdditionalIncome-RLTI-frequencySelect")
    WebElement selectRLTIFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-TRBI-amountInput")
    WebElement txtTaxableIncomeFromTribalSourcesAmount;

    @FindBy(id = "ELIG-AdditionalIncome-TRBI-frequencySelect")
    WebElement selectTRBIFrequency;

    @FindBy(xpath = "//hr")
    WebElement horizontalLine;

    @FindBy(css = "#ELIG-AdditionalIncome-ALMR-amountInput")
    WebElement txtBoxAlimonyReceivedAmount;

    @FindBy(xpath = "//*[name()='svg' and @class='feather feather-dollar-sign']")
    WebElement dollarSymbol;

    @FindBy(xpath = "//label[@class='checkbox-container checked']")
    List<WebElement> checkBoxChecked;

    @FindBy(xpath = "//lib-button")
    List<WebElement> btnOutlineBackAndSave;

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
            case "Alimony Received":
                addtlIncomeOptionsCheckbox.get(0).click();
                basicActions.waitForElementToBeClickable(txtAlimonyReceivedAmount, 10);
                txtAlimonyReceivedAmount.sendKeys(Amount);

                Select dropdown1 = new Select(selectALMRFrequency);
                dropdown1.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Private Retirement Income":
                addtlIncomeOptionsCheckbox.get(4).click();
                basicActions.waitForElementToBeClickable(txtPrivateRetrIncomeAmount, 10);
                txtPrivateRetrIncomeAmount.sendKeys(Amount);

                Select dropdown51 = new Select(selectRETRFrequency);
                dropdown51.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Income from Social Security":
                addtlIncomeOptionsCheckbox.get(5).click();
                basicActions.waitForElementToBeClickable(txtSocialSecurityIncome, 10);
                txtSocialSecurityIncome.sendKeys(Amount);

                Select dropdown6 = new Select(selectTTWIFrequency);
                dropdown6.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Unemployment insurance benefit":
                addtlIncomeOptionsCheckbox.get(6).click();
                basicActions.waitForElementToBeClickable(txtUnemploymentInsuranceBenefitIncome, 10);
                txtUnemploymentInsuranceBenefitIncome.sendKeys(Amount);

                Select dropdown7 = new Select(selectUNEPFrequency);
                dropdown7.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Investment Income":
                addtlIncomeOptionsCheckbox.get(7).click();
                basicActions.waitForElementToBeClickable(txtInvestmentIncome, 10);
                txtInvestmentIncome.sendKeys(Amount);

                Select dropdown8 = new Select(selectINVIFrequency);
                dropdown8.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Cash Support":
                addtlIncomeOptionsCheckbox.get(8).click();
                basicActions.waitForElementToBeClickable(txtCashSupportIncome, 10);
                txtCashSupportIncome.sendKeys(Amount);

                Select dropdown9 = new Select(selectCASPFrequency);
                dropdown9.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Untaxed foreign income":
                addtlIncomeOptionsCheckbox.get(9).click();
                basicActions.waitForElementToBeClickable(txtUntaxedForeignIncome, 10);
                txtUntaxedForeignIncome.sendKeys(Amount);

                Select dropdown10 = new Select(selectUTFIFrequency);
                dropdown10.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Royalty income":
                addtlIncomeOptionsCheckbox.get(10).click();
                basicActions.waitForElementToBeClickable(txtRoyaltyIncomeAmount, 10);
                txtRoyaltyIncomeAmount.sendKeys(Amount);

                Select dropdown11 = new Select(selectRLTIFrequency);
                dropdown11.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Taxable income from Tribal Sources":
                addtlIncomeOptionsCheckbox.get(11).click();
                basicActions.waitForElementToBeClickable(txtTaxableIncomeFromTribalSourcesAmount, 10);
                txtTaxableIncomeFromTribalSourcesAmount.sendKeys(Amount);

                Select dropdown12 = new Select(selectTRBIFrequency);
                dropdown12.selectByVisibleText(" " + Frequency + " ");
                break;
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
            case "Pension":
                addtlIncomeOptionsCheckbox.get(3).click();
                basicActions.waitForElementToBeClickable(txtPensionIncomeAmount, 10);
                txtPrivateRetirementIncomeAmount.sendKeys(Amount);

                Select dropdown4 = new Select(selectPENSFrequency);
                dropdown4.selectByVisibleText(" " + Frequency + " ");
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
        basicActions.wait(250);
        basicActions.waitForElementListToBePresent(helpLnk, 10);
        switch(label){
            case "Help me understand":
                basicActions.waitForElementToBeClickableWithRetries(helpLnk.get(0), 20);
                helpLnk.get(0).click();
                break;
            case "side help":
                helpSide.click();
                break;
            case "close help":
                helpCloseLink.click();
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
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerContactUsLink, 10);
                helpDrawerContactUsLink.click();
                break;
            case "Item":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(0), 20);
                helpDrawerBodyNewLinks.get(0).click();
                break;
            case "Alimony Received":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(0), 20);
                helpDrawerBodyNewLinks.get(0).click();
                break;
            case "Capital Gains":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(1), 20);
                helpDrawerBodyNewLinks.get(1).click();
                break;
            case "Income from Rental":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(2), 20);
                helpDrawerBodyNewLinks.get(2).click();
                break;
            case "Pension":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(3), 20);
                helpDrawerBodyNewLinks.get(3).click();
                break;
            case "Private Retirement Income":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(4), 20);
                helpDrawerBodyNewLinks.get(4).click();
                break;
            case "Title II Income":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(5), 20);
                helpDrawerBodyNewLinks.get(5).click();
                break;
            case "Unemployment Insurance":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(6), 20);
                helpDrawerBodyNewLinks.get(6).click();
                break;
            case "Investment Income":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(7), 20);
                helpDrawerBodyNewLinks.get(7).click();
                break;
            case "Untaxed Foreign Income":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(8), 20);
                helpDrawerBodyNewLinks.get(8).click();
                break;
            case "Royalty Income":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(9), 20);;
                helpDrawerBodyNewLinks.get(9).click();
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
            case "Taxable income from Tribal Sources":
                basicActions.waitForElementToBePresent(txtTaxableIncomeFromTribalSourcesAmount,20);
                softAssert.assertEquals(txtTaxableIncomeFromTribalSourcesAmount.getAttribute("value"), Amount);
                softAssert.assertEquals(selectTRBIFrequency.getAttribute("value"), Frequency);
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
        basicActions.waitForElementToBePresentWithRetries(helpDrawerHeaderHelp, 30);
        basicActions.waitForElementToBePresentWithRetries(helpDrawerHeaderAddtionalIncome, 30);
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
        softAssert.assertEquals(helpDrawerHeaders.get(0).getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Additions");
        softAssert.assertEquals(helpDrawerHeaders.get(1).getText(), "Overview");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(0).getText(), "Tell us about any additional income this person may receive.");
        softAssert.assertEquals(helpDrawerHeaders.get(2).getText(), "Alimony Received");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(1).getText(), "Amounts received from a spouse or a former spouse under a divorce or separation agreement (including a divorce decree, a separate maintenance decree, or a written separation agreement) may be considered alimony for federal tax purposes. For more information, see:\nhttps://www.irs.gov/taxtopics/tc452\nIf your divorce or separation was finalized on or before December 31, 2018, you should include alimony you received in your Additional Income Sources. If your divorce or separation was finalized on or after January 1, 2019, do not include alimony you receive in your Additional Income Sources.");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerHeaders.get(3).getText(), "Capital Gains");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(2).getText(), "Capital gain is a rise in the value of a capital asset (investment or real estate) that gives it a higher worth than the purchase price. The gain is not realized until the asset is sold. For more information, see:\nhttps://www.irs.gov/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(1).getText(), "https://www.irs.gov/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerHeaders.get(4).getText(), "Income from Rental Property");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(3).getText(), "Cash or the fair market value of property or services you receive for the use of real estate or personal property is taxable to you as rental income. For more information, see:\nhttps://www.irs.gov/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(2).getText(), "https://www.irs.gov/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerHeaders.get(5).getText(), "Pension");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(4).getText(), "It is possible that you must report income from pension and annuity plans on your federal income tax return. Any such income that you report on your tax return must be entered here. For more information, see:\nhttps://www.irs.gov/publications/p575");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(3).getText(), "https://www.irs.gov/publications/p575");
        softAssert.assertEquals(helpDrawerHeaders.get(6).getText(), "Private Retirement Income");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(5).getText(), "Private retirement income can include IRAs, 401(k), 403(b), and 457(b) withdrawals and distributions, not Social Security. For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(4).getText(), "https://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerHeaders.get(7).getText(), "Title II Income");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(6).getText(), "Title II benefits are the monthly benefits that are issued by the Social Security Administration for disability claims. For more information, see:\nhttps://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(5).getText(), "https://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerHeaders.get(8).getText(), "Unemployment Insurance Benefit");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(7).getText(), "Unemployment compensation generally includes any amounts received under the unemployment compensation laws of the United States or of a state, including state unemployment insurance benefits. For more information, see:\nhttps://www.irs.gov/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(6).getText(), "https://www.irs.gov/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerHeaders.get(9).getText(), "Investment Income");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(8).getText(), "Investment income includes dividends and other gains as reflected on lines 9 and 14 of 1040, as well as interest income (Line 8). For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(7).getText(), "https://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerHeaders.get(10).getText(), "Cash Support");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(9).getText(), "If you receive any income in cash from any source, you must report it here.");
        softAssert.assertEquals(helpDrawerHeaders.get(11).getText(), "Untaxed Foreign Income");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(10).getText(), "Foreign earned income is income you receive for services you perform in a foreign country during a period your tax home is in a foreign country and during which you meet either the bona fide residence test or the physical presence test. For more information, see:\nhttps://www.irs.gov/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(8).getText(), "https://www.irs.gov/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerHeaders.get(12).getText(), "Royalty Income");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(11).getText(), "Royalty income is a payment received for the use and exploitation of artistic or literary works, patents and mineral rights. For more information, see:\nhttps://www.irs.gov/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(9).getText(), "https://www.irs.gov/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerHeaders.get(13).getText(), "Taxable Income from Tribal Sources");
        softAssert.assertEquals(helpParagraphUnderTaxableIncomeHeader.getText(), "Only include the taxable portion of income you receive from an American Indian or Alaska Native tribal source. Common types of income include:");
        softAssert.assertEquals(helpListUnderTaxableIncomeHeader.getText(), "Per capita payments from the tribe that come from natural resources, usage rights, leases or royalties.\nPayments from natural resources, farming, ranching, fishing, leases, or royalties from land designated as Indian land by the Department of Interior (including reservations and former reservations).\nMoney from selling things that have cultural significance.");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaders.get(0).getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Adiciones");
        softAssert.assertEquals(helpDrawerHeaders.get(1).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(0).getText(), "Indique cualquier ingreso adicional que esta persona pueda recibir.");
        softAssert.assertEquals(helpDrawerHeaders.get(2).getText(), "Pensi\u00F3n alimenticia recibida");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(1).getText(), "Cantidades recibidas del c\u00F3nyuge o exc\u00F3nyuge por acuerdo de divorcio o separaci\u00F3n (incluyendo una sentencia de divorcio, una sentencia de separaci\u00F3n por manutenci\u00F3n o un acuerdo de separaci\u00F3n por escrito) pueden ser consideradas pensi\u00F3n alimenticia cuando declare sus impuestos federales sobre los ingresos. Para m\u00E1s informaci\u00F3n visite:\nhttps://www.irs.gov/es/taxtopics/tc452\nSi su divorcio o separaci\u00F3n finaliz\u00F3 en o antes del 31 de diciembre de 2018, debe incluir la pensi\u00F3n alimenticia que recibi\u00F3 en sus Otras fuentes de ingreso. Si su divorcio o separaci\u00F3n finaliz\u00F3 en o despu\u00E9s del 1\u00BA de enero de 2019, no incluya la pensi\u00F3n alimenticia que recibi\u00F3 en sus Otras fuentes de ingreso.");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerHeaders.get(3).getText(), "Ganancias de capital");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(2).getText(), "Ganancias de capital es un aumento de un bien capital (inversi\u00F3n o bienes ra\u00EDces) que le proporciona un mayor valor al precio de compra. La ganancia se obtiene hasta que se vende la propiedad. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(1).getText(), "https://www.irs.gov/es/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerHeaders.get(4).getText(), "Ingresos por renta de propiedades");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(3).getText(), "El efectivo o valor razonable de mercado de la propiedad o servicios que recibe por el uso del bien o propiedad personal le es sujeto a impuestos como ingreso por rentas. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(2).getText(), "https://www.irs.gov/es/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerHeaders.get(5).getText(), "Pensi\u00F3n");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(4).getText(), "Es posible que deba reportar ingresos por planes de pensi\u00F3n y anualidad en su declaraci\u00F3n de impuestos sobre los ingresos. Cualquier ingreso que reporte en su declaraci\u00F3n de impuestos debe ingresarlo aqu\u00ED. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(3).getText(), "https://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerHeaders.get(6).getText(), "Ingresos privados por retiro");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(5).getText(), "Los ingresos privados por retiro pueden incluir retiros y aportes a IRA, 401(k), 403(b) y 457(b), no Seguro Social. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(4).getText(), "https://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerHeaders.get(7).getText(), "Ingresos del T\u00EDtulo II");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(6).getText(), "Los beneficios del T\u00EDtulo II son los beneficios mensuales que emite la Administraci\u00F3n del Seguro Social para reclamos por discapacidad. Para m\u00E1s informaci\u00F3n, ver:\nhttps://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(5).getText(), "https://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerHeaders.get(8).getText(), "Beneficio del seguro de desempleo");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(7).getText(), "La compensaci\u00F3n por desempleo generalmente incluye cualquier cantidad recibida bajo las leyes de compensaci\u00F3n por desempleo de Estados Unidos o de un estado, incluyendo el seguro de beneficios estatales por desempleo. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(6).getText(), "https://www.irs.gov/es/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerHeaders.get(9).getText(), "Ingresos derivados de inversiones");
        //waiting on the fix
        softAssert.assertEquals(helpDrawerNewParagraphs.get(8).getText(), "Los ingresos derivados de inversiones incluyen los dividendos y otras ganancias, como se reflejan tanto en las l\u00EDneas 9 y 14 del 1040, como en los ingresos por intereses (l\u00EDnea 8). Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p550");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(7).getText(), "https://www.irs.gov/es/publications/p550");
        softAssert.assertEquals(helpDrawerHeaders.get(10).getText(), "Apoyo en efectivo");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(9).getText(), "Si obtiene un ingreso en efectivo de cualquier fuente, debe reportarlo aqu\u00ED.");
        softAssert.assertEquals(helpDrawerHeaders.get(11).getText(), "Ingresos obtenidos en el extranjero no gravados");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(10).getText(), "El ingreso extranjero obtenido es ingreso que recibe por servicios otorgados en un pa\u00EDs extranjero durante un per\u00EDodo en el que su residencia fiscal es en un pa\u00EDs extranjero y durante el que cumple ya sea con el criterio de la residencia leg\u00EDtima o de presencia f\u00EDsica. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(8).getText(), "https://www.irs.gov/es/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerHeaders.get(12).getText(), "Ingresos por regal\u00EDas");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(11).getText(), "El ingreso por regal\u00EDas es un pago recibido por el uso y utilizaci\u00F3n de trabajos art\u00EDsticos o literarios, derechos de patente y de minerales. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(9).getText(), "https://www.irs.gov/es/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerHeaders.get(13).getText(), "Ingresos gravables de origen tribal");
        softAssert.assertEquals(helpParagraphUnderTaxableIncomeHeader.getText(), "Incluya \u00FAnicamente la parte de los ingresos reportados que recibi\u00F3 de origen tribal como ind\u00EDgena norteamericano o nativo de Alaska. Tipos de ingresos comunes son:");
        softAssert.assertEquals(helpListUnderTaxableIncomeHeader.getText(), "Pagos per c\u00E1pita de la tribu proveniente de recursos naturales, derechos de uso, arrendamientos o regal\u00EDas.\nPagos provenientes de recursos naturales, agricultura, ganader\u00EDa, pesca, arrendamientos o regal\u00EDas de tierras designadas como tierras en fideicomiso ind\u00EDgenas por el Departamento del Interior (incluidas reservas ind\u00EDgenas y antiguas reservas ind\u00EDgenas).\nDinero de la venta de patrimonio de significado cultural.");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateAlimonyReceivedHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Alimony Received");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Amounts received from a spouse or a former spouse under a divorce or separation agreement (including a divorce decree, a separate maintenance decree, or a written separation agreement) may be considered alimony for federal tax purposes. For more information, see:\nhttps://www.irs.gov/taxtopics/tc452\nIf your divorce or separation was finalized on or before December 31, 2018, you should include alimony you received in your Additional Income Sources. If your divorce or separation was finalized on or after January 1, 2019, do not include alimony you receive in your Additional Income Sources.");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateAlimonyReceivedHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Pensi\u00F3n alimenticia recibida");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Cantidades recibidas del c\u00F3nyuge o exc\u00F3nyuge por acuerdo de divorcio o separaci\u00F3n (incluyendo una sentencia de divorcio, una sentencia de separaci\u00F3n por manutenci\u00F3n o un acuerdo de separaci\u00F3n por escrito) pueden ser consideradas pensi\u00F3n alimenticia cuando declare sus impuestos federales sobre los ingresos. Para m\u00E1s informaci\u00F3n visite:\nhttps://www.irs.gov/es/taxtopics/tc452\nSi su divorcio o separaci\u00F3n finaliz\u00F3 en o antes del 31 de diciembre de 2018, debe incluir la pensi\u00F3n alimenticia que recibi\u00F3 en sus Otras fuentes de ingreso. Si su divorcio o separaci\u00F3n finaliz\u00F3 en o despu\u00E9s del 1\u00BA de enero de 2019, no incluya la pensi\u00F3n alimenticia que recibi\u00F3 en sus Otras fuentes de ingreso.");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/taxtopics/tc452");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateCapitalGainsHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Capital Gains");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Capital gain is a rise in the value of a capital asset (investment or real estate) that gives it a higher worth than the purchase price. The gain is not realized until the asset is sold. For more information, see:\nhttps://www.irs.gov/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateCapitalGainsHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ganancias de capital");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Ganancias de capital es un aumento de un bien capital (inversi\u00F3n o bienes ra\u00EDces) que le proporciona un mayor valor al precio de compra. La ganancia se obtiene hasta que se vende la propiedad. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/taxtopics/tc409");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateRentalIncomeHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Income from Rental Property");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Cash or the fair market value of property or services you receive for the use of real estate or personal property is taxable to you as rental income. For more information, see:\nhttps://www.irs.gov/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateRentalIncomeHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos por renta de propiedades");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "El efectivo o valor razonable de mercado de la propiedad o servicios que recibe por el uso del bien o propiedad personal le es sujeto a impuestos como ingreso por rentas. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/taxtopics/tc414");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validatePensionHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Pension");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "It is possible that you must report income from pension and annuity plans on your federal income tax return. Any such income that you report on your tax return must be entered here. For more information, see:\nhttps://www.irs.gov/publications/p575");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/publications/p575");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validatePensionHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Pensi\u00F3n");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Es posible que deba reportar ingresos por planes de pensi\u00F3n y anualidad en su declaraci\u00F3n de impuestos sobre los ingresos. Cualquier ingreso que reporte en su declaraci\u00F3n de impuestos debe ingresarlo aqu\u00ED. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/publications/p575");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validatePrivateRetirementHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Private Retirement Income");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Private retirement income can include IRAs, 401(k), 403(b), and 457(b) withdrawals and distributions, not Social Security. For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validatePrivateRetirementHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos privados por retiro");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Los ingresos privados por retiro pueden incluir retiros y aportes a IRA, 401(k), 403(b) y 457(b), no Seguro Social. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/publications/p575");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateSocialSecurityHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Title II Income");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Title II benefits are the monthly benefits that are issued by the Social Security Administration for disability claims. For more information, see:\nhttps://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateSocialSecurityHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos del T\u00EDtulo II");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Los beneficios del T\u00EDtulo II son los beneficios mensuales que emite la Administraci\u00F3n del Seguro Social para reclamos por discapacidad. Para m\u00E1s informaci\u00F3n, ver:\nhttps://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.disability-benefits-help.org/glossary/title-ii-benefits");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateUnemploymentHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Unemployment Insurance Benefit");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Unemployment compensation generally includes any amounts received under the unemployment compensation laws of the United States or of a state, including state unemployment insurance benefits. For more information, see:\nhttps://www.irs.gov/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateUnemploymentHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Beneficio del seguro de desempleo");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "La compensaci\u00F3n por desempleo generalmente incluye cualquier cantidad recibida bajo las leyes de compensaci\u00F3n por desempleo de Estados Unidos o de un estado, incluyendo el seguro de beneficios estatales por desempleo. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/individuals/employees/unemployment-compensation");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateInvestmentHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Investment Income");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Investment income includes dividends and other gains as reflected on lines 9 and 14 of 1040, as well as interest income (Line 8). For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateInvestmentHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos derivados de inversiones");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Los ingresos derivados de inversiones incluyen los dividendos y otras ganancias, como se reflejan tanto en las l\u00EDneas 9 y 14 del 1040, como en los ingresos por intereses (l\u00EDnea 8). Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p550");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/publications/p550");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateCashSupportHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Cash Support");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "If you receive any income in cash from any source, you must report it here.");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateCashSupportHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Apoyo en efectivo");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Si obtiene un ingreso en efectivo de cualquier fuente, debe reportarlo aqu\u00ED.");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateUntaxedForeignHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Untaxed Foreign Income");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Foreign earned income is income you receive for services you perform in a foreign country during a period your tax home is in a foreign country and during which you meet either the bona fide residence test or the physical presence test. For more information, see:\nhttps://www.irs.gov/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateUntaxedForeignHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos obtenidos en el extranjero no gravados");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "El ingreso extranjero obtenido es ingreso que recibe por servicios otorgados en un pa\u00EDs extranjero durante un per\u00EDodo en el que su residencia fiscal es en un pa\u00EDs extranjero y durante el que cumple ya sea con el criterio de la residencia leg\u00EDtima o de presencia f\u00EDsica. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateRoyaltyIncomeHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Royalty Income");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Royalty income is a payment received for the use and exploitation of artistic or literary works, patents and mineral rights. For more information, see:\nhttps://www.irs.gov/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateRoyaltyIncomeHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos por regal\u00EDas");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "El ingreso por regal\u00EDas es un pago recibido por el uso y utilizaci\u00F3n de trabajos art\u00EDsticos o literarios, derechos de patente y de minerales. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/forms-pubs/about-form-1099-misc");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateTribalSourcesHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Taxable Income from Tribal Sources");
        softAssert.assertEquals(helpParagraphUnderTaxableIncomeHeader.getText(), "Only include the taxable portion of income you receive from an American Indian or Alaska Native tribal source. Common types of income include:");
        softAssert.assertEquals(helpListUnderTaxableIncomeHeader.getText(), "Per capita payments from the tribe that come from natural resources, usage rights, leases or royalties.\nPayments from natural resources, farming, ranching, fishing, leases, or royalties from land designated as Indian land by the Department of Interior (including reservations and former reservations).\nMoney from selling things that have cultural significance.");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateTribalSourcesHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderAddtionalIncome.getText(), "Ingresos gravables de origen tribal");
        softAssert.assertEquals(helpParagraphUnderTaxableIncomeHeader.getText(), "Incluya \u00FAnicamente la parte de los ingresos reportados que recibi\u00F3 de origen tribal como ind\u00EDgena norteamericano o nativo de Alaska. Tipos de ingresos comunes son:");
        softAssert.assertEquals(helpListUnderTaxableIncomeHeader.getText(), "Pagos per c\u00E1pita de la tribu proveniente de recursos naturales, derechos de uso, arrendamientos o regal\u00EDas.\nPagos provenientes de recursos naturales, agricultura, ganader\u00EDa, pesca, arrendamientos o regal\u00EDas de tierras designadas como tierras en fideicomiso ind\u00EDgenas por el Departamento del Interior (incluidas reservas ind\u00EDgenas y antiguas reservas ind\u00EDgenas).\nDinero de la venta de patrimonio de significado cultural.");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
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

    public void validateErrorMessageAndItsProperties(DataTable dataTable) {
        basicActions.waitForElementListToBePresent(ActiveErrorIcon, 10);
        basicActions.waitForElementListToBePresent(ActiveErrorMessage, 10);

        List<Map<String, String>> data = dataTable.asMaps();
        for (int i = 0; i < data.size(); i++) {
            softAssert.assertTrue(ActiveErrorIcon.get(i).isDisplayed(), "Error Icon for error '" + data.get(i).get("Text") + "' is not visible in the page");
            softAssert.assertTrue(ActiveErrorMessage.get(i).isDisplayed(), "Error Message for error '" + data.get(i).get("Text") + "' is not visible in the page");
            softAssert.assertEquals(ActiveErrorMessage.get(i).getText(), data.get(i).get("Text"),"Expected and Actual Error message is not matching");
            softAssert.assertEquals(ActiveErrorMessage.get(i).getCssValue("font-size"), data.get(i).get("fontSize"),"Expected and Actual Font size for the error '" + data.get(i).get("Text") +"' is not matching.");
            softAssert.assertEquals(ActiveErrorMessage.get(i).getCssValue("font-family"), data.get(i).get("fontFamily"),"Expected and Actual Font family for the error '" + data.get(i).get("Text") +"' is not matching.");
            softAssert.assertEquals(ActiveErrorMessage.get(i).getCssValue("font-weight"), data.get(i).get("fontWeight"),"Expected and Actual Font weight for the error '" + data.get(i).get("Text") +"' is not matching.");
            softAssert.assertEquals(ActiveErrorMessage.get(i).getCssValue("color"), data.get(i).get("color"),"Expected and Actual Font color for the error '" + data.get(i).get("Text") +"' is not matching.");
            softAssert.assertAll();
        }
    }

    public void verifyActiveErrorMessage(String expectedErrorMessage){
        basicActions.waitForElementListToBePresent(ActiveErrorMessage,30);
        softAssert.assertEquals(ActiveErrorMessage.get(0).getText(), expectedErrorMessage,"Actual and Expected Error message is not matching");
        softAssert.assertAll();
    }

    public void enterAndVerifyTheAmount(String enteredValue,String expectedValue){
        basicActions.waitForElementToBePresent(ActiveInputTextField,30);
        ActiveInputTextField.clear();
        ActiveInputTextField.sendKeys(enteredValue);
        basicActions.wait(20);
        softAssert.assertEquals(ActiveInputTextField.getAttribute("value"), expectedValue,"Actual and Expected Amount is not matching");
        softAssert.assertAll();
    }
    public void verifyHeaderAndOtherTextsColorEtc(List<String> pageTexts){
        basicActions.wait(1000);
        String signature=SharedData.getPrimaryMember().getSignature();
        softAssert.assertEquals(hdr_Income.getText(),pageTexts.get(0)+" "+signature,"Income header text mismatch");
        softAssert.assertEquals(hdr_AdditionalIncome.getText(),pageTexts.get(1),"Add income sources text mismatch");
        softAssert.assertEquals(txtAdditionalIncomeText.get(0).getText(),pageTexts.get(2),"Did you receive text mismatch");
        softAssert.assertEquals(txtAdditionalIncomeText.get(1).getText(),pageTexts.get(3),"Select all that apply text mismatch");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(horizontalLine,10));

        softAssert.assertEquals(hdr_Income.getCssValue("font-size"), "36px", "IncomeSummaryHeader-Font size mismatch");
        softAssert.assertEquals(hdr_Income.getCssValue("color"), "rgba(43, 49, 60, 1)", "IncomeSummaryHeader-Color mismatch");
        softAssert.assertEquals(hdr_Income.getCssValue("font-family"), "\"PT Sans\", sans-serif", "IncomeSummaryHeader-Font family mismatch");
        softAssert.assertEquals(hdr_Income.getCssValue("line-height"), "48px", "IncomeSummaryHeader-Line height mismatch");
        softAssert.assertEquals(hdr_AdditionalIncome.getCssValue("font-size"), "28px", "DeductionSummaryHeader-Font size mismatch");
        softAssert.assertEquals(hdr_AdditionalIncome.getCssValue("color"), "rgba(43, 49, 60, 1)", "DeductionSummaryHeader-Color mismatch");
        softAssert.assertEquals(hdr_AdditionalIncome.getCssValue("font-family"), "\"PT Sans\", sans-serif", "DeductionSummaryHeader-Font family mismatch");
        softAssert.assertEquals(hdr_AdditionalIncome.getCssValue("line-height"), "40px", "DeductionSummaryHeader-Line height mismatch");
        softAssert.assertEquals(txtAdditionalIncomeText.get(0).getCssValue("font-size"), "16px", "Do You have-Font size mismatch");
        softAssert.assertEquals(txtAdditionalIncomeText.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)", "Do You have-Color mismatch");
        softAssert.assertEquals(txtAdditionalIncomeText.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif", "Do You have-Font family mismatch");
        softAssert.assertEquals(txtAdditionalIncomeText.get(0).getCssValue("line-height"), "28px", "Do You have-Line height mismatch");
        softAssert.assertEquals(txtAdditionalIncomeText.get(1).getCssValue("font-size"), "16px", "Select all that apply-Font size mismatch");
        softAssert.assertEquals(txtAdditionalIncomeText.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)", "Select all that apply-Color mismatch");
        softAssert.assertEquals(txtAdditionalIncomeText.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif", "Select all that apply-Font family mismatch");
        softAssert.assertEquals(txtAdditionalIncomeText.get(1).getCssValue("line-height"), "28px", "Select all that apply-Line height mismatch");
        softAssert.assertAll();
    }
    public void verifyViewOrderTextColorFormatOfAddIncomeOptions(List<String> addIncomeOpts){
        for (int i=0;i<addIncomeOpts.size();i++){
            softAssert.assertEquals(addtlIncomeOptionsName.get(i).getText().trim(), addIncomeOpts.get(i), "Income Options"+i+"-text mismatch");
            softAssert.assertFalse(addtlIncomeOptionsCheckbox.get(i).isSelected(),"Check box"+i+" is Selected");
            softAssert.assertEquals(addtlIncomeOptionsName.get(i).getCssValue("font-size"), "16px", "addtlIncomeOptionsName"+i+"-Font size mismatch");
            softAssert.assertEquals(addtlIncomeOptionsName.get(i).getCssValue("color"), "rgba(43, 49, 60, 1)", "addtlIncomeOptionsName"+i+"-Color mismatch");
            softAssert.assertEquals(addtlIncomeOptionsName.get(i).getCssValue("font-family"), "\"PT Sans\", sans-serif", "addtlIncomeOptionsName"+i+"-Font family mismatch");
            softAssert.assertEquals(addtlIncomeOptionsName.get(i).getCssValue("line-height"), "28px", "addtlIncomeOptionsName"+i+"-Line height mismatch");
            softAssert.assertAll();
        }
    }
    public void verifyTextsOfBackAndSaveBtn(String btnBack,String btnSave){
        softAssert.assertEquals(backBtn.getText().trim(), btnBack, "Back Button-text mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getText().trim(), btnSave, "Save Button-text mismatch");
        softAssert.assertAll();
    }
    public void clickOnAlimonyReceivedCheckBox(){
        basicActions.waitForElementToBePresent(addtlIncomeOptionsCheckbox.get(0),10);
        addtlIncomeOptionsCheckbox.get(0).click();
    }

    public void verifyDefaultPropertyOfTextBoxAndDropdown(String languageOpt,List<String> dropDownOpts) {
        softAssert.assertTrue(txtBoxAlimonyReceivedAmount.isDisplayed(), "AR text box not visible");
        softAssert.assertTrue(selectALMRFrequency.isDisplayed(), "Drop Down not visible");
        switch (languageOpt){
            case "English":
                softAssert.assertEquals(txtBoxAlimonyReceivedAmount.getAttribute("placeholder"), "amount", "Amount default text not visible");
                softAssert.assertEquals(basicActions.getFirstSelectedOptionFromDD(selectALMRFrequency).getText().trim(), "Select Option", "Select Option not visible");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(txtBoxAlimonyReceivedAmount.getAttribute("placeholder"),"cantidad","cantidad default text not visible");
                softAssert.assertEquals(basicActions.getFirstSelectedOptionFromDD(selectALMRFrequency).getText().trim(),"Seleccionar opci\u00F3n","Seleccionar opci\u00F3n not visible");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + languageOpt);
        }
        checkAllDropDownOptions(dropDownOpts);
        softAssert.assertAll();
    }

    private void checkAllDropDownOptions(List<String> dropdownOptions){
        for (int i=0;i<dropdownOptions.size();i++) {
            softAssert.assertEquals(basicActions.selectAllOptionsFromDropDown(selectALMRFrequency).get(i).getText().trim(), dropdownOptions.get(i), "DD Option text not matching");
            softAssert.assertAll();
        }
    }
    public void verifyEnteredAmountAndFreq(String amount,String freq){
        softAssert.assertEquals(txtBoxAlimonyReceivedAmount.getAttribute("value"),amount,"Entered amount mismatch");
        softAssert.assertTrue(dollarSymbol.isDisplayed(),"Dollar Symbol is not visible");
        softAssert.assertEquals(basicActions.getFirstSelectedOptionFromDD(selectALMRFrequency).getText().trim(),freq,"Entered freq mismatch");
        softAssert.assertAll();
    }
    public void verifyNone_Of_TheseOnlySelected(){
        basicActions.waitForElementToBePresent(addtlIncomeOptionsCheckbox.get(12),10);
        addtlIncomeOptionsCheckbox.get(12).click();
        for (int i=0;i<addtlIncomeOptionsCheckbox.size()-1;i++){
            softAssert.assertFalse(addtlIncomeOptionsCheckbox.get(i).isSelected(),"Other"+i+" is selected");
            softAssert.assertAll();
        }
        softAssert.assertTrue(checkBoxChecked.size()==1,"NoneOfThese is not selected");
        softAssert.assertAll();
    }
    public void verifyFontColorBorderOfBackAndSaveBtn(String mouseOverOpt){
        switch (mouseOverOpt){
            case "Off":
                validateColorFontEtcWhenMouseHoverOff();
                break;
            case "On":
                validateColorFontEtcWhenMouseHoverOn();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + mouseOverOpt);
        }
    }

    private void validateColorFontEtcWhenMouseHoverOff(){
        addtlIncomeOptionsCheckbox.get(12).click();
        softAssert.assertEquals(backBtn.getCssValue("background-color"), "rgba(252, 252, 252, 1)", "Go Back-back ground Color mismatching");
        softAssert.assertEquals(backBtn.getCssValue("border"), "2px solid rgb(26, 112, 179)", "Go Back-border mismatch");
        softAssert.assertEquals(backBtn.getCssValue("border-top-left-radius"), "4px", "Go Back-Border radios mismatch");
        softAssert.assertEquals(backBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Go Back-Font family mismatch");
        softAssert.assertEquals(backBtn.getCssValue("font-size"), "20px", "Go Back-Font size mismatch");
        softAssert.assertEquals(backBtn.getCssValue("padding-bottom"), "12px", "Go Back-Padding bottom not matching");
        softAssert.assertEquals(backBtn.getCssValue("padding-right"), "20px", "Go Back-Padding right not matching");
        softAssert.assertEquals(backBtn.getCssValue("color"), "rgba(26, 112, 179, 1)", "Go Back-Color mismatch");
        softAssert.assertEquals(btnOutlineBackAndSave.get(0).getCssValue("background-color"), "rgba(0, 0, 0, 0)", "Go Back Outline-back ground Color mismatching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(26, 112, 179, 1)", "saveAndContinueBtn-back ground Color mismatching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("border"), "2px solid rgb(26, 112, 179)", "saveAndContinueBtn-border mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("border-top-left-radius"), "4px", "saveAndContinueBtn-Border radios mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif", "saveAndContinueBtn-Font family mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px", "saveAndContinueBtn-Font size mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("padding-bottom"), "12px", "saveAndContinueBtn-Padding bottom not matching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("padding-right"), "20px", "saveAndContinueBtn-Padding right not matching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)", "saveAndContinueBtn-Color mismatch");
        softAssert.assertEquals(btnOutlineBackAndSave.get(1).getCssValue("background-color"), "rgba(0, 0, 0, 0)", "Save outline-back ground Color mismatching");
        softAssert.assertAll();
    }
    private void validateColorFontEtcWhenMouseHoverOn(){
        basicActions.mouseHoverOnElement(backBtn);
        softAssert.assertEquals(backBtn.getCssValue("background-color"), "rgba(226, 241, 248, 1)", "Go Back When Mouse Hover No-back ground Color mismatching");
        softAssert.assertEquals(backBtn.getCssValue("border"), "2px solid rgb(26, 112, 179)", "Go Back-border mismatch");
        softAssert.assertEquals(backBtn.getCssValue("border-top-left-radius"), "4px", "Go Back-Border radios mismatch");
        softAssert.assertEquals(backBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Go Back-Font family mismatch");
        softAssert.assertEquals(backBtn.getCssValue("font-size"), "20px", "Go Back-Font size mismatch");
        softAssert.assertEquals(backBtn.getCssValue("padding-bottom"), "12px", "Go Back-Padding bottom not matching");
        softAssert.assertEquals(backBtn.getCssValue("padding-right"), "20px", "Go Back-Padding right not matching");
        basicActions.scrollToElement(saveAndContinueBtn);
        basicActions.mouseHoverOnElement(saveAndContinueBtn);
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(22, 156, 216, 1)", "Save btn When Mouse Hover No-back ground Color mismatching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("border"), "2px solid rgb(252, 252, 252)", "saveAndContinueBtn-border mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("border-top-left-radius"), "4px", "saveAndContinueBtn-Border radios mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif", "saveAndContinueBtn-Font family mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px", "saveAndContinueBtn-Font size mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("padding-bottom"), "12px", "saveAndContinueBtn-Padding bottom not matching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("padding-right"), "20px", "saveAndContinueBtn-Padding right not matching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)", "saveAndContinueBtn-Color mismatch");
        softAssert.assertAll();
    }
}
