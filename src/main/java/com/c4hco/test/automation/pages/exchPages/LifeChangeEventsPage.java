package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    private void validateTheVerbiageEn() {
        basicActions.assertContainsText(textReportLifeChangeHeader.getText(), "Report a life change");
        basicActions.assertContainsText(textLifeChangeSubTitle.getText(), "Select any life change event you or someone in your household has experienced within the past 60 days. The loss of other health insurance, including Health First Colorado or Child Health Plans Plus, can be reported up to 60 days before you lose coverage. Members of federally recognized tribes and Alaska natives can enroll in coverage through Connect for Health Colorado anytime of the year.");
        basicActions.assertContainsText(lnkHelpLink.getText(), "Help me understand this page");
        basicActions.assertContainsText(textLceLable.get(0).getText(), "Birth/Adoption/Foster Care/Court order");
        basicActions.assertContainsText(textLceLable.get(1).getText(), "Pregnancy");
        basicActions.assertContainsText(textLceLable.get(2).getText(), "Got married/divorced");
        basicActions.assertContainsText(textLceLable.get(3).getText(), "Will lose/lost health insurance or my household's annual income meets special requirements");
        basicActions.assertContainsText(textLceLable.get(4).getText(), "Gain of eligible immigration status");
        basicActions.assertContainsText(textLceLable.get(5).getText(), "Gain of American Indian/Alaska Native status");
        basicActions.assertContainsText(textLceLable.get(6).getText(), "Moved to Colorado");
        basicActions.assertContainsText(textLceLable.get(7).getText(), "Change of Incarceration Status");
        basicActions.assertContainsText(textLceLable.get(8).getText(), "Other");
        basicActions.assertContainsText(textLceLable.get(9).getText(), "None of these");
        btnHelpExpand.click();
        basicActions.waitForElementToBePresent(textHelpDrawerHeader, 30);
        basicActions.assertContainsText(textHelpDrawerHeader.getText(), "Help");
        basicActions.assertContainsText(textHelpDrawerTitle.getText(), "Qualified Life Change Event");
        basicActions.assertContainsText(textHelpDrawerOverview.getText(), "Overview");
        basicActions.assertContainsText(textHelpDrawerBody.getText(), "Select any Life Change Event that happened to you or someone in your household within the past 60 days. The loss of other health insurance can be reported up to 60 days before you lose your other insurance.");
        basicActions.assertContainsText(textHelpDrawerFooter.getText(), "Need more help?");
        basicActions.assertContainsText(lnkHelpDrawerContactUs.getText(), "Contact us");
    }

    private void validateTheVerbiageEs() {
        basicActions.assertContainsText(textReportLifeChangeHeader.getText(), "Reportar un cambio de vida");
        basicActions.assertContainsText(textLifeChangeSubTitle.getText(), "Seleccione los eventos de vida calificados que usted o alguien de su familia haya tenido en los \u00faltimos 60 d\u00edas. Se puede reportar la p\u00e9rdida de seguro de salud, incluyendo Health First Colorado o Child Health Plan Plus, hasta 60 d\u00edas antes de que pierda la cobertura. Los miembros de las tribus reconocidas a nivel federal o los nativos de Alaska pueden inscribirse en la cobertura a trav\u00e9s de Connect for Health Colorado en cualquier momento del a\u00f1o.");
        basicActions.assertContainsText(lnkHelpLink.getText(), "Ayuda para entender esta p\u00e1gina");
        basicActions.assertContainsText(textLceLable.get(0).getText(), "Nacimiento/Adopci\u00f3n/Colocaci\u00f3n en hogar sustituto/Mandato judicial");
        basicActions.assertContainsText(textLceLable.get(1).getText(), "Embarazo");
        basicActions.assertContainsText(textLceLable.get(2).getText(), "Matrimonio/Divorcio");
        basicActions.assertContainsText(textLceLable.get(3).getText(), "Perder\u00e9 o perd\u00ed el seguro de salud o mi ingreso familiar anual cumple con los requisitos especiales");
        basicActions.assertContainsText(textLceLable.get(4).getText(), "Obtenci\u00f3n de estatus migratorio elegible");
        basicActions.assertContainsText(textLceLable.get(5).getText(), "Obtenci\u00f3n de estatus tribal de ind\u00edgena norteamericano o nativo de Alaska");
        basicActions.assertContainsText(textLceLable.get(6).getText(), "Mudanza a Colorado");
        basicActions.assertContainsText(textLceLable.get(7).getText(), "Cambio en el estado de encarcelamiento");
        basicActions.assertContainsText(textLceLable.get(8).getText(), "Otro");
        basicActions.assertContainsText(textLceLable.get(9).getText(), "Ninguno de estos");
        btnHelpExpand.click();
        basicActions.waitForElementToBePresent(textHelpDrawerHeader, 30);
        basicActions.assertContainsText(textHelpDrawerHeader.getText(), "Ayuda");
        basicActions.assertContainsText(textHelpDrawerTitle.getText(), "Evento de cambio de vida calificado");
        basicActions.assertContainsText(textHelpDrawerOverview.getText(), "Resumen");
        basicActions.assertContainsText(textHelpDrawerBody.getText(), "Seleccione el evento de vida calificado que usted o alguien de su familia haya tenido en los \u00faltimos 60 d\u00edas. La p\u00e9rdida de otro seguro de salud se puede reportar hasta 60 d\u00edas antes de que lo pierda.");
        basicActions.assertContainsText(textHelpDrawerFooter.getText(), "\u00bfNecesitas m\u00e1s ayuda?");
        basicActions.assertContainsText(lnkHelpDrawerContactUs.getText(), "Cont\u00e1ctenos");
    }
}
