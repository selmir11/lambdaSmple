package com.c4hco.test.automation.pages.exchPages;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class FinancialHelpAgreementsPage {


    private BasicActions basicActions;

    public FinancialHelpAgreementsPage (WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(),  this);

    }

    @FindBy(id ="SOL-FinHelpAgreements-Continue")
    WebElement continueButton;

    @FindBy(id = "SOL-FinHelpAgreements-ElectronicSignatureLegalEffect")
    WebElement signatureInput;
    @FindBy(xpath = "(//input[@id='SOL-FinHelpAgreements-ElectronicSignatureLegalEffect'])[2]")
    WebElement signatureForSecondTaxPayer;
    @FindBy(css="mat-checkbox input")
    WebElement termsAndAgreeChkbx;


    public void enterSignature(){
        basicActions.waitForElementToBeClickable(signatureInput, 10);
        signatureInput.sendKeys(SharedData.getPrimaryMember().getSignature());
    }

    public void enterFirstTaxPayerSignature(){
        String namePath = "(//div/div/span)[2]";
        String signature = basicActions.getDriver().findElement(By.xpath(namePath)).getText();
        signatureInput.click();
        signatureInput.sendKeys(signature);
    }
    public void enterSecondTaxPayerSignature(){
        String namePath = "(//div/div/span)[3]";
        String signature = basicActions.getDriver().findElement(By.xpath(namePath)).getText();
        signatureForSecondTaxPayer.click();
        signatureForSecondTaxPayer.sendKeys(signature);
    }

    public void selectTermsAgreementsCheckbox(){
        basicActions.waitForElementToBePresent(termsAndAgreeChkbx, 20);
        termsAndAgreeChkbx.click();
    }

    public void clickContinue() {
        basicActions.waitForElementToBeClickable(continueButton, 5);
        basicActions.scrollToElement(continueButton);
        continueButton.click();

    }
}
