package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

public class LawfulPresencePage {
    private BasicActions basicActions;

    public LawfulPresencePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "usCitizenYes")
    WebElement rdobtnCitizenYes;

    @FindBy(id = "usCitizenNo")
    WebElement rdobtnCitizenNo;

    @FindBy(id = "naturalizedCitizenYes")
    WebElement rdobtnNaturalizedYes;
    @FindBy(id = "naturalizedCitizenNo")
    WebElement rdobtnnaturalizedNo;

    @FindBy(id = "nonCitizenYes")
    WebElement rdobtnEligibleImmigrantYes;

    @FindBy(id = "nonCitzenNo")
    WebElement rdobtnEligibleImmigrantNo;

    @FindBy(id = "documentType")
    WebElement selectDocType;

    @FindBy(id = "alienNumberNonCitizen")
    WebElement alienNumberNonCitizen;

    @FindBy(id = "livedSince1996Yes")
    WebElement livedSince1996Yes;

    @FindBy(id = "livedSince1996No")
    WebElement livedSince1996No;

    @FindBy(id = "myselfMilitary")
    WebElement chkBoxMyselfMilitary;

    @FindBy(id = "spouseMilitary")
    WebElement chkBoxSpouseMilitary;

    @FindBy(id = "parentsMilitary")
    WebElement chkBoxParentsMilitary;

    @FindBy(id = "noneOfTheAbove")
    WebElement chkBoxNoneOfTheAbove;

    @FindBy(id = "nameMatchesYes")
    WebElement NameMatchesYes;

    @FindBy(id = "nameMatchesNo")
    WebElement nameMatchesNo;

    @FindBy(name = "saveAndContinue")
    WebElement saveContinue;

    @FindBy(css = "h1.c4PageHeader")
    WebElement citizenshipImmigrationStatusHeader;

    @FindBy(css = "#overviewButton")
    WebElement helpMeUnderstandLink;

    @FindBy(xpath = "//label[@for='usCitizen']/span[@class='c4BodyText1']")
    WebElement usCitizenQuestionText;

    @FindBy(css = ".citizenGroup input#usCitizenYes + label span")
    WebElement textYesUSCitizen;

    @FindBy(css = ".citizenGroup input#usCitizenNo + label span")
    WebElement textNoUSCitizen;

    @FindBy(css = "#NaturalizedCitizenQ  label span")
    List<WebElement> naturalizedCitizenGroup;

    @FindBy(css = "#NonCitizenQ label span")
    List<WebElement> immigrationStatusQuestion;

    @FindBy(css = "#NonCitizenTable div:nth-child(1) div div label span")
    WebElement textDocumentType;

    @FindBy (css = ".back-button-link")
    WebElement btnBack;

    public void isMemberCitizen(String YNCitizen){
        switch(YNCitizen){
            case "Yes":
                rdobtnCitizenYes.click();
                break;
            case "No":
                rdobtnCitizenNo.click();
        }
    }

    public void isMemberNaturalized(String YNNaturalized){
        switch(YNNaturalized){
            case "Yes":
                rdobtnNaturalizedYes.click();
                break;
            case "No":
                rdobtnnaturalizedNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNNaturalized);
        }
    }

    public void isMemberHaveEligibleImmigrationStatus(String YNEligibleImmigrationStatus){
        switch(YNEligibleImmigrationStatus){
            case "Yes":
                rdobtnEligibleImmigrantYes.click();
                break;
            case "No":
                rdobtnEligibleImmigrantNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNEligibleImmigrationStatus);
        }
    }

    public void selectDocumentType(String documentType){
        basicActions.waitForElementToBePresent(selectDocType, 15);

        Select dropdown = new Select(selectDocType);
        dropdown.selectByVisibleText(documentType);
    }

    public static String generateUSCISNumber(){
        Random rand = new Random();
        int USCISNumber = 100_000_000 + rand.nextInt(900_000_000);
        return String.valueOf(USCISNumber);
    }

    public void enterUSCISNumber(){
        String USCISNumberValue = generateUSCISNumber();
        alienNumberNonCitizen.sendKeys(USCISNumberValue);
    }

    public void isMemberLivedInUSSince1996(String YNLivedInUSSince1996){
        switch(YNLivedInUSSince1996){
            case "Yes":
                livedSince1996Yes.click();
                break;
            case "No":
                livedSince1996No.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNLivedInUSSince1996);
        }
    }

    public void selectActiveDutyMilitaryOrHonorablyDischargedVeterans(String memberOptions){
        switch(memberOptions){
            case "Me":
                chkBoxMyselfMilitary.click();
                break;
            case "My spouse":
                chkBoxSpouseMilitary.click();
                break;
            case "One or both of my parents":
                chkBoxParentsMilitary.click();
                break;
            case "None of the above":
                chkBoxNoneOfTheAbove.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + memberOptions);
        }
    }

    public void selectNameMatchesDocument(String YNNameMatchesDocument){
        switch(YNNameMatchesDocument){
            case "Yes":
                NameMatchesYes.click();
                break;
            case "No":
                nameMatchesNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNNameMatchesDocument);
        }
    }

    public  void clickContinue(){saveContinue.click();}

    public void getPrimaryMemberId() {
        String currentUrl = basicActions.getCurrentUrl();
       SharedData.setPrimaryMemberId(currentUrl.substring(currentUrl.indexOf('=')+1));
        System.out.println("Primary Member ID: "+SharedData.getPrimaryMemberId());
    }

    public void validateVerbiageOnCitizenshipAndImmigratioStatusPage(String language) {
        switch (language) {
            case "English":
                validateVerbiageEnglish();
                break;
            case "Spanish":
                validateVerbiageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private void validateVerbiageSpanish() {
        SoftAssert softAssert = new SoftAssert();

    }

    private void validateVerbiageEnglish() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(citizenshipImmigrationStatusHeader.getText().contains("Citizenship and immigration status: "), "Page Header text mismatch");
        softAssert.assertEquals(helpMeUnderstandLink.getText(), "Help me understand this page", "Page Hyperlink text mismatch");
        softAssert.assertEquals(usCitizenQuestionText.getText(), "Are you a U.S. Citizen?", "US Citizen Question text mismatch");
        softAssert.assertEquals(textYesUSCitizen.getText(), "Yes", "US Citizen - Yes RadioButton text mismatch");
        softAssert.assertEquals(textNoUSCitizen.getText(), "No", "US Citizen - No RadioButton text mismatch");

        // Select US Citizen - "Yes" RadioButton
        rdobtnCitizenYes.click();

        softAssert.assertEquals(naturalizedCitizenGroup.get(0).getText(), "Are you a Naturalized Citizen?", "Naturalized Citizen Question text mismatch");
        softAssert.assertEquals(naturalizedCitizenGroup.get(1).getText(), "Yes", "Naturalized Citizen - Yes RadioButton text mismatch");
        softAssert.assertEquals(naturalizedCitizenGroup.get(2).getText(), "No", "Naturalized Citizen - No RadioButton text mismatch");

        // Select US Citizen - "No" RadioButton
        rdobtnCitizenNo.click();

        softAssert.assertEquals(immigrationStatusQuestion.get(0).getText(), "Do you have an eligible immigration status?", "Immigration status Question text mismatch");
        softAssert.assertEquals(immigrationStatusQuestion.get(1).getText(), "Yes", "Immigration status - Yes RadioButton text mismatch");
        softAssert.assertEquals(immigrationStatusQuestion.get(2).getText(), "No", "Immigration status - No RadioButton text mismatch");

        //Select Immigration Status Yes
        rdobtnEligibleImmigrantYes.click();

        softAssert.assertEquals(textDocumentType.getText(), "Document type", "Document type text mismatch");

        // Initialize Select class with the dropdown element
        basicActions.waitForElementToBePresent(selectDocType, 15);
        Select dropdown = new Select(selectDocType);

        // Define the expected options
        String[] expectedOptions = {"Select Option", "I-327 Reentry Permit", "I-551 Permanent Resident Card", "I-571 Refugee Travel Document", "I-766 Employment Authorization Card", "Machine Readable Immigrant Visa (with Temporary I-551 Language)", "Temporary I-551 Stamp (on passport or I-94)", "Temporary I-551 Stamp (on passport or I-94)", "I-94 (Arrival/Departure Record)", "I-94 (Arrival/Departure Record) in Unexpired Foreign Passport", "I-20 (Certificate of Eligibility for Nonimmigrant (F-1) Student Status)", "DS2019 (Certificate of Eligibility for Exchange Visitor (J-1) Status)", "Other"};

        // Verify each option is present in the dropdown
        for (String option : expectedOptions) {
            boolean optionExists = dropdown.getOptions().stream().anyMatch(e -> e.getText().equals(option));
            softAssert.assertTrue(optionExists, "Option '" + option + "' is not displayed in the dropdown.");
        }

        softAssert.assertEquals(btnBack.getAttribute("value"), "< Back", "Back button text mismatch");
        softAssert.assertEquals(saveContinue.getAttribute("value"), "Save and Continue", "Continue button text mismatch");

        softAssert.assertAll();
    }

}
