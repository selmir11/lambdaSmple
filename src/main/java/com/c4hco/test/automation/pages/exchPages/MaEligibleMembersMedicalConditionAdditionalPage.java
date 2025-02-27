package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MaEligibleMembersMedicalConditionAdditionalPage {

    private BasicActions basicActions;
    public MaEligibleMembersMedicalConditionAdditionalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    SoftAssert softAssert = new SoftAssert();
    
    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(xpath = "//*[@value = 'Save and Continue']")
    WebElement btnSaveAndContinue;

    @FindBy(xpath = "//*[@class = 'c4PageHeader']")
    WebElement headerMedicalConditionAdditional;

    @FindBy(xpath = "//*[contains(text(),'Help me understand this page')]")
    WebElement helpMeText;

    @FindBy(xpath = "//*[contains(text(),'Ayuda para entender esta p\u00E1gina')]")
    WebElement helpMeTextSP;

    @FindBy(xpath = "//*[@id = 'criteriaApplicableLabel']")
    WebElement anyoneText;

    @FindBy (xpath= "//*[@id = 'memberMAForMedicalCondition']")
    WebElement questionText;

    @FindBy (xpath= "//*[@id = 'memberMAForMedicalCondition']")
    WebElement questionTextSP;


    @FindBy(xpath = "//*[@value = '< Back']")
    WebElement valueText;

    @FindBy(xpath = "//*[@value = '< Atr\u00E1s']")
    WebElement valueTextSP;

    // Calendar
    @FindBy(id = "medicalConditionBeginDate")
    WebElement conditionDate;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> allmembersConditioncheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> conditionEventDate;

    public String getCurrentDate() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate currentDate = LocalDate.now();
        // Now format the date
        return dateFormat.format(currentDate);
    }

    public void iContinue(){
        basicActions.waitForElementToBePresentWithRetries( btnSaveAndContinue,20 );
        basicActions.click( btnSaveAndContinue );

    }
    public void iValidateMedicalConditionAdditionalText(String language) {
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        switch (language) {
            case "English":
                validateMedicalConditionAdditionalEnglish();
                break;
            case "Spanish":
                validateMedicalConditionAddtionalSpanish();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );

        }

    }

    public void validateMedicalConditionAdditionalEnglish(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(headerMedicalConditionAdditional,20  );
        softAssert.assertTrue(headerMedicalConditionAdditional.getText().contains( "Medical Condition or Disability:" ));

        softAssert.assertEquals( helpMeText.getText(), "Help me understand this page" );
        softAssert.assertTrue(questionText.getText().contains( "medical condition or disability begin?" ));


        softAssert.assertEquals( valueText.getAttribute( "value" ), "< Back");
        softAssert.assertEquals( btnSaveAndContinue.getAttribute( "value" ), "Save and Continue");
        softAssert.assertAll();
    }


    public void validateMedicalConditionAddtionalSpanish(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(headerMedicalConditionAdditional,20  );
        softAssert.assertTrue(headerMedicalConditionAdditional.getText().contains( "Medical Condition or Disability:" ));

        softAssert.assertEquals( helpMeTextSP.getText(), "Ayuda para entender esta p\u00E1gina" );
        softAssert.assertTrue(questionTextSP.getText().contains( "medical condition or disability begin?" ));

        softAssert.assertEquals( valueTextSP.getAttribute("value"), "< Atr\u00E1s" );
        softAssert.assertEquals( btnSaveAndContinue.getAttribute( "value" ), "Guardar y Continuar");
        softAssert.assertAll();
    }

    public void iselectMedicalConditionDate(){
        conditionDate.click();
        conditionDate.sendKeys( getCurrentDate() );
        }
    }

