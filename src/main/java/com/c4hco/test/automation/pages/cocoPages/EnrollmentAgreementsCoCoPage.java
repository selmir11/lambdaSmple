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

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;
    @FindBy(css="mat-checkbox input")
    List<WebElement> agreementsCheckbox;

    @FindBy(id = "SOL-EnrollmentAgreements-AccountHolder")
    WebElement signatureLabel;

    @FindBy(id = "SOL-EnrollmentAgreements-Signature")
    WebElement signatureInput;

    @FindBy(id="SOL-EnrollmentAgreements-Continue")
    WebElement continueButton;

    @FindBy(id="SOL-EnrollmentAgreements-GoBack")
    WebElement goBackBtn;


    @FindBy(id="SOL-EnrollmentAgreements-UnderstandAndAgree")
    WebElement understandAcknowledgeChckbx;

    @FindBy(id = "SOL-EnrollmentAgreements-UnderstandElectronicSignature")
    WebElement understandSigChckbx;

    @FindBy(id="SOL-EnrollmentAgreements-SubmitEnrollment")
    WebElement submitEnrollmentBtn;

    public void selectAgreementsCheckboxCoCo(String checkbox){
        basicActions.waitForElementToDisappear(spinner,20);
        basicActions.waitForElementToBePresent(signatureLabel,20);
        basicActions.waitForElementListToBePresent(agreementsCheckbox, 10);
        switch(checkbox){
            // remove this area after code update 8/29
            case "Terms of Use":
                agreementsCheckbox.get(0).click();
                break;
            case "Privacy Policy":
                agreementsCheckbox.get(1).click();
                break;
            case "Dental Coverage":
                agreementsCheckbox.get(2).click();
                break;
            /////////////////////////////////////////////
            case "Acknowledgement":
                understandAcknowledgeChckbx.click();
                break;
            case "Submit":
                understandSigChckbx.click();
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

    public void clickSubmitEnrollment() {
        basicActions.waitForElementToBePresent(submitEnrollmentBtn, 15);
        basicActions.scrollToElement( submitEnrollmentBtn );
        submitEnrollmentBtn.click();
    }

    public void clickBackBtn() {
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresent(goBackBtn, 5);
        basicActions.scrollToElement(goBackBtn);
        goBackBtn.click();
    }

    public void validatePageText() {
        // header, subheader1, subheader2, subheader3, 3checkboxes, terms of use, privacy policy, dentalLaw, signature text, submission date, submission text.
        // text on buttons

    }
}
