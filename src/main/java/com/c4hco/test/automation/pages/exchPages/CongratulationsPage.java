package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CongratulationsPage {
    private BasicActions basicActions;

    public CongratulationsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(css = "h1.c4PageHeader1")
    WebElement textCongratulations;

    @FindBy(css = ".panel-body .c4BodyText1")
    List <WebElement> textPanelBody;

    @FindBy(id = "submitButton")
    WebElement saveAndContinue;

    public void clickSaveContinue(){
        basicActions.waitForElementToBePresentWithRetries(saveAndContinue,60);
        saveAndContinue.click();
    }

    public void validateTheVerbiageOnTheRIDPCongratulationsPage(String language) {
        switch (language){
            case "English":
                validateTheVerbiageEn();
                break;
            case "Spanish":
                validateTheVerbiageEs();
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private void validateTheVerbiageEn() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(textCongratulations.getText(), "Congratulations!", "Congratulations text mismatch");
        softAssert.assertTrue(textPanelBody.get(0).getText().contains("You have successfully provided proof of identity for"), "You have successfully.. text mismatch");
        softAssert.assertTrue(textPanelBody.get(1).getText().contains("start to browse for plans, or"), "start to browse.. text mismatch");
        softAssert.assertEquals(textPanelBody.get(2).getAttribute("value"), "look for expert help in your area.", "look for expert help in your area. text mismatch");

        softAssert.assertAll();
    }

    private void validateTheVerbiageEs() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(textCongratulations.getText(), "\u00A1Felicidades!", "\u00A1Felicidades! text mismatch");
        softAssert.assertTrue(textPanelBody.get(0).getText().contains("Ha proporcionado correctamente la prueba de identidad de"), "Ha proporcionado correctamente.. text mismatch");
        softAssert.assertTrue(textPanelBody.get(0).getText().contains("Ya puede empezar a revisar los planes o"), "Ya puede empezar.. text mismatch");
        softAssert.assertEquals(textPanelBody.get(2).getAttribute("value"), "a buscar ayuda experta en su zona. ", "a buscar ayuda experta en su zona.. text mismatch");

        softAssert.assertAll();
    }
}
