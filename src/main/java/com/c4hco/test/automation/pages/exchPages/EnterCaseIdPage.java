package com.c4hco.test.automation.pages.exchPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(id = "caseId")
    WebElement caseIDPlaceHolderText;

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Zip Code']")
    WebElement zipCodeText;

    @FindBy(id = "zipCode")
    WebElement verifyZipCodePlaceHolderTextEn;

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Last Name']")
    WebElement lastNameText;

    @FindBy(id = "lastName")
    WebElement LastNamePlaceHolderTextEn;

    @FindBy(xpath = "//*[@name='saveAndContinue']")
    WebElement saveAndContinueButton;

    @FindBy(xpath = "//input[@class='back-button-link' and @type='submit' and @name='back']")
    WebElement backButtonLink;

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

    @FindBy(xpath = "//input[contains(@class, 'back-button-link')]")
    WebElement backButtonLinkEs;

    // Determine the WebElement based on the expected text using switch-case
    public boolean verifyTheText(String expectedText) {
        WebElement pageElement = switch (expectedText) {
            case "Please fill out the following information found on your Health First Colorado denial notice" ->
                    healthFirstColoradoDenialNoticeText;
            case "Case ID" -> caseIDText;
            case "1BXXXXXX" -> caseIDPlaceHolderText;
            case "Zip Code" -> zipCodeText;
            case "XXXXX" -> verifyZipCodePlaceHolderTextEn;
            case "Last Name" -> lastNameText;
            case "" -> LastNamePlaceHolderTextEn;
            case "< Back" -> backButtonLink;
            case "Save and Continue" -> saveAndContinueButton;
            case "Anote la siguiente" -> healthFirstColoradoDenialNoticeTextEs;
            case "Identificaci" -> caseIDTextEs;
            case "digo postal" -> zipCodeTextEs;
            case "Apellido(s)" -> lastNameTextEs;
            case "< Atr" -> backButtonLinkEs;
            case "Guardar y Continuar" -> saveAndContinueButton;
            default ->
                // Throw NoSuchElementException when WebElement is not found
                    throw new NoSuchElementException("WebElement for '" + expectedText + "' not found.");
        };

        // Verify the text on the WebElement
        return basicActions.verifyElementText(pageElement, expectedText);
    }

}
