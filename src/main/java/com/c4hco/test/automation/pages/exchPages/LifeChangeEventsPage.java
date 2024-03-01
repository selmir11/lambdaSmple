package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LifeChangeEventsPage {

    private BasicActions basicActions;

    public LifeChangeEventsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".input-checkbox")
    List<WebElement> lceInputCheckbox;

    @FindBy(css = ".label-checkbox")
    List<WebElement> textLceLable;

    @FindBy(id = "continueButton")
    WebElement saveAndContinueButton;

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

    @FindBy(css = ".drawer-footer p b")
    WebElement textHelpDrawerFooter;

    @FindBy(css = ".drawer-footer p a")
    WebElement lnkHelpDrawerContactUs;

    public void selectLCE(String lceOption){
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
                case "MovedToColorado":
                    lceInputCheckbox.get(6).click();
                    break;
            default:
                throw new IllegalArgumentException("Invalid option: " + lceOption);
            }
        saveAndContinueButton.click();
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
}
