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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyPoliciesPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public MyPoliciesPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".current-policy .txt-name")
    List<WebElement> memberNames;  // Gives names of all members - both medical and dental

    @FindBy(css = ".current-policy-data .pDate span:nth-child(2)")
    List<WebElement> planStartAndEndDate; // update this locator - split and have one for plan start date and one for plan end date

    @FindBy(css = ".current-policy-container .header-3")
    List<WebElement> planNames; // Both medical and dental plan names for all members

    @FindBy(id = "viewPlanHistoryLink_0")
    WebElement viewPlanHistoryLinkMedical;

    @FindBy(id = "viewPlanHistoryLink_1")
    WebElement viewPlanHistoryLinkDental;

    @FindBy(css = "app-plan-details .container .header-2")
    WebElement planHistoryTitle;

    @FindBy(css = "table .body-text-1")
    List<WebElement> tableRecord;

    @FindBy(css = "table .body-text-1 p")
    List<WebElement> enrolledMemNames;

    @FindBy(id="backToCurrentPlanDetailsButton")
    WebElement backToCurPlansBtn;

    @FindBy(xpath = "//span[contains(., 'Monthly Premium')]/following-sibling::span")
    List<WebElement> premiumAmt;

    @FindBy(css=".amount-row span")
    List<WebElement> financialPremiumData; // financial stat date, premium after help

    @FindBy(css = ".current-policy div:nth-child(4) .txt-left span")
    List<WebElement> policyNumSubscriber; // policy num, subscriber, updated On for both medical and dental plans

    @FindBy(id="Cancel 2024 Medical PlansButton")
    WebElement cancelMedicalPlanbtn;

    @FindBy(id="Cancel 2024 Dental Plans Button")
    WebElement cancelDentalPlanbtn;

    String lastUpdated = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")); // TO DO:: Move this to Shared Data?

    MemberDetails primaryMember = SharedData.getPrimaryMember();
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    Set<String> allMemberNames = new HashSet<>();
    Set<String> namesFromUI = new HashSet<>();


    public void validatePlanDetails(String planType){
        basicActions.waitForElementListToBePresent(memberNames, 10);
        basicActions.waitForElementListToBePresent(policyNumSubscriber, 10);
        allMemberNames = new HashSet<>(basicActions.getAllMemNames());
        switch (planType){
            case "medical":
                validateEnrolledMedicalPlanDetails();
                break;
            case "dental":
                validateEnrolledDentalPlanDetails();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + planType);
        }
    }

    public void clickViewPlanHistory(String planType){
        switch(planType){
            case "medical":
                clickViewPlanHistoryFromMed();
                break;
            case "dental":
                clickViewPlanHistoryFromDental();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + planType);
        }
    }

    public void validatePlanDetailsPlanHistory(String planType){
        basicActions.waitForElementToBePresent(planHistoryTitle, 10);
        basicActions.waitForElementListToBePresent(tableRecord, 10);
        validateNamesOnPlanHistory();
        switch (planType){
            case "medical":
                validateMedPlanDetailsFromPlanHistory();
                break;
            case "dental":
                validateDentalPlanDetailsFromPlanHistory();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + planType);
        }
    }

    private void validateNamesOnPlanHistory(){
        if(basicActions.waitForElementListToBePresent(enrolledMemNames, 10)){
            allMemberNames = new HashSet<>(basicActions.getAllMemNames());
            enrolledMemNames.stream().forEach(element-> namesFromUI.add(element.getText()));
            softAssert.assertTrue(namesFromUI.equals(allMemberNames),"Member names  from plan history page did not match");
        } else {
            softAssert.assertTrue(tableRecord.get(0).getText().equals(SharedData.getPrimaryMember().getSignature()));
        }
        softAssert.assertAll();
    }

    private void validateEnrolledDentalPlanDetails(){
        // Validating Names
        Set<String> namesFromUi = new HashSet<>(Arrays.asList(memberNames.get(1).getText().replace(" and ", ", ").split(", ")));
        softAssert.assertTrue(allMemberNames.equals(namesFromUi));

        softAssert.assertEquals(planStartAndEndDate.get(2).getText(), primaryMember.getPlanStartDate(), "Dental start date didn't match");
        softAssert.assertEquals(planStartAndEndDate.get(3).getText(), primaryMember.getPlanEndDate(), "Dental end date didnt match");
        softAssert.assertEquals(planNames.get(1).getText(), primaryMember.getDentalPlan(),"dental plan name did not match. Actual on page::"+planNames.get(1).getText()+"::Expected::"+primaryMember.getDentalPlan());
        softAssert.assertEquals(premiumAmt.get(1).getText().replace("$",""), primaryMember.getDentalPremiumAmt().replace("$", ""), "Dental premium did not match");
        softAssert.assertTrue(policyNumSubscriber.get(8).getText().equals("Subscriber:"));
        softAssert.assertEquals(policyNumSubscriber.get(9).getText(), primaryMember.getSignature(),"Subscriber name mismatch");
        softAssert.assertTrue(policyNumSubscriber.get(10).getText().equals("Last Updated On:"));
        softAssert.assertEquals(policyNumSubscriber.get(11).getText(), lastUpdated, "Last updated date on dental tile does not match");

        // Validating dental EAP_ID
        softAssert.assertTrue(policyNumSubscriber.get(6).getText().equals("Exchange Policy Number:"));
        softAssert.assertEquals(primaryMember.getDentalEapid_db(),policyNumSubscriber.get(7).getText(), "Dental EAP_ID from My Policies page does not match with EAP_ID from DB");

        String dentalPremAfterAPTC = financialPremiumData.get(11).getText();
        String dentalPremiumFromSharedData = primaryMember.getDentalPremiumAmt();
        softAssert.assertEquals(dentalPremAfterAPTC, "$"+dentalPremiumFromSharedData+"/mo", "Total dental Premium amount after APTC reduction does not match from UI and DB");
        softAssert.assertAll();
    }

    private void validateEnrolledMedicalPlanDetails(){
            // Validating Names
        Set<String> namesFromUi = new HashSet<>(Arrays.asList(memberNames.get(0).getText().replace(" and ", ", ").split(", ")));
        softAssert.assertTrue(allMemberNames.equals(namesFromUi));

        softAssert.assertEquals(planStartAndEndDate.get(0).getText(), primaryMember.getPlanStartDate(), "medical plan date did not match");
        softAssert.assertEquals(planStartAndEndDate.get(1).getText(), primaryMember.getPlanEndDate(), "medical plan end date did not match");
        softAssert.assertEquals(planNames.get(0).getText(), primaryMember.getMedicalPlan(), "medical plan name did not match");
        softAssert.assertEquals(premiumAmt.get(0).getText(), "$"+primaryMember.getMedicalPremiumAmt(), "medical premium did not match");
        softAssert.assertTrue(policyNumSubscriber.get(2).getText().equals("Subscriber:"));
        softAssert.assertEquals(policyNumSubscriber.get(3).getText(), primaryMember.getSignature(), "Subscriber Name did not match on medical card");
        softAssert.assertTrue(policyNumSubscriber.get(4).getText().equals("Last Updated On:"));
        softAssert.assertEquals(policyNumSubscriber.get(5).getText(), lastUpdated, "Last Updated Date did not match");

        //Validating medical EAP_ID
        exchDbDataProvider.getEap_id();
        softAssert.assertEquals(primaryMember.getMedicalEapid_db(),policyNumSubscriber.get(1).getText(), "Medical EAP_ID from My Policies page does not match EAP_ID plan summary page");

        //Validating Total Premium after APTC amount reduction
        String totalAmtAfterReduction = primaryMember.getTotalMedAmtAfterReduction();
        String premiumAfterAPTC = financialPremiumData.get(5).getText();
        softAssert.assertEquals(premiumAfterAPTC, "$"+totalAmtAfterReduction+"/mo", "Total Premium amount after APTC reduction does not match from UI and DB");
        softAssert.assertAll();
    }


    private void clickViewPlanHistoryFromMed(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkMedical, 10);
        viewPlanHistoryLinkMedical.click();
    }

    private void clickViewPlanHistoryFromDental(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkDental, 10);
        viewPlanHistoryLinkDental.click();
    }

    private void validateMedPlanDetailsFromPlanHistory(){
        softAssert.assertTrue(tableRecord.get(1).getText().equals(primaryMember.getMedicalPlan()), "Medical plan mismatch");
        softAssert.assertTrue(tableRecord.get(2).getText().equals("$"+primaryMember.getTotalMedAmtAfterReduction()),"medical premium amount after reduction mismatch");
        if(primaryMember.getMedicalAptcAmt().equals("0")){
            softAssert.assertTrue(tableRecord.get(3).getText().equals("$"+primaryMember.getMedicalAptcAmt()+".00"),"Medical APTC amount mismatch");
        }else {
            softAssert.assertTrue(tableRecord.get(3).getText().equals("$" + primaryMember.getMedicalAptcAmt()), "Medical APTC amount mismatch");
        }
        softAssert.assertTrue(tableRecord.get(4).getText().equals(primaryMember.getPlanStartDate()), "plan start date mismatch");
        softAssert.assertTrue(tableRecord.get(5).getText().equals(primaryMember.getPlanEndDate()), "plan end date mismatch");
        softAssert.assertAll();
    }



    private void validateDentalPlanDetailsFromPlanHistory(){

        softAssert.assertEquals(tableRecord.get(1).getText(), primaryMember.getDentalPlan(), "Dental plan did not match");
        softAssert.assertEquals(tableRecord.get(2).getText().replace("$",""), primaryMember.getDentalPremiumAmt().replace("$",""), "Dental premium did not match" );
        softAssert.assertTrue(tableRecord.get(3).getText().equals(primaryMember.getDentalAptcAmt()+".00"),"Dental APTC mismatch"); //  financial help
        softAssert.assertEquals(tableRecord.get(4).getText(), primaryMember.getPlanStartDate(), "dental plan start date did not match");
        softAssert.assertEquals(tableRecord.get(5).getText(), primaryMember.getPlanEndDate(), "dental plan end date did not match");
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
}