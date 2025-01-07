package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.ExpectedCalculatedDates;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.ScenarioDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountOverviewPage {

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(css = "li.vertical-ruler")
    WebElement userNameExchLink;

    @FindBy(xpath = "//*[@id='submit-curr-yr-3' or @id='submit-curr-yr-1' or @id='submit-curr-yr-6' or @id='submit-curr-yr-2']")
    WebElement btnApplyForCurrentYear;  //Locator for both QA and Staging

    @FindBy(css = "#submit[name='applyForNextYear']")
    WebElement btnApplyForNextYear;

    @FindBy(css = ".linkButton")
    List<WebElement> clickHereLinks; // profile, eligibility, documents, plans

    @FindBy(css = "h4 .c4PageHeader")
    WebElement txtNextStep;

    @FindBy(id = "submit-curr-yr-4")
    WebElement makeChangesButton;

    @FindBy(css = ".c4PageHeader-large")
    WebElement header;

    @FindBy(css = ".table-bordered td b")
    List<WebElement> planInformationTable;

    @FindBy(css = ".table-bordered tr:nth-child(1) td:nth-child(2) span b")
    List<WebElement> medicalMemberNames;
    @FindBy(css = "option[selected='selected']")
    WebElement planYearOnWelcomeBackPage;

    @FindBy(xpath = "(//h1/span)[2]")
    WebElement txtUserName;

    @FindBy(css = "p.c4PageHeader")
    WebElement txtHeaderVerifyYourInformation;

    @FindBy(xpath = "//p[@class='c4PageHeader']/following-sibling::p")
    WebElement txtContentVerifyYourInformation;

    @FindBy(css = "#selfAttestation #submit")
    WebElement btnVerifyYourInformation;

    @FindBy(css = ".c4PageTitle")
    List<WebElement> txtHeaderDetails;

    @FindBy(css = "#planYear>option")
    List<WebElement> dpdSelectPlanYear;

    @FindBy(css=".btn-group-toggle>label")
    List<WebElement> btnOpenClosedToggle;

    @FindBy(xpath = "//div[@data-toggle='buttons']/parent::div/following-sibling::p")
    List<WebElement> txtEnrollmentTextInfo;

    @FindBy(xpath = "//*[contains(text(),'You can apply for vision coverage')]")
    WebElement txtApplyForVisionCoverage;

    @FindBy(xpath = "//button[@id='medicalDentalButton']/parent::p/a")
    WebElement btnShopForVisionPlans;

    @FindBy(xpath = "//button[@id='medicalDentalButton']")
    WebElement btnMakeChangesToMyDentalPlan;

    @FindBy(xpath = "//*[contains(text(),'Do you want to')]")
    List<WebElement> txtAdditionalResourcesDetails;

    @FindBy(xpath = "//a[@class='linkButton']/parent::p")
    List<WebElement> txtlinkButton;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AccountOverviewPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickuserNameExchLink() {
        basicActions.waitForElementToBeClickable(userNameExchLink, 15);
        userNameExchLink.click();
    }

    public void clickApplyForCurrentYear(){
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent(header, 30);
        WebElement applyForYr;

        if(SharedData.getIsOpenEnrollment().equals("yes")){
             applyForYr = btnApplyForNextYear;
        } else{
            applyForYr = btnApplyForCurrentYear;
        }
        basicActions.waitForElementToBePresent(applyForYr, 40);
        String year = applyForYr.getText().replace("Apply for ", "");
        SharedData.setPlanYear(year);
        applyForYr.click();
    }

    public void clickHereLinks(String clickHereOption){
        basicActions.waitForElementListToBePresent(clickHereLinks, 10);
        switch(clickHereOption){
            case "My Profile":
                clickHereLinks.get(0).click();
                break;
            case "My Eligibility":
                clickHereLinks.get(1).click();
                break;
            case "My Documents":
                clickHereLinks.get(2).click();
                break;
            case "My Plans":
                clickHereLinks.get(3).click();
                break;
            default: throw new IllegalArgumentException("Entered Invalid option for clickHere link: " + clickHereOption);
        }

    }

    public void iClickOnMakeChanges(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresent(header, 30);
        WebElement makeChanges;
        if(SharedData.getIsOpenEnrollment().equals("yes")){
            makeChanges = btnApplyForNextYear;
        } else{
            makeChanges = makeChangesButton;
        }
        basicActions.waitForElementToBePresent(makeChanges, 10);
        basicActions.click(makeChanges);
    }


    // ================VALIDATION METHODS================//
    public void verifyLanguageText(String language) {
        switch (language) {
            case "English":
                validateNextStepEnglish();
                break;
            case "Spanish":
                validateNextStepSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateNextStepEnglish() {
        basicActions.waitForElementToBePresent(txtNextStep,10);
        softAssert.assertEquals(txtNextStep.getText(), "Next step: Apply for health insurance");
        softAssert.assertAll();
    }

    public void validateNextStepSpanish() {
        basicActions.waitForElementToBePresent(txtNextStep,10);
        softAssert.assertEquals(txtNextStep.getText(), "Paso siguiente: Solicitar seguro de salud");
        softAssert.assertAll();
    }

    public void setScenarioDetails(List<Map<String, String>> expectedResult) {
        String noOfGroups = expectedResult.get(0).get("totalGroups");
        String totalMembers = expectedResult.get(0).get("totalMembers");
        String totalSubscribers = expectedResult.get(0).get("total_subscribers");
        String totalDependents = expectedResult.get(0).get("total_dependents");
        String totalEnrollees = expectedResult.get(0).get("total_enrollees");
        ScenarioDetails scenarioDetails = new ScenarioDetails();
        scenarioDetails.setTotalGroups(Integer.parseInt(noOfGroups));
        scenarioDetails.setTotalMembers(Integer.parseInt(totalMembers));
        scenarioDetails.setSubscribers(totalSubscribers);
        scenarioDetails.setDependents(totalDependents);
        scenarioDetails.setEnrollees(totalEnrollees);
        SharedData.setScenarioDetails(scenarioDetails);
   }

    public void setDates(String planType, List<Map<String, String>> expectedResult) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        String policyStartDate;
        String policyEndDate;
        String coverageStartDate;
        String coverageEndDate;
        String financialStartDate;
        String financialEndDate;

        if(SharedData.getIsOpenEnrollment().equals("yes")){
            policyStartDate = SharedData.getPlanYear()+"-01-01";
            policyEndDate = SharedData.getPlanYear()+"-12-31";
            coverageStartDate = SharedData.getPlanYear()+"-01-01";
            coverageEndDate = SharedData.getPlanYear()+"-12-31";
            financialStartDate = SharedData.getPlanYear()+"-01-01";
            financialEndDate = SharedData.getPlanYear()+"-12-31";
        } else {
             policyStartDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("PolicyStartDate"));
             policyEndDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("PolicyEndDate"));
             coverageStartDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("CoverageStartDate"));
             coverageEndDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("CoverageEndDate"));
             financialStartDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("FinancialStartDate"));
             financialEndDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("FinancialEndDate"));
        }
       String planStartDate =  basicActions.changeDateFormat(policyStartDate, "yyyy-MM-dd", "MM/dd/yyyy");
       String planEndDate = basicActions.changeDateFormat(policyEndDate, "yyyy-MM-dd", "MM/dd/yyyy");

        switch(planType){
            case "medical":
                ExpectedCalculatedDates expectedCalculatedDates_medical = new ExpectedCalculatedDates();

                expectedCalculatedDates_medical.setPolicyStartDate(policyStartDate);
                expectedCalculatedDates_medical.setPolicyEndDate(policyEndDate);
                expectedCalculatedDates_medical.setCoverageStartDate(coverageStartDate);
                expectedCalculatedDates_medical.setCoverageEndDate(coverageEndDate);
                expectedCalculatedDates_medical.setFinancialStartDate(financialStartDate);
                expectedCalculatedDates_medical.setFinancialEndDate(financialEndDate);

                SharedData.setExpectedCalculatedDates_medicalPlan(expectedCalculatedDates_medical);
                subscriber.setMedicalPlanStartDate(planStartDate);
                subscriber.setMedicalPlanEndDate(planEndDate);
                break;
            case "dental":
                ExpectedCalculatedDates expectedCalculatedDates_dental = new ExpectedCalculatedDates();

                expectedCalculatedDates_dental.setPolicyStartDate(policyStartDate);
                expectedCalculatedDates_dental.setPolicyEndDate(policyEndDate);
                expectedCalculatedDates_dental.setCoverageStartDate(coverageStartDate);
                expectedCalculatedDates_dental.setCoverageEndDate(coverageEndDate);
                expectedCalculatedDates_dental.setFinancialStartDate(financialStartDate);
                expectedCalculatedDates_dental.setFinancialEndDate(financialEndDate);

                SharedData.setExpectedCalculatedDates_dentalPlan(expectedCalculatedDates_dental);
                subscriber.setDentalPlanStartDate(planStartDate);
                subscriber.setDentalPlanEndDate(planEndDate);
                break;
            default: Assert.fail("Invalid argument passed");
        }
        SharedData.setPrimaryMember(subscriber);
    }

    public void validateUsername(String memberName){
    basicActions.waitForElementToBePresent(txtUserName,20);
    softAssert.assertTrue(txtUserName.getText().contains(memberName));
    softAssert.assertAll();
    }

    public void validateText(List<String> textToVerify){
        basicActions.waitForElementToDisappear(spinner,20);
        softAssert.assertEquals(txtHeaderVerifyYourInformation.getText(),textToVerify.get(0));
        softAssert.assertEquals(txtContentVerifyYourInformation.getText(),textToVerify.get(1));
        softAssert.assertEquals(btnVerifyYourInformation.getText(),textToVerify.get(2));
        softAssert.assertEquals(txtHeaderDetails.get(0).getText(),textToVerify.get(3));
        softAssert.assertEquals(txtHeaderDetails.get(1).getText(),textToVerify.get(4));
        softAssert.assertEquals(txtHeaderDetails.get(2).getText(),textToVerify.get(5));
        softAssert.assertEquals(txtHeaderDetails.get(3).getText(),textToVerify.get(6));
        softAssert.assertEquals(txtHeaderDetails.get(4).getText(),textToVerify.get(7));
        softAssert.assertEquals(txtHeaderDetails.get(5).getText(),textToVerify.get(8));
        softAssert.assertEquals(dpdSelectPlanYear.get(0).getText(), LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yyyy")));
        softAssert.assertEquals(dpdSelectPlanYear.get(1).getText(), LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy")));
        softAssert.assertEquals(dpdSelectPlanYear.get(2).getText(), LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yyyy")));
        softAssert.assertEquals(btnOpenClosedToggle.get(0).getText(), textToVerify.get(9));
        softAssert.assertEquals(btnOpenClosedToggle.get(1).getText(), textToVerify.get(10));
        softAssert.assertEquals(txtEnrollmentTextInfo.get(0).getText(), textToVerify.get(11));
        softAssert.assertEquals(txtEnrollmentTextInfo.get(1).getText(), textToVerify.get(12));
        softAssert.assertEquals(txtApplyForVisionCoverage.getText(), textToVerify.get(13));
        softAssert.assertEquals(btnShopForVisionPlans.getText(), textToVerify.get(14));
        softAssert.assertEquals(btnMakeChangesToMyDentalPlan.getText(), textToVerify.get(15));
        softAssert.assertEquals(txtAdditionalResourcesDetails.get(0).getText(), textToVerify.get(16));
        softAssert.assertEquals(txtAdditionalResourcesDetails.get(1).getText(), textToVerify.get(17));
        softAssert.assertEquals(txtAdditionalResourcesDetails.get(2).getText(), textToVerify.get(18));
        softAssert.assertEquals(txtAdditionalResourcesDetails.get(3).getText(), textToVerify.get(19));
        softAssert.assertEquals(txtlinkButton.get(0).getText(), textToVerify.get(20));
        softAssert.assertEquals(txtlinkButton.get(1).getText(), textToVerify.get(21));
        softAssert.assertEquals(txtlinkButton.get(2).getText(), textToVerify.get(22));
        softAssert.assertEquals(txtlinkButton.get(3).getText(), textToVerify.get(23));
        softAssert.assertAll();
    }

    public void clickMyInfoButton() {
        basicActions.waitForElementToBeClickable(btnVerifyYourInformation, 10);
        btnVerifyYourInformation.click();
    }

    public void verifyMyInfoButtonDoesNotExist(){
        softAssert.assertFalse(basicActions.isElementDisplayed(btnVerifyYourInformation, 10));
        softAssert.assertAll();
    }

    public void verifyMemberNames() {
        List<MemberDetails> allMemberList = basicActions.getAllMedicalEligibleMemInfo();
        for (int i = 1; i <= SharedData.getScenarioDetails().getTotalGroups() + SharedData.getScenarioDetails().getTotalGroups(); i++) {

            List<String> expectedMemberNames = new ArrayList<>();
            List<String> actualMemberNames = new ArrayList<>();

            List<WebElement> getactualMemberNames = basicActions.getDriver().findElements(By.cssSelector(".table-bordered tr:nth-child(" + i + ") td:nth-child(2) span b"));
            String expectedMedGroupInd = null;

            for (WebElement member : getactualMemberNames) {
                actualMemberNames.add(member.getText());
            }

            for(String actualMemName : actualMemberNames ) {
                for (MemberDetails member : allMemberList) {
                    if (member.getSignature().equals(actualMemName)) {

                        if (expectedMedGroupInd == null) {
                            expectedMedGroupInd = member.getMedGroupInd();
                        }
                        //Assert that this member belongs to the same MedGroupInd as the first member
                        softAssert.assertTrue(member.getMedGroupInd().equals(expectedMedGroupInd),"Member Medical Group :"+member.getMedGroupInd()+" does not match to another member Medical Group : "+expectedMedGroupInd);
                        expectedMemberNames.add(member.getSignature());

                        verifyPlanInfo(member);
                    }
                }
            }
            softAssert.assertTrue(actualMemberNames.containsAll(expectedMemberNames) && expectedMemberNames.containsAll(actualMemberNames) && actualMemberNames.size() == expectedMemberNames.size(), "Member names do not match.");
        }
        softAssert.assertAll();
    }

    private void verifyPlanInfo(MemberDetails memberInfo) {
        //Medical Plan Validation
        WebElement MedicalPlanName = basicActions.getDriver().findElement(By.xpath("(//b[contains(text(),'" + memberInfo.getFirstName() + "')]/ancestor-or-self::tr)[1]/td[4]/b"));
        WebElement MedicalPremiumAmnt = basicActions.getDriver().findElement(By.xpath("(//b[contains(text(),'" + memberInfo.getFirstName() + "')]/ancestor-or-self::tr)[1]/td[5]/b"));
        WebElement MedicalAPTCAmnt = basicActions.getDriver().findElement(By.xpath("(//b[contains(text(),'" + memberInfo.getFirstName() + "')]/ancestor-or-self::tr)[1]/td[6]/b"));

        softAssert.assertEquals(MedicalPlanName.getText(), memberInfo.getMedicalPlan(), memberInfo.getFirstName() + " Medical Plan Name does not match");
        softAssert.assertEquals(MedicalPremiumAmnt.getText().replace(",", ""), "$" + memberInfo.getMedicalPremiumAmt(), memberInfo.getFirstName() + " Medical premium amount does not match");
        softAssert.assertEquals(MedicalAPTCAmnt.getText().replace(",", ""), "$" + memberInfo.getMedicalAptcAmt(), memberInfo.getFirstName() + " Medical APTC amount did not match");

        //Dental Plan Validation
        WebElement DentalPlanName = basicActions.getDriver().findElement(By.xpath("(//b[contains(text(),'" + memberInfo.getFirstName() + "')]/ancestor-or-self::tr)[2]/td[4]/b"));
        WebElement DentalPremiumAmnt = basicActions.getDriver().findElement(By.xpath("(//b[contains(text(),'" + memberInfo.getFirstName() + "')]/ancestor-or-self::tr)[2]/td[5]/b"));
        WebElement DentalAPTCAmnt = basicActions.getDriver().findElement(By.xpath("(//b[contains(text(),'" + memberInfo.getFirstName() + "')]/ancestor-or-self::tr)[2]/td[6]/b"));

        //Dental
        softAssert.assertEquals(DentalPlanName.getText(), memberInfo.getDentalPlan(), memberInfo.getFirstName() + " Dental Plan Name does not match");
        softAssert.assertEquals(DentalPremiumAmnt.getText(), "$" + basicActions.doubleAmountFormat(memberInfo.getDentalPremiumAmt()), memberInfo.getFirstName() + " Dental Premium amount does not match");
        softAssert.assertEquals(DentalAPTCAmnt.getText(), "$" + "0", memberInfo.getFirstName() + " Dental APTC amount on account overview page mismatch");

        softAssert.assertAll();
    }
    public void verifySelfAttestationContainer(){
        basicActions.waitForElementToDisappear(spinner,20);
        softAssert.assertEquals(txtHeaderVerifyYourInformation.getText(),"We need you to verify your information");
        softAssert.assertEquals(txtContentVerifyYourInformation.getText(),"We attempted to verify your application information but need you to confirm a few things. Don't worry, it will only take a minute or two!");
        softAssert.assertEquals(btnVerifyYourInformation.getText(),"Verify My Information");

    }
}
