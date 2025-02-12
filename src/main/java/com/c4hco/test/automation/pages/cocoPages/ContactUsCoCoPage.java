package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ContactUsCoCoPage {

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-contact-us/app-container/div/div/div[1]")
    WebElement title;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-contact-us/app-container/div/div/div[2]/div[1]")
    WebElement p1;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-contact-us/app-container/div/div/div[2]/div[2]/div[1]")
    WebElement h1;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-contact-us/app-container/div/div/div[2]/div[2]/div[2]/div")
    WebElement p2;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-contact-us/app-container/div/div/div[2]/div[2]/div[2]/ul/li[1]")
    WebElement p3;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-contact-us/app-container/div/div/div[2]/div[2]/div[2]/ul/li[2]")
    WebElement p4;

    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;


    public ContactUsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void verifyPageText(String language) {

        switch (language) {
            case "English":
                verifyEnglish();
                break;
            case "Spanish":
                verifySpanish();
                break;
            default: throw new IllegalArgumentException("Unsupported language: " + language);
        }

    }

    private void verifySpanish() {

        softAssert.assertEquals(title.getText(), "P\u00F3ngase en contacto");
        softAssert.assertEquals(p1.getText(), "Si tiene preguntas sobre su plan de seguro de salud y beneficios,\n" +
                "comun\u00EDquese directamente con su compa\u00F1\u00EDa de seguros.");
        softAssert.assertEquals(h1.getText(), "Llame a nuestro centro de atenci\u00F3n al cliente al");
        softAssert.assertEquals(p2.getText(), "855-675-2626");
        softAssert.assertEquals(p3.getText(), "Nuestro personal capacitado est\u00E1 disponible para ayudarle por tel\u00E9fono: de lunes a viernes de 8:00 a.m. a 6:00 p.m.");
        softAssert.assertEquals(p4.getText(), "Tal vez se ofrezca un horario extendido cerca de las fechas l\u00EDmites.");
        softAssert.assertAll();

    }

    private void verifyEnglish() {

        softAssert.assertEquals(title.getText(), "Contact Us");
        softAssert.assertEquals(p1.getText(), "For questions about your health insurance plan and benefits,\n" +
                "please contact your insurance company directly.");
        softAssert.assertEquals(h1.getText(), "Call our Customer Service Center");
        softAssert.assertEquals(p2.getText(), "855-675-2626");
        softAssert.assertEquals(p3.getText(), "Our trained staff are available to help you over the phone: Monday-Friday 8:00 a.m. \u2013 6:00 p.m.");
        softAssert.assertEquals(p4.getText(), "Extended hours may be offered leading up to deadlines.");
        softAssert.assertAll();

    }
}
