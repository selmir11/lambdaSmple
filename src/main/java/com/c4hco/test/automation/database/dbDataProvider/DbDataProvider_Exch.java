package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.*;
import com.c4hco.test.automation.database.Queries.DbQueries_Exch;
import com.c4hco.test.automation.database.dbHandler.*;
import com.c4hco.test.automation.utils.BasicActions;

import java.util.*;

public class DbDataProvider_Exch {
    private DbQueries_Exch exchDbQueries = new DbQueries_Exch();
    PolicyTableDbHandler policyTableDbHandler = new PolicyTableDbHandler();
    EnPolicyAhHandler enPolicyAhHandler = new EnPolicyAhHandler();
    EnPolicyMemberAhHandler enPolicyMemberAhHandler = new EnPolicyMemberAhHandler();
    EsIncomeDbHandler esIncomeDbHandler = new EsIncomeDbHandler();

    EnMemberEffectiveDatesHandler enMemberEffectiveDatesHandler = new EnMemberEffectiveDatesHandler();

    EnPolicyFinancialAhHandler enPolicyFinancialAhHandler = new EnPolicyFinancialAhHandler();
    EnMemberCoverageFinancialAhHandler enMemberCoverageFinancialAhHandler = new EnMemberCoverageFinancialAhHandler();
    EnPolicyMemberCoverageAhHandler enPolicyMemberCoverageAhHandler = new EnPolicyMemberCoverageAhHandler();
    Ob834DetailsDbHandler ob834DetailsDbHandler = new Ob834DetailsDbHandler();
    Ib999Handler ib999Handler = new Ib999Handler();
    Ob999Handler ob999Handler = new Ob999Handler();
    Ib834Handler ib834Handler = new Ib834Handler();
    EsMemberOhcDbHandler esMemberOhcDbHandler = new EsMemberOhcDbHandler();
    BookOfBuisnessQDbHandler bookOfBuisnessQDbHandler = new BookOfBuisnessQDbHandler();
    EsManualVerifRequestDbHandler manualVerifRequestDbHandler = new EsManualVerifRequestDbHandler();
    PostgresHandler postgresHandler = new PostgresHandler();
    MemberDetails primaryMember = SharedData.getPrimaryMember();
    EsMemberHouseholdHandler esMemberHouseholdHandler = new EsMemberHouseholdHandler();
    EsHouseholdContactDbHandler esHouseholdContactDbHandler = new EsHouseholdContactDbHandler();
    EsMemberDbHandler esMemberDbHandler = new EsMemberDbHandler();
    EsSelfAttestationDbHandler esSelfAttestationDbHandler = new EsSelfAttestationDbHandler();
    BasicActions basicActions = new BasicActions();
    EsFDSHRetryControlDbHandler esFDSHRetryControlDbHandler = new EsFDSHRetryControlDbHandler();

    public List<PolicyTablesEntity> getDataFromPolicyTables(){
        return policyTableDbHandler.getPolicyTableDetails(exchDbQueries.policyTablesQuery());
    }

    public List<PolicyTablesEntity> getDataFrmPolicyTables(String coverageType){
        return policyTableDbHandler.getPolicyTableDetails(exchDbQueries.policyTablesCombinedQuery(coverageType));
    }

    public List<Ob834DetailsEntity> getOb834Details(String insurance_line_code){
        return ob834DetailsDbHandler.getOb834DetalsAfterCompleted(exchDbQueries.ob834DetailsRecords(insurance_line_code));
    }
    public List<Ib999Entity> getIb999Details(String ak1grp_ctrl_number){
        return ib999Handler.getIbDetailsAfterCompleted(exchDbQueries.ib999Details(ak1grp_ctrl_number));
    }

    public List<Ob999Entity> getOb999Details(String ak1grp_ctrl_number){
        return ob999Handler.getObDetailsAfterCompleted(exchDbQueries.ob999Details(ak1grp_ctrl_number));
    }

    public List<Ib834Entity> getIb834Details(String grpCtlNum){
        return ib834Handler.getIbDetailsAfterCompleted(exchDbQueries.ib834Details(grpCtlNum));
    }
    public Map<String,String> getEap_id() {
        //This function works one medical EAPID and one dental EAPID
        Map<String, String> eapid = postgresHandler.getResultForTwoColumnValuesInMap("coverage_type", "exchange_assigned_policy_id", exchDbQueries.getEAPID());
        primaryMember.setMedicalEapid_db(eapid.get("1"));
        primaryMember.setDentalEapid_db(eapid.get("2"));
        SharedData.setPrimaryMember(primaryMember);
        return eapid;
    }
    public Map<String,String> getMedicalEap_id(){
        return postgresHandler.getResultForTwoColumnValuesInMap("shopping_group_number", "exchange_assigned_policy_id", exchDbQueries.getMedicalEAPID());
    }

    public Map<String,String> getDentalEap_id(){
        return postgresHandler.getResultForTwoColumnValuesInMap("shopping_group_number", "exchange_assigned_policy_id", exchDbQueries.getDentalEAPID());
    }

    public String getFipcode(){
        String zipcode = primaryMember.getResAddress().getAddressZipcode();
        String county = primaryMember.getResAddress().getAddressCounty();
        return  postgresHandler.getResultFor("fips", exchDbQueries.getFipcode(zipcode, county));
    }

    public String getFipCodeForMem(String name){
        MemberDetails member = basicActions.getMember(name);
        String zipcode = member.getResAddress().getAddressZipcode();
        String county = member.getResAddress().getAddressCounty();
        if(member.getIsProfileChange()&&member.getIsResAddChange()){
            zipcode = member.getOldResAddress().getAddressZipcode();
            county = member.getOldResAddress().getAddressCounty();
        }
        return  postgresHandler.getResultFor("fips", exchDbQueries.getFipcode(zipcode, county));

    }

    public String getRatingAreaName(String fipcode){
       return postgresHandler.getResultFor("name", exchDbQueries.getRatingArea(fipcode));

    }
    public String getRatingAreaId(String fipcode){
        return postgresHandler.getResultFor("rating_area_id", exchDbQueries.getRatingAreaId(fipcode));
    }
    public String[] getIssuerNameId(String hiosIssuerId){
        return postgresHandler.getResultForTwoColumnValues("name", "tin_num", exchDbQueries.en_issuer(hiosIssuerId));
    }

    public String[] getBaseIdAndHiosIssuerForPlan(String planName){
        return postgresHandler.getResultForTwoColumnValues("base_id", "hios_issuer_id", exchDbQueries.en_plan(planName));
    }

//    public String[] getBaseIdAndHiosIssuerForDentalPlan(String planName){
//        return postgresHandler.getResultForTwoColumnValues("base_id", "hios_issuer_id", exchDbQueries.en_Dentalplan(planName));
//    }

    public String getExchPersonId(String memId){
        return postgresHandler.getResultFor("exch_person_id", exchDbQueries.exchPersonId(memId));
    }
    public String getCSRLevel(){
        return postgresHandler.getResultFor("csr_level", exchDbQueries.csrLevel());
    }
    public String getTinNumForBroker() {
        return postgresHandler.getResultFor("commission_tin", exchDbQueries.commissionTin());
    }

    public Map<String,String> getSubscriberCSRDataFromDb(){
        Map<String,String> csrAmount =  postgresHandler.getResultForTwoColumnValuesInMap("coverage_type","csr_amt", exchDbQueries.getCSRRecords());
        return csrAmount;
    }

    public Map<String,String> getSubscriberCSRDataFromDb_aian(){
        Map<String,String> csrAmount =  postgresHandler.getResultForTwoColumnValuesInMap("coverage_type","csr_amt", exchDbQueries.getMedCSRRecords_aian());
        return csrAmount;
    }

    public void setDataFromDb(){
        String fipcode = getFipcode();
        String ratingAreaName = getRatingAreaName(fipcode);
        String ratingAreaId = getRatingAreaId(fipcode);
        String csrLevel = getCSRLevel();
        String brokerTinNum = null;
        if(SharedData.getHasBroker()){
                brokerTinNum = getTinNumForBroker();
            }
        DbData dbData = new DbData();

        dbData.setFipcode(fipcode);
        dbData.setRatingAreaName(ratingAreaName);
        dbData.setRatingAreaId(ratingAreaId);
        dbData.setBrokerTinNum(brokerTinNum);
        dbData.setCsrLevel(csrLevel);
        SharedData.setDbData(dbData);
    }
    public void setDataFromDb_New(String name){
        String fipcode = getFipCodeForMem(name);
        String ratingAreaName = getRatingAreaName(fipcode);
        String ratingAreaId = getRatingAreaId(fipcode);
        String csrLevel = getCSRLevel();
        String brokerTinNum = null;
        if(SharedData.getHasBroker()){
            brokerTinNum = getTinNumForBroker();
        }
        DbData dbData = new DbData();

        dbData.setFipcode(fipcode);
        dbData.setRatingAreaName(ratingAreaName);
        dbData.setRatingAreaId(ratingAreaId);
        dbData.setBrokerTinNum(brokerTinNum);
        dbData.setCsrLevel(csrLevel);
        SharedData.setDbData(dbData);
        setDataFromDbGrp(name, dbData );
    }
    public void setDataFromDbGrp(String name, DbData dbData){
        Set<Map<String, DbData>> dbDataMapList = SharedData.getDbDataNew();
        if(dbDataMapList == null){
            dbDataMapList = new HashSet<>();
        }
        Map<String, DbData> dbDataMap = new HashMap<>();
        dbDataMap.put(name,dbData);
        dbDataMapList.add(dbDataMap);
        SharedData.setDbDataNew(dbDataMapList);
    }
    public void setExchPersonId(MemberDetails mem, String memberId){
        String exchPersnId =  getExchPersonId(memberId);
        Map<String, String> exchPersonId = SharedData.getExchPersonId();
        if(exchPersonId==null){
            exchPersonId = new HashMap<>();
        }
        exchPersonId.put(mem.getFirstName(), exchPersnId );
        SharedData.setExchPersonId(exchPersonId);
    }
    public void setMedicalPlanDataFromDb(String planName){
        String[] baseIdAndHiosIssuerId = getBaseIdAndHiosIssuerForPlan(planName);
        String baseId = baseIdAndHiosIssuerId[0];
        String hiosIssuerId = baseIdAndHiosIssuerId[1];
        String[] issuerNameId = getIssuerNameId(hiosIssuerId);
        String issuerName = issuerNameId[0];
        String issuerId = issuerNameId[1];
        Map<String,String> csrMap = getSubscriberCSRDataFromDb();
        String csrAmtMed =csrMap.get("1");
        Map<String, PlanDbData> medicalPlanDetailsFromDb = SharedData.getMedicalPlanDbData();
        if(medicalPlanDetailsFromDb==null) {
            medicalPlanDetailsFromDb = new HashMap<>();
        }
            PlanDbData planDbData = new PlanDbData();
            planDbData.setBaseId(baseId);
            planDbData.setPlanName(planName);
            planDbData.setIssuerName(issuerName);
            planDbData.setIssuerId(issuerId);
            planDbData.setHiosIssuerId(hiosIssuerId);
            planDbData.setCsrAmt(csrAmtMed);
            medicalPlanDetailsFromDb.put("group1", planDbData);
            SharedData.setMedicalPlanDbData(medicalPlanDetailsFromDb);
    }
    public void setMedicalPlanDataFromDb_New(String name, String planName){
        String[] baseIdAndHiosIssuerId = getBaseIdAndHiosIssuerForPlan(planName);
        String baseId = baseIdAndHiosIssuerId[0];
        String hiosIssuerId = baseIdAndHiosIssuerId[1];
        String[] issuerNameId = getIssuerNameId(hiosIssuerId);
        String issuerName = issuerNameId[0];
        String issuerId = issuerNameId[1];
        Map<String,String> csrMap = SharedData.getIsAiAn()? getSubscriberCSRDataFromDb_aian() : getSubscriberCSRDataFromDb();
        String csrAmtMed = csrMap.get("1");
        List<Map<String, PlanDbData>> medicalPlanDetailsFromDb = SharedData.getMedicalPlanDbDataNew();
        if(medicalPlanDetailsFromDb == null) {
            medicalPlanDetailsFromDb = new ArrayList<>();
        }
        PlanDbData planDbData = new PlanDbData();
        Map<String, PlanDbData> planDbDataMap = new HashMap<>();
        planDbData.setBaseId(baseId);
        planDbData.setPlanName(planName);
        planDbData.setIssuerName(issuerName);
        planDbData.setIssuerId(issuerId);
        planDbData.setHiosIssuerId(hiosIssuerId);
        planDbData.setCsrAmt(csrAmtMed);
        planDbDataMap.put(name, planDbData);

        medicalPlanDetailsFromDb.add(planDbDataMap);
        SharedData.setMedicalPlanDbDataNew(medicalPlanDetailsFromDb);
    }

    public void setDentalPlanDataFromDb(String planName){
        String[] baseIdAndHiosIssuerId = getBaseIdAndHiosIssuerForPlan(planName);
        String baseId = baseIdAndHiosIssuerId[0];
        String hiosIssuerId = baseIdAndHiosIssuerId[1];
        String[] issuerNameId = getIssuerNameId(hiosIssuerId);
        String issuerName = issuerNameId[0];
        String issuerId = issuerNameId[1];
        Map<String,String> csrMap = getSubscriberCSRDataFromDb();
        String csrAmt =csrMap.get("2"); //Dental
        Map<String, PlanDbData> dentalPlanDetailsFromDb = SharedData.getDentalPlanDbData();
        if(dentalPlanDetailsFromDb==null) {
            dentalPlanDetailsFromDb = new HashMap<>();
        }
        PlanDbData planDbData = new PlanDbData();

        planDbData.setBaseId(baseId);
        planDbData.setPlanName(planName);
        planDbData.setIssuerName(issuerName);
        planDbData.setIssuerId(issuerId);
        planDbData.setHiosIssuerId(hiosIssuerId);
        planDbData.setCsrAmt(csrAmt);
        dentalPlanDetailsFromDb.put("group1", planDbData);
        SharedData.setDentalPlanDbData(dentalPlanDetailsFromDb);
    }
    public void setDentalPlanDataFromDb_New(String name, String planName){
        String[] baseIdAndHiosIssuerId = getBaseIdAndHiosIssuerForPlan(planName);
        String baseId = baseIdAndHiosIssuerId[0];
        String hiosIssuerId = baseIdAndHiosIssuerId[1];
        String[] issuerNameId = getIssuerNameId(hiosIssuerId);
        String issuerName = issuerNameId[0];
        String issuerId = issuerNameId[1];
        Map<String,String> csrMap = getSubscriberCSRDataFromDb();
        String csrAmt =csrMap.get("2"); //Dental

        List<Map<String, PlanDbData>> dentalPlanDetailsFromDb = SharedData.getDentalPlanDbDataNew();
        if(dentalPlanDetailsFromDb == null) {
            dentalPlanDetailsFromDb = new ArrayList<>();
        }

        PlanDbData planDbData = new PlanDbData();
        Map<String, PlanDbData> planDbDataMap = new HashMap<>();

        planDbData.setBaseId(baseId);
        planDbData.setPlanName(planName);
        planDbData.setIssuerName(issuerName);
        planDbData.setIssuerId(issuerId);
        planDbData.setHiosIssuerId(hiosIssuerId);
        planDbData.setCsrAmt(csrAmt);
        planDbDataMap.put(name, planDbData);
        dentalPlanDetailsFromDb.add( planDbDataMap);
        SharedData.setDentalPlanDbDataNew(dentalPlanDetailsFromDb);
    }

    public Boolean getDataFromOhcTables(String memberId){
        return postgresHandler.dbRecordsExisting(exchDbQueries.getOhcRecordsAll(memberId));
    }

    public EsMemberOhcEntity getOptionsFromOhcDbTables(String memberId) {
        return esMemberOhcDbHandler.getOptionsFromOhcTables(exchDbQueries.getOhcRecordsAll(memberId));
    }

    public EsMemberHraEntity getOptionsFromHraDbTables(){
        return esMemberOhcDbHandler.getOptionsFromHraTables(exchDbQueries.getPrimaryHraRecords());
    }

    public Map<String,String> getPolicyDqCheckAndPolicyAhId(){
        postgresHandler.setRec(exchDbQueries.setEnvForDataQuality());
        return postgresHandler.getResultForTwoColumnValuesInMap("policy_ah_id", "en_policy_dq_check", exchDbQueries.getPolicyDqCheck());
    }

    public List<BookOfBusinessQEntity> getBookOfBusinessQ(String eventType){
        return bookOfBuisnessQDbHandler.getBookOfBusinessQDetails(exchDbQueries.getBookOfBusinessQ(eventType));
    }
    public List<BookOfBusinessQEntity> getBoBQueryByApplicationId(String eventType){
        return bookOfBuisnessQDbHandler.getBookOfBusinessQDetails(exchDbQueries.getBookOfBusinessByApplicationId(eventType));
    }

    public List<String> getPolicyId(){
        return postgresHandler.getResultListFor("policy_id", exchDbQueries.policyId());
    }
    public List<String> getApplicationId(){
        return postgresHandler.getResultListFor("application_id", exchDbQueries.appIdFromEnPolicyAh());
    }

    public List<String> getAccount_holder_fn() {

       return postgresHandler.getResultListFor("Acct_holder_fn", exchDbQueries.getAcct_holder_fnFromBOB());}

    public List<String> getClientEmailInBoB() {

       return postgresHandler.getResultListFor("email", exchDbQueries.getClientEmailFromBOB());
    }

    public List<String> getBrokerAuthorizationInBoB(String clientFirstName) {

       return postgresHandler.getResultListFor("broker_name", exchDbQueries.verifyBrokerAuthorizationInBOB(clientFirstName));
    }

    public List<String> getApplicationSubmissionInBoB() {

       return postgresHandler.getResultListFor("account_id", exchDbQueries.verifyApplicationSubmissionInBOB());
    }

    public List<String> getPolicySubmissionInBoB(int coverageType) {

       return postgresHandler.getResultListFor("account_id", exchDbQueries.verifyPolicySubmissionInBOB(coverageType));
    }

    public Boolean getNoMedicalPolicySubmissionInBoB() {

        return postgresHandler.dbRecordsExisting(exchDbQueries.verifyPolicySubmissionInBOB(1));
    }

    public List<String> getAgencyCommissionTinDb() {

        return postgresHandler.getResultListFor("commission_tin", exchDbQueries.verifyAgencyCommissionTinDb());
    }

    public Boolean getExchHouseholdIdBoB() {

        return postgresHandler.dbRecordsExisting(exchDbQueries.verifyExchHouseholdIdBOB());
    }

    public Boolean getPasswordResetNotArchivedDb(String currentDate) {

        return postgresHandler.dbRecordsExisting(exchDbQueries.verifyPasswordResetNotArchivedDb(currentDate));
    }

    public List<String> getBrokerAuthorizationStatusBoB() {

        return postgresHandler.getResultListFor("authorization_status", exchDbQueries.verifyBrokerAuthorizationStatusBOB());
    }

    public List<String> getBrokerAuthorizationTypeBoB() {

        return postgresHandler.getResultListFor("staff_type", exchDbQueries.verifyBrokerAuthorizationTypeBOB());
    }

    public List<EnPolicyAhEntity> getEnPolicyAh_details(){
        return enPolicyAhHandler.getEnPolicyTableDetails(exchDbQueries.enPolicyAh());
    }

    public List<EnMemberCoverageFinancialAhEntity> getEn_Mem_Cov_Fin_Ah_details(){
        return enMemberCoverageFinancialAhHandler.getEnMemberCoverageFinAhTableDetails(exchDbQueries.enMem_Coverage_FinancialAh());
    }

    public List<EnPolicyMemberCoverageAhEntity> getEnPol_Mem_Cov_Ah_details(){
        return enPolicyMemberCoverageAhHandler.getEnMemberCoverageAhTableDetails(exchDbQueries.enPolicy_Mem_CoverageAh());
    }
    public List<EnPolicyFinancialAhEntity> getEnPol_fin_ah_details(){
        return enPolicyFinancialAhHandler.getEnPolicyFinancialAhTableDetails(exchDbQueries.enPolicyFinancialAh());
    }
    public List<EnPolicyMemberAhEntity> getEnPol_mem_ah_details(){
        return enPolicyMemberAhHandler.getEnPolicyMemberAhTableDetails(exchDbQueries.enPolicyMemberAh());
	}

    public EsManualVerifRequestEntity getEsMVR_options(String manualVerificationType) {
        return manualVerifRequestDbHandler.getOptionsFromMVRTables(exchDbQueries.esMVR(manualVerificationType));
    }

    public Boolean getMVRDetails(){
        return postgresHandler.dbRecordsExisting(exchDbQueries.esMVRFullAccount());
    }

    public EsSsaVerificationReqEntity getSsaResponseCode(String memberId){
        return manualVerifRequestDbHandler.getSsaResponseCode(exchDbQueries.esSsaVerification(memberId));
    }

    public EsSsaVerificationReqEntity getSsaResponseCodeByCreatedBy(){
        return manualVerifRequestDbHandler.getSsaResponseCode(exchDbQueries.esSsaVerificationCreatedby());
    }

    public List<EnMemberEffectiveDatesEntity> getEnMember_eff_dates(){
        return enMemberEffectiveDatesHandler.getEnMemberEffectiveDatesDetails(exchDbQueries.enMemberEffectiveDates());
    }

    public List<EsMemberHouseholdEntity> getCountOfPersonIds(){
        return esMemberHouseholdHandler.getEsMemberHouseholdDetails(exchDbQueries.countOfPersonIds());
    }

    public List<EsMemberHouseholdEntity> getEsHousehold(){
        return esMemberHouseholdHandler.getEsMemberHouseholdDetails(exchDbQueries.esHousehold());
    }


    public EsHouseholdContactEntity getEsHouseholdContactDetails() {
        return esHouseholdContactDbHandler.getEsHouseholdContactDetails(exchDbQueries.getEmailStored());
    }
    public EsMemberHraAhEntity getOptionsFromHraAhDbTables(){
        return esMemberOhcDbHandler.getOptionsFromHraAhTables(exchDbQueries.getPrimaryHraAhRecords());

    }

    public List<String> getDBMedicalPlanList(){
        return postgresHandler.getResultListFor("plan_marketing_name", exchDbQueries.getDBMedicalPlanList() );
    }


    public String[] getmemberNonAIAN(String reasonCode) {
        return postgresHandler.getResultForTwoColumnValues("reason_code", "eligibility_type", exchDbQueries.getMemberNonAIAn(reasonCode));
    }

    public String[] getEsMemberRaceEthnicityDetails() {
        return postgresHandler.getResultForTwoColumnValues("race_ethnicity", "race_other_text", exchDbQueries.getRaceEthnicityStored());}


    public String getPlanMarketingName(String year){
        return postgresHandler.getResultFor("plan_marketing_name",exchDbQueries.getPlan_marketing_name(year));
    }

    public String getFplPercentDetails() {
        return postgresHandler.getResultFor("fpl_percent",exchDbQueries.fplPercentDetails());
    }

    public String getFPLPercentEsTaxReturnAPTC(){
        return postgresHandler.getResultFor("calculated_fpl",exchDbQueries.fplEsTaxReturn());
    }

    public String getMemberReasonCodeByAccountId() {
        return postgresHandler.getResultFor("reason_code",exchDbQueries.getMemberReasonCodeByAccountId());
    }


    public String getHouseholdID() {
        return postgresHandler.getResultFor("household_id",exchDbQueries.householdIdQuery());
    }

    public String getMemberID(String householdId) {
        return postgresHandler.getResultFor("member_id", exchDbQueries.memberIdQuery(householdId));
    }

    public String getReasonCode(String memberId, String expectedReasonCode) {
        return postgresHandler.getResultFor("reason_code", exchDbQueries.reasonCodeQuery(memberId, expectedReasonCode));
    }

    public String getCreatedBy(String memberId, String expectedReasonCode) {
        return postgresHandler.getResultFor("created_by", exchDbQueries.createdByQuery(memberId, expectedReasonCode));
    }

    public String[] getDentalPolicyDate() {
        return postgresHandler.getResultForTwoColumnValues("policy_start_date","policy_end_date",exchDbQueries.getDental_policy_date());}

    public String getMedLatestApplicationDate() {
        return postgresHandler.getResultFor("policy_submitted_ts",exchDbQueries.getMedCurrentLatestAppDate());

    }

    public String[] getMedSecondPolicy(String year) {
        return postgresHandler.getResultForThreeColumnValues("exchange_assigned_policy_id","policy_start_date","first_name",exchDbQueries.getMedSecondPolicyDB(year));
    }


    public String[] getDentSecondPolicy(String year) {
        return postgresHandler.getResultForThreeColumnValues("exchange_assigned_policy_id","policy_start_date","first_name",exchDbQueries.getDentalSecondPolicyDB(year));
    }

    public String getEventLogId(String event, String eventLogId) {
        return postgresHandler.getResultFor("event_log_id", exchDbQueries.getEventLogIdDB(event, eventLogId));
    }

    public String[] getLceType_PlanYr_esMember() {
        String householdId = postgresHandler.getResultFor("household_id", exchDbQueries.getHouseholdId());
        return postgresHandler.getResultForTwoColumnValues("lce_type","plan_year", exchDbQueries.getLceTpePlanYear(householdId));
    }

    public String getEnrollmentEndDate() {
        return postgresHandler.getResultFor("enrollment_period_end_date", exchDbQueries.getEnrollmentPeriodEndDate());
    }
    public String getMedCurrentEhbPremiumAmtForTheYearDB(String year) {
        return postgresHandler.getResultFor("ehb_percent_of_total_premium", exchDbQueries.ehb_percent_of_total_premiumForYear(year));
    }

    public String getRatingName() {
        return postgresHandler.getResultFor("name",exchDbQueries.nameRatingPolicy());
    }
    public String getMedServiceAreaForTheYearDB() {
        return postgresHandler.getResultFor("service_area_id",exchDbQueries.serviceAreaForTheYearDB());
    }
    public String[] getLCEEventTypeAndLCEDateTypeForTheYearDB() {
        return postgresHandler.getResultForTwoColumnValues("lce_type","lce_event_date",exchDbQueries.lCEEventTypeAndLCEDateTypeForTheYearDB());
    }

    public String getAv_calculator_output() {
        return postgresHandler.getResultFor("av_calculator_output",exchDbQueries.getAv_calculator_outputDB());
    }


    public String[] getMedDentalPolicyDate() {
            return postgresHandler.getResultForTwoColumnValues("policy_start_date","policy_end_date",exchDbQueries.getMedicalDental_policy_date());
    }

    public String getPrimaryTobaccoInMemberDetailsTable() {
        return postgresHandler.getResultFor("prior_6_months_tobacco_use_ind",exchDbQueries.prior_6_months_tobacco_use_ind());
    }

    public String getMedDenLatestApplicationDate() {
        return postgresHandler.getResultFor("policy_submitted_ts",exchDbQueries.getMedDentalCurrentLatestAppDate());
    }
    public String getTheBrokerEmailInDB() {
        return postgresHandler.getResultFor("email",exchDbQueries.getBrokerEmailIn());
    }

    public String[] getTaxFilingData(String memberId) {
        return postgresHandler.getResultForTwoColumnValues("claimed_as_dep_on_othr_ftr_ind", "tax_filing_type",exchDbQueries.getTaxFilingDataDB(memberId));
    }

    public String[] getTaxReturnData(String memberId) {
        return postgresHandler.getResultForFiveColumnValues("tax_filing_type","claimed_as_dep_on_othr_ftr_ind","tax_filing_status","exceptional_circumstance","tax_return_id", exchDbQueries.getTaxReturnDataDB(memberId));
    }

    public String[] get_rq_queue_msg(){
        return postgresHandler.getResultForThreeColumnValues("status", "changeevent", "requesttype", exchDbQueries.getRqQueMsg());
    }

    public String getMemberId(String fName){
        return postgresHandler.getResultFor("member_id", exchDbQueries.getMemberId(fName));
    }

    public EsMemberEntity getEsMemberDetails(String memId){
        return esMemberDbHandler.getEsMemberDbHandler(exchDbQueries.esMemberWithMemberId(memId));
    }

    public String getApplicationId_esApplication() {
        String householdId = postgresHandler.getResultFor("household_id", exchDbQueries.getHouseholdId());
        return postgresHandler.getResultFor("application_id", exchDbQueries.geApplicationId(householdId));
    }

    public List<String> getAllApplicationIds_esApplication() {
        String householdId = postgresHandler.getResultFor("household_id", exchDbQueries.getHouseholdId());
        return postgresHandler.getResultListFor("application_id", exchDbQueries.geAllApplicationIds(householdId));
    }

    public EsSelfAttestationEntity getEsSelfAttest_options() {
        String householdId = postgresHandler.getResultFor("household_id", exchDbQueries.getHouseholdId());
        return esSelfAttestationDbHandler.getOptionsFromSelfAttestTable(exchDbQueries.getSelfAttestationDetails(householdId));
    }
    public List<String> getEventCD(){
        String taxpayerKey = SharedData.getPrimaryTaxPayerKey();
        return postgresHandler.getResultListFor("event_cd", exchDbQueries.dorTaxHousehold(taxpayerKey));
    }
    public List<String> getEventLog(){
        String taxpayerKey = SharedData.getPrimaryTaxPayerKey();
        return postgresHandler.getResultListFor("event_cd", exchDbQueries.easyEnrollmentEventLog(taxpayerKey));
    }

    public List<EsMemberHouseholdEntity> getExchPersonIdFields_esMember(){
        String householdId = postgresHandler.getResultFor("household_id", exchDbQueries.getHouseholdId());
        return esMemberHouseholdHandler.getEsMemberHouseholdDetails(exchDbQueries.getExchPersonIdFields_esMem(householdId));
    }

    public List<EsMemberHouseholdEntity> getExchPersonIdFieldsOldAcc_esMember(){
        String householdId = postgresHandler.getResultFor("household_id", exchDbQueries.getHouseholdIdForOldAccount());
        return esMemberHouseholdHandler.getEsMemberHouseholdDetails(exchDbQueries.getExchPersonIdFields_esMem(householdId));
    }

    public List<String> getAddressInformation(String fName) {
        String memberId = postgresHandler.getResultFor("member_id", exchDbQueries.getMemberId(fName));
        return postgresHandler.getResultForDynamicColumns(exchDbQueries.getAddressDetails(memberId),"address_line1","address_line2","city","state","zip","county");
    }
    public List<String> getMailingAddressInformation(String fName) {
        String memberId = postgresHandler.getResultFor("member_id", exchDbQueries.getMemberId(fName));
        return postgresHandler.getResultForDynamicColumns(exchDbQueries.getMailingAddressDetails(memberId),"address_line1","city","state","zip","county");
    }
    public String getStateInformation(String fName) {
        String memberId = postgresHandler.getResultFor("member_id", exchDbQueries.getMemberId(fName));
        return postgresHandler.getResultFor("co_resident_ind", exchDbQueries.getStateDetails(memberId));
    }
    public List<String> getInfoForTellAboutAdditionalInformation(String fName) {
        String memberId = postgresHandler.getResultFor("member_id", exchDbQueries.getMemberId(fName));
        return postgresHandler.getResultForDynamicColumns(exchDbQueries.getTellAboutAdditionalInformation(memberId),"first_name","middle_name","last_name","gender","birth_date","applying_for_coverage_ind");
    }
    public List<String> getExchPersonIds() {
        return postgresHandler.getResultListFor("exch_person_id", exchDbQueries.compareExchPersonIds());
    }

    public String getArpIndicator() {
        return postgresHandler.getResultFor("arp_quick_submit_ind", exchDbQueries.getArpIndicator());
    }

    public String getCyaEligibility() {
        return postgresHandler.getResultFor("outcome_ind", exchDbQueries.getCyaEligibility());
    }

    public String getVLPResponseCode(String requestType) {
        return postgresHandler.getResultFor("response_code", exchDbQueries.getVLPResponseCodeInfo(requestType));
    }

    public String getFDSHRetryType() {
        return postgresHandler.getResultFor("service_type", exchDbQueries.getFDSHRetryType());
    }

    public String getFDSHRetryStatus() {
        return postgresHandler.getResultFor("status", exchDbQueries.getFDSHRetryStatus());
    }

    public List<String> getSubscribers(String memId) {
        return postgresHandler.getResultListFor("SubscriberInd", exchDbQueries.getMedSubscribers(memId));
	}
    public EsFDSHRetryControlEntity getEsFDSH_details() {
        return esFDSHRetryControlDbHandler.getDetailsFromFDSHRetry(exchDbQueries.getFDSHRetryDetails());
    }
    public List<IncomeDataEntity> getIncomeData() {
        return esIncomeDbHandler.getIncomeDetailsFromIncomeTables(exchDbQueries.getIncomeDataDetails());
    }

    public List<String> getApplicationIdFromHouseholdTable() {
        return postgresHandler.getResultListFor("application_id", exchDbQueries.getApplicationIdFromHouseholdTable());
    }

    public String getEmployerIncomeRowCount(){
        return postgresHandler.getResultFor("count", exchDbQueries.getMemberIncomeDetailsQuery() );
    }

    public String[] getDeductionAmount(String fName, String kindValue) {
        String memberId = postgresHandler.getResultFor("member_id", exchDbQueries.getMemberId(fName));
        return postgresHandler.getResultForThreeColumnValues("kind", "amount", "period", exchDbQueries.getDeductionamountDetails(memberId, kindValue));
    }

    public String getOverriddenAmount() {
        return postgresHandler.getResultFor("ind_ssap_data", exchDbQueries.getOverriddenAmountDetails());
    }

    public String getVlpRequestCount(){
        return postgresHandler.getResultFor("count", exchDbQueries.getVlpRequestCountQuery());}

    public String getEligibilityType(){
        return postgresHandler.getResultFor("eligibility_type", exchDbQueries.getEligibilityTypeQuery());}

    public String[] getDeterminationEffectiveDate(){
        return postgresHandler.getResultForTwoColumnValues("determination", "effective_date", exchDbQueries.getgetDeterminationEffectiveDateDetails());
    }

    public String getOutcomeInd(){
        return postgresHandler.getResultFor("outcome_ind", exchDbQueries.getOutcomeIndQuery());}

    public String getRemovedEffectiveDate(){
        return postgresHandler.getResultFor("removed_effective_date", exchDbQueries.getRemovedEffectiveDateQuery());}

    public List<String> getEsMemberLceAh(String memberId) {
        return postgresHandler.getResultForDynamicColumns(exchDbQueries.getEsMemberLceAhDetails(memberId),"lce_member_lce_id","lce_ah_member_lce_id","lce_evaluation_id","lce_ah_evaluation_id","lce_report_date","lce_ah_report_date","lce_event_date","lce_ah_event_date");
    }

    public String getDeductionRowCount(){
        String memberId = basicActions.getMemberId("Primary");
        return postgresHandler.getResultFor("count", exchDbQueries.getDeductionAmountCount(memberId));
    }

    public String getEnrollmentPlanYear() {
        return postgresHandler.getResultFor("plan_year", exchDbQueries.getEnrollmentPeriodEndDate());}

    public List<List<String>> getEnrollmentPlanLceDetails() {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(exchDbQueries.getMultipleEnrollmentPeriodEndDate(), "enrollment_period_end_date", "qlce_present_ind", "plan_year");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public String getEnrollmentPlanLceRowCount(){
        return postgresHandler.getResultFor("count", exchDbQueries.getEnrollmentPeriodEndDateCount());}

    public String[] getMyDocumentdetails() {
        return postgresHandler.getResultForFiveColumnValues("document_source_id", "document_author", "document_display_name", "file_extension", "received_date", exchDbQueries.getLatestForm8962DocumentQuery());
    }


    public String getTheAssistNetEmailInDB() {
        return postgresHandler.getResultFor("email",exchDbQueries.getAssistNetEmailIn());
    }
}
