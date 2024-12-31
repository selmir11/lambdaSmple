package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.*;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.utils.BasicActions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DbValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();
    String formattedDate; //formatted in YYYY-MM-DD

    BasicActions basicActions = new BasicActions();

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

    public void validateOhiDetails(String memPrefix) {
        Boolean hasRecords = exchDbDataProvider.getDataFromOhiTables(basicActions.getMemberId(memPrefix));
        Assert.assertFalse(hasRecords, "Query returned records");
        softAssert.assertAll();
    }

    public void validateOhiOptions(String memPrefix, List<Map<String, String>> expectedValues) {
        EsMemberOhiEntity actualResult = exchDbDataProvider.getOptionsFromOhiDbTables(basicActions.getMemberId(memPrefix));
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
        List<String> applicationIdListFromPolicyAh = exchDbDataProvider.getApplicationId();
        List<String> policyIdFromPolicyDB = exchDbDataProvider.getPolicyId();

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

    public void validateMemberCSRNonAIANData() {
        String[] dbValues = exchDbDataProvider.getmemberNonAIAN();
        softAssert.assertEquals(dbValues[0], "NON_AIAN", "Reason code mismatch: Expected 'NONAIAN'");
        softAssert.assertEquals(dbValues[1], "CSR", "Eligibility type mismatch: Expected 'CSR'");
        softAssert.assertAll();
    }

    public void validateApplicationResult(String expectedReasonCode, String memPrefix) {
        String expReasonCode = null;
        switch (expectedReasonCode) {
            case "OFF_EXCHANGE_ELIGIBLE", "OFF_EXCHANGE_NOT_ELIGIBLE":
                expReasonCode= "OFFEXCH";
                break;
            case "ELIGIBLE_FOR_HP2_LIMITED":
                expReasonCode = "HP2";
                break;
            case "QLCE":
                expReasonCode = "GAIN_DEP_QLCE";
                break;
            default:
                Assert.fail("Expected Reason Code is not valid");
        }

        String memberID = exchDbDataProvider.getMemberId(basicActions.getMemFirstNames(memPrefix));
        String reasonCode = exchDbDataProvider.getReasonCode(memberID, expReasonCode);

        System.out.println("Member ID: " + memberID);
        System.out.println("Reason Code: " + reasonCode);

        softAssert.assertEquals(reasonCode, expectedReasonCode, "Reason Code validation failed");
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
                    default:
                        throw new IllegalArgumentException("Invalid option: " + key);
                }
            }
        }
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
    public void validateEnrollmentEndDateDB(int enrollmentEndDate) {
        String enrolmentEndDate = exchDbDataProvider.getEnrollmentEndDate();
        String formattedDateEnd = basicActions.changeDateFormat(enrolmentEndDate ,"yyyy-MM-dd","MM/dd/yyyy");

        LocalDate currentDate = LocalDate.now();
        LocalDate twoMonthsLater = currentDate.plusDays(enrollmentEndDate);

        String formattedEnrolmentEndDate = basicActions.changeDateFormat(String.valueOf(twoMonthsLater),"yyyy-MM-dd","MM/dd/yyyy");
        softAssert.assertEquals(formattedDateEnd, formattedEnrolmentEndDate);
        softAssert.assertAll();
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



 }
