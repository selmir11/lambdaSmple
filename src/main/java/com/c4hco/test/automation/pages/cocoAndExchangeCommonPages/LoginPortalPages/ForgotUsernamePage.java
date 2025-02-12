package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ForgotUsernamePage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public ForgotUsernamePage(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(xpath ="//input[@id='fn-mf-error']")
    WebElement firstName;
    @FindBy(xpath ="//input[@id='ln-mf-error']")
    WebElement lastName;
    @FindBy(xpath ="//input[@id='phone']")
    WebElement phone;
    @FindBy(xpath ="//select[@id='at-mf-error']")
    WebElement accountTypeDrp;
    @FindBy(xpath ="//select[@id='at-mf-error']/option")
    List<WebElement> accountTypeOptions;

    @FindBy(xpath ="//button[@id='submit-button']")
    WebElement submitBTN;
    @FindBy(xpath ="//div[@class='alert alert-warning mb-3 mt-3 ng-star-inserted']")
    WebElement noticeIsSentMsg;
    @FindBy(xpath ="//span[@class='error-message ng-star-inserted']")
    List<WebElement> errorMsg;
    public void informationSForForgotUsername(String FirsnameSTG, String LastNameSTG, String phoneSTG, String accountTypeData, String FirsnameQA, String LastNameQA, String phoneQA){
            if (SharedData.getEnv().equals("qa") ) {
                DataForForgotUsername(FirsnameQA, LastNameQA, phoneQA, accountTypeData);
            } else if (SharedData.getEnv().equals("staging")) {
                DataForForgotUsername(FirsnameSTG, LastNameSTG, phoneSTG, accountTypeData);
            }

    }

    public void DataForForgotUsername(String firstNameData, String lastNameData, String phoneData, String accountTypeData) {
        basicActions.waitForElementToBePresent(firstName,20);
        firstName.sendKeys(firstNameData);
        lastName.sendKeys(lastNameData);
        phone.sendKeys(phoneData);
        accountTypeDrp.click();
        switch (accountTypeData){
            case "Customer":
                accountTypeOptions.get(1).click();
                break;
            case "Certified Broker":
                accountTypeOptions.get(2).click();
                break;
            case "Program Manager":
                accountTypeOptions.get(3).click();
                break;
            case "Administrative Staff":
                accountTypeOptions.get(4).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + accountTypeData);
        }
        submitBTN.click();
    }

    public void ValidateNoticeSentSuccessfulMsgIsDisplayed() {
        basicActions.waitForElementToBePresent(noticeIsSentMsg,20);
        softAssert.assertTrue(noticeIsSentMsg.isDisplayed());
        softAssert.assertEquals(noticeIsSentMsg.getText(), "An email has been sent to the address on file. If you did not receive an email, please contact our Service Center.");
        softAssert.assertAll();
    }


    public void clickSubmitOnForgotUsernamePage() {
        basicActions.waitForElementToBePresent(submitBTN,20);
        submitBTN.click();
    }

    public void verifyTheFirstNameErrorMsgIn(String language) {
        basicActions.waitForElementToBePresent(errorMsg.get(0),20);
        switch (language){
            case "English":
                softAssert.assertEquals(errorMsg.get(0).getText(),"First Name is required");
                softAssert.assertEquals(errorMsg.get(1).getText(),"Last Name is required");
                softAssert.assertEquals(errorMsg.get(2).getText(),"Phone number is required");
                softAssert.assertEquals(errorMsg.get(3).getText(),"Account Type is required");
                break;
            case "Spanish":
                softAssert.assertEquals(errorMsg.get(0).getText(),"El nombre es obligatorio");
                softAssert.assertEquals(errorMsg.get(1).getText(),"El apellido es obligatorio");
                softAssert.assertEquals(errorMsg.get(2).getText(),"El n\u00FAmero de tel\u00E9fono es obligatorio");
                softAssert.assertEquals(errorMsg.get(3).getText(),"El tipo de cuenta es obligatorio");
                break;
            case "Special character":
                softAssert.assertEquals(errorMsg.get(0).getText(),"First Name cannot contain special characters");
                softAssert.assertEquals(errorMsg.get(1).getText(),"Last Name cannot contain special characters");
                softAssert.assertEquals(errorMsg.get(2).getText(),"Please enter valid phone number");
                break;
            case "Special character Spanish":
                softAssert.assertEquals(errorMsg.get(0).getText(),"El nombre no puede contener caracteres especiales");
                softAssert.assertEquals(errorMsg.get(1).getText(),"El apellido no puede contener caracteres especiales");
                softAssert.assertEquals(errorMsg.get(2).getText(),"El n\u00FAmero de tel\u00E9fono es obligatorio");
                break;
        }
        softAssert.assertAll();
    }
}
