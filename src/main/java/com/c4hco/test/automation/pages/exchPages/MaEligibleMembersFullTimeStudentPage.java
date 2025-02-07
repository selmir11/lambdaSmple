package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MaEligibleMembersFullTimeStudentPage {

    private BasicActions basicActions;
    public MaEligibleMembersFullTimeStudentPage(WebDriver webDriver) {
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
    WebElement headerFTStudent;

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


    public void answerStudent(String nextOption){
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

    public void iValidateStudentText(String language) {
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        switch (language) {
            case "English":
                validateFTStudentPageEnglish();
                break;
            case "Spanish":
                validateFTStudentPageSpanish();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );
        }

    }
    public void iContinue(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.click( btnSaveAndContinue );
    }

    public void validateFTStudentPageEnglish(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(headerFTStudent,20  );
        softAssert.assertEquals( headerFTStudent.getText(), "Full-time student" );
        softAssert.assertEquals( helpMeText.getText(), "Help me understand this page" );
        softAssert.assertEquals( anyoneText.getText(), "Is anyone in the household attending school full-time?" );

        softAssert.assertEquals( yesText.getText(),"Yes" );
        basicActions.waitForElementToBePresentWithRetries( rdoYes,20 );
        basicActions.click( rdoYes );

        softAssert.assertTrue(whichText.getText().contains( "Which household members are attending school? (Select all that apply)" ));

        softAssert.assertEquals( noText.getText(),"No" );
        basicActions.waitForElementToBePresentWithRetries( rdoNo,20 );
        basicActions.click( rdoNo );

        softAssert.assertEquals( valueText.getAttribute( "value" ), "< Back");
        softAssert.assertEquals( btnSaveAndContinue.getText(), "Save and Continue" );
        softAssert.assertAll();
    }


    public void validateFTStudentPageSpanish(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(headerFTStudent,20  );
        softAssert.assertEquals( headerFTStudent.getText(), "Cu\u00E9ntanos sobre la escuela" );
        softAssert.assertEquals( helpMeTextSP.getText(), "Ayuda para entender esta p\u00E1gina" );
        softAssert.assertEquals( anyoneText.getText(), "\u00BFHay alguien en el hogar que asiste la escuela?" );

        softAssert.assertEquals( yesTextSP.getText(),"S\u00ED" );
        basicActions.waitForElementToBePresentWithRetries( rdoYes,20 );
        basicActions.click(rdoYes);

        softAssert.assertTrue(whichText.getText().contains( "\u00BFQu\u00E9 miembros del hogar asisten la escuela? (seleccione todos los que apliquen)" ));

        softAssert.assertEquals( noText.getText(),"No" );
        basicActions.waitForElementToBePresentWithRetries( rdoNo,20 );
        basicActions.click( rdoNo );

        softAssert.assertEquals( valueTextSP.getAttribute("value"), "< Atr\u00E1s" );
        softAssert.assertEquals( btnSaveAndContinue.getText(), "Guardar y Continuar" );
        softAssert.assertAll();
    }
}
