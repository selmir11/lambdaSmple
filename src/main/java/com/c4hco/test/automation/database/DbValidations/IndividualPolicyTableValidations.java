package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.*;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class IndividualPolicyTableValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();
    //en policy table validations
    public void validateEnPolicyTableDetails() {
        List<EnPolicyAhEntity> EnPolicyEntities = exchDbDataProvider.getEnPolicyAh_details();
        DbData dbData = SharedData.getDbData();
        String policyStartDate = SharedData.getPrimaryMember().getMedicalFinancialStartDate();
        String startDateFormatted = policyStartDate.substring(6,10)+"-" + policyStartDate.substring(0, 2)+"-" + policyStartDate.substring(3, 5);
        String policyEndDate = SharedData.getPrimaryMember().getMedicalFinancialEndDate();
        String endDateFormatted = policyEndDate.substring(6,10)+"-" + policyEndDate.substring(0, 2)+"-" + policyEndDate.substring(3, 5);

        for (EnPolicyAhEntity enPolicyEntity : EnPolicyEntities) {
            if(enPolicyEntity.getCoverage_type().equals("2")){
                softAssert.assertEquals(enPolicyEntity.getPolicy_start_date(), startDateFormatted, "Coverage type 2, Policy start date does not match");
                softAssert.assertEquals(enPolicyEntity.getPolicy_end_date(), endDateFormatted, "Coverage type 2, Policy end date does not match");
                softAssert.assertEquals(enPolicyEntity.getEffectuated_ind(), "0", "Coverage type 2, effectuated indicator does not match");
                softAssert.assertEquals(enPolicyEntity.getRating_area_id(), dbData.getRatingAreaId(), "Coverage type 2,Rating area id does not match");
                softAssert.assertEquals(enPolicyEntity.getPlan_year(), SharedData.getPlanYear(), "Coverage type 2, Plan year does not match");
                softAssert.assertEquals(enPolicyEntity.getCurrent_ind(), "1","Coverage type 2,Current_ind does not match");
                softAssert.assertEquals(enPolicyEntity.getPolicy_status(), "SUBMITTED","Coverage type 2,Policy status does not match");
            }else if(enPolicyEntity.getCoverage_type().equals("1")){
                softAssert.assertEquals(enPolicyEntity.getPolicy_start_date(), startDateFormatted, "Coverage type 1, Policy start date does not match");
                softAssert.assertEquals(enPolicyEntity.getPolicy_end_date(), endDateFormatted, "Coverage type 1, Policy end date does not match");
                softAssert.assertEquals(enPolicyEntity.getEffectuated_ind(), "0", "Coverage type 1, effectuated indicator does not match");
                softAssert.assertEquals(enPolicyEntity.getRating_area_id(), dbData.getRatingAreaId(),"Coverage type 1,Rating area id does not match");
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
    public void validateEnPolicyFinancialAh(){
       List<EnPolicyFinancialAhEntity> enPolicyFinAhEntities = exchDbDataProvider.getEnPol_fin_ah_details();
        MemberDetails subscriber = SharedData.getPrimaryMember();
        //Dental
        softAssert.assertEquals(enPolicyFinAhEntities.get(0).getFinancial_period_start_date(),"2024-01-01", "Dental Policy financial start date does not match");
        softAssert.assertEquals(enPolicyFinAhEntities.get(0).getFinancial_period_end_date(),"2024-12-31", "Dental Policy financial end date does not match");
        softAssert.assertEquals(enPolicyFinAhEntities.get(0).getTotal_plan_premium_amt(), SharedData.getPrimaryMember().getDentalPremiumAmt().replace("$",""), "Dental Policy total plan premium amount does not match");
        softAssert.assertEquals(enPolicyFinAhEntities.get(0).getTotal_premium_reduction_amt(), SharedData.getPrimaryMember().getDentalAptcAmt().replace("$","")+".00","Dental Policy total premium reduction amount does not match");
        softAssert.assertEquals(enPolicyFinAhEntities.get(0).getTotal_responsible_amt(), SharedData.getPrimaryMember().getTotalDentalPremAfterReduction().replace("$","").replace("/mo",""),"Dental Policy total responsible amount does not match");
        softAssert.assertEquals(String.valueOf(enPolicyFinAhEntities.get(0).getPremium_reduction_type()), "null","Dental Policy premium reduction type does not match");
        softAssert.assertEquals(enPolicyFinAhEntities.get(0).getTotal_csr_amt(), "0.00","Dental Policy total CSR amount does not match");
        softAssert.assertEquals(enPolicyFinAhEntities.get(0).getCsr_level(), "01", "Dental Policy CSR level does not match");
        //Medical
        softAssert.assertEquals(enPolicyFinAhEntities.get(1).getFinancial_period_start_date(),"2024-01-01", "Medical Policy financial start date does not match");
        softAssert.assertEquals(enPolicyFinAhEntities.get(1).getFinancial_period_end_date(),"2024-12-31", "Medical Policy financial end date does not match");
        softAssert.assertEquals(enPolicyFinAhEntities.get(1).getTotal_plan_premium_amt(), SharedData.getPrimaryMember().getMedicalPremiumAmt(), "Medical Policy total plan premium amount does not match");

        softAssert.assertEquals(enPolicyFinAhEntities.get(1).getTotal_premium_reduction_amt(),
               subscriber.getFinancialHelp()? enPolicyFinAhEntities.get(1).getTotal_premium_reduction_amt() : SharedData.getPrimaryMember().getMedicalAptcAmt()+".00",
               "Medical APTC amount does not match");
        softAssert.assertEquals(    String.valueOf(enPolicyFinAhEntities.get(1).getPremium_reduction_type()),
               subscriber.getFinancialHelp() ? "APTC" : "null",
               " Medical Policy premium reduction type does not match");

        softAssert.assertEquals(enPolicyFinAhEntities.get(1).getTotal_responsible_amt(),  SharedData.getPrimaryMember().getTotalMedAmtAfterReduction(),"--Medical Policy total responsible amount does not match");
        softAssert.assertEquals(enPolicyFinAhEntities.get(1).getTotal_csr_amt(), "0.00","Medical Policy total CSR amount does not match");
        softAssert.assertEquals(enPolicyFinAhEntities.get(1).getCsr_level(), "01", "Medical Policy CSR level does not match");
        softAssert.assertAll();
    }

    public void validateEnPolicyMemberAh(){
            List<EnPolicyMemberAhEntity> enPolMemAhEntities = exchDbDataProvider.getEnPol_mem_ah_details();
        MemberDetails subscriber = SharedData.getPrimaryMember();
        softAssert.assertEquals(enPolMemAhEntities.get(0).getEffectuated_ind(), "0", "Effectuated indicator is not zero");
        softAssert.assertEquals(enPolMemAhEntities.get(0).getSubscriber_ind(), "1", "Subscriber indicator is not 1");
        softAssert.assertEquals(enPolMemAhEntities.get(0).getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");
        softAssert.assertEquals(enPolMemAhEntities.get(0).getResponsible_adult_ind(), "0", "Responsible adult indicator is not zero");
        softAssert.assertEquals(enPolMemAhEntities.get(0).getCreated_by(), SharedData.getPrimaryMember().getEmailId(), "Created by does not match");

        softAssert.assertEquals(enPolMemAhEntities.get(1).getEffectuated_ind(), "0", "Effectuated indicator is not zero");
        softAssert.assertEquals(enPolMemAhEntities.get(1).getSubscriber_ind(), "1", "Subscriber indicator is not 1");
        softAssert.assertEquals(enPolMemAhEntities.get(1).getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");
        softAssert.assertEquals(enPolMemAhEntities.get(1).getResponsible_adult_ind(), "0", "Responsible adult indicator is not zero");
        softAssert.assertEquals(enPolMemAhEntities.get(1).getCreated_by(), SharedData.getPrimaryMember().getEmailId(), "Created by does not match");
        softAssert.assertAll();
    }

    public void validateUniquePersonId(){
            List<EsMemberHouseholdEntity> esMemberHouseholdEntities = exchDbDataProvider.getCountOfPersonIds();
        softAssert.assertEquals(esMemberHouseholdEntities.get(0).getCount(), "1", "Count of Person IDs is not 1");
        softAssert.assertAll();
    }

    public void validatePersonIdReviewStatus(){
            List<EsMemberHouseholdEntity> esMemberHouseholdEntities = exchDbDataProvider.getEsHousehold();
        softAssert.assertEquals(esMemberHouseholdEntities.get(0).getExch_person_id_review_status(), "MANUAL_REVIEW_REQUIRED", "Status is not Manual Review Required");
        softAssert.assertAll();
    }

    public void validateExchPersonIds() {
        List<String> exchPersonIds = exchDbDataProvider.getExchPersonIds();
        softAssert.assertEquals(exchPersonIds.size(), 2, "The number of EXCH_PERSON_IDs is not 2");
        if (exchPersonIds.size() == 2) {
            softAssert.assertEquals(exchPersonIds.get(0), exchPersonIds.get(1), "EXCH_PERSON_IDs are not the same");
        } else {
            softAssert.fail("Cannot validate EXCH_PERSON_IDs as the count is not 2");
        }
        softAssert.assertAll();
    }


}
