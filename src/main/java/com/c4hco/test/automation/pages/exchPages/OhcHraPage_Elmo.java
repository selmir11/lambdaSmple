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

import java.util.List;

import static java.awt.SystemColor.window;

public class OhcHraPage_Elmo {
    BasicActions basicActions;
    Actions action;
    SoftAssert softAssert = new SoftAssert();
    public OhcHraPage_Elmo(WebDriver webDriver){
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

    @FindBy(css = ".drawer-heading .body-text-1")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = ".drawer-heading .drawer-title")
    WebElement helpDrawerHeaderMedicare;

    @FindBy(css = "div > strong")
    List<WebElement> helpDrawerMainHeaders;

    @FindBy(css = ".drawer-text-content p")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = ".drawer-footer h3")
    WebElement helpDrawerFooter;

    @FindBy(css = ".drawer-footer h3 a")
    WebElement helpDrawerContactUsLink;



    public void clickSaveAndContinue(){
        basicActions.waitForElementToBePresent(ohcHeader,90);
        basicActions.waitForElementToBePresent(ohcHraHeader,90);
        basicActions.waitForElementToBePresent(whenYouPayTxt,90);
        basicActions.waitForElementToBePresent(planYeardpd,90);
        basicActions.waitForElementToBePresent(amountInput,90);
        basicActions.waitForElementToBePresent(hraQsehraBtn,90);
        basicActions.waitForElementToBePresent(hraIchraBtn,90);
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 90);
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
    }

    public void clickGoBack(){
        basicActions.waitForElementToBeClickable(goBackBtn, 20);
        goBackBtn.click();
    }

    public void clickYear(){
        basicActions.waitForElementToBePresent(planYeardpd,20);
        planYeardpd.sendKeys("2024");
    }

    public void enterAmount(String amount){
        basicActions.waitForElementToBePresent(amountInput,20);
        amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        amountInput.sendKeys(amount);
        amountInput.sendKeys(Keys.TAB);
    }

    public void selectHraType(String type){
        basicActions.waitForElementToBePresent(ohcHeader,90);
        basicActions.waitForElementToBePresent(ohcHraHeader,90);
        basicActions.waitForElementToBePresent(whenYouPayTxt,90);
        basicActions.waitForElementToBePresent(planYeardpd,90);
        basicActions.waitForElementToBePresent(amountInput,90);
        basicActions.waitForElementToBePresent(hraQsehraBtn,90);
        basicActions.waitForElementToBePresent(hraIchraBtn,90);
        basicActions.scrollToElement(hraIchraBtn);
        switch (type){
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

    public void selectOptOut(String aptc){
        basicActions.waitForElementListToBePresent(optOutBtn,20);
        switch (aptc){
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
        switch(label){
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
    public void verifyHeadersHraOhcPage(String language){
        switch (language){
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

    public void verifyHeadersHraOhcPageEnglish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(),"Health Reimbursement Arrangement (HRA) offered through an employer");
        softAssert.assertAll();
    }

    public void verifyHeadersHraOhcPageSpanish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(),"Las Provisiones de reembolso de salud (HRA) se ofrecen a trav\u00E9s de su empleador");
        softAssert.assertAll();
    }

    public void verifyHraData(String dataToVerify, String expectedIncome, String language){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        switch (language){
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

    public void verifyHraDataEnglish(String dataToVerify, String expectedIncome){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        switch (dataToVerify){
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

    public void verifyHraDataSpanish(String dataToVerify, String expectedIncome){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        switch (dataToVerify){
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

    public void verifyHraPageInitialDataEnglish(String expectedIncome){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(),"Health Reimbursement Arrangement (HRA) offered through an employer");
        softAssert.assertEquals(helpMeLink.getText(),"Help me understand this page");
        softAssert.assertEquals(whenYouPayTxt.getText(), "When you pay for your health insurance using a Health Reimbursement Arrangement (HRA) provided through your employer, you may be required to buy a plan outside of Connect for Health Colorado. Confirm with your employer whether you have a salary reduction arrangement, as it could affect your ability to sign up for a plan through our Marketplace.");
        softAssert.assertEquals(hraQuestionTxt.get(0).getText(),"Select the plan year for your HRA coverage.");
        softAssert.assertEquals(planYeardpd.getText(),"Select a year\n2024\n2025");
        softAssert.assertEquals(hraQuestionTxt.get(1).getText(),"Enter the amount your employer contributes each month to an HRA for your coverage.");
        softAssert.assertEquals(amountInput.getAttribute("value"), expectedIncome);
        softAssert.assertEquals(hraQuestionTxt.get(2).getText(),"What type of HRA is your employer offering?");
        softAssert.assertEquals(hraQsehraBtn.getText(),"Qualified Small Employer Health Reimbursement Arrangement (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(),"Individual Coverage Health Reimbursement Arrangement (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageInitialDataSpanish(String expectedIncome){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(),"Las Provisiones de reembolso de salud (HRA) se ofrecen a trav\u00E9s de su empleador");
        softAssert.assertEquals(helpMeLink.getText(),"Ayuda para entender esta p\u00E1gina");
        softAssert.assertEquals(whenYouPayTxt.getText(), "Cuando paga su seguro de salud utilizando las Provisiones de reembolso de salud (HRA) proporcionadas a trav\u00E9s de su empleador, es posible que deba adquirir un plan fuera de Connect for Health Colorado. Confirme con su empleador si tiene una provisi\u00F3n de reducci\u00F3n de salario, ya que podr\u00EDa afectar su capacidad para inscribirse en un plan a trav\u00E9s del Mercado.");
        softAssert.assertEquals(hraQuestionTxt.get(0).getText(),"Seleccione el a\u00F1o del plan para su cobertura HRA.");
        softAssert.assertEquals(planYeardpd.getText(),"Selecciona un a\u00F1o\n2024\n2025");
        softAssert.assertEquals(hraQuestionTxt.get(1).getText(),"Ingrese la cantidad que aporta su empleador cada mes a las Provisiones de reembolso de salud (HRA) por su cobertura.");
        softAssert.assertEquals(amountInput.getAttribute("value"), expectedIncome);
        softAssert.assertEquals(hraQuestionTxt.get(2).getText(),"\u00BFQu\u00E9 tipo de Provisiones de reembolso de salud (HRA) ofrece su empleador?");
        softAssert.assertEquals(hraQsehraBtn.getText(),"Provisiones de reembolso de salud para peque\u00F1os empleadores calificados (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(),"Provisiones de reembolso de salud de cobertura individual (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageInitialSecondaryDataEnglish(String expectedIncome){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(),"Health Reimbursement Arrangement (HRA) offered through an employer");
        softAssert.assertEquals(helpMeLink.getText(),"Help me understand this page");
        softAssert.assertTrue(whenYouPayTxt.getText().equalsIgnoreCase("When " + SharedData.getMembers().get(0).getFullName() + " pays for their health insurance using a Health Reimbursement Arrangement (HRA) provided through their employer, they may be required to buy a plan outside of Connect for Health Colorado. Confirm with " + SharedData.getMembers().get(0).getFullName() + "'s employer whether they have a salary reduction arrangement, as it could affect their ability to sign up for a plan through our Marketplace."));
        softAssert.assertTrue(hraQuestionTxt.get(0).getText().equalsIgnoreCase("Select a plan year for " + SharedData.getMembers().get(0).getFullName() + "'s coverage."));
        softAssert.assertEquals(planYeardpd.getText(),"Select a year\n2024\n2025");
        softAssert.assertTrue(hraQuestionTxt.get(1).getText().equalsIgnoreCase("Enter the amount " + SharedData.getMembers().get(0).getFullName() + "'s employer contributes each month to an HRA for their coverage."));
        softAssert.assertEquals(amountInput.getAttribute("value"), expectedIncome);
        softAssert.assertTrue(hraQuestionTxt.get(2).getText().equalsIgnoreCase("What type of HRA is " + SharedData.getMembers().get(0).getFullName() + "'s employer offering?"));
        softAssert.assertEquals(hraQsehraBtn.getText(),"Qualified Small Employer Health Reimbursement Arrangement (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(),"Individual Coverage Health Reimbursement Arrangement (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageInitialSecondaryDataSpanish(String expectedIncome){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(),"Las Provisiones de reembolso de salud (HRA) se ofrecen a trav\u00E9s de su empleador");
        softAssert.assertEquals(helpMeLink.getText(),"Ayuda para entender esta p\u00E1gina");
        softAssert.assertTrue(whenYouPayTxt.getText().equalsIgnoreCase("Cuando " + SharedData.getMembers().get(0).getFullName() + " paga su seguro de salud utilizando las Provisiones de reembolso de salud (HRA) proporcionadas a trav\u00E9s por su empleador, es posible que deba adquirir un plan fuera de Connect for Health Colorado. Confirme con el empleador de " + SharedData.getMembers().get(0).getFullName() + " si tiene una provisi\u00F3n de reducci\u00F3n de salario, ya que podr\u00EDa afectar su capacidad para inscribirse en un plan a trav\u00E9s del Mercado."));
        softAssert.assertTrue(hraQuestionTxt.get(0).getText().equalsIgnoreCase("Seleccione el a\u00F1o del plan para la cobertura HRA de " + SharedData.getMembers().get(0).getFullName() + "."));
        softAssert.assertEquals(planYeardpd.getText(),"Selecciona un a\u00F1o\n2024\n2025");
        softAssert.assertTrue(hraQuestionTxt.get(1).getText().equalsIgnoreCase("Ingrese la cantidad que el empleador de " + SharedData.getMembers().get(0).getFullName() + " aporta cada mes a las Provisiones de reembolso de salud (HRA) por su cobertura."));
        softAssert.assertEquals(amountInput.getAttribute("value"), expectedIncome);
        softAssert.assertTrue(hraQuestionTxt.get(2).getText().equalsIgnoreCase("\u00BFQu\u00E9 tipo de Provisiones de reembolso de salud (HRA) ofrece el empleador de " + SharedData.getMembers().get(0).getFullName() + "?"));
        softAssert.assertEquals(hraQsehraBtn.getText(),"Provisiones de reembolso de salud para peque\u00F1os empleadores calificados (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(),"Provisiones de reembolso de salud de cobertura individual (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutDataEnglish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertEquals(ifMayTxt.getText(),"It may be less expensive to pay for your coverage with the Advanced Premium Tax Credit you could receive through Connect for Health Colorado. This would replace your employer's contribution.");
        softAssert.assertEquals(hraQuestionTxt.get(3).getText(),"If receiving Advance Premium Tax Credit is a more affordable option, would you choose to opt out from receiving an employer contribution?");
        softAssert.assertEquals(optOutBtn.get(0).getText(),"Yes");
        softAssert.assertEquals(optOutBtn.get(1).getText(), "No");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutDataSpanish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertEquals(ifMayTxt.getText(),"Es posible que sea menos costoso pagar su cobertura con los cr\u00E9ditos fiscales anticipados para la prima que podr\u00EDa recibir a trav\u00E9s de Connect for Health Colorado. Esto reemplazar\u00EDa el aporte de su empleador.");
        softAssert.assertEquals(hraQuestionTxt.get(3).getText(),"Si recibir Cr\u00E9dito fiscal anticipado para la prima es una opci\u00F3n m\u00E1s econ\u00F3mica, \u00BFoptar\u00EDa por no recibir un aporte del empleador?");
        softAssert.assertEquals(optOutBtn.get(0).getText(),"S\u00ED");
        softAssert.assertEquals(optOutBtn.get(1).getText(), "No");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ifMayTxt.getText().equalsIgnoreCase("It may be less expensive to pay for " + SharedData.getMembers().get(0).getFullName() + "\u2019s coverage with the Advanced Premium Tax Credit they could receive through Connect for Health Colorado. This would replace their employer's contribution."));
        softAssert.assertTrue(hraQuestionTxt.get(3).getText().equalsIgnoreCase("If receiving Advance Premium Tax Credit is a more affordable option, would " + SharedData.getMembers().get(0).getFullName() + " choose to opt out from receiving an employer contribution?"));
        softAssert.assertEquals(optOutBtn.get(0).getText(),"Yes");
        softAssert.assertEquals(optOutBtn.get(1).getText(), "No");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ifMayTxt.getText().equalsIgnoreCase("Es posible que sea menos costoso pagar la cobertura de " + SharedData.getMembers().get(0).getFullName() + " con los cr\u00E9ditos fiscales anticipados para la prima que podr\u00EDa recibir a trav\u00E9s de Connect for Health Colorado. Esto reemplazar\u00EDa el aporte de su empleador."));
        softAssert.assertTrue(hraQuestionTxt.get(3).getText().equalsIgnoreCase("Si recibir Cr\u00E9dito fiscal anticipado para la prima es una opci\u00F3n m\u00E1s econ\u00F3mica, \u00BFoptar\u00EDa " + SharedData.getMembers().get(0).getFullName() + " por no recibir un aporte del empleador?"));
        softAssert.assertEquals(optOutBtn.get(0).getText(),"S\u00ED");
        softAssert.assertEquals(optOutBtn.get(1).getText(), "No");
        softAssert.assertAll();
    }
    
    public void verifyHraContinueAndgoBackBtnsEnglish(){
        softAssert.assertEquals(goBackBtn.getText(), "  Go back");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(goBackBtn.getCssValue("background"), "rgb(255, 255, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(goBackBtn).pause(1000L).build().perform();
        softAssert.assertEquals(goBackBtn.getText(), "  Go back");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(goBackBtn.getCssValue("background"), "rgb(227, 246, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(26, 112, 179) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(22, 156, 216) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertAll();
    }

    public void verifyHraContinueAndgoBackBtnsSpanish(){
        softAssert.assertEquals(goBackBtn.getText(), "  Volver");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(goBackBtn.getCssValue("background"), "rgb(255, 255, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(goBackBtn).pause(1000L).build().perform();
        softAssert.assertEquals(goBackBtn.getText(), "  Volver");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
        softAssert.assertEquals(goBackBtn.getCssValue("background"), "rgb(227, 246, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(26, 112, 179) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(22, 156, 216) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertAll();
    }

    public void verifyEnrolledOption(String year, String amount, String type, String withOrWithout, String aptc){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        basicActions.waitForElementToBePresent(ohcHraHeader,15);
        basicActions.waitForElementToBePresent(whenYouPayTxt,15);
        basicActions.waitForElementToBePresent(planYeardpd,15);
        basicActions.waitForElementToBePresent(amountInput,15);
        basicActions.waitForElementToBePresent(hraQsehraBtn,15);
        basicActions.waitForElementToBePresent(hraIchraBtn,15);
        switch (year){
            case "Current Year":
                basicActions.waitForElementToBePresent(planYeardpd,15);
                softAssert.assertEquals(planYeardpd.getAttribute("class"), "form-select ng-untouched ng-pristine ng-valid");
                softAssert.assertEquals(planYeardpd.getAttribute("value"),"1: 2024");
                softAssert.assertAll();
                break;
            case "Not Selected":
                basicActions.waitForElementToBePresent(planYeardpd,15);
                softAssert.assertEquals(planYeardpd.getAttribute("class"),"form-select ng-untouched ng-pristine ng-invalid");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + year);
        }
        if (!amount.equals("Not Selected")) {
            softAssert.assertEquals(amountInput.getAttribute("value"), amount);
            softAssert.assertAll();
        } else if (amount.equals("Not Selected")) {
            softAssert.assertEquals(amountInput.getAttribute("class"), "form-control monetary-input ng-untouched ng-pristine ng-invalid");
            softAssert.assertAll();
        }
        switch (type){
            case "ICHRA":
                basicActions.waitForElementToBePresent(hraIchraBtn,15);
                softAssert.assertEquals(hraIchraBtn.getAttribute("class"),"button option-button-selected ng-star-inserted");
                softAssert.assertEquals(hraQsehraBtn.getAttribute("class"),"button option-button ng-star-inserted");
                softAssert.assertAll();
                break;
            case "QSEHRA":
                basicActions.waitForElementToBePresent(hraQsehraBtn,15);
                softAssert.assertEquals(hraQsehraBtn.getAttribute("class"),"button option-button-selected ng-star-inserted");
                softAssert.assertEquals(hraIchraBtn.getAttribute("class"),"button option-button ng-star-inserted");
                softAssert.assertAll();
                break;
            case "QSEHRA no Continue":
                basicActions.waitForElementToBePresent(hraQsehraBtn,15);
                softAssert.assertEquals(hraQsehraBtn.getAttribute("class"),"button ng-star-inserted option-button-selected");
                softAssert.assertEquals(hraIchraBtn.getAttribute("class"),"button ng-star-inserted option-button");
                softAssert.assertAll();
                break;
            case "Not Selected":
                basicActions.waitForElementToBePresent(hraQsehraBtn,15);
                softAssert.assertEquals(hraQsehraBtn.getAttribute("class"),"button option-button ng-star-inserted");
                softAssert.assertEquals(hraIchraBtn.getAttribute("class"),"button option-button ng-star-inserted");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + type);
        }
        switch (withOrWithout){
            case"With":
                switch (aptc){
                    case "Yes":
                        basicActions.waitForElementListToBePresent(optOutBtn,15);
                        softAssert.assertEquals(optOutBtn.get(0).getAttribute("class"),"button option-button-selected ng-star-inserted");
                        softAssert.assertEquals(optOutBtn.get(1).getAttribute("class"),"button option-button ng-star-inserted");
                        softAssert.assertAll();
                        break;
                    case "No":
                        basicActions.waitForElementListToBePresent(optOutBtn,15);
                        softAssert.assertEquals(optOutBtn.get(1).getAttribute("class"),"button option-button-selected ng-star-inserted");
                        softAssert.assertEquals(optOutBtn.get(0).getAttribute("class"),"button option-button ng-star-inserted");
                        softAssert.assertAll();
                        break;
                    case "Not Selected":
                        basicActions.waitForElementListToBePresent(optOutBtn,15);
                        softAssert.assertEquals(optOutBtn.get(0).getAttribute("class"),"button option-button ng-star-inserted");
                        softAssert.assertEquals(optOutBtn.get(1).getAttribute("class"),"button option-button ng-star-inserted");
                        softAssert.assertAll();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + aptc);
                }
                break;
            case"Without":
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
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(planYearError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(planYearError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(planYearError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(planYearError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(planYearError.getCssValue("color"), "rgba(150, 0, 0, 1)");
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
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(amountError.getText(), "Esta cantidad es obligatoria");
                softAssert.assertEquals(amountError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(amountError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(amountError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(amountError.getCssValue("color"), "rgba(150, 0, 0, 1)");
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
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(typeError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(typeError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(typeError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(typeError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(typeError.getCssValue("color"), "rgba(150, 0, 0, 1)");
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
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(optOutError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(optOutError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(optOutError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(optOutError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(optOutError.getCssValue("color"), "rgba(150, 0, 0, 1)");
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

    public void verifyHraPageDataEnglish(String dataToVerify){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        switch (dataToVerify){
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
        softAssert.assertEquals(goBackBtn.getText(),"  Go back");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Save and continue");
        softAssert.assertAll();
    }

    public void verifyHraPageFirstSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(),"Health Reimbursement Arrangement (HRA) offered through an employer");
        softAssert.assertEquals(helpMeLink.getText(),"Help me understand this page");
        softAssert.assertEquals(whenYouPayTxt.getText(), "When you pay for your health insurance using a Health Reimbursement Arrangement (HRA) provided through your employer, you may be required to buy a plan outside of Connect for Health Colorado. Confirm with your employer whether you have a salary reduction arrangement, as it could affect your ability to sign up for a plan through our Marketplace.");
        softAssert.assertEquals(hraQuestionTxt.get(0).getText(),"Select the plan year for your HRA coverage.");
        softAssert.assertEquals(planYeardpd.getText(),"Select a year\n2024\n2025");
        softAssert.assertEquals(hraQuestionTxt.get(1).getText(),"Enter the amount your employer contributes each month to an HRA for your coverage.");
        softAssert.assertEquals(amountInput.getText(),"");
        softAssert.assertEquals(hraQuestionTxt.get(2).getText(),"What type of HRA is your employer offering?");
        softAssert.assertEquals(hraQsehraBtn.getText(),"Qualified Small Employer Health Reimbursement Arrangement (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(),"Individual Coverage Health Reimbursement Arrangement (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        basicActions.waitForElementToBePresent(ifMayTxt,15);
        softAssert.assertEquals(ifMayTxt.getText(),"It may be less expensive to pay for your coverage with the Advanced Premium Tax Credit you could receive through Connect for Health Colorado. This would replace your employer's contribution.");
        softAssert.assertEquals(hraQuestionTxt.get(3).getText(),"If receiving Advance Premium Tax Credit is a more affordable option, would you choose to opt out from receiving an employer contribution?");
        softAssert.assertEquals(optOutBtn.get(0).getText(),"Yes");
        softAssert.assertEquals(optOutBtn.get(1).getText(),"No");
        softAssert.assertAll();
    }

    public void verifyHraPageDataSpanish(String dataToVerify){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        switch (dataToVerify){
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
        softAssert.assertEquals(goBackBtn.getText(),"  Volver");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyHraPageFirstSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertTrue(ohcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohcHraHeader.getText(),"Las Provisiones de reembolso de salud (HRA) se ofrecen a trav\u00E9s de su empleador");
        softAssert.assertEquals(helpMeLink.getText(),"Ayuda para entender esta p\u00E1gina");
        softAssert.assertEquals(whenYouPayTxt.getText(), "Cuando paga su seguro de salud utilizando las Provisiones de reembolso de salud (HRA) proporcionadas a trav\u00E9s de su empleador, es posible que deba adquirir un plan fuera de Connect for Health Colorado. Confirme con su empleador si tiene una provisi\u00F3n de reducci\u00F3n de salario, ya que podr\u00EDa afectar su capacidad para inscribirse en un plan a trav\u00E9s del Mercado.");
        softAssert.assertEquals(hraQuestionTxt.get(0).getText(),"Seleccione el a\u00F1o del plan para su cobertura HRA.");
        softAssert.assertEquals(planYeardpd.getText(),"Selecciona un a\u00F1o\n2024\n2025");
        softAssert.assertEquals(hraQuestionTxt.get(1).getText(),"Ingrese la cantidad que aporta su empleador cada mes a las Provisiones de reembolso de salud (HRA) por su cobertura.");
        softAssert.assertEquals(amountInput.getText(),"");
        softAssert.assertEquals(hraQuestionTxt.get(2).getText(),"\u00BFQu\u00E9 tipo de Provisiones de reembolso de salud (HRA) ofrece su empleador?");
        softAssert.assertEquals(hraQsehraBtn.getText(),"Provisiones de reembolso de salud para peque\u00F1os empleadores calificados (QSEHRA)");
        softAssert.assertEquals(hraIchraBtn.getText(),"Provisiones de reembolso de salud de cobertura individual (ICHRA)");
        softAssert.assertAll();
    }

    public void verifyHraPageOptOutSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohcHeader,15);
        softAssert.assertEquals(ifMayTxt.getText(),"Es posible que sea menos costoso pagar su cobertura con los cr\u00E9ditos fiscales anticipados para la prima que podr\u00EDa recibir a trav\u00E9s de Connect for Health Colorado. Esto reemplazar\u00EDa el aporte de su empleador.");
        softAssert.assertEquals(hraQuestionTxt.get(3).getText(),"Si recibir Cr\u00E9dito fiscal anticipado para la prima es una opci\u00F3n m\u00E1s econ\u00F3mica, \u00BFoptar\u00EDa por no recibir un aporte del empleador?");
        softAssert.assertEquals(optOutBtn.get(0).getText(),"S\u00ED");
        softAssert.assertEquals(optOutBtn.get(1).getText(),"No");
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
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Overview");
        softAssert.assertEquals(helpDrawerMainHeaders.get(1).getText(), "Employer Contribution Amount");
        softAssert.assertEquals(helpDrawerMainHeaders.get(2).getText(), "Individual Coverage HRA Opt Out");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "This is a Health Reimbursement Arrangement (HRA) offered by your employer to help you pay for health insurance, even if you do not sign up for it. The HRA option that your employer offers may be called a Qualified Small Employer HRA (QSEHRA) or an Individual Coverage HRA (ICHRA).");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Enter the amount the employer contributes to cover only you, not the amount they contribute toward you and your dependents (if any) or spouse.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "You may be subject to a tax penalty if you receive Advance Premium Tax Credits in addition to your employer's contribution toward an Individual Coverage HRA.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderMedicare.getText(), "Provisi\u00F3n de reembolso de salud (HRA)");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerMainHeaders.get(1).getText(), "La cantidad que aporta su empleador");
        softAssert.assertEquals(helpDrawerMainHeaders.get(2).getText(), "Una cuenta de reembolso de gastos m\u00E9dicos de cobertura individual (ICHRA) optar por no");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Si sus empleador le ofrece una Cuenta de reembolso de gastos m\u00E9dicos (HRA) para ayudarle a pagar su seguro de salud, incluso si no se inscribe en uno. La opci\u00F3n HRA que le ofrece su empleador puede ser llamada HRA de Peque\u00F1o empleador calificado (QSEHRA) o HRA de Cobertura individual (ICHRA)");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Ingrese la cantidad que aporta el empleador para cubrirlo solo a usted, no la cantidad que contribuye para usted y sus dependientes (si aplican) o c\u00F3nyuge.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Puede estar sujeto a una multa fiscal si recibe un Cr\u00E9dito fiscal anticipado para la prima adem\u00E1s del aporte de su empleador para su cobertura individual HRA.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }






}
