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

public class PolicyTableDbValidations {

    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    BasicActions basicActions = new BasicActions();
    SoftAssert softAssert = new SoftAssert();
    List<PolicyTablesEntity> medicalPolicyEntities = new ArrayList<>();
    List<PolicyTablesEntity> dentalPolicyEntities = new ArrayList<>();
    Set<Map<String, DbData>> dbDataMapList = new HashSet<>();
    List<Map<String, PlanDbData>> medicalPlanDbDataMapList = new ArrayList<>();
    List<Map<String, PlanDbData>> dentalPlanDbDataMapList = new ArrayList<>();
    Map<String, PlanDbData> medicalPlanDbDataMap = new HashMap<>();
    Map<String, PlanDbData> dentalPlanDbDataMap = new HashMap<>();
    Map<String, DbData> dbDataMap = new HashMap<>();
    List<MemberDetails> subscribers;
    String policyStatus;
    String policyMemCoverageStatus;

    public void groupRecordsValidations(String recordType) {
        SharedData.setRecType(recordType);
            switch (recordType) {
                case "medical":
                    policyStatus ="SUBMITTED";
                    policyMemCoverageStatus="SUBMITTED";
                    setMedicalData();
                    medicalRecordsValidations();
                    break;
                case "dental":
                    policyStatus ="SUBMITTED";
                    policyMemCoverageStatus="SUBMITTED";
                    setDentalData();
                    dentalRecordsValidations();
                    break;
                case "medical-cancelled":
                    policyStatus ="CANCELLED";
                    policyMemCoverageStatus ="DISENROLL_SUBMITTED";
                    setMedicalCancelData();
                    medicalRecordsValidations();
                    break;
                case "dental-cancelled":
                    policyStatus ="CANCELLED";
                    policyMemCoverageStatus ="DISENROLL_SUBMITTED";
                    setDentalCancelData();
                    dentalRecordsValidations();
                    break;
                default:
                    Assert.fail("Record Type entered is not valid");
            }
            softAssert.assertAll();
    }

    private void setMedicalCancelData() {
        resetValues();
        medicalPolicyEntities = exchDbDataProvider.getDataFrmPolicyTables("1");
        SharedData.setMedicalPolicyTablesEntities(null);
        List<PolicyTablesEntity> medCancelledPolEntities = new ArrayList<>();
        for(PolicyTablesEntity entity :medicalPolicyEntities){
            if(entity.getPolicy_status().equals("CANCELLED")) {
                medCancelledPolEntities.add(entity);
            }
        }
        SharedData.setMedicalPolicyTablesEntities(medCancelledPolEntities);
        for (PolicyTablesEntity policyTablesEntity : medCancelledPolEntities) {
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
            exchDbDataProvider.setMedicalPlanDataFromDb_New(subscriber.getFirstName(),subscriber.getMedicalPlan());
        }
        setExchPersonId();
        dbDataMapList = SharedData.getDbDataNew();
        medicalPlanDbDataMapList = SharedData.getMedicalPlanDbDataNew();
        setMedicalSubscriber();
    }
    private void setDentalCancelData() {
        resetValues();
        dentalPolicyEntities = exchDbDataProvider.getDataFrmPolicyTables("2");
        List<PolicyTablesEntity> denCancelledPolEntities = new ArrayList<>();
        for(PolicyTablesEntity entity :dentalPolicyEntities){
            if(entity.getPolicy_status().equals("CANCELLED")) {
                denCancelledPolEntities.add(entity);
            }
        }
        SharedData.setDentalPolicyTablesEntities(denCancelledPolEntities);
        for (PolicyTablesEntity policyTablesEntity : dentalPolicyEntities) {
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
            exchDbDataProvider.setDentalPlanDataFromDb_New(subscriber.getFirstName(),subscriber.getDentalPlan());
        }
        setExchPersonId();
        dbDataMapList = SharedData.getDbDataNew();
        dentalPlanDbDataMapList = SharedData.getDentalPlanDbDataNew();
        setDentalSubscriber();
    }
    private void dentalRecordsValidations() {
            for (PolicyTablesEntity dentalEntity : dentalPolicyEntities) {
                if (dentalEntity.getSubscriber_ind().equals("1")) {
                    for(MemberDetails subscriber: subscribers){
                        if(subscriber.getFirstName().equals(dentalEntity.getFirst_name())){
                            validateSubscriberDenDetails(subscriber,dentalEntity);
                            validateMedDenForSubscriber(subscriber,dentalEntity);
                            denValidationsCommonForAllMembers(subscriber.getFirstName(), dentalEntity);
                        }
                    }
                } else {
                    validateDependentDenDetails(dentalEntity);
                }
            }
        }

        private void resetValues(){
             medicalPolicyEntities = new ArrayList<>();
             dentalPolicyEntities = new ArrayList<>();
             dbDataMapList = new HashSet<>();
             medicalPlanDbDataMapList = new ArrayList<>();
            dentalPlanDbDataMapList = new ArrayList<>();
             medicalPlanDbDataMap = new HashMap<>();
             dentalPlanDbDataMap = new HashMap<>();
             dbDataMap = new HashMap<>();
             subscribers = new ArrayList<>();
            SharedData.setDbDataNew(dbDataMapList);
             if(SharedData.getRecType()!=null && SharedData.getRecType().contains("medical")){
                 SharedData.setMedicalPlanDbDataNew(medicalPlanDbDataMapList);
             }
        }

        private void medicalRecordsValidations() {
            for (PolicyTablesEntity policyTablesEntity : medicalPolicyEntities) {
                if (policyTablesEntity.getSubscriber_ind().equals("1")) {
                    for(MemberDetails subscriber : subscribers){
                        if(subscriber.getFirstName().equals(policyTablesEntity.getFirst_name())){
                            validateSubscriberMedDetails(subscriber, policyTablesEntity);
                            validateMedDenForSubscriber(subscriber, policyTablesEntity);
                            medValidationsCommonForAllMembers(subscriber.getFirstName(),policyTablesEntity);
                            break;
                        }
                    }
                } else {
                    validateDependentMedDetails(policyTablesEntity);
                }
            }
        }

            private void validateSubscriberMedDetails(MemberDetails subscriber, PolicyTablesEntity policyTablesEntity) {
                getMedicalPlanDbDataMap(subscriber.getFirstName());
               softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");
               softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), subscriber.getMedicalPremiumAmt().replace(",", ""), "Medical Policy total plan premium amount does not match");
               softAssert.assertEquals(basicActions.doubleAmountFormat(policyTablesEntity.getTotal_premium_reduction_amt()), basicActions.doubleAmountFormat(SharedData.getPrimaryMember().getFinancialHelp() ? policyTablesEntity.getTotal_premium_reduction_amt() : subscriber.getMedicalAptcAmt()), "Subscriber Medical APTC amount does not match");
               softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()), Double.parseDouble(subscriber.getMedicalAptcAmt()) > 0 ? "APTC" : "null", "Subscriber Medical Policy premium reduction type does not match");
               softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_epfh()), Double.parseDouble(subscriber.getMedicalAptcAmt()) > 0 ? "APTC" : "null", "premium reduction type in en policy financial ah table does not match");
               softAssert.assertEquals(policyTablesEntity.getTotal_responsible_amt(), subscriber.getTotalMedAmtAfterReduction().replace(",", ""), "Medical Policy total responsible amount does not match");
               softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), medicalPlanDbDataMap.get(subscriber.getFirstName()).getCsrAmt(), "Medical Policy total CSR amount does not match");
               softAssert.assertEquals(policyTablesEntity.getFinancial_period_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialStartDate(), "Medical financial start date does not match");
               softAssert.assertEquals(policyTablesEntity.getFinancial_period_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialEndDate(), "Medical financial end date does not match");
               softAssert.assertEquals(policyTablesEntity.getDisenrollment_reason(), SharedData.getPrimaryMember().getPolicyDisenrollmentReasonMed(),"Disenrollment reason mismatch");
            softAssert.assertAll();
        }

        private void validateSubscriberDenDetails(MemberDetails subscriber,PolicyTablesEntity policyTablesEntity) {
            getDentalPlanDbDataMap(subscriber.getFirstName());
            softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");
            softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), subscriber.getDentalPremiumAmt(), "Dental Policy total plan premium amount does not match");
            softAssert.assertEquals(basicActions.doubleAmountFormat(policyTablesEntity.getTotal_premium_reduction_amt()), basicActions.doubleAmountFormat(SharedData.getPrimaryMember().getFinancialHelp() ? policyTablesEntity.getTotal_premium_reduction_amt() : subscriber.getDentalAptcAmt()) , "Subscriber Dental APTC amount does not match");
            softAssert.assertNull(policyTablesEntity.getPremium_reduction_type_emcfh(), "subscriber Dental Policy premium reduction type does not match");
            softAssert.assertNull(policyTablesEntity.getPremium_reduction_type_epfh(), "premium reduction type in en policy financial ah table does not match");
            softAssert.assertEquals(policyTablesEntity.getTotal_responsible_amt(), subscriber.getTotalDentalPremAfterReduction(), "Dental Policy total responsible amount does not match");
            softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), dentalPlanDbDataMap.get(subscriber.getFirstName()).getCsrAmt(), "Dental Policy total CSR amount does not match");
            softAssert.assertEquals(policyTablesEntity.getFinancial_period_start_date(), SharedData.getExpectedCalculatedDates_dentalPlan().getFinancialStartDate(), "Dental financial start date does not match");
            softAssert.assertEquals(policyTablesEntity.getFinancial_period_end_date(), SharedData.getExpectedCalculatedDates_dentalPlan().getFinancialEndDate(), "Dental financial end date does not match");
            softAssert.assertEquals(policyTablesEntity.getDisenrollment_reason(), SharedData.getPrimaryMember().getPolicyDisenrollmentReasonDen(),"Disenrollment reason mismatch");
            softAssert.assertAll();
        }

        private void validateMedDenForSubscriber(MemberDetails subscriber, PolicyTablesEntity policyTablesEntity) {
            getDbDataMap(subscriber.getFirstName());
            validateSubmittedBy(policyTablesEntity);
            softAssert.assertEquals(policyTablesEntity.getFirst_name(), subscriber.getFirstName(), "Subscriber first name matches");
            softAssert.assertEquals(policyTablesEntity.getLast_name(), subscriber.getLastName(), "Subscriber last name matches");
            softAssert.assertEquals(policyTablesEntity.getAccount_id(), String.valueOf(SharedData.getPrimaryMember().getAccount_id()), "Subscriber account id does not match");
            softAssert.assertEquals(policyTablesEntity.getApplication_id(), SharedData.getPrimaryMember().getApplication_id(), "Subscriber application id does not match");
            softAssert.assertNull(policyTablesEntity.getTobacco_use(), "Tobacco use field is obsolete in policy tables. So, it should be null always. We got a non-null value");
            softAssert.assertTrue(policyTablesEntity.getBirth_date().contains(basicActions.changeDateFormat(subscriber.getDob(), "MMddyyyy", "yyyy-MM-dd")), "Subscriber DOB does not match");
            softAssert.assertEquals(policyTablesEntity.getPlan_year(), SharedData.getPlanYear(), " Plan year does not match");
            softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "Coverage type 1, effectuated indicator does not match in en policy ah");
            softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_epmh(), "0", "En effectuated indicator does not match in en policy member ah");
            softAssert.assertEquals(policyTablesEntity.getPolicy_status(), policyStatus, "Policy status does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_member_coverage_status(), policyMemCoverageStatus, "Dental member coverage status does not match");
            softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbDataMap.get(subscriber.getFirstName()).getRatingAreaId(), "Rating area id does not match");
            softAssert.assertEquals(policyTablesEntity.getCsr_level_epfh(), SharedData.getRecType()!=null && SharedData.getRecType().contains("medical")&& SharedData.getIsAiAn()? "03": dbDataMap.get(subscriber.getFirstName()).getCsrLevel(), "epfh CSR level does not match");
            softAssert.assertEquals(policyTablesEntity.getCsr_level_emcfh(),  SharedData.getRecType()!=null && SharedData.getRecType().contains("medical")&& SharedData.getIsAiAn()? "03": dbDataMap.get(subscriber.getFirstName()).getCsrLevel(), "emcfh CSR level does not match");
            softAssert.assertNull(policyTablesEntity.getResponsible_adult_ind(), "Responsible adult indicator is always null except when a minor only kid(s) applying");
            softAssert.assertAll();
        }

        private void validateMedDenForDependents(PolicyTablesEntity policyTablesEntity, DbData dbData, MemberDetails member) {
            validateSubmittedBy(policyTablesEntity);
            softAssert.assertEquals(policyTablesEntity.getFirst_name(), member.getFirstName(), "member first name matches");
            softAssert.assertEquals(policyTablesEntity.getLast_name(), member.getLastName(), "member last name matches");
            softAssert.assertEquals(policyTablesEntity.getAccount_id(), String.valueOf(SharedData.getPrimaryMember().getAccount_id()), "Subscriber account id does not match");
            softAssert.assertEquals(policyTablesEntity.getApplication_id(), SharedData.getPrimaryMember().getApplication_id(), "Subscriber application id does not match");
            softAssert.assertTrue(policyTablesEntity.getBirth_date().contains(basicActions.changeDateFormat(member.getDob(), "MMddyyyy", "yyyy-MM-dd")), "DOB does not match");
            softAssert.assertNull(policyTablesEntity.getTobacco_use(), "Tobacco use field is obsolete in policy tables. So, it should be null always. We got a non-null value");
            softAssert.assertEquals(policyTablesEntity.getPlan_year(), SharedData.getPlanYear(), " Plan year does not match");
            softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_eph(), "0", "effectuated indicator does not match in en policy ah");
            softAssert.assertEquals(policyTablesEntity.getEffectuated_ind_epmh(), "0", "En effectuated indicator does not match in en policy member ah");

            softAssert.assertEquals(policyTablesEntity.getPolicy_status(), policyStatus, "Policy status does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_member_coverage_status(), policyMemCoverageStatus, "Medical member coverage status does not match");

            softAssert.assertEquals(policyTablesEntity.getRating_area_id(), dbData.getRatingAreaId(), "Rating area id does not match");
            softAssert.assertNull(policyTablesEntity.getCsr_level_epfh(), "epfh CSR level does not match");
            softAssert.assertEquals(policyTablesEntity.getCsr_level_emcfh(), dbData.getCsrLevel(), "emcfh CSR level does not match");
            softAssert.assertNull(policyTablesEntity.getResponsible_adult_ind(), "Responsible adult indicator is always null except when a minor only kid(s) applying");
            softAssert.assertAll();
        }

        private void validateDependentMedDetails(PolicyTablesEntity policyTablesEntity) {
            List<MemberDetails> members = basicActions.getAllDependents();
            for (MemberDetails member : members) {
                if (member.getFirstName().equals(policyTablesEntity.getFirst_name())) {
                    getDbDataMap(member.getMedSubscriberName());
                    medValidationsCommonForAllMembers(member.getMedSubscriberName(),policyTablesEntity);
                    validateMedDenForDependents(policyTablesEntity, dbDataMap.get(member.getMedSubscriberName()), member);
                    softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), member.getRelation_to_subscriber(), "Relationship to subscriber does not match");
                    softAssert.assertNull(policyTablesEntity.getTotal_plan_premium_amt(), "Medical Policy total plan premium amount for member does not match");
                    softAssert.assertNull(policyTablesEntity.getTotal_premium_reduction_amt(), "Medical APTC amount from policy table does not match");
                    softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()), SharedData.getPrimaryMember().getFinancialHelp() ? "APTC" : "null", "Member Medical Policy premium reduction type does not match");
                    softAssert.assertNull(policyTablesEntity.getPremium_reduction_type_epfh(), "premium reduction type in en policy financial ah table will be null for dependents");
                    softAssert.assertNull(policyTablesEntity.getTotal_responsible_amt(), "Medical Policy total responsible amount for member does not match");
                    softAssert.assertNull(policyTablesEntity.getTotal_csr_amt(), "Medical Policy total CSR amount does not match");
                    softAssert.assertNull(policyTablesEntity.getFinancial_period_start_date(), "Medical financial start date does not match");
                    softAssert.assertNull(policyTablesEntity.getFinancial_period_end_date(), "Medical financial end date,null does not match");
                    softAssert.assertEquals(policyTablesEntity.getDisenrollment_reason(), member.getPolicyDisenrollmentReasonMed(),"Disenrollment reason mismatch");
                    softAssert.assertAll();
                }
            }
        }

        private void validateDependentDenDetails(PolicyTablesEntity denEntity) {
            List<MemberDetails> members = basicActions.getAllDependents();
            for (MemberDetails member : members) {
                if (member.getFirstName().equals(denEntity.getFirst_name())) {
                    getDbDataMap(member.getDenSubscriberName());
                    denValidationsCommonForAllMembers(member.getDenSubscriberName(), denEntity);
                    validateMedDenForDependents(denEntity, dbDataMap.get(member.getDenSubscriberName()), member);
                    softAssert.assertEquals(denEntity.getRelation_to_subscriber(), member.getRelation_to_subscriber(), "Relationship to subscriber does not match");
                    softAssert.assertNull(denEntity.getTotal_plan_premium_amt(), "Dental Policy total plan premium amount does not match");
                    softAssert.assertNull(denEntity.getTotal_premium_reduction_amt(), "Dental APTC amount from policy table does not match");
                    softAssert.assertNull(denEntity.getPremium_reduction_type_emcfh(), "Dental premium reduction type in emcfh does not match");
                    softAssert.assertNull(denEntity.getPremium_reduction_type_epfh(), "premium reduction type in en policy financial ah table does not match");
                    softAssert.assertNull(denEntity.getTotal_responsible_amt(), "Dental Policy total responsible amount does not match");
                    softAssert.assertNull(denEntity.getTotal_csr_amt(), "Dental Policy total CSR amount does not match");
                    softAssert.assertNull(denEntity.getFinancial_period_start_date(), "Dental financial start date does not match");
                    softAssert.assertNull(denEntity.getFinancial_period_end_date(), "Dental financial end date does not match");
                    softAssert.assertEquals(denEntity.getDisenrollment_reason(), member.getPolicyDisenrollmentReasonMed(),"Disenrollment reason mismatch");
                    softAssert.assertAll();
                }
            }
        }



        private void medValidationsCommonForAllMembers(String name, PolicyTablesEntity policyTablesEntity) {
            getMedicalPlanDbDataMap(name);
            getDbDataMap(name);
            String csrLevel = SharedData.getIsAiAn() ? "03" : dbDataMap.get(name).getCsrLevel();
            softAssert.assertEquals(policyTablesEntity.getHios_plan_id(), medicalPlanDbDataMap.get(name).getBaseId() + "-" + csrLevel, "Medical Hios id does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyStartDate(), "Coverage type 1, Policy start date does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyEndDate(), "Coverage type 1, Policy end date does not match");

            softAssert.assertEquals(policyTablesEntity.getCoverage_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getCoverageStartDate(), "policy member coverage start date does not match");
            softAssert.assertEquals(policyTablesEntity.getCoverage_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getCoverageEndDate(), "policy member coverage end date does not match");

            softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialStartDate(), "Medical member financial start date does not match");
            softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialEndDate(), "Medical member financial end date does not match");
            softAssert.assertAll();
        }

        private void denValidationsCommonForAllMembers(String name, PolicyTablesEntity policyTablesEntity) {
            getDentalPlanDbDataMap(name);
            getDbDataMap(name);
            softAssert.assertEquals(policyTablesEntity.getHios_plan_id(), dentalPlanDbDataMap.get(name).getBaseId() + "-" + dbDataMap.get(name).getCsrLevel(), "Dental Hios id does not match for "+name);
            softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), SharedData.getExpectedCalculatedDates_dentalPlan().getPolicyStartDate(), "Coverage type 1, Policy start date does not match");
            softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), SharedData.getExpectedCalculatedDates_dentalPlan().getPolicyEndDate(), "Coverage type 1, Policy end date does not match");

            softAssert.assertEquals(policyTablesEntity.getCoverage_start_date(), SharedData.getExpectedCalculatedDates_dentalPlan().getCoverageStartDate(), "policy member coverage start date does not match");
            softAssert.assertEquals(policyTablesEntity.getCoverage_end_date(), SharedData.getExpectedCalculatedDates_dentalPlan().getCoverageEndDate(), "policy member coverage end date does not match");

            softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), SharedData.getExpectedCalculatedDates_dentalPlan().getFinancialStartDate(), "Medical member financial start date does not match");
            softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), SharedData.getExpectedCalculatedDates_dentalPlan().getFinancialEndDate(), "Medical member financial end date does not match");
            softAssert.assertAll();
        }
        private void setMedicalData(){
            resetValues();
            medicalPolicyEntities = exchDbDataProvider.getDataFrmPolicyTables("1");
            SharedData.setMedicalPolicyTablesEntities(medicalPolicyEntities);

            for (PolicyTablesEntity policyTablesEntity : medicalPolicyEntities) {
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
                exchDbDataProvider.setMedicalPlanDataFromDb_New(subscriber.getFirstName(),subscriber.getMedicalPlan());
            }
            setExchPersonId();
            dbDataMapList = SharedData.getDbDataNew();
            medicalPlanDbDataMapList = SharedData.getMedicalPlanDbDataNew();
            setMedicalSubscriber();
        }

        private void setDentalData(){
        resetValues();
        dentalPolicyEntities = exchDbDataProvider.getDataFrmPolicyTables("2");
            SharedData.setDentalPolicyTablesEntities(dentalPolicyEntities);

            for (PolicyTablesEntity policyTablesEntity : dentalPolicyEntities) {
                if (policyTablesEntity.getSubscriber_ind().equals("1")) {
                    for (MemberDetails member : basicActions.getAllMem()) {
                        if (policyTablesEntity.getFirst_name().equals(member.getFirstName())) {
                            member.setIsDentalSubscriber("Y");
                            break;
                        }
                    }
                }
            }

            subscribers = basicActions.getAllSubscribers();
            for (MemberDetails subscriber : subscribers) {
                exchDbDataProvider.setDataFromDb_New(subscriber.getFirstName());
                exchDbDataProvider.setDentalPlanDataFromDb_New(subscriber.getFirstName(),subscriber.getDentalPlan());
            }
            setExchPersonId();
            dbDataMapList = SharedData.getDbDataNew();
            dentalPlanDbDataMapList = SharedData.getDentalPlanDbDataNew();
            setDentalSubscriber();
        }

    private void getMedicalPlanDbDataMap(String name){
        medicalPlanDbDataMap = new HashMap<>();
        for(Map<String, PlanDbData> map: medicalPlanDbDataMapList){
            if(map.containsKey(name)){
                medicalPlanDbDataMap = map;
                break;
            }
        }
    }
    private void getDentalPlanDbDataMap(String name){
        dentalPlanDbDataMap = new HashMap<>();
        for(Map<String, PlanDbData> map: dentalPlanDbDataMapList){
            if(map.containsKey(name)){
                dentalPlanDbDataMap = map;
                break;
            }
        }
    }
    private void getDbDataMap(String name){
        dbDataMap = new HashMap<>();
        for(Map<String, DbData> map: dbDataMapList){
            if(map.containsKey(name)){
                dbDataMap = map;
                break;
            }
        }
    }
    private void setMedicalSubscriber(){
        List<MemberDetails> allMem = basicActions.getAllMem();
        for(MemberDetails member: allMem){
            for (MemberDetails subscriber: subscribers){
                if(subscriber.getMedGroupInd().equals(member.getMedGroupInd())){
                    member.setMedSubscriberName(subscriber.getFirstName());
                    break;
                }
            }

        }
    }

    private void setDentalSubscriber(){
        List<MemberDetails> allMem = basicActions.getAllMem();
        for(MemberDetails member: allMem){
            for (MemberDetails subscriber: subscribers){
                if(subscriber.getDenGroupInd().equals(member.getDenGroupInd())){
                    member.setDenSubscriberName(subscriber.getFirstName());
                    break;
                }
            }
        }
    }

       private void validateSubmittedBy(PolicyTablesEntity policyTablesEntity) {
            String submittedBy = policyTablesEntity.getPolicy_submitted_by();
            String primaryMemberEmail = SharedData.getPrimaryMember().getEmailId();

            softAssert.assertTrue(submittedBy.equals(primaryMemberEmail) || submittedBy.equals("SYSTEM"),
                    "Submitted_by does not match either " + primaryMemberEmail + " or " + "SYSTEM"
            );
        }

    private void setExchPersonId(){
        List<MemberDetails> memberDetailsList = basicActions.getAllMem();
        Map<String, String> exchPersonId = new HashMap<>();
        SharedData.setExchPersonId(exchPersonId);
        for (MemberDetails member : memberDetailsList) {
            exchDbDataProvider.setExchPersonId(member, member.getMemberId());
        }
    }
}

