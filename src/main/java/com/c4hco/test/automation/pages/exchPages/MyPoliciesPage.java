package com.c4hco.test.automation.pages.exchPages;

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
import java.util.List;

public class MyPoliciesPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public MyPoliciesPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".current-policy .txt-name")
    List<WebElement> memberNames;  // Gives names of all members - both medical and dental

    @FindBy(css = ".current-policy .current-policy-container")
    List<WebElement> cardsList;

    @FindBy(css = ".current-policy-data .pDate span:nth-child(2)")
    List<WebElement> planStartAndEndDate; // update this locator - split and have one for plan start date and one for plan end date

    @FindBy(css = ".current-policy-container .header-3")
    List<WebElement> planNames; // Both medical and dental plan names for all members

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

    @FindBy(xpath = "//span[contains(., 'Monthly Premium')]/following-sibling::span")
    List<WebElement> premiumAmt;

    @FindBy(xpath = "//div[contains(./span, 'Exchange Policy Number:')]/following-sibling::div/span")
    List<WebElement> EAPID; //exchange policy number for both medical and dental

    @FindBy(css=".amount-row span")
    List<WebElement> financialPremiumData; // financial stat date, premium after help

    @FindBy(css = ".current-policy div:nth-child(4) .txt-left span")
    List<WebElement> policyNumSubscriber; // policy num, subscriber, updated On for both medical and dental plans

    @FindBy(id="Cancel 2024 Medical PlansButton")
    WebElement cancelMedicalPlanbtn;

    @FindBy(id="Cancel 2024 Dental Plans Button")
    WebElement cancelDentalPlanbtn;
    @FindBy(css ="table tr:nth-child(2) td")
    List<WebElement> planhistoryNames;

    String lastUpdated = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")); // TO DO:: Move this to Shared Data?

    MemberDetails primaryMember = SharedData.getPrimaryMember();
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();

    public void validateEnrolledMedicalPlanDetails(String startDate, String endDate) {
        String policyBgnDt = basicActions.getDateBasedOnRequirement(startDate);
        String policyEndDt = basicActions.getDateBasedOnRequirement(endDate);
        policyBgnDt=  basicActions.changeDateFormat(policyBgnDt, "yyyy-MM-dd", "MM/dd/yyyy");
        policyEndDt = basicActions.changeDateFormat(policyEndDt, "yyyy-MM-dd", "MM/dd/yyyy");
        // **** Works when only one member with one medical plan **** //
        primaryMember.setMedicalPlanStartDate(policyBgnDt);
        primaryMember.setMedicalPlanEndDate(policyEndDt);
        primaryMember.setMedicalFinancialStartDate(policyBgnDt);
        primaryMember.setMedicalFinancialEndDate(policyEndDt);
        SharedData.setPrimaryMember(primaryMember);
        //Validating member names from table - medical
        basicActions.waitForElementListToBePresent(memberNames, 10);
        List<MemberDetails> memberDetailsList = SharedData.getMembers();
        MemberDetails subscriber = SharedData.getPrimaryMember();
        String[] medMemnames = memberNames.get(0).getText().split("\\s*(,|and)\\s*");
        for (String memName : medMemnames) {
            String memFirstLastName = memName.trim();
            String[] memFullNames = memFirstLastName.split(" ");
            String memFirstName = memFullNames[0];
            String memLastName = memFullNames[memFullNames.length - 1];
            if (subscriber.getFirstName().equals(memFirstName) && subscriber.getLastName().equals(memLastName)) {
                softAssert.assertEquals(memFirstName+" "+memLastName, primaryMember.getSignature(),"Primary member name from current medical plans does not match-my policies page");
            }else if (memberDetailsList !=null) {
                for (int i = 0; i < memberDetailsList.size(); i++) {
                    MemberDetails member = SharedData.getMembers().get(i);
                    member.setMedicalPlanStartDate(policyBgnDt);
                    member.setMedicalPlanEndDate(policyEndDt);
                    member.setMedicalFinancialStartDate(policyBgnDt);
                    member.setMedicalFinancialEndDate(policyEndDt);
                    softAssert.assertEquals(memFirstName+" "+memLastName, member.getSignature(), "Member names from current medical plans does not match- my policies page");
                }
            }
        }
        softAssert.assertEquals(planStartAndEndDate.get(0).getText(), primaryMember.getMedicalPlanStartDate(), "medical plan date did not match");
        softAssert.assertEquals(planStartAndEndDate.get(1).getText(), primaryMember.getMedicalPlanEndDate(), "medical plan end date did not match");
        softAssert.assertEquals(planNames.get(0).getText(), primaryMember.getMedicalPlan(), "medical plan name did not match");
        softAssert.assertEquals(premiumAmt.get(0).getText(), "$"+primaryMember.getMedicalPremiumAmt(), "medical premium did not match");
        softAssert.assertTrue(policyNumSubscriber.get(2).getText().equals("Subscriber:"));
        softAssert.assertEquals(policyNumSubscriber.get(3).getText(), primaryMember.getSignature(), "Subscriber Name did not match on medical card");
        softAssert.assertTrue(policyNumSubscriber.get(4).getText().equals("Last Updated On:"));
        softAssert.assertEquals(policyNumSubscriber.get(5).getText(), lastUpdated, "Last Updated Date did not match");
        softAssert.assertEquals(financialPremiumData.get(0).getText(), "Applicable From: "+primaryMember.getMedicalFinancialStartDate(), "medical financial start date did not match");
        softAssert.assertEquals(financialPremiumData.get(3).getText(), "After $"+primaryMember.getMedicalAptcAmt()+" Financial Help", "financial help amount did not match");
        softAssert.assertTrue(policyNumSubscriber.get(0).getText().equals("Exchange Policy Number:"));

        //Validating medical EAP_ID
        exchDbDataProvider.getEap_id();
        basicActions.waitForElementListToBePresent(policyNumSubscriber, 10);
        softAssert.assertEquals(primaryMember.getMedicalEapid_db(),policyNumSubscriber.get(1).getText(), "Medical EAP_ID from My Policies page does not match EAP_ID plan summary page");


        //Validating Total Premium after APTC amount reduction
        String totalAmtAfterReduction = primaryMember.getTotalMedAmtAfterReduction();
        String premiumAfterAPTC = financialPremiumData.get(5).getText();
        softAssert.assertEquals(premiumAfterAPTC, "$"+totalAmtAfterReduction+"/mo", "Total Premium amount after APTC reduction does not match from UI and DB");
        softAssert.assertAll();
    }

    public void validateDentalPlanDetails( String startDate,String endDate){
        String polBeginDate = basicActions.getDateBasedOnRequirement(startDate);
        String polEndDate = basicActions.getDateBasedOnRequirement(endDate);
        polBeginDate=  basicActions.changeDateFormat(polBeginDate, "yyyy-MM-dd", "MM/dd/yyyy");
        polEndDate = basicActions.changeDateFormat(polEndDate, "yyyy-MM-dd", "MM/dd/yyyy");
        // **** Works when only one member with one medical plan and one dental plan **** //
        primaryMember.setDentalPlanStartDate(polBeginDate);
        primaryMember.setDentalPlanEndDate(polEndDate);
        primaryMember.setDentalFinancialStartDate(polBeginDate);
        primaryMember.setDentalFinancialEndDate(polEndDate);
        SharedData.setPrimaryMember(primaryMember);
        List<MemberDetails> memberDetailsList = SharedData.getMembers();
        if (memberDetailsList !=null) {
            for (int i = 0; i < memberDetailsList.size(); i++) {
                MemberDetails member = SharedData.getMembers().get(i);
                member.setDentalPlanStartDate(polBeginDate);
                member.setDentalPlanEndDate(polEndDate);
                member.setDentalFinancialStartDate(polBeginDate);
                member.setDentalFinancialEndDate(polEndDate);
            }
        }

        basicActions.waitForElementListToBePresent(memberNames, 10);
        //softAssert.assertEquals(memberNames.get(1).getText(), primaryMember.getSignature(), "member name on dental card did not match");
        softAssert.assertEquals(planNames.get(1).getText(), primaryMember.getDentalPlan() ,
                "dental plan name did not match. Actual on page::"+planNames.get(1).getText()+"::Expected::"+primaryMember.getDentalPlan());
        softAssert.assertEquals(planStartAndEndDate.get(2).getText(), primaryMember.getDentalPlanStartDate(), "Dental start date didn't match");
        softAssert.assertEquals(planStartAndEndDate.get(3).getText(), primaryMember.getDentalPlanEndDate(), "Dental end date didnt match");
        softAssert.assertEquals(premiumAmt.get(1).getText().replace("$",""), primaryMember.getDentalPremiumAmt().replace("$", ""), "Dental premium did not match");
        softAssert.assertTrue(policyNumSubscriber.get(6).getText().equals("Exchange Policy Number:"));
        softAssert.assertEquals(policyNumSubscriber.get(7).getText(), primaryMember.getDentalEapid_db(), "Dental EAPID mismatch");
        softAssert.assertTrue(policyNumSubscriber.get(8).getText().equals("Subscriber:"));
        softAssert.assertEquals(policyNumSubscriber.get(9).getText(), primaryMember.getSignature(),"Subscriber name mismatch");
        softAssert.assertTrue(policyNumSubscriber.get(10).getText().equals("Last Updated On:"));
        softAssert.assertEquals(policyNumSubscriber.get(11).getText(), lastUpdated, "Last updated date on dental tile does not match");

        String totalDenPremAmtAfterTrim = null;
        //Validating dental EAP_ID
        basicActions.waitForElementListToBePresent(policyNumSubscriber, 10);
        softAssert.assertEquals(primaryMember.getDentalEapid_db(),policyNumSubscriber.get(7).getText(), "Dental EAP_ID from My Policies page does not match with EAP_ID from DB");

        if(primaryMember.getDentalAptcAmt().equals("$0")){
            String dentalPremiumAmt = primaryMember.getDentalPremiumAmt();
            totalDenPremAmtAfterTrim = dentalPremiumAmt.replace("$", "");
        } else{
            // TO DO:: Add more when needed
        }

        String dentalPremAfterAPTC = financialPremiumData.get(11).getText();
        primaryMember.setTotalDentalPremAfterReduction(dentalPremAfterAPTC);
        SharedData.setPrimaryMember(primaryMember);

        String dentalPremiumFromSharedData = primaryMember.getDentalPremiumAmt();
        softAssert.assertEquals(dentalPremAfterAPTC, dentalPremiumFromSharedData+"/mo", "Total dental Premium amount after APTC reduction does not match from UI and DB");
        softAssert.assertAll();
    }

    public void clickViewPlanHistoryFromMed(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkMedical, 10);
        viewPlanHistoryLinkMedical.click();
    }

    public void validateMedPlanDetailsFromPlanHistory(){
        basicActions.waitForElementToBePresent(planHistoryTitle, 10);
        basicActions.waitForElementListToBePresent(tableRecord, 10);
        List<MemberDetails> memberDetailsList = SharedData.getMembers();
        MemberDetails subscriber = SharedData.getPrimaryMember();

        softAssert.assertTrue(tableRecord.get(0).getText().equals(primaryMember.getSignature()));
        softAssert.assertTrue(tableRecord.get(1).getText().equals(primaryMember.getMedicalPlan()));
        softAssert.assertTrue(tableRecord.get(2).getText().equals("$"+primaryMember.getTotalMedAmtAfterReduction()));
        if(primaryMember.getMedicalAptcAmt().equals("0")){
            softAssert.assertTrue(tableRecord.get(3).getText().equals("$"+primaryMember.getMedicalAptcAmt()+".00"));
        }else {
            softAssert.assertTrue(tableRecord.get(3).getText().equals("$" + primaryMember.getMedicalAptcAmt()));
        }
        softAssert.assertTrue(tableRecord.get(4).getText().equals(primaryMember.getMedicalPlanStartDate()));
        softAssert.assertTrue(tableRecord.get(5).getText().equals(primaryMember.getMedicalPlanEndDate()));
        softAssert.assertAll();
    }

    public void clickViewPlanHistoryFromDental(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkDental, 10);
        viewPlanHistoryLinkDental.click();
    }

    public void validateDentalPlanDetailsFromPlanHistory(){
        basicActions.waitForElementToBePresent(planHistoryTitle, 10);
        basicActions.waitForElementListToBePresent(tableRecord, 10);
        List<MemberDetails> memberDetailsList = SharedData.getMembers();
        MemberDetails subscriber = SharedData.getPrimaryMember();
        softAssert.assertTrue(tableRecord.get(0).getText().equals(primaryMember.getSignature()));
        softAssert.assertEquals(tableRecord.get(1).getText(), primaryMember.getDentalPlan(), "Dental plan did not match");
        softAssert.assertEquals(tableRecord.get(2).getText().replace("$",""), primaryMember.getDentalPremiumAmt().replace("$",""), "Dental premium did not match" );
        softAssert.assertTrue(tableRecord.get(3).getText().equals(primaryMember.getDentalAptcAmt()+".00")); //  financial help
        softAssert.assertEquals(tableRecord.get(4).getText(), primaryMember.getDentalPlanStartDate(), "dental plan start date did not match");
        softAssert.assertEquals(tableRecord.get(5).getText(), primaryMember.getDentalPlanEndDate(), "dental plan end date did not match");
        softAssert.assertAll();
    }

    public void clickBackButton(){
        basicActions.waitForElementToBePresent(backToCurPlansBtn, 10);
        backToCurPlansBtn.click();
    }

    public void clickPlanCancelButton(String btnDetail){
        switch (btnDetail) {
            case ("Cancel Medical Plan"):
                basicActions.waitForElementToBePresent(cancelMedicalPlanbtn, 10);
                cancelMedicalPlanbtn.click();
            break;
            case ("Cancel Dental Plan"):
                basicActions.waitForElementToBePresent(cancelDentalPlanbtn, 10);
                cancelDentalPlanbtn.click();
            break;
            default:
            throw new IllegalArgumentException("Invalid option: " + btnDetail);
        }

    }

    public void validateMedPolicyFinancialStartDate(String expectedStartDate){
        //Medical - start date is first of next month
            iSetMedicalPlanDates();
        switch (expectedStartDate) {
            case "First Of Next Month":
                medValidationsBasedOnFirstNextMonth();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + expectedStartDate);
        }
    }
    public void validateDentPolicyFinancialStartDate(String expectedStartDate){
        //Dental - start date is first of next month
            iSetDentalPlanDates();
        switch (expectedStartDate) {
            case "First Of Next Month":
                denValidationsBasedOnFirstNextMonth();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + expectedStartDate);
        }
    }
    public String firstDateOfNextMonth(){
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfNextMonth = today.plusMonths(1).withDayOfMonth(1);
        // Format the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedStartDate = firstDayOfNextMonth.format(formatter);
        return formattedStartDate;
    }

    public void iSetMedicalPlanDates(){
        //EnrInitial sinple NFA application- my policies page validations
        primaryMember.setMedicalPlanStartDate(firstDateOfNextMonth());
        primaryMember.setMedicalPlanEndDate("12/31/2024");
        primaryMember.setMedicalFinancialStartDate(firstDateOfNextMonth());
        primaryMember.setMedicalFinancialEndDate("12/31/2024");
        SharedData.setPrimaryMember(primaryMember);
    }
    public void iSetDentalPlanDates(){
        //EnrInitial sinple NFA application- my policies page validations
        primaryMember.setDentalPlanStartDate(firstDateOfNextMonth());
        primaryMember.setDentalPlanEndDate("12/31/2024");
        primaryMember.setDentalFinancialStartDate(firstDateOfNextMonth());
        primaryMember.setDentalFinancialEndDate("12/31/2024");
        SharedData.setPrimaryMember(primaryMember);
    }

    public void medValidationsBasedOnFirstNextMonth(){//for single member- my policies page
        String[] medMemnames = memberNames.get(0).getText().split("\\s*(,|and)\\s*");
        for (String memName : medMemnames) {
            String memFirstLastName = memName.trim();
            String[] memFullNames = memFirstLastName.split(" ");
            String memFirstName = memFullNames[0];
            String memLastName = memFullNames[memFullNames.length - 1];
            softAssert.assertEquals(memFirstName + " " + memLastName, primaryMember.getSignature(), "Primary member name from current medical plans does not match-my policies page");
        }
        softAssert.assertEquals(planStartAndEndDate.get(0).getText(), primaryMember.getMedicalPlanStartDate(), "medical plan start date did not match");
        softAssert.assertEquals(planStartAndEndDate.get(1).getText(), primaryMember.getMedicalPlanEndDate(), "medical plan end date did not match");
        softAssert.assertEquals(planNames.get(0).getText(), primaryMember.getMedicalPlan(), "medical plan name did not match");
        softAssert.assertEquals(premiumAmt.get(0).getText(), "$"+primaryMember.getMedicalPremiumAmt(), "medical premium did not match");
        softAssert.assertTrue(policyNumSubscriber.get(2).getText().equals("Subscriber:"));
        softAssert.assertEquals(policyNumSubscriber.get(3).getText(), primaryMember.getSignature(), "Subscriber Name did not match on medical card");
        softAssert.assertTrue(policyNumSubscriber.get(4).getText().equals("Last Updated On:"));
        softAssert.assertEquals(policyNumSubscriber.get(5).getText(), lastUpdated, "Last Updated Date did not match");
        softAssert.assertEquals(financialPremiumData.get(0).getText(), "Applicable From: "+primaryMember.getMedicalFinancialStartDate(), "medical applicable from date did not match");
        softAssert.assertEquals(financialPremiumData.get(3).getText(), "After $"+primaryMember.getMedicalAptcAmt()+" Financial Help", "financial help amount did not match");
        softAssert.assertTrue(policyNumSubscriber.get(0).getText().equals("Exchange Policy Number:"));

        //Validating medical EAP_ID
        exchDbDataProvider.getEap_id();
        basicActions.waitForElementListToBePresent(policyNumSubscriber, 10);
        softAssert.assertEquals(primaryMember.getMedicalEapid_db(),policyNumSubscriber.get(1).getText(), "Medical EAP_ID from My Policies page does not match EAP_ID plan summary page");
        //Validating Total Premium after APTC amount reduction
        String totalAmtAfterReduction = primaryMember.getTotalMedAmtAfterReduction();
        String premiumAfterAPTC = financialPremiumData.get(5).getText();
        softAssert.assertEquals(premiumAfterAPTC, "$"+totalAmtAfterReduction+"/mo", "Total Premium amount after APTC reduction does not match from UI and DB");
        softAssert.assertAll();
    }

    public void denValidationsBasedOnFirstNextMonth(){ //for single member- my policies page
        basicActions.waitForElementListToBePresent(memberNames, 10);
        softAssert.assertEquals(planNames.get(1).getText(), primaryMember.getDentalPlan() ,
                "dental plan name did not match. Actual on page::"+planNames.get(1).getText()+"::Expected::"+primaryMember.getDentalPlan());
        softAssert.assertEquals(planStartAndEndDate.get(2).getText(), primaryMember.getDentalPlanStartDate(), "Dental plan start date didn't match");
        softAssert.assertEquals(planStartAndEndDate.get(3).getText(), primaryMember.getDentalPlanEndDate(), "Dental plan end date didnt match");

        softAssert.assertEquals(premiumAmt.get(1).getText(), primaryMember.getDentalPremiumAmt(), "Dental premium did not match");
        softAssert.assertTrue(policyNumSubscriber.get(6).getText().equals("Exchange Policy Number:"));
        softAssert.assertEquals(policyNumSubscriber.get(7).getText(), primaryMember.getDentalEapid_db(), "Eapid mismatch on dental tile");
        softAssert.assertTrue(policyNumSubscriber.get(8).getText().equals("Subscriber:"));
        softAssert.assertEquals(policyNumSubscriber.get(9).getText(),primaryMember.getSignature(), "Subscriber name mismatch on Dental tile");
        softAssert.assertTrue(policyNumSubscriber.get(10).getText().equals("Last Updated On:"));
        softAssert.assertEquals(policyNumSubscriber.get(11).getText(), lastUpdated, "Last updated on date mismatch on dental tile");
        softAssert.assertEquals(financialPremiumData.get(6).getText(), "Applicable From: "+primaryMember.getDentalFinancialStartDate(), "Dental applicable from date did not match");

        String totalDenPremAmtAfterTrim = null;
        //Validating dental EAP_ID
        basicActions.waitForElementListToBePresent(policyNumSubscriber, 10);
        softAssert.assertEquals(primaryMember.getDentalEapid_db(),policyNumSubscriber.get(7).getText(), "Dental EAP_ID from My Policies page does not match with EAP_ID from DB");

        if(primaryMember.getDentalAptcAmt().equals("$0")){
            String dentalPremiumAmt = primaryMember.getDentalPremiumAmt();
            totalDenPremAmtAfterTrim = dentalPremiumAmt.replace("$", "");
            softAssert.assertEquals(totalDenPremAmtAfterTrim, dentalPremiumAmt.replace("$",""), "Dental premium amount does not match");
        } else{
            // TO DO:: Add more when needed
        }

        String dentalPremAfterAPTC = financialPremiumData.get(11).getText();
        primaryMember.setTotalDentalPremAfterReduction(dentalPremAfterAPTC);
        SharedData.setPrimaryMember(primaryMember);

        String dentalPremiumFromSharedData = primaryMember.getDentalPremiumAmt();
        softAssert.assertEquals(dentalPremAfterAPTC, dentalPremiumFromSharedData+"/mo", "Total dental Premium amount after APTC reduction does not match from UI and DB");
        softAssert.assertAll();
    }


}
