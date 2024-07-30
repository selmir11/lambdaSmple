package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.EnPolicyAhEntity;
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
        List<EnPolicyAhEntity> EnPolicyEntities = exchDbDataProvider.getEnPolicyAh_details();

        String policyStartDate = SharedData.getPrimaryMember().getMedicalFinancialStartDate();
        String startDateFormatted = policyStartDate.substring(6,10)+"-" + policyStartDate.substring(0, 2)+"-" + policyStartDate.substring(3, 5);
        String policyEndDate = SharedData.getPrimaryMember().getMedicalFinancialEndDate();
        String endDateFormatted = policyEndDate.substring(6,10)+"-" + policyEndDate.substring(0, 2)+"-" + policyEndDate.substring(3, 5);

        for (EnPolicyAhEntity enPolicyEntity : EnPolicyEntities) {
            //BigDecimal targetValue = new BigDecimal(enPolicyEntity.get("coverage_type").toString());
            if(enPolicyEntity.getCoverage_type().equals("2")){
                softAssert.assertEquals(enPolicyEntity.getPolicy_start_date(), startDateFormatted, "Coverage type 2, Policy start date does not match");
                softAssert.assertEquals(enPolicyEntity.getPolicy_end_date(), endDateFormatted, "Coverage type 2, Policy end date does not match");
                softAssert.assertEquals(enPolicyEntity.getEffectuated_ind(), "0", "Coverage type 2, effectuated indicator does not match");
                softAssert.assertEquals(enPolicyEntity.getRating_area_id(),"8", "Coverage type 2,Rating area id does not match");
                softAssert.assertEquals(enPolicyEntity.getPlan_year(), SharedData.getPlanYear(), "Coverage type 2, Plan year does not match");
                softAssert.assertEquals(enPolicyEntity.getCurrent_ind(), "1","Coverage type 2,Current_ind does not match");
                softAssert.assertEquals(enPolicyEntity.getPolicy_status(), "SUBMITTED","Coverage type 2,Policy status does not match");
            }else if(enPolicyEntity.getCoverage_type().equals("1")){
                softAssert.assertEquals(enPolicyEntity.getPolicy_start_date(), startDateFormatted, "Coverage type 1, Policy start date does not match");
                softAssert.assertEquals(enPolicyEntity.getPolicy_end_date(), endDateFormatted, "Coverage type 1, Policy end date does not match");
                softAssert.assertEquals(enPolicyEntity.getEffectuated_ind(), "0", "Coverage type 2, effectuated indicator does not match");
                softAssert.assertEquals(enPolicyEntity.getRating_area_id(), "8","Coverage type 1,Rating area id does not match");
                softAssert.assertEquals(enPolicyEntity.getPlan_year(), SharedData.getPlanYear(), "Coverage type 1, Plan year does not match");
                softAssert.assertEquals(enPolicyEntity.getCurrent_ind(), "1","Coverage type 1,Current_ind does not match");
                softAssert.assertEquals(enPolicyEntity.getPolicy_status(), "SUBMITTED","Coverage type 1,Policy status does not match");
            }
            softAssert.assertAll();
        }
    }

}
