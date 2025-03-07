package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

    @FindBy(id="goBackButton")
    WebElement backToCurPlansBtn;

    @FindBy(xpath = "//span[contains(., 'Monthly Premium')]/following-sibling::span")
    List<WebElement> premiumAmt;

    @FindBy(css=".amount-row span")
    List<WebElement> financialPremiumData; // financial stat date, premium after help

    @FindBy(css = ".current-policy div:nth-child(4) .txt-left span")
    List<WebElement> policyNumSubscriber; // policy num, subscriber, updated On for both medical and dental plans

    @FindBy(id="SOL-CurrentPolicies-CancelCurrentMedical")
    WebElement cancelMedicalPlanbtn;

    @FindBy(id="SOL-CurrentPolicies-CancelCurrentDental")
    WebElement cancelDentalPlanbtn;

    @FindBy(id="SOL-CurrentPolicies-FuturePlans")
    WebElement FuturePlans;

    @FindBy(id="SOL-CurrentPolicies-CurrentPlans")
    WebElement CurrentPlans;

    @FindBy(id="SOL-MyPolicies-ShowCancelledPlans")
    WebElement CancelPlansSlider;

    String lastUpdated = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")); // TO DO:: Move this to Shared Data?

    Set<String> allMemberNames = new HashSet<>();

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

    private void validateEnrolledDentalPlanDetails(){
        DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
        for (MemberDetails member : basicActions.getAllDentalEligibleMemInfo()) {

            //WebElements
            WebElement planStartDate = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[@id='SOL-CurrentPolicies-PolicyStartDateCoverage']"));
            WebElement planEndDate = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[@id='SOL-CurrentPolicies-PolicyEndDateCoverage']"));
            WebElement premiumAfterReduction = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//*[contains(@id,'AppliedSubsidy')] //span[1]"));
            WebElement aptc = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//*[contains(@id,'AppliedSubsidy')] //span[2]"));
            WebElement EAPID = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//*[@id='SOL-CurrentPolicies-PolicyNumberExch']"));
            WebElement lastUpdatedOn = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//*[@id='SOL-CurrentPolicies-PolicySubmittedDate']"));

            //DateConversion
            String expecStartDate = basicActions.changeDateFormat(SharedData.getPrimaryMember().getDentalPlanStartDate(),"MM/dd/yyyy","MM/dd/yy");
            String expecEndDate = basicActions.changeDateFormat(SharedData.getPrimaryMember().getDentalPlanEndDate(),"MM/dd/yyyy","MM/dd/yy");
            String expecLastUpdatedDate = basicActions.changeDateFormat(lastUpdated,"MM/dd/yyyy","MM/dd/yy");

            //validation
            softAssert.assertEquals(planStartDate.getText().replace(" -",""),expecStartDate, "plan start Date mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(planEndDate.getText(),expecEndDate, "plan End Date mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(premiumAfterReduction.getText().replace("$","").replace(" /month","").replace(",", ""),(member.getTotalDentalPremAfterReduction()), "Dental Premium after reduction mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(aptc.getText().replace(".00 financial help","").replace(",", ""),(member.getDentalAptcAmt()), "Dental APTC amount mismatch for member: " + member.getFirstName());

            Map<String, String> denEapidDb = exchDbDataProvider.getDentalEap_id();
            member.setDentalEapid_db(denEapidDb.get(member.getDenGroupInd()));
            softAssert.assertEquals(denEapidDb.get(member.getDenGroupInd()),EAPID.getText().replace("Policy Number: ",""), "Medical EAP_ID from My Policies page does not match EAP_ID plan summary page");
            softAssert.assertEquals(lastUpdatedOn.getText(),expecLastUpdatedDate, "Last Updated On mismatch for member: " + member.getFirstName());
            softAssert.assertAll();
        }
    }

    private void validateEnrolledMedicalPlanDetails(){
        DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
        for (MemberDetails member : basicActions.getAllMedicalEligibleMemInfo()) {

            //WebElements
            WebElement planStartDate = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[@id='SOL-CurrentPolicies-PolicyStartDateCoverage']"));
            WebElement planEndDate = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[@id='SOL-CurrentPolicies-PolicyEndDateCoverage']"));
            WebElement premiumAfterReduction = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//*[contains(@id,'AppliedSubsidy')] //span[1]"));
            WebElement aptc = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//*[contains(@id,'AppliedSubsidy')] //span[2]"));
            WebElement EAPID = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//*[@id='SOL-CurrentPolicies-PolicyNumberExch']"));
            WebElement lastUpdatedOn = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//*[@id='SOL-CurrentPolicies-PolicySubmittedDate']"));

            //DateConversion
            String expecStartDate = basicActions.changeDateFormat(SharedData.getPrimaryMember().getMedicalPlanStartDate(),"MM/dd/yyyy","MM/dd/yy");
            String expecEndDate = basicActions.changeDateFormat(SharedData.getPrimaryMember().getMedicalPlanEndDate(),"MM/dd/yyyy","MM/dd/yy");
            String expecLastUpdatedDate = basicActions.changeDateFormat(lastUpdated,"MM/dd/yyyy","MM/dd/yy");


            //validation
            softAssert.assertEquals(planStartDate.getText().replace(" -",""),expecStartDate, "Start Date mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(planEndDate.getText(),expecEndDate, "End Date mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(premiumAfterReduction.getText().replace("$","").replace(" /month","").replace(",", ""), member.getTotalMedAmtAfterReduction(), "Medical Premium after reduction mismatch for member: " + member.getFirstName());

            String aptcValueNumeric = aptc.getText().replace(" financial help", "").replace("$", "").replace(",", "");

            if(aptcValueNumeric.equalsIgnoreCase("0.00")){
                aptcValueNumeric = "0";
                softAssert.assertEquals(aptcValueNumeric,(member.getMedicalAptcAmt()), "Medical APTC amount mismatch for member: " + member.getFirstName());
            }
            else {
                softAssert.assertEquals(aptcValueNumeric, (member.getMedicalAptcAmt()), "Medical APTC amount mismatch for member: " + member.getFirstName());
            }

            Map<String, String> medEapidDb = exchDbDataProvider.getMedicalEap_id();
            member.setMedicalEapid_db(medEapidDb.get(member.getMedGroupInd()));
            softAssert.assertEquals(medEapidDb.get(member.getMedGroupInd()),EAPID.getText().replace("Policy Number: ",""), "Medical EAP_ID from My Policies page does not match EAP_ID plan summary page");
            softAssert.assertEquals(lastUpdatedOn.getText(),expecLastUpdatedDate, "Last Updated On mismatch for member: " + member.getFirstName());
            softAssert.assertAll();
        }
    }

    public void clickBackButton(){
        basicActions.waitForElementToBePresent(backToCurPlansBtn, 10);
        backToCurPlansBtn.click();
    }

    public void clickFuturePlans(){
        basicActions.waitForElementToBePresent(FuturePlans, 10);
        FuturePlans.click();
    }

    public void clickCurrentPlans(){
        basicActions.waitForElementToBePresent(CurrentPlans, 10);
        CurrentPlans.click();
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

    public void validateCancelPlanButnNotPresent(String planType) {
        switch (planType){
            case "Medical":
                validateCancelPlan(planType);
                break;
            case "Dental":
                validateCancelPlan(planType);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + planType);
        }
    }
    
    public void validateCancelPlan(String planType){
         By locator = By.id("SOL-CurrentPolicies-CancelCurrent" + planType + "\")");
         softAssert.assertFalse(basicActions.elementExists(locator),"Element should be absent but was found.");
    }

    public void clickCancelledPlansSlider(){
        basicActions.waitForElementToBePresent(CancelPlansSlider, 10);
        CancelPlansSlider.click();
    }
}
