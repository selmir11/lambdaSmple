package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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

    @FindBy(css = ".header-2")
    WebElement hdr_Employment;

    @FindBy(id = "EmploymentSummary-SaveAndContinue")
    WebElement btnContinue;

    @FindBy(xpath = "//*[starts-with(@id,'edit')]")
    WebElement lnkEditIncome;

    @FindBy(css = "[id^='remove-employer-']")
    List<WebElement> lnkRemoveJob;

    @FindBy(css = "app-confirmation-dialog button")
    List<WebElement> lnkRemoveContinue;

    @FindBy(css = ".col-3.content-center")
    WebElement btnAddJob;

    @FindBy(css = "lib-help-icon a")
    WebElement helpLnk;

    @FindBy(css = ".help-label")
    WebElement helpSide;

    @FindBy(css = ".drawer-controls > div > div > a > svg")
    WebElement helpCloseSide;

    @FindBy(css = ".drawer-heading .body-text-1")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = ".drawer-heading .drawer-title")
    WebElement helpDrawerHeaderEmploymentSummary;

    @FindBy(css = "div.drawer-text-content.body-text-1 > b")
    List<WebElement> helpDrawerMainHeaders;

    @FindBy(css = "div.drawer-text-content.body-text-1 > p")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = "div.drawer-text-content.body-text-1 > ul > li")
    List<WebElement> helpDrawerBodySubParagraphs;

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

    @FindBy(css = ".drawer-footer h3")
    WebElement helpDrawerFooter;

    @FindBy(css = ".drawer-footer h3 a")
    WebElement helpDrawerContactUsLink;

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;


    public void clickContinue(){
        basicActions.waitForElementToBePresent(btnContinue,30);
        basicActions.waitForElementToBePresent(lnkEditIncome,30);
        basicActions.waitForElementToBeClickable(btnContinue, 30);
        basicActions.scrollToElement(btnContinue);
        btnContinue.click();
    }

    public void clickEditIncome(int Index){
        basicActions.waitForElementToBePresent(lnkEditIncome,10);
        Index -=1;
        lnkEditIncome.click();

    }

    public void clickAddJob(){
        basicActions.waitForElementToBePresent(spinner,20);
        basicActions.waitForElementToBePresent(btnAddJob,20);
        btnAddJob.click();
    }

    public void clickRemoveJob(String DeleteJob){
        String setEmployerName;
        basicActions.waitForElementListToBePresent(lnkRemoveJob,20);
        switch (DeleteJob) {
            case "First":
                setEmployerName = SharedData.getPrimaryMember().getEmployerName();
                System.out.println("First employer is "+setEmployerName);
                lnkRemoveJob.get(0).click();
                break;
            case "Second":
                setEmployerName = SharedData.getPrimaryMember().getEmployerName();
                System.out.println("Second employer is "+setEmployerName);
                lnkRemoveJob.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid member type: " + DeleteJob);
        }
        basicActions.waitForElementListToBePresent(lnkRemoveContinue, 20);
        lnkRemoveContinue.get(0).click();
    }

    public void clickHelpIcon(String label) {
        basicActions.waitForElementToBePresent(helpLnk, 10);
        switch(label){
            case "Help me understand":
                helpLnk.click();
                break;
            case "side help":
                helpSide.click();
                break;
            case "close side help":
                helpCloseSide.click();
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
        basicActions.waitForElementToBePresent(hdr_Income,15);
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
        softAssert.assertEquals(helpDrawerHeaderEmploymentSummary.getText(), "Employment Income");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Income");
        softAssert.assertEquals(helpDrawerMainHeaders.get(1).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "We need to know how much you and your family members earn at your job(s).");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(0).getText(), "Employment\nDoes this person earn money through a job or by being self-employed?");
        softAssert.assertEquals(helpDrawerMainHeaders.get(2).getText(), "Employment");
        softAssert.assertEquals(helpDrawerMainHeaders.get(3).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "We need to know about the company you work for.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(1).getText(), "Gross Income\nTell us the total amount paid by this job BEFORE taxes or any other deductions (like retirement contributions) are taken out. This is gross pay and would be MORE than the amount received on a check or deposited in a bank account, which is the net pay.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(2).getText(), "Net Income\nTell us your income from your self-employment after business expenses have been paid. (Net income is sometimes called \"profit\".)");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(3).getText(), "Seasonal, commission or tipped base employment\nThis question helps us calculate the annual income for customers who don't have the same income every week or month.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(4).getText(), "Same or lower\nWe ask this question to make sure the calculation of your annual income is correct for customers who don't have consistent income.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(5).getText(), "Employer Address\nConnect for Health Colorado will notify an employer if an employee has been determined eligible for Advance Premium Tax Credits and/or Cost-Sharing Reductions and has enrolled in a Qualified Health Plan. The employer has the right to file an appeal if they believe this determination is incorrect. The correct contact information for the employer is required to support the employer appeal process, so please double check your entry of the employer contact information.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(4).getText(), "Additions");
        softAssert.assertEquals(helpDrawerMainHeaders.get(5).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Tell us about any additional income this person may receive.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(6).getText(), "Alimony Received\nAmounts received from a spouse or a former spouse under a divorce or separation agreement (including a divorce decree, a separate maintenance decree, or a written separation agreement) may be considered alimony for federal tax purposes. For more information, see:\nhttps://www.irs.gov/taxtopics/tc452\n\nIf your divorce or separation was finalized on or before December 31, 2018, you should include alimony you received in your Additional Income Sources. If your divorce or separation was finalized on or after January 1, 2019, do not include alimony you receive in your Additional Income Sources.");
        softAssert.assertEquals(helpDrawerAlimonyRecievedLink.getText(), "https://www.irs.gov/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(7).getText(), "Capital Gains\nCapital gain is a rise in the value of a capital asset (investment or real estate) that gives it a higher worth than the purchase price. The gain is not realized until the asset is sold. For more information, see:\nhttps://www.irs.gov/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerCapitalGainsLink.getText(), "https://www.irs.gov/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(8).getText(), "Income from Rental Property\nCash or the fair market value of property or services you receive for the use of real estate or personal property is taxable to you as rental income. For more information, see:\nhttps://www.irs.gov/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerIncomeRentalPropertyLink.getText(), "https://www.irs.gov/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(9).getText(), "Pension\nIt is possible that you must report income from pension and annuity plans on your federal income tax return. Any such income that you report on your tax return must be entered here. For more information, see:\nhttps://www.irs.gov/publications/p575");
        softAssert.assertEquals(helpDrawerPensionLink.getText(), "https://www.irs.gov/publications/p575");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(10).getText(), "Private Retirement Income\nPrivate retirement income can include IRAs, 401(k), 403(b), and 457(b) withdrawals and distributions, not Social Security. For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerPrivateRetirementIncomeLink.getText(), "https://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(11).getText(), "Unemployment Insurance Benefit\nUnemployment compensation generally includes any amounts received under the unemployment compensation laws of the United States or of a state, including state unemployment insurance benefits. For more information, see:\nhttps://www.irs.gov/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerUnemploymentInsuranceBenefitLink.getText(), "https://www.irs.gov/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(12).getText(), "Investment Income\nInvestment income includes dividends and other gains as reflected on lines 9 and 14 of 1040, as well as interest income (Line 8). For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerInvestmentIncomeLink.getText(), "https://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(13).getText(), "Cash Support\nIf you receive any income in cash from any source, you must report it here.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(14).getText(), "Untaxed Foreign Income\nForeign earned income is income you receive for services you perform in a foreign country during a period your tax home is in a foreign country and during which you meet either the bona fide residence test or the physical presence test.\nFor more information, see:\nhttps://www.irs.gov/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerUntaxedForeignIncomeLink.getText(), "https://www.irs.gov/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(15).getText(), "Royalty Income\nRoyalty income is a payment received for the use and exploitation of artistic or literary works, patents and mineral rights. For more information, see:\nhttps://www.irs.gov/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerRoyaltyIncomeLink.getText(), "https://www.irs.gov/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(16).getText(), "Title II Income\nTitle II benefits are the monthly benefits that are issued by the Social Security Administration for disability claims. For more information, see:\nhttps://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerTitle2IncomeLink.getText(), "https://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(17).getText(), "Taxable Income from Tribal Sources\nOnly include the taxable portion of income you receive from an American Indian or Alaska Native tribal source. Common types of income include:\n\u2022 Per capita payments from the tribe that come from natural resources, usage rights, leases or royalties.\n\u2022 Payments from natural resources, farming, ranching, fishing, leases, or royalties from land designated as Indian land by the Department of Interior (including reservations and former reservations).\n\u2022 Money from selling things that have cultural significance.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(6).getText(), "Deductions");
        softAssert.assertEquals(helpDrawerMainHeaders.get(7).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "If there are things that can be deducted on an income tax return, telling us about them could make the cost of health insurance a little lower.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(18).getText(), "Deductions\nTell us all deductions you will take when filing taxes and tell us the amount of each deduction.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(19).getText(), "Alimony or spousal support paid out\nAlimony is a payment to a spouse or former spouse under a divorce or separation agreement. For more information, see:\nhttps://www.irs.gov/taxtopics/tc452\n\nIf your divorce or separation was finalized on or before December 31, 2018, you should include alimony or spousal support you paid in your Deductions. If your divorce or separation was finalized on or after January 1, 2019, do not include alimony or spousal support you pay in your Deductions.");
        softAssert.assertEquals(helpDrawerAlimonyPaidOutLink.getText(), "https://www.irs.gov/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(20).getText(), "Domestic production activities\nThe Domestic Production Activities Tax Deduction is intended to provide tax relief for businesses that produce goods in the United States rather than producing it overseas. For more information, see:\nhttps://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerDomesticProductionLink.getText(), "https://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(21).getText(), "Health Savings Account\nA type of savings account that lets you set aside money on a pre-tax basis to pay for qualified medical expenses. Enter contributions made to your health savings account, up to the yearly limit. For more information see IRS Form 8889.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(22).getText(), "Pre-tax retirement account contribution\nA pre-tax contribution is a payment made to a retirement account with money that has not been taxed. For more information, see:\nhttps://www.irs.gov/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerPreTaxRetirementContributionLink.getText(), "https://www.irs.gov/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(23).getText(), "School tuition and fees\nCertain school tuition and fees are able to be deducted from your taxes. For more information, see:\n\nhttps://www.irs.gov/taxtopics/tc513\n\nSelf-Employed Individuals \u2013 https://www.irs.gov/pub/irs-pdf/f1040sc.pdf or https://www.irs.gov/pub/irs-pdf/f1040sf.pdf\n\nArmed Forces Reservists, Qualified Performing Artists, and State/Local Government Officials \u2013 https://www.irs.gov/pub/irs-pdf/f1040s1.pdf and https://www.irs.gov/pub/irs-pdf/f2106.pdf\n\nIndividuals with a Disability - https://www.irs.gov/pub/irs-pdf/f1040sa.pdf and https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionLink.getText(), "https://www.irs.gov/taxtopics/tc513");
        softAssert.assertEquals(helpDrawerSchoolTuitionSelfEmpLink.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sc.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionSelfEmp2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sf.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionArmedForcesLink.getText(), "https://www.irs.gov/pub/irs-pdf/f1040s1.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionArmedForces2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionDisabilityLink.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sa.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionDisability2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(24).getText(), "Self-employment tax\nSelf-employment income is income that arises from the performance of personal services, but which cannot be classified as wages because an employer-employee relationship does not exist between the payer and the payee. The Internal Revenue Code imposes the self-employment tax on the self-employment income of any U.S. citizen or resident alien who has such self-employment income. For more information, see:\nhttps://www.irs.gov/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerSelfEmploymentTaxLink.getText(), "https://www.irs.gov/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(25).getText(), "Student Loan Interest\nStudent loan interest is interest you paid during the year on a qualified student loan. For more information, see:\nhttps://www.irs.gov/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerStudentLoanInterestLink.getText(), "https://www.irs.gov/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(26).getText(), "Self-employment Health Insurance\nIf you are self-employed, there is a tax deduction generally available for medical, dental or long-term care insurance premiums that self-employed people often pay for themselves, their spouse and their dependents. For more information, see:\nhttps://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerSelfEmploymentHealthInsuranceLink.getText(), "https://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(27).getText(), "Self-Employment Retirement Plan\nThere are numerous options for contributing to a retirement plan for the self-employed, and claiming a tax deduction for the contribution. For more information, see:\nhttps://www.irs.gov/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerSelfEmploymentRetirementLink.getText(), "https://www.irs.gov/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(28).getText(), "Moving Expenses\nIf you are a member of the U.S. Armed Forces on active duty and are moving due to a permanent change of duty station, you may deduct unreimbursed moving expenses. If you are not in the military, do not include moving expenses on your application. For more information, see:\nhttps://www.irs.gov/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerMovingExpensesLink.getText(), "https://www.irs.gov/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerMainHeaders.get(8).getText(), "Income Summary");
        softAssert.assertEquals(helpDrawerMainHeaders.get(9).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "This page shows you what you have told us so far about how much money you make. The amount of financial help you qualify for will be based on these numbers. Please make sure all the information is correct before clicking Continue. If any information on this page is not right, click the Back button to go back and fix it.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(29).getText(), "Projected Income\nThe projected annual income you enter will be used to calculate the amount of financial help you qualify for (instead of the amount we calculated from the combined sources of income that you reported). We will also review the current, monthly income details you provide to assess whether you are potentially eligible for Health First Colorado (Colorado\u2019s Medicaid program). Keep in mind, if the income that you report on your federal income tax return differs from the information reported in this application, you may have to repay some or all of the financial assistance you receive. The Internal Revenue Service (IRS) makes the final determination of eligibility for Premium Tax Credits.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
        softAssert.assertEquals(helpDrawerHeaderEmploymentSummary.getText(), "Ingresos laborales o del empleador");
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Ingreso");
        softAssert.assertEquals(helpDrawerMainHeaders.get(1).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Necesitamos saber cu\u00E1nto ganan usted y los miembros de su familia en su(s) trabajo(s).");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(0).getText(), "Empleo\n\u00BFEsta persona tiene un ingreso como empleado o como trabajador independiente?");
        softAssert.assertEquals(helpDrawerMainHeaders.get(2).getText(), "Empleo");
        softAssert.assertEquals(helpDrawerMainHeaders.get(3).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Necesitamos informaci\u00F3n sobre la empresa para la que trabaja usted.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(1).getText(), "Ingreso bruto\nIndique la cantidad total que le pagan en este trabajo ANTES de descontar impuestos o hacer otras deducciones (como aportes para el retiro). Es el salario bruto y debe ser m\u00E1s que la cantidad que recibe en cheque o le depositan en su cuenta bancaria, que es el salario neto.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(2).getText(), "Ingreso neto\nIndique su ingreso como trabajador independiente despues de pagar sus gastos de negocios. (Ingreso neto a veces se llama \"ganacias\".)");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(3).getText(), "Trabajo temporal, por comisiones o por propinas\nEsta pregunta nos ayuda a calcular el ingreso anual de los clientes que no tienen el mismo ingreso cada semana o mes.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(4).getText(), "Igual o bajar\u00E1\nLe hacemos esta pregunta para asegurarnos de calcular correctamente su ingreso anual, como es el caso de clientes que no tienen un ingreso constante.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(5).getText(), "Direcci\u00F3n del empleador\nConnect for Health Colorado notificar\u00E1 a un empleador si un empleado ha sido determinado elegible para Cr\u00E9dito fiscal anticipado para la cuota y/o reducciones en los costos compartidos y se ha inscrito en un Plan de salud calificado. El empleador tiene el derecho a presentar una apelaci\u00F3n si creen que esta determinaci\u00F3n es incorrecta. Se requiere la informaci\u00F3n de contacto correcta para el empleador para apoyar este proceso, por favor verifique que la informaci\u00F3n del empleador esta correcta.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(4).getText(), "Adiciones");
        softAssert.assertEquals(helpDrawerMainHeaders.get(5).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Indique cualquier ingreso adicional que esta persona pueda recibir.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(6).getText(), "Pensi\u00F3n alimenticia recibida\nCantidades recibidas del c\u00F3nyuge o exc\u00F3nyuge por acuerdo de divorcio o separaci\u00F3n (incluyendo una sentencia de divorcio, una sentencia de separaci\u00F3n por manutenci\u00F3n o un acuerdo de separaci\u00F3n por escrito) pueden ser consideradas pensi\u00F3n alimenticia cuando declare sus impuestos federales sobre los ingresos. Para m\u00E1s informaci\u00F3n visite:\nhttps://www.irs.gov/es/taxtopics/tc452\n\nSi su divorcio o separaci\u00F3n finaliz\u00F3 en o antes del 31 de diciembre de 2018, debe incluir la pensi\u00F3n alimenticia que recibi\u00F3 en sus Otras fuentes de ingreso. Si su divorcio o separaci\u00F3n finaliz\u00F3 en o despu\u00E9s del 1\u00BA de enero de 2019, no incluya la pensi\u00F3n alimenticia que recibi\u00F3 en sus Otras fuentes de ingreso.");
        softAssert.assertEquals(helpDrawerAlimonyRecievedLink.getText(), "https://www.irs.gov/es/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(7).getText(), "Ganancias de capital\nGanancias de capital es un aumento de un bien capital (inversi\u00F3n o bienes ra\u00EDces) que le proporciona un mayor valor al precio de compra. La ganancia se obtiene hasta que se vende la propiedad. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerCapitalGainsLink.getText(), "https://www.irs.gov/es/taxtopics/tc409");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(8).getText(), "Ingresos por renta de propiedades\nEl efectivo o valor razonable de mercado de la propiedad o servicios que recibe por el uso del bien o propiedad personal le es sujeto a impuestos como ingreso por rentas. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerIncomeRentalPropertyLink.getText(), "https://www.irs.gov/es/taxtopics/tc414");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(9).getText(), "Pensi\u00F3n\nEs posible que deba reportar ingresos por planes de pensi\u00F3n y anualidad en su declaraci\u00F3n de impuestos sobre los ingresos. Cualquier ingreso que reporte en su declaraci\u00F3n de impuestos debe ingresarlo aqu\u00ED. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerPensionLink.getText(), "https://www.irs.gov/es/publications/p575");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(10).getText(), "Ingresos privados por retiro\nLos ingresos privados por retiro pueden incluir retiros y aportes a IRA, 401(k), 403(b) y 457(b), no Seguro Social. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerPrivateRetirementIncomeLink.getText(), "https://www.irs.gov/pub/irs-pdf/p575.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(11).getText(), "Beneficio del seguro de desempleo\nLa compensaci\u00F3n por desempleo generalmente incluye cualquier cantidad recibida bajo las leyes de compensaci\u00F3n por desempleo de Estados Unidos o de un estado, incluyendo el seguro de beneficios estatales por desempleo. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerUnemploymentInsuranceBenefitLink.getText(), "https://www.irs.gov/es/individuals/employees/unemployment-compensation");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(12).getText(), "Ingresos derivados de inversiones\nLos ingresos derivados de inversiones incluyen los dividendos y otras ganancias, como se reflejan tanto en las l\u00EDneas 9 y 14 del 1040, como en los ingresos por intereses (l\u00EDnea 8). Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerInvestmentIncomeLink.getText(), "https://www.irs.gov/pub/irs-pdf/p550.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(13).getText(), "Apoyo en efectivo\nSi obtiene un ingreso en efectivo de cualquier fuente, debe reportarlo aqu\u00ED.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(14).getText(), "Ingresos obtenidos en el extranjero no gravados\nEl ingreso extranjero obtenido es ingreso que recibe por servicios otorgados en un pa\u00EDs extranjero durante un per\u00EDodo en el que su residencia fiscal es en un pa\u00EDs extranjero y durante el que cumple ya sea con el criterio de la residencia leg\u00EDtima o de presencia f\u00EDsica. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerUntaxedForeignIncomeLink.getText(), "https://www.irs.gov/es/individuals/international-taxpayers/foreign-earned-income-exclusion-what-is-foreign-earned-income");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(15).getText(), "Ingresos por regal\u00EDas\nEl ingreso por regal\u00EDas es un pago recibido por el uso y utilizaci\u00F3n de trabajos art\u00EDsticos o literarios, derechos de patente y de minerales. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerRoyaltyIncomeLink.getText(), "https://www.irs.gov/es/forms-pubs/about-form-1099-misc");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(16).getText(), "Ingresos del T\u00EDtulo II\nLos beneficios del T\u00EDtulo II son los beneficios mensuales que emite la Administraci\u00F3n del Seguro Social para reclamos por discapacidad. Para m\u00E1s informaci\u00F3n, ver:\nhttps://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerTitle2IncomeLink.getText(), "https://www.disability-benefits-help.org/glossary/title-ii-benefits");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(17).getText(), "Ingresos gravables de origen tribal\nIncluya \u00FAnicamente la parte de los ingresos reportados que recibi\u00F3 de origen tribal como ind\u00EDgena norteamericano o nativo de Alaska. Tipos de ingresos comunes son:\n\u2022 Pagos per c\u00E1pita de la tribu proveniente de recursos naturales, derechos de uso, arrendamientos o regal\u00EDas.\n\u2022 Pagos provenientes de recursos naturales, agricultura, ganader\u00EDa, pesca, arrendamientos o regal\u00EDas de tierras designadas como tierras en fideicomiso ind\u00EDgenas por el Departamento del Interior (incluidas reservas ind\u00EDgenas y antiguas reservas ind\u00EDgenas).\n\u2022 Dinero de la venta de patrimonio de significado cultural");
        softAssert.assertEquals(helpDrawerMainHeaders.get(6).getText(), "Deducciones");
        softAssert.assertEquals(helpDrawerMainHeaders.get(7).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "Si hay ciertos gastos que puedan deducirse en una declaraci\u00F3n de impuestos, esta informaci\u00F3n nos servir\u00EDa para reducir un poco m\u00E1s el costo del seguro de salud.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(18).getText(), "Deducciones\nD\u00EDganos todas las deducciones que har\u00E1 cuando presente su declaraci\u00F3n de impuestos de este a\u00F1o e indique la cantidad de cada deducci\u00F3n.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(19).getText(), "Pensi\u00F3n alimenticia o apoyo conyugal que paga\nLa pensi\u00F3n alimenticia es un pago a un c\u00F3nyuge o exc\u00F3nyuge por un acuerdo de divorcio o separaci\u00F3n. Para m\u00E1s informaci\u00F3n visite:\nhttps://www.irs.gov/es/taxtopics/tc452\n\nSi su divorcio o separaci\u00F3n finaliz\u00F3 en o antes del 31 de diciembre de 2018, debe incluir la pensi\u00F3n alimenticia o apoyo conyugal que pag\u00F3 en sus Deducciones. Si su divorcio o separaci\u00F3n finaliz\u00F3 en o despu\u00E9s del 1\u00BA de enero de 2019, no incluya la pensi\u00F3n alimenticia o apoyo conyugal que pag\u00F3 en sus Deducciones.");
        softAssert.assertEquals(helpDrawerAlimonyPaidOutLink.getText(), "https://www.irs.gov/es/taxtopics/tc452");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(20).getText(), "Actividades de producci\u00F3n para el mercado interno\nLa Deducci\u00F3n de impuestos por actividades dom\u00E9sticas de producci\u00F3n pretende brindarle un alivio fiscal a las empresas que producen mercanc\u00EDa en los Estados Unidos en lugar de producirlas en el extranjero. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerDomesticProductionLink.getText(), "https://www.irs.gov/pub/irs-pdf/i8903.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(21).getText(), "Cuenta de ahorros de salud\nUn tipo de cuenta de ahorros que le permite ahorrar dinero en una base antes de impuestos para pagar los gastos m\u00E9dicos calificados. Ingrese las contribuciones hechas a su cuenta de ahorros de salud, hasta el l\u00EDmite anual. Para m\u00E1s informaci\u00F3n, consulte el formulario 8889 del IRS.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(22).getText(), "Aportes a la cuenta de retiro antes de impuestos\nUn aporte antes de impuestos es un pago realizado a una cuenta de retiro con dinero que no ha sido sujeto a impuestos. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerPreTaxRetirementContributionLink.getText(), "https://www.irs.gov/es/retirement-plans/plan-participant-employee/retirement-savings-contributions-savers-credit");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(23).getText(), "Colegiatura y cuotas escolares\nCiertas colegiaturas y cuotas de inscripci\u00F3n pueden ser deducidas de sus impuestos. Para obtener m\u00E1s informaci\u00F3n, visite:\n\nhttps://www.irs.gov/es/taxtopics/tc513\n\nTrabajadores independientes: https://www.irs.gov/pub/irs-pdf/f1040scs.pdf o https://www.irs.gov/pub/irs-pdf/f1040sfs.pdf\n\nReservistas de las Fuerzas Armadas, artistas ejecutantes calificados y funcionarios del gobierno estatal y local: https://www.irs.gov/pub/irs-pdf/f1040s1s.pdf y https://www.irs.gov/pub/irs-pdf/f2106.pdf\n\nPersonas con alguna discapacidad: https://www.irs.gov/pub/irs-pdf/f1040sa.pdf y https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionLink.getText(), "https://www.irs.gov/es/taxtopics/tc513");
        softAssert.assertEquals(helpDrawerSchoolTuitionSelfEmpLink.getText(), "https://www.irs.gov/pub/irs-pdf/f1040scs.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionSelfEmp2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sfs.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionArmedForcesLink.getText(), "https://www.irs.gov/pub/irs-pdf/f1040s1s.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionArmedForces2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionDisabilityLink.getText(), "https://www.irs.gov/pub/irs-pdf/f1040sa.pdf");
        softAssert.assertEquals(helpDrawerSchoolTuitionDisability2Link.getText(), "https://www.irs.gov/pub/irs-pdf/f2106.pdf");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(24).getText(), "Impuesto al trabajo independiente\nEl ingreso como trabajador independiente es ingreso que se genera por servicios personales otorgados, los cuales no pueden ser clasificados como sueldos, ya que no existe una relaci\u00F3n de empleador y el empleado entre el pagador y el beneficiario. El C\u00F3digo de impuestos internos impone el impuesto de trabajador independiente al ingreso de trabajo independiente sujeto a impuestos a todos los ciudadanos estadounidenses o extranjeros residentes que tienen dicho ingreso como trabajador independiente. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerSelfEmploymentTaxLink.getText(), "https://www.irs.gov/es/individuals/international-taxpayers/self-employment-tax");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(25).getText(), "Inter\u00E9s por pr\u00E9stamo de estudiante\nEl inter\u00E9s del pr\u00E9stamo estudiantil que paga durante el a\u00F1o de un pr\u00E9stamo estudiantil calificado. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerStudentLoanInterestLink.getText(), "https://www.irs.gov/es/taxtopics/tc456");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(26).getText(), "Seguro de salud de trabajador independiente\nSi usted es trabajador independiente, hay una deducci\u00F3n generalmente disponible para las cuotas de seguro m\u00E9dico, dental o de atenci\u00F3n prolongada que las personas que trabajan de manera independiente pagan para s\u00ED mismos, para sus c\u00F3nyuges o para sus dependientes. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerSelfEmploymentHealthInsuranceLink.getText(), "https://www.healthinsurance.org/obamacare/self-employed-health-insurance-deduction/");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(27).getText(), "Plan de retiro como trabajador independiente\nExisten m\u00FAltiples opciones de planes de retiro para los trabajadores independientes y para reclamar una deducci\u00F3n de impuestos por los aportes. Para obtener m\u00E1s informaci\u00F3n, visite:\nhttps://www.irs.gov/es/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerSelfEmploymentRetirementLink.getText(), "https://www.irs.gov/es/retirement-plans/retirement-plans-for-self-employed-people");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(28).getText(), "Gastos de mudanza\nSi es un miembro del servicio activo de las Fuerzas Armadas de Estados Unidos y se muda debido a un cambio permanente en la estaci\u00F3n de servicio, puede deducir los gastos de mudanza no reembolsados. Si no est\u00E1 en el servicio militar, no incluya gastos de mudanza en su solicitud. Para m\u00E1s informaci\u00F3n visite:\nhttps://www.irs.gov/es/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerMovingExpensesLink.getText(), "https://www.irs.gov/es/forms-pubs/about-form-3903");
        softAssert.assertEquals(helpDrawerMainHeaders.get(8).getText(), "Resumen de ingresos");
        softAssert.assertEquals(helpDrawerMainHeaders.get(9).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "Esta p\u00E1gina resume la informaci\u00F3n que nos ha dado hasta ahora sobre cu\u00E1l es su ingreso. La cantidad de ayuda financiera a la que califica se basar\u00E1 en estas cifras. Verifique que toda la informaci\u00F3n sea correcta, antes de hacer clic en Continuar. Si alguna informaci\u00F3n de esta p\u00E1gina no es correcta, haga clic en el bot\u00F3n Atr\u00E1s para regresar y corregirla.");
        softAssert.assertEquals(helpDrawerBodySubParagraphs.get(29).getText(), "Ingresos que proyecta\nEl ingreso anual proyectado que ingrese se utilizar\u00E1 para calcular la cantidad de ayuda financiera a la que califique (en lugar de la cantidad que calculamos de las fuentes de ingresos combinadas que report\u00F3). Tambi\u00E9n revisaremos los detalles de su ingreso mensual actual que proporcione para evaluar si es potencialmente elegible para Health First Colorado (Programa Medicaid de Colorado). Recuerde que si el ingreso que report\u00F3 en su declaraci\u00F3n del impuesto federal sobre los ingresos difiere de la informaci\u00F3n que report\u00F3 en esta solicitud, es posible que tenga que devolver parte o toda la ayuda financiera que reciba. El Servicio de Rentas Internas (IRS) hace la determinaci\u00F3n final sobre elegibilidad para Cr\u00E9ditos fiscales para la prima.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

}
