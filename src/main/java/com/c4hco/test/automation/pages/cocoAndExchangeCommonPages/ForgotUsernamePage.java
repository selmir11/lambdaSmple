package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

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
    @FindBy(xpath ="//input[@id='fn']")
    WebElement firstName;
    @FindBy(xpath ="//input[@id='ln']")
    WebElement lastName;
    @FindBy(xpath ="//input[@id='phone']")
    WebElement phone;
    @FindBy(xpath ="//app-option-select-dropdown/div/div[1]")
    WebElement accountTypeDrp;
    @FindBy(xpath ="//app-option-select-dropdown//div[2]/div")
    List<WebElement> accountTypeOptions;

    @FindBy(xpath ="//button[@id='submit-button']")
    WebElement submitBTN;
    @FindBy(xpath ="//div[@class='alert alert-warning mb-3 mt-3 ng-star-inserted']")
    WebElement noticeIsSentMsg;
    public void informationSForForgotUsername(String language){
        if (SharedData.getEnv().equals("qa") & language.equals("English")){
            DataForForgotUsername("erty", "el", "123-456-7890", "Customer");
        }else if(SharedData.getEnv().equals("staging") & language.equals("English")){
            DataForForgotUsername("candy", "SpanishSTG", "111-111-1112", "Customer");
        }else if(SharedData.getEnv().equals("qa") & language.equals("Spanish")){
            DataForForgotUsername("candy", "SpanishQA", "111-111-1112", "Customer");
        }else{
            DataForForgotUsername("Primary", "Tucker", "111-111-1112", "Customer");
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
                accountTypeOptions.get(0).click();
                break;
            case "Certified Broker":
                accountTypeOptions.get(1).click();
                break;
            case "Program Manager":
                accountTypeOptions.get(2).click();
                break;
            case "Administrative Staff":
                accountTypeOptions.get(3).click();
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



}
