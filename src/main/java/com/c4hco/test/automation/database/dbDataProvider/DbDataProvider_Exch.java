package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.EsMemberOhiEntity;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.Queries.DbQueries_Exch;
import com.c4hco.test.automation.database.dbHandler.EsMemberOhiDbHandler;
import com.c4hco.test.automation.database.dbHandler.Ob834DetailsDbHandler;
import com.c4hco.test.automation.database.dbHandler.PolicyTableDbHandler;
import com.c4hco.test.automation.database.dbHandler.PostgresHandler;

import java.util.List;
import java.util.Map;

public class DbDataProvider_Exch {
    private DbQueries_Exch exchDbQueries = new DbQueries_Exch();
    PolicyTableDbHandler policyTableDbHandler = new PolicyTableDbHandler();
    Ob834DetailsDbHandler ob834DetailsDbHandler = new Ob834DetailsDbHandler();
    EsMemberOhiDbHandler esMemberOhiDbHandler = new EsMemberOhiDbHandler();
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
        String zipcode = primaryMember.getResAddress().getResidentialAddressZipcode();
        return  postgresHandler.getResultFor("fip_code", exchDbQueries.getFipcode(zipcode));
    }

    public String getRatingAreaName(String fipcode){
       return postgresHandler.getResultFor("name", exchDbQueries.getRatingArea(fipcode));

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

    public void setDataFromDb(String planName){
      String fipcode = getFipcode();
     String ratingAreaName = getRatingAreaName(fipcode);
     String[] baseIdAndHiosIssuerId = getBaseIdAndHiosIssuerForPlan(planName);
     String baseId = baseIdAndHiosIssuerId[0];
     String hiosIssuerId = baseIdAndHiosIssuerId[1];
     String[] issuerNameId = getIssuerNameId(hiosIssuerId);
     String issuerName = issuerNameId[0];
     String issuerId = issuerNameId[1];
     String exchPersonId = getExchPersonId();

        DbData dbData = new DbData();

        dbData.setFipcode(fipcode);
        dbData.setRatingAreaName(ratingAreaName);
        dbData.setBaseId(baseId);
        dbData.setHiosIssuerId(hiosIssuerId);
        dbData.setIssuerName(issuerName);
        dbData.setIssuerId(issuerId);
        dbData.setExchPersonId(exchPersonId);

        SharedData.setDbData(dbData);
    }

    public Boolean getDataFromOhiTables(){
        return postgresHandler.dbRecordsExisting(exchDbQueries.getOhiRecords());
    }

    public EsMemberOhiEntity getOptionsFromOhiDbTables(){
        return esMemberOhiDbHandler.getOptionsFromOhiTables(exchDbQueries.getOhiRecords());
    }
}
