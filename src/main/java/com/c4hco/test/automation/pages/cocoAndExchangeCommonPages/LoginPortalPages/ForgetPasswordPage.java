package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages.LoginPage;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.Set;

public class ForgetPasswordPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    String resetPW= BasicActions.getUniquePW();
    public ForgetPasswordPage(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    LoginPage loginPage = new LoginPage(WebDriverManager.getDriver());

    @FindBy(xpath ="//div[@class='forgot-password-header']")
    WebElement forgotPasswordPageTitle;

    @FindBy(xpath ="//label[@class='input-label form-label ng-star-inserted']")
    WebElement lblEnterYourEmail;

    @FindBy(xpath ="//button[@id='submit-button']")
    WebElement submitBtn;
    @FindBy(xpath="//input[@id='un']")
    WebElement emailForgetPassword;
    @FindBy(xpath ="//span[@class='error-message']")
    WebElement errorUsername;

    @FindBy(xpath ="//div[@class='alert alert-warning mb-3 m-3 ng-star-inserted']")
    WebElement textNoticeIsSent;
    @FindBy(xpath ="//input[@type='password']")
    List<WebElement> resetPassword;



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
        basicActions.waitForElementToBePresent(emailForgetPassword,60);
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

    public void EnterValidEmailToAnyEnvQASTG(String qaEmail, String stgEmail) {
        basicActions.waitForElementToBePresent(emailForgetPassword,10);
        if (SharedData.getEnv().equals("qa")) {
            emailForgetPassword.sendKeys(qaEmail);
        } else if (SharedData.getEnv().equals("staging") ){
            emailForgetPassword.sendKeys(stgEmail);
        }

    }

    public void enterTheNewPasswordInCreateNewPasswordPage() {
        basicActions.switchtoactiveTab();
        Set<String> handles = basicActions.getDriver().getWindowHandles();
        for (String handle : handles) {
            if (basicActions.getDriver().getCurrentUrl().contains("aws.connectforhealthco.com/login-portal/createPassword")) {
                System.out.println(basicActions.getDriver().getCurrentUrl());
                System.out.println("The URL matches the desired link.");
                resetPassword.get(0).sendKeys(resetPW);
                resetPassword.get(1).sendKeys(resetPW);
                submitBtn.click();
                break;}
                basicActions.getDriver().switchTo().window(handle);
        }
    }
    public void loginAsIndividualWithPasswordResetCode(String qaEmail, String stgEmail) {
        basicActions.waitForElementToBePresent(loginPage.password, 40);
        basicActions.wait(60);
        if (SharedData.getEnv().equals("qa")) {
            loginPage.username.sendKeys(qaEmail);
        }else{
            loginPage.username.sendKeys(stgEmail);
        }
        loginPage.password.sendKeys(resetPW);
        loginPage.signInButton.click();
    }
}
