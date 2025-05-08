package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages;
import com.c4hco.test.automation.utils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class LoginPage {

    SoftAssert softAssert = new SoftAssert();

    @FindBy(id = "main-sign-in")
    WebElement signAdmin;

    @FindBy(id = "username_mf_error")
    WebElement usernameError;

    @FindBy(id = "password_mf_error")
    WebElement passwordError;

    @FindBy(id = "globe-image")
    WebElement languageDrpSignIn;
    @FindBy(id = "eng")
    WebElement languageDrpOptionSignInEnglish;
    @FindBy(id = "esp")
    WebElement languageDrpOptionSignInSpanish;

    private BasicActions basicActions;
    private Utils utils = new Utils(WebDriverManager.getDriver());

    public LoginPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openPage(String portalType) {
        basicActions.getDriver().get(utils.getBaseLoginUrl(portalType));
        basicActions.refreshPage();
    }

    public void clickSignIn() {
        signAdmin.click();
    }



    public void validateTheErrorMsgUsernameAndPasswordRequiredIn(String language) {
        basicActions.waitForElementToBePresentWithRetries(usernameError,60);
        basicActions.waitForElementToBePresentWithRetries(passwordError,60);
        switch (language){
            case "English":
                softAssert.assertEquals(usernameError.getText(),"Username is required");
                softAssert.assertEquals(passwordError.getText(),"Password is required");
            break;
            case "Spanish":
                softAssert.assertEquals(usernameError.getText(),"Se requiere su nombre de usuario");
                softAssert.assertEquals(passwordError.getText(),"Se requiere su contrase\u00F1a");
            break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);

        }
        softAssert.assertAll();
    }


    public void changeLanguage(String language) {

        basicActions.wait(250);
        switch (language) {
            case "English Login":
                basicActions.waitForElementToBePresent(languageDrpSignIn, 60);
                languageDrpSignIn.click();
                basicActions.waitForElementToBePresent(languageDrpOptionSignInEnglish, 60);
                languageDrpOptionSignInEnglish.click();
                break;
            case "Spanish Login":
                basicActions.waitForElementToBePresent(languageDrpSignIn, 60);
                languageDrpSignIn.click();
                basicActions.waitForElementToBePresent(languageDrpOptionSignInSpanish, 60);
                languageDrpOptionSignInSpanish.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        basicActions.wait(50);
    }

}