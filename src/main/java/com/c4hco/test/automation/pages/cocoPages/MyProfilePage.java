package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages.CreateAccountPage;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MyProfilePage {


    @FindBy(id = "preferredLanguage")
    WebElement PreferredLanguageDrpCoCo;

    @FindBy(css = "#preferredLanguage option")
    List<WebElement> LanguageDrpOptionsCoCo; //// Select option, English, Spanish

    @FindBy(id = "preferredContactMethod")
    WebElement PreferredContactDrpCoCo;

    @FindBy(css = "#preferredContactMethod option")
    List<WebElement> PreferredContactDrpOptionsCoCo; // Select option, Email, Mail
    @FindBy(xpath = "//button[contains(@class,'back-to-welcome')]")
    public WebElement backToWelcomeButton;

    @FindBy(css = ".bottom_buttons_container button")
    List<WebElement> MyProfileButtonCoCo; /// Go back, Make changes, Save buttons

    @FindBy(css = "#email")
    WebElement InputEmailCoCo;

    @FindBy(id = "mobilePhone")
    WebElement MobilephoneCoCo;

    @FindBy(id = "homePhone")
    WebElement HomephoneCoCo;

    @FindBy(css = "#userPassword")
    WebElement PasswordInputCoCo;

    @FindBy(css = ".password-button")
    WebElement PasswordSaveChangesCoCo;


    @FindBy(css = "p.heading")
    WebElement PasswordHeaderCoCo;

    @FindBy(css = "p.content")
    WebElement PasswordContentTextCoCo;

    @FindBy(css = "label[for='userPassword']")
    WebElement PasswordLabelCoCo;

    @FindBy(css = "a.toggle-links")
    WebElement ShowlinkCoCo;

    @FindBy(css = "a[type='button']")
    WebElement CancelLinkCoCo;

    @FindBy(css = "div.successful-banner.ng-star-inserted")
    WebElement SuccessfulBannerCoCo;

    @FindBy(css = ".error-message")
    WebElement ErrorMessageCoCo;

    @FindBy(css = "span.content_line_label.red-text")
    List<WebElement> ErrorMessageContactInformationCoCo;

    @FindBy(css = ".row.header-2.popup-page-header")
    WebElement headerChangePrimaryCoCo;
    @FindBy(css = ".action-link.col-sm-2.float-end.ng-star-inserted")
    WebElement changePrimaryContactCoCo;
    @FindBy(id = "contactNames")
    WebElement primaryContactDRPCoCo;
    @FindBy(css = ".btn.btn-lg.btn-md.btn-sml.primary-action-button.mb-1.ms-3")
    WebElement savePrimaryContactCoCo;

    @FindBy(xpath = "//*[@id='contactNames']/option[1]")
    WebElement dpdPrimaryChangeOpt1CoCo;

    @FindBy(xpath = "//*[@id='contactNames']/option[2]")
    WebElement dpdPrimaryChangeOpt2CoCo;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelPrimaryPopupCoCo;
    @FindBy(xpath = "//button[normalize-space()='Cancelar'] ")
    WebElement getCancelPrimaryPopupSpCoCo;

    @FindBy(css = "a#privacyPolicyLink.action-link1")
    WebElement privacyPolicyCoCo;

    @FindBy(css = "a#termsOfUseLink.action-link1")
    WebElement termsOfUseCoCo;

    @FindBy(css = "div.session-expiration-alert-modal-header.ng-tns-c3387428997-0")
    WebElement Headertimeoutcoco;

    @FindBy(css = "p.ng-tns-c3387428997-0")
    WebElement Questiontextcoco;

    @FindBy(id = "sessionExpirationAlert-Continue")
    WebElement YesTimeoutcoco;

    @FindBy(id = "sessionExpirationAlert-Logout")
    WebElement NoTimeoutcoco;

    @FindBy(css = "hr.myProfile_home_phone_hr")
    WebElement grayLineHPCoCo;

    @FindBy(css = "hr.myProfile_address_hr")
    WebElement grayLineAddressCoCo;

    @FindBy(css = "div.change-password-container")
    WebElement PasswordButtonCoCo;

    @FindBy(css = "span.change-password-msg")
    WebElement PasswordMessageCoCo;



    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    public MyProfilePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void backToWelcomeButton() {
        basicActions.waitForElementToBeClickable(backToWelcomeButton, 5);
        backToWelcomeButton.click();
    }

    public void clickMakeChangesButtonCoCo() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 60);
        MyProfileButtonCoCo.get(1).click();
    }

    public void clickSaveButtonCoCo() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40);
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInputCoCo, 40);
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChangesCoCo, 40);
        PasswordSaveChangesCoCo.click();
    }


    public void clickPreferredLanguageDrpCoCo() {
        basicActions.waitForElementToBePresent(PreferredLanguageDrpCoCo, 60);
        PreferredLanguageDrpCoCo.click();
    }


    public void clickPreferredContactDrpCoCo() {
        basicActions.waitForElementToBePresent(PreferredContactDrpCoCo, 60);
        PreferredContactDrpCoCo.click();
    }


    public void PreferredContactMethod(String contactPrefrences) {
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        clickPreferredContactDrpCoCo();
        switch (contactPrefrences) {
            case "Email":
                PreferredContactDrpOptionsCoCo.get(1).click();
                primaryMem.setContactPref("Email");
                primaryMem.setIncorrectContactPref("Mail");
                break;
            case "Mail":
                PreferredContactDrpOptionsCoCo.get(2).click();
                primaryMem.setContactPref("Mail");
                primaryMem.setIncorrectContactPref("Email");
            default:
                Assert.fail("Invalid argument passed");
        }
    }

    public void PreferredContactLanguageMethod(String langContactPreferred) {
        clickPreferredLanguageDrpCoCo();
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        switch (langContactPreferred) {
            case "English":
                LanguageDrpOptionsCoCo.get(1).click();
                primaryMem.setPrefLang("English");
                primaryMem.setIncorrectLanguage("Spanish");
                break;
            case "Spanish":
                LanguageDrpOptionsCoCo.get(2).click();
                primaryMem.setPrefLang("Spanish");
                primaryMem.setIncorrectLanguage("English");
                break;
            default:
                Assert.fail("Invalid argument passed");
        }
    }

    public void verifyPasswordPopupTextOnMyProfileCoCoPage(String language) {
        switch (language) {
            case "English":
                verifyPasswordPopupTextOnMyProfilePageCoCoEnglish();
                break;
            case "Spanish":
                verifyPasswordPopupTextOnMyProfilePageCoCoSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyPasswordPopupTextOnMyProfilePageCoCoEnglish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40);
        MyProfileButtonCoCo.get(1).click();
        LanguageDrpOptionsCoCo.get(2).click();
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeaderCoCo, 10);
        softAssert.assertEquals(PasswordHeaderCoCo.getText(), "Password required");
        softAssert.assertEquals(PasswordHeaderCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordHeaderCoCo.getCssValue("font-size"), "20px");
        softAssert.assertEquals(PasswordHeaderCoCo.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(PasswordContentTextCoCo.getText(), "For your security, please enter your password to save changes.");
        softAssert.assertEquals(PasswordContentTextCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordContentTextCoCo.getCssValue("font-size"), "15px");
        softAssert.assertEquals(PasswordContentTextCoCo.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(PasswordLabelCoCo.getText(), "Password");
        softAssert.assertEquals(PasswordLabelCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordLabelCoCo.getCssValue("font-size"), "16px");
        softAssert.assertEquals(PasswordLabelCoCo.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(ShowlinkCoCo.getText(), "Show");
        softAssert.assertEquals(ShowlinkCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ShowlinkCoCo.getCssValue("font-size"), "16px");
        softAssert.assertEquals(ShowlinkCoCo.getCssValue("color"), "rgba(16, 111, 153, 1)");
        softAssert.assertEquals(CancelLinkCoCo.getText(), "Cancel");
        softAssert.assertEquals(CancelLinkCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(CancelLinkCoCo.getCssValue("font-size"), "16px");
        softAssert.assertEquals(CancelLinkCoCo.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(PasswordSaveChangesCoCo.getText(), "Save changes");
        softAssert.assertEquals(PasswordSaveChangesCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordSaveChangesCoCo.getCssValue("font-size"), "16px");
        softAssert.assertEquals(PasswordSaveChangesCoCo.getCssValue("color"), "rgba(252, 252, 252, 1)");
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(SuccessfulBannerCoCo, 10);
        softAssert.assertEquals(SuccessfulBannerCoCo.getText(), "Your changes have been successfully saved!");
        softAssert.assertAll();
    }


    public void verifyPasswordPopupTextOnMyProfilePageCoCoSpanish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 50);
        MyProfileButtonCoCo.get(1).click();
        LanguageDrpOptionsCoCo.get(1).click();
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeaderCoCo, 10);
        softAssert.assertEquals(PasswordHeaderCoCo.getText(), "Se requiere contrase\u00F1a");
        softAssert.assertEquals(PasswordHeaderCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordHeaderCoCo.getCssValue("font-size"), "20px");
        softAssert.assertEquals(PasswordHeaderCoCo.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(PasswordContentTextCoCo.getText(), "Por su seguridad, ingrese su contrase\u00F1a para guardar los cambios.");
        softAssert.assertEquals(PasswordContentTextCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordContentTextCoCo.getCssValue("font-size"), "15px");
        softAssert.assertEquals(PasswordContentTextCoCo.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(PasswordLabelCoCo.getText(), "Contrase\u00F1a");
        softAssert.assertEquals(PasswordLabelCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordLabelCoCo.getCssValue("font-size"), "16px");
        softAssert.assertEquals(PasswordLabelCoCo.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(ShowlinkCoCo.getText(), "Mostrar");
        softAssert.assertEquals(ShowlinkCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ShowlinkCoCo.getCssValue("font-size"), "16px");
        softAssert.assertEquals(ShowlinkCoCo.getCssValue("color"), "rgba(16, 111, 153, 1)");
        softAssert.assertEquals(CancelLinkCoCo.getText(), "Cancelar");
        softAssert.assertEquals(CancelLinkCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(CancelLinkCoCo.getCssValue("font-size"), "16px");
        softAssert.assertEquals(CancelLinkCoCo.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(PasswordSaveChangesCoCo.getText(), "Guardar cambios");
        softAssert.assertEquals(PasswordSaveChangesCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordSaveChangesCoCo.getCssValue("font-size"), "16px");
        softAssert.assertEquals(PasswordSaveChangesCoCo.getCssValue("color"), "rgba(252, 252, 252, 1)");
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(SuccessfulBannerCoCo, 10);
        softAssert.assertEquals(SuccessfulBannerCoCo.getText(), "Los cambios se guardaron correctamente!");
        softAssert.assertAll();
    }

    public void verifyCancelbuttonOnMyProfileCoCoPage(String language) {
        switch (language) {
            case "English":
                verifyCancelbuttonOnMyProfilePageEnglish();
                break;
            case "Spanish":
                verifyCancelbuttonOnMyProfilePageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }


    public void verifyCancelbuttonOnMyProfilePageEnglish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40);
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeaderCoCo, 10);
        softAssert.assertEquals(CancelLinkCoCo.getText(), "Cancel");
        CancelLinkCoCo.click();
        basicActions.waitForElementToBePresent(MyProfileButtonCoCo.get(1), 10);
        softAssert.assertAll();
    }


    public void verifyCancelbuttonOnMyProfilePageSpanish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 100);
        MyProfileButtonCoCo.get(1).click();
        LanguageDrpOptionsCoCo.get(2).click();
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeaderCoCo, 40);
        softAssert.assertEquals(CancelLinkCoCo.getText(), "Cancelar");
        CancelLinkCoCo.click();
        basicActions.waitForElementToBePresent(MyProfileButtonCoCo.get(1), 10);
        softAssert.assertAll();
    }

    public void verifyErrortextpopupOnMyProfileCoCoPage(String language) {
        switch (language) {
            case "English":
                verifyErrortextpopupOnMyProfileEnglish();
                break;
            case "Spanish":
                verifyErrortextpopupOnMyProfileSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }


    public void verifyErrortextpopupOnMyProfileEnglish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40);
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeaderCoCo, 10);
        PasswordSaveChangesCoCo.click();
        softAssert.assertEquals(ErrorMessageCoCo.getText(), "Please enter your password");
        CancelLinkCoCo.click();
        basicActions.waitForElementToBePresent(MyProfileButtonCoCo.get(1), 10);
        softAssert.assertAll();
    }


    public void verifyErrortextpopupOnMyProfileSpanish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 100);
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeaderCoCo, 40);
        PasswordSaveChangesCoCo.click();
        softAssert.assertEquals(ErrorMessageCoCo.getText(), "Ingrese su contrase\u00F1a");
        CancelLinkCoCo.click();
        basicActions.waitForElementToBePresent(MyProfileButtonCoCo.get(1), 10);
        softAssert.assertAll();
    }


    public void verifyIncorrectPasswordErrortextpopupOnMyProfileCoCoPage(String language) {
        switch (language) {
            case "English":
                verifyIncorrectPasswordErrortextpopupOnMyProfileEnglish();
                break;
            case "Spanish":
                verifyIncorrectPasswordErrortextpopupOnMyProfileSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }


    public void verifyIncorrectPasswordErrortextpopupOnMyProfileEnglish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40);
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeaderCoCo, 10);
        String newPassword = "ALaska15!";
        PasswordInputCoCo.sendKeys(newPassword);
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(ErrorMessageCoCo, 40);
        softAssert.assertEquals(ErrorMessageCoCo.getText(), "Incorrect password. After three failed attempts, your account will be locked for 15 minutes.");
        CancelLinkCoCo.click();
        basicActions.waitForElementToBePresent(MyProfileButtonCoCo.get(1), 10);
        softAssert.assertAll();
    }


    public void verifyIncorrectPasswordErrortextpopupOnMyProfileSpanish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 100);
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeaderCoCo, 40);
        String newPassword = "ALaska15!";
        PasswordInputCoCo.sendKeys(newPassword);
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(ErrorMessageCoCo, 40);
        softAssert.assertEquals(ErrorMessageCoCo.getText(), "Contrase\u00F1a incorrecta. Despu\u00E9s de tres intentos fallidos, su cuenta se bloquear\u00E1 durante 15 minutos.");
        CancelLinkCoCo.click();
        basicActions.waitForElementToBePresent(MyProfileButtonCoCo.get(1), 10);
        softAssert.assertAll();
    }

    public void ValidatethirdattemptincorrectPasswordCoCo() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 100);
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeaderCoCo, 40);
        String newPassword = "ALaska15!";
        PasswordInputCoCo.sendKeys(newPassword);
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(MyProfileButtonCoCo.get(1), 40);
        softAssert.assertAll();
    }

    public void ClickChangePrimaryContactOnMyProfilePageCoCo() {
        basicActions.waitForElementToBePresent(changePrimaryContactCoCo, 80);
        changePrimaryContactCoCo.click();
    }

    public void validateChangePrimaryContactPopupCoCo(String language) {
        switch (language) {
            case "English":
                validateChangePrimaryContactpopupEnglish();
                break;
            case "Spanish":
                validateChangePrimaryContactpopupSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }


    public void validateChangePrimaryContactpopupEnglish() {
        basicActions.waitForElementToBePresent(headerChangePrimaryCoCo, 2000);
        softAssert.assertEquals(headerChangePrimaryCoCo.getText(), "Change Primary Contact");
        primaryContactDRPCoCo.click();
        softAssert.assertEquals(dpdPrimaryChangeOpt1CoCo.getText(), SharedData.getMembers().get(0).getFirstName() + " " + SharedData.getMembers().get(0).getMiddleName() +" "+ SharedData.getMembers().get(0).getLastName());
        softAssert.assertEquals(dpdPrimaryChangeOpt2CoCo.getText(), SharedData.getPrimaryMember().getFullName());
        String firstName = SharedData.getMembers().get(0).getFirstName();
        primaryContactDRPCoCo.sendKeys(firstName);
        primaryContactDRPCoCo.sendKeys(Keys.ENTER);
        softAssert.assertEquals(cancelPrimaryPopupCoCo.getText(), "Cancel");
        softAssert.assertEquals(savePrimaryContactCoCo.getText(), "Save");
        softAssert.assertEquals(privacyPolicyCoCo.getText(), "Privacy Policy");
        softAssert.assertEquals(termsOfUseCoCo.getText(), "Terms Of Use");
        cancelPrimaryPopupCoCo.click();
        softAssert.assertAll();
    }


    public void validateChangePrimaryContactpopupSpanish() {
        basicActions.waitForElementToBePresent(headerChangePrimaryCoCo, 2000);
        softAssert.assertEquals(headerChangePrimaryCoCo.getText(), "Cambiar el contacto principal");
        primaryContactDRPCoCo.click();
        softAssert.assertEquals(dpdPrimaryChangeOpt1CoCo.getText(), SharedData.getMembers().get(0).getFirstName() + " " + SharedData.getMembers().get(0).getMiddleName() +" "+ SharedData.getMembers().get(0).getLastName());
        softAssert.assertEquals(dpdPrimaryChangeOpt2CoCo.getText(), SharedData.getPrimaryMember().getFullName());
        String firstName = SharedData.getMembers().get(0).getFirstName();
        primaryContactDRPCoCo.sendKeys(firstName);
        primaryContactDRPCoCo.sendKeys(Keys.ENTER);
        softAssert.assertEquals(getCancelPrimaryPopupSpCoCo.getText(), "Cancelar");
        softAssert.assertEquals(savePrimaryContactCoCo.getText(), "Guardar");
        softAssert.assertEquals(privacyPolicyCoCo.getText(), "Pol\u00EDtica de privacidad");
        softAssert.assertEquals(termsOfUseCoCo.getText(), "T\u00E9rminos de uso");
        savePrimaryContactCoCo.click();
        softAssert.assertAll();
    }

    public void VerifyTimeoutPopupCoco(String language) {
        switch (language) {
            case "English":
                verifyTimeoutPopupEnglishCoco();
                break;
            case "Spanish":
                verifyTimeoutPopupSpanishCoco();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }


    public void verifyTimeoutPopupEnglishCoco() {
        basicActions.wait(840000);
        //basicActions.waitForElementToBePresent(NoTimeout, 20);
        softAssert.assertEquals(Headertimeoutcoco.getText(), "Your session is about to end.");
        softAssert.assertEquals(NoTimeoutcoco.getText(), "No, sign me out");
        softAssert.assertEquals(YesTimeoutcoco.getText(), "Yes, stay signed in");
        basicActions.isElementDisplayed(Questiontextcoco, 10);
        YesTimeoutcoco.click();
        basicActions.waitForElementToBePresent(MyProfileButtonCoCo.get(1), 10);
        softAssert.assertAll();
    }


    public void verifyTimeoutPopupSpanishCoco() {
        basicActions.wait(840000);
        //basicActions.waitForElementToBePresent(NoTimeout, 20);
        softAssert.assertEquals(Headertimeoutcoco.getText(), "El tiempo de su sesi\u00F3n est\u00E1 por terminar.");
        softAssert.assertEquals(NoTimeoutcoco.getText(), "No, cierre mi sesi\u00F3n");
        softAssert.assertEquals(YesTimeoutcoco.getText(), "S\u00ED, deseo seguir en la sesi\u00F3n");
        basicActions.isElementDisplayed(Questiontextcoco, 10);
        NoTimeoutcoco.click();
        softAssert.assertAll();
    }
    public void ValidateSaveChangesEmailCoCo() {
        // Update email address/////////
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40);
        MyProfileButtonCoCo.get(1).click();
        System.out.println("Email ::" + SharedData.getPrimaryMember().getEmailId());
        String newEmail = "updated.automation1025@test.com";
        InputEmailCoCo.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        InputEmailCoCo.sendKeys(newEmail);
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInputCoCo, 40);
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChangesCoCo, 40);
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(SuccessfulBannerCoCo, 10);
        softAssert.assertEquals(SuccessfulBannerCoCo.getText(), "Your changes have been successfully saved!");
        // Revert email address/////////
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 100);
        MyProfileButtonCoCo.get(1).click();
        InputEmailCoCo.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        InputEmailCoCo.sendKeys(SharedData.getPrimaryMember().getEmailId());
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInputCoCo, 40);
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChangesCoCo, 40);
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(SuccessfulBannerCoCo, 10);
        softAssert.assertEquals(SuccessfulBannerCoCo.getText(), "Your changes have been successfully saved!");
        softAssert.assertAll();
    }

    public void updateContactEmailAddressCoco() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40);
        String oldEmail = SharedData.getPrimaryMember().getEmailId();
        SharedData.getPrimaryMember().setIncorrectEmail(oldEmail);
        String newEmail = "Updated"+oldEmail;
        SharedData.getPrimaryMember().setEmailId(newEmail);
        InputEmailCoCo.clear();
        InputEmailCoCo.sendKeys(newEmail);
    }

    public void ValidateSaveChangesPhonenumberCoCo() {
        /////update mobile number//////
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 200);
        MyProfileButtonCoCo.get(1).click();
        System.out.println("phoneNumber ::" + SharedData.getPrimaryMember().getPhoneNumber());
        String newMobile = "7205210110";
        MobilephoneCoCo.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        MobilephoneCoCo.sendKeys(newMobile);
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInputCoCo, 40);
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChangesCoCo, 40);
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(SuccessfulBannerCoCo, 10);
        softAssert.assertEquals(SuccessfulBannerCoCo.getText(), "Your changes have been successfully saved!");
        ////// Update home phone number///////
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 200);
        MyProfileButtonCoCo.get(1).click();
        System.out.println("phoneNumber ::" + SharedData.getPrimaryMember().getPhoneNumber());
        String newHome = "3037182114";
        HomephoneCoCo.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        HomephoneCoCo.sendKeys(newHome);
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInputCoCo, 40);
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChangesCoCo, 40);
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(SuccessfulBannerCoCo, 20);
        softAssert.assertEquals(SuccessfulBannerCoCo.getText(), "Your changes have been successfully saved!");

        softAssert.assertAll();
    }

    public void ValidateSaveChangesLanguageCoCo() {
        /////update Language to Spanish//////
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 200);
        MyProfileButtonCoCo.get(1).click();
        LanguageDrpOptionsCoCo.get(2).click();
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInputCoCo, 40);
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChangesCoCo, 40);
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(SuccessfulBannerCoCo, 20);
        softAssert.assertEquals(SuccessfulBannerCoCo.getText(), "Your changes have been successfully saved!");
        ////// Update Language to English///////

        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 200);
        MyProfileButtonCoCo.get(1).click();
        LanguageDrpOptionsCoCo.get(1).click();
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInputCoCo, 40);
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChangesCoCo, 40);
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(SuccessfulBannerCoCo, 10);
        softAssert.assertEquals(SuccessfulBannerCoCo.getText(), "Your changes have been successfully saved!");
        softAssert.assertAll();
    }

    public void ValidateSaveChangesContactMethodCoCo() {
        /////update contact method to Mail//////
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 200);
        MyProfileButtonCoCo.get(1).click();
        PreferredContactDrpOptionsCoCo.get(2).click();
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInputCoCo, 40);
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChangesCoCo, 40);
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(SuccessfulBannerCoCo, 20);
        softAssert.assertEquals(SuccessfulBannerCoCo.getText(), "Your changes have been successfully saved!");
        ////// Update contact method to Email///////

        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 200);
        MyProfileButtonCoCo.get(1).click();
        PreferredContactDrpOptionsCoCo.get(1).click();
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInputCoCo, 40);
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChangesCoCo, 40);
        PasswordSaveChangesCoCo.click();
        basicActions.waitForElementToBePresent(SuccessfulBannerCoCo, 10);
        softAssert.assertEquals(SuccessfulBannerCoCo.getText(), "Your changes have been successfully saved!");
        softAssert.assertAll();
    }

    public void validateErrorMessageCoCo(String language) {
        switch (language) {
            case "English":
                validateErrorMessageEnglishCoCo();
                break;
            case "Spanish":
                validateErrorMessageSpanishCoCo();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateErrorMessageEnglishCoCo() {
        // Update email address/////////
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40000);
        MyProfileButtonCoCo.get(1).click();
        InputEmailCoCo.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        basicActions.waitForElementToBePresent(MobilephoneCoCo, 40);
        MobilephoneCoCo.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        String newPhoneNumber = "303";
        MobilephoneCoCo.sendKeys(newPhoneNumber);
        basicActions.waitForElementToBePresent(HomephoneCoCo, 40);
        HomephoneCoCo.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        HomephoneCoCo.sendKeys(newPhoneNumber);
        MyProfileButtonCoCo.get(1).click();
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(0).getText(), "A valid email is required");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(1).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(1).getText(), "Please enter a valid phone number");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(1).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(2).getText(), "Please enter a valid phone number");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(2).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(grayLineHPCoCo.getCssValue("color"), "rgba(149, 147, 147, 1)");
        softAssert.assertEquals(grayLineAddressCoCo.getCssValue("color"), "rgba(149, 147, 147, 1)");
        softAssert.assertAll();
    }


    public void validateErrorMessageSpanishCoCo() {

        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(0).getText(), "Es obligatorio un correo electr\u00F3nico v\u00E1lido");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(1).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(1).getText(), "Ingrese un n\u00FAmero de tel\u00E9fono v\u00E1lido");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(1).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(2).getText(), "Ingrese un n\u00FAmero de tel\u00E9fono v\u00E1lido");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformationCoCo.get(2).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertAll();
    }

    public void verifyPasswordTextOnMyProfileExchPageCoCo(String language) {
        switch (language) {
            case "English":
                verifyPasswordTextOnMyProfilePageEnglishCoCo();
                break;
            case "Spanish":
                verifyPasswordTextOnMyProfilePageSpanishCoCo();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyPasswordTextOnMyProfilePageEnglishCoCo() {
        basicActions.waitForElementToBePresent(PasswordMessageCoCo, 10);
        softAssert.assertEquals(PasswordMessageCoCo.getText(), "Clicking on Change Password will log you out and take you to a Password Reset page.");
        softAssert.assertEquals(PasswordMessageCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordMessageCoCo.getCssValue("font-size"), "12px");
        softAssert.assertEquals(PasswordMessageCoCo.getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(PasswordButtonCoCo.getText(), "Change password");
        softAssert.assertAll();
    }


    public void verifyPasswordTextOnMyProfilePageSpanishCoCo() {
        basicActions.waitForElementToBePresent(PasswordMessageCoCo, 10);
        softAssert.assertEquals(PasswordMessageCoCo.getText(), "Al hacer clic en Cambiar contrase\u00F1a se cerrar\u00E1 su sesi\u00F3n y lo llevar\u00E1 a la p\u00E1gina de Restablecer contrase\u00F1a");
        softAssert.assertEquals(PasswordMessageCoCo.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordMessageCoCo.getCssValue("font-size"), "12px");
        softAssert.assertEquals(PasswordMessageCoCo.getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(PasswordButtonCoCo.getText(), "Cambiar contrase\u00F1a");
        softAssert.assertAll();
    }

    public void updateContactPhoneNumberCoco() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40);
        String oldHomePhNum = SharedData.getPrimaryMember().getPhoneNumber();
        SharedData.getPrimaryMember().setIncorrectHomePhone(oldHomePhNum);
        String newPhone = (String) CreateAccountPage.generatePhoneNumber();
        SharedData.getPrimaryMember().setPhoneNumber(newPhone);
        HomephoneCoCo.clear();
        HomephoneCoCo.sendKeys(newPhone);
    }

    public void updateMobilePhNumCoco() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40);
        String oldMobilePhNum = SharedData.getPrimaryMember().getIncorrectHomePhone()!=null ? SharedData.getPrimaryMember().getIncorrectHomePhone() :SharedData.getPrimaryMember().getPhoneNumber();
        SharedData.getPrimaryMember().setIncorrectMobilePhone(oldMobilePhNum);
        String newPhone = (String) CreateAccountPage.generatePhoneNumber();
        SharedData.getPrimaryMember().setAlternatePhNum(newPhone);
        MobilephoneCoCo.clear();
        MobilephoneCoCo.sendKeys(newPhone);
    }


}



