package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PolicyTableDBValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();
    public void validateDataFromPolicyTables(){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        List<PolicyTablesEntity> policyEntities = exchDbDataProvider.getDataFromPolicyTables();

        exchDbDataProvider.setDataFromDb(subscriber.getMedicalPlan());
        DbData dbData = SharedData.getDbData();

        for(PolicyTablesEntity policyTablesEntity: policyEntities){
            if(policyTablesEntity.getCoverage_type().equals("1")){
                validateMedicalPolicyDataFromDB(policyTablesEntity, dbData);
            } else{
                validateDentalPolicyDataFromDB(policyTablesEntity, dbData);
            }
            //  validateMedicalDentalPolicyDataFromDB(policyTablesEntity, subscriber);
            // softAssert.assertAll();
        }
    }

    public void validateMedicalPolicyDataFromDB(PolicyTablesEntity policyTablesEntity, DbData dbData){
        // validate MEDICAL specific details
        MemberDetails subscriber = SharedData.getPrimaryMember();
        String policyStartDate = SharedData.getPrimaryMember().getMedicalFinancialStartDate();
        String startDateFormatted = policyStartDate.substring(6,10)+"-" + policyStartDate.substring(0, 2)+"-" + policyStartDate.substring(3, 5);
        String policyEndDate = SharedData.getPrimaryMember().getMedicalFinancialEndDate();
        String endDateFormatted = policyEndDate.substring(6,10)+"-" + policyEndDate.substring(0, 2)+"-" + policyEndDate.substring(3, 5);

        if(policyTablesEntity.getSubscriber_ind().equals("1")){
            //Subscriber
            System.out.println(policyTablesEntity.getSubscriber_ind());
            softAssert.assertEquals(policyTablesEntity.getFirst_name(), subscriber.getFirstName(), "Subscriber first name matches");
            softAssert.assertEquals(policyTablesEntity.getLast_name(), subscriber.getLastName(), "Subscriber last name matches");
            softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), startDateFormatted, "Coverage type 1, Policy start date does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), endDateFormatted, "Coverage type 1, Policy end date does not match");
            softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "Coverage type 2, effectuated indicator does not match");
            softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbData.getRatingAreaId(), "Coverage type 1,Rating area id does not match");
            softAssert.assertEquals(policyTablesEntity.getPlan_year(), SharedData.getPlanYear(), "Coverage type 1, Plan year does not match");
            softAssert.assertEquals(policyTablesEntity.getCurrent_ind(), "1", "Coverage type 1,Current_ind does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_status(), "SUBMITTED", "Coverage type 1,Policy status does not match");

            softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), "2024-01-01", "En member medical financial start date does not match");
            softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), "2024-12-31", "En member medical financial end date does not match");
            softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), SharedData.getPrimaryMember().getMedicalPremiumAmt(), "En member medical plan premium amount does not match");
            softAssert.assertEquals(policyTablesEntity.getTotal_premium_reduction_amt(), SharedData.getPrimaryMember().getMedicalAptcAmt(), "En member medical aptc amount does not match");
            softAssert.assertEquals(policyTablesEntity.getTotal_responsible_amt(), SharedData.getPrimaryMember().getTotalMedAmtAfterReduction(), "En member medical responsible amount");
            softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), "0.00", "En member medical csr amount does not match");
            softAssert.assertEquals(policyTablesEntity.getCsr_level_epfh(), "01", "Medical CSR level does not match");

            softAssert.assertEquals(policyTablesEntity.getCoverage_start_date(), "2024-01-01","En policy member coverage start date does not match");
            softAssert.assertEquals(policyTablesEntity.getCoverage_end_date(), "2024-12-31", "En policy member coverage end date does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_member_coverage_status(), "SUBMITTED", "En policy member coverage status does not match");
            softAssert.assertEquals(policyTablesEntity.getCurrent_ind(), "1", "Current indicator does not match");

            softAssert.assertEquals(policyTablesEntity.getFinancial_period_start_date(),"2024-01-01", "Medical Policy financial start date does not match");
            softAssert.assertEquals(policyTablesEntity.getFinancial_period_end_date(),"2024-12-31", "Medical Policy financial end date does not match");
            softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), SharedData.getPrimaryMember().getMedicalPremiumAmt(), "Medical Policy total plan premium amount does not match");

            softAssert.assertEquals(policyTablesEntity.getTotal_premium_reduction_amt(),
                    subscriber.getFinancialHelp()? policyTablesEntity.getTotal_premium_reduction_amt() : SharedData.getPrimaryMember().getMedicalAptcAmt()+".00",
                    "Medical APTC amount does not match");
            softAssert.assertEquals(    String.valueOf(policyTablesEntity.getPremium_reduction_type()),
                    subscriber.getFinancialHelp() ? "APTC" : "null",
                    " Medical Policy premium reduction type does not match");

            softAssert.assertEquals(policyTablesEntity.getResponsible_amt(),  SharedData.getPrimaryMember().getTotalMedAmtAfterReduction(),"--Medical Policy total responsible amount does not match");
            softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), "0.00","Medical Policy total CSR amount does not match");
            softAssert.assertEquals(policyTablesEntity.getCsr_level_epfh(), "01", "Medical Policy CSR level does not match");
        }else {
            //Member
            List<MemberDetails> memberslist = SharedData.getMembers();
            if (memberslist != null) {
                for (int i = 0; i < memberslist.size(); i++) {
                    softAssert.assertEquals(policyTablesEntity.getFirst_name(), memberslist.get(i).getFirstName(), "Member first name does not matches.");
                    softAssert.assertEquals(policyTablesEntity.getLast_name(), memberslist.get(i).getLastName(), "Member Last name does not matches.");
                    softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), startDateFormatted, "Member FInancial start date does not match");
                    softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), endDateFormatted, "Member financial end date does not match");

                    softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), startDateFormatted, "Policy start date does not match");
                    softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), endDateFormatted, "Policy end date does not match");
                    softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), memberslist.get(i).getMedicalPremiumAmt(), "Total medical premium amount without APTC does not match");
                    softAssert.assertEquals(policyTablesEntity.getTotal_premium_reduction_amt(), memberslist.get(i).getMedicalAptcAmt(), "Dental APTC amount does not match" );
                    softAssert.assertEquals(policyTablesEntity.getResponsible_amt(), memberslist.get(i).getTotalMedAmtAfterReduction(), "Total medical responsible premium amount does not match");
                    softAssert.assertEquals(policyTablesEntity.getCsr_level_epfh(), "01", "Medical CSR level does not match");
                    softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(),"0.00", "Medical Total CSR amount does not match");
                    softAssert.assertEquals(policyTablesEntity.getSubscriber_ind(), "0", "Subscriber indicator is not 0");
                    softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "WIFE", "Relationship to subscriber does not match");
                    softAssert.assertEquals(policyTablesEntity.getCurrent_ind(), "1", "Current indicator does not match");
                    softAssert.assertEquals(policyTablesEntity.getCreated_by(), SharedData.getPrimaryMember().getEmailId(), "Member Med Created by does not match");
                }
            }

        }
        softAssert.assertAll();
    }

    public void validateDentalPolicyDataFromDB(PolicyTablesEntity policyTablesEntity, DbData dbData){
        // validate DENTAL specific details
        String policyStartDate = SharedData.getPrimaryMember().getDentalFinancialStartDate();
        String startDateFormatted = policyStartDate.substring(6,10)+"-" + policyStartDate.substring(0, 2)+"-" + policyStartDate.substring(3, 5);
        String policyEndDate = SharedData.getPrimaryMember().getDentalFinancialEndDate();
        String endDateFormatted = policyEndDate.substring(6,10)+"-" + policyEndDate.substring(0, 2)+"-" + policyEndDate.substring(3, 5);

        if(policyTablesEntity.getSubscriber_ind().equals("1")){
            //Subscriber
            softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), startDateFormatted, "Coverage type 2, Policy start date does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), endDateFormatted, "Coverage type 2, Policy end date does not match");
            softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), "2024-01-01", "Dental financial start date does not match");
            softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), "2024-12-31", "Dental financial end date does not match");
            softAssert.assertEquals(policyTablesEntity.getCoverage_start_date(), "2024-01-01","Dental member coverage start date does not match");
            softAssert.assertEquals(policyTablesEntity.getCoverage_end_date(), "2024-12-31", "Dental member coverage end date does not match");

            softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "Coverage type 2, effectuated indicator does not match");
            softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbData.getRatingAreaId(), "Coverage type 2,Rating area id does not match");
            softAssert.assertEquals(policyTablesEntity.getPlan_year(), SharedData.getPlanYear(), "Coverage type 2, Plan year does not match");
            softAssert.assertEquals(policyTablesEntity.getCurrent_ind(), "1", "Coverage type 2,Current_ind does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_status(), "SUBMITTED", "Coverage type 2,Policy status does not match");

            softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), SharedData.getPrimaryMember().getDentalPremiumAmt().replace("$", ""), "En member dental plan premium amount does not match");
            softAssert.assertEquals(policyTablesEntity.getPremium_reduction_amt(), SharedData.getPrimaryMember().getDentalAptcAmt().replace("$", "")+".00", "Dental aptc amount does not match");
            softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type()), "null","Dental Policy premium reduction type does not match");
            softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), "0.00", "Dental csr amount does not match");
            softAssert.assertEquals(policyTablesEntity.getCsr_level_epfh(), "01", "Dental CSR level does not match");

            softAssert.assertEquals(policyTablesEntity.getPolicy_member_coverage_status(), "SUBMITTED", "Dental member coverage status does not match");
            softAssert.assertEquals(policyTablesEntity.getCurrent_ind(), "1", "Current indicator does not match");
            softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "Effectuated indicator is not zero");
            softAssert.assertEquals(policyTablesEntity.getSubscriber_ind(), "1", "Subscriber indicator is not 1");
            softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");
            softAssert.assertEquals(policyTablesEntity.getResponsible_adult_ind(), "0", "Responsible adult indicator is not zero");
            softAssert.assertEquals(policyTablesEntity.getPolicy_submitted_by(), SharedData.getPrimaryMember().getEmailId(), "Subscriber Created by does not match");
            softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbData.getRatingAreaId(), "Rating area id does not match");
        }else{
            //Members
            List<MemberDetails> memberslist = SharedData.getMembers();
            if (memberslist != null) {
                for (int i = 0; i < memberslist.size(); i++) {
                    softAssert.assertEquals(policyTablesEntity.getFirst_name(), memberslist.get(i).getFirstName(), "Member first name matches.");
                    softAssert.assertEquals(policyTablesEntity.getLast_name(), memberslist.get(i).getLastName(), "Member Last name does not matches.");
                    softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), startDateFormatted, "Member FInancial start date does not match");
                    softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), endDateFormatted, "Member financial end date does not match");
                    softAssert.assertEquals(policyTablesEntity.getPolicy_status(), "SUBMITTED", "member status does not match");

                    softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), startDateFormatted, "Policy start date does not match");
                    softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), endDateFormatted, "Policy end date does not match");
                    softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), memberslist.get(i).getDentalPremiumAmt().replace("$",""), "Total Dental premium amount does not match");
                    softAssert.assertEquals(policyTablesEntity.getTotal_premium_reduction_amt(), memberslist.get(i).getDentalAptcAmt(), "Dental APTC amount does not match" );
                    softAssert.assertEquals(policyTablesEntity.getCsr_level_epfh(), "01", "CSR level does not match");
                    softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(),"0.00", "Total CSR amount does not match");

                    softAssert.assertEquals(policyTablesEntity.getSubscriber_ind(), "0", "Subscriber indicator is not 0");
                    softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "WIFE", "Relationship to subscriber does not match");
                    softAssert.assertEquals(policyTablesEntity.getCurrent_ind(), "1", "Current indicator does not match");
                    softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "Effectuated indicator is not zero");
                    softAssert.assertEquals(policyTablesEntity.getPolicy_submitted_by(), SharedData.getPrimaryMember().getEmailId(), "Member Created by does not match");
                    softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbData.getRatingAreaId(), "Rating area id does not match");
                }
            }
        }
        softAssert.assertAll();
    }
}

