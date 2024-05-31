package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EmploymentIncomePage {
    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public EmploymentIncomePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }


    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-IncomeJob-YesButton")
    WebElement employmentYesButton;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-IncomeJob-NoButton")
    WebElement employmentNoButton;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-amountInput")
    WebElement incomeInput;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-frequencySelect")
    WebElement incomeFrequencyDropdown;

    @FindBy(css = "lib-dropdown option")
    List<WebElement> incomeFrequencyOptions;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-SeasonalIncome-YesButton")
    WebElement incomeSeasonalYesButton;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-SeasonalIncome-NoButton")
    WebElement incomeSeasonalNoButton;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-IncomeChangeEveryYear-YesButton")
    WebElement incomeChangesYesButton;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-IncomeChangeEveryYear-NoButton")
    WebElement incomeChangesNoButton;

    @FindBy(id = "EmploymentIncomeJob-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(css = ".input-error-message")
    WebElement errorMessage;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton,30);
        basicActions.click(saveAndContinueButton);
    }

    public void answerEmploymentQs(String employment){
        switch(employment) {
            case "Yes":
                basicActions.waitForElementToBeClickable(employmentYesButton, 100);
                employmentYesButton.click();
                break;
            case "No":
                basicActions.waitForElementToBeClickable(employmentNoButton, 100);
                employmentNoButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + employment);
        }
    }

    public void enterIncomeAmount(String amountOfIncome){
        basicActions.waitForElementToBePresent(incomeInput, 10);
        incomeInput.sendKeys(amountOfIncome);
    }

    public void selectIncomeFrequency(String frequencyOfIncome){
        basicActions.waitForElementToBePresent(incomeFrequencyDropdown, 10);
        incomeFrequencyDropdown.click();

        basicActions.waitForElementListToBePresent(incomeFrequencyOptions, 10);
        switch(frequencyOfIncome) {
            case "Select Option":
                incomeFrequencyOptions.get(0).click();
                break;
            case "Annually":
                incomeFrequencyOptions.get(1).click();
                break;
            case "Every 2 weeks":
                incomeFrequencyOptions.get(2).click();
                break;
            case "Monthly":
                incomeFrequencyOptions.get(3).click();
                break;
            case "Twice a month":
                incomeFrequencyOptions.get(4).click();
                break;
            case "Weekly":
                incomeFrequencyOptions.get(5).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + frequencyOfIncome);
        }
    }

    public void answerIsIncomeSeasonalQs(String seasonal){
        switch(seasonal) {
            case "Yes":
                basicActions.waitForElementToBePresent(incomeSeasonalYesButton, 10);
                incomeSeasonalYesButton.click();
                break;
            case "No":
                basicActions.waitForElementToBePresent(incomeSeasonalNoButton, 10);
                incomeSeasonalNoButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + seasonal);
        }
    }

    public void answerIncomeChangesQs(String changes){
        switch(changes) {
            case "Yes":
                basicActions.waitForElementToBePresent(incomeChangesYesButton, 10);
                incomeChangesYesButton.click();
                break;
            case "No":
                basicActions.waitForElementToBePresent(incomeChangesNoButton, 10);
                incomeChangesNoButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + changes);
        }
    }

//////////////////////////////////////////////VALIDATION METHODS//////////////////////////////////////////////////

    public void verifyNoErrorMessage_EmploymentInfo() {
        softAssert.assertFalse(basicActions.waitForElementPresence(errorMessage, 20));
        softAssert.assertAll();
    }

    public void verifyJobOption_EmploymentInfo(String isEmployed) {
            switch (isEmployed){
                case "Yes":
                    basicActions.waitForElementToBePresent(employmentYesButton,15);
                    softAssert.assertTrue(employmentYesButton.getAttribute("class").contains("selected"));
                    softAssert.assertAll();
                    break;
                case "No":
                    basicActions.waitForElementToBePresent(employmentNoButton,15);
                    softAssert.assertTrue(employmentNoButton.getAttribute("class").contains("selected"));
                    softAssert.assertAll();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " +  isEmployed);
        }
    }
}