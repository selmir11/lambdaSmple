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

    @FindBy(css = "*[role='presentation']")
    List<WebElement> helpDrawerHelpText;

    @FindBy(id = "usCitizen-error")
    WebElement USCitizenErrorMessage;

    @FindBy(id = "naturalizedCitizen-error")
    WebElement NaturalizedCitizenErrorMessage;

    @FindBy(id = "lawfulNonCitizen-error")
    WebElement EligibleImmigrantStatusErrorMessage;

    @FindBy(id = "documentFirstName")
    WebElement DocumentFirstNameField;

    @FindBy(id = "documentMiddleName")
    WebElement DocumentMiddleNameField;

    @FindBy(id = "documentLastName")
    WebElement DocumentLastNameField;

    @FindBy(xpath = "//*[@class='c4BodyText1']")
    List<WebElement> bodyTexts;

    @FindBy(xpath = "//input[@id='naturalizationCertificate']//following-sibling::label/span")
    WebElement textNaturalizationCertificate;

    @FindBy(xpath = "//input[@id='citizenshipCertificate']//following-sibling::label/span")
    WebElement textCitizenshipCertificate;

    @FindBy(xpath = "//label[@id='alienNumber-error']")
    WebElement UsicsNumErrMsg;

    @FindBy(xpath = "//label[@id='documentTypeCitzn-error']")
    WebElement DocTypeErrorMsg;

    @FindBy(xpath = "//label[@id='documentNumber-error']")
    WebElement DocNumError;

    @FindBy(id = "documentType-error")
    WebElement DocumentTypeErrorMessage;

    @FindBy(css = ".aNumber.row .col-sm-4 .control-label span")
    WebElement ANumberOrUSCISNumberLabel;

    @FindBy(css = "#militaryFamilyGrp .control-label span")
    WebElement MilitaryOrDischargedVeteransQuestion;

    @FindBy(css = ".input-checkbox[type='checkbox']")
    List<WebElement> CheckBoxesForMilitaryOrDischargedVeteransQuestion;

    @FindBy(css = ".input-group div .label-checkbox")
    List<WebElement> CheckBoxesLabelsForMilitaryOrDischargedVeteransQuestion;

    @FindBy(css = "#NameMatchesDocumentQ label span")
    List<WebElement> UsernameMatchWithDocumentNameQuestionWithYesNoLabels;

    @FindBy(css = ".control-label.input-radio[type='radio'][name='nameMatchesDocument']")
    List<WebElement> RadioButtonsForUsernameMatchWithDocumentNameQuestion;

    @FindBy(id = "alienNumberNonCitizen-error")
    WebElement AlienNumberErrorMessage;

    @FindBy(id = "nameMatchesDocument-error")
    WebElement nameMatchesDocumentErrorMessage;

    @FindBy(id = "documentFirstName-error")
    WebElement DocumentFirstNameErrorMessage;

    @FindBy(id = "documentLastName-error")
    WebElement DocumentLastNameErrorMessage;

    @FindBy(id = "selectOption")
    WebElement MilitaryOrHonorablyDischargedVeteransErrorMessage;

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
        switch (citizenship) {
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
        switch (docType) {
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
        String CardNumberValue = "AAA5" + generateCardNumber();
        cardNumber.sendKeys(CardNumberValue);
    }

    public void enterExpirationDate() {
        String expirationDateValue = "01012028";
        documentExpirationDate.sendKeys(expirationDateValue);
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
                basicActions.waitForElementToBeClickable(chkBoxNoneOfTheAbove, 20);
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
            SharedData.getPrimaryMember().setMemberId(memberId);
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
        basicActions.waitForElementToBePresent(citizenshipImmigrationStatusHeader,20);
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
                throw new IllegalArgumentException("Invalid option: " + language);
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

    public void clickHelpIcon(String label) {
        basicActions.waitForElementToBePresent (helpMeUnderstandLink, 10);
        switch(label){
            case "Help me understand":
                helpMeUnderstandLink.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + label);
        }
    }

    public void validateHelpVerbiage(String helpText, String language) {
        basicActions.waitForElementToBePresent(helpDrawerHelpText.get(2), 30);
        switch (helpText) {
            case "Eligible Immigration Status":
                handleEligibleImmigrationStatus(language);
                break;
            case "Document Type":
                handleDocumentType(language);
                break;
            case "Active Duty Military Members or Honorably Discharged Veterans":
                handleMilitaryMembersOrVeterans(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + helpText);
        }
    }

    private void handleEligibleImmigrationStatus(String language) {
        switch (language) {
            case "English":
                validateEligibleImmigrationStatusHelpTextVerbiageEng();
                break;
            case "Spanish":
                validateEligibleImmigrationStatusHelpTextVerbiageSp();
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
    }

    private void handleDocumentType(String language) {
        switch (language) {
            case "English":
                validateDocumentTypeHelpTextVerbiageEng();
                break;
            case "Spanish":
                validateDocumentTypeHelpTextVerbiageSp();
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
    }

    private void handleMilitaryMembersOrVeterans(String language) {
        switch (language) {
            case "English":
                validateMilitaryMembersOrVeteransHelpTextVerbiageEng();
                break;
            case "Spanish":
                validateMilitaryMembersOrVeteransHelpTextVerbiageSp();
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
    }

    public void validateEligibleImmigrationStatusHelpTextVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerHelpText.get(4),20);
        softAssert.assertEquals(helpDrawerHelpText.get(4).getText(), "Eligible Immigration Status\nThose who have eligible immigration status are those who have permission to live and work in the United States but are not U.S. citizens. If you have an Employment Authorization Document (EAD), you are also considered lawfully present.\nA full list of qualifying situations can be found here: https://www.healthcare.gov/immigrants/ immigration-status/");
        softAssert.assertAll();
    }

    public void validateEligibleImmigrationStatusHelpTextVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerHelpText.get(4),20);
        softAssert.assertEquals(helpDrawerHelpText.get(4).getText(), "Estatus migratorio elegible\nTienen estatus migratorio elegible aquellas personas que tienen autorizaci\u00F3n para vivir y trabajar en Estados Unidos pese a no ser ciudadanas estadounidenses. Tambi\u00E9n se le considera con \"presencia legal\" si cuenta con un documento de autorizaci\u00F3n de empleo (EAD).\nPuede consultar una lista completa de las situaciones calificadas en: https://www. cuidadodesalud.gov/es/immigrants/immigration-status/");
        softAssert.assertAll();
    }

    public void validateDocumentTypeHelpTextVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerHelpText.get(5),20);
        softAssert.assertEquals(helpDrawerHelpText.get(5).getText(), "Document Type\nFor more information on these documents, please see: https://www.healthcare.gov/help/ immigration-document-types/");
        softAssert.assertAll();
    }

    public void validateDocumentTypeHelpTextVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerHelpText.get(5),20);
        softAssert.assertEquals(helpDrawerHelpText.get(5).getText(), "Tipo de documento\nSi desea mayor informaci\u00F3n sobre estos documentos, visite: https://www.cuidadode salud.gov/es/help/immigration-document-types/");
        softAssert.assertAll();
    }

    public void validateMilitaryMembersOrVeteransHelpTextVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerHelpText.get(8),20);
        softAssert.assertEquals(helpDrawerHelpText.get(8).getText(), "Active Duty Military Members or Honorably Discharged Veterans\nQualified immigrants who also are (1) an honorably discharged veteran, (2) on active duty in the U.S. military or (3) the spouse (including a surviving spouse who has not remarried) or unmarried dependent child of an honorably discharged veteran or individual on active duty in the U.S. military are able to apply for health insurance through Connect for Health Colorado before the end of a five-year waiting period. Please note: DACA recipients should answer this question \"no\", even if they meet the qualifications noted above.");
        softAssert.assertAll();
    }

    public void validateMilitaryMembersOrVeteransHelpTextVerbiageSp() {
        basicActions.waitForElementToBePresent( helpDrawerHelpText.get(8),20);
        softAssert.assertEquals(helpDrawerHelpText.get(8).getText(), "Servicio activo del ej\u00E9rcito o veterano dado de baja honrosamente\nUn inmigrante autorizado que tambi\u00E9n: (1) sea veterano dado de baja honrosamente, (2) est\u00E9 en servicio activo en el ej\u00E9rcito de Estados Unidos o (3) sea c\u00F3nyuge (incluso un c\u00F3nyuge sobreviviente que no se haya vuelto a casar) o sea hijo dependiente soltero de un veterano dado de baja honrosamente o de un miembro en servicio activo del ej\u00E9rcito de Estados Unidos, puede solicitar seguro de salud por medio de Connect for Health Colorado antes de concluir un per\u00EDodo de espera de cinco a\u00F1os. Tenga en cuenta que: los beneficiarios de DACA deben responder \"no\" a esta pregunta, incluso si cumplen con los requisitos que se mencionan en la parte superior.");
        softAssert.assertAll();
    }

    public void validateUSCitizenErrorMessage(String expectedErrorMessage) {
        basicActions.waitForElementToBePresent( USCitizenErrorMessage,20);
        softAssert.assertEquals(USCitizenErrorMessage.getText(), expectedErrorMessage);
        softAssert.assertAll();
    }

    public void validateUSCitizenQuestionAndOptions(List<String> expectedTextList) {
        basicActions.waitForElementToBePresent( usCitizenQuestionText,20);
        basicActions.waitForElementToBePresent( textYesUSCitizen,20);
        basicActions.waitForElementToBePresent( textNoUSCitizen,20);
        basicActions.waitForElementToBePresent( rdobtnCitizenYes,20);
        basicActions.waitForElementToBePresent( rdobtnCitizenNo,20);
        softAssert.assertEquals(usCitizenQuestionText.getText(), expectedTextList.get(0));
        softAssert.assertEquals(textYesUSCitizen.getText(), expectedTextList.get(1));
        softAssert.assertEquals(textNoUSCitizen.getText(), expectedTextList.get(2));
        softAssert.assertTrue(rdobtnCitizenYes.isDisplayed(), "'Yes' Radio button for US Citizen question not visible"); // Verifying whether Yes radio button is present
        softAssert.assertTrue(rdobtnCitizenNo.isDisplayed(), "'No' Radio button for US Citizen question not visible"); // Verifying whether No radio button is present
        softAssert.assertAll();
    }

    public void validateNaturalizedCitizenQuestionAndOptions(List<String> expectedTextList) {
        basicActions.waitForElementToBePresent( naturalizedCitizenGroup.get(0),20);
        basicActions.waitForElementToBePresent( naturalizedCitizenGroup.get(1),20);
        basicActions.waitForElementToBePresent( naturalizedCitizenGroup.get(2),20);
        basicActions.waitForElementToBePresent( rdobtnNaturalizedYes,20);
        basicActions.waitForElementToBePresent( rdobtnnaturalizedNo,20);
        softAssert.assertEquals(naturalizedCitizenGroup.get(0).getText(), expectedTextList.get(0));
        softAssert.assertEquals(naturalizedCitizenGroup.get(1).getText(), expectedTextList.get(1));
        softAssert.assertEquals(naturalizedCitizenGroup.get(2).getText(), expectedTextList.get(2));
        softAssert.assertTrue(rdobtnNaturalizedYes.isDisplayed(), "'Yes' Radio button for Naturalized Citizen question not visible"); // Verifying whether Yes radio button is present
        softAssert.assertTrue(rdobtnnaturalizedNo.isDisplayed(), "'No' Radio button for Naturalized Citizen question not visible"); // Verifying whether No radio button is present
        softAssert.assertAll();
    }

    public void validateEligibleImmigrationStatusQuestionAndOptions(List<String> expectedTextList) {
        basicActions.waitForElementToBePresent( immigrationStatusQuestion.get(0),20);
        basicActions.waitForElementToBePresent( immigrationStatusQuestion.get(1),20);
        basicActions.waitForElementToBePresent( immigrationStatusQuestion.get(2),20);
        basicActions.waitForElementToBePresent( textNonCitizenInfoBox,20);
        basicActions.waitForElementToBePresent( rdobtnEligibleImmigrantYes,20);
        basicActions.waitForElementToBePresent( rdobtnEligibleImmigrantNo,20);
        softAssert.assertEquals(immigrationStatusQuestion.get(0).getText(), expectedTextList.get(0));
        softAssert.assertEquals(immigrationStatusQuestion.get(1).getText(), expectedTextList.get(1));
        softAssert.assertEquals(immigrationStatusQuestion.get(2).getText(), expectedTextList.get(2));
        softAssert.assertEquals(textNonCitizenInfoBox.getText(), expectedTextList.get(3));
        softAssert.assertTrue(rdobtnEligibleImmigrantYes.isDisplayed(), "'Yes' Radio button for eligible immigration status question not visible"); // Verifying whether Yes radio button is present
        softAssert.assertTrue(rdobtnEligibleImmigrantNo.isDisplayed(), "'No' Radio button for eligible immigration status question not visible"); // Verifying whether No radio button is present
        softAssert.assertAll();
    }

    public void validateTextOnSelectingNoToEligibleImmigrationStatusQuestion(List<String> expectedTextList) {
        basicActions.waitForElementToBePresent( textUndocumentedCitizenInfo.get(0),20);
        basicActions.waitForElementToBePresent( linkUndocumentedCitizenInfo.get(1),20);
        basicActions.waitForElementToBePresent( textUndocumentedCitizenInfo.get(1),20);
        basicActions.waitForElementToBePresent( linkUndocumentedCitizenInfo.get(2),20);
        basicActions.waitForElementToBePresent( textUndocumentedCitizenInfo.get(2),20);
        softAssert.assertEquals(textUndocumentedCitizenInfo.get(0).getText(), expectedTextList.get(0));
        softAssert.assertEquals(linkUndocumentedCitizenInfo.get(1).getText(), expectedTextList.get(1));
        softAssert.assertEquals(textUndocumentedCitizenInfo.get(1).getText(), expectedTextList.get(2));
        softAssert.assertEquals(linkUndocumentedCitizenInfo.get(2).getText(), expectedTextList.get(3));
        softAssert.assertEquals(textUndocumentedCitizenInfo.get(2).getText(), expectedTextList.get(4));
        softAssert.assertAll();
    }

    public void validateNaturalizedCitizenErrorMessage(String expectedErrorMessage) {
        basicActions.waitForElementToBePresent( NaturalizedCitizenErrorMessage,20);
        softAssert.assertEquals(NaturalizedCitizenErrorMessage.getText(), expectedErrorMessage);
        softAssert.assertAll();
    }

    public void validateEligibleImmigrationStatusErrorMessage(String expectedErrorMessage) {
        basicActions.waitForElementToBePresent( EligibleImmigrantStatusErrorMessage,20);
        softAssert.assertEquals(EligibleImmigrantStatusErrorMessage.getText(), expectedErrorMessage);
        softAssert.assertAll();
    }

    public void validatePageTextWhenUsCitizenOptYesOrNo(String option,List<String> languageText){
        switch (option){
            case "Yes":
                validatePageTextWhenUsCitizenOptYes(languageText);
                break;
            case "No":
                validatePageTextWhenUsCitizenOptNo(languageText);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
    }

    private void validatePageTextWhenUsCitizenOptYes(List<String> languageText){
        softAssert.assertEquals(languageText.get(0),bodyTexts.get(3).getText());
        softAssert.assertEquals(languageText.get(1),bodyTexts.get(4).getText());
        softAssert.assertEquals(languageText.get(2),bodyTexts.get(5).getText());
        softAssert.assertEquals(languageText.get(3),alienNumberCitizen.getAttribute("placeholder"));
        softAssert.assertEquals(languageText.get(4),textNaturalizationCertificate.getText());
        softAssert.assertEquals(languageText.get(5),textCitizenshipCertificate.getText());
        softAssert.assertAll();
    }
    private void validatePageTextWhenUsCitizenOptNo(List<String> languageText){
        softAssert.assertEquals(bodyTexts.get(7).getText(),languageText.get(0));
        softAssert.assertEquals(bodyTexts.get(18).getText(),languageText.get(1));
        softAssert.assertEquals(bodyTexts.get(19).getText(),languageText.get(2));
        softAssert.assertEquals(bodyTexts.get(20).getText(),languageText.get(3));
        softAssert.assertEquals(bodyTexts.get(21).getText(),languageText.get(4));
        softAssert.assertEquals(bodyTexts.get(22).getText(),languageText.get(5));
        String Firstname = SharedData.getPrimaryMember().getFirstName();
        String Lastname = SharedData.getPrimaryMember().getLastName();
        softAssert.assertEquals(bodyTexts.get(23).getText(),languageText.get(6)+" " + Firstname+" " + Lastname+" " + languageText.get(7));
        softAssert.assertEquals(bodyTexts.get(24).getText(),languageText.get(8));
        softAssert.assertEquals(bodyTexts.get(25).getText(),languageText.get(9));
        softAssert.assertEquals(bodyTexts.get(26).getText(),languageText.get(10));
        softAssert.assertEquals(bodyTexts.get(27).getText(),languageText.get(11));
        softAssert.assertAll();
    }
    public void verifyErrMsgInCitizenshipAndImmigrationPage(String language, List<String> dataText) {
        basicActions.waitForElementToBePresent(UsicsNumErrMsg, 2);
        basicActions.waitForElementToBePresent(DocTypeErrorMsg, 1);
        basicActions.waitForElementToBePresent(DocNumError, 1);
        softAssert.assertEquals(UsicsNumErrMsg.getText(), dataText.get(1), "Label Not matching");
        softAssert.assertEquals(DocTypeErrorMsg.getText(), dataText.get(2), "Label Not matching");
        softAssert.assertEquals(DocNumError.getText(), dataText.get(3), "label not matching");
        softAssert.assertAll();
    }

    public void validateDocumentTypeDropdownErrorMessage(String expectedErrorMessage) {
        basicActions.waitForElementToBePresent( DocumentTypeErrorMessage,20);
        softAssert.assertEquals(DocumentTypeErrorMessage.getText(), expectedErrorMessage);
        softAssert.assertAll();
    }

    public void validateWebElementsAfterSelectingDocumentType(List<String> expectedText) {
        basicActions.waitForElementToBePresent( ANumberOrUSCISNumberLabel,20);
        basicActions.waitForElementToBePresent( alienNumberNonCitizen,20);
        basicActions.waitForElementToBePresent( MilitaryOrDischargedVeteransQuestion,20);
        basicActions.waitForElementListToBePresent( CheckBoxesForMilitaryOrDischargedVeteransQuestion,20);
        basicActions.waitForElementListToBePresent( CheckBoxesLabelsForMilitaryOrDischargedVeteransQuestion,20);
        basicActions.waitForElementListToBePresent( UsernameMatchWithDocumentNameQuestionWithYesNoLabels,20);
        basicActions.waitForElementListToBePresent( RadioButtonsForUsernameMatchWithDocumentNameQuestion,20);
        softAssert.assertEquals(ANumberOrUSCISNumberLabel.getText(), expectedText.get(0));
        softAssert.assertTrue(alienNumberNonCitizen.isDisplayed(), "A-Number/USCIS number text box not visible");
        softAssert.assertEquals(MilitaryOrDischargedVeteransQuestion.getText(), expectedText.get(1));
        softAssert.assertTrue(CheckBoxesForMilitaryOrDischargedVeteransQuestion.get(0).isDisplayed(), "Me checkbox label not visible");
        softAssert.assertTrue(CheckBoxesForMilitaryOrDischargedVeteransQuestion.get(1).isDisplayed(), "My spouse checkbox label not visible");
        softAssert.assertTrue(CheckBoxesForMilitaryOrDischargedVeteransQuestion.get(2).isDisplayed(), "One or both of my parents checkbox label not visible");
        softAssert.assertTrue(CheckBoxesForMilitaryOrDischargedVeteransQuestion.get(3).isDisplayed(), "'None of the above' checkbox label not visible");
        softAssert.assertEquals(CheckBoxesLabelsForMilitaryOrDischargedVeteransQuestion.get(0).getText(), expectedText.get(2));
        softAssert.assertEquals(CheckBoxesLabelsForMilitaryOrDischargedVeteransQuestion.get(1).getText(), expectedText.get(3));
        softAssert.assertEquals(CheckBoxesLabelsForMilitaryOrDischargedVeteransQuestion.get(2).getText(), expectedText.get(4));
        softAssert.assertEquals(CheckBoxesLabelsForMilitaryOrDischargedVeteransQuestion.get(3).getText(), expectedText.get(5));
        softAssert.assertTrue(UsernameMatchWithDocumentNameQuestionWithYesNoLabels.get(0).isDisplayed(), "User name Match With Document Name Question not visible");
        softAssert.assertEquals(UsernameMatchWithDocumentNameQuestionWithYesNoLabels.get(1).getText(), expectedText.get(6));
        softAssert.assertEquals(UsernameMatchWithDocumentNameQuestionWithYesNoLabels.get(2).getText(), expectedText.get(7));
        softAssert.assertAll();
    }

    public void validateAlienNumberFieldErrorMessage(String expectedErrorMessage,String value) {
        basicActions.waitForElementToBePresent( alienNumberNonCitizen,20);
        alienNumberNonCitizen.clear();
        alienNumberNonCitizen.sendKeys(value);
        clickContinue();
        basicActions.waitForElementToBePresent( AlienNumberErrorMessage,20);
        softAssert.assertEquals(AlienNumberErrorMessage.getText(), expectedErrorMessage);
        softAssert.assertAll();
    }

    public void iValidateTrimmedValueInANumberField(String expectedValue,String givenValue) {
        basicActions.waitForElementToBePresent( alienNumberNonCitizen,20);
        alienNumberNonCitizen.clear();
        alienNumberNonCitizen.sendKeys(givenValue);
        basicActions.waitForElementToBePresent( alienNumberNonCitizen,40);
        softAssert.assertEquals(alienNumberNonCitizen.getAttribute("value"), expectedValue);
        softAssert.assertAll();
    }

    public void validateNameMatchesDocumentErrorMessage(String expectedErrorMessage) {
        basicActions.waitForElementToBePresent( nameMatchesDocumentErrorMessage,20);
        softAssert.assertEquals(nameMatchesDocumentErrorMessage.getText(), expectedErrorMessage);
        softAssert.assertAll();
    }

    public void validateTextAndWebElementsAfterSelectingNoToDocumentNameMatchQuestion(List<String> expectedText) {
        basicActions.waitForElementToBePresent( bodyTexts.get(24),20);
        basicActions.waitForElementToBePresent( bodyTexts.get(25),20);
        basicActions.waitForElementToBePresent( bodyTexts.get(26),20);
        basicActions.waitForElementToBePresent( bodyTexts.get(27),20);
        basicActions.waitForElementToBePresent( DocumentFirstNameField,20);
        basicActions.waitForElementToBePresent( DocumentMiddleNameField,20);
        basicActions.waitForElementToBePresent( DocumentLastNameField,20);
        softAssert.assertEquals(bodyTexts.get(24).getText(), expectedText.get(0));
        softAssert.assertEquals(bodyTexts.get(25).getText(), expectedText.get(1));
        softAssert.assertEquals(bodyTexts.get(26).getText(), expectedText.get(2));
        softAssert.assertEquals(bodyTexts.get(27).getText(), expectedText.get(3));
        softAssert.assertTrue(DocumentFirstNameField.isDisplayed(), "Document First Name field is not visible");
        softAssert.assertTrue(DocumentMiddleNameField.isDisplayed(), "Document Middle Name field is not visible");
        softAssert.assertTrue(DocumentLastNameField.isDisplayed(), "Document Last Name field is not visible");
        softAssert.assertAll();
    }

    public void validateErrorMessagesWhenNoValueGivenInFirstNameAndLastNameFields(List<String> expectedText) {
        basicActions.waitForElementToBePresent( DocumentFirstNameErrorMessage,20);
        basicActions.waitForElementToBePresent( DocumentLastNameErrorMessage,20);
        softAssert.assertEquals(DocumentFirstNameErrorMessage.getText(), expectedText.get(0));
        softAssert.assertEquals(DocumentLastNameErrorMessage.getText(), expectedText.get(1));
        softAssert.assertAll();
    }

    public void validateFieldDoesNotAcceptMoreThan25Characters(String inputText) {
        basicActions.waitForElementToBePresent( DocumentFirstNameField,20);
        DocumentFirstNameField.sendKeys(inputText);
        softAssert.assertTrue(DocumentFirstNameField.getAttribute("value").length()<26,"First name field accepting more than 25 characters");
        softAssert.assertAll();
    }

    public void validateFieldDoesNotAcceptMoreThan40Characters(String inputText) {
        basicActions.waitForElementToBePresent( DocumentLastNameField,20);
        DocumentLastNameField.clear();
        DocumentLastNameField.sendKeys(inputText);
        softAssert.assertTrue(DocumentLastNameField.getAttribute("value").length()<41,"Last name field accepting more than 40 characters");
        softAssert.assertAll();
    }

    public void validateLastNameFieldErrorMessageWhenNumericValueIsGivenInIt(String expectedErrorMessage,String value) {
        DocumentLastNameField.clear();
        DocumentLastNameField.sendKeys(value);
        clickContinue();
        basicActions.waitForElementToBePresent( DocumentLastNameErrorMessage,20);
        softAssert.assertEquals(DocumentLastNameErrorMessage.getText(), expectedErrorMessage);
        softAssert.assertAll();
    }

    public void validateMilitaryOrHonorablyDischargedVeteranErrorMessage(String expectedErrorMessage) {
        basicActions.waitForElementToBePresent( MilitaryOrHonorablyDischargedVeteransErrorMessage,20);
        softAssert.assertEquals(MilitaryOrHonorablyDischargedVeteransErrorMessage.getText(), expectedErrorMessage);
        softAssert.assertAll();
    }







}
