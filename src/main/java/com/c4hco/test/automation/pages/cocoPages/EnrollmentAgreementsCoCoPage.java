package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EnrollmentAgreementsCoCoPage {
    private BasicActions basicActions;

    public EnrollmentAgreementsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css="mat-checkbox input")
    List<WebElement> agreementsCheckbox;

    @FindBy(id = "SOL-EnrollmentAgreements-AccountHolder")
    WebElement signatureLabel;

    @FindBy(id = "SOL-EnrollmentAgreements-Signature")
    WebElement signatureInput;

    @FindBy(id="SOL-EnrollmentAgreements-Continue")
    WebElement continueButton;

    public void selectAgreementsCheckboxCoCo(String checkbox){
        basicActions.waitForElementToBePresent(signatureLabel,20);
        switch(checkbox){
            case "Terms of Use":
                agreementsCheckbox.get(0).click();
                break;
            case "Privacy Policy":
                agreementsCheckbox.get(1).click();
                break;
            case "Dental Coverage":
                agreementsCheckbox.get(2).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +checkbox);
        }
    }

    public void enterSignatureAgreementsCoCo(){
        basicActions.waitForElementToBePresent(signatureLabel, 10);
        String label = signatureLabel.getText();
        label = label.trim();

        basicActions.waitForElementToBeClickable(signatureInput, 10);
        signatureInput.click();
        signatureInput.sendKeys(label);
    }

    public void selectContinueCoCo() {
        basicActions.waitForElementToBeClickable(continueButton, 5);
        continueButton.click();
    }
}
