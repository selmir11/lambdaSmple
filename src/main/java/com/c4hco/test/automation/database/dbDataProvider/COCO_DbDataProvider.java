package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.*;
import com.c4hco.test.automation.database.Queries.DbQueries_COCO;
import com.c4hco.test.automation.database.Queries.DbQueries_Exch;
import com.c4hco.test.automation.database.dbHandler.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class COCO_DbDataProvider {
    private DbQueries_COCO cocoDbQueries = new DbQueries_COCO();
    PolicyTableDbHandler policyTableDbHandler = new PolicyTableDbHandler();
    EnPolicyAhHandler enPolicyAhHandler = new EnPolicyAhHandler();
    EnPolicyMemberAhHandler enPolicyMemberAhHandler = new EnPolicyMemberAhHandler();

    EnMemberEffectiveDatesHandler enMemberEffectiveDatesHandler = new EnMemberEffectiveDatesHandler();

    EnPolicyFinancialAhHandler enPolicyFinancialAhHandler = new EnPolicyFinancialAhHandler();
    EnMemberCoverageFinancialAhHandler enMemberCoverageFinancialAhHandler = new EnMemberCoverageFinancialAhHandler();
    EnPolicyMemberCoverageAhHandler enPolicyMemberCoverageAhHandler = new EnPolicyMemberCoverageAhHandler();
    Ob834DetailsDbHandler ob834DetailsDbHandler = new Ob834DetailsDbHandler();
    Ib999Handler ib999Handler = new Ib999Handler();
    Ob999Handler ob999Handler = new Ob999Handler();
    Ib834Handler ib834Handler = new Ib834Handler();
    EsMemberOhiDbHandler esMemberOhiDbHandler = new EsMemberOhiDbHandler();
    BookOfBuisnessQDbHandler bookOfBuisnessQDbHandler = new BookOfBuisnessQDbHandler();
    EsManualVerifRequestDbHandler manualVerifRequestDbHandler = new EsManualVerifRequestDbHandler();
    PostgresHandler postgresHandler = new PostgresHandler();
    MemberDetails primaryMember = SharedData.getPrimaryMember();
    EsMemberHouseholdHandler esMemberHouseholdHandler = new EsMemberHouseholdHandler();
    EsHouseholdContactDbHandler esHouseholdContactDbHandler = new EsHouseholdContactDbHandler();
    EsMemberDbHandler esMemberDbHandler = new EsMemberDbHandler();
    EsSelfAttestationDbHandler esSelfAttestationDbHandler = new EsSelfAttestationDbHandler();

//    public List<PolicyTablesEntity> getDataFromPolicyTables(){
//        return policyTableDbHandler.getPolicyTableDetails(cocoDbQueries.policyTablesQuery());
//    }

    public List<PolicyTablesEntity> getDataFrmPolicyTables(String coverageType){
        return policyTableDbHandler.getPolicyTableDetails(cocoDbQueries.policyTablesCombinedQuery(coverageType));
    }

    public List<Ob834DetailsEntity> getOb83Db4Details(){
        return ob834DetailsDbHandler.getOb834DetalsAfterCompleted(cocoDbQueries.ob834Details());
    }

    public List<Ob834DetailsEntity> getOb834Details(String insurance_line_code){
        return ob834DetailsDbHandler.getOb834DetalsAfterCompleted(cocoDbQueries.ob834DetailsRecords(insurance_line_code));
    }
    public List<Ib999Entity> getIb999Details(String ak1grp_ctrl_number){
        return ib999Handler.getIbDetailsAfterCompleted(cocoDbQueries.ib999Details(ak1grp_ctrl_number));
    }

    public List<Ob999Entity> getOb999Details(String ak1grp_ctrl_number){
        return ob999Handler.getObDetailsAfterCompleted(cocoDbQueries.ob999Details(ak1grp_ctrl_number));
    }

    public List<Ib834Entity> getIb834Details(String grpCtlNum){
        return ib834Handler.getIbDetailsAfterCompleted(cocoDbQueries.ib834Details(grpCtlNum));
    }
    public Map<String,String> getEap_id() {
        //This function works one medical EAPID and one dental EAPID
        Map<String, String> eapid = postgresHandler.getResultForTwoColumnValuesInMap("coverage_type", "exchange_assigned_policy_id", cocoDbQueries.getEAPID());
        primaryMember.setMedicalEapid_db(eapid.get("1"));
        primaryMember.setDentalEapid_db(eapid.get("2"));
        SharedData.setPrimaryMember(primaryMember);
        return eapid;
    }
    public Map<String,String> getMedicalEap_id(){
        return postgresHandler.getResultForTwoColumnValuesInMap("shopping_group_number", "exchange_assigned_policy_id", cocoDbQueries.getMedicalEAPID());
    }

    public Map<String,String> getDentalEap_id(){
        return postgresHandler.getResultForTwoColumnValuesInMap("shopping_group_number", "exchange_assigned_policy_id", cocoDbQueries.getDentalEAPID());
    }

    public String getFipcode(){
        String zipcode = primaryMember.getResAddress().getAddressZipcode();
        return  postgresHandler.getResultFor("fips", cocoDbQueries.getFipcode(zipcode));
    }

    public String getRatingAreaName(String fipcode){
       return postgresHandler.getResultFor("name", cocoDbQueries.getRatingArea(fipcode));

    }
    public String getRatingAreaId(String fipcode){
        return postgresHandler.getResultFor("rating_area_id", cocoDbQueries.getRatingAreaId(fipcode));
    }
    public String[] getIssuerNameId(String hiosIssuerId){
        return postgresHandler.getResultForTwoColumnValues("name", "tin_num", cocoDbQueries.en_issuer(hiosIssuerId));
    }

    public String[] getBaseIdAndHiosIssuerForPlan(String planName){
        return postgresHandler.getResultForTwoColumnValues("base_id", "hios_issuer_id", cocoDbQueries.en_plan(planName));
    }
    public String getExchPersonId(String memId){
        return postgresHandler.getResultFor("exch_person_id", cocoDbQueries.exchPersonId(memId));
    }
    public String getCSRLevel(){
        return postgresHandler.getResultFor("csr_level", cocoDbQueries.csrLevel());
    }
    public String getTinNumForBroker() {
        return postgresHandler.getResultFor("agency_tin_ein", cocoDbQueries.brokerId());
    }

    public Map<String,String> getSubscriberCSRDataFromDb(){
        Map<String,String> csrAmount =  postgresHandler.getResultForTwoColumnValuesInMap("coverage_type","csr_amt", cocoDbQueries.getCSRRecords());
        return csrAmount;
    }

    public void setDataFromDb(){
        String fipcode = getFipcode();
        String ratingAreaName = getRatingAreaName(fipcode);
        String ratingAreaId = getRatingAreaId(fipcode);
        String brokerTinNum = null;
        String csrLevel = "00";
        DbData dbData = new DbData();

        dbData.setFipcode(fipcode);
        dbData.setRatingAreaName(ratingAreaName);
        dbData.setRatingAreaId(ratingAreaId);
        dbData.setBrokerTinNum(brokerTinNum);
        dbData.setCsrLevel(csrLevel);
        SharedData.setDbData(dbData);
    }
    public void setDataFromDb_New(String name){
        String fipcode = getFipcode();
        String ratingAreaName = getRatingAreaName(fipcode);
        String ratingAreaId = getRatingAreaId(fipcode);
        String brokerTinNum = null;
        String csrLevel = null;
        if (!SharedData.getAppType().equals("coco")) {
            if(SharedData.getHasBroker()){
                brokerTinNum = getTinNumForBroker();
            }
            csrLevel = getCSRLevel();
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
        List<Map<String, DbData>> dbDataMapList = SharedData.getDbDataNew();
        if(dbDataMapList == null){
            dbDataMapList = new ArrayList<>();
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
        Map<String,String> csrMap = getSubscriberCSRDataFromDb();
        String csrAmtMed =csrMap.get("1");
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

    public Boolean getDataFromOhiTables(String memberId){
        return postgresHandler.dbRecordsExisting(cocoDbQueries.getOhiRecordsAll(memberId));
    }

    public EsMemberOhiEntity getOptionsFromOhiDbTables(String memberId) {
        return esMemberOhiDbHandler.getOptionsFromOhiTables(cocoDbQueries.getOhiRecordsAll(memberId));
    }

    public EsMemberHraEntity getOptionsFromHraDbTables(){
        return esMemberOhiDbHandler.getOptionsFromHraTables(cocoDbQueries.getPrimaryHraRecords());
    }

    public Map<String,String> getPolicyDqCheckAndPolicyAhId(){
        postgresHandler.setRec(cocoDbQueries.setEnvForDataQuality());
        return postgresHandler.getResultForTwoColumnValuesInMap("policy_ah_id", "en_policy_dq_check", cocoDbQueries.getPolicyDqCheck());
    }

    public List<BookOfBusinessQEntity> getBookOfBusinessQ(String eventType){
        return bookOfBuisnessQDbHandler.getBookOfBusinessQDetails(cocoDbQueries.getBookOfBusinessQ(eventType));
    }

    public List<String> getPolicyId(){
        return postgresHandler.getResultListFor("policy_id", cocoDbQueries.policyId());
    }
    public List<String> getApplicationId(){
        return postgresHandler.getResultListFor("application_id", cocoDbQueries.appIdFromEnPolicyAh());
    }

    public List<String> getAccount_holder_fn() {

       return postgresHandler.getResultListFor("Acct_holder_fn", cocoDbQueries.getAcct_holder_fnFromBOB());}

    public List<String> getClientEmailInBoB() {

       return postgresHandler.getResultListFor("email", cocoDbQueries.getClientEmailFromBOB());
    }

    public List<String> getBrokerAuthorizationInBoB(String clientFirstName) {

       return postgresHandler.getResultListFor("broker_name", cocoDbQueries.verifyBrokerAuthorizationInBOB(clientFirstName));
    }

    public List<String> getApplicationSubmissionInBoB() {

       return postgresHandler.getResultListFor("account_id", cocoDbQueries.verifyApplicationSubmissionInBOB());
    }

    public List<String> getPolicySubmissionInBoB(int coverageType) {

       return postgresHandler.getResultListFor("account_id", cocoDbQueries.verifyPolicySubmissionInBOB(coverageType));
    }

    public Boolean getNoMedicalPolicySubmissionInBoB() {

        return postgresHandler.dbRecordsExisting(cocoDbQueries.verifyPolicySubmissionInBOB(1));
    }

    public List<String> getAgencyCommissionTinDb() {

        return postgresHandler.getResultListFor("commission_tin", cocoDbQueries.verifyAgencyCommissionTinDb());
    }

    public Boolean getExchHouseholdIdBoB() {

        return postgresHandler.dbRecordsExisting(cocoDbQueries.verifyExchHouseholdIdBOB());
    }

    public List<String> getBrokerAuthorizationStatusBoB() {

        return postgresHandler.getResultListFor("authorization_status", cocoDbQueries.verifyBrokerAuthorizationStatusBOB());
    }

    public List<String> getBrokerAuthorizationTypeBoB() {

        return postgresHandler.getResultListFor("staff_type", cocoDbQueries.verifyBrokerAuthorizationTypeBOB());
    }

    public List<EnPolicyAhEntity> getEnPolicyAh_details(){
        return enPolicyAhHandler.getEnPolicyTableDetails(cocoDbQueries.enPolicyAh());
    }

    public List<EnMemberCoverageFinancialAhEntity> getEn_Mem_Cov_Fin_Ah_details(){
        return enMemberCoverageFinancialAhHandler.getEnMemberCoverageFinAhTableDetails(cocoDbQueries.enMem_Coverage_FinancialAh());
    }

    public List<EnPolicyMemberCoverageAhEntity> getEnPol_Mem_Cov_Ah_details(){
        return enPolicyMemberCoverageAhHandler.getEnMemberCoverageAhTableDetails(cocoDbQueries.enPolicy_Mem_CoverageAh());
    }
    public List<EnPolicyFinancialAhEntity> getEnPol_fin_ah_details(){
        return enPolicyFinancialAhHandler.getEnPolicyFinancialAhTableDetails(cocoDbQueries.enPolicyFinancialAh());
    }
    public List<EnPolicyMemberAhEntity> getEnPol_mem_ah_details(){
        return enPolicyMemberAhHandler.getEnPolicyMemberAhTableDetails(cocoDbQueries.enPolicyMemberAh());
	}

    public EsManualVerifRequestEntity getEsMVR_options(String manualVerificationType) {
        return manualVerifRequestDbHandler.getOptionsFromMVRTables(cocoDbQueries.esMVR(manualVerificationType));
    }

    public EsSsaVerificationReqEntity getSsaResponseCode(String memberId){
        return manualVerifRequestDbHandler.getSsaResponseCode(cocoDbQueries.esSsaVerification(memberId));
    }

    public List<EnMemberEffectiveDatesEntity> getEnMember_eff_dates(){
        return enMemberEffectiveDatesHandler.getEnMemberEffectiveDatesDetails(cocoDbQueries.enMemberEffectiveDates());
    }

    public List<EsMemberHouseholdEntity> getCountOfPersonIds(){
        return esMemberHouseholdHandler.getEsMemberHouseholdDetails(cocoDbQueries.countOfPersonIds());
    }

    public List<EsMemberHouseholdEntity> getEsHousehold(){
        return esMemberHouseholdHandler.getEsMemberHouseholdDetails(cocoDbQueries.esHousehold());
    }


    public EsHouseholdContactEntity getEsHouseholdContactDetails() {
        return esHouseholdContactDbHandler.getEsHouseholdContactDetails(cocoDbQueries.getEmailStored());
    }
    public EsMemberHraAhEntity getOptionsFromHraAhDbTables(){
        return esMemberOhiDbHandler.getOptionsFromHraAhTables(cocoDbQueries.getPrimaryHraAhRecords());

    }

    public List<String> getDBMedicalPlanList(){
        return postgresHandler.getResultListFor("plan_marketing_name", cocoDbQueries.getDBMedicalPlanList() );
    }

    public String[] getmemberNonAIAN(){
        return postgresHandler.getResultForTwoColumnValues("reason_code", "eligibility_type", cocoDbQueries.getMemberNonAIAn()) ;}


    public String[] getEsMemberRaceEthnicityDetails() {
        return postgresHandler.getResultForTwoColumnValues("race_ethnicity", "race_other_text", cocoDbQueries.getRaceEthnicityStored());}


    public String getPlanMarketingName(String year){
        return postgresHandler.getResultFor("plan_marketing_name",cocoDbQueries.getPlan_marketing_name(year));
    }

    public String getHouseholdID() {
        return postgresHandler.getResultFor("household_id",cocoDbQueries.householdIdQuery());
    }

    public String getMemberID(String householdId) {
        return postgresHandler.getResultFor("member_id", cocoDbQueries.memberIdQuery(householdId));
    }

    public String getReasonCode(String memberId, String expectedReasonCode) {
        return postgresHandler.getResultFor("reason_code", cocoDbQueries.reasonCodeQuery(memberId, expectedReasonCode));
    }

    public String[] getDentalPolicyDate() {
        return postgresHandler.getResultForTwoColumnValues("policy_start_date","policy_end_date",cocoDbQueries.getDental_policy_date());}

    public String getMedLatestApplicationDate() {
        return postgresHandler.getResultFor("policy_submitted_ts",cocoDbQueries.getMedCurrentLatestAppDate());

    }

    public String[] getMedSecondPolicy(String year) {
        return postgresHandler.getResultForThreeColumnValues("exchange_assigned_policy_id","policy_start_date","first_name",cocoDbQueries.getMedSecondPolicyDB(year));
    }


    public String[] getDentSecondPolicy(String year) {
        return postgresHandler.getResultForThreeColumnValues("exchange_assigned_policy_id","policy_start_date","first_name",cocoDbQueries.getDentalSecondPolicyDB(year));
    }

    public String getEventLogId(String event, String eventLogId) {
        return postgresHandler.getResultFor("event_log_id", cocoDbQueries.getEventLogIdDB(event, eventLogId));
    }

    public String[] getLceType_PlanYr_esMember() {
        String householdId = postgresHandler.getResultFor("household_id", cocoDbQueries.getHouseholdId());
        return postgresHandler.getResultForTwoColumnValues("lce_type","plan_year", cocoDbQueries.getLceTpePlanYear(householdId));
    }

    public String getEnrollmentEndDate() {
        return postgresHandler.getResultFor("enrollment_period_end_date", cocoDbQueries.getEnrollmentPeriodEndDate());
    }
    public String getMedCurrentEhbPremiumAmtForTheYearDB(String year) {
        return postgresHandler.getResultFor("ehb_percent_of_total_premium", cocoDbQueries.ehb_percent_of_total_premiumForYear(year));
    }

    public String getRatingName() {
        return postgresHandler.getResultFor("name",cocoDbQueries.nameRatingPolicy());
    }
    public String getMedServiceAreaForTheYearDB() {
        return postgresHandler.getResultFor("service_area_id",cocoDbQueries.serviceAreaForTheYearDB());
    }
    public String[] getLCEEventTypeAndLCEDateTypeForTheYearDB() {
        return postgresHandler.getResultForTwoColumnValues("lce_type","lce_event_date",cocoDbQueries.lCEEventTypeAndLCEDateTypeForTheYearDB());
    }

    public String getAv_calculator_output() {
        return postgresHandler.getResultFor("av_calculator_output",cocoDbQueries.getAv_calculator_outputDB());
    }


    public String[] getMedDentalPolicyDate() {
            return postgresHandler.getResultForTwoColumnValues("policy_start_date","policy_end_date",cocoDbQueries.getMedicalDental_policy_date());
    }

    public String getPrimaryTobaccoInMemberDetailsTable() {
        return postgresHandler.getResultFor("prior_6_months_tobacco_use_ind",cocoDbQueries.prior_6_months_tobacco_use_ind());
    }

    public String getMedDenLatestApplicationDate() {
        return postgresHandler.getResultFor("policy_submitted_ts",cocoDbQueries.getMedDentalCurrentLatestAppDate());
    }
    public String getTheBrokerEmailInDB() {
        return postgresHandler.getResultFor("email",cocoDbQueries.getBrokerEmailIn());
    }

    public String[] getTaxFilingData(String memberId) {
        return postgresHandler.getResultForTwoColumnValues("claimed_as_dep_on_othr_ftr_ind", "tax_filing_type",cocoDbQueries.getTaxFilingDataDB(memberId));
    }

    public String[] getTaxReturnData(String memberId) {
        return postgresHandler.getResultForFiveColumnValues("tax_filing_type","claimed_as_dep_on_othr_ftr_ind","tax_filing_status","exceptional_circumstance","tax_return_id", cocoDbQueries.getTaxReturnDataDB(memberId));
    }

    public String[] get_rq_queue_msg(){
        return postgresHandler.getResultForThreeColumnValues("status", "changeevent", "requesttype", cocoDbQueries.getRqQueMsg());
    }

    public String getMemberId(String fName){
        return postgresHandler.getResultFor("member_id", cocoDbQueries.getMemberId(fName));
    }

    public EsMemberEntity getEsMemberDetails(String memId){
        return esMemberDbHandler.getEsMemberDbHandler(cocoDbQueries.esMemberWithMemberId(memId));
    }

    public String getApplicationId_esApplication() {
        String householdId = postgresHandler.getResultFor("household_id", cocoDbQueries.getHouseholdId());
        return postgresHandler.getResultFor("application_id", cocoDbQueries.geApplicationId(householdId));
    }

    public List<String> getAllApplicationIds_esApplication() {
        String householdId = postgresHandler.getResultFor("household_id", cocoDbQueries.getHouseholdId());
        return postgresHandler.getResultListFor("application_id", cocoDbQueries.geAllApplicationIds(householdId));
    }

    public EsSelfAttestationEntity getEsSelfAttest_options() {
        String householdId = postgresHandler.getResultFor("household_id", cocoDbQueries.getHouseholdId());
        return esSelfAttestationDbHandler.getOptionsFromSelfAttestTable(cocoDbQueries.getSelfAttestationDetails(householdId));
    }
    public List<String> getEventCD(){
        String taxpayerKey = SharedData.getPrimaryTaxPayerKey();
        return postgresHandler.getResultListFor("event_cd", cocoDbQueries.dorTaxHousehold(taxpayerKey));
    }
    public List<String> getEventLog(){
        String taxpayerKey = SharedData.getPrimaryTaxPayerKey();
        return postgresHandler.getResultListFor("event_cd", cocoDbQueries.easyEnrollmentEventLog(taxpayerKey));
    }

    public List<EsMemberHouseholdEntity> getExchPersonIdFields_esMember(){
        String householdId = postgresHandler.getResultFor("household_id", cocoDbQueries.getHouseholdId());
        return esMemberHouseholdHandler.getEsMemberHouseholdDetails(cocoDbQueries.getExchPersonIdFields_esMem(householdId));
    }

    public List<EsMemberHouseholdEntity> getExchPersonIdFieldsOldAcc_esMember(){
        String householdId = postgresHandler.getResultFor("household_id", cocoDbQueries.getHouseholdIdForOldAccount());
        return esMemberHouseholdHandler.getEsMemberHouseholdDetails(cocoDbQueries.getExchPersonIdFields_esMem(householdId));
    }

    public List<String> getAddressInformation(String fName) {
        String memberId = postgresHandler.getResultFor("member_id", cocoDbQueries.getMemberId(fName));
        return postgresHandler.getResultForDynamicColumns(cocoDbQueries.getAddressDetails(memberId),"address_line1","address_line2","city","state","zip","county");
    }

}
