package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
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

    SoftAssert softAssert = new SoftAssert();

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

    @FindBy(id = "nonCitizenNo")
    WebElement rdobtnEligibleImmigrantNo;

    @FindBy(css = "select#documentType")
    WebElement selectDocType;

    @FindBy(id = "alienNumberNonCitizen")
    WebElement alienNumberNonCitizen;

    @FindBy(id = "alienNumber")
    WebElement alienNumberCitizen;

    @FindBy(id = "cardNumber")
    WebElement cardNumber;

    @FindBy(id = "documentExpirationDate")
    WebElement documentExpirationDate;

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

    @FindBy(css = "#NonCitizenTable .c4BodyText1")
    WebElement textDocumentType;

    @FindBy(css = ".back-button-link")
    WebElement btnBack;

    @FindBy(css = "p.information-box-text")
    WebElement textNonCitizenInfoBox;

    @FindBy(css = "span.undocumented-citizen-info-text")
    List<WebElement> textUndocumentedCitizenInfo;

    @FindBy(css = ".linkText1")
    List<WebElement> linkUndocumentedCitizenInfo;

    @FindBy(css = "#documentNumber")
    WebElement DocumentNumber;

    @FindBy(id = "naturalizationCertificate")
    WebElement dpdNaturalizationCertificate;

    @FindBy(id = "citizenshipCertificate")
    WebElement dpdCitizenshipCertificate;

    public void isMemberCitizen(String YNCitizen) {
        switch (YNCitizen) {
            case "Yes":
                basicActions.waitForElementToBePresent(rdobtnCitizenYes, 50);
                rdobtnCitizenYes.click();
                break;
            case "No":
                basicActions.waitForElementToBePresent(rdobtnCitizenNo, 50);
                rdobtnCitizenNo.click();
        }
    }

    public void isMemberNaturalized(String YNNaturalized) {
        switch (YNNaturalized) {
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

    public void isMemberHaveEligibleImmigrationStatus(String YNEligibleImmigrationStatus) {
        switch (YNEligibleImmigrationStatus) {
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

    public void selectDocumentType(String documentType) {
        basicActions.waitForElementToBePresent(selectDocType, 15);

        Select dropdown = new Select(selectDocType);
        dropdown.selectByVisibleText(documentType);
    }

    public static String generateUSCISNumber() {
        Random rand = new Random();
        int USCISNumber = 100_000_000 + rand.nextInt(900_000_000);
        return String.valueOf(USCISNumber);
    }

    public void enterUSCISNumber(String citizenship) {
        switch (citizenship){
            case "NonCitizen":
                enterUSCISNumberNonCitizen();
                break;
            case "Citizen":
                enterUSCISNumberCitizen();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + citizenship);
        }
    }

    public void enterUSCISNumberNonCitizen() {
        String USCISNumberValue = generateUSCISNumber();
        alienNumberNonCitizen.sendKeys(USCISNumberValue);
    }

    public void enterUSCISNumberCitizen() {
        String USCISNumberValue = generateUSCISNumber();
        alienNumberCitizen.sendKeys(USCISNumberValue);
    }

    public void clickDocType(String docType) {
        switch (docType){
            case "Naturalization Certificate":
                dpdNaturalizationCertificate.click();
                break;
            case "Citizenship Certificate":
                dpdCitizenshipCertificate.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + docType);
        }
    }

    public void enterDocumentNumber() {
        String DocumentNumberValue = generateUSCISNumber();
        DocumentNumber.sendKeys(DocumentNumberValue);
    }

    public static String generateCardNumber() {
        Random rand = new Random();
        int CardNumber = 100_000_000 + rand.nextInt(900_000_000);
        return String.valueOf(CardNumber);
    }

    public void enterCardNumber() {
        String CardNumberValue = "AAA5"+generateCardNumber();
        cardNumber.sendKeys(CardNumberValue);
    }

    public void enterExpirationDate() {
        String expirationDateValue = "01012028";
        documentExpirationDate.sendKeys(expirationDateValue);
    }


    public void isMemberLivedInUSSince1996(String YNLivedInUSSince1996) {
        switch (YNLivedInUSSince1996) {
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

    public void selectActiveDutyMilitaryOrHonorablyDischargedVeterans(String memberOptions) {
        switch (memberOptions) {
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

    public void selectNameMatchesDocument(String YNNameMatchesDocument) {
        switch (YNNameMatchesDocument) {
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

    public void clickContinue() {
        basicActions.waitForElementToBeClickable(saveContinue, 20);
        getMemberId();
        saveContinue.click();
    }

    public void clickGoBack() {
        basicActions.waitForElementToBeClickable(btnBack, 20);
        btnBack.click();
    }

    public void getMemberId() {

        List<MemberDetails> memberDetailsList = SharedData.getMembers();
        MemberDetails subscriber = SharedData.getPrimaryMember();

        String currentUrl = basicActions.getCurrentUrl();
        String headerText = citizenshipImmigrationStatusHeader.getText();
        String nameFromHeader = headerText.substring(headerText.indexOf(':') + 1).trim();
        String memberId = currentUrl.substring(currentUrl.indexOf('=') + 1);
        if (nameFromHeader.equals(SharedData.getPrimaryMember().getFullName())) {
            SharedData.setPrimaryMemberId(memberId);
            subscriber.setMemberId(memberId);
        }
        if (memberDetailsList != null && !memberDetailsList.isEmpty()) {
            for (MemberDetails member : memberDetailsList) {
                if (nameFromHeader.equals(member.getFullName())) {
                    member.setMemberId(memberId);
                    break;
                }
            }
            SharedData.setMembers(memberDetailsList);
        }
    }

    // WIP - Do we need a switch case here if it is same for both cases?
    public void validateVerbiageOnCitizenshipAndImmigratioStatusPage(String language, List<String> data) {
        switch (language) {
            case "English", "Spanish":
                validateVerbiageOnCitizenAndImmigratioStatusPage(data);
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private void validateVerbiageOnCitizenAndImmigratioStatusPage(List<String> data) {

        softAssert.assertTrue(citizenshipImmigrationStatusHeader.getText().contains(data.get(0)), "Page Header text mismatch");
        softAssert.assertEquals(helpMeUnderstandLink.getText(), data.get(1), "Page Hyperlink text mismatch");
        softAssert.assertEquals(usCitizenQuestionText.getText(), data.get(2), "US Citizen Question text mismatch");
        softAssert.assertEquals(textYesUSCitizen.getText(), data.get(3), "US Citizen - Yes RadioButton text mismatch");
        softAssert.assertEquals(textNoUSCitizen.getText(), data.get(4), "US Citizen - No RadioButton text mismatch");

        softAssert.assertAll();
    }

    public void validateVerbageForNaturalizedCitizenIn(String language, List<String> data) {
        switch (language) {
            case "English", "Spanish":
                validateVerbiageNaturalizedCitizen(data);
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }

    }

    private void validateVerbiageNaturalizedCitizen(List<String> data) {

        softAssert.assertEquals(naturalizedCitizenGroup.get(0).getText(), data.get(0), "Naturalized Citizen Question text mismatch");
        softAssert.assertEquals(naturalizedCitizenGroup.get(1).getText(), data.get(1), "Naturalized Citizen - Yes RadioButton text mismatch");
        softAssert.assertEquals(naturalizedCitizenGroup.get(2).getText(), data.get(2), "Naturalized Citizen - No RadioButton text mismatch");

        softAssert.assertAll();
    }

    public void validateVerbiageForEligibleImmigrationStausIn(String language, List<String> data) {
        switch (language) {
            case "English", "Spanish":
                validateVerbiageEligibleImmigrationStaus(data);
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private void validateVerbiageEligibleImmigrationStaus(List<String> data) {

        softAssert.assertEquals(immigrationStatusQuestion.get(0).getText(), data.get(0), "Immigration status Question text mismatch");
        softAssert.assertEquals(textNonCitizenInfoBox.getText(), data.get(1), "Immigration status - information text box");
        softAssert.assertEquals(immigrationStatusQuestion.get(1).getText(), data.get(2), "Immigration status - Yes RadioButton text mismatch");
        softAssert.assertEquals(immigrationStatusQuestion.get(2).getText(), data.get(3), "Immigration status - No RadioButton text mismatch");

        softAssert.assertAll();
    }

    public void validateVerbiageForDocumentTypeIn(String language, List<String> data) {
        switch (language) {
            case "English", "Spanish":
                validateVerbiageDocumentType(data);
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private void validateVerbiageDocumentType(List<String> data) {
        List<WebElement> dropdownOptions = new Select(selectDocType).getOptions();
        int index = 0;
        for (WebElement dropdownOption : dropdownOptions) {
            softAssert.assertEquals(dropdownOption.getText(), data.get(index), "Mismatch at option " + index);
            index++;
        }
        softAssert.assertAll(); // This should be here, after all the assertions have been made
    }

    public void validateDocumentTypeText(String language, List<String> data) {
        switch (language) {
            case "English", "Spanish":
                validateDocumentTypeTextIn(data);
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private void validateDocumentTypeTextIn(List<String> data) {

        softAssert.assertEquals(textDocumentType.getText(), data.get(0), "Document Type text mismatch");

        softAssert.assertAll();
    }

    public void validateUndocumentedCitizenInfoText(String language) {
        basicActions.waitForElementToBePresent(citizenshipImmigrationStatusHeader, 10);
        switch (language) {
            case "English":
                validateUndocumentedCitizenInfoTextEnglish();
                break;
            case "Spanish":
                validateUndocumentedCitizenInfoTextSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void validateUndocumentedCitizenInfoTextEnglish() {
        softAssert.assertEquals(textUndocumentedCitizenInfo.get(0).getText(), "If you are undocumented, you may qualify for other coverage options and financial help, such as");
        softAssert.assertEquals(linkUndocumentedCitizenInfo.get(1).getText(), "OmniSalud");
        softAssert.assertEquals(textUndocumentedCitizenInfo.get(1).getText(), ". In 2025, there are also new coverage options for undocumented people who are pregnant or under age 19. To find the best option for you, you can");
        softAssert.assertEquals(linkUndocumentedCitizenInfo.get(2).getText(), "get free, expert help");
        softAssert.assertEquals(textUndocumentedCitizenInfo.get(2).getText(), ".");
        softAssert.assertAll();
    }

    public void validateUndocumentedCitizenInfoTextSpanish() {
        softAssert.assertEquals(textUndocumentedCitizenInfo.get(0).getText(), "Si es una persona indocumentada, puede calificar para otras opciones de cobertura y ayuda financiera, tal como");
        softAssert.assertEquals(linkUndocumentedCitizenInfo.get(1).getText(), "OmniSalud");
        softAssert.assertEquals(textUndocumentedCitizenInfo.get(1).getText(), ". En 2025, tambi\u00E9n hay nuevas opciones de cobertura para personas indocumentadas que est\u00E1n embarazadas o son menores de 19 a\u00F1os. Para encontrar la mejor opci\u00F3n para usted, puede");
        softAssert.assertEquals(linkUndocumentedCitizenInfo.get(2).getText(), "obtener ayuda de un experto sin costo");
        softAssert.assertEquals(textUndocumentedCitizenInfo.get(2).getText(), ".");
        softAssert.assertAll();
    }

}
