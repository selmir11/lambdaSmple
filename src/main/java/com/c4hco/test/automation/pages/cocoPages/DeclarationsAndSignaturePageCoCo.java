package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DeclarationsAndSignaturePageCoCo {

    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public DeclarationsAndSignaturePageCoCo(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".header-1")
    WebElement hdr_DeclarationsAndSignature;

    @FindBy(css = ".input-label")
    WebElement signatureLabel;

    @FindBy(id = "ELIG-DeclarationsAndSignature-signatureBox")
    WebElement signatureInputField;

    @FindBy(id = "DeclarationsAndSignature-GoBack")
    WebElement goBackButton;

    @FindBy(id = "DeclarationsAndSignature-SaveAndContinue")
    WebElement continueButton;

    @FindBy(xpath="//label[@class='input-label form-label']")
    WebElement getSignature;

    public void enterSignatureinCoCo(){
        basicActions.waitForElementToBePresent(signatureInputField, 20);
        signatureInputField.sendKeys(SharedData.getPrimaryMember().getCompleteFullName());
    }
    public void goBack() {
        basicActions.waitForElementToBeClickable(goBackButton,10);
        goBackButton.click();
    }

    public void submitApplicationCoCo()  {
        basicActions.waitForElementToBeClickableWithRetries(continueButton,20);
        basicActions.click(continueButton);
    }

    public void enterOBOSignature(){
        basicActions.waitForElementToBeClickable(signatureInputField, 100);
        // Extract the text from the element
        String originalText = getSignature.getText();

        // Remove "Electronic Signature:" from the text
        String modifiedText = originalText.replace(" Electronic Signature:", "");
        signatureInputField.sendKeys(modifiedText);
    }

    //////////////////////////////////////////////VALIDATION METHODS//////////////////////////////////////////////////
    public void verifyHeadersDeclarationsAndSignaturePage(String language){
        switch (language){
            case "English":
                verifyHeadersDeclarationsAndSignaturePageEnglish();
                break;
            case "Spanish":
                verifyHeadersDeclarationsAndSignaturePageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersDeclarationsAndSignaturePageEnglish(){
        basicActions.wait(250);
        basicActions.waitForElementToBePresentWithRetries(hdr_DeclarationsAndSignature,120);
        softAssert.assertEquals(hdr_DeclarationsAndSignature.getText(), "Declarations and Signature");
        softAssert.assertAll();
    }

    public void verifyHeadersDeclarationsAndSignaturePageSpanish(){
        basicActions.wait(250);
        basicActions.waitForElementToBePresentWithRetries(hdr_DeclarationsAndSignature,60);
        softAssert.assertEquals(hdr_DeclarationsAndSignature.getText(), "Declaraciones y firma");
        softAssert.assertAll();
    }

}
