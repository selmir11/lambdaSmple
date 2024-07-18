package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MyProfileExchPage {


    @FindBy(css = ".bottom_buttons_container button")
    List<WebElement> MyProfileButtonExch; /// Go back, Make changes, Save buttons

    @FindBy(id = "myProfile_email")
    WebElement EmailAddress;

    @FindBy(id = "myProfile_username")
    WebElement UsernameProfile;

    @FindBy(id= "myProfile_accountId")
    WebElement ProfileAccountId;

    @FindBy(id = "preferredLanguage")
    WebElement  PreferredLanguageDrp;

    @FindBy(css = "#preferredLanguage option")
    List<WebElement> LanguageDrpOptions; //// Select option, English, Spanish

    @FindBy(id = "preferredContactMethod")
    WebElement   PreferredContactDrp;

    @FindBy(css = "#preferredContactMethod option")
    List<WebElement>  PreferredContactDrpOptions; // Select option, Email, Mail


    @FindBy(css = "div.myProfile_fullName")
    WebElement FullNameProfile;


    @FindBy(id= "myProfile_mobilePhone")
    WebElement  Mobilephone;

    @FindBy(id = "myProfile_homePhone")
    WebElement Homephone;

    @FindBy(css = "h1.myProfile_title")
    WebElement MyProfileHeader;

     @FindBy(css = ".myProfile_subheading")
     List<WebElement> MyProfileSubHeading; ///// Primary contact, Contact Information, Login & Security, Settings & Preferences

    @FindBy(css = "span.content_line_label")
    List<WebElement>  MyProfileContentline;  ///// Name, Date of Birth, Social security number, Email, Mobile phone, Home phone, Residential address, Username, Password, account number, Preferred language contact, Preferred contact Method

    @FindBy(css = "div.change-password-container")
    WebElement  PasswordButton;

    @FindBy(css = "span.change-password-msg" )
    WebElement PasswordMessage;
    @FindBy(xpath = "//span[.=' Change ']" )
    WebElement changePrimaryContact;
    @FindBy(id = "contactNames" )
    WebElement primaryContactDRP;
    @FindBy(xpath = "//button[.='Save']" )
    WebElement savePrimaryContact;

    @FindBy(css = "#userPassword")
    WebElement PasswordInput;

    @FindBy(css = ".password-button")
    WebElement PasswordSaveChanges;

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public MyProfileExchPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void backToWelcomeButtonExch() {
        basicActions.waitForElementToBeClickable(MyProfileButtonExch.get(0), 60);
        MyProfileButtonExch.get(0).click();
    }

    public void clickMakeChangesButton() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 60);
        MyProfileButtonExch.get(1).click();
    }

    public void clickSaveButton() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 40);
        MyProfileButtonExch.get(1).click();
//        basicActions.waitForElementToBePresent(PasswordInput,40);
//        PasswordInput.sendKeys(SharedData.getPrimaryMember().getPassword()); //QA feature branch
//        basicActions.waitForElementToBePresent(PasswordSaveChanges,40);
//        PasswordSaveChanges.click();
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

//////Validation Method/////////////////////////////////////////////

    public void verifyTextOnMyProfileExchPage(String language){
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


    public void verifyTextOnMyProfilePageEnglish(){
    basicActions.waitForElementToBePresent(MyProfileHeader,10);
        softAssert.assertEquals(MyProfileHeader.getText(), "My Profile");
        softAssert.assertEquals(MyProfileHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileHeader.getCssValue("font-size"), "36px");
        softAssert.assertEquals(MyProfileHeader.getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getText(), "Primary Contact");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getCssValue("font-size"), "19px");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(0).getText(), "Name");
        softAssert.assertEquals(MyProfileContentline.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(FullNameProfile.getText(), SharedData.getPrimaryMember().getFirstName()+" "+SharedData.getPrimaryMember().getLastName());
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
        softAssert.assertEquals(Mobilephone.getText(), SharedData.getPrimaryMember().getPhoneNumber());
        softAssert.assertEquals(MyProfileContentline.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileContentline.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(MyProfileContentline.get(4).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(MyProfileContentline.get(5).getText(), "Home Phone");
        softAssert.assertEquals(Homephone.getText(), SharedData.getPrimaryMember().getPhoneNumber());
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
        softAssert.assertEquals(MyProfileButtonExch.get(0).getText(), "Go back to Welcome page");
        softAssert.assertEquals(MyProfileButtonExch.get(1).getText(), "Make Changes");
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
        softAssert.assertEquals(MyProfileButtonExch.get(0).getText(), "Go back to Welcome page");
        softAssert.assertAll();
    }

    public void verifyTextOnMyProfilePageSpanish(){
        basicActions.waitForElementToBePresent(MyProfileHeader,10);
        softAssert.assertEquals(MyProfileHeader.getText(), "Mi P\u00E9rfil");
        softAssert.assertEquals(MyProfileHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(MyProfileHeader.getCssValue("font-size"), "36px");
        softAssert.assertEquals(MyProfileHeader.getCssValue("color"), "rgba(77, 77, 79, 1)");
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
        softAssert.assertEquals(MyProfileButtonExch.get(0).getText(), "Volver a la Pagina de Bienvenida");
        softAssert.assertEquals(MyProfileButtonExch.get(1).getText(), "Hacer Cambios");
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

    public void verifyPasswordTextOnMyProfilePageEnglish(){
        basicActions.waitForElementToBePresent(PasswordMessage,10);
        softAssert.assertEquals(PasswordMessage.getText(), "Clicking on Change Password will log you out and take you to a Password Reset page.");;
        softAssert.assertEquals(PasswordMessage.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordMessage.getCssValue("font-size"), "12px");
        softAssert.assertEquals(PasswordMessage.getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(PasswordButton.getText(), "Change Password");
        softAssert.assertAll();
    }


    public void verifyPasswordTextOnMyProfilePageSpanish(){
        basicActions.waitForElementToBePresent(PasswordMessage,10);
        softAssert.assertEquals(PasswordMessage.getText(), "Al hacer clic en Cambiar contrase\u00F1a se cerrar\u00E1 su sesi\u00F3n y lo llevar\u00E1 a la p\u00E1gina de Restablecer contrase\u00F1a");
        softAssert.assertEquals(PasswordMessage.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PasswordMessage.getCssValue("font-size"), "12px");
        softAssert.assertEquals(PasswordMessage.getCssValue("color"), "rgba(182, 38, 38, 1)");
        softAssert.assertEquals(PasswordButton.getText(), "Cambiar Contrase\u00F1a");
        softAssert.assertAll();
    }


    public void PreferredContactMethod(String contactPrefrences) {
        clickPreferredContactDrp();
        switch (contactPrefrences){
            case "Email":
                PreferredContactDrpOptions.get(1).click();
                break;
            case "Mail":
                PreferredContactDrpOptions.get(2).click();
        }
    }

    public void PreferredContactLanguageMethod(String langContactPreferred) {
        clickPreferredLanguageDrp();
        switch (langContactPreferred){
            case "English":
                LanguageDrpOptions.get(1).click();
                break;
            case "Spanish":
                LanguageDrpOptions.get(2).click();
        }
    }

    public void ClickChangePrimaryContactOnMyProfilePage() {
       basicActions.waitForElementToBePresent(changePrimaryContact,80);
       changePrimaryContact.click();
    }

    public void SelectTheSecondHouseholdMemberAsPrimaryContact() {
        basicActions.waitForElementToBeClickable(primaryContactDRP,20);
        primaryContactDRP.click();
        String firstName= SharedData.getMembers().get(0).getFirstName() ;
        primaryContactDRP.sendKeys(firstName);
        primaryContactDRP.sendKeys(Keys.ENTER);
        savePrimaryContact.click();
        basicActions.wait(60);
    }
}

