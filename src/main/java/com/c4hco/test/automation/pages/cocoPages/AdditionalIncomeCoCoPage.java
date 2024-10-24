package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdditionalIncomeCoCoPage {
    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public AdditionalIncomeCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "app-show-options button")
    List<WebElement> addIncomeButton;

    @FindBy(id = "ELIG-AdditionalIncome-ALMR-amountInput")
    WebElement alimonyAmount;

    @FindBy(id = "ELIG-AdditionalIncome-ALMR-frequencySelect")
    WebElement alimonyFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-CAPG-amountInput")
    WebElement capGainsAmount;

    @FindBy(id = "ELIG-AdditionalIncome-CAPG-frequencySelect")
    WebElement capGainsFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-IFRP-amountInput")
    WebElement rentalAmount;

    @FindBy(id = "ELIG-AdditionalIncome-IFRP-frequencySelect")
    WebElement rentalFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-PENS-amountInput")
    WebElement pensionAmount;

    @FindBy(id = "ELIG-AdditionalIncome-PENS-frequencySelect")
    WebElement pensionFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-RETR-amountInput")
    WebElement retirementAmount;

    @FindBy(id = "ELIG-AdditionalIncome-RETR-frequencySelect")
    WebElement retirementFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-TTWI-amountInput")
    WebElement socialSecurityAmount;

    @FindBy(id = "ELIG-AdditionalIncome-TTWI-frequencySelect")
    WebElement socialSecurityFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-UNEP-amountInput")
    WebElement unemploymentAmount;

    @FindBy(id = "ELIG-AdditionalIncome-UNEP-frequencySelect")
    WebElement unemploymentFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-INVI-amountInput")
    WebElement investmentAmount;

    @FindBy(id = "ELIG-AdditionalIncome-INVI-frequencySelect")
    WebElement investmentFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-CASP-amountInput")
    WebElement cashSupportAmount;

    @FindBy(id = "ELIG-AdditionalIncome-CASP-frequencySelect")
    WebElement cashSupportFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-UTFI-amountInput")
    WebElement untaxedForeignAmount;

    @FindBy(id = "ELIG-AdditionalIncome-UTFI-frequencySelect")
    WebElement untaxedForeignFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-RLTI-amountInput")
    WebElement royaltyAmount;

    @FindBy(id = "ELIG-AdditionalIncome-RLTI-frequencySelect")
    WebElement royaltyFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-TRBI-amountInput")
    WebElement taxableAmount;

    @FindBy(id = "ELIG-AdditionalIncome-TRBI-frequencySelect")
    WebElement taxableFrequency;

    @FindBy(id = "ELIG-AdditionalIncome-NoIncome-checkBoxButton")
    WebElement noneOfThese;

    @FindBy(css = "lib-list-error > lib-error-msg > div")
    WebElement hdrError;

    @FindBy(css = "lib-input .error-message")
    List<WebElement> addtlIncomeAmountError;

    @FindBy(css = "lib-dropdown .error-message")
    List<WebElement> additlIncomeFrequencyError;

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
        softAssert.assertEquals(hdr_AdditionalIncome.getText(), "Additional Income");
        softAssert.assertAll();
    }

    public void verifyHeadersAdditionalIncomePageSpanish(){
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 90);
        basicActions.waitForElementToBePresent(hdrAddInfoForYourself, 90);
        basicActions.waitForElementToBePresent(hdr_AdditionalIncome, 90);
        basicActions.waitForElementListToBePresent(addIncomeButton, 90);
        softAssert.assertTrue(hdrAddInfoForYourself.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_AdditionalIncome.getText(), "Otras fuentes de ingreso");
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

}
