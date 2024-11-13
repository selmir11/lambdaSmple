package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EnrollmentAgreementsPage {
    private BasicActions basicActions;

    public EnrollmentAgreementsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css="mat-checkbox input")
    List<WebElement> agreementsChckbx;

    @FindBy(id = "SOL-EnrollmentAgreements-Signature")
    WebElement signatureInput;

    @FindBy(id="SOL-EnrollmentAgreements-Continue")
    WebElement continueBtn;

    @FindBy(id = "SOL-EnrollmentAgreements-GoBack")
    WebElement goBackbtn;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id="SOL-EnrollmentAgreements-UnderstandAndAgree")
    WebElement understandAcknowledgeChckbx;

    @FindBy(id = "SOL-EnrollmentAgreements-UnderstandElectronicSignature")
    WebElement understandSigChckbx;

    @FindBy(id="SOL-EnrollmentAgreements-SubmitEnrollment")
    WebElement submitEnrollmentBtn;

    public void selectAgreementsCheckbox(String checkbox) {
       basicActions.waitForElementToDisappear( spinner, 15 );
       basicActions.waitForElementListToBePresentWithRetries(agreementsChckbx, 10);
        switch (checkbox) {
            case "Acknowledgement":
                understandAcknowledgeChckbx.click();
                break;
            case "Submit":
                understandSigChckbx.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option selected to click checkboxes: " + checkbox);
        }
    }


    public void enterSignature(){
            basicActions.waitForElementToBeClickable(signatureInput, 10);
            signatureInput.sendKeys(SharedData.getPrimaryMember().getSignature());
    }

    public void clickContinue() {

        basicActions.waitForElementToBePresent(continueBtn, 20);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        continueBtn.click();
    }
    public void clickSubmitEnrollment() {
        basicActions.waitForElementToBePresent(submitEnrollmentBtn, 15);
        basicActions.scrollToElement( submitEnrollmentBtn );
        submitEnrollmentBtn.click();
    }

    public void clickGoBack() {
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresent( goBackbtn,45 );
        basicActions.scrollToElement( goBackbtn );
        goBackbtn.click();


    }



}
