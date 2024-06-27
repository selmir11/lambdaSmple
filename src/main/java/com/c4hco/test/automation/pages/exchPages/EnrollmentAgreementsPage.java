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

    public void selectAgreementsCheckbox(String checkbox) {
        // TO DO: Update this method and remove the wait below
       basicActions.waitForElementListToBePresent(agreementsChckbx, 10);
        switch (checkbox) {
            case "Terms of Use":
                agreementsChckbx.get(0).click();
                break;
            case "Privacy Policy":
                agreementsChckbx.get(1).click();
                break;
            case "Understand Law":
                agreementsChckbx.get(2).click();
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
        basicActions.waitForElementToBeClickable(continueBtn, 5);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        continueBtn.click();
    }

    public void clickGoBack() {
        basicActions.waitForElementToBeClickable( goBackbtn,10 );
        basicActions.scrollToElement( goBackbtn );
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", goBackbtn);
        goBackbtn.click();

    }



}
