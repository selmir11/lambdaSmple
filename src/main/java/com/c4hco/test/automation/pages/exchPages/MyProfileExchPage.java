package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MyProfileExchPage {


    @FindBy(css = ".bottom_buttons_container button")
    List<WebElement> MyProfileButtonExch; /// Go back, Make changes, Save buttons

    @FindBy(id = "email")
    WebElement EmailUpdate;

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

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public MyProfileExchPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void backToWelcomeButtonExch() {
        basicActions.waitForElementToBeClickable(MyProfileButtonExch.get(0), 5);
        MyProfileButtonExch.get(0).click();
    }

    public void clickMakeChangesButton() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 15);
        MyProfileButtonExch.get(1).click();
    }

    public void clickSaveButton() {
        basicActions.waitForElementListToBePresent(MyProfileButtonExch, 15);
        MyProfileButtonExch.get(1).click();
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


    public void verifyTextOnMyProfilePageEnglish(){
    basicActions.waitForElementToBePresent(MyProfileHeader,10);
        softAssert.assertEquals(MyProfileHeader.getText(), "My Profile");;
        softAssert.assertEquals(MyProfileContentline.get(0).getText(), "Name");
        softAssert.assertEquals(MyProfileContentline.get(1).getText(), "Date of Birth");
        softAssert.assertEquals(MyProfileContentline.get(2).getText(), "Social Security Number");
        softAssert.assertEquals(MyProfileSubHeading.get(1).getText(), "Contact Information");
        softAssert.assertEquals(MyProfileContentline.get(3).getText(), "Email");
        softAssert.assertEquals(MyProfileContentline.get(4).getText(), "Mobile Phone");
        softAssert.assertEquals(MyProfileContentline.get(5).getText(), "Home Phone");
        softAssert.assertEquals(MyProfileContentline.get(6).getText(), "Residential Address");
        softAssert.assertEquals(MyProfileSubHeading.get(2).getText(), "Login & Security");
        softAssert.assertEquals(MyProfileContentline.get(7).getText(), "Username");
        softAssert.assertEquals(MyProfileContentline.get(8).getText(), "Password");
        softAssert.assertEquals(MyProfileContentline.get(9).getText(), "Account Number");
        softAssert.assertEquals(MyProfileSubHeading.get(3).getText(), "Settings & Preferences");
        softAssert.assertEquals(MyProfileContentline.get(10).getText(), "Preferred Language of Contact");
        softAssert.assertEquals(MyProfileContentline.get(11).getText(), "Preferred Contact Method");
        softAssert.assertEquals(MyProfileButtonExch.get(0).getText(), "Go back to Welcome page");
        softAssert.assertEquals(MyProfileButtonExch.get(1).getText(), "Make Changes");

        softAssert.assertAll();
    }

    public void verifyTextOnMyProfilePageSpanish(){
        basicActions.waitForElementToBePresent(MyProfileHeader,10);
        softAssert.assertEquals(MyProfileHeader.getText(), "Mi P\u00E9rfil");
        softAssert.assertEquals(MyProfileSubHeading.get(0).getText(), "Contacto principal");
        softAssert.assertEquals(MyProfileContentline.get(0).getText(), "Nombre");
        softAssert.assertEquals(MyProfileContentline.get(1).getText(), "Fecha de Nacimiento");
        softAssert.assertEquals(MyProfileContentline.get(2).getText(), "N\u00FAmero de Seguro Social");
        softAssert.assertEquals(MyProfileSubHeading.get(1).getText(), "Informacion de Contacto");
        softAssert.assertEquals(MyProfileContentline.get(3).getText(), "Email");
        softAssert.assertEquals(MyProfileContentline.get(4).getText(), "Telefono Movil");
        softAssert.assertEquals(MyProfileContentline.get(5).getText(), "Telefono Residencial");
        softAssert.assertEquals(MyProfileContentline.get(6).getText(), "Direcci\u00F3n del Domicilio");
        softAssert.assertEquals(MyProfileSubHeading.get(2).getText(), "Acceso y Seguridad");
        softAssert.assertEquals(MyProfileContentline.get(7).getText(), "Nombre de Usario");
        softAssert.assertEquals(MyProfileContentline.get(8).getText(), "Contrase\u00F1a");
        softAssert.assertEquals(MyProfileContentline.get(9).getText(), "N\u00FAmero de Cuenta");
        softAssert.assertEquals(MyProfileSubHeading.get(3).getText(), "Configuraciones y Preferencias");
        softAssert.assertEquals(MyProfileContentline.get(10).getText(), "Idioma de Contacto Preferido");
        softAssert.assertEquals(MyProfileContentline.get(11).getText(), "Medio de Contacto Preferido");
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
        softAssert.assertEquals(PasswordButton.getText(), "Change Password");
        softAssert.assertAll();
    }


    public void verifyPasswordTextOnMyProfilePageSpanish(){
        basicActions.waitForElementToBePresent(PasswordMessage,10);
        softAssert.assertEquals(PasswordMessage.getText(), "Al hacer clic en Cambiar contrase\u00F1a se cerrar\u00E1 su sesi\u00F3n y lo llevar\u00E1 a la p\u00E1gina de Restablecer contrase\u00F1a");
        softAssert.assertEquals(PasswordButton.getText(), "Cambiar Contrase\u00F1a");
        softAssert.assertAll();
    }


}

