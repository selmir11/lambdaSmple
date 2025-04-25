package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class OhcMedicarePage {
    private BasicActions basicActions;
    Actions actions = new Actions(WebDriverManager.getDriver());
    SoftAssert softAssert = new SoftAssert();
    public OhcMedicarePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container .header-1")
    WebElement OhcHeader;

    @FindBy(css = ".container .header-2")
    WebElement OhcMedicareHeader;

    @FindBy(css = ".ohc-container.body-text-1 > span")
    WebElement pleaseEnterTxt;

    @FindBy(css = ".row.label-row > div > label")
    List<WebElement> questionTxt;

    @FindBy(css = "lib-error-msg > div")
    List<WebElement> hdrError;

    @FindBy(css = "#ELIG-medicareOhc-partAPremium-container span.error-message")
    WebElement currentlyEligibleError;

    @FindBy(id = "ELIG-medicareOhc-partAPremium-YesButton")
    WebElement currentlyEligibleYes;

    @FindBy(id = "ELIG-medicareOhc-partAPremium-NoButton")
    WebElement currentlyEligibleNo;

    @FindBy(css = ".ohc-container > div > div:nth-child(1)")
    WebElement areYouEnrolledTxt;

    @FindBy(css = "lib-checkbox-control > label")
    List<WebElement> medicareCheckboxDetails;

    @FindBy(xpath = "//button[@role='checkbox']")
    List<WebElement> medicareCheckboxes;

    @FindBy(css = "#ELIG-medicareOhc-partBEndsSoon-container label > span")
    WebElement questionTxtB;

    @FindBy(css = "#ELIG-medicareOhc-partB-container .checkbox-container")
    WebElement medicareCheckboxDetailsB;

    @FindBy(css = "#ELIG-medicareOhc-premiumAmount-container span.error-message")
    WebElement InsuranceAmountError;

    @FindBy(css = "#ELIG-medicareOhc-premiumAmount")
    WebElement partAInsuranceAmount;

    @FindBy(css = "#ELIG-medicareOhc-partAEndsSoon-container span.error-message")
    WebElement partAInsuranceEndingError;

    @FindBy(id = "ELIG-medicareOhc-partAEndsSoon-YesButton")
    WebElement partAInsuranceEndingYes;

    @FindBy(id = "ELIG-medicareOhc-partAEndsSoon-NoButton")
    WebElement partAInsuranceEndingNo;

    @FindBy(css = "#ELIG-medicareOhc-partACoverageDate-container span.error-message")
    WebElement partAInsuranceEndInputError;

    @FindBy(css = "#ELIG-medicareOhc-partACoverageDate")
    WebElement partAInsuranceEndInput;

    @FindBy(css = "#ELIG-medicareOhc-partBEndsSoon-container span.error-message")
    WebElement partBInsuranceEndingError;

    @FindBy(id = "ELIG-medicareOhc-partBEndsSoon-YesButton")
    WebElement partBInsuranceEndingYes;

    @FindBy(id = "ELIG-medicareOhc-partBEndsSoon-NoButton")
    WebElement partBInsuranceEndingNo;

    @FindBy(css = "#ELIG-medicareOhc-partBCoverageDate-container span.error-message")
    WebElement partBInsuranceEndInputError;

    @FindBy(css = "#ELIG-medicareOhc-partBCoverageDate")
    WebElement partBInsuranceEndInput;

    @FindBy(id = "medicareOhc-GoBack")
    WebElement goBackButton;

    @FindBy(id = "medicareOhc-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(css = "div.header-3.text-center.content-center.ng-star-inserted > a")
    WebElement helpLnk;

    @FindBy(css = "lib-help-icon a")
    List<WebElement> helpIcons;

    @FindBy(css = "div.desktop-help > div > span.c4-text-body-200")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = "div.desktop-help > div > span.title.c4-type-header-sm")
    WebElement helpDrawerHeaderMedicare;

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

    @FindBy(css = "div.help-main-content.ng-star-inserted > p:nth-child(9) > a")
    WebElement doiMedicareLink;

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
                basicActions.waitForElementListToBePresentWithRetries(medicareCheckboxDetails,120);
                medicareCheckboxDetails.get(0).click();
                break;
            case "B":
                basicActions.waitForElementToBePresentWithRetries(medicareCheckboxDetailsB,120);
                medicareCheckboxDetailsB.click();
                break;
            case "A Don't Pay":
                basicActions.waitForElementListToBePresentWithRetries(medicareCheckboxDetails,120);
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

    public void enterEndDate(String endDateData, String insurancePart){
        switch (insurancePart) {
            case "A":
                enterEndDate(endDateData, partAInsuranceEndInput);
                break;
            case "B":
                enterEndDate(endDateData, partBInsuranceEndInput);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insurancePart);
        }
    }

    public void enterEndDate(String endDateData, WebElement inputElement) {
        String formattedDate;
        switch (endDateData) {
            case "Today":
                formattedDate = basicActions.changeDateFormat(basicActions.getTodayDate(), "MM/dd/yyyy", "MMdd");
                break;
            case "Current Month":
                formattedDate = basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MMdd");
                break;
            case "Prior Month":
                formattedDate = basicActions.changeDateFormat(basicActions.getPastDate(1), "MM/dd/yyyy", "MMdd");
                break;
            case "Future Month":
                formattedDate = basicActions.changeDateFormat(basicActions.getFutureDate(61), "MM/dd/yyyy", "MMdd");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + endDateData);
        }
        inputElement.sendKeys(formattedDate);
    }

    public void clickHelpIcon(String label) {
        basicActions.waitForElementListToBePresentWithRetries(helpIcons, 60);
        basicActions.waitForElementToBePresentWithRetries(helpLnk, 60);
        switch(label){
            case "Help me understand":
                helpLnk.click();
                break;
            case "Please enter":
                helpIcons.get(0).click();
                break;
            case "currently eligible":
                helpIcons.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + label);
        }
    }

    public void clickHelpContactUsNavigation() {
        basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
        helpDrawerContactUsLink.click();
    }

    public void clickHelpDoiNavigation() {
        basicActions.waitForElementToBePresent(doiMedicareLink, 10);
        doiMedicareLink.click();
    }



    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    public void verifyHeadersMedicareOhcPage(String member, String language){
        switch (language){
            case "English":
                verifyHeadersMedicareOhcPageEnglish(member);
                break;
            case "Spanish":
                verifyHeadersMedicareOhcPageSpanish(member);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersMedicareOhcPageEnglish(String member){
        basicActions.wait(250);
        basicActions.waitForElementToBePresentWithRetries(OhcHeader,60);
        basicActions.waitForElementToBePresentWithRetries(OhcMedicareHeader,60);
        switch (member){
            case "Primary":
                softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
                softAssert.assertEquals(OhcMedicareHeader.getText(),"Medicare");
                softAssert.assertAll();
                break;
            case "Secondary":
                softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getMembers().get(0).getFullName()));
                softAssert.assertEquals(OhcMedicareHeader.getText(),"Medicare");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + member);
        }
    }

    public void verifyHeadersMedicareOhcPageSpanish(String member){
        basicActions.waitForElementToBePresentWithRetries(OhcHeader,60);
        basicActions.waitForElementToBePresentWithRetries(OhcMedicareHeader,60);
        switch (member){
            case "Primary":
                softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
                softAssert.assertEquals(OhcMedicareHeader.getText(),"Medicare");
                softAssert.assertAll();
                break;
            case "Secondary":
                softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getMembers().get(0).getFullName()));
                softAssert.assertEquals(OhcMedicareHeader.getText(),"Medicare");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + member);
        }
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
        softAssert.assertTrue(partAInsuranceEndInput.getAttribute("value").contains(basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "yyyy-MM-dd")));
        softAssert.assertAll();
    }

    public void verifyPartBEndDate(){
        basicActions.waitForElementToBePresent(partBInsuranceEndInput, 60);
        softAssert.assertTrue(partBInsuranceEndInput.getAttribute("value").contains(basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "yyyy-MM-dd")));
        softAssert.assertAll();
    }

    public void verifyMedicarePageData(String dataToVerify, String language){
        basicActions.waitForElementToBePresent(OhcHeader,15);
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
        basicActions.waitForElementToBePresent(OhcHeader,15);
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
        softAssert.assertEquals(goBackButton.getText(),"Go back");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Save and continue");
        softAssert.assertAll();
    }

    public void verifyMedicarePageFirstSectionDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        basicActions.waitForElementToBePresent(OhcMedicareHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcMedicareHeader.getText(),"Medicare");
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
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertEquals(questionTxt.get(1).getText(),"Premium Amount");
        softAssert.assertEquals(partAInsuranceAmount.getText(),"");
        softAssert.assertEquals(questionTxt.get(2).getText(),"Will this health insurance end in the next 60 days?");
        softAssert.assertEquals(partAInsuranceEndingYes.getText(),"Yes");
        softAssert.assertEquals(partAInsuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyMedicarePagePartBSectionDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertEquals(questionTxtB.getText(),"Will this health insurance end in the next 60 days?");
        softAssert.assertEquals(partBInsuranceEndingYes.getText(),"Yes");
        softAssert.assertEquals(partBInsuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyMedicarePageFirstSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        basicActions.waitForElementToBePresent(OhcMedicareHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(OhcMedicareHeader.getText(),"Medicare");
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
        basicActions.waitForElementToBePresent(OhcHeader,15);
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
        softAssert.assertEquals(goBackButton.getText(),"Volver");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyMedicarePageFirstSectionDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcMedicareHeader.getText(),"Medicare");
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
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertEquals(questionTxt.get(1).getText(),"Monto de la cuota");
        softAssert.assertEquals(partAInsuranceAmount.getText(),"");
        softAssert.assertEquals(questionTxt.get(2).getText(),"\u00BFEste seguro de salud terminar\u00E1 en los siguientes 60 d\u00EDas?");
        softAssert.assertEquals(partAInsuranceEndingYes.getText(),"S\u00ED");
        softAssert.assertEquals(partAInsuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyMedicarePagePartBSectionDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        softAssert.assertEquals(questionTxtB.getText(),"\u00BFEste seguro de salud terminar\u00E1 en los siguientes 60 d\u00EDas?");
        softAssert.assertEquals(partBInsuranceEndingYes.getText(),"S\u00ED");
        softAssert.assertEquals(partBInsuranceEndingNo.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyMedicarePageFirstSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(OhcHeader,15);
        basicActions.waitForElementToBePresent(OhcMedicareHeader,15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(OhcMedicareHeader.getText(),"Medicare");
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
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(currentlyEligibleError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(currentlyEligibleError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
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
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(InsuranceAmountError.getText(), "Por favor ingrese un monto");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(InsuranceAmountError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
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
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(partAInsuranceEndingError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partAInsuranceEndingError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
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
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(partAInsuranceEndInputError.getText(), "La fecha es obligatoria");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partAInsuranceEndInputError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
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
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(partBInsuranceEndingError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partBInsuranceEndingError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
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
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(partBInsuranceEndInputError.getText(), "La fecha es obligatoria");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(partBInsuranceEndInputError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
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

    public void validateHelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 30);
        basicActions.waitForElementToBePresent(helpDrawerHeaderMedicare, 30);
        switch (language) {
            case "English":
                validateGeneralHelpBodyVerbiageEng();
                break;
            case "Spanish":
                validateGeneralHelpBodyVerbiageSp();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateGeneralHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderMedicare.getText(), "Medicare");
        softAssert.assertEquals(helpDrawerHeaderOne.getText(), "Overview");
        softAssert.assertEquals(helpDrawerHeaderTwo.getText(), "Medicare");
        softAssert.assertEquals(helpDrawerHeaderThree.getText(), "Part A");
        softAssert.assertEquals(helpDrawerBodyParagraphOne.getText(), "We are asking because if this person is enrolled in this plan, they won t be eligible for financial help if they buy a Connect for Health Colorado insurance plan instead.");
        softAssert.assertEquals(helpDrawerBodyParagraphTwo.getText(), "Tell us about anyone who is getting Medicare Part A or Part B or who is entitled to Part A, or B. By entitled, we mean that you are able to get the benefit, even if you arent actually getting it.");
        softAssert.assertEquals(helpDrawerBodyParagraphThree.getText(), "If you have Medicare Part A (Hospital Insurance), you're considered covered under the health care law and don't need a Connect for Health Colorado insurance plan.\nThe decision not to enroll in Medicare when eligible, or to cancel Medicare coverage, should not be taken lightly. Consumers with questions should consult the State Health Insurance Assistance Program (SHIP) office or their Broker. For more information, please see https://doi.colorado.gov/insurance-products/health-insurance/senior-health-care-medicare");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderMedicare.getText(), "Medicare");
        softAssert.assertEquals(helpDrawerHeaderOne.getText(), "Resumen");
        softAssert.assertEquals(helpDrawerHeaderTwo.getText(), "Medicare");
        softAssert.assertEquals(helpDrawerHeaderThree.getText(), "Part A");
        softAssert.assertEquals(helpDrawerBodyParagraphOne.getText(), "Se lo preguntamos porque, si esta persona est\u00E1 inscrita en ese plan, no tendr\u00E1 derecho a ayuda financiera si adquiere en su lugar un plan de seguro con Connect for Health Colorado.");
        softAssert.assertEquals(helpDrawerBodyParagraphTwo.getText(), "Indique si cualquier persona que reciba beneficios de Medicare Parte A, Parte B, o que tenga derecho a recibir beneficios de la Parte A o B. Cuando decimos \"que tenga derecho\" nos referimos a que puede recibir el beneficio, aunque en la actualidad no lo est\u00E9 recibiendo.");
        softAssert.assertEquals(helpDrawerBodyParagraphThree.getText(), "Si tiene la Parte A de Medicare (Seguro de Hospital), est\u00E1 cubierto bajo la ley de salud y no necesita un plan de seguro con Connect for Health Colorado.\nNo debe tomarse a la ligera la decisi\u00F3n de no inscribirse en Medicare cuando es elegible, o de cancelar su cobertura de Medicare. Los consumidores que tengan preguntas deben consultar la oficina estatal del Programa de asistencia de seguro de salud (SHIP, por sus siglas en ingl\u00E9s) o con su agente. Para obtener m\u00E1s informaci\u00F3n, visite https://doi.colorado.gov/insurance-products/health-insurance/senior-health-care-medicare");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyMedicareCheckboxes(String state){
        basicActions.wait(250);
        switch (state){
            case "Selected":
                verifySelectedStateOfCheckboxes();
                break;
            case "Hover":
                verifyHoverStateOfCheckboxes();
                break;
            case "Focus":
                verifyFocusStateOfCheckboxes();
                break;
            case "Not Selected":
                verifyNotSelectedStateOfCheckboxes();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + state);
        }
    }

    public void verifyNotSelectedStateOfCheckboxes() {
        basicActions.waitForElementListToBePresentWithRetries(medicareCheckboxes, 60);
        for (int i = 0; i < medicareCheckboxes.size(); i++) {
            WebElement element1 = medicareCheckboxes.get(i);
            WebElement element2 = medicareCheckboxDetails.get(i);
            basicActions.wait(100);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(55, 55, 55)");
            softAssert.assertAll();
            element1.click();
            basicActions.wait(100);
        }
    }

    public void verifyFocusStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(medicareCheckboxes, 15);
        for (int i = 0; i < medicareCheckboxes.size(); i++) {
            WebElement element = medicareCheckboxes.get(i);
            element.sendKeys(Keys.SHIFT);
            basicActions.wait(200);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element.getCssValue("box-shadow"), "rgb(112, 163, 0) 0px 0px 7px 3px");
            softAssert.assertAll();
            element.click();
            basicActions.wait(200);
        }
    }

    public void verifyHoverStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(medicareCheckboxes, 15);
        for (int i = 0; i < medicareCheckboxes.size(); i++) {
            WebElement element = medicareCheckboxes.get(i);
            actions.moveToElement(element).perform();
            basicActions.wait(500);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertAll();
            element.click();
            basicActions.wait(300);
        }
    }

    public void verifySelectedStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(medicareCheckboxes, 15);
        for (int i = 0; i < medicareCheckboxes.size(); i++) {
            WebElement element1 = medicareCheckboxes.get(i);
            WebElement element2 = medicareCheckboxDetails.get(i);
            element1.click();
            basicActions.wait(200);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container checked"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(112, 163, 0, 1)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(112, 163, 0)");
            softAssert.assertAll();
            basicActions.wait(200);
        }
    }



}
