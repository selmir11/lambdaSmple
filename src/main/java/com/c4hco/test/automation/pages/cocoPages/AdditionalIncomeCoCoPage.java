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

    @FindBy(id = "ELIG-AdditionalIncome-NoIncome-checkBoxButton")
    WebElement noneOfThese;

    @FindBy(id = "AdditionalIncome-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "AdditionalIncome-GoBack")
    WebElement goBackButton;

    @FindBy(css = ".banner-error-component")
    WebElement errorMessage;

    @FindBy(css = ".header-1")
    WebElement hdrAddInfoForYourself;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        basicActions.waitForElementToBeClickable(hdrAddInfoForYourself, 30);
        basicActions.scrollToElement(saveAndContinueButton);
        saveAndContinueButton.click();
    }

    public void selectAddIncomeOption(String addtlIncomeOption, String Amount, String Frequency) {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 10);

        switch (addtlIncomeOption) {
            case "Cash Support":
                addIncomeButton.get(8).click();
                basicActions.waitForElementToBeClickable(cashSupportAmount, 10);
                cashSupportAmount.sendKeys(Amount);

                Select dropdown8 = new Select(cashSupportFrequency);
                dropdown8.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Untaxed Foreign Income":
                addIncomeButton.get(9).click();
                basicActions.waitForElementToBeClickable(untaxedForeignAmount, 10);
                untaxedForeignAmount.sendKeys(Amount);

                Select dropdown9 = new Select(untaxedForeignFrequency);
                dropdown9.selectByVisibleText(" " + Frequency + " ");
                break;
            case "Royalty Income":
                addIncomeButton.get(10).click();
                basicActions.waitForElementToBeClickable(royaltyAmount, 10);
                royaltyAmount.sendKeys(Amount);

                Select dropdown10 = new Select(royaltyFrequency);
                dropdown10.selectByVisibleText(" " + Frequency + " ");
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + addtlIncomeOption);
        }
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

}
