package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmploymentIncomePage {
    private BasicActions basicActions;

    public EmploymentIncomePage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(css = "[controlname='isEmployed'] button")
    List<WebElement> employmentButton;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-amountInput")
    WebElement incomeInput;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-frequencySelect")
    WebElement incomeFrequencyDropdown;

    @FindBy(css = "lib-dropdown option")
    List<WebElement> incomeFrequencyOptions;

    @FindBy(css = "[controlname='isIncomeSeasonal'] button")
    List<WebElement> incomeSeasonalButton;

    @FindBy(css = "[controlname='isIncomeSameNextYear'] button")
    List<WebElement> incomeChangesButton;

    @FindBy(id = "EmploymentIncomeJob-SaveAndContinue")
    WebElement saveAndContinueButton;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        saveAndContinueButton.click();
    }

    public void answerEmploymentQs(String employment){
        basicActions.waitForElementListToBePresent(employmentButton, 10);
        switch(employment) {
            case ("Yes"):
                employmentButton.get(0).click();
                break;
            case ("No"):
                employmentButton.get(1).click();
                break;
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
            case ("Select Option"):
                incomeFrequencyOptions.get(0).click();
                break;
            case ("Annually"):
                incomeFrequencyOptions.get(1).click();
                break;
            case ("Every 2 weeks"):
                incomeFrequencyOptions.get(2).click();
                break;
            case ("Monthly"):
                incomeFrequencyOptions.get(3).click();
                break;
            case ("Twice a month"):
                incomeFrequencyOptions.get(4).click();
                break;
            case ("Weekly"):
                incomeFrequencyOptions.get(5).click();
                break;
        }
    }

    public void answerIsIncomeSeasonalQs(String seasonal){
        basicActions.waitForElementListToBePresent(incomeSeasonalButton, 10);
        switch(seasonal) {
            case ("Yes"):
                incomeSeasonalButton.get(0).click();
                break;
            case ("No"):
                incomeSeasonalButton.get(1).click();
                break;
        }
    }

    public void answerIncomeChangesQs(String changes){
        basicActions.waitForElementListToBePresent(incomeChangesButton, 10);
        switch(changes) {
            case ("Yes"):
                incomeChangesButton.get(0).click();
                break;
            case ("No"):
                incomeChangesButton.get(1).click();
                break;
        }
    }
}
