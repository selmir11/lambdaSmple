
package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage {

    @FindBy(css = "div.header-1.content-center.content-margin")
    WebElement PageTitle;

    @FindBy(css = "input#firstName")
    WebElement txtFirstName;

    @FindBy(css = "input#middleName")
    WebElement txtMiddleName;

    @FindBy(css = "input#lastName")
    WebElement txtLastName;

    @FindBy(id = "suffix-text1")
    WebElement Selectsuffix;

    @FindBy(id = "birthDate")
    WebElement MemberDOB;

    @FindBy(css = "app-male-female-option .button")
    List<WebElement> genderButton;

    @FindBy(css = "app-yes-no-option .button")
    List<WebElement> applyButton;

    @FindBy(css = "span.body-text-1")
    List<WebElement> textValidation;

    @FindBy(css = "select.input-select")
    WebElement RelationshipOption;

    @FindBy(xpath = "//select[@name='relatedToType']")
    List<WebElement> selectRelationship1;

    @FindBy(xpath = "//span[contains(text(),'Primary')]/parent::div/parent::form-label/parent::div //select")
    WebElement selectRelationshipToPrimary;

    @FindBy(xpath = "//span[contains(text(),'Spouse')]/parent::div/parent::form-label/parent::div //select")
    WebElement selectRelationshipToSpouse;

    @FindBy(xpath = "//span[contains(text(),'Daughter')]/parent::div/parent::form-label/parent::div //select")
    WebElement selectRelationshipToDaughter;

    @FindBy(xpath = "//span[contains(text(),'Son')]/parent::div/parent::form-label/parent::div //select")
    WebElement selectRelationshipToSon;

    @FindBy(id = "ELIG-MemberDetails-GoBack")
    WebElement GoBackButton;

    @FindBy(id = "ELIG-MemberDetails-SaveAndContinue")
    WebElement SaveandContinueButton;

    @FindBy(css = "small.required")
    List<WebElement> requiredValidationError;

    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    public TellUsAboutAdditionalMembersOfYourHouseholdCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }


    public void enterMemberDOB(String dateOfBirth) {
        basicActions.waitForElementToBeClickable(MemberDOB, 30);
        MemberDOB.sendKeys(dateOfBirth);
    }
    public void updateMemberDOB(String dateOfBirth, String memPrefix) {
        basicActions.waitForElementToBeClickable(MemberDOB, 30);
        MemberDOB.clear();
        MemberDOB.sendKeys(dateOfBirth);
    }

    public void clickSaveandContinueButton() {
        basicActions.waitForElementToBeClickable(SaveandContinueButton, 30);
        SaveandContinueButton.click();
    }

    public void clickGoBackButton() {
        basicActions.waitForElementToBeClickable(GoBackButton, 30);
        GoBackButton.click();
    }

    public void setRelationshipOption(String Relation){
       WebElement relationToPrimary = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),'"+SharedData.getPrimaryMember().getFirstName()+"')]/parent::div/parent::form-label/parent::div //select"));
        basicActions.waitForElementToBePresent(relationToPrimary, 15);

        Select dropdown = new Select(relationToPrimary);
        relationToPrimary.click();
        dropdown.selectByVisibleText(Relation);
    }

    public static String getUniqueString(int length) {
        return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
    }

    public void enterSpecificDetails(String Name, String DOB, String gender, String applying) {
        String frstName = Name + getUniqueString(8);
        String mdlName = getUniqueString(8);
        String lastName = getUniqueString(12);
        basicActions.waitForElementToBePresent(txtFirstName, 30);
        txtFirstName.sendKeys(frstName);
        txtMiddleName.sendKeys(mdlName);
        txtLastName.sendKeys(lastName);

        if(DOB.equals("getFromSharedData")){
            DOB = SharedData.getCalculatedDob().get(Name);
            DOB = basicActions.changeDateFormat(DOB, "MM/dd/yyyy", "MMddyyyy");
        }
        else if(DOB.contains("Age")){
            memberDetailswithAge(Integer.parseInt(DOB.replaceAll("\\D", "")));
        }

        List<MemberDetails> memberList = basicActions.getAllMem();


        MemberDetails member = new MemberDetails();
        member.setFirstName(frstName);
        member.setLastName(lastName);
        member.setMiddleName(mdlName);
        member.setDob(DOB);
        member.setGender(gender);
        member.setSignature(frstName + " " + lastName);
        member.setFullName(frstName + " " + mdlName.charAt(0) + ". " + lastName);
        member.setCompleteFullName(frstName + " " + mdlName + " " + lastName);
        member.setApplyingforCov(applying);
        memberList.add(member);

        SharedData.setMembers(memberList);

        enterMemberDOB(DOB);
        genderSelection(gender);
        applyingForCoverage(applying);
    }


    public void specificAdditionalMemberDetailsCoCo(String Name, String DOB, String gender, List<String> Relations, String applying) {

        String frstName = Name + getUniqueString(8);
        String mdlName = getUniqueString(8);
        String lastName = getUniqueString(12);
        basicActions.waitForElementToBePresent(txtFirstName, 30);
        txtFirstName.sendKeys(frstName);
        txtMiddleName.sendKeys(mdlName);
        txtLastName.sendKeys(lastName);

        if(DOB.equals("getFromSharedData")){
            DOB = SharedData.getCalculatedDob().get(Name);
            DOB = basicActions.changeDateFormat(DOB, "MM/dd/yyyy", "MMddyyyy");
        }
        else if(DOB.contains("Age")){
            memberDetailswithAge(Integer.parseInt(DOB.replaceAll("\\D", "")));
        }

        List<MemberDetails> membersList = SharedData.getMembers();

        MemberDetails member = new MemberDetails();
        member.setFirstName(frstName);
        member.setLastName(lastName);
        member.setMiddleName(mdlName);
        member.setDob(DOB);
        member.setGender(gender);
        member.setSignature(frstName + " " + lastName);
        member.setFullName(frstName + " " + mdlName.charAt(0) + ". " + lastName);
        member.setCompleteFullName(frstName + " " + mdlName + " " + lastName);
        member.setApplyingforCov(applying);

        enterMemberDOB(DOB);
        genderSelection(gender);
        for (String Relation : Relations) {
            selectRelationship(Relation);
            applyingForCoverage(applying);
            if(Relation.split(":")[0].equalsIgnoreCase("Primary")){
               String rel = Relation.split(":")[1].toUpperCase().contains("CHILD")? "CHILD" : Relation.split(":")[1].toUpperCase();
                member.setRelation_to_subscriber(rel);
            }
        }
        if(membersList==null){
           membersList = new ArrayList<>();
        }

       membersList.add(member);
        SharedData.setMembers(membersList);
    }

    public void memberDetailswithAge(int Age){
        LocalDate currentDate = LocalDate.now();
        LocalDate DOBCalculate = currentDate.minusYears(Age);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String actualdob=dateFormat.format(DOBCalculate);
    }

    public void specificAdditionalMemberDetailsCoCoSpanish(String DOB, String gender, String Relation, String applying) {

        String frstName = getUniqueString(8);
        String mdlName = getUniqueString(8);
        String lastName = getUniqueString(12);
        basicActions.waitForElementToBePresent(txtFirstName, 30);
        txtFirstName.sendKeys(frstName);
        txtMiddleName.sendKeys(mdlName);
        txtLastName.sendKeys(lastName);

        List<MemberDetails> memberList = basicActions.getAllMem();

        MemberDetails member = new MemberDetails();
        member.setFirstName(frstName);
        member.setLastName(lastName);
        member.setMiddleName(mdlName);
        member.setDob(DOB);
        member.setSignature(frstName+" "+lastName);
        member.setFullName(frstName+" "+mdlName.charAt(0)+". "+lastName);
        memberList.add(member);

        SharedData.setMembers(memberList);

        enterMemberDOB(DOB);
        genderSelectionSpanish(gender);
        applyingForCoverageSpanish(applying);
        setRelationshipOption(Relation);

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

    public void genderSelectionSpanish(String gender) {
        basicActions.waitForElementListToBePresent(genderButton, 30);
        switch (gender) {
            case "Masculino":
                genderButton.get(1).click();
                break;
            case "Femenino":
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

    public void applyingForCoverageSpanish(String applying) {
        basicActions.waitForElementListToBePresent(applyButton, 30);
        switch (applying) {
            case "Si":
                applyButton.get(0).click();
                break;
            case "No":
                applyButton.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + applying);
        }
    }

    public void verifyTextOnTellUsAboutAdditionalMembersOfYourHouseholdPage(String language) {
        switch (language) {
            case "English":
                verifyEnglishTextOnTellUsAboutAdditionalMembersOfYourHouseholdPage();
                break;
            case "Spanish":
                verifySpanishTextOnTellUsAboutAdditionalMembersOfYourHouseholdPage();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }
    public void verifyerrormessageOnTellUsAboutAdditionalMembersOfYourHouseholdfPage(String language) {
        switch (language) {
            case "English":
                verifyValidationerrormessageOnTellUsAboutAdditionalMembersOfYourHouseholdfPage();
                break;
            case "Spanish":
                verifySpanishValidationerrormessageOnTellUsAboutAdditionalMembersOfYourHouseholdfPage();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }
    ///////Page Validation-------------------------------------------------------------------------------------
    ///Text validation
    public void verifyEnglishTextOnTellUsAboutAdditionalMembersOfYourHouseholdPage(){
        basicActions.waitForElementToBePresent(PageTitle,10);
        softAssert.assertEquals(PageTitle.getText(), "Tell us about additional members of your household");
        softAssert.assertEquals(PageTitle.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PageTitle.getCssValue("font-size"), "36px");
        softAssert.assertEquals(PageTitle.getCssValue("color"), "rgba(43, 49, 60, 1)");
        specificAdditionalMemberDetailsCoCo("Spouse","01011982","Male", Collections.singletonList("Primary:Spouse"), "Yes");
        softAssert.assertEquals(textValidation.get(0).getText(), "First name");
        softAssert.assertEquals(textValidation.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(textValidation.get(1).getText(), "Middle name or initial (optional)");
        softAssert.assertEquals(textValidation.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(textValidation.get(2).getText(), "Last name");
        softAssert.assertEquals(textValidation.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(textValidation.get(3).getText(), "Suffix optional");
        softAssert.assertEquals(textValidation.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(textValidation.get(4).getText(), "Date of birth");
        softAssert.assertEquals(textValidation.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(textValidation.get(5).getText(), "Sex");
        softAssert.assertEquals(textValidation.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(genderButton.get(0).getText(), "Female");
        softAssert.assertEquals(genderButton.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(genderButton.get(0).getCssValue("font-size"), "20px");
        softAssert.assertEquals(genderButton.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(genderButton.get(1).getText(), "  Male");
        softAssert.assertEquals(genderButton.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(genderButton.get(1).getCssValue("font-size"), "20px");
        softAssert.assertEquals(genderButton.get(1).getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(textValidation.get(6).getText(), SharedData.getMembers().get(0).getFirstName()+" "+SharedData.getMembers().get(0).getLastName()+" is "+Character.toUpperCase(SharedData.getPrimaryMember().getFirstName().charAt(0)) + SharedData.getPrimaryMember().getFirstName().substring(1) + " " +
                Character.toUpperCase(SharedData.getPrimaryMember().getLastName().charAt(0)) + SharedData.getPrimaryMember().getLastName().substring(1)+"'s?");
        softAssert.assertEquals(textValidation.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RelationshipOption.getText(), "Select Option\nSpouse\nParent or Guardian\nChild or Other dependent\nSibling\nStepparent\nStepchild\nPartner\nOther Relative\nUnrelated");
        softAssert.assertEquals(textValidation.get(7).getText(), "Are you applying for health insurance?");
        softAssert.assertEquals(textValidation.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(applyButton.get(0).getText(), "  Yes");
        softAssert.assertEquals(applyButton.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(applyButton.get(0).getCssValue("font-size"), "20px");
        softAssert.assertEquals(applyButton.get(0).getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(applyButton.get(1).getText(), "No");
        softAssert.assertEquals(applyButton.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(applyButton.get(1).getCssValue("font-size"), "20px");
        softAssert.assertEquals(applyButton.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(GoBackButton.getText(), " Go Back");
        softAssert.assertEquals(GoBackButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(GoBackButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(GoBackButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(SaveandContinueButton.getText(), "Save and continue");
        softAssert.assertEquals(SaveandContinueButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(SaveandContinueButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(SaveandContinueButton.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertAll();
    }

    public void verifySpanishTextOnTellUsAboutAdditionalMembersOfYourHouseholdPage(){
        basicActions.waitForElementToBePresent(PageTitle,10);
        softAssert.assertEquals(PageTitle.getText(), "Informaci\u00F3n sobre otros miembros de su familia");
        softAssert.assertEquals(PageTitle.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(PageTitle.getCssValue("font-size"), "36px");
        softAssert.assertEquals(PageTitle.getCssValue("color"), "rgba(43, 49, 60, 1)");
        specificAdditionalMemberDetailsCoCoSpanish("01011982","Masculino", "C\u00F3nyuge", "Si");
        softAssert.assertEquals(textValidation.get(0).getText(), "Nombre");
        softAssert.assertEquals(textValidation.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(0).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(textValidation.get(1).getText(), "Segundo nombre o inicial (opcional)");
        softAssert.assertEquals(textValidation.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(1).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(textValidation.get(2).getText(), "Apellido(s)");
        softAssert.assertEquals(textValidation.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(2).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(textValidation.get(3).getText(), "T\u00EDtulo o tratamiento opcional");
        softAssert.assertEquals(textValidation.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(3).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(textValidation.get(4).getText(), "Fecha de nacimiento");
        softAssert.assertEquals(textValidation.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(4).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(textValidation.get(5).getText(), "Sexo");
        softAssert.assertEquals(textValidation.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(5).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(genderButton.get(0).getText(), "Femenino");
        softAssert.assertEquals(genderButton.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(genderButton.get(0).getCssValue("font-size"), "20px");
        softAssert.assertEquals(genderButton.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(genderButton.get(1).getText(), "  Masculino");
        softAssert.assertEquals(genderButton.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(genderButton.get(1).getCssValue("font-size"), "20px");
        softAssert.assertEquals(genderButton.get(1).getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(textValidation.get(6).getText(), SharedData.getMembers().get(1).getFirstName()+" "+SharedData.getMembers().get(1).getLastName()+" es "+Character.toUpperCase(SharedData.getPrimaryMember().getFirstName().charAt(0)) + SharedData.getPrimaryMember().getFirstName().substring(1) + " " +
                Character.toUpperCase(SharedData.getPrimaryMember().getLastName().charAt(0)) + SharedData.getPrimaryMember().getLastName().substring(1)+"'s?");
        softAssert.assertEquals(textValidation.get(6).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(6).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RelationshipOption.getText(), "Seleccione\nC\u00F3nyuge\nPadre/madre o tutor\nHijo(a) o Otro dependiente\nHermano(a)\nPadrastro/madrastra\nHijastro/hijastra\nPareja\nOtro parentesco\nSin parentesco");
        softAssert.assertEquals(textValidation.get(7).getText(), "\u00BFEsta solicitando seguro de salud?");
        softAssert.assertEquals(textValidation.get(7).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(textValidation.get(7).getCssValue("font-size"), "16px");
        softAssert.assertEquals(textValidation.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(applyButton.get(0).getText(), "  S\u00ED");
        softAssert.assertEquals(applyButton.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(applyButton.get(0).getCssValue("font-size"), "20px");
        softAssert.assertEquals(applyButton.get(0).getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(applyButton.get(1).getText(), "No");
        softAssert.assertEquals(applyButton.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(applyButton.get(1).getCssValue("font-size"), "20px");
        softAssert.assertEquals(applyButton.get(1).getCssValue("color"), "rgba(77, 77, 79, 1)");
        softAssert.assertEquals(GoBackButton.getText(), " Volver");
        softAssert.assertEquals(GoBackButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(GoBackButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(GoBackButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(SaveandContinueButton.getText(), "Guardar y continuar");
        softAssert.assertEquals(SaveandContinueButton.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(SaveandContinueButton.getCssValue("font-size"), "20px");
        softAssert.assertEquals(SaveandContinueButton.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertAll();
    }

    public void verifyValidationerrormessageOnTellUsAboutAdditionalMembersOfYourHouseholdfPage() {
        basicActions.waitForElementToBePresent(PageTitle,10);
        softAssert.assertEquals(PageTitle.getText(), "Tell us about additional members of your household");
        clickSaveandContinueButton();
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

    public void verifySpanishValidationerrormessageOnTellUsAboutAdditionalMembersOfYourHouseholdfPage() {
        basicActions.waitForElementToBePresent(PageTitle,10);
        softAssert.assertEquals(PageTitle.getText(), "Informaci\u00F3n sobre otros miembros de su familia");
        clickSaveandContinueButton();
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

    public void selectRelationship(String Relationship){
        String[] parts = Relationship.split(":");
        String Name = parts[0];  // "Primary"
        String Relation = parts[1]; // "Spouse"
            WebElement element = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),'"+Name+"')]/parent::div/parent::form-label/parent::div //select"));
            basicActions.waitForElementToBeClickableWithRetries(element,10);
            // Perform actions on the element
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(Relation);
            softAssert.assertTrue(dropdown.getFirstSelectedOption().getText().equals(Relation));
            softAssert.assertAll();
    }

    public void getDob(String namePrefix, String dob){
        basicActions.getDob(namePrefix, dob);
    }

    public void validateRelationshipLabel(){
        for(MemberDetails member : basicActions.getAllMem()) {
            basicActions.waitForElementToBePresent(txtFirstName,10);
            txtFirstName.sendKeys(SharedData.getPrimaryMember().getFirstName() + "test");
            txtMiddleName.sendKeys(SharedData.getPrimaryMember().getMiddleName() + "test");
            txtLastName.sendKeys(SharedData.getPrimaryMember().getLastName() + "test");
            WebElement element = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),'" + member.getFirstName() + "')]/parent::div/parent::form-label"));
            basicActions.waitForElementToBePresent(element, 10);
            softAssert.assertTrue(element.isDisplayed());
            softAssert.assertTrue(element.getText().toLowerCase().contains(member.getFullName().toLowerCase()));
            softAssert.assertAll();
        }
    }

    public void validateTellUsAboutAdditionalMembersCoCo(String FName,String DOB, String Gender, String applying, List<String> relationship) {
        basicActions.waitForElementToBePresent(txtFirstName, 30);
        List<MemberDetails> memberList=basicActions.getAllMem();
        for(MemberDetails actualMember : memberList) {
            if(actualMember.getFirstName().contains(FName)) {
                softAssert.assertEquals(txtFirstName.getAttribute("value"),actualMember.getFirstName());
                softAssert.assertEquals(txtMiddleName.getAttribute("value"),actualMember.getMiddleName());
                softAssert.assertEquals(txtLastName.getAttribute("value"),actualMember.getLastName());
                softAssert.assertEquals(DOB,actualMember.getDob());
                softAssert.assertEquals(Gender,actualMember.getGender());
                softAssert.assertEquals(applying,actualMember.getApplyingforCov());
            }
        }

        for(String relationInfo : relationship) {
            String[] parts = relationInfo.split(":");
            String Name = parts[0];  // "Primary"
            String Relation = parts[1]; // "Spouse"
            basicActions.waitForElementToBePresent(txtFirstName,10);
            WebElement element = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),'"+Name+"')]/parent::div/parent::form-label/parent::div //select"));
            basicActions.waitForElementToBeClickableWithRetries(element,10);
            // Perform actions on the element
            Select dropdown = new Select(element);
            softAssert.assertEquals(dropdown.getFirstSelectedOption().getText(),Relation,"Autopopulated relationship for "+Name+" is not matching with expected");
            //softAssert.assertAll();
        }
        softAssert.assertAll();
    }

    public void updateAdditionalMemberDetailsCoCo(String FName, String DOB, String gender, String applying, List<String> Relations) {
        List<MemberDetails> memberList=basicActions.getAllMem();
        for(MemberDetails actualMember : memberList) {
            if (actualMember.getFirstName().contains(FName)) {
                if (DOB.equals("getFromSharedData")) {
                    DOB = SharedData.getCalculatedDob().get(FName);
                    DOB = basicActions.changeDateFormat(DOB, "MM/dd/yyyy", "MMddyyyy");
                } else if (DOB.contains("Age")) {
                    memberDetailswithAge(Integer.parseInt(DOB.replaceAll("\\D", "")));
                }
                enterMemberDOB(DOB);
                genderSelection(gender);
                for (String Relation : Relations) {
                    selectRelationship(Relation);
                }
                applyingForCoverage(applying);
                actualMember.setDob(DOB);
                actualMember.setGender(gender);
                actualMember.setApplyingforCov(applying);
            }
        }
    }


    public void validateDropdownOptions(List<String> expectedValues) {
        Select select = new Select(selectRelationship1.get(0));
        List<String> actualValues = new ArrayList<>();
        for (WebElement option : select.getOptions()) {
            actualValues.add(option.getText());
        }
        if (!actualValues.containsAll(expectedValues)) {
            throw new AssertionError("Dropdown validation failed. Expected: " + expectedValues + ", Actual: " + actualValues);
        }
    }

}


