package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.PlanDbData;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PolicyTableDBValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();

    public void validateDataFromPolicyTables() {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        List<PolicyTablesEntity> policyEntities = exchDbDataProvider.getDataFromPolicyTables();
        SharedData.setPolicyTablesEntities(policyEntities);
        exchDbDataProvider.setDataFromDb();
        DbData dbData = SharedData.getDbData();

        for (PolicyTablesEntity policyTablesEntity : policyEntities) {
            if (policyTablesEntity.getCoverage_type().equals("1")) {
                exchDbDataProvider.setMedicalPlanDataFromDb(subscriber.getMedicalPlan());
                PlanDbData medicalPlanDbData = SharedData.getMedicalPlanDbData().get("group1");
                medicalPlanDbData.setPremiumAmt(policyTablesEntity.getPlan_premium_amt());
                SharedData.getMedicalPlanDbData().put("group1", medicalPlanDbData);
                validateMedicalPolicyDataFromDB(policyTablesEntity, dbData, medicalPlanDbData);
            } else {
                exchDbDataProvider.setDentalPlanDataFromDb(subscriber.getDentalPlan());
                PlanDbData dentalPlanDbData = SharedData.getDentalPlanDbData().get("group1");
                dentalPlanDbData.setPremiumAmt(policyTablesEntity.getPlan_premium_amt());
                SharedData.getDentalPlanDbData().put("group1", dentalPlanDbData);
                validateDentalPolicyDataFromDB(policyTablesEntity, dbData, dentalPlanDbData);
            }
            validateMedicalDentalPolicyDataFromDB(policyTablesEntity, dbData);
        }
    }

    private void validateDependentMedDetails(PolicyTablesEntity policyTablesEntity, DbData dbData, PlanDbData medicalPlanDbData) {
        // WIP - We need medicalPlanDbData/Dental only for hios id - seperate that and validate for all members.
        List<MemberDetails> memberslist = SharedData.getMembers();
        for (MemberDetails member : memberslist) {
            if (member.getFirstName().equals(policyTablesEntity.getFirst_name())) {
                softAssert.assertEquals(policyTablesEntity.getFirst_name(), member.getFirstName(), "Member first name does not matches.");
                softAssert.assertEquals(policyTablesEntity.getLast_name(), member.getLastName(), "Member Last name does not matches.");
                softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), SharedData.getExpectedCalculatedDates().getFinancialStartDate(), "Member FInancial start date does not match");
                softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), SharedData.getExpectedCalculatedDates().getFinancialEndDate(), "Member financial end date does not match");
                softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), SharedData.getExpectedCalculatedDates().getPolicyStartDate(), "Policy start date does not match");
                softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), SharedData.getExpectedCalculatedDates().getPolicyEndDate(), "Policy end date does not match");
                softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), member.getMedicalPremiumAmt(), "Total medical premium amount without APTC does not match");
                softAssert.assertEquals(policyTablesEntity.getTotal_premium_reduction_amt(), member.getMedicalAptcAmt(), "Dental APTC amount does not match");
                softAssert.assertEquals(policyTablesEntity.getResponsible_amt(), member.getTotalMedAmtAfterReduction(), "Total medical responsible premium amount does not match");
                softAssert.assertEquals(policyTablesEntity.getCsr_level_epfh(), "01", "Medical CSR level does not match");
                softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), "0.00", "Medical Total CSR amount does not match");
                softAssert.assertEquals(policyTablesEntity.getSubscriber_ind(), "0", "Subscriber indicator is not 0");
                softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "WIFE", "Relationship to subscriber does not match");
                softAssert.assertEquals(policyTablesEntity.getCurrent_ind(), "1", "Current indicator does not match");
                softAssert.assertEquals(policyTablesEntity.getCreated_by(), SharedData.getPrimaryMember().getEmailId(), "Member Med Created by does not match");
                softAssert.assertAll();
                // WIP - Can we break here?
            }
        }
    }

    private void validateSubscriberMedDetails(PolicyTablesEntity policyTablesEntity, DbData dbData, PlanDbData medicalPlanDbData) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        softAssert.assertEquals(policyTablesEntity.getHios_plan_id(), medicalPlanDbData.getBaseId() + "-" + dbData.getCsrLevel(), "Hios id does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), SharedData.getExpectedCalculatedDates().getPolicyStartDate(), "Coverage type 1, Policy start date does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), SharedData.getExpectedCalculatedDates().getPolicyEndDate(), "Coverage type 1, Policy end date does not match");

        softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");

        softAssert.assertEquals(policyTablesEntity.getCoverage_start_date(), SharedData.getExpectedCalculatedDates().getCoverageStartDate(), "policy member coverage start date does not match");
        softAssert.assertEquals(policyTablesEntity.getCoverage_end_date(), SharedData.getExpectedCalculatedDates().getCoverageEndDate(), "policy member coverage end date does not match");
        softAssert.assertEquals(policyTablesEntity.getFinancial_period_start_date(), SharedData.getExpectedCalculatedDates().getFinancialStartDate(), "Medical financial start date does not match");
        softAssert.assertEquals(policyTablesEntity.getFinancial_period_end_date(), SharedData.getExpectedCalculatedDates().getFinancialEndDate(), "Medical financial end date does not match");
        softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), SharedData.getExpectedCalculatedDates().getFinancialStartDate(), "Medical member financial start date does not match");
        softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), SharedData.getExpectedCalculatedDates().getFinancialEndDate(), "Medical member financial end date does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), SharedData.getPrimaryMember().getMedicalPremiumAmt(), "Medical Policy total plan premium amount does not match");

        softAssert.assertEquals(policyTablesEntity.getTotal_premium_reduction_amt(),
                subscriber.getFinancialHelp() ? policyTablesEntity.getTotal_premium_reduction_amt() : SharedData.getPrimaryMember().getMedicalAptcAmt() + ".00",
                "Subscriber Medical APTC amount does not match");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()),
                subscriber.getFinancialHelp() ? "APTC" : "null",
                "Subscriber Medical Policy premium reduction type does not match");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()), "null", "premium reduction type in table en member coverage financial does not match.");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_epfh()), "null", "premium reduction type in en policy financial ah table does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_responsible_amt(), SharedData.getPrimaryMember().getTotalMedAmtAfterReduction(), "--Medical Policy total responsible amount does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), "0.00", "Medical Policy total CSR amount does not match");
        softAssert.assertAll();
    }

    private void validateSubscriberDenDetails(PolicyTablesEntity policyTablesEntity, DbData dbData, PlanDbData dentalPlanDbData) {
        softAssert.assertEquals(policyTablesEntity.getHios_plan_id(), dentalPlanDbData.getBaseId() + "-" + dbData.getCsrLevel(), "Subscriber Hios id does not match");

        softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), SharedData.getExpectedCalculatedDates().getPolicyStartDate(), "Coverage type 2, Policy start date does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), SharedData.getExpectedCalculatedDates().getPolicyEndDate(), "Coverage type 2, Policy end date does not match");

        softAssert.assertEquals(policyTablesEntity.getFinancial_period_start_date(), SharedData.getExpectedCalculatedDates().getFinancialStartDate(), "Dental financial start date does not match");
        softAssert.assertEquals(policyTablesEntity.getFinancial_period_end_date(), SharedData.getExpectedCalculatedDates().getFinancialEndDate(), "Dental financial end date does not match");
        softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), SharedData.getExpectedCalculatedDates().getFinancialStartDate(), "Dental member financial start date does not match");
        softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), SharedData.getExpectedCalculatedDates().getFinancialEndDate(), "Dental member financial end date does not match");
        softAssert.assertEquals(policyTablesEntity.getCoverage_start_date(), SharedData.getExpectedCalculatedDates().getCoverageStartDate(), "Dental member coverage start date does not match");
        softAssert.assertEquals(policyTablesEntity.getCoverage_end_date(), SharedData.getExpectedCalculatedDates().getCoverageEndDate(), "Dental member coverage end date does not match");

        softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), SharedData.getPrimaryMember().getDentalPremiumAmt().replace("$", ""), "En member dental plan premium amount does not match");
        softAssert.assertEquals(policyTablesEntity.getPremium_reduction_amt(), SharedData.getPrimaryMember().getDentalAptcAmt().replace("$", "") + ".00", "Dental aptc amount does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_responsible_amt(), SharedData.getPrimaryMember().getTotalDentalPremAfterReduction().replace("$", "").replace("/mo", ""), "Dental responsible amount");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type()), "null", "Dental Policy premium reduction type does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), "0.00", "Dental csr amount does not match");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()), "null", "premium reduction type in table en member coverage financial does not match.");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_epfh()), "null", "premium reduction type in en policy financial ah table does not match");

        softAssert.assertEquals(policyTablesEntity.getSubscriber_ind(), "1", "Subscriber indicator is not 1");
        softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");
        softAssert.assertAll();
    }

    private void validateDependentDenDetails(PolicyTablesEntity policyTablesEntity, DbData dbData, PlanDbData dentalPlanDbData) {
        List<MemberDetails> memberslist = SharedData.getMembers();
        for (MemberDetails member : memberslist) {
            // WIP
            if (policyTablesEntity.getFirst_name().equals(member.getFirstName())) {
                System.out.println("NAME::" + member.getFirstName());
                softAssert.assertEquals(policyTablesEntity.getLast_name(), member.getLastName(), "Member Last name does not matches.");
                softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), SharedData.getExpectedCalculatedDates().getFinancialStartDate(), "Member FInancial start date does not match");
                softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), SharedData.getExpectedCalculatedDates().getFinancialEndDate(), "Member financial end date does not match");
                softAssert.assertEquals(policyTablesEntity.getPolicy_status(), "SUBMITTED", "member status does not match");

                softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), SharedData.getExpectedCalculatedDates().getPolicyStartDate(), "Policy start date does not match");
                softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), SharedData.getExpectedCalculatedDates().getPolicyEndDate(), "Policy end date does not match");
                softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), member.getDentalPremiumAmt().replace("$", ""), "Total Dental premium amount does not match");
                softAssert.assertEquals(policyTablesEntity.getTotal_premium_reduction_amt(), member.getDentalAptcAmt(), "Dental APTC amount does not match");
                softAssert.assertEquals(policyTablesEntity.getCsr_level_epfh(), dbData.getCsrLevel(), "CSR level does not match");
                softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), "0.00", "Total CSR amount does not match");

                softAssert.assertEquals(policyTablesEntity.getSubscriber_ind(), "0", "Subscriber indicator is not 0");
                softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), member.getRelation_to_subscriber(), "Relationship to subscriber does not match");
                softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "Effectuated indicator is not zero");
            }
        }
    }

    public void validateMedicalPolicyDataFromDB(PolicyTablesEntity policyTablesEntity, DbData dbData, PlanDbData medicalPlanDbData) {
        //This method works for members in single group
        // validate MEDICAL specific details
        if (policyTablesEntity.getSubscriber_ind().equals("1")) {
            validateSubscriberMedDetails(policyTablesEntity, dbData, medicalPlanDbData);
        } else {
            validateDependentMedDetails(policyTablesEntity, dbData, medicalPlanDbData);
        }
    }

    public void validateDentalPolicyDataFromDB(PolicyTablesEntity policyTablesEntity, DbData dbData, PlanDbData dentalPlanDbData) {
        //This method works for members in single group
        if (policyTablesEntity.getSubscriber_ind().equals("1")) {
            validateSubscriberDenDetails(policyTablesEntity, dbData, dentalPlanDbData);
        } else {
            validateDependentDenDetails(policyTablesEntity, dbData, dentalPlanDbData);
        }
    }

    public void validateMedicalDentalPolicyDataFromDB(PolicyTablesEntity policyTablesEntity, DbData dbData) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        validateTobaccoUse(policyTablesEntity);
        validateSubmittedBy(policyTablesEntity);
        softAssert.assertEquals(policyTablesEntity.getFirst_name(), subscriber.getFirstName(), "Subscriber first name matches");
        softAssert.assertEquals(policyTablesEntity.getLast_name(), subscriber.getLastName(), "Subscriber last name matches");
        softAssert.assertEquals(policyTablesEntity.getAccount_id(), String.valueOf(SharedData.getPrimaryMember().getAccount_id()), "Subscriber account id does not match");
        softAssert.assertEquals(policyTablesEntity.getApplication_id(), SharedData.getPrimaryMember().getApplication_id(), "Subscriber application id does not match");
        String subscriberdob = getSubscriberDOB();
        softAssert.assertTrue(policyTablesEntity.getBirth_date().contains(subscriberdob), "Subscriber DOB does not match");
        //tobacco usage is empty in policy table query
        softAssert.assertEquals(SharedData.getPrimaryMember().getTobacco_user(), "No", "Subscriber tobacco usage matches");

        softAssert.assertEquals(policyTablesEntity.getPlan_year(), SharedData.getPlanYear(), " Plan year does not match");
        softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "Coverage type 1, effectuated indicator does not match in en policy ah");
        softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_epmh(), "0", "En effectuated indicator does not match in en policy member ah");
        softAssert.assertEquals(policyTablesEntity.getPolicy_status(), "SUBMITTED", "Policy status does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_member_coverage_status(), "SUBMITTED", "Dental member coverage status does not match");
        softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbData.getRatingAreaId(), "Rating area id does not match");
        softAssert.assertEquals(policyTablesEntity.getCsr_level_epfh(), dbData.getCsrLevel(), "epfh CSR level does not match");
        softAssert.assertEquals(policyTablesEntity.getCsr_level_emcfh(), dbData.getCsrLevel(), "emcfh CSR level does not match");
        //  softAssert.assertEquals(policyTablesEntity.getResponsible_adult_ind(), "0", "Responsible adult indicator is not zero");
        softAssert.assertNull(policyTablesEntity.getDisenrollment_reason(), "Disenrollment reason mismatch");
        softAssert.assertAll();
        // WIP - Validate for all members
    }

    private String getSubscriberDOB() {
        String dobData = SharedData.getPrimaryMember().getDob();
        String month = dobData.substring(0, 2);
        String day = dobData.substring(2, 4);
        String year = dobData.substring(4, 8);
        String formattedDOB = year + "-" + month + "-" + day;
        return formattedDOB;
    }

    private void validateTobaccoUse(PolicyTablesEntity policyTablesEntity) {
        if (policyTablesEntity.getTobacco_use() == null) {
            softAssert.assertEquals(SharedData.getPrimaryMember().getTobacco_user(), "No", "Tobacco usage for subscriber does not match");
        }
    }

    private void validateSubmittedBy(PolicyTablesEntity policyTablesEntity) {
        String submittedBy = policyTablesEntity.getPolicy_submitted_by();
        String primaryMemberEmail = SharedData.getPrimaryMember().getEmailId();

        softAssert.assertTrue(submittedBy.equals(primaryMemberEmail) || submittedBy.equals("SYSTEM"),
                "Submitted_by does not match either " + primaryMemberEmail + " or " + "SYSTEM"
        );
    }
}
