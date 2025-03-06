package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CommunicationPreferencesPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "terms-and-conditions-button")
    WebElement continueCommunicationPreferences;

    @FindBy(id = "BP-CommunicationPreferences-GoBack")
    WebElement goBackCommunicationPreferences;

    @FindBy(id = "l_communication_preferences")
    WebElement communicationPreferencesTitle;

    @FindBy(xpath = "//label[@for='email']")
    WebElement emailFieldTitle;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(id = "valid-email")
    WebElement emailFieldValidEmailError;

    @FindBy(id = "mf-email")
    WebElement emailFieldRequiredError;

    @FindBy(xpath = "//label[@for='phoneNumber']")
    WebElement phoneNumberFieldTitle;

    @FindBy(xpath = "//input[@id='primaryPhoneNumber']")
    WebElement phoneNumberField;

    @FindBy(id = "valid-num")
    WebElement phoneNumberFieldRequiredError;

    private BasicActions basicActions;
    public CommunicationPreferencesPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickContinueCommunicationPreferencesPage(){
        basicActions.waitForElementToBePresent(continueCommunicationPreferences,10);
        continueCommunicationPreferences.click();
    }

    public void clickGoBackCommunicationPreferencesPage(){
        basicActions.waitForElementToBePresent(goBackCommunicationPreferences,10);
        goBackCommunicationPreferences.click();
    }

    public void validateCommunicationPreferencesPageTitle(){
        basicActions.waitForElementToBePresent(communicationPreferencesTitle,10);
        softAssert.assertEquals(communicationPreferencesTitle.getText(),"Communication Preferences");
        softAssert.assertAll();
    }

    public void validateFieldLabels(){
        basicActions.waitForElementToBePresent(emailFieldTitle,10);
        softAssert.assertEquals(emailFieldTitle.getText(),"Email:");
        softAssert.assertEquals(phoneNumberFieldTitle.getText(),"Phone number:");
        softAssert.assertAll();
    }

    public void validateEmailAutoPopulated(){
        basicActions.waitForElementToBePresent(emailField,10);
        BrokerDetails broker = SharedData.getBroker();
        softAssert.assertEquals(emailField.getAttribute("value"), broker.getEmail());
        softAssert.assertAll();
    }

    public void validatePhoneNumberAutoPopulated(){
        basicActions.waitForElementToBePresent(phoneNumberField,10);
        BrokerDetails broker = SharedData.getBroker();
        softAssert.assertEquals(phoneNumberField.getAttribute("value"), broker.getPhoneNumber());
        softAssert.assertAll();
    }

    public void validateRequiredFieldsErrorMessages(){
        basicActions.waitForElementToBePresent(emailField,10);
        emailField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        phoneNumberField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        softAssert.assertEquals(emailFieldRequiredError.getText(),"Email is required");
        softAssert.assertEquals(phoneNumberFieldRequiredError.getText(),"Please enter Phone Number");
        softAssert.assertAll();
    }

    public void validateValidErrorMessages(){
        basicActions.waitForElementToBePresent(emailField,10);
        emailField.clear();
        emailField.sendKeys("a$");
        phoneNumberField.clear();
        phoneNumberField.sendKeys("32");
        softAssert.assertEquals(emailFieldValidEmailError.getText(),"Enter valid email");
        softAssert.assertEquals(phoneNumberFieldRequiredError.getText(),"Valid phone number is required");
        softAssert.assertAll();
    }

}
