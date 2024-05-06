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

public class OhiRetireeHealthPlanPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public OhiRetireeHealthPlanPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container .header-1")
    WebElement ohiHeader;

    @FindBy(css = ".container .header-2")
    WebElement ohiRetireeHeader;

    @FindBy(css = ".ohi-container > div > span")
    WebElement pleaseEnterTxt;

    @FindBy(css = "div > label")
    List<WebElement> retireeQuestionTxt;

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

    @FindBy(id = "Ohi-Endable-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(id = "Ohi-Endable-GoBack")
    WebElement goBackBtn;



    public void clickGoBack() {
        basicActions.click(goBackBtn);
    }

    public void clickSaveAndContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
        saveAndContinueBtn.click();
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

    public void enterEndDate(){
        basicActions.waitForElementToBePresent(inputEndDate, 60);
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        DateFormat endOfCurrentMonth = new SimpleDateFormat("MM-dd");

        inputEndDate.sendKeys(endOfCurrentMonth.format(lastDayOfMonth));
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
    public void verifyHeadersRetireeOhiPageEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Existing Health Insurance: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiRetireeHeader.getText(),"Retiree Health Plan");
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

    public void verifyRetireePageData(String dataToVerify, String language){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (language){
            case "English":
                verifyRetireePageDataEnglish(dataToVerify);
                break;
            case "Spanish":
                verifyRetireePageDataSpanish(dataToVerify);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyRetireePageDataEnglish(String dataToVerify){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (dataToVerify){
            case "First Section":
                verifyRetireePageFirstSectionDataEnglish();
                break;
            case "Second Section":
                verifyRetireePageFirstSectionDataEnglish();
                verifyRetireePageSecondSectionDataEnglish();
                break;
            case "Third Section":
                verifyRetireePageFirstSectionDataEnglish();
                verifyRetireePageSecondSectionDataEnglish();
                verifyRetireePageThirdSectionDataEnglish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackBtn.getText(),"  Go Back");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Save and Continue");
        softAssert.assertAll();
    }

    public void verifyRetireePageFirstSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Existing Health Insurance: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiRetireeHeader.getText(),"Retiree Health Plan");
        softAssert.assertEquals(pleaseEnterTxt.getText(), "Please enter the following information about your eligibility or current enrollment in a retiree health plan.");
        softAssert.assertEquals(retireeQuestionTxt.get(0).getText(),"Are you currently enrolled in a retiree health plan?");
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"Yes");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyRetireePageSecondSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(retireeQuestionTxt.get(1).getText(),"Will this health insurance end in the next 60 days?");
        softAssert.assertEquals(insuranceEndingYes.getText(),"Yes");
        softAssert.assertEquals(insuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyRetireePageThirdSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(retireeQuestionTxt.get(2).getText(),"What day will your coverage end?");
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(retireeQuestionTxt.get(3).getText(),"Are you voluntarily ending this health insurance?");
        softAssert.assertEquals(endVoluntaryYes.getText(),"Yes");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyRetireePageDataSpanish(String dataToVerify){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (dataToVerify){
            case "First Section":
                verifyRetireePageFirstSectionDataSpanish();
                break;
            case "Second Section":
                verifyRetireePageFirstSectionDataSpanish();
                verifyRetireePageSecondSectionDataSpanish();
                break;
            case "Third Section":
                verifyRetireePageFirstSectionDataSpanish();
                verifyRetireePageSecondSectionDataSpanish();
                verifyRetireePageThirdSectionDataSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackBtn.getText(),"  Volver");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyRetireePageFirstSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Existing Health Insurance: " + SharedData.getPrimaryMember().getFullName() + " (Spanish)"));
        softAssert.assertEquals(ohiRetireeHeader.getText(),"Retiree Health Plan (es)");
        softAssert.assertEquals(pleaseEnterTxt.getText(), "Please enter the following information about your eligibility or current enrollment in a retiree health plan. (es)");
        softAssert.assertEquals(retireeQuestionTxt.get(0).getText(),"Are you currently enrolled in a retiree health plan? (es)");
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"Si");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyRetireePageSecondSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(retireeQuestionTxt.get(1).getText(),"Will this health insurance end in the next 60 days? (es)");
        softAssert.assertEquals(insuranceEndingYes.getText(),"Si");
        softAssert.assertEquals(insuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyRetireePageThirdSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(retireeQuestionTxt.get(2).getText(),"What day will your coverage end? (es)");
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(retireeQuestionTxt.get(3).getText(),"Are you voluntarily ending this health insurance? (es)");
        softAssert.assertEquals(endVoluntaryYes.getText(),"Si");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
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
                softAssert.assertEquals(currentlyEnrolledError.getText(), "Seleccione una de las siguientes opciones");
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
                softAssert.assertEquals(insuranceEndingError.getText(), "Seleccione una de las siguientes opciones");
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
                softAssert.assertEquals(inputEndDateError.getText(), "La fecha es obligatoria");
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
                softAssert.assertEquals(endVoluntaryError.getText(), "Seleccione una de las siguientes opciones");
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
                basicActions.waitForElementToDisappear(currentlyEnrolledError, 10);
                softAssert.assertAll();
                break;
            case "Insurance Ending":
                basicActions.waitForElementToDisappear(insuranceEndingError, 10);
                softAssert.assertAll();
                break;
            case "Input Date":
                basicActions.waitForElementToDisappear(inputEndDateError, 10);
                softAssert.assertAll();
                break;
            case "Voluntary End":
                basicActions.waitForElementToDisappear(endVoluntaryError, 10);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }
    
    
    
}
