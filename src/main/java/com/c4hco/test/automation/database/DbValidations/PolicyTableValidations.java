package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.EnMemberCoverageFinancialAhEntity;
import com.c4hco.test.automation.database.EntityObj.EnPolicyAhEntity;
import com.c4hco.test.automation.database.EntityObj.EnPolicyMemberCoverageAhEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.asserts.SoftAssert;

import java.util.List;

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

    public void validateEnMemberCoverageFinancialAh(){
        List<EnMemberCoverageFinancialAhEntity> EnMemCovFinAhEntities  =exchDbDataProvider.getEn_Mem_Cov_Fin_Ah_details();
            //Dental
            softAssert.assertEquals(EnMemCovFinAhEntities.get(0).getMember_financial_start_date(), "2024-01-01", "En member dental financial start date does not match");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(0).getMember_financial_end_date(), "2024-12-31", "En member dental financial end date does not match");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(0).getPlan_premium_amt(), SharedData.getPrimaryMember().getDentalPremiumAmt().replace("$",""), "En member dental plan premium amount does not match");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(0).getPremium_reduction_amt().replace(".00",""), SharedData.getPrimaryMember().getDentalAptcAmt().replace("$",""), "En member dental aptc amount does not match");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(0).getResponsible_amt(), SharedData.getPrimaryMember().getTotalDentalPremAfterReduction().replace("/mo","").replace("$",""), "En member dental responsible amount");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(0).getCsr_amt(), "0.00", "En member dental csr amount does not match");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(0).getCsr_level(), "01", "Dental CSR level does not match");
            //Medical
            softAssert.assertEquals(EnMemCovFinAhEntities.get(1).getMember_financial_start_date(), "2024-01-01", "En member medical financial start date does not match");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(1).getMember_financial_end_date(), "2024-12-31", "En member medical financial end date does not match");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(1).getPlan_premium_amt(), SharedData.getPrimaryMember().getMedicalPremiumAmt(), "En member medical plan premium amount does not match");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(1).getPremium_reduction_amt().replace(".00",""), SharedData.getPrimaryMember().getMedicalAptcAmt(), "En member medical aptc amount does not match");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(1).getResponsible_amt(), SharedData.getPrimaryMember().getTotalMedAmtAfterReduction(), "En member medical responsible amount");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(1).getCsr_amt(),"0.00", "En member medical csr amount does not match");
            softAssert.assertEquals(EnMemCovFinAhEntities.get(1).getCsr_level(), "01", "Medical CSR level does not match");
            softAssert.assertAll();
        }

    public void validateEnPolicyMemberCoverageAh(){
        List<EnPolicyMemberCoverageAhEntity> enPolMemCovAhEntities = exchDbDataProvider.getEnPol_Mem_Cov_Ah_details();
            softAssert.assertEquals(enPolMemCovAhEntities.get(0).getCoverage_start_date(), "2024-01-01","En policy member coverage start date does not match");
            softAssert.assertEquals(enPolMemCovAhEntities.get(0).getCoverage_end_date(), "2024-12-31", "En policy member coverage end date does not match");
            softAssert.assertEquals(enPolMemCovAhEntities.get(0).getPolicy_member_coverage_status(), "SUBMITTED", "En policy member coverage status does not match");
            softAssert.assertEquals(enPolMemCovAhEntities.get(0).getCurrent_ind(), "1", "Current indicator does not match");
            softAssert.assertEquals(enPolMemCovAhEntities.get(1).getCoverage_start_date(), "2024-01-01","En policy member coverage start date does not match");
            softAssert.assertEquals(enPolMemCovAhEntities.get(1).getCoverage_end_date(), "2024-12-31", "En policy member coverage end date does not match");
            softAssert.assertEquals(enPolMemCovAhEntities.get(1).getPolicy_member_coverage_status(), "SUBMITTED", "En policy member coverage status does not match");
            softAssert.assertEquals(enPolMemCovAhEntities.get(1).getCurrent_ind(), "1", "Current indicator does not match");
            softAssert.assertAll();
        }


}
