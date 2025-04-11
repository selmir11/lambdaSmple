package com.c4hco.test.automation.database.DbValidations;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.database.dbDataProvider.MpDbDataProvider;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

public class ManagePlanDBValidation {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    MpDbDataProvider mpDbDataProvider = new MpDbDataProvider();
    List<PolicyTablesEntity> medicalPolicyEntities = new ArrayList<>();
    List<PolicyTablesEntity> dentalPolicyEntities = new ArrayList<>();
    SoftAssert softAssert = new SoftAssert();
    BasicActions basicActions = new BasicActions();

    public ManagePlanDBValidation(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }


    private void setData() {
        List<PolicyTablesEntity> policyEntitiesList = exchDbDataProvider.getDataFrmPolicyTables("1");
        List<PolicyTablesEntity> dentalEntitiesList = exchDbDataProvider.getDataFrmPolicyTables("2");
        SharedData.setMedicalPolicyTablesEntities(policyEntitiesList);
        SharedData.setDentalPolicyTablesEntities(dentalEntitiesList);
        medicalPolicyEntities = SharedData.getMedicalPolicyTablesEntities();
        dentalPolicyEntities = SharedData.getDentalPolicyTablesEntities();
    }

    public void validateCurrentMedicalPlanDataDB(String year) {
        setData();
        SharedData.getManagePlanDentalMedicalPlan().setPlanType("1");
        softAssert.assertEquals(exchDbDataProvider.getPlanMarketingName(year),SharedData.getManagePlanDentalMedicalPlan().getPlanMarketingName());
        softAssert.assertEquals(medicalPolicyEntities.get(0).getFinancial_period_start_date(), SharedData.getManagePlanDentalMedicalPlan().getMedFinancialStartDate());

        String [] policyDate = exchDbDataProvider.getMedDentalPolicyDate();
        String dateStr = policyDate[0];
        String dateEnd = policyDate[1];
        String formattedDateSTR = basicActions.changeDateFormat(dateStr ,"yyyy-MM-dd","MM/dd/yyyy");
        String formattedDateEnd = basicActions.changeDateFormat(dateEnd ,"yyyy-MM-dd","MM/dd/yyyy");
        String coverageDate = formattedDateSTR+" to "+formattedDateEnd;
        softAssert.assertTrue(SharedData.getManagePlanDentalMedicalPlan().getPolicyCoverageDate().contains(coverageDate));

        String MEDFinancialEndDateDB = medicalPolicyEntities.get(0).getFinancial_period_end_date();
        softAssert.assertEquals(MEDFinancialEndDateDB, SharedData.getManagePlanDentalMedicalPlan().getMedFinancialEndDate());

        String total_csr_amtDB = medicalPolicyEntities.get(0).getTotal_csr_amt();
        softAssert.assertEquals("$" + total_csr_amtDB, SharedData.getManagePlanDentalMedicalPlan().getTotal_csr_amt());

        String planPremiumAmt = medicalPolicyEntities.get(0).getPlan_premium_amt();
        softAssert.assertEquals("$" + planPremiumAmt, SharedData.getManagePlanDentalMedicalPlan().getPlanPremiumAmt());

        String planAptcAmtDB = medicalPolicyEntities.get(0).getPremium_reduction_amt();
        softAssert.assertEquals("$" + planAptcAmtDB, SharedData.getManagePlanDentalMedicalPlan().getPlanAptcAmt());

        String ReductionAmt = medicalPolicyEntities.get(0).getTotal_premium_reduction_amt();
        double premiumReductionAmt = Double.parseDouble(planPremiumAmt) - Double.parseDouble(ReductionAmt);
        String reductionAmount = String.format("%.2f", premiumReductionAmt);
        softAssert.assertEquals("$" + reductionAmount, SharedData.getManagePlanDentalMedicalPlan().getPremiumAfterSubsidy());

        String HIOSIdDB = medicalPolicyEntities.get(0).getHios_plan_id();
        softAssert.assertEquals(HIOSIdDB, SharedData.getManagePlanDentalMedicalPlan().getMedHIOSId());

        String MedEhbPremiumAmtDB = exchDbDataProvider.getMedCurrentEhbPremiumAmtForTheYearDB(year);
        String premiumAmount = medicalPolicyEntities.get(0).getPlan_premium_amt();

        Double x = Double.parseDouble(premiumAmount)* Double.parseDouble(MedEhbPremiumAmtDB);
        String amount = Double.toString(x);

        softAssert.assertEquals("$"+amount,SharedData.getManagePlanDentalMedicalPlan().getMedEhbPremiumAmt());

       softAssert.assertEquals("Rating Area "+SharedData.getManagePlanDentalMedicalPlan().getRatingArea(), exchDbDataProvider.getRatingName());

        String[] medLceEventDB = exchDbDataProvider.getLCEEventTypeAndLCEDateTypeForTheYearDB();
        String lce_typeDB = medLceEventDB[0].replace("_", " ").toLowerCase();
        String lce_event_dateDB = basicActions.changeDateFormat(medLceEventDB[1],"yyyy-MM-dd","MM/dd/yyyy");
        softAssert.assertEquals(lce_typeDB+" "+lce_event_dateDB,SharedData.getManagePlanDentalMedicalPlan().getMedLCEEventTypeAndDate());

        String ServiceArea = exchDbDataProvider.getMedServiceAreaForTheYearDB();
        softAssert.assertEquals(ServiceArea ,SharedData.getManagePlanDentalMedicalPlan().getMedServiceArea());

        String planAVDB = exchDbDataProvider.getAv_calculator_output();
        double number = Double.parseDouble(planAVDB);
        String percentageString = String.format("%.2f%%", number);
        softAssert.assertEquals(percentageString ,SharedData.getManagePlanDentalMedicalPlan().getMedPlanAV());

        String[] medPolicyArray =exchDbDataProvider.getMedSecondPolicy(year);
        String policyIDDB = medPolicyArray[0];
        softAssert.assertEquals(policyIDDB ,SharedData.getManagePlanDentalMedicalPlan().getPolicyID());

        String medLatestAppDateDB = exchDbDataProvider.getMedDenLatestApplicationDate();
        softAssert.assertTrue(medLatestAppDateDB.contains(SharedData.getManagePlanDentalMedicalPlan().getMedLatestAppDate()));
        softAssert.assertAll();
    }


    public void validateCurrentMedicalCoverageDetailsTableDB() {
        String coverageStartDB = medicalPolicyEntities.get(0).getCoverage_start_date();
        String coverageEndDB = medicalPolicyEntities.get(0).getCoverage_end_date();
        coverageStartDB = basicActions.changeDateFormat(coverageStartDB,"yyyy-MM-dd","MM/dd/yyyy");
        coverageEndDB = basicActions.changeDateFormat(coverageEndDB,"yyyy-MM-dd","MM/dd/yyyy");
        softAssert.assertEquals(coverageStartDB ,SharedData.getManagePlanDentalMedicalPlan().getCoverageStartDate());
        softAssert.assertEquals(coverageEndDB ,SharedData.getManagePlanDentalMedicalPlan().getCoverageEndDate());

        String MEDStatusCoverageDB = medicalPolicyEntities.get(0).getPolicy_member_coverage_status().toLowerCase();
        softAssert.assertEquals(MEDStatusCoverageDB ,SharedData.getManagePlanDentalMedicalPlan().getMedStatus());

        String medEffectuatedDB = medicalPolicyEntities.get(0).getEffectuated_ind_eph();
        switch (medEffectuatedDB){
            case "0":
                medEffectuatedDB ="no";
                break;
            case "1":
                medEffectuatedDB ="yes";
                break;
        }
        softAssert.assertEquals(medEffectuatedDB ,SharedData.getManagePlanDentalMedicalPlan().getMedEffectuated());

        String MedTerminationReasonDB = medicalPolicyEntities.get(0).getDisenrollment_reason();
        if (MedTerminationReasonDB==null){
            MedTerminationReasonDB="";
        }
        softAssert.assertEquals(MedTerminationReasonDB,SharedData.getManagePlanDentalMedicalPlan().getMedTerminationReason());
        softAssert.assertAll();
    }

    public void validateCurrentMedicalMemberDetailsTableDB() {
        String personIdDB = medicalPolicyEntities.get(0).getExch_person_id();
        softAssert.assertEquals(personIdDB, SharedData.getManagePlanDentalMedicalPlan().getMedPersonID());

        String FullNameDB = medicalPolicyEntities.get(0).getFirst_name() + " " + medicalPolicyEntities.get(0).getLast_name();
        softAssert.assertEquals(FullNameDB, SharedData.getManagePlanDentalMedicalPlan().getNameMember());

        String DateOfBirthUser = medicalPolicyEntities.get(0).getBirth_date();
        String dateOfBirthDB = DateOfBirthUser.split(" ")[0];
        dateOfBirthDB = basicActions.changeDateFormat(dateOfBirthDB, "yyyy-MM-dd", "MM/dd/yyyy");
        softAssert.assertEquals(dateOfBirthDB, SharedData.getManagePlanDentalMedicalPlan().getDateOFBirth());

        String Relationship = medicalPolicyEntities.get(0).getRelation_to_subscriber();
        Relationship = Relationship.toLowerCase();
        softAssert.assertEquals(Relationship, SharedData.getManagePlanDentalMedicalPlan().getRelationship());


        String tobaccoDB = exchDbDataProvider.getPrimaryTobaccoInMemberDetailsTable();
        switch (tobaccoDB) {
            case "0":
                tobaccoDB = "No";
                break;
            case "1":
                tobaccoDB = "Yes";
                break;
        }
        softAssert.assertEquals(tobaccoDB, SharedData.getManagePlanDentalMedicalPlan().getTobacco());
        softAssert.assertAll();
    }

    public void validateCurrentFinancialDetailsTableDB() {
        String MEDFinancialStartDateDB = medicalPolicyEntities.get(0).getFinancial_period_start_date();
        MEDFinancialStartDateDB= basicActions.changeDateFormat(MEDFinancialStartDateDB,"yyyy-MM-dd","MM/dd/yyyy");
        softAssert.assertEquals(MEDFinancialStartDateDB,SharedData.getManagePlanDentalMedicalPlan().getMedFinancialStartFnTable());

        String MEDFinancialEndDateDB = medicalPolicyEntities.get(0).getMember_financial_end_date();
        MEDFinancialEndDateDB= basicActions.changeDateFormat(MEDFinancialEndDateDB,"yyyy-MM-dd","MM/dd/yyyy");
        softAssert.assertEquals(MEDFinancialEndDateDB,SharedData.getManagePlanDentalMedicalPlan().getMedFinancialEndFnTable());

        String planPremiumAmtDB = medicalPolicyEntities.get(0).getPlan_premium_amt();
        softAssert.assertEquals("$"+planPremiumAmtDB,SharedData.getManagePlanDentalMedicalPlan().getMedPlanPremiumAmtFnTable());

        String planAptcAmtDB = medicalPolicyEntities.get(0).getTotal_premium_reduction_amt();
        softAssert.assertEquals("$"+planAptcAmtDB,SharedData.getManagePlanDentalMedicalPlan().getMedPlanAptcAmtFnTable());
        softAssert.assertAll();
    }


    public void validateCurrentDentalPlanDataForTheYearDB(String year) {
        SharedData.getManagePlanDentalMedicalPlan().setPlanType("2");
        setData();
        softAssert.assertEquals(exchDbDataProvider.getPlanMarketingName(year),SharedData.getManagePlanDentalMedicalPlan().getPlanMarketingName());
        softAssert.assertEquals(dentalPolicyEntities.get(0).getFinancial_period_start_date(), SharedData.getManagePlanDentalMedicalPlan().getDenFinancialStartDate());

        String [] policyDate = exchDbDataProvider.getMedDentalPolicyDate();
        String dateStr = policyDate[0];
        String dateEnd = policyDate[1];
        String formattedDateSTR = basicActions.changeDateFormat(dateStr ,"yyyy-MM-dd","MM/dd/yyyy");
        String formattedDateEnd = basicActions.changeDateFormat(dateEnd ,"yyyy-MM-dd","MM/dd/yyyy");
        String coverageDate = formattedDateSTR+" to "+formattedDateEnd;
        softAssert.assertTrue(SharedData.getManagePlanDentalMedicalPlan().getDenPolicyCoverageDate().contains(coverageDate));

        String DenFinancialEndDateDB = dentalPolicyEntities.get(0).getFinancial_period_end_date();
        softAssert.assertEquals(DenFinancialEndDateDB, SharedData.getManagePlanDentalMedicalPlan().getDenFinancialEndDate());

        String Dentotal_csr_amtDB = dentalPolicyEntities.get(0).getTotal_csr_amt();
        softAssert.assertEquals("$" + Dentotal_csr_amtDB, SharedData.getManagePlanDentalMedicalPlan().getDenTotal_csr_amt());
        softAssert.assertAll();

        String DenplanPremiumAmt = dentalPolicyEntities.get(0).getPlan_premium_amt();
        softAssert.assertEquals("$" + DenplanPremiumAmt, SharedData.getManagePlanDentalMedicalPlan().getDenPlanPremiumAmt());
        softAssert.assertAll();

        String DenplanAptcAmtDB = dentalPolicyEntities.get(0).getPremium_reduction_amt();
        softAssert.assertEquals("$" + DenplanAptcAmtDB, SharedData.getManagePlanDentalMedicalPlan().getDenPlanAptcAmt());
        softAssert.assertAll();

        String DenReductionAmt = dentalPolicyEntities.get(0).getTotal_premium_reduction_amt();
        double premiumReductionAmt = Double.parseDouble(DenplanPremiumAmt) - Double.parseDouble(DenReductionAmt);
        String DenreductionAmount = String.format("%.2f", premiumReductionAmt);
        softAssert.assertEquals("$" + DenreductionAmount, SharedData.getManagePlanDentalMedicalPlan().getDenPremiumAfterSubsidy());
        softAssert.assertAll();

        String DenHIOSIdDB = dentalPolicyEntities.get(0).getHios_plan_id();
        softAssert.assertEquals(DenHIOSIdDB, SharedData.getManagePlanDentalMedicalPlan().getDenHIOSId());
        softAssert.assertAll();

        String DenEhbPremiumAmtDB = exchDbDataProvider.getMedCurrentEhbPremiumAmtForTheYearDB(year);
        String DenpremiumAmount = dentalPolicyEntities.get(0).getPlan_premium_amt();

        Double x = Double.parseDouble(DenpremiumAmount)* Double.parseDouble(DenEhbPremiumAmtDB);
        String amount = String.format("%.2f", x);

        softAssert.assertEquals("$"+amount,SharedData.getManagePlanDentalMedicalPlan().getDenEhbPremiumAmt());
        softAssert.assertAll();

        softAssert.assertEquals("Rating Area "+SharedData.getManagePlanDentalMedicalPlan().getDenRatingArea(), exchDbDataProvider.getRatingName());
        softAssert.assertAll();

        String[] DenLceEventDB = exchDbDataProvider.getLCEEventTypeAndLCEDateTypeForTheYearDB();
        String lce_typeDB = DenLceEventDB[0].replace("_", " ").toLowerCase();
        String lce_event_dateDB = basicActions.changeDateFormat(DenLceEventDB[1],"yyyy-MM-dd","MM/dd/yyyy");
        softAssert.assertEquals(lce_typeDB+" "+lce_event_dateDB,SharedData.getManagePlanDentalMedicalPlan().getDenLCEEventTypeAndDate());
        softAssert.assertAll();

        String DenServiceArea = exchDbDataProvider.getMedServiceAreaForTheYearDB();
        softAssert.assertEquals(DenServiceArea ,SharedData.getManagePlanDentalMedicalPlan().getDenServiceArea());
        softAssert.assertAll();

        String DenplanAVDB = exchDbDataProvider.getAv_calculator_output();
        double number = Double.parseDouble(DenplanAVDB);
        String DenpercentageString = String.format("%.2f%%", number);
        softAssert.assertEquals(DenpercentageString ,SharedData.getManagePlanDentalMedicalPlan().getDenPlanAV());
        softAssert.assertAll();

        String[] DenPolicyArray =exchDbDataProvider.getMedSecondPolicy(year);
        String policyIDDB = DenPolicyArray[0];
        softAssert.assertEquals(policyIDDB ,SharedData.getManagePlanDentalMedicalPlan().getDenPolicyID());

        String DenLatestAppDateDB = exchDbDataProvider.getMedDenLatestApplicationDate();
        softAssert.assertTrue(DenLatestAppDateDB.contains(SharedData.getManagePlanDentalMedicalPlan().getDenLatestAppDate()));
        softAssert.assertAll();
    }

    public void validateCurrentDentalMemberDetailsTableDB() {
        String denpersonIdDB = dentalPolicyEntities.get(0).getExch_person_id();
        softAssert.assertEquals(denpersonIdDB, SharedData.getManagePlanDentalMedicalPlan().getDenPersonID());

        String denFullNameDB = dentalPolicyEntities.get(0).getFirst_name() + " " + dentalPolicyEntities.get(0).getLast_name();
        softAssert.assertEquals(denFullNameDB, SharedData.getManagePlanDentalMedicalPlan().getDenNameMember());

        String denDateOfBirthUser = dentalPolicyEntities.get(0).getBirth_date();
        String dendateOfBirthDB = denDateOfBirthUser.split(" ")[0];
        dendateOfBirthDB = basicActions.changeDateFormat(dendateOfBirthDB, "yyyy-MM-dd", "MM/dd/yyyy");
        softAssert.assertEquals(dendateOfBirthDB, SharedData.getManagePlanDentalMedicalPlan().getDenDateOFBirth());

        String denRelationship = dentalPolicyEntities.get(0).getRelation_to_subscriber();
        denRelationship = denRelationship.toLowerCase();
        softAssert.assertEquals(denRelationship, SharedData.getManagePlanDentalMedicalPlan().getDenRelationship());


        String dentobaccoDB = exchDbDataProvider.getPrimaryTobaccoInMemberDetailsTable();
        switch (dentobaccoDB) {
            case "0":
                dentobaccoDB = "No";
                break;
            case "1":
                dentobaccoDB = "Yes";
                break;
        }
        softAssert.assertEquals(dentobaccoDB, SharedData.getManagePlanDentalMedicalPlan().getDenTobacco());
        softAssert.assertAll();
    }

    public void validateCurrentDentalCoverageDetailsTableDB() {
        String dencoverageStartDB = dentalPolicyEntities.get(0).getCoverage_start_date();
        String dencoverageEndDB = dentalPolicyEntities.get(0).getCoverage_end_date();
        dencoverageStartDB = basicActions.changeDateFormat(dencoverageStartDB,"yyyy-MM-dd","MM/dd/yyyy");
        dencoverageEndDB = basicActions.changeDateFormat(dencoverageEndDB,"yyyy-MM-dd","MM/dd/yyyy");
        softAssert.assertEquals(dencoverageStartDB ,SharedData.getManagePlanDentalMedicalPlan().getCoverageStartDate());
        softAssert.assertEquals(dencoverageEndDB ,SharedData.getManagePlanDentalMedicalPlan().getCoverageEndDate());

        String denStatusCoverageDB = dentalPolicyEntities.get(0).getPolicy_member_coverage_status().toLowerCase();
        softAssert.assertEquals(denStatusCoverageDB ,SharedData.getManagePlanDentalMedicalPlan().getDenStatus());

        String denEffectuatedDB = dentalPolicyEntities.get(0).getEffectuated_ind_eph();
        switch (denEffectuatedDB){
            case "0":
                denEffectuatedDB ="no";
                break;
            case "1":
                denEffectuatedDB ="yes";
                break;
        }
        softAssert.assertEquals(denEffectuatedDB ,SharedData.getManagePlanDentalMedicalPlan().getMedEffectuated());

        String denTerminationReasonDB = dentalPolicyEntities.get(0).getDisenrollment_reason();
        if (denTerminationReasonDB==null){
            denTerminationReasonDB="";
        }
        softAssert.assertEquals(denTerminationReasonDB,SharedData.getManagePlanDentalMedicalPlan().getMedTerminationReason());
        softAssert.assertAll();
    }

    public void validateCurrentDentalFinancialDetailsTableDB() {
        String denFinancialStartDateDB = dentalPolicyEntities.get(0).getFinancial_period_start_date();
        denFinancialStartDateDB= basicActions.changeDateFormat(denFinancialStartDateDB,"yyyy-MM-dd","MM/dd/yyyy");
        softAssert.assertEquals(denFinancialStartDateDB,SharedData.getManagePlanDentalMedicalPlan().getDenFinancialStartFnTable());

        String denFinancialEndDateDB = dentalPolicyEntities.get(0).getMember_financial_end_date();
        denFinancialEndDateDB= basicActions.changeDateFormat(denFinancialEndDateDB,"yyyy-MM-dd","MM/dd/yyyy");
        softAssert.assertEquals(denFinancialEndDateDB,SharedData.getManagePlanDentalMedicalPlan().getDenFinancialEndFnTable());

        String denplanPremiumAmtDB = dentalPolicyEntities.get(0).getPlan_premium_amt();
        softAssert.assertEquals("$"+denplanPremiumAmtDB,SharedData.getManagePlanDentalMedicalPlan().getDenPlanPremiumAmtFnTable());

        String denplanAptcAmtDB = dentalPolicyEntities.get(0).getTotal_premium_reduction_amt();
        softAssert.assertEquals("$"+denplanAptcAmtDB,SharedData.getManagePlanDentalMedicalPlan().getDenPlanAptcAmtFnTable());
        softAssert.assertAll();
    }

    public void validateCurrentMembersDetailsTableDB(String planType, Integer memberNum) {
        List<List<String>> dbValuesList = mpDbDataProvider.getManagePlansMemberDetails(planType);
        System.out.println("Query executed, returned values: " + dbValuesList);

        if (dbValuesList.isEmpty()) {
            throw new RuntimeException("No data returned for account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'");
        }
        Set<String> processedFirstNames = new HashSet<>();
        int uiRowIndex = 1;
        for (int i = 0; i < dbValuesList.size(); i++) {
            if (uiRowIndex > memberNum) {
                break;
            }
            List<String> dbRow = dbValuesList.get(i);
            String firstName = dbRow.get(1);
            if (processedFirstNames.contains(firstName)) {
                continue;
            }
            processedFirstNames.add(firstName);
            String dbTobaccoValue = dbRow.get(1).equals("1") ? "Yes" : "No";
            String dbDobValue = basicActions.changeDateFormat(dbRow.get(3), "yyyy-MM-dd", "MM/dd/yyyy");

            WebElement personID = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='referenceId_" + uiRowIndex + "']"));
            WebElement fistName = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='firstName_" + uiRowIndex + "']"));
            WebElement dob = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='dateOfBirth_" + uiRowIndex + "']"));
            WebElement relationship = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='relationshipToSubscriber_" + uiRowIndex + "']"));
            WebElement tobacco = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='tobacco_" + uiRowIndex + "']"));

            softAssert.assertEquals(dbRow.get(0), personID.getText(), "Mismatch in exch_person_id for row " + uiRowIndex);
            softAssert.assertEquals(dbRow.get(1)+" "+dbRow.get(2), fistName.getText(), "Mismatch in first_name last_name for row " + uiRowIndex);
            softAssert.assertEquals(dbDobValue, dob.getText(), "Mismatch in birth_date for row " + uiRowIndex);
            softAssert.assertEquals(dbRow.get(4).toLowerCase(), relationship.getText().toLowerCase(), "Mismatch in relation_to_subscriber for row " + uiRowIndex);
            softAssert.assertEquals(dbTobaccoValue, tobacco.getText(), "Mismatch in prior_6_months_tobacco_use_ind for row " + uiRowIndex);
            uiRowIndex++;
        }
        softAssert.assertAll();
    }

    public void validateCurrentCoverageDetailsTableDB(String planType, Integer memberNum) {
        List<List<String>> dbValuesList = mpDbDataProvider.getManagePlansCoverageDetails(planType);
        System.out.println("Query executed, returned values: " + dbValuesList);

        if (dbValuesList.isEmpty()) {
            throw new RuntimeException("No data returned for account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'");
        }
        Set<String> processedFirstNames = new HashSet<>();
        int uiRowIndex = 1;
        for (int i = 0; i < dbValuesList.size(); i++) {
            if (uiRowIndex > memberNum) {
                break;
            }
            List<String> dbRow = dbValuesList.get(i);
            String firstName = dbRow.get(5);
            if (processedFirstNames.contains(firstName)) {
                continue;
            }
            processedFirstNames.add(firstName);
            String dbStartDateValue = basicActions.changeDateFormat(dbRow.get(0), "yyyy-MM-dd", "MM/dd/yyyy");
            String dbEndDateValue = basicActions.changeDateFormat(dbRow.get(1), "yyyy-MM-dd", "MM/dd/yyyy");
            String dbEffectuatedValue = dbRow.get(3).equals("1") ? "Yes" : "No";
            String dbTermReasonValue = dbRow.get(4) == null ? "" : dbRow.get(4).toString().trim();

            WebElement coverageStartDate = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='coverageStartDate_" + uiRowIndex + "']"));
            WebElement coverageEndDate = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='coverageEndDate_" + uiRowIndex + "']"));
            WebElement status = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='status_" + uiRowIndex + "']"));
            WebElement effectuated = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='effectuated_" + uiRowIndex + "']"));
            WebElement terminationReason = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='terminationReason_" + uiRowIndex + "']"));

            softAssert.assertEquals(dbStartDateValue, coverageStartDate.getText(), "Mismatch in coverage_start_date for row " + uiRowIndex);
            softAssert.assertEquals(dbEndDateValue, coverageEndDate.getText(), "Mismatch in coverage_end_date for row " + uiRowIndex);
            softAssert.assertEquals(dbRow.get(2).toLowerCase(), status.getText().toLowerCase(), "Mismatch in policy_member_coverage_status for row " + uiRowIndex);
            softAssert.assertEquals(dbEffectuatedValue, effectuated.getText(), "Mismatch in effectuated_ind for row " + uiRowIndex);
            softAssert.assertEquals(dbTermReasonValue, terminationReason.getText(), "Mismatch in disenrollment_reason for row " + uiRowIndex);
            uiRowIndex++;
        }
        softAssert.assertAll();
    }

    public void validateCurrentFinancialDetailsTableDB(String planType, Integer memberNum) {
        List<List<String>> dbValuesList = mpDbDataProvider.getManagePlansFinancialDetails(planType);
        System.out.println("Query executed, returned values: " + dbValuesList);

        if (dbValuesList.isEmpty()) {
            throw new RuntimeException("No data returned for account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'");
        }
        Set<String> processedFirstNames = new HashSet<>();
        int uiRowIndex = 1;
        for (int i = 0; i < dbValuesList.size(); i++) {
            if (uiRowIndex > memberNum) {
                break;
            }
            List<String> dbRow = dbValuesList.get(i);
            String firstName = dbRow.get(4);
            if (processedFirstNames.contains(firstName)) {
                continue;
            }
            processedFirstNames.add(firstName);
            String dbStartDateValue = basicActions.changeDateFormat(dbRow.get(0), "yyyy-MM-dd", "MM/dd/yyyy");
            String dbEndDateValue = basicActions.changeDateFormat(dbRow.get(1), "yyyy-MM-dd", "MM/dd/yyyy");

            WebElement financialStartDate = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='financialStartDate_" + uiRowIndex + "']"));
            WebElement financialEndDate = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='financialEndDate_" + uiRowIndex + "']"));
            WebElement premium = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='premium_" + uiRowIndex + "']"));
            String reduction = "";
            if (SharedData.getDbName().toLowerCase().contains("exch")) {
                reduction = "APTC";
            } else if (SharedData.getDbName().toLowerCase().contains("coco")) {
                reduction = "SES";
            }
            WebElement taxCredit = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container plan-container-fill']//div[@id='plan"+reduction+"_" + uiRowIndex + "']"));

            softAssert.assertEquals(dbStartDateValue, financialStartDate.getText(), "Mismatch in member_financial_start_date for row " + uiRowIndex);
            softAssert.assertEquals(dbEndDateValue, financialEndDate.getText(), "Mismatch in member_financial_end_date for row " + uiRowIndex);
            softAssert.assertEquals("$"+dbRow.get(2), premium.getText(), "Mismatch in plan_premium_amt for row " + uiRowIndex);
            softAssert.assertEquals("$"+dbRow.get(3), taxCredit.getText(), "Mismatch in premium_reduction_amt for row " + uiRowIndex);
            uiRowIndex++;
        }
        softAssert.assertAll();
    }

    public void validatePreviousMembersDetailsTableDB(String planType, Integer memberNum) {
        List<List<String>> dbValuesList = mpDbDataProvider.getManagePlansMemberDetails(planType);
        System.out.println("Query executed, returned values: " + dbValuesList);

        if (dbValuesList.isEmpty()) {
            throw new RuntimeException("No data returned for account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'");
        }
        Set<String> processedFirstNamesPrevious = new HashSet<>();
        int uiRowIndex = 1;
        for (int i = 0; i < dbValuesList.size(); i++) {
            if (uiRowIndex > memberNum) {
                break;
            }
            List<String> dbRow = dbValuesList.get(i);
            String firstName = dbRow.get(1);
            String coverageEndDateValue = dbRow.get(5);
            boolean hasSecondRow = (i + 1) < dbValuesList.size() && dbValuesList.get(i + 1).get(1).equals(firstName);
            if (coverageEndDateValue.contains("12-31") && hasSecondRow) {
                System.out.println("Skipping first row for " + firstName + " due to coverage_end_date containing 12-31.");
                dbRow = dbValuesList.get(i + 1);
                i++;
            }
            if (processedFirstNamesPrevious.contains(firstName)) {
                continue;
            }
            processedFirstNamesPrevious.add(firstName);
            String dbTobaccoValue = dbRow.get(1).equals("1") ? "Yes" : "No";
            String dbDobValue = basicActions.changeDateFormat(dbRow.get(3), "yyyy-MM-dd", "MM/dd/yyyy");

            WebElement personID = basicActions.getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container']//div[@id='referenceId_" + uiRowIndex + "']"));
            WebElement fistName = basicActions.getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container']//div[@id='firstName_" + uiRowIndex + "']"));
            WebElement dob = basicActions.getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container']//div[@id='dateOfBirth_" + uiRowIndex + "']"));
            WebElement relationship = basicActions.getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container']//div[@id='relationshipToSubscriber_" + uiRowIndex + "']"));
            WebElement tobacco = basicActions.getDriver().findElement(By.xpath("//div[@class='" + planType.toLowerCase() + "-plan-container']//div[@id='tobacco_" + uiRowIndex + "']"));

            softAssert.assertEquals(dbRow.get(0), personID.getText(), "Mismatch in exch_person_id for row " + uiRowIndex);
            softAssert.assertEquals(dbRow.get(1) + " " + dbRow.get(2), fistName.getText(), "Mismatch in first_name last_name for row " + uiRowIndex);
            softAssert.assertEquals(dbDobValue, dob.getText(), "Mismatch in birth_date for row " + uiRowIndex);
            softAssert.assertEquals(dbRow.get(4).toLowerCase(), relationship.getText().toLowerCase(), "Mismatch in relation_to_subscriber for row " + uiRowIndex);
            softAssert.assertEquals(dbTobaccoValue, tobacco.getText(), "Mismatch in prior_6_months_tobacco_use_ind for row " + uiRowIndex);

            uiRowIndex++;
        }

        softAssert.assertAll();
    }

    public void validatePreviousCoverageDetailsTableDB(String planType, Integer memberNum) {
        List<List<String>> dbValuesList = mpDbDataProvider.getManagePlansCoverageDetails(planType);
        System.out.println("Query executed, returned values: " + dbValuesList);

        if (dbValuesList.isEmpty()) {
            throw new RuntimeException("No data returned for account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'");
        }
        Set<String> processedFirstNamesPrevious = new HashSet<>();
        int uiRowIndex = 1;
        for (int i = 0; i < dbValuesList.size(); i++) {
            if (uiRowIndex > memberNum) {
                break;
            }
            List<String> dbRow = dbValuesList.get(i);
            String firstName = dbRow.get(5);
            String coverageEndDateValue = dbRow.get(1);
            boolean hasSecondRow = (i + 1) < dbValuesList.size() && dbValuesList.get(i + 1).get(5).equals(firstName);
            if (coverageEndDateValue.contains("12-31") && hasSecondRow) {
                System.out.println("Skipping first row for " + firstName + " due to coverage_end_date containing 12-31.");
                dbRow = dbValuesList.get(i + 1);
                i++;
            }
            if (processedFirstNamesPrevious.contains(firstName)) {
                continue;
            }
            processedFirstNamesPrevious.add(firstName);
            String dbStartDateValue = basicActions.changeDateFormat(dbRow.get(0), "yyyy-MM-dd", "MM/dd/yyyy");
            String dbEndDateValue = basicActions.changeDateFormat(dbRow.get(1), "yyyy-MM-dd", "MM/dd/yyyy");
            String dbEffectuatedValue = dbRow.get(3).equals("1") ? "Yes" : "No";
            String dbTermReasonValue = dbRow.get(4) == null ? "" : dbRow.get(4).toString().trim();

            WebElement coverageStartDate = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container']//div[@id='coverageStartDate_" + uiRowIndex + "']"));
            WebElement coverageEndDate = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container']//div[@id='coverageEndDate_" + uiRowIndex + "']"));
            WebElement status = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container']//div[@id='status_" + uiRowIndex + "']"));
            WebElement effectuated = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container']//div[@id='effectuated_" + uiRowIndex + "']"));
            WebElement terminationReason = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container']//div[@id='terminationReason_" + uiRowIndex + "']"));

            softAssert.assertEquals(dbStartDateValue, coverageStartDate.getText(), "Mismatch in coverage_start_date for row " + uiRowIndex);
            softAssert.assertEquals(dbEndDateValue, coverageEndDate.getText(), "Mismatch in coverage_end_date for row " + uiRowIndex);
            softAssert.assertEquals(dbRow.get(2).toLowerCase(), status.getText().toLowerCase(), "Mismatch in policy_member_coverage_status for row " + uiRowIndex);
            softAssert.assertEquals(dbEffectuatedValue, effectuated.getText(), "Mismatch in effectuated_ind for row " + uiRowIndex);
            softAssert.assertEquals(dbTermReasonValue, terminationReason.getText(), "Mismatch in disenrollment_reason for row " + uiRowIndex);
            uiRowIndex++;
        }
        softAssert.assertAll();
    }

    public void validatePreviousFinancialDetailsTableDB(String planType, Integer memberNum) {
        List<List<String>> dbValuesList = mpDbDataProvider.getManagePlansFinancialDetails(planType);
        System.out.println("Query executed, returned values: " + dbValuesList);

        if (dbValuesList.isEmpty()) {
            throw new RuntimeException("No data returned for account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'");
        }
        Set<String> processedFirstNamesPrevious = new HashSet<>();
        int uiRowIndex = 1;
        for (int i = 0; i < dbValuesList.size(); i++) {
            if (uiRowIndex > memberNum) {
                break;
            }
            List<String> dbRow = dbValuesList.get(i);
            String firstName = dbRow.get(4);
            String coverageEndDateValue = dbRow.get(5);
            boolean hasSecondRow = (i + 1) < dbValuesList.size() && dbValuesList.get(i + 1).get(4).equals(firstName);
            if (coverageEndDateValue.contains("12-31") && hasSecondRow) {
                System.out.println("Skipping first row for " + firstName + " due to coverage_end_date containing 12-31.");
                dbRow = dbValuesList.get(i + 1);
                i++;
            }
            if (processedFirstNamesPrevious.contains(firstName)) {
                continue;
            }
            processedFirstNamesPrevious.add(firstName);
            String dbStartDateValue = basicActions.changeDateFormat(dbRow.get(0), "yyyy-MM-dd", "MM/dd/yyyy");
            String dbEndDateValue = basicActions.changeDateFormat(dbRow.get(1), "yyyy-MM-dd", "MM/dd/yyyy");

            WebElement financialStartDate = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container']//div[@id='financialStartDate_" + uiRowIndex + "']"));
            WebElement financialEndDate = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container']//div[@id='financialEndDate_" + uiRowIndex + "']"));
            WebElement premium = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container']//div[@id='premium_" + uiRowIndex + "']"));
            String reduction = "";
            if (SharedData.getDbName().toLowerCase().contains("exch")) {
                reduction = "APTC";
            } else if (SharedData.getDbName().toLowerCase().contains("coco")) {
                reduction = "SES";
            }
            WebElement taxCredit = basicActions.getDriver().findElement(By.xpath("//div[@class='"+planType.toLowerCase()+"-plan-container']//div[@id='plan"+reduction+"_" + uiRowIndex + "']"));

            softAssert.assertEquals(dbStartDateValue, financialStartDate.getText(), "Mismatch in member_financial_start_date for row " + uiRowIndex);
            softAssert.assertEquals(dbEndDateValue, financialEndDate.getText(), "Mismatch in member_financial_end_date for row " + uiRowIndex);
            softAssert.assertEquals("$"+dbRow.get(2), premium.getText(), "Mismatch in plan_premium_amt for row " + uiRowIndex);
            softAssert.assertEquals("$"+dbRow.get(3), taxCredit.getText(), "Mismatch in premium_reduction_amt for row " + uiRowIndex);
            uiRowIndex++;
        }
        softAssert.assertAll();
    }

    public void validateCurrentPlanSummaryDB(String planType, Integer memberNum) throws Exception {
        List<List<String>> dbValuesList = mpDbDataProvider.getManagePlansPlanSummary(planType);
        System.out.println("Query executed, returned values: " + dbValuesList);

        if (dbValuesList.isEmpty()) {
            throw new RuntimeException("No data returned for account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'");
        }

        List<String> selectedRow = dbValuesList.get(0);
        Map<String, String> financials = calculateCurrentPlanFinancials(dbValuesList, memberNum, planType);

        CurrentPlanElements elements = getCurrentPlanWebElements(planType, financials.get("reduction"));

        softAssert.assertEquals("Current " + planType + " Plan:", elements.currentPolicyTxt.getText(), "Mismatch in currentPolicyTxt");
        softAssert.assertEquals("Select a policy:\n" + selectedRow.get(0) + " - " + financials.get("policyStartDate") + " - " + selectedRow.get(2), elements.currentPolicyData.getText(), "Mismatch in currentPolicyData");
        softAssert.assertEquals(selectedRow.get(3), elements.planName.getText(), "Mismatch in planName");
        softAssert.assertEquals("Policy Coverage: " + financials.get("policyStartDate") + " to " + financials.get("policyEndDate"), elements.policyCoverageDates.getText(), "Mismatch in policyCoverageDates");
        softAssert.assertEquals("Latest Application Date:", elements.latestApplicationDateTxt.getText(), "Mismatch in latestApplicationDateTxt");
        softAssert.assertEquals(financials.get("latestAppDate"), elements.latestApplicationDateData.getText(), "Mismatch in latestApplicationDateData");
        softAssert.assertEquals("Financial Start Date:", elements.financialStartDateTxt.getText(), "Mismatch in financialStartDateTxt");
        softAssert.assertEquals(financials.get("financialStartDate"), elements.financialStartDateData.getText(), "Mismatch in financialStartDateData");
        softAssert.assertEquals("EHB Premium:", elements.ehbPremiumTxt.getText(), "Mismatch in ehbPremiumTxt");
        softAssert.assertEquals(financials.get("ehbPremium"), elements.ehbPremiumData.getText(), "Mismatch in ehbPremiumData");
        softAssert.assertEquals("Financial End Date:", elements.financialEndDateTxt.getText(), "Mismatch in financialEndDateTxt");
        softAssert.assertEquals(financials.get("financialEndDate"), elements.financialEndDateData.getText(), "Mismatch in financialEndDateData");
        softAssert.assertEquals("CSR Amount:", elements.csrAmountTxt.getText(), "Mismatch in csrAmountTxt");
        softAssert.assertEquals(financials.get("csrAmount"), elements.csrAmountData.getText(), "Mismatch in csrAmountData");
        softAssert.assertEquals("Plan Premium:", elements.planPremiumTxt.getText(), "Mismatch in planPremiumTxt");
        softAssert.assertEquals(financials.get("premium"), elements.planPremiumData.getText(), "Mismatch in planPremiumData");
        softAssert.assertEquals("Latest LCE and Date:", elements.latestLceandDateTxt.getText(), "Mismatch in latestLceandDateTxt");
        softAssert.assertEquals(financials.get("latestLceText"), elements.latestLceandDateData.getText().toLowerCase(), "Mismatch in latestLceandDateData");
        softAssert.assertEquals("Plan " + financials.get("reduction") + ":", elements.planReductionTxt.getText(), "Mismatch in planReductionTxt");
        softAssert.assertEquals(financials.get("aptc"), elements.planReductionData.getText(), "Mismatch in planReductionData");
        softAssert.assertEquals("Rating Area:", elements.ratingAreaTxt.getText(), "Mismatch in ratingAreaTxt");
        softAssert.assertEquals(selectedRow.get(14).replace("Rating Area ", ""), elements.ratingAreaData.getText(), "Mismatch in ratingAreaData");
        softAssert.assertEquals("Premium after Subsidy:", elements.premiumAfterSubsidyTxt.getText(), "Mismatch in premiumAfterSubsidyTxt");
        softAssert.assertEquals(financials.get("premiumAfterSubsidy"), elements.premiumAfterSubsidyData.getText(), "Mismatch in premiumAfterSubsidyData");
        softAssert.assertEquals("Service Area:", elements.serviceAreaTxt.getText(), "Mismatch in serviceAreaTxt");
        softAssert.assertEquals(selectedRow.get(15), elements.serviceAreaData.getText(), "Mismatch in serviceAreaData");
        softAssert.assertEquals("Plan AV:", elements.planAvTxt.getText(), "Mismatch in planAvTxt");
        softAssert.assertEquals(financials.get("planAv"), elements.planAvData.getText(), "Mismatch in planAvData");
        softAssert.assertEquals("Policy ID:", elements.policyIdTxt.getText(), "Mismatch in policyIdTxt");
        softAssert.assertEquals(selectedRow.get(0), elements.policyIdData.getText(), "Mismatch in policyIdData");
        elements.policyIdTxt.click();
        String clipboardText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        softAssert.assertEquals(clipboardText, selectedRow.get(0), "Clipboard data mismatch");
        softAssert.assertEquals("HIOS ID:", elements.hiosIdTxt.getText(), "Mismatch in hiosIdTxt");
        softAssert.assertEquals(selectedRow.get(17), elements.hiosIdData.getText(), "Mismatch in hiosIdData");

        softAssert.assertAll();
    }

    private Map<String, String> calculateCurrentPlanFinancials(List<List<String>> rows, int memberNum, String planType) {
        Map<String, String> values = new HashMap<>();
        List<String> firstRow = rows.get(0);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");

        String policyStart = basicActions.changeDateFormat(firstRow.get(1), "yyyy-MM-dd", "MM/dd/yyyy");
        String policyEnd = basicActions.changeDateFormat(firstRow.get(4), "yyyy-MM-dd", "MM/dd/yyyy");
        String latestApp = basicActions.changeDateTimeFormat(firstRow.get(5), "MM/dd/yyyy");

        BigDecimal ehbPercent = new BigDecimal(firstRow.get(7));
        BigDecimal totalPremium = BigDecimal.ZERO, totalCsr = BigDecimal.ZERO, totalAptc = BigDecimal.ZERO;

        for (int i = 0; i < memberNum; i++) {
            List<String> row = rows.get(i);
            totalPremium = totalPremium.add(new BigDecimal(row.get(8)));
            totalCsr = totalCsr.add(new BigDecimal(row.get(10)));
            totalAptc = totalAptc.add(new BigDecimal(row.get(13)));
        }

        String financialStart = rows.stream().map(r -> r.get(19)).filter(Objects::nonNull).map(d -> parseDateSafe(d, inputFormat)).filter(Objects::nonNull).max(Date::compareTo).map(outputFormat::format).orElse("");
        String financialEnd = basicActions.changeDateFormat(firstRow.get(18), "yyyy-MM-dd", "MM/dd/yyyy");
        String reduction = SharedData.getDbName().toLowerCase().contains("exch") ? "APTC" : "SES";
        String latestLce = rows.stream().map(r -> {
            try {
                Date lceDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(r.get(12));
                return Map.entry(lceDate, r.get(11));
            } catch (Exception e) {
                return null;
            }
        }).filter(Objects::nonNull).max(Map.Entry.comparingByKey()).map(e -> e.getValue().toLowerCase().replace("_", " ") + " " + new SimpleDateFormat("MM/dd/yyyy").format(e.getKey())).orElse("");

        BigDecimal ehbValue = ehbPercent.multiply(totalPremium).setScale(2, RoundingMode.HALF_UP);
        BigDecimal premiumAfterSubsidy = totalPremium.subtract(totalAptc).setScale(2, RoundingMode.HALF_UP);

        String dbPlanAvValue = "";
        if (firstRow.get(16) != null && !firstRow.get(16).trim().isEmpty()) {
            BigDecimal av = new BigDecimal(firstRow.get(16).trim());
            dbPlanAvValue = av.compareTo(BigDecimal.ZERO) == 0
                    ? (planType.equalsIgnoreCase("Dental") ? "0.00%" : "")
                    : av.multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP) + "%";
        }

        values.put("policyStartDate", policyStart);
        values.put("policyEndDate", policyEnd);
        values.put("latestAppDate", latestApp);
        values.put("financialStartDate", financialStart);
        values.put("financialEndDate", financialEnd);
        values.put("ehbPremium", "$" + ehbValue);
        values.put("csrAmount", "$" + totalCsr.setScale(2, RoundingMode.HALF_UP));
        values.put("premium", "$" + totalPremium);
        values.put("aptc", "$" + totalAptc);
        values.put("premiumAfterSubsidy", "$" + premiumAfterSubsidy);
        values.put("planAv", dbPlanAvValue);
        values.put("latestLceText", latestLce);
        values.put("reduction", reduction);

        return values;
    }

    private Date parseDateSafe(String dateStr, SimpleDateFormat format) {
        try {
            return format.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    public class CurrentPlanElements {
        public WebElement currentPolicyTxt;
        public WebElement currentPolicyData;
        public WebElement planName;
        public WebElement policyCoverageDates;
        public WebElement latestApplicationDateTxt;
        public WebElement latestApplicationDateData;
        public WebElement financialStartDateTxt;
        public WebElement financialStartDateData;
        public WebElement ehbPremiumTxt;
        public WebElement ehbPremiumData;
        public WebElement financialEndDateTxt;
        public WebElement financialEndDateData;
        public WebElement csrAmountTxt;
        public WebElement csrAmountData;
        public WebElement planPremiumTxt;
        public WebElement planPremiumData;
        public WebElement latestLceandDateTxt;
        public WebElement latestLceandDateData;
        public WebElement planReductionTxt;
        public WebElement planReductionData;
        public WebElement ratingAreaTxt;
        public WebElement ratingAreaData;
        public WebElement premiumAfterSubsidyTxt;
        public WebElement premiumAfterSubsidyData;
        public WebElement serviceAreaTxt;
        public WebElement serviceAreaData;
        public WebElement planAvTxt;
        public WebElement planAvData;
        public WebElement policyIdTxt;
        public WebElement policyIdData;
        public WebElement hiosIdTxt;
        public WebElement hiosIdData;
    }

    private CurrentPlanElements getCurrentPlanWebElements(String planType, String reduction) {
        CurrentPlanElements elements = new CurrentPlanElements();
        String base = "//div[@class='" + planType.toLowerCase() + "-plan-container plan-container-fill']";

        WebDriver driver = basicActions.getDriver();

        elements.currentPolicyTxt = driver.findElement(By.xpath(base + "//app-current-plan/div/div[1]/p"));
        elements.currentPolicyData = driver.findElement(By.xpath(base + "//app-current-plan/div/div[1]/div"));
        elements.planName = driver.findElement(By.xpath(base + "//*[@id=\"enrollment-info\"]/div/div[1]"));
        elements.policyCoverageDates = driver.findElement(By.xpath(base + "//div[contains(text(), 'Policy Coverage')]"));
        elements.latestApplicationDateTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'Latest Application Date')]"));
        elements.latestApplicationDateData = driver.findElement(By.xpath(base + "//div[contains(text(), 'Latest Application Date')]//following::div[1]"));
        elements.financialStartDateTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'Financial Start Date')]"));
        elements.financialStartDateData = driver.findElement(By.xpath(base + "//div[contains(text(), 'Financial Start Date')]//following::div[1]"));
        elements.ehbPremiumTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'EHB Premium')]"));
        elements.ehbPremiumData = driver.findElement(By.xpath(base + "//div[contains(text(), 'EHB Premium')]//following::div[1]"));
        elements.financialEndDateTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'Financial End Date')]"));
        elements.financialEndDateData = driver.findElement(By.xpath(base + "//div[contains(text(), 'Financial End Date')]//following::div[1]"));
        elements.csrAmountTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'CSR Amount')]"));
        elements.csrAmountData = driver.findElement(By.xpath(base + "//div[contains(text(), 'CSR Amount')]//following::div[1]"));
        elements.planPremiumTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'Plan Premium')]"));
        elements.planPremiumData = driver.findElement(By.xpath(base + "//div[contains(text(), 'Plan Premium')]//following::div[1]"));
        elements.latestLceandDateTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'Latest LCE and Date')]"));
        elements.latestLceandDateData = driver.findElement(By.xpath(base + "//div[contains(text(), 'Latest LCE and Date')]//following::div[1]"));
        elements.planReductionTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'Plan " + reduction + "')]"));
        elements.planReductionData = driver.findElement(By.xpath(base + "//div[contains(text(), 'Plan " + reduction + "')]//following::div[1]"));
        elements.ratingAreaTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'Rating Area')]"));
        elements.ratingAreaData = driver.findElement(By.xpath(base + "//div[contains(text(), 'Rating Area')]//following::div[1]"));
        elements.premiumAfterSubsidyTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'Premium after Subsidy')]"));
        elements.premiumAfterSubsidyData = driver.findElement(By.xpath(base + "//div[contains(text(), 'Premium after Subsidy')]//following::div[1]"));
        elements.serviceAreaTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'Service Area')]"));
        elements.serviceAreaData = driver.findElement(By.xpath(base + "//div[contains(text(), 'Service Area')]//following::div[1]"));
        elements.planAvTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'Plan AV')]"));
        elements.planAvData = driver.findElement(By.xpath(base + "//div[contains(text(), 'Plan AV')]//following::div[1]"));
        elements.policyIdTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'Policy ID')]"));
        elements.policyIdData = driver.findElement(By.xpath(base + "//div[contains(text(), 'Policy ID')]//following::div[1]"));
        elements.hiosIdTxt = driver.findElement(By.xpath(base + "//div[contains(text(), 'HIOS ID')]"));
        elements.hiosIdData = driver.findElement(By.xpath(base + "//div[contains(text(), 'HIOS ID')]//following::div[1]"));

        return elements;
    }




}
