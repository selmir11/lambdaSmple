package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class MaEligibleMembersMedicalConditionPage {

    private BasicActions basicActions;
    public MaEligibleMembersMedicalConditionPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    SoftAssert softAssert = new SoftAssert();
    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "isAnyoneMACriteriaYes")
    WebElement rdoYes;

    @FindBy(id = "isAnyoneMACriteriaNo")
    WebElement rdoNo;

    @FindBy(id = "continueButton")
    WebElement btnSaveAndContinue;

    @FindBy(className = "c4PageHeader")
    WebElement headerMedicalCondition;

    @FindBy(xpath = "//*[contains(text(),'Help me understand this page')]")
    WebElement helpMeText;

    @FindBy(xpath = "//*[contains(text(),'Ayuda para entender esta p\u00E1gina')]")
    WebElement helpMeTextSP;

    @FindBy(xpath = "//*[@id = 'criteriaApplicableLabel']")
    WebElement anyoneText;

    @FindBy (xpath= "//*[@id = 'membersForMACriteriaChoosingId']")
    WebElement whichText;

    @FindBy (xpath= "//*[@id = 'membersForMACriteriaChoosingId']")
    WebElement whichTextSP;

    @FindBy(xpath = "//span[contains(text(),'Yes')]")
    WebElement yesText;

    @FindBy(xpath = "//span[contains(text(),'S\u00ED')]")
    WebElement yesTextSP;
    @FindBy(xpath = "//span[contains(text(),'No')]")
    WebElement noText;

    @FindBy(xpath = "//*[@value = '< Back']")
    WebElement valueText;

    @FindBy(xpath = "//*[@value = '< Atr\u00E1s']")
    WebElement valueTextSP;


    public void answerDisability(String nextOption){
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

    public void iContinue(){
        basicActions.waitForElementToBePresentWithRetries( btnSaveAndContinue,20 );
        basicActions.click( btnSaveAndContinue );

    }

    public void iValidateMedicalConditionText(String language) {
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        switch (language) {
            case "English":
                validateMedicalConditionEnglish();
                break;
            case "Spanish":
                vvalidateMedicalConditionSpanish();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );


        }

    }

    public void validateMedicalConditionEnglish(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(headerMedicalCondition,20  );
        softAssert.assertEquals( headerMedicalCondition.getText(), "Medical Condition or Disability" );
        softAssert.assertEquals( helpMeText.getText(), "Help me understand this page" );
        softAssert.assertEquals( anyoneText.getText(), "Does anyone in the household have a medical condition or disability?" );

        softAssert.assertEquals( yesText.getText(),"Yes" );
        basicActions.waitForElementToBePresentWithRetries( rdoYes,20 );
        basicActions.click( rdoYes );

        softAssert.assertTrue(whichText.getText().contains( "Which household members have a medical condition? (Select all that apply)" ));

        softAssert.assertEquals( noText.getText(),"No" );
        basicActions.waitForElementToBePresentWithRetries( rdoNo,20 );
        basicActions.click( rdoNo );

        softAssert.assertEquals( valueText.getAttribute( "value" ), "< Back");
        softAssert.assertEquals( btnSaveAndContinue.getText(), "Save and Continue" );
        softAssert.assertAll();
    }


    public void vvalidateMedicalConditionSpanish(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(headerMedicalCondition,20  );
        softAssert.assertEquals( headerMedicalCondition.getText(), "Condici\u00F3n m\u00E9dica o discapacidad" );
        softAssert.assertEquals( helpMeTextSP.getText(), "Ayuda para entender esta p\u00E1gina" );
        softAssert.assertEquals( anyoneText.getText(), "\u00BFAlguien en la familia tiene una condici\u00F3n m\u00E9dica o discapacidad?" );

        softAssert.assertEquals( yesTextSP.getText(),"S\u00ED" );
        basicActions.waitForElementToBePresentWithRetries( rdoYes,20 );
        basicActions.click(rdoYes);

        softAssert.assertTrue(whichTextSP.getText().contains( "\u00BFQu\u00E9 miembros del hogar tienen una condici\u00F3n m\u00E9dica? (seleccione todos los que apliquen)" ));

        softAssert.assertEquals( noText.getText(),"No" );
        basicActions.waitForElementToBePresentWithRetries( rdoNo,20 );
        basicActions.click( rdoNo );

        softAssert.assertEquals( valueTextSP.getAttribute("value"), "< Atr\u00E1s" );
        softAssert.assertEquals( btnSaveAndContinue.getText(), "Guardar y Continuar" );
        softAssert.assertAll();
    }
}
