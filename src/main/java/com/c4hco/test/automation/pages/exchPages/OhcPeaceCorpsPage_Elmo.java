package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OhcPeaceCorpsPage_Elmo {
    BasicActions basicActions;
    Actions action;
    SoftAssert softAssert = new SoftAssert();
    Calendar calendar = Calendar.getInstance();
    Date today = new Date();
    public OhcPeaceCorpsPage_Elmo(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        action = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
        Assert.assertTrue(basicActions.waitForAngular(10), "page did not load in 10 seconds");
    }

    @FindBy(css = ".container .header-1")
    WebElement OhcHeader;

    @FindBy(css = ".container .header-2")
    WebElement OhcPeaceCorpsHeader;

    @FindBy(css = ".header-3 .clickable")
    WebElement helpMeLink;

    @FindBy(css = ".ohc-container > div > span")
    WebElement pleaseEnterTxt;

    @FindBy(css = "div > label")
    List<WebElement> PeaceCorpsQuestionTxt;

    @FindBy(css = "#Ohc-Endable-enrolled-container span.error-message")
    WebElement currentlyEnrolledError;

    @FindBy(id = "Ohc-Endable-enrolled-YesButton")
    WebElement currentlyEnrolledYes;

    @FindBy(id = "Ohc-Endable-enrolled-NoButton")
    WebElement currentlyEnrolledNo;

    @FindBy(css = "#Ohc-Endable-endsSoon-container span.error-message")
    WebElement insuranceEndingError;

    @FindBy(id = "Ohc-Endable-endsSoon-YesButton")
    WebElement insuranceEndingYes;

    @FindBy(id = "Ohc-Endable-endsSoon-NoButton")
    WebElement insuranceEndingNo;

    @FindBy(css = "#Ohc-Endable-endDate-container span.error-message")
    WebElement inputEndDateError;

    @FindBy(css = "#Ohc-Endable-endDate")
    WebElement inputEndDate;

    @FindBy(css = "#Ohc-Endable-endVoluntary-container span.error-message")
    WebElement endVoluntaryError;

    @FindBy(id = "Ohc-Endable-endVoluntary-YesButton")
    WebElement endVoluntaryYes;

    @FindBy(id = "Ohc-Endable-endVoluntary-NoButton")
    WebElement endVoluntaryNo;

    @FindBy(id = "Ohc-Endable-GoBack")
    WebElement goBackBtn;

    @FindBy(id = "Ohc-Endable-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(css = ".header-3.content-center > a")
    WebElement helpLnk;

    @FindBy(css = "lib-help-icon a")
    List<WebElement> helpIcons;

    @FindBy(css = ".drawer-heading .body-text-1")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = ".drawer-heading .drawer-title")
    WebElement helpDrawerHeaderPeaceCorps;

    @FindBy(css = "div > strong")
    List<WebElement> helpDrawerMainHeaders;

    @FindBy(css = ".drawer-text-content p")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = ".drawer-footer h3")
    WebElement helpDrawerFooter;

    @FindBy(css = ".drawer-footer h3 a")
    WebElement helpDrawerContactUsLink;



    public void clickSaveAndContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 50);
        saveAndContinueBtn.click();
    }

    public void clickGoBack(){
        basicActions.waitForElementToBeClickable(goBackBtn, 20);
        goBackBtn.click();
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
                calendar.add(Calendar.DATE, 60);
                Date futureDate = calendar.getTime();
                DateFormat futureDateFormat = new SimpleDateFormat("MM-dd");
                inputEndDate.sendKeys(futureDateFormat.format(futureDate));
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

    public void clickHelpIcon(String label) {
        basicActions.waitForElementListToBePresent(helpIcons, 10);
        switch(label){
            case "Help me understand":
                helpLnk.click();
                break;
            case "Please enter":
                helpIcons.get(0).click();
                break;
            case "currently enrolled":
                helpIcons.get(1).click();
                break;
            case "60 days":
                helpIcons.get(2).click();
                break;
            case "voluntarily ending":
                helpIcons.get(3).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + label);
        }
    }

    public void clickHelpContactUsNavigation() {
        basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
        helpDrawerContactUsLink.click();
    }



    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    public void verifyHeadersPeaceCorpsOhcPage(String language){
        switch (language){
            case "English":
                verifyHeadersPeaceCorpsOhcPageEnglish();
                break;
            case "Spanish":
                verifyHeadersPeaceCorpsOhcPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersPeaceCorpsOhcPageEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcPeaceCorpsHeader.getText(),"Peace Corps");
        softAssert.assertAll();
    }

    public void verifyHeadersPeaceCorpsOhcPageSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcPeaceCorpsHeader.getText(),"Cuerpos de paz (Peace Corps)");
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
            case "Not Selected":
                basicActions.waitForElementToBePresent(currentlyEnrolledYes,15);
                softAssert.assertTrue(currentlyEnrolledYes.getAttribute("class").equals("button option-button ng-star-inserted"));
                softAssert.assertTrue(currentlyEnrolledNo.getAttribute("class").equals("button option-button ng-star-inserted"));
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
        DateFormat endOfCurrentMonth = new SimpleDateFormat("YYYY-MM-dd");

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

    public void verifyPeaceCorpsPageData(String dataToVerify, String language){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        switch (language){
            case "English":
                verifyPeaceCorpsPageDataDataEnglish(dataToVerify);
                break;
            case "Spanish":
                verifyPeaceCorpsPageDataDataSpanish(dataToVerify);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyPeaceCorpsPageDataDataEnglish(String dataToVerify){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        switch (dataToVerify){
            case "First Section":
                verifyPeaceCorpsPageDataFirstSectionDataEnglish();
                break;
            case "Second Section":
                verifyPeaceCorpsPageDataFirstSectionDataEnglish();
                verifyPeaceCorpsPageDataSecondSectionDataEnglish();
                break;
            case "Third Section":
                verifyPeaceCorpsPageDataFirstSectionDataEnglish();
                verifyPeaceCorpsPageDataSecondSectionDataEnglish();
                verifyPeaceCorpsPageDataThirdSectionDataEnglish();
                break;
            case "First Section Secondary":
                verifyPeaceCorpsPageFirstSectionSecondaryDataEnglish();
                break;
            case "Second Section Secondary":
                verifyPeaceCorpsPageFirstSectionSecondaryDataEnglish();
                verifyPeaceCorpsPageDataSecondSectionDataEnglish();
                break;
            case "Third Section Secondary":
                verifyPeaceCorpsPageFirstSectionSecondaryDataEnglish();
                verifyPeaceCorpsPageDataSecondSectionDataEnglish();
                verifyPeaceCorpsPageThirdSectionSecondaryDataEnglish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackBtn.getText(),"  Go Back");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Save and Continue");
        softAssert.assertAll();
    }

    public void verifyPeaceCorpsPageDataFirstSectionDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcPeaceCorpsHeader.getText(),"Peace Corps");
        softAssert.assertEquals(helpMeLink.getText(),"Help me understand this page");
        softAssert.assertEquals(pleaseEnterTxt.getText(), "Please enter the following information about your eligibility or current enrollment in Peace Corps coverage");
        softAssert.assertEquals(PeaceCorpsQuestionTxt.get(0).getText(),"Are you currently enrolled in Peace Corps coverage?");
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"Yes");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyPeaceCorpsPageFirstSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(OhcPeaceCorpsHeader.getText(),"Peace Corps");
        softAssert.assertEquals(helpMeLink.getText(),"Help me understand this page");
        softAssert.assertTrue(pleaseEnterTxt.getText().equalsIgnoreCase( "Please enter the following information about " + SharedData.getMembers().get(0).getFullName() + "'s eligibility or current enrollment in Peace Corps coverage"));
        softAssert.assertTrue(PeaceCorpsQuestionTxt.get(0).getText().equalsIgnoreCase("Is " + SharedData.getMembers().get(0).getFullName() + " currently enrolled in Peace Corps coverage?"));
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"Yes");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyPeaceCorpsPageDataSecondSectionDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertEquals(PeaceCorpsQuestionTxt.get(1).getText(),"Will this health insurance end in the next 60 days?");
        softAssert.assertEquals(insuranceEndingYes.getText(),"Yes");
        softAssert.assertEquals(insuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyPeaceCorpsPageDataThirdSectionDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertEquals(PeaceCorpsQuestionTxt.get(2).getText(),"What day will your coverage end?");
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(PeaceCorpsQuestionTxt.get(3).getText(),"Are you voluntarily ending this health insurance?");
        softAssert.assertEquals(endVoluntaryYes.getText(),"Yes");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyPeaceCorpsPageThirdSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(PeaceCorpsQuestionTxt.get(2).getText().equalsIgnoreCase("What day will " + SharedData.getMembers().get(0).getFullName() + "\u0027s coverage end?"));
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertTrue(PeaceCorpsQuestionTxt.get(3).getText().equalsIgnoreCase("Is " + SharedData.getMembers().get(0).getFullName() + " voluntarily ending this health insurance?"));
        softAssert.assertEquals(endVoluntaryYes.getText(),"Yes");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyPeaceCorpsPageDataDataSpanish(String dataToVerify){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        switch (dataToVerify){
            case "First Section":
                verifyPeaceCorpsPageDataFirstSectionDataSpanish();
                break;
            case "Second Section":
                verifyPeaceCorpsPageDataFirstSectionDataSpanish();
                verifyPeaceCorpsPageDataSecondSectionDataSpanish();
                break;
            case "Third Section":
                verifyPeaceCorpsPageDataFirstSectionDataSpanish();
                verifyPeaceCorpsPageDataSecondSectionDataSpanish();
                verifyPeaceCorpsPageDataThirdSectionDataSpanish();
                break;
            case "First Section Secondary":
                verifyPeaceCorpsPageDataFirstSectionSecondaryDataSpanish();
                break;
            case "Second Section Secondary":
                verifyPeaceCorpsPageDataFirstSectionSecondaryDataSpanish();
                verifyPeaceCorpsPageDataSecondSectionDataSpanish();
                break;
            case "Third Section Secondary":
                verifyPeaceCorpsPageDataFirstSectionSecondaryDataSpanish();
                verifyPeaceCorpsPageDataSecondSectionDataSpanish();
                verifyPeaceCorpsPageDataThirdSectionSecondaryDataSpanish();
                break;
                default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackBtn.getText(),"  Volver");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyPeaceCorpsPageDataFirstSectionDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcPeaceCorpsHeader.getText(),"Cuerpos de paz (Peace Corps)");
        softAssert.assertEquals(helpMeLink.getText(),"Ayuda para entender esta p\u00E1gina");
        softAssert.assertEquals(pleaseEnterTxt.getText(), "Ingrese la siguiente informaci\u00F3n acerca de su elegibilidad o inscripci\u00F3n actual en la cobertura del Cuerpo de Paz.");
        softAssert.assertEquals(PeaceCorpsQuestionTxt.get(0).getText(),"\u00BFActualmente est\u00E1 inscrito en la cobertura del Cuerpo de Paz?");
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"S\u00ED");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyPeaceCorpsPageDataFirstSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(OhcPeaceCorpsHeader.getText(),"Cuerpos de paz (Peace Corps)");
        softAssert.assertEquals(helpMeLink.getText(),"Ayuda para entender esta p\u00E1gina");
        softAssert.assertTrue(pleaseEnterTxt.getText().equalsIgnoreCase( "Ingrese la siguiente informaci\u00F3n acerca de la elegibilidad o inscripci\u00F3n actual de " + SharedData.getMembers().get(0).getFullName() + " en la cobertura del Cuerpo de Paz."));
        softAssert.assertTrue(PeaceCorpsQuestionTxt.get(0).getText().equalsIgnoreCase("\u00BFActualmente " + SharedData.getMembers().get(0).getFullName() + " est\u00E1 inscrito en la cobertura del Cuerpo de Paz?"));
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"S\u00ED");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyPeaceCorpsPageDataSecondSectionDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertEquals(PeaceCorpsQuestionTxt.get(1).getText(),"\u00BFEste seguro de salud terminar\u00E1 en los siguientes 60 d\u00EDas?");
        softAssert.assertEquals(insuranceEndingYes.getText(),"S\u00ED");
        softAssert.assertEquals(insuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyPeaceCorpsPageDataThirdSectionDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertEquals(PeaceCorpsQuestionTxt.get(2).getText(),"\u00BFQu\u00E9 d\u00EDa termina su cobertura?");
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(PeaceCorpsQuestionTxt.get(3).getText(),"\u00BFEst\u00E1 cancelando voluntariamente este seguro de salud?");
        softAssert.assertEquals(endVoluntaryYes.getText(),"S\u00ED");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyPeaceCorpsPageDataThirdSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(PeaceCorpsQuestionTxt.get(2).getText().equalsIgnoreCase("\u00BFQu\u00E9 d\u00EDa termina la cobertura de " + SharedData.getMembers().get(0).getFullName() + "?"));
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertTrue(PeaceCorpsQuestionTxt.get(3).getText().equalsIgnoreCase("\u00BF" + SharedData.getMembers().get(0).getFullName() + " est\u00E1 cancelando voluntariamente este seguro de salud?"));
        softAssert.assertEquals(endVoluntaryYes.getText(),"S\u00ED");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyErrorMessage(String errorType, String language) {
        switch (errorType) {
            case "Currently Enrolled":
                verifyCurrentlyEnrolledError(language);
                break;
            case "Insurance Ending":
                verifyInsuranceEndingError(language);
                break;
            case "Input Date":
                verifyInputEndDateError(language);
                break;
            case "Voluntary End":
                verifyEndVoluntaryError(language);
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

    public void verifyInsuranceEndingError(String language) {
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

    public void verifyInputEndDateError(String language) {
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
                softAssert.assertEquals(inputEndDateError.getText(), "Por favor ingrese un valor mayor que o igual a "+formattedDate);
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

    public void verifyEndVoluntaryError(String language) {
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

    public void validateHelpVerbiage(String helpData,String language) {
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 30);
        basicActions.waitForElementToBePresent(helpDrawerHeaderPeaceCorps, 30);
        switch (language) {
            case "English":
                switch (helpData){
                    case "full":
                        validateGeneralHelpBodyVerbiageEng();
                        break;
                    case "currently enrolled":
                        validateCurrentlyEnrolledHelpBodyVerbiageEng();
                        break;
                    case "60 days":
                        validate60DaysHelpBodyVerbiageEng();
                        break;
                    case "voluntarily ending":
                        validateVoluntaryEndingHelpBodyVerbiageEng();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + helpData);
                }
                break;
            case "Spanish":
                switch (helpData){
                    case "full":
                        validateGeneralHelpBodyVerbiageSp();
                        break;
                    case "currently enrolled":
                        validateCurrentlyEnrolledHelpBodyVerbiageSp();
                        break;
                    case "60 days":
                        validate60DaysHelpBodyVerbiageSp();
                        break;
                    case "voluntarily ending":
                        validateVoluntaryEndingHelpBodyVerbiageSp();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + helpData);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateGeneralHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderPeaceCorps.getText(), "Peace Corps");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Overview");
        softAssert.assertEquals(helpDrawerMainHeaders.get(1).getText(), "Enrollment");
        softAssert.assertEquals(helpDrawerMainHeaders.get(2).getText(), "End in the next 60 days");
        softAssert.assertEquals(helpDrawerMainHeaders.get(3).getText(), "Voluntarily Ending");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "This page helps us find out if this person is enrolled in or eligible for other health insurance. By eligible, we mean that they have the option to enroll, even if they aren't currently enrolled.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "If this person currently has this health insurance, select \"Yes\". If they are able to get this health insurance, but have chosen not to, select \"No\".");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "If this insurance is ending in the next 60 days, this person is eligible for a Special Enrollment Period which allows you and your family to shop for health insurance outside of the Open Enrollment Period.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "If this person chooses to end this health insurance, they will not be eligible for a Special Enrollment Period to shop for other health insurance. They must wait until the next Open Enrollment Period to shop unless they have another qualifying life change event.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderPeaceCorps.getText(), "Cuerpos de paz (Peace Corps)");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerMainHeaders.get(1).getText(), "Inscripci\u00F3n");
        softAssert.assertEquals(helpDrawerMainHeaders.get(2).getText(), "Finalizaci\u00F3n en los pr\u00F3ximos 60 d\u00EDas");
        softAssert.assertEquals(helpDrawerMainHeaders.get(3).getText(), "Cancelaci\u00F3n voluntaria");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Esta p\u00E1gina nos ayuda a saber si esta persona est\u00E1 inscrita o es elegible para otro seguro de salud. Al decir elegible, nos referimos a que tiene la opci\u00F3n de inscribirse, aun si la persona no est\u00E1 actualmente inscrita.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Si actualmente esta persona tiene este seguro de salud, seleccione \"S\u00ED\". Si esta persona puede obtener este seguro de salud, pero ha decidido no tenerlo, seleccione \"No\".");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Si este seguro va a terminar en los pr\u00F3ximos 60 d\u00EDas, esta persona es elegible para un Per\u00EDodo de inscripci\u00F3n especial que le permite tanto a usted como a su familia adquirir un seguro de salud fuera del Per\u00EDodo de inscripci\u00F3n abierta.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "Si esta persona decide cancelar este seguro de salud, no podr\u00E1 ser elegible para un Per\u00EDodo de inscripci\u00F3n especial para adquirir otro seguro de salud. Deber\u00E1 esperar hasta el siguiente Per\u00EDodo de inscripci\u00F3n abierta para adquirirlo a menos que tenga otro evento de vida calificado.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateCurrentlyEnrolledHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderPeaceCorps.getText(), "Peace Corps");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Enrollment");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "If this person currently has this health insurance, select \"Yes\". If they are able to get this health insurance, but have chosen not to, select \"No\".");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateCurrentlyEnrolledHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderPeaceCorps.getText(), "Cuerpos de paz (Peace Corps)");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Inscripci\u00F3n");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Si actualmente esta persona tiene este seguro de salud, seleccione \"S\u00ED\". Si esta persona puede obtener este seguro de salud, pero ha decidido no tenerlo, seleccione \"No\".");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validate60DaysHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderPeaceCorps.getText(), "Peace Corps");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "End in the next 60 days");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "If this insurance is ending in the next 60 days, this person is eligible for a Special Enrollment Period which allows you and your family to shop for health insurance outside of the Open Enrollment Period.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validate60DaysHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderPeaceCorps.getText(), "Cuerpos de paz (Peace Corps)");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Finalizaci\u00F3n en los pr\u00F3ximos 60 d\u00EDas");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Si este seguro va a terminar en los pr\u00F3ximos 60 d\u00EDas, esta persona es elegible para un Per\u00EDodo de inscripci\u00F3n especial que le permite tanto a usted como a su familia adquirir un seguro de salud fuera del Per\u00EDodo de inscripci\u00F3n abierta.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateVoluntaryEndingHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderPeaceCorps.getText(), "Peace Corps");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Voluntarily Ending");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "If this person chooses to end this health insurance, they will not be eligible for a Special Enrollment Period to shop for other health insurance. They must wait until the next Open Enrollment Period to shop unless they have another qualifying life change event.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateVoluntaryEndingHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderPeaceCorps.getText(), "Cuerpos de paz (Peace Corps)");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Cancelaci\u00F3n voluntaria");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Si esta persona decide cancelar este seguro de salud, no podr\u00E1 ser elegible para un Per\u00EDodo de inscripci\u00F3n especial para adquirir otro seguro de salud. Deber\u00E1 esperar hasta el siguiente Per\u00EDodo de inscripci\u00F3n abierta para adquirirlo a menos que tenga otro evento de vida calificado.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    
}
