package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.*;
import com.c4hco.test.automation.database.Queries.DbQueries_Exch;
import com.c4hco.test.automation.database.dbHandler.*;

import java.util.ArrayList;
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
    EsMemberOhiDbHandler esMemberOhiDbHandler = new EsMemberOhiDbHandler();
    BookOfBuisnessQDbHandler bookOfBuisnessQDbHandler = new BookOfBuisnessQDbHandler();
    PostgresHandler postgresHandler = new PostgresHandler();
    MemberDetails primaryMember = SharedData.getPrimaryMember();
    String fipcode;

    public List<PolicyTablesEntity> getDataFromPolicyTables(){
        return policyTableDbHandler.getPolicyTableDetails(exchDbQueries.policyTablesQuery());
    }

    public List<Ob834DetailsEntity> getOb83Db4Details(){
        return ob834DetailsDbHandler.getOb834DetalsAfterCompleted(exchDbQueries.ob834Details());
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
    public String getExchPersonId(){
        return postgresHandler.getResultFor("exch_person_id", exchDbQueries.exchPersonId());
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

     String exchPersonId = getExchPersonId();
     String brokerTinNum = getTinNumForBroker();
        DbData dbData = new DbData();

        dbData.setFipcode(fipcode);
        dbData.setRatingAreaName(ratingAreaName);
        dbData.setRatingAreaId(ratingAreaId);

        dbData.setExchPersonId(exchPersonId);

        dbData.setBrokerTinNum(brokerTinNum);

        SharedData.setDbData(dbData);
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
        String csrLevel = getCSRLevel();
        List<PlanDbData> medicalPlanDetailsFromDb = SharedData.getMedicalPlanDbData();
        if(medicalPlanDetailsFromDb==null) {
            medicalPlanDetailsFromDb = new ArrayList<>();
        }
            PlanDbData planDbData = new PlanDbData();
            // set details
            planDbData.setBaseId(baseId);
            planDbData.setPlanName(planName);
            medicalPlanDetailsFromDb.add(planDbData);
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
        String csrLevel = getCSRLevel();
        List<PlanDbData> dentalPlanDetailsFromDb = SharedData.getDentalPlanDbData();
        if(dentalPlanDetailsFromDb==null) {
            dentalPlanDetailsFromDb = new ArrayList<>();
        }
        PlanDbData planDbData = new PlanDbData();
        // set details
        planDbData.setBaseId(baseId);
        planDbData.setPlanName(planName);
        dentalPlanDetailsFromDb.add(planDbData);
        SharedData.setDentalPlanDbData(dentalPlanDetailsFromDb);
    }

    public Boolean getDataFromOhiTables(){
        return postgresHandler.dbRecordsExisting(exchDbQueries.getOhiRecords());
    }

    public EsMemberOhiEntity getOptionsFromOhiDbTables(){
        return esMemberOhiDbHandler.getOptionsFromOhiTables(exchDbQueries.getOhiRecords());
    }

    public EsMemberHraEntity getOptionsFromHraDbTables(){
        return esMemberOhiDbHandler.getOptionsFromHraTables(exchDbQueries.getPrimaryHraRecords());
    }

    public Map<String,String> getPolicyDqCheckAndPolicyAhId(){
        postgresHandler.setRec(exchDbQueries.setEnvForDataQuality());
        return postgresHandler.getResultForTwoColumnValuesInMap("policy_ah_id", "en_policy_dq_check", exchDbQueries.getPolicyDqCheck());
    }

    public List<BookOfBusinessQEntity> getBookOfBusinessQ(){
        return bookOfBuisnessQDbHandler.getBookOfBusinessQDetails(exchDbQueries.getBookOfBusinessQ());
    }


    public List<String> getPolicyId(){
        return postgresHandler.getResultListFor("policy_id", exchDbQueries.policyId());
    }


    public List<String> getAccount_holder_fn() {

       return postgresHandler.getResultListFor("Acct_holder_fn", exchDbQueries.getAcct_holder_fnFromBOB());}

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
}
