package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeclarationsAndSignaturePageCoCo {
    private BasicActions basicActions;

    public DeclarationsAndSignaturePageCoCo(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".input-label")
    WebElement signatureLabel;

    @FindBy(id = "ELIG-DeclarationsAndSignature-signatureBox")
    WebElement signatureInputField;

    @FindBy(id = "DeclarationsAndSignature-SaveAndContinue")
    WebElement continueButton;

    public void enterSignatureCoCo(){
        basicActions.waitForElementToBePresent(signatureLabel, 10);
        String label = signatureLabel.getText();
        label = label.replaceAll("Electronic Signature:", "");
        label = label.trim();

        basicActions.waitForElementToBeClickable(signatureInputField, 10);
        signatureInputField.click();
        signatureInputField.sendKeys(label);
    }

    public void submitApplicationCoCo()  {
        continueButton.click();
    }
}
