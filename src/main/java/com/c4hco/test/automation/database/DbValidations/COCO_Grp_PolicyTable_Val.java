package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.PlanDbData;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.utils.BasicActions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.*;
import java.util.stream.Collectors;

public class COCO_Grp_PolicyTable_Val {

    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    BasicActions basicActions = new BasicActions();
    SoftAssert softAssert = new SoftAssert();
    List<PolicyTablesEntity> medPolicyEntityList = new ArrayList<>();
    DbData dbData = new DbData();
    PlanDbData medicalPlanDbData = new PlanDbData();
    MemberDetails subscriber = new MemberDetails();
    String polStatus;
    String policyMemCoverageStatus;
    String policyDisenrollmentReason;
    List<MemberDetails> subscribers;
    Map<String, DbData> dbDataMap = new HashMap<>();
    Map<String, PlanDbData> medicalPlanDbDataMap = new HashMap<>();
    Set<Map<String, DbData>> dbDataMapList = new HashSet<>();
    List<Map<String, PlanDbData>> medicalPlanDbDataMapList = new ArrayList<>();

    public void grpRecordsValidationsPolicyTable(String policyStatus) {
        switch (policyStatus) {
            case "SUBMITTED":
                polStatus = "SUBMITTED";
                policyMemCoverageStatus = "SUBMITTED";
                policyDisenrollmentReason = null;
                break;
            case "CANCELLED":
                polStatus = "CANCELLED";
                policyMemCoverageStatus = "DISENROLL_SUBMITTED";
                break;
            default:
                Assert.fail("Record Type entered is not valid");
        }
        setData();
        cocoMedRecordsValidations();
        softAssert.assertAll();
    }

    private void cocoMedRecordsValidations() {
        for (PolicyTablesEntity policyTablesEntity : medPolicyEntityList) {
            if (policyTablesEntity.getSubscriber_ind().equals("1")) {
                for (MemberDetails subscriber : subscribers) {
                    if (subscriber.getFirstName().equals(policyTablesEntity.getFirst_name())) {
                        validateSubscriberMedDetails(subscriber, policyTablesEntity);
                        validateFieldsCommonForSubscriber(subscriber, policyTablesEntity);
                        medValidationsCommonForAllMembers(subscriber.getFirstName(), policyTablesEntity);
                        break;
                    }
                }
            } else {
                validateDependentMedDetails(policyTablesEntity);
            }
        }
    }

    private void validateFieldsCommonForSubscriber(MemberDetails subscriber, PolicyTablesEntity policyTablesEntity) {
        getCocoDbDataMap(subscriber.getFirstName());
        validateSubmittedBy(policyTablesEntity,subscriber);
        softAssert.assertEquals(policyTablesEntity.getFirst_name(), subscriber.getFirstName(), "Subscriber first name matches");
        softAssert.assertEquals(policyTablesEntity.getLast_name(), subscriber.getLastName(), "Subscriber last name matches");
        softAssert.assertEquals(policyTablesEntity.getAccount_id(), String.valueOf(SharedData.getPrimaryMember().getAccount_id()), "Subscriber account id does not match");
        softAssert.assertEquals(policyTablesEntity.getApplication_id(), exchDbDataProvider.getApplicationIdFromHouseholdTable().get(0), "Subscriber application id does not match");
        softAssert.assertNull(policyTablesEntity.getTobacco_use(), "Tobacco use field is obsolete in policy tables. So, it should be null always. We got a non-null value");
        softAssert.assertTrue(policyTablesEntity.getBirth_date().contains(basicActions.changeDateFormat(subscriber.getDob(), "MMddyyyy", "yyyy-MM-dd")), "Subscriber DOB does not match");
        softAssert.assertEquals(policyTablesEntity.getPlan_year(), SharedData.getPlanYear(), " Plan year does not match");
        softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "Coverage type 1, effectuated indicator does not match in en policy ah");
        softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_epmh(), "0", "En effectuated indicator does not match in en policy member ah");
        softAssert.assertEquals(policyTablesEntity.getPolicy_status(), polStatus, "Policy status does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_member_coverage_status(), policyMemCoverageStatus, "Dental member coverage status does not match");
        softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbDataMap.get(subscriber.getFirstName()).getRatingAreaId(), "Rating area id does not match");
        softAssert.assertNull(policyTablesEntity.getResponsible_adult_ind(), "Responsible adult indicator is always null except when a minor only kid(s) applying");
        softAssert.assertEquals(policyTablesEntity.getDisenrollment_reason(), policyDisenrollmentReason, "Disenrollment reason mismatch");
        softAssert.assertAll();
    }

    private void getCocoDbDataMap(String name) {
        dbDataMap = new HashMap<>();
        for (Map<String, DbData> map : dbDataMapList) {
            if (map.containsKey(name)) {
                dbDataMap = map;
                break;
            }
        }
    }

    private void validateMedForDependents(PolicyTablesEntity policyTablesEntity, DbData dbData, MemberDetails member) {
        validateSubmittedBy(policyTablesEntity, member);
        softAssert.assertEquals(policyTablesEntity.getFirst_name(), member.getFirstName(), "Subscriber first name matches");
        softAssert.assertEquals(policyTablesEntity.getLast_name(), member.getLastName(), "Subscriber last name matches");
        softAssert.assertEquals(policyTablesEntity.getAccount_id(), String.valueOf(SharedData.getPrimaryMember().getAccount_id()), "Subscriber account id does not match");
        softAssert.assertEquals(policyTablesEntity.getApplication_id(), exchDbDataProvider.getApplicationIdFromHouseholdTable().get(0), "Subscriber application id does not match");
        softAssert.assertTrue(policyTablesEntity.getBirth_date().contains(basicActions.changeDateFormat(member.getDob(), "MMddyyyy", "yyyy-MM-dd")), "DOB does not match");
        softAssert.assertNull(policyTablesEntity.getTobacco_use(), "Tobacco use field is obsolete in policy tables. So, it should be null always. We got a non-null value");
        softAssert.assertEquals(policyTablesEntity.getPlan_year(), SharedData.getPlanYear(), " Plan year does not match");
        softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "effectuated indicator does not match in en policy ah");
        softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_epmh(), "0", "En effectuated indicator does not match in en policy member ah");
        softAssert.assertEquals(policyTablesEntity.getPolicy_status(), polStatus, "Policy status does not match");
        softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbData.getRatingAreaId(), "Rating area id for mem" + member.getFirstName() + " does not match");
        softAssert.assertNull(policyTablesEntity.getResponsible_adult_ind(), "Responsible adult indicator is always null except when a minor only kid(s) applying");
        softAssert.assertNull(policyTablesEntity.getDisenrollment_reason(), "Disenrollment reason mismatch");
        softAssert.assertAll();
    }

    private void validateDependentMedDetails(PolicyTablesEntity policyTablesEntity) {
        List<MemberDetails> members = SharedData.getMembers();
        for (MemberDetails member : members) {
            if (member.getFirstName().equals(policyTablesEntity.getFirst_name())) {
                System.out.println("Validating coco member :: " + member.getFirstName());
                validateMedForDependents(policyTablesEntity, dbDataMap.get(member.getMedSubscriberName()), member);
                softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), member.getRelation_to_subscriber(), "Relationship to subscriber does not match");
                softAssert.assertNull(policyTablesEntity.getTotal_plan_premium_amt(), "Medical Policy total plan premium amount for member does not match");
                softAssert.assertNull(policyTablesEntity.getTotal_premium_reduction_amt(), "Medical APTC amount from policy table does not match");
                softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()), "null", "Member Medical Policy premium reduction type does not match");
                softAssert.assertNull(policyTablesEntity.getPremium_reduction_type_epfh(), "premium reduction type in en policy financial ah table will be null for dependents");
                softAssert.assertNull(policyTablesEntity.getTotal_responsible_amt(), "Medical Policy total responsible amount for member does not match");
                softAssert.assertNull(policyTablesEntity.getFinancial_period_start_date(), "Medical financial start date does not match");
                softAssert.assertNull(policyTablesEntity.getFinancial_period_end_date(), "Medical financial end date does not match");
                softAssert.assertAll();
            }
        }
    }

    private void validateSubscriberMedDetails(MemberDetails subscriber, PolicyTablesEntity policyTablesEntity) {
        getMedicalPlanDbDataMap(subscriber.getFirstName());
        softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), subscriber.getMedicalPremiumAmt().replace(",", ""), "Medical Policy total plan premium amount does not match");
        softAssert.assertEquals(basicActions.doubleAmountFormat(policyTablesEntity.getTotal_premium_reduction_amt()), subscriber.getMedicalAptcAmt(), "Subscriber Medical APTC amount does not match");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()), "null", "Subscriber Medical Policy premium reduction type does not match");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_epfh()), "null", "premium reduction type in en policy financial ah table does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_responsible_amt(), subscriber.getMedicalPremiumAmt().replace(",", ""), "Medical Policy total responsible amount does not match");
        softAssert.assertEquals(policyTablesEntity.getFinancial_period_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialStartDate(), "Medical financial start date does not match");
        softAssert.assertEquals(policyTablesEntity.getFinancial_period_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialEndDate(), "Medical financial end date does not match");
        validateSubmittedBy(policyTablesEntity, subscriber);
        softAssert.assertAll();
    }

    private void medValidationsCommonForAllMembers(String name, PolicyTablesEntity policyTablesEntity) {
        getMedicalPlanDbDataMap(name);
        getCocoDbDataMap(name);
        softAssert.assertEquals(policyTablesEntity.getHios_plan_id(), medicalPlanDbDataMap.get(name).getBaseId() + "-00", "Hios id does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyStartDate(), "Coverage type 1, Policy start date does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyEndDate(), "Coverage type 1, Policy end date does not match");
        softAssert.assertEquals(policyTablesEntity.getCoverage_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getCoverageStartDate(), "policy member coverage start date does not match");
        softAssert.assertEquals(policyTablesEntity.getCoverage_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getCoverageEndDate(), "policy member coverage end date does not match");
        softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialStartDate(), "Medical member financial start date does not match");
        softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialEndDate(), "Medical member financial end date does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_member_coverage_status(), policyMemCoverageStatus, "Policy member coverage status does not match");
        softAssert.assertAll();
    }

    private void getMedicalPlanDbDataMap(String name) {
        medicalPlanDbDataMap = new HashMap<>();
        for (Map<String, PlanDbData> map : medicalPlanDbDataMapList) {
            if (map.containsKey(name)) {
                medicalPlanDbDataMap = map;
                break;
            }
        }
    }

    private void setData() {
        subscriber = SharedData.getPrimaryMember();
        medPolicyEntityList = exchDbDataProvider.getDataFrmPolicyTables("1");
        SharedData.setMedicalPolicyTablesEntities(medPolicyEntityList);

        for (PolicyTablesEntity policyTablesEntity : medPolicyEntityList) {
            if (policyTablesEntity.getSubscriber_ind().equals("1")) {
                for (MemberDetails member : basicActions.getAllMem()) {
                    if (policyTablesEntity.getFirst_name().equals(member.getFirstName())) {
                        member.setIsSubscriber("Y");
                        member.setRelation_to_subscriber("SELF");
                        break;
                    }
                }
            }
        }
        subscribers = basicActions.getAllSubscribers();
        for (MemberDetails subscriber : subscribers) {
            exchDbDataProvider.setDataFromDb_New(subscriber.getFirstName());
            exchDbDataProvider.setMedicalPlanDataFromDb_New(subscriber.getFirstName(), subscriber.getMedicalPlan());
        }
        setExchPersonId();
        dbDataMapList = SharedData.getDbDataNew();
        medicalPlanDbDataMapList = SharedData.getMedicalPlanDbDataNew();
        setMedicalSubscriber();
    }

    private void validateSubmittedBy(PolicyTablesEntity policyTablesEntity, MemberDetails member) {
        String submittedBy = policyTablesEntity.getPolicy_submitted_by();
        String primaryMemberEmail = SharedData.getPrimaryMember().getEmailId();
        softAssert.assertTrue(submittedBy.equals(member.getSubmittedBy()) || submittedBy.equals("SYSTEM"),
                "Submitted_by does not match either " + member.getSubmittedBy() + " or " + "SYSTEM"
        );
    }

    private void setExchPersonId() {
        List<MemberDetails> memberDetailsList = basicActions.getAllMem();
        Map<String, String> exchPersonId = new HashMap<>();
        SharedData.setExchPersonId(exchPersonId);
        for (MemberDetails member : memberDetailsList) {
            exchDbDataProvider.setExchPersonId(member, member.getMemberId());
        }
    }

    private void setMedicalSubscriber() {
        List<MemberDetails> allMem = basicActions.getAllMem();
        for (MemberDetails member : allMem) {
            for (MemberDetails subscriber : subscribers) {
                if (subscriber.getMedGroupInd().equals(member.getMedGroupInd())) {
                    member.setMedSubscriberName(subscriber.getFirstName());
                    break;
                }
            }
        }
    }


}
