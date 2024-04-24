package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FinancialHelpAgreementsPage {
    private BasicActions basicActions;
    public FinancialHelpAgreementsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(css="mat-checkbox input")
    WebElement termsAndAgreeChkbx;

    @FindBy(id="SOL-FinHelpAgreements-ElectronicSignatureLegalEffect")
    WebElement signatureInputBox;
    @FindBy(id="SOL-FinHelpAgreements-Continue")
    WebElement continueButton;

    public void selectTermsAgreementsCheckbox(){
        termsAndAgreeChkbx.click();
    }
    public void enterSignature(){
        basicActions.waitForElementToBeClickable(signatureInputBox, 10);
        signatureInputBox.sendKeys(SharedData.getPrimaryMember().getSignature());
    }

    public void clickContinue() {
        basicActions.waitForElementToBeClickable(continueButton, 5);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", continueButton);
        continueButton.click();
    }
}
