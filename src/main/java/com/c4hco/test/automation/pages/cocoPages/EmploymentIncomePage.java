package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
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

    @FindBy(css = ".header-1")
    WebElement hdr_Income;

    @FindBy(css = ".header-2")
    WebElement hdr_EmploymentIncome;

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

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(css = "#EmploymentIncomeJob-GoBack")
    WebElement goBackButton;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBePresent(saveAndContinueButton,30);
        basicActions.click(saveAndContinueButton);
    }

    public void clickGoBackButton() {
        basicActions.waitForElementToBePresent(goBackButton,30);
        basicActions.click(goBackButton);
    }

    public void answerEmploymentQs(String employment){
        basicActions.waitForElementToDisappear( spinner, 40 );
        switch(employment) {
            case "Yes":
                basicActions.waitForElementToBePresent(employmentYesButton, 100);
                employmentYesButton.click();
                break;
            case "No":
                basicActions.waitForElementToBePresent(employmentNoButton, 100);
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
public void verifyHeadersEmploymentIncomePage(String language){
    switch (language){
        case "English":
            verifyHeadersEmploymentIncomePageEnglish();
            break;
        case "Spanish":
            verifyHeadersEmploymentIncomePageSpanish();
            break;
        default:
            throw new IllegalArgumentException("Invalid option: " + language);
    }
}

    public void verifyHeadersEmploymentIncomePageEnglish(){
        basicActions.waitForElementToBePresent(hdr_Income,15);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase( "Income: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_EmploymentIncome.getText(), "Employment Income (Please include income from all jobs and employers.)");
        softAssert.assertAll();
    }

    public void verifyHeadersEmploymentIncomePageSpanish(){
        basicActions.waitForElementToBePresent(hdr_Income,50);
        basicActions.waitForElementToBePresent(hdr_EmploymentIncome,50);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_EmploymentIncome.getText(), "Ingresos por empleo (Incluya el ingreso que recibe de todos los trabajos y empleadores.)");
        softAssert.assertAll();
    }

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