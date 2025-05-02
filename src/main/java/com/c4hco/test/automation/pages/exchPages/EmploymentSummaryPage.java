package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class EmploymentSummaryPage {
    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;
    public EmploymentSummaryPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".header-1")
    WebElement hdr_Income;

    @FindBy(css = ".header-2 > span")
    WebElement hdr_Employment;

    @FindBy(css = ".header-3")
    List<WebElement> jobOrSelfEmploymentHeaders;

    @FindBy(id = "EmploymentSummary-SaveAndContinue")
    WebElement btnContinue;

    @FindBy(xpath = "//*[starts-with(@id,'edit')]")
    WebElement lnkEditIncome;

    @FindBy(css = "[id^='remove-employer-']")
    List<WebElement> lnkRemoveJob;

    @FindBy(css = "app-confirmation-dialog button")
    List<WebElement> lnkRemoveContinue;

    @FindBy(css = "a.clickable.c4-type-links-lg")
    WebElement btnAddJob;

    @FindBy(css = "lib-help-icon a")
    WebElement helpLnk;

    @FindBy(id = "Help.Button")
    WebElement helpSide;

    @FindBy(css = ".header-close-link")
    WebElement helpCloseLink;

    @FindBy(css = ".title-row .c4-text-body-200")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = ".title-row .title")
    WebElement helpDrawerHeaderEmploymentSummary;

    @FindBy(css = ".help-main-content .c4-text-body-200")
    WebElement helpDrawerMainHeaders;

    @FindBy(css = "div.section-help-content-gap-0-container > div")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = "ul:nth-child(18) > li:nth-child(1) > a, ul:nth-child(17) > li:nth-child(1) > a")
    WebElement helpDrawerAlimonyRecievedLink; //English and Spanish

    @FindBy(css = "ul:nth-child(18) > li:nth-child(2) > a, ul:nth-child(17) > li:nth-child(2) > a")
    WebElement helpDrawerCapitalGainsLink;

    @FindBy(css = "ul:nth-child(18) > li:nth-child(3) > a, ul:nth-child(17) > li:nth-child(3) > a")
    WebElement helpDrawerIncomeRentalPropertyLink;

    @FindBy(css = "ul:nth-child(18) > li:nth-child(4) > a, ul:nth-child(17) > li:nth-child(4) > a")
    WebElement helpDrawerPensionLink;

    @FindBy(css = "ul:nth-child(18) > li:nth-child(5) > a, ul:nth-child(17) > li:nth-child(5) > a")
    WebElement helpDrawerPrivateRetirementIncomeLink;

    @FindBy(css = "ul:nth-child(18) > li:nth-child(6) > a, ul:nth-child(17) > li:nth-child(6) > a")
    WebElement helpDrawerUnemploymentInsuranceBenefitLink;

    @FindBy(css = "ul:nth-child(18) > li:nth-child(7) > a, ul:nth-child(17) > li:nth-child(7) > a")
    WebElement helpDrawerInvestmentIncomeLink;

    @FindBy(css = "ul:nth-child(18) > li:nth-child(9) > a, ul:nth-child(17) > li:nth-child(9) > a")
    WebElement helpDrawerUntaxedForeignIncomeLink;

    @FindBy(css = "ul:nth-child(18) > li:nth-child(10) > a, ul:nth-child(17) > li:nth-child(10) > a")
    WebElement helpDrawerRoyaltyIncomeLink;

    @FindBy(css = "ul:nth-child(18) > li:nth-child(11) > a, ul:nth-child(17) > li:nth-child(11) > a")
    WebElement helpDrawerTitle2IncomeLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(2) > a, ul:nth-child(23) > li:nth-child(2) > a")
    WebElement helpDrawerAlimonyPaidOutLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(3) > a, ul:nth-child(23) > li:nth-child(3) > a")
    WebElement helpDrawerDomesticProductionLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(5) > a, ul:nth-child(23) > li:nth-child(5) > a")
    WebElement helpDrawerPreTaxRetirementContributionLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(6) > a:nth-child(5), ul:nth-child(23) > li:nth-child(6) > a:nth-child(5)")
    WebElement helpDrawerSchoolTuitionLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(6) > a:nth-child(8), ul:nth-child(23) > li:nth-child(6) > a:nth-child(8)")
    WebElement helpDrawerSchoolTuitionSelfEmpLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(6) > a:nth-child(9), ul:nth-child(23) > li:nth-child(6) > a:nth-child(9)")
    WebElement helpDrawerSchoolTuitionSelfEmp2Link;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(6) > a:nth-child(12), ul:nth-child(23) > li:nth-child(6) > a:nth-child(12)")
    WebElement helpDrawerSchoolTuitionArmedForcesLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(6) > a:nth-child(13), ul:nth-child(23) > li:nth-child(6) > a:nth-child(13)")
    WebElement helpDrawerSchoolTuitionArmedForces2Link;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(6) > a:nth-child(16), ul:nth-child(23) > li:nth-child(6) > a:nth-child(16)")
    WebElement helpDrawerSchoolTuitionDisabilityLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(6) > a:nth-child(17), ul:nth-child(23) > li:nth-child(6) > a:nth-child(17)")
    WebElement helpDrawerSchoolTuitionDisability2Link;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(7) > a, ul:nth-child(23) > li:nth-child(7) > a")
    WebElement helpDrawerSelfEmploymentTaxLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(8) > a, ul:nth-child(23) > li:nth-child(8) > a")
    WebElement helpDrawerStudentLoanInterestLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(9) > a, ul:nth-child(23) > li:nth-child(9) > a")
    WebElement helpDrawerSelfEmploymentHealthInsuranceLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(10) > a, ul:nth-child(23) > li:nth-child(10) > a")
    WebElement helpDrawerSelfEmploymentRetirementLink;

    @FindBy(css = "ul:nth-child(24) > li:nth-child(11) > a, ul:nth-child(23) > li:nth-child(11) > a")
    WebElement helpDrawerMovingExpensesLink;

    @FindBy(css = ".help-footer .c4-type-links-md")
    List<WebElement> helpDrawerFooter;

    @FindBy(css = ".help-footer .clickable")
    WebElement helpDrawerContactUsLink;

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(xpath = "//app-employment-summary//div[contains(@class,'bold')]")
    List<WebElement> employmentSummaryBoldTexts;

    @FindBy(id = "EmploymentSummary-GoBack")
    WebElement btnGoBack;



    public void clickOnBackButton() {
        basicActions.waitForElementToBePresent(btnGoBack,20);
        btnGoBack.click();
    }

    public void clickContinue(){
        basicActions.wait(500);
        basicActions.waitForElementToDisappear( spinner,100 );
        basicActions.waitForElementToBePresentWithRetries(btnContinue,30);
        basicActions.scrollToElement(btnContinue);
        btnContinue.click();
    }

    public void clickEditIncome(int Index){
        basicActions.waitForElementToBePresent(lnkEditIncome,10);
        Index -=1;
        lnkEditIncome.click();

    }

    public void clickAddJob(){
        basicActions.waitForElementToBePresentWithRetries(spinner,60);
        basicActions.waitForElementToBePresentWithRetries(btnAddJob,60);
        basicActions.waitForElementToBeClickable(btnAddJob, 10);
        basicActions.click(btnAddJob);
    }

    public void clickRemoveJob(String DeleteJob) {
        basicActions.waitForElementListToBePresent(lnkRemoveJob, 20);

        List<String> employerNames = new ArrayList<>(SharedData.getCompanyname());
        String setEmployerName;
        int indexToRemove;

        switch (DeleteJob) {
            case "First":
                indexToRemove = 0;
                break;
            case "Second":
                indexToRemove = 1;
                break;
            case "Third":
                indexToRemove = 2;
                break;
            case "Fourth":
                indexToRemove = 3;
                break;
            default:
                throw new IllegalArgumentException("Invalid member type: " + DeleteJob);
        }

        if (indexToRemove < employerNames.size()) {
            setEmployerName = employerNames.get(indexToRemove);
            System.out.println(DeleteJob + " employer is " + setEmployerName);
            employerNames.remove(indexToRemove);
            lnkRemoveJob.get(indexToRemove).click();
            SharedData.setCompanyname(new ArrayList<>(employerNames));
            System.out.println("Remaining employer(s) "+SharedData.getCompanyname());
        }

        basicActions.waitForElementListToBePresent(lnkRemoveContinue, 60);
        lnkRemoveContinue.get(0).click();
    }

    public void clickHelpIcon(String label) {
        basicActions.waitForElementToBePresentWithRetries(helpLnk, 60);
        switch(label){
            case "Help me understand":
                helpLnk.click();
                break;
            case "side help":
                helpSide.click();
                break;
            case "close help":
                helpCloseLink.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + label);
        }
    }

    public void clickHelpContactUsNavigation(String lnkName) {
        switch (lnkName){
            case "Contact Us":
                basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
                helpDrawerContactUsLink.click();
                break;
            case "Alimony Received":
                basicActions.scrollToElement(helpDrawerAlimonyRecievedLink);
                helpDrawerAlimonyRecievedLink.click();
                break;
            case "Capital Gains":
                basicActions.scrollToElement(helpDrawerCapitalGainsLink);
                helpDrawerCapitalGainsLink.click();
                break;
            case "Income from Rental":
                basicActions.scrollToElement(helpDrawerIncomeRentalPropertyLink);
                helpDrawerIncomeRentalPropertyLink.click();
                break;
            case "Pension":
                basicActions.scrollToElement(helpDrawerPensionLink);
                helpDrawerPensionLink.click();
                break;
            case "Private Retirement Income":
                basicActions.scrollToElement(helpDrawerPrivateRetirementIncomeLink);
                helpDrawerPrivateRetirementIncomeLink.click();
                break;
            case "Unemployment Insurance":
                basicActions.scrollToElement(helpDrawerUnemploymentInsuranceBenefitLink);
                helpDrawerUnemploymentInsuranceBenefitLink.click();
                break;
            case "Investment Income":
                basicActions.scrollToElement(helpDrawerInvestmentIncomeLink);
                helpDrawerInvestmentIncomeLink.click();
                break;
            case "Untaxed Foreign Income":
                basicActions.scrollToElement(helpDrawerUntaxedForeignIncomeLink);
                helpDrawerUntaxedForeignIncomeLink.click();
                break;
            case "Royalty Income":
                basicActions.scrollToElement(helpDrawerRoyaltyIncomeLink);
                helpDrawerRoyaltyIncomeLink.click();
                break;
            case "Title II Income":
                basicActions.scrollToElement(helpDrawerTitle2IncomeLink);
                helpDrawerTitle2IncomeLink.click();
                break;
            case "Alimony paid out":
                basicActions.scrollToElement(helpDrawerAlimonyPaidOutLink);
                helpDrawerAlimonyPaidOutLink.click();
                break;
            case "Domestic production activities":
                basicActions.scrollToElement(helpDrawerDomesticProductionLink);
                helpDrawerDomesticProductionLink.click();
                break;
            case "Pre-tax retirement contribution":
                basicActions.scrollToElement(helpDrawerPreTaxRetirementContributionLink);
                helpDrawerPreTaxRetirementContributionLink.click();
                break;
            case "School tuition":
                basicActions.scrollToElement(helpDrawerSchoolTuitionLink);
                helpDrawerSchoolTuitionLink.click();
                break;
            case "School tuition: Self-Employed 1":
                basicActions.scrollToElement(helpDrawerSchoolTuitionSelfEmpLink);
                helpDrawerSchoolTuitionSelfEmpLink.click();
                break;
            case "School tuition: Self-Employed 2":
                basicActions.scrollToElement(helpDrawerSchoolTuitionSelfEmp2Link);
                helpDrawerSchoolTuitionSelfEmp2Link.click();
                break;
            case "School tuition: Armed Forces 1":
                basicActions.scrollToElement(helpDrawerSchoolTuitionArmedForcesLink);
                helpDrawerSchoolTuitionArmedForcesLink.click();
                break;
            case "School tuition: Armed Forces 2":
                basicActions.scrollToElement(helpDrawerSchoolTuitionArmedForces2Link);
                helpDrawerSchoolTuitionArmedForces2Link.click();
                break;
            case "School tuition: Disability 1":
                basicActions.scrollToElement(helpDrawerSchoolTuitionDisabilityLink);
                helpDrawerSchoolTuitionDisabilityLink.click();
                break;
            case "School tuition: Disability 2":
                basicActions.scrollToElement(helpDrawerSchoolTuitionDisability2Link);
                helpDrawerSchoolTuitionDisability2Link.click();
                break;
            case "Self-employment tax":
                basicActions.scrollToElement(helpDrawerSelfEmploymentTaxLink);
                helpDrawerSelfEmploymentTaxLink.click();
                break;
            case "Student Loan Interest":
                basicActions.scrollToElement(helpDrawerStudentLoanInterestLink);
                helpDrawerStudentLoanInterestLink.click();
                break;
            case "Self-employment Health Insurance":
                basicActions.scrollToElement(helpDrawerSelfEmploymentHealthInsuranceLink);
                helpDrawerSelfEmploymentHealthInsuranceLink.click();
                break;
            case "Self-Employment Retirement Plan":
                basicActions.scrollToElement(helpDrawerSelfEmploymentRetirementLink);
                helpDrawerSelfEmploymentRetirementLink.click();
                break;
            case "Moving Expenses":
                basicActions.scrollToElement(helpDrawerMovingExpensesLink);
                helpDrawerMovingExpensesLink.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + lnkName);
        }
    }



    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    public void verifyHeadersEmploymentSummaryPage(String language){
        switch (language){
            case "English":
                verifyHeadersEmploymentSummaryPageEnglish();
                break;
            case "Spanish":
                verifyHeadersEmploymentSummaryPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersEmploymentSummaryPageEnglish(){
        basicActions.waitForElementToBePresentWithRetries(hdr_Income,60);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Income: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(hdr_Employment.getText(),"Employment");
        softAssert.assertAll();
    }

    public void verifyHeadersEmploymentSummaryPageSpanish(){
        basicActions.waitForElementToBePresent(hdr_Income,15);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(hdr_Employment.getText(),"Ingresos por empleo");
        softAssert.assertAll();
    }

    public void validateHelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 30);
        basicActions.waitForElementToBePresent(helpDrawerHeaderEmploymentSummary, 30);
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
        softAssert.assertEquals(helpDrawerHeaderEmploymentSummary.getText(), "Employment summary");
        softAssert.assertEquals(helpDrawerMainHeaders.getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "This page provides a summary of the jobs, self-employment and income details you\u2019ve provided for your household. Review the information carefully and make updates if needed. This ensures the financial help you may receive is accurate.");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderEmploymentSummary.getText(), "Resumen del empleo");
        softAssert.assertEquals(helpDrawerMainHeaders.getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Esta p\u00E1gina muestra un resumen de la informaci\u00F3n sobre los empleos, el trabajo independiente y el ingreso que proporcion\u00F3 respecto a su familia. Revise la informaci\u00F3n con cuidado y actual\u00EDcela de ser necesario. Con esto se garantiza que la ayuda financiera que pueda recibir sea la correcta.");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateTextEmploymentSummaryPage(String language) {
        basicActions.waitForElementToBePresent(hdr_Income, 15);
        switch (language) {
            case "English":
                validateEnglishTextEmploymentSummaryPage();
                break;
            case "Spanish":
                validateSpanishTextEmploymentSummaryPage();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateEnglishTextEmploymentSummaryPage() {
        basicActions.waitForElementToBePresentWithRetries(hdr_Income, 30);
        basicActions.waitForElementToBePresentWithRetries(hdr_Employment, 30);
        basicActions.waitForElementListToBePresentWithRetries(jobOrSelfEmploymentHeaders, 60);

        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Income: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertTrue(hdr_Employment.getText().contains("Employment"), "Header text mismatch!");
        softAssert.assertEquals(jobOrSelfEmploymentHeaders.get(0).getText(), "Job or Self-Employment Income");
        softAssert.assertEquals(jobOrSelfEmploymentHeaders.get(1).getText(), "Total Job or Employment Income");

        softAssert.assertEquals(employmentSummaryBoldTexts.get(0).getText(), "Company Name");
        softAssert.assertEquals(employmentSummaryBoldTexts.get(1).getText(), "Self-employed");
        softAssert.assertEquals(employmentSummaryBoldTexts.get(2).getText(), "Job Income");
        softAssert.assertEquals(employmentSummaryBoldTexts.get(3).getText(), "Frequency");
        softAssert.assertEquals(employmentSummaryBoldTexts.get(4).getText(), "Annual Total");

        softAssert.assertEquals(btnContinue.getText(), "Continue");
        softAssert.assertEquals(lnkEditIncome.getText(), "Edit/Update");
        softAssert.assertEquals(lnkRemoveJob.get(0).getText(), "Remove this job");
        softAssert.assertEquals(btnAddJob.getText(), "+ Add job or self-employment");
        softAssert.assertEquals(btnGoBack.getText(), "Go back");

        softAssert.assertAll();
    }

    public void validateSpanishTextEmploymentSummaryPage() {
        basicActions.waitForElementToBePresent(hdr_Income, 15);

        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(hdr_Employment.getText(), "Ingresos por empleo");
        softAssert.assertEquals(jobOrSelfEmploymentHeaders.get(0).getText(), "Ingreso por empleo o por trabajo independiente");
        softAssert.assertEquals(jobOrSelfEmploymentHeaders.get(1).getText(), "Ingreso total por empleo o por trabajo independiente");

        softAssert.assertEquals(employmentSummaryBoldTexts.get(0).getText(), "Nombre de la compa\u00F1\u00EDa");
        softAssert.assertEquals(employmentSummaryBoldTexts.get(1).getText(), "Trabajadores por cuenta propia");
        softAssert.assertEquals(employmentSummaryBoldTexts.get(2).getText(), "Ingresos laborales");
        softAssert.assertEquals(employmentSummaryBoldTexts.get(3).getText(), "Frecuencia");
        softAssert.assertEquals(employmentSummaryBoldTexts.get(4).getText(), "Total anual");

        softAssert.assertEquals(btnContinue.getText(), "Continuar");
        softAssert.assertEquals(lnkEditIncome.getText(), "Editar/Actualizar");
        softAssert.assertEquals(lnkRemoveJob.get(0).getText(), "Eliminar este trabajo");
        softAssert.assertEquals(btnAddJob.getText(), "+ Agregar un empleo o trabajo independiente");
        softAssert.assertEquals(btnGoBack.getText(), "Volver");

        softAssert.assertAll();
    }

    public void validateBoldTextEmploymentSummaryPage() {
        basicActions.waitForElementToBePresent(hdr_Income, 15);

        // Validating Income Header
        softAssert.assertEquals(hdr_Income.getCssValue("font-size"), "36px", "Font size mismatch for Income");
        softAssert.assertEquals(hdr_Income.getCssValue("font-weight"), "700", "Font weight mismatch for Income");
        softAssert.assertEquals(hdr_Income.getCssValue("line-height"), "48px", "Line height mismatch for Income");
        softAssert.assertEquals(hdr_Income.getCssValue("color"), "rgba(43, 49, 60, 1)", "Color mismatch for Income");

        // Validating Employment Header
        softAssert.assertEquals(hdr_Employment.getText(), "Employment", "Text mismatch for Employment");
        softAssert.assertEquals(hdr_Employment.getCssValue("font-size"), "28px", "Font size mismatch for Employment");
        softAssert.assertEquals(hdr_Employment.getCssValue("font-weight"), "700", "Font weight mismatch for Employment");
        softAssert.assertEquals(hdr_Employment.getCssValue("line-height"), "40px", "Line height mismatch for Employment");
        softAssert.assertEquals(hdr_Employment.getCssValue("color"), "rgba(43, 49, 60, 1)", "Color mismatch for Employment");

        // Validating Job or Self-Employment Header
        softAssert.assertEquals(jobOrSelfEmploymentHeaders.get(0).getText(), "Job or Self-Employment Income", "Text mismatch for Job or Self-Employment Income");
        softAssert.assertEquals(jobOrSelfEmploymentHeaders.get(0).getCssValue("font-size"), "19px", "Font size mismatch");
        softAssert.assertEquals(jobOrSelfEmploymentHeaders.get(0).getCssValue("font-weight"), "700", "Font weight mismatch");
        softAssert.assertEquals(jobOrSelfEmploymentHeaders.get(0).getCssValue("line-height"), "28px", "Line height mismatch");
        softAssert.assertEquals(jobOrSelfEmploymentHeaders.get(0).getCssValue("color"), "rgba(77, 77, 79, 1)", "Color mismatch");

        // Validating Edit/Update Link
        softAssert.assertEquals(lnkEditIncome.getText(), "Edit/Update", "Text mismatch for Edit/Update");
        softAssert.assertEquals(lnkEditIncome.getCssValue("font-size"), "14px", "Font size mismatch");
        softAssert.assertEquals(lnkEditIncome.getCssValue("font-weight"), "400", "Font weight mismatch");
        softAssert.assertEquals(lnkEditIncome.getCssValue("line-height"), "24px", "Line height mismatch");
        softAssert.assertEquals(lnkEditIncome.getCssValue("color"), "rgba(26, 112, 179, 1)", "Color mismatch");

        // Validating Buttons
        softAssert.assertEquals(hdr_Income.getCssValue("font-size"), "36px", "Font size mismatch for Income");
        softAssert.assertEquals(hdr_Income.getCssValue("font-weight"), "700", "Font weight mismatch for Income");
        softAssert.assertEquals(hdr_Income.getCssValue("line-height"), "48px", "Line height mismatch for Income");
        softAssert.assertEquals(hdr_Income.getCssValue("color"), "rgba(43, 49, 60, 1)", "Color mismatch for Income");

        // Go Back Button
        softAssert.assertEquals(btnGoBack.getText(), "Go back", "Button text mismatch");
        softAssert.assertEquals(btnGoBack.getCssValue("background-color"), "rgba(252, 252, 252, 1)", "Button background mismatch for Go back");
        softAssert.assertEquals(btnGoBack.getCssValue("border"), "2px solid rgb(26, 112, 179)", "Button border mismatch for Go back");
        softAssert.assertEquals(btnGoBack.getCssValue("border-radius"), "4px", "Button border-radius mismatch for Go back");
        softAssert.assertEquals(btnGoBack.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch for Go back");
        softAssert.assertEquals(btnGoBack.getCssValue("font-size"), "20px", "Font size mismatch for Go back");
        softAssert.assertEquals(btnGoBack.getCssValue("color"), "rgba(26, 112, 179, 1)", "Text color mismatch for Go back");

        // Continue Button
        softAssert.assertEquals(btnContinue.getText(), "Continue", "Button text mismatch for Continue");
        softAssert.assertEquals(btnContinue.getCssValue("background-color"), "rgba(26, 112, 179, 1)", "Button background mismatch for Continue");
        softAssert.assertEquals(btnContinue.getCssValue("border"), "2px solid rgb(26, 112, 179)", "Button border mismatch for Continue");
        softAssert.assertEquals(btnContinue.getCssValue("border-radius"), "4px", "Button border-radius mismatch for Continue");
        softAssert.assertEquals(btnContinue.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch for Continue");
        softAssert.assertEquals(btnContinue.getCssValue("font-size"), "20px", "Font size mismatch for Continue");
        softAssert.assertEquals(btnContinue.getCssValue("color"), "rgba(252, 252, 252, 1)", "Text color mismatch for Continue");
        softAssert.assertAll();
    }
    public void clickOnGoBack(){
        basicActions.waitForElementToBePresent(btnGoBack,10);
        btnGoBack.click();
    }

}
