package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.SharedData;
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

    @FindBy(id = "DeclarationsAndSignature-GoBack")
    WebElement goBackButton;

    @FindBy(id = "DeclarationsAndSignature-SaveAndContinue")
    WebElement continueButton;

    public void enterSignatureinCoCo(){
        basicActions.waitForElementToBePresent(signatureInputField, 20);
        signatureInputField.sendKeys(SharedData.getPrimaryMember().getSignature());
    }
    public void goBack() {
        basicActions.waitForElementToBeClickable(goBackButton,10);
        goBackButton.click();
    }

    public void submitApplicationCoCo()  {
        basicActions.waitForElementToBeClickable(continueButton,20);
        basicActions.click(continueButton);
    }
}
