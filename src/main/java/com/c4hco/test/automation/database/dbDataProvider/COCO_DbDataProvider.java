package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.*;
import com.c4hco.test.automation.database.Queries.DbQueries_COCO;
import com.c4hco.test.automation.database.Queries.DbQueries_Exch;
import com.c4hco.test.automation.database.dbHandler.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class COCO_DbDataProvider {
    private DbQueries_COCO cocoDbQueries = new DbQueries_COCO();
    private DbQueries_Exch exchDbQueries = new DbQueries_Exch();
    PolicyTableDbHandler policyTableDbHandler = new PolicyTableDbHandler();
    PostgresHandler postgresHandler = new PostgresHandler();
    MemberDetails primaryMember = SharedData.getPrimaryMember();

    public List<PolicyTablesEntity> getDataFrmPolicyTables(String coverageType){
        return policyTableDbHandler.getPolicyTableDetails(cocoDbQueries.policyTablesCombinedQuery(coverageType));
    }
    public String getFipcode(){
        String zipcode = primaryMember.getResAddress().getAddressZipcode();
        return  postgresHandler.getResultFor("fips", cocoDbQueries.getFipcode(zipcode));
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

    public Map<String,String> getSubscriberCSRDataFromDb(){
        Map<String,String> csrAmount =  postgresHandler.getResultForTwoColumnValuesInMap("coverage_type","csr_amt", exchDbQueries.getCSRRecords());
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

}
