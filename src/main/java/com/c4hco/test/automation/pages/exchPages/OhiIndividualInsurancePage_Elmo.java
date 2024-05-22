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

public class OhiIndividualInsurancePage_Elmo {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    Calendar calendar = Calendar.getInstance();
    Date today = new Date();
    public OhiIndividualInsurancePage_Elmo(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container .header-1")
    WebElement ohiHeader;

    @FindBy(css = ".container .header-2")
    WebElement ohiIndividualInsuranceHeader;

    @FindBy(css = ".header-3 .clickable")
    WebElement helpMeLink;

    @FindBy(css = ".ohi-container > div > span")
    WebElement pleaseEnterTxt;

    @FindBy(css = "div > label")
    List<WebElement> IndividualInsuranceQuestionTxt;

    @FindBy(css = "#Ohi-Endable-enrolled-container span.error-message")
    WebElement currentlyEnrolledError;

    @FindBy(id = "Ohi-Endable-enrolled-YesButton")
    WebElement currentlyEnrolledYes;

    @FindBy(id = "Ohi-Endable-enrolled-NoButton")
    WebElement currentlyEnrolledNo;

    @FindBy(css = "#Ohi-Endable-endsSoon-container span.error-message")
    WebElement insuranceEndingError;

    @FindBy(id = "Ohi-Endable-endsSoon-YesButton")
    WebElement insuranceEndingYes;

    @FindBy(id = "Ohi-Endable-endsSoon-NoButton")
    WebElement insuranceEndingNo;

    @FindBy(css = "#Ohi-Endable-endDate-container span.error-message")
    WebElement inputEndDateError;

    @FindBy(css = "#Ohi-Endable-endDate")
    WebElement inputEndDate;

    @FindBy(css = "#Ohi-Endable-endVoluntary-container span.error-message")
    WebElement endVoluntaryError;

    @FindBy(id = "Ohi-Endable-endVoluntary-YesButton")
    WebElement endVoluntaryYes;

    @FindBy(id = "Ohi-Endable-endVoluntary-NoButton")
    WebElement endVoluntaryNo;

    @FindBy(id = "Ohi-Endable-GoBack")
    WebElement goBackButton;

    @FindBy(id = "Ohi-Endable-SaveAndContinue")
    WebElement saveAndContinueBtn;



    public void clickSaveAndContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
        saveAndContinueBtn.click();
    }

    public void clickGoBack(){
        basicActions.waitForElementToBeClickable(goBackButton, 20);
        goBackButton.click();
    }

    public void clickCurrentlyEnrolledOption(String currentlyEnrolled) {
        switch (currentlyEnrolled) {
            case "Yes":
                basicActions.waitForElementToBeClickable(currentlyEnrolledYes, 20);
                basicActions.click(currentlyEnrolledYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(currentlyEnrolledNo, 20);
                basicActions.click(currentlyEnrolledNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + currentlyEnrolled);
        }
    }

    public void clickInsuranceEndingOption(String insuranceEnding) {
        switch (insuranceEnding) {
            case "Yes":
                basicActions.waitForElementToBeClickable(insuranceEndingYes, 20);
                basicActions.click(insuranceEndingYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(insuranceEndingNo, 20);
                basicActions.click(insuranceEndingNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceEnding);
        }
    }

    public void enterEndDate(String endDate){
        basicActions.waitForElementToBePresent(inputEndDate, 60);
        calendar.setTime(today);

        switch (endDate){
            case "Current Month":
                calendar.add(Calendar.MONTH, 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.add(Calendar.DATE, -1);
                Date lastDayOfMonth = calendar.getTime();
                DateFormat endOfCurrentMonth = new SimpleDateFormat("MM-dd");
                inputEndDate.sendKeys(endOfCurrentMonth.format(lastDayOfMonth));
                break;
            case "Prior Month":
                calendar.add(Calendar.MONTH, 0);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.add(Calendar.DATE, -1);
                Date lastDayOfPriorMonth = calendar.getTime();
                DateFormat endOfPriorMonth = new SimpleDateFormat("MM-dd");
                inputEndDate.sendKeys(endOfPriorMonth.format(lastDayOfPriorMonth));
                break;
            case "Future Month":
                calendar.add(Calendar.MONTH, 3);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.add(Calendar.DATE, -1);
                Date lastDayOfFutureMonth = calendar.getTime();
                DateFormat endOfFutureMonth = new SimpleDateFormat("MM-dd");
                inputEndDate.sendKeys(endOfFutureMonth.format(lastDayOfFutureMonth));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + endDate);
        }
    }

    public void clickEndVoluntaryOption(String voluntaryEnding) {
        switch (voluntaryEnding) {
            case "Yes":
                basicActions.waitForElementToBeClickable(endVoluntaryYes, 20);
                basicActions.click(endVoluntaryYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(endVoluntaryNo, 20);
                basicActions.click(endVoluntaryNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + voluntaryEnding);
        }
    }





    // ############################## VALIDATION STEPS #########################
// Add only validation methods below this line
    public void verifyHeadersIndividualInsuranceOhiPageEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiIndividualInsuranceHeader.getText(),"Individual Insurance");
        softAssert.assertAll();
    }

    public void verifyCurrentlyEnrolledOption(String currentlyEnrolled){
        switch (currentlyEnrolled){
            case "Yes":
                basicActions.waitForElementToBePresent(currentlyEnrolledYes,15);
                softAssert.assertTrue(currentlyEnrolledYes.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(currentlyEnrolledNo,15);
                softAssert.assertTrue(currentlyEnrolledNo.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + currentlyEnrolled);
        }
    }

    public void verifyInsuranceEndingOption(String insuranceEnding){
        switch (insuranceEnding){
            case "Yes":
                basicActions.waitForElementToBePresent(insuranceEndingYes,15);
                softAssert.assertTrue(insuranceEndingYes.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(insuranceEndingNo,15);
                softAssert.assertTrue(insuranceEndingNo.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceEnding);
        }
    }

    public void verifyEndDate(){
        basicActions.waitForElementToBePresent(inputEndDate, 60);
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        DateFormat endOfCurrentMonth = new SimpleDateFormat("YYY-MM-dd");

        softAssert.assertTrue(inputEndDate.getAttribute("value").contains(endOfCurrentMonth.format(lastDayOfMonth)));
        softAssert.assertAll();
    }

    public void verifyVoluntaryEndingOption(String voluntaryEnding){
        switch (voluntaryEnding){
            case "Yes":
                basicActions.waitForElementToBePresent(endVoluntaryYes,15);
                softAssert.assertTrue(endVoluntaryYes.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(endVoluntaryNo,15);
                softAssert.assertTrue(endVoluntaryNo.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + voluntaryEnding);
        }
    }

    public void verifyErrorMessage(String errorType, String language) {
        switch (errorType) {
            case "Currently Enrolled":
                verifyCurrentlyEnrolledError(language);
                break;
            case "Insurance Ending":
                verifyinsuranceEndingError(language);
                break;
            case "Input Date":
                verifyinputEndDateError(language);
                break;
            case "Voluntary End":
                verifyendVoluntaryError(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }

    public void verifyCurrentlyEnrolledError(String language) {
        basicActions.waitForElementToBePresent(currentlyEnrolledError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(currentlyEnrolledError.getText(), "Please select one of the options below");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(currentlyEnrolledError.getText(), "Por favor seleccione una opci\u00F3n");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyinsuranceEndingError(String language) {
        basicActions.waitForElementToBePresent(insuranceEndingError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(insuranceEndingError.getText(), "Please select one of the options below");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(insuranceEndingError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(insuranceEndingError.getText(), "Por favor seleccione una opci\u00F3n");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(insuranceEndingError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyinputEndDateError(String language) {
        basicActions.waitForElementToBePresent(inputEndDateError, 20);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        calendar.setTime(today);
        String formattedDate = dateFormat.format(today);
        switch (language) {
            case "English":
                softAssert.assertEquals(inputEndDateError.getText(), "Date is required");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(inputEndDateError.getText(), "Por favor ingrese una fecha");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "English Prior":
                softAssert.assertEquals(inputEndDateError.getText(), "Please enter a value greater than or equal to "+formattedDate);
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish Prior":
                softAssert.assertEquals(inputEndDateError.getText(), "Por favor ingrese una valor mayor que o igual "+formattedDate);
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "English Future":
                softAssert.assertEquals(inputEndDateError.getText(), "Date cannot exceed 60 days in the future");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish Future":
                softAssert.assertEquals(inputEndDateError.getText(), "La fecha a seleccionar no puede exceder los 60 d\u00EDas");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyendVoluntaryError(String language) {
        basicActions.waitForElementToBePresent(endVoluntaryError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(endVoluntaryError.getText(), "Please select one of the options below");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(endVoluntaryError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(endVoluntaryError.getText(), "Por favor seleccione una opci\u00F3n");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(endVoluntaryError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyNoErrorMessage(String errorType) {
        switch (errorType) {
            case "Currently Enrolled":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(currentlyEnrolledError, 10));
                softAssert.assertAll();
                break;
            case "Insurance Ending":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(insuranceEndingError, 10));
                softAssert.assertAll();
                break;
            case "Input Date":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(inputEndDateError, 10));
                softAssert.assertAll();
                break;
            case "Voluntary End":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(endVoluntaryError, 10));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }

    public void verifyIndividualInsurancePageData(String dataToVerify, String language){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (language){
            case "English":
                verifyIndividualInsurancePageDataEnglish(dataToVerify);
                break;
            case "Spanish":
                verifyIndividualInsurancePageDataSpanish(dataToVerify);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyIndividualInsurancePageDataEnglish(String dataToVerify){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (dataToVerify){
            case "First Section":
                verifyIndividualInsurancePageFirstSectionDataEnglish();
                break;
            case "Second Section":
                verifyIndividualInsurancePageFirstSectionDataEnglish();
                verifyIndividualInsurancePageSecondSectionDataEnglish();
                break;
            case "Third Section":
                verifyIndividualInsurancePageFirstSectionDataEnglish();
                verifyIndividualInsurancePageSecondSectionDataEnglish();
                verifyIndividualInsurancePageThirdSectionDataEnglish();
                break;
            case "First Section Secondary":
                verifyIndividualInsurancePageFirstSectionSecondaryDataEnglish();
                break;
            case "Second Section Secondary":
                verifyIndividualInsurancePageFirstSectionSecondaryDataEnglish();
                verifyIndividualInsurancePageSecondSectionDataEnglish();
                break;
            case "Third Section Secondary":
                verifyIndividualInsurancePageFirstSectionSecondaryDataEnglish();
                verifyIndividualInsurancePageSecondSectionDataEnglish();
                verifyIndividualInsurancePageThirdSectionSecondaryDataEnglish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackButton.getText(),"  Go Back");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Save and Continue");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageFirstSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiIndividualInsuranceHeader.getText(),"Individual Insurance");
        softAssert.assertEquals(helpMeLink.getText(),"Help me understand this page");
        softAssert.assertEquals(pleaseEnterTxt.getText(), "Please enter the following information about your eligibility or current enrollment in health insurance purchased directly through an insurance company, through HealthCare.gov, or another state\u2019s Marketplace.");
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(0).getText(),"Are you currently enrolled in individual insurance?");
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"Yes");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageSecondSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(1).getText(),"Will this health insurance end in the next 60 days?");
        softAssert.assertEquals(insuranceEndingYes.getText(),"Yes");
        softAssert.assertEquals(insuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageThirdSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(2).getText(),"What day will your coverage end?");
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(3).getText(),"Are you voluntarily ending this health insurance?");
        softAssert.assertEquals(endVoluntaryYes.getText(),"Yes");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageFirstSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(ohiIndividualInsuranceHeader.getText(),"Individual Insurance");
        softAssert.assertEquals(helpMeLink.getText(),"Help me understand this page");
        softAssert.assertTrue(pleaseEnterTxt.getText().equalsIgnoreCase( "Please enter the following information about " + SharedData.getMembers().get(0).getFullName() + "'s eligibility or current enrollment in health insurance purchased directly through an insurance company, through HealthCare.gov, or another state\u2019s Marketplace."));
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(0).getText().equalsIgnoreCase("Is " + SharedData.getMembers().get(0).getFullName() + " currently enrolled in individual insurance?"));
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"Yes");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageThirdSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(2).getText().equalsIgnoreCase("What day will " + SharedData.getMembers().get(0).getFullName() + "\u0027s coverage end?"));
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(3).getText().equalsIgnoreCase("Is " + SharedData.getMembers().get(0).getFullName() + " voluntarily ending this health insurance?"));
        softAssert.assertEquals(endVoluntaryYes.getText(),"Yes");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageDataSpanish(String dataToVerify){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (dataToVerify){
            case "First Section":
                verifyIndividualInsurancePageFirstSectionDataSpanish();
                break;
            case "Second Section":
                verifyIndividualInsurancePageFirstSectionDataSpanish();
                verifyIndividualInsurancePageSecondSectionDataSpanish();
                break;
            case "Third Section":
                verifyIndividualInsurancePageFirstSectionDataSpanish();
                verifyIndividualInsurancePageSecondSectionDataSpanish();
                verifyIndividualInsurancePageThirdSectionDataSpanish();
                break;
            case "First Section Secondary":
                verifyIndividualInsurancePageFirstSectionSecondaryDataSpanish();
                break;
            case "Second Section Secondary":
                verifyIndividualInsurancePageFirstSectionSecondaryDataSpanish();
                verifyIndividualInsurancePageSecondSectionDataSpanish();
                break;
            case "Third Section Secondary":
                verifyIndividualInsurancePageFirstSectionSecondaryDataSpanish();
                verifyIndividualInsurancePageSecondSectionDataSpanish();
                verifyIndividualInsurancePageThirdSectionSecondaryDataSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackButton.getText(),"  Volver");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageFirstSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiIndividualInsuranceHeader.getText(),"Seguro individual");
        softAssert.assertEquals(helpMeLink.getText(),"Ayuda para entender esta p\u00E1gina");
        softAssert.assertEquals(pleaseEnterTxt.getText(), "Ingrese la siguiente informaci\u00F3n acerca de su elegibilidad o inscripci\u00F3n actual en el seguro de salud adquirido directamente a trav\u00E9s de una compa\u00F1\u00Eda de seguros, por medio de HealthCare.gov o a trav\u00E9s de otro Mercado del estado.");
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(0).getText(),"\u00BFActualmente est\u00E1 inscrito en un seguro individual?");
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"Si");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageSecondSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(1).getText(),"\u00BFEste seguro de salud terminar\u00E1 en los siguientes 60 d\u00EDas?");
        softAssert.assertEquals(insuranceEndingYes.getText(),"Si");
        softAssert.assertEquals(insuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageThirdSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(2).getText(),"\u00BFQu\u00E9 d\u00EDa termina su cobertura?");
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(3).getText(),"\u00BFEst\u00E1 cancelando voluntariamente este seguro de salud?");
        softAssert.assertEquals(endVoluntaryYes.getText(),"Si");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageFirstSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(ohiIndividualInsuranceHeader.getText(),"Seguro individual");
        softAssert.assertEquals(helpMeLink.getText(),"Ayuda para entender esta p\u00E1gina");
        softAssert.assertTrue(pleaseEnterTxt.getText().equalsIgnoreCase( "Ingrese la siguiente informaci\u00F3n acerca de la elegibilidad o inscripci\u00F3n actual de " + SharedData.getMembers().get(0).getFullName() + " en el seguro de salud adquirido directamente a trav\u00E9s de una compa\u00F1\u00Eda de seguros, por medio de HealthCare.gov o a trav\u00E9s de otro Mercado del estado."));
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(0).getText().equalsIgnoreCase("\u00BFActualmente " + SharedData.getMembers().get(0).getFullName() + " est\u00E1 inscrito en un seguro individual?"));
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"Si");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageThirdSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(2).getText().equalsIgnoreCase("\u00BFQu\u00E9 d\u00EDa termina la cobertura de " + SharedData.getMembers().get(0).getFullName() + "?"));
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(3).getText().equalsIgnoreCase("\u00BF" + SharedData.getMembers().get(0).getFullName() + " est\u00E1 cancelando voluntariamente este seguro de salud?"));
        softAssert.assertEquals(endVoluntaryYes.getText(),"Si");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }













}
