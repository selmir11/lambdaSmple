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
import java.util.*;

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

    @FindBy(id="Cancel 2025 Medical PlansButton")
    WebElement cancelMedicalPlanbtn;

    @FindBy(id="Cancel 2025 Dental Plans Button")
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
      //  validateNamesOnPlanHistory();
        switch (planType){
            case "medical":
                validateMedicalPlanFromPlanHistory();
                break;
            case "dental":
                validateDentalPlanFromPlanHistory();
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
        for (MemberDetails member : basicActions.getAllDentalEligibleMemInfo()) {

            //WebElements
            WebElement planStartDate = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Plan Start Date:')]/following-sibling::*"));

            WebElement planEndDate = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Plan End Date:')]/following-sibling::*"));

            WebElement monthlyPremium = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Monthly Premium')]/following-sibling::*"));

            WebElement premiumAfterReduction = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),' After ')]/following-sibling::*"));

            WebElement aptc = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Financial Help')]"));

            WebElement EAPID = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Exchange Policy Number:')]/parent::*/following-sibling::*/*"));

            WebElement lastUpdatedOn = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4]//span[contains(text(),'Last Updated On:')]/../following-sibling::*/*"));

            WebElement applicableFrom = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Applicable From:')][last()]"));

            //validation
            softAssert.assertEquals(planStartDate.getText(),(SharedData.getPrimaryMember().getDentalPlanStartDate()), "Start Date mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(planEndDate.getText(),(SharedData.getPrimaryMember().getDentalPlanEndDate()), "End Date mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(monthlyPremium.getText().replace("$","").replace(",", ""),(member.getDentalPremiumAmt()), "Dental Premium mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(premiumAfterReduction.getText().replace("$","").replace("/mo","").replace(",", ""),(member.getTotalDentalPremAfterReduction()), "Dental Premium after reduction mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(aptc.getText().replace(" Financial Help","").replace(",", ""),(member.getDentalAptcAmt()), "Dental APTC amount mismatch for member: " + member.getFirstName());

            Map<String, String> denEapidDb = exchDbDataProvider.getDentalEap_id();
            member.setMedicalEapid_db(denEapidDb.get(member.getDenGroupInd()));
            softAssert.assertEquals(denEapidDb.get(member.getDenGroupInd()),EAPID.getText(), "Medical EAP_ID from My Policies page does not match EAP_ID plan summary page");

            if(member.getIsSubscriber().equals("Y")){
                WebElement subscriber = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getDentalPlan()+"')]/ancestor::div[4]//span[contains(text(),'Subscriber:')]/../following-sibling::*/*[contains(text(),'"+member.getFirstName()+"')]"));
                softAssert.assertEquals(subscriber.getText(),(member.getSignature()), "Subscriber name mismatch for member: " + member.getFirstName());
            }

            softAssert.assertEquals(lastUpdatedOn.getText(),(lastUpdated), "Last Updated On mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(applicableFrom.getText().replace("Applicable From: ",""),(SharedData.getPrimaryMember().getDentalPlanStartDate()), "Dental APTC amount mismatch for member: " + member.getFirstName());
            softAssert.assertAll();
        }
    }

    private void validateEnrolledMedicalPlanDetails(){
        for (MemberDetails member : basicActions.getAllMedicalEligibleMemInfo()) {

            //WebElements
            WebElement planStartDate = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Plan Start Date:')]/following-sibling::*"));

            WebElement planEndDate = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Plan End Date:')]/following-sibling::*"));

            WebElement monthlyPremium = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Monthly Premium')]/following-sibling::*"));

            WebElement premiumAfterReduction = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),' After ')]/following-sibling::*"));

            WebElement aptc = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Financial Help')]"));

            WebElement EAPID = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Exchange Policy Number:')]/parent::*/following-sibling::*/*"));



            WebElement lastUpdatedOn = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4]//span[contains(text(),'Last Updated On:')]/../following-sibling::*/*"));

            WebElement applicableFrom = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4][.//span[contains(text(),'"+member.getFirstName()+"')]]//span[contains(text(),'Applicable From:')][last()]"));

            //validation
            softAssert.assertEquals(planStartDate.getText(),(SharedData.getPrimaryMember().getMedicalPlanStartDate()), "Start Date mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(planEndDate.getText(),(SharedData.getPrimaryMember().getMedicalPlanEndDate()), "End Date mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(monthlyPremium.getText().replace("$","").replace(",",""),(member.getMedicalPremiumAmt()), "Medical Premium mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(premiumAfterReduction.getText().replace("$","").replace("/mo","").replace(",", ""), member.getTotalMedAmtAfterReduction(), "Medical Premium after reduction mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(aptc.getText().replace(" Financial Help","").replace("$","").replace(",",""),(member.getMedicalAptcAmt()), "Medical APTC amount mismatch for member: " + member.getFirstName());

            Map<String, String> medEapidDb = exchDbDataProvider.getMedicalEap_id();
            member.setMedicalEapid_db(medEapidDb.get(member.getMedGroupInd()));
            softAssert.assertEquals(medEapidDb.get(member.getMedGroupInd()),EAPID.getText(), "Medical EAP_ID from My Policies page does not match EAP_ID plan summary page");

            if(member.getIsSubscriber().equals("Y")){
                WebElement subscriber = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+member.getMedicalPlan()+"')]/ancestor::div[4]//span[contains(text(),'Subscriber:')]/../following-sibling::*/*[contains(text(),'"+member.getFirstName()+"')]"));
                softAssert.assertEquals(subscriber.getText(),(member.getSignature()), "Subscriber name mismatch for member: " + member.getFirstName());
            }

            softAssert.assertEquals(lastUpdatedOn.getText(),(lastUpdated), "Last Updated On mismatch for member: " + member.getFirstName());
            softAssert.assertEquals(applicableFrom.getText().replace("Applicable From: ",""),(SharedData.getPrimaryMember().getMedicalPlanStartDate()), "Applicable From date is not-matched for member: " + member.getFirstName());
            softAssert.assertAll();
        }
    }
    private void validateMedicalPlanFromPlanHistory(){
        for (MemberDetails member : basicActions.getAllMedicalEligibleMemInfo()) {
            basicActions.waitForElementToBePresent(viewPlanHistoryLinkMedical,10);
            WebElement viewPlanHistoryLink = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'" + member.getMedicalPlan() + "')]/ancestor::div[4][.//span[contains(text(),'" + member.getFirstName() + "')]] //a"));
            viewPlanHistoryLink.click();
            validateMedPlanDetailsFromPlanHistory(member);
            clickBackButton();
        }
    }

    private void validateDentalPlanFromPlanHistory(){
        for (MemberDetails member : basicActions.getAllDentalEligibleMemInfo()) {
            basicActions.waitForElementToBePresent(viewPlanHistoryLinkDental,10);
            WebElement viewPlanHistoryLink = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'" + member.getDentalPlan() + "')]/ancestor::div[4][.//span[contains(text(),'" + member.getFirstName() + "')]] //a"));
            viewPlanHistoryLink.click();
            validateDentalPlanDetailsFromPlanHistory(member);
            clickBackButton();
        }
    }


    private void clickViewPlanHistoryFromMed(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkMedical, 10);
        viewPlanHistoryLinkMedical.click();
    }

    private void clickViewPlanHistoryFromDental(){
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkDental, 10);
        viewPlanHistoryLinkDental.click();
    }

    private void validateMedPlanDetailsFromPlanHistory(MemberDetails member){
        basicActions.waitForElementListToBePresent(tableRecord,10);
        softAssert.assertTrue(tableRecord.get(0).getText().contains(member.getFirstName()), "Member Name mismatch");
        softAssert.assertEquals(tableRecord.get(1).getText(),(member.getMedicalPlan()), "Medical plan mismatch");
        softAssert.assertEquals(tableRecord.get(2).getText().replace(",", ""), ("$"+member.getTotalMedAmtAfterReduction()),"medical premium amount after reduction mismatch");
        if(member.getMedicalAptcAmt().equals("0")){
            softAssert.assertEquals(tableRecord.get(3).getText(),("$"+member.getMedicalAptcAmt()+".00"),"Medical APTC amount mismatch");
        }else {
            softAssert.assertEquals(tableRecord.get(3).getText().replace(",",""),("$" + member.getMedicalAptcAmt()), "Medical APTC amount mismatch");
        }
        softAssert.assertTrue(tableRecord.get(4).getText().equals(SharedData.getPrimaryMember().getMedicalPlanStartDate()), "plan start date mismatch");
        softAssert.assertTrue(tableRecord.get(5).getText().equals(SharedData.getPrimaryMember().getMedicalPlanEndDate()), "plan end date mismatch");
        softAssert.assertAll();
    }

    private void validateDentalPlanDetailsFromPlanHistory(MemberDetails member){
        basicActions.waitForElementListToBePresent(tableRecord,10);
        softAssert.assertTrue(tableRecord.get(0).getText().contains(member.getFirstName()), "Member Name not match");
        softAssert.assertEquals(tableRecord.get(1).getText(), member.getDentalPlan(), "Dental plan did not match");
        softAssert.assertEquals(tableRecord.get(2).getText().replace("$",""), member.getDentalPremiumAmt().replace("$",""), "Dental premium did not match" );
        softAssert.assertEquals(tableRecord.get(3).getText(),(member.getDentalAptcAmt()+".00"),"Dental APTC mismatch"); //  financial help
        softAssert.assertEquals(tableRecord.get(4).getText(), SharedData.getPrimaryMember().getDentalPlanStartDate(), "dental plan start date did not match");
        softAssert.assertEquals(tableRecord.get(5).getText(), SharedData.getPrimaryMember().getDentalPlanEndDate(), "dental plan end date did not match");
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