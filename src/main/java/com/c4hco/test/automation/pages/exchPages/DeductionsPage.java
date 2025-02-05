package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;
import static com.c4hco.test.automation.utils.WebDriverManager.getDriver;

public class DeductionsPage {
    private BasicActions basicActions;
    Actions actions = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    SoftAssert softAssert = new SoftAssert();
    public DeductionsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".header-1")
    WebElement IncomeSummaryHeader;

    @FindBy(css = ".header-2")
    WebElement DeductionSummaryHeader;

    @FindBy(css = "app-deductions .additional-income-row button")
    List<WebElement> addtlDeductionOptionsCheckbox;

    @FindBy(css = "lib-checkbox-control label")
    List<WebElement> addtlDeductionBox;

    @FindBy(id = "ELIG-Deductions-AOSS-amountInput")
    WebElement txtAOSSAmount;

    @FindBy(id = "ELIG-Deductions-AOSS-frequencySelect")
    WebElement selectAOSSFrequency;

    @FindBy(id = "ELIG-Deductions-PRAC-amountInput")
    WebElement txtPRACAmount;

    @FindBy(id = "ELIG-Deductions-PRAC-frequencySelect")
    WebElement selectPRACFrequency;

    @FindBy(id = "ELIG-Deductions-SETX-amountInput")
    WebElement txtSETXAmount;

    @FindBy(id = "ELIG-Deductions-SETX-frequencySelect")
    WebElement selectSETXFrequency;

    @FindBy(css = ".monetary-input-container input")
    List<WebElement> deductionsAmount;

    @FindBy(css = ".col .form-select")
    List<WebElement> deductionsFrequency;

    @FindBy(css = "lib-error-msg > div")
    List<WebElement> hdrError;

    @FindBy(css = "lib-list-error .error-message")
    WebElement deductionsSelectError;

    @FindBy(css = "lib-input .row.error-row")
    List<WebElement> deductionsAmountError;

    @FindBy(css = "lib-dropdown .row.error-row")
    List<WebElement> deductionsFrequencyError;

    @FindBy(id = "Deductions-SaveAndContinue")
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
    WebElement helpDrawerHeaderDeductions;

    @FindBy(css = "div.drawer-text-content.body-text-1 > b")
    List<WebElement> helpDrawerMainHeaders;

    @FindBy(css = ".drawer-text-content.body-text-1")
    WebElement helpDrawerParagraphs;

    @FindBy(css = "div.drawer-text-content.body-text-1 > p")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = "div.drawer-text-content.body-text-1 > ul > li")
    List<WebElement> helpDrawerBodySubParagraphs;

    @FindBy(css = ".drawer-text-content.body-text-1 a")
    WebElement helpDrawerParagraphLink;

    @FindBy(css = ".drawer-text-content.body-text-1 a:nth-child(6)")
    WebElement helpDrawerParagraphLink2;

    @FindAll({
            @FindBy(css = ".drawer-text-content.body-text-1 a:nth-child(8)"),
            @FindBy(css = ".drawer-text-content.body-text-1 a:nth-child(7)")})
    WebElement helpDrawerParagraphLink3;

    @FindAll({
            @FindBy(css = ".drawer-text-content.body-text-1 a:nth-child(10)"),
            @FindBy(css = ".drawer-text-content.body-text-1 a:nth-child(11)")})
    WebElement helpDrawerParagraphLink4;

    @FindAll({
            @FindBy(css = ".drawer-text-content.body-text-1 a:nth-child(13)"),
            @FindBy(css = ".drawer-text-content.body-text-1 a:nth-child(11)")})
    WebElement helpDrawerParagraphLink5;

    @FindAll({
            @FindBy(css = ".drawer-text-content.body-text-1 a:nth-child(16)"),
            @FindBy(css = ".drawer-text-content.body-text-1 a:nth-child(14)")})
    WebElement helpDrawerParagraphLink6;

    @FindAll({
            @FindBy(css = ".drawer-text-content.body-text-1 a:nth-child(18)"),
            @FindBy(css = ".drawer-text-content.body-text-1 a:nth-child(15)")})
    WebElement helpDrawerParagraphLink7;

    @FindBy(css = "ul > li:nth-child(2) > a")
    WebElement helpDrawerAlimonyPaidLink;

    @FindBy(css = "ul > li:nth-child(3) > a")
    WebElement helpDrawerDomesticProductionPropertyLink;

    @FindBy(css = "ul > li:nth-child(5) > a")
    WebElement helpDrawerPreTaxRetirementIncomeLink;

    @FindBy(css = "ul > li:nth-child(6) > a:nth-child(5)")
    WebElement helpDrawerSchoolTuitionDeductionsLink;

    @FindBy(css = "ul > li:nth-child(6) > a:nth-child(8)")
    WebElement helpDrawerSchoolTuitionSelfEmployed1Link;

    @FindAll({
            @FindBy(css = "ul > li:nth-child(6) > a:nth-child(10)"),
            @FindBy(css = "ul > li:nth-child(6) > a:nth-child(9)")})
    WebElement helpDrawerSchoolTuitionSelfEmployed2Link;

    @FindAll({
            @FindBy(css = "ul > li:nth-child(6) > a:nth-child(12)"),
            @FindBy(css = "ul > li:nth-child(6) > a:nth-child(13)")})
    WebElement helpDrawerSchoolTuitionArmedForces1Link;

    @FindAll({
            @FindBy(css = "ul > li:nth-child(6) > a:nth-child(15)"),
            @FindBy(css = "ul > li:nth-child(6) > a:nth-child(13)")})
    WebElement helpDrawerSchoolTuitionArmedForces2Link;

    @FindAll({
            @FindBy(css = "ul > li:nth-child(6) > a:nth-child(18)"),
            @FindBy(css = "ul > li:nth-child(6) > a:nth-child(16)")})
    WebElement helpDrawerSchoolTuitionDisability1Link;

    @FindAll({
            @FindBy(css = "ul > li:nth-child(6) > a:nth-child(20)"),
            @FindBy(css = "ul > li:nth-child(6) > a:nth-child(17)")})
    WebElement helpDrawerSchoolTuitionDisability2Link;

    @FindBy(css = "ul > li:nth-child(7) > a")
    WebElement helpDrawerSelfEmploymentTaxLink;

    @FindBy(css = "ul > li:nth-child(8) > a")
    WebElement helpDrawerStudentLoadLink;

    @FindBy(css = "ul > li:nth-child(9) > a")
    WebElement helpDrawerSelfEmploymentInsuranceLink;

    @FindBy(css = "ul > li:nth-child(10) > a")
    WebElement helpDrawerSelfEmploymentRetirementLink;

    @FindBy(css = "ul > li:nth-child(11) > a")
    WebElement helpDrawerMovingLink;

    @FindBy(css = ".drawer-footer h3")
    WebElement helpDrawerFooter;

    @FindBy(css = ".drawer-footer h3 a")
    WebElement helpDrawerContactUsLink;

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(css=".parent-position .body-text-1:nth-child(1)")
    WebElement expenseQuestion;

    @FindBy(css=".parent-position .body-text-1:nth-child(2)")
    WebElement selectAllThatApplyLabel;

    @FindBy(css = ".checkbox-container span")
    List<WebElement> checkBoxLabels;

    @FindBy(css="span .btn-second-action-button")
    WebElement goBackButton;

    @FindBy(xpath = "(//button[@role='checkbox'])[position()<11]")
    List<WebElement> ExpenseCheckBoxes;

    @FindBy(xpath = "//div//div//lib-fi[@name='dollar-sign']//*[position()=2]")
    List<WebElement> DollarSignForExpenseCheckboxes;

    @FindBy(css = ".col .form-select option")
    List<WebElement> frequencyDropdownValues;

    public void selectAddtlDeductionOption(String addtlDeductionOption, String Amount, String Frequency){
        switch(addtlDeductionOption){
            case "Alimony or spousal support paid out":
                addtlDeductionOptionsCheckbox.get(0).click();
                basicActions.waitForElementToBeClickable(txtAOSSAmount, 10);
                txtAOSSAmount.sendKeys(Amount);

                Select dropdown = new Select(selectAOSSFrequency);
                dropdown.selectByVisibleText(" "+Frequency+" ");
                break;
            case "Pre-tax retirement account contribution":
                basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 10);
                addtlDeductionOptionsCheckbox.get(3).click();
                txtPRACAmount.sendKeys(Amount);

                Select dropdown4 = new Select(selectPRACFrequency);
                dropdown4.selectByVisibleText(" "+Frequency+" ");
                break;
            case "Self-employment tax":
                basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 10);
                addtlDeductionOptionsCheckbox.get(5).click();
                txtSETXAmount.sendKeys(Amount);

                Select dropdown6 = new Select(selectSETXFrequency);
                dropdown6.selectByVisibleText(" "+Frequency+" ");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlDeductionOption);
        }
    }

    public void selectNoneAddtlDeductionOption(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 20);
        addtlDeductionOptionsCheckbox.get(10).click();
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
    }

    public void clickContinue(){
        basicActions.waitForElementToBePresentWithRetries(DeductionSummaryHeader,5);
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
        basicActions.scrollToElement(saveAndContinueBtn);
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
            case "Alimony paid out":
                helpLnk.get(1).click();
                break;
            case "Domestic production activities":
                helpLnk.get(2).click();
                break;
            case "Health Savings Account contribution":
                helpLnk.get(3).click();
                break;
            case "Pre-tax retirement contribution":
                helpLnk.get(4).click();
                break;
            case "School tuition":
                helpLnk.get(5).click();
                break;
            case "Self-employment tax":
                helpLnk.get(6).click();
                break;
            case "Student Loan Interest":
                helpLnk.get(7).click();
                break;
            case "Self-employment Health Insurance":
                helpLnk.get(8).click();
                break;
            case "Self-employment Retirement Plan":
                helpLnk.get(9).click();
                break;
            case "Moving Expenses":
                helpLnk.get(10).click();
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
            case "Item":
                basicActions.scrollToElement(helpDrawerParagraphLink);
                helpDrawerParagraphLink.click();
                break;
            case "Item 2":
                basicActions.scrollToElement(helpDrawerParagraphLink2);
                helpDrawerParagraphLink2.click();
                break;
            case "Item 3":
                basicActions.scrollToElement(helpDrawerParagraphLink3);
                helpDrawerParagraphLink3.click();
                break;
            case "Item 4":
                basicActions.scrollToElement(helpDrawerParagraphLink4);
                helpDrawerParagraphLink4.click();
                break;
            case "Item 5":
                basicActions.scrollToElement(helpDrawerParagraphLink5);
                helpDrawerParagraphLink5.click();
                break;
            case "Item 6":
                basicActions.scrollToElement(helpDrawerParagraphLink6);
                helpDrawerParagraphLink6.click();
                break;
            case "Item 7":
                basicActions.scrollToElement(helpDrawerParagraphLink7);
                helpDrawerParagraphLink7.click();
                break;
            case "Alimony paid out":
                basicActions.scrollToElement(helpDrawerAlimonyPaidLink);
                helpDrawerAlimonyPaidLink.click();
                break;
            case "Domestic production activities":
                basicActions.scrollToElement(helpDrawerDomesticProductionPropertyLink);
                helpDrawerDomesticProductionPropertyLink.click();
                break;
            case "Pre-tax retirement contribution":
                basicActions.scrollToElement(helpDrawerPreTaxRetirementIncomeLink);
                helpDrawerPreTaxRetirementIncomeLink.click();
                break;
            case "School tuition":
                basicActions.scrollToElement(helpDrawerSchoolTuitionDeductionsLink);
                helpDrawerSchoolTuitionDeductionsLink.click();
                break;
            case "School tuition: Self-Employed 1":
                basicActions.scrollToElement(helpDrawerSchoolTuitionSelfEmployed1Link);
                helpDrawerSchoolTuitionSelfEmployed1Link.click();
                break;
            case "School tuition: Self-Employed 2":
                basicActions.scrollToElement(helpDrawerSchoolTuitionSelfEmployed2Link);
                helpDrawerSchoolTuitionSelfEmployed2Link.click();
                break;
            case "School tuition: Armed Forces 1":
                basicActions.scrollToElement(helpDrawerSchoolTuitionArmedForces1Link);
                helpDrawerSchoolTuitionArmedForces1Link.click();
                break;
            case "School tuition: Armed Forces 2":
                basicActions.scrollToElement(helpDrawerSchoolTuitionArmedForces2Link);
                helpDrawerSchoolTuitionArmedForces2Link.click();
                break;
            case "School tuition: Disability 1":
                basicActions.scrollToElement(helpDrawerSchoolTuitionDisability1Link);
                helpDrawerSchoolTuitionDisability1Link.click();
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
                basicActions.scrollToElement(helpDrawerStudentLoadLink);
                helpDrawerStudentLoadLink.click();
                break;
            case "Self-employment Health Insurance":
                basicActions.scrollToElement(helpDrawerSelfEmploymentInsuranceLink);
                helpDrawerSelfEmploymentInsuranceLink.click();
                break;
            case "Self-Employment Retirement Plan":
                basicActions.scrollToElement(helpDrawerSelfEmploymentRetirementLink);
                helpDrawerSelfEmploymentRetirementLink.click();
                break;
            case "Moving Expenses":
                basicActions.scrollToElement(helpDrawerMovingLink);
                int elementWidth = helpDrawerMovingLink.getSize().getWidth(); //Click left of center due to chat widget
                int elementHeight = helpDrawerMovingLink.getSize().getHeight();
                int centerX = elementWidth / 2;
                int centerY = elementHeight / 2;
                int offsetX = centerX - 200;
                actions.moveToElement(helpDrawerMovingLink, offsetX, centerY)
                        .click()
                        .perform();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + lnkName);
        }
    }



    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void verifyHeadersDeductionsPage(String language){
        switch (language){
            case "English":
                verifyHeadersDeductionsPageEnglish();
                break;
            case "Spanish":
                verifyHeadersDeductionsPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersDeductionsPageEnglish(){
        basicActions.waitForElementToBePresent(DeductionSummaryHeader,15);
        softAssert.assertTrue(IncomeSummaryHeader.getText().equalsIgnoreCase("Income: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(DeductionSummaryHeader.getText(),"Deductions");
        softAssert.assertAll();
    }

    public void verifyHeadersDeductionsPageSpanish(){
        basicActions.waitForElementToBePresent(DeductionSummaryHeader,15);
        softAssert.assertTrue(IncomeSummaryHeader.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(DeductionSummaryHeader.getText(),"Deducciones");
        softAssert.assertAll();
    }

    public void selectAddtlDeductionOptionOnly(String addtlDeductionOption){
//        Alimony or spousal support paid out = AOSS
//        Domestic production activities = DPAC
//        Health Savings Account contribution = HSAC
//        Pre-tax retirement account contribution = PRAC
//        School tuition and fees = STAF
//        Self-employment tax = SETX
//        Student loan interest = STLI
//        Self-employment health insurance = SEHI
//        Self-employment retirement plan = SERP
//        Moving expenses = MOVE
//        None of these = NoDeductions

        basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 20);
        WebElement addtlDeductionOptionBox = basicActions.getDriver().findElement(By.xpath("//*[@id='ELIG-Deductions-"+addtlDeductionOption+"-checkBoxButton']"));
        addtlDeductionOptionBox.click();
    }

    public void verifyDeductionsOptionAmt1Error(String language){
        switch (language) {
            case "English":
                softAssert.assertEquals(deductionsAmountError.get(0).getText(), "Amount is required");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(deductionsAmountError.get(0).getText(), "Esta cantidad es obligatoria");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyDeductionsOptionFreq1Error(String language){
        switch (language) {
            case "English":
                softAssert.assertEquals(deductionsFrequencyError.get(0).getText(), "Please select one of the options below");
                softAssert.assertEquals(hdrError.get(1).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(deductionsFrequencyError.get(0).getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(hdrError.get(1).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyDeductionsOptionNoError(){
        basicActions.waitForElementListToDisappear(deductionsAmountError, 10);
        basicActions.waitForElementListToDisappear(deductionsFrequencyError, 10);
        softAssert.assertAll();
    }

    public void verifyDeductionOption(String addtlDeductionOption, String Amount, String Frequency){
        switch(addtlDeductionOption){
            case "2nd Checked":
                softAssert.assertEquals(deductionsAmount.get(1).getAttribute("value"), Amount);
                softAssert.assertEquals(deductionsFrequency.get(1).getAttribute("value"), Frequency);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlDeductionOption);
        }
    }

    public void verifyDeductionsPageNoError(){
        basicActions.waitForElementToDisappear(deductionsSelectError, 10);
        softAssert.assertAll();
    }

    public void verifyDeductionsPageError(String language){
        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(deductionsSelectError,20);
                softAssert.assertEquals(deductionsSelectError.getText(), "Please select one or more of the options below");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(deductionsSelectError,20);
                softAssert.assertEquals(deductionsSelectError.getText(), "Seleccione una o m\u00E1s de las siguientes opciones");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateHelpVerbiage(String helpText, String language) {
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 30);
        basicActions.waitForElementToBePresent(helpDrawerHeaderDeductions, 30);
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
            case "Alimony paid out":switch (language) {
                case "English":
                    validateAlimonyPaidOutHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateAlimonyPaidOutHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Domestic production activities":switch (language) {
                case "English":
                    validateDomesticActivitiesHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateDomesticActivitiesHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Health Savings Account contribution":switch (language) {
                case "English":
                    validateHealthSavingsHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateHealthSavingsHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Pre-tax retirement contribution":switch (language) {
                case "English":
                    validatePreTaxRetireHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validatePreTaxRetireHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "School tuition":switch (language) {
                case "English":
                    validateSchoolTuitionHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateSchoolTuitionHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Self-employment tax":switch (language) {
                case "English":
                    validateSelfEmployTaxHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateSelfEmployTaxHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Student Loan Interest":switch (language) {
                case "English":
                    validateStudentLoanHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateStudentLoanHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Self-employment Health Insurance":switch (language) {
                case "English":
                    validateSelfEmployHealthHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateSelfEmployHealthHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Self-employment Retirement Plan":switch (language) {
                case "English":
                    validateSelfEmployRetireHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateSelfEmployRetireHelpBodyVerbiageSp();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
            break;
            case "Moving Expenses":switch (language) {
                case "English":
                    validateMovingExpensesHelpBodyVerbiageEng();
                    break;
                case "Spanish":
                    validateMovingExpensesHelpBodyVerbiageSp();
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
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Deductions");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "If there are things that can be deducted on an income tax return, telling us about them could make the cost of health insurance a little lower.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(0).getText(), "Deductions\nTell us all deductions you will take when filing taxes and tell us the amount of each deduction.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(1).getText(), "Alimony or spousal support paid out\nAlimony is a payment to a spouse or former spouse under a divorce or separation agreement. For more information, see:\n\nhttps://www.irs.gov/taxtopics/tc452\n\nIf your divorce or separation was finalized on or before December 31, 2018, you should include alimony or spousal support you paid in your Deductions. If your divorce or separation was finalized on or after January 1, 2019, do not include alimony or spousal support you pay in your Deductions.");
        softAssert.assertEquals(helpDrawerAlimonyPaidLink.getText(), "https://www.irs.gov/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(2).getText(), "Domestic production activities\nThe Domestic Production Activities Tax Deduction is intended to provide tax relief for businesses that produce goods in the United States rather than producing it overseas. For more information, see:\n\nhttps://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerDomesticProductionPropertyLink.getText(), "https://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(3).getText(), "Health Savings Account\nA type of savings account that lets you set aside money on a pre-tax basis to pay for qualified medical expenses. Enter contributions made to your health savings account, up to the yearly limit. For more information see IRS Form 8889.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(4).getText(), "Pre-tax retirement account contribution\nA pre-tax contribution is a payment made to a retirement account with money that has not been taxed. For more information, see:\n\nhttps://www.irs.gov/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerPreTaxRetirementIncomeLink.getText(), "https://www.irs.gov/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(5).getText(), "School tuition and fees\nCertain school tuition and fees are able to be deducted from your taxes. For more information, see:\n\nhttps://www.irs.gov/taxtopics/tc513\n\nSelf-Employed Individuals \u2013 https://www.irs.gov/pub/irs-pdf/f1040sc.pdf or https://www.irs.gov/pub/irs-pdf/f1040sf.pdf\n\nArmed Forces Reservists, Qualified Performing Artists, and State/Local Government Officials \u2013 https://www.irs.gov/pub/irs-pdf/f1040s1.pdf and https://www.irs.gov/pub/irs-pdf/f2106.pdf\n\nIndividuals with a Disability - https://www.irs.gov/pub/irs-pdf/f1040sa.pdf and https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionDeductionsLink.getText(), "https://www.irs.gov/taxtopics/tc513");
        softAssert.assertEquals(helpDrawerSchoolTuitionSelfEmployed1Link.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sc.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionSelfEmployed2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sf.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionArmedForces1Link.getText(), "https://www.irs.gov/pub/irs-pdf/f1040s1.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionArmedForces2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionDisability1Link.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sa.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionDisability2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(6).getText(), "Self-employment tax\nSelf-employment income is income that arises from the performance of personal services, but which cannot be classified as wages because an employer-employee relationship does not exist between the payer and the payee. The Internal Revenue Code imposes the self-employment tax on the self-employment income of any U.S. citizen or resident alien who has such self-employment income. For more information, see:\n\nhttps://www.irs.gov/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerSelfEmploymentTaxLink.getText(), "https://www.irs.gov/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(7).getText(), "Student Loan Interest\nStudent loan interest is interest you paid during the year on a qualified student loan. For more information, see:\n\nhttps://www.irs.gov/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerStudentLoadLink.getText(), "https://www.irs.gov/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(8).getText(), "Self-employment Health Insurance\nIf you are self-employed, there is a tax deduction generally available for medical, dental or long-term care insurance premiums that self-employed people often pay for themselves, their spouse and their dependents. For more information, see:\n\nhttps://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerSelfEmploymentInsuranceLink.getText(), "https://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(9).getText(), "Self-Employment Retirement Plan\nThere are numerous options for contributing to a retirement plan for the self-employed, and claiming a tax deduction for the contribution. For more information, see:\n\nhttps://www.irs.gov/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerSelfEmploymentRetirementLink.getText(), "https://www.irs.gov/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(10).getText(), "Moving Expenses\nIf you are a member of the U.S. Armed Forces on active duty and are moving due to a permanent change of duty station, you may deduct unreimbursed moving expenses. If you are not in the military, do not include moving expenses on your application. For more information, see:\n\nhttps://www.irs.gov/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerMovingLink.getText(), "https://www.irs.gov/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Deducciones");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Si hay ciertos gastos que puedan deducirse en una declaraci\u00F3n de impuestos, esta informaci\u00F3n nos servir\u00EDa para reducir un poco m\u00E1s el costo del seguro de salud.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(0).getText(), "Deducciones\nD\u00EDganos todas las deducciones que har\u00E1 cuando presente su declaraci\u00F3n de impuestos de este a\u00F1o e indique la cantidad de cada deducci\u00F3n.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(1).getText(), "Pensi\u00F3n alimenticia o apoyo conyugal que paga\nLa pensi\u00F3n alimenticia es un pago a un c\u00F3nyuge o exc\u00F3nyuge por un acuerdo de divorcio o separaci\u00F3n. Para m\u00E1s informaci\u00F3n visite:\n\nhttps://www.irs.gov/es/taxtopics/tc452\n\nSi su divorcio o separaci\u00F3n finaliz\u00F3 en o antes del 31 de diciembre de 2018, debe incluir la pensi\u00F3n alimenticia o apoyo conyugal que pag\u00F3 en sus Deducciones. Si su divorcio o separaci\u00F3n finaliz\u00F3 en o despu\u00E9s del 1\u00BA de enero de 2019, no incluya la pensi\u00F3n alimenticia o apoyo conyugal que pag\u00F3 en sus Deducciones.");
        softAssert.assertEquals(helpDrawerAlimonyPaidLink.getText(), "https://www.irs.gov/es/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(2).getText(), "Actividades de producci\u00F3n para el mercado interno\nLa Deducci\u00F3n de impuestos por actividades dom\u00E9sticas de producci\u00F3n pretende brindarle un alivio fiscal a las empresas que producen mercanc\u00EDa en los Estados Unidos en lugar de producirlas en el extranjero. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerDomesticProductionPropertyLink.getText(), "https://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(3).getText(), "Cuenta de ahorros de salud\nUn tipo de cuenta de ahorros que le permite ahorrar dinero en una base antes de impuestos para pagar los gastos m\u00E9dicos calificados. Ingrese las contribuciones hechas a su cuenta de ahorros de salud, hasta el l\u00EDmite anual. Para m\u00E1s informaci\u00F3n, consulte el formulario 8889 del IRS.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(4).getText(), "Aportes a la cuenta de retiro antes de impuestos\nUn aporte antes de impuestos es un pago realizado a una cuenta de retiro con dinero que no ha sido sujeto a impuestos. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/es/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerPreTaxRetirementIncomeLink.getText(), "https://www.irs.gov/es/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(5).getText(), "Colegiatura y cuotas escolares\nCiertas colegiaturas y cuotas de inscripci\u00F3n pueden ser deducidas de sus impuestos. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/es/taxtopics/tc513\n\nTrabajadores independientes: https://www.irs.gov/pub/irs-pdf/f1040scs.pdf o https://www.irs.gov/pub/irs-pdf/f1040sfs.pdf\n\nReservistas de las Fuerzas Armadas, artistas ejecutantes calificados y funcionarios del gobierno estatal y local: https://www.irs.gov/pub/irs-pdf/f1040s1s.pdf y https://www.irs.gov/pub/irs-pdf/f2106.pdf\n\nPersonas con alguna discapacidad: https://www.irs.gov/pub/irs-pdf/f1040sa.pdf y https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionDeductionsLink.getText(), "https://www.irs.gov/es/taxtopics/tc513");
        softAssert.assertEquals(helpDrawerSchoolTuitionSelfEmployed1Link.getText(), "https://www.irs.gov/pub/irs-pdf/f1040scs.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionSelfEmployed2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sfs.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionArmedForces1Link.getText(), "https://www.irs.gov/pub/irs-pdf/f1040s1s.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionArmedForces2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionDisability1Link.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sa.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionDisability2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(6).getText(), "Impuesto al trabajo independiente\nEl ingreso como trabajador independiente es ingreso que se genera por servicios personales otorgados, los cuales no pueden ser clasificados como sueldos, ya que no existe una relaci\u00F3n de empleador y el empleado entre el pagador y el beneficiario. El C\u00F3digo de impuestos internos impone el impuesto de trabajador independiente al ingreso de trabajo independiente sujeto a impuestos a todos los ciudadanos estadounidenses o extranjeros residentes que tienen dicho ingreso como trabajador independiente. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/es/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerSelfEmploymentTaxLink.getText(), "https://www.irs.gov/es/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(7).getText(), "Inter\u00E9s por pr\u00E9stamo de estudiante\nEl inter\u00E9s del pr\u00E9stamo estudiantil que paga durante el a\u00F1o de un pr\u00E9stamo estudiantil calificado. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/es/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerStudentLoadLink.getText(), "https://www.irs.gov/es/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(8).getText(), "Seguro de salud de trabajador independiente\nSi usted es trabajador independiente, hay una deducci\u00F3n generalmente disponible para las cuotas de seguro m\u00E9dico, dental o de atenci\u00F3n prolongada que las personas que trabajan de manera independiente pagan para s\u00ED mismos, para sus c\u00F3nyuges o para sus dependientes. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerSelfEmploymentInsuranceLink.getText(), "https://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(9).getText(), "Plan de retiro como trabajador independiente\nExisten m\u00FAltiples opciones de planes de retiro para los trabajadores independientes y para reclamar una deducci\u00F3n de impuestos por los aportes. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/es/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerSelfEmploymentRetirementLink.getText(), "https://www.irs.gov/es/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(10).getText(), "Gastos de mudanza\nSi es un miembro del servicio activo de las Fuerzas Armadas de Estados Unidos y se muda debido a un cambio permanente en la estaci\u00F3n de servicio, puede deducir los gastos de mudanza no reembolsados. Si no est\u00E1 en el servicio militar, no incluya gastos de mudanza en su solicitud. Para m\u00E1s informaci\u00F3n visite:\n\nhttps://www.irs.gov/es/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerMovingLink.getText(), "https://www.irs.gov/es/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateAlimonyPaidOutHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Alimony or spousal support paid out");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Alimony is a payment to a spouse or former spouse under a divorce or separation agreement. For more information, see:\n\nhttps://www.irs.gov/taxtopics/tc452\n\nIf your divorce or separation was finalized on or before December 31, 2018, you should include alimony or spousal support you paid in your Deductions. If your divorce or separation was finalized on or after January 1, 2019, do not include alimony or spousal support you pay in your Deductions.");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateAlimonyPaidOutHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Pensi\u00F3n alimenticia o apoyo conyugal que paga");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "La pensi\u00F3n alimenticia es un pago a un c\u00F3nyuge o exc\u00F3nyuge por un acuerdo de divorcio o separaci\u00F3n. Para m\u00E1s informaci\u00F3n visite:\n\nhttps://www.irs.gov/es/taxtopics/tc452\n\nSi su divorcio o separaci\u00F3n finaliz\u00F3 en o antes del 31 de diciembre de 2018, debe incluir la pensi\u00F3n alimenticia o apoyo conyugal que pag\u00F3 en sus Deducciones. Si su divorcio o separaci\u00F3n finaliz\u00F3 en o despu\u00E9s del 1\u00BA de enero de 2019, no incluya la pensi\u00F3n alimenticia o apoyo conyugal que pag\u00F3 en sus Deducciones.");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateDomesticActivitiesHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Domestic production activities");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "The Domestic Production Activities Tax Deduction is intended to provide tax relief for businesses that produce goods in the United States rather than producing it overseas. For more information, see:\n\nhttps://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateDomesticActivitiesHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Actividades de producci\u00F3n para el mercado interno");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "La Deducci\u00F3n de impuestos por actividades dom\u00E9sticas de producci\u00F3n pretende brindarle un alivio fiscal a las empresas que producen mercanc\u00EDa en los Estados Unidos en lugar de producirlas en el extranjero. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateHealthSavingsHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Health Savings Account");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "A type of savings account that lets you set aside money on a pre-tax basis to pay for qualified medical expenses. Enter contributions made to your health savings account, up to the yearly limit. For more information see IRS Form 8889.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateHealthSavingsHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Cuenta de ahorros de salud");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Un tipo de cuenta de ahorros que le permite ahorrar dinero en una base antes de impuestos para pagar los gastos m\u00E9dicos calificados. Ingrese las contribuciones hechas a su cuenta de ahorros de salud, hasta el l\u00EDmite anual. Para m\u00E1s informaci\u00F3n, consulte el formulario 8889 del IRS.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validatePreTaxRetireHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Pre-tax retirement account contribution");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "A pre-tax contribution is a payment made to a retirement account with money that has not been taxed. For more information, see:\n\nhttps://www.irs.gov/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validatePreTaxRetireHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Aportes a la cuenta de retiro antes de impuestos");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Un aporte antes de impuestos es un pago realizado a una cuenta de retiro con dinero que no ha sido sujeto a impuestos. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/es/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateSchoolTuitionHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "School tuition and fees");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Certain school tuition and fees are able to be deducted from your taxes. For more information, see:\n\nhttps://www.irs.gov/taxtopics/tc513\n\nSelf-Employed Individuals \u2013 https://www.irs.gov/pub/irs-pdf/f1040sc.pdf or https://www.irs.gov/pub/irs-pdf/f1040sf.pdf\n\nArmed Forces Reservists, Qualified Performing Artists, and State/Local Government Officials \u2013 https://www.irs.gov/pub/irs-pdf/f1040s1.pdf and https://www.irs.gov/pub/irs-pdf/f2106.pdf\n\nIndividuals with a Disability - https://www.irs.gov/pub/irs-pdf/f1040sa.pdf and https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/taxtopics/tc513");
        softAssert.assertEquals(helpDrawerParagraphLink2.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sc.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink3.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sf.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink4.getText(), "https://www.irs.gov/pub/irs-pdf/f1040s1.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink5.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink6.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sa.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink7.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateSchoolTuitionHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Colegiatura y cuotas escolares");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Ciertas colegiaturas y cuotas de inscripci\u00F3n pueden ser deducidas de sus impuestos. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/es/taxtopics/tc513\n\nTrabajadores independientes: https://www.irs.gov/pub/irs-pdf/f1040scs.pdf o https://www.irs.gov/pub/irs-pdf/f1040sfs.pdf\n\nReservistas de las Fuerzas Armadas, artistas ejecutantes calificados y funcionarios del gobierno estatal y local: https://www.irs.gov/pub/irs-pdf/f1040s1s.pdf y https://www.irs.gov/pub/irs-pdf/f2106.pdf\n\nPersonas con alguna discapacidad: https://www.irs.gov/pub/irs-pdf/f1040sa.pdf y https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/taxtopics/tc513");
        softAssert.assertEquals(helpDrawerParagraphLink2.getText(), "https://www.irs.gov/pub/irs-pdf/f1040scs.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink3.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sfs.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink4.getText(), "https://www.irs.gov/pub/irs-pdf/f1040s1s.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink5.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink6.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sa.pdf");
        softAssert.assertEquals(helpDrawerParagraphLink7.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateSelfEmployTaxHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Self-employment tax");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Self-employment income is income that arises from the performance of personal services, but which cannot be classified as wages because an employer-employee relationship does not exist between the payer and the payee. The Internal Revenue Code imposes the self-employment tax on the self-employment income of any U.S. citizen or resident alien who has such self-employment income. For more information, see:\n\nhttps://www.irs.gov/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateSelfEmployTaxHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Impuesto al trabajo independiente");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "El ingreso como trabajador independiente es ingreso que se genera por servicios personales otorgados, los cuales no pueden ser clasificados como sueldos, ya que no existe una relaci\u00F3n de empleador y el empleado entre el pagador y el beneficiario. El C\u00F3digo de impuestos internos impone el impuesto de trabajador independiente al ingreso de trabajo independiente sujeto a impuestos a todos los ciudadanos estadounidenses o extranjeros residentes que tienen dicho ingreso como trabajador independiente. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/es/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateStudentLoanHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Student Loan Interest");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Student loan interest is interest you paid during the year on a qualified student loan. For more information, see:\n\nhttps://www.irs.gov/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateStudentLoanHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Inter\u00E9s por pr\u00E9stamo de estudiante");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "El inter\u00E9s del pr\u00E9stamo estudiantil que paga durante el a\u00F1o de un pr\u00E9stamo estudiantil calificado. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/es/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateSelfEmployHealthHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Self-employment Health Insurance");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "If you are self-employed, there is a tax deduction generally available for medical, dental or long-term care insurance premiums that self-employed people often pay for themselves, their spouse and their dependents. For more information, see:\n\nhttps://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateSelfEmployHealthHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Seguro de salud de trabajador independiente");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Si usted es trabajador independiente, hay una deducci\u00F3n generalmente disponible para las cuotas de seguro m\u00E9dico, dental o de atenci\u00F3n prolongada que las personas que trabajan de manera independiente pagan para s\u00ED mismos, para sus c\u00F3nyuges o para sus dependientes. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateSelfEmployRetireHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Self-Employment Retirement Plan");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "There are numerous options for contributing to a retirement plan for the self-employed, and claiming a tax deduction for the contribution. For more information, see:\n\nhttps://www.irs.gov/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateSelfEmployRetireHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Plan de retiro como trabajador independiente");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Existen m\u00FAltiples opciones de planes de retiro para los trabajadores independientes y para reclamar una deducci\u00F3n de impuestos por los aportes. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/es/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateMovingExpensesHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Moving Expenses");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "If you are a member of the U.S. Armed Forces on active duty and are moving due to a permanent change of duty station, you may deduct unreimbursed moving expenses. If you are not in the military, do not include moving expenses on your application. For more information, see:\n\nhttps://www.irs.gov/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateMovingExpensesHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter,20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Gastos de mudanza");
        softAssert.assertEquals(helpDrawerParagraphs.getText(), "Si es un miembro del servicio activo de las Fuerzas Armadas de Estados Unidos y se muda debido a un cambio permanente en la estaci\u00F3n de servicio, puede deducir los gastos de mudanza no reembolsados. Si no est\u00E1 en el servicio militar, no incluya gastos de mudanza en su solicitud. Para m\u00E1s informaci\u00F3n visite:\n\nhttps://www.irs.gov/es/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerParagraphLink.getText(), "https://www.irs.gov/es/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyDeductionsOptionCheckbox(String state){
        switch (state){
            case "Selected":
                verifySelectedStateOfDeductionCheckboxes();
                break;
            case "Hover":
                verifyHoverStateOfDeductionCheckboxes();
                break;
            case "Focus":
                verifyFocusStateOfDeductionCheckboxes();
                break;
            case "Not Selected":
                verifyNotSelectedStateOfDeductionCheckboxes();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + state);
        }
    }

    public void verifyNotSelectedStateOfDeductionCheckboxes() {
        basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 15);
        for (int i = 0; i < addtlDeductionOptionsCheckbox.size(); i++) {
            WebElement element1 = addtlDeductionOptionsCheckbox.get(i);
            WebElement element2 = addtlDeductionBox.get(i);
            basicActions.wait(300);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(55, 55, 55)");
            softAssert.assertAll();
        }
    }

    public void verifyFocusStateOfDeductionCheckboxes() {
        basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 15);
        for (int i = 0; i < addtlDeductionOptionsCheckbox.size(); i++) {
            WebElement element = addtlDeductionOptionsCheckbox.get(i);
            element.sendKeys(Keys.SHIFT);
            basicActions.wait(300);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element.getCssValue("box-shadow"), "rgb(112, 163, 0) 0px 0px 7px 3px");
            softAssert.assertAll();
            DeductionSummaryHeader.click();
        }
    }

    public void verifyHoverStateOfDeductionCheckboxes() {
        basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 15);
        for (int i = 0; i < addtlDeductionOptionsCheckbox.size(); i++) {
            WebElement element = addtlDeductionOptionsCheckbox.get(i);
            actions.moveToElement(element).perform();
            basicActions.wait(300);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertAll();
            DeductionSummaryHeader.click();
        }
    }

    public void verifySelectedStateOfDeductionCheckboxes() {
        basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 15);
        for (int i = 0; i < addtlDeductionOptionsCheckbox.size(); i++) {
            WebElement element1 = addtlDeductionOptionsCheckbox.get(i);
            WebElement element2 = addtlDeductionBox.get(i);
            element1.click();
            DeductionSummaryHeader.click();
            basicActions.wait(300);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container checked"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(112, 163, 0, 1)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(112, 163, 0)");
            softAssert.assertAll();
            element1.click();
            DeductionSummaryHeader.click();
        }
    }

    public void verifyTextOnDeductionsPage(List<String> dataText) {
        basicActions.waitForElementToBePresent(IncomeSummaryHeader,20);
        basicActions.waitForElementToBePresent(DeductionSummaryHeader,20);
        basicActions.waitForElementToBePresent(expenseQuestion,20);
        basicActions.waitForElementToBePresent(selectAllThatApplyLabel,20);
        basicActions.waitForElementToBePresent(goBackButton,20);
        basicActions.waitForElementToBePresent(saveAndContinueBtn,20);
        basicActions.waitForElementToBePresent(helpSide,20);
        softAssert.assertEquals(IncomeSummaryHeader.getText(), dataText.get(0) + " " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(DeductionSummaryHeader.getText(), dataText.get(1), "Title Not matching");
        softAssert.assertEquals(expenseQuestion.getText(), dataText.get(2), "Expense Question Not matching");
        softAssert.assertEquals(selectAllThatApplyLabel.getText(), dataText.get(3), "Select All that Apply label Not matching");
        softAssert.assertEquals(checkBoxLabels.get(0).getText(), dataText.get(4), "Alimony or Spousal support label Not matching");
        softAssert.assertEquals(checkBoxLabels.get(1).getText(), dataText.get(5), "Domestic production label Not matching");
        softAssert.assertEquals(checkBoxLabels.get(2).getText(), dataText.get(6), "Health savings account label Not matching");
        softAssert.assertEquals(checkBoxLabels.get(3).getText(), dataText.get(7), "Pre-tax retirement label Not matching");
        softAssert.assertEquals(checkBoxLabels.get(4).getText(), dataText.get(8), "School tuition and fees label Not matching");
        softAssert.assertEquals(checkBoxLabels.get(5).getText(), dataText.get(9), "Self-employment tax label Not matching");
        softAssert.assertEquals(checkBoxLabels.get(6).getText(), dataText.get(10), "Student loan interest label Not matching");
        softAssert.assertEquals(checkBoxLabels.get(7).getText(), dataText.get(11), "Self-employment health insurance label Not matching");
        softAssert.assertEquals(checkBoxLabels.get(8).getText(), dataText.get(12), "Self-employment retirement plan label Not matching");
        softAssert.assertEquals(checkBoxLabels.get(9).getText(), dataText.get(13), "Moving expenses label Not matching");
        softAssert.assertEquals(checkBoxLabels.get(10).getText(), dataText.get(14), "None of these label Not matching");
        softAssert.assertEquals(goBackButton.getText().trim(), dataText.get(15), "Go back button text Not matching");
        softAssert.assertEquals(saveAndContinueBtn.getText(), dataText.get(16), "Save and continue button text Not matching");
        softAssert.assertEquals(helpSide.getText(), dataText.get(17), "Help button text Not matching");
        softAssert.assertAll();
    }

    public void clickOnAllExpenseCheckboxesAndVerifyInputFieldText(String dataText) {
        for(int i=0;i<ExpenseCheckBoxes.size();i++){
            ExpenseCheckBoxes.get(i).click();
            basicActions.waitForElementToBePresent(deductionsAmount.get(i),20);
            softAssert.assertTrue(DollarSignForExpenseCheckboxes.get(i).isDisplayed(),"Dollar sign not visible for" + " " + checkBoxLabels.get(i).getText() + " Expense."); // Verifying dollar sign is present
            softAssert.assertEquals(deductionsAmount.get(i).getAttribute("Placeholder"), dataText, "Amount label in input text field not matching for the expense" + " " + checkBoxLabels.get(i).getText());
        }
        softAssert.assertAll();
    }

    public void verifyDropdownValuesForAllTheExpenses(List<String> dataText) {
        for(int i=0;i<ExpenseCheckBoxes.size();i++) {
            deductionsFrequency.get(i).click();
            softAssert.assertEquals(frequencyDropdownValues.get(0).getText(), dataText.get(0), "Frequency dropdown value not matching for the expense " + checkBoxLabels.get(i).getText());
            softAssert.assertEquals(frequencyDropdownValues.get(1).getText(), dataText.get(1), "Frequency dropdown value not matching for the expense " + checkBoxLabels.get(i).getText());
            softAssert.assertEquals(frequencyDropdownValues.get(2).getText(), dataText.get(2), "Frequency dropdown value not matching for the expense " + checkBoxLabels.get(i).getText());
            softAssert.assertEquals(frequencyDropdownValues.get(3).getText(), dataText.get(3), "Frequency dropdown value not matching for the expense " + checkBoxLabels.get(i).getText());
            softAssert.assertEquals(frequencyDropdownValues.get(4).getText(), dataText.get(4), "Frequency dropdown value not matching for the expense " + checkBoxLabels.get(i).getText());
            softAssert.assertEquals(frequencyDropdownValues.get(5).getText(), dataText.get(5), "Frequency dropdown value not matching for the expense " + checkBoxLabels.get(i).getText());
        }
        softAssert.assertAll();
    }
    
    
    
    
    
    
    
    
    
    
    
}
