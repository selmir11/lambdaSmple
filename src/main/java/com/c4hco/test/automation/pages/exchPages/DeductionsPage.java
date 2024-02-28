package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DeductionsPage {
    private BasicActions basicActions;
    public DeductionsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "app-deductions .additional-income-row button")
    List<WebElement> addtlDeductionOptionsCheckbox;

    @FindBy(id = "ELIG-Deductions-AOSS-amountInput")
    WebElement txtAOSSAmount;

    @FindBy(id = "ELIG-Deductions-AOSS-frequencySelect")
    WebElement selectAOSSFrequency;

    @FindBy(id = "Deductions-SaveAndContinue")
    WebElement saveAndContinueBtn;

    public void selectAddtlDeductionOption(String addtlDeductionOption, String Amount, String Frequency){
        switch(addtlDeductionOption){
            case "Alimony or spousal support paid out":
                addtlDeductionOptionsCheckbox.get(0).click();
                basicActions.waitForElementToBeClickable(txtAOSSAmount, 10);
                txtAOSSAmount.sendKeys(Amount);

                Select dropdown = new Select(selectAOSSFrequency);
                dropdown.selectByVisibleText(" "+Frequency+" ");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlDeductionOption);
        }
    }

    public void selectNoneAddtlDeductionOption(){
        addtlDeductionOptionsCheckbox.get(10).click();
        saveAndContinueBtn.click();
    }

    public void clickContinue(){
        saveAndContinueBtn.click();
    }
}
