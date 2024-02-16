package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class EmploymentInfoPage {
    private BasicActions basicActions;
    public EmploymentInfoPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsEmployed-YesButton")
    WebElement btnYesEmployed;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsEmployed-NoButton")
    WebElement btnNoEmployed;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsSelfEmployment-YesButton")
    WebElement btnYesSelfEmployed;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsSelfEmployment-NoButton")
    WebElement btnNoSelfEmployed;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-employerNameInput")
    WebElement txtCompanyName;

    @FindBy(id = "ELIG-employerAddress-addressLine1Input")
    WebElement txtAddressOne;

    @FindBy(id = "ELIG-employerAddress-addressLine2Input")
    WebElement txtAddressTwo;

    @FindBy(id = "ELIG-employerAddress-cityInput")
    WebElement txtCity;

    @FindBy(id = "ELIG-employerAddress-stateSelect")
    WebElement selectState;

    @FindBy(id = "ELIG-employerAddress-zipCodeInput")
    WebElement txtZip;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-amountInput")
    WebElement txtIncomeAmount;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-frequencySelect")
    WebElement selectIncomeFreq;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsIncomeSeasonal-YesButton")
    WebElement btnIsSeasonalYes;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsIncomeSeasonal-NoButton")
    WebElement btnIsSeasonalNo;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsIncomeSame-YesButton")
    WebElement btnIncomeSameYes;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsIncomeSame-NoButton")
    WebElement btnIncomeSameNo;

    @FindBy(id = "ExchEmploymentIncomeJob-SaveAndContinue")
    WebElement btnContinue;

    public void isUserEmployed(String employmentOption){
        basicActions.waitForElementToBeClickable(btnYesEmployed, 10);

        switch(employmentOption){
            case "Yes":
                btnYesEmployed.click();
                break;
            case "No":
                btnNoEmployed.click();
                break;
        }
    }

    public void isUserSelfEmplyed(String selfEmploymentOption){
        switch(selfEmploymentOption){
            case "Yes":
                btnYesSelfEmployed.click();
                break;
            case "No":
                btnNoSelfEmployed.click();
                break;
        }
    }

    public void addEmploymentInfo(String Salary, String Frequency){

        txtCompanyName.sendKeys("Test Company Name");
        txtAddressOne.sendKeys("123 Test Address");
        txtAddressTwo.sendKeys("Test Suite 321");
        txtCity.sendKeys("Denver");

        Select dropdown = new Select(selectState);
        dropdown.selectByVisibleText(" CO ");

        txtZip.sendKeys("80205");
        txtIncomeAmount.sendKeys(Salary);

        dropdown = new Select(selectIncomeFreq);
        dropdown.selectByVisibleText(" "+Frequency+" ");
    }

    public void isUserEmploymentSeasonal(String seasonalEmploymentOption){
        switch(seasonalEmploymentOption){
            case "Yes":
                btnIsSeasonalYes.click();
                break;
            case "No":
                btnIsSeasonalNo.click();
                break;
        }
    }

    public void projectedIncomeQuestion(String projectedUncomeOption){
        switch(projectedUncomeOption){
            case "Yes":
                btnIncomeSameYes.click();
                break;
            case "No":
                btnIncomeSameNo.click();
                break;
        }
    }

    public void saveAndContinue(){btnContinue.click();}
}