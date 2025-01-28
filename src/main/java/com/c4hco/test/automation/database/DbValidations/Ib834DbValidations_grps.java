package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.Ib834Entity;
import com.c4hco.test.automation.database.EntityObj.PlanDbData;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.utils.BasicActions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.*;

import static com.c4hco.test.automation.utils.BasicActions.isSSNValid;
import static com.c4hco.test.automation.utils.EnumRelationship.getCodeForRelationship;
import static com.c4hco.test.automation.utils.Race.getCodeForRace;

public class Ib834DbValidations_grps {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();
    BasicActions basicActions = new BasicActions();
    MemberDetails primaryMember = SharedData.getPrimaryMember();
    List<Ib834Entity> ib834MedEntities = new ArrayList<>();
    List<Ib834Entity> ib834DenEntities = new ArrayList<>();
    List<MemberDetails> subscribers = new ArrayList<>();
    List<Map<String, DbData>> dbDataMapList = new ArrayList<>();
    List<Map<String, PlanDbData>> medicalPlanDbDataMapList = new ArrayList<>();
    List<Map<String, PlanDbData>> dentalPlanDbDataMapList = new ArrayList<>();
    Map<String, PlanDbData> medicalPlanDbDataMap = new HashMap<>();
    Map<String, PlanDbData> dentalPlanDbDataMap = new HashMap<>();
    Map<String, DbData> dbDataMap = new HashMap<>();
    List<PolicyTablesEntity> medicalPolicyEnitities = new ArrayList<>();
    List<PolicyTablesEntity> dentalPolicyEnitities = new ArrayList<>();

    public void ib834DbRecordsValidations(String recordType, List<Map<String, String>> expectedValues) {
        switch (recordType) {
            case "medical":
                setIb834Data();
                ib834MedRecordsValidations(expectedValues);
                break;
            case "dental":
                ib834DenRecordsValidations(expectedValues);
                break;
            default:
                Assert.fail("Record Type entered is not valid");
        }
        softAssert.assertAll();
    }

    private void ib834MedRecordsValidations(List<Map<String, String>> expectedValues){
        for (Ib834Entity ib834Entity : ib834MedEntities) {
            if (ib834Entity.getSubscriber_indicator().equals("Y")) {
                for(MemberDetails subscriber: subscribers){
                    if(subscriber.getFirstName().equals(ib834Entity.getMember_first_name())){
                        subscriberOnlyMedDenFields(ib834Entity, subscriber);
                        validateMedDenForSubscriberAndMem(ib834Entity, subscriber);
                        medValidationsCommonForAllMembers(ib834Entity, expectedValues, subscriber);
                        break;
                    }
                }
            } else {
                validateDependentMedDenDetails(ib834Entity);
                validateMedForMem(ib834Entity, expectedValues);
            }

            medDenValidationsCommonForAllMem(ib834Entity);
        }
        softAssert.assertAll();
    }

    private void validateMedForMem(Ib834Entity ib834Entity, List<Map<String, String>> expectedValues){
        List<MemberDetails> members = basicActions.getAllDependents();
        for(MemberDetails member: members){
            if(member.getFirstName().equals(ib834Entity.getMember_first_name())){
                medValidationsCommonForAllMembers(ib834Entity, expectedValues, member);
            }
        }
    }

    private void validateDenForMem(Ib834Entity ib834Entity, List<Map<String, String>> expectedValues){
        List<MemberDetails> members = basicActions.getAllDependents();
        for(MemberDetails member: members){
            if(member.getFirstName().equals(ib834Entity.getMember_first_name())){
                denValidationsCommonForAllMembers(ib834Entity, expectedValues, member);
            }
        }
    }

    private void ib834DenRecordsValidations(List<Map<String, String>> expectedValues){
        for (Ib834Entity ib834Entity : ib834DenEntities) {
            if (ib834Entity.getSubscriber_indicator().equals("Y")) {
                for(MemberDetails subscriber: subscribers){
                    if(subscriber.getFirstName().equals(ib834Entity.getMember_first_name())){
                        subscriberOnlyDenValidations(ib834Entity, subscriber);
                        validateMedDenForSubscriberAndMem(ib834Entity, subscriber);
                        denValidationsCommonForAllMembers(ib834Entity, expectedValues, subscriber);
                        break;
                    }
                }
            } else {
                validateDependentMedDenDetails(ib834Entity);
                validateDenForMem(ib834Entity,expectedValues);
            }
            medDenValidationsCommonForAllMem(ib834Entity);
        }
        softAssert.assertAll();
    }

    private void validateDependentMedDenDetails(Ib834Entity ib834Entity){
        List<MemberDetails> members = basicActions.getAllDependents();
        for(MemberDetails member: members){
            if(member.getFirstName().equals(ib834Entity.getMember_first_name())){
                System.out.println("VALIDATING FOR THE MEMBER - MEMBER's FIRST NAME::"+ib834Entity.getMember_first_name());
                validateMemberOnlyMedDenFields(ib834Entity);
                validateMedDenForSubscriberAndMem(ib834Entity, member);
            }
        }
    }


    private void validateMemberOnlyMedDenFields(Ib834Entity ib834Entity){
        softAssert.assertNull(ib834Entity.getPremium_reduction_amt(), "Member Medical Plan premium reduction amount does not match");
        softAssert.assertNull(ib834Entity.getCsr_amount(), "Member Medical CSR amount does not match");
        softAssert.assertNull(ib834Entity.getTotal_responsible_amount(), "MemberMedical Total Responsible amount does not match");
        softAssert.assertNull(ib834Entity.getTotal_premium_amount(), "Member Medical Total Premium amount does not match");
        softAssert.assertNull(ib834Entity.getPlan_sponsor_name(), "Member plan sponsor name did not match");
        softAssert.assertNull(ib834Entity.getSponsor_id(), "Member Sponsor_id did not match");
        softAssert.assertNull(ib834Entity.getMail_street_line1(), "Mailing address street line 1 does not match");
        softAssert.assertNull(ib834Entity.getMail_street_line2(), "Mailing address street line 2 is not null");
        softAssert.assertNull(ib834Entity.getMail_city(), "Mailing city does not match");
        softAssert.assertNull(ib834Entity.getMail_st(), "Mailing state does not match");
        softAssert.assertNull(ib834Entity.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertNull(ib834Entity.getMail_fip_code(), "Mailing fipcode is not null");
        softAssert.assertNull(ib834Entity.getResidence_street_line2(), "Residential address line 2 is not null");
        softAssert.assertNull(ib834Entity.getResidence_city(), "Residential address city does not match");
        softAssert.assertNull(ib834Entity.getResidence_st(), "Residential address state does not match");
        softAssert.assertNull(ib834Entity.getResidence_zip_code(), "Residential address zipcode does not match");
        softAssert.assertNull(ib834Entity.getResidence_fip_code(), "Residential address fipcode does not match");
        softAssert.assertNull(ib834Entity.getPremium_reduction_type(),"Plan premium reduction type does not match");
        softAssert.assertAll();
    }

    private void validateMedDenForSubscriberAndMem(Ib834Entity ib834Entity, MemberDetails member){
        softAssert.assertEquals(member.getPrior_subscriber_id(), ib834Entity.getPrior_subscriber_id(), "Prior subscriber id did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getIsSubscriber(), ib834Entity.getSubscriber_indicator(), "Subscriber indicator did not match for "+member.getFirstName());
        softAssert.assertEquals(SharedData.getExchPersonId().get(member.getFirstName()), ib834Entity.getMember_id(), "Member Id did not match for "+member.getFirstName());
        validateSubscriberId(ib834Entity, member);
        validatePersonalDetails(ib834Entity, member);
       // validateIncorrectEntities(ib834Entity, member);
        softAssert.assertAll();
    }

    private void validateSubscriberId(Ib834Entity ib834Entity, MemberDetails member){
        String name = getName(ib834Entity, member);
        softAssert.assertEquals(SharedData.getExchPersonId().get(name), ib834Entity.getSubscriber_id(), "subscriber id did not match "+member.getFirstName());
    }


    private void validateResidentialAddress(Ib834Entity ib834Entity, MemberDetails member) {
        String name = getName(ib834Entity, member);
        getDbDataMap(name);
        softAssert.assertEquals(member.getResAddress().getAddressLine1(), ib834Entity.getResidence_street_line1(), "Residential address line 1 does not match");
        if (member.getResAddress().getAddressLine2() != null) {
            softAssert.assertEquals(member.getResAddress().getAddressLine2(), ib834Entity.getResidence_street_line2(), "Residential line2 is null");
        } else {
            softAssert.assertNull(ib834Entity.getResidence_street_line2(), "Residential address line 2 is not null");
        }
        softAssert.assertEquals(member.getResAddress().getAddressCity(), ib834Entity.getResidence_city(), "Residential address city does not match");
        softAssert.assertEquals(member.getResAddress().getAddressState(), ib834Entity.getResidence_st(), "Residential address state does not match");
        softAssert.assertEquals(member.getResAddress().getAddressZipcode(), ib834Entity.getResidence_zip_code(), "Residential address zipcode does not match");
        softAssert.assertEquals(dbDataMap.get(name).getFipcode(), ib834Entity.getResidence_fip_code(), "Residential address fipcode does not match");
    }

    private void validateMailingAddressIsNull(Ib834Entity ib834Entity, MemberDetails subscriber){
        softAssert.assertNull(ib834Entity.getMail_street_line1(), "Mailing address street line 1 does not match");
        softAssert.assertNull(ib834Entity.getMail_street_line2(), "Mailing address street line 2 is not null");
        softAssert.assertNull(ib834Entity.getMail_city(), "Mailing city does not match");
        softAssert.assertNull(ib834Entity.getMail_st(), "Mailing state does not match");
        softAssert.assertNull(ib834Entity.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertNull(ib834Entity.getMail_fip_code(), "Mailing fipcode is not null");
        softAssert.assertAll("Mailing Address did not match for "+subscriber.getFirstName());
    }

    private void validateMailingAddress(Ib834Entity ib834Entity, MemberDetails subscriber) {
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressLine1(), ib834Entity.getMail_street_line1(), "Mailing address street line 1 does not match");
        if (subscriber.getMailingAddress().getAddressLine2() != null) {
            softAssert.assertEquals(subscriber.getMailingAddress().getAddressLine2(), ib834Entity.getMail_street_line2(), "Mailing address street line 2 does not match");
        } else {
            softAssert.assertNull(ib834Entity.getMail_street_line2(), "Mailing address street line 2 is not null");
        }
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressCity(), ib834Entity.getMail_city(), "Mailing city does not match");
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressState(), ib834Entity.getMail_st(), "Mailing state does not match");
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressZipcode(), ib834Entity.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertNull(ib834Entity.getMail_fip_code(), "Mailing fipcode is not null");
       // softAssert.assertAll("Mailing Address did not match for "+subscriber.getFirstName());
    }

//    private void validateIncorrectEntities(Ib834Entity ib834Entity, MemberDetails member) {
//        softAssert.assertEquals(ib834Entity.getIncorrect_entity_id_code(), member.getIncorrectEntityIdCode(), "Incorrect_entity_id_code did not match!");
//        softAssert.assertEquals(ib834Entity.getIncorrect_id_code(), member.getIncorrectIdCode(), "Incorrect_id_code did not match!");
//        softAssert.assertEquals(ib834Entity.getIncorrect_entity_type_qualifier(), member.getIncorrectEntityTypeQualifier(), "Incorrect_entity_type_qualifier did not match!");
//        softAssert.assertEquals(ib834Entity.getIncorrect_first_name(), member.getIncorrect_first_name(), "Incorrect_first_name did not match!");
//        softAssert.assertEquals(ib834Entity.getIncorrect_last_name(), member.getIncorrect_last_name(), "Incorrect_last_name did not match!");
//        // WIP - POL-9151 - softAssert.assertEquals(ob834Entity.getIncorrect_id_code_qualifier(), member.getIncorrectIdCodeQualifier(), "Incorrect_id_code_qualifier did not match!");
//        softAssert.assertEquals(ib834Entity.getIncorrect_dob(), member.getIncorrect_dob(), "Incorrect_dob did not match!");
//        softAssert.assertEquals(ib834Entity.getIncorrect_gender(), member.getIncorrect_gender(), "Incorrect_gender did not match!");
//        softAssert.assertEquals(ib834Entity.getIncorrect_marital_status_code(), member.getIncorrect_marital_status_code(), "Incorrect_marital_status_code did not match!");
//        softAssert.assertEquals(ib834Entity.getIncorrect_race(), member.getIncorrect_race(), "Incorrect_race did not match!");
//        softAssert.assertEquals(ib834Entity.getIncorrect_middle_name(), member.getIncorrect_middle_name()!=null && !member.getIncorrect_middle_name().isEmpty()? member.getIncorrect_middle_name(): null, "Incorrect_middle_name did not match!");
//        softAssert.assertAll();
//    }

    private void validateBrokerDetails(Ib834Entity ib834Entity) {
        BrokerDetails broker = SharedData.getBroker();
        getDbDataMap(primaryMember.getFirstName());
        if (SharedData.getHasBroker()) {
            softAssert.assertEquals(broker.getBroker_name(), ib834Entity.getTpa_or_broker_name(), "Broker name is incorrect");
            softAssert.assertEquals(ib834Entity.getTpa_or_broker_id(), dbDataMap.get(primaryMember.getFirstName()).getBrokerTinNum(), "Broker Tin Number is incorrect");
            softAssert.assertEquals(ib834Entity.getTpa_or_broker_lic_num(), broker.getBroker_lic_num(), "Broker license number is incorrect");
        } else {
            softAssert.assertNull(ib834Entity.getTpa_or_broker_name(), "Broker name is incorrect");
            softAssert.assertNull(ib834Entity.getTpa_or_broker_id(), "Broker Tin Number is incorrect");
            softAssert.assertNull(ib834Entity.getTpa_or_broker_lic_num(), "Broker license number is incorrect");
        }
    }

    private void validateResponsiblePersonDetails(Ib834Entity ib834Entity, MemberDetails member) {
        if (!member.getIsMinor()) {
            validateResPersonDetailsForMember(ib834Entity);
        } else {
            if(ib834Entity.getSubscriber_indicator().equals("Y")){
                validateResPerDetailsForMinorSubscriber();
            } else {
                validateResPerDetailsForMinorMem();
            }
        }
    }

    private void validateResPerDetailsForMinorSubscriber(){

    }

    private void validateResPerDetailsForMinorMem(){
        Assert.fail("WRITE CODE TO HANDLE VALIDATIONS");
    }

    private void validateResPersonDetailsForMember(Ib834Entity ib834Entity){
        softAssert.assertEquals(ib834Entity.getResponsible_person_first_name(), null);
        softAssert.assertEquals(ib834Entity.getResponsible_person_last_name(), null);
        softAssert.assertEquals(ib834Entity.getResponsible_person_rel_code(), null);
        softAssert.assertEquals(ib834Entity.getResponsible_person_ssn(), null);
        softAssert.assertEquals(ib834Entity.getResponsible_person_phone(), null);
        softAssert.assertEquals(ib834Entity.getResponsible_person_email(), null);
        softAssert.assertEquals(ib834Entity.getResponsible_person_alt_phone(), null);
        softAssert.assertEquals(ib834Entity.getResponsible_person_street_line1(), null);
        softAssert.assertEquals(ib834Entity.getResidence_street_line2(), null);
        softAssert.assertEquals(ib834Entity.getResponsible_person_city(), null);
        softAssert.assertEquals(ib834Entity.getResponsible_person_st(), null);
        softAssert.assertEquals(ib834Entity.getResponsible_person_zip_code(), null);
    }

    private void validatePersonalDetails(Ib834Entity ib834Entity, MemberDetails member) {
        String dateFormatted = member.getDob().substring(4, 8) + member.getDob().substring(0, 2) + member.getDob().substring(2, 4);
        softAssert.assertEquals(member.getFirstName(), ib834Entity.getMember_first_name(), "member firstname did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getLastName(), ib834Entity.getMember_last_name(), "member firstname did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getMiddleName(), ib834Entity.getMember_middle_name(), "member middle did not match for "+member.getFirstName());
        softAssert.assertEquals(dateFormatted, ib834Entity.getMember_dob(), "dob did not match for "+member.getFirstName());
        softAssert.assertEquals(ib834Entity.getMember_gender(), member.getGender().substring(0, 1), "gender did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getTobacco_user().equals("Yes") ? "T" : member.getTobacco_user().substring(0, 1), ib834Entity.getTobacco_use(), "Tobacco usage did not match for "+member.getFirstName());
        softAssert.assertEquals(ib834Entity.getMarital_status_code(), "I", "Marital Status did not match for "+member.getFirstName());
        softAssert.assertEquals(getCodeForRelationship(member.getRelation_to_subscriber()), ib834Entity.getIndividual_rel_code(), "RelationshipCode did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getSsn()!=null? member.getSsn(): "000000000", ib834Entity.getMember_ssn(), "ssn did not match for "+member.getFirstName());
        softAssert.assertEquals(getCodeForRace(member.getRace()), ib834Entity.getMember_race(), "Race did not match");
        softAssert.assertAll("Personal Details for Member::"+member.getFirstName()+" did not match");
    }

    private void validateSponsorId(Ib834Entity ib834Entity, MemberDetails subscriber) {
        boolean validSSN = isSSNValid(SharedData.getPrimaryMember().getSsn());
        if (validSSN) {
            softAssert.assertEquals(subscriber.getSsn(), ib834Entity.getSponsor_id(), "Sponsor_id did not match");
        }
    }

    private void validateConstantFields(Ib834Entity ib834Entity) {
        String date = LocalDate.now().toString();

        String appType = SharedData.getAppType();
        if (appType.equals("exchange")) {
            softAssert.assertEquals(ib834Entity.getInterchange_sender_id(), "CNCT4HLTHCO");
        } else if (appType.equals("coco")) {
            softAssert.assertEquals(ib834Entity.getInterchange_sender_id(), "COLOCONNECT");
        }
     //   softAssert.assertEquals(ib834Entity.getApplication_date(), date.replace("-", ""), "Application date does not match in ob834 entity");
        softAssert.assertEquals(ib834Entity.getUpdated_by(), "JAVA_OB834", "Ob834 updated_by does not match");
        softAssert.assertEquals(ib834Entity.getAck_requested(), "0", "Ob834 Ack_requested does not match");
        softAssert.assertEquals(ib834Entity.getUsage_indicator(), "T", "Ob834 Usage_indicator does not match");
        softAssert.assertEquals(ib834Entity.getInterchange_date(), date.replace("-", ""), "Interchange_date does not match in with date ob834 entity");
      //  softAssert.assertEquals(ib834Entity.getDate_created().substring(0, 10), date, "Date_created does not match with date in ob834 entity");
       // softAssert.assertEquals(ib834Entity.getDate_updated().substring(0, 10), date, "Date_updated does not match with date in ob834 entity");
    }

    private void medValidationsCommonForAllMembers(Ib834Entity ib834Entity, List<Map<String, String>> expectedValues, MemberDetails member) {
        List<MemberDetails> allMembers = basicActions.getAllMem();
                String name = getName(ib834Entity, member);
                getMedicalPlanDbDataMap(name);
                String formatPlanStartDate = SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyStartDate().replaceAll("-", "");
                String formatMedicalPlanEndDate = SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyEndDate().replaceAll("-", "");
                String formatedFinStartDate = SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialStartDate().replaceAll("-", "");

                softAssert.assertEquals(ib834Entity.getHios_plan_id(), medicalPlanDbDataMap.get(name).getBaseId(), "Medical Hios id did not match!");
                softAssert.assertEquals(ib834Entity.getInsurer_name(), medicalPlanDbDataMap.get(name).getIssuerName(), "Medical Insurer Name did not match!");
                softAssert.assertEquals(ib834Entity.getInsurer_id(), medicalPlanDbDataMap.get(name).getIssuerId(), "Medical Insurer Id did not match!");

                softAssert.assertEquals(ib834Entity.getBenefit_begin_date(), formatPlanStartDate, "Medical plan start date is not correct");
                softAssert.assertEquals(ib834Entity.getBenefit_end_date(), formatMedicalPlanEndDate, "Medical plan end date is not correct");
                softAssert.assertEquals(ib834Entity.getFinancial_effective_date(), formatedFinStartDate, "Financial start date is not correct");

                validateDetailsFromStep(ib834Entity, expectedValues.get(0));
                validateIndivMedPremAmt(ib834Entity);
                setGrpCtrlNums(ib834Entity.getGroup_ctrl_number());
    }

    private void setGrpCtrlNums(String grpCtrlNum){
        List<String> medGrpCtrlNums = SharedData.getMedGroupCtlNumbers();
        if(medGrpCtrlNums==null){
            medGrpCtrlNums = new ArrayList<>();
        }
        medGrpCtrlNums.add(grpCtrlNum);
        SharedData.setMedGroupCtlNumbers(medGrpCtrlNums);
    }

    private void denValidationsCommonForAllMembers(Ib834Entity ib834Entity, List<Map<String, String>> expectedValues, MemberDetails member) {
        String name = getName(ib834Entity, member);
        getDentalPlanDbDataMap(name);
        String formatPlanStartDate = SharedData.getExpectedCalculatedDates_dentalPlan().getPolicyStartDate().replaceAll("-", "");
        String formatMedicalPlanEndDate = SharedData.getExpectedCalculatedDates_dentalPlan().getPolicyEndDate().replaceAll("-", "");
        String formatedFinStartDate = SharedData.getExpectedCalculatedDates_dentalPlan().getFinancialStartDate().replaceAll("-", "");

        SharedData.setDenGroupCtlNumber(ib834Entity.getGroup_ctrl_number());
        softAssert.assertEquals(ib834Entity.getHios_plan_id(), dentalPlanDbDataMap.get(name).getBaseId(), "Dental Hios id did not match!");
        softAssert.assertEquals(ib834Entity.getInsurer_name(), dentalPlanDbDataMap.get(name).getIssuerName(), "Dental Insurer Name did not match!");
        softAssert.assertEquals(ib834Entity.getInsurer_id(), dentalPlanDbDataMap.get(name).getIssuerId(), "Dental Insurer Id did not match!");

        softAssert.assertEquals(ib834Entity.getBenefit_begin_date(), formatPlanStartDate, "Medical plan start date is not correct");
        softAssert.assertEquals(ib834Entity.getBenefit_end_date(), formatMedicalPlanEndDate, "Medical plan end date is not correct");
        softAssert.assertEquals(ib834Entity.getFinancial_effective_date(), formatedFinStartDate, "Financial start date is not correct");

        validateDetailsFromStep(ib834Entity, expectedValues.get(0));
        validateIndivDenPremAmt(ib834Entity);
    }

    private void medDenValidationsCommonForAllMem(Ib834Entity ib834Entity, MemberDetails member){
                String name = getName(ib834Entity, member);
                validateConstantFields(ib834Entity);
                validateBrokerDetails(ib834Entity);
                validateResponsiblePersonDetails(ib834Entity, member);
                getDbDataMap(name);
                String enrollees = getTotalEnrollees(ib834Entity);
                softAssert.assertEquals(primaryMember.getEmailId(), ib834Entity.getPrimary_email(), "primary email did not match");
                softAssert.assertEquals(primaryMember.getPhoneNumber(), ib834Entity.getPrimary_phone(), "primary phone did not match");
                softAssert.assertEquals(primaryMember.getSpokenLanguage(), ib834Entity.getSpoken_language(), "spoken language did not match");
                softAssert.assertEquals(primaryMember.getWrittenLanguage(), ib834Entity.getWritten_language(), "written language did not match");
                //  softAssert.assertEquals(ib834Entity.getPlan_year(), SharedData.getPlanYear(), "Plan Year is not correct");
                softAssert.assertEquals("1", ib834Entity.getTotal_subscribers(), "total subscribers did not match");
                //  softAssert.assertEquals(SharedData.getPlanYear(), ib834Entity.getPlan_year(), "plan year did not match");
                softAssert.assertTrue(dbDataMap.get(name).getRatingAreaName().contains(ib834Entity.getRate_area()));
                softAssert.assertEquals(ib834Entity.getCsr_level(), dbDataMap.get(name).getCsrLevel(), "CSR level does not match");

                softAssert.assertEquals(enrollees, ib834Entity.getTotal_enrollees().trim(), "Total enrollees does not match");
                softAssert.assertEquals(String.valueOf(Integer.parseInt(enrollees) - 1), ib834Entity.getTotal_dependents().toString().trim(), "total dependents did not match");
                //   softAssert.assertEquals(getGrpNum(ib834Entity), ib834Entity.getMember_group(), "member group did not match");
    }

    private String getGrpNum(Ib834Entity ib834Entity){
        return ib834Entity.getInsurance_line_code().equals("HLT")? getMemberMedGrp(ib834Entity.getMember_first_name()): getMemberDenGrp(ib834Entity.getMember_first_name());
    }

    private String getMemberMedGrp(String firstName){
        List<MemberDetails> allMedEligMem =  basicActions.getAllMedicalEligibleMemInfo();
        String medGrpInd = "";
        for(MemberDetails member:allMedEligMem){
            if(member.getFirstName().equals(firstName)){
                medGrpInd = member.getMedGroupInd();
                break;
            }
        }
        return medGrpInd;
    }

    private String getMemberDenGrp(String firstName){
        List<MemberDetails> allMedEligMem =  basicActions.getAllDentalEligibleMemInfo();
        String denGrpInd = "";
        for(MemberDetails member:allMedEligMem){
            if(member.getFirstName().equals(firstName)){
                denGrpInd = member.getDenGroupInd();
                break;
            }
        }
        return denGrpInd;
    }

    private String getTotalEnrollees(Ib834Entity ib834Entity){
        return ib834Entity.getInsurance_line_code().equals("HLT")? getTotalMedEnrollees(ib834Entity.getMember_first_name()) : getTotalDentalEnrollees(ib834Entity.getMember_first_name());
    }

    private String getTotalMedEnrollees(String firstName){
        List<MemberDetails> allMembers = basicActions.getAllMedicalEligibleMemInfo();
        String totalMemInGrp = "";
        for(MemberDetails member: allMembers){
            if(member.getFirstName().equals(firstName)){
                totalMemInGrp = basicActions.getTotalMemInMedGrp(member.getMedGroupInd());
                break;
            }
        }
        return totalMemInGrp;
    }

    private String getTotalDentalEnrollees(String firstName){
        List<MemberDetails> allMembers = basicActions.getAllDentalEligibleMemInfo();
        String totalMemInGrp = "";
        for(MemberDetails member: allMembers){
            if(member.getFirstName().equals(firstName)){
                totalMemInGrp = basicActions.getTotalMemInDenGrp(member.getDenGroupInd());
                break;
            }
        }
        return totalMemInGrp;
    }

    private void subscriberOnlyMedValidations(Ib834Entity ib834Entity, MemberDetails subscriber) {
        // Subscriber Only Fields
        getMedicalPlanDbDataMap(getName(ib834Entity, subscriber));
        double amt = Double.parseDouble(subscriber.getMedicalAptcAmt());
        String expectedPMMedicalAptcAmt = String.format("%.2f", amt);
//        softAssert.assertEquals(expectedPMMedicalAptcAmt, ib834Entity.getPremium_reduction_amt(), "Medical Plan premium reduction amount does not match");
//        softAssert.assertEquals(medicalPlanDbDataMap.get(subscriber.getFirstName()).getCsrAmt() != null ? medicalPlanDbDataMap.get(subscriber.getFirstName()).getCsrAmt() : "0.00", ib834Entity.getCsr_amount(), "Medical CSR amount does not match");
//        softAssert.assertEquals(subscriber.getTotalMedAmtAfterReduction().replace("$", "").replace(",", ""), ib834Entity.getTotal_responsible_amount(), "Medical Total Responsible amount does not match");
//        softAssert.assertEquals(subscriber.getMedicalPremiumAmt().replace("$", "").replace(",", ""), ib834Entity.getTotal_premium_amount(), "Medical Total Premium amount does not match");
        subscriberOnlyMedDenFields(ib834Entity, subscriber);
        setMedicalFileName(ib834Entity);
    }

    private void setMedicalFileName(Ib834Entity ib834Entity){
        List<String> medFileNames = SharedData.getMedicalIb834FileNames();
        if(medFileNames==null){
            medFileNames = new ArrayList<>();
        }
        medFileNames.add(ib834Entity.getFilename());

        Set<String> set = new LinkedHashSet<>(medFileNames);
        medFileNames = new ArrayList<>(set);
        SharedData.setMedicalIb834FileNames(medFileNames);
    }

    private void setDentalFileName(Ib834Entity ib834Entity){
        List<String> denFileNames = SharedData.getDentalIb834FileNames();
        if(denFileNames==null){
            denFileNames = new ArrayList<>();
        }
        denFileNames.add(ib834Entity.getFilename());

        Set<String> set = new LinkedHashSet<>(denFileNames);
        denFileNames = new ArrayList<>(set);
        SharedData.setDentalIb834FileNames(denFileNames);
    }

    private void subscriberOnlyDenValidations(Ib834Entity ib834Entity, MemberDetails subscriber) {
        // Subscriber Only Fields
        softAssert.assertEquals("0.00", ib834Entity.getPremium_reduction_amt(), "Dental Plan premium reduction amount does not match");
        softAssert.assertEquals("0.00", ib834Entity.getCsr_amount(), "Medical CSR amount does not match");
        softAssert.assertEquals(subscriber.getTotalDentalPremAfterReduction().replace("$", "").replace(",",""), ib834Entity.getTotal_responsible_amount(), "Dental Total Responsible amount does not match");
        softAssert.assertEquals(subscriber.getDentalPremiumAmt().replace("$", "").replace(",", ""), ib834Entity.getTotal_premium_amount(), "Medical Total Premium amount does not match");
        subscriberOnlyMedDenFields(ib834Entity, subscriber);
        setDentalFileName(ib834Entity);
    }

    private void subscriberOnlyMedDenFields(Ib834Entity ib834Entity, MemberDetails subscriber){
        //  Bug - POL-9149 - Plan Sponsor Name should be primary member name - it is not updated with name change - Need to revert the code after the bug is fixed.
        softAssert.assertEquals( ib834Entity.getPlan_sponsor_name(), subscriber.getSignature(), "plan sponsor name did not match");
        softAssert.assertEquals(primaryMember.getAlternatePhNum() != null ? primaryMember.getAlternatePhNum() : primaryMember.getPhoneNumber(), ib834Entity.getAlternate_phone(), "alternate phone did not match");
        softAssert.assertEquals(ib834Entity.getSubscriber_id(), ib834Entity.getMember_id(), "Subscriber_id and Member_id in ob834 entity does not match");
        softAssert.assertEquals(ib834Entity.getPremium_reduction_type(), "APTC", "Plan premium reduction type does not match");
        validateSponsorId(ib834Entity, subscriber);
        validateResidentialAddress(ib834Entity, subscriber);
        if(subscriber.getMailingAddress()!=null&&!subscriber.getMailingAddress().equals(subscriber.getResAddress())){
            validateMailingAddress(ib834Entity, subscriber);
        } else {
            validateMailingAddressIsNull(ib834Entity, subscriber);
        }
    }

    private void validateIndivMedPremAmt(Ib834Entity ib834Entity){
        medicalPolicyEnitities.stream().filter(medEntity -> medEntity.getFirst_name().equals(ib834Entity.getMember_first_name())).findFirst().ifPresent(medEntity ->
                softAssert.assertEquals(medEntity.getPlan_premium_amt(), ib834Entity.getPremium_amount(), "Medical Individual Plan premium amount does not match for "+medEntity.getFirst_name()));
        softAssert.assertAll();
    }

    private void validateIndivDenPremAmt(Ib834Entity ib834Entity){
        dentalPolicyEnitities.stream().filter(denEntity -> denEntity.getFirst_name().equals(ib834Entity.getMember_first_name())).findFirst().ifPresent(denEntity ->
                softAssert.assertEquals(denEntity.getPlan_premium_amt(), ib834Entity.getPremium_amount(), "Dental Individual Plan premium amount does not match for "+denEntity.getFirst_name()));
    }

    private void validateDetailsFromStep(Ib834Entity ib834Entity, Map<String, String> expectedValues) {
        softAssert.assertEquals(ib834Entity.getMaintenance_type_code(), expectedValues.get("maintenance_type_code"), "maintenance_type_code mismatched");
        softAssert.assertEquals(ib834Entity.getHd_maint_type_code(), expectedValues.get("hd_maint_type_code"), "hd_maint_type_code mismatched");
        softAssert.assertEquals(ib834Entity.getMaintenance_reas_code(), expectedValues.get("maintenance_reas_code"), "maintenance_reas_code mismatched");
        softAssert.assertEquals(ib834Entity.getAddl_maint_reason(), expectedValues.get("addl_maint_reason")!=null? expectedValues.get("addl_maint_reason").replace(" or ", "|") : expectedValues.get("addl_maint_reason"), "addl_maint_reason mismatched");
      //  softAssert.assertTrue(expectedValues.get("sep_reason") == null ? ib834Entity.getSep_reason().isEmpty() : ib834Entity.getSep_reason().equals(expectedValues.get("sep_reason")), "Sep_reason mismatch or expected blank but was: " + ob834Entity.getSep_reason());
    }

    private void setIb834Data() {
        subscribers = basicActions.getAllSubscribers();

        List<String> medGrpCtrlNums = SharedData.getMedGroupCtlNumbers();
        for(String medGrpCtrlNum: medGrpCtrlNums){
            ib834MedEntities.addAll(exchDbDataProvider.getIb834Details(medGrpCtrlNum));
        }
        SharedData.setIb834MedDetailsEntities(ib834MedEntities);

        List<String> denGrpCtrlNums = SharedData.getDenGroupCtlNumbers();
        for(String denGrpCtrlNum: denGrpCtrlNums){
            ib834DenEntities.addAll(exchDbDataProvider.getIb834Details(denGrpCtrlNum));
        }
        SharedData.setIb834DenDetailsEntities(ib834DenEntities);

        dbDataMapList = SharedData.getDbDataNew();
        medicalPlanDbDataMapList = SharedData.getMedicalPlanDbDataNew();
        dentalPlanDbDataMapList = SharedData.getDentalPlanDbDataNew();

        SharedData.setMedicalIb834FileName(ib834MedEntities.get(0).getFilename());
        SharedData.setDentalIb834FileName(ib834DenEntities.get(0).getFilename());

        medicalPolicyEnitities = SharedData.getMedicalPolicyTablesEntities();
        dentalPolicyEnitities = SharedData.getDentalPolicyTablesEntities();
    }

    private void getMedicalPlanDbDataMap(String name){
        for(Map<String, PlanDbData> map: medicalPlanDbDataMapList){
            if(map.containsKey(name)){
                medicalPlanDbDataMap = map;
                break;
            }
        }
    }
    private void getDentalPlanDbDataMap(String name){
        for(Map<String, PlanDbData> map: dentalPlanDbDataMapList){
            if(map.containsKey(name)){
                dentalPlanDbDataMap = map;
                break;
            }
        }
    }
    private void getDbDataMap(String name){
        for(Map<String, DbData> map: dbDataMapList){
            if(map.containsKey(name)){
                dbDataMap = map;
                break;
            }
        }
    }

    private String getName(Ib834Entity ib834Entity, MemberDetails member){
        String name = "";
        if(member.getIsSubscriber().equals("Y")){
            name = member.getFirstName();
        } else if(ib834Entity.getInsurance_line_code().equals("HLT")){
            name = member.getMedSubscriberName();
        } else {
            name = member.getDenSubscriberName();
        }
        return name;
    }
}
