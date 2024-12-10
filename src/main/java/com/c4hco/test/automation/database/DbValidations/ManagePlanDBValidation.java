package com.c4hco.test.automation.database.DbValidations;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.utils.BasicActions;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.List;

public class ManagePlanDBValidation {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    List<PolicyTablesEntity> medicalPolicyEntities = new ArrayList<>();
    List<PolicyTablesEntity> dentalPolicyEntities = new ArrayList<>();
    SoftAssert softAssert = new SoftAssert();
    BasicActions basicActions = new BasicActions();


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
}
