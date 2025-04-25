package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class MyProfileExchPage {


    @FindBy(css = ".bottom_buttons_container button")
    List<WebElement> MyProfileButtonExch; /// Go back, Make changes, Save buttons

    @FindBy(id = "myProfile_email")
    WebElement EmailAddress;

    @FindBy(css = "#email")
    WebElement InputEmail;

    @FindBy(id = "myProfile_username")
    WebElement UsernameProfile;

    @FindBy(id = "myProfile_accountId")
    WebElement ProfileAccountId;

    @FindBy(id = "preferredLanguage")
    WebElement PreferredLanguageDrp;

    @FindBy(css = "#preferredLanguage option")
    List<WebElement> LanguageDrpOptions; //// Select option, English, Spanish

    @FindBy(id = "preferredContactMethod")
    WebElement PreferredContactDrp;

    @FindBy(css = "#preferredContactMethod option")
    List<WebElement> PreferredContactDrpOptions; // Select option, Email, Mail


    @FindBy(css = "div.myProfile_fullName")
    WebElement FullNameProfile;


    @FindBy(id = "myProfile_mobilePhone")
    WebElement MobilephonePrimaryChange;

    @FindBy(id = "myProfile_homePhone")
    WebElement HomephonePrimaryChange;

    @FindBy(id = "mobilePhone")
    WebElement Mobilephone;

    @FindBy(id = "homePhone")
    WebElement Homephone;

    @FindBy(css = "h1.myProfile_title")
    WebElement MyProfileHeader;

    @FindBy(css = ".myProfile_subheading")
    List<WebElement> MyProfileSubHeading; ///// Primary contact, Contact Information, Login & Security, Settings & Preferences

    @FindBy(css = "span.content_line_label")
    List<WebElement> MyProfileContentline;  ///// Name, Date of Birth, Social security number, Email, Mobile phone, Home phone, Residential address, Username, Password, account number, Preferred language contact, Preferred contact Method

    @FindBy(css = "span.content_line_label.red-text")
    List<WebElement> ErrorMessageContactInformation;

    @FindBy(css = "div.change-password-container")
    WebElement PasswordButton;

    @FindBy(css = "span.change-password-msg")
    WebElement PasswordMessage;
    @FindBy(css = ".action-link.col-sm-2.float-end.ng-star-inserted")
    WebElement changePrimaryContact;
    @FindBy(id = "contactNames")
    WebElement primaryContactDRP;
    @FindBy(css = ".btn.btn-lg.btn-md.btn-sml.primary-action-button.mb-1.ms-3")
    WebElement savePrimaryContact;

    @FindBy(css = "#userPassword")
    WebElement PasswordInput;

    @FindBy(css = ".password-button")
    WebElement PasswordSaveChanges;

    @FindBy(css = "p.heading")
    WebElement PasswordHeader;

    @FindBy(css = "p.content")
    WebElement PasswordContentText;

    @FindBy(css = "label[for='userPassword']")
    WebElement PasswordLabel;

    @FindBy(css = "a.toggle-links")
    WebElement Showlink;

    @FindBy(css = "a[type='button']")
    WebElement CancelLink;

    @FindBy(css = "div.successful-banner.ng-star-inserted")
    WebElement SuccessfulBanner;

    @FindBy(css = ".error-message")
    WebElement ErrorMessage;

    @FindBy(css = ".content_line_label.red-text")
    WebElement  EmailinUseMessage;

    @FindBy(css = "div.session-expiration-alert-modal-header.ng-tns-c2876597241-0")
    WebElement Headertimeout;

    @FindBy(css = "p.ng-tns-c3387428997-0")
    WebElement Questiontext;

    @FindBy(id = "sessionExpirationAlert-Continue")
    WebElement YesTimeout;

    @FindBy(id = "sessionExpirationAlert-Logout")
    WebElement NoTimeout;

    @FindBy(css = ".row.header-2.popup-page-header")
    WebElement headerChangePrimary;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
   WebElement cancelPrimaryPopup;

    @FindBy(xpath = "//button[normalize-space()='Cancelar'] ")
    WebElement getCancelPrimaryPopupSp;

    @FindBy(css = "a#privacyPolicyLink.action-link1")
    WebElement privacyPolicy;

    @FindBy(css = "a#termsOfUseLink.action-link1")
    WebElement termsOfUse;

    @FindBy(xpath = "//*[@id='contactNames']/option[1]")
    WebElement dpdPrimaryChangeOpt1;

    @FindBy(xpath = "//*[@id='contactNames']/option[2]")
    WebElement dpdPrimaryChangeOpt2;

    @FindBy(css = "hr.myProfile_home_phone_hr")
    WebElement grayLineHP;

    @FindBy(css = "hr.myProfile_address_hr")
    WebElement grayLineAddress;


    @FindBy(xpath = "//button[text()='Go back to welcome page']")
    WebElement GoBackToWelcomePage;

    @FindBy(css = ".action-link.col-sm-2.float-end.ng-star-inserted")
    List<WebElement>changePrimaryContactnotdisplay;


    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public MyProfileExchPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void backToWelcomeButtonExch() {
        basicActions.waitForElementToBeClickable(GoBackToWelcomePage, 60);
        GoBackToWelcomePage.click();
    }

    public void clickMakeChangesButton() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 60);
        MyProfileButtonExch.get(1).click();
    }

    public void clickSaveButton() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInput, 40);
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChanges, 40);
        PasswordSaveChanges.click();
    }

    public void clickSaveButtonObO() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        MyProfileButtonExch.get(1).click();

        basicActions.waitForElementToBePresent(SuccessfulBanner, 10);
        softAssert.assertEquals(SuccessfulBanner.getText(), "Your changes have been successfully saved!");
        softAssert.assertAll();
    }

    public void clickChangePasswordButton() {
        basicActions.waitForElementToBeClickable(PasswordButton, 15);
        PasswordButton.click();
    }

    public void clickPreferredLanguageDrp() {
        basicActions.waitForElementToBePresent(PreferredLanguageDrp, 60);
        PreferredLanguageDrp.click();
    }


    public void clickPreferredContactDrp() {
        basicActions.waitForElementToBePresent(PreferredContactDrp, 60);
        PreferredContactDrp.click();
    }

    public void clickCancelButton() {
        basicActions.waitForElementToBeClickable(CancelLink, 15);
        CancelLink.click();
    }

//////Validation Method/////////////////////////////////////////////

    public void verifyTextOnMyProfileExchPage(String language) {
        switch (language) {
            case "English":
                verifyTextOnMyProfilePageEnglish();
                break;
            case "Spanish":
                verifyTextOnMyProfilePageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }


    public void verifyTextOnMyProfilePageEnglish() {
        String formatedPhoneNumber = SharedData.getPrimaryMember().getPhoneNumber().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
        basicActions.waitForElementToBePresent(MyProfileHeader, 10);
        softAssert.assertEquals(MyProfileHeader.getText(), "My Profile");
        softAssert.assertEquals(MyProfileHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileHeader.getCssValue("font-size"), "36px");
        softAssert.assertEquals(MyProfileHeader.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getText(), "Primary Contact");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getCssValue("font-size"), "19px");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(0).getText(), "Name");
        softAssert.assertEquals(MyProfileContentline.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(FullNameProfile.getText(), SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(FullNameProfile.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(FullNameProfile.getCssValue("font-size"), "16px");
        softAssert.assertEquals(FullNameProfile.getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(1).getText(), "Date of Birth");
        softAssert.assertEquals(MyProfileContentline.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(2).getText(), "Social Security Number");
        softAssert.assertEquals(MyProfileContentline.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(2).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileSubHeading.get(1).getText(), "Contact Information");
        softAssert.assertEquals(MyProfileSubHeading.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileSubHeading.get(1).getCssValue("font-size"), "19px");
        softAssert.assertEquals(MyProfileSubHeading.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(3).getText(), "Email");
        softAssert.assertEquals(MyProfileContentline.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(3).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(UsernameProfile.getText(), SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(EmailAddress.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(EmailAddress.getCssValue("font-size"), "16px");
        softAssert.assertEquals(EmailAddress.getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(4).getText(), "Mobile Phone");
        softAssert.assertEquals(MobilephonePrimaryChange.getText(), formatedPhoneNumber);
        softAssert.assertEquals(MyProfileContentline.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(4).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(5).getText(), "Home Phone");
        softAssert.assertEquals(HomephonePrimaryChange.getText(), formatedPhoneNumber);
        softAssert.assertEquals(MyProfileContentline.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(5).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(6).getText(), "Residential Address");
        softAssert.assertEquals(MyProfileContentline.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(6).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileSubHeading.get(2).getText(), "Login & Security");
        softAssert.assertEquals(MyProfileSubHeading.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileSubHeading.get(2).getCssValue("font-size"), "19px");
        softAssert.assertEquals(MyProfileSubHeading.get(2).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(UsernameProfile.getText(), SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(UsernameProfile.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(UsernameProfile.getCssValue("font-size"), "16px");
        softAssert.assertEquals(UsernameProfile.getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(7).getText(), "Username");
        softAssert.assertEquals(MyProfileContentline.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(7).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(8).getText(), "Password");
        softAssert.assertEquals(MyProfileContentline.get(8).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(8).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(8).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(9).getText(), "Account Number");
        softAssert.assertEquals(MyProfileContentline.get(9).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(9).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(9).getCssValue("color"), "rgba(77, 77, 79, 1)");
        //softAssert.assertEquals(ProfileAccountId.getText(), SharedData.getPrimaryMember().getAccount_id());
        softAssert.assertEquals(ProfileAccountId.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ProfileAccountId.getCssValue("font-size"), "16px");
        softAssert.assertEquals(ProfileAccountId.getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileSubHeading.get(3).getText(), "Settings & Preferences");
        softAssert.assertEquals(MyProfileSubHeading.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileSubHeading.get(3).getCssValue("font-size"), "19px");
        softAssert.assertEquals(MyProfileSubHeading.get(3).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileButtonExch.get(0).getText(), "Go back to welcome page");
        softAssert.assertEquals(MyProfileButtonExch.get(1).getText(), "Make changes");
        clickMakeChangesButton();
        clickPreferredLanguageDrp();
        softAssert.assertEquals(MyProfileContentline.get(10).getText(), "Preferred Language of Contact");
        softAssert.assertEquals(MyProfileContentline.get(10).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(10).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(10).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(LanguageDrpOptions.get(1).getText(), "English");
        softAssert.assertEquals(LanguageDrpOptions.get(2).getText(), "Spanish");
        clickPreferredContactDrp();
        softAssert.assertEquals(MyProfileContentline.get(11).getText(), "Preferred Contact Method");
        softAssert.assertEquals(MyProfileContentline.get(11).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(11).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(11).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(PreferredContactDrpOptions.get(1).getText(), "Email");
        //softAssert.assertEquals(PreferredContactDrpOptions.get(2).getText(), "Mail");
        clickSaveButton();
        softAssert.assertEquals(MyProfileButtonExch.get(0).getText(), "Go back to welcome page");
        softAssert.assertAll();
    }

    public void verifyTextOnMyProfilePageSpanish() {
        basicActions.waitForElementToBePresent(MyProfileHeader, 10);
        softAssert.assertEquals(MyProfileHeader.getText(), "Mi P\u00E9rfil");
        softAssert.assertEquals(MyProfileHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileHeader.getCssValue("font-size"), "36px");
        softAssert.assertEquals(MyProfileHeader.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getText(), "Contacto principal");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getCssValue("font-size"), "19px");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(0).getText(), "Nombre");
        softAssert.assertEquals(MyProfileContentline.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(1).getText(), "Fecha de Nacimiento");
        softAssert.assertEquals(MyProfileContentline.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(2).getText(), "N\u00FAmero de Seguro Social");
        softAssert.assertEquals(MyProfileContentline.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(2).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileSubHeading.get(1).getText(), "Informacion de Contacto");
        softAssert.assertEquals(MyProfileSubHeading.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileSubHeading.get(1).getCssValue("font-size"), "19px");
        softAssert.assertEquals(MyProfileSubHeading.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(3).getText(), "Email");
        softAssert.assertEquals(MyProfileContentline.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(3).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(4).getText(), "Telefono Movil");
        softAssert.assertEquals(MyProfileContentline.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(4).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(5).getText(), "Telefono Residencial");
        softAssert.assertEquals(MyProfileContentline.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(5).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(6).getText(), "Direcci\u00F3n del Domicilio");
        softAssert.assertEquals(MyProfileContentline.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(6).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileSubHeading.get(2).getText(), "Acceso y Seguridad");
        softAssert.assertEquals(MyProfileSubHeading.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileSubHeading.get(2).getCssValue("font-size"), "19px");
        softAssert.assertEquals(MyProfileSubHeading.get(2).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(7).getText(), "Nombre de Usario");
        softAssert.assertEquals(MyProfileContentline.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(7).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(8).getText(), "Contrase\u00F1a");
        softAssert.assertEquals(MyProfileContentline.get(8).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(8).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(8).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(9).getText(), "N\u00FAmero de Cuenta");
        softAssert.assertEquals(MyProfileContentline.get(9).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(9).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(9).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileSubHeading.get(3).getText(), "Configuraciones y Preferencias");
        softAssert.assertEquals(MyProfileSubHeading.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileSubHeading.get(3).getCssValue("font-size"), "19px");
        softAssert.assertEquals(MyProfileSubHeading.get(3).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(10).getText(), "Idioma de Contacto Preferido");
        softAssert.assertEquals(MyProfileContentline.get(10).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(10).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(10).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(11).getText(), "Medio de Contacto Preferido");
        softAssert.assertEquals(MyProfileContentline.get(11).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(11).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(11).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileButtonExch.get(0).getText(), "Volver a la pagina de bienvenida");
        softAssert.assertEquals(MyProfileButtonExch.get(1).getText(), "Hacer cambios");
        softAssert.assertAll();
    }

    public void verifyPasswordTextOnMyProfileExchPage(String language) {
        switch (language) {
            case "English":
                verifyPasswordTextOnMyProfilePageEnglish();
                break;
            case "Spanish":
                verifyPasswordTextOnMyProfilePageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyPasswordTextOnMyProfilePageEnglish() {
        basicActions.waitForElementToBePresent(PasswordMessage, 10);
        softAssert.assertEquals(PasswordMessage.getText(), "Clicking on Change Password will log you out and take you to a Password Reset page.");
        softAssert.assertEquals(PasswordMessage.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordMessage.getCssValue("font-size"), "12px");
        softAssert.assertEquals(PasswordMessage.getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(PasswordButton.getText(), "Change password");
        softAssert.assertAll();
    }


    public void verifyPasswordTextOnMyProfilePageSpanish() {
        basicActions.waitForElementToBePresent(PasswordMessage, 10);
        softAssert.assertEquals(PasswordMessage.getText(), "Al hacer clic en Cambiar contrase\u00F1a se cerrar\u00E1 su sesi\u00F3n y lo llevar\u00E1 a la p\u00E1gina de Restablecer contrase\u00F1a");
        softAssert.assertEquals(PasswordMessage.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordMessage.getCssValue("font-size"), "12px");
        softAssert.assertEquals(PasswordMessage.getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(PasswordButton.getText(), "Cambiar contrase\u00F1a");
        softAssert.assertAll();
    }


    public void PreferredContactMethod(String contactPrefrences) {
        clickPreferredContactDrp();
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        switch (contactPrefrences) {
            case "Email":
                PreferredContactDrpOptions.get(1).click();
                primaryMem.setContactPref("Email");
                primaryMem.setIncorrectContactPref("Mail");
                break;
            case "Mail":
                PreferredContactDrpOptions.get(2).click();
                primaryMem.setContactPref("Mail");
                primaryMem.setIncorrectContactPref("Email");
                break;
            default:
                Assert.fail("Invalid argument passed");
        }
    }

    public void PreferredContactLanguageMethod(String langContactPreferred) {
        clickPreferredLanguageDrp();
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        switch (langContactPreferred) {
            case "English":
                LanguageDrpOptions.get(1).click();
                primaryMem.setPrefLang("English");
                primaryMem.setIncorrectLanguage("Spanish");
                break;
            case "Spanish":
                LanguageDrpOptions.get(2).click();
                primaryMem.setPrefLang("Spanish");
                primaryMem.setIncorrectLanguage("English");
                break;
            default:
                Assert.fail("Invalid argument passed");
        }
    }

    public void ClickChangePrimaryContactOnMyProfilePage() {
        basicActions.waitForElementToBePresent(changePrimaryContact, 80);
        changePrimaryContact.click();
    }

    public void UpdateContactEmailAddress() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        String oldEmail = SharedData.getPrimaryMember().getEmailId();
        SharedData.getPrimaryMember().setIncorrectEmail(oldEmail);
        String newEmail = "Updated"+oldEmail;
        SharedData.getPrimaryMember().setEmailId(newEmail);
        InputEmail.clear();
        InputEmail.sendKeys(newEmail);
    }

    public void updateContactPhoneNumber() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        String oldHomePhNum = SharedData.getPrimaryMember().getPhoneNumber();
        SharedData.getPrimaryMember().setIncorrectHomePhone(oldHomePhNum);
        String newPhone = (String) basicActions.generatePhoneNumber();
        SharedData.getPrimaryMember().setPhoneNumber(newPhone);
        Homephone.clear();
        Homephone.sendKeys(newPhone);
    }

    public void updateMobilePhNum() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        String oldMobilePhNum = SharedData.getPrimaryMember().getIncorrectHomePhone()!=null ? SharedData.getPrimaryMember().getIncorrectHomePhone() :SharedData.getPrimaryMember().getPhoneNumber();
        SharedData.getPrimaryMember().setIncorrectMobilePhone(oldMobilePhNum);
        String newPhone = (String) basicActions.generatePhoneNumber();
        SharedData.getPrimaryMember().setAlternatePhNum(newPhone);
        Mobilephone.clear();
        Mobilephone.sendKeys(newPhone);
    }
    
    public void SelectTheHouseholdMemberAsPrimaryContact(String memberName) {
        basicActions.waitForElementToBeClickable(primaryContactDRP, 20);
        primaryContactDRP.click();
        updatePrimaryMemInSharedData(memberName);
        String firstName = SharedData.getPrimaryMember().getFirstName();
        primaryContactDRP.sendKeys(firstName);
        primaryContactDRP.sendKeys(Keys.ENTER);
        savePrimaryContact.click();
        basicActions.wait(60);
    }
    public void verifyPasswordPopupTextOnMyProfileExchPage(String language) {
        switch (language) {
            case "English":
                verifyPasswordPopupTextOnMyProfilePageEnglish();
                break;
            case "Spanish":
                verifyPasswordPopupTextOnMyProfilePageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyPasswordPopupTextOnMyProfilePageEnglish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        MyProfileButtonExch.get(1).click();
        LanguageDrpOptions.get(2).click();
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeader, 10);
        softAssert.assertEquals(PasswordHeader.getText(), "Password required");
        softAssert.assertEquals(PasswordHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordHeader.getCssValue("font-size"), "20px");
        softAssert.assertEquals(PasswordHeader.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(PasswordContentText.getText(), "For your security, please enter your password to save changes.");
        softAssert.assertEquals(PasswordContentText.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordContentText.getCssValue("font-size"), "15px");
        softAssert.assertEquals(PasswordContentText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(PasswordLabel.getText(), "Password");
        softAssert.assertEquals(PasswordLabel.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordLabel.getCssValue("font-size"), "16px");
        softAssert.assertEquals(PasswordLabel.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(Showlink.getText(), "Show");
        softAssert.assertEquals(Showlink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(Showlink.getCssValue("font-size"), "16px");
        softAssert.assertEquals(Showlink.getCssValue("color"), "rgba(16, 111, 153, 1)");
        softAssert.assertEquals(CancelLink.getText(), "Cancel");
        softAssert.assertEquals(CancelLink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(CancelLink.getCssValue("font-size"), "16px");
        softAssert.assertEquals(CancelLink.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(PasswordSaveChanges.getText(), "Save changes");
        softAssert.assertEquals(PasswordSaveChanges.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordSaveChanges.getCssValue("font-size"), "16px");
        softAssert.assertEquals(PasswordSaveChanges.getCssValue("color"), "rgba(252, 252, 252, 1)");
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(SuccessfulBanner, 10);
        softAssert.assertEquals(SuccessfulBanner.getText(), "Your changes have been successfully saved!");
        softAssert.assertAll();
    }


    public void verifyPasswordPopupTextOnMyProfilePageSpanish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 50);
        MyProfileButtonExch.get(1).click();
        LanguageDrpOptions.get(1).click();
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeader, 10);
        softAssert.assertEquals(PasswordHeader.getText(), "Se requiere contrase\u00F1a");
        softAssert.assertEquals(PasswordHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordHeader.getCssValue("font-size"), "20px");
        softAssert.assertEquals(PasswordHeader.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(PasswordContentText.getText(), "Por su seguridad, ingrese su contrase\u00F1a para guardar los cambios.");
        softAssert.assertEquals(PasswordContentText.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordContentText.getCssValue("font-size"), "15px");
        softAssert.assertEquals(PasswordContentText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(PasswordLabel.getText(), "Contrase\u00F1a");
        softAssert.assertEquals(PasswordLabel.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordLabel.getCssValue("font-size"), "16px");
        softAssert.assertEquals(PasswordLabel.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(Showlink.getText(), "Mostrar");
        softAssert.assertEquals(Showlink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(Showlink.getCssValue("font-size"), "16px");
        softAssert.assertEquals(Showlink.getCssValue("color"), "rgba(16, 111, 153, 1)");
        softAssert.assertEquals(CancelLink.getText(), "Cancelar");
        softAssert.assertEquals(CancelLink.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(CancelLink.getCssValue("font-size"), "16px");
        softAssert.assertEquals(CancelLink.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(PasswordSaveChanges.getText(), "Guardar cambios");
        softAssert.assertEquals(PasswordSaveChanges.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordSaveChanges.getCssValue("font-size"), "16px");
        softAssert.assertEquals(PasswordSaveChanges.getCssValue("color"), "rgba(252, 252, 252, 1)");
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(SuccessfulBanner, 10);
        softAssert.assertEquals(SuccessfulBanner.getText(), "Los cambios se guardaron correctamente!");
        softAssert.assertAll();
    }


    public void verifyCancelbuttonOnMyProfileExchPage(String language) {
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
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeader, 10);
        softAssert.assertEquals(CancelLink.getText(), "Cancel");
        CancelLink.click();
        basicActions.waitForElementToBePresent(MyProfileButtonExch.get(1), 10);
        softAssert.assertAll();
    }


    public void verifyCancelbuttonOnMyProfilePageSpanish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 100);
        MyProfileButtonExch.get(1).click();
        LanguageDrpOptions.get(2).click();
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeader, 40);
        softAssert.assertEquals(CancelLink.getText(), "Cancelar");
        CancelLink.click();
        basicActions.waitForElementToBePresent(MyProfileButtonExch.get(1), 10);
        softAssert.assertAll();
    }

    public void verifyErrortextpopupOnMyProfileExchPage(String language) {
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
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeader, 10);
        PasswordSaveChanges.click();
        softAssert.assertEquals(ErrorMessage.getText(), "Please enter your password");
        CancelLink.click();
        basicActions.waitForElementToBePresent(MyProfileButtonExch.get(1), 10);
        softAssert.assertAll();
    }


    public void verifyErrortextpopupOnMyProfileSpanish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 100);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeader, 40);
        PasswordSaveChanges.click();
        softAssert.assertEquals(ErrorMessage.getText(), "Ingrese su contrase\u00F1a");
        CancelLink.click();
        basicActions.waitForElementToBePresent(MyProfileButtonExch.get(1), 10);
        softAssert.assertAll();
    }


    public void verifyIncorrectPasswordErrortextpopupOnMyProfileExchPage(String language) {
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
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeader, 10);
        String newPassword = "ALaska15!";
        PasswordInput.sendKeys(newPassword);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(ErrorMessage, 40);
        softAssert.assertEquals(ErrorMessage.getText(), "Incorrect password. After three failed attempts, your account will be locked for 15 minutes.");
        CancelLink.click();
        basicActions.waitForElementToBePresent(MyProfileButtonExch.get(1), 10);
        softAssert.assertAll();
    }


    public void verifyIncorrectPasswordErrortextpopupOnMyProfileSpanish() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 100);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeader, 40);
        String newPassword = "ALaska15!";
        PasswordInput.sendKeys(newPassword);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(ErrorMessage, 40);
        softAssert.assertEquals(ErrorMessage.getText(), "Contrase\u00F1a incorrecta. Despu\u00E9s de tres intentos fallidos, su cuenta se bloquear\u00E1 durante 15 minutos.");
        CancelLink.click();
        basicActions.waitForElementToBePresent(MyProfileButtonExch.get(1), 10);
        softAssert.assertAll();
    }

    public void ValidatethirdattemptincorrectPassword() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 100);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordHeader, 40);
        String newPassword = "ALaska15!";
        PasswordInput.sendKeys(newPassword);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(MyProfileButtonExch.get(1), 40);
        softAssert.assertAll();
    }

    public void ValidateSaveChangesEmail() {
        // Update email address/////////
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        MyProfileButtonExch.get(1).click();
        System.out.println("Email ::" + SharedData.getPrimaryMember().getEmailId());
        String newEmail = "updated.automation1027@test.com";
        InputEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        InputEmail.sendKeys(newEmail);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInput, 40);
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChanges, 40);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(SuccessfulBanner, 10);
        softAssert.assertEquals(SuccessfulBanner.getText(), "Your changes have been successfully saved!");
        // Revert email address/////////
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 100);
        MyProfileButtonExch.get(1).click();
        InputEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        InputEmail.sendKeys(SharedData.getPrimaryMember().getEmailId());
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInput, 40);
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChanges, 40);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(SuccessfulBanner, 10);
        softAssert.assertEquals(SuccessfulBanner.getText(), "Your changes have been successfully saved!");
        softAssert.assertAll();
    }


    public void ValidateSaveChangesPhonenumber() {
        /////update mobile number//////
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 200);
        MyProfileButtonExch.get(1).click();
        System.out.println("phoneNumber ::" + SharedData.getPrimaryMember().getPhoneNumber());
        String newMobile = "7205210110";
        Mobilephone.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        Mobilephone.sendKeys(newMobile);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInput, 40);
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChanges, 40);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(SuccessfulBanner, 10);
        softAssert.assertEquals(SuccessfulBanner.getText(), "Your changes have been successfully saved!");
        ////// Update home phone number///////
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 200);
        MyProfileButtonExch.get(1).click();
        System.out.println("phoneNumber ::" + SharedData.getPrimaryMember().getPhoneNumber());
        String newHome = "3037182114";
        Homephone.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        Homephone.sendKeys(newHome);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInput, 40);
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChanges, 40);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(SuccessfulBanner, 20);
        softAssert.assertEquals(SuccessfulBanner.getText(), "Your changes have been successfully saved!");

        softAssert.assertAll();
    }

    public void ValidateSaveChangesLanguage() {
        /////update Language to Spanish//////
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 200);
        MyProfileButtonExch.get(1).click();
        LanguageDrpOptions.get(2).click();
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInput, 40);
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChanges, 40);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(SuccessfulBanner, 20);
        softAssert.assertEquals(SuccessfulBanner.getText(), "Your changes have been successfully saved!");
        ////// Update Language to English///////

        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 200);
        MyProfileButtonExch.get(1).click();
        LanguageDrpOptions.get(1).click();
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInput, 40);
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChanges, 40);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(SuccessfulBanner, 10);
        softAssert.assertEquals(SuccessfulBanner.getText(), "Your changes have been successfully saved!");
        softAssert.assertAll();
    }

    public void ValidateSaveChangesContactMethod() {
        /////update contact method to Mail//////
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 200);
        MyProfileButtonExch.get(1).click();
        PreferredContactDrpOptions.get(2).click();
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInput, 40);
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChanges, 40);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(SuccessfulBanner, 20);
        softAssert.assertEquals(SuccessfulBanner.getText(), "Your changes have been successfully saved!");
        ////// Update contact method to Email///////

        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 200);
        MyProfileButtonExch.get(1).click();
        PreferredContactDrpOptions.get(1).click();
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInput, 40);
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChanges, 40);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(SuccessfulBanner, 10);
        softAssert.assertEquals(SuccessfulBanner.getText(), "Your changes have been successfully saved!");
        softAssert.assertAll();
    }

    public void verifyEmailUseErrorMessage(String language) {
        switch (language) {
            case "English":
                ValidateEmailinuseErrorEnglish();
                break;
            case "Spanish":
                ValidateEmailinuseErrorSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void ValidateEmailinuseErrorEnglish() {
        // Update email address/////////
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40000);
        MyProfileButtonExch.get(1).click();
        System.out.println("Email ::" + SharedData.getPrimaryMember().getEmailId());
        String newEmail =  "testlraccount@test.com";
        InputEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        InputEmail.sendKeys(newEmail);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInput, 40);
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChanges, 40);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(EmailinUseMessage, 10);
        softAssert.assertEquals(EmailinUseMessage.getText(), "Email already in use");
        softAssert.assertAll();
    }


    public void ValidateEmailinuseErrorSpanish() {

        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        MyProfileButtonExch.get(1).click();
        System.out.println("Email ::" + SharedData.getPrimaryMember().getEmailId());
        String newEmail =  "testlraccount@test.com";
        InputEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        InputEmail.sendKeys(newEmail);
        MyProfileButtonExch.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInput, 40);
        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChanges, 40);
        PasswordSaveChanges.click();
        basicActions.waitForElementToBePresent(EmailinUseMessage, 10);
        softAssert.assertEquals(EmailinUseMessage.getText(), "Correo electr\u00F3nico en uso");
        softAssert.assertAll();
    }
    public void VerifyTimeoutPopup(String language) {
        switch (language) {
            case "English":
                verifyTimeoutPopupEnglish();
                break;
            case "Spanish":
                verifyTimeoutPopupSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }


    public void verifyTimeoutPopupEnglish() {
        basicActions.wait(840000);
        //basicActions.waitForElementToBePresent(NoTimeout, 20);
        softAssert.assertEquals(Headertimeout.getText(), "Your session is about to end.");
        softAssert.assertEquals(NoTimeout.getText(), "No, sign me out");
        softAssert.assertEquals(YesTimeout.getText(), "Yes, stay signed in");
        basicActions.isElementDisplayed(Questiontext, 10);
        YesTimeout.click();
        basicActions.waitForElementToBePresent(MyProfileButtonExch.get(1), 10);
        softAssert.assertAll();
    }


    public void verifyTimeoutPopupSpanish() {
        basicActions.wait(840000);
        //basicActions.waitForElementToBePresent(NoTimeout, 20);
        softAssert.assertEquals(Headertimeout.getText(), "El tiempo de su sesi\u00F3n est\u00E1 por terminar.");
        softAssert.assertEquals(NoTimeout.getText(), "No, cierre mi sesi\u00F3n");
        softAssert.assertEquals(YesTimeout.getText(), "S\u00ED, deseo seguir en la sesi\u00F3n");
        basicActions.isElementDisplayed(Questiontext, 10);
        NoTimeout.click();
        softAssert.assertAll();
    }

    public void validateChangePrimaryContactpopop(String language) {
        switch (language) {
            case "English":
                validateChangePrimaryContactpopopEnglish();
                break;
            case "Spanish":
                validateChangePrimaryContactpopopSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }


    public void validateChangePrimaryContactpopopEnglish() {
        basicActions.waitForElementToBePresent(headerChangePrimary, 2000);
        softAssert.assertEquals(headerChangePrimary.getText(), "Change Primary Contact");
        primaryContactDRP.click();
        softAssert.assertEquals(dpdPrimaryChangeOpt1.getText(),  SharedData.getPrimaryMember().getFullName());
        softAssert.assertEquals(dpdPrimaryChangeOpt2.getText(), SharedData.getMembers().get(0).getFirstName() + " " + SharedData.getMembers().get(0).getMiddleName() +" "+ SharedData.getMembers().get(0).getLastName());
        String firstName = SharedData.getMembers().get(0).getFirstName();
        primaryContactDRP.sendKeys(firstName);
        primaryContactDRP.sendKeys(Keys.ENTER);
        softAssert.assertEquals(cancelPrimaryPopup.getText(), "Cancel");
        softAssert.assertEquals(savePrimaryContact.getText(), "Save");
        softAssert.assertEquals(privacyPolicy.getText(), "Privacy Policy");
        softAssert.assertEquals(termsOfUse.getText(), "Terms Of Use");
        cancelPrimaryPopup.click();
        softAssert.assertAll();
    }


    public void validateChangePrimaryContactpopopSpanish() {
        basicActions.waitForElementToBePresent(headerChangePrimary, 2000);
        softAssert.assertEquals(headerChangePrimary.getText(), "Cambiar el contacto principal");
        primaryContactDRP.click();
        softAssert.assertEquals(dpdPrimaryChangeOpt1.getText(),  SharedData.getPrimaryMember().getFullName());
        softAssert.assertEquals(dpdPrimaryChangeOpt2.getText(), SharedData.getMembers().get(0).getFirstName() + " " + SharedData.getMembers().get(0).getMiddleName() +" "+ SharedData.getMembers().get(0).getLastName());
        String firstName = SharedData.getMembers().get(0).getFirstName();
        primaryContactDRP.sendKeys(firstName);
        primaryContactDRP.sendKeys(Keys.ENTER);
        softAssert.assertEquals(getCancelPrimaryPopupSp.getText(), "Cancelar");
        softAssert.assertEquals(savePrimaryContact.getText(), "Guardar");
        softAssert.assertEquals(privacyPolicy.getText(), "Pol\u00EDtica de privacidad");
        softAssert.assertEquals(termsOfUse.getText(), "T\u00E9rminos de uso");
        savePrimaryContact.click();
        softAssert.assertAll();
    }

    private void updatePrimaryMemInSharedData(String memPrefix){
        List<MemberDetails> memberList = SharedData.getMembers();
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        memberList.add(primaryMem);

        memberList.stream().filter(member -> member.getFirstName().contains(memPrefix)).findFirst().ifPresent(newPrimaryMem -> {
            newPrimaryMem.setEmailId(primaryMem.getEmailId());
            newPrimaryMem.setAccount_id(primaryMem.getAccount_id());
            newPrimaryMem.setPhoneNumber(primaryMem.getPhoneNumber());
            newPrimaryMem.setResAddress(primaryMem.getResAddress());
            newPrimaryMem.setMailingAddress(primaryMem.getMailingAddress());
            setRelation(newPrimaryMem);
            memberList.remove(newPrimaryMem);
            SharedData.setPrimaryMember(newPrimaryMem);
        });
        SharedData.setMembers(memberList);
    }

    private void setRelation(MemberDetails member){
     String relation = member.getRelation_to_subscriber();
        MemberDetails memWithPrimaryPrefix = basicActions.getMember("Primary");;
        if(relation.toLowerCase().contains("spouse") || relation.toLowerCase().contains("wife") || relation.toLowerCase().contains("husband")){
                 if(memWithPrimaryPrefix.getGender().toLowerCase().equals("male")){
                   memWithPrimaryPrefix.setRelation_to_subscriber("HUSBAND");
                 } else{
                     memWithPrimaryPrefix.setRelation_to_subscriber("WIFE");
                 }
            }
        member.setRelation_to_subscriber("SELF");
    }

    public void validateErrorMessage(String language) {
        switch (language) {
            case "English":
                validateErrorMessageEnglish();
                break;
            case "Spanish":
                validateErrorMessageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateErrorMessageEnglish() {
        // Update email address/////////
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40000);
        MyProfileButtonExch.get(1).click();
        InputEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        basicActions.waitForElementToBePresent(Mobilephone, 40);
        Mobilephone.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        String newPhoneNumber = "303";
        Mobilephone.sendKeys(newPhoneNumber);
        basicActions.waitForElementToBePresent(Homephone, 40);
        Homephone.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        Homephone.sendKeys(newPhoneNumber);
        MyProfileButtonExch.get(1).click();
        softAssert.assertEquals(ErrorMessageContactInformation.get(0).getText(), "A valid email is required");
        softAssert.assertEquals(ErrorMessageContactInformation.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformation.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformation.get(1).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(ErrorMessageContactInformation.get(1).getText(), "Please enter a valid phone number");
        softAssert.assertEquals(ErrorMessageContactInformation.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformation.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformation.get(1).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(ErrorMessageContactInformation.get(2).getText(), "Please enter a valid phone number");
        softAssert.assertEquals(ErrorMessageContactInformation.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformation.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformation.get(2).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(grayLineHP.getCssValue("color"), "rgba(149, 147, 147, 1)");
        softAssert.assertEquals(grayLineAddress.getCssValue("color"), "rgba(149, 147, 147, 1)");
        softAssert.assertAll();
    }


    public void validateErrorMessageSpanish() {

        softAssert.assertEquals(ErrorMessageContactInformation.get(0).getText(), "Es obligatorio un correo electr\u00F3nico v\u00E1lido");
        softAssert.assertEquals(ErrorMessageContactInformation.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformation.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformation.get(1).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(ErrorMessageContactInformation.get(1).getText(), "Ingrese un n\u00FAmero de tel\u00E9fono v\u00E1lido");
        softAssert.assertEquals(ErrorMessageContactInformation.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformation.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformation.get(1).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(ErrorMessageContactInformation.get(2).getText(), "Ingrese un n\u00FAmero de tel\u00E9fono v\u00E1lido");
        softAssert.assertEquals(ErrorMessageContactInformation.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(ErrorMessageContactInformation.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(ErrorMessageContactInformation.get(2).getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertAll();
    }


    public void changePrimaryContactnotdisplay() {
        softAssert.assertTrue(changePrimaryContactnotdisplay.isEmpty(),"Button displayed when not expected");
        softAssert.assertAll();
    }

    public void PreferredWritternLanguage(String langContactPreferred) {
        clickPreferredLanguageDrp();
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        switch (langContactPreferred) {
            case "English":
                LanguageDrpOptions.get(1).click();
                primaryMem.setWrittenLanguage("English");
                primaryMem.setIncorrectLanguage("Spanish");
                break;
            case "Spanish":
                LanguageDrpOptions.get(2).click();
                primaryMem.setWrittenLanguage("Spanish");
                primaryMem.setIncorrectLanguage("English");
                break;
            default:
                Assert.fail("Invalid argument passed");
        }
    }

    public void validateTimeoutSessionPopupWithoutTakingAnyActions() {
        basicActions.wait(840000);
        softAssert.assertEquals(Headertimeout.getText(), "Your session is about to end.");
        softAssert.assertEquals(NoTimeout.getText(), "No, sign me out");
        softAssert.assertEquals(YesTimeout.getText(), "Yes, stay signed in");
        basicActions.isElementDisplayed(Questiontext, 10);
        basicActions.waitForElementToBePresent(MyProfileButtonExch.get(1), 10);
        softAssert.assertAll();
    }
}