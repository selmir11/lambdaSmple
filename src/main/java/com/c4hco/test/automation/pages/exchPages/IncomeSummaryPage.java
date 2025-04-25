package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

    @FindBy(id = "Help.Button")
    WebElement helpSide;

    @FindBy(css = ".header-close-link")
    WebElement helpCloseLink;

    @FindBy(css = ".title-row .title")
    WebElement helpDrawerHeaderIncomeSummary;

    @FindBy(css = ".c4-text-body-200")
    List<WebElement> helpDrawerHeaders;

    @FindBy(css = "div.section-help-content-container > p")
    List<WebElement> helpDrawerNewParagraphs;

    @FindBy(css = ".help-footer .c4-type-links-md")
    List<WebElement> helpDrawerFooter;

    @FindBy(css = ".help-footer .clickable")
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

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinnerOverlay;

    @FindBy(css = "span.error-message.c4-text-body-100")
    private WebElement errorMessage;

    @FindBy(css = ".input-error-message .error-message")
    private WebElement ActiveErrorMessage;

    @FindBy(xpath = "//*[@class='income-details-left margin-left-32']")
    WebElement labelNoIncomeReported;

    @FindBy(xpath = "//*[@class='body-text-1 income-details-row margin-left-32 ng-star-inserted']")
    WebElement labelNoDeductionsReported;

    @FindBy(xpath="(//div[@class='header-3 income-details-left indent-left'])[2]/following::div[@class='body-text-1 income-details-row margin-left-32 ng-star-inserted']")
    WebElement labelNoDeductionsReportedUnderDeductions;

    @FindBy(xpath = "//*[@id='edit-income-button']")
    WebElement btnEditIncome;

    @FindBy(xpath = " //*[@id='edit-deductions-button']")
    WebElement btnEditDeductions;

    @FindBy(xpath = "//div[@class='income-details-right']")
    List<WebElement> allIncomeAmounts;

    @FindBy(id = "edit-income-button")
    WebElement editIncomeButton;

    @FindBy(id = "edit-deductions-button")
    WebElement editdeductionsButton;

    @FindBy(xpath = "//*[name()='svg' and @class='feather feather-dollar-sign']")
    WebElement projectIncomeDollarSign;


    public void clickEditDeductionsButton() {
        basicActions.waitForElementToBePresentWithRetries(editdeductionsButton,30);
        editdeductionsButton.click();
    }
    public void clickEditIncomeButton() {
        basicActions.waitForElementToBePresentWithRetries(editIncomeButton,30);
        editIncomeButton.click();
    }

    public void selectProjectedIncome(String projectedIncomeOption){
        basicActions.waitForElementToDisappear(loaderIcon, 120);
        basicActions.waitForElementToDisappear(spinner,60);
        basicActions.waitForElementToDisappear(spinnerOverlay,60);
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
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
    }

    public void clickHelpIcon(String label) {
        basicActions.wait(50);

        basicActions.waitForElementListToBePresent(helpLnk, 10);
        switch(label){
            case "Help me understand":
                helpLnk.get(0).click();
                break;
            case "side help":
                basicActions.waitForElementToBeClickableWithRetries(helpSide, 10);
                helpSide.click();
                break;
            case "close help":
                helpCloseLink.click();
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

    public void selectOneOfTheProjectedIncomeOptions(String projectedIncomeOption){
        basicActions.waitForElementToBePresentWithRetries(projectedIncomeYes,10);
        basicActions.waitForElementToBePresentWithRetries(projectedIncomeNo,10);
        switch(projectedIncomeOption){
            case "Yes":
                basicActions.waitForElementToBePresentWithRetries(hdr_Income,30);
                basicActions.waitForElementToBePresentWithRetries(hdr_IncomeSummary,30);
                basicActions.waitForElementToBeClickableWithRetries(projectedIncomeYes, 30);
                basicActions.scrollToElement(projectedIncomeYes);
                projectedIncomeYes.click();
                break;
            case "No":
                basicActions.waitForElementToBePresentWithRetries(hdr_Income,30);
                basicActions.waitForElementToBePresentWithRetries(hdr_IncomeSummary,30);
                basicActions.waitForElementToBeClickableWithRetries(projectedIncomeNo, 30);
                basicActions.scrollToElement(projectedIncomeNo);
                projectedIncomeNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option given for Projected Income");
        }
    }

    public void enterProjectedIncomeAmount(String projectedIncome) {
        basicActions.waitForElementToBePresent(ProjectedIncomeInputTextField, 20);
        ProjectedIncomeInputTextField.sendKeys(projectedIncome);
        ProjectedIncomeLabel.click();
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
        basicActions.waitForElementToBePresent(helpDrawerHeaders.get(0), 30);
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
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaders.get(0).getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderIncomeSummary.getText(), "Income Summary");
        softAssert.assertEquals(helpDrawerHeaders.get(1).getText(), "Overview");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(0).getText(), "This page shows you what you have told us so far about how much money you make. The amount of financial help you qualify for will be based on these numbers. Please make sure all the information is correct before clicking Continue. If any information on this page is not right, click the Back button to go back and fix it.");
        softAssert.assertEquals(helpDrawerHeaders.get(2).getText(), "Projected Income");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(1).getText(), "The projected annual income you enter will be used to calculate the amount of financial help you qualify for (instead of the amount we calculated from the combined sources of income that you reported). We will also review the current, monthly income details you provide to assess whether you are potentially eligible for Health First Colorado (Colorado\u2019s Medicaid program). Keep in mind, if the income that you report on your federal income tax return differs from the information reported in this application, you may have to repay some or all of the financial assistance you receive. The Internal Revenue Service (IRS) makes the final determination of eligibility for Premium Tax Credits.");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaders.get(0).getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderIncomeSummary.getText(), "Resumen de ingresos");
        softAssert.assertEquals(helpDrawerHeaders.get(1).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(0).getText(), "Esta p\u00E1gina resume la informaci\u00F3n que nos ha dado hasta ahora sobre cu\u00E1l es su ingreso. La cantidad de ayuda financiera a la que califica se basar\u00E1 en estas cifras. Verifique que toda la informaci\u00F3n sea correcta, antes de hacer clic en Continuar. Si alguna informaci\u00F3n de esta p\u00E1gina no es correcta, haga clic en el bot\u00F3n Atr\u00E1s para regresar y corregirla.");
        softAssert.assertEquals(helpDrawerHeaders.get(2).getText(), "Ingresos que proyecta");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(1).getText(), "El ingreso anual proyectado que ingrese se utilizar\u00E1 para calcular la cantidad de ayuda financiera a la que califique (en lugar de la cantidad que calculamos de las fuentes de ingresos combinadas que report\u00F3). Tambi\u00E9n revisaremos los detalles de su ingreso mensual actual que proporcione para evaluar si es potencialmente elegible para Health First Colorado (Programa Medicaid de Colorado). Recuerde que si el ingreso que report\u00F3 en su declaraci\u00F3n del impuesto federal sobre los ingresos difiere de la informaci\u00F3n que report\u00F3 en esta solicitud, es posible que tenga que devolver parte o toda la ayuda financiera que reciba. El Servicio de Rentas Internas (IRS) hace la determinaci\u00F3n final sobre elegibilidad para Cr\u00E9ditos fiscales para la prima.");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateProjectedIncomeHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaders.get(0).getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderIncomeSummary.getText(), "Projected Income");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(0).getText(), "The projected annual income you enter will be used to calculate the amount of financial help you qualify for (instead of the amount we calculated from the combined sources of income that you reported). We will also review the current, monthly income details you provide to assess whether you are potentially eligible for Health First Colorado (Colorado\u2019s Medicaid program). Keep in mind, if the income that you report on your federal income tax return differs from the information reported in this application, you may have to repay some or all of the financial assistance you receive. The Internal Revenue Service (IRS) makes the final determination of eligibility for Premium Tax Credits.");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateProjectedIncomeHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaders.get(0).getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderIncomeSummary.getText(), "Ingresos que proyecta");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(0).getText(), "El ingreso anual proyectado que ingrese se utilizar\u00E1 para calcular la cantidad de ayuda financiera a la que califique (en lugar de la cantidad que calculamos de las fuentes de ingresos combinadas que report\u00F3). Tambi\u00E9n revisaremos los detalles de su ingreso mensual actual que proporcione para evaluar si es potencialmente elegible para Health First Colorado (Programa Medicaid de Colorado). Recuerde que si el ingreso que report\u00F3 en su declaraci\u00F3n del impuesto federal sobre los ingresos difiere de la informaci\u00F3n que report\u00F3 en esta solicitud, es posible que tenga que devolver parte o toda la ayuda financiera que reciba. El Servicio de Rentas Internas (IRS) hace la determinaci\u00F3n final sobre elegibilidad para Cr\u00E9ditos fiscales para la prima.");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
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

    public void clickGoBackOnIncomeSummary() {
        basicActions.waitForElementToBePresent(goBackBtn,15);
        goBackBtn.click();
    }


    public void verifyErrorMessage() {
        basicActions.waitForElementToBePresent(errorMessage,15);
        softAssert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
        projectedIncomeYes.click();
        saveAndContinueBtn.click();
        softAssert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
        ProjectedIncomeInputTextField.sendKeys("11111111111");
        softAssert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
        softAssert.assertAll();
    }

    public void verifyActiveErrorMessage(String expectedErrorMessage){
        basicActions.waitForElementToBeClickable(ActiveErrorMessage,30);
        softAssert.assertEquals(ActiveErrorMessage.getText(), expectedErrorMessage,"Actual and Expected Error message is not matching");
        softAssert.assertAll();
    }

    public void verifyNoErrors() {
        basicActions.waitForElementToDisappear(ActiveErrorMessage,30);
        softAssert.assertFalse(basicActions.waitForElementPresence(ActiveErrorMessage,20));
        softAssert.assertAll();
    }

    public void validatePageHeaderText(){
        String signature=SharedData.getPrimaryMember().getSignature();
        softAssert.assertEquals(hdr_Income.getText(),"Income: "+signature,"Header1 text not matching");
        softAssert.assertEquals(hdr_IncomeSummary.getText(),"Summary","Header2 is not matching");
        softAssert.assertAll();
    }
    public void validateTextFontColourEtc(){
        softAssert.assertEquals(incomeTotalAmount.getText().trim(),"$0.00","Income Amount Mismatch");
        softAssert.assertEquals(deductionsTotalAmount.getText().trim(),"$0.00","Deduction Amount Mismatch");
        softAssert.assertEquals(incomeTotalAmount.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(incomeTotalAmount.getCssValue("font-size"), "19px", "Font size mismatch");
        softAssert.assertEquals(incomeTotalAmount.getCssValue("font-weight"), "700", "Font weight mismatch");
        softAssert.assertEquals(deductionsTotalAmount.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(deductionsTotalAmount.getCssValue("font-size"), "19px", "Font size mismatch");
        softAssert.assertEquals(deductionsTotalAmount.getCssValue("font-weight"), "700", "Font weight mismatch");
        softAssert.assertEquals(labelNoIncomeReported.getText().trim(),"No income reported","No income reported text mismatch");
        softAssert.assertEquals(labelNoIncomeReported.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(labelNoIncomeReported.getCssValue("font-size"), "16px", "Font size mismatch");
        softAssert.assertEquals(labelNoIncomeReported.getCssValue("font-weight"), "400", "Font weight mismatch");
        softAssert.assertEquals(labelNoIncomeReported.getCssValue("color"), "rgba(43, 49, 60, 1)", "Color mismatch");
        softAssert.assertEquals(labelNoIncomeReported.getCssValue("line-height"), "28px", "Line-height mismatch");
        softAssert.assertEquals(labelNoDeductionsReported.getText().trim(),"No deductions reported","No deductions reported text mismatch");
        softAssert.assertEquals(labelNoDeductionsReported.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(labelNoDeductionsReported.getCssValue("font-size"), "16px", "Font size mismatch");
        softAssert.assertEquals(labelNoDeductionsReported.getCssValue("font-weight"), "400", "Font weight mismatch");
        softAssert.assertEquals(labelNoDeductionsReported.getCssValue("color"), "rgba(43, 49, 60, 1)", "Color mismatch");
        softAssert.assertEquals(labelNoDeductionsReported.getCssValue("line-height"), "28px", "Line-height mismatch");
        softAssert.assertAll();
    }
    public void validateAddedIncomeNameAndAmount(String incomeName,String amount){
        basicActions.wait(1000);
        softAssert.assertEquals(labelNoIncomeReported.getText(),incomeName,"Added Income Name not matching");
        softAssert.assertEquals(incomeTotalAmount.getText().trim(),amount,"Income Amount Mismatch");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(labelNoDeductionsReportedUnderDeductions,10));
        softAssert.assertAll();
    }
    public void clickOnEditIncomeOrDeductionButton(String editButton){
        switch (editButton){
            case "edit_income_button":
                basicActions.waitForElementToBePresent(btnEditIncome,10);
                btnEditIncome.click();
                break;
            case "edit_deductions_button":
                basicActions.waitForElementToBePresent(btnEditDeductions,10);
                btnEditDeductions.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + editButton);
        }

    }
    public void validateTwoIncomeAmounts(String amount1,String amount2) {
        softAssert.assertEquals(allIncomeAmounts.get(0).getText().trim(), amount1, "Added Income amount not matching");
        softAssert.assertEquals(allIncomeAmounts.get(1).getText().trim(), amount2, "Added Income amount not matching");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(labelNoDeductionsReportedUnderDeductions, 10));
        softAssert.assertAll();

    }

    public void validateThreeIncomeAmounts(String amount1, String amount2, String amount3) {
        softAssert.assertEquals(allIncomeAmounts.get(0).getText().trim(), "$12,500.00", "Added Income amount not matching");
        softAssert.assertEquals(allIncomeAmounts.get(1).getText().trim(), "$18,425.00", "Added Income amount not matching");
        softAssert.assertEquals(allIncomeAmounts.get(2).getText().trim(), "$45.02", "Added Income amount not matching");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(labelNoDeductionsReportedUnderDeductions, 10));
        softAssert.assertAll();
    }

    public void validateDeductionAmount(String deductAmt,String incomeAmt1,String incomeAmt2,String incomeAmt3){
        basicActions.wait(1000);
        softAssert.assertEquals(allIncomeAmounts.get(0).getText().trim(),incomeAmt1,"Added Income amount not matching");
        softAssert.assertEquals(allIncomeAmounts.get(1).getText().trim(),incomeAmt2,"Added Income amount not matching");
        softAssert.assertEquals(allIncomeAmounts.get(2).getText().trim(),incomeAmt3,"Added Income amount not matching");
        softAssert.assertEquals(allIncomeAmounts.get(3).getText().trim(),deductAmt,"Added deductions amount not matching");
        softAssert.assertAll();
    }
    public void validateIncomeDeductionCalculations(){
        double incomeTotalAmountValue=Double.parseDouble( basicActions.removeCommaAndDollarSignFromAmount(incomeTotalAmount.getText().trim()));
        double incomeAmount1=Double.parseDouble( basicActions.removeCommaAndDollarSignFromAmount(allIncomeAmounts.get(0).getText().trim()));
        double incomeAmount2=Double.parseDouble( basicActions.removeCommaAndDollarSignFromAmount(allIncomeAmounts.get(1).getText().trim()));
        double incomeAmount3=Double.parseDouble( basicActions.removeCommaAndDollarSignFromAmount(allIncomeAmounts.get(2).getText().trim()));
        softAssert.assertTrue(incomeTotalAmountValue==incomeAmount1+incomeAmount2+incomeAmount3,"Addition of income amount is not matching with total amount");
        double totalAnnualIncomeValue=Double.parseDouble( totalAnnualIncome.getText().replaceAll("[^\\d.]", ""));
        double deductionTotalAmountValue=Double.parseDouble( basicActions.removeCommaAndDollarSignFromAmount(deductionsTotalAmount.getText().trim()));
        softAssert.assertTrue(totalAnnualIncomeValue==incomeTotalAmountValue-deductionTotalAmountValue,"Total Annual Income amount mismatch");
        softAssert.assertAll();
    }
    public void validateSpouseName(){
        String spouseName=basicActions.getMemFirstLastNames("Spouse");
        Assert.assertEquals(hdr_Income.getText(),"Income: "+spouseName,"Spouse name not matching");
    }
    public void verifyProjectIncomeQstnNotAnswered() {
        softAssert.assertFalse(projectedIncomeYes.getAttribute("class").contains("button-selected"), "Yes button is Selected");
        softAssert.assertFalse(projectedIncomeNo.getAttribute("class").contains("button-selected"), "No button is Selected");
        softAssert.assertAll();
    }

    public void verifyFontColorText() {
        basicActions.waitForElementToBePresent(totalAnnualIncome,10);
        softAssert.assertTrue(totalAnnualIncome.getText().trim().contains("$0.00"), "Income Amount not 0.00");
        softAssert.assertEquals(totalAnnualIncome.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(totalAnnualIncome.getCssValue("font-size"), "19px", "Font size mismatch");
        softAssert.assertEquals(totalAnnualIncome.getCssValue("color"), "rgba(77, 77, 79, 1)", "Color mismatch");
        softAssert.assertAll();
    }

    public void verifyTotalAnnualIncome(String amount) {
        basicActions.wait(1000);
        softAssert.assertEquals(totalAnnualIncome.getText().trim(), "Total annual income " + amount, "Total Annual Income mismatch");
        softAssert.assertEquals(totalAnnualIncome.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(totalAnnualIncome.getCssValue("font-size"), "19px", "Font size mismatch");
        softAssert.assertEquals(totalAnnualIncome.getCssValue("color"), "rgba(77, 77, 79, 1)", "Color mismatch");
        softAssert.assertAll();
    }
    public void verifyEnteredProjectedIncome(String projectedAmount){
        softAssert.assertEquals(ProjectedIncomeInputTextField.getAttribute("value"),projectedAmount,"Entered projected amount is incorrect");
        softAssert.assertEquals(ProjectedIncomeInputTextField.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(ProjectedIncomeInputTextField.getCssValue("font-size"), "16px", "Font size mismatch");
        softAssert.assertEquals(ProjectedIncomeInputTextField.getCssValue("color"), "rgba(77, 77, 79, 1)", "Color mismatch");
        softAssert.assertTrue(projectIncomeDollarSign.isDisplayed(),"Dollar sign not present");
        softAssert.assertAll();
    }
}
