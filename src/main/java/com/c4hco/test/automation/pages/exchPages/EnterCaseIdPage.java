package com.c4hco.test.automation.pages.exchPages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.c4hco.test.automation.utils.BasicActions;

public class EnterCaseIdPage {
    private BasicActions basicActions;
    public EnterCaseIdPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);

    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Please fill out the following information found on your Health First Colorado denial notice']")
    WebElement healthFirstColoradoDenialNoticeText;

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Case ID']")
    WebElement caseIDText;

    @FindBy(xpath = "//input[@id='caseId' and @class='form-control' and @type='text' and @maxlength='8' and @placeholder='1BXXXXXX' and @name='caseId']") //
    WebElement caseIDPlaceHolderText;

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Zip Code']")
    WebElement zipCodeText;

    @FindBy(id = "zipCode")
    WebElement verifyZipCodePlaceHolderTextEn;

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Last Name']")
    WebElement lastNameText;

    @FindBy(id = "lastName")
    WebElement LastNamePlaceHolderTextEn;

    @FindBy(xpath = "//span[contains(text(),'Anote la siguiente')]")
    WebElement healthFirstColoradoDenialNoticeTextEs;

    @FindBy(xpath = "//span[contains(text(),'Identificaci')]")
    WebElement caseIDTextEs;

    @FindBy(id = "caseId")
    WebElement caseIDPlaceHolderTextEs;

    @FindBy(xpath = "//span[contains(text(),'digo postal')]")
    WebElement zipCodeTextEs;

    @FindBy(id = "zipCode")
    WebElement verifyZipCodePlaceHolderTextEs;

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Apellido(s)']")
    WebElement lastNameTextEs;

    @FindBy(id = "lastName")
    WebElement LastNamePlaceHolderTextEs;

    public void validateTheElementsOnEnterCaseIdPageEn() {
        assertElementText(healthFirstColoradoDenialNoticeText, "Please fill out the following information found on your Health First Colorado denial notice");
        assertElementText(caseIDText, "Case ID");
        assertPlaceholderText(caseIDPlaceHolderText, "1BXXXXXX");
        assertElementText(zipCodeText, "Zip Code");
        assertPlaceholderText(verifyZipCodePlaceHolderTextEn, "XXXXX");
        assertElementText(lastNameText, "Last Name");
        assertPlaceholderText(LastNamePlaceHolderTextEn, "");

    }

    public void validateTheElementsOnEnterCaseIdPageEs() {
        assertElementText(healthFirstColoradoDenialNoticeTextEs, "Anote la siguiente informaci");
        assertElementText(caseIDTextEs, "del caso");
        assertPlaceholderText(caseIDPlaceHolderTextEs, "1BXXXXXX");
        assertElementText(zipCodeTextEs, "digo postal");
        assertPlaceholderText(verifyZipCodePlaceHolderTextEs, "XXXXX");
        assertElementText(lastNameTextEs, "Apellido(s)");
        assertPlaceholderText(LastNamePlaceHolderTextEs, "");
    }
    private void assertElementText(WebElement element, String expectedText) {
        String actualText = element.getText().trim();
        Assert.assertTrue("Expected text '" + expectedText + "' not found in actual text: '" + actualText + "'", actualText.contains(expectedText));
    }

    private void assertPlaceholderText(WebElement element, String expectedPlaceholder) {
        String actualPlaceholder = element.getAttribute("placeholder");
        Assert.assertEquals("Expected placeholder text '" + expectedPlaceholder + "' not found in actual placeholder: '" + actualPlaceholder + "'", expectedPlaceholder, actualPlaceholder);
    }

}
