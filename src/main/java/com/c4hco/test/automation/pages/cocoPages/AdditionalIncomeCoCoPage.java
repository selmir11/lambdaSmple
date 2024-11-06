package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Constants;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdditionalIncomeCoCoPage {
    private BasicActions basicActions;

    Actions actions = new Actions(WebDriverManager.getDriver());

    SoftAssert softAssert = new SoftAssert();

    public AdditionalIncomeCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "app-show-options button")
    List<WebElement> addIncomeButton;

    @FindBy(css = "div.parent-position > div:nth-child(1)")
    WebElement additionalIncomeQuestion;

    @FindBy(css = "div.parent-position > div:nth-child(2)")
    WebElement selectIncomeSentence;

    @FindBy(css = "#ELIG-AdditionalIncome-ALMR-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement alimonyText;

    @FindBy(id = "ELIG-AdditionalIncome-ALMR-amountInput")
    WebElement alimonyAmount;

    @FindBy(id = "ELIG-AdditionalIncome-ALMR-frequencySelect")
    WebElement alimonyFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-CAPG-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement capGainsText;

    @FindBy(id = "ELIG-AdditionalIncome-CAPG-amountInput")
    WebElement capGainsAmount;

    @FindBy(id = "ELIG-AdditionalIncome-CAPG-frequencySelect")
    WebElement capGainsFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-IFRP-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement rentalText;

    @FindBy(id = "ELIG-AdditionalIncome-IFRP-amountInput")
    WebElement rentalAmount;

    @FindBy(id = "ELIG-AdditionalIncome-IFRP-frequencySelect")
    WebElement rentalFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-PENS-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement pensionText;

    @FindBy(id = "ELIG-AdditionalIncome-PENS-amountInput")
    WebElement pensionAmount;

    @FindBy(id = "ELIG-AdditionalIncome-PENS-frequencySelect")
    WebElement pensionFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-RETR-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement retirementText;

    @FindBy(id = "ELIG-AdditionalIncome-RETR-amountInput")
    WebElement retirementAmount;

    @FindBy(id = "ELIG-AdditionalIncome-RETR-frequencySelect")
    WebElement retirementFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-TTWI-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement socialSecurityText;

    @FindBy(id = "ELIG-AdditionalIncome-TTWI-amountInput")
    WebElement socialSecurityAmount;

    @FindBy(id = "ELIG-AdditionalIncome-TTWI-frequencySelect")
    WebElement socialSecurityFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-UNEP-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement unemploymentText;

    @FindBy(id = "ELIG-AdditionalIncome-UNEP-amountInput")
    WebElement unemploymentAmount;

    @FindBy(id = "ELIG-AdditionalIncome-UNEP-frequencySelect")
    WebElement unemploymentFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-INVI-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement investmentText;

    @FindBy(id = "ELIG-AdditionalIncome-INVI-amountInput")
    WebElement investmentAmount;

    @FindBy(id = "ELIG-AdditionalIncome-INVI-frequencySelect")
    WebElement investmentFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-CASP-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement cashSupportText;

    @FindBy(id = "ELIG-AdditionalIncome-CASP-amountInput")
    WebElement cashSupportAmount;

    @FindBy(id = "ELIG-AdditionalIncome-CASP-frequencySelect")
    WebElement cashSupportFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-UTFI-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement untaxedForeignText;

    @FindBy(id = "ELIG-AdditionalIncome-UTFI-amountInput")
    WebElement untaxedForeignAmount;

    @FindBy(id = "ELIG-AdditionalIncome-UTFI-frequencySelect")
    WebElement untaxedForeignFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-RLTI-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement royaltyText;

    @FindBy(id = "ELIG-AdditionalIncome-RLTI-amountInput")
    WebElement royaltyAmount;

    @FindBy(id = "ELIG-AdditionalIncome-RLTI-frequencySelect")
    WebElement royaltyFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-TRBI-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement taxableText;

    @FindBy(id = "ELIG-AdditionalIncome-TRBI-amountInput")
    WebElement taxableAmount;

    @FindBy(id = "ELIG-AdditionalIncome-TRBI-frequencySelect")
    WebElement taxableFrequency;

    @FindBy(css = "#ELIG-AdditionalIncome-NoIncome-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label > span")
    WebElement noneOfTheseText;

    @FindBy(id = "ELIG-AdditionalIncome-NoIncome-checkBoxButton")
    WebElement noneOfThese;

    @FindBy(css = "lib-list-error > lib-error-msg > div")
    WebElement hdrError;

    @FindBy(css = "lib-input .error-message")
    List<WebElement> addtlIncomeAmountError;

    @FindBy(css = "lib-dropdown .error-message")
    List<WebElement> additlIncomeFrequencyError;

    @FindBy(css = ".additional-income-row label")
    List<WebElement> additlIncomeBoxes;

    @FindBy(css = ".additional-income-row button")
    List<WebElement> additlIncomeCheckboxes;

    @FindBy(id = "AdditionalIncome-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "AdditionalIncome-GoBack")
    WebElement goBackButton;

    @FindBy(css = ".banner-error-component")
    WebElement errorMessage;

    @FindBy(css = ".header-1")
    WebElement hdrAddInfoForYourself;

    @FindBy(css = ".header-2")
    WebElement hdr_AdditionalIncome;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        basicActions.waitForElementToBePresent(hdrAddInfoForYourself, 30);
        basicActions.waitForElementToBePresent(hdr_AdditionalIncome, 30);
        basicActions.scrollToElement(saveAndContinueButton);
        saveAndContinueButton.click();
    }

    public void selectAddIncomeOption(String addtlIncomeOption, String amount, String frequency) {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 10);

        selectAddtlIncomeOptionOnly(addtlIncomeOption);
        enterAmount(addtlIncomeOption, amount);
        selectFrequency(addtlIncomeOption, frequency);
    }

    public void selectAddtlIncomeOptionOnly(String addtlIncomeOption) {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 10);
        switch (addtlIncomeOption) {
            case "Alimony Received":
                addIncomeButton.get(0).click();
                break;
            case "Capital Gains":
                addIncomeButton.get(1).click();
                break;
            case "Income from rental property":
                addIncomeButton.get(2).click();
                break;
            case "Pension":
                addIncomeButton.get(3).click();
                break;
            case "Private Retirement Income":
                addIncomeButton.get(4).click();
                break;
            case "Income from Social Security":
                addIncomeButton.get(5).click();
                break;
            case "Unemployment Insurance Benefit":
                addIncomeButton.get(6).click();
                break;
            case "Investment Income":
                addIncomeButton.get(7).click();
                break;
            case "Cash Support":
                addIncomeButton.get(8).click();
                break;
            case "Untaxed Foreign Income":
                addIncomeButton.get(9).click();
                break;
            case "Royalty Income":
                addIncomeButton.get(10).click();
                break;
            case "Taxable income from Tribal Sources":
                addIncomeButton.get(11).click();
                break;
            case "None of these":
                addIncomeButton.get(12).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlIncomeOption);
        }
    }

    private void enterAmount(String addtlIncomeOption, String amount) {
        switch (addtlIncomeOption) {
            case "Alimony Received":
                basicActions.waitForElementToBeClickable(alimonyAmount, 10);
                alimonyAmount.sendKeys(amount);
                break;
            case "Capital Gains":
                basicActions.waitForElementToBeClickable(capGainsAmount, 10);
                capGainsAmount.sendKeys(amount);
                break;
            case "Income from rental property":
                basicActions.waitForElementToBeClickable(rentalAmount, 10);
                rentalAmount.sendKeys(amount);
                break;
            case "Pension":
                basicActions.waitForElementToBeClickable(pensionAmount, 10);
                pensionAmount.sendKeys(amount);
                break;
            case "Private Retirement Income":
                basicActions.waitForElementToBeClickable(retirementAmount, 10);
                retirementAmount.sendKeys(amount);
                break;
            case "Income from Social Security":
                basicActions.waitForElementToBeClickable(socialSecurityAmount, 10);
                socialSecurityAmount.sendKeys(amount);
                break;
            case "Unemployment Insurance Benefit":
                basicActions.waitForElementToBeClickable(unemploymentAmount, 10);
                unemploymentAmount.sendKeys(amount);
                break;
            case "Investment Income":
                basicActions.waitForElementToBeClickable(investmentAmount, 10);
                investmentAmount.sendKeys(amount);
                break;
            case "Cash Support":
                basicActions.waitForElementToBeClickable(cashSupportAmount, 10);
                cashSupportAmount.sendKeys(amount);
                break;
            case "Untaxed Foreign Income":
                basicActions.waitForElementToBeClickable(untaxedForeignAmount, 10);
                untaxedForeignAmount.sendKeys(amount);
                break;
            case "Royalty Income":
                basicActions.waitForElementToBeClickable(royaltyAmount, 10);
                royaltyAmount.sendKeys(amount);
                break;
            case "Taxable income from Tribal Sources":
                basicActions.waitForElementToBeClickable(taxableAmount, 10);
                taxableAmount.sendKeys(amount);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlIncomeOption);
        }
    }

    private void selectFrequency(String addtlIncomeOption, String frequency) {
        switch (addtlIncomeOption) {
            case "Alimony Received":
                selectFrequencyFromDropdown(alimonyFrequency, frequency);
                break;
            case "Capital Gains":
                selectFrequencyFromDropdown(capGainsFrequency, frequency);
                break;
            case "Income from rental property":
                selectFrequencyFromDropdown(rentalFrequency, frequency);
                break;
            case "Pension":
                selectFrequencyFromDropdown(pensionFrequency, frequency);
                break;
            case "Private Retirement Income":
                selectFrequencyFromDropdown(retirementFrequency, frequency);
                break;
            case "Income from Social Security":
                selectFrequencyFromDropdown(socialSecurityFrequency, frequency);
                break;
            case "Unemployment Insurance Benefit":
                selectFrequencyFromDropdown(unemploymentFrequency, frequency);
                break;
            case "Investment Income":
                selectFrequencyFromDropdown(investmentFrequency, frequency);
                break;
            case "Cash Support":
                selectFrequencyFromDropdown(cashSupportFrequency, frequency);
                break;
            case "Untaxed Foreign Income":
                selectFrequencyFromDropdown(untaxedForeignFrequency, frequency);
                break;
            case "Royalty Income":
                selectFrequencyFromDropdown(royaltyFrequency, frequency);
                break;
            case "Taxable income from Tribal Sources":
                selectFrequencyFromDropdown(taxableFrequency, frequency);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlIncomeOption);
        }
    }

    private void selectFrequencyFromDropdown(WebElement frequencyDropdown, String frequency) {
        Select dropdown = new Select(frequencyDropdown);
        dropdown.selectByVisibleText(" " + frequency + " ");
    }

    public void selectNoneAddIncomeOption(){
        basicActions.waitForElementListToBePresent(addIncomeButton, 30);
        addIncomeButton.get(12).click();
    }

    public void clickGoBackButton() {
        basicActions.waitForElementToBeClickable(goBackButton, 30);
        basicActions.scrollToElement(goBackButton);
        goBackButton.click();
    }

    public void openNewTab(){
        String currentUrl = basicActions.getCurrentUrl();
        JavascriptExecutor jse = (JavascriptExecutor)basicActions.getDriver();
        jse.executeScript("window.open()");
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
        }
        basicActions.getDriver().get(currentUrl);
    }

    public void unselectOptions(String addtlIncomeOption) {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 10);

        switch (addtlIncomeOption) {
            case "Cash Support":
                addIncomeButton.get(8).click();
                break;
            case "Untaxed Foreign Income":
                addIncomeButton.get(9).click();
                break;
            case "Royalty Income":
                addIncomeButton.get(10).click();
                break;
            case "None of these":
                noneOfThese.click();
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + addtlIncomeOption);
        }
    }

//////////////////////////////////////////////VALIDATION METHODS//////////////////////////////////////////////////
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
        basicActions.waitForElementToBePresent(hdrAddInfoForYourself,15);
        softAssert.assertTrue(hdrAddInfoForYourself.getText().equalsIgnoreCase( "Income: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdrAddInfoForYourself.getCssValue("font-size"), "36px");
        softAssert.assertEquals(hdrAddInfoForYourself.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdrAddInfoForYourself.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(hdr_AdditionalIncome.getText(), "Additional income sources");
        softAssert.assertEquals(hdr_AdditionalIncome.getCssValue("font-size"), "28px");
        softAssert.assertEquals(hdr_AdditionalIncome.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_AdditionalIncome.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
    }

    public void verifyHeadersAdditionalIncomePageSpanish(){
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 90);
        basicActions.waitForElementToBePresent(hdrAddInfoForYourself, 90);
        basicActions.waitForElementToBePresent(hdr_AdditionalIncome, 90);
        basicActions.waitForElementListToBePresent(addIncomeButton, 90);
        softAssert.assertTrue(hdrAddInfoForYourself.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdrAddInfoForYourself.getCssValue("font-size"), "36px");
        softAssert.assertEquals(hdrAddInfoForYourself.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdrAddInfoForYourself.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(hdr_AdditionalIncome.getText(), "Otras fuentes de ingreso");
        softAssert.assertEquals(hdr_AdditionalIncome.getCssValue("font-size"), "28px");
        softAssert.assertEquals(hdr_AdditionalIncome.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_AdditionalIncome.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
    }

    public void verifyAdditionalIncomeTextCoCo(String language){
        basicActions.waitForElementToBePresent(hdrAddInfoForYourself,15);
        switch (language) {
            case "English":
                softAssert.assertEquals(additionalIncomeQuestion.getText(), "Did you receive any of the following income?");
                softAssert.assertEquals(additionalIncomeQuestion.getCssValue("font-weight"), "700");
                softAssert.assertEquals(additionalIncomeQuestion.getCssValue("font-size"), "16px");
                softAssert.assertEquals(additionalIncomeQuestion.getCssValue("line-height"), "28px");
                softAssert.assertEquals(additionalIncomeQuestion.getCssValue("color"), "rgba(43, 49, 60, 1)");
                softAssert.assertEquals(selectIncomeSentence.getText(), "Select all that apply, and enter the amount of income received.");
                softAssert.assertEquals(alimonyText.getText(), "Alimony Received");
                softAssert.assertEquals(capGainsText.getText(), "Capital Gains");
                softAssert.assertEquals(rentalText.getText(), "Income from rental property");
                softAssert.assertEquals(pensionText.getText(), "Pension");
                softAssert.assertEquals(retirementText.getText(), "Private Retirement Income");
                softAssert.assertEquals(socialSecurityText.getText(), "Income from Social Security");
                softAssert.assertEquals(unemploymentText.getText(), "Unemployment Insurance Benefit");
                softAssert.assertEquals(investmentText.getText(), "Investment Income");
                softAssert.assertEquals(cashSupportText.getText(), "Cash Support");
                softAssert.assertEquals(untaxedForeignText.getText(), "Untaxed Foreign Income");
                softAssert.assertEquals(royaltyText.getText(), "Royalty Income");
                softAssert.assertEquals(taxableText.getText(), "Taxable income from Tribal Sources");
                softAssert.assertEquals(noneOfTheseText.getText(), "None of these");
                softAssert.assertAll();
                verifyBaseTextFormatting(selectIncomeSentence);
                verifyBaseTextFormatting(alimonyText);
                verifyBaseTextFormatting(capGainsText);
                verifyBaseTextFormatting(rentalText);
                verifyBaseTextFormatting(pensionText);
                verifyBaseTextFormatting(retirementText);
                verifyBaseTextFormatting(socialSecurityText);
                verifyBaseTextFormatting(unemploymentText);
                verifyBaseTextFormatting(investmentText);
                verifyBaseTextFormatting(cashSupportText);
                verifyBaseTextFormatting(untaxedForeignText);
                verifyBaseTextFormatting(royaltyText);
                verifyBaseTextFormatting(taxableText);
                verifyBaseTextFormatting(noneOfTheseText);
                break;
            case "Spanish":
                softAssert.assertEquals(additionalIncomeQuestion.getText(), "\u00bfRecibi\u00f3 alguno de los ingresos siguientes?");
                softAssert.assertEquals(additionalIncomeQuestion.getCssValue("font-weight"), "700");
                softAssert.assertEquals(additionalIncomeQuestion.getCssValue("font-size"), "16px");
                softAssert.assertEquals(additionalIncomeQuestion.getCssValue("line-height"), "28px");
                softAssert.assertEquals(additionalIncomeQuestion.getCssValue("color"), "rgba(43, 49, 60, 1)");
                softAssert.assertEquals(selectIncomeSentence.getText(), "Seleccione todo lo que corresponda y registre la cantidad de ingreso que recibe.");
                softAssert.assertEquals(alimonyText.getText(), "Pensi\u00f3n alimenticia recibida");
                softAssert.assertEquals(capGainsText.getText(), "Ganancias de capital");
                softAssert.assertEquals(rentalText.getText(), "Ingresos por renta de propiedades");
                softAssert.assertEquals(pensionText.getText(), "Pensi\u00f3n");
                softAssert.assertEquals(retirementText.getText(), "Ingresos privados por retiro");
                softAssert.assertEquals(socialSecurityText.getText(), "Ingresos por el Seguro Social");
                softAssert.assertEquals(unemploymentText.getText(), "Beneficio del seguro de desempleo");
                softAssert.assertEquals(investmentText.getText(), "Ingresos derivados de inversiones");
                softAssert.assertEquals(cashSupportText.getText(), "Apoyo en efectivo");
                softAssert.assertEquals(untaxedForeignText.getText(), "Ingresos extranjeros no gravados");
                softAssert.assertEquals(royaltyText.getText(), "Ingresos por regal\u00edas");
                softAssert.assertEquals(taxableText.getText(), "Ingresos gravables de origen tribal");
                softAssert.assertEquals(noneOfTheseText.getText(), "Ninguna de las anteriores");
                softAssert.assertAll();
                verifyBaseTextFormatting(selectIncomeSentence);
                verifyBaseTextFormatting(alimonyText);
                verifyBaseTextFormatting(capGainsText);
                verifyBaseTextFormatting(rentalText);
                verifyBaseTextFormatting(pensionText);
                verifyBaseTextFormatting(retirementText);
                verifyBaseTextFormatting(socialSecurityText);
                verifyBaseTextFormatting(unemploymentText);
                verifyBaseTextFormatting(investmentText);
                verifyBaseTextFormatting(cashSupportText);
                verifyBaseTextFormatting(untaxedForeignText);
                verifyBaseTextFormatting(royaltyText);
                verifyBaseTextFormatting(taxableText);
                verifyBaseTextFormatting(noneOfTheseText);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyAdditionalIncomeNavigationButtonsCoCo(String language){
        basicActions.waitForElementToBePresent(hdrAddInfoForYourself,15);
        switch(language){
            case "English":
                softAssert.assertEquals(goBackButton.getText(), "  Go Back");
                softAssert.assertEquals(goBackButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(goBackButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(goBackButton.getCssValue("line-height"), "30px");
                softAssert.assertEquals(goBackButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
                softAssert.assertEquals(goBackButton.getCssValue("background-color"), "rgba(255, 255, 255, 1)");
                softAssert.assertEquals(saveAndContinueButton.getText(), "Save and Continue");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("line-height"), "30px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("color"), "rgba(255, 255, 255, 1)");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(goBackButton.getText(), "  Volver");
                softAssert.assertEquals(goBackButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(goBackButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(goBackButton.getCssValue("line-height"), "30px");
                softAssert.assertEquals(goBackButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
                softAssert.assertEquals(goBackButton.getCssValue("background-color"), "rgba(255, 255, 255, 1)");
                softAssert.assertEquals(saveAndContinueButton.getText(), "Guardar y continuar");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("line-height"), "30px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("color"), "rgba(255, 255, 255, 1)");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
                softAssert.assertAll();
                break;
        }
    }

    public void verifyBaseTextFormatting(WebElement BaseText){
        softAssert.assertEquals(BaseText.getCssValue("font-weight"), "400");
        softAssert.assertEquals(BaseText.getCssValue("font-size"), "16px");
        softAssert.assertEquals(BaseText.getCssValue("line-height"), "28px");
        softAssert.assertEquals(BaseText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertAll();
    }

    public void verifyNoErrorMessage_AdditionalIncome() {
        Assert.assertTrue(basicActions.waitForElementToDisappear(errorMessage, 30), "Error is displayed");
    }

    public void verifyErrorMessage_AdditionalIncome() {
        Assert.assertTrue(basicActions.waitForElementToBePresent(errorMessage, 30), "Error is NOT displayed");
    }

    public void verifyOptionSelected_AdditionalIncome(String optionName){
        switch (optionName){
            case "None of these":
                basicActions.waitForElementToBePresent(noneOfThese,30);
                softAssert.assertFalse(noneOfThese.getAttribute("class").contains("not-selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +  optionName);
        }
    }

    public void verifyAddtlIncomeOptionHdrError(String language){
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
        basicActions.waitForElementToDisappear(hdrError, 10);
        softAssert.assertAll();
    }

    public void verifyAddtlIncomeEnteredData(String addtlIncomeOption, String Amount, String Frequency){
//        Frequency will have a number ex: "3: Monthly"
        switch (addtlIncomeOption) {
            case "Private Retirement income":
                basicActions.waitForElementToBePresent(retirementAmount,20);
                softAssert.assertEquals(retirementAmount.getAttribute("value"), Amount);
                softAssert.assertEquals(retirementFrequency.getAttribute("value"), Frequency);
                softAssert.assertAll();
                break;
            case "Pension":
                basicActions.waitForElementToBePresent(pensionAmount,20);
                softAssert.assertEquals(pensionAmount.getAttribute("value"), Amount);
                softAssert.assertEquals(pensionFrequency.getAttribute("value"), Frequency);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlIncomeOption);
        }
    }

    public void verifyAddtlIncomeOptionCheckboxCOCO(String state){
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
        basicActions.waitForElementListToBePresent(additlIncomeCheckboxes, 15);
        for (int i = 0; i < additlIncomeCheckboxes.size(); i++) {
            WebElement element1 = additlIncomeCheckboxes.get(i);
            WebElement element2 = additlIncomeBoxes.get(i);
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
        basicActions.waitForElementListToBePresent(additlIncomeCheckboxes, 15);
        for (int i = 0; i < additlIncomeCheckboxes.size(); i++) {
            WebElement element = additlIncomeCheckboxes.get(i);
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
            hdr_AdditionalIncome.click();
        }
    }

    public void verifyHoverStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresent(additlIncomeCheckboxes, 15);
        for (int i = 0; i < additlIncomeCheckboxes.size(); i++) {
            WebElement element = additlIncomeCheckboxes.get(i);
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
            hdr_AdditionalIncome.click();
        }
    }

    public void verifySelectedStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresent(additlIncomeCheckboxes, 15);
        for (int i = 0; i < additlIncomeCheckboxes.size(); i++) {
            WebElement element1 = additlIncomeCheckboxes.get(i);
            WebElement element2 = additlIncomeBoxes.get(i);
            element1.click();
            hdr_AdditionalIncome.click();
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
            hdr_AdditionalIncome.click();
        }
    }

}
