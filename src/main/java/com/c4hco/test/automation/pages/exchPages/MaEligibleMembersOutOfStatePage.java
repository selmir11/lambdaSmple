package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MaEligibleMembersOutOfStatePage {

    private BasicActions basicActions;

    public MaEligibleMembersOutOfStatePage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );
    }
    SoftAssert softAssert = new SoftAssert();

    public BasicActions getDriver() {
        return BasicActions.getInstance();
    }


    @FindBy(css = ".c4PageHeader")
    WebElement headerOutOfState;

    @FindBy(xpath = "//*[contains(text(),'Help me understand this page')]")
    WebElement helpMeText;

    @FindBy(xpath = "//*[contains(text(),'Ayuda para entender esta p\u00E1gina')]")
    WebElement helpMeTextSP;

    @FindBy(xpath = "//*[@id = 'criteriaApplicableLabel']")
    WebElement anyoneText;

    @FindBy(xpath = "//span[contains(text(),'Yes')]")
    WebElement yesText;

    @FindBy(xpath = "//span[contains(text(),'S\u00ED')]")
    WebElement yesTextSP;
    @FindBy(xpath = "//span[contains(text(),'No')]")
    WebElement noText;

    @FindBy(xpath = "//*[@class = 'col-sm-6 custom-lg-col custom-xs-col']")
    WebElement whichText1;

    @FindBy(xpath = "//span[contains(text(),'\u00BFQu\u00E9 miembros del hogar est\u00E1n temporalmente ausentes? (seleccione todos los que apliquen)')]")
    WebElement whichText1SP;

    @FindBy(xpath = "//span[contains(text(),'Seleccione una o más de las opciones siguientes')]")
    WebElement whichText2SP;

    @FindBy(xpath = "//*[@value = '< Atr\u00E1s']")
    WebElement valueTextSP;

    @FindBy(id = "isAnyoneMACriteriaYes")
    WebElement rdoYes;

    @FindBy(id = "isAnyoneMACriteriaNo")
    WebElement rdoNo;

    @FindBy(xpath = "//*[@value = '< Back']")
    WebElement valueText;

    @FindBy(id = "continueButton")
    WebElement btnSaveAndContinue;

    public void iContinue() {
        basicActions.waitForElementToBePresentWithRetries( btnSaveAndContinue, 50 );
        basicActions.click( btnSaveAndContinue );
    }

    public void answerAbsent(String nextOption) {
        basicActions.waitForElementToBePresent( rdoYes, 20 );
        switch (nextOption) {
            case "Yes":
                rdoYes.click();
                break;
            case "No":
                rdoNo.click();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + nextOption );
        }
        btnSaveAndContinue.click();
    }

    public void textOutofStateMA(String language) {
        switch (language) {
            case "English":
                validateOutofStateMAPageEnglish();
                break;
            case "Spanish":
                validateOutofStateMAPageSpanish();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );
        }
    }


        public void validateOutofStateMAPageEnglish() {
            basicActions.waitForElementToBePresent( headerOutOfState, 20 );
            softAssert.assertEquals( headerOutOfState.getText(), "Temporarily Absent from Colorado" );
            softAssert.assertEquals( helpMeText.getText(), "Help me understand this page" );
            softAssert.assertEquals( anyoneText.getText(), "Is anyone in the household temporarily absent from Colorado?" );

            basicActions.waitForElementToBePresentWithRetries( yesText,20 );
            softAssert.assertEquals( yesText.getText(), "Yes" );

            basicActions.waitForElementToBePresentWithRetries( rdoYes,20 );
            basicActions.click( rdoYes );
            softAssert.assertTrue(whichText1.getText().contains("Which household members are temporarily absent? (Select all that apply)"));

            softAssert.assertEquals( noText.getText(), "No" );
            basicActions.waitForElementToBePresentWithRetries(rdoNo, 50 );
            basicActions.click( rdoNo );

            softAssert.assertEquals( valueText.getAttribute( "value" ), "< Back" );
            softAssert.assertEquals( btnSaveAndContinue.getText(), "Save and Continue" );
            softAssert.assertAll();
        }


        public void validateOutofStateMAPageSpanish() {
            basicActions.waitForElementToBePresent( headerOutOfState, 20 );
            softAssert.assertEquals( headerOutOfState.getText(), "Temporalmente ausente de Colorado" );
            softAssert.assertEquals( helpMeTextSP.getText(), "Ayuda para entender esta p\u00E1gina" );
            softAssert.assertEquals( anyoneText.getText(), "\u00BFAlguien de su familia est\u00E1 temporalmente ausente de Colorado?" );

            softAssert.assertEquals( yesTextSP.getText(), "S\u00ED" );
            basicActions.click( rdoYes );
            softAssert.assertEquals( whichText1SP.getText(), "\u00BFQu\u00E9 miembros del hogar est\u00E1n temporalmente ausentes? (seleccione todos los que apliquen)" );

            softAssert.assertEquals( noText.getText(), "No" );
            basicActions.waitForElementToBePresentWithRetries( rdoNo, 50 );
            basicActions.click( rdoNo );

            softAssert.assertEquals( valueTextSP.getAttribute( "value" ), "< Atr\u00E1s" );
            softAssert.assertEquals( btnSaveAndContinue.getText(), "Guardar y Continuar" );
            softAssert.assertAll();
        }
    }

