package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ForgetPasswordPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public ForgetPasswordPage(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath ="//div[@class='forgot-password-header']")
    WebElement forgotPasswordPageTitle;

    @FindBy(xpath ="//label[@class='input-label form-label ng-star-inserted']")
    WebElement lblEnterYourEmail;

    @FindBy(xpath ="//button[@id='submit-button']")
    WebElement submitBtn;
    @FindBy(xpath ="//input[@id='un']")
    WebElement emailForgetPassword;
    @FindBy(xpath ="//span[@class='error-message']")
    WebElement errorUsername;

    @FindBy(xpath ="//div[@class='alert alert-warning mb-3 m-3 ng-star-inserted']")
    WebElement textNoticeIsSent;



    public void validateForgotMyPasswordPageTitle(String language) {
        basicActions.waitForElementToBePresent(forgotPasswordPageTitle,10);
        switch (language) {
            case "English":
                softAssert.assertEquals(forgotPasswordPageTitle.getText(),"Forgot my password");
                break;
            case "Spanish":
                softAssert.assertEquals(forgotPasswordPageTitle.getText(),"Olvid\u00E9 mi contrase\u00F1a");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void enterPasswordText(String language) {
        basicActions.waitForElementToBePresent(lblEnterYourEmail,10);
        switch (language) {
            case "English":
                softAssert.assertEquals(lblEnterYourEmail.getText(),"Enter your username in order to receive a link to reset your password");
                break;
            case "Spanish":
                softAssert.assertEquals(lblEnterYourEmail.getText(),"Para recibir un enlace para restablecer su contrase\u00F1a, ingrese su nombre de usuario");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void clickSubmit() {
        basicActions.waitForElementToBePresent(submitBtn,10);
        submitBtn.click();
    }

    public void errorUsernameRequiredText(String language) {
        basicActions.waitForElementToBePresent(errorUsername,10);
        switch (language) {
            case "English":
                softAssert.assertEquals(errorUsername.getText(),"Username is required");
                softAssert.assertEquals(lblEnterYourEmail.getText(),"Enter your username in order to receive a link to reset your password");

                break;
            case "Spanish":
                softAssert.assertEquals(errorUsername.getText(),"Se requiere su nombre de usuario");
                softAssert.assertEquals(lblEnterYourEmail.getText(),"Para recibir un enlace para restablecer su contrase\u00F1a, ingrese su nombre de usuario");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }


    public void enterValidPassword(String emailAddress) {
        basicActions.waitForElementToBePresent(emailForgetPassword,10);
        emailForgetPassword.sendKeys(emailAddress);
    }

    public void verifyNoticeIsSentText(String language) {
        basicActions.waitForElementToBePresent(textNoticeIsSent,50);
        switch (language) {
            case "English":
                softAssert.assertEquals(textNoticeIsSent.getText(),"An email has been sent to the address on file. If you did not receive an email, please contact our Service Center.");
                break;
            case "Spanish":
                softAssert.assertEquals(textNoticeIsSent.getText(),"Se ha enviado un correo electr\u00F3nico a la direcci\u00F3n que tenemos en el archivo. Si no recibi\u00F3 un correo electr\u00F3nico, comun\u00EDquese con el Centro de atenci\u00F3n al cliente.");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }
}
