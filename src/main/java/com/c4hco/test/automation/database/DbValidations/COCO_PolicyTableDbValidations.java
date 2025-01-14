package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.PlanDbData;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.dbDataProvider.COCO_DbDataProvider;
import com.c4hco.test.automation.utils.BasicActions;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class COCO_PolicyTableDbValidations {
    COCO_DbDataProvider cocoDbDataProvider = new COCO_DbDataProvider();
    BasicActions basicActions = new BasicActions();
    SoftAssert softAssert = new SoftAssert();
    List<PolicyTablesEntity> medicalPolicyEntities = new ArrayList<>();
    DbData dbData = new DbData();
    PlanDbData medicalPlanDbData = new PlanDbData();
    PlanDbData dentalPlanDbData = new PlanDbData();
    MemberDetails subscriber = new MemberDetails();

    public void recordsValidations() {
        setData();
        medicalRecordsValidations();
        softAssert.assertAll();
    }

   private void medicalRecordsValidations() {
        for (PolicyTablesEntity policyTablesEntity : medicalPolicyEntities) {
            if (policyTablesEntity.getSubscriber_ind().equals("1")) {
                validateSubscriberMedDetails(policyTablesEntity);
                validateMedDenForSubscriber(policyTablesEntity);
            } else {
                validateDependentMedDetails(policyTablesEntity);
            }
            medValidationsCommonForAllMembers(policyTablesEntity);
        }
    }
    private void validateMedDenForSubscriber(PolicyTablesEntity policyTablesEntity) {
        validateSubmittedBy(policyTablesEntity);
        softAssert.assertEquals(policyTablesEntity.getFirst_name(), subscriber.getFirstName(), "Subscriber first name matches");
        softAssert.assertEquals(policyTablesEntity.getLast_name(), subscriber.getLastName(), "Subscriber last name matches");
        softAssert.assertEquals(policyTablesEntity.getAccount_id(), String.valueOf(subscriber.getAccount_id()), "Subscriber account id does not match");
        softAssert.assertEquals(policyTablesEntity.getApplication_id(), subscriber.getApplication_id(), "Subscriber application id does not match");
        softAssert.assertNull(policyTablesEntity.getTobacco_use(), "Tobacco use field is obsolete in policy tables. So, it should be null always. We got a non-null value");
        softAssert.assertTrue(policyTablesEntity.getBirth_date().contains(basicActions.changeDateFormat(subscriber.getDob(), "MMddyyyy", "yyyy-MM-dd")), "Subscriber DOB does not match");
        softAssert.assertEquals(policyTablesEntity.getPlan_year(), SharedData.getPlanYear(), " Plan year does not match");
        softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "Coverage type 1, effectuated indicator does not match in en policy ah");
        softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_epmh(), "0", "En effectuated indicator does not match in en policy member ah");
        softAssert.assertEquals(policyTablesEntity.getPolicy_status(), "SUBMITTED", "Policy status does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_member_coverage_status(), "SUBMITTED", "Dental member coverage status does not match");
        softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbData.getRatingAreaId(), "Rating area id does not match");
        softAssert.assertEquals(policyTablesEntity.getCsr_level_epfh(), dbData.getCsrLevel(), "epfh CSR level does not match");
        softAssert.assertEquals(policyTablesEntity.getCsr_level_emcfh(), dbData.getCsrLevel(), "emcfh CSR level does not match");
        softAssert.assertNull(policyTablesEntity.getResponsible_adult_ind(), "Responsible adult indicator is always null except when a minor only kid(s) applying");
        softAssert.assertNull(policyTablesEntity.getDisenrollment_reason(), "Disenrollment reason mismatch");
        softAssert.assertAll();
    }

    private void validateMedDenForDependents(PolicyTablesEntity policyTablesEntity, DbData dbData, MemberDetails member) {
        validateSubmittedBy(policyTablesEntity);
        softAssert.assertEquals(policyTablesEntity.getFirst_name(), member.getFirstName(), "Subscriber first name matches");
        softAssert.assertEquals(policyTablesEntity.getLast_name(), member.getLastName(), "Subscriber last name matches");
        softAssert.assertEquals(policyTablesEntity.getAccount_id(), String.valueOf(SharedData.getPrimaryMember().getAccount_id()), "Subscriber account id does not match");
        softAssert.assertEquals(policyTablesEntity.getApplication_id(), SharedData.getPrimaryMember().getApplication_id(), "Subscriber application id does not match");
        softAssert.assertTrue(policyTablesEntity.getBirth_date().contains(basicActions.changeDateFormat(member.getDob(), "MMddyyyy", "yyyy-MM-dd")), "DOB does not match");
        softAssert.assertNull(policyTablesEntity.getTobacco_use(), "Tobacco use field is obsolete in policy tables. So, it should be null always. We got a non-null value");
        softAssert.assertEquals(policyTablesEntity.getPlan_year(), SharedData.getPlanYear(), " Plan year does not match");
        softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "effectuated indicator does not match in en policy ah");
        softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_epmh(), "0", "En effectuated indicator does not match in en policy member ah");
        softAssert.assertEquals(policyTablesEntity.getPolicy_status(), "SUBMITTED", "Policy status does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_member_coverage_status(), "SUBMITTED", "Dental member coverage status does not match");
        softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbData.getRatingAreaId(), "Rating area id does not match");
        softAssert.assertNull(policyTablesEntity.getCsr_level_epfh(), "epfh CSR level does not match");
        softAssert.assertEquals(policyTablesEntity.getCsr_level_emcfh(), dbData.getCsrLevel(), "emcfh CSR level does not match");
        softAssert.assertNull(policyTablesEntity.getResponsible_adult_ind(), "Responsible adult indicator is always null except when a minor only kid(s) applying");
        softAssert.assertNull(policyTablesEntity.getDisenrollment_reason(), "Disenrollment reason mismatch");
        softAssert.assertAll();
    }

    private void validateDependentMedDetails(PolicyTablesEntity policyTablesEntity) {
        List<MemberDetails> members = SharedData.getMembers();
        for (MemberDetails member : members) {
            if (member.getFirstName().equals(policyTablesEntity.getFirst_name())) {
                validateMedDenForDependents(policyTablesEntity, dbData, member);
                softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), member.getRelation_to_subscriber(), "Relationship to subscriber does not match");
                softAssert.assertNull(policyTablesEntity.getTotal_plan_premium_amt(), "Medical Policy total plan premium amount for member does not match");
                softAssert.assertNull(policyTablesEntity.getTotal_premium_reduction_amt(), "Medical APTC amount from policy table does not match");
                softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()),  "null", "Member Medical Policy premium reduction type does not match");
                softAssert.assertNull(policyTablesEntity.getPremium_reduction_type_epfh(), "premium reduction type in en policy financial ah table will be null for dependents");
                softAssert.assertNull(policyTablesEntity.getTotal_responsible_amt(), "Medical Policy total responsible amount for member does not match");
                softAssert.assertNull(policyTablesEntity.getTotal_csr_amt(), "Medical Policy total CSR amount does not match");
                softAssert.assertNull(policyTablesEntity.getFinancial_period_start_date(), "Medical financial start date does not match");
                softAssert.assertNull(policyTablesEntity.getFinancial_period_end_date(), "Medical financial end date does not match");
                softAssert.assertAll();
            }
        }
    }

    private void validateSubscriberMedDetails(PolicyTablesEntity policyTablesEntity) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), subscriber.getMedicalPremiumAmt().replace(",", ""), "Medical Policy total plan premium amount does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_premium_reduction_amt(), subscriber.getAptcAmt(), "Subscriber Medical APTC amount does not match");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()), "null", "Subscriber Medical Policy premium reduction type does not match");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_epfh()), "null", "premium reduction type in en policy financial ah table does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_responsible_amt(), subscriber.getMedicalPremiumAmt().replace(",", ""), "Medical Policy total responsible amount does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), medicalPlanDbData.getCsrAmt(), "Medical Policy total CSR amount does not match");
        softAssert.assertEquals(policyTablesEntity.getFinancial_period_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialStartDate(), "Medical financial start date does not match");
        softAssert.assertEquals(policyTablesEntity.getFinancial_period_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialEndDate(), "Medical financial end date does not match");
        softAssert.assertAll();
    }

    private void medValidationsCommonForAllMembers(PolicyTablesEntity policyTablesEntity) {
        softAssert.assertEquals(policyTablesEntity.getHios_plan_id(), medicalPlanDbData.getBaseId() + "-" + dbData.getCsrLevel(), "Hios id does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyStartDate(), "Coverage type 1, Policy start date does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyEndDate(), "Coverage type 1, Policy end date does not match");

        softAssert.assertEquals(policyTablesEntity.getCoverage_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getCoverageStartDate(), "policy member coverage start date does not match");
        softAssert.assertEquals(policyTablesEntity.getCoverage_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getCoverageEndDate(), "policy member coverage end date does not match");

        softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialStartDate(), "Medical member financial start date does not match");
        softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialEndDate(), "Medical member financial end date does not match");
        softAssert.assertAll();
    }
    private void setData() {
        subscriber = SharedData.getPrimaryMember();
        List<PolicyTablesEntity> medicalPolicyEntitiesList = cocoDbDataProvider.getDataFrmPolicyTables("1");

        SharedData.setMedicalPolicyTablesEntities(medicalPolicyEntitiesList);

        cocoDbDataProvider.setDataFromDb();
        cocoDbDataProvider.setMedicalPlanDataFromDb(SharedData.getPrimaryMember().getMedicalPlan()); // Works for one group

        if (SharedData.getScenarioDetails().getTotalMembers() > 1) {
            List<MemberDetails> memberDetailsList = SharedData.getMembers();
            for (MemberDetails member : memberDetailsList) {
                cocoDbDataProvider.setExchPersonId(member, member.getMemberId());
            }
        }
        cocoDbDataProvider.setExchPersonId(subscriber, subscriber.getMemberId());

        medicalPolicyEntities = SharedData.getMedicalPolicyTablesEntities();
        dbData = SharedData.getDbData();
        medicalPlanDbData = SharedData.getMedicalPlanDbData().get("group1");
    }

    private void validateSubmittedBy(PolicyTablesEntity policyTablesEntity) {
        String submittedBy = policyTablesEntity.getPolicy_submitted_by();
        String primaryMemberEmail = SharedData.getPrimaryMember().getEmailId();

        softAssert.assertTrue(submittedBy.equals(primaryMemberEmail) || submittedBy.equals("SYSTEM"),
                "Submitted_by does not match either " + primaryMemberEmail + " or " + "SYSTEM"
        );
    }

}