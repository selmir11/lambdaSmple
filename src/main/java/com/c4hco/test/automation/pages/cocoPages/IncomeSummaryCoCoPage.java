package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class IncomeSummaryCoCoPage {

    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    public IncomeSummaryCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "div.total-income-width div")
    WebElement totalAnnualIncome;

    @FindBy(css = "lib-option-buttons button")
    List<WebElement> projectedIncomeButtons;

    @FindBy(id = "ELIG-summaryDetails-incomeAmountInput")
    WebElement projectedIncomeInput;

    @FindBy(id = "pageId-SaveAndContinue")
    WebElement saveAndContinueButton;

    public void verifyTotalAnnualIncome(String Amount){
        basicActions.waitForElementToBePresent(totalAnnualIncome, 10);
        softAssert.assertTrue(totalAnnualIncome.getText().contains(Amount), "Amount is incorrect");
        softAssert.assertAll();
    }

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        saveAndContinueButton.click();
    }

    public void selectProjectedIncome(String projectedIncome){
        switch(projectedIncome){
            case "Yes":
                basicActions.waitForElementListToBePresent(projectedIncomeButtons, 15);
                projectedIncomeButtons.get(0).click();
                break;
            case "No":
                basicActions.waitForElementListToBePresent(projectedIncomeButtons, 15);
                projectedIncomeButtons.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + projectedIncomeButtons);
        }
    }

    public void enterProjectedIncomeAmountCoCo(String amount){
        basicActions.waitForElementToBePresent(projectedIncomeInput, 10);
        projectedIncomeInput.sendKeys(amount);
    }
}
