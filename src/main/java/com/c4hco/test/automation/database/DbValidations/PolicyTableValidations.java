package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class PolicyTableValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();
    //en policy table validations
    public void validateEnPolicyTableDetails() {
        List<Map<String, Object>> EnPolicyEntities = exchDbDataProvider.getEnPolicyAh_details();

        String policyStartDate = SharedData.getPrimaryMember().getMedicalFinancialStartDate();
        String startDateFormatted = policyStartDate.substring(6,10)+"-" + policyStartDate.substring(0, 2)+"-" + policyStartDate.substring(3, 5);
        String policyEndDate = SharedData.getPrimaryMember().getMedicalFinancialEndDate();
        String endDateFormatted = policyEndDate.substring(6,10)+"-" + policyEndDate.substring(0, 2)+"-" + policyEndDate.substring(3, 5);

        for (Map<String, Object> enPolicyEntity : EnPolicyEntities) {
            BigDecimal targetValue = new BigDecimal(enPolicyEntity.get("coverage_type").toString());
            if(targetValue.equals(new BigDecimal("2"))){
                softAssert.assertEquals(String.valueOf(enPolicyEntity.get("policy_start_date")), startDateFormatted, "coverage type 2, Policy start date does not match");
                softAssert.assertEquals(String.valueOf(enPolicyEntity.get("policy_end_date")), endDateFormatted, "coverage type 2, Policy end date does not match");
                //softAssert.assertEquals(enPolicyEntity.get("rating_area_id"), "Rating area id does not match");
                softAssert.assertEquals(enPolicyEntity.get("plan_year"), SharedData.getPlanYear(), "coverage type 2, Plan year does not match");
                //softAssert.assertEquals(enPolicyEntity.get("current_ind"), "Current_ind does not match");
                //softAssert.assertEquals(enPolicyEntity.get("policy_status"), "Policy status does not match");
            }else if(targetValue.equals(new BigDecimal("1"))){
                softAssert.assertEquals(String.valueOf(enPolicyEntity.get("policy_start_date")), startDateFormatted, "coverage type 1,--Policy start date does not match");
                softAssert.assertEquals(String.valueOf(enPolicyEntity.get("policy_end_date")), endDateFormatted, "coverage type 1,--Policy end date does not match");
                //softAssert.assertEquals(enPolicyEntity.get("rating_area_id"), "Rating area id does not match");
                softAssert.assertEquals(enPolicyEntity.get("plan_year"), SharedData.getPlanYear(), "coverage type 1,--Plan year does not match");
                //softAssert.assertEquals(enPolicyEntity.get("current_ind"), "Current_ind does not match");
                //softAssert.assertEquals(enPolicyEntity.get("policy_status"), "Policy status does not match");
            }
            softAssert.assertAll();
        }
    }

}
