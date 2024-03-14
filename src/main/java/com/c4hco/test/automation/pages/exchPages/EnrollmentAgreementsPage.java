package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.SharedData;
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

    public void selectAgreementsCheckbox(String checkbox) {
        basicActions.waitForElementListToBePresent(agreementsChckbx, 20);
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
        String signature = SharedData.getFirstName()+ " "+SharedData.getLastName();
            basicActions.waitForElementToBeClickable(signatureInput, 10);
            signatureInput.click();
            signatureInput.sendKeys(signature);
    }

    public void clickContinue() {
        basicActions.waitForElementToBeClickable(continueBtn, 5);
        continueBtn.click();
    }

}
