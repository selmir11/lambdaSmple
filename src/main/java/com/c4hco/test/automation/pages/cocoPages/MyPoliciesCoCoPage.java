package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class MyPoliciesCoCoPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public MyPoliciesCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SOL-CurrentPolicies-EnrolledMemberInfo")
    List<WebElement> memberNames;  // Gives names of all members - both medical and dental

    @FindBy(css = ".current-policy .current-policy-container")
    List<WebElement> cardsList;

    @FindBy(css = "span#SOL-CurrentPolicies-PolicyStartDateCoverage")
    WebElement planStartDate;
    @FindBy(css = "span#SOL-CurrentPolicies-PolicyEndDateCoverage")
    WebElement planEndDate;
    @FindBy(css = "span#SOL-CurrentPolicies-.c4-type-header-sm.current-future__policy-name")
    WebElement planNames; // Both medical and dental plan names for all members
    @FindBy(css="#SOL-CurrentPolicies-.current-future__policy-name")
    WebElement planNameOnFuturePlans;
    @FindBy(id = "viewPlanHistoryLink_0")
    WebElement viewPlanHistoryLinkMedical; // To DO:: Update the locators in this file
    @FindBy(id = "viewPlanHistoryLink_1")
    WebElement viewPlanHistoryLinkDental; // Update locator - will only work when we have 1medical, 1dental and 1 memeber

    @FindBy(css = "app-plan-details .container .header-2")
    WebElement planHistoryTitle;

    @FindBy(css = "table .body-text-1")
    List<WebElement> tableRecord; // TO DO:: Check if this works with multiple members and multiple groups

    @FindBy(id="backToCurrentPlanDetailsButton")
    WebElement backToCurPlansBtn;

    @FindBy(xpath = "//div[@id='SOL-CurrentPolicies-NoAppliedSubsidy']/child::span")
    List<WebElement> premiumAmt;
    @FindBy(css="#SOL-CurrentPolicies-NoAppliedSubsidy span")
    List<WebElement> futurePlansPremiumAmt;

    @FindBy(xpath = "//div[contains(./span, 'Exchange Policy Number:')]/following-sibling::div/span")
    List<WebElement> EAPID; //exchange policy number for both medical and dental

    @FindBy(css=".amount-row span")
    List<WebElement> financialPremiumData; // financial stat date, premium after help

    @FindBy(css = "div#SOL-CurrentPolicies-PolicyNumberCOCO")
    WebElement policyNumSubscriber; // policy num, subscriber, updated On for both medical and dental plans

    @FindBy(css = "span#SOL-MyPolicies-subscriberName")
    WebElement subscriberName;
    @FindBy(xpath = "//div[@id='SOL-CurrentPolicies-LastUpdated']/span")
    WebElement lastUpdatedOn;
    @FindBy(css = "#SOL-CurrentPolicies-LastUpdated span")
    List<WebElement> lastUpdatedOnFuturePlans;
    @FindBy(css = "span#SOL-CurrentPolicies-PolicySubmittedDate")
    WebElement lastUpdatedDate;
    @FindBy(id="SOL-CurrentPolicies-CancelCurrentMedical")
    WebElement cancelMedicalPlanbtnCoCo;

    @FindBy(id="SOL-CurrentPolicies-FuturePlans")
    WebElement FuturePlans;

    @FindBy(id="SOL-CurrentPolicies-CurrentPlans")
    WebElement CurrentPlans;


    @FindBy(css ="table tr:nth-child(2) p")
    List<WebElement> planhistoryNames;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;
    String lastUpdated = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    MemberDetails primaryMember = SharedData.getPrimaryMember();
    Set<String> allMemberNames = new HashSet<>();

    Set<String> namesFromUI = new HashSet<>();

    public void validateEnrolledPlanDetails() {
        DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
        // Validating Names
        basicActions.waitForElementListToBePresent(memberNames, 40);
        allMemberNames = new HashSet<>(basicActions.getAllMemNames());
        Set<String> namesFromUi = new HashSet<>(Arrays.asList(memberNames.get(0).getText().replace(" and ", ", ").split(", ")));
        softAssert.assertTrue(allMemberNames.equals(namesFromUi));

        softAssert.assertEquals(planStartDate.getText().split(" ")[0], basicActions.changeDateFormat(primaryMember.getMedicalPlanStartDate(), "MM/dd/yyyy", "MM/dd/yy"), "medical plan date did not match");
        softAssert.assertEquals(planEndDate.getText(), basicActions.changeDateFormat(primaryMember.getMedicalPlanEndDate(), "MM/dd/yyyy", "MM/dd/yy"), "medical plan end date did not match");
        softAssert.assertEquals(planNames.getText(), primaryMember.getMedicalPlan(), "medical plan name did not match");
        softAssert.assertEquals(premiumAmt.get(0).getText().split(" ")[0], "$" + primaryMember.getMedicalPremiumAmt(), "medical premium did not match");

        Map<String, String> medEapidDb = exchDbDataProvider.getMedicalEap_id();
        primaryMember.setMedicalEapid_db(medEapidDb.get(primaryMember.getMedGroupInd()));
        softAssert.assertEquals(medEapidDb.get(primaryMember.getMedGroupInd()),policyNumSubscriber.getText().replace("Exchange policy number: ",""), "Medical EAP_ID from My Policies page does not match EAP_ID plan summary page");
        softAssert.assertTrue(lastUpdatedOn.getText().equals("Last updated:"));
        softAssert.assertEquals(lastUpdatedDate.getText(),basicActions.changeDateFormat(lastUpdated, "MM/dd/yyyy", "MM/dd/yy"), "Last Updated Date did not match");

        //Validating Total Premium without SES
        String totalAmtAfterZeroFinancialHelp = primaryMember.getMedicalPremiumAmt();
        String premiumWithoutSes = premiumAmt.get(0).getText();
        softAssert.assertEquals(premiumWithoutSes, "$"+totalAmtAfterZeroFinancialHelp+" /month", "Total Premium amount does not match");
        softAssert.assertAll();
    }
    public void validatePlanDetailsOnFuturePlans(){
        DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
        // Validating Names
        basicActions.waitForElementListToBePresent(memberNames, 40);
        allMemberNames = new HashSet<>(basicActions.getAllMemNames());
        Set<String> namesFromUi = new HashSet<>(Arrays.asList(memberNames.get(0).getText().replace(" and ", ", ").split(", ")));
        softAssert.assertTrue(allMemberNames.equals(namesFromUi));

        softAssert.assertEquals(planStartDate.getText().split(" ")[0], basicActions.changeDateFormat(primaryMember.getMedicalPlanStartDate(), "MM/dd/yyyy", "MM/dd/yy"), "medical plan date did not match");
        softAssert.assertEquals(planEndDate.getText(), basicActions.changeDateFormat(primaryMember.getMedicalPlanEndDate(), "MM/dd/yyyy", "MM/dd/yy"), "medical plan end date did not match");
        softAssert.assertEquals(planNameOnFuturePlans.getText(), primaryMember.getMedicalPlan(), "medical plan name did not match");
        softAssert.assertEquals(futurePlansPremiumAmt.get(0).getText().split(" ")[0], "$" + primaryMember.getMedicalPremiumAmt(), "medical premium did not match");

        Map<String, String> medEapidDb = exchDbDataProvider.getMedicalEap_id();
        primaryMember.setMedicalEapid_db(medEapidDb.get(primaryMember.getMedGroupInd()));
        softAssert.assertEquals(medEapidDb.get(primaryMember.getMedGroupInd()),policyNumSubscriber.getText().replace("Exchange policy number: ",""), "Medical EAP_ID from My Policies page does not match EAP_ID plan summary page");
        softAssert.assertTrue(lastUpdatedOnFuturePlans.get(0).getText().equals("Last updated:"),"Last Updated text mismatch");
        softAssert.assertEquals(lastUpdatedOnFuturePlans.get(1).getText(),basicActions.changeDateFormat(lastUpdated, "MM/dd/yyyy", "MM/dd/yy"), "Last Updated Date did not match");

        //Validating Total Premium without SES
        String totalAmtAfterZeroFinancialHelp = primaryMember.getMedicalPremiumAmt();
        String premiumWithoutSes = futurePlansPremiumAmt.get(0).getText();
        softAssert.assertEquals(premiumWithoutSes, "$"+totalAmtAfterZeroFinancialHelp+" /month", "Total Premium amount does not match");
        softAssert.assertAll();
    }
    public void clickViewPlanHistoryLink(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkMedical, 10);
        viewPlanHistoryLinkMedical.click();
    }
    public void validateMedPlanDetailsFromPlanHistoryCoco(){
        basicActions.waitForElementToBePresent(planHistoryTitle, 10);
        basicActions.waitForElementListToBePresent(tableRecord, 10);
        basicActions.waitForElementListToBePresent(memberNames, 10);
        allMemberNames = new HashSet<>(basicActions.getAllMemNames());
        namesFromUI = new HashSet<>(memberNames.stream().map(WebElement::getText).collect(Collectors.toList()));
        softAssert.assertTrue(tableRecord.get(1).getText().equals(primaryMember.getMedicalPlan()), "Medical plan mismatch");
        String  ses = SharedData.getSes();
        String openEnrolment = SharedData.getIsOpenEnrollment();
        if(ses.equals("yes") && openEnrolment.equals("yes")){
            softAssert.assertTrue(tableRecord.get(2).getText().equals("$" + "0.00"), "Medical amount mismatch");
            softAssert.assertTrue(tableRecord.get(3).getText().equals("$" + primaryMember.getMedicalPremiumAmt()), "Medical amount mismatch");
        }else {
            softAssert.assertTrue(tableRecord.get(2).getText().equals("$" + primaryMember.getMedicalPremiumAmt()), "Medical amount mismatch");
            softAssert.assertTrue(tableRecord.get(3).getText().equals("$" + "0.00"), "Medical amount mismatch");
        }
        softAssert.assertTrue(tableRecord.get(4).getText().equals(primaryMember.getMedicalPlanStartDate()), "plan start date mismatch");
        softAssert.assertTrue(tableRecord.get(5).getText().equals(primaryMember.getMedicalPlanEndDate()), "plan end date mismatch");
        softAssert.assertAll();
    }

    public void clickFuturePlansCoCo(){
        basicActions.waitForElementToBePresent(FuturePlans, 10);
        FuturePlans.click();
    }

    public void clickCurrentPlansCoCo(){
        basicActions.waitForElementToBePresent(CurrentPlans, 10);
        CurrentPlans.click();
    }

    public void cancelMedicalPlanbtnCoCo(){
        basicActions.waitForElementToBePresent(cancelMedicalPlanbtnCoCo, 10);
        cancelMedicalPlanbtnCoCo.click();
    }

}
