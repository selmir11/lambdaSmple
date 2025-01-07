package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LifeChangeEventsPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public LifeChangeEventsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".input-checkbox")
    List<WebElement> lceInputCheckbox;

    @FindBy(css = ".label-checkbox")
    List<WebElement> textLceLable;

    @FindBy(id = "continueButton")
    List<WebElement> saveAndContinueButton;

    @FindBy(css = "div.col-sm-6.text-right > input")
    WebElement saveAndContinueOnlyButton;

    @FindBy(css = "h1.c4PageHeader")
    WebElement textReportLifeChangeHeader;

    @FindBy (css = "h1.c4PageSubTitle")
    WebElement textLifeChangeSubTitle;

    @FindBy (css = "#overviewButton")
    WebElement lnkHelpLink;

    @FindBy(css = "#helpButtonExpand")
    WebElement btnHelpExpand;

    @FindBy(css = ".drawer-heading h4")
    WebElement textHelpDrawerHeader;

    @FindBy(css = "h2")
    WebElement textHelpDrawerTitle;

    @FindBy (css = "#overview b p")
    WebElement textHelpDrawerOverview;

    @FindBy(css = "#overview > p")
    WebElement textHelpDrawerBody;

    @FindBy(css = "#LossOfCovg b p")
    WebElement textHelpDrawerLossOfCoverage;

    @FindBy(css = "#LossOfCovg > p:nth-of-type(1)")
    WebElement textHelpDrawerLossOfCoveragePleaseVisit;

    @FindBy(css = "#LossOfCovg > p:nth-of-type(2) > a")
    WebElement lnkHelpDrawerWhenCanIBuyInsurance;

    // Second paragraph immediately under the <li> element
    @FindBy(css = "#LossOfCovg > p:nth-of-type(3)")
    WebElement textHelpDrawerFederalPovertyLevel;

    @FindBy(css = "#LossOfCovg span > p:nth-of-type(1) > a")
    WebElement lnkHelpDrawerFederalPovertyLevel;

    @FindBy(css = "#LossOfCovg span > p:nth-of-type(2)")
    WebElement textHelpDrawerIncomeLimitByHouseholdSize;

    @FindBy(css = "#LossOfCovg span div p")
    List <WebElement> textHelpDrawerIncomeLimitByHouseholdSizeDiv;

    @FindBy(css = ".drawer-footer p b")
    WebElement textHelpDrawerFooter;

    @FindBy(css = ".drawer-footer p a")
    WebElement lnkHelpDrawerContactUs;

    @FindBy(css = "#LossOfCovgButton i")
    WebElement iconHelp;

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    public void selectLCE(String lceOption){
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementToBePresent(saveAndContinueOnlyButton,20);
        switch(lceOption){
            case "Birth":
                lceInputCheckbox.get(0).click();
                break;
            case "Pregnancy":
                lceInputCheckbox.get(1).click();
                break;
            case "Marriage":
                lceInputCheckbox.get(2).click();
                break;
            case "LostCoverage":
                lceInputCheckbox.get(3).click();
                break;
            case "GainedLawfulPresence":
                lceInputCheckbox.get(4).click();
                break;
            case "GainedAmericanIndianAlaskaNative":
                lceInputCheckbox.get(5).click();
                break;
            case "MovedToColorado":
                lceInputCheckbox.get(6).click();
                break;
            case "Change of Incarceration Status":
                lceInputCheckbox.get(7).click();
                break;
            case "Other":
                lceInputCheckbox.get(8).click();
                break;
            case "NoneOfThese":
                lceInputCheckbox.get(9).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + lceOption);
            }

        if (SharedData.getEnv().equals("qa")) {
            saveAndContinueButton.get(0).click();
        } else {
            basicActions.scrollToElement(saveAndContinueOnlyButton);
            saveAndContinueOnlyButton.click();
        }
    }

    public void clickContinueWithApplication(){
        saveAndContinueButton.get(1).click();
    }

    public void validateTheVerbiageOnReportALifeChangePage(String language) {
        switch (language){
            case "English":
                validateTheVerbiageEn();
                break;
            case "Spanish":
                validateTheVerbiageEs();
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    public void validateTheVerbiageEn() {
        // Initialize a SoftAssert object
        SoftAssert softAssert = new SoftAssert();

        // Asserting each text element using assertEquals
        softAssert.assertEquals(textReportLifeChangeHeader.getText(), "Report a life change", "Report a life change header text mismatch");
        softAssert.assertEquals(textLifeChangeSubTitle.getText(), "Select any life change event you or someone in your household has experienced within the past 60 days. The loss of other health insurance, including Health First Colorado or Child Health Plans Plus, can be reported up to 60 days before you lose coverage. Members of federally recognized tribes and Alaska natives can enroll in coverage through Connect for Health Colorado anytime of the year.", "Life change subtitle text mismatch");
        softAssert.assertEquals(lnkHelpLink.getText(), "Help me understand this page", "Help me understand this page link text mismatch");
        softAssert.assertEquals(textLceLable.get(0).getText(), "Birth/Adoption/Foster Care/Court order", "Birth/Adoption/Foster Care/Court order label text mismatch");
        softAssert.assertEquals(textLceLable.get(1).getText(), "Pregnancy", "Pregnancy label text mismatch");
        softAssert.assertEquals(textLceLable.get(2).getText(), "Got married/divorced", "Got married/divorced label text mismatch");
        softAssert.assertEquals(textLceLable.get(3).getText(), "Will lose/lost health insurance or my household's annual income meets special requirements", "Will lose/lost health insurance label text mismatch");
        softAssert.assertEquals(textLceLable.get(4).getText(), "Gain of eligible immigration status", "Gain of eligible immigration status label text mismatch");
        softAssert.assertEquals(textLceLable.get(5).getText(), "Gain of American Indian/Alaska Native status", "Gain of American Indian/Alaska Native status label text mismatch");
        softAssert.assertEquals(textLceLable.get(6).getText(), "Moved to Colorado", "Moved to Colorado label text mismatch");
        softAssert.assertEquals(textLceLable.get(7).getText(), "Change of Incarceration Status", "Change of Incarceration Status label text mismatch");
        softAssert.assertEquals(textLceLable.get(8).getText(), "Other", "Other label text mismatch");
        softAssert.assertEquals(textLceLable.get(9).getText(), "None of these", "None of these label text mismatch");

        // Expand help and validate its content
        btnHelpExpand.click();
        basicActions.waitForElementToBePresent(textHelpDrawerHeader, 30);
        softAssert.assertEquals(textHelpDrawerHeader.getText(), "Help", "Help drawer header text mismatch");
        softAssert.assertEquals(textHelpDrawerTitle.getText(), "Qualified Life Change Event", "Help drawer title text mismatch");
        softAssert.assertEquals(textHelpDrawerOverview.getText(), "Overview", "Help drawer overview text mismatch");
        softAssert.assertEquals(textHelpDrawerBody.getText(), "Select any Life Change Event that happened to you or someone in your household within the past 60 days. The loss of other health insurance can be reported up to 60 days before you lose your other insurance.", "Help drawer body text mismatch");
        softAssert.assertEquals(textHelpDrawerFooter.getText(), "Need more help?", "Help drawer footer text mismatch");
        softAssert.assertEquals(lnkHelpDrawerContactUs.getText(), "Contact us", "Help drawer contact us link text mismatch");

        // Verify all assertions
        softAssert.assertAll();
    }

    private void validateTheVerbiageEs() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(textReportLifeChangeHeader.getText(), "Reportar un cambio de vida", "Reportar un cambio de vida text not found");
        softAssert.assertEquals(textLifeChangeSubTitle.getText(), "Seleccione los eventos de vida calificados que usted o alguien de su familia haya tenido en los \u00faltimos 60 d\u00edas. Se puede reportar la p\u00e9rdida de seguro de salud, incluyendo Health First Colorado o Child Health Plan Plus, hasta 60 d\u00edas antes de que pierda la cobertura. Los miembros de las tribus reconocidas a nivel federal o los nativos de Alaska pueden inscribirse en la cobertura a trav\u00e9s de Connect for Health Colorado en cualquier momento del a\u00f1o.", "Life change subtitle mismatch");
        softAssert.assertEquals(lnkHelpLink.getText(), "Ayuda para entender esta p\u00e1gina", "Ayuda para entender esta página link text mismatch");
        softAssert.assertEquals(textLceLable.get(0).getText(), "Nacimiento/Adopci\u00f3n/Colocaci\u00f3n en hogar sustituto/Mandato judicial", "Nacimiento/Adopción/Colocación en hogar sustituto/Mandato judicial text mismatch");
        softAssert.assertEquals(textLceLable.get(1).getText(), "Embarazo", "Embarazo text mismatch");
        softAssert.assertEquals(textLceLable.get(2).getText(), "Matrimonio/Divorcio", "Matrimonio/Divorcio text mismatch");
        softAssert.assertEquals(textLceLable.get(3).getText(), "Perder\u00e9 o perd\u00ed el seguro de salud o mi ingreso familiar anual cumple con los requisitos especiales", "Perderé o perdí el seguro de salud text mismatch");
        softAssert.assertEquals(textLceLable.get(4).getText(), "Obtenci\u00f3n de estatus migratorio elegible", "Obtención de estatus migratorio elegible text mismatch");
        softAssert.assertEquals(textLceLable.get(5).getText(), "Obtenci\u00f3n de estatus tribal de ind\u00edgena norteamericano o nativo de Alaska", "Obtención de estatus tribal de indígena norteamericano o nativo de Alaska text mismatch");
        softAssert.assertEquals(textLceLable.get(6).getText(), "Mudanza a Colorado", "Mudanza a Colorado text mismatch");
        softAssert.assertEquals(textLceLable.get(7).getText(), "Cambio en el estado de encarcelamiento", "Cambio en el estado de encarcelamiento text mismatch");
        softAssert.assertEquals(textLceLable.get(8).getText(), "Otro", "Otro text mismatch");
        softAssert.assertEquals(textLceLable.get(9).getText(), "Ninguno de estos", "Ninguno de estos text mismatch");

        btnHelpExpand.click();
        basicActions.waitForElementToBePresent(textHelpDrawerHeader, 30);

        softAssert.assertEquals(textHelpDrawerHeader.getText(), "Ayuda", "Ayuda text mismatch");
        softAssert.assertEquals(textHelpDrawerTitle.getText(), "Evento de cambio de vida calificado", "Evento de cambio de vida calificado text mismatch");
        softAssert.assertEquals(textHelpDrawerOverview.getText(), "Resumen", "Resumen text mismatch");
        softAssert.assertEquals(textHelpDrawerBody.getText(), "Seleccione el evento de vida calificado que usted o alguien de su familia haya tenido en los \u00faltimos 60 d\u00edas. La p\u00e9rdida de otro seguro de salud se puede reportar hasta 60 d\u00edas antes de que lo pierda.", "Help drawer body text mismatch");
        softAssert.assertEquals(textHelpDrawerFooter.getText(), "\u00bfNecesitas m\u00e1s ayuda?", "Need more help? text mismatch");
        softAssert.assertEquals(lnkHelpDrawerContactUs.getText(), "Cont\u00e1ctenos", "Contáctenos text mismatch");

        softAssert.assertAll();
    }

    public void validateTheHeaderOnReportALifeChangePage(String language) {
        switch (language){
            case "English":
                validateTheHeaderEn();
                break;
            case "Spanish":
                validateTheHeaderEs();
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    public void validateTheHeaderEn() {
        basicActions.waitForElementToBePresent(textReportLifeChangeHeader,10);
        softAssert.assertEquals(textReportLifeChangeHeader.getText(), "Tell us about life changes");
        softAssert.assertAll();
    }

    private void validateTheHeaderEs() {
        basicActions.waitForElementToBePresent(textReportLifeChangeHeader,10);
        softAssert.assertEquals(textReportLifeChangeHeader.getText(), "Inf\u00F3rmenos sobre los cambios importantes en la vida");
        softAssert.assertAll();
    }

    public void clickHelpDrawerIcon() {
        btnHelpExpand.click();
    }

    public void validateHelpDrawerText(String language, List<String> data) {
        switch (language){
            case "English", "Spanish":
                validateHelpDrawerText(data);
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private void validateHelpDrawerText(List<String> data) {
        basicActions.waitForElementToBePresent(textHelpDrawerHeader, 30);

        softAssert.assertEquals(textHelpDrawerHeader.getText(), data.get(0), "Help drawer header text mismatch");
        softAssert.assertEquals(textHelpDrawerTitle.getText(), data.get(1), "Help drawer title text mismatch");
        softAssert.assertEquals(textHelpDrawerOverview.getText(), data.get(2), "Help drawer overview text mismatch");
        softAssert.assertEquals(textHelpDrawerBody.getText(), data.get(3), "Help drawer body text mismatch");
        softAssert.assertEquals(textHelpDrawerLossOfCoverage.getText(), data.get(4), "Help drawer loss of coverage text mismatch");
        softAssert.assertEquals(textHelpDrawerLossOfCoveragePleaseVisit.getText(), data.get(5), "Help drawer loss of coverage please visit text mismatch");
        softAssert.assertEquals(lnkHelpDrawerWhenCanIBuyInsurance.getText(), data.get(6), "Help drawer when can I buy insurance link text mismatch");
        softAssert.assertEquals(textHelpDrawerFederalPovertyLevel.getText(), data.get(7), "Help drawer federal poverty level text mismatch");
        softAssert.assertEquals(lnkHelpDrawerFederalPovertyLevel.getText(), data.get(8), "Help drawer federal poverty level link text mismatch");
        softAssert.assertEquals(textHelpDrawerIncomeLimitByHouseholdSize.getText(), data.get(9), "Help drawer income limit by household size text mismatch");
        softAssert.assertEquals(textHelpDrawerIncomeLimitByHouseholdSizeDiv.get(0).getText(), data.get(10), "Help drawer income limit 1 person text mismatch");
        softAssert.assertEquals(textHelpDrawerIncomeLimitByHouseholdSizeDiv.get(1).getText(), data.get(11), "Help drawer income limit 2 person text mismatch");
        softAssert.assertEquals(textHelpDrawerIncomeLimitByHouseholdSizeDiv.get(2).getText(), data.get(12), "Help drawer income limit 3 person text mismatch");
        softAssert.assertEquals(textHelpDrawerIncomeLimitByHouseholdSizeDiv.get(3).getText(), data.get(13), "Help drawer income limit 4 person text mismatch");
        softAssert.assertEquals(textHelpDrawerIncomeLimitByHouseholdSizeDiv.get(4).getText(), data.get(14), "Help drawer income limit 5 person text mismatch");
        softAssert.assertEquals(textHelpDrawerIncomeLimitByHouseholdSizeDiv.get(5).getText(), data.get(15), "Help drawer income limit 6 person text mismatch");
        softAssert.assertEquals(textHelpDrawerIncomeLimitByHouseholdSizeDiv.get(6).getText(), data.get(16), "Help drawer income limit 7 person text mismatch");
        softAssert.assertEquals(textHelpDrawerIncomeLimitByHouseholdSizeDiv.get(7).getText(), data.get(17), "Help drawer income limit 8 person text mismatch");
        softAssert.assertEquals(textHelpDrawerIncomeLimitByHouseholdSizeDiv.get(8).getText(), data.get(18), "Help drawer income limit 9 person text mismatch");
        softAssert.assertEquals(textHelpDrawerIncomeLimitByHouseholdSizeDiv.get(9).getText(), data.get(19), "Help drawer income limit 10 person text mismatch");
        softAssert.assertEquals(textHelpDrawerFooter.getText(), data.get(20), "Help drawer footer text mismatch");
        softAssert.assertEquals(lnkHelpDrawerContactUs.getText(), data.get(21), "Help drawer contact us link text mismatch");

        softAssert.assertAll();

    }

    public void clickHelpIconNextToSpecialRequirement() {
        basicActions.waitForElementToBePresent(iconHelp, 10);
        iconHelp.click();
    }
}
