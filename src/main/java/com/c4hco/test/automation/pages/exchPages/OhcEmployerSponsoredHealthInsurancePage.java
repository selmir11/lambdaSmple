package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class OhcEmployerSponsoredHealthInsurancePage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public OhcEmployerSponsoredHealthInsurancePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container .header-1")
    WebElement OhcHeader;

    @FindBy(css = ".container .header-2")
    WebElement OhcEsiHeader;

    @FindBy(css = "div > label")
    List<WebElement> EsiQuestionTxt;

    @FindBy(css = "lib-error-msg > div")
    List<WebElement> hdrError;

    @FindBy(css = "#ELIG-Ohc-Esi-employer-container span.error-message")
    WebElement whichJobError;

    @FindBy(css = "#ELIG-Ohc-Esi-employer")
    WebElement esiSelectEmployerDpd;

    @FindBy(css = "#ELIG-Ohc-Esi-minStdVal-container span.error-message")
    WebElement minValueError;

    @FindBy(id = "ELIG-Ohc-Esi-minStdVal-YesButton")
    WebElement esiMinValueStandardYesBtn;

    @FindBy(id = "ELIG-Ohc-Esi-minStdVal-NoButton")
    WebElement esiMinValueStandardNoBtn;

    @FindBy(id = "ELIG-Ohc-Esi-minStdVal-IDontKnowButton")
    WebElement esiMinValueStandardDontKnowBtn;

    @FindBy(css = "#ELIG-Ohc-Esi-EmpSponsCovgMonthlyPremium-container span.error-message")
    WebElement amountError;

    @FindBy(css = "#ELIG-Ohc-Esi-EmpSponsCovgMonthlyPremium")
    WebElement esiMonthlyAmountInput;

    @FindBy(css = "#ELIG-Ohc-Esi-currEnrl-container span.error-message")
    WebElement currentlyEnrolledError;

    @FindBy(id = "ELIG-Ohc-Esi-currEnrl-YesButton")
    WebElement esiCurrentlyEnrolledYesBtn;

    @FindBy(id = "ELIG-Ohc-Esi-currEnrl-NoButton")
    WebElement esiCurrentlyEnrolledNoBtn;

    @FindBy(css = "#ELIG-Ohc-Esi-covgEndsSoon-container span.error-message")
    WebElement insuranceEndingError;

    @FindBy(id = "ELIG-Ohc-Esi-covgEndsSoon-YesButton")
    WebElement esiInsuranceEndYesBtn;

    @FindBy(id = "ELIG-Ohc-Esi-covgEndsSoon-NoButton")
    WebElement esiInsuranceEndNoBtn;

    @FindBy(css = "#ELIG-Ohc-Esi-empSponsCovgEndDate-container span.error-message")
    WebElement inputEndDateError;

    @FindBy(css = "#ELIG-Ohc-Esi-empSponsCovgEndDate")
    WebElement esiEndDateInput;

    @FindBy(css = "#ELIG-Ohc-Esi-empVoluntaryEnd-container span.error-message")
    WebElement endVoluntaryError;

    @FindBy(id = "ELIG-Ohc-Esi-empVoluntaryEnd-YesButton")
    WebElement esiVoluntarilyEndingYesBtn;

    @FindBy(id = "ELIG-Ohc-Esi-empVoluntaryEnd-NoButton")
    WebElement esiVoluntarilyEndingNoBtn;

    @FindBy(css = "#ELIG-Ohc-Esi-FamilyCoveragePlanOffered-container span.error-message")
    WebElement esiFamilyOfferedError;

    @FindBy(id = "ELIG-Ohc-Esi-FamilyCoveragePlanOffered-YesButton")
    WebElement esiFamilyOfferedYesBtn;

    @FindBy(id = "ELIG-Ohc-Esi-FamilyCoveragePlanOffered-NoButton")
    WebElement esiFamilyOfferedNoBtn;

    @FindBy(css = "#ELIG-Ohc-Esi-EmpSponsCovgFamilyMonthlyPremium")
    WebElement esiMonthlyAmountFamilyInput;

    @FindBy(css = "#ELIG-Ohc-Esi-EmpSponsCovgFamilyMonthlyPremium-container span.error-message")
    WebElement esiFamilyAmountError;

    @FindBy(css = "#ELIG-Ohc-Esi-MemberCoverage > div > span")
    WebElement esiMemberStatusTxt;

    @FindBy(css = "#ELIG-Ohc-Esi-MemberCoverage span.error-message")
    WebElement esiFamilyStatusError;

    @FindBy(css = "app-other-member-coverage > div > span")
    List<WebElement> esiFamilyMemberTxt;

    @FindBy(xpath = "//*[@id='ELIG-Ohc-Esi-MemberCoverage']//button[contains(@id, 'CoverageTypeEnrolledButton')]")
    List<WebElement> esiFamilyEnrolledBtn;

    @FindBy(xpath = "//*[@id='ELIG-Ohc-Esi-MemberCoverage']//button[contains(@id, 'CoverageTypeAccessButton')]")
    List<WebElement> esiFamilyOfferedBtn;

    @FindBy(xpath = "//*[@id='ELIG-Ohc-Esi-MemberCoverage']//button[contains(@id, 'CoverageTypeNoAccessButton')]")
    List<WebElement> esiFamilyNoOptionBtn;

    @FindBy(id = "Help.Button")
    WebElement helpButton;

    @FindBy(css = ".header-3.content-center > a")
    WebElement helpCenterTxt;

    @FindBy(css = ".header-3.content-center.ng-star-inserted > a")
    WebElement helpUnderstandLnk;

    @FindBy(css = "lib-help-icon a")
    List<WebElement> helpIcon;

    @FindBy(css = ".desktop-help > div > span.c4-text-body-200")
    WebElement helpHeaderTxt;

    @FindBy(css = ".desktop-help > div > span.title.c4-type-header-sm")
    WebElement helpSubHeaderTxt;

    @FindBy(css = ".help-main-content div.section-help-content-container span")
    List<WebElement> helpDrawerHeaderTxt;

    @FindBy(css = ".help-main-content > div > div > span")
    List<WebElement> helpDrawerSubHeaderTxt;

    @FindBy(css = ".help-main-content > div > div > div> span")
    List<WebElement> helpDrawerHeaderSection2Txt;

    @FindBy(css = ".section-help-content-container > div > div > div")
    WebElement helpDrawerWaitingPeriodTxt;

    @FindBy(css = ".section-help-content-container > div > div > span")
    List<WebElement> helpDrawerSubHdrTxt;

    @FindBy(css = ".help-main-content > div > span")
    List<WebElement> helpDrawerSubHdr2Txt;

    @FindBy(css = ".help-main-content > div > div > div")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = ".help-main-content> div > div")
    List<WebElement> helpDrawerBodyParagraphs2;

    @FindBy(css = "lib-help-window-link > a")
    List<WebElement> helpDrawerParagraphLnk1;

    @FindBy(css = ".help-main-content > div > div > div > div > lib-help-window-link > a")
    WebElement helpDrawerParagraphLnk2;

    @FindBy(css = ".help-main-content li")
    List<WebElement> helpDrawerBodyPoints;

    @FindBy(css = "em > lib-help-window-link > a")
    WebElement helpDrawerPrintLnk;

    @FindBy(css = ".help-main-content > div > div > em")
    WebElement helpDrawerPrintTxt;

    @FindBy(css = ".help-footer")
    WebElement helpDrawerFooter;

    @FindBy(css = ".help-footer.ng-star-inserted a")
    WebElement helpDrawerContactUsLink;

    @FindBy(id = "Ohc-Esi-GoBack")
    WebElement goBackButton;

    @FindBy(id = "Ohc-Esi-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(xpath = "//span[text()='Please select one of the options below']")
    WebElement errHealtInsMeetEn;
    @FindBy(xpath = "//span[text()='Amount is required']")
    WebElement errHwMuchWdUPayEn;
    @FindBy(xpath = "//span[text()='Date is required']")
    WebElement errDateIsReqEn;
    @FindBy(xpath = "//span[text()='Please select one of the options below']//following::span[15]")
    WebElement errVolEndInsEn;

    @FindBy(css = "div.input-error-message.error-icon.ng-star-inserted span.error-message")
    WebElement healthinsuranceenrollmentstatuserrorMessage;

    


    public void clickGoBack() {
        basicActions.waitForElementToBeClickable(goBackButton, 20);
        basicActions.click(goBackButton);
    }

    public void clickSaveAndContinue() {
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
    }

    public void selectEmployer(String intString, String member) {
        int index = Integer.parseInt(intString);
        basicActions.waitForElementToBeClickable(esiSelectEmployerDpd, 50);
        String setEmployerName;
        Select dropdown = new Select(esiSelectEmployerDpd);

        switch (member) {
            case "Primary":
                setEmployerName = SharedData.getPrimaryMember().getEmployerName();
                break;
            case "Secondary":
                setEmployerName = SharedData.getMembers().get(index).getEmployerName();
                break;
            case "Third":
                setEmployerName = SharedData.getMembers().get(1).getEmployerName();
                break;
            default:
                throw new IllegalArgumentException("Invalid member type: " + member);
        }

        dropdown.selectByVisibleText(setEmployerName);
    }

    public void clickMinValueStandard(String minValueStandard) {
        basicActions.waitForElementToBeClickable(esiMinValueStandardYesBtn, 20);
        switch (minValueStandard) {
            case "Yes":
                basicActions.click(esiMinValueStandardYesBtn);
                break;
            case "No":
                basicActions.click(esiMinValueStandardNoBtn);
                break;
            case "I don't know":
                basicActions.click(esiMinValueStandardDontKnowBtn);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + minValueStandard);
        }
    }

    public void enterMonthlyAmount(String employeeAmount) {
        basicActions.waitForElementToBePresent(esiMonthlyAmountInput, 50);
        esiMonthlyAmountInput.clear();
        esiMonthlyAmountInput.sendKeys(employeeAmount);
    }

    public void clickCurrentlyEnrolled(String currentlyEnrolled) {
        basicActions.waitForElementToBePresent(esiCurrentlyEnrolledNoBtn, 30);
        switch (currentlyEnrolled) {
            case "Yes":
                basicActions.click(esiCurrentlyEnrolledYesBtn);
                break;
            case "No":
                basicActions.click(esiCurrentlyEnrolledNoBtn);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + currentlyEnrolled);
        }
    }

    public void clickInsuranceEnd(String willEnd) {
        basicActions.waitForElementToBePresent(esiInsuranceEndYesBtn, 30);
        switch (willEnd) {
            case "Yes":
                basicActions.click(esiInsuranceEndYesBtn);
                break;
            case "No":
                basicActions.click(esiInsuranceEndNoBtn);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + willEnd);
        }
    }

    public void enterEndDate(String endDate) {
        basicActions.waitForElementToBePresent(esiEndDateInput, 60);
        switch (endDate) {
            case "Today":
                esiEndDateInput.sendKeys(basicActions.changeDateFormat(basicActions.getTodayDate(), "MM/dd/yyyy", "MMdd"));
                break;
            case "Current Month":
                esiEndDateInput.sendKeys(basicActions.changeDateFormat(basicActions.lastDateOfCurrMonth(), "MM-dd-yyyy", "MMdd"));
                break;
            case "Prior Month":
                esiEndDateInput.sendKeys(basicActions.changeDateFormat(basicActions.getPastDate(1), "MM/dd/yyyy", "MMdd"));
                break;
            case "Future Month":
                esiEndDateInput.sendKeys(basicActions.changeDateFormat(basicActions.getFutureDate(61), "MM/dd/yyyy", "MMdd"));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + endDate);
        }
    }

    public void clickVoluntarilyEnding(String voluntarilyEnding) {
        switch (voluntarilyEnding) {
            case "Yes":
                basicActions.waitForElementToBeClickable(esiVoluntarilyEndingYesBtn, 20);
                basicActions.click(esiVoluntarilyEndingYesBtn);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(esiVoluntarilyEndingNoBtn, 20);
                basicActions.click(esiVoluntarilyEndingNoBtn);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + voluntarilyEnding);
        }
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

    public void enterMonthlyFamilyAmount(String familyAmount) {
        basicActions.waitForElementToBePresent(esiMonthlyAmountFamilyInput, 50);
        esiMonthlyAmountFamilyInput.clear();
        esiMonthlyAmountFamilyInput.sendKeys(familyAmount);
    }

    public void clickFamilyEnrollmentStatusMembers(List<String> expectedValues) {
//        status types are Enrolled, TypeAccess (Offered but not enrolled), NoAccess
        for (String option : expectedValues) {
            String[] parts = option.split(":");

            String name = parts[0].trim();
            String enrollmentStatus = parts[1].trim();

            clickFamilyEnrollmentStatusMember(name, enrollmentStatus);
        }
    }

    private void clickFamilyEnrollmentStatusMember(String name, String enrollmentStatus) {
        String xpath = String.format("//*[contains(text(),'%s')]//following::button[contains(@id, 'Button') and contains(@id,'%s')]", name, enrollmentStatus);

        System.out.println("XPath: " + xpath);

        WebElement button = basicActions.getDriver().findElement(By.xpath(xpath));
        button.click();
    }

    public void clickMainHelp() {
        basicActions.waitForElementToBeClickable(helpButton, 10);
        basicActions.click(helpButton);
    }

    public void clickIconHelp(String iconName) {
        switch (iconName) {
            case "Header":
                basicActions.click(helpCenterTxt);
                break;
            case "Help Me Understand":
                basicActions.click(helpUnderstandLnk);
                break;
            case "Which job":
                basicActions.click(helpIcon.get(0));
                break;
            case "Minimum Value":
                basicActions.click(helpIcon.get(1));
                break;
            case "Monthly Amount":
                basicActions.click(helpIcon.get(2));
                break;
            case "Currently Enrolled":
                basicActions.click(helpIcon.get(3));
                break;
            case "End in 60 days":
                basicActions.click(helpIcon.get(4));
                break;
            case "Voluntarily Ending":
                basicActions.click(helpIcon.get(5));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + iconName);
        }
    }

    public void clickHelpDrawerContactUs(String lnkName) {
        switch (lnkName) {
            case "Contact Us":
                basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
                helpDrawerContactUsLink.click();
                break;
            case "Employer Coverage Tool 1":
                basicActions.waitForElementListToBePresentWithRetries(helpDrawerParagraphLnk1, 10);
                basicActions.scrollToElement(helpDrawerParagraphLnk1.get(0));
                helpDrawerParagraphLnk1.get(0).click();
                break;
            case "Employer Coverage Tool 2":
                basicActions.waitForElementToBePresent(helpDrawerParagraphLnk2, 10);
                basicActions.scrollToElement(helpDrawerParagraphLnk2);
                helpDrawerParagraphLnk2.click();
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
    public void verifyHeadersEsiOhcPage(String language) {
        switch (language) {
            case "English":
                verifyHeadersEsiOhcPageEnglish();
                break;
            case "Spanish":
                verifyHeadersEsiOhcPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersEsiOhcPageEnglish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        basicActions.waitForElementToBePresent(OhcEsiHeader, 15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcEsiHeader.getText(), "Employer-sponsored Health Insurance");
        softAssert.assertAll();
    }

    public void verifyHeadersEsiOhcPageSpanish() {
        basicActions.waitForElementToBePresentWithRetries(OhcHeader, 15);
        basicActions.waitForElementToBePresentWithRetries(OhcEsiHeader, 15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcEsiHeader.getText(), "Seguro de salud patrocinado por el empleador");
        softAssert.assertAll();
    }


    public void verifyCurrentSelections(String question, String dataOffered) {
        basicActions.wait(500);
        switch (question) {

            case "Min Value":
                verifyMinValueOption(dataOffered);
                break;
            case "Amount":
                verifyAmountOption(dataOffered);
                break;
            case "Currently Enrolled":
                verifyCurrentlyEnrolledOption(dataOffered);
                break;
            case "Insurance Ending":
                verifyInsuranceEndingOption(dataOffered);
                break;
            case "Input Date":
                verifyInputDateOption(dataOffered);
                break;
            case "Voluntary End":
                verifyVoluntarilyEndOption(dataOffered);
                break;
            case "Family Offered":
                verifyFamilyOfferedToEnrollOption(dataOffered);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + question);
        }
    }

    public void verifyMinValueOption(String dataOffered) {
        switch (dataOffered) {
            case "Yes":
                basicActions.waitForElementToBePresent(esiMinValueStandardYesBtn, 15);
                softAssert.assertTrue(esiMinValueStandardYesBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(esiMinValueStandardNoBtn, 15);
                softAssert.assertTrue(esiMinValueStandardNoBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "I don't know":
                basicActions.waitForElementToBePresent(esiMinValueStandardDontKnowBtn, 15);
                softAssert.assertTrue(esiMinValueStandardDontKnowBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataOffered);
        }
    }

    public void verifyAmountOption(String dataOffered) {
        basicActions.waitForElementToBePresent(esiMonthlyAmountInput, 15);
        softAssert.assertTrue(esiMonthlyAmountInput.getAttribute("value").equals(dataOffered));
        softAssert.assertAll();
    }

    public void verifyCurrentlyEnrolledOption(String dataOffered) {
        switch (dataOffered) {
            case "Yes":
                basicActions.waitForElementToBePresent(esiCurrentlyEnrolledYesBtn, 15);
                softAssert.assertTrue(esiCurrentlyEnrolledYesBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(esiCurrentlyEnrolledNoBtn, 15);
                softAssert.assertTrue(esiCurrentlyEnrolledNoBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataOffered);
        }
    }

    public void verifyInsuranceEndingOption(String dataOffered) {
        switch (dataOffered) {
            case "Yes":
                basicActions.waitForElementToBePresent(esiInsuranceEndYesBtn, 15);
                softAssert.assertTrue(esiInsuranceEndYesBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(esiInsuranceEndNoBtn, 15);
                softAssert.assertTrue(esiInsuranceEndNoBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataOffered);
        }
    }

    public void verifyInputDateOption(String dataOffered) {
        basicActions.waitForElementToBePresent(esiEndDateInput, 60);

        switch (dataOffered) {
            case "Current Month":
                String endOfCurrentMonth = basicActions.endOfMonthDate();
                endOfCurrentMonth = basicActions.changeDateFormat(endOfCurrentMonth, "MM/dd/yyyy", "yyyy-MM-dd");
                softAssert.assertTrue(esiEndDateInput.getAttribute("value").equals(endOfCurrentMonth), "Expected " + endOfCurrentMonth + " Found " + esiEndDateInput.getAttribute("value"));
                softAssert.assertAll();
                break;
            case "Today":
                String todayDate = basicActions.getTodayDate();
                todayDate = basicActions.changeDateFormat(todayDate, "MM/dd/yyyy", "yyyy-MM-dd");
                softAssert.assertTrue(esiEndDateInput.getAttribute("value").equals(todayDate), "Expected " + todayDate + " Found " + esiEndDateInput.getAttribute("value"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataOffered);
        }
    }

    public void verifyVoluntarilyEndOption(String dataOffered) {
        switch (dataOffered) {
            case "Yes":
                basicActions.waitForElementToBePresent(esiVoluntarilyEndingYesBtn, 15);
                softAssert.assertTrue(esiVoluntarilyEndingYesBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(esiVoluntarilyEndingNoBtn, 15);
                softAssert.assertTrue(esiVoluntarilyEndingNoBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataOffered);
        }
    }

    public void verifyFamilyOfferedToEnrollOption(String dataOffered) {
        switch (dataOffered) {
            case "Yes":
                basicActions.waitForElementToBePresent(esiFamilyOfferedYesBtn, 15);
                softAssert.assertTrue(esiFamilyOfferedYesBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(esiFamilyOfferedNoBtn, 15);
                softAssert.assertTrue(esiFamilyOfferedNoBtn.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataOffered);
        }
    }

    public void verifyMonthlyAmount(String familyAmount) {
        basicActions.waitForElementToBePresent(esiMonthlyAmountFamilyInput, 50);
        softAssert.assertTrue(esiMonthlyAmountFamilyInput.getAttribute("value").contains(familyAmount));
        softAssert.assertAll();
    }

    public void verifyFamilyEnrollmentStatusMembers(List<Map<String, String>> expectedValues) {
        for (int i = 0; i < expectedValues.size(); i++) {
            String txtToClick = expectedValues.get(i).get("enrollmentStatus");
            verifyFamilyEnrollmentStatusMember(txtToClick, i);
        }
    }

    public void verifyFamilyEnrollmentStatusMember(String enrollmentStatus, int memberIndex) {
        switch (enrollmentStatus) {
            case "Enrolled":
                basicActions.waitForElementListToBePresent(esiFamilyEnrolledBtn, 60);
                softAssert.assertTrue(esiFamilyEnrolledBtn.get(memberIndex).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "Offered":
                basicActions.waitForElementListToBePresent(esiFamilyOfferedBtn, 60);
                softAssert.assertTrue(esiFamilyOfferedBtn.get(memberIndex).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No Option":
                basicActions.waitForElementListToBePresent(esiFamilyNoOptionBtn, 60);
                softAssert.assertTrue(esiFamilyNoOptionBtn.get(memberIndex).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + enrollmentStatus);
        }
    }

    public void verifyEsiPageData(String dataToVerify, String language) {
        basicActions.waitForElementToBePresentWithRetries(OhcHeader, 15);
        switch (language) {
            case "English":
                verifyEsiPageDataEnglish(dataToVerify);
                break;
            case "Spanish":
                verifyEsiPageDataSpanish(dataToVerify);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyEsiPageDataEnglish(String dataToVerify) {
        basicActions.waitForElementToBePresentWithRetries(OhcHeader, 15);
        switch (dataToVerify) {
            case "No Job Section":
                verifyEsiPageNoJobSectionDataEnglish();
                break;
            case "Job Section":
                verifyEsiPageNoJobSectionDataEnglish();
                verifyEsiPageJobSectionDataEnglish();
                break;
            case "Currently Enrolled Section":
                verifyEsiPageNoJobSectionDataEnglish();
                verifyEsiPageJobSectionDataEnglish();
                verifyEsiPageCurrentlyEnrolledSectionDataEnglish();
                break;
            case "Currently Enrolled Ending Section":
                verifyEsiPageNoJobSectionDataEnglish();
                verifyEsiPageJobSectionDataEnglish();
                verifyEsiPageCurrentlyEnrolledSectionDataEnglish();
                verifyEsiPageCurrentlyEnrolledEndingSectionDataEnglish();
                break;
            case "Family Plans Section":
                verifyEsiPageNoJobSectionDataEnglish();
                verifyEsiPageJobSectionDataEnglish();
                verifyEsiPageCurrentlyEnrolledSectionDataEnglish();
                verifyEsiPageCurrentlyEnrolledEndingSectionDataEnglish();
                verifyEsiPageFamilyPlansSectionDataEnglish();
                break;
            case "No Job Section Secondary":
                verifyEsiPageFirstSectionSecondaryDataEnglish();
                break;
            case "Job Section Secondary":
                verifyEsiPageFirstSectionSecondaryDataEnglish();
                verifyEsiPageSecondSectionSecondaryDataEnglish();
                break;
            case "Currently Enrolled Section Secondary":
                verifyEsiPageFirstSectionSecondaryDataEnglish();
                verifyEsiPageSecondSectionSecondaryDataEnglish();
                verifyEsiPageCurrentlyEnrolledSectionDataEnglish();
                break;
            case "Currently Enrolled Ending Section Secondary":
                verifyEsiPageFirstSectionSecondaryDataEnglish();
                verifyEsiPageSecondSectionSecondaryDataEnglish();
                verifyEsiPageCurrentlyEnrolledSectionDataEnglish();
                verifyEsiPageCurrentlyEnrolledEndingSectionSecondaryDataEnglish();
                break;
            case "Family Plans Section Secondary":
                verifyEsiPageFirstSectionSecondaryDataEnglish();
                verifyEsiPageSecondSectionSecondaryDataEnglish();
                verifyEsiPageCurrentlyEnrolledSectionDataEnglish();
                verifyEsiPageCurrentlyEnrolledEndingSectionSecondaryDataEnglish();
                verifyEsiPageFamilyPlansSectionSecondaryDataEnglish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackButton.getText(), "Go back");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertAll();
    }

    public void verifyEsiPageNoJobSectionDataEnglish() {
        basicActions.waitForElementToBePresentWithRetries(OhcHeader, 15);
        basicActions.waitForElementToBePresentWithRetries(OhcEsiHeader, 15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcEsiHeader.getText(), "Employer-sponsored Health Insurance");
        softAssert.assertEquals(EsiQuestionTxt.get(0).getText(), "Which job is offering health insurance?");
        softAssert.assertEquals(esiSelectEmployerDpd.getText(), "Select an employer\n" + SharedData.getPrimaryMember().getEmployerName());
        softAssert.assertAll();
    }

    public void verifyEsiPageJobSectionDataEnglish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertEquals(EsiQuestionTxt.get(1).getText(), "Does this health insurance meet the Minimum Value Standard?");
        softAssert.assertEquals(esiMinValueStandardYesBtn.getText(), "Yes");
        softAssert.assertEquals(esiMinValueStandardNoBtn.getText(), "No");
        softAssert.assertEquals(esiMinValueStandardDontKnowBtn.getText(), "I don't know");
        softAssert.assertEquals(EsiQuestionTxt.get(2).getText(), "How much would you pay for the lowest-cost monthly health plan premium at " + SharedData.getPrimaryMember().getEmployerName() + " just for yourself?");
        softAssert.assertEquals(esiMonthlyAmountInput.getAttribute("placeholder"), "monthly amount");
        softAssert.assertEquals(EsiQuestionTxt.get(3).getText(), "Are you currently enrolled in the health insurance offered by " + SharedData.getPrimaryMember().getEmployerName() + "?");
        softAssert.assertEquals(esiCurrentlyEnrolledYesBtn.getText(), "Yes");
        softAssert.assertEquals(esiCurrentlyEnrolledNoBtn.getText(), "No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledSectionDataEnglish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertEquals(EsiQuestionTxt.get(4).getText(), "Will this health insurance end in the next 60 days?");
        softAssert.assertEquals(esiInsuranceEndYesBtn.getText(), "Yes");
        softAssert.assertEquals(esiInsuranceEndNoBtn.getText(), "No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledEndingSectionDataEnglish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertEquals(EsiQuestionTxt.get(5).getText(), "What day will your coverage end?");
        softAssert.assertEquals(esiEndDateInput.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(EsiQuestionTxt.get(6).getText(), "Are you voluntarily ending this health insurance?");
        softAssert.assertEquals(esiVoluntarilyEndingYesBtn.getText(), "Yes");
        softAssert.assertEquals(esiVoluntarilyEndingNoBtn.getText(), "No");
        softAssert.assertAll();
    }

    public void verifyEsiPageFamilyPlansSectionDataEnglish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertEquals(EsiQuestionTxt.get(7).getText(), "Does " + SharedData.getPrimaryMember().getEmployerName() + " offer family health plans?");
        softAssert.assertEquals(esiFamilyOfferedYesBtn.getText(), "Yes");
        softAssert.assertEquals(esiFamilyOfferedNoBtn.getText(), "No");
        softAssert.assertEquals(EsiQuestionTxt.get(8).getText(), "How much would you pay for the lowest-cost monthly health plan premium at " + SharedData.getPrimaryMember().getEmployerName() + " to cover your family?");
        softAssert.assertEquals(esiMemberStatusTxt.getText(), "For each member, select which option best describes their health insurance enrollment status with " + SharedData.getPrimaryMember().getEmployerName() + ":");
        softAssert.assertTrue(esiFamilyMemberTxt.get(0).getText().equalsIgnoreCase(SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(esiFamilyEnrolledBtn.get(0).getText(), "Enrolled");
        softAssert.assertEquals(esiFamilyOfferedBtn.get(0).getText(), "Offered a plan but not enrolled");
        softAssert.assertEquals(esiFamilyNoOptionBtn.get(0).getText(), "No option to enroll");
        softAssert.assertAll();
    }

    public void verifyEsiPageFirstSectionSecondaryDataEnglish() {
        basicActions.waitForElementToBePresentWithRetries(OhcHeader, 15);
        basicActions.waitForElementToBePresentWithRetries(OhcEsiHeader, 15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Other Health Coverage: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(OhcEsiHeader.getText(), "Employer-sponsored Health Insurance");
        softAssert.assertEquals(EsiQuestionTxt.get(0).getText(), "Which job is offering health insurance?");
        softAssert.assertEquals(esiSelectEmployerDpd.getText(), "Select an employer\n" + SharedData.getMembers().get(0).getEmployerName());
        softAssert.assertAll();
    }

    public void verifyEsiPageSecondSectionSecondaryDataEnglish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertEquals(EsiQuestionTxt.get(1).getText(), "Does this health insurance meet the Minimum Value Standard?");
        softAssert.assertEquals(esiMinValueStandardYesBtn.getText(), "Yes");
        softAssert.assertEquals(esiMinValueStandardNoBtn.getText(), "No");
        softAssert.assertEquals(esiMinValueStandardDontKnowBtn.getText(), "I don't know");
        softAssert.assertTrue(EsiQuestionTxt.get(2).getText().equalsIgnoreCase("How much would " + SharedData.getMembers().get(0).getFullName() + " pay for the lowest-cost monthly health plan premium at " + SharedData.getMembers().get(0).getEmployerName() + " just for themself?"));
        softAssert.assertEquals(esiMonthlyAmountInput.getAttribute("placeholder"), "monthly amount");
        softAssert.assertTrue(EsiQuestionTxt.get(3).getText().equalsIgnoreCase("Is " + SharedData.getMembers().get(0).getFullName() + " currently enrolled in the health insurance offered by " + SharedData.getMembers().get(0).getEmployerName() + "?"));
        softAssert.assertEquals(esiCurrentlyEnrolledYesBtn.getText(), "Yes");
        softAssert.assertEquals(esiCurrentlyEnrolledNoBtn.getText(), "No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledEndingSectionSecondaryDataEnglish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertTrue(EsiQuestionTxt.get(5).getText().equalsIgnoreCase("What day will " + SharedData.getMembers().get(0).getFullName() + "'s coverage end?"));
        softAssert.assertEquals(esiEndDateInput.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertTrue(EsiQuestionTxt.get(6).getText().equalsIgnoreCase("Is " + SharedData.getMembers().get(0).getFullName() + " voluntarily ending this health insurance?"));
        softAssert.assertEquals(esiVoluntarilyEndingYesBtn.getText(), "Yes");
        softAssert.assertEquals(esiVoluntarilyEndingNoBtn.getText(), "No");
        softAssert.assertAll();
    }

    public void verifyEsiPageFamilyPlansSectionSecondaryDataEnglish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertTrue(EsiQuestionTxt.get(7).getText().equalsIgnoreCase("Does " + SharedData.getMembers().get(0).getEmployerName() + " offer family health plans?"));
        softAssert.assertEquals(esiFamilyOfferedYesBtn.getText(), "Yes");
        softAssert.assertEquals(esiFamilyOfferedNoBtn.getText(), "No");
        softAssert.assertTrue(EsiQuestionTxt.get(8).getText().equalsIgnoreCase("How much would " + SharedData.getMembers().get(0).getFullName() + " pay for the lowest-cost monthly health plan premium at " + SharedData.getMembers().get(0).getEmployerName() + " to cover your family?"));
        softAssert.assertEquals(esiMemberStatusTxt.getText(), "For each member, select which option best describes their health insurance enrollment status with " + SharedData.getMembers().get(0).getEmployerName() + ":");
        softAssert.assertTrue(esiFamilyMemberTxt.get(0).getText().equalsIgnoreCase(SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(esiFamilyEnrolledBtn.get(0).getText(), "Enrolled");
        softAssert.assertEquals(esiFamilyOfferedBtn.get(0).getText(), "Offered a plan but not enrolled");
        softAssert.assertEquals(esiFamilyNoOptionBtn.get(0).getText(), "No option to enroll");
        softAssert.assertAll();
    }

    public void verifyEsiPageDataSpanish(String dataToVerify) {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        switch (dataToVerify) {
            case "No Job Section":
                verifyEsiPageNoJobSectionDataSpanish();
                break;
            case "Job Section":
                verifyEsiPageNoJobSectionDataSpanish();
                verifyEsiPageJobSectionDataSpanish();
                break;
            case "Currently Enrolled Section":
                verifyEsiPageNoJobSectionDataSpanish();
                verifyEsiPageJobSectionDataSpanish();
                verifyEsiPageCurrentlyEnrolledSectionDataSpanish();
                break;
            case "Currently Enrolled Ending Section":
                verifyEsiPageNoJobSectionDataSpanish();
                verifyEsiPageJobSectionDataSpanish();
                verifyEsiPageCurrentlyEnrolledSectionDataSpanish();
                verifyEsiPageCurrentlyEnrolledEndingSectionDataSpanish();
                break;
            case "Family Plans Section":
                verifyEsiPageNoJobSectionDataSpanish();
                verifyEsiPageJobSectionDataSpanish();
                verifyEsiPageCurrentlyEnrolledSectionDataSpanish();
                verifyEsiPageCurrentlyEnrolledEndingSectionDataSpanish();
                verifyEsiPageFamilyPlansSectionDataSpanish();
                break;
            case "No Job Section Secondary":
                verifyEsiPageFirstSectionSecondaryDataSpanish();
                break;
            case "Job Section Secondary":
                verifyEsiPageFirstSectionSecondaryDataSpanish();
                verifyEsiPageSecondSectionSecondaryDataSpanish();
                break;
            case "Currently Enrolled Section Secondary":
                verifyEsiPageFirstSectionSecondaryDataSpanish();
                verifyEsiPageSecondSectionSecondaryDataSpanish();
                verifyEsiPageCurrentlyEnrolledSectionDataSpanish();
                break;
            case "Currently Enrolled Ending Section Secondary":
                verifyEsiPageFirstSectionSecondaryDataSpanish();
                verifyEsiPageSecondSectionSecondaryDataSpanish();
                verifyEsiPageCurrentlyEnrolledSectionDataSpanish();
                verifyEsiPageCurrentlyEnrolledEndingSectionSecondaryDataSpanish();
                break;
            case "Family Plans Section Secondary":
                verifyEsiPageFirstSectionSecondaryDataSpanish();
                verifyEsiPageSecondSectionSecondaryDataSpanish();
                verifyEsiPageCurrentlyEnrolledSectionDataSpanish();
                verifyEsiPageCurrentlyEnrolledEndingSectionSecondaryDataSpanish();
                verifyEsiPageFamilyPlansSectionSecondaryDataSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dataToVerify);
        }
        softAssert.assertEquals(goBackButton.getText(), "Volver");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyEsiPageNoJobSectionDataSpanish() {
        basicActions.waitForElementToBePresent(OhcHeader, 30);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(OhcEsiHeader.getText(), "Seguro de salud patrocinado por el empleador");
        softAssert.assertEquals(EsiQuestionTxt.get(0).getText(), "\u00BFQu\u00E9 empleo le ofrece seguro de salud?");
        softAssert.assertEquals(esiSelectEmployerDpd.getText(), "Seleccionar un empleador\n" + SharedData.getPrimaryMember().getEmployerName());
        softAssert.assertAll();
    }

    public void verifyEsiPageJobSectionDataSpanish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertEquals(EsiQuestionTxt.get(1).getText(), "\u00BFCumple este seguro de salud el est\u00E1ndar de valor m\u00EDnimo?");
        softAssert.assertEquals(esiMinValueStandardYesBtn.getText(), "S\u00ED");
        softAssert.assertEquals(esiMinValueStandardNoBtn.getText(), "No");
        softAssert.assertEquals(esiMinValueStandardDontKnowBtn.getText(), "No s\u00E9");
        softAssert.assertEquals(EsiQuestionTxt.get(2).getText(), "\u00BFCu\u00E1nto pagar\u00EDa por la prima mensual del plan de salud de menor costo en " + SharedData.getPrimaryMember().getEmployerName() + " solo para usted?");
        softAssert.assertEquals(esiMonthlyAmountInput.getAttribute("placeholder"), "Cantidad mensual");
        softAssert.assertEquals(EsiQuestionTxt.get(3).getText(), "\u00BFEst\u00E1 inscrito actualmente en el seguro de salud que ofrece " + SharedData.getPrimaryMember().getEmployerName() + "?");
        softAssert.assertEquals(esiCurrentlyEnrolledYesBtn.getText(), "S\u00ED");
        softAssert.assertEquals(esiCurrentlyEnrolledNoBtn.getText(), "No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledSectionDataSpanish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertEquals(EsiQuestionTxt.get(4).getText(), "\u00BFEste seguro de salud terminar\u00E1 en los siguientes 60 d\u00EDas?");
        softAssert.assertEquals(esiInsuranceEndYesBtn.getText(), "S\u00ED");
        softAssert.assertEquals(esiInsuranceEndNoBtn.getText(), "No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledEndingSectionDataSpanish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertEquals(EsiQuestionTxt.get(5).getText(), "\u00BFQu\u00E9 d\u00EDa termina su cobertura?");
        softAssert.assertEquals(esiEndDateInput.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(EsiQuestionTxt.get(6).getText(), "\u00BFEst\u00E1 cancelando voluntariamente este seguro de salud?");
        softAssert.assertEquals(esiVoluntarilyEndingYesBtn.getText(), "S\u00ED");
        softAssert.assertEquals(esiVoluntarilyEndingNoBtn.getText(), "No");
        softAssert.assertAll();
    }

    public void verifyEsiPageFamilyPlansSectionDataSpanish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertEquals(EsiQuestionTxt.get(7).getText(), "\u00BF" + SharedData.getPrimaryMember().getEmployerName() + " ofrece planes de salud familiares?");
        softAssert.assertEquals(esiFamilyOfferedYesBtn.getText(), "S\u00ED");
        softAssert.assertEquals(esiFamilyOfferedNoBtn.getText(), "No");
        softAssert.assertEquals(EsiQuestionTxt.get(8).getText(), "\u00BFCu\u00E1nto pagar\u00EDa por la prima mensual del plan de salud de menor costo en " + SharedData.getPrimaryMember().getEmployerName() + " para cubrir a su familia?");
        softAssert.assertEquals(esiMemberStatusTxt.getText(), "Para cada miembro, seleccione la opci\u00F3n que describe mejor el estado de su inscripci\u00F3n en el seguro m\u00E9dico con " + SharedData.getPrimaryMember().getEmployerName() + ":");
        softAssert.assertTrue(esiFamilyMemberTxt.get(0).getText().equalsIgnoreCase(SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(esiFamilyEnrolledBtn.get(0).getText(), "Inscrito");
        softAssert.assertEquals(esiFamilyOfferedBtn.get(0).getText(), "Se le ofreci\u00F3 un plan pero no se inscribi\u00F3");
        softAssert.assertEquals(esiFamilyNoOptionBtn.get(0).getText(), "No hay opci\u00F3n para inscribirse");
        softAssert.assertAll();
    }

    public void verifyEsiPageFirstSectionSecondaryDataSpanish() {
        basicActions.waitForElementToBePresentWithRetries(OhcHeader, 15);
        basicActions.waitForElementToBePresentWithRetries(OhcEsiHeader, 15);
        softAssert.assertTrue(OhcHeader.getText().equalsIgnoreCase("Otra cobertura de salud: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(OhcEsiHeader.getText(), "Seguro de salud patrocinado por el empleador");
        softAssert.assertEquals(EsiQuestionTxt.get(0).getText(), "\u00BFQu\u00E9 empleo le ofrece seguro de salud?");
        softAssert.assertEquals(esiSelectEmployerDpd.getText(), "Seleccionar un empleador\n" + SharedData.getMembers().get(0).getEmployerName());
        softAssert.assertAll();
    }

    public void verifyEsiPageSecondSectionSecondaryDataSpanish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertEquals(EsiQuestionTxt.get(1).getText(), "\u00BFCumple este seguro de salud el est\u00E1ndar de valor m\u00EDnimo?");
        softAssert.assertEquals(esiMinValueStandardYesBtn.getText(), "S\u00ED");
        softAssert.assertEquals(esiMinValueStandardNoBtn.getText(), "No");
        softAssert.assertEquals(esiMinValueStandardDontKnowBtn.getText(), "No s\u00E9");
        softAssert.assertTrue(EsiQuestionTxt.get(2).getText().equalsIgnoreCase("\u00BFCu\u00E1nto pagar\u00EDa " + SharedData.getMembers().get(0).getFullName() + " por la prima mensual del plan de salud de menor costo en " + SharedData.getMembers().get(0).getEmployerName() + " solo para ellos?"));
        softAssert.assertEquals(esiMonthlyAmountInput.getAttribute("placeholder"), "Cantidad mensual");
        softAssert.assertTrue(EsiQuestionTxt.get(3).getText().equalsIgnoreCase("\u00BF" + SharedData.getMembers().get(0).getFullName() + " se inscribi\u00F3 en el seguro de salud que ofrece " + SharedData.getMembers().get(0).getEmployerName() + "?"));
        softAssert.assertEquals(esiCurrentlyEnrolledYesBtn.getText(), "S\u00ED");
        softAssert.assertEquals(esiCurrentlyEnrolledNoBtn.getText(), "No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledEndingSectionSecondaryDataSpanish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertTrue(EsiQuestionTxt.get(5).getText().equalsIgnoreCase("\u00BFQu\u00E9 d\u00EDa termina la cobertura de " + SharedData.getMembers().get(0).getFullName() + "?"));
        softAssert.assertEquals(esiEndDateInput.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertTrue(EsiQuestionTxt.get(6).getText().equalsIgnoreCase("\u00BF" + SharedData.getMembers().get(0).getFullName() + " est\u00E1 cancelando voluntariamente este seguro de salud?"));
        softAssert.assertEquals(esiVoluntarilyEndingYesBtn.getText(), "S\u00ED");
        softAssert.assertEquals(esiVoluntarilyEndingNoBtn.getText(), "No");
        softAssert.assertAll();
    }

    public void verifyEsiPageFamilyPlansSectionSecondaryDataSpanish() {
        basicActions.waitForElementToBePresent(OhcHeader, 15);
        softAssert.assertEquals(EsiQuestionTxt.get(7).getText(), "\u00BF" + SharedData.getMembers().get(0).getEmployerName() + " ofrece planes de salud familiares?");
        softAssert.assertEquals(esiFamilyOfferedYesBtn.getText(), "S\u00ED");
        softAssert.assertEquals(esiFamilyOfferedNoBtn.getText(), "No");
        softAssert.assertTrue(EsiQuestionTxt.get(8).getText().equalsIgnoreCase("\u00BFCu\u00E1nto pagar\u00EDa " + SharedData.getMembers().get(0).getFullName() + " por la prima mensual del plan de salud de menor costo en " + SharedData.getMembers().get(0).getEmployerName() + " para cubrir a su familia?"));
        softAssert.assertEquals(esiMemberStatusTxt.getText(), "Para cada miembro, seleccione la opci\u00F3n que describe mejor el estado de su inscripci\u00F3n en el seguro m\u00E9dico con " + SharedData.getMembers().get(0).getEmployerName() + ":");
        softAssert.assertTrue(esiFamilyMemberTxt.get(0).getText().equalsIgnoreCase(SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(esiFamilyEnrolledBtn.get(0).getText(), "Inscrito");
        softAssert.assertEquals(esiFamilyOfferedBtn.get(0).getText(), "Se le ofreci\u00F3 un plan pero no se inscribi\u00F3");
        softAssert.assertEquals(esiFamilyNoOptionBtn.get(0).getText(), "No hay opci\u00F3n para inscribirse");
        softAssert.assertAll();
    }

    public void verifyErrorMessage(String errorType, String language) {
        WebElement errorElement;
        switch (errorType) {
            case "Which Job":
                errorElement = whichJobError;
                verifyPleaseSelectError(language, errorElement);
                break;
            case "Min Value":
                errorElement = minValueError;
                verifyPleaseSelectError(language, errorElement);
                break;
            case "Amount":
                errorElement = amountError;
                verifyAmountError(language, errorElement);
                break;
            case "Currently Enrolled":
                errorElement = currentlyEnrolledError;
                verifyPleaseSelectError(language, errorElement);
                break;
            case "Insurance Ending":
                errorElement = insuranceEndingError;
                verifyPleaseSelectError(language, errorElement);
                break;
            case "Input Date":
                verifyInputEndDateError(language);
                break;
            case "Voluntary End":
                errorElement = endVoluntaryError;
                verifyPleaseSelectError(language, errorElement);
                break;
            case "Family Offered":
                errorElement = esiFamilyOfferedError;
                verifyPleaseSelectError(language, errorElement);
                break;
            case "Family Amount":
                errorElement = esiFamilyAmountError;
                verifyAmountError(language, errorElement);
                break;
            case "Family Status":
                verifyFamilyStatusError(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }

    public void verifyPleaseSelectError(String language, WebElement element) {
        basicActions.waitForElementToBePresent(element, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(element.getText(), "Please select one of the options below");
                softAssert.assertEquals(element.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(element.getCssValue("font-size"), "14px");
                softAssert.assertEquals(element.getCssValue("font-weight"), "400");
                softAssert.assertEquals(element.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(element.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(element.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(element.getCssValue("font-size"), "14px");
                softAssert.assertEquals(element.getCssValue("font-weight"), "400");
                softAssert.assertEquals(element.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyAmountError(String language, WebElement element) {
        basicActions.waitForElementToBePresent(element, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(element.getText(), "Amount is required");
                softAssert.assertEquals(element.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(element.getCssValue("font-size"), "14px");
                softAssert.assertEquals(element.getCssValue("font-weight"), "400");
                softAssert.assertEquals(element.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(element.getText(), "Esta cantidad es obligatoria");
                softAssert.assertEquals(element.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(element.getCssValue("font-size"), "14px");
                softAssert.assertEquals(element.getCssValue("font-weight"), "400");
                softAssert.assertEquals(element.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyInputEndDateError(String language) {
        basicActions.waitForElementToBePresent(inputEndDateError, 20);
        String TodayDate = basicActions.getTodayDate();
        switch (language) {
            case "English":
                softAssert.assertEquals(inputEndDateError.getText(), "Date is required");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(inputEndDateError.getText(), "La fecha es obligatoria");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "English Prior":
                softAssert.assertEquals(inputEndDateError.getText(), "Please enter a value greater than or equal to " + TodayDate);
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish Prior":
                softAssert.assertEquals(inputEndDateError.getText(), "Por favor ingrese un valor mayor que o igual a " + TodayDate);
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "English Future":
                softAssert.assertEquals(inputEndDateError.getText(), "Date cannot exceed 60 days in the future");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish Future":
                softAssert.assertEquals(inputEndDateError.getText(), "La fecha a seleccionar no puede exceder los 60 d\u00EDas");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyFamilyStatusError(String language) {
        basicActions.waitForElementToBePresent(esiFamilyStatusError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(esiFamilyStatusError.getText(), "Please select one option for each individual below");
                softAssert.assertEquals(esiFamilyStatusError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(esiFamilyStatusError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(esiFamilyStatusError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(esiFamilyStatusError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(esiFamilyStatusError.getText(), "Seleccione una opci\u00F3n para cada individuo a continuaci\u00F3n");
                softAssert.assertEquals(esiFamilyStatusError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(esiFamilyStatusError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(esiFamilyStatusError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(esiFamilyStatusError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyNoErrorMessage(String errorType) {
        switch (errorType) {
            case "Which Job":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(whichJobError, 10));
                softAssert.assertAll();
                break;
            case "Min Value":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(minValueError, 10));
                softAssert.assertAll();
                break;
            case "Amount":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(amountError, 10));
                softAssert.assertAll();
                break;
            case "Currently Enrolled":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(currentlyEnrolledError, 10));
                softAssert.assertAll();
                break;
            case "Insurance Ending":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(insuranceEndingError, 10));
                softAssert.assertAll();
                break;
            case "Input Date":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(inputEndDateError, 10));
                softAssert.assertAll();
                break;
            case "Voluntary End":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(endVoluntaryError, 10));
                softAssert.assertAll();
                break;
            case "Family Offered":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(esiFamilyOfferedError, 10));
                softAssert.assertAll();
                break;
            case "Family Amount":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(esiFamilyAmountError, 10));
                softAssert.assertAll();
                break;
            case "Family Status":
                softAssert.assertTrue(basicActions.waitForElementToDisappear(esiFamilyStatusError, 10));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }

    public void verifyHelpDrawerStatus(String drawerStatus) {
        switch (drawerStatus) {
            case "Closed English":
                basicActions.waitForElementToBeClickable(helpButton, 10);
                softAssert.assertEquals(helpButton.getText(), "Help");
                softAssert.assertAll();
                break;
            case "Closed Spanish":
                basicActions.waitForElementToBeClickable(helpButton, 10);
                softAssert.assertEquals(helpButton.getText(), "Ayuda");
                softAssert.assertAll();
                break;
            case "Open":
                basicActions.waitForElementToBePresent(helpHeaderTxt,60);
                String actualText = helpHeaderTxt.getText();
                softAssert.assertTrue(actualText.equals("Help") || actualText.equals("Ayuda"));
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
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Health insurance offered through a job");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(0).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Overview\nBefore you continue, gather any documents about health coverage that include information about premium costs and who in the household can get coverage.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "You may find this information in an online employee account, a letter, email, PDF, or another document from the job that's offering health coverage.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "If none of these are available, ask your job to fill out information in the Employer Information section of the Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerParagraphLnk1.get(0).getText(), "Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(1).getText(), "Tell us about coverage if you:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "Can get health coverage through a job, even if you're not currently enrolled or don't plan to enroll.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "Can get health coverage through a job, even if the employer's plan isn't currently in Open Enrollment.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "Don't think you can afford the coverage that's being offered. We'll ask more questions later to help determine if you can qualify for savings through Connect for Health Colorado.");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(2).getText(), "You don\u2019t need to answer these questions if:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(3).getText(), "You aren't offered coverage through your job at all.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(4).getText(), "You don't work enough hours to qualify for the coverage your job offers.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(5).getText(), "The only type of coverage available through a job is a Health Reimbursement Arrangement (HRA). However, if a person is offered an HRA and another group health insurance plan, select their name. Remember: you will also need to provide information about the HRA on the \"Other Health Insurance\" page.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(6).getText(), "Your only option for getting health insurance is COBRA continuation coverage or retiree coverage.");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(4).getText(), "If you are or will be in a \"waiting period\", don\u2019t answer these questions yet. When that waiting period ends, return to the application, report a life change, and enter your job\u2019s health insurance information here.");
        softAssert.assertEquals(helpDrawerWaitingPeriodTxt.getText(), "A waiting period is the time that must pass before an employer offers an employee health coverage. Waiting periods can be 0-90 days.");
        softAssert.assertEquals(helpDrawerHeaderSection2Txt.get(1).getText(), "Minimum Value Standard:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "Minimum Value Standard:\nMost health insurance plans offered by jobs meet the minimum value standard");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(5).getText(), "More about the minimum value standard\nA health plan meets the minimum value standard if it's designed to pay at least 60% of the total cost of medical services for a standard population, and if its benefits include substantial coverage of inpatient hospital and physician services.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(6).getText(), "To find out if a plan meets the minimum value standard, check the Summary of Benefits and Coverage (SBC) from your job\u2019s plan, or ask them to fill out the Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerParagraphLnk1.get(1).getText(), "Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(7).getText(), "Print or download the Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerParagraphLnk1.get(2).getText(), "Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerHeaderSection2Txt.get(3).getText(), "Lowest Cost Premium:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(8).getText(), "Lowest Cost Premium:\nHint Text:Only enter the amount you would pay. Don't include any amount paid by your employer.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(9).getText(), "Learn more about entering premium amounts\nEnter the regular amount you would have to pay for health coverage (the \"premium\") if you enrolled.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(10).getText(), "Enter the amount of the lowest-cost plan offered by the employer that would only cover you.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(11).getText(), "If the employer has wellness programs:\nEnter the premium you would pay if you got the maximum discount for any tobacco cessation programs (counseling to stop smoking), but no other programs.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(12).getText(), "These amounts should be listed in a notice from your employer. But, if you don't have a notice or you're not sure what these amounts are, ask the employer.");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Enrollment:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(13).getText(), "If you currently have health insurance through this job, select \"Yes\". If you are able to get this health insurance, but have chosen not to enroll, select \"No\".");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(1).getText(), "End in the next 60 days:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(14).getText(), "If this insurance will end soon because:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(7).getText(), "the job is ending,");
        softAssert.assertEquals(helpDrawerBodyPoints.get(8).getText(), "the company is no longer offering health insurance,");
        softAssert.assertEquals(helpDrawerBodyPoints.get(9).getText(), "or you won't qualify for it any longer,");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(15).getText(), "select \"Yes\" and enter the date the insurance will end.");
        softAssert.assertEquals(helpDrawerHeaderSection2Txt.get(6).getText(), "Voluntarily Ending Health Insurance:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(16).getText(), "Voluntarily Ending Health Insurance:\nSelect \"Yes\" if you are still eligible for health insurance through your employer but have chosen to cancel the plan or if you declined to enroll in a plan when you had the opportunity.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(17).getText(), "Select \"No\" if you are no longer eligible for health insurance through your employer or your employer used to offer health insurance and no longer provides health insurance.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(18).getText(), "Select \"No\" if your employer used to offer health insurance and now only offers a Health Reimbursement Arrangement (HRA)");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerWhichJobTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Health insurance offered through a job");
        softAssert.assertEquals(helpDrawerSubHdrTxt.get(0).getText(), "Tell us about coverage if you:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "Can get health coverage through a job, even if you're not currently enrolled or don't plan to enroll.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "Can get health coverage through a job, even if the employer's plan isn't currently in Open Enrollment.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "Don't think you can afford the coverage that's being offered. We'll ask more questions later to help determine if you can qualify for savings through Connect for Health Colorado.");
        softAssert.assertEquals(helpDrawerSubHdrTxt.get(1).getText(), "You don\u2019t need to answer these questions if:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(3).getText(), "You aren't offered coverage through your job at all.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(4).getText(), "You don't work enough hours to qualify for the coverage your job offers.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(5).getText(), "The only type of coverage available through a job is a Health Reimbursement Arrangement (HRA). However, if a person is offered an HRA and another group health insurance plan, select their name. Remember: you will also need to provide information about the HRA on the \"Other Health Insurance\" page.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(6).getText(), "Your only option for getting health insurance is COBRA continuation coverage or retiree coverage.");
        softAssert.assertEquals(helpDrawerHeaderSection2Txt.get(2).getText(), "If you are or will be in a \"waiting period\", don\u2019t answer these questions yet. When that waiting period ends, return to the application, report a life change, and enter your job\u2019s health insurance information here.");
        softAssert.assertEquals(helpDrawerWaitingPeriodTxt.getText(), "A waiting period is the time that must pass before an employer offers an employee health coverage. Waiting periods can be 0-90 days.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerMinimumValueTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Health insurance offered through a job");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Minimum Value Standard:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Most health insurance plans offered by jobs meet the minimum value standard");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(1).getText(), "More about the minimum value standard");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "A health plan meets the minimum value standard if it's designed to pay at least 60% of the total cost of medical services for a standard population, and if its benefits include substantial coverage of inpatient hospital and physician services.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "To find out if a plan meets the minimum value standard, check the Summary of Benefits and Coverage (SBC) from your job\u2019s plan, or ask them to fill out the Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerParagraphLnk1.get(0).getText(), "Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerPrintTxt.getText(), "Print or download the Employer Coverage Tool");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerMonthlyAmountTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Health insurance offered through a job");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Lowest Cost Premium:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Hint Text:Only enter the amount you would pay. Don't include any amount paid by your employer.");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(1).getText(), "Learn more about entering premium amounts");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Enter the regular amount you would have to pay for health coverage (the \"premium\") if you enrolled.");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(2).getText(), "Enter the amount of the lowest-cost plan offered by the employer that would only cover you.");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(3).getText(), "If the employer has wellness programs:\nEnter the premium you would pay if you got the maximum discount for any tobacco cessation programs (counseling to stop smoking), but no other programs.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Enter the premium you would pay if you got the maximum discount for any tobacco cessation programs (counseling to stop smoking), but no other programs.");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(4).getText(), "These amounts should be listed in a notice from your employer. But, if you don't have a notice or you're not sure what these amounts are, ask the employer.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerCurrentlyEnrolledTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Health insurance offered through a job");
        softAssert.assertEquals(helpDrawerSubHdr2Txt.get(0).getText(), "Enrollment:");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(0).getText(), "If you currently have health insurance through this job, select \"Yes\". If you are able to get this health insurance, but have chosen not to enroll, select \"No\".");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerEnd60DaysTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Health insurance offered through a job");
        softAssert.assertEquals(helpDrawerSubHdr2Txt.get(0).getText(), "End in the next 60 days:");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(0).getText(), "If this insurance will end soon because:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "the job is ending,");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "the company is no longer offering health insurance,");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "or you won't qualify for it any longer,");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(1).getText(), "select \"Yes\" and enter the date the insurance will end.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerVoluntarilyEndingTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Health insurance offered through a job");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Voluntarily Ending Health Insurance:");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(0).getText(), "Voluntarily Ending Health Insurance:\nSelect \"Yes\" if you are still eligible for health insurance through your employer but have chosen to cancel the plan or if you declined to enroll in a plan when you had the opportunity.");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(1).getText(), "Select \"No\" if you are no longer eligible for health insurance through your employer or your employer used to offer health insurance and no longer provides health insurance.");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(2).getText(), "Select \"No\" if your employer used to offer health insurance and now only offers a Health Reimbursement Arrangement (HRA)");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help?\nContact us");
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
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Seguro de salud ofrecido a trav\u00E9s de un empleo");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(0).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Resumen\nAntes de continuar, re\u00FAna todos los documentos sobre la cobertura de salud que incluyan informaci\u00F3n sobre el costo de las primas y qui\u00E9n en la familia puede tener cobertura.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Puede encontrar esta informaci\u00F3n en una cuenta de empleado en l\u00EDnea, una carta, un correo electr\u00F3nico, un PDF u otro documento del trabajo en el que se ofrece cobertura de salud.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Si no dispone de ninguno de ellos, pida en su trabajo que llenen la informaci\u00F3n de la secci\u00F3n \"Informaci\u00F3n del empleador\" de la herramienta de cobertura del empleador");
        softAssert.assertEquals(helpDrawerParagraphLnk1.get(0).getText(), "herramienta de cobertura del empleador");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(1).getText(), "Inf\u00F3rmenos sobre la cobertura en los siguientes casos:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "Puede obtener cobertura de salud a trav\u00E9s de un empleo, aunque no est\u00E9 inscrita actualmente ni tenga previsto hacerlo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "Puede obtener cobertura de salud a trav\u00E9s de un empleo, incluso si el plan del empleador no est\u00E1 actualmente en el per\u00EDodo de inscripci\u00F3n abierta.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "No cree que pueda pagar la cobertura que le ofrecen. M\u00E1s adelante, le haremos m\u00E1s preguntas para ayudarle a determinar si puede calificar para obtener ahorros a trav\u00E9s de Connect for Health Colorado.");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(2).getText(), "No tiene que responder estas preguntas en los siguientes casos:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(3).getText(), "No se le ofrece cobertura a trav\u00E9s de su empleo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(4).getText(), "No trabaja suficientes horas para calificar para la cobertura que ofrece su empleo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(5).getText(), "El \u00FAnico tipo de cobertura disponible a trav\u00E9s del trabajo es el acuerdo de reembolsos de salud (HRA). Sin embargo, si a una persona se le ofrece un HRA y otro plan de seguro de salud grupal, seleccione el nombre. Recuerde: tambi\u00E9n deber\u00E1 proporcionar informaci\u00F3n sobre el HRA en la p\u00E1gina \"Otros seguros de salud\".");
        softAssert.assertEquals(helpDrawerBodyPoints.get(6).getText(), "La \u00FAnica opci\u00F3n que tiene para conseguir un seguro de salud es la continuaci\u00F3n de la cobertura COBRA o la cobertura para retirados.");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(4).getText(), "Si est\u00E1 o va a estar en \"per\u00EDodo de espera\", no responda a\u00FAn estas preguntas. Cuando finalice ese per\u00EDodo de espera, vuelva a la solicitud, comunique el cambio de vida e introduzca aqu\u00ED los datos del seguro de salud de su trabajo.");
        softAssert.assertEquals(helpDrawerWaitingPeriodTxt.getText(),"Un per\u00EDodo de espera es el tiempo que debe transcurrir antes de que un empleador ofrezca cobertura de salud a un empleado. Los per\u00EDodos de espera pueden ser de 0 a 90 d\u00EDas.");
        softAssert.assertEquals(helpDrawerHeaderSection2Txt.get(1).getText(), "Est\u00E1ndar de valor m\u00EDnimo:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "Est\u00E1ndar de valor m\u00EDnimo:\nLa mayor\u00EDa de los planes de seguro de salud que se ofrecen a trav\u00E9s de los trabajos cumplen el est\u00E1ndar de valor m\u00EDnimo.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(5).getText(), "M\u00E1s informaci\u00F3n sobre el est\u00E1ndar de valor m\u00EDnimo\nUn plan de salud cumple el est\u00E1ndar de valor m\u00EDnimo si est\u00E1 dise\u00F1ado para pagar al menos el 60% del costo total de los servicios m\u00E9dicos para una poblaci\u00F3n est\u00E1ndar y si sus beneficios incluyen una cobertura considerable de los servicios hospitalarios y m\u00E9dicos.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(6).getText(), "Para saber si un plan cumple el est\u00E1ndar de valor m\u00EDnimo, consulte el Resumen de beneficios y cobertura (SBC) del plan de su empleo o pida en su trabajo que le llenen la herramienta de cobertura del empleador");
        softAssert.assertEquals(helpDrawerParagraphLnk1.get(1).getText(), "herramienta de cobertura del empleador");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(7).getText(), "Imprima o descargue la herramienta de cobertura del empleador");
        softAssert.assertEquals(helpDrawerParagraphLnk1.get(2).getText(), "herramienta de cobertura del empleador");
        softAssert.assertEquals(helpDrawerHeaderSection2Txt.get(3).getText(), "Prima de costo m\u00E1s bajo:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(8).getText(), "Prima de costo m\u00E1s bajo:\nTexto de sugerencia:Solo ingrese la cantidad que pagar\u00EDa. No incluya ninguna cantidad que pague su empleador.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(9).getText(), "Obtenga m\u00E1s informaci\u00F3n sobre c\u00F3mo ingresar las cantidades de las primas\nIngrese la cantidad normal que el empleado tendr\u00EDa que pagar por su cobertura de salud (la \"prima\") si se inscribiera.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(10).getText(), "Ingrese la cantidad del plan de menor costo que ofrece el empleador y que cubrir\u00EDa solo al empleado.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(11).getText(), "Si el empleador tiene programas de bienestar, haga lo siguiente:\nIngrese la prima que pagar\u00EDa esta persona si obtuviera el descuento m\u00E1ximo para cualquier programa de suspensi\u00F3n al tabaco (consejer\u00EDa para dejar de fumar), pero para ning\u00FAn otro programa.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(12).getText(), "El empleador debe indicar estas cantidades en un aviso. Sin embargo, si usted no dispone de un aviso o no est\u00E1 seguro de cu\u00E1les son estas cantidades, pregunte a su empleador.");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Inscripci\u00F3n:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(13).getText(), "Si esta persona tiene actualmente seguro de salud a trav\u00E9s de este trabajo, seleccione \"S\u00ED\". Si esta persona puede obtener ese seguro de salud, pero ha preferido no inscribirse, seleccione \"No\".");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(1).getText(), "Finalizaci\u00F3n en los pr\u00F3ximos 60 d\u00EDas:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(14).getText(), "Si este seguro acabar\u00E1 pronto porque:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(7).getText(), "el trabajo est\u00E1 por terminarse;");
        softAssert.assertEquals(helpDrawerBodyPoints.get(8).getText(), "la empresa ya no ofrecer\u00E1 seguro de salud;");
        softAssert.assertEquals(helpDrawerBodyPoints.get(9).getText(), "usted ya no calificar\u00E1 para recibirlo;");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(15).getText(), "seleccione \"S\u00ED\" e ingrese la fecha en que terminar\u00E1 el seguro.");
        softAssert.assertEquals(helpDrawerHeaderSection2Txt.get(6).getText(), "Cancelar el seguro de salud de manera voluntaria:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(16).getText(), "Cancelar el seguro de salud de manera voluntaria:\nSeleccione \"S\u00ED\" si todav\u00EDa es elegible para recibir seguro de salud a trav\u00E9s de su empleador, pero ha elegido cancelar el plan o si rechaz\u00F3 la inscripci\u00F3n cuando tuvo la oportunidad.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(17).getText(), "Seleccione \"No\" si ya no es elegible para recibir seguro de salud por medio de su empleador o si su empleador ofrec\u00EDa seguro de salud y ya no lo ofrece.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(18).getText(), "Seleccione \"No\" si su empleador ofrec\u00EDa seguro de salud y ahora solo ofrece un acuerdo de reembolsos de salud (HRA).");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerWhichJobTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Seguro de salud ofrecido a trav\u00E9s de un empleo");
        softAssert.assertEquals(helpDrawerSubHdrTxt.get(0).getText(), "Inf\u00F3rmenos sobre la cobertura en los siguientes casos:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "Puede obtener cobertura de salud a trav\u00E9s de un empleo, aunque no est\u00E9 inscrita actualmente ni tenga previsto hacerlo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "Puede obtener cobertura de salud a trav\u00E9s de un empleo, incluso si el plan del empleador no est\u00E1 actualmente en el per\u00EDodo de inscripci\u00F3n abierta.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "No cree que pueda pagar la cobertura que le ofrecen. M\u00E1s adelante, le haremos m\u00E1s preguntas para ayudarle a determinar si puede calificar para obtener ahorros a trav\u00E9s de Connect for Health Colorado.");
        softAssert.assertEquals(helpDrawerSubHdrTxt.get(1).getText(), "No tiene que responder estas preguntas en los siguientes casos:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(3).getText(), "No se le ofrece cobertura a trav\u00E9s de su empleo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(4).getText(), "No trabaja suficientes horas para calificar para la cobertura que ofrece su empleo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(5).getText(), "El \u00FAnico tipo de cobertura disponible a trav\u00E9s del trabajo es el acuerdo de reembolsos de salud (HRA). Sin embargo, si a una persona se le ofrece un HRA y otro plan de seguro de salud grupal, seleccione el nombre. Recuerde: tambi\u00E9n deber\u00E1 proporcionar informaci\u00F3n sobre el HRA en la p\u00E1gina \"Otros seguros de salud\".");
        softAssert.assertEquals(helpDrawerBodyPoints.get(6).getText(), "La \u00FAnica opci\u00F3n que tiene para conseguir un seguro de salud es la continuaci\u00F3n de la cobertura COBRA o la cobertura para retirados.");
        softAssert.assertEquals(helpDrawerHeaderSection2Txt.get(2).getText(), "Si est\u00E1 o va a estar en \"per\u00EDodo de espera\", no responda a\u00FAn estas preguntas. Cuando finalice ese per\u00EDodo de espera, vuelva a la solicitud, comunique el cambio de vida e introduzca aqu\u00ED los datos del seguro de salud de su trabajo.");
        softAssert.assertEquals(helpDrawerWaitingPeriodTxt.getText(), "Un per\u00EDodo de espera es el tiempo que debe transcurrir antes de que un empleador ofrezca cobertura de salud a un empleado. Los per\u00EDodos de espera pueden ser de 0 a 90 d\u00EDas.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerMinimumValueTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Seguro de salud ofrecido a trav\u00E9s de un empleo");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Est\u00E1ndar de valor m\u00EDnimo:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "La mayor\u00EDa de los planes de seguro de salud que se ofrecen a trav\u00E9s de los trabajos cumplen el est\u00E1ndar de valor m\u00EDnimo.");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(1).getText(), "M\u00E1s informaci\u00F3n sobre el est\u00E1ndar de valor m\u00EDnimo");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Un plan de salud cumple el est\u00E1ndar de valor m\u00EDnimo si est\u00E1 dise\u00F1ado para pagar al menos el 60% del costo total de los servicios m\u00E9dicos para una poblaci\u00F3n est\u00E1ndar y si sus beneficios incluyen una cobertura considerable de los servicios hospitalarios y m\u00E9dicos.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Para saber si un plan cumple el est\u00E1ndar de valor m\u00EDnimo, consulte el Resumen de beneficios y cobertura (SBC) del plan de su empleo o pida en su trabajo que le llenen la herramienta de cobertura del empleador");
        softAssert.assertEquals(helpDrawerParagraphLnk1.get(0).getText(), "herramienta de cobertura del empleador");
        softAssert.assertEquals(helpDrawerPrintTxt.getText(), "Imprima o descargue la herramienta de cobertura del empleador");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerMonthlyAmountTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Seguro de salud ofrecido a trav\u00E9s de un empleo");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Prima de costo m\u00E1s bajo:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Texto de sugerencia:Solo ingrese la cantidad que pagar\u00EDa. No incluya ninguna cantidad que pague su empleador.");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(1).getText(), "Obtenga m\u00E1s informaci\u00F3n sobre c\u00F3mo ingresar las cantidades de las primas");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Ingrese la cantidad normal que el empleado tendr\u00EDa que pagar por su cobertura de salud (la \"prima\") si se inscribiera.");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(2).getText(), "Ingrese la cantidad del plan de menor costo que ofrece el empleador y que cubrir\u00EDa solo al empleado.");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(3).getText(), "Si el empleador tiene programas de bienestar, haga lo siguiente:\nIngrese la prima que pagar\u00EDa esta persona si obtuviera el descuento m\u00E1ximo para cualquier programa de suspensi\u00F3n al tabaco (consejer\u00EDa para dejar de fumar), pero para ning\u00FAn otro programa.");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(4).getText(), "El empleador debe indicar estas cantidades en un aviso. Sin embargo, si usted no dispone de un aviso o no est\u00E1 seguro de cu\u00E1les son estas cantidades, pregunte a su empleador.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerCurrentlyEnrolledTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Seguro de salud ofrecido a trav\u00E9s de un empleo");
        softAssert.assertEquals(helpDrawerSubHdr2Txt.get(0).getText(), "Inscripci\u00F3n:");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(0).getText(), "Si esta persona tiene actualmente seguro de salud a trav\u00E9s de este trabajo, seleccione \"S\u00ED\". Si esta persona puede obtener ese seguro de salud, pero ha preferido no inscribirse, seleccione \"No\".");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerEnd60DaysTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Seguro de salud ofrecido a trav\u00E9s de un empleo");
        softAssert.assertEquals(helpDrawerSubHdr2Txt.get(0).getText(), "Finalizaci\u00F3n en los pr\u00F3ximos 60 d\u00EDas:");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(0).getText(), "Si este seguro acabar\u00E1 pronto porque:");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "el trabajo est\u00E1 por terminarse;");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "la empresa ya no ofrecer\u00E1 seguro de salud;");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "usted ya no calificar\u00E1 para recibirlo;");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(1).getText(), "seleccione \"S\u00ED\" e ingrese la fecha en que terminar\u00E1 el seguro.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerVoluntarilyEndingTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink, 25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(), "Seguro de salud ofrecido a trav\u00E9s de un empleo");
        softAssert.assertEquals(helpDrawerSubHeaderTxt.get(0).getText(), "Cancelar el seguro de salud de manera voluntaria:");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(0).getText(), "Cancelar el seguro de salud de manera voluntaria:\nSeleccione \"S\u00ED\" si todav\u00EDa es elegible para recibir seguro de salud a trav\u00E9s de su empleador, pero ha elegido cancelar el plan o si rechaz\u00F3 la inscripci\u00F3n cuando tuvo la oportunidad.");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(1).getText(), "Seleccione \"No\" si ya no es elegible para recibir seguro de salud por medio de su empleador o si su empleador ofrec\u00EDa seguro de salud y ya no lo ofrece.");
        softAssert.assertEquals(helpDrawerBodyParagraphs2.get(2).getText(), "Seleccione \"No\" si su empleador ofrec\u00EDa seguro de salud y ahora solo ofrece un acuerdo de reembolsos de salud (HRA).");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyLanguageTextInESIPage(List<String> dataText) {
        softAssert.assertEquals(OhcHeader.getText(), dataText.get(1) + " " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName(), "Page Header 1 Not matching");
        softAssert.assertEquals(OhcEsiHeader.getText(), dataText.get(2), "Page Header 2 Not matching");
        softAssert.assertAll();
    }

    public void verifyStdErrorTextInESIPage(List<String> dataText) {
        softAssert.assertEquals(errHealtInsMeetEn.getText(), dataText.get(1), "Label Not matching");
        softAssert.assertEquals(errHwMuchWdUPayEn.getText(), dataText.get(2), "Label Not matching");
        softAssert.assertEquals(errDateIsReqEn.getText(), dataText.get(3), "Label Not matching");
        softAssert.assertEquals(errVolEndInsEn.getText(), dataText.get(4), "Label Not matching");
        softAssert.assertAll();
    }

    public void verifyErrorMessageForHealthInsuranceEnrollmentStatus() {
        basicActions.waitForElementToBeClickable(healthinsuranceenrollmentstatuserrorMessage, 25);
        softAssert.assertEquals(healthinsuranceenrollmentstatuserrorMessage.getText(), "Please select one option for each individual below");
        softAssert.assertEquals(healthinsuranceenrollmentstatuserrorMessage.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(healthinsuranceenrollmentstatuserrorMessage.getCssValue("font-size"), "14px");
        softAssert.assertEquals(healthinsuranceenrollmentstatuserrorMessage.getCssValue("font-weight"), "400");
        softAssert.assertEquals(healthinsuranceenrollmentstatuserrorMessage.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertAll();
    }


}