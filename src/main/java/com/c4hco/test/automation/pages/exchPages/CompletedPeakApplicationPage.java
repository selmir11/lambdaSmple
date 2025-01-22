package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CompletedPeakApplicationPage {
    private BasicActions basicActions;
    public CompletedPeakApplicationPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="completedApplicationQYes")
    WebElement yesImNew;

    @FindBy(id = "completedApplicationQNo")
    WebElement noThanksRadioButton;

    @FindBy(xpath = "//*[@name='saveAndContinue']")
    WebElement saveAndContinueButton;

    @FindBy(css = "h1")
    WebElement pageHeaderLetUsGuideYou;

    @FindBy(css = ".c4BodyText1")
    List<WebElement> bodyText;

    @FindBy(xpath = "//input[@name='back']")
    WebElement backButton;


    public void setYesImNew(){
        yesImNew.click();
    }

    public void selectNoThanksOption(){
        noThanksRadioButton.click();
    }

    public void clickSaveAndContinueButton(){
        saveAndContinueButton.click();
    }
    public  void backButton(){
       backButton.click();
    }

    public void validateTheVerbiageOnLetUsGuideYouPage(String language){
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

    public void validateTheVerbiageEn() {
        SoftAssert softAssert = new SoftAssert();

        basicActions.waitForElementToBePresent(pageHeaderLetUsGuideYou, 30);
        softAssert.assertEquals(pageHeaderLetUsGuideYou.getText(), "Let us guide you", "Header text mismatch: Let us guide you");
        softAssert.assertEquals(bodyText.get(0).getText(), "If you have never enrolled with us before but have completed an application for Health First Colorado (Colorado's Medicaid Program) or Child Health Plan Plus (CHP+), we can save you time and pull the information you submitted previously. You will have a chance to review and change your information as needed. Would you like to search for a previously completed application?", "Body text mismatch: If you have never enrolled...");
        softAssert.assertEquals(bodyText.get(1).getText(), "You will need your Case ID, which can be found on your Health First Colorado eligibility notice.", "Body text mismatch: You will need your Case ID...");
        softAssert.assertEquals(bodyText.get(2).getText(), "Yes, I\u2019m new to Connect for Health Colorado and I have completed an application for Health First Colorado or Child Health Plan Plus", "Body text mismatch: Yes, I'm new to Connect for Health Colorado...");
        softAssert.assertEquals(bodyText.get(3).getText(), "No thanks, take me to the application", "Body text mismatch: No thanks, take me to the application");
        softAssert.assertAll();
    }

    public void validateTheVerbiageEs() {
        SoftAssert softAssert = new SoftAssert();

        basicActions.waitForElementToBePresent(pageHeaderLetUsGuideYou, 30);
        softAssert.assertEquals(pageHeaderLetUsGuideYou.getText(), "Perm\u00edtanos guiarlo", "Header text mismatch: Perm\u00edtanos guiarlo");
        softAssert.assertEquals(bodyText.get(0).getText(), "Si nunca se ha inscrito con nosotros antes pero ya present\u00f3 una solicitud para Health First Colorado (el programa Medicaid de Colorado) o Child Health Plan Plus (CHP+), podemos ahorrarle tiempo y extraer la informaci\u00f3n que envi\u00f3 antes. Usted tendr\u00e1 la oportunidad de revisar y cambiar su informaci\u00f3n seg\u00fan sea necesario. \u00bfDesea buscar una solicitud previamente completada?", "Body text mismatch: Si nunca se ha inscrito...");
        softAssert.assertEquals(bodyText.get(1).getText(), "Necesitar\u00e1 su identificaci\u00f3n del caso que aparece en su aviso de elegibilidad de Health First Colorado.", "Body text mismatch: Necesitar\u00e1 su identificaci\u00f3n del caso...");
        softAssert.assertEquals(bodyText.get(2).getText(), "S\u00ed, soy nuevo a Connect for Health Colorado y ya present\u00e9 una solicitud Health First Colorado or Child Health Plan Plus", "Body text mismatch: S\u00ed, soy nuevo...");
        softAssert.assertEquals(bodyText.get(3).getText(), "No gracias, ll\u00e9veme a la aplicaci\u00f3n", "Body text mismatch: No gracias, ll\u00e9veme a la aplicaci\u00f3n");
        softAssert.assertAll();
    }

    public void iSelectOption(String option) {
        switch (option.toLowerCase()) {
            case "yes":
                setYesImNew();
                break;
            case "no":
                selectNoThanksOption();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
    }
}
