package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class IncomeSummaryPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public IncomeSummaryPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".header-1")
    WebElement hdr_Income;

    @FindBy(css = ".header-2")
    WebElement hdr_IncomeSummary;

    @FindBy(id ="ELIG-summaryDetails-YesButton")
    WebElement projectedIncomeYes;

    @FindBy(id = "ELIG-summaryDetails-NoButton")
    WebElement projectedIncomeNo;

    @FindBy(id = "pageId-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(css = "lib-help-icon a")
    List<WebElement> helpLnk;

    @FindBy(css = ".help-label")
    WebElement helpSide;

    @FindBy(css = ".drawer-controls > div > div > a > svg")
    WebElement helpCloseSide;

    @FindBy(css = ".drawer-heading .body-text-1")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = ".drawer-heading .drawer-title")
    WebElement helpDrawerHeaderIncomeSummary;

    @FindBy(css = ".drawer-text-content.body-text-1 > div")
    WebElement helpDrawerMainHeaders;

    @FindBy(css = ".drawer-text-content.body-text-1")
    WebElement helpDrawerParagraphs;

    @FindBy(css = "div.drawer-text-content.body-text-1 > p")
    WebElement helpDrawerBodyParagraphs;

    @FindBy(css = "div.drawer-text-content.body-text-1 > ul > li")
    WebElement helpDrawerBodySubParagraphs;

    @FindBy(css = ".drawer-footer h3")
    WebElement helpDrawerFooter;

    @FindBy(css = ".drawer-footer h3 a")
    WebElement helpDrawerContactUsLink;

    @FindBy(id = "loader-icon")
    WebElement loaderIcon;

    @FindBy(id = "pageId-GoBack")
    WebElement goBackBtn;

    @FindBy(xpath = "(//div[@class='header-3 income-details-left indent-left'])[1]")
    WebElement incomeSubHeadingLabel;

    @FindBy(xpath = "(//div[@class='header-3 income-details-right'])[1]")
    WebElement incomeTotalAmount;

    @FindBy(xpath = "(//div[@class='income-details-left margin-left-32'])[1]")
    WebElement companyOrJobName;

    @FindBy(xpath = "(//div[@class='body-text-1 income-details-row margin-top-sm ng-star-inserted']//div)[2]")
    WebElement companyOrJobAmount;

    @FindBy(xpath = "(//div[@class='income-details-left margin-left-32'])[2]")
    WebElement additionalIncomeName;

    @FindBy(xpath = "(//div[@class='body-text-1 income-details-row margin-top-sm ng-star-inserted']//div)[4]")
    WebElement additionalIncomeAmount;

    @FindBy(xpath = "(//div[@class='header-3 income-details-left indent-left'])[2]")
    WebElement deductionsSubHeadingLabel;

    @FindBy(xpath = "(//div[@class='header-3 income-details-right'])[2]")
    WebElement deductionsTotalAmount;

    @FindBy(xpath = "(//div[@class='income-details-left margin-left-32'])[3]")
    WebElement deductionName;

    @FindBy(xpath = "(//div[@class='body-text-1 income-details-row margin-top-sm ng-star-inserted']//div)[6]")
    WebElement deductionAmount;

    @FindBy(xpath = "//div[@class='total-income-width']//div//span")
    WebElement totalAnnualIncome;

    @FindBy(xpath = "//div[@class='total-income-width']//div//em")
    WebElement IncomeMinusDeductions;

    @FindBy(xpath = "//div[@class='margin-top-lg']//div[@class='header-3']")
    WebElement ProjectedIncomeLabel;

    @FindBy(xpath = "//div//label//span[@class='ng-star-inserted']")
    WebElement IncomeDifferentThanTheAmountQuestion;

    @FindBy(xpath = "//div[@class='col']//label[@for='ELIG-summaryDetails-incomeAmountInput']")
    WebElement enterProjectedIncomeInCurrentYearLabel;

    @FindBy(xpath = "//div//input[@id='ELIG-summaryDetails-incomeAmountInput']")
    WebElement ProjectedIncomeInputTextField;

    @FindBy(xpath = "(//div//lib-fi[@name='dollar-sign']//*)[1]")
    WebElement DollarSymbolForProjectedIncomeInputField;

    public void selectProjectedIncome(String projectedIncomeOption){
        basicActions.waitForElementToDisappear(loaderIcon, 120);
        basicActions.waitForElementToBePresentWithRetries(hdr_Income,10);
        switch(projectedIncomeOption){
            case "No":
                basicActions.waitForElementToBePresentWithRetries(hdr_Income,30);
                basicActions.waitForElementToBePresentWithRetries(hdr_IncomeSummary,30);
                basicActions.waitForElementToBeClickableWithRetries(projectedIncomeNo, 30);
                basicActions.scrollToElement(projectedIncomeNo);
                projectedIncomeNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + projectedIncomeNo);
        }
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueBtn, 30);
        saveAndContinueBtn.click();
    }

    public void clickSaveandContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn,30);
        saveAndContinueBtn.click();
    }

    public void clickHelpIcon(String label) {
        basicActions.waitForElementListToBePresent(helpLnk, 10);
        switch(label){
            case "Help me understand":
                helpLnk.get(0).click();
                break;
            case "side help":
                helpSide.click();
                break;
            case "close side help":
                helpCloseSide.click();
                break;
            case "Projected Income":
                helpLnk.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + label);
        }
    }

    public void clickHelpContactUsNavigation() {
            basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
            helpDrawerContactUsLink.click();
    }





    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void verifyHeadersIncomeSummaryPage(String language){
        switch (language){
            case "English":
                verifyHeadersIncomeSummaryPageEnglish();
                break;
            case "Spanish":
                verifyHeadersIncomeSummaryPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersIncomeSummaryPageEnglish(){
        basicActions.waitForElementToBePresent(hdr_Income,15);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase( "Income: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_IncomeSummary.getText(), "Summary");
        softAssert.assertAll();
    }

    public void verifyHeadersIncomeSummaryPageSpanish(){
        basicActions.waitForElementToBePresent(hdr_Income,15);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_IncomeSummary.getText(), "Resumen");
        softAssert.assertAll();
    }

    public void validateHelpVerbiage(String helpText, String language) {
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 30);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncomeSummary, 30);
        switch (helpText){
            case "Full":switch (language) {
                case "English":
                    validateGeneralHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateGeneralHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
                break;
            case "Projected Income":switch (language) {
                case "English":
                    validateProjectedIncomeHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateProjectedIncomeHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            default:
                throw new IllegalArgumentException("Invalid option: " + helpText);
        }

    }

    public void validateGeneralHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderIncomeSummary.getText(), "Income Summary");
        softAssert.assertEquals(helpDrawerMainHeaders.getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.getText(), "This page shows you what you have told us so far about how much money you make. The amount of financial help you qualify for will be based on these numbers. Please make sure all the information is correct before clicking Continue. If any information on this page is not right, click the Back button to go back and fix it.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.getText(), "Projected Income\nThe projected annual income you enter will be used to calculate the amount of financial help you qualify for (instead of the amount we calculated from the combined sources of income that you reported). We will also review the current, monthly income details you provide to assess whether you are potentially eligible for Health First Colorado (Colorado\u2019s Medicaid program). Keep in mind, if the income that you report on your federal income tax return differs from the information reported in this application, you may have to repay some or all of the financial assistance you receive. The Internal Revenue Service (IRS) makes the final determination of eligibility for Premium Tax Credits.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderIncomeSummary.getText(), "Resumen de ingresos");
        softAssert.assertEquals(helpDrawerMainHeaders.getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.getText(), "Esta p\u00E1gina resume la informaci\u00F3n que nos ha dado hasta ahora sobre cu\u00E1l es su ingreso. La cantidad de ayuda financiera a la que califica se basar\u00E1 en estas cifras. Verifique que toda la informaci\u00F3n sea correcta, antes de hacer clic en Continuar. Si alguna informaci\u00F3n de esta p\u00E1gina no es correcta, haga clic en el bot\u00F3n Atr\u00E1s para regresar y corregirla.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.getText(), "Ingresos que proyecta\nEl ingreso anual proyectado que ingrese se utilizar\u00E1 para calcular la cantidad de ayuda financiera a la que califique (en lugar de la cantidad que calculamos de las fuentes de ingresos combinadas que report\u00F3). Tambi\u00E9n revisaremos los detalles de su ingreso mensual actual que proporcione para evaluar si es potencialmente elegible para Health First Colorado (Programa Medicaid de Colorado). Recuerde que si el ingreso que report\u00F3 en su declaraci\u00F3n del impuesto federal sobre los ingresos difiere de la informaci\u00F3n que report\u00F3 en esta solicitud, es posible que tenga que devolver parte o toda la ayuda financiera que reciba. El Servicio de Rentas Internas (IRS) hace la determinaci\u00F3n final sobre elegibilidad para Cr\u00E9ditos fiscales para la prima.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateProjectedIncomeHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderIncomeSummary.getText(), "Projected Income");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "The projected annual income you enter will be used to calculate the amount of financial help you qualify for (instead of the amount we calculated from the combined sources of income that you reported). We will also review the current, monthly income details you provide to assess whether you are potentially eligible for Health First Colorado (Colorado\u2019s Medicaid program). Keep in mind, if the income that you report on your federal income tax return differs from the information reported in this application, you may have to repay some or all of the financial assistance you receive. The Internal Revenue Service (IRS) makes the final determination of eligibility for Premium Tax Credits.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateProjectedIncomeHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderIncomeSummary.getText(), "Ingresos que proyecta");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "El ingreso anual proyectado que ingrese se utilizar\u00E1 para calcular la cantidad de ayuda financiera a la que califique (en lugar de la cantidad que calculamos de las fuentes de ingresos combinadas que report\u00F3). Tambi\u00E9n revisaremos los detalles de su ingreso mensual actual que proporcione para evaluar si es potencialmente elegible para Health First Colorado (Programa Medicaid de Colorado). Recuerde que si el ingreso que report\u00F3 en su declaraci\u00F3n del impuesto federal sobre los ingresos difiere de la informaci\u00F3n que report\u00F3 en esta solicitud, es posible que tenga que devolver parte o toda la ayuda financiera que reciba. El Servicio de Rentas Internas (IRS) hace la determinaci\u00F3n final sobre elegibilidad para Cr\u00E9ditos fiscales para la prima.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyTextInIncomeSummaryPage(List<String> dataText){
        basicActions.waitForElementToBePresent(hdr_Income,15);
        softAssert.assertEquals(hdr_Income.getText(), dataText.get(0) + " " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(hdr_IncomeSummary.getText(), dataText.get(1), "Summary Title Not matching");
        softAssert.assertEquals(incomeSubHeadingLabel.getText(), dataText.get(2), "Income subheading label not matching");
        softAssert.assertEquals(incomeTotalAmount.getText(), dataText.get(3), "Total Income amount Not matching");
        softAssert.assertTrue(companyOrJobName.isDisplayed(), "Company or Job name is not getting displayed"); // Verifying whether job name or company name exists
        softAssert.assertEquals(companyOrJobAmount.getText(), dataText.get(4), "Company or Job amount Not matching");
        softAssert.assertEquals(additionalIncomeName.getText(), dataText.get(5), "Additional Income name not matching");
        softAssert.assertEquals(additionalIncomeAmount.getText(), dataText.get(6), "Additional Income amount not matching");
        softAssert.assertEquals(deductionsSubHeadingLabel.getText(), dataText.get(7), "Deductions subheading label not matching");
        softAssert.assertEquals(deductionsTotalAmount.getText(), dataText.get(8), "Total Deduction amount not matching");
        softAssert.assertEquals(deductionName.getText(), dataText.get(9), "Deduction name not matching");
        softAssert.assertEquals(deductionAmount.getText(), dataText.get(10), deductionName + " Amount not matching.");
        softAssert.assertEquals(totalAnnualIncome.getText(), dataText.get(11), "Total Annual Income amount or label not matching");
        softAssert.assertEquals(IncomeMinusDeductions.getText(), dataText.get(12), "IncomeMinusDeductions label not matching");
        softAssert.assertEquals(ProjectedIncomeLabel.getText(), dataText.get(13), "Projected Income label not matching");
        softAssert.assertEquals(IncomeDifferentThanTheAmountQuestion.getText(), dataText.get(14), "Income Different than the amount question not matching");
        softAssert.assertEquals(projectedIncomeYes.getText(), dataText.get(15), "Projected Income Yes button label not matching");
        softAssert.assertEquals(projectedIncomeNo.getText(), dataText.get(16), "Projected Income No button label not matching");
        softAssert.assertEquals(goBackBtn.getText().trim(), dataText.get(17), "Go Back button label not matching");
        softAssert.assertEquals(saveAndContinueBtn.getText(), dataText.get(18), "Save and continue button label not matching");
        softAssert.assertEquals(helpSide.getText(), dataText.get(19), "Help button label not matching");
        softAssert.assertAll();
    }

    public void verifyTextAfterClickingYesToDifferentIncomeQuestion(List<String> dataText){
        basicActions.waitForElementToBePresent(projectedIncomeYes,15);
        projectedIncomeYes.click();
        softAssert.assertEquals(enterProjectedIncomeInCurrentYearLabel.getText(), dataText.get(0), "Enter Projected Income In Current Year label not matching");
        softAssert.assertEquals(ProjectedIncomeInputTextField.getAttribute("Placeholder"), dataText.get(1), "annual amount label for Projected Income input text field not matching");
        softAssert.assertTrue(DollarSymbolForProjectedIncomeInputField.isDisplayed(),"Dollar sign for Projected Income Input field is not visible"); // Verifying dollar sign is present
        softAssert.assertAll();
    }



}
