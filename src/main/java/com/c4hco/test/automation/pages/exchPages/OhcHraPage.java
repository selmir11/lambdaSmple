package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.List;



public class OhcHraPage {
    BasicActions basicActions;
    Actions action;
    SoftAssert softAssert = new SoftAssert();

    public OhcHraPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        action = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }


    @FindBy(css = ".container .header-1")
    WebElement ohcHeader;

    @FindBy(css = ".container .header-2")
    WebElement ohcHraHeader;

    @FindBy(css = ".header-3 .clickable")
    WebElement helpMeLink;

    @FindBy(css = "div.ohc-container.body-text-1 > p > span")
    WebElement whenYouPayTxt;

    @FindBy(css = "div > label")
    List<WebElement> hraQuestionTxt;

    @FindBy(css = "lib-error-msg > div")
    List<WebElement> hdrError;

    @FindBy(css = "#ELIG-Ohc-Hra-planYear-container span")
    WebElement planYearError;

    @FindBy(css = "#ELIG-Ohc-Hra-planYear")
    WebElement planYeardpd;

    @FindBy(css = "#ELIG-Ohc-Hra-employerContribution-container span")
    WebElement amountError;

    @FindBy(css = "#ELIG-Ohc-Hra-employerContribution")
    WebElement amountInput;

    @FindBy(css = "#ELIG-Ohc-Hra-hraType-container div > span")
    WebElement typeError;

    @FindBy(id = "ELIG-Ohc-Hra-hraType-Hra.QSEHRAButton")
    WebElement hraQsehraBtn;

    @FindBy(id = "ELIG-Ohc-Hra-hraType-Hra.ICHRAButton")
    WebElement hraIchraBtn;

    @FindBy(css = "div.ohc-container > div > p")
    WebElement ifMayTxt;

    @FindBy(css = "#ELIG-Ohc-Hra-employerContributionOptout-container div > span")
    WebElement optOutError;

    @FindBy(css = "#ELIG-Ohc-Hra-employerContributionOptout-container div button")
    List<WebElement> optOutBtn;

    @FindBy(css = "#Ohc-Hra-GoBack")
    WebElement goBackBtn;

    @FindBy(css = "#Ohc-Hra-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(css = ".header-3.content-center > a")
    WebElement helpLnk;

    @FindBy(css = "lib-help-icon a")
    List<WebElement> helpIcons;

    @FindBy(css = "div.desktop-help > div > span.c4-text-body-200")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = "div.desktop-help > div > span.title.c4-type-header-sm")
    WebElement helpDrawerHeaderMedicare;

    @FindBy(css = "div.help-main-content.ng-star-inserted > strong")
    WebElement helpDrawerMainHeaders;

    @FindBy(css = "div.help-main-content.ng-star-inserted > strong:nth-child(1)")
    WebElement helpDrawerOverviewHeader;

    @FindBy(css = "div.help-main-content.ng-star-inserted > strong:nth-child(4)")
    WebElement helpDrawerEmployerHeader;

    @FindBy(css = "div.help-main-content.ng-star-inserted > strong:nth-child(7)")
    WebElement helpDrawerOptOutHeader;

    @FindBy(css = "drawer-text-content p")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = "div.help-main-content.ng-star-inserted > p:nth-child(3)")
    WebElement helpDrawerBodyParagraph1;

    @FindBy(css = "div.help-main-content.ng-star-inserted > p:nth-child(6)")
    WebElement helpDrawerBodyParagraph2;

    @FindBy(css = "div.help-main-content.ng-star-inserted > p:nth-child(9)")
    WebElement helpDrawerBodyParagraph3;

    @FindBy(css = "div.help-footer.ng-star-inserted")
    WebElement helpDrawerFooter;

    @FindBy(css = "div.help-footer.ng-star-inserted > a")
    WebElement helpDrawerContactUsLink;

    @FindBy(xpath = "//div[@class='div-input-margin-top-2 ng-star-inserted']//p")
    WebElement ICHRAErrMsg1;

    @FindBy(xpath = "//div[@class='div-input-margin-top-2 ng-star-inserted']//div//div")
    WebElement ICHRAErrMsg2;



    public void clickSaveAndContinue() {
        basicActions.waitForElementToBePresent(ohcHeader, 90);
        basicActions.waitForElementToBePresent(ohcHraHeader, 90);
        basicActions.waitForElementToBePresent(whenYouPayTxt, 90);
        basicActions.waitForElementToBePresent(planYeardpd, 90);
        basicActions.waitForElementToBePresent(amountInput, 90);
        basicActions.waitForElementToBePresent(hraQsehraBtn, 90);
        basicActions.waitForElementToBePresent(hraIchraBtn, 90);
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 90);
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
    }

    public void clickGoBack() {
        basicActions.waitForElementToBeClickable(goBackBtn, 20);
        goBackBtn.click();
    }

    public void clickYear() {
        basicActions.waitForElementToBePresent(planYeardpd, 20);
        planYeardpd.sendKeys(basicActions.getCurrYear());
    }

    public void enterAmount(String amount) {
        basicActions.waitForElementToBePresent(amountInput, 20);
        amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        amountInput.sendKeys(amount);
        amountInput.sendKeys(Keys.TAB);
    }

    public void selectHraType(String type) {
        basicActions.waitForElementToBePresent(ohcHeader, 90);
        basicActions.waitForElementToBePresent(ohcHraHeader, 90);
        basicActions.waitForElementToBePresent(whenYouPayTxt, 90);
        basicActions.waitForElementToBePresent(planYeardpd, 90);
        basicActions.waitForElementToBePresent(amountInput, 90);
        basicActions.waitForElementToBePresent(hraQsehraBtn, 90);
        basicActions.waitForElementToBePresent(hraIchraBtn, 90);
        basicActions.scrollToElement(hraIchraBtn);
        basicActions.scrollToElement(hraQsehraBtn);
        switch (type) {
            case "ICHRA":
                hraIchraBtn.click();
                break;
            case "QSEHRA":
                hraQsehraBtn.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + type);
        }
    }

    public void selectOptOut(String aptc) {
        basicActions.waitForElementListToBePresent(optOutBtn, 20);
        switch (aptc) {
            case "Yes":
                optOutBtn.get(0).click();
                break;
            case "No":
                optOutBtn.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + aptc);
        }
    }

    public void clickHelpIcon(String label) {
        basicActions.waitForElementListToBePresent(helpIcons, 10);
        switch (label) {
            case "Help me understand":
                helpLnk.click();
                break;
            case "employer contribution":
                helpIcons.get(0).click();
                break;
            case "opt out":
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


    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    public void verifyHeadersHraOhcPage(String language) {
        switch (language) {
            case "English":
                verifyHeadersHraOhcPageEnglish();
                break;
            case "Spanish":
                verifyHeadersHraOhcPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersHraOhcPageEnglish() {
        basicActions.waitForElementToBePresentWithRetries(ohcHeader, 60);
        basicActions.waitForElementToBePresentWithRetries(ohcHraHeader, 60);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(), "Health Reimbursement Arrangement (HRA) offered through an employer");
        softAssert.assertAll();
    }

    public void verifyHeadersHraOhcPageSpanish() {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        basicActions.waitForElementToBePresent(ohcHraHeader, 15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(), "Las Provisiones de reembolso de salud (HRA) se ofrecen a trav\u00E9s de su empleador");
        softAssert.assertAll();
    }

    public void verifyHraData(String dataToVerify, String expectedIncome, String language) {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        switch (language) {
            case "English":
                verifyHraDataEnglish(dataToVerify, expectedIncome);
                break;
            case "Spanish":
                verifyHraDataSpanish(dataToVerify, expectedIncome);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHraDataEnglish(String dataToVerify, String expectedIncome) {
        basicActions.waitForElementToBePresentWithRetries(ohcHeader, 15);
        switch (dataToVerify) {
            case "Initial Page":
                verifyHraPageInitialDataEnglish(expectedIncome);
                break;
            case "Opt Out":
                verifyHraPageInitialDataEnglish(expectedIncome);
                verifyHraPageOptOutDataEnglish();
                break;
            case "Initial Page Secondary":
                verifyHraPageInitialSecondaryDataEnglish(expectedIncome);
                break;
            case "Opt Out Secondary":
                verifyHraPageInitialSecondaryDataEnglish(expectedIncome);
                verifyHraPageOptOutSecondaryDataEnglish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        verifyHraContinueAndgoBackBtnsEnglish();
        softAssert.assertAll();
    }

    public void verifyHraDataSpanish(String dataToVerify, String expectedIncome) {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        switch (dataToVerify) {
            case "Initial Page":
                verifyHraPageInitialDataSpanish(expectedIncome);
                break;
            case "Opt Out":
                verifyHraPageInitialDataSpanish(expectedIncome);
                verifyHraPageOptOutDataSpanish();
                break;
            case "Initial Page Secondary":
                verifyHraPageInitialSecondaryDataSpanish(expectedIncome);
                break;
            case "Opt Out Secondary":
                verifyHraPageInitialSecondaryDataSpanish(expectedIncome);
                verifyHraPageOptOutSecondaryDataSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        verifyHraContinueAndgoBackBtnsSpanish();
        softAssert.assertAll();
    }

    public void verifyHraPageInitialDataEnglish(String expectedIncome) {
        basicActions.waitForElementToBePresentWithRetries(ohcHeader, 15);
        basicActions.waitForElementToBePresentWithRetries(ohcHraHeader, 15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(), "Health Reimbursement Arrangement (HRA) offered through an employer");
        softAssert.assertEquals(helpMeLink.getText(), "Help me understand this page");
        softAssert.assertEquals(whenYouPayTxt.getText(), "When you pay for your health insurance using a Health Reimbursement Arrangement (HRA) provided through your employer, you may be required to buy a plan outside of Connect for Health Colorado. Confirm with your employer whether you have a salary reduction arrangement, as it could affect your ability to sign up for a plan through our Marketplace.");
        softAssert.assertEquals(hraQuestionTxt.get(0).getText(), "Select the plan year for your HRA coverage.");
        softAssert.assertEquals(planYeardpd.getText(), "Select a year\n2025");
        softAssert.assertEquals(hraQuestionTxt.get(1).getText(), "Enter the amount your employer contributes each month to an HRA for your coverage.");
        softAssert.assertEquals(amountInput.getAttribute("value"), expectedIncome);
        softAssert.assertEquals(hraQuestionTxt.get(2).getText(), "What type of HRA is your employer offering?");
        softAssert.assertEquals(hraQsehraBtn.getText(), "Qualified Small Employer Health Reimbursement Arrangement (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(), "Individual Coverage Health Reimbursement Arrangement (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageInitialDataSpanish(String expectedIncome) {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(), "Las Provisiones de reembolso de salud (HRA) se ofrecen a trav\u00E9s de su empleador");
        softAssert.assertEquals(helpMeLink.getText(), "Ayuda para entender esta p\u00E1gina");
        softAssert.assertEquals(whenYouPayTxt.getText(), "Cuando paga su seguro de salud utilizando las Provisiones de reembolso de salud (HRA) proporcionadas a trav\u00E9s de su empleador, es posible que deba adquirir un plan fuera de Connect for Health Colorado. Confirme con su empleador si tiene una provisi\u00F3n de reducci\u00F3n de salario, ya que podr\u00EDa afectar su capacidad para inscribirse en un plan a trav\u00E9s del Mercado.");
        softAssert.assertEquals(hraQuestionTxt.get(0).getText(), "Seleccione el a\u00F1o del plan para su cobertura HRA.");
        softAssert.assertEquals(planYeardpd.getText(), "Selecciona un a\u00F1o\n2025");
        softAssert.assertEquals(hraQuestionTxt.get(1).getText(), "Ingrese la cantidad que aporta su empleador cada mes a las Provisiones de reembolso de salud (HRA) por su cobertura.");
        softAssert.assertEquals(amountInput.getAttribute("value"), expectedIncome);
        softAssert.assertEquals(hraQuestionTxt.get(2).getText(), "\u00BFQu\u00E9 tipo de Provisiones de reembolso de salud (HRA) ofrece su empleador?");
        softAssert.assertEquals(hraQsehraBtn.getText(), "Provisiones de reembolso de salud para peque\u00F1os empleadores calificados (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(), "Provisiones de reembolso de salud de cobertura individual (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageInitialSecondaryDataEnglish(String expectedIncome) {
        basicActions.waitForElementToBePresentWithRetries(ohcHeader, 60);
        basicActions.waitForElementToBePresentWithRetries(ohcHraHeader, 60);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(), "Health Reimbursement Arrangement (HRA) offered through an employer");
        softAssert.assertEquals(helpMeLink.getText(), "Help me understand this page");
        softAssert.assertTrue(whenYouPayTxt.getText().equalsIgnoreCase("When " + SharedData.getMembers().get(0).getFullName() + " pays for their health insurance using a Health Reimbursement Arrangement (HRA) provided through their employer, they may be required to buy a plan outside of Connect for Health Colorado. Confirm with " + SharedData.getMembers().get(0).getFullName() + "'s employer whether they have a salary reduction arrangement, as it could affect their ability to sign up for a plan through our Marketplace."));
        softAssert.assertTrue(hraQuestionTxt.get(0).getText().equalsIgnoreCase("Select a plan year for " + SharedData.getMembers().get(0).getFullName() + "'s coverage."));
        softAssert.assertEquals(planYeardpd.getText(), "Select a year\n2025");
        softAssert.assertTrue(hraQuestionTxt.get(1).getText().equalsIgnoreCase("Enter the amount " + SharedData.getMembers().get(0).getFullName() + "'s employer contributes each month to an HRA for their coverage."));
        softAssert.assertEquals(amountInput.getAttribute("value"), expectedIncome);
        softAssert.assertTrue(hraQuestionTxt.get(2).getText().equalsIgnoreCase("What type of HRA is " + SharedData.getMembers().get(0).getFullName() + "'s employer offering?"));
        softAssert.assertEquals(hraQsehraBtn.getText(), "Qualified Small Employer Health Reimbursement Arrangement (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(), "Individual Coverage Health Reimbursement Arrangement (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageInitialSecondaryDataSpanish(String expectedIncome) {
        basicActions.waitForElementToBePresentWithRetries(ohcHeader, 60);
        basicActions.waitForElementToBePresentWithRetries(ohcHraHeader, 60);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(), "Las Provisiones de reembolso de salud (HRA) se ofrecen a trav\u00E9s de su empleador");
        softAssert.assertEquals(helpMeLink.getText(), "Ayuda para entender esta p\u00E1gina");
        softAssert.assertTrue(whenYouPayTxt.getText().equalsIgnoreCase("Cuando " + SharedData.getMembers().get(0).getFullName() + " paga su seguro de salud utilizando las Provisiones de reembolso de salud (HRA) proporcionadas a trav\u00E9s por su empleador, es posible que deba adquirir un plan fuera de Connect for Health Colorado. Confirme con el empleador de " + SharedData.getMembers().get(0).getFullName() + " si tiene una provisi\u00F3n de reducci\u00F3n de salario, ya que podr\u00EDa afectar su capacidad para inscribirse en un plan a trav\u00E9s del Mercado."));
        softAssert.assertTrue(hraQuestionTxt.get(0).getText().equalsIgnoreCase("Seleccione el a\u00F1o del plan para la cobertura HRA de " + SharedData.getMembers().get(0).getFullName() + "."));
        softAssert.assertEquals(planYeardpd.getText(), "Selecciona un a\u00F1o\n2025");
        softAssert.assertTrue(hraQuestionTxt.get(1).getText().equalsIgnoreCase("Ingrese la cantidad que el empleador de " + SharedData.getMembers().get(0).getFullName() + " aporta cada mes a las Provisiones de reembolso de salud (HRA) por su cobertura."));
        softAssert.assertEquals(amountInput.getAttribute("value"), expectedIncome);
        softAssert.assertTrue(hraQuestionTxt.get(2).getText().equalsIgnoreCase("\u00BFQu\u00E9 tipo de Provisiones de reembolso de salud (HRA) ofrece el empleador de " + SharedData.getMembers().get(0).getFullName() + "?"));
        softAssert.assertEquals(hraQsehraBtn.getText(), "Provisiones de reembolso de salud para peque\u00F1os empleadores calificados (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(), "Provisiones de reembolso de salud de cobertura individual (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutDataEnglish() {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        softAssert.assertEquals(ifMayTxt.getText(), "It may be less expensive to pay for your coverage with the Advanced Premium Tax Credit you could receive through Connect for Health Colorado. This would replace your employer's contribution.");
        softAssert.assertEquals(hraQuestionTxt.get(3).getText(), "If receiving Advance Premium Tax Credit is a more affordable option, would you choose to opt out from receiving an employer contribution?");
        softAssert.assertEquals(optOutBtn.get(0).getText(), "Yes");
        softAssert.assertEquals(optOutBtn.get(1).getText(), "No");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutDataSpanish() {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        softAssert.assertEquals(ifMayTxt.getText(), "Es posible que sea menos costoso pagar su cobertura con los cr\u00E9ditos fiscales anticipados para la prima que podr\u00EDa recibir a trav\u00E9s de Connect for Health Colorado. Esto reemplazar\u00EDa el aporte de su empleador.");
        softAssert.assertEquals(hraQuestionTxt.get(3).getText(), "Si recibir Cr\u00E9dito fiscal anticipado para la prima es una opci\u00F3n m\u00E1s econ\u00F3mica, \u00BFoptar\u00EDa por no recibir un aporte del empleador?");
        softAssert.assertEquals(optOutBtn.get(0).getText(), "S\u00ED");
        softAssert.assertEquals(optOutBtn.get(1).getText(), "No");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutSecondaryDataEnglish() {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        softAssert.assertTrue(ifMayTxt.getText().equalsIgnoreCase("It may be less expensive to pay for " + SharedData.getMembers().get(0).getFullName() + "\u2019s coverage with the Advanced Premium Tax Credit they could receive through Connect for Health Colorado. This would replace their employer's contribution."));
        softAssert.assertTrue(hraQuestionTxt.get(3).getText().equalsIgnoreCase("If receiving Advance Premium Tax Credit is a more affordable option, would " + SharedData.getMembers().get(0).getFullName() + " choose to opt out from receiving an employer contribution?"));
        softAssert.assertEquals(optOutBtn.get(0).getText(), "Yes");
        softAssert.assertEquals(optOutBtn.get(1).getText(), "No");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutSecondaryDataSpanish() {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        softAssert.assertTrue(ifMayTxt.getText().equalsIgnoreCase("Es posible que sea menos costoso pagar la cobertura de " + SharedData.getMembers().get(0).getFullName() + " con los cr\u00E9ditos fiscales anticipados para la prima que podr\u00EDa recibir a trav\u00E9s de Connect for Health Colorado. Esto reemplazar\u00EDa el aporte de su empleador."));
        softAssert.assertTrue(hraQuestionTxt.get(3).getText().equalsIgnoreCase("Si recibir Cr\u00E9dito fiscal anticipado para la prima es una opci\u00F3n m\u00E1s econ\u00F3mica, \u00BFoptar\u00EDa " + SharedData.getMembers().get(0).getFullName() + " por no recibir un aporte del empleador?"));
        softAssert.assertEquals(optOutBtn.get(0).getText(), "S\u00ED");
        softAssert.assertEquals(optOutBtn.get(1).getText(), "No");
        softAssert.assertAll();
    }

    public void verifyHraContinueAndgoBackBtnsEnglish() {
        softAssert.assertEquals(goBackBtn.getText(), "Go back");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(goBackBtn.getCssValue("background-color"), "rgba(252, 252, 252, 1)");
        action.moveToElement(goBackBtn).perform();
        softAssert.assertEquals(goBackBtn.getText(), "Go back");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(goBackBtn.getCssValue("background-color"), "rgba(226, 241, 248, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
        action.moveToElement(saveAndContinueBtn).perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(22, 156, 216, 1)");
        softAssert.assertAll();
    }

    public void verifyHraContinueAndgoBackBtnsSpanish() {
        softAssert.assertEquals(goBackBtn.getText(), "Volver");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(goBackBtn.getCssValue("background-color"), "rgba(252, 252, 252, 1)");
        action.moveToElement(goBackBtn).perform();
        softAssert.assertEquals(goBackBtn.getText(), "Volver");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(goBackBtn.getCssValue("background-color"), "rgba(226, 241, 248, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
        action.moveToElement(saveAndContinueBtn).perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(22, 156, 216, 1)");
        softAssert.assertAll();
    }

    public void verifyEnrolledOption(String year, String amount, String type, String withOrWithout, String aptc) {
        basicActions.waitForElementToBePresentWithRetries(ohcHeader, 15);
        basicActions.waitForElementToBePresentWithRetries(ohcHraHeader, 15);
        basicActions.waitForElementToBePresent(whenYouPayTxt, 15);
        basicActions.waitForElementToBePresent(planYeardpd, 15);
        basicActions.waitForElementToBePresent(amountInput, 15);
        basicActions.waitForElementToBePresent(hraQsehraBtn, 15);
        basicActions.waitForElementToBePresent(hraIchraBtn, 15);
        String expectedSubstringSelectedOption = "touched";
        String expectedSubstringNotSelectedOption = "untouched";
        String expectedSubstringSelectedButton = "selected";
        switch (year) {
            case "Current Year":
                basicActions.waitForElementToBePresent(planYeardpd, 15);
                softAssert.assertTrue(planYeardpd.getAttribute("class").contains(expectedSubstringSelectedOption), "Current year field does not contain: " +expectedSubstringSelectedOption);
                softAssert.assertEquals(planYeardpd.getAttribute("value"), "1: " + basicActions.getCurrYear());
                softAssert.assertAll();
                break;
            case "Future Year":
                basicActions.waitForElementToBePresent(planYeardpd, 15);
                softAssert.assertTrue(planYeardpd.getAttribute("class").contains(expectedSubstringSelectedOption), "Future year field does not contain: " +expectedSubstringSelectedOption);
                softAssert.assertEquals(planYeardpd.getAttribute("value"), "2: " + basicActions.getFutureYear());
                softAssert.assertAll();
                break;
            case "Not Selected":
                basicActions.waitForElementToBePresent(planYeardpd, 15);
                softAssert.assertTrue(planYeardpd.getAttribute("class").contains(expectedSubstringNotSelectedOption), "Year field does not contain: " +expectedSubstringSelectedOption);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + year);
        }
        if (!amount.equals("Not Selected")) {
            softAssert.assertEquals(amountInput.getAttribute("value"), amount);
            softAssert.assertAll();
        } else if (amount.equals("Not Selected")) {
            softAssert.assertTrue(amountInput.getAttribute("class").contains(expectedSubstringNotSelectedOption), "Amount field does not contain: " +expectedSubstringNotSelectedOption);
            softAssert.assertAll();
        }
        switch (type) {
            case "ICHRA":
                basicActions.waitForElementToBePresent(hraIchraBtn, 15);
                softAssert.assertTrue(hraIchraBtn.getAttribute("class").contains(expectedSubstringSelectedButton), "ICHRA button does not contain: " +expectedSubstringSelectedButton);
                softAssert.assertFalse(hraQsehraBtn.getAttribute("class").contains(expectedSubstringSelectedButton), "QSEHRA button contains: " +expectedSubstringSelectedButton);
                softAssert.assertAll();
                break;
            case "QSEHRA":
                basicActions.waitForElementToBePresent(hraQsehraBtn, 15);
                softAssert.assertTrue(hraQsehraBtn.getAttribute("class").contains(expectedSubstringSelectedButton), "QSEHRA button does not contain: " +expectedSubstringSelectedButton);
                softAssert.assertFalse(hraIchraBtn.getAttribute("class").contains(expectedSubstringSelectedButton), "ICHRA button contains: " +expectedSubstringSelectedButton);
                softAssert.assertAll();
                break;
            case "QSEHRA no Continue":
                basicActions.waitForElementToBePresent(hraQsehraBtn, 15);
                softAssert.assertTrue(hraQsehraBtn.getAttribute("class").contains(expectedSubstringSelectedButton), "QSEHRA button does not contain: " +expectedSubstringSelectedButton);
                softAssert.assertFalse(hraIchraBtn.getAttribute("class").contains(expectedSubstringSelectedButton), "ICHRA button contains: " +expectedSubstringSelectedButton);
                softAssert.assertAll();
                break;
            case "Not Selected":
                basicActions.waitForElementToBePresent(hraQsehraBtn, 15);
                softAssert.assertFalse(hraQsehraBtn.getAttribute("class").contains(expectedSubstringSelectedButton), "QSEHRA button contains: " +expectedSubstringSelectedButton);
                softAssert.assertFalse(hraIchraBtn.getAttribute("class").contains(expectedSubstringSelectedButton), "ICHRA button contains: " +expectedSubstringSelectedButton);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + type);
        }
        switch (withOrWithout) {
            case "With":
                switch (aptc) {
                    case "Yes":
                        basicActions.waitForElementListToBePresent(optOutBtn, 15);
                        softAssert.assertTrue(optOutBtn.get(0).getAttribute("class").contains(expectedSubstringSelectedButton), "APTC Yes button does not contain: " +expectedSubstringSelectedButton);
                        softAssert.assertFalse(optOutBtn.get(1).getAttribute("class").contains(expectedSubstringSelectedButton), "APTC No button contains: " +expectedSubstringSelectedButton);
                        softAssert.assertAll();
                        break;
                    case "No":
                        basicActions.waitForElementListToBePresent(optOutBtn, 15);
                        softAssert.assertTrue(optOutBtn.get(1).getAttribute("class").contains(expectedSubstringSelectedButton), "APTC No button does not contain: " +expectedSubstringSelectedButton);
                        softAssert.assertFalse(optOutBtn.get(0).getAttribute("class").contains(expectedSubstringSelectedButton), "APTC Yes button contains: " +expectedSubstringSelectedButton);
                        softAssert.assertAll();
                        break;
                    case "Not Selected":
                        basicActions.waitForElementListToBePresent(optOutBtn, 15);
                        softAssert.assertFalse(optOutBtn.get(0).getAttribute("class").contains(expectedSubstringSelectedButton), "APTC Yes button contains: " +expectedSubstringSelectedButton);
                        softAssert.assertFalse(optOutBtn.get(1).getAttribute("class").contains(expectedSubstringSelectedButton), "APTC No button contains: " +expectedSubstringSelectedButton);
                        softAssert.assertAll();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + aptc);
                }
                break;
            case "Without":
                if (optOutBtn.size() >= 1) {
                    Assert.assertFalse(basicActions.waitForElementToBePresent(optOutBtn.get(0), 30), "First optOutBtn should not be visible");
                    Assert.assertFalse(basicActions.waitForElementToBePresent(optOutBtn.get(1), 30), "Second optOutBtn should not be visible");
                }
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + withOrWithout);
        }
    }

    public void verifyErrorMessage(String errorType, String language) {
        switch (errorType) {
            case "Plan Year":
                verifyPlanYearError(language);
                break;
            case "Amount":
                verifyAmountError(language);
                break;
            case "Type":
                verifyTypeError(language);
                break;
            case "Opt Out":
                verifyOptOutError(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }

    public void verifyPlanYearError(String language) {
        basicActions.waitForElementToBePresent(planYearError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(planYearError.getText(), "Please select one of the options below");
                softAssert.assertEquals(planYearError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(planYearError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(planYearError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(planYearError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(planYearError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(planYearError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(planYearError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(planYearError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(planYearError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyAmountError(String language) {
        basicActions.waitForElementToBePresent(amountError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(amountError.getText(), "Amount is required");
                softAssert.assertEquals(amountError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(amountError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(amountError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(amountError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(amountError.getText(), "Esta cantidad es obligatoria");
                softAssert.assertEquals(amountError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(amountError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(amountError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(amountError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTypeError(String language) {
        basicActions.waitForElementToBePresent(typeError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(typeError.getText(), "Please select one of the options below");
                softAssert.assertEquals(typeError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(typeError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(typeError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(typeError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(typeError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(typeError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(typeError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(typeError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(typeError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyOptOutError(String language) {
        basicActions.waitForElementToBePresent(optOutError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(optOutError.getText(), "Please select one of the options below");
                softAssert.assertEquals(optOutError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(optOutError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(optOutError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(optOutError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(optOutError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(optOutError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(optOutError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(optOutError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(optOutError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyNoErrorMessage(String errorType) {
        switch (errorType) {
            case "Plan Year":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(planYearError, 10));
                softAssert.assertAll();
                break;
            case "Amount":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(amountError, 10));
                softAssert.assertAll();
                break;
            case "Type":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(typeError, 10));
                softAssert.assertAll();
                break;
            case "Opt Out":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(optOutError, 10));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }

    public void verifyHraPageData(String dataToVerify, String language) {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        switch (language) {
            case "English":
                verifyHraPageDataEnglish(dataToVerify);
                break;
            case "Spanish":
                verifyHraPageDataSpanish(dataToVerify);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHraPageDataEnglish(String dataToVerify) {
        basicActions.waitForElementToBePresentWithRetries(ohcHeader, 60);
        switch (dataToVerify) {
            case "First Section":
                verifyHraPageFirstSectionDataEnglish();
                break;
            case "Opt Out Section":
                verifyHraPageFirstSectionDataEnglish();
                verifyHraPageOptOutSectionDataEnglish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackBtn.getText(), "Go back");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertAll();
    }

    public void verifyHraPageFirstSectionDataEnglish() {
        basicActions.wait(250);
        basicActions.waitForElementToBePresentWithRetries(ohcHeader, 60);
        basicActions.waitForElementToBePresentWithRetries(ohcHraHeader, 60);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(), "Health Reimbursement Arrangement (HRA) offered through an employer");
        softAssert.assertEquals(helpMeLink.getText(), "Help me understand this page");
        softAssert.assertEquals(whenYouPayTxt.getText(), "When you pay for your health insurance using a Health Reimbursement Arrangement (HRA) provided through your employer, you may be required to buy a plan outside of Connect for Health Colorado. Confirm with your employer whether you have a salary reduction arrangement, as it could affect your ability to sign up for a plan through our Marketplace.");
        softAssert.assertEquals(hraQuestionTxt.get(0).getText(), "Select the plan year for your HRA coverage.");
        softAssert.assertEquals(planYeardpd.getText(), "Select a year\n2025");
        softAssert.assertEquals(hraQuestionTxt.get(1).getText(), "Enter the amount your employer contributes each month to an HRA for your coverage.");
        softAssert.assertEquals(amountInput.getText(), "");
        softAssert.assertEquals(hraQuestionTxt.get(2).getText(), "What type of HRA is your employer offering?");
        softAssert.assertEquals(hraQsehraBtn.getText(), "Qualified Small Employer Health Reimbursement Arrangement (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(), "Individual Coverage Health Reimbursement Arrangement (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutSectionDataEnglish() {
        basicActions.waitForElementToBePresent(ohcHeader, 60);
        basicActions.waitForElementToBePresent(ifMayTxt, 60);
        softAssert.assertEquals(ifMayTxt.getText(), "It may be less expensive to pay for your coverage with the Advanced Premium Tax Credit you could receive through Connect for Health Colorado. This would replace your employer's contribution.");
        softAssert.assertEquals(hraQuestionTxt.get(3).getText(), "If receiving Advance Premium Tax Credit is a more affordable option, would you choose to opt out from receiving an employer contribution?");
        softAssert.assertEquals(optOutBtn.get(0).getText(), "Yes");
        softAssert.assertEquals(optOutBtn.get(1).getText(), "No");
        softAssert.assertAll();
    }

    public void verifyHraPageDataSpanish(String dataToVerify) {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        switch (dataToVerify) {
            case "First Section":
                verifyHraPageFirstSectionDataSpanish();
                break;
            case "Opt Out Section":
                verifyHraPageFirstSectionDataSpanish();
                verifyHraPageOptOutSectionDataSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackBtn.getText(), "Volver");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyHraPageFirstSectionDataSpanish() {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(), "Las Provisiones de reembolso de salud (HRA) se ofrecen a trav\u00E9s de su empleador");
        softAssert.assertEquals(helpMeLink.getText(), "Ayuda para entender esta p\u00E1gina");
        softAssert.assertEquals(whenYouPayTxt.getText(), "Cuando paga su seguro de salud utilizando las Provisiones de reembolso de salud (HRA) proporcionadas a trav\u00E9s de su empleador, es posible que deba adquirir un plan fuera de Connect for Health Colorado. Confirme con su empleador si tiene una provisi\u00F3n de reducci\u00F3n de salario, ya que podr\u00EDa afectar su capacidad para inscribirse en un plan a trav\u00E9s del Mercado.");
        softAssert.assertEquals(hraQuestionTxt.get(0).getText(), "Seleccione el a\u00F1o del plan para su cobertura HRA.");
        softAssert.assertEquals(planYeardpd.getText(), "Selecciona un a\u00F1o\n2025");
        softAssert.assertEquals(hraQuestionTxt.get(1).getText(), "Ingrese la cantidad que aporta su empleador cada mes a las Provisiones de reembolso de salud (HRA) por su cobertura.");
        softAssert.assertEquals(amountInput.getText(), "");
        softAssert.assertEquals(hraQuestionTxt.get(2).getText(), "\u00BFQu\u00E9 tipo de Provisiones de reembolso de salud (HRA) ofrece su empleador?");
        softAssert.assertEquals(hraQsehraBtn.getText(), "Provisiones de reembolso de salud para peque\u00F1os empleadores calificados (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(), "Provisiones de reembolso de salud de cobertura individual (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutSectionDataSpanish() {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        softAssert.assertEquals(ifMayTxt.getText(), "Es posible que sea menos costoso pagar su cobertura con los cr\u00E9ditos fiscales anticipados para la prima que podr\u00EDa recibir a trav\u00E9s de Connect for Health Colorado. Esto reemplazar\u00EDa el aporte de su empleador.");
        softAssert.assertEquals(hraQuestionTxt.get(3).getText(), "Si recibir Cr\u00E9dito fiscal anticipado para la prima es una opci\u00F3n m\u00E1s econ\u00F3mica, \u00BFoptar\u00EDa por no recibir un aporte del empleador?");
        softAssert.assertEquals(optOutBtn.get(0).getText(), "S\u00ED");
        softAssert.assertEquals(optOutBtn.get(1).getText(), "No");
        softAssert.assertAll();
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
        softAssert.assertEquals(helpDrawerHeaderMedicare.getText(), "Health Reimbursement Arrangement (HRA)");
        softAssert.assertEquals(helpDrawerOverviewHeader.getText(), "Overview");
        softAssert.assertEquals(helpDrawerEmployerHeader.getText(), "Employer Contribution Amount");
        softAssert.assertEquals(helpDrawerOptOutHeader.getText(), "Individual Coverage HRA Opt Out");
        softAssert.assertEquals(helpDrawerBodyParagraph1.getText(), "This is a Health Reimbursement Arrangement (HRA) offered by your employer to help you pay for health insurance, even if you do not sign up for it. The HRA option that your employer offers may be called a Qualified Small Employer HRA (QSEHRA) or an Individual Coverage HRA (ICHRA).");
        softAssert.assertEquals(helpDrawerBodyParagraph2.getText(), "Enter the amount the employer contributes to cover only you, not the amount they contribute toward you and your dependents (if any) or spouse.");
        softAssert.assertEquals(helpDrawerBodyParagraph3.getText(), "You may be subject to a tax penalty if you receive Advance Premium Tax Credits in addition to your employer's contribution toward an Individual Coverage HRA.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderMedicare.getText(), "Provisi\u00F3n de reembolso de salud (HRA)");
        softAssert.assertEquals(helpDrawerOverviewHeader.getText(), "Resumen");
        softAssert.assertEquals(helpDrawerEmployerHeader.getText(), "La cantidad que aporta su empleador");
        softAssert.assertEquals(helpDrawerOptOutHeader.getText(), "Una cuenta de reembolso de gastos m\u00E9dicos de cobertura individual (ICHRA) optar por no");
        softAssert.assertEquals(helpDrawerBodyParagraph1.getText(), "Si sus empleador le ofrece una Cuenta de reembolso de gastos m\u00E9dicos (HRA) para ayudarle a pagar su seguro de salud, incluso si no se inscribe en uno. La opci\u00F3n HRA que le ofrece su empleador puede ser llamada HRA de Peque\u00F1o empleador calificado (QSEHRA) o HRA de Cobertura individual (ICHRA)");
        softAssert.assertEquals(helpDrawerBodyParagraph2.getText(), "Ingrese la cantidad que aporta el empleador para cubrirlo solo a usted, no la cantidad que contribuye para usted y sus dependientes (si aplican) o c\u00F3nyuge.");
        softAssert.assertEquals(helpDrawerBodyParagraph3.getText(), "Puede estar sujeto a una multa fiscal si recibe un Cr\u00E9dito fiscal anticipado para la prima adem\u00E1s del aporte de su empleador para su cobertura individual HRA.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateDropdownOptions(String dateToCheck) {
        basicActions.waitForElementToBePresent(ohcHeader, 15);
        basicActions.waitForElementToBePresent(ohcHraHeader, 15);
        basicActions.waitForElementToBePresent(whenYouPayTxt, 15);
        basicActions.waitForElementToBePresent(planYeardpd, 15);
        String today = basicActions.changeDateFormat(basicActions.getTodayDate(), "MM/dd/yyyy", "yyyy-MM-dd");
        String startDateOE = basicActions.changeDateFormat(basicActions.getStartDateOE(), "MM/dd/yyyy", "yyyy-MM-dd");
        String endDateOE = basicActions.changeDateFormat(basicActions.getEndDateOE(), "MM/dd/yyyy", "yyyy-MM-dd");
        LocalDate todayDate = LocalDate.parse(today);
        LocalDate startDate = LocalDate.parse(startDateOE);
        LocalDate endDate = LocalDate.parse(endDateOE);
        switch (dateToCheck) {
            case "Actual date":
                if (todayDate.isEqual(startDate) || todayDate.isEqual(endDate) ||(todayDate.isAfter(startDate) && todayDate.isBefore(endDate))) {
                    softAssert.assertEquals(planYeardpd.getText(),"Select a year\n" + basicActions.getCurrYear() + "\n" + basicActions.getFutureYear());
                } else {
                    softAssert.assertEquals(planYeardpd.getText(),"Select a year\n" + basicActions.getCurrYear());
                }
                softAssert.assertAll();
                break;
            case "Overridden date":
                String currentUrl = basicActions.getCurrentUrl();
                String date = basicActions.extractDateFromUrl(currentUrl);
                if (date == null || date.isEmpty()) {
                    System.out.println("Date parameter is missing or empty in the URL");
                } else {
                    try {
                        String formattedDate = basicActions.changeDateFormat(date, "MM/dd/yyyy", "yyyy-MM-dd");
                        LocalDate overriddenDate = LocalDate.parse(formattedDate);
                        if (overriddenDate.isEqual(startDate) || overriddenDate.isEqual(endDate) ||(overriddenDate.isAfter(startDate) && overriddenDate.isBefore(endDate))) {
                            softAssert.assertEquals(planYeardpd.getText(),"Select a year\n" + basicActions.getCurrYear() + "\n" + basicActions.getFutureYear());
                            System.out.println("The overridden date is within the time frame");
                        } else {
                            softAssert.assertEquals(planYeardpd.getText(),"Select a year\n" + basicActions.getFutureYear());
                        }
                        softAssert.assertAll();
                    } catch (Exception e) {
                        System.out.println("Error processing the overridden date: " + e.getMessage());
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dateToCheck);
        }
    }

    public void selectYearOption(String year) {
        basicActions.waitForElementToBePresent(planYeardpd, 20);
        switch (year) {
            case "Current year":
                planYeardpd.sendKeys(basicActions.getCurrYear());
                break;
            case "Future year":
                planYeardpd.sendKeys(basicActions.getFutureYear());
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + year);
        }
    }
    public void validateICHRAmessagedisplayed(List<String> messege) {

        softAssert.assertEquals(ICHRAErrMsg1.getText(), messege.get(0));
        softAssert.assertEquals(ICHRAErrMsg2.getText(), messege.get(1));
        softAssert.assertAll();
    }



}
