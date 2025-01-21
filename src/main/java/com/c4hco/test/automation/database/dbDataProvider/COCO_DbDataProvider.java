package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.*;
import com.c4hco.test.automation.database.Queries.DbQueries_Exch;
import com.c4hco.test.automation.database.dbHandler.PolicyTableDbHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class COCO_DbDataProvider {
    private DbQueries_Exch exchDbQueries = new DbQueries_Exch();
    DbDataProvider_Exch dbDataProviderExch = new DbDataProvider_Exch();
    PolicyTableDbHandler policyTableDbHandler = new PolicyTableDbHandler();

    public List<PolicyTablesEntity> getDataFrmPolicyTablesCOCO(String coverageType, String policyStatus){
        List<PolicyTablesEntity> policyTablesList = policyTableDbHandler.getPolicyTableDetails(exchDbQueries.policyTablesCombinedQuery(coverageType));
        return policyTablesList.stream().filter(policy -> policy.getPolicy_status().equals(policyStatus)).collect(Collectors.toList());
    }
    public void setDataFromDb(){
        String fipcode = dbDataProviderExch.getFipcodeCOCO();
        String ratingAreaName = dbDataProviderExch.getRatingAreaName(fipcode);
        String ratingAreaId = dbDataProviderExch.getRatingAreaId(fipcode);
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
        String exchPersnId =  dbDataProviderExch.getExchPersonId(memberId);
        Map<String, String> exchPersonId = SharedData.getExchPersonId();
        if(exchPersonId==null){
            exchPersonId = new HashMap<>();
        }
        exchPersonId.put(mem.getFirstName(), exchPersnId );
        SharedData.setExchPersonId(exchPersonId);
    }
    public void setMedicalPlanDataFromDb(String planName){
        String[] baseIdAndHiosIssuerId = dbDataProviderExch.getBaseIdAndHiosIssuerForPlan(planName);
        String baseId = baseIdAndHiosIssuerId[0];
        String hiosIssuerId = baseIdAndHiosIssuerId[1];
        String[] issuerNameId = dbDataProviderExch.getIssuerNameId(hiosIssuerId);
        String issuerName = issuerNameId[0];
        String issuerId = issuerNameId[1];
        Map<String,String> csrMap = dbDataProviderExch.getSubscriberCSRDataFromDb();
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
