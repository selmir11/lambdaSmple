package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
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
import java.util.Map;

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

    @FindBy(id="Cancel 2024 Dental Plans")
    WebElement cancelDentalPlanbtn;

    String lastUpdated = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")); // TO DO:: Move this to Shared Data?

    MemberDetails primaryMember = SharedData.getPrimaryMember();
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();

    public void validateEnrolledMedicalPlanDetails(List<Map<String, String>> expectedResult){
        // **** Works when only one member with one medical plan **** //
        primaryMember.setMedicalPlanStartDate(expectedResult.get(0).get("PolicyStartDate"));
        primaryMember.setMedicalPlanEndDate(expectedResult.get(0).get("PolicyEndDate"));
        primaryMember.setMedicalFinancialStartDate(expectedResult.get(0).get("FinancialStartDate"));
        primaryMember.setMedicalFinancialEndDate(expectedResult.get(0).get("FinancialEndDate"));
        SharedData.setPrimaryMember(primaryMember);

        basicActions.waitForElementListToBePresent(memberNames, 10);
        softAssert.assertEquals(memberNames.get(0).getText(), primaryMember.getSignature(), "Enrolled Member did not match on medical card");
        softAssert.assertEquals(planStartAndEndDate.get(0).getText(), primaryMember.getMedicalPlanStartDate(), "medical plan date did not match");
        softAssert.assertEquals(planStartAndEndDate.get(1).getText(), primaryMember.getMedicalPlanEndDate(), "medical plan end date did not match");
        softAssert.assertEquals(planNames.get(0).getText(), primaryMember.getMedicalPlan(), "medical plan name did not match");
        softAssert.assertEquals(premiumAmt.get(0).getText(), primaryMember.getMedicalPremiumAmt(), "medical premium did not match");
        softAssert.assertTrue(policyNumSubscriber.get(2).getText().equals("Subscriber:"));
        softAssert.assertEquals(policyNumSubscriber.get(3).getText(), primaryMember.getSignature(), "Subscriber Name did not match on medical card");

        softAssert.assertTrue(policyNumSubscriber.get(4).getText().equals("Last Updated On:"));
        softAssert.assertEquals(policyNumSubscriber.get(5).getText(), lastUpdated, "Last Updated Date did not match");

        softAssert.assertEquals(premiumAmt.get(0).getText(), primaryMember.getMedicalPremiumAmt(), "medical premium did not match");

        softAssert.assertEquals(financialPremiumData.get(0).getText(), "Applicable From: "+primaryMember.getMedicalFinancialStartDate(), "medical financial start date did not match");
        softAssert.assertEquals(financialPremiumData.get(3).getText(), "After "+primaryMember.getAptcAmt()+" Financial Help", "financial help amount did not match");

        softAssert.assertTrue(policyNumSubscriber.get(0).getText().equals("Exchange Policy Number:"));
        primaryMember.setMedicalEapid(policyNumSubscriber.get(1).getText());



        //Validating medical EAP_ID
        List<PolicyTablesEntity> policyEntity = exchDbDataProvider.getEap_idFromPolicyTable();
        basicActions.waitForElementListToBePresent(policyNumSubscriber, 10);
        primaryMember.setMedicalEapid(policyNumSubscriber.get(1).getText());
        primaryMember.setDentalEapid(policyNumSubscriber.get(7).getText());

        for(PolicyTablesEntity policyTablesEntity: policyEntity) {

            if (policyTablesEntity.getCoverage_type() != null && policyTablesEntity.getCoverage_type().equals("1")) {
                softAssert.assertEquals(primaryMember.getMedicalEapid(),policyNumSubscriber.get(1).getText(), "Medical EAP_ID from My Policies page does not match EAP_ID from DB");
            }else {

            }
        }


        //Validating Total Premium after APTC amount reduction
        String totalAmtAfterReduction=null;
        if(primaryMember.getAptcAmt().equals("$0")){
            String medicalPremiumAmt = primaryMember.getMedicalPremiumAmt();
            totalAmtAfterReduction = medicalPremiumAmt.replace("$", "");
        } else{
            // TO DO:: Add more when needed
        }
        String premiumAfterAPTC = financialPremiumData.get(5).getText();
        //String premiumAmountAfterTrim = premiumAfterAPTC.replace("/mo", "").replace("$", "");

        primaryMember.setTotalMedAmtAfterReduction(totalAmtAfterReduction);
        SharedData.setPrimaryMember(primaryMember);

        String premiumFromSharedData = primaryMember.getTotalMedAmtAfterReduction();
        System.out.println("totalAmtAfterReduction--"+totalAmtAfterReduction);
        System.out.println(premiumFromSharedData);
        softAssert.assertEquals(premiumAfterAPTC, "$"+premiumFromSharedData+"/mo", "Total Premium amount after APTC reduction does not match from UI and DB");
        softAssert.assertAll();
    }

    public void validateDentalPlanDetails(List<Map<String, String>> expectedResult){
        // **** Works when only one member with one medical plan and one dental plan **** //

        primaryMember.setDentalPlanStartDate(expectedResult.get(0).get("PolicyStartDate"));
        primaryMember.setDentalPlanEndDate(expectedResult.get(0).get("PolicyEndDate"));
        primaryMember.setDentalPlanStartDate(expectedResult.get(0).get("FinancialStartDate"));
        primaryMember.setDentalPlanEndDate(expectedResult.get(0).get("FinancialEndDate"));
        SharedData.setPrimaryMember(primaryMember);

        basicActions.waitForElementListToBePresent(memberNames, 10);
        softAssert.assertEquals(memberNames.get(1).getText(), primaryMember.getSignature(), "member name on dental card did not match");
        softAssert.assertEquals(planNames.get(1).getText(), primaryMember.getDentalPlan() ,
                "dental plan name did not match. Actual on page::"+planNames.get(1).getText()+"::Expected::"+primaryMember.getDentalPlan());
        softAssert.assertEquals(planStartAndEndDate.get(2).getText(), primaryMember.getDentalPlanStartDate(), "Dental start date didn't match");
        softAssert.assertEquals(planStartAndEndDate.get(3).getText(), primaryMember.getDentalPlanEndDate(), "Dental end date didnt match");

        softAssert.assertEquals(premiumAmt.get(1).getText(), primaryMember.getDentalPremiumAmt(), "Dental premium did not match");
        softAssert.assertTrue(policyNumSubscriber.get(6).getText().equals("Exchange Policy Number:"));
        softAssert.assertTrue(policyNumSubscriber.get(8).getText().equals("Subscriber:"));
        softAssert.assertTrue(policyNumSubscriber.get(10).getText().equals("Last Updated On:"));

        //Validating dental EAP_ID
        List<PolicyTablesEntity> policyEntity = exchDbDataProvider.getEap_idFromPolicyTable();
        basicActions.waitForElementListToBePresent(policyNumSubscriber, 10);
        primaryMember.setDentalEapid(policyNumSubscriber.get(7).getText());

        for(PolicyTablesEntity policyTablesEntity: policyEntity) {

            if (policyTablesEntity.getCoverage_type() != null && policyTablesEntity.getCoverage_type().equals("2")) {
                softAssert.assertEquals(primaryMember.getDentalEapid(),policyNumSubscriber.get(7).getText(), "Dental EAP_ID from My Policies page does not match with EAP_ID from DB");
            }else{

            }
        }

        String totalDenPremAmtAfterTrim=null;
        if(primaryMember.getAptcAmt().equals("$0")){
            String dentalPremiumAmt = primaryMember.getDentalPremiumAmt();
            System.out.println("dentalPremiumAmt :: "+dentalPremiumAmt);
            totalDenPremAmtAfterTrim = dentalPremiumAmt.replace("$", "");
            System.out.println("totalDenPremAmtAfterTrim :: "+totalDenPremAmtAfterTrim);
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
        softAssert.assertTrue(tableRecord.get(0).getText().equals(primaryMember.getSignature()));
        softAssert.assertTrue(tableRecord.get(1).getText().equals(primaryMember.getMedicalPlan()));
        softAssert.assertTrue(tableRecord.get(2).getText().equals(primaryMember.getMedicalPremiumAmt()));
//        softAssert.assertTrue(tableRecord.get(3).getText().equals()); // financial help
        softAssert.assertTrue(tableRecord.get(4).getText().equals(primaryMember.getMedicalPlanStartDate()));
        softAssert.assertTrue(tableRecord.get(5).getText().equals(primaryMember.getMedicalPlanEndDate()));
    //    softAssert.assertAll();
    }

    public void clickViewPlanHistoryFromDental(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkDental, 10);
        viewPlanHistoryLinkDental.click();
    }

    public void validateDentalPlanDetailsFromPlanHistory(){
        basicActions.waitForElementToBePresent(planHistoryTitle, 10);
        basicActions.waitForElementListToBePresent(tableRecord, 10);
        softAssert.assertEquals(tableRecord.get(0).getText(), primaryMember.getSignature(), "Name did not match");
        softAssert.assertEquals(tableRecord.get(1).getText(), primaryMember.getDentalPlan(), "Dental plan did not match");
        softAssert.assertEquals(tableRecord.get(2).getText(), primaryMember.getDentalPremiumAmt(), "Dental premium did not match" );
//        softAssert.assertTrue(tableRecord.get(3).getText().equals()); //  financial help
        softAssert.assertEquals(tableRecord.get(4).getText(), primaryMember.getDentalPlanStartDate(), "dental plan start date did not match");
        softAssert.assertEquals(tableRecord.get(5).getText(), primaryMember.getDentalPlanEndDate(), "dental plan end date did not match");
  //      softAssert.assertAll();
    }

    public void clickBackButton(){
        basicActions.waitForElementToBePresent(backToCurPlansBtn, 10);
        backToCurPlansBtn.click();
    }

    public void clickMedicalPlanCancelButton(){
        basicActions.waitForElementToBePresent(cancelMedicalPlanbtn, 10);
        cancelMedicalPlanbtn.click();
    }

    public void clickDentalPlanCancelButton(){
        basicActions.waitForElementToBePresent(cancelDentalPlanbtn, 10);
        cancelDentalPlanbtn.click();
    }

}
