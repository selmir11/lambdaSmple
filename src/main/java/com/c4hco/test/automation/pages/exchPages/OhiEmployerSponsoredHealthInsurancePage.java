package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OhiEmployerSponsoredHealthInsurancePage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    Calendar calendar = Calendar.getInstance();
    Date today = new Date();
    public OhiEmployerSponsoredHealthInsurancePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container .header-1")
    WebElement ohiHeader;

    @FindBy(css = ".container .header-2")
    WebElement ohiEsiHeader;

    @FindBy(css = "div > label")
    List<WebElement> EsiQuestionTxt;

    @FindBy(css ="#ELIG-Ohc-Esi-employer-container span.error-message")
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

    @FindBy(id = "ELIG-Ohc-Esi-FamilyCoveragePlanOffered-YesButton")
    WebElement esiFamilyOfferedYesBtn;

    @FindBy(id = "ELIG-Ohc-Esi-FamilyCoveragePlanOffered-NoButton")
    WebElement esiFamilyOfferedNoBtn;

    @FindBy(css = "#ELIG-Ohc-Esi-EmpSponsCovgFamilyMonthlyPremium")
    WebElement esiMonthlyAmountFamilyInput;

    @FindBy(css = "#ELIG-Ohc-Esi-MemberCoverage > div > span")
    WebElement esiMemberStatusTxt;

    @FindBy(css = "app-other-member-coverage > div > span")
    List<WebElement> esiFamilyMemberTxt;

    @FindBy(id = "ELIG-Ohc-Esi-MemberCoverage-0-CoverageTypeEnrolledButton")
    List<WebElement> esiFamilyEnrolledBtn;

    @FindBy(id = "ELIG-Ohc-Esi-MemberCoverage-0-CoverageTypeAccessButton")
    List<WebElement> esiFamilyOfferedBtn;

    @FindBy(id = "ELIG-Ohc-Esi-MemberCoverage-0-CoverageTypeNoAccessButton")
    List<WebElement> esiFamilyNoOptionBtn;

    @FindBy(css = ".drawer-controls > div > div")
    WebElement helpButton;

    @FindBy(css = ".header-3.content-center > a")
    WebElement helpCenterTxt;

    @FindBy(css = ".header-3.content-center.ng-star-inserted > a")
    WebElement helpUnderstandLnk;

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

    @FindBy(id = "Ohi-Esi-GoBack")
    WebElement goBackButton;

    @FindBy(id = "Ohi-Esi-SaveAndContinue")
    WebElement saveAndContinueBtn;



    public void clickGoBack() {
        basicActions.click(goBackButton);
    }

    public void clickSaveAndContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
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
            default:
                throw new IllegalArgumentException("Invalid member type: " + member);
        }

        dropdown.selectByVisibleText(setEmployerName);
    }

    public void clickMinValueStandard(String minValueStandard){
        switch (minValueStandard){
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

    public void enterMonthlyAmount(String employeeAmount){
        basicActions.waitForElementToBePresent(esiMonthlyAmountInput, 50);
        esiMonthlyAmountInput.clear();
        esiMonthlyAmountInput.sendKeys(employeeAmount);
    }

    public void clickCurrentlyEnrolled(String currentlyEnrolled){
        switch (currentlyEnrolled){
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

    public void clickInsuranceEnd(String willEnd){
        switch (willEnd){
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

    public void enterEndDate(String endDate){
        basicActions.waitForElementToBePresent(esiEndDateInput, 60);
        calendar.setTime(today);

        switch (endDate){
            case "Current Month":
                calendar.add(Calendar.MONTH, 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.add(Calendar.DATE, -1);
                Date lastDayOfMonth = calendar.getTime();
                DateFormat endOfCurrentMonth = new SimpleDateFormat("MM-dd");
                esiEndDateInput.sendKeys(endOfCurrentMonth.format(lastDayOfMonth));
                break;
            case "Prior Month":
                calendar.add(Calendar.MONTH, 0);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.add(Calendar.DATE, -1);
                Date lastDayOfPriorMonth = calendar.getTime();
                DateFormat endOfPriorMonth = new SimpleDateFormat("MM-dd");
                esiEndDateInput.sendKeys(endOfPriorMonth.format(lastDayOfPriorMonth));
                break;
            case "Future Month":
                calendar.add(Calendar.MONTH, 3);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.add(Calendar.DATE, -1);
                Date lastDayOfFutureMonth = calendar.getTime();
                DateFormat endOfFutureMonth = new SimpleDateFormat("MM-dd");
                esiEndDateInput.sendKeys(endOfFutureMonth.format(lastDayOfFutureMonth));
                break;
            case "Today":
                DateFormat todayDate = new SimpleDateFormat("MM-dd");
                esiEndDateInput.sendKeys(todayDate.format(today));
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

    public void enterMonthlyFamilyAmount(String familyAmount){
        basicActions.waitForElementToBePresent(esiMonthlyAmountFamilyInput, 50);
        esiMonthlyAmountFamilyInput.clear();
        esiMonthlyAmountFamilyInput.sendKeys(familyAmount);
    }

    public void clickFamilyEnrollmentStatusMembers(List<Map<String, String>> expectedValues){
        for(int i=0; i<expectedValues.size();i++){
            String txtToClick =  expectedValues.get(i).get("enrollmentStatus");
            clickFamilyEnrollmentStatusMember(txtToClick, i);
        }
    }

    public void clickFamilyEnrollmentStatusMember(String enrollmentStatus, int memberIndex) {
        switch (enrollmentStatus) {
            case "Enrolled":
                basicActions.waitForElementListToBePresent(esiFamilyEnrolledBtn, 20);
                basicActions.click(esiFamilyEnrolledBtn.get(memberIndex));
                break;
            case "Offered":
                basicActions.waitForElementListToBePresent(esiFamilyOfferedBtn, 20);
                basicActions.click(esiFamilyOfferedBtn.get(memberIndex));
                break;
            case "No Option":
                basicActions.waitForElementListToBePresent(esiFamilyNoOptionBtn, 20);
                basicActions.click(esiFamilyNoOptionBtn.get(memberIndex));
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
        switch (lnkName){
            case "Contact Us":
                basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
                helpDrawerContactUsLink.click();
                break;
            case "Employer Coverage Tool 1":
                basicActions.waitForElementToBePresentWithRetries(helpDrawerParagraphLnk1, 10);
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
    public void verifyHeadersEsiOhiPageEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Existing Health Insurance: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiEsiHeader.getText(),"Employer-sponsored Health Insurance");
        softAssert.assertAll();
    }

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
        basicActions.waitForElementToBePresent(esiMonthlyAmountFamilyInput, 50);
        softAssert.assertTrue(esiMonthlyAmountFamilyInput.getAttribute("value").contains(familyAmount));
        softAssert.assertAll();
    }

    public void verifyFamilyEnrollmentStatusMembers(List<Map<String, String>> expectedValues){
        for(int i=0; i<expectedValues.size();i++){
            String txtToClick =  expectedValues.get(i).get("enrollmentStatus");
            verifyFamilyEnrollmentStatusMember(txtToClick, i);
        }
    }

    public void verifyFamilyEnrollmentStatusMember(String enrollmentStatus, int memberIndex) {
        switch (enrollmentStatus) {
            case "Enrolled":
                basicActions.waitForElementListToBePresent(esiFamilyEnrolledBtn, 20);
                softAssert.assertTrue(esiFamilyEnrolledBtn.get(memberIndex).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "Offered":
                basicActions.waitForElementListToBePresent(esiFamilyOfferedBtn, 20);
                softAssert.assertTrue(esiFamilyOfferedBtn.get(memberIndex).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No Option":
                basicActions.waitForElementListToBePresent(esiFamilyNoOptionBtn, 20);
                softAssert.assertTrue(esiFamilyNoOptionBtn.get(memberIndex).getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + enrollmentStatus);
        }
    }

    public void verifyEsiPageData(String dataToVerify, String language){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (language){
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

    public void verifyEsiPageDataEnglish(String dataToVerify){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (dataToVerify){
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
        softAssert.assertEquals(goBackButton.getText(),"  Go Back");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Save and Continue");
        softAssert.assertAll();
    }

    public void verifyEsiPageNoJobSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Existing Health Insurance: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiEsiHeader.getText(),"Employer-sponsored Health Insurance");
        softAssert.assertEquals(EsiQuestionTxt.get(0).getText(),"Which job is offering health insurance?");
        softAssert.assertEquals(esiSelectEmployerDpd.getText(),"Select an employer\n"+SharedData.getPrimaryMember().getEmployerName());
        softAssert.assertAll();
    }

    public void verifyEsiPageJobSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(1).getText(),"Does this health insurance meet the Minimum Value Standard?");
        softAssert.assertEquals(esiMinValueStandardYesBtn.getText(),"Yes");
        softAssert.assertEquals(esiMinValueStandardNoBtn.getText(),"No");
        softAssert.assertEquals(esiMinValueStandardDontKnowBtn.getText(),"I don't know");
        softAssert.assertEquals(EsiQuestionTxt.get(2).getText(),"How much would you pay for the lowest-cost monthly health plan premium at "+SharedData.getPrimaryMember().getEmployerName()+" just for yourself?");
        softAssert.assertEquals(esiMonthlyAmountInput.getAttribute("placeholder"),"monthly amount");
        softAssert.assertEquals(EsiQuestionTxt.get(3).getText(),"Are you currently enrolled in the health insurance offered by "+SharedData.getPrimaryMember().getEmployerName()+"?");
        softAssert.assertEquals(esiCurrentlyEnrolledYesBtn.getText(),"Yes");
        softAssert.assertEquals(esiCurrentlyEnrolledNoBtn.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(4).getText(),"Will this health insurance end in the next 60 days?");
        softAssert.assertEquals(esiInsuranceEndYesBtn.getText(),"Yes");
        softAssert.assertEquals(esiInsuranceEndNoBtn.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledEndingSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(5).getText(),"End Date:");
        softAssert.assertEquals(esiEndDateInput.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(EsiQuestionTxt.get(6).getText(),"Are you voluntarily ending this health insurance?");
        softAssert.assertEquals(esiVoluntarilyEndingYesBtn.getText(),"Yes");
        softAssert.assertEquals(esiVoluntarilyEndingNoBtn.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyEsiPageFamilyPlansSectionDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(7).getText(),"Does "+SharedData.getPrimaryMember().getEmployerName()+" offer family health plans?");
        softAssert.assertEquals(esiFamilyOfferedYesBtn.getText(),"Yes");
        softAssert.assertEquals(esiFamilyOfferedNoBtn.getText(),"No");
        softAssert.assertEquals(EsiQuestionTxt.get(8).getText(),"How much would you pay for the lowest-cost monthly health plan premium at "+SharedData.getPrimaryMember().getEmployerName()+" to cover your family?");
        softAssert.assertEquals(esiMemberStatusTxt.getText(),"For each member, select which option best describes their health insurance enrollment status with "+SharedData.getPrimaryMember().getEmployerName()+":");
        softAssert.assertTrue(esiFamilyMemberTxt.get(0).getText().equalsIgnoreCase(SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(esiFamilyEnrolledBtn.get(0).getText(),"Enrolled");
        softAssert.assertEquals(esiFamilyOfferedBtn.get(0).getText(),"Offered a plan but not enrolled");
        softAssert.assertEquals(esiFamilyNoOptionBtn.get(0).getText(),"No option to enroll");
        softAssert.assertAll();
    }

    public void verifyEsiPageFirstSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Existing Health Insurance: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(ohiEsiHeader.getText(),"Employer-sponsored Health Insurance");
        softAssert.assertEquals(EsiQuestionTxt.get(0).getText(),"Which job is offering health insurance?");
        softAssert.assertEquals(esiSelectEmployerDpd.getText(),"Select an employer\n"+SharedData.getMembers().get(0).getEmployerName());
        softAssert.assertAll();
    }

    public void verifyEsiPageSecondSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(1).getText(),"Does this health insurance meet the Minimum Value Standard?");
        softAssert.assertEquals(esiMinValueStandardYesBtn.getText(),"Yes");
        softAssert.assertEquals(esiMinValueStandardNoBtn.getText(),"No");
        softAssert.assertEquals(esiMinValueStandardDontKnowBtn.getText(),"I don't know");
        softAssert.assertEquals(EsiQuestionTxt.get(2).getText(),"How much would "+SharedData.getMembers().get(0).getFirstName()+" pay for the lowest-cost monthly health plan premium at "+SharedData.getMembers().get(0).getEmployerName()+" just for themself?");
        softAssert.assertEquals(esiMonthlyAmountInput.getAttribute("placeholder"),"monthly amount");
        softAssert.assertEquals(EsiQuestionTxt.get(3).getText(),"Is "+SharedData.getMembers().get(0).getFirstName()+" currently enrolled in the health insurance offered by "+SharedData.getMembers().get(0).getEmployerName()+"?");
        softAssert.assertEquals(esiCurrentlyEnrolledYesBtn.getText(),"Yes");
        softAssert.assertEquals(esiCurrentlyEnrolledNoBtn.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledEndingSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(5).getText(),"End Date:");
        softAssert.assertEquals(esiEndDateInput.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(EsiQuestionTxt.get(6).getText(),"Is "+SharedData.getMembers().get(0).getFirstName()+" voluntarily ending this health insurance?");
        softAssert.assertEquals(esiVoluntarilyEndingYesBtn.getText(),"Yes");
        softAssert.assertEquals(esiVoluntarilyEndingNoBtn.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyEsiPageFamilyPlansSectionSecondaryDataEnglish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(7).getText(),"Does "+SharedData.getMembers().get(0).getEmployerName()+" offer family health plans?");
        softAssert.assertEquals(esiFamilyOfferedYesBtn.getText(),"Yes");
        softAssert.assertEquals(esiFamilyOfferedNoBtn.getText(),"No");
        softAssert.assertEquals(EsiQuestionTxt.get(8).getText(),"How much would "+SharedData.getMembers().get(0).getFirstName()+" pay for the lowest-cost monthly health plan premium at "+SharedData.getMembers().get(0).getEmployerName()+" to cover your family?");
        softAssert.assertEquals(esiMemberStatusTxt.getText(),"For each member, select which option best describes their health insurance enrollment status with "+SharedData.getMembers().get(0).getEmployerName()+":");
        softAssert.assertTrue(esiFamilyMemberTxt.get(0).getText().equalsIgnoreCase(SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(esiFamilyEnrolledBtn.get(0).getText(),"Enrolled");
        softAssert.assertEquals(esiFamilyOfferedBtn.get(0).getText(),"Offered a plan but not enrolled");
        softAssert.assertEquals(esiFamilyNoOptionBtn.get(0).getText(),"No option to enroll");
        softAssert.assertAll();
    }

    public void verifyEsiPageDataSpanish(String dataToVerify){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        switch (dataToVerify){
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
        softAssert.assertEquals(goBackButton.getText(),"  Volver");
        softAssert.assertEquals(saveAndContinueBtn.getText(),"Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyEsiPageNoJobSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Seguro de salud existente: " + SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(ohiEsiHeader.getText(),"Seguro de salud patrocinado por el empleador");
        softAssert.assertEquals(EsiQuestionTxt.get(0).getText(),"\u00BFQu\u00E9 empleo le ofrece seguro de salud?");
        softAssert.assertEquals(esiSelectEmployerDpd.getText(),"Seleccionar un empleador\n"+SharedData.getPrimaryMember().getEmployerName());
        softAssert.assertAll();
    }

    public void verifyEsiPageJobSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(1).getText(),"\u00BFCumple este seguro de salud el est\u00E1ndar de valor m\u00EDnimo?");
        softAssert.assertEquals(esiMinValueStandardYesBtn.getText(),"S\u00ED");
        softAssert.assertEquals(esiMinValueStandardNoBtn.getText(),"No");
        softAssert.assertEquals(esiMinValueStandardDontKnowBtn.getText(),"No s\u00E9");
        softAssert.assertEquals(EsiQuestionTxt.get(2).getText(),"\u00BFCu\u00E1nto pagar\u00EDa por la prima mensual del plan de salud de menor costo en "+SharedData.getPrimaryMember().getEmployerName()+" solo para usted?");
        softAssert.assertEquals(esiMonthlyAmountInput.getAttribute("placeholder"),"Cantidad mensual");
        softAssert.assertEquals(EsiQuestionTxt.get(3).getText(),"\u00BFEst\u00E1 inscrito actualmente en el seguro de salud que ofrece "+SharedData.getPrimaryMember().getEmployerName()+"?");
        softAssert.assertEquals(esiCurrentlyEnrolledYesBtn.getText(),"S\u00ED");
        softAssert.assertEquals(esiCurrentlyEnrolledNoBtn.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(4).getText(),"\u00BFEste seguro de salud terminar\u00E1 en los siguientes 60 d\u00EDas?");
        softAssert.assertEquals(esiInsuranceEndYesBtn.getText(),"S\u00ED");
        softAssert.assertEquals(esiInsuranceEndNoBtn.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledEndingSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(5).getText(),"Fecha de terminaci\u00F3n:");
        softAssert.assertEquals(esiEndDateInput.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(EsiQuestionTxt.get(6).getText(),"\u00BFEst\u00E1 cancelando voluntariamente este seguro de salud?");
        softAssert.assertEquals(esiVoluntarilyEndingYesBtn.getText(),"S\u00ED");
        softAssert.assertEquals(esiVoluntarilyEndingNoBtn.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyEsiPageFamilyPlansSectionDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(7).getText(),"\u00BF"+SharedData.getPrimaryMember().getEmployerName()+" ofrece planes de salud familiares?");
        softAssert.assertEquals(esiFamilyOfferedYesBtn.getText(),"S\u00ED");
        softAssert.assertEquals(esiFamilyOfferedNoBtn.getText(),"No");
        softAssert.assertEquals(EsiQuestionTxt.get(8).getText(),"\u00BFCu\u00E1nto pagar\u00EDa por la prima mensual del plan de salud de menor costo en "+SharedData.getPrimaryMember().getEmployerName()+" para cubrir a su familia?");
        softAssert.assertEquals(esiMemberStatusTxt.getText(),"Para cada miembro, seleccione la opci\u00F3n que describe mejor el estado de su inscripci\u00F3n en el seguro m\u00E9dico con "+SharedData.getPrimaryMember().getEmployerName()+":");
        softAssert.assertTrue(esiFamilyMemberTxt.get(0).getText().equalsIgnoreCase(SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(esiFamilyEnrolledBtn.get(0).getText(),"Inscrito");
        softAssert.assertEquals(esiFamilyOfferedBtn.get(0).getText(),"Se le ofreci\u00F3 un plan pero no se inscribi\u00F3");
        softAssert.assertEquals(esiFamilyNoOptionBtn.get(0).getText(),"No hay opci\u00F3n para inscribirse");
        softAssert.assertAll();
    }

    public void verifyEsiPageFirstSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertTrue(ohiHeader.getText().equalsIgnoreCase("Seguro de salud existente: " + SharedData.getMembers().get(0).getFullName()));
        softAssert.assertEquals(ohiEsiHeader.getText(),"Seguro de salud patrocinado por el empleador");
        softAssert.assertEquals(EsiQuestionTxt.get(0).getText(),"\u00BFQu\u00E9 empleo le ofrece seguro de salud?");
        softAssert.assertEquals(esiSelectEmployerDpd.getText(),"Seleccionar un empleador\n"+SharedData.getMembers().get(0).getEmployerName());
        softAssert.assertAll();
    }

    public void verifyEsiPageSecondSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(1).getText(),"\u00BFCumple este seguro de salud el est\u00E1ndar de valor m\u00EDnimo?");
        softAssert.assertEquals(esiMinValueStandardYesBtn.getText(),"S\u00ED");
        softAssert.assertEquals(esiMinValueStandardNoBtn.getText(),"No");
        softAssert.assertEquals(esiMinValueStandardDontKnowBtn.getText(),"No s\u00E9");
        softAssert.assertEquals(EsiQuestionTxt.get(2).getText(),"\u00BFCu\u00E1nto pagar\u00EDa " + SharedData.getMembers().get(0).getFirstName() + " por la prima mensual del plan de salud de menor costo en "+SharedData.getMembers().get(0).getEmployerName()+" solo para ellos?");
        softAssert.assertEquals(esiMonthlyAmountInput.getAttribute("placeholder"),"Cantidad mensual");
        softAssert.assertEquals(EsiQuestionTxt.get(3).getText(),"\u00BF"+ SharedData.getMembers().get(0).getFirstName() + " se inscribi\u00F3 en el seguro de salud que ofrece "+SharedData.getMembers().get(0).getEmployerName()+"?");
        softAssert.assertEquals(esiCurrentlyEnrolledYesBtn.getText(),"S\u00ED");
        softAssert.assertEquals(esiCurrentlyEnrolledNoBtn.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyEsiPageCurrentlyEnrolledEndingSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(5).getText(),"Fecha de terminaci\u00F3n:");
        softAssert.assertEquals(esiEndDateInput.getAttribute("placeholder"), "MM/DD/YYYY");
        softAssert.assertEquals(EsiQuestionTxt.get(6).getText(),"\u00BF" + SharedData.getMembers().get(0).getFirstName() + " est\u00E1 cancelando voluntariamente este seguro de salud?");
        softAssert.assertEquals(esiVoluntarilyEndingYesBtn.getText(),"S\u00ED");
        softAssert.assertEquals(esiVoluntarilyEndingNoBtn.getText(),"No");
        softAssert.assertAll();
    }

    public void verifyEsiPageFamilyPlansSectionSecondaryDataSpanish(){
        basicActions.waitForElementToBePresent(ohiHeader,15);
        softAssert.assertEquals(EsiQuestionTxt.get(7).getText(),"\u00BF"+SharedData.getMembers().get(0).getEmployerName()+" ofrece planes de salud familiares?");
        softAssert.assertEquals(esiFamilyOfferedYesBtn.getText(),"S\u00ED");
        softAssert.assertEquals(esiFamilyOfferedNoBtn.getText(),"No");
        softAssert.assertEquals(EsiQuestionTxt.get(8).getText(),"\u00BFCu\u00E1nto pagar\u00EDa " + SharedData.getMembers().get(0).getFirstName() + " por la prima mensual del plan de salud de menor costo en "+SharedData.getMembers().get(0).getEmployerName()+" para cubrir a su familia?");
        softAssert.assertEquals(esiMemberStatusTxt.getText(),"Para cada miembro, seleccione la opci\u00F3n que describe mejor el estado de su inscripci\u00F3n en el seguro m\u00E9dico con "+SharedData.getMembers().get(0).getEmployerName()+":");
        softAssert.assertTrue(esiFamilyMemberTxt.get(0).getText().equalsIgnoreCase(SharedData.getPrimaryMember().getFullName()));
        softAssert.assertEquals(esiFamilyEnrolledBtn.get(0).getText(),"Inscrito");
        softAssert.assertEquals(esiFamilyOfferedBtn.get(0).getText(),"Se le ofreci\u00F3 un plan pero no se inscribi\u00F3");
        softAssert.assertEquals(esiFamilyNoOptionBtn.get(0).getText(),"No hay opci\u00F3n para inscribirse");
        softAssert.assertAll();
    }

    public void verifyErrorMessage(String errorType, String language) {
        switch (errorType) {
            case "Which Job":
                verifyWhichJobError(language);
                break;
            case "Min Value":
                verifyMinValueError(language);
                break;
            case "Amount":
                verifyAmountError(language);
                break;
            case "Currently Enrolled":
                verifyCurrentlyEnrolledError(language);
                break;
            case "Insurance Ending":
                verifyInsuranceEndingError(language);
                break;
            case "Input Date":
                verifyInputEndDateError(language);
                break;
            case "Voluntary End":
                verifyEndVoluntaryError(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }

    public void verifyWhichJobError(String language) {
        basicActions.waitForElementToBePresent(whichJobError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(whichJobError.getText(), "Please select one of the options below");
                softAssert.assertEquals(whichJobError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(whichJobError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(whichJobError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(whichJobError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(whichJobError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(whichJobError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(whichJobError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(whichJobError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(whichJobError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyMinValueError(String language) {
        basicActions.waitForElementToBePresent(minValueError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(minValueError.getText(), "Please select one of the options below");
                softAssert.assertEquals(minValueError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(minValueError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(minValueError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(minValueError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(minValueError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(minValueError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(minValueError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(minValueError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(minValueError.getCssValue("color"), "rgba(150, 0, 0, 1)");
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

    public void verifyCurrentlyEnrolledError(String language) {
        basicActions.waitForElementToBePresent(currentlyEnrolledError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(currentlyEnrolledError.getText(), "Please select one of the options below");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(currentlyEnrolledError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(currentlyEnrolledError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyInsuranceEndingError(String language) {
        basicActions.waitForElementToBePresent(insuranceEndingError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(insuranceEndingError.getText(), "Please select one of the options below");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(insuranceEndingError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(insuranceEndingError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(insuranceEndingError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(insuranceEndingError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyInputEndDateError(String language) {
        basicActions.waitForElementToBePresent(inputEndDateError, 20);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        calendar.setTime(today);
        String formattedDate = dateFormat.format(today);
        switch (language) {
            case "English":
                softAssert.assertEquals(inputEndDateError.getText(), "Date is required");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(inputEndDateError.getText(), "La fecha es obligatoria");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "English Prior":
                softAssert.assertEquals(inputEndDateError.getText(), "Please enter a value greater than or equal to "+formattedDate);
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish Prior":
                softAssert.assertEquals(inputEndDateError.getText(), "Por favor ingrese un valor mayor que o igual a "+formattedDate);
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "English Future":
                softAssert.assertEquals(inputEndDateError.getText(), "Date cannot exceed 60 days in the future");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish Future":
                softAssert.assertEquals(inputEndDateError.getText(), "La fecha a seleccionar no puede exceder los 60 d\u00EDas");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(inputEndDateError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(inputEndDateError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyEndVoluntaryError(String language) {
        basicActions.waitForElementToBePresent(endVoluntaryError, 20);
        switch (language) {
            case "English":
                softAssert.assertEquals(endVoluntaryError.getText(), "Please select one of the options below");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(endVoluntaryError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(endVoluntaryError.getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(endVoluntaryError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(endVoluntaryError.getCssValue("color"), "rgba(150, 0, 0, 1)");
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
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
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
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
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
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
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
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerMonthlyAmountTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"How much would you pay for the lowest-cost monthly health plan premium at "+SharedData.getPrimaryMember().getEmployerName()+" just for yourself?");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(0).getText(), "Lowest-Cost Premium:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Lowest-Cost Premium:\nHint Text: Only enter the amount you would pay. Don't include any amount paid by your employer.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Learn more about entering premium amounts\nEnter the regular amount the employee would have to pay for their health coverage (the \"premium\") if they enrolled.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Enter the amount of the lowest-cost plan offered by the employer that would cover only the employee.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "If the employer has wellness programs:\nEnter the premium this person would pay if they got the maximum discount for any tobacco cessation programs (counseling to stop smoking), but no other programs.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "These amounts should be listed in a notice from your employer. But, if you don't have a notice or you're not sure what these amounts are, ask your employer.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerCurrentlyEnrolledTextEnglish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Help");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"Are you currently enrolled in the health insurance offered by "+SharedData.getPrimaryMember().getEmployerName()+"?");
        softAssert.assertEquals(helpDrawerHeaderTxt.get(0).getText(), "Enrollment:");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Enrollment:\nIf this person currently has health insurance through this job, select \"Yes\". If this person is able to get this health insurance, but has chosen not to enroll, select \"No\".");
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
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
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
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
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
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
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
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
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
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
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerMonthlyAmountTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"\u00BFCu\u00E1nto pagar\u00EDa por la prima mensual del plan de salud de menor costo en "+SharedData.getPrimaryMember().getEmployerName()+" solo para usted?");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Prima de costo m\u00E1s bajo:\nTexto de sugerencia: Solo ingrese la cantidad que pagar\u00EDa. No incluya ninguna cantidad que pague su empleador.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Obtenga m\u00E1s informaci\u00F3n sobre c\u00F3mo ingresar las cantidades de las primas\nIngrese la cantidad normal que el empleado tendr\u00EDa que pagar por su cobertura de salud (la \"prima\") si se inscribiera.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Ingrese la cantidad del plan de menor costo que ofrece el empleador y que cubrir\u00EDa solo al empleado.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "Si el empleador tiene programas de bienestar, haga lo siguiente:\nIngrese la prima que pagar\u00EDa esta persona si obtuviera el descuento m\u00E1ximo para cualquier programa de suspensi\u00F3n al tabaco (consejer\u00EDa para dejar de fumar), pero para ning\u00FAn otro programa.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "El empleador debe indicar estas cantidades en un aviso. Sin embargo, si usted no dispone de un aviso o no est\u00E1 seguro de cu\u00E1les son estas cantidades, pregunte a su empleador.");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerCurrentlyEnrolledTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"\u00BFEst\u00E1 inscrito actualmente en el seguro de salud que ofrece "+SharedData.getPrimaryMember().getEmployerName()+"?");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Inscripci\u00F3n:\nSi esta persona tiene actualmente seguro de salud a trav\u00E9s de este trabajo, seleccione \"S\u00ED\". Si esta persona puede obtener ese seguro de salud, pero ha preferido no inscribirse, seleccione \"No\".");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
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
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerVoluntarilyEndingTextSpanish() {
        basicActions.waitForElementToBeClickable(helpDrawerContactUsLink,25);
        softAssert.assertEquals(helpHeaderTxt.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHeaderTxt.getText(),"\u00BFEst\u00E1 cancelando voluntariamente este seguro de salud?");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Cancelar el seguro de salud de manera voluntaria:\nSeleccione \"S\u00ED\" si todav\u00EDa es elegible para recibir seguro de salud a trav\u00E9s de su empleador, pero ha elegido cancelar el plan o si rechaz\u00F3 la inscripci\u00F3n cuando tuvo la oportunidad.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Seleccione \"No\" si ya no es elegible para recibir seguro de salud por medio de su empleador o si su empleador ofrec\u00EDa seguro de salud y ya no lo ofrece.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Seleccione \"No\" si su empleador ofrec\u00EDa seguro de salud y ahora solo ofrece un acuerdo de reembolsos de salud (HRA).");
        softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
        softAssert.assertAll();
    }




}