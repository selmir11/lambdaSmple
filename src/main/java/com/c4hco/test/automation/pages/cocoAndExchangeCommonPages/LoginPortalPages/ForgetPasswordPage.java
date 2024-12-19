package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages.LoginPage;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
    @FindBy(xpath ="//span[@class='error-message ng-star-inserted']")
    WebElement errorUsername;

    @FindBy(xpath ="//div[@class='alert alert-warning mb-3 m-3 ng-star-inserted']")
    WebElement textNoticeIsSent;
    @FindBy(xpath ="//input[@type='password']")
    List<WebElement> resetPassword;
    @FindBy(xpath ="//div[@class='help-block text-danger mb-3 m-3 text-center ng-star-inserted']")
    WebElement usedPWErrorMsg;
    @FindBy(xpath ="//div[@class='ng-star-inserted']")
    WebElement PWErrorMsg;



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
                resetPassword.get(0).clear();
                resetPassword.get(1).clear();
                resetPassword.get(0).sendKeys(resetPW);
                resetPassword.get(1).sendKeys(resetPW);
                submitBtn.click();
                System.out.println(resetPW);
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

    public void enterValidEmailOfTheAccountCreated() {
        basicActions.waitForElementToBePresentWithRetries(loginPage.password, 40);
        emailForgetPassword.sendKeys(SharedData.getPrimaryMember().getEmailId());
    }


    public void LoginAsIndividualWithPasswordResetCode() {
        basicActions.waitForElementToBePresent(loginPage.password, 40);
        loginPage.username.sendKeys(SharedData.getPrimaryMember().getEmailId());
        loginPage.password.sendKeys(resetPW);
        basicActions.waitForElementToBePresentWithRetries(loginPage.signInButton,30);
        loginPage.signInButton.click();
    }

    public void enterThePreviousPassword() {
        basicActions.waitForElementToBePresent(loginPage.password, 40);
        resetPassword.get(0).sendKeys(SharedData.getPrimaryMember().getPassword());
        resetPassword.get(1).sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(submitBtn, 40);
        submitBtn.click();
    }

    public void validateTheErrorMsgForUsedPassword(String language) {
        basicActions.waitForElementToBePresentWithRetries(usedPWErrorMsg,30);
        switch (language){
            case "English":
                softAssert.assertEquals(usedPWErrorMsg.getText()," Password requirements were not met. Password requirements: does not include any part of your username, first name or last name. Your password cannot be any of your last 24 passwords. ");
                break;
            case "Spanish":
                softAssert.assertEquals(usedPWErrorMsg.getText()," La contrase\u00F1a no cumple con los requisitos. Requisitos de la contrase\u00F1a: no debe contener ninguna parte de su nombre de usuario, ni su nombre, ni su apellido. Su contrase\u00F1a no puede ser ninguna de sus \u00FAltimas 24 contrase\u00F1as. ");
                break;

        }
    }

    public void validateCreateNewPasswordMustContainAtLeastCharactersErrorMessageIn(String language) {
        basicActions.waitForElementToBePresent(resetPassword.get(0), 10);
        resetPassword.get(0).clear();
        resetPassword.get(1).clear();
        resetPassword.get(0).sendKeys("Aa1");
        resetPassword.get(1).sendKeys("Aa1");

        switch(language){
            case "English":
                softAssert.assertEquals(PWErrorMsg.getText(),"Password must have at least 8 characters");
                break;
            case "Spanish":
                softAssert.assertEquals(PWErrorMsg.getText(),"La contrase\u00F1a debe tener al menos 8 caracteres");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validateCreateNewPasswordMustContainUppercaseCharacterErrorMessageIn(String language) {
        basicActions.waitForElementToBePresent(resetPassword.get(0), 10);
        resetPassword.get(0).clear();
        resetPassword.get(1).clear();
        resetPassword.get(0).sendKeys("12345678");
        resetPassword.get(1).sendKeys("12345678");

        switch(language){
            case "English":
                softAssert.assertEquals(PWErrorMsg.getText(),"Password must have at least 1 uppercase");
                break;
            case "Spanish":
                softAssert.assertEquals(PWErrorMsg.getText(),"La contrase\u00F1a debe tener al menos una may\u00FAscula");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validateCreateNewPasswordMustContainLowercaseCharacterErrorMessageIn(String language) {
        basicActions.waitForElementToBePresent(resetPassword.get(0), 10);
        resetPassword.get(0).clear();
        resetPassword.get(1).clear();
        resetPassword.get(0).sendKeys("ABCDEFGH1");
        resetPassword.get(1).sendKeys("ABCDEFGH1");

        switch(language){
            case "English":
                softAssert.assertEquals(PWErrorMsg.getText(),"Password must have at least 1 lowercase");
                break;
            case "Spanish":
                softAssert.assertEquals(PWErrorMsg.getText(),"La contrase\u00F1a debe tener al menos una min\u00FAscula");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validateCreateNewPasswordMustContainNumberErrorMessageIn(String language) {
        basicActions.waitForElementToBePresent(resetPassword.get(0), 10);
        resetPassword.get(0).clear();
        resetPassword.get(1).clear();
        resetPassword.get(0).sendKeys("abcdefgh");
        resetPassword.get(1).sendKeys("abcdefgh");
        switch(language){
            case "English":
                softAssert.assertEquals(PWErrorMsg.getText(),"Password must have at least 1 number");
                break;
            case "Spanish":
                softAssert.assertEquals(PWErrorMsg.getText(),"La contrase\u00F1a debe tener al menos 1 n\u00FAmero");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }


    public void validateCreateNewPasswordCannotContainPartOfTheUsernameErrorMessageIn(String typePW,String language) {
        basicActions.waitForElementToBePresent(resetPassword.get(0), 10);
        resetPassword.get(0).clear();
        resetPassword.get(1).clear();
        switch (typePW){
            case "username":
                resetPassword.get(0).sendKeys("1Soukaina@outlook");
                resetPassword.get(1).sendKeys("1Soukaina@outlook");
            break;
            case "previous password":
                resetPassword.get(0).sendKeys("ALaska12!");
                resetPassword.get(1).sendKeys("ALaska12!");

            break;
            case "first name":
                resetPassword.get(0).sendKeys(SharedData.getPrimaryMember().getFirstName());
                resetPassword.get(1).sendKeys(SharedData.getPrimaryMember().getFirstName());
            break;

        }
        submitBtn.click();
        basicActions.waitForElementToBePresentWithRetries(usedPWErrorMsg,80);
        verificationLanguage(language);

    }
    public void verificationLanguage(String language){
        basicActions.waitForElementToBePresentWithRetries(usedPWErrorMsg,60);
        switch(language){
            case "English":
                softAssert.assertEquals(usedPWErrorMsg.getText(),"Password requirements were not met. Password requirements: does not include any part of your username, first name or last name. Your password cannot be any of your last 24 passwords.");
                break;
            case "Spanish":
                softAssert.assertEquals(usedPWErrorMsg.getText(),"La contrase\u00F1a no cumple con los requisitos. Requisitos de la contrase\u00F1a: no debe contener ninguna parte de su nombre de usuario, ni su nombre, ni su apellido. Su contrase\u00F1a no puede ser ninguna de sus \u00FAltimas 24 contrase\u00F1as.");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validateCreateNewPasswordCannotContainTheFirstNameErrorMessageIn(String language) {
        basicActions.waitForElementToBePresent(resetPassword.get(0), 10);
        resetPassword.get(0).clear();
        resetPassword.get(1).clear();
        resetPassword.get(0).sendKeys(SharedData.getPrimaryMember().getFirstName());
        resetPassword.get(1).sendKeys(SharedData.getPrimaryMember().getFirstName());
        switch(language){
            case "English":
                softAssert.assertEquals(PWErrorMsg.getText(),"Password cannot contain first name");
                break;
            case "Spanish":
                softAssert.assertEquals(PWErrorMsg.getText(),"La contrase\u00F1a no puede incluir el nombre");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }
}
