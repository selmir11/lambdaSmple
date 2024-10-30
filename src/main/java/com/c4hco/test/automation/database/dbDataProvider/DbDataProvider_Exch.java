package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.*;
import com.c4hco.test.automation.database.Queries.DbQueries_Exch;
import com.c4hco.test.automation.database.dbHandler.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbDataProvider_Exch {
    private DbQueries_Exch exchDbQueries = new DbQueries_Exch();
    PolicyTableDbHandler policyTableDbHandler = new PolicyTableDbHandler();
    EnPolicyAhHandler enPolicyAhHandler = new EnPolicyAhHandler();
    EnPolicyMemberAhHandler enPolicyMemberAhHandler = new EnPolicyMemberAhHandler();
    EnPolicyFinancialAhHandler enPolicyFinancialAhHandler = new EnPolicyFinancialAhHandler();
    EnMemberCoverageFinancialAhHandler enMemberCoverageFinancialAhHandler = new EnMemberCoverageFinancialAhHandler();
    EnPolicyMemberCoverageAhHandler enPolicyMemberCoverageAhHandler = new EnPolicyMemberCoverageAhHandler();
    Ob834DetailsDbHandler ob834DetailsDbHandler = new Ob834DetailsDbHandler();
    Ib999Handler ib999Handler = new Ib999Handler();
    Ib834Handler ib834Handler = new Ib834Handler();
    EsMemberOhiDbHandler esMemberOhiDbHandler = new EsMemberOhiDbHandler();
    BookOfBuisnessQDbHandler bookOfBuisnessQDbHandler = new BookOfBuisnessQDbHandler();
    PostgresHandler postgresHandler = new PostgresHandler();
    MemberDetails primaryMember = SharedData.getPrimaryMember();
    EsMemberHouseholdHandler esMemberHouseholdHandler = new EsMemberHouseholdHandler();
    EsHouseholdContactDbHandler esHouseholdContactDbHandler = new EsHouseholdContactDbHandler();

    public List<PolicyTablesEntity> getDataFromPolicyTables(){
        return policyTableDbHandler.getPolicyTableDetails(exchDbQueries.policyTablesQuery());
    }

    public List<PolicyTablesEntity> getMedicalRecordsDataFromPolicyTables(){
        return policyTableDbHandler.getPolicyTableDetails(exchDbQueries.policyTablesMedicalRecordsQuery());
    }

    public List<PolicyTablesEntity> getDentalRecordsDataFromPolicyTables(){
        return policyTableDbHandler.getPolicyTableDetails(exchDbQueries.policyTablesDentalRecordsQuery());
    }

    public List<Ob834DetailsEntity> getOb83Db4Details(){
        return ob834DetailsDbHandler.getOb834DetalsAfterCompleted(exchDbQueries.ob834Details());
    }

    public List<Ob834DetailsEntity> getOb834Details(String insurance_line_code){
        return ob834DetailsDbHandler.getOb834DetalsAfterCompleted(exchDbQueries.ob834DetailsRecords(insurance_line_code));
    }
    public List<Ib999Entity> getIb999Details(String ak1grp_ctrl_number){
        return ib999Handler.getIbDetailsAfterCompleted(exchDbQueries.ib999Details(ak1grp_ctrl_number));
    }
    public List<Ib834Entity> getIb834Details(String grpCtlNum){
        return ib834Handler.getIbDetailsAfterCompleted(exchDbQueries.ib834Details(grpCtlNum));
    }

    public Map<String,String> getEap_id(){
        //This function works one medical EAPID and one dental EAPID
        Map<String,String> eapid = postgresHandler.getResultForTwoColumnValuesInMap("coverage_type", "exchange_assigned_policy_id", exchDbQueries.getEAPID());
        primaryMember.setMedicalEapid_db(eapid.get("1"));
        primaryMember.setDentalEapid_db(eapid.get("2"));
        SharedData.setPrimaryMember(primaryMember);
        return eapid;
    }

    public String getFipcode(){
        String zipcode = primaryMember.getResAddress().getAddressZipcode();
        return  postgresHandler.getResultFor("fip_code", exchDbQueries.getFipcode(zipcode));
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
    public String getExchPersonId(String memId){
        return postgresHandler.getResultFor("exch_person_id", exchDbQueries.exchPersonId(memId));
    }
    public String getCSRLevel(){
        return postgresHandler.getResultFor("csr_level", exchDbQueries.csrLevel());
    }
    public String getTinNumForBroker() {
        return postgresHandler.getResultFor("agency_tin_ein", exchDbQueries.brokerId());
    }

    public Map<String,String> getSubscriberCSRDataFromDb(){
        Map<String,String> csrAmount =  postgresHandler.getResultForTwoColumnValuesInMap("coverage_type","csr_amt", exchDbQueries.getCSRRecords());
        return csrAmount;
    }

    public void setDataFromDb(){
        String fipcode = getFipcode();
        String ratingAreaName = getRatingAreaName(fipcode);
        String ratingAreaId = getRatingAreaId(fipcode);
        String brokerTinNum = getTinNumForBroker();
        String csrLevel = getCSRLevel();
        DbData dbData = new DbData();

        dbData.setFipcode(fipcode);
        dbData.setRatingAreaName(ratingAreaName);
        dbData.setRatingAreaId(ratingAreaId);
        dbData.setBrokerTinNum(brokerTinNum);
        dbData.setCsrLevel(csrLevel);
        SharedData.setDbData(dbData);
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

    public Boolean getDataFromOhiTables(String memberId){
        return postgresHandler.dbRecordsExisting(exchDbQueries.getOhiRecordsAll(memberId));
    }

    public EsMemberOhiEntity getOptionsFromOhiDbTables(String memberId) {
        return esMemberOhiDbHandler.getOptionsFromOhiTables(exchDbQueries.getOhiRecordsAll(memberId));
    }

    public EsMemberHraEntity getOptionsFromHraDbTables(){
        return esMemberOhiDbHandler.getOptionsFromHraTables(exchDbQueries.getPrimaryHraRecords());
    }

    public Map<String,String> getPolicyDqCheckAndPolicyAhId(){
        postgresHandler.setRec(exchDbQueries.setEnvForDataQuality());
        return postgresHandler.getResultForTwoColumnValuesInMap("policy_ah_id", "en_policy_dq_check", exchDbQueries.getPolicyDqCheck());
    }

    public List<BookOfBusinessQEntity> getBookOfBusinessQ(String eventType){
        return bookOfBuisnessQDbHandler.getBookOfBusinessQDetails(exchDbQueries.getBookOfBusinessQ(eventType));
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
        return esMemberOhiDbHandler.getOptionsFromHraAhTables(exchDbQueries.getPrimaryHraAhRecords());

    }

    public List<String> getDBMedicalPlanList(){
        return postgresHandler.getResultListFor("plan_marketing_name", exchDbQueries.getDBMedicalPlanList() );
    }

    public String[] getEsMemberRaceEthnicityDetails() {
        return postgresHandler.getResultForTwoColumnValues("race_ethnicity", "race_other_text", exchDbQueries.getRaceEthnicityStored());}


    public String getPlanMarketingName(String year){
        return postgresHandler.getResultFor("plan_marketing_name",exchDbQueries.getPlan_marketing_name(year));
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
}
