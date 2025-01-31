package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class MaEligibleMembersCareTakerPage {

    private BasicActions basicActions;
    public MaEligibleMembersCareTakerPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    SoftAssert softAssert = new SoftAssert();

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(className = "c4PageHeader")
    WebElement headerCaretaker;

    @FindBy(xpath = "//*[contains(text(),'Help me understand this page')]")
    WebElement helpMeText;

    @FindBy(xpath = "//*[contains(text(),'Help me understand this page')]")
    WebElement helpMeTextSP;

    @FindBy(xpath = "//*[@id = 'criteriaApplicableLabel']")
    WebElement anyoneText;

    @FindBy(xpath = "//span[contains(text(),'Who is the main person taking care of this child?')]")
    WebElement whoText;

    @FindBy(xpath = "//span[contains(text(),'Who is the main person taking care of this child?')]")
    WebElement whoTextSP;

    @FindBy(xpath = "//*[@value = '1']")
    WebElement yesText;

    @FindBy(xpath = "//*[@value = '0']")
    WebElement noText;

    @FindBy(xpath = "//*[@value = '< Back']")
    WebElement valueText;

    @FindBy(id = "isAnyoneMACriteriaYes")
    WebElement rdoYes;

    @FindBy(id = "isAnyoneMACriteriaNo")
    WebElement rdoNo;

    @FindBy(id = "continueButton")
    WebElement btnSaveAndContinue;

    public void answerUnder19(String nextOption){
        basicActions.waitForElementToBePresent(rdoYes, 20);
        switch(nextOption) {
            case "Yes":
                rdoYes.click();
                break;
            case "No":
                rdoNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + nextOption);
        }
        btnSaveAndContinue.click();
    }

    public void textCaretaker(String language) {
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        switch (language) {
            case "English":
                validateCaretakerPageEnglish();
                break;
            case "Spanish":
                validateCaretakerPageSpanish();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );
        }
    }

    public void validateCaretakerPageEnglish(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(headerCaretaker,20  );
        softAssert.assertEquals( headerCaretaker.getText(), "Parent/Caretaker" );
        softAssert.assertEquals( helpMeText.getText(), "Help me understand this page" );
        softAssert.assertEquals( anyoneText.getText(), "Is anyone in the household under the age of 19?" );
        softAssert.assertEquals( yesText.getText(), "Yes" );
        basicActions.click(yesText);
        softAssert.assertEquals( whoText.getText(), "Who is the main person taking care of this child?" );
        softAssert.assertEquals( noText.getText(), "No" );
        softAssert.assertEquals( valueText.getText(), "< Back" );
        softAssert.assertEquals( btnSaveAndContinue.getText(), "Save and Continue" );

    }


    public void validateCaretakerPageSpanish(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(headerCaretaker,20  );
        softAssert.assertEquals( headerCaretaker.getText(), "Cuidador principal" );
        softAssert.assertEquals( helpMeText.getText(), "Ayuda para entender esta p\u00E1gina" );
        softAssert.assertEquals( anyoneText.getText(), "\u00BFAlg\u00FAn miembro de su familia tiene 19 a\u00F1os o menos?" );
        softAssert.assertEquals( yesText.getText(), "S\u00ED" );
        basicActions.click(yesText);
        softAssert.assertEquals( whoText.getText(), "¿Qui\u00E9n es la persona responsable por este ni\u00F1o?" );
        softAssert.assertEquals( noText.getText(), "No" );
        softAssert.assertEquals( valueText.getText(), "< Atr\u00E1s" );
        softAssert.assertEquals( btnSaveAndContinue.getText(), "Guardar y Continuar" );

    }
    }
