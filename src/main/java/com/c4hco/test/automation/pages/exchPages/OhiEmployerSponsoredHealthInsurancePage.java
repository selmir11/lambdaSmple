package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class OhiEmployerSponsoredHealthInsurancePage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public OhiEmployerSponsoredHealthInsurancePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "#ELIG-Ohi-Esi-employer")
    WebElement esiSelectEmployerDpd;

    @FindBy(id = "ELIG-Ohi-Esi-covgEndsSoon-YesButton")
    WebElement esiInsuranceEndYesBtn;

    @FindBy(id = "ELIG-Ohi-Esi-currEnrl-YesButton")
    WebElement esiCurrentlyEnrolledYesBtn;

    @FindBy(id = "ELIG-Ohi-Esi-FamilyCoveragePlanOffered-YesButton")
    WebElement esiFamilyOfferedYesBtn;

    @FindBy(id = "ELIG-Ohi-Esi-FamilyCoveragePlanOffered-NoButton")
    WebElement esiFamilyOfferedNoBtn;

    @FindBy(css = "#ELIG-Ohi-Esi-EmpSponsCovgFamilyMonthlyPremium")
    WebElement esiMonthlyAmountInput;

    @FindBy(id = "-Esi.CoverageTypeEnrolledButton")
    List<WebElement> esiFamilyEnrolledBtn;

    @FindBy(id = "-Esi.CoverageTypeAccessButton")
    List<WebElement> esiFamilyOfferedBtn;

    @FindBy(id = "-Esi.CoverageTypeNoAccessButton")
    List<WebElement> esiFamilyNoOptionBtn;

    @FindBy(css = ".drawer-controls > div > div")
    WebElement helpButton;

    @FindBy(css = "lib-help-icon a")
    List<WebElement> helpIcon;

    @FindBy(css = ".drawer-heading > div")
    WebElement helpHeaderTxt;

    @FindBy(css = ".drawer-heading > h3")
    WebElement helpSubHeaderTxt;

    @FindBy(css = ".drawer-text-content > p > b")
    List<WebElement> helpDrawerHeaderTxt;

    @FindBy(css = ".drawer-text-content > span")
    List<WebElement>helpDrawerSubHeaderTxt;

    @FindBy(css = ".drawer-text-content p")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = ".drawer-text-content > p:nth-child(3) > a")
    WebElement helpDrawerParagraphLnk1;

    @FindBy(css = ".drawer-text-content > p:nth-child(4) > a")
    WebElement helpDrawerParagraphLnk1SpMinVal;

    @FindBy(css = ".drawer-text-content > p:nth-child(12) > a")
    WebElement helpDrawerParagraphLnk2;

    @FindBy(css = ".drawer-text-content > p:nth-child(14) > a")
    WebElement helpDrawerParagraphLnk2Sp;

    @FindBy(css = ".drawer-text-content > p:nth-child(4) > a")
    WebElement helpDrawerParagraphLnk2SpMinVal;

    @FindBy(css = ".drawer-text-content li")
    List<WebElement> helpDrawerBodyPoints;

    @FindBy(css = ".drawer-text-content > p > i > a")
    WebElement helpDrawerPrintLnk;

    @FindBy(css = ".drawer-footer h3")
    WebElement helpDrawerFooter;

    @FindBy(css = ".drawer-footer h3 a")
    WebElement helpDrawerContactUsLink;

    @FindBy(id = "ELIG-Ohi-Esi-GoBack")
    WebElement goBackButton;

    @FindBy(id = "ELIG-Ohi-Esi-SaveAndContinue")
    WebElement saveAndContinueBtn;



    public void clickGoBack() {
        basicActions.click(goBackButton);
    }

    public void clickSaveAndContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
        saveAndContinueBtn.click();
    }

    public void selectEmployer() {
        String setEmployerName = SharedData.getEmployerName();
        Select dropdown = new Select(esiSelectEmployerDpd);
        dropdown.selectByVisibleText(setEmployerName);
    }

    public void clickCurrentlyEnrolledYes(){
        basicActions.click(esiCurrentlyEnrolledYesBtn);
    }

    public void clickInsuranceEndYes(){
        basicActions.click(esiInsuranceEndYesBtn);
    }

    public void clickFamilyPlansOffered(String currentlyOffered) {
        switch (currentlyOffered) {
            case "Yes":
                basicActions.waitForElementToBeClickable(esiFamilyOfferedYesBtn, 20);
                basicActions.click(esiFamilyOfferedYesBtn);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(esiFamilyOfferedNoBtn, 20);
                basicActions.click(esiFamilyOfferedNoBtn);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + currentlyOffered);
        }
    }

    public void enterMonthlyAmount(String familyAmount){
        basicActions.waitForElementToBePresent(esiMonthlyAmountInput, 50);
        esiMonthlyAmountInput.clear();
        esiMonthlyAmountInput.sendKeys(familyAmount);
    }

    public void clickFamilyEnrollmentStatusMember1(String enrollmentStatus) {
        switch (enrollmentStatus) {
            case "Enrolled":
                basicActions.waitForElementListToBePresent(esiFamilyEnrolledBtn, 20);
                basicActions.click(esiFamilyEnrolledBtn.get(0));
                break;
            case "Offered":
                basicActions.waitForElementListToBePresent(esiFamilyOfferedBtn, 20);
                basicActions.click(esiFamilyOfferedBtn.get(0));
                break;
            case "No Option":
                basicActions.waitForElementListToBePresent(esiFamilyNoOptionBtn, 20);
                basicActions.click(esiFamilyNoOptionBtn.get(0));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + enrollmentStatus);
        }
    }

    public void clickFamilyEnrollmentStatusMember2(String enrollmentStatus) {
        switch (enrollmentStatus) {
            case "Enrolled":
                basicActions.waitForElementListToBePresent(esiFamilyEnrolledBtn, 20);
                basicActions.click(esiFamilyEnrolledBtn.get(1));
                break;
            case "Offered":
                basicActions.waitForElementListToBePresent(esiFamilyOfferedBtn, 20);
                basicActions.click(esiFamilyOfferedBtn.get(1));
                break;
            case "No Option":
                basicActions.waitForElementListToBePresent(esiFamilyNoOptionBtn, 20);
                basicActions.click(esiFamilyNoOptionBtn.get(1));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + enrollmentStatus);
        }
    }

    public void clickMainHelp() {
        basicActions.waitForElementToBeClickable(helpButton,10);
        basicActions.click(helpButton);
    }

    public void clickIconHelp(String iconName) {
        switch (iconName) {
            case "Header":
                basicActions.click(helpIcon.get(0));
                break;
            case "Which job":
                basicActions.click(helpIcon.get(1));
                break;
            case "Minimum Value":
                basicActions.click(helpIcon.get(2));
                break;
            case "Monthly Amount":
                basicActions.click(helpIcon.get(3));
                break;
            case "Currently Enrolled":
                basicActions.click(helpIcon.get(4));
                break;
            case "End in 60 days":
                basicActions.click(helpIcon.get(5));
                break;
            case "Voluntarily Ending":
                basicActions.click(helpIcon.get(6));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + iconName);
        }
    }

    public void clickHelpDrawerContactUs(String lnkName) {
        switch (lnkName){
            case "Contact Us":
                basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
                helpDrawerContactUsLink.click();
                break;
            case "Employer Coverage Tool 1":
                basicActions.waitForElementToBePresent(helpDrawerParagraphLnk1, 10);
                basicActions.scrollToElement(helpDrawerParagraphLnk1);
                helpDrawerParagraphLnk1.click();
                break;
            case "Employer Coverage Tool 1 Spanish Min Val":
                basicActions.waitForElementToBePresent(helpDrawerParagraphLnk1SpMinVal, 10);
                basicActions.scrollToElement(helpDrawerParagraphLnk1SpMinVal);
                helpDrawerParagraphLnk1SpMinVal.click();
                break;
            case "Employer Coverage Tool 2":
                basicActions.waitForElementToBePresent(helpDrawerParagraphLnk2, 10);
                basicActions.scrollToElement(helpDrawerParagraphLnk2);
                helpDrawerParagraphLnk2.click();
                break;
            case "Employer Coverage Tool 2 Spanish":
                basicActions.waitForElementToBePresent(helpDrawerParagraphLnk2Sp, 10);
                basicActions.scrollToElement(helpDrawerParagraphLnk2Sp);
                helpDrawerParagraphLnk2Sp.click();
                break;
            case "Employer Coverage Tool 3":
                basicActions.waitForElementToBePresent(helpDrawerPrintLnk, 10);
                basicActions.scrollToElement(helpDrawerPrintLnk);
                helpDrawerPrintLnk.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + lnkName);
        }
    }




    // =================== VALIDATION STEPS ===============//
    public void verifyFamilyOfferedToEnrollOption(String currentlyOffered){
        switch (currentlyOffered){
            case "Yes":
                basicActions.waitForElementToBePresent(esiFamilyOfferedYesBtn,15);
                softAssert.assertTrue(esiFamilyOfferedYesBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(esiFamilyOfferedNoBtn,15);
                softAssert.assertTrue(esiFamilyOfferedNoBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + currentlyOffered);
        }
    }

    public void verifyMonthlyAmount(String familyAmount){
        basicActions.waitForElementToBePresent(esiMonthlyAmountInput, 50);
        softAssert.assertTrue(esiMonthlyAmountInput.getAttribute("value").contains(familyAmount));
        softAssert.assertAll();
    }

    public void verifyFamilyEnrollmentStatusMember1(String enrollmentStatus) {
        switch (enrollmentStatus) {
            case "Enrolled":
                basicActions.waitForElementListToBePresent(esiFamilyEnrolledBtn, 20);
                softAssert.assertTrue(esiFamilyEnrolledBtn.get(0).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "Offered":
                basicActions.waitForElementListToBePresent(esiFamilyOfferedBtn, 20);
                softAssert.assertTrue(esiFamilyOfferedBtn.get(0).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No Option":
                basicActions.waitForElementListToBePresent(esiFamilyNoOptionBtn, 20);
                softAssert.assertTrue(esiFamilyNoOptionBtn.get(0).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + enrollmentStatus);
        }
    }

    public void verifyFamilyEnrollmentStatusMember2(String enrollmentStatus) {
        switch (enrollmentStatus) {
            case "Enrolled":
                basicActions.waitForElementListToBePresent(esiFamilyEnrolledBtn, 20);
                softAssert.assertTrue(esiFamilyEnrolledBtn.get(1).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "Offered":
                basicActions.waitForElementListToBePresent(esiFamilyOfferedBtn, 20);
                softAssert.assertTrue(esiFamilyOfferedBtn.get(1).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No Option":
                basicActions.waitForElementListToBePresent(esiFamilyNoOptionBtn, 20);
                softAssert.assertTrue(esiFamilyNoOptionBtn.get(1).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + enrollmentStatus);
        }
    }

    public void verifyHelpDrawerStatus(String drawerStatus) {
        switch (drawerStatus) {
            case "Closed English":
                basicActions.waitForElementToBeClickable(helpButton,10);
                softAssert.assertEquals(helpButton.getText(), "Help");
                softAssert.assertAll();
                break;
            case "Closed Spanish":
                basicActions.waitForElementToBeClickable(helpButton,10);
                softAssert.assertEquals(helpButton.getText(), "Ayuda");
                softAssert.assertAll();
                break;
            case"Open":
                basicActions.waitForElementToBeClickable(helpButton,10);
                softAssert.assertEquals(helpButton.getText(), "");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + drawerStatus);
        }
    }

    public void verifyHelpDrawerText(String drawerPage, String language) {
        switch (language) {
            case "English":
                verifyHelpDrawerTextEnglish(drawerPage);
                break;
            case "Spanish":
                verifyHelpDrawerTextSpanish(drawerPage);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHelpDrawerTextEnglish(String drawerPage) {
        switch (drawerPage) {
            case "Main":
                verifyHelpDrawerMainTextEnglish();
                break;
            case "Which job":
                verifyHelpDrawerWhichJobTextEnglish();
                break;
            case "Minimum Value":
                verifyHelpDrawerMinimumValueTextEnglish();
                break;
            case "Monthly Amount":
                verifyHelpDrawerMonthlyAmountTextEnglish();
                break;
            case "Currently Enrolled":
                verifyHelpDrawerCurrentlyEnrolledTextEnglish();
                break;
            case "End in 60 days":
                verifyHelpDrawerEnd60DaysTextEnglish();
                break;
            case "Voluntarily Ending":
                verifyHelpDrawerVoluntarilyEndingTextEnglish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + drawerPage);
        }
    }

    public void verifyHelpDrawerMainTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"Employer-sponsored Health Insurance");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(0).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Overview\nBefore you continue, gather any documents about health coverage that include information about premium costs and who in the household can get coverage.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "You may find this information in an online employee account, a letter, email, PDF, or another document from the job that's offering health coverage.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "If none of these are available, ask your job to fill out information in the Employer Information section of the Employer Coverage Tool.");
        softAssert.assertEquals(helpDrawerParagraphLnk1.getText(), "Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Tell us about coverage if you:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "Can get health coverage through a job, even if you're not currently enrolled or don't plan to enroll.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "Can get health coverage through a job, even if the employer's plan isn't currently in Open Enrollment.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "Don't think you can afford the coverage that's being offered. We'll ask more questions later to help determine if you can qualify for savings through Connect for Health Colorado.");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(1).getText(), "You don\u2019t need to answer these questions if:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(3).getText(), "You aren't offered coverage through your job at all.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(4).getText(), "You don't work enough hours to qualify for the coverage your job offers.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(5).getText(), "The only type of coverage available through a job is a Health Reimbursement Arrangement (HRA). However, if a person is offered an HRA and another group health insurance plan, select their name. Remember: you will also need to provide information about the HRA on the \"Other Health Insurance\" page.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(6).getText(), "Your only option for getting health insurance is COBRA continuation coverage or retiree coverage.");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(1).getText(), "If you are or will be in a \"waiting period\", don\u2019t answer these questions yet.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "If you are or will be in a \"waiting period\", don\u2019t answer these questions yet. When that waiting period ends, return to the application, report a life change, and enter your job\u2019s health insurance information here.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "A waiting period is the time that must pass before an employer offers an employee health coverage. Waiting periods can be 0-90 days.");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(3).getText(), "Minimum Value Standard:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(5).getText(), "Minimum Value Standard:\nMost health insurance plans offered by jobs meet the minimum value standard.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(6).getText(), "More about the minimum value standard\nA health plan meets the minimum value standard if it's designed to pay at least 60% of the total cost of medical services for a standard population, and if its benefits include substantial coverage of inpatient hospital and physician services.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(7).getText(), "To find out if a plan meets the minimum value standard, check the Summary of Benefits and Coverage (SBC) from your job\u2019s plan, or ask them to fill out the Employer Coverage Tool.");
        softAssert.assertEquals(helpDrawerParagraphLnk2.getText(), "Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(8).getText(), "Print or download the Employer Coverage Tool.");
        softAssert.assertEquals(helpDrawerPrintLnk.getText(), "Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(4).getText(), "Lowest-Cost Premium:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(9).getText(), "Lowest-Cost Premium:\nHint Text: Only enter the amount you would pay. Don't include any amount paid by your employer.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(10).getText(), "Learn more about entering premium amounts\nEnter the regular amount the employee would have to pay for their health coverage (the \"premium\") if they enrolled.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(11).getText(), "Enter the amount of the lowest-cost plan offered by the employer that would cover only the employee.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(12).getText(), "If the employer has wellness programs:\nEnter the premium this person would pay if they got the maximum discount for any tobacco cessation programs (counseling to stop smoking), but no other programs.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(13).getText(), "These amounts should be listed in a notice from your employer. But, if you don't have a notice or you're not sure what these amounts are, ask your employer.");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(6).getText(), "Enrollment:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(14).getText(), "Enrollment:\nIf this person currently has health insurance through this job, select \"Yes\". If this person is able to get this health insurance, but has chosen not to enroll, select \"No\".");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(2).getText(), "End in the next 60 days:\nIf this insurance will end soon because:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(7).getText(), "the job is ending,");
        softAssert.assertEquals(helpDrawerBodyPoints.get(8).getText(), "the company is no longer offering health insurance,");
        softAssert.assertEquals(helpDrawerBodyPoints.get(9).getText(), "or you won't qualify for it any longer,");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(15).getText(), "select \"Yes\" and enter the date the insurance will end.");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(7).getText(), "Voluntarily Ending Health Insurance:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(16).getText(), "Voluntarily Ending Health Insurance:\nSelect \"Yes\" if you are still eligible for health insurance through your employer but have chosen to cancel the plan or if you declined to enroll in a plan when you had the opportunity.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(17).getText(), "Select \"No\" if you are no longer eligible for health insurance through your employer or your employer used to offer health insurance and no longer provides health insurance.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(18).getText(), "Select \"No\" if your employer used to offer health insurance and now only offers a Health Reimbursement Arrangement (HRA)");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact Us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerWhichJobTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"Which job is offering health insurance?");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Tell us about coverage if you:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "Can get health coverage through a job, even if you're not currently enrolled or don't plan to enroll.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "Can get health coverage through a job, even if the employer's plan isn't currently in Open Enrollment.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "Don't think you can afford the coverage that's being offered. We'll ask more questions later to help determine if you can qualify for savings through Connect for Health Colorado.");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(1).getText(), "You don\u2019t need to answer these questions if:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(3).getText(), "You aren't offered coverage through your job at all.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(4).getText(), "You don't work enough hours to qualify for the coverage your job offers.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(5).getText(), "The only type of coverage available through a job is a Health Reimbursement Arrangement (HRA). However, if a person is offered an HRA and another group health insurance plan, select their name. Remember: you will also need to provide information about the HRA on the \"Other Health Insurance\" page.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(6).getText(), "Your only option for getting health insurance is COBRA continuation coverage or retiree coverage.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "If you are or will be in a \"waiting period\", don\u2019t answer these questions yet. When that waiting period ends, return to the application, report a life change, and enter your job\u2019s health insurance information here.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "A waiting period is the time that must pass before an employer offers an employee health coverage. Waiting periods can be 0-90 days.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact Us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerMinimumValueTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"Does this health insurance meet the Minimum Value Standard?");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(0).getText(), "Minimum Value Standard:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Minimum Value Standard:\nMost health insurance plans offered by jobs meet the minimum value standard.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "More about the minimum value standard\nA health plan meets the minimum value standard if it's designed to pay at least 60% of the total cost of medical services for a standard population, and if its benefits include substantial coverage of inpatient hospital and physician services.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "To find out if a plan meets the minimum value standard, check the Summary of Benefits and Coverage (SBC) from your job\u2019s plan, or ask them to fill out the Employer Coverage Tool.");
        softAssert.assertEquals(helpDrawerParagraphLnk1.getText(), "Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "Print or download the Employer Coverage Tool.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact Us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerMonthlyAmountTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"How much would you pay for the lowest-cost monthly health plan premium at "+SharedData.getEmployerName()+" just for yourself?");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(0).getText(), "Lowest-Cost Premium:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Lowest-Cost Premium:\nHint Text: Only enter the amount you would pay. Don't include any amount paid by your employer.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Learn more about entering premium amounts\nEnter the regular amount the employee would have to pay for their health coverage (the \"premium\") if they enrolled.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Enter the amount of the lowest-cost plan offered by the employer that would cover only the employee.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "If the employer has wellness programs:\nEnter the premium this person would pay if they got the maximum discount for any tobacco cessation programs (counseling to stop smoking), but no other programs.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "These amounts should be listed in a notice from your employer. But, if you don't have a notice or you're not sure what these amounts are, ask your employer.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact Us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerCurrentlyEnrolledTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"Are you currently enrolled in the health insurance offered by "+SharedData.getEmployerName()+"?");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(0).getText(), "Enrollment:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Enrollment:\nIf this person currently has health insurance through this job, select \"Yes\". If this person is able to get this health insurance, but has chosen not to enroll, select \"No\".");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact Us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerEnd60DaysTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"Will this health insurance end in the next 60 days?");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "End in the next 60 days:\nIf this insurance will end soon because:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "the job is ending,");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "the company is no longer offering health insurance,");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "or you won't qualify for it any longer,");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "select \"Yes\" and enter the date the insurance will end.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact Us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerVoluntarilyEndingTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"Are you voluntarily ending this health insurance?");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(0).getText(), "Voluntarily Ending Health Insurance:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Voluntarily Ending Health Insurance:\nSelect \"Yes\" if you are still eligible for health insurance through your employer but have chosen to cancel the plan or if you declined to enroll in a plan when you had the opportunity.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Select \"No\" if you are no longer eligible for health insurance through your employer or your employer used to offer health insurance and no longer provides health insurance.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Select \"No\" if your employer used to offer health insurance and now only offers a Health Reimbursement Arrangement (HRA).");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact Us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerTextSpanish(String drawerPage) {
        switch (drawerPage) {
            case "Main":
                verifyHelpDrawerMainTextSpanish();
                break;
            case "Which job":
                verifyHelpDrawerWhichJobTextSpanish();
                break;
            case "Minimum Value":
                verifyHelpDrawerMinimumValueTextSpanish();
                break;
            case "Monthly Amount":
                verifyHelpDrawerMonthlyAmountTextSpanish();
                break;
            case "Currently Enrolled":
                verifyHelpDrawerCurrentlyEnrolledTextSpanish();
                break;
            case "End in 60 days":
                verifyHelpDrawerEnd60DaysTextSpanish();
                break;
            case "Voluntarily Ending":
                verifyHelpDrawerVoluntarilyEndingTextSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + drawerPage);
        }
    }

    public void verifyHelpDrawerMainTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"Seguro de salud patrocinado por el empleador");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(0).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Resumen\nAntes de continuar, re\u00FAna todos los documentos sobre la cobertura de salud que incluyan informaci\u00F3n sobre el costo de las primas y qui\u00E9n en la familia puede tener cobertura.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Puede encontrar esta informaci\u00F3n en una cuenta de empleado en l\u00EDnea, una carta, un correo electr\u00F3nico, un PDF u otro documento del trabajo en el que se ofrece cobertura de salud.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Si no dispone de ninguno de ellos, pida en su trabajo que llenen la informaci\u00F3n de la secci\u00F3n \"Informaci\u00F3n del empleador\" de la herramienta de cobertura del empleador.");
        softAssert.assertEquals(helpDrawerParagraphLnk1.getText(), "herramienta de cobertura del empleador.");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Inf\u00F3rmenos sobre la cobertura en los siguientes casos:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "Puede obtener cobertura de salud a trav\u00E9s de un empleo, aunque no est\u00E9 inscrito actualmente ni tenga previsto hacerlo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "Puede obtener cobertura de salud a trav\u00E9s de un empleo, incluso si el plan del empleador no est\u00E1 actualmente en el per\u00EDodo de inscripci\u00F3n abierta.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "No cree que pueda pagar la cobertura que le ofrecen. M\u00E1s adelante, le haremos m\u00E1s preguntas para ayudarle a determinar si puede calificar para obtener ahorros a trav\u00E9s de Connect for Health Colorado.");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(1).getText(), "No tiene que responder estas preguntas en los siguientes casos:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(3).getText(), "No se le ofrece cobertura a trav\u00E9s de su empleo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(4).getText(), "No trabaja suficientes horas para calificar para la cobertura que ofrece su empleo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(5).getText(), "El \u00FAnico tipo de cobertura disponible a trav\u00E9s del trabajo es el acuerdo de reembolsos de salud (HRA). Sin embargo, si a una persona se le ofrece un HRA y otro plan de seguro de salud grupal, seleccione el nombre. Recuerde: tambi\u00E9n deber\u00E1 proporcionar informaci\u00F3n sobre el HRA en la p\u00E1gina \"Otros seguros de salud\".");
        softAssert.assertEquals(helpDrawerBodyPoints.get(6).getText(), "La \u00FAnica opci\u00F3n que tiene para conseguir un seguro de salud es la continuaci\u00F3n de la cobertura COBRA o la cobertura para retirados.");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(1).getText(), "Si est\u00E1 o va a estar en \"per\u00EDodo de espera\", no responda a\u00FAn estas preguntas. Cuando finalice ese per\u00EDodo de espera, vuelva a la solicitud, comunique el cambio de vida e introduzca aqu\u00ED los datos del seguro de salud de su trabajo.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "Un per\u00EDodo de espera es el tiempo que debe transcurrir antes de que un empleador ofrezca cobertura de salud a un empleado. Los per\u00EDodos de espera pueden ser de 0 a 90 d\u00EDas.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(6).getText(), "Est\u00E1ndar de valor m\u00EDnimo:\nLa mayor\u00EDa de los planes de seguro de salud que se ofrecen a trav\u00E9s de los trabajos cumplen el est\u00E1ndar de valor m\u00EDnimo.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(7).getText(), "M\u00E1s informaci\u00F3n sobre el est\u00E1ndar de valor m\u00EDnimo\nUn plan de salud cumple el est\u00E1ndar de valor m\u00EDnimo si est\u00E1 dise\u00F1ado para pagar al menos el 60% del costo total de los servicios m\u00E9dicos para una poblaci\u00F3n est\u00E1ndar y si sus beneficios incluyen una cobertura considerable de los servicios hospitalarios y m\u00E9dicos.");
        softAssert.assertEquals(helpDrawerParagraphLnk2Sp.getText(), "herramienta de cobertura del empleador.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(8).getText(), "Para saber si un plan cumple el est\u00E1ndar de valor m\u00EDnimo, consulte el Resumen de beneficios y cobertura (SBC) del plan de su empleo o pida en su trabajo que le llenen la herramienta de cobertura del empleador.");
        softAssert.assertEquals(helpDrawerPrintLnk.getText(), "herramienta de cobertura del empleador.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(9).getText(), "Imprima o descargue la herramienta de cobertura del empleador.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(10).getText(), "Prima de costo m\u00E1s bajo:\nTexto de sugerencia: Solo ingrese la cantidad que pagar\u00EDa. No incluya ninguna cantidad que pague su empleador.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(11).getText(), "Obtenga m\u00E1s informaci\u00F3n sobre c\u00F3mo ingresar las cantidades de las primas\nIngrese la cantidad normal que el empleado tendr\u00EDa que pagar por su cobertura de salud (la \"prima\") si se inscribiera.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(12).getText(), "Ingrese la cantidad del plan de menor costo que ofrece el empleador y que cubrir\u00EDa solo al empleado.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(13).getText(), "Si el empleador tiene programas de bienestar, haga lo siguiente:\nIngrese la prima que pagar\u00EDa esta persona si obtuviera el descuento m\u00E1ximo para cualquier programa de suspensi\u00F3n al tabaco (consejer\u00EDa para dejar de fumar), pero para ning\u00FAn otro programa.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(14).getText(), "El empleador debe indicar estas cantidades en un aviso. Sin embargo, si usted no dispone de un aviso o no est\u00E1 seguro de cu\u00E1les son estas cantidades, pregunte a su empleador.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(15).getText(), "Inscripci\u00F3n:\nSi esta persona tiene actualmente seguro de salud a trav\u00E9s de este trabajo, seleccione \"S\u00ED\". Si esta persona puede obtener ese seguro de salud, pero ha preferido no inscribirse, seleccione \"No\".");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(2).getText(), "Finalizaci\u00F3n en los pr\u00F3ximos 60 d\u00EDas:\nSi este seguro acabar\u00E1 pronto porque:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(7).getText(), "el trabajo est\u00E1 por terminarse;");
        softAssert.assertEquals(helpDrawerBodyPoints.get(8).getText(), "la empresa ya no ofrecer\u00E1 seguro de salud;");
        softAssert.assertEquals(helpDrawerBodyPoints.get(9).getText(), "usted ya no calificar\u00E1 para recibirlo;");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(16).getText(), "seleccione \"S\u00ED\" e ingrese la fecha en que terminar\u00E1 el seguro.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(17).getText(), "Cancelar el seguro de salud de manera voluntaria:\nSeleccione \"S\u00ED\" si todav\u00EDa es elegible para recibir seguro de salud a trav\u00E9s de su empleador, pero ha elegido cancelar el plan o si rechaz\u00F3 la inscripci\u00F3n cuando tuvo la oportunidad.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(18).getText(), "Seleccione \"No\" si ya no es elegible para recibir seguro de salud por medio de su empleador o si su empleador ofrec\u00EDa seguro de salud y ya no lo ofrece.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(19).getText(), "Seleccione \"No\" si su empleador ofrec\u00EDa seguro de salud y ahora solo ofrece un acuerdo de reembolsos de salud (HRA).");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesita m\u00E1s ayuda? P\u00F3ngase en contacto");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerWhichJobTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"\u00BFQu\u00E9 empleo le ofrece seguro de salud?");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Inf\u00F3rmenos sobre la cobertura en los siguientes casos:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "Puede obtener cobertura de salud a trav\u00E9s de un empleo, aunque no est\u00E9 inscrito actualmente ni tenga previsto hacerlo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "Puede obtener cobertura de salud a trav\u00E9s de un empleo, incluso si el plan del empleador no est\u00E1 actualmente en el per\u00EDodo de inscripci\u00F3n abierta.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "No cree que pueda pagar la cobertura que le ofrecen. M\u00E1s adelante, le haremos m\u00E1s preguntas para ayudarle a determinar si puede calificar para obtener ahorros a trav\u00E9s de Connect for Health Colorado.");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(1).getText(), "No tiene que responder estas preguntas en los siguientes casos:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(3).getText(), "No se le ofrece cobertura a trav\u00E9s de su empleo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(4).getText(), "No trabaja suficientes horas para calificar para la cobertura que ofrece su empleo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(5).getText(), "El \u00FAnico tipo de cobertura disponible a trav\u00E9s del trabajo es el acuerdo de reembolsos de salud (HRA). Sin embargo, si a una persona se le ofrece un HRA y otro plan de seguro de salud grupal, seleccione el nombre. Recuerde: tambi\u00E9n deber\u00E1 proporcionar informaci\u00F3n sobre el HRA en la p\u00E1gina \"Otros seguros de salud\".");
        softAssert.assertEquals(helpDrawerBodyPoints.get(6).getText(), "La \u00FAnica opci\u00F3n que tiene para conseguir un seguro de salud es la continuaci\u00F3n de la cobertura COBRA o la cobertura para retirados.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Si est\u00E1 o va a estar en \"per\u00EDodo de espera\", no responda a\u00FAn estas preguntas. Cuando finalice ese per\u00EDodo de espera, vuelva a la solicitud, comunique el cambio de vida e introduzca aqu\u00ED los datos del seguro de salud de su trabajo.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Un per\u00EDodo de espera es el tiempo que debe transcurrir antes de que un empleador ofrezca cobertura de salud a un empleado. Los per\u00EDodos de espera pueden ser de 0 a 90 d\u00EDas.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesita m\u00E1s ayuda? P\u00F3ngase en contacto");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerMinimumValueTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"\u00BFCumple este seguro de salud el est\u00E1ndar de valor m\u00EDnimo?");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Est\u00E1ndar de valor m\u00EDnimo:\nLa mayor\u00EDa de los planes de seguro de salud que se ofrecen a trav\u00E9s de los trabajos cumplen el est\u00E1ndar de valor m\u00EDnimo.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "M\u00E1s informaci\u00F3n sobre el est\u00E1ndar de valor m\u00EDnimo\nUn plan de salud cumple el est\u00E1ndar de valor m\u00EDnimo si est\u00E1 dise\u00F1ado para pagar al menos el 60% del costo total de los servicios m\u00E9dicos para una poblaci\u00F3n est\u00E1ndar y si sus beneficios incluyen una cobertura considerable de los servicios hospitalarios y m\u00E9dicos.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Para saber si un plan cumple el est\u00E1ndar de valor m\u00EDnimo, consulte el Resumen de beneficios y cobertura (SBC) del plan de su empleo o pida en su trabajo que le llenen la herramienta de cobertura del empleador.");
        softAssert.assertEquals(helpDrawerPrintLnk.getText(), "herramienta de cobertura del empleador.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "Imprima o descargue la herramienta de cobertura del empleador.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesita m\u00E1s ayuda? P\u00F3ngase en contacto");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerMonthlyAmountTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"\u00BFCu\u00E1nto pagar\u00EDa por la prima mensual del plan de salud de menor costo en "+SharedData.getEmployerName()+" solo para usted?");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Prima de costo m\u00E1s bajo:\nTexto de sugerencia: Solo ingrese la cantidad que pagar\u00EDa. No incluya ninguna cantidad que pague su empleador.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Obtenga m\u00E1s informaci\u00F3n sobre c\u00F3mo ingresar las cantidades de las primas\nIngrese la cantidad normal que el empleado tendr\u00EDa que pagar por su cobertura de salud (la \"prima\") si se inscribiera.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Ingrese la cantidad del plan de menor costo que ofrece el empleador y que cubrir\u00EDa solo al empleado.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "Si el empleador tiene programas de bienestar, haga lo siguiente:\nIngrese la prima que pagar\u00EDa esta persona si obtuviera el descuento m\u00E1ximo para cualquier programa de suspensi\u00F3n al tabaco (consejer\u00EDa para dejar de fumar), pero para ning\u00FAn otro programa.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "El empleador debe indicar estas cantidades en un aviso. Sin embargo, si usted no dispone de un aviso o no est\u00E1 seguro de cu\u00E1les son estas cantidades, pregunte a su empleador.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesita m\u00E1s ayuda? P\u00F3ngase en contacto");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerCurrentlyEnrolledTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"\u00BFEst\u00E1 inscrito actualmente en el seguro de salud que ofrece "+SharedData.getEmployerName()+"?");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Inscripci\u00F3n:\nSi esta persona tiene actualmente seguro de salud a trav\u00E9s de este trabajo, seleccione \"S\u00ED\". Si esta persona puede obtener ese seguro de salud, pero ha preferido no inscribirse, seleccione \"No\".");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesita m\u00E1s ayuda? P\u00F3ngase en contacto");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerEnd60DaysTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"\u00BFEste seguro de salud terminar\u00E1 en los siguientes 60 d\u00EDas?");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Finalizaci\u00F3n en los pr\u00F3ximos 60 d\u00EDas:\nSi este seguro acabar\u00E1 pronto porque:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "el trabajo est\u00E1 por terminarse;");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "la empresa ya no ofrecer\u00E1 seguro de salud;");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "usted ya no calificar\u00E1 para recibirlo;");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "seleccione \"S\u00ED\" e ingrese la fecha en que terminar\u00E1 el seguro.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesita m\u00E1s ayuda? P\u00F3ngase en contacto");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerVoluntarilyEndingTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"\u00BFEst\u00E1 cancelando voluntariamente este seguro de salud?");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Cancelar el seguro de salud de manera voluntaria:\nSeleccione \"S\u00ED\" si todav\u00EDa es elegible para recibir seguro de salud a trav\u00E9s de su empleador, pero ha elegido cancelar el plan o si rechaz\u00F3 la inscripci\u00F3n cuando tuvo la oportunidad.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Seleccione \"No\" si ya no es elegible para recibir seguro de salud por medio de su empleador o si su empleador ofrec\u00EDa seguro de salud y ya no lo ofrece.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Seleccione \"No\" si su empleador ofrec\u00EDa seguro de salud y ahora solo ofrece un acuerdo de reembolsos de salud (HRA).");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesita m\u00E1s ayuda? P\u00F3ngase en contacto");
        softAssert.assertAll();
    }




}