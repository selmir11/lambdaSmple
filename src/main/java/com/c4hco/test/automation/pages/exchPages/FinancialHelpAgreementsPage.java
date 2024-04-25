package com.c4hco.test.automation.pages.exchPages;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
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
    @FindBy(id = "SOL-FinHelpAgreements-HaveReadTermsAgree-input")
    WebElement termsUsecheckbox;

    @FindBy(id ="SOL-FinHelpAgreements-Continue")
    WebElement continueButton;

    @FindBy(id = "SOL-FinHelpAgreements-Signature")
    WebElement signatureInput;

    @FindBy(id  = "SOL-FinHelpAgreements-ElectronicSignatureLegalEffect")
    WebElement signatureFinHelpInput;

    @FindBy(css="mat-checkbox input")
    WebElement termsAndAgreeChkbx;


    public void enterSignature(){
        basicActions.waitForElementToBeClickable(signatureInput, 10);
        signatureInput.sendKeys(SharedData.getPrimaryMember().getSignature());
    }


    public void selectTermsAgreementsCheckbox(){
        termsAndAgreeChkbx.click();
    }

    public void clickContinue() {
        basicActions.waitForElementToBeClickable(continueButton, 5);
        basicActions.scrollToElement(continueButton);
        continueButton.click();

    }
}
