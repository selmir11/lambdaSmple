package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class BeforeYouBeginPage {

    private BasicActions basicActions;

    public BeforeYouBeginPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "#beforeYouBegin .btn")
    WebElement continueWithApplication;

    @FindBy(css = "h1")
    WebElement beforeYouBeginText;

    @FindBy(css = "p.c4BodyText1")
    WebElement bodyText;

    public void clickContinueWithApplicationButton(){
        basicActions.waitForElementToBePresent(continueWithApplication, 10);
        continueWithApplication.click();
    }

    public void validateTheVerbiageOnBeforeYouBeginPage(String language) {
        switch (language){
            case "English":
                validateTheVerbiageEn();
                break;
            case "Spanish":
                validateTheVerbiageEs();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    private void validateTheVerbiageEn() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(beforeYouBeginText.getText(), "Before you begin", "Before you begin text not found");
        softAssert.assertEquals(bodyText.getText(), "If you provided information in a previous session or filled out an application in PEAK, your answers will be shown here. Don't worry, you can confirm or change your answers as you go. At the end of the application, we will use the information you provided to see if you qualify for financial help to reduce your monthly health insurance costs.", "Body text mismatch");
        softAssert.assertEquals(continueWithApplication.getAttribute("value"), "Continue with application", "Continue with application button text mismatch");

        softAssert.assertAll();
    }


    private void validateTheVerbiageEs() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(beforeYouBeginText.getText(), "Antes de empezar", "Antes de empezar text not found");
        softAssert.assertEquals(bodyText.getText(), "Si proporcion\u00f3 informaci\u00f3n en una sesi\u00f3n anterior, o present\u00f3 una solicitud en PEAK, aqu\u00ed se mostrar\u00e1n sus respuestas. No se preocupe, podr\u00e1 confirmar o cambiar sus respuestas conforme avance. Al terminar la solicitud, utilizaremos la informaci\u00f3n que nos proporcione para ver si califica para obtener ayuda financiera, que reducir\u00e1 sus costos mensuales del seguro de salud.", "Body text mismatch");
        softAssert.assertEquals(continueWithApplication.getAttribute("value"), "Continuar con la solicitud", "Continuar con la solicitud button text mismatch");

        softAssert.assertAll();
    }

}
