package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OhiMedicarePage_Elmo {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public OhiMedicarePage_Elmo(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container .header-1")
    WebElement ohiHeader;

    @FindBy(css = ".container .header-2")
    WebElement ohiMedicareHeader;

    @FindBy(css = ".ohi-container.body-text-1 > span")
    WebElement pleaseEnterTxt;

    @FindBy(css = ".row.label-row > div > label")
    List<WebElement> questionTxt;

    @FindBy(css = "#ELIG-medicareOhi-partAPremium-container span.error-message")
    WebElement currentlyEligibleError;

    @FindBy(id = "ELIG-medicareOhi-partAPremium-YesButton")
    WebElement currentlyEligibleYes;

    @FindBy(id = "ELIG-medicareOhi-partAPremium-NoButton")
    WebElement currentlyEligibleNo;

    @FindBy(css = ".ohi-container > div > div:nth-child(1)")
    WebElement areYouEnrolledTxt;

    @FindBy(css = "lib-checkbox-control > label")
    List<WebElement> medicareCheckboxDetails;

    @FindBy(css = "#ELIG-medicareOhi-partBEndsSoon-container label > span")
    WebElement questionTxtB;

    @FindBy(css = "#ELIG-medicareOhi-partB-container .checkbox-container")
    WebElement medicareCheckboxDetailsB;

    @FindBy(css = "#ELIG-medicareOhi-premiumAmount-container span.error-message")
    WebElement InsuranceAmountError;

    @FindBy(css = "#ELIG-medicareOhi-premiumAmount")
    WebElement partAInsuranceAmount;

    @FindBy(css = "#ELIG-medicareOhi-partAEndsSoon-container span.error-message")
    WebElement partAInsuranceEndingError;

    @FindBy(id = "ELIG-medicareOhi-partAEndsSoon-YesButton")
    WebElement partAInsuranceEndingYes;

    @FindBy(id = "ELIG-medicareOhi-partAEndsSoon-NoButton")
    WebElement partAInsuranceEndingNo;

    @FindBy(css = "#ELIG-medicareOhi-partACoverageDate-container span.error-message")
    WebElement partAInsuranceEndInputError;

    @FindBy(css = "#ELIG-medicareOhi-partACoverageDate")
    WebElement partAInsuranceEndInput;

    @FindBy(css = "#ELIG-medicareOhi-partBEndsSoon-container span.error-message")
    WebElement partBInsuranceEndingError;

    @FindBy(id = "ELIG-medicareOhi-partBEndsSoon-YesButton")
    WebElement partBInsuranceEndingYes;

    @FindBy(id = "ELIG-medicareOhi-partBEndsSoon-NoButton")
    WebElement partBInsuranceEndingNo;

    @FindBy(css = "#ELIG-medicareOhi-partBCoverageDate-container span.error-message")
    WebElement partBInsuranceEndInputError;

    @FindBy(css = "#ELIG-medicareOhi-partBCoverageDate")
    WebElement partBInsuranceEndInput;

    @FindBy(id = "medicareOhi-GoBack")
    WebElement goBackButton;

    @FindBy(id = "medicareOhi-SaveAndContinue")
    WebElement saveAndContinueBtn;

    public void clickSaveAndContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
        saveAndContinueBtn.click();
    }

    public void clickGoBack(){
        basicActions.waitForElementToBeClickable(goBackButton, 20);
        goBackButton.click();
    }

    public void clickCurrentlyEligibleOption(String currentlyEligible) {
        switch (currentlyEligible) {
            case "Yes":
                basicActions.waitForElementToBeClickable(currentlyEligibleYes, 20);
                basicActions.click(currentlyEligibleYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(currentlyEligibleNo, 20);
                basicActions.click(currentlyEligibleNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + currentlyEligible);
        }
    }

    public void clickInsurancePartOption(String insurancePart) {
        switch (insurancePart){
            case "A":
                basicActions.waitForElementListToBePresent(medicareCheckboxDetails,20);
                medicareCheckboxDetails.get(0).click();
                break;
            case "B":
                basicActions.waitForElementToBePresent(medicareCheckboxDetailsB,20);
                medicareCheckboxDetailsB.click();
                break;
            case "A Don't Pay":
                basicActions.waitForElementListToBePresent(medicareCheckboxDetails,20);
                medicareCheckboxDetails.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insurancePart);
        }
    }

    public void enterPartAAmount(String premiumAmount){
        basicActions.waitForElementToBePresent(partAInsuranceAmount, 20);
        partAInsuranceAmount.clear();
        partAInsuranceAmount.sendKeys(premiumAmount);
    }

    public void clickInsuranceEndingPartOption(String insuranceEnding, String part) {
        switch (part) {
            case "A":
                clickInsuranceEndingPartAOption(insuranceEnding);
                break;
            case "B":
                clickInsuranceEndingPartBOption(insuranceEnding);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + part);
        }
    }

    public void clickInsuranceEndingPartAOption(String insuranceEnding) {
        switch (insuranceEnding) {
            case "Yes":
                basicActions.waitForElementToBeClickable(partAInsuranceEndingYes, 20);
                basicActions.click(partAInsuranceEndingYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(partAInsuranceEndingNo, 20);
                basicActions.click(partAInsuranceEndingNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceEnding);
        }
    }

    public void clickInsuranceEndingPartBOption(String insuranceEnding) {
        switch (insuranceEnding) {
            case "Yes":
                basicActions.waitForElementToBeClickable(partBInsuranceEndingYes, 20);
                basicActions.click(partBInsuranceEndingYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(partBInsuranceEndingNo, 20);
                basicActions.click(partBInsuranceEndingNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceEnding);
        }
    }

    public void enterEndDate(String insurancePart){
        switch (insurancePart) {
            case "A":
                enterEndDatePartA();
                break;
            case "B":
                enterEndDatePartB();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insurancePart);
        }
    }

    public void enterEndDatePartA(){
        basicActions.waitForElementToBePresent(partAInsuranceEndInput, 60);
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        DateFormat endOfCurrentMonth = new SimpleDateFormat("MM-dd");

        partAInsuranceEndInput.sendKeys(endOfCurrentMonth.format(lastDayOfMonth));
    }

    public void enterEndDatePartB(){
        basicActions.waitForElementToBePresent(partBInsuranceEndInput, 60);
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        DateFormat endOfCurrentMonth = new SimpleDateFormat("MM-dd");

        partBInsuranceEndInput.sendKeys(endOfCurrentMonth.format(lastDayOfMonth));
    }



    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    public void verifyHeadersMedicareOhiPageEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiMedicareHeader.getText(),"Medicare");
        softAssert.assertAll();
    }

    public void verifyInitialQuestions(String language){
        switch (language) {
            case "English":
                basicActions.waitForElementListToBePresent(questionTxt, 15);
                softAssert.assertEquals(questionTxt.get(0).getText(), "Are you currently eligible for Medicare Premium Free Part A?");
                softAssert.assertEquals(areYouEnrolledTxt.getText(), "Are you enrolled in any of the following?");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementListToBePresent(questionTxt, 15);
                softAssert.assertEquals(questionTxt.get(0).getText(), "Are you currently eligible for Medicare Premium Free Part A?");
                softAssert.assertEquals(areYouEnrolledTxt.getText(), "Are you enrolled in any of the following?");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyCheckboxes(String boxA, String boxB){
        basicActions.waitForElementListToBePresent(medicareCheckboxDetails,20);
        switch (boxA){
            case "is":
                softAssert.assertEquals(medicareCheckboxDetails.get(0).getAttribute("className"), "checkbox-container checked");
                softAssert.assertAll();
                break;
            case "is not":
                softAssert.assertEquals(medicareCheckboxDetails.get(0).getAttribute("className"), "checkbox-container");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + boxA);
        }
        switch (boxB){
            case "is":
                softAssert.assertEquals(medicareCheckboxDetailsB.getAttribute("className"), "checkbox-container checked");
                softAssert.assertAll();
                break;
            case "is not":
                softAssert.assertEquals(medicareCheckboxDetailsB.getAttribute("className"), "checkbox-container");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + boxA);
        }
    }

    public void verifyCurrentlyEligibleOption(String currentlyEligible){
        switch (currentlyEligible){
            case "Yes":
                basicActions.waitForElementToBePresent(currentlyEligibleYes,15);
                softAssert.assertTrue(currentlyEligibleYes.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(currentlyEligibleNo,15);
                softAssert.assertTrue(currentlyEligibleNo.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "Not Selected":
                basicActions.waitForElementToBePresent(currentlyEligibleYes,15);
                softAssert.assertTrue(currentlyEligibleYes.getAttribute("class").equals("button option-button ng-star-inserted"));
                softAssert.assertTrue(currentlyEligibleNo.getAttribute("class").equals("button option-button ng-star-inserted"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + currentlyEligible);
        }
    }

    public void verifyPartInsuranceEndingOption(String part, String insuranceEnding){
        switch (part){
            case "A":
                verifyPartAInsuranceEndingOption(insuranceEnding);
                break;
            case "B":
                verifyPartBInsuranceEndingOption(insuranceEnding);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + part);
        }
    }

    public void verifyPartAInsuranceEndingOption(String insuranceEnding){
        switch (insuranceEnding){
            case "Yes":
                basicActions.waitForElementToBePresent(partAInsuranceEndingYes,15);
                softAssert.assertTrue(partAInsuranceEndingYes.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(partAInsuranceEndingNo,15);
                softAssert.assertTrue(partAInsuranceEndingNo.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceEnding);
        }
    }

    public void verifyPartAPremiumAmount(String premiumAmount){
        basicActions.waitForElementToBePresent(partAInsuranceAmount,15);
        softAssert.assertEquals(partAInsuranceAmount.getAttribute("value"), premiumAmount);
        softAssert.assertAll();
    }

    public void verifyPartBInsuranceEndingOption(String insuranceEnding){
        switch (insuranceEnding){
            case "Yes":
                basicActions.waitForElementToBePresent(partBInsuranceEndingYes,15);
                softAssert.assertTrue(partBInsuranceEndingYes.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(partBInsuranceEndingNo,15);
                softAssert.assertTrue(partBInsuranceEndingNo.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceEnding);
        }
    }

    public void verifyPartEndDate(String part){
        switch (part){
            case "A":
                verifyPartAEndDate();
                break;
            case "B":
                verifyPartBEndDate();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + part);
        }
    }

    public void verifyPartAEndDate(){
        basicActions.waitForElementToBePresent(partAInsuranceEndInput, 60);
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        DateFormat endOfCurrentMonth = new SimpleDateFormat("yyyy-MM-dd");

        softAssert.assertTrue(partAInsuranceEndInput.getAttribute("value").contains(endOfCurrentMonth.format(lastDayOfMonth)));
        softAssert.assertAll();
    }

    public void verifyPartBEndDate(){
        basicActions.waitForElementToBePresent(partBInsuranceEndInput, 60);
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        DateFormat endOfCurrentMonth = new SimpleDateFormat("yyyy-MM-dd");

        softAssert.assertTrue(partBInsuranceEndInput.getAttribute("value").contains(endOfCurrentMonth.format(lastDayOfMonth)));
        softAssert.assertAll();
    }

    public void verifyMedicarePageData(String dataToVerify, String language){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (language){
            case "English":
                verifyMedicarePageDataEnglish(dataToVerify);
                break;
            case "Spanish":
                verifyMedicarePageDataSpanish(dataToVerify);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyMedicarePageDataEnglish(String dataToVerify){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (dataToVerify){
            case "First Section":
                verifyMedicarePageFirstSectionDataEnglish();
                break;
            case "Part A Section":
                verifyMedicarePageFirstSectionDataEnglish();
                verifyMedicarePagePartASectionDataEnglish();
                break;
            case "Part B Section":
                verifyMedicarePageFirstSectionDataEnglish();
                verifyMedicarePagePartBSectionDataEnglish();
                break;
            case "Part A & B Section":
                verifyMedicarePageFirstSectionDataEnglish();
                verifyMedicarePagePartASectionDataEnglish();
                verifyMedicarePagePartBSectionDataEnglish();
                break;
            case "First Section Secondary":
                verifyMedicarePageFirstSectionSecondaryDataEnglish();
                break;
            case "Part A Section Secondary":
                verifyMedicarePageFirstSectionSecondaryDataEnglish();
                verifyMedicarePagePartASectionDataEnglish();
                break;
            case "Part B Section Secondary":
                verifyMedicarePageFirstSectionSecondaryDataEnglish();
                verifyMedicarePagePartBSectionDataEnglish();
                break;
            case "Part A & B Section Secondary":
                verifyMedicarePageFirstSectionSecondaryDataEnglish();
                verifyMedicarePagePartASectionDataEnglish();
                verifyMedicarePagePartBSectionDataEnglish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackButton.getText(),"  Go Back");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Save and Continue");
        softAssert.assertAll();
    }

    public void verifyMedicarePageFirstSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiMedicareHeader.getText(),"Medicare");
        softAssert.assertEquals(pleaseEnterTxt.getText(), "Please enter the following information about your eligibility or current enrollment in Medicare.");
        softAssert.assertEquals(questionTxt.get(0).getText(),"Are you currently eligible for Medicare Premium Free Part A?");
        softAssert.assertEquals(currentlyEligibleYes.getText(),"Yes");
        softAssert.assertEquals(currentlyEligibleNo.getText(),"No");
        softAssert.assertEquals(areYouEnrolledTxt.getText(),"Are you enrolled in any of the following?");
        softAssert.assertEquals(medicareCheckboxDetails.get(0).getText(),"Part A");
        softAssert.assertEquals(medicareCheckboxDetailsB.getText(),"Part B");
        softAssert.assertAll();
    }

    public void verifyMedicarePagePartASectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(questionTxt.get(1).getText(),"Premium Amount");
        softAssert.assertEquals(partAInsuranceAmount.getText(),"");
        softAssert.assertEquals(questionTxt.get(2).getText(),"Will this health insurance end in the next 60 days?");
        softAssert.assertEquals(partAInsuranceEndingYes.getText(),"Yes");
        softAssert.assertEquals(partAInsuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyMedicarePagePartBSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(questionTxtB.getText(),"Will this health insurance end in the next 60 days?");
        softAssert.assertEquals(partBInsuranceEndingYes.getText(),"Yes");
        softAssert.assertEquals(partBInsuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyMedicarePageFirstSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(ohiMedicareHeader.getText(),"Medicare");
        softAssert.assertTrue(pleaseEnterTxt.getText().equalsIgnoreCase( "Please enter the following information about "+SharedData.getMembers().get(0).getFullName()+"'s eligibility or current enrollment in Medicare."));
        softAssert.assertTrue(questionTxt.get(0).getText().equalsIgnoreCase("Is "+SharedData.getMembers().get(0).getFullName()+" currently eligible for Medicare Premium Free Part A?"));
        softAssert.assertEquals(currentlyEligibleYes.getText(),"Yes");
        softAssert.assertEquals(currentlyEligibleNo.getText(),"No");
        softAssert.assertTrue(areYouEnrolledTxt.getText().equalsIgnoreCase("Is "+SharedData.getMembers().get(0).getFullName()+" enrolled in any of the following?"));
        softAssert.assertEquals(medicareCheckboxDetails.get(0).getText(),"Part A");
        softAssert.assertEquals(medicareCheckboxDetailsB.getText(),"Part B");
        softAssert.assertAll();
    }

    public void verifyMedicarePageDataSpanish(String dataToVerify){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (dataToVerify){
            case "First Section":
                verifyMedicarePageFirstSectionDataSpanish();
                break;
            case "Part A Section":
                verifyMedicarePageFirstSectionDataSpanish();
                verifyMedicarePagePartASectionDataSpanish();
                break;
            case "Part B Section":
                verifyMedicarePageFirstSectionDataSpanish();
                verifyMedicarePagePartBSectionDataSpanish();
                break;
            case "Part A & B Section":
                verifyMedicarePageFirstSectionDataSpanish();
                verifyMedicarePagePartASectionDataSpanish();
                verifyMedicarePagePartBSectionDataSpanish();
                break;
            case "First Section Secondary":
                verifyMedicarePageFirstSectionSecondaryDataSpanish();
                break;
            case "Part A Section Secondary":
                verifyMedicarePageFirstSectionSecondaryDataSpanish();
                verifyMedicarePagePartASectionDataSpanish();
                break;
            case "Part B Section Secondary":
                verifyMedicarePageFirstSectionSecondaryDataSpanish();
                verifyMedicarePagePartBSectionDataSpanish();
                break;
            case "Part A & B Section Secondary":
                verifyMedicarePageFirstSectionSecondaryDataSpanish();
                verifyMedicarePagePartASectionDataSpanish();
                verifyMedicarePagePartBSectionDataSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackButton.getText(),"  Volver");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyMedicarePageFirstSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiMedicareHeader.getText(),"Medicare");
        softAssert.assertEquals(pleaseEnterTxt.getText(), "Ingrese la siguiente informaci\u00F3n acerca de su elegibilidad o inscripci\u00F3n actual en Medicare.");
        softAssert.assertEquals(questionTxt.get(0).getText(),"\u00BFActualmente, es elegible para Medicare Parte A sin prima?");
        softAssert.assertEquals(currentlyEligibleYes.getText(),"S\u00ED");
        softAssert.assertEquals(currentlyEligibleNo.getText(),"No");
        softAssert.assertEquals(areYouEnrolledTxt.getText(),"\u00BFEst\u00E1s inscrito/a en alguno de los siguientes");
        softAssert.assertEquals(medicareCheckboxDetails.get(0).getText(),"Parte A");
        softAssert.assertEquals(medicareCheckboxDetailsB.getText(),"Parte B");
        softAssert.assertAll();
    }

    public void verifyMedicarePagePartASectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(questionTxt.get(1).getText(),"Monto de la cuota");
        softAssert.assertEquals(partAInsuranceAmount.getText(),"");
        softAssert.assertEquals(questionTxt.get(2).getText(),"\u00BFEste seguro de salud terminar\u00E1 en los siguientes 60 d\u00EDas?");
        softAssert.assertEquals(partAInsuranceEndingYes.getText(),"S\u00ED");
        softAssert.assertEquals(partAInsuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyMedicarePagePartBSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(questionTxtB.getText(),"\u00BFEste seguro de salud terminar\u00E1 en los siguientes 60 d\u00EDas?");
        softAssert.assertEquals(partBInsuranceEndingYes.getText(),"S\u00ED");
        softAssert.assertEquals(partBInsuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyMedicarePageFirstSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(ohiMedicareHeader.getText(),"Medicare");
        softAssert.assertTrue(pleaseEnterTxt.getText().equalsIgnoreCase( "Ingrese la siguiente informaci\u00F3n acerca de la elegibilidad o inscripci\u00F3n actual de " + SharedData.getMembers().get(0).getFullName() + " en Medicare."));
        softAssert.assertTrue(questionTxt.get(0).getText().equalsIgnoreCase("\u00BFActualmente " + SharedData.getMembers().get(0).getFullName() + " es elegible para Medicare Parte A sin pago de prima?"));
        softAssert.assertEquals(currentlyEligibleYes.getText(),"S\u00ED");
        softAssert.assertEquals(currentlyEligibleNo.getText(),"No");
        softAssert.assertTrue(areYouEnrolledTxt.getText().equalsIgnoreCase("\u00BFEst\u00E1 " + SharedData.getMembers().get(0).getFullName() + " inscrito en cualquiera de los siguientes tipos de cobertura?"));
        softAssert.assertEquals(medicareCheckboxDetails.get(0).getText(),"Parte A");
        softAssert.assertEquals(medicareCheckboxDetailsB.getText(),"Parte B");
        softAssert.assertAll();
    }

    public void verifyErrorMessage(String errorType, String language) {
        switch (errorType) {
            case "Currently Eligible":
                verifyCurrentlyEligibleError(language);
                break;
            case "Part A Amount Required":
                verifyPartAAmountError(language);
                break;
            case "Part A":
                verifyPartAError(language);
                break;
            case "Part A Date":
                verifyPartADateError(language);
                break;
            case "Part B":
                verifyPartBError(language);
                break;
            case "Part B Date":
                verifyPartBDateError(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }

    public void verifyCurrentlyEligibleError(String language) {
        basicActions.waitForElementToBePresent(currentlyEligibleError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(currentlyEligibleError.getText(), "Please select one of the options below");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(currentlyEligibleError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyPartAAmountError(String language) {
        basicActions.waitForElementToBePresent(InsuranceAmountError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(InsuranceAmountError.getText(), "Premium amount is required");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(InsuranceAmountError.getText(), "Por favor ingrese un monto");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyPartAError(String language) {
        basicActions.waitForElementToBePresent(partAInsuranceEndingError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(partAInsuranceEndingError.getText(), "Please select one of the options below");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(partAInsuranceEndingError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyPartADateError(String language) {
        basicActions.waitForElementToBePresent(partAInsuranceEndInputError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(partAInsuranceEndInputError.getText(), "Date is required");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(partAInsuranceEndInputError.getText(), "La fecha es obligatoria");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyPartBError(String language) {
        basicActions.waitForElementToBePresent(partBInsuranceEndingError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(partBInsuranceEndingError.getText(), "Please select one of the options below");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(partBInsuranceEndingError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyPartBDateError(String language) {
        basicActions.waitForElementToBePresent(partBInsuranceEndInputError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(partBInsuranceEndInputError.getText(), "Date is required");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(partBInsuranceEndInputError.getText(), "La fecha es obligatoria");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyNoErrorMessage(String errorType) {
        switch (errorType) {
            case "Currently Eligible":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(currentlyEligibleError, 10));
                softAssert.assertAll();
                break;
            case "Part A":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(InsuranceAmountError, 10));
                softAssert.assertTrue(basicActions.waitForElementToDisappear(partAInsuranceEndingError, 10));
                softAssert.assertAll();
                break;
            case "Part A Amount Required":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(InsuranceAmountError, 10));
                softAssert.assertAll();
                break;
            case "Part A Date":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(partAInsuranceEndInputError, 10));
                softAssert.assertAll();
                break;
            case "Part B":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(partBInsuranceEndingError, 10));
                softAssert.assertAll();
                break;
            case "Part B Date":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(partBInsuranceEndInputError, 10));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }





}
