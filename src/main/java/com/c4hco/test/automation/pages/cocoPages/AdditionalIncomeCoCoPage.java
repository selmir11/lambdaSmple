package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdditionalIncomeCoCoPage {
    private BasicActions basicActions;

    public AdditionalIncomeCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "app-show-options button")
    List<WebElement> addIncomeButton;

    @FindBy(id = "ELIG-AdditionalIncome-NoIncome-checkBoxButton")
    WebElement cashSupportAmount;

    @FindBy(id = "ELIG-AdditionalIncome-CASP-frequencySelect")
    WebElement cashSupportFrequency;

    @FindBy(id = "AdditionalIncome-SaveAndContinue")
    WebElement saveAndContinueButton;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        saveAndContinueButton.click();
    }

    public void selectAddIncomeOption(String addtlIncomeOption, String Amount, String Frequency) {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 10);

        switch (addtlIncomeOption) {
            case "Cash Support":
                addIncomeButton.get(8).click();
                basicActions.waitForElementToBeClickable(cashSupportAmount, 10);
                cashSupportAmount.sendKeys(Amount);

                Select dropdown = new Select(cashSupportFrequency);
                dropdown.selectByVisibleText(" " + Frequency + " ");
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + addtlIncomeOption);
        }
    }

    public void selectNoneAddIncomeOption(){
        basicActions.waitForElementListToBePresent(addIncomeButton, 30);
        addIncomeButton.get(12).click();
    }

}
