package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TellUsAboutYourselfCoCoPage {

    @FindBy(css = "div.header-1")
    WebElement pageTitleText;

    @FindBy(css = "span.body-text-1")
    List<WebElement> pageValidationText;

    @FindBy(css = "input#firstName")
    WebElement firstNameText;


    @FindBy(css = "input#middleName")
    WebElement middleNameText;

    @FindBy(css = "input#lastName")
    WebElement lastNameText;

    @FindBy(id = "birthDate")
    WebElement memberDOBTbox;

    @FindBy(css = "app-male-female-option .button")
    List<WebElement> genderButton;

    @FindBy(css = "select.input-select")
    WebElement relationshipOption;

    @FindBy(css = "app-yes-no-option .button")
    List<WebElement> applyButton;

    @FindBy(id = "ELIG-MemberDetails-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "ELIG-MemberDetails-GoBack")
    WebElement goBackButton;

    @FindBy(css = "small.required")
    List<WebElement> requiredValidationError;

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public TellUsAboutYourselfCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void enterMemberDOBTbox(String dateOfBirth) {
        basicActions.waitForElementToBeClickable(memberDOBTbox, 30);
        memberDOBTbox.sendKeys(dateOfBirth);
    }

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBePresent(pageTitleText, 30);
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        saveAndContinueButton.click();
    }

    public void specificMemberDetailsCoCo(String dateOfBirth, String gender, String applying) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        enterMemberDOBTbox(dateOfBirth);
        genderSelection(gender);
        applyingForCoverage(applying);
        subscriber.setDob(dateOfBirth);
        subscriber.setGender(gender);
        clickSaveAndContinueButton();
    }

    public void genderSelection(String gender) {
        basicActions.waitForElementListToBePresent(genderButton, 30);
        switch (gender) {
            case "Male":
                genderButton.get(1).click();
                break;
            case "Female":
                genderButton.get(0).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + gender);
        }
    }

    public void applyingForCoverage(String applying) {
        basicActions.waitForElementListToBePresent(applyButton, 30);
        switch (applying) {
            case "Yes":
                applyButton.get(0).click();
                break;
            case "No":
                applyButton.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + applying);
        }
    }

    public void clickGoBackButton() {
        basicActions.waitForElementToBeClickable(goBackButton, 30);
        goBackButton.click();
    }

    public void enterPrimaryFirstLastInfo() {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        basicActions.waitForElementToBePresent(firstNameText, 30);
        firstNameText.sendKeys(subscriber.getFirstName());

        basicActions.waitForElementToBePresent(lastNameText, 30);
        lastNameText.sendKeys(subscriber.getLastName());
    }

    public void verifyTextOnTellUsAboutYourselfPage(String language) {
        switch (language) {
            case "English":
                verifyTextOnTellUsAboutYourselfPage();
                break;
            case "Spanish":
                verifySpanishTextOnTellUsAboutYourselfPage();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }
        public void verifyErrorTextOnTellUsAboutYourselfPage(String language) {
            switch (language) {
                case "English":
                    verifyValidationerrormessageOnTellUsAboutYourselfPage();
                    break;
                case "Spanish":
                    verifySpanishValidationerrormessageOnTellUsAboutYourselfPage();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
    }

    ///////Page Validation-------------------------------------------------------------------------------------
///Text validation
    public void verifyTextOnTellUsAboutYourselfPage() {
        basicActions.waitForElementToBePresent(pageTitleText, 20);
        softAssert.assertEquals(pageTitleText.getText(), "Tell us about yourself");
        softAssert.assertEquals(pageTitleText.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageTitleText.getCssValue("font-size"), "36px");
        softAssert.assertEquals(pageTitleText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(0).getText(), "First name");
        //softAssert.assertEquals(firstNameText.getText(), SharedData.getPrimaryMember().getFirstName());
        softAssert.assertEquals(pageValidationText.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(1).getText(), "Middle name or initial (optional)");
        softAssert.assertEquals(pageValidationText.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(2).getText(), "Last name");
        //softAssert.assertEquals(lastNameText.getText(), SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(pageValidationText.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(3).getText(), "Suffix optional");
        softAssert.assertEquals(pageValidationText.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(4).getText(), "Date of birth");
        //softAssert.assertEquals(memberDOBTbox.getText(), SharedData.getPrimaryMember().getDob());
        softAssert.assertEquals(pageValidationText.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(5).getText(), "Sex");
        softAssert.assertEquals(pageValidationText.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(genderButton.get(0).getText(), "  Female");
        softAssert.assertEquals(genderButton.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(genderButton.get(0).getCssValue("font-size"), "20px");
        softAssert.assertEquals(genderButton.get(0).getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(genderButton.get(1).getText(), "Male");
        softAssert.assertEquals(genderButton.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(genderButton.get(1).getCssValue("font-size"), "20px");
        softAssert.assertEquals(genderButton.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(pageValidationText.get(6).getText(), SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName() + " is " + Character.toUpperCase(SharedData.getMembers().get(0).getFirstName().charAt(0)) + SharedData.getMembers().get(0).getFirstName().substring(1) + " " + Character.toUpperCase(SharedData.getMembers().get(0).getMiddleName().charAt(0)) + ". " + Character.toUpperCase(SharedData.getMembers().get(0).getLastName().charAt(0)) + SharedData.getMembers().get(0).getLastName().substring(1) + "'s?");
        softAssert.assertEquals(pageValidationText.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(relationshipOption.getText(), "Select Option\nSpouse\nParent or Guardian\nChild or Other dependent\nSibling\nStepparent\nStepchild\nPartner\nOther Relative\nUnrelated");
        softAssert.assertEquals(pageValidationText.get(7).getText(), "Are you applying for health insurance?");
        softAssert.assertEquals(pageValidationText.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(applyButton.get(0).getText(), "  Yes");
        softAssert.assertEquals(applyButton.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(applyButton.get(0).getCssValue("font-size"), "20px");
        softAssert.assertEquals(applyButton.get(0).getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(applyButton.get(1).getText(), "No");
        softAssert.assertEquals(applyButton.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(applyButton.get(1).getCssValue("font-size"), "20px");
        softAssert.assertEquals(applyButton.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(goBackButton.getText(), " Go Back");
        softAssert.assertEquals(goBackButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(saveAndContinueButton.getText(), "Save and continue");
        softAssert.assertEquals(saveAndContinueButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueButton.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertAll();
    }

    public void verifySpanishTextOnTellUsAboutYourselfPage() {
        basicActions.waitForElementToBePresent(pageTitleText, 20);
        softAssert.assertEquals(pageTitleText.getText(), "Informaci\u00F3n sobre usted");
        softAssert.assertEquals(pageTitleText.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageTitleText.getCssValue("font-size"), "36px");
        softAssert.assertEquals(pageTitleText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(0).getText(), "Nombre");
        //softAssert.assertEquals(firstNameText.getText(), SharedData.getPrimaryMember().getFirstName());
        softAssert.assertEquals(pageValidationText.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(1).getText(), "Segundo nombre o inicial (opcional)");
        softAssert.assertEquals(pageValidationText.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(2).getText(), "Apellido(s)");
        //softAssert.assertEquals(lastNameText.getText(), SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(pageValidationText.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(3).getText(), "T\u00EDtulo o tratamiento opcional");
        softAssert.assertEquals(pageValidationText.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(4).getText(), "Fecha de nacimiento");
        //softAssert.assertEquals(memberDOBTbox.getText(), SharedData.getPrimaryMember().getDob());
        softAssert.assertEquals(pageValidationText.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(pageValidationText.get(5).getText(), "Sexo");
        softAssert.assertEquals(pageValidationText.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(genderButton.get(0).getText(), "  Femenino");
        softAssert.assertEquals(genderButton.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(genderButton.get(0).getCssValue("font-size"), "20px");
        softAssert.assertEquals(genderButton.get(0).getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(genderButton.get(1).getText(), "Masculino");
        softAssert.assertEquals(genderButton.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(genderButton.get(1).getCssValue("font-size"), "20px");
        softAssert.assertEquals(genderButton.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(pageValidationText.get(6).getText(), SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName() + " es " + Character.toUpperCase(SharedData.getMembers().get(0).getFirstName().charAt(0)) + SharedData.getMembers().get(0).getFirstName().substring(1) + " " + Character.toUpperCase(SharedData.getMembers().get(0).getMiddleName().charAt(0)) + ". " + Character.toUpperCase(SharedData.getMembers().get(0).getLastName().charAt(0)) + SharedData.getMembers().get(0).getLastName().substring(1) + "'s?");
        softAssert.assertEquals(pageValidationText.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(relationshipOption.getText(), "Seleccione\nC\u00F3nyuge\nPadre/madre o tutor\nHijo(a) o Otro dependiente\nHermano(a)\nPadrastro/madrastra\nHijastro/hijastra\nPareja\nOtro parentesco\nSin parentesco");
        softAssert.assertEquals(pageValidationText.get(7).getText(), "\u00BFEsta solicitando seguro de salud?");
        softAssert.assertEquals(pageValidationText.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(pageValidationText.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(pageValidationText.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(applyButton.get(0).getText(), "  Si");
        softAssert.assertEquals(applyButton.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(applyButton.get(0).getCssValue("font-size"), "20px");
        softAssert.assertEquals(applyButton.get(0).getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(applyButton.get(1).getText(), "No");
        softAssert.assertEquals(applyButton.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(applyButton.get(1).getCssValue("font-size"), "20px");
        softAssert.assertEquals(applyButton.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(goBackButton.getText(), " Volver");
        softAssert.assertEquals(goBackButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(saveAndContinueButton.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueButton.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertAll();
    }


    public void verifyValidationerrormessageOnTellUsAboutYourselfPage() {
        basicActions.waitForElementToBePresent(pageTitleText, 20);
        softAssert.assertEquals(pageTitleText.getText(), "Tell us about yourself");
        firstNameText.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ;
        lastNameText.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ;
        clickSaveAndContinueButton();
        softAssert.assertEquals(requiredValidationError.get(0).getText(), "First name is required");
        softAssert.assertEquals(requiredValidationError.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(requiredValidationError.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(requiredValidationError.get(0).getCssValue("color"), "rgba(255, 0, 0, 1)");
        softAssert.assertEquals(requiredValidationError.get(1).getText(), "Last name is required");
        softAssert.assertEquals(requiredValidationError.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(requiredValidationError.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(requiredValidationError.get(1).getCssValue("color"), "rgba(255, 0, 0, 1)");
        softAssert.assertEquals(requiredValidationError.get(2).getText(), "Date of birth is required");
        softAssert.assertEquals(requiredValidationError.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(requiredValidationError.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(requiredValidationError.get(2).getCssValue("color"), "rgba(255, 0, 0, 1)");
        softAssert.assertEquals(requiredValidationError.get(3).getText(), "Please select one of the options below");
        softAssert.assertEquals(requiredValidationError.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(requiredValidationError.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(requiredValidationError.get(3).getCssValue("color"), "rgba(255, 0, 0, 1)");
        softAssert.assertEquals(requiredValidationError.get(4).getText(), "Please select one of the options below");
        softAssert.assertEquals(requiredValidationError.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(requiredValidationError.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(requiredValidationError.get(4).getCssValue("color"), "rgba(255, 0, 0, 1)");
        softAssert.assertAll();
    }

    public void verifySpanishValidationerrormessageOnTellUsAboutYourselfPage() {
        basicActions.waitForElementToBePresent(pageTitleText, 20);
        softAssert.assertEquals(pageTitleText.getText(), "Informaci\u00F3n sobre usted");
        firstNameText.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ;
        lastNameText.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ;
        clickSaveAndContinueButton();
        softAssert.assertEquals(requiredValidationError.get(0).getText(), "El nombre es obligatorio");
        softAssert.assertEquals(requiredValidationError.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(requiredValidationError.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(requiredValidationError.get(0).getCssValue("color"), "rgba(255, 0, 0, 1)");
        softAssert.assertEquals(requiredValidationError.get(1).getText(), "El apellido es obligatorio");
        softAssert.assertEquals(requiredValidationError.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(requiredValidationError.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(requiredValidationError.get(1).getCssValue("color"), "rgba(255, 0, 0, 1)");
        softAssert.assertEquals(requiredValidationError.get(2).getText(), "La fecha de nacimiento es obligatoria");
        softAssert.assertEquals(requiredValidationError.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(requiredValidationError.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(requiredValidationError.get(2).getCssValue("color"), "rgba(255, 0, 0, 1)");
        softAssert.assertEquals(requiredValidationError.get(3).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(requiredValidationError.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(requiredValidationError.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(requiredValidationError.get(3).getCssValue("color"), "rgba(255, 0, 0, 1)");
        softAssert.assertEquals(requiredValidationError.get(4).getText(), "Seleccione una de las siguientes opciones");
        softAssert.assertEquals(requiredValidationError.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(requiredValidationError.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(requiredValidationError.get(4).getCssValue("color"), "rgba(255, 0, 0, 1)");
        softAssert.assertAll();
    }

    public void validateRelationshipLabel(){
        for(MemberDetails member : basicActions.getAllMem()) {
            basicActions.waitForElementToBePresent(firstNameText,10);
            WebElement element = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),'" + member.getFirstName() + "')]/parent::div/parent::form-label"));
            basicActions.waitForElementToBePresent(element, 10);
            softAssert.assertTrue(element.isDisplayed());
            softAssert.assertTrue(element.getText().toLowerCase().contains(member.getFullName().toLowerCase()));
            softAssert.assertAll();
        }
    }

    public void validateAutoPopRelationshipOption(List<String> relationship){
        for(String relationInfo : relationship) {
            String[] parts = relationInfo.split(":");
            String Name = parts[0];  // "Primary"
            String Relation = parts[1]; // "Spouse"
            basicActions.waitForElementToBePresent(firstNameText,10);
            WebElement element = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),'"+Name+"')]/parent::div/parent::form-label/parent::div //select"));
            basicActions.waitForElementToBeClickableWithRetries(element,10);
            // Perform actions on the element
            Select dropdown = new Select(element);
            softAssert.assertEquals(dropdown.getFirstSelectedOption().getText(),Relation,"Autopopulated relationship for "+Name+" is not matching with expected");
            softAssert.assertAll();
        }
    }
}


