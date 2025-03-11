package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.SharedData;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

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

    @FindBy(xpath = "//div[@id='ELIG-DeclarationsAndSignature-signatureBox-container']//div[3]//input")
    WebElement signatureInputField;

    @FindBy(id = "DeclarationsAndSignature-GoBack")
    WebElement goBackButton;

    @FindBy(id = "DeclarationsAndSignature-SaveAndContinue")
    WebElement continueButton;

    @FindBy(xpath="//label[@class='input-label form-label ng-star-inserted']")
    WebElement getSignature;

    @FindBy(css = ".error-message")
    WebElement ErrorMessage;

    @FindBy(css = ".input-error-message .error-icon")
    WebElement ErrorIcon;

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

    public void verifyErrorFormat() {
        basicActions.waitForElementToBePresent(signatureInputField, 15);
        verifyElementStyles(signatureInputField);
        softAssert.assertAll();
    }

    public void verifyElementStyles(WebElement element) {
        softAssert.assertEquals(element.getCssValue("border-radius"), "6px", element + " Border radius mismatch");
        softAssert.assertEquals(element.getCssValue("border-color"), "rgb(150, 0, 0)", element + " Border color mismatch");
        softAssert.assertEquals(element.getCssValue("background-color"), "rgba(255, 255, 255, 1)", element + " Background color mismatch");
        softAssert.assertEquals(element.getCssValue("color"), "rgba(150, 0, 0, 1)", element + " Text color mismatch");
        softAssert.assertEquals(element.getCssValue("border"), "1px solid rgb(150, 0, 0)", element + " Border mismatch");
    }

    public void verifyElectronicSignatureLabelAndInputBox(String language) {
        basicActions.waitForElementToBePresent(signatureLabel, 15);
        basicActions.waitForElementToBePresent(signatureInputField, 15);
        switch (language){
            case "English":
                softAssert.assertEquals(signatureLabel.getText(), SharedData.getPrimaryMember().getCompleteFullName() + " Electronic Signature:");
                softAssert.assertTrue(signatureInputField.isDisplayed(), "Electronic signature input field is not visible");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(signatureLabel.getText(), SharedData.getPrimaryMember().getCompleteFullName() + " Firma electrónica:");
                softAssert.assertTrue(signatureInputField.isDisplayed(), "Electronic signature input field is not visible");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyErrorMessageWithoutEnteringAnythingInInputSignatureBox(String expectedErrorMsg) {
        basicActions.waitForElementToBePresent(ErrorMessage, 15);
        softAssert.assertEquals(ErrorMessage.getText(),expectedErrorMsg);
        softAssert.assertAll();
    }

    public void validateErrorMessageAndStyleProp(DataTable dataTable){
        basicActions.waitForElementToBePresent(ErrorIcon,20);
        basicActions.waitForElementToBePresent(ErrorMessage,10);

        List<Map<String,String>> data = dataTable.asMaps();
                String validationText = data.get(0).get("Text");
                String fontSize = data.get(0).get("fontSize");
                String fontFamily = data.get(0).get("fontFamily");
                String fontWeight = data.get(0).get("fontWeight");
                String color = data.get(0).get("color");
                String lineHeight = data.get(0).get("lineHeight");
                String textAlign = data.get(0).get("textAlign");
                softAssert.assertTrue(ErrorIcon.isDisplayed(),"Error Icon is not visible in the page");
                softAssert.assertTrue(ErrorMessage.isDisplayed(),"Error Message is not visible in the page");
                softAssert.assertEquals(ErrorMessage.getText(), validationText);
                softAssert.assertEquals(ErrorMessage.getCssValue("font-size"), fontSize);
                softAssert.assertEquals(ErrorMessage.getCssValue("font-family"), fontFamily);
                softAssert.assertEquals(ErrorMessage.getCssValue("font-weight"), fontWeight);
                softAssert.assertEquals(ErrorMessage.getCssValue("color"), color);
                softAssert.assertEquals(ErrorMessage.getCssValue("line-height"), lineHeight);
                softAssert.assertEquals(ErrorMessage.getCssValue("text-align"), textAlign);
                softAssert.assertAll();
    }

    public void validateLabelTextAndStyleProp(DataTable dataTable){
        basicActions.waitForElementToBePresent(signatureLabel,10);

        List<Map<String,String>> data = dataTable.asMaps();
        String fontSize = data.get(0).get("fontSize");
        String fontFamily = data.get(0).get("fontFamily");
        String fontWeight = data.get(0).get("fontWeight");
        String color = data.get(0).get("color");
        String lineHeight = data.get(0).get("lineHeight");
        String textAlign = data.get(0).get("textAlign");
        softAssert.assertTrue(signatureLabel.isDisplayed(),"Username Electronic signature label not visible");
        softAssert.assertEquals(signatureLabel.getCssValue("font-size"), fontSize);
        softAssert.assertEquals(signatureLabel.getCssValue("font-family"), fontFamily);
        softAssert.assertEquals(signatureLabel.getCssValue("font-weight"), fontWeight);
        softAssert.assertEquals(signatureLabel.getCssValue("color"), color);
        softAssert.assertEquals(signatureLabel.getCssValue("line-height"), lineHeight);
        softAssert.assertEquals(signatureLabel.getCssValue("text-align"), textAlign);
        softAssert.assertAll();
    }

    public void enterInvalidSignatureName() {
        basicActions.waitForElementToBePresent(signatureInputField, 15);
        signatureInputField.sendKeys("sakjchfdgldj");
    }

}
