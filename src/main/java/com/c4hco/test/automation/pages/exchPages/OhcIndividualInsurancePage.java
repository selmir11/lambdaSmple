package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class OhcIndividualInsurancePage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public OhcIndividualInsurancePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container .header-1")
    WebElement OhcHeader;

    @FindBy(css = ".container .header-2")
    WebElement OhcIndividualInsuranceHeader;

    @FindBy(css = ".header-3 .clickable")
    WebElement helpMeLink;

    @FindBy(css = ".ohc-container > div > span")
    WebElement pleaseEnterTxt;

    @FindBy(css = "div > label")
    List<WebElement> IndividualInsuranceQuestionTxt;

    @FindBy(css = "lib-error-msg > div")
    List<WebElement> hdrError;

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
    WebElement goBackButton;

    @FindBy(id = "Ohc-Endable-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(css = ".header-3.content-center > a")
    WebElement helpLnk;

    @FindBy(css = "lib-help-icon a")
    List<WebElement> helpIcons;

    @FindBy(css = "div.desktop-help > div > span.c4-text-body-200")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = "div.desktop-help > div > span.title.c4-type-header-sm")
    WebElement helpDrawerHeaderIndividualInsurance;

    @FindBy(css = "div.desktop-help > mat-dialog-content > div > div > div.help-main-content.ng-star-inserted > strong")
    WebElement helpDrawerMainHeaders;

    @FindBy(css = "div.desktop-help > mat-dialog-content > div > div > div.help-main-content.ng-star-inserted > strong:nth-child(1)")
    WebElement helpDrawerHeaderOne;

    @FindBy(css = "div.desktop-help > mat-dialog-content > div > div > div.help-main-content.ng-star-inserted > strong:nth-child(4)")
    WebElement helpDrawerHeaderTwo;

    @FindBy(css = "div.desktop-help > mat-dialog-content > div > div > div.help-main-content.ng-star-inserted > strong:nth-child(7)")
    WebElement helpDrawerHeaderThree;

    @FindBy(css = "div.desktop-help > mat-dialog-content > div > div > div.help-main-content.ng-star-inserted > strong:nth-child(10)")
    WebElement helpDrawerHeaderFour;

    @FindBy(css = ".drawer-text-content p")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = "div.desktop-help > mat-dialog-content > div > div > div.help-main-content.ng-star-inserted > p:nth-child(3)")
    WebElement helpDrawerBodyParagraphOne;

    @FindBy(css = "div.desktop-help > mat-dialog-content > div > div > div.help-main-content.ng-star-inserted > p:nth-child(6)")
    WebElement helpDrawerBodyParagraphTwo;

    @FindBy(css = "div.desktop-help > mat-dialog-content > div > div > div.help-main-content.ng-star-inserted > p:nth-child(9)")
    WebElement helpDrawerBodyParagraphThree;

    @FindBy(css = "div.desktop-help > mat-dialog-content > div > div > div.help-main-content.ng-star-inserted > p:nth-child(12)")
    WebElement helpDrawerBodyParagraphFour;

    @FindBy(css = "div.help-footer.ng-star-inserted")
    WebElement helpDrawerFooter;

    @FindBy(css = "div.help-footer.ng-star-inserted > a")
    WebElement helpDrawerContactUsLink;



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

    public void enterEndDate(String endDateData){
        basicActions.waitForElementToBePresent(inputEndDate, 60);
        String endDate = endDateData;
        int daysInFuture = 0;
        if (endDateData.startsWith("Future Day:")) {
            String[] parts = endDateData.split(":");
            endDate = parts[0];
            daysInFuture = Integer.parseInt(parts[1]);
        }

        switch (endDate){
            case "Current Month":
                inputEndDate.sendKeys(basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MMdd"));
                break;
            case "Prior Month":
                inputEndDate.sendKeys(basicActions.changeDateFormat(basicActions.getPastDate(1), "MM/dd/yyyy", "MMdd"));
                break;
            case "Future Month":
                inputEndDate.sendKeys(basicActions.changeDateFormat(basicActions.getFutureDate(61), "MM/dd/yyyy", "MMdd"));
                break;
            case "Future Day":
                inputEndDate.sendKeys(basicActions.changeDateFormat(basicActions.getFutureDate(daysInFuture), "MM/dd/yyyy", "MMdd"));
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
    public void verifyHeadersIndividualInsuranceOhcPage(String language){
        switch (language){
            case "English":
                verifyHeadersIndividualInsuranceOhcPageEnglish();
                break;
            case "Spanish":
                verifyHeadersIndividualInsuranceOhcPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersIndividualInsuranceOhcPageEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        basicActions.waitForElementToBePresent(OhcIndividualInsuranceHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcIndividualInsuranceHeader.getText(),"Individual Insurance");
        softAssert.assertAll();
    }

    public void verifyHeadersIndividualInsuranceOhcPageSpanish(){
        basicActions.waitForElementToBePresentWithRetries(OhcHeader,60);
        basicActions.waitForElementToBePresentWithRetries(OhcIndividualInsuranceHeader,60);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcIndividualInsuranceHeader.getText(),"Seguro individual");
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
        softAssert.assertTrue(inputEndDate.getAttribute("value").contains(basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "yyyy-MM-dd")));
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
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(currentlyEnrolledError.getText(), "Por favor seleccione una opci\u00F3n");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
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
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(insuranceEndingError.getText(), "Por favor seleccione una opci\u00F3n");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(insuranceEndingError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyinputEndDateError(String language) {
        basicActions.waitForElementToBePresent(inputEndDateError, 20);
        String todayDate = basicActions.getTodayDate();
        switch (language) {
            case "English":
                softAssert.assertEquals(inputEndDateError.getText(), "Date is required");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(inputEndDateError.getText(), "Por favor ingrese una fecha");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "English Prior":
                softAssert.assertEquals(inputEndDateError.getText(), "Please enter a value greater than or equal to "+todayDate);
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish Prior":
                softAssert.assertEquals(inputEndDateError.getText(), "Por favor ingrese un valor mayor que o igual a "+todayDate);
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "English Future":
                softAssert.assertEquals(inputEndDateError.getText(), "Date cannot exceed 60 days in the future");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish Future":
                softAssert.assertEquals(inputEndDateError.getText(), "La fecha a seleccionar no puede exceder los 60 d\u00EDas");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
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
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(endVoluntaryError.getText(), "Por favor seleccione una opci\u00F3n");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(endVoluntaryError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
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
        basicActions.waitForElementToBePresent(OhcHeader,15);
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
        basicActions.waitForElementToBePresent(OhcHeader,15);
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
        softAssert.assertEquals(goBackButton.getText(),"Go back");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Save and continue");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageFirstSectionDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        basicActions.waitForElementToBePresent(OhcIndividualInsuranceHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcIndividualInsuranceHeader.getText(),"Individual Insurance");
        softAssert.assertEquals(helpMeLink.getText(),"Help me understand this page");
        softAssert.assertEquals(pleaseEnterTxt.getText(), "Please enter the following information about your eligibility or current enrollment in health insurance purchased directly through an insurance company, through HealthCare.gov, or another state\u2019s Marketplace.");
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(0).getText(),"Are you currently enrolled in individual insurance?");
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"Yes");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageSecondSectionDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        basicActions.waitForElementToBePresent(OhcIndividualInsuranceHeader,15);
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(1).getText(),"Will this health insurance end in the next 60 days?");
        softAssert.assertEquals(insuranceEndingYes.getText(),"Yes");
        softAssert.assertEquals(insuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageThirdSectionDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(2).getText(),"What day will your coverage end?");
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(3).getText(),"Are you voluntarily ending this health insurance?");
        softAssert.assertEquals(endVoluntaryYes.getText(),"Yes");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageFirstSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresentWithRetries(OhcHeader,15);
        basicActions.waitForElementToBePresentWithRetries(OhcIndividualInsuranceHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(OhcIndividualInsuranceHeader.getText(),"Individual Insurance");
        softAssert.assertEquals(helpMeLink.getText(),"Help me understand this page");
        softAssert.assertTrue(pleaseEnterTxt.getText().equalsIgnoreCase( "Please enter the following information about " + SharedData.getMembers().get(0).getFullName() + "'s eligibility or current enrollment in health insurance purchased directly through an insurance company, through HealthCare.gov, or another state\u2019s Marketplace."));
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(0).getText().equalsIgnoreCase("Is " + SharedData.getMembers().get(0).getFullName() + " currently enrolled in individual insurance?"));
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"Yes");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageThirdSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(2).getText().equalsIgnoreCase("What day will " + SharedData.getMembers().get(0).getFullName() + "\u0027s coverage end?"));
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(3).getText().equalsIgnoreCase("Is " + SharedData.getMembers().get(0).getFullName() + " voluntarily ending this health insurance?"));
        softAssert.assertEquals(endVoluntaryYes.getText(),"Yes");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageDataSpanish(String dataToVerify){
        basicActions.waitForElementToBePresent(OhcHeader,15);
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
        softAssert.assertEquals(goBackButton.getText(),"Volver");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageFirstSectionDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcIndividualInsuranceHeader.getText(),"Seguro individual");
        softAssert.assertEquals(helpMeLink.getText(),"Ayuda para entender esta p\u00E1gina");
        softAssert.assertEquals(pleaseEnterTxt.getText(), "Ingrese la siguiente informaci\u00F3n acerca de su elegibilidad o inscripci\u00F3n actual en el seguro de salud adquirido directamente a trav\u00E9s de una compa\u00F1\u00Eda de seguros, por medio de HealthCare.gov o a trav\u00E9s de otro Mercado del estado.");
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(0).getText(),"\u00BFActualmente est\u00E1 inscrito en un seguro individual?");
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"S\u00ED");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageSecondSectionDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(1).getText(),"\u00BFEste seguro de salud terminar\u00E1 en los siguientes 60 d\u00EDas?");
        softAssert.assertEquals(insuranceEndingYes.getText(),"S\u00ED");
        softAssert.assertEquals(insuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageThirdSectionDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(2).getText(),"\u00BFQu\u00E9 d\u00EDa termina su cobertura?");
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(IndividualInsuranceQuestionTxt.get(3).getText(),"\u00BFEst\u00E1 cancelando voluntariamente este seguro de salud?");
        softAssert.assertEquals(endVoluntaryYes.getText(),"S\u00ED");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageFirstSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresentWithRetries(OhcHeader,60);
        basicActions.waitForElementToBePresentWithRetries(OhcIndividualInsuranceHeader,60);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(OhcIndividualInsuranceHeader.getText(),"Seguro individual");
        softAssert.assertEquals(helpMeLink.getText(),"Ayuda para entender esta p\u00E1gina");
        softAssert.assertTrue(pleaseEnterTxt.getText().equalsIgnoreCase( "Ingrese la siguiente informaci\u00F3n acerca de la elegibilidad o inscripci\u00F3n actual de " + SharedData.getMembers().get(0).getFullName() + " en el seguro de salud adquirido directamente a trav\u00E9s de una compa\u00F1\u00Eda de seguros, por medio de HealthCare.gov o a trav\u00E9s de otro Mercado del estado."));
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(0).getText().equalsIgnoreCase("\u00BFActualmente " + SharedData.getMembers().get(0).getFullName() + " est\u00E1 inscrito en un seguro individual?"));
        softAssert.assertEquals(currentlyEnrolledYes.getText(),"S\u00ED");
        softAssert.assertEquals(currentlyEnrolledNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyIndividualInsurancePageThirdSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(2).getText().equalsIgnoreCase("\u00BFQu\u00E9 d\u00EDa termina la cobertura de " + SharedData.getMembers().get(0).getFullName() + "?"));
        softAssert.assertEquals(inputEndDate.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertTrue(IndividualInsuranceQuestionTxt.get(3).getText().equalsIgnoreCase("\u00BF" + SharedData.getMembers().get(0).getFullName() + " est\u00E1 cancelando voluntariamente este seguro de salud?"));
        softAssert.assertEquals(endVoluntaryYes.getText(),"S\u00ED");
        softAssert.assertEquals(endVoluntaryNo.getText(),"No");
        softAssert.assertAll();
    }

    public void validateHelpVerbiage(String helpData,String language) {
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 30);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIndividualInsurance, 30);
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
        softAssert.assertEquals(helpDrawerHeaderIndividualInsurance.getText(), "Individual Insurance");
        softAssert.assertEquals(helpDrawerHeaderOne.getText(), "Overview");
        softAssert.assertEquals(helpDrawerHeaderTwo.getText(), "Enrollment");
        softAssert.assertEquals(helpDrawerHeaderThree.getText(), "End in the next 60 days");
        softAssert.assertEquals(helpDrawerHeaderFour.getText(), "Voluntarily Ending");
        softAssert.assertEquals(helpDrawerBodyParagraphOne.getText(), "This page helps us find out if this person is enrolled in or eligible for other health insurance. By eligible, we mean that they have the option to enroll, even if they aren't currently enrolled.");
        softAssert.assertEquals(helpDrawerBodyParagraphTwo.getText(), "If this person currently has this health insurance, select \"Yes\". If they are able to get this health insurance, but have chosen not to, select \"No\".");
        softAssert.assertEquals(helpDrawerBodyParagraphThree.getText(), "If this insurance is ending in the next 60 days, this person is eligible for a Special Enrollment Period which allows you and your family to shop for health insurance outside of the Open Enrollment Period.");
        softAssert.assertEquals(helpDrawerBodyParagraphFour.getText(), "If this person chooses to end this health insurance, they will not be eligible for a Special Enrollment Period to shop for other health insurance. They must wait until the next Open Enrollment Period to shop unless they have another qualifying life change event.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderIndividualInsurance.getText(), "Seguro individual");
        softAssert.assertEquals(helpDrawerHeaderOne.getText(), "Resumen");
        softAssert.assertEquals(helpDrawerHeaderTwo.getText(), "Inscripci\u00F3n");
        softAssert.assertEquals(helpDrawerHeaderThree.getText(), "Finalizaci\u00F3n en los pr\u00F3ximos 60 d\u00EDas");
        softAssert.assertEquals(helpDrawerHeaderFour.getText(), "Cancelaci\u00F3n voluntaria");
        softAssert.assertEquals(helpDrawerBodyParagraphOne.getText(), "Esta p\u00E1gina nos ayuda a saber si esta persona est\u00E1 inscrita o es elegible para otro seguro de salud. Al decir elegible, nos referimos a que tiene la opci\u00F3n de inscribirse, aun si la persona no est\u00E1 actualmente inscrita.");
        softAssert.assertEquals(helpDrawerBodyParagraphTwo.getText(), "Si actualmente esta persona tiene este seguro de salud, seleccione \"S\u00ED\". Si esta persona puede obtener este seguro de salud, pero ha decidido no tenerlo, seleccione \"No\".");
        softAssert.assertEquals(helpDrawerBodyParagraphThree.getText(), "Si este seguro va a terminar en los pr\u00F3ximos 60 d\u00EDas, esta persona es elegible para un Per\u00EDodo de inscripci\u00F3n especial que le permite tanto a usted como a su familia adquirir un seguro de salud fuera del Per\u00EDodo de inscripci\u00F3n abierta.");
        softAssert.assertEquals(helpDrawerBodyParagraphFour.getText(), "Si esta persona decide cancelar este seguro de salud, no podr\u00E1 ser elegible para un Per\u00EDodo de inscripci\u00F3n especial para adquirir otro seguro de salud. Deber\u00E1 esperar hasta el siguiente Per\u00EDodo de inscripci\u00F3n abierta para adquirirlo a menos que tenga otro evento de vida calificado.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateCurrentlyEnrolledHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderIndividualInsurance.getText(), "Individual Insurance");
        softAssert.assertEquals(helpDrawerMainHeaders.getText(), "Enrollment");
        softAssert.assertEquals(helpDrawerBodyParagraphOne.getText(), "If this person currently has this health insurance, select \"Yes\". If they are able to get this health insurance, but have chosen not to, select \"No\".");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void validateCurrentlyEnrolledHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderIndividualInsurance.getText(), "Seguro individual");
        softAssert.assertEquals(helpDrawerMainHeaders.getText(), "Inscripci\u00F3n");
        softAssert.assertEquals(helpDrawerBodyParagraphOne.getText(), "Si actualmente esta persona tiene este seguro de salud, seleccione \"S\u00ED\". Si esta persona puede obtener este seguro de salud, pero ha decidido no tenerlo, seleccione \"No\".");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validate60DaysHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderIndividualInsurance.getText(), "Individual Insurance");
        softAssert.assertEquals(helpDrawerMainHeaders.getText(), "End in the next 60 days");
        softAssert.assertEquals(helpDrawerBodyParagraphOne.getText(), "If this insurance is ending in the next 60 days, this person is eligible for a Special Enrollment Period which allows you and your family to shop for health insurance outside of the Open Enrollment Period.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void validate60DaysHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderIndividualInsurance.getText(), "Seguro individual");
        softAssert.assertEquals(helpDrawerMainHeaders.getText(), "Finalizaci\u00F3n en los pr\u00F3ximos 60 d\u00EDas");
        softAssert.assertEquals(helpDrawerBodyParagraphOne.getText(), "Si este seguro va a terminar en los pr\u00F3ximos 60 d\u00EDas, esta persona es elegible para un Per\u00EDodo de inscripci\u00F3n especial que le permite tanto a usted como a su familia adquirir un seguro de salud fuera del Per\u00EDodo de inscripci\u00F3n abierta.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateVoluntaryEndingHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderIndividualInsurance.getText(), "Individual Insurance");
        softAssert.assertEquals(helpDrawerMainHeaders.getText(), "Voluntarily Ending");
        softAssert.assertEquals(helpDrawerBodyParagraphOne.getText(), "If this person chooses to end this health insurance, they will not be eligible for a Special Enrollment Period to shop for other health insurance. They must wait until the next Open Enrollment Period to shop unless they have another qualifying life change event.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void validateVoluntaryEndingHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderIndividualInsurance.getText(), "Seguro individual");
        softAssert.assertEquals(helpDrawerMainHeaders.getText(), "Cancelaci\u00F3n voluntaria");
        softAssert.assertEquals(helpDrawerBodyParagraphOne.getText(), "Si esta persona decide cancelar este seguro de salud, no podr\u00E1 ser elegible para un Per\u00EDodo de inscripci\u00F3n especial para adquirir otro seguro de salud. Deber\u00E1 esperar hasta el siguiente Per\u00EDodo de inscripci\u00F3n abierta para adquirirlo a menos que tenga otro evento de vida calificado.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }













}
