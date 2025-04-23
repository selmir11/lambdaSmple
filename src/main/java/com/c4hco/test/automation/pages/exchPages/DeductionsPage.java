package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

    @FindBy(id = "ELIG-Deductions-STAF-amountInput")
    WebElement txtSTAFAmount;

    @FindBy(id = "ELIG-Deductions-STLI-amountInput")
    WebElement txtSTLIAmount;

    @FindBy(id = "ELIG-Deductions-MOVE-amountInput")
    WebElement txtMoveAmount;
    @FindBy(id = "ELIG-Deductions-SERP-amountInput")
    WebElement txtSERPAmount;

    @FindBy(id = "ELIG-Deductions-SERP-frequencySelect")
    WebElement selectSERPFrequency;
    @FindBy(id = "ELIG-Deductions-SETX-frequencySelect")
    WebElement selectSETXFrequency;
    @FindBy(id = "ELIG-Deductions-MOVE-frequencySelect")
    WebElement selectMoveFrequency;

    @FindBy(id = "ELIG-Deductions-STLI-frequencySelect")
    WebElement selectSTLIFrequency;

    @FindBy(id = "ELIG-Deductions-STAF-frequencySelect")
    WebElement selectSATFFrequency;

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

    @FindBy(id = "Help.Button")
    WebElement helpSide;

    @FindBy(css = ".header-close-link")
    WebElement helpCloseLink;

    @FindBy(css = ".title-row .c4-text-body-200")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = ".title-row .title")
    WebElement helpDrawerHeaderDeductions;

    @FindBy(css = ".c4-text-body-200")
    List<WebElement> helpDrawerHeaders;

    @FindBy(css = "div.section-help-content-container > p")
    List<WebElement> helpDrawerNewParagraphs;

    @FindBy(css = "div.help-main-content > p")
    WebElement helpDrawerNewIconsParagraphs;

    @FindBy(css = "lib-help-window-link > a")
    List<WebElement> helpDrawerBodyNewLinks;

    @FindBy(css = ".help-footer .c4-type-links-md")
    List<WebElement> helpDrawerFooter;

    @FindBy(css = ".help-footer .clickable")
    WebElement helpDrawerContactUsLink;

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(css=".parent-position .body-text-1:nth-child(1)")
    WebElement expenseQuestion;

    @FindBy(css=".parent-position .body-text-1:nth-child(2)")
    WebElement selectAllThatApplyLabel;

    @FindBy(css = ".checkbox-container span")
    List<WebElement> checkBoxLabels;

    @FindBy(id="Deductions-GoBack")
    WebElement goBackButton;

    @FindBy(xpath = "(//button[@role='checkbox'])[position()<11]")
    List<WebElement> ExpenseCheckBoxes;

    @FindBy(xpath = "//div//div//lib-fi[@name='dollar-sign']//*[position()=2]")
    List<WebElement> DollarSignForExpenseCheckboxes;

    @FindBy(css = ".col .form-select option")
    List<WebElement> frequencyDropdownValues;

    @FindBy(xpath = "//div[@class='body-text-1']")
    List<WebElement> bodyTexts;

    @FindBy(xpath = "//hr")
    WebElement horizontalLine;

    @FindBy(xpath = "//*[@class='checkbox-label ng-star-inserted']")
    List<WebElement> labelAllDeductionOptions;

    @FindBy(xpath = "//*[name()='svg' and @class='feather feather-dollar-sign']")
    WebElement dollarSymbol;

    @FindBy(xpath = "//lib-button")
    List<WebElement> btnOutlineBackAndSave;

    @FindBy(xpath = "//label[@class='checkbox-container checked']")
    List<WebElement> checkBoxChecked;

    public void selectAddtlDeductionOption(String addtlDeductionOption, String Amount, String Frequency){
        switch(addtlDeductionOption){
            case "Alimony or spousal support paid out":
                basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 20);
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
            case "School tuition and fees":
                basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 10);
                addtlDeductionOptionsCheckbox.get(4).click();
                txtSTAFAmount.sendKeys(Amount);
                Select dropdown5 = new Select(selectSATFFrequency);
                dropdown5.selectByVisibleText(" "+Frequency+" ");
                break;
            case "Student loan interest":
                basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 10);
                addtlDeductionOptionsCheckbox.get(6).click();
                txtSTLIAmount.sendKeys(Amount);
                Select dropdown7 = new Select(selectSTLIFrequency);
                dropdown7.selectByVisibleText(" "+Frequency+" ");
                break;
            case "Moving expenses":
                basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 10);
                addtlDeductionOptionsCheckbox.get(9).click();
                txtMoveAmount.sendKeys(Amount);
                Select dropdown8 = new Select(selectMoveFrequency);
                dropdown8.selectByVisibleText(" "+Frequency+" ");
                break;

            case "Self-employment retirement plan":
                basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 10);
                addtlDeductionOptionsCheckbox.get(8).click();
                txtSERPAmount.sendKeys(Amount);
                Select dropdown9 = new Select(selectSERPFrequency);
                dropdown9.selectByVisibleText(" "+Frequency+" ");
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

    public void clickGoBack(){
        basicActions.waitForElementToBePresentWithRetries(DeductionSummaryHeader,5);
        basicActions.waitForElementToBeClickable(goBackButton, 20);
        basicActions.scrollToElement(goBackButton);
        goBackButton.click();
    }


    public void clickHelpIcon(String label) {
        basicActions.wait(50);
        basicActions.waitForElementListToBePresentWithRetries(helpLnk, 5);
        basicActions.waitForElementToBeClickable(helpLnk.get(0), 20);
        switch(label){
            case "Help me understand":
                helpLnk.get(0).click();
                break;
            case "side help":
                helpSide.click();
                break;
            case "close help":
                helpCloseLink.click();
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
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(0), 20);
                helpDrawerBodyNewLinks.get(0).click();
                break;
            case "Item 2":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(1), 20);
                helpDrawerBodyNewLinks.get(1).click();
                break;
            case "Item 3":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(2), 20);
                helpDrawerBodyNewLinks.get(2).click();
                break;
            case "Item 4":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(3), 20);
                helpDrawerBodyNewLinks.get(3).click();
                break;
            case "Item 5":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(4), 20);
                helpDrawerBodyNewLinks.get(4).click();
                break;
            case "Item 6":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(5), 20);
                helpDrawerBodyNewLinks.get(5).click();
                break;
            case "Item 7":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(6), 20);
                helpDrawerBodyNewLinks.get(6).click();
                break;
            case "Alimony paid out":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(0), 20);
                helpDrawerBodyNewLinks.get(0).click();
                break;
            case "Domestic production activities":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(1), 20);
                helpDrawerBodyNewLinks.get(1).click();
                break;
            case "Pre-tax retirement contribution":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(2), 20);
                helpDrawerBodyNewLinks.get(2).click();
                break;
            case "School tuition":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(3), 20);
                helpDrawerBodyNewLinks.get(3).click();
                break;
            case "School tuition: Self-Employed 1":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(4), 20);
                helpDrawerBodyNewLinks.get(4).click();
                break;
            case "School tuition: Self-Employed 2":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(5), 20);
                helpDrawerBodyNewLinks.get(5).click();
                break;
            case "School tuition: Armed Forces 1":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(6), 20);
                helpDrawerBodyNewLinks.get(6).click();
                break;
            case "School tuition: Armed Forces 2":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(7), 20);
                helpDrawerBodyNewLinks.get(7).click();
                break;
            case "School tuition: Disability 1":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(8), 20);
                helpDrawerBodyNewLinks.get(8).click();
                break;
            case "School tuition: Disability 2":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(9), 20);
                helpDrawerBodyNewLinks.get(9).click();
                break;
            case "Self-employment tax":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(10), 20);
                helpDrawerBodyNewLinks.get(10).click();
                break;
            case "Student Loan Interest":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(11), 20);
                helpDrawerBodyNewLinks.get(11).click();
                break;
            case "Self-employment Health Insurance":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(12), 20);
                helpDrawerBodyNewLinks.get(12).click();
                break;
            case "Self-Employment Retirement Plan":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(13), 20);
                helpDrawerBodyNewLinks.get(13).click();
                break;
            case "Moving Expenses":
                basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(14), 20);
                helpDrawerBodyNewLinks.get(14).click();
                /*String incomeSummaryHeaderText = IncomeSummaryHeader.getText().trim();
                if (incomeSummaryHeaderText.startsWith("Income")) { // English version
                    basicActions.waitForElementToBeClickableWithRetries(helpDrawerBodyNewLinks.get(14), 20);
                    basicActions.scrollToElement(helpDrawerBodyNewLinks.get(14));
                    int elementWidth = helpDrawerBodyNewLinks.get(14).getSize().getWidth();
                    int elementHeight = helpDrawerBodyNewLinks.get(14).getSize().getHeight();
                    int centerX = elementWidth / 2;
                    int centerY = elementHeight / 2;
                    int offsetX = centerX - 200; // Adjust click position to avoid chat widget
                    actions.moveToElement(helpDrawerBodyNewLinks.get(14), offsetX, centerY)
                            .click()
                            .perform();
                } else if (incomeSummaryHeaderText.startsWith("Ingresos")) { // Spanish version
                    helpDrawerBodyNewLinks.get(14).click();
                }*/
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
        basicActions.waitForElementToBePresent(DeductionSummaryHeader,60);
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
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaders.get(0).getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Deductions");
        softAssert.assertEquals(helpDrawerHeaders.get(1).getText(), "Overview");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(0).getText(), "If there are things that can be deducted on an income tax return, telling us about them could make the cost of health insurance a little lower.");
        softAssert.assertEquals(helpDrawerHeaders.get(2).getText(), "Deductions");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(1).getText(), "Tell us all deductions you will take when filing taxes and tell us the amount of each deduction.");
        softAssert.assertEquals(helpDrawerHeaders.get(3).getText(), "Alimony or spousal support paid out");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(2).getText(), "Alimony is a payment to a spouse or former spouse under a divorce or separation agreement. For more information, see:\nhttps://www.irs.gov/taxtopics/tc452\nIf your divorce or separation was finalized on or before December 31, 2018, you should include alimony or spousal support you paid in your Deductions. If your divorce or separation was finalized on or after January 1, 2019, do not include alimony or spousal support you pay in your Deductions.");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerHeaders.get(4).getText(), "Domestic production activities");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(3).getText(), "The Domestic Production Activities Tax Deduction is intended to provide tax relief for businesses that produce goods in the United States rather than producing it overseas. For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(1).getText(), "https://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerHeaders.get(5).getText(), "Health Savings Account");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(4).getText(), "A type of savings account that lets you set aside money on a pre-tax basis to pay for qualified medical expenses. Enter contributions made to your health savings account, up to the yearly limit. For more information see IRS Form 8889.");
        softAssert.assertEquals(helpDrawerHeaders.get(6).getText(), "Pre-tax retirement account contribution");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(5).getText(), "A pre-tax contribution is a payment made to a retirement account with money that has not been taxed. For more information, see:\nhttps://www.irs.gov/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(2).getText(), "https://www.irs.gov/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerHeaders.get(7).getText(), "School tuition and fees");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(6).getText(), "Certain school tuition and fees are able to be deducted from your taxes. For more information, see:\nhttps://www.irs.gov/taxtopics/tc513\nSelf-Employed Individuals - https://www.irs.gov/pub/irs-pdf/f1040sc.pdf or https://www.irs.gov/pub/irs-pdf/f1040sf.pdf\nArmed Forces Reservists, Qualified Performing Artists, and State/Local Government Officials \u2013 https://www.irs.gov/pub/irs-pdf/f1040s1.pdf and https://www.irs.gov/pub/irs-pdf/f2106.pdf\nIndividuals with a Disability - https://www.irs.gov/pub/irs-pdf/f1040sa.pdf and https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(3).getText(), "https://www.irs.gov/taxtopics/tc513");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(4).getText(), "https://www.irs.gov/pub/irs-pdf/f1040sc.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(5).getText(), "https://www.irs.gov/pub/irs-pdf/f1040sf.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(6).getText(), "https://www.irs.gov/pub/irs-pdf/f1040s1.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(7).getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(8).getText(), "https://www.irs.gov/pub/irs-pdf/f1040sa.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(9).getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerHeaders.get(8).getText(), "Self-employment tax");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(7).getText(), "Self-employment income is income that arises from the performance of personal services, but which cannot be classified as wages because an employer-employee relationship does not exist between the payer and the payee. The Internal Revenue Code imposes the self-employment tax on the self-employment income of any U.S. citizen or resident alien who has such self-employment income. For more information, see:\nhttps://www.irs.gov/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(10).getText(), "https://www.irs.gov/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerHeaders.get(9).getText(), "Student Loan Interest");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(8).getText(), "Student loan interest is interest you paid during the year on a qualified student loan. For more information, see:\nhttps://www.irs.gov/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(11).getText(), "https://www.irs.gov/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerHeaders.get(10).getText(), "Self-employment Health Insurance");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(9).getText(), "If you are self-employed, there is a tax deduction generally available for medical, dental or long-term care insurance premiums that self-employed people often pay for themselves, their spouse and their dependents. For more information, see:\nhttps://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(12).getText(), "https://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerHeaders.get(11).getText(), "Self-Employment Retirement Plan");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(10).getText(), "There are numerous options for contributing to a retirement plan for the self-employed, and claiming a tax deduction for the contribution. For more information, see:\nhttps://www.irs.gov/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(13).getText(), "https://www.irs.gov/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerHeaders.get(12).getText(), "Moving Expenses");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(11).getText(), "If you are a member of the U.S. Armed Forces on active duty and are moving due to a permanent change of duty station, you may deduct unreimbursed moving expenses. If you are not in the military, do not include moving expenses on your application. For more information, see:\nhttps://www.irs.gov/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(14).getText(), "https://www.irs.gov/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaders.get(0).getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Deducciones");
        softAssert.assertEquals(helpDrawerHeaders.get(1).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(0).getText(), "Si hay ciertos gastos que puedan deducirse en una declaraci\u00F3n de impuestos, esta informaci\u00F3n nos servir\u00EDa para reducir un poco m\u00E1s el costo del seguro de salud.");
        softAssert.assertEquals(helpDrawerHeaders.get(2).getText(), "Deducciones");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(1).getText(), "D\u00EDganos todas las deducciones que har\u00E1 cuando presente su declaraci\u00F3n de impuestos de este a\u00F1o e indique la cantidad de cada deducci\u00F3n.");
        softAssert.assertEquals(helpDrawerHeaders.get(3).getText(), "Pensi\u00F3n alimenticia o apoyo conyugal que paga");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(2).getText(), "La pensi\u00F3n alimenticia es un pago a un c\u00F3nyuge o exc\u00F3nyuge por un acuerdo de divorcio o separaci\u00F3n. Para m\u00E1s informaci\u00F3n visite:\nhttps://www.irs.gov/es/taxtopics/tc452\nSi su divorcio o separaci\u00F3n finaliz\u00F3 en o antes del 31 de diciembre de 2018, debe incluir la pensi\u00F3n alimenticia o apoyo conyugal que pag\u00F3 en sus Deducciones. Si su divorcio o separaci\u00F3n finaliz\u00F3 en o despu\u00E9s del 1\u00BA de enero de 2019, no incluya la pensi\u00F3n alimenticia o apoyo conyugal que pag\u00F3 en sus Deducciones.");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerHeaders.get(4).getText(), "Actividades de producci\u00F3n para el mercado interno");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(3).getText(), "La Deducci\u00F3n de impuestos por actividades dom\u00E9sticas de producci\u00F3n pretende brindarle un alivio fiscal a las empresas que producen mercanc\u00EDa en los Estados Unidos en lugar de producirlas en el extranjero. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(1).getText(), "https://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerHeaders.get(5).getText(), "Cuenta de ahorros de salud");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(4).getText(), "Un tipo de cuenta de ahorros que le permite ahorrar dinero en una base antes de impuestos para pagar los gastos m\u00E9dicos calificados. Ingrese las contribuciones hechas a su cuenta de ahorros de salud, hasta el l\u00EDmite anual. Para m\u00E1s informaci\u00F3n, consulte el formulario 8889 del IRS.");
        softAssert.assertEquals(helpDrawerHeaders.get(6).getText(), "Aportes a la cuenta de retiro antes de impuestos");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(5).getText(), "Un aporte antes de impuestos es un pago realizado a una cuenta de retiro con dinero que no ha sido sujeto a impuestos. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(2).getText(), "https://www.irs.gov/es/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerHeaders.get(7).getText(), "Colegiatura y cuotas escolares");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(6).getText(), "Ciertas colegiaturas y cuotas de inscripci\u00F3n pueden ser deducidas de sus impuestos. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc513\nTrabajadores independientes: https://www.irs.gov/pub/irs-pdf/f1040scs.pdf o https://www.irs.gov/pub/irs-pdf/f1040sfs.pdf\nReservistas de las Fuerzas Armadas, artistas ejecutantes calificados y funcionarios del gobierno estatal y local: https://www.irs.gov/pub/irs-pdf/f1040s1s.pdf y https://www.irs.gov/pub/irs-pdf/f2106.pdf\nPersonas con alguna discapacidad: https://www.irs.gov/pub/irs-pdf/f1040sa.pdf y https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(3).getText(), "https://www.irs.gov/es/taxtopics/tc513");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(4).getText(), "https://www.irs.gov/pub/irs-pdf/f1040scs.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(5).getText(), "https://www.irs.gov/pub/irs-pdf/f1040sfs.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(6).getText(), "https://www.irs.gov/pub/irs-pdf/f1040s1s.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(7).getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(8).getText(), "https://www.irs.gov/pub/irs-pdf/f1040sa.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(9).getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerHeaders.get(8).getText(), "Impuesto al trabajo independiente");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(7).getText(), "El ingreso como trabajador independiente es ingreso que se genera por servicios personales otorgados, los cuales no pueden ser clasificados como sueldos, ya que no existe una relaci\u00F3n de empleador y el empleado entre el pagador y el beneficiario. El C\u00F3digo de impuestos internos impone el impuesto de trabajador independiente al ingreso de trabajo independiente sujeto a impuestos a todos los ciudadanos estadounidenses o extranjeros residentes que tienen dicho ingreso como trabajador independiente. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(10).getText(), "https://www.irs.gov/es/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerHeaders.get(9).getText(), "Inter\u00E9s por pr\u00E9stamo de estudiante");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(8).getText(), "El inter\u00E9s del pr\u00E9stamo estudiantil que paga durante el a\u00F1o de un pr\u00E9stamo estudiantil calificado. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(11).getText(), "https://www.irs.gov/es/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerHeaders.get(10).getText(), "Seguro de salud de trabajador independiente");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(9).getText(), "Si usted es trabajador independiente, hay una deducci\u00F3n generalmente disponible para las cuotas de seguro m\u00E9dico, dental o de atenci\u00F3n prolongada que las personas que trabajan de manera independiente pagan para s\u00ED mismos, para sus c\u00F3nyuges o para sus dependientes. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(12).getText(), "https://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerHeaders.get(11).getText(), "Plan de retiro como trabajador independiente");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(10).getText(), "Existen m\u00FAltiples opciones de planes de retiro para los trabajadores independientes y para reclamar una deducci\u00F3n de impuestos por los aportes. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(13).getText(), "https://www.irs.gov/es/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerHeaders.get(12).getText(), "Gastos de mudanza");
        softAssert.assertEquals(helpDrawerNewParagraphs.get(11).getText(), "Si es un miembro del servicio activo de las Fuerzas Armadas de Estados Unidos y se muda debido a un cambio permanente en la estaci\u00F3n de servicio, puede deducir los gastos de mudanza no reembolsados. Si no est\u00E1 en el servicio militar, no incluya gastos de mudanza en su solicitud. Para m\u00E1s informaci\u00F3n visite:\nhttps://www.irs.gov/es/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(14).getText(), "https://www.irs.gov/es/forms-pubs/about-form-3903");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateAlimonyPaidOutHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Alimony or spousal support paid out");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Alimony is a payment to a spouse or former spouse under a divorce or separation agreement. For more information, see:\nhttps://www.irs.gov/taxtopics/tc452\nIf your divorce or separation was finalized on or before December 31, 2018, you should include alimony or spousal support you paid in your Deductions. If your divorce or separation was finalized on or after January 1, 2019, do not include alimony or spousal support you pay in your Deductions.");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateAlimonyPaidOutHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Pensi\u00F3n alimenticia o apoyo conyugal que paga");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "La pensi\u00F3n alimenticia es un pago a un c\u00F3nyuge o exc\u00F3nyuge por un acuerdo de divorcio o separaci\u00F3n. Para m\u00E1s informaci\u00F3n visite:\nhttps://www.irs.gov/es/taxtopics/tc452\nSi su divorcio o separaci\u00F3n finaliz\u00F3 en o antes del 31 de diciembre de 2018, debe incluir la pensi\u00F3n alimenticia o apoyo conyugal que pag\u00F3 en sus Deducciones. Si su divorcio o separaci\u00F3n finaliz\u00F3 en o despu\u00E9s del 1\u00BA de enero de 2019, no incluya la pensi\u00F3n alimenticia o apoyo conyugal que pag\u00F3 en sus Deducciones.");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/taxtopics/tc452");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateDomesticActivitiesHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Domestic production activities");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "The Domestic Production Activities Tax Deduction is intended to provide tax relief for businesses that produce goods in the United States rather than producing it overseas. For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateDomesticActivitiesHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Actividades de producci\u00F3n para el mercado interno");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "La Deducci\u00F3n de impuestos por actividades dom\u00E9sticas de producci\u00F3n pretende brindarle un alivio fiscal a las empresas que producen mercanc\u00EDa en los Estados Unidos en lugar de producirlas en el extranjero. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/pub/irs-pdf/i8903.pdf");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateHealthSavingsHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Health Savings Account");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "A type of savings account that lets you set aside money on a pre-tax basis to pay for qualified medical expenses. Enter contributions made to your health savings account, up to the yearly limit. For more information see IRS Form 8889.");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateHealthSavingsHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Cuenta de ahorros de salud");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Un tipo de cuenta de ahorros que le permite ahorrar dinero en una base antes de impuestos para pagar los gastos m\u00E9dicos calificados. Ingrese las contribuciones hechas a su cuenta de ahorros de salud, hasta el l\u00EDmite anual. Para m\u00E1s informaci\u00F3n, consulte el formulario 8889 del IRS.");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validatePreTaxRetireHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Pre-tax retirement account contribution");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "A pre-tax contribution is a payment made to a retirement account with money that has not been taxed. For more information, see:\nhttps://www.irs.gov/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validatePreTaxRetireHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Aportes a la cuenta de retiro antes de impuestos");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Un aporte antes de impuestos es un pago realizado a una cuenta de retiro con dinero que no ha sido sujeto a impuestos. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateSchoolTuitionHelpBodyVerbiageEng() {
        basicActions.wait(50);
        basicActions.waitForElementToBeClickable(helpDrawerFooter.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "School tuition and fees");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Certain school tuition and fees are able to be deducted from your taxes. For more information, see:\nhttps://www.irs.gov/taxtopics/tc513\nSelf-Employed Individuals - https://www.irs.gov/pub/irs-pdf/f1040sc.pdf or https://www.irs.gov/pub/irs-pdf/f1040sf.pdf\nArmed Forces Reservists, Qualified Performing Artists, and State/Local Government Officials \u2013 https://www.irs.gov/pub/irs-pdf/f1040s1.pdf and https://www.irs.gov/pub/irs-pdf/f2106.pdf\nIndividuals with a Disability - https://www.irs.gov/pub/irs-pdf/f1040sa.pdf and https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/taxtopics/tc513");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(1).getText(), "https://www.irs.gov/pub/irs-pdf/f1040sc.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(2).getText(), "https://www.irs.gov/pub/irs-pdf/f1040sf.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(3).getText(), "https://www.irs.gov/pub/irs-pdf/f1040s1.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(4).getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(5).getText(), "https://www.irs.gov/pub/irs-pdf/f1040sa.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(6).getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateSchoolTuitionHelpBodyVerbiageSp() {
        basicActions.wait(50);
        basicActions.waitForElementToBeClickable(helpDrawerFooter.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Colegiatura y cuotas escolares");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Ciertas colegiaturas y cuotas de inscripci\u00F3n pueden ser deducidas de sus impuestos. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc513\nTrabajadores independientes: https://www.irs.gov/pub/irs-pdf/f1040scs.pdf o https://www.irs.gov/pub/irs-pdf/f1040sfs.pdf\nReservistas de las Fuerzas Armadas, artistas ejecutantes calificados y funcionarios del gobierno estatal y local: https://www.irs.gov/pub/irs-pdf/f1040s1s.pdf y https://www.irs.gov/pub/irs-pdf/f2106.pdf\nPersonas con alguna discapacidad: https://www.irs.gov/pub/irs-pdf/f1040sa.pdf y https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/taxtopics/tc513");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(1).getText(), "https://www.irs.gov/pub/irs-pdf/f1040scs.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(2).getText(), "https://www.irs.gov/pub/irs-pdf/f1040sfs.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(3).getText(), "https://www.irs.gov/pub/irs-pdf/f1040s1s.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(4).getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(5).getText(), "https://www.irs.gov/pub/irs-pdf/f1040sa.pdf");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(6).getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateSelfEmployTaxHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Self-employment tax");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Self-employment income is income that arises from the performance of personal services, but which cannot be classified as wages because an employer-employee relationship does not exist between the payer and the payee. The Internal Revenue Code imposes the self-employment tax on the self-employment income of any U.S. citizen or resident alien who has such self-employment income. For more information, see:\nhttps://www.irs.gov/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateSelfEmployTaxHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Impuesto al trabajo independiente");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "El ingreso como trabajador independiente es ingreso que se genera por servicios personales otorgados, los cuales no pueden ser clasificados como sueldos, ya que no existe una relaci\u00F3n de empleador y el empleado entre el pagador y el beneficiario. El C\u00F3digo de impuestos internos impone el impuesto de trabajador independiente al ingreso de trabajo independiente sujeto a impuestos a todos los ciudadanos estadounidenses o extranjeros residentes que tienen dicho ingreso como trabajador independiente. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/individuals/international-taxpayers/self-employment-tax");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateStudentLoanHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Student Loan Interest");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Student loan interest is interest you paid during the year on a qualified student loan. For more information, see:\nhttps://www.irs.gov/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateStudentLoanHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Inter\u00E9s por pr\u00E9stamo de estudiante");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "El inter\u00E9s del pr\u00E9stamo estudiantil que paga durante el a\u00F1o de un pr\u00E9stamo estudiantil calificado. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/taxtopics/tc456");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateSelfEmployHealthHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Self-employment Health Insurance");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "If you are self-employed, there is a tax deduction generally available for medical, dental or long-term care insurance premiums that self-employed people often pay for themselves, their spouse and their dependents. For more information, see:\nhttps://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateSelfEmployHealthHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Seguro de salud de trabajador independiente");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Si usted es trabajador independiente, hay una deducci\u00F3n generalmente disponible para las cuotas de seguro m\u00E9dico, dental o de atenci\u00F3n prolongada que las personas que trabajan de manera independiente pagan para s\u00ED mismos, para sus c\u00F3nyuges o para sus dependientes. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateSelfEmployRetireHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Self-Employment Retirement Plan");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "There are numerous options for contributing to a retirement plan for the self-employed, and claiming a tax deduction for the contribution. For more information, see:\nhttps://www.irs.gov/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateSelfEmployRetireHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Plan de retiro como trabajador independiente");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Existen m\u00FAltiples opciones de planes de retiro para los trabajadores independientes y para reclamar una deducci\u00F3n de impuestos por los aportes. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/retirement-plans/retirement-plans-for-self-employed-people");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void validateMovingExpensesHelpBodyVerbiageEng() {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0),20);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Moving Expenses");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "If you are a member of the U.S. Armed Forces on active duty and are moving due to a permanent change of duty station, you may deduct unreimbursed moving expenses. If you are not in the military, do not include moving expenses on your application. For more information, see:\nhttps://www.irs.gov/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void validateMovingExpensesHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderDeductions.getText(), "Gastos de mudanza");
        softAssert.assertEquals(helpDrawerNewIconsParagraphs.getText(), "Si es un miembro del servicio activo de las Fuerzas Armadas de Estados Unidos y se muda debido a un cambio permanente en la estaci\u00F3n de servicio, puede deducir los gastos de mudanza no reembolsados. Si no est\u00E1 en el servicio militar, no incluya gastos de mudanza en su solicitud. Para m\u00E1s informaci\u00F3n visite:\nhttps://www.irs.gov/es/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerBodyNewLinks.get(0).getText(), "https://www.irs.gov/es/forms-pubs/about-form-3903");
        basicActions.waitForElementListToBePresent(helpDrawerFooter, 30);
        basicActions.scrollToElement(helpDrawerFooter.get(0));
        softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
        softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
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
        basicActions.waitForElementToBePresentWithRetries(IncomeSummaryHeader,60);
        basicActions.waitForElementToBePresentWithRetries(DeductionSummaryHeader,60);
        basicActions.waitForElementToBePresentWithRetries(expenseQuestion,60);
        basicActions.waitForElementToBePresentWithRetries(selectAllThatApplyLabel,60);
        basicActions.waitForElementToBePresentWithRetries(goBackButton,60);
        basicActions.waitForElementToBePresentWithRetries(saveAndContinueBtn,60);
        basicActions.waitForElementToBePresentWithRetries(helpSide,60);
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

    public void verifyAllDeductioncheckboxErrors(String language) {
        int checkBoxCount = addtlDeductionBox.size();
        for (int i = 0; i < checkBoxCount-1; i++) {
            addtlDeductionBox.get(i).click();
            saveAndContinueBtn.click();
            verifyDeductionsOptionAmt1Error(language);
            verifyDeductionsOptionFreq1Error(language);
            addtlDeductionBox.get(i).click();
        }
    }
    public void clickOnGoBackButton(){
        basicActions.waitForElementToBePresent(goBackButton,10);
        goBackButton.click();
    }
    public void verifyTextsHeaderAndOtherLabels(List<String> pageTexts){
        basicActions.wait(1000);
        String signature=SharedData.getPrimaryMember().getSignature();
        softAssert.assertEquals(IncomeSummaryHeader.getText(),pageTexts.get(0)+" "+signature,"Income header text mismatch");
        softAssert.assertEquals(DeductionSummaryHeader.getText(),pageTexts.get(1),"Deduction header text mismatch");
        softAssert.assertEquals(bodyTexts.get(0).getText(),pageTexts.get(2),"Do you have any text mismatch");
        softAssert.assertEquals(bodyTexts.get(1).getText(),pageTexts.get(3),"Select all that apply text mismatch");

        softAssert.assertEquals(IncomeSummaryHeader.getCssValue("font-size"), "36px", "IncomeSummaryHeader-Font size mismatch");
        softAssert.assertEquals(IncomeSummaryHeader.getCssValue("color"), "rgba(43, 49, 60, 1)", "IncomeSummaryHeader-Color mismatch");
        softAssert.assertEquals(IncomeSummaryHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif", "IncomeSummaryHeader-Font family mismatch");
        softAssert.assertEquals(IncomeSummaryHeader.getCssValue("line-height"), "48px", "IncomeSummaryHeader-Line height mismatch");
        softAssert.assertEquals(DeductionSummaryHeader.getCssValue("font-size"), "28px", "DeductionSummaryHeader-Font size mismatch");
        softAssert.assertEquals(DeductionSummaryHeader.getCssValue("color"), "rgba(43, 49, 60, 1)", "DeductionSummaryHeader-Color mismatch");
        softAssert.assertEquals(DeductionSummaryHeader.getCssValue("font-family"), "\"PT Sans\", sans-serif", "DeductionSummaryHeader-Font family mismatch");
        softAssert.assertEquals(DeductionSummaryHeader.getCssValue("line-height"), "40px", "DeductionSummaryHeader-Line height mismatch");
        softAssert.assertEquals(bodyTexts.get(0).getCssValue("font-size"), "16px", "Do You have-Font size mismatch");
        softAssert.assertEquals(bodyTexts.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)", "Do You have-Color mismatch");
        softAssert.assertEquals(bodyTexts.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif", "Do You have-Font family mismatch");
        softAssert.assertEquals(bodyTexts.get(0).getCssValue("line-height"), "28px", "Do You have-Line height mismatch");
        softAssert.assertEquals(bodyTexts.get(1).getCssValue("font-size"), "16px", "Select all that apply-Font size mismatch");
        softAssert.assertEquals(bodyTexts.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)", "Select all that apply-Color mismatch");
        softAssert.assertEquals(bodyTexts.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif", "Select all that apply-Font family mismatch");
        softAssert.assertEquals(bodyTexts.get(1).getCssValue("line-height"), "28px", "Select all that apply-Line height mismatch");
        softAssert.assertAll();
    }
    public void verifyDeductionOptionsOrderAndText(String languageOpt,List<String> deductionOpts){
        Assert.assertTrue(basicActions.waitForElementToBePresent(horizontalLine,10));
        for (int i=0;i<deductionOpts.size();i++){
            softAssert.assertEquals(labelAllDeductionOptions.get(i).getText().trim(),deductionOpts.get(i),"Deduction Option "+i+" text mismatch");
            softAssert.assertFalse(addtlDeductionOptionsCheckbox.get(i).isSelected(),"Check box"+i+" is Selected");
            softAssert.assertEquals(labelAllDeductionOptions.get(i).getCssValue("font-size"), "16px", "labelAllDeductionOptions"+i+"-Font size mismatch");
            softAssert.assertEquals(labelAllDeductionOptions.get(i).getCssValue("color"), "rgba(43, 49, 60, 1)", "labelAllDeductionOptions"+i+"-Color mismatch");
            softAssert.assertEquals(labelAllDeductionOptions.get(i).getCssValue("font-family"), "\"PT Sans\", sans-serif", "labelAllDeductionOptions"+i+"-Font family mismatch");
            softAssert.assertEquals(labelAllDeductionOptions.get(i).getCssValue("line-height"), "28px", "labelAllDeductionOptions"+i+"-Line height mismatch");
            softAssert.assertAll();
        }
        switch (languageOpt){
            case "English":
                softAssert.assertEquals(goBackButton.getText().trim(),"Go back","Go back text mismatch");
                softAssert.assertEquals(saveAndContinueBtn.getText().trim(),"Save and continue","Save and continue text mismatch");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(goBackButton.getText().trim(),"Volver","Go back spanish text mismatch");
                softAssert.assertEquals(saveAndContinueBtn.getText().trim(),"Guardar y continuar","Guardar y continuar text mismatch");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + languageOpt);
        }
    }
    public void verifyDefaultPropertyOfTextBoxAndDropdown(String languageOpt,List<String> dropdownOptions){
        softAssert.assertTrue(txtAOSSAmount.isDisplayed(),"AOSS text box not visible");
        softAssert.assertTrue(selectAOSSFrequency.isDisplayed(),"Drop Down not visible");
        switch (languageOpt){
            case "English":
                softAssert.assertEquals(txtAOSSAmount.getAttribute("placeholder"),"amount","AOSS default text not visible");
                softAssert.assertEquals(basicActions.getFirstSelectedOptionFromDD(selectAOSSFrequency).getText().trim(),"Select Option","Select Option not visible");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(txtAOSSAmount.getAttribute("placeholder"),"cantidad","AOSS default text not visible");
                softAssert.assertEquals(basicActions.getFirstSelectedOptionFromDD(selectAOSSFrequency).getText().trim(),"Seleccionar opci\u00F3n","Seleccionar opci\u00F3n not visible");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + languageOpt);
        }
        checkAllDropDownOptions(dropdownOptions);
        softAssert.assertAll();
    }
    private void checkAllDropDownOptions(List<String> dropdownOptions){
        for (int i=0;i<dropdownOptions.size();i++) {
            softAssert.assertEquals(basicActions.selectAllOptionsFromDropDown(selectAOSSFrequency).get(i).getText().trim(), dropdownOptions.get(i), "Option text not equal");
            softAssert.assertAll();
        }
    }
    public void verifyAmountCanBeEntered(String amount,String freq){
        softAssert.assertEquals(txtAOSSAmount.getAttribute("value"),amount,"Entered amount mismatch");
        softAssert.assertTrue(dollarSymbol.isDisplayed(),"Dollar Symbol is not visible");
        softAssert.assertEquals(basicActions.getFirstSelectedOptionFromDD(selectAOSSFrequency).getText().trim(),freq,"Entered freq mismatch");
        softAssert.assertAll();
    }
    public void verifyOnlyNone_of_theseSelected(){
        basicActions.waitForElementToBePresent(addtlDeductionOptionsCheckbox.get(10),10);
        addtlDeductionOptionsCheckbox.get(10).click();
        for (int i=0;i<addtlDeductionOptionsCheckbox.size()-1;i++){
            softAssert.assertFalse(addtlDeductionOptionsCheckbox.get(i).isSelected(),"Other"+i+" is selected");
            softAssert.assertAll();
        }
        softAssert.assertTrue(checkBoxChecked.size()==1,"NoneOfThese is not selected");
        softAssert.assertAll();
    }
    public void verifyFontSizeColorOfBackAndContinue(String mouseOverOpt){
        switch (mouseOverOpt){
            case "Off":
                verifyColorFontEtcWhenMouseHoverOff();
                break;
            case "On":
                verifyColorFontEtcWhenMouseHoverOn();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + mouseOverOpt);
        }
    }
    private void verifyColorFontEtcWhenMouseHoverOff(){
        addtlDeductionOptionsCheckbox.get(10).click();
        softAssert.assertEquals(goBackButton.getCssValue("background-color"), "rgba(252, 252, 252, 1)", "Go Back-back ground Color mismatching");
        softAssert.assertEquals(goBackButton.getCssValue("border"), "2px solid rgb(26, 112, 179)", "Go Back-border mismatch");
        softAssert.assertEquals(goBackButton.getCssValue("border-top-left-radius"), "4px", "Go Back-Border radios mismatch");
        softAssert.assertEquals(goBackButton.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Go Back-Font family mismatch");
        softAssert.assertEquals(goBackButton.getCssValue("font-size"), "20px", "Go Back-Font size mismatch");
        softAssert.assertEquals(goBackButton.getCssValue("padding-bottom"), "12px", "Go Back-Padding bottom not matching");
        softAssert.assertEquals(goBackButton.getCssValue("padding-right"), "20px", "Go Back-Padding right not matching");
        softAssert.assertEquals(goBackButton.getCssValue("color"), "rgba(26, 112, 179, 1)", "Go Back-Color mismatch");
        softAssert.assertEquals(btnOutlineBackAndSave.get(0).getCssValue("background-color"), "rgba(0, 0, 0, 0)", "Go Back Outline-back ground Color mismatching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(26, 112, 179, 1)", "saveAndContinueBtn-back ground Color mismatching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("border"), "2px solid rgb(26, 112, 179)", "saveAndContinueBtn-border mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("border-top-left-radius"), "4px", "saveAndContinueBtn-Border radios mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif", "saveAndContinueBtn-Font family mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px", "saveAndContinueBtn-Font size mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("padding-bottom"), "12px", "saveAndContinueBtn-Padding bottom not matching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("padding-right"), "20px", "saveAndContinueBtn-Padding right not matching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)", "saveAndContinueBtn-Color mismatch");
        softAssert.assertEquals(btnOutlineBackAndSave.get(1).getCssValue("background-color"), "rgba(0, 0, 0, 0)", "Save outline-back ground Color mismatching");
        softAssert.assertAll();
    }
    private void verifyColorFontEtcWhenMouseHoverOn(){
        basicActions.mouseHoverOnElement(goBackButton);
        softAssert.assertEquals(goBackButton.getCssValue("background-color"), "rgba(226, 241, 248, 1)", "Go Back When Mouse Hover No-back ground Color mismatching");
        softAssert.assertEquals(goBackButton.getCssValue("border"), "2px solid rgb(26, 112, 179)", "Go Back-border mismatch");
        softAssert.assertEquals(goBackButton.getCssValue("border-top-left-radius"), "4px", "Go Back-Border radios mismatch");
        softAssert.assertEquals(goBackButton.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Go Back-Font family mismatch");
        softAssert.assertEquals(goBackButton.getCssValue("font-size"), "20px", "Go Back-Font size mismatch");
        softAssert.assertEquals(goBackButton.getCssValue("padding-bottom"), "12px", "Go Back-Padding bottom not matching");
        softAssert.assertEquals(goBackButton.getCssValue("padding-right"), "20px", "Go Back-Padding right not matching");
        basicActions.scrollToElement(saveAndContinueBtn);
        basicActions.mouseHoverOnElement(saveAndContinueBtn);
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(22, 156, 216, 1)", "Save btn When Mouse Hover No-back ground Color mismatching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("border"), "2px solid rgb(252, 252, 252)", "saveAndContinueBtn-border mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("border-top-left-radius"), "4px", "saveAndContinueBtn-Border radios mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif", "saveAndContinueBtn-Font family mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px", "saveAndContinueBtn-Font size mismatch");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("padding-bottom"), "12px", "saveAndContinueBtn-Padding bottom not matching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("padding-right"), "20px", "saveAndContinueBtn-Padding right not matching");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)", "saveAndContinueBtn-Color mismatch");
        softAssert.assertAll();
    }
}
