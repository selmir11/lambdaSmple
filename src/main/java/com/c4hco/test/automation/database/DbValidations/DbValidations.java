package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.*;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.database.dbDataProvider.DataProviderDb_qa_coco;
import com.c4hco.test.automation.utils.BasicActions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DbValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();
    String formattedDate; //formatted in YYYY-MM-DD

    BasicActions basicActions = new BasicActions();
    List<PolicyTablesEntity> PolicyTableEntity;
    List<String> applicationIdListFromPolicyAh;
    List<String> policyIdFromPolicyDB;
    public String getCurrentdate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter dateCreateUpdateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formattedDate = currentDate.format(dateCreateUpdateformat);
        return currentDate.format(formatter);
    }

    public void validateMemberExistsInPolicyTable() {
        List<PolicyTablesEntity> policyEntity = exchDbDataProvider.getDataFromPolicyTables();
        Assert.assertFalse(policyEntity.isEmpty(), "No records exists with this account number in Policy table");
        softAssert.assertAll();
    }

    public void validateOhcDetails(String memPrefix) {
        Boolean hasRecords = exchDbDataProvider.getDataFromOhcTables(basicActions.getMemberId(memPrefix));
        Assert.assertFalse(hasRecords, "Query returned records");
        softAssert.assertAll();
    }

    public void validateOhcOptions(String memPrefix, List<Map<String, String>> expectedValues) {
        EsMemberOhcEntity actualResult = exchDbDataProvider.getOptionsFromOhcDbTables(basicActions.getMemberId(memPrefix));
        System.out.println(actualResult);

        softAssert.assertEquals(actualResult.getEmp_sponsored_covg_ind(), expectedValues.get(0).get("emp_sponsored_covg_ind"));
        softAssert.assertEquals(actualResult.getMedicare_ind(), expectedValues.get(0).get("medicare_ind"));
        softAssert.assertEquals(actualResult.getVa_health_care_ind(), expectedValues.get(0).get("va_health_care_ind"));
        softAssert.assertEquals(actualResult.getCobra_ind(), expectedValues.get(0).get("cobra_ind"));
        softAssert.assertEquals(actualResult.getRetiree_health_plan_ind(), expectedValues.get(0).get("retiree_health_plan_ind"));
        softAssert.assertEquals(actualResult.getTricare_ind(), expectedValues.get(0).get("tricare_ind"));
        softAssert.assertEquals(actualResult.getPeace_corps_ind(), expectedValues.get(0).get("peace_corps_ind"));
        softAssert.assertEquals(actualResult.getHealth_plus_plan_ind(), expectedValues.get(0).get("health_plus_plan_ind"));
        softAssert.assertEquals(actualResult.getChild_health_plan_plus_ind(), expectedValues.get(0).get("child_health_plan_plus_ind"));
        softAssert.assertEquals(actualResult.getIndividual_insurance_ind(), expectedValues.get(0).get("individual_insurance_ind"));
        softAssert.assertEquals(actualResult.getHra_ind(), expectedValues.get(0).get("hra_ind"));
        softAssert.assertEquals(actualResult.getMedicare_parta_ind(), expectedValues.get(0).get("medicare_parta_ind"));
        softAssert.assertEquals(actualResult.getMedicare_partb_ind(), expectedValues.get(0).get("medicare_partb_ind"));
        softAssert.assertEquals(actualResult.getMedicare_premium_amount(), expectedValues.get(0).get("medicare_premium_amount"));
        softAssert.assertEquals(actualResult.getMedicare_prem_parta_ind3(), expectedValues.get(0).get("medicare_prem_parta_ind3"));
        softAssert.assertEquals(actualResult.getMedicare_parta_end_soon_ind3(), expectedValues.get(0).get("medicare_parta_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getMedicare_partb_end_soon_ind3(), expectedValues.get(0).get("medicare_partb_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getMedicare_no_premium_paid_ind(), expectedValues.get(0).get("medicare_no_premium_paid_ind"));
        softAssert.assertEquals(actualResult.getIndv_ins_enrl_covg_ind3(), expectedValues.get(0).get("indv_ins_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getIndv_ins_covg_end_soon_ind3(), expectedValues.get(0).get("indv_ins_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getIndv_ins_end_voluntary_ind3(), expectedValues.get(0).get("indv_ins_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_end_soon_ind3(), expectedValues.get(0).get("emp_coverage_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_min_std_ind3(), expectedValues.get(0).get("emp_coverage_min_std_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_monthly_prem_amt(), expectedValues.get(0).get("emp_coverage_monthly_prem_amt"));
        softAssert.assertEquals(actualResult.getEnrl_emp_sponsored_covg_ind3(), expectedValues.get(0).get("enrl_emp_sponsored_covg_ind3"));
        softAssert.assertEquals(actualResult.getEmp_end_voluntary_ind3(), expectedValues.get(0).get("emp_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_family_plan_offered_ind3(), expectedValues.get(0).get("emp_coverage_family_plan_offered_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_family_prem_amount(), expectedValues.get(0).get("emp_coverage_family_prem_amount"));
        softAssert.assertEquals(actualResult.getCobra_enrl_covg_ind3(), expectedValues.get(0).get("cobra_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getCobra_covg_end_soon_ind3(), expectedValues.get(0).get("cobra_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getCobra_end_voluntary_ind3(), expectedValues.get(0).get("cobra_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getVa_enrl_covg_ind3(), expectedValues.get(0).get("va_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getVa_covg_end_soon_ind3(), expectedValues.get(0).get("va_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getVa_end_voluntary_ind3(), expectedValues.get(0).get("va_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getRetiree_enrl_covg_ind3(), expectedValues.get(0).get("retiree_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getRetiree_covg_end_soon_ind3(), expectedValues.get(0).get("retiree_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getRetiree_end_voluntary_ind3(), expectedValues.get(0).get("retiree_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getTricare_enrl_covg_ind3(), expectedValues.get(0).get("tricare_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getTricare_covg_end_soon_ind3(), expectedValues.get(0).get("tricare_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getTricare_end_voluntary_ind3(), expectedValues.get(0).get("tricare_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getPeace_corps_enrl_covg_ind3(), expectedValues.get(0).get("peace_corps_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getPeace_corps_covg_end_soon_ind3(), expectedValues.get(0).get("peace_corps_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getCurr_year_esi_afford_ind3(), expectedValues.get(0).get("curr_year_esi_afford_ind3"));
        softAssert.assertEquals(actualResult.getNext_year_esi_afford_ind3(), expectedValues.get(0).get("next_year_esi_afford_ind3"));
        softAssert.assertEquals(actualResult.getCurr_year_esi_family_afford_ind3(), expectedValues.get(0).get("curr_year_esi_family_afford_ind3"));
        softAssert.assertEquals(actualResult.getNext_year_esi_family_afford_ind3(), expectedValues.get(0).get("next_year_esi_family_afford_ind3"));
        softAssert.assertAll();
    }

    public void validateHraOptions(List<Map<String, String>> expectedValues) {
        EsMemberHraEntity actualResult = exchDbDataProvider.getOptionsFromHraDbTables();
        System.out.println(actualResult);

        softAssert.assertEquals(actualResult.getPlan_year(), expectedValues.get(0).get("plan_year"));
        softAssert.assertEquals(actualResult.getEmplr_hra_ctb(), expectedValues.get(0).get("emplr_hra_ctb"));
        softAssert.assertEquals(actualResult.getHra_type(), expectedValues.get(0).get("hra_type"));
        softAssert.assertEquals(actualResult.getEmplr_ctb_optout_ind(), expectedValues.get(0).get("emplr_ctb_optout_ind"));
        softAssert.assertEquals(actualResult.getHra_not_affordable_ind(), expectedValues.get(0).get("hra_not_affordable_ind"));
        softAssert.assertAll();
    }

    public void validatePolicyDqCheck(int keysetSize) {
        Map<String, String> policyAhId = exchDbDataProvider.getPolicyDqCheckAndPolicyAhId();
        softAssert.assertEquals(policyAhId.keySet().size(), keysetSize, "Policy Ah Id keyset size does not match");
        for (String key : policyAhId.keySet()) {
            softAssert.assertEquals(policyAhId.get(key), "0", "Doesn't match policyAhId.get(key)");
        }
        softAssert.assertAll();
    }

    public void validateBookOfBusinessQ(String eventType) {
        getCurrentdate();
        List<BookOfBusinessQEntity> bookOfBusinessQList = exchDbDataProvider.getBookOfBusinessQ(eventType);
        List<String> policyIdListFromBookOfBusinessDb = new ArrayList<>();
        List<String> applicationIdListFromBob = new ArrayList<>();

        // WIP - get these from existing policyTables instead of new tables/queries.
        applicationIdListFromPolicyAh = exchDbDataProvider.getApplicationId();
        policyIdFromPolicyDB = exchDbDataProvider.getPolicyId();

        for (BookOfBusinessQEntity bookOfBusinessQEntity : bookOfBusinessQList) {
            softAssert.assertEquals(bookOfBusinessQEntity.getExchange(), "c4hco_direct_exchange", "Bob exchange mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getRouting_key(), "book_of_business_q", "Bob routing key mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getPolicyplanyr(), SharedData.getPlanYear(), "Bob plan year mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getStatus(), "PROCESSED", "BOB Status mismatch");
            softAssert.assertTrue(bookOfBusinessQEntity.getCreated_ts().contains(formattedDate), "Bob created date mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getEventtype(), eventType, "Bob, event type updated does not match " + eventType);
            policyIdListFromBookOfBusinessDb.add(bookOfBusinessQEntity.getPolicyid());
            applicationIdListFromBob.add(bookOfBusinessQEntity.getApplicationid());
        }
        softAssert.assertEquals(applicationIdListFromPolicyAh.size(), bookOfBusinessQList.size(), "No of records does not match for event type " + eventType);
        softAssert.assertTrue(new HashSet<>(applicationIdListFromBob).containsAll(applicationIdListFromPolicyAh), "application id mismatch");
        softAssert.assertTrue(new HashSet<>(policyIdListFromBookOfBusinessDb).containsAll(policyIdFromPolicyDB), "Policy Id mismatch ");
        softAssert.assertAll();

    }

    public void validateBobByApplicationId(String eventType) {
        getCurrentdate();
        List<BookOfBusinessQEntity> bookOfBusinessQListByAppId = exchDbDataProvider.getBoBQueryByApplicationId(eventType);
        List<String> policyIdListFromBookOfBusinessDb = new ArrayList<>();
        List<String> applicationIdListFromBob = new ArrayList<>();
        
        applicationIdListFromPolicyAh = exchDbDataProvider.getApplicationId();
        policyIdFromPolicyDB = exchDbDataProvider.getPolicyId();

        for (BookOfBusinessQEntity bookOfBusinessQEntity : bookOfBusinessQListByAppId) {
            softAssert.assertEquals(bookOfBusinessQEntity.getExchange(), "c4hco_direct_exchange", "Bob exchange mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getRouting_key(), "book_of_business_q", "Bob routing key mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getPolicyplanyr(), SharedData.getPlanYear(), "Bob plan year mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getStatus(), "PROCESSED", "BOB Status mismatch");
            softAssert.assertTrue(bookOfBusinessQEntity.getCreated_ts().contains(formattedDate), "Bob created date mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getEventtype(), eventType, "Bob, event type updated does not match " + eventType);
            policyIdListFromBookOfBusinessDb.add(bookOfBusinessQEntity.getPolicyid());
            applicationIdListFromBob.add(bookOfBusinessQEntity.getApplicationid());
        }
        softAssert.assertEquals(2, bookOfBusinessQListByAppId.size(), "No of records does not match for event type " + eventType);

        Set<String> uniqueAppIds = new HashSet<>(applicationIdListFromBob);
        softAssert.assertTrue(uniqueAppIds.contains(SharedData.getPrimaryMember().getApplication_id()), "application id mismatch");

        softAssert.assertTrue(new HashSet<>(policyIdListFromBookOfBusinessDb).containsAll(policyIdFromPolicyDB), "Policy Id mismatch ");
        softAssert.assertAll();
    }

   public void validateBookOfBusinessQMedical(String coverageType, String eventType){
        switch(coverageType) {
            case "medical":
                PolicyTableEntity = SharedData.getMedicalPolicyTablesEntities();
                break;
            case "dental":
                PolicyTableEntity = SharedData.getDentalPolicyTablesEntities();
                break;
            default:
                Assert.fail("Coverage Type entered is not valid");
        }
       HashSet<String> PolicyIds = new HashSet<>();
      for(PolicyTablesEntity entity: PolicyTableEntity){
          PolicyIds.add(entity.getPolicy_id());
      }
       getCurrentdate();
       List<BookOfBusinessQEntity> bookOfBusinessQList = exchDbDataProvider.getBookOfBusinessQ(eventType);

       applicationIdListFromPolicyAh = exchDbDataProvider.getApplicationId();
       List<String> uniqueApplicationId = new ArrayList<>(new HashSet<>(applicationIdListFromPolicyAh));
       policyIdFromPolicyDB = exchDbDataProvider.getPolicyId();
       for (BookOfBusinessQEntity bookOfBusinessQEntity : bookOfBusinessQList) {
           if(bookOfBusinessQEntity.getEventtype().equals(eventType)){
               softAssert.assertEquals(bookOfBusinessQEntity.getExchange(), "c4hco_direct_exchange", " BOB, exchange mismatch");
               softAssert.assertEquals(bookOfBusinessQEntity.getRouting_key(), "book_of_business_q", " BOB, routing key mismatch");
               softAssert.assertEquals(bookOfBusinessQEntity.getPolicyplanyr(), SharedData.getPlanYear(), " BOB, plan year mismatch");
               softAssert.assertEquals(bookOfBusinessQEntity.getStatus(), "PROCESSED", " BOB, Status mismatch");
               softAssert.assertTrue(bookOfBusinessQEntity.getCreated_ts().contains(formattedDate), " BOB,Bob created date mismatch");
               softAssert.assertTrue(PolicyIds.contains(bookOfBusinessQEntity.getPolicyid()), " BOB,Policy Id mismatch ");
               softAssert.assertTrue(applicationIdListFromPolicyAh.contains(bookOfBusinessQEntity.getApplicationid()), " BOB,application id mismatch");
               softAssert.assertEquals(uniqueApplicationId.size(), bookOfBusinessQList.size(), "No of records does not match for event type " + eventType);
               softAssert.assertAll();
           }
       }
   }

    public void validateAccountHolderNameFromBOB() {
        List<String> acct_holderBOB = exchDbDataProvider.getAccount_holder_fn();
        softAssert.assertEquals(SharedData.getPrimaryMember().getFirstName(), acct_holderBOB.get(0));
        softAssert.assertAll();
    }

    public void verifyUpdatedEmailAddressBOB() {
        List<String> clientEmailBOB = exchDbDataProvider.getClientEmailInBoB();
        softAssert.assertEquals(SharedData.getPrimaryMember().getEmailId(), clientEmailBOB.get(0));
        softAssert.assertAll();
    }

    public void validateBrokerAuthorizationBob(String expectedBrokerName) {
        String clientFirstName = SharedData.getPrimaryMember().getFirstName();
        List<String> brokerAuthBOB = exchDbDataProvider.getBrokerAuthorizationInBoB(clientFirstName);
        softAssert.assertEquals(brokerAuthBOB.get(0), expectedBrokerName);
        softAssert.assertAll();
    }

    public void validateApplicationSubmissionBob() {
        List<String> applicationSubmissionBOB = exchDbDataProvider.getApplicationSubmissionInBoB();
        softAssert.assertEquals(applicationSubmissionBOB.size(), 1);
        softAssert.assertAll();
    }

    public void validatePolicySubmissionBob(int expectedRecords, int coverageType) {
        List<String> policySubmissionBOB = exchDbDataProvider.getPolicySubmissionInBoB(coverageType);
        softAssert.assertEquals(policySubmissionBOB.size(), expectedRecords);
        softAssert.assertAll();
    }

    public void validateNoMedicalPolicySubmissionBob() {
        Boolean hasRecords = exchDbDataProvider.getNoMedicalPolicySubmissionInBoB();
        Assert.assertFalse(hasRecords, "Query returned records");
        softAssert.assertAll();
    }

    public void verifyAgencyCommissionTinDb() {
        String expectedAgencyTin = SharedData.getAgencyOwner().getAgencyTin();
        List<String> agencyTinDb = exchDbDataProvider.getAgencyCommissionTinDb();
        softAssert.assertEquals(agencyTinDb.get(0), expectedAgencyTin);
        softAssert.assertAll();
    }

    public void verifyExchHouseholdIdDb() {
        Boolean hasRecords = exchDbDataProvider.getExchHouseholdIdBoB();
        Assert.assertTrue(hasRecords, "Query returned no records");
        softAssert.assertAll();
    }

    public void verifyPasswordResetNotArchivedDb(String accountStg, String accountQa) {
        MemberDetails user = new MemberDetails();
        String currentDate = basicActions.changeDateFormat(basicActions.getTodayDate(), "MM/dd/yyyy", "M/d/yyyy");

        if(SharedData.getEnv().equals("staging")){
            user.setAccount_id(new BigDecimal(accountStg));
        } else{
            user.setAccount_id(new BigDecimal(accountQa));
        }
        SharedData.setPrimaryMember(user);

        Boolean hasRecords = exchDbDataProvider.getPasswordResetNotArchivedDb(currentDate);
        Assert.assertFalse(hasRecords, "Query returned records");
        softAssert.assertAll();
    }

    public void verifyBrokerAuthorizationStatusDb() {
        List<String> authorizationStatusDB = exchDbDataProvider.getBrokerAuthorizationStatusBoB();
        Assert.assertEquals(authorizationStatusDB.get(0), "AUTHORIZATION_REVOKED_CLIENT");
        softAssert.assertAll();
    }

    public void verifyBrokerAuthorizationTypeDb(String expectedBrokerType) {
        List<String> authorizationStatusDB = exchDbDataProvider.getBrokerAuthorizationTypeBoB();
        Assert.assertEquals(authorizationStatusDB.get(0), expectedBrokerType);
        softAssert.assertAll();
    }

    public void validateHraAhOptions(List<Map<String, String>> expectedValues) {
        EsMemberHraAhEntity actualResult = exchDbDataProvider.getOptionsFromHraAhDbTables();
        System.out.println(actualResult);

        softAssert.assertEquals(actualResult.getPlan_year(), expectedValues.get(0).get("plan_year"));
        softAssert.assertEquals(actualResult.getEmplr_hra_ctb(), expectedValues.get(0).get("emplr_hra_ctb"));
        softAssert.assertEquals(actualResult.getHra_type(), expectedValues.get(0).get("hra_type"));
        softAssert.assertEquals(actualResult.getEmplr_ctb_optout_ind(), expectedValues.get(0).get("emplr_ctb_optout_ind"));
        softAssert.assertEquals(actualResult.getHra_not_affordable_ind(), expectedValues.get(0).get("hra_not_affordable_ind"));
        softAssert.assertAll();
    }

    public void validateDatabaseEmail() {
        EsHouseholdContactEntity actualResult = exchDbDataProvider.getEsHouseholdContactDetails();

        softAssert.assertEquals(actualResult.getEmail(), SharedData.getPrimaryMember().getEmailId());
        System.out.println("Account  Email " + SharedData.getPrimaryMember().getEmailId());
        System.out.println("Database Email " + actualResult.getEmail());
        softAssert.assertAll();
    }

    
    public void validateDatabaseMedicalPlanList() {
        List<String> medicalPlanList = exchDbDataProvider.getDBMedicalPlanList();
        List<String> expectedMedicalPlanList = SharedData.getMedicalPlansList();
        softAssert.assertEquals(medicalPlanList, expectedMedicalPlanList, "Medical plan lists do not match!");
        softAssert.assertAll();}

    public void validateMemberCSRNonAIANData(String reasonCode) {
        String[] dbValues = exchDbDataProvider.getmemberNonAIAN(reasonCode);
        softAssert.assertEquals(dbValues[0], "NON_AIAN_LEVEL_3", "Reason code mismatch: Expected 'NONAIAN'");
        softAssert.assertEquals(dbValues[1], "CSR", "Eligibility type mismatch: Expected 'CSR'");
        softAssert.assertAll();
    }

    public void validateApplicationResult(String expectedReasonCode, String memPrefix) {
        String determination = getDeterminationValue(expectedReasonCode);

        if(memPrefix.equals("getFromSharedData")){
           memPrefix = SharedData.getPrimaryMember().getFirstName();
        }

        String memberID = basicActions.getMemberId(memPrefix);
        String reasonCode = exchDbDataProvider.getReasonCode(memberID, determination);

        softAssert.assertEquals(reasonCode, expectedReasonCode, "Reason Code validation failed");
        softAssert.assertAll();
    }

    private String getDeterminationValue(String expectedReasonCode){
        String determination = null;
        switch (expectedReasonCode) {
            case "OFF_EXCHANGE_ELIGIBLE", "OFF_EXCHANGE_NOT_ELIGIBLE":
                determination= "OFFEXCH";
                break;
            case "ELIGIBLE_FOR_HP2_LIMITED", "ELIGIBLE_FOR_HP2":
                determination = "HP2";
                break;
            case "QLCE":
                determination = "GAIN_DEP_QLCE";
                break;
            case "NO_TAX_TIME_ENROLLMENT_ELIGIBILITY":
                determination = "TAX_TIME_ENROLLMENT_QLCE";
                break;
            case "TAX_TIME_ENROLLMENT_ELIGIBILITY":
                determination = "TAX_TIME_ENROLLMENT_QLCE";
                break;
            default:
                Assert.fail("Expected Reason Code is not valid");
        }
        return determination;
    }

    public void validateCreatedBy(String createdBy, String memPrefix, String expectedReasonCode){
        String determination = getDeterminationValue(expectedReasonCode);

        if(memPrefix.equals("getFromSharedData")){
            memPrefix = SharedData.getPrimaryMember().getFirstName();
        }

        String memberID = basicActions.getMemberId(memPrefix);
        String createdByFromDb = exchDbDataProvider.getCreatedBy(memberID, determination);
        softAssert.assertEquals(createdByFromDb, createdBy, "CreatedBy validation failed");
        softAssert.assertAll();
    }


    public void validateCurrentDentalPlanNameForTheYear(String year) {
        String dbdentalPlanName = exchDbDataProvider.getPlanMarketingName(year);
        softAssert.assertEquals(dbdentalPlanName,SharedData.getManagePlanDentalMedicalPlan().getPlanMarketingName());
        softAssert.assertAll();

    }

    public void validateCurrentDentalPolicyStartAndEndDateForTheYearDB() {
        String [] policyDate = exchDbDataProvider.getDentalPolicyDate();

        String dateStr = policyDate[0];
        String dateEnd = policyDate[1];
        String formattedDateSTR = basicActions.changeDateFormat(dateStr ,"yyyy-MM-dd","MM/dd/yyyy");
        String formattedDateEnd = basicActions.changeDateFormat(dateEnd ,"yyyy-MM-dd","MM/dd/yyyy");
        String coverageDate = formattedDateSTR+" to "+formattedDateEnd;
        softAssert.assertTrue(SharedData.getManagePlanDentalMedicalPlan().getPolicyCoverageDate().contains(coverageDate));
        softAssert.assertAll();
    }


    public void validateDatabaseRaceEthnicity(String expectedRaceEthnicity, String expectedRaceOtherText) {
        String[] dbValues = exchDbDataProvider.getEsMemberRaceEthnicityDetails();
        softAssert.assertEquals(dbValues[0], expectedRaceEthnicity, "Race/Ethnicity mismatch");

        if (expectedRaceOtherText.equals("null")) {
            softAssert.assertNull(dbValues[1], "Race Other Text is null");
        } else {
            softAssert.assertEquals(dbValues[1], expectedRaceOtherText, "Race Other Text mismatch");
        }
        softAssert.assertAll();
    }

    public void validateTheLatestApplicationDateForTheYearDB() {
       String medLatestAppDateDB = exchDbDataProvider.getMedLatestApplicationDate();
       softAssert.assertTrue(medLatestAppDateDB.contains(SharedData.getManagePlanDentalMedicalPlan().getMedLatestAppDate()));
        softAssert.assertAll();
    }

    public void validateTheSecondMedicalPoliciyForTheYearDB(String year) {
        String[] medSecondPolicy = exchDbDataProvider.getMedSecondPolicy(year);
        String inputDate = medSecondPolicy[1];
        String formattedDate = basicActions.changeDateFormat(inputDate,"yyyy-MM-dd","MM/dd/yyyy");
        System.out.println("Formatted Date: " + formattedDate);
        String SecondMedicalPolicyDB = medSecondPolicy[0]+ " - " + formattedDate +" - " +medSecondPolicy[2];
        softAssert.assertEquals(SecondMedicalPolicyDB,SharedData.getManagePlanDentalMedicalPlan().getSelectMedSecondPolicyDrp());
        softAssert.assertAll();
    }

    public void validateTheSecondDentalPoliciyForTheYearDB(String year) {
        String[] denSecondPolicy = exchDbDataProvider.getDentSecondPolicy(year);
        String inputDate = denSecondPolicy[1];
        String formattedDate = basicActions.changeDateFormat(inputDate,"yyyy-MM-dd","MM/dd/yyyy");
        System.out.println("Formatted Date: " + formattedDate);
        String SecondMedicalPolicyDB = denSecondPolicy[0]+ " - " + formattedDate +" - " +denSecondPolicy[2];
        softAssert.assertEquals(SecondMedicalPolicyDB,SharedData.getManagePlanDentalMedicalPlan().getSelectDenSecondPolicyDrp());
        softAssert.assertAll();
    }

    public void validateMVR(List<Map<String, String>> expectedValues) {
        for (int i = 0; i < expectedValues.size(); i++) {
            Map<String, String> row = expectedValues.get(i);
            String manualVerificationType = row.get("manual_verification_type");

            EsManualVerifRequestEntity actualResult = exchDbDataProvider.getEsMVR_options(manualVerificationType);
            System.out.println(actualResult);

            for (Map.Entry<String, String> entry : row.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                switch (key) {
                    case "manual_verification_type":
                        softAssert.assertEquals(actualResult.getManual_verification_type(), value,"Validation failed for manual_verification_type at row " + (i + 1));
                        break;
                    case "manual_verif_status":
                        softAssert.assertEquals(actualResult.getManual_verif_status(), value, "Validation failed for manual_verif_status at row " + (i + 1));
                        break;
                    case "manual_verif_date_set":
                        softAssert.assertTrue(actualResult.getManual_verif_date_set().contains(addDaysDate(Integer.parseInt(value))),"Validation failed for manual_verif_date_set at row " + (i + 1));
                        break;
                    case "manual_verif_due_date":
                        softAssert.assertTrue(actualResult.getManual_verif_due_date().contains(addDaysDate(Integer.parseInt(value))),"Validation failed for manual_verif_due_date at row " + (i + 1));
                        break;
                    case "manual_verif_date_expired":
                        softAssert.assertTrue(actualResult.getManual_verif_date_expired().contains(addDaysDate(Integer.parseInt(value))),"Validation failed for manual_verif_date_expired at row " + (i + 1));
                        break;
                    case "manual_verif_date_closed":
                        softAssert.assertEquals(actualResult.getManual_verif_date_closed(), value,"Validation failed for manual_verif_date_closed at row " + (i + 1));
                        break;
                    case "last_action_description":
                        softAssert.assertEquals(actualResult.getLast_action_description(), value, "Validation failed for last_action_description at row " + (i + 1));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + key);
                }
            }
        }
        softAssert.assertAll();
    }

    public void validateMVRDoesNotExist(){
        Boolean hasRecords = exchDbDataProvider.getMVRDetails();
        Assert.assertFalse(hasRecords, "Query returned records");
        softAssert.assertAll();
    }

    public String addDaysDate(int daysAdded) {
        LocalDate currentDate = LocalDate.now();
        LocalDate newDate = currentDate.plusDays(daysAdded);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return newDate.format(outputFormatter);
    }

    public void verifySsaResponseCodeDb(String code, String memPrefix){
        EsSsaVerificationReqEntity actualResult = exchDbDataProvider.getSsaResponseCode(basicActions.getMemberId(memPrefix));
        System.out.println(actualResult);
        softAssert.assertEquals(actualResult.getRsp_tx_return_code(),code);
        softAssert.assertAll();
    }

    public void verifySsaResponseCodeDbByCreatedBy(String code){
        EsSsaVerificationReqEntity actualResult = exchDbDataProvider.getSsaResponseCodeByCreatedBy();
        System.out.println(actualResult);
        softAssert.assertEquals(actualResult.getRsp_tx_return_code(),code);
        softAssert.assertAll();
    }

    public void validateNewEventDB(String event) {
        List<String> savedEventIds = SharedData.getEventIds();
        if (savedEventIds == null) {
            savedEventIds = new ArrayList<>();
        }

        String lastEventLogId = savedEventIds.isEmpty() ? "0" : savedEventIds.get(savedEventIds.size() - 1);
        String eventId = exchDbDataProvider.getEventLogId(event, lastEventLogId);
        System.out.println("Retrieved Event ID: " + eventId);

        if (savedEventIds.contains(eventId)) {
            softAssert.fail("Event ID " + eventId + " already exists in SharedData.");
        } else {
            savedEventIds.add(eventId);
            SharedData.setEventIds(savedEventIds);
            System.out.println("Updated Event IDs in SharedData: " + savedEventIds);
        }
        softAssert.assertAll();
    }

    public void validateLceTypeAndPlanYr_EsMember(){
       String[] lceType_planYr = exchDbDataProvider.getLceType_PlanYr_esMember();
       softAssert.assertEquals(lceType_planYr[0], "ADMIN_LCE", "LCE Type did not match");
       softAssert.assertEquals(lceType_planYr[1], SharedData.getPlanYear(), "plan year did not match");
       softAssert.assertAll();
    }


    public void validateTheDentalLatestApplicationDateForTheYearDB() {
        String denLatestAppDateDB = exchDbDataProvider.getMedLatestApplicationDate();
        softAssert.assertTrue(denLatestAppDateDB.contains(SharedData.getManagePlanDentalMedicalPlan().getDenLatestAppDate()));
        softAssert.assertAll();}

    public void validateTheBrokerEmailInDB() {
        String brokerEmail = exchDbDataProvider.getTheBrokerEmailInDB();
        softAssert.assertEquals(brokerEmail,SharedData.getBroker().getEmail());
        softAssert.assertAll();
    }

    public void validateTheAgencyEmailInDB() {
        String agencyEmail = exchDbDataProvider.getTheBrokerEmailInDB();
        softAssert.assertEquals(agencyEmail,SharedData.getBroker().getAgencyEmail());
        softAssert.assertAll();
    }

    public void validateEnrollmentEndDateDB() {
        String enrEndDateDb = basicActions.changeDateFormat(exchDbDataProvider.getEnrollmentEndDate(), "yyyy-MM-dd", "MM/dd/yyyy");
        LocalDate qlceDatePlus60Days = LocalDate.now().plusDays(60); // works only when qlce date is today
        LocalDate expectedEndDate = qlceDatePlus60Days;

        if (SharedData.getIsOpenEnrollment().equals("yes")) {
            if (getOpenEnrEndDate().isAfter(qlceDatePlus60Days)) {
                expectedEndDate = getOpenEnrEndDate();
            }
        }
        String expectedEnrEndDate = basicActions.changeDateFormat(expectedEndDate.toString(), "yyyy-MM-dd", "MM/dd/yyyy");
        softAssert.assertEquals(enrEndDateDb, expectedEnrEndDate);
        softAssert.assertAll();
    }

    private LocalDate getOpenEnrEndDate(){
            int year;
            Month currentMonth = LocalDate.now().getMonth();
            if(currentMonth.toString().toLowerCase().equals("january")){
                year = LocalDate.now().getYear();
            } else {
                year = LocalDate.now().getYear()+1;
            }
            return LocalDate.of(year, 1, 15);
    }

    public void verifyTaxFilingData(String memPrefix,List<Map<String, String>> expectedValues) {
        String[] dbValues = exchDbDataProvider.getTaxFilingData(basicActions.getMemberId(memPrefix));
        System.out.println(Arrays.toString(dbValues));
        softAssert.assertEquals(dbValues[0], expectedValues.get(0).get("claimed_as_dep_on_othr_ftr_ind"));
        softAssert.assertEquals(dbValues[1], expectedValues.get(0).get("tax_filing_type"));
        softAssert.assertAll();
    }

    public void verifyTaxReturnData(String memPrefix, List<Map<String, String>> expectedValues) {
        String[] rawDbValues = exchDbDataProvider.getTaxReturnData(basicActions.getMemberId(memPrefix));

        String[] dbValues = new String[5];
        Arrays.fill(dbValues, null);
        for (int i = 0; i < rawDbValues.length && i < 5; i++) {
            dbValues[i] = rawDbValues[i];
        }

        softAssert.assertEquals(dbValues[0], expectedValues.get(0).get("tax_filing_type"), "Mismatch in tax_filing_type");
        softAssert.assertEquals(dbValues[1], expectedValues.get(0).get("claimed_as_dep_on_othr_ftr_ind"), "Mismatch in claimed_as_dep_on_othr_ftr_ind");
        softAssert.assertEquals(dbValues[2], expectedValues.get(0).get("tax_filing_status"), "Mismatch in tax_filing_status");
        softAssert.assertEquals(dbValues[3], expectedValues.get(0).get("exceptional_circumstance"), "Mismatch in exceptional_circumstance");
        softAssert.assertAll();

        String taxReturnIdValue = dbValues[4] == null ? "null" : dbValues[4];

        List<String> taxReturnIdList;
        if (memPrefix.startsWith("Primary")) {
            taxReturnIdList = SharedData.getPrimaryMember().getTaxReturnId();
        } else {
            taxReturnIdList = SharedData.getMembers().stream().filter(mem -> mem.getFirstName().contains(memPrefix)).findFirst().orElseThrow(() -> new IllegalStateException("Member not found")).getTaxReturnId();
        }
        if (taxReturnIdList == null) {
            taxReturnIdList = new ArrayList<>();
        }
        taxReturnIdList.add(taxReturnIdValue);
        if (memPrefix.startsWith("Primary")) {
            SharedData.getPrimaryMember().setTaxReturnId(taxReturnIdList);
        } else {
            MemberDetails targetMember = SharedData.getMembers().stream().filter(mem -> mem.getFirstName().contains(memPrefix)).findFirst().orElseThrow(() -> new IllegalStateException("Member not found"));
            targetMember.setTaxReturnId(taxReturnIdList);
        }

        String formattedList = String.join(", ", taxReturnIdList);
        System.out.println("Adjusted DB values: " + Arrays.toString(dbValues));
        System.out.println("Tax return ID value to be processed: " + taxReturnIdValue);
        System.out.println("Tax return ID list before updating: " + taxReturnIdList);
        System.out.println("Updated tax_return_id list for " + memPrefix + ": " + formattedList);
    }

    public void validate_rq_queue_msg(){
        String dbValues[] = exchDbDataProvider.get_rq_queue_msg();
        softAssert.assertEquals(dbValues[0], "PROCESSED", "status from rq_queue_msg table did not match");
        softAssert.assertEquals(dbValues[1], "\"REASSIGN_PRIMARY_CONTACT\"", "changeEvent from rq_queue_msg table did not match");
        softAssert.assertEquals(dbValues[2], "\"TransferContactInfo\"", "requestType from rq_queue_msg table did not match");
        softAssert.assertAll();
    }

    public void validateMemIds(){
        List<MemberDetails> allMembers = basicActions.getAllMem();
        for(MemberDetails member: allMembers){
           String memberIdFromDb = exchDbDataProvider.getMemberId(member.getFirstName());
           softAssert.assertEquals(memberIdFromDb, member.getMemberId(), "MemberId did not match");
           softAssert.assertAll();
        }
    }

    public void validateTellUsAbtUrslfDetails(){
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        String memberIdFromDb =  exchDbDataProvider.getMemberId(primaryMem.getFirstName());
        System.out.println("memberID from DB ::"+memberIdFromDb);
       EsMemberEntity primaryMemFromDb = exchDbDataProvider.getEsMemberDetails(memberIdFromDb);
       softAssert.assertEquals(primaryMem.getFirstName(), primaryMemFromDb.getFirst_name(), "First name did not match");
        softAssert.assertEquals(primaryMem.getMiddleName(), primaryMemFromDb.getMiddle_name(), "Middle name did not match");
        softAssert.assertEquals(primaryMem.getLastName(), primaryMemFromDb.getLast_name(), "Last name did not match");
        softAssert.assertTrue(primaryMemFromDb.getBirth_date().contains(basicActions.formatDob(primaryMem.getDob())), "Dob did not match");
        softAssert.assertEquals(primaryMem.getGender(), primaryMemFromDb.getGender(), "Gender did not match");
        softAssert.assertEquals(primaryMem.getSuffix().replace(".", "").toUpperCase(),primaryMemFromDb.getName_suffix() , "Suffix did not match");
       softAssert.assertTrue(primaryMem.getApplyingforCov().equals("Yes")? primaryMemFromDb.getApplying_for_coverage_ind().equals("1") : primaryMemFromDb.getApplying_for_coverage_ind().equals("0"), "Applying for coverage ind did not match");
        softAssert.assertAll();
    }

    public void validateApplicationId(){
        softAssert.assertEquals(exchDbDataProvider.getApplicationId_esApplication(), SharedData.getPrimaryMember().getApplication_id(), "Application Id's did not match");
        softAssert.assertAll();
    }

    public void validateApplicationIds(){
        List<String> applicationIds = exchDbDataProvider.getAllApplicationIds_esApplication();
        Set<String> applicationIdsList_unique = new HashSet<>(applicationIds);
        Assert.assertEquals(applicationIdsList_unique.size(), applicationIds.size(), "Application id's are not unique");
    }

    public void validateSelfAttest(List<Map<String, String>> expectedValues) {
        for (int i = 0; i < expectedValues.size(); i++) {
            Map<String, String> row = expectedValues.get(i);

            EsSelfAttestationEntity actualResult = exchDbDataProvider.getEsSelfAttest_options();
            System.out.println(actualResult);

            for (Map.Entry<String, String> entry : row.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                switch (key) {
                    case "attests_to_income":
                        softAssert.assertEquals(actualResult.getAttests_to_income(), value,"Validation failed for attests_to_income at row " + (i + 1));
                        break;
                    case "attests_to_aptc_received":
                        softAssert.assertEquals(actualResult.getAttests_to_aptc_received(), value, "Validation failed for attests_to_aptc_received at row " + (i + 1));
                        break;
                    case "attests_to_aptc_tax_reporting":
                        softAssert.assertEquals(actualResult.getAttests_to_aptc_tax_reporting(), value, "Validation failed for attests_to_aptc_tax_reporting at row " + (i + 1));
                        break;
                    case "attests_to_aptc_future_tax_reporting":
                        softAssert.assertEquals(actualResult.getAttests_to_aptc_future_tax_reporting(), value,"Validation failed for attests_to_aptc_future_tax_reporting at row " + (i + 1));
                        break;
                    case "outcome":
                        softAssert.assertEquals(actualResult.getOutcome(), value,"Validation failed for outcome at row " + (i + 1));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + key);
                }
            }
        }
        softAssert.assertAll();
    }

    public void validateExchPersonIdRelatedFieldsToBeNull(){
        List<EsMemberHouseholdEntity> esMemberHouseholdEntities = exchDbDataProvider.getExchPersonIdFields_esMember();
        softAssert.assertEquals(esMemberHouseholdEntities.size(), 1, "Size of records did not match");
        softAssert.assertNull(esMemberHouseholdEntities.get(0).getExch_person_id(), "exch_person_id is not null");
        softAssert.assertNull(esMemberHouseholdEntities.get(0).getExch_person_id_review_id(), "exch_person_id_review_id is not null");
        softAssert.assertNull(esMemberHouseholdEntities.get(0).getExch_person_id_review_status(), "exch_person_id_review_status is not null");
        softAssert.assertAll();
    }

    public void validateExchPersonIdRelatedFields() {
        List<EsMemberHouseholdEntity> esMemberHouseholdEntities = exchDbDataProvider.getExchPersonIdFields_esMember();
        softAssert.assertEquals(esMemberHouseholdEntities.size(), 1, "Size of records did not match");
        softAssert.assertNotNull(esMemberHouseholdEntities.get(0).getExch_person_id(), "exch_person_id is null");
        softAssert.assertNull(esMemberHouseholdEntities.get(0).getExch_person_id_review_id(), "exch_person_id_review_id is not null");
        softAssert.assertNull(esMemberHouseholdEntities.get(0).getExch_person_id_review_status(), "exch_person_id_review_status is not null");
        softAssert.assertAll();
    }

    public void validateExchPersonIdFields_duplicateMem() {
        List<EsMemberHouseholdEntity> esMemberHouseholdEntities = exchDbDataProvider.getExchPersonIdFields_esMember();
        String exchPersonId_currentMem = esMemberHouseholdEntities.get(0).getExch_person_id();
        softAssert.assertEquals(esMemberHouseholdEntities.size(), 1, "Size of records did not match");
        softAssert.assertNotNull(esMemberHouseholdEntities.get(0).getExch_person_id(), "exch_person_id is null");
        softAssert.assertNull(esMemberHouseholdEntities.get(0).getExch_person_id_review_id(), "exch_person_id_review_id is not null");
        softAssert.assertNull(esMemberHouseholdEntities.get(0).getExch_person_id_review_status(), "exch_person_id_review_status is not null");

        List<EsMemberHouseholdEntity> esMemberHouseholdEntities_oldMem = exchDbDataProvider.getExchPersonIdFieldsOldAcc_esMember();
        String exchPersonId_OldMem = esMemberHouseholdEntities_oldMem.get(0).getExch_person_id();
        softAssert.assertEquals(esMemberHouseholdEntities_oldMem.size(), 1, "Size of records did not match");
        softAssert.assertNotNull(esMemberHouseholdEntities_oldMem.get(0).getExch_person_id(), "exch_person_id is null");
        softAssert.assertNull(esMemberHouseholdEntities_oldMem.get(0).getExch_person_id_review_id(), "exch_person_id_review_id is not null");
        softAssert.assertNull(esMemberHouseholdEntities_oldMem.get(0).getExch_person_id_review_status(), "exch_person_id_review_status is not null");

       softAssert.assertEquals(exchPersonId_OldMem, exchPersonId_currentMem, "Exch person ids did not match");
        softAssert.assertAll();
    }

    public void validateEventCD(){
      List<String> queryResult = exchDbDataProvider.getEventCD();

        softAssert.assertTrue(queryResult.contains("FAILED_POSTAL_ADDRESS_VALIDATION"), "EventCD contains FAILED_POSTAL_ADDRESS_VALIDATION");
        softAssert.assertTrue(queryResult.contains("FAILED_EMAIL_ADDRESS_VALIDATION"), "EventCD contains FAILED_EMAIL_ADDRESS_VALIDATION");
        softAssert.assertAll();
    }
    public void validateEventLog(List<String> eventCD){
        List<String> queryResult = exchDbDataProvider.getEventLog();
        for(String eventcd: eventCD) {
            softAssert.assertTrue(queryResult.contains(eventcd), "Event log contains eventCD "+eventcd);
        }
        softAssert.assertAll();
    }

    public void validateExchPersonIdFields_specifcPerson() {
        List<EsMemberHouseholdEntity> esMemberHouseholdEntities = exchDbDataProvider.getExchPersonIdFields_esMember();
        softAssert.assertEquals(esMemberHouseholdEntities.size(), 1, "Size of records did not match");
        softAssert.assertNotNull(esMemberHouseholdEntities.get(0).getExch_person_id(), "exch_person_id is null");
        softAssert.assertEquals(esMemberHouseholdEntities.get(0).getExch_person_id_review_id(), esMemberHouseholdEntities.get(0).getExch_person_id(), "exch_person_id_review_id is not equal to exch person id");
        softAssert.assertEquals(esMemberHouseholdEntities.get(0).getExch_person_id_review_status(), "MANUAL_REVIEW_REQUIRED", "exch_person_id_review_status is not null");
        softAssert.assertAll();
    }

    public void validateAddressDetailsinDB(String FName,String address_line1, String address_line2, String city, String state, String zip, String county){
        String FirstName=null;
        List<MemberDetails> memberList=basicActions.getAllMem();
        for(MemberDetails actualMember : memberList) {
            if(actualMember.getFirstName().contains(FName)) {
                FirstName = actualMember.getFirstName();
                break;
            }
        }

        List<String> dbValues = exchDbDataProvider.getAddressInformation(FirstName);
        softAssert.assertEquals(dbValues.get(0), address_line1);
        softAssert.assertEquals(dbValues.get(1), address_line2);
        softAssert.assertEquals(dbValues.get(2), city);
        softAssert.assertEquals(dbValues.get(3), state);
        softAssert.assertEquals(dbValues.get(4), zip);
        softAssert.assertEquals(dbValues.get(5), county);
        softAssert.assertAll();
    }
    public void validateEnrollmentEndDateForAIANDB() {
        String enrolmentEndDate = exchDbDataProvider.getEnrollmentEndDate();
        String formattedDateEnd = basicActions.changeDateFormat(enrolmentEndDate ,"yyyy-MM-dd","MM/dd/yyyy");
        LocalDate lastDayOfYear = Year.now().atMonth(Month.DECEMBER).atDay(31);
        String formattedLastDayOfYear = basicActions.changeDateFormat(lastDayOfYear.toString(), "yyyy-MM-dd", "MM/dd/yyyy");
        softAssert.assertEquals(formattedDateEnd, formattedLastDayOfYear);
        softAssert.assertAll();
    }

    public void validateTellAboutAdditionalInformationinDB(String FName){
        List<MemberDetails> memberList=basicActions.getAllMem();
        for(MemberDetails actualMember : memberList) {
            if(actualMember.getFirstName().contains(FName)) {
                String FirstName = actualMember.getFirstName();
                String MiddleName = actualMember.getMiddleName();
                String LastName = actualMember.getLastName();
                String gender = actualMember.getGender();
                String dateOfBirth = actualMember.getDob();
                String applyForCover = actualMember.getApplyingforCov();
                List<String> dbValues = exchDbDataProvider.getInfoForTellAboutAdditionalInformation(FirstName);
                softAssert.assertEquals(dbValues.get(0), FirstName);
                softAssert.assertEquals(dbValues.get(1), MiddleName);
                softAssert.assertEquals(dbValues.get(2), LastName);
                softAssert.assertEquals(dbValues.get(3), gender);
                String formattedDbDOBDate = basicActions.changeDateFormat(dbValues.get(4), "yyyy-MM-dd HH:mm:ss", "MMddyyyy");
                softAssert.assertEquals(formattedDbDOBDate, dateOfBirth);
                softAssert.assertEquals(dbValues.get(5), (applyForCover.equals("Yes")) ? "1" : "0");
                softAssert.assertAll();
                break;
            }
        }
    }
    public void validateMailingAddressDetailsinDB(String FName,String address_line1, String city, String state, String zip, String county){
        String FirstName=null;
        List<MemberDetails> memberList=basicActions.getAllMem();
        for(MemberDetails actualMember : memberList) {
            if(actualMember.getFirstName().contains(FName)) {
                FirstName = actualMember.getFirstName();
                break;
            }
        }
        List<String> dbValues = exchDbDataProvider.getMailingAddressInformation(FirstName);
        softAssert.assertEquals(dbValues.get(0), address_line1);
        softAssert.assertEquals(dbValues.get(1), city);
        softAssert.assertEquals(dbValues.get(2), state);
        softAssert.assertEquals(dbValues.get(3), zip);
        softAssert.assertEquals(dbValues.get(4), county);
        softAssert.assertAll();
    }
    public void validateStateInformation(String FName, int state) {
        String FirstName = null;
        List<MemberDetails> memberList = basicActions.getAllMem();
        for (MemberDetails actualMember : memberList) {
            if (actualMember.getFirstName().contains(FName)) {
                FirstName = actualMember.getFirstName();
                break;
            }
        }
        String  stateFromDB = exchDbDataProvider.getStateInformation(FirstName);
        softAssert.assertEquals(stateFromDB, String.valueOf(state), "State mismatched");
        softAssert.assertAll();
    }

    public void validateFplPercent(String expectedFplPercent) {
        String fplValue = exchDbDataProvider.getFplPercentDetails();
        softAssert.assertEquals(fplValue.trim(), expectedFplPercent, "FPL Percent mismatch: Expected " + expectedFplPercent + ".");
        softAssert.assertAll();
    }

    public void validateFPLESTaxReturnAPTC(String expectedFPL){
        String fpl = exchDbDataProvider.getFPLPercentEsTaxReturnAPTC();
        softAssert.assertEquals(fpl.trim(), expectedFPL, "FPL Percent mismatch: ");
        softAssert.assertAll();

    }
    public void validateEnrollmentEndDateDB(int enrollmentEndDate) {
        String enrEndDateDb = basicActions.changeDateFormat(exchDbDataProvider.getEnrollmentEndDate(), "yyyy-MM-dd", "MM/dd/yyyy");
        LocalDate expectedEndDate = LocalDate.now().plusDays(enrollmentEndDate); // works only when qlce date is today

        if (SharedData.getIsOpenEnrollment().equals("yes")) {
            if (getOpenEnrEndDate().isAfter(expectedEndDate)) {
                expectedEndDate = getOpenEnrEndDate();
            }
        }
        String expectedEnrEndDate = basicActions.changeDateFormat(expectedEndDate.toString(), "yyyy-MM-dd", "MM/dd/yyyy");
        softAssert.assertEquals(enrEndDateDb, expectedEnrEndDate);
        softAssert.assertAll();
    }

    public void validateCyaEligibility() {
        String age = SharedData.getPrimaryMember().getDob();
        String applyingForCoverage = SharedData.getPrimaryMember().getApplyingforCov();
        String cyaEligibilityOutcomeDb = exchDbDataProvider.getCyaEligibility();
        String residentialState = SharedData.getPrimaryMember().getResAddress().getAddressState();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate birthDate = LocalDate.parse(age, formatter);
        LocalDate currentDate = LocalDate.now();
        int ageInYears = Period.between(birthDate, currentDate).getYears();

        if(applyingForCoverage.equals("Yes") && residentialState.equals("CO") && ageInYears < 30) {
            softAssert.assertEquals(cyaEligibilityOutcomeDb, "1");
        } else {
            softAssert.assertEquals(cyaEligibilityOutcomeDb, "0");
        }
        softAssert.assertAll();
    }

    public void validateVLPResponseCode(String expectedResponseCode, String requestType) {
        String actualResponseCode = exchDbDataProvider.getVLPResponseCode(requestType);
        softAssert.assertEquals(actualResponseCode.trim(), expectedResponseCode);
        softAssert.assertAll();
    }

    public void validateFDSHRetryTypeandStatus(String expectedRetryType, String expectedStatus) {
        String actualRetryType = exchDbDataProvider.getFDSHRetryType();
        String actualRetryStatus = exchDbDataProvider.getFDSHRetryStatus();
        softAssert.assertEquals(actualRetryType.trim(), expectedRetryType);
        softAssert.assertEquals(actualRetryStatus.trim(), expectedStatus);
        softAssert.assertAll();
    }

    public void validateReasonCode(String expectedReasonCode) {
        String reasonCode = exchDbDataProvider.getMemberReasonCodeByAccountId();
        softAssert.assertEquals(reasonCode, expectedReasonCode, "Reason code mismatch!");
        softAssert.assertAll();
    }

    public void validateFDSHRetry(List<Map<String, String>> expectedValues) {
        for (int i = 0; i < expectedValues.size(); i++) {
            Map<String, String> row = expectedValues.get(i);

            EsFDSHRetryControlEntity actualResult = exchDbDataProvider.getEsFDSH_details();
            System.out.println(actualResult);

            for (Map.Entry<String, String> entry : row.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                switch (key) {
                    case "service_type":
                        softAssert.assertEquals(actualResult.getService_type(), value,"Validation failed for service_type at row " + (i + 1));
                        break;
                    case "status":
                        softAssert.assertEquals(actualResult.getStatus(), value,"Validation failed for status at row " + (i + 1));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + key);
                }
            }
        }
        softAssert.assertAll();
    }

    public void validateIncomeDetails(List<Map<String, String>> expectedValues) {
        List<IncomeDataEntity> actualResults = exchDbDataProvider.getIncomeData();
        softAssert.assertEquals(actualResults.size(), expectedValues.size(), "Row count mismatch");

        for (int i = 0; i < expectedValues.size(); i++) {
            IncomeDataEntity actualResult = actualResults.get(i);
            Map<String, String> expectedRow = expectedValues.get(i);
            System.out.println("Validating row " + (i + 1) + ": " + actualResult);
            softAssert.assertEquals(actualResult.getType(), expectedRow.get("type"), "Type mismatch at row " + (i + 1));
            softAssert.assertEquals(actualResult.getKind(), expectedRow.get("kind"), "Kind mismatch at row " + (i + 1));
            softAssert.assertEquals(actualResult.getAmount(), expectedRow.get("amount"), "Amount mismatch at row " + (i + 1));
            softAssert.assertEquals(actualResult.getPeriod(), expectedRow.get("period"), "Period mismatch at row " + (i + 1));
            softAssert.assertEquals(actualResult.getAnnual_amount(), expectedRow.get("annual_amount"), "Annual_amount mismatch at row " + (i + 1));
            softAssert.assertEquals(actualResult.getFuture_income_changes_ind(), expectedRow.get("future_income_changes_ind"), "Future_income_changes_ind mismatch at row " + (i + 1));
            softAssert.assertEquals(actualResult.getSelf_employed_ind(), expectedRow.get("self_employed_ind"), "Self_employed_ind mismatch at row " + (i + 1));
            softAssert.assertEquals(actualResult.getSeason_comm_tip_samelower_ind(), expectedRow.get("season_comm_tip_samelower_ind"), "Season_comm_tip_samelower_ind mismatch at row " + (i + 1));
            softAssert.assertEquals(actualResult.getMonthly_amount(), expectedRow.get("monthly_amount"), "Monthly_amount mismatch at row " + (i + 1));
            softAssert.assertNotNull(actualResult.getEmployer_ah_id(), "Employer_ah_id is null at row " + (i + 1));
            softAssert.assertNotNull(actualResult.getEmployer_id(), "Employer_id is null at row " + (i + 1));
            softAssert.assertEquals(actualResult.getEmployer_name(), "COCO_DEFAULT_EMPLOYER", "Employer_name mismatch at row " + (i + 1));
            softAssert.assertNotNull(actualResult.getSeason_comm_tip_ind(), "Season_comm_tip_ind is null at row " + (i + 1));
            softAssert.assertNotNull(actualResult.getCreated_by(), "Created_by is null at row " + (i + 1));
        }
        softAssert.assertAll();
    }

    public void validateMemberRowCount(int expectedRowCount) {
        basicActions.wait(5000);
        int actualRowCount = Integer.parseInt(exchDbDataProvider.getEmployerIncomeRowCount());
        softAssert.assertEquals(actualRowCount, expectedRowCount, "Row count mismatch!");
        softAssert.assertAll();
    }

    public void validateDeductionAmount(String kind, String expectedAmount, String expectedFrequency) {
        SoftAssert softAssert = new SoftAssert();
        String[] deductionDetails = exchDbDataProvider.getDeductionAmount(SharedData.getPrimaryMember().getFirstName(), kind);
        String actualKind = deductionDetails[0];
        String actualAmount = deductionDetails[1];
        String actualFrequency = deductionDetails[2];
        softAssert.assertEquals(actualKind, kind, "Kind does not match!");
        softAssert.assertEquals(actualAmount, expectedAmount, "Amount does not match!");
        softAssert.assertEquals(actualFrequency, expectedFrequency, "Frequency does not match!");

        softAssert.assertAll();
    }

    public void validateOverriddenAmount(String overriddenAmt) {
        String overriddenAmount = exchDbDataProvider.getOverriddenAmount();
        softAssert.assertTrue(overriddenAmount.contains("overriddenAptcAmount>" + overriddenAmt), "Amount does not match! Expected to contain: overriddenAptcAmount>" + overriddenAmt + " Found: " + overriddenAmount);
        softAssert.assertAll();
    }
    public void verifyVLPCallsMadeForMember(int expectedVLPCallsMade){
        int actualVLPCallsMade = Integer.parseInt(exchDbDataProvider.getVlpRequestCount());
        Assert.assertEquals(actualVLPCallsMade, expectedVLPCallsMade, "VLP Calls made mismatch!");
    }

    public void verifyPrimaryEligibilityType(String reasonCode) {
        String eligibilityType = exchDbDataProvider.getEligibilityType();
        softAssert.assertEquals(eligibilityType, reasonCode, "Amount does not match! Expected to contain: " + reasonCode + " Found: " + eligibilityType);
        softAssert.assertAll();
    }

    public void verifyDeterminationEffectiveDate(String qlceType, String dateType){
        String dbValues[] = exchDbDataProvider.getDeterminationEffectiveDate();
        softAssert.assertEquals(dbValues[0], qlceType, "QLCE Type was " + dbValues[0] + " instead of " + qlceType);
        softAssert.assertEquals(dbValues[1], basicActions.getDateBasedOnRequirement(dateType) + " 00:00:00", "QLCE Type was " + dbValues[1] + " instead of " + basicActions.getDateBasedOnRequirement(dateType) + " 00:00:00");
        softAssert.assertAll();
    }

    public void validateOutcomeInd(String outcome) {
        String outcomeIndDb = exchDbDataProvider.getOutcomeInd();
        softAssert.assertEquals(outcomeIndDb, outcome);
        softAssert.assertAll();
    }

    public void validateRemovedEffectiveDate() {
        String removedEffectiveDate = exchDbDataProvider.getRemovedEffectiveDate();
        softAssert.assertEquals(removedEffectiveDate, basicActions.getDateBasedOnRequirement("First Day Of Next Year") + " 00:00:00");
        softAssert.assertAll();
    }

    public void validateApplyingForCoverageIndDB(String FName, String applying){
        List<MemberDetails> memberList=basicActions.getAllMem();
        for(MemberDetails actualMember : memberList) {
            if(actualMember.getFirstName().contains(FName)) {
                String FirstName = actualMember.getFirstName();
                List<String> dbValues = exchDbDataProvider.getInfoForTellAboutAdditionalInformation(FirstName);
                softAssert.assertEquals(dbValues.get(5), applying);
                softAssert.assertAll();
                break;
            }
        }
    }

    public void validateLceMovedToAh(String FName) {
        String dbValues[] = exchDbDataProvider.getEsMemberLceAh(basicActions.getMemberId(FName)).toArray(new String[0]);
        softAssert.assertEquals(dbValues[0], dbValues[1], "First set");
        softAssert.assertEquals(dbValues[2], dbValues[3], "Second set");
        softAssert.assertEquals(dbValues[4], dbValues[5] + " 00:00:00", "Third set");
        softAssert.assertEquals(dbValues[6], dbValues[7] + " 00:00:00", "Forth set");
        softAssert.assertAll();
    }

    public void validateDeductionRowCount(int expectedRowCount) {
        basicActions.wait(7000);
        int actualRowCount = Integer.parseInt(exchDbDataProvider.getDeductionRowCount());
        softAssert.assertEquals(actualRowCount, expectedRowCount, "Row count mismatch!");
        softAssert.assertAll();
    }

    public void validateEnrollmentPlanYear(String year) {
        String enrolmentPlanYear = exchDbDataProvider.getEnrollmentPlanYear();
        softAssert.assertEquals(enrolmentPlanYear, basicActions.getDateBasedOnRequirement(year));
        softAssert.assertAll();
    }

    public void validateEnrollmentPlanLce(List<Map<String, String>> expectedValues) {
        basicActions.wait(5000);
        List<List<String>> dbValuesList = exchDbDataProvider.getEnrollmentPlanLceDetails();
        System.out.println("Query executed, returned values: " + dbValuesList);

        if (dbValuesList.isEmpty()) {
            throw new RuntimeException("No data returned from exchDbDataProvider for account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'");
        }

        for (int i = 0; i < expectedValues.size(); i++) {
            if (i >= dbValuesList.size()) {
                throw new RuntimeException("Mismatch: Expected more rows than returned by DB.");
            }
            List<String> dbRow = dbValuesList.get(i);
            Map<String, String> expectedRow = expectedValues.get(i);
            String enrollmentPeriodEndDateBasic = basicActions.getDateBasedOnRequirement(expectedRow.get("enrollment_period_end_date"));
            String enrollmentPeriodEndDate = basicActions.changeDateFormat(enrollmentPeriodEndDateBasic, "MM/dd/yyyy", "yyyy-MM-dd");
            String planYear = basicActions.getDateBasedOnRequirement(expectedRow.get("plan_year"));

            softAssert.assertEquals(dbRow.get(0), enrollmentPeriodEndDate, "enrollment_period_end_date");
            softAssert.assertEquals(dbRow.get(1), expectedRow.get("qlce_present_ind"), "qlce_present_ind");
            softAssert.assertEquals(dbRow.get(2), planYear, "plan_year");
        }
        softAssert.assertAll();
    }

    public void validateEnrollmentPlanLceRowCount(int expectedRowCount) {
        basicActions.wait(5000);
        int actualRowCount = Integer.parseInt(exchDbDataProvider.getEnrollmentPlanLceRowCount());
        softAssert.assertEquals(actualRowCount, expectedRowCount, "Row count mismatch!");
        softAssert.assertAll();
    }



    public void validateDocumentDetails(List<String> expectedValues) {
        SoftAssert softAssert = new SoftAssert();
        String[] documentDetails = exchDbDataProvider.getMyDocumentdetails();

        softAssert.assertEquals(documentDetails[0], expectedValues.get(0), "Mismatch in Source ID");
        softAssert.assertEquals("null".equals(expectedValues.get(1)) ? null : expectedValues.get(1), documentDetails[1], "Mismatch in Document Author");
        softAssert.assertEquals(documentDetails[2], expectedValues.get(2), "Mismatch in Display Name");
        softAssert.assertEquals(documentDetails[3], expectedValues.get(3), "Mismatch in File Extension");
        softAssert.assertEquals(documentDetails[4] != null ? documentDetails[4].split(" ")[0] : null, LocalDate.now().toString(), "DB date mismatch");

        softAssert.assertAll();
    }


    public void validateTheAssistnetEmailInDB() {
        String assistNetEmail = exchDbDataProvider.getTheAssistNetEmailInDB();
        softAssert.assertEquals(assistNetEmail,SharedData.getAssisterDetails().getEmail());
        softAssert.assertAll();
    }

    public void validateMemberIncomeOptOutInDB(String expectedValue) {
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        String memberIdFromDb =  exchDbDataProvider.getMemberId(primaryMem.getFirstName());
        System.out.println("memberID from DB ::"+memberIdFromDb);
        EsMemberEntity primaryMemFromDb = exchDbDataProvider.getEsMemberDetails(memberIdFromDb);
        System.out.println("ESMemberEntity: "+primaryMemFromDb);
        softAssert.assertEquals(primaryMemFromDb.getJob_income_optout_ind(), expectedValue, "Applying for Coverage Opt Out did not match");
        softAssert.assertAll();
    }

    public void validateCoCoMemberIncomeDetailsInDB(List<Map<String, String>> expectedValues){
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        String[] rawDbValues = exchDbDataProvider.getCoCoIncomeDataDetails();

        String[] dbValues = new String[5];
        Arrays.fill(dbValues, null);
        for (int i = 0; i < rawDbValues.length && i < 5; i++) {
            dbValues[i] = rawDbValues[i];
        }

        softAssert.assertEquals(dbValues[0], expectedValues.get(0).get("amount"), "incorrect amount");
        softAssert.assertEquals(dbValues[1], expectedValues.get(0).get("period"), "incorrect period");
        softAssert.assertEquals(dbValues[2], expectedValues.get(0).get("season_comm_tip_ind"), "incorrect answer for tips");
        softAssert.assertEquals(dbValues[3], expectedValues.get(0).get("season_comm_tip_samelower_ind"), "incorrect answer for same or lower");
        softAssert.assertEquals(dbValues[4],primaryMem.getEmailId(), "incorrect e-mail for updated by");
        softAssert.assertAll();
    }
}

