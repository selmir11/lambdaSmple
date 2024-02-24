package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdditionalIncomePage {

    private BasicActions basicActions;
    public AdditionalIncomePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "ELIG-AdditionalIncome-CAPG-amountInput")
    WebElement txtCapitalGainsAmount;

    @FindBy(id = "ELIG-AdditionalIncome-CAPG-frequencySelect")
    WebElement selectCAPGFrequency;
    @FindBy(id = "AdditionalIncome-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(css = ".additional-income-row button")
    List<WebElement> addtlIncomeOptionsCheckbox;

    public void selectAddtlIncomeOption(String addtlIncomeOption, String Amount, String Frequency){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 10);

        switch(addtlIncomeOption){
            case "Capital Gains":
                addtlIncomeOptionsCheckbox.get(1).click();
                basicActions.waitForElementToBeClickable(txtCapitalGainsAmount, 10);
                txtCapitalGainsAmount.sendKeys(Amount);

                Select dropdown = new Select(selectCAPGFrequency);
                dropdown.selectByVisibleText(" "+Frequency+" ");
                break;
        }
    }

    public void selectNoneAddtlIncomeOption(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 10);
        addtlIncomeOptionsCheckbox.get(12).click();
        saveAndContinueBtn.click();
    }

    public void clickContinue(){saveAndContinueBtn.click();}
}
