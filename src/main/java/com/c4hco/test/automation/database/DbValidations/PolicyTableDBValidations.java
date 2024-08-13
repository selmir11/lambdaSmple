package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class PolicyTableDBValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();
    public void validateDataFromPolicyTables(List<Map<String, String>> expectedResult){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        List<PolicyTablesEntity> policyEntities = exchDbDataProvider.getDataFromPolicyTables();

        exchDbDataProvider.setDataFromDb(subscriber.getMedicalPlan());
        DbData dbData = SharedData.getDbData();

        for(PolicyTablesEntity policyTablesEntity: policyEntities){
            if(policyTablesEntity.getCoverage_type().equals("1")){
                validateMedicalPolicyDataFromDB(policyTablesEntity, dbData, expectedResult);
            } else{
                validateDentalPolicyDataFromDB(policyTablesEntity, dbData, expectedResult);
            }
              validateMedicalDentalPolicyDataFromDB(policyTablesEntity, dbData);
            // softAssert.assertAll();
        }
    }

    public void validateMedicalPolicyDataFromDB(PolicyTablesEntity policyTablesEntity, DbData dbData, List<Map<String, String>> expectedResult){
        //This method works for members in single group
        // validate MEDICAL specific details
        MemberDetails subscriber = SharedData.getPrimaryMember();
        String policyStartDate = SharedData.getPrimaryMember().getMedicalFinancialStartDate();
        String startDateFormatted = policyStartDate.substring(6,10)+"-" + policyStartDate.substring(0, 2)+"-" + policyStartDate.substring(3, 5);
        String policyEndDate = SharedData.getPrimaryMember().getMedicalFinancialEndDate();
        String endDateFormatted = policyEndDate.substring(6,10)+"-" + policyEndDate.substring(0, 2)+"-" + policyEndDate.substring(3, 5);

        if(policyTablesEntity.getSubscriber_ind().equals("1")){
            //Subscriber
            softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), startDateFormatted, "Coverage type 1, Policy start date does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), endDateFormatted, "Coverage type 1, Policy end date does not match");

            softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");

            softAssert.assertEquals(policyTablesEntity.getCoverage_start_date(), SharedData.getPlanYear()+"-"+expectedResult.get(0).get("CoverageStartDate"),"policy member coverage start date does not match");
            softAssert.assertEquals(policyTablesEntity.getCoverage_end_date(), SharedData.getPlanYear()+"-"+expectedResult.get(0).get("CoverageEndDate"), "policy member coverage end date does not match");
            softAssert.assertEquals(policyTablesEntity.getFinancial_period_start_date(),startDateFormatted, "Medical Policy financial start date does not match");
            softAssert.assertEquals(policyTablesEntity.getFinancial_period_end_date(),endDateFormatted, "Medical Policy financial end date does not match");
            softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), SharedData.getPrimaryMember().getMedicalPremiumAmt(), "Medical Policy total plan premium amount does not match");

            softAssert.assertEquals(policyTablesEntity.getTotal_premium_reduction_amt(),
                    subscriber.getFinancialHelp()? policyTablesEntity.getTotal_premium_reduction_amt() : SharedData.getPrimaryMember().getMedicalAptcAmt()+".00",
                    "Subscriber Medical APTC amount does not match");
            softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()),
                    subscriber.getFinancialHelp() ? "APTC" : "null",
                    "Subscriber Medical Policy premium reduction type does not match");

            softAssert.assertEquals(policyTablesEntity.getTotal_responsible_amt(),  SharedData.getPrimaryMember().getTotalMedAmtAfterReduction(),"--Medical Policy total responsible amount does not match");
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

    public void validateDentalPolicyDataFromDB(PolicyTablesEntity policyTablesEntity, DbData dbData, List<Map<String, String>> expectedResult){
        //This method works for members in single group
        // validate DENTAL specific details
        String policyStartDate = SharedData.getPrimaryMember().getDentalFinancialStartDate();
        String startDateFormatted = policyStartDate.substring(6,10)+"-" + policyStartDate.substring(0, 2)+"-" + policyStartDate.substring(3, 5);
        String policyEndDate = SharedData.getPrimaryMember().getDentalFinancialEndDate();
        String endDateFormatted = policyEndDate.substring(6,10)+"-" + policyEndDate.substring(0, 2)+"-" + policyEndDate.substring(3, 5);

        if(policyTablesEntity.getSubscriber_ind().equals("1")){
            //Subscriber
            softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), startDateFormatted, "Coverage type 2, Policy start date does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), endDateFormatted, "Coverage type 2, Policy end date does not match");
            softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), startDateFormatted, "Dental financial start date does not match");
            softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), endDateFormatted, "Dental financial end date does not match");
            softAssert.assertEquals(policyTablesEntity.getCoverage_start_date(), SharedData.getPlanYear()+"-"+expectedResult.get(0).get("CoverageStartDate"),"Dental member coverage start date does not match");
            softAssert.assertEquals(policyTablesEntity.getCoverage_end_date(), SharedData.getPlanYear()+"-"+expectedResult.get(0).get("CoverageEndDate"), "Dental member coverage end date does not match");

            softAssert.assertEquals(policyTablesEntity.getCurrent_ind(), "1", "Coverage type 2,Current_ind does not match");

            softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), SharedData.getPrimaryMember().getDentalPremiumAmt().replace("$", ""), "En member dental plan premium amount does not match");
            softAssert.assertEquals(policyTablesEntity.getPremium_reduction_amt(), SharedData.getPrimaryMember().getDentalAptcAmt().replace("$", "")+".00", "Dental aptc amount does not match");
            softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type()), "null","Dental Policy premium reduction type does not match");
            softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), "0.00", "Dental csr amount does not match");
            softAssert.assertEquals(policyTablesEntity.getCsr_level_epfh(), "01", "Dental CSR level does not match");

            softAssert.assertEquals(policyTablesEntity.getPolicy_member_coverage_status(), "SUBMITTED", "Dental member coverage status does not match");
            softAssert.assertEquals(policyTablesEntity.getSubscriber_ind(), "1", "Subscriber indicator is not 1");
            softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");
            softAssert.assertEquals(policyTablesEntity.getResponsible_adult_ind(), "0", "Responsible adult indicator is not zero");
            //softAssert.assertEquals(policyTablesEntity.getCreated_by(), SharedData.getPrimaryMember().getEmailId(), "Subscriber Created by does not match");

            softAssert.assertAll();
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
                    softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "Effectuated indicator is not zero");
                    softAssert.assertEquals(policyTablesEntity.getPolicy_submitted_by(), SharedData.getPrimaryMember().getEmailId(), "Member Created by does not match");
                    softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbData.getRatingAreaId(), "Rating area id does not match");
                }
            }
        }
        softAssert.assertAll();
    }

    public void validateMedicalDentalPolicyDataFromDB(PolicyTablesEntity policyTablesEntity, DbData dbData){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        softAssert.assertEquals(policyTablesEntity.getFirst_name(), subscriber.getFirstName(), "Subscriber first name matches");
        softAssert.assertEquals(policyTablesEntity.getLast_name(), subscriber.getLastName(), "Subscriber last name matches");
        softAssert.assertEquals(policyTablesEntity.getAccount_id(), String.valueOf(SharedData.getPrimaryMember().getAccount_id()), "Subscriber account id does not match");
        softAssert.assertEquals(policyTablesEntity.getApplication_id(), SharedData.getPrimaryMember().getApplication_id(), "Subscriber application id does not match");
        String subscriberdob = getSubscriberDOB();
        softAssert.assertTrue(policyTablesEntity.getBirth_date().contains(subscriberdob),"Subscriber DOB does not match");
        softAssert.assertEquals(SharedData.getPrimaryMember().getTobacco_user(),"No", "Subscriber tobacco usage matches");

        softAssert.assertEquals(policyTablesEntity.getPlan_year(), SharedData.getPlanYear(), " Plan year does not match");
        softAssert.assertEquals(policyTablesEntity.getCurrent_ind(), "1", "Current_ind does not match");
        softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "Coverage type 1, effectuated indicator does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_status(), "SUBMITTED", "Policy status does not match");
        softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbData.getRatingAreaId(), "Rating area id does not match");
        softAssert.assertAll();
    }

    private String getSubscriberDOB(){
        String dobData = SharedData.getPrimaryMember().getDob();
        String month = dobData.substring(0,2);
        String day = dobData.substring(2,4);
        String year = dobData.substring(4,8);
        String formattedDOB = year+"-"+month+"-"+day;
        return formattedDOB;
    }

}

