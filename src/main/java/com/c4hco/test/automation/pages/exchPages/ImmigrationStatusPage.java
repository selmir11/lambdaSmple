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

public class ImmigrationStatusPage {

    private BasicActions basicActions;
    public ImmigrationStatusPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "lprYes")
    WebElement rdobtnLprYes;

    @FindBy(id = "lprNo")
    WebElement rdobtnLprNo;

    @FindBy(css = "select#lprNoDropdown.form-control")
    WebElement immigrationStatusLPRNo;

    @FindBy(id = "lprYesDropdown")
    WebElement immigrationStatusLPRYes;

    @FindBy(name = "saveAndContinue")
    WebElement saveContinue;


    @FindBy(css = "span.c4PageHeader")
    WebElement pageHeaderLpr;

    @FindBy(css = "span.c4PageTitle")
    WebElement pageTitleLpr;

    @FindBy(css = "p.c4BodyText1")
    WebElement  lprNeedMoreInfo;

    @FindBy(css = "a#overview")
    WebElement  helpUnderstandtext;

    @FindBy(css = "span.c4BodyText1")
    List<WebElement> lprQuestions;

    @FindBy(css = "input#submitButton.back-button-link")
    WebElement backButton;

    @FindBy(css = "input[name='grantDate']")
    WebElement grantDateInputField;

    @FindBy(id = "livedSince1996Yes")
    WebElement livedSince1996Yes;

    @FindBy(id = "livedSince1996No")
    WebElement livedSince1996No;

   //Immigration Status For parolee into US

    @FindBy(css = "h2.c4PageHeader")
    WebElement paroleePageHeader;

    @FindBy(id = "overviewButton")
    WebElement  paroleeHelpUnderstandText;

    @FindBy(css = "h2.c4PageTitle")
    WebElement paroleePageTitle;

    @FindBy(css = "div.c4BodyText1")
    WebElement  ParoleeNeedMoreInfo;


    public void isMemberLawfulPermanentResident(String YNLawfulPermanentResident){
        switch(YNLawfulPermanentResident){
            case "Yes":
                rdobtnLprYes.click();
                break;
            case "No":
                rdobtnLprNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNLawfulPermanentResident);
        }
    }

    public void selectImmigrationStatus(String selectImmigrationStatus){
        if (rdobtnLprYes.isSelected()){
             Select dropdown = new Select(immigrationStatusLPRYes);
             dropdown.selectByVisibleText(selectImmigrationStatus);
        } else if (rdobtnLprNo.isSelected()) {
            Select dropdown = new Select(immigrationStatusLPRNo);
            dropdown.selectByVisibleText(selectImmigrationStatus);
        }else {
            throw new IllegalStateException("Neither 'Yes' nor 'No' option is selected for Lawful Permanent Resident.");
        }
    }

    public  void clickContinue(){
        basicActions.waitForElementToBePresent(saveContinue, 10);
        saveContinue.click();
    }

    public void validateCitizenshipAndImmigrationJuvenileText(String language) {
        basicActions.waitForElementToBePresent(pageHeaderLpr, 10);
        switch (language) {
            case "English":
                validateCitizenshipAndImmigrationJuvenileTextEnglish();
                break;
            case "Spanish":
                validateCitizenshipAndImmigrationJuvenileTextSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void validateCitizenshipAndImmigrationJuvenileTextEnglish() {
        basicActions.waitForElementToBePresent(pageHeaderLpr,40);
        softAssert.assertEquals(pageHeaderLpr.getText(), "Citizenship and Immigration Status: "+ SharedData.getPrimaryMember().getFirstName()+" "+SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(pageTitleLpr.getText(), "Immigration Status");
        softAssert.assertEquals(helpUnderstandtext.getText(), "Help me understand this page");
        softAssert.assertEquals(lprNeedMoreInfo.getText(), "It looks like we need more information about your immigration status");
        softAssert.assertEquals(lprQuestions.get(0).getText(), "Are you a Lawful Permanent Resident (green card holder)?");
        basicActions.waitForElementListToBePresent(lprQuestions, 40);
        basicActions.waitForElementToBePresent(rdobtnLprYes, 40);
        rdobtnLprYes.click();
        softAssert.assertEquals((lprQuestions.get(1).getText()), "Before you became a Lawful Permanent Resident, did any of the following immigration statuses apply to you?");
        softAssert.assertEquals(immigrationStatusLPRYes.getText().trim().replaceAll("\\s+", " "), "Select Afghan or Iraqi Special Immigrant Visa (SIV) holder Afghan or Ukrainian Humanitarian Parolee Applicant/recipient for Special Immigrant Juvenile status Citizen of Micronesia, the Marshall Islands, or Palau Cuban/Haitian Entrant Granted Withholding of Deportation Native American born in Canada Refugee or asylee Victim of trafficking (or victim's spouse, child, sibling or parent) None of these apply to me");
        rdobtnLprNo.click();
        basicActions.waitForElementToBeClickable(immigrationStatusLPRNo, 150);
        softAssert.assertEquals(immigrationStatusLPRNo.getText().trim().replaceAll("\\s+", " "), "Select Administrative order staying removal Afghan or Iraqi Special Immigrant Visa (SIV) holder Afghan or Ukrainian Humanitarian Parolee Applicant for adjustment to LPR status Applicant for asylum Applicant for Cancellation of Removal or Suspension of Deportation Applicant for legalization under the Immigration Reform and Control Act Applicant for Legalization under the LIFE Act Applicant/recipient for Temporary Protected Status Applicant for withholding of deportation or removal Applicant/recipient for Special Immigrant Juvenile status Citizen of Micronesia, the Marshall Islands, or Palau Conditional Entrant Granted before 1980 Cuban/Haitian Entrant Deferred Action Status (including DACA) Deferred Enforced Departure Granted Withholding of Deportation Native American born in Canada Non-immigrant visa holder Order of Supervision Paroled into the U.S. Refugee or asylee Registry applicant Resident of American Samoa Temporary Protected Status Temporary Resident Status Victim of battery/abuse (or victim's spouse, child, or parent) Victim of trafficking (or victim's spouse, child, sibling or parent)");
        basicActions.waitForElementToBeClickable(backButton, 150);
        softAssert.assertEquals(backButton.getAttribute("value"), "< Back");
        softAssert.assertEquals(saveContinue.getAttribute("value"), "Save and Continue");
        softAssert.assertAll();
    }

    public void validateCitizenshipAndImmigrationJuvenileTextSpanish() {
        basicActions.waitForElementToBePresent(pageHeaderLpr,40);
        softAssert.assertEquals(pageHeaderLpr.getText(), "Ciudadan\u00EDa y estatus migratorio: "+ SharedData.getPrimaryMember().getFirstName()+" "+SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(pageTitleLpr.getText(), "Estatus Migratorio");
        softAssert.assertEquals(helpUnderstandtext.getText(), "Ayuda para entender esta p\u00E1gina");
        softAssert.assertEquals(lprNeedMoreInfo.getText(), "Al parecer, necesitamos m\u00E1s informaci\u00F3n sobre su estatus migratorio");
        softAssert.assertEquals(lprQuestions.get(0).getText(), "\u00BFTiene la Residencia permanente legal (tarjeta verde)?");
        basicActions.waitForElementListToBePresent(lprQuestions, 40);
        rdobtnLprYes.click();
        softAssert.assertEquals((lprQuestions.get(1).getText()), "Antes de ser residente permanente legal, \u00BFalguno de los siguientes estatus migratorios aplicaban para usted?");
        softAssert.assertEquals(immigrationStatusLPRYes.getText().trim().replaceAll("\\s+", " "), "Seleccione Afgano o iraqu\u00ED titular de una visa especial (SIV) Afgano o Ucraniano en libertad condicional humanitaria Ciudadano de Micronesia, de las Islas Marshall y Palau Ind\u00EDgena norteamericano nacido en Canad\u00E1 Participante cubano o haitiano Refugiado o asilado Solicitante o sujeto de estatus especial para inmigrantes j\u00F3venes Suspensi\u00F3n de deportaci\u00F3n otorgada V\u00EDctima de tr\u00E1fico (o es c\u00F3nyuge, hijo/a, hermano/a o padre/madre de la v\u00EDctima) Ninguno de los anteriores se aplican a m\u00ED");
        rdobtnLprNo.click();
        softAssert.assertEquals(immigrationStatusLPRNo.getText().trim().replaceAll("\\s+", " "), "Seleccione Afgano o iraqu\u00ED titular de una visa especial de inmigrante (SIV) Afgano o Ucraniano en libertad condicional humanitaria Ciudadano de Micronesia, de las Islas Marshall y Palau En libertad condicional otorgada en EE. UU. Estatus de Acci\u00F3n Diferida (incluido DACA) Estatus de residente temporal Estatus temporalmente protegido Expulsi\u00F3n forzada aplazada Ind\u00EDgena norteamericano nacido en Canad\u00E1 Orden administrativa de aplazamiento de traslado Orden de supervisi\u00F3n Participante condicional: estatus otorgado antes de 1980 Participante cubano o haitiano Refugiado o asilado Residente de Samoa Americana Solicitante de asilo Solicitante de cambio de estatus a residente permanente legal (LPR) Solicitante de cancelaci\u00F3n de traslado o de suspensi\u00F3n de deportaci\u00F3n Solicitante o sujeto de Estatus temporalmente protegido Solicitante de legalizaci\u00F3n seg\u00FAn la Ley de Reforma y Control de la Inmigraci\u00F3n Solicitante de Legalizaci\u00F3n seg\u00FAn la ley LIFE Solicitante de registro Solicitante de suspensi\u00F3n de deportaci\u00F3n o traslado Solicitante o sujeto de estatus especial para inmigrantes j\u00F3venes Suspensi\u00F3n de deportaci\u00F3n otorgada Titular de visa no inmigrante V\u00EDctima de tr\u00E1fico (o es c\u00F3nyuge, hijo/a, hermano/a o padre/madre de la v\u00EDctima) V\u00EDctima de violencia/abuso (o es c\u00F3nyuge, hijo/a o padre/madre de la v\u00EDctima)");
        softAssert.assertEquals(backButton.getAttribute("value"), "< Atr\u00E1s");
        softAssert.assertEquals(saveContinue.getAttribute("value"),  "Guardar y Continuar");
        softAssert.assertAll();
    }

    public void VerifyCitizenshipAndImmigrationforParoledInToUSTextEnglish() {
        basicActions.waitForElementToBePresent(paroleePageHeader,40);
        softAssert.assertEquals(paroleePageHeader.getText(), "Citizenship and Immigration Status: "+ SharedData.getPrimaryMember().getFirstName()+" "+SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(paroleeHelpUnderstandText.getText(), "Help me understand this page");
        softAssert.assertEquals(paroleePageTitle.getText(), "Immigration Status");
        softAssert.assertEquals(ParoleeNeedMoreInfo.getText(), "It looks like we need more information about your immigration status");
        softAssert.assertEquals(lprQuestions.get(0).getText(), "What is the grant date of your parolee status?");
        softAssert.assertEquals(grantDateInputField.getAttribute("placeholder"), "mm/dd/yyyy");
        basicActions.waitForElementToBeClickable(backButton, 150);
        softAssert.assertEquals(backButton.getAttribute("value"), "< Back");
        softAssert.assertEquals(saveContinue.getAttribute("value"), "Save and Continue");
        softAssert.assertAll();
    }
    public void VerifyCitizenshipAndImmigrationforParoledInToUSTextSpanish() {
        basicActions.waitForElementToBePresent(paroleePageHeader, 40);
        softAssert.assertEquals(paroleePageHeader.getText(), "Ciudadan\u00EDa y estatus migratorio: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(paroleeHelpUnderstandText.getText(), "Ayuda para entender esta p\u00E1gina");
        softAssert.assertEquals(paroleePageTitle.getText(), "Estatus Migratorio");
        softAssert.assertEquals(ParoleeNeedMoreInfo.getText(), "Al parecer, necesitamos más información sobre su estatus migratorio");
        softAssert.assertEquals(lprQuestions.get(0).getText(), "¿Cuál es la fecha en la que se le otorgó su estatus de libertad condicional?");
        softAssert.assertEquals(grantDateInputField.getAttribute("placeholder"), "mm/dd/yyyy");
        basicActions.waitForElementToBeClickable(backButton, 150);
        softAssert.assertEquals(backButton.getAttribute("value"), "< Atr\u00E1s");
        softAssert.assertEquals(saveContinue.getAttribute("value"),  "Guardar y Continuar");
        softAssert.assertAll();
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

    public void inputGrantDate(String grantDate) {
        basicActions.waitForElementToBePresent(grantDateInputField, 10);
        grantDateInputField.sendKeys(grantDate);
    }

    public void VerifyCitizenshipAndImmigrationTextOnParoledIntoTheUSPage(String language) {
        switch (language) {
            case "English":
                VerifyCitizenshipAndImmigrationforParoledInToUSTextEnglish();
                break;
            case "Spanish":
                VerifyCitizenshipAndImmigrationforParoledInToUSTextSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }
}
