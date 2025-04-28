package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
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

public class Ob834PreEdiDbValidations {

    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();
    BasicActions basicActions = new BasicActions();
    MemberDetails primaryMember = SharedData.getPrimaryMember();
    List<Ob834DetailsEntity> ob834DetailsMedEntities = new ArrayList<>();
    List<Ob834DetailsEntity> ob834DetailsDenEntities = new ArrayList<>();
    List<MemberDetails> subscribers = new ArrayList<>();
    Set<Map<String, DbData>> dbDataMapList = new HashSet<>();
    List<Map<String, PlanDbData>> medicalPlanDbDataMapList = new ArrayList<>();
    List<Map<String, PlanDbData>> dentalPlanDbDataMapList = new ArrayList<>();
    Map<String, PlanDbData> medicalPlanDbDataMap = new HashMap<>();
    Map<String, PlanDbData> dentalPlanDbDataMap = new HashMap<>();
    Map<String, DbData> dbDataMap = new HashMap<>();
    List<PolicyTablesEntity> medicalPolicyEnitities = new ArrayList<>();
    List<PolicyTablesEntity> dentalPolicyEnitities = new ArrayList<>();

    public void groupRecordsValidations(String recordType, List<Map<String, String>> expectedValues) {
        SharedData.setRecType(recordType);
        switch (recordType) {
            case "medical":
                setMedicalData();
                ob834MedRecordsValidations(expectedValues);
                break;
            case "dental":
                setDentalData();
                ob834DenRecordsValidations(expectedValues);
                break;
            default:
                Assert.fail("Record Type entered is not valid");
        }
        softAssert.assertAll();
    }

    private void ob834MedRecordsValidations(List<Map<String, String>> expectedValues) {
        subscribers = basicActions.getAllSubscribers();
        for (Ob834DetailsEntity ob834DetailsEntity : ob834DetailsMedEntities) {
            if (ob834DetailsEntity.getSubscriber_indicator().equals("Y")) {
                for (MemberDetails subscriber : subscribers) {
                    if (subscriber.getFirstName().equals(ob834DetailsEntity.getMember_first_name())) {
                        subscriberOnlyMedValidations(ob834DetailsEntity, subscriber);
                        validateMedDenForSubscriberAndMem(ob834DetailsEntity, subscriber);
                        medDenValidationsCommonForAllMem(ob834DetailsEntity, subscriber);
                        medValidationsCommonForAllMembers(ob834DetailsEntity, expectedValues, subscriber);
                        break;
                    }
                }
            } else {
                validateDependentMedDenDetails(ob834DetailsEntity);
                validateMedForMem(ob834DetailsEntity, expectedValues);
            }
        }
        softAssert.assertAll();
    }

    private void validateMedForMem(Ob834DetailsEntity ob834Entity, List<Map<String, String>> expectedValues) {
        List<MemberDetails> members = basicActions.getAllDependents();
        for (MemberDetails member : members) {
            if (member.getFirstName().equals(ob834Entity.getMember_first_name())) {
                medValidationsCommonForAllMembers(ob834Entity, expectedValues, member);
            }
        }
    }

    private void validateDenForMem(Ob834DetailsEntity ob834Entity, List<Map<String, String>> expectedValues) {
        List<MemberDetails> members = basicActions.getAllDependents();
        for (MemberDetails member : members) {
            if (member.getFirstName().equals(ob834Entity.getMember_first_name())) {
                denValidationsCommonForAllMembers(ob834Entity, expectedValues, member);
            }
        }
    }

    private void ob834DenRecordsValidations(List<Map<String, String>> expectedValues) {
        for (Ob834DetailsEntity ob834DetailsEntity : ob834DetailsDenEntities) {
            if (ob834DetailsEntity.getSubscriber_indicator().equals("Y")) {
                for (MemberDetails subscriber : subscribers) {
                    if (subscriber.getFirstName().equals(ob834DetailsEntity.getMember_first_name())) {
                        subscriberOnlyDenValidations(ob834DetailsEntity, subscriber);
                        validateMedDenForSubscriberAndMem(ob834DetailsEntity, subscriber);
                        medDenValidationsCommonForAllMem(ob834DetailsEntity, subscriber);
                        denValidationsCommonForAllMembers(ob834DetailsEntity, expectedValues, subscriber);
                        break;
                    }
                }
            } else {
                validateDependentMedDenDetails(ob834DetailsEntity);
                validateDenForMem(ob834DetailsEntity, expectedValues);
            }
        }
        softAssert.assertAll();
    }

    private void validateDependentMedDenDetails(Ob834DetailsEntity ob834Entity) {
        List<MemberDetails> members = basicActions.getAllDependents();
        for (MemberDetails member : members) {
            if (member.getFirstName().equals(ob834Entity.getMember_first_name())) {
                System.out.println("VALIDATING FOR THE MEMBER - MEMBER's FIRST NAME::" + ob834Entity.getMember_first_name());
                validateMemberOnlyMedDenFields(ob834Entity);
                validateMedDenForSubscriberAndMem(ob834Entity, member);
                medDenValidationsCommonForAllMem(ob834Entity, member);
            }
        }
    }


    private void validateMemberOnlyMedDenFields(Ob834DetailsEntity ob834Entity) {
        softAssert.assertNull(ob834Entity.getPremium_reduction_amt(), "Member Medical Plan premium reduction amount does not match");
        softAssert.assertNull(ob834Entity.getCsr_amount(), "Member Medical CSR amount does not match");
        softAssert.assertNull(ob834Entity.getTotal_responsible_amount(), "MemberMedical Total Responsible amount does not match");
        softAssert.assertNull(ob834Entity.getTotal_premium_amount(), "Member Medical Total Premium amount does not match");
        softAssert.assertNull(ob834Entity.getPlan_sponsor_name(), "Member plan sponsor name did not match");
        softAssert.assertNull(ob834Entity.getSponsor_id(), "Member Sponsor_id did not match");
        softAssert.assertNull(ob834Entity.getMail_street_line1(), "Mailing address street line 1 does not match");
        softAssert.assertNull(ob834Entity.getMail_street_line2(), "Mailing address street line 2 is not null");
        softAssert.assertNull(ob834Entity.getMail_city(), "Mailing city does not match");
        softAssert.assertNull(ob834Entity.getMail_st(), "Mailing state does not match");
        softAssert.assertNull(ob834Entity.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertNull(ob834Entity.getMail_fip_code(), "Mailing fipcode is not null");
        softAssert.assertNull(ob834Entity.getResidence_street_line2(), "Residential address line 2 is not null");
        softAssert.assertNull(ob834Entity.getResidence_city(), "Residential address city does not match");
        softAssert.assertNull(ob834Entity.getResidence_st(), "Residential address state does not match");
        softAssert.assertNull(ob834Entity.getResidence_zip_code(), "Residential address zipcode does not match");
        softAssert.assertNull(ob834Entity.getResidence_fip_code(), "Residential address fipcode does not match");
        softAssert.assertNull(ob834Entity.getPremium_reduction_type(), "Plan premium reduction type does not match");
        softAssert.assertAll();
    }

    private void validateMedDenForSubscriberAndMem(Ob834DetailsEntity ob834Entity, MemberDetails member) {
        softAssert.assertEquals(member.getPrior_subscriber_id(), ob834Entity.getPrior_subscriber_id(), "Prior subscriber id did not match for " + member.getFirstName());
        softAssert.assertEquals(member.getIsSubscriber(), ob834Entity.getSubscriber_indicator(), "Subscriber indicator did not match for " + member.getFirstName());
        softAssert.assertEquals(SharedData.getExchPersonId().get(member.getFirstName()), ob834Entity.getMember_id(), "Member Id did not match for " + member.getFirstName());
        validateSubscriberId(ob834Entity, member);
        validatePersonalDetails(ob834Entity, member);
        validateIncorrectEntities(ob834Entity, member);
        softAssert.assertAll();
    }

    private void validateSubscriberId(Ob834DetailsEntity ob834Entity, MemberDetails member) {
        String name = getName(ob834Entity, member);
        softAssert.assertEquals(SharedData.getExchPersonId().get(name), ob834Entity.getSubscriber_id(), "subscriber id did not match " + member.getFirstName());
    }


    private void validateResidentialAddress(Ob834DetailsEntity ob834Entity, MemberDetails member) {
        if(member.getIsProfileChange()&&member.getIsResAddChange()){
            dbDataMapList = new HashSet<>();
            SharedData.setDbDataNew(dbDataMapList);
            exchDbDataProvider.setDataFromDb_New(member.getFirstName());
            dbDataMapList = SharedData.getDbDataNew();
            String name = getName(ob834Entity, member);
            getDbDataMap(name);
            softAssert.assertEquals(member.getOldResAddress().getAddressLine1(), ob834Entity.getResidence_street_line1(), "Residential address line 1 does not match");
            if (member.getOldResAddress().getAddressLine2() != null) {
                softAssert.assertEquals(member.getOldResAddress().getAddressLine2(), ob834Entity.getResidence_street_line2(), "Residential line2 is null");
            } else {
                softAssert.assertNull(ob834Entity.getResidence_street_line2(), "Residential address line 2 is not null");
            }
            softAssert.assertEquals(member.getOldResAddress().getAddressCity(), ob834Entity.getResidence_city(), "Residential address city does not match");
            softAssert.assertEquals(member.getOldResAddress().getAddressState(), ob834Entity.getResidence_st(), "Residential address state does not match");
            softAssert.assertEquals(member.getOldResAddress().getAddressZipcode(), ob834Entity.getResidence_zip_code(), "Residential address zipcode does not match");
            softAssert.assertEquals(dbDataMap.get(name).getFipcode(), ob834Entity.getResidence_fip_code(), "Residential address fipcode does not match");
        } else {

            String name = getName(ob834Entity, member);
            getDbDataMap(name);
            softAssert.assertEquals(member.getResAddress().getAddressLine1(), ob834Entity.getResidence_street_line1(), "Residential address line 1 does not match");
            if (member.getResAddress().getAddressLine2() != null) {
                softAssert.assertEquals(member.getResAddress().getAddressLine2(), ob834Entity.getResidence_street_line2(), "Residential line2 is null");
            } else {
                softAssert.assertNull(ob834Entity.getResidence_street_line2(), "Residential address line 2 is not null");
            }
            softAssert.assertEquals(member.getResAddress().getAddressCity(), ob834Entity.getResidence_city(), "Residential address city does not match");
            softAssert.assertEquals(member.getResAddress().getAddressState(), ob834Entity.getResidence_st(), "Residential address state does not match");
            softAssert.assertEquals(member.getResAddress().getAddressZipcode(), ob834Entity.getResidence_zip_code(), "Residential address zipcode does not match");
            softAssert.assertEquals(dbDataMap.get(name).getFipcode(), ob834Entity.getResidence_fip_code(), "Residential address fipcode does not match");
        }
        softAssert.assertAll();
    }

    private void validateMailingAddressIsNull(Ob834DetailsEntity ob834Entity, MemberDetails subscriber) {
        softAssert.assertNull(ob834Entity.getMail_street_line1(), "Mailing address street line 1 does not match");
        softAssert.assertNull(ob834Entity.getMail_street_line2(), "Mailing address street line 2 is not null");
        softAssert.assertNull(ob834Entity.getMail_city(), "Mailing city does not match");
        softAssert.assertNull(ob834Entity.getMail_st(), "Mailing state does not match");
        softAssert.assertNull(ob834Entity.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertNull(ob834Entity.getMail_fip_code(), "Mailing fipcode is not null");
        softAssert.assertAll("Mailing Address did not match for " + subscriber.getFirstName());
    }

    private void validateMailingAddress(Ob834DetailsEntity ob834Entity, MemberDetails subscriber) {
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressLine1(), ob834Entity.getMail_street_line1(), "Mailing address street line 1 does not match");
        if (subscriber.getMailingAddress().getAddressLine2() != null) {
            softAssert.assertEquals(subscriber.getMailingAddress().getAddressLine2(), ob834Entity.getMail_street_line2(), "Mailing address street line 2 does not match");
        } else {
            softAssert.assertNull(ob834Entity.getMail_street_line2(), "Mailing address street line 2 is not null");
        }
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressCity(), ob834Entity.getMail_city(), "Mailing city does not match");
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressState(), ob834Entity.getMail_st(), "Mailing state does not match");
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressZipcode(), ob834Entity.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertNull(ob834Entity.getMail_fip_code(), "Mailing fipcode is not null");
        softAssert.assertAll("Mailing Address did not match for " + subscriber.getFirstName());
        softAssert.assertAll();
    }

    private void validateIncorrectEntities(Ob834DetailsEntity ob834Entity, MemberDetails member) {
        softAssert.assertEquals(ob834Entity.getIncorrect_entity_id_code(), member.getIncorrectEntityIdCode(), "Incorrect_entity_id_code did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_id_code(), member.getIncorrectIdCode(), "Incorrect_id_code did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_entity_type_qualifier(), member.getIncorrectEntityTypeQualifier(), "Incorrect_entity_type_qualifier did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_first_name(), member.getIncorrect_first_name(), "Incorrect_first_name did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_last_name(), member.getIncorrect_last_name(), "Incorrect_last_name did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_id_code_qualifier(), member.getIncorrectIdCodeQualifier(), "Incorrect_id_code_qualifier did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_dob(), member.getIncorrect_dob(), "Incorrect_dob did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_gender(), member.getIncorrect_gender(), "Incorrect_gender did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_marital_status_code(), member.getIncorrect_marital_status_code(), "Incorrect_marital_status_code did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_race(), member.getIncorrect_race(), "Incorrect_race did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_middle_name(), member.getIncorrect_middle_name() != null && !member.getIncorrect_middle_name().isEmpty() ? member.getIncorrect_middle_name() : null, "Incorrect_middle_name did not match!");
        softAssert.assertAll();
    }

    private void validateBrokerDetails(Ob834DetailsEntity ob834Entity) {
        BrokerDetails broker = SharedData.getBroker();

        if (SharedData.getHasBroker()) {
            getDbDataMap(primaryMember.getFirstName());
            softAssert.assertEquals(broker.getBroker_name(), ob834Entity.getTpa_or_broker_name(), "Broker name is incorrect");
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_id(), dbDataMap.get(primaryMember.getFirstName()).getBrokerTinNum().replace("-", ""), "Broker Tin Number is incorrect");
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_lic_num(), broker.getBroker_lic_num(), "Broker license number is incorrect");
        } else {
            softAssert.assertNull(ob834Entity.getTpa_or_broker_name(), "Broker name is incorrect");
            softAssert.assertNull(ob834Entity.getTpa_or_broker_id(), "Broker Tin Number is incorrect");
            softAssert.assertNull(ob834Entity.getTpa_or_broker_lic_num(), "Broker license number is incorrect");
        }
    }

    private void validateResponsiblePersonDetails(Ob834DetailsEntity ob834Entity, MemberDetails member) {
        if (!member.getIsMinor()) {
            validateResPersonDetailsForMember(ob834Entity);
        } else {
            if(ob834Entity.getSubscriber_indicator().equals("Y")){
                validateResPerDetailsForMinorSubscriber(ob834Entity);
            } else {
                validateResPerDetailsForMinorMem(ob834Entity, member);
            }
        }
    }

    private void validateResPerDetailsForMinorSubscriber(Ob834DetailsEntity ob834Entity){
       MemberDetails primaryMember = SharedData.getPrimaryMember();
        softAssert.assertEquals(ob834Entity.getResponsible_person_first_name(), primaryMember.getFirstName(), "Responsible person first name mismatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_last_name(), primaryMember.getLastName(), "Responsible person last name mismatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_rel_code(), "S1", "Responsible person rel_code mismatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_ssn(), primaryMember.getSsn(), "Responsible person SSN does not match");
        softAssert.assertEquals(ob834Entity.getResponsible_person_phone(), primaryMember.getPhoneNumber().replace("-","") ,"Responsible person phone mismatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_email(), primaryMember.getEmailId(),"Responsible person email mismatch");
        softAssert.assertEquals(primaryMember.getAlternatePhNum() != null ? primaryMember.getAlternatePhNum().replace("-",""):primaryMember.getPhoneNumber().replace("-",""),ob834Entity.getAlternate_phone(),"Responsible person alt phone");
        softAssert.assertEquals(ob834Entity.getResponsible_person_street_line1(), primaryMember.getMailingAddress().getAddressLine1(), "Responsible person mailing street line 1");
        softAssert.assertEquals(ob834Entity.getResidence_street_line2(),primaryMember.getMailingAddress().getAddressLine2() , "Responsible person mailing street line 2");
        softAssert.assertEquals(ob834Entity.getResponsible_person_city(), primaryMember.getMailingAddress().getAddressCity(), "Responsible person mailing city mismatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_st(), primaryMember.getMailingAddress().getAddressState(),"State mismatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_zip_code(),primaryMember.getMailingAddress().getAddressZipcode(), "Zipcode mismatch");
        softAssert.assertAll("validateResPerDetailsForMinorSubscriber failed");
    }

    private void validateResPerDetailsForMinorMem(Ob834DetailsEntity ob834Entity, MemberDetails member){
        MemberDetails subscriber = basicActions.getMember(getName(ob834Entity, member));
        softAssert.assertEquals(ob834Entity.getResponsible_person_first_name(), subscriber.getFirstName());
        softAssert.assertEquals(ob834Entity.getResponsible_person_last_name(), subscriber.getLastName());
        softAssert.assertEquals(ob834Entity.getResponsible_person_rel_code(), "S1", "Responsible_person_rel_code mismatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_ssn(), subscriber.getSsn(), "Responsible_person_ssn mistatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_phone(), subscriber.getAlternatePhNum(),"Responsible person phone mismatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_email(), subscriber.getEmailId(),"Responsible person email id mismatch" );
        softAssert.assertEquals(ob834Entity.getResponsible_person_alt_phone(), subscriber.getAlternatePhNum(), "Responsible person alternate phone mismatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_street_line1(), subscriber.getMailingAddress().getAddressLine1(), "Responsible person mail addressline 1 mismatch");
        softAssert.assertEquals(ob834Entity.getResidence_street_line2(), subscriber.getMailingAddress().getAddressLine2(),"Responsible person mail addressline 2 mismatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_city(), subscriber.getMailingAddress().getAddressCity(), "Responsible person mail city mismatch");
        softAssert.assertEquals(ob834Entity.getResponsible_person_st(), subscriber.getMailingAddress().getAddressState(),"Responsible person mail state mismatch" );
        softAssert.assertEquals(ob834Entity.getResponsible_person_zip_code(), subscriber.getMailingAddress().getAddressZipcode(), "Responsible person mail zipcode mismatch");
        softAssert.assertAll("validateResPerDetailsForMinorMem failed");
    }

    private void validateResPersonDetailsForMember(Ob834DetailsEntity ob834Entity){
        softAssert.assertEquals(ob834Entity.getResponsible_person_first_name(), null);
        softAssert.assertEquals(ob834Entity.getResponsible_person_last_name(), null);
        softAssert.assertEquals(ob834Entity.getResponsible_person_rel_code(), null);
        softAssert.assertEquals(ob834Entity.getResponsible_person_ssn(), null);
        softAssert.assertEquals(ob834Entity.getResponsible_person_phone(), null);
        softAssert.assertEquals(ob834Entity.getResponsible_person_email(), null);
        softAssert.assertEquals(ob834Entity.getResponsible_person_alt_phone(), null);
        softAssert.assertEquals(ob834Entity.getResponsible_person_street_line1(), null);
        softAssert.assertEquals(ob834Entity.getResidence_street_line2(), null);
        softAssert.assertEquals(ob834Entity.getResponsible_person_city(), null);
        softAssert.assertEquals(ob834Entity.getResponsible_person_st(), null);
        softAssert.assertEquals(ob834Entity.getResponsible_person_zip_code(), null);
        softAssert.assertAll("validateResPersonDetailsForMember failed");
    }

    private void validatePersonalDetails(Ob834DetailsEntity ob834Entity, MemberDetails member) {
        String dateFormatted = member.getDob().substring(4, 8) + member.getDob().substring(0, 2) + member.getDob().substring(2, 4);
        softAssert.assertEquals(member.getFirstName(), ob834Entity.getMember_first_name(), "member firstname did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getLastName(), ob834Entity.getMember_last_name(), "member firstname did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getMiddleName(), ob834Entity.getMember_middle_name(), "member middle did not match for "+member.getFirstName());
        softAssert.assertEquals(dateFormatted, ob834Entity.getMember_dob(), "dob did not match for "+member.getFirstName());
        softAssert.assertEquals(ob834Entity.getMember_gender(), member.getGender().substring(0, 1), "gender did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getTobacco_user().equals("Yes") ? "T" : member.getTobacco_user().substring(0, 1), ob834Entity.getTobacco_use(), "Tobacco usage did not match for "+member.getFirstName());
//  Bug NVO-5231  softAssert.assertEquals(ob834Entity.getMarital_status_code(), "I", "Marital Status did not match for "+member.getFirstName());
        softAssert.assertEquals(getCodeForRelationship(member.getRelation_to_subscriber()), ob834Entity.getIndividual_rel_code(), "RelationshipCode did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getSsn()!=null? member.getSsn(): "000000000", ob834Entity.getMember_ssn(), "ssn did not match for "+member.getFirstName());
            softAssert.assertEquals(getCodeForRace(member.getRace()), ob834Entity.getMember_race(), "Race did not match");
        softAssert.assertAll("Personal Details for Member::"+member.getFirstName()+" did not match");
    }

    private void validateSponsorId(Ob834DetailsEntity ob834Entity, MemberDetails subscriber) {
        boolean validSSN = isSSNValid(SharedData.getPrimaryMember().getSsn());
        if (validSSN) {
            softAssert.assertEquals(subscriber.getSsn(), ob834Entity.getSponsor_id(), "Sponsor_id did not match");
        }
    }

    private void validateConstantFields(Ob834DetailsEntity ob834Entity) {
        String date = LocalDate.now().toString();

        String appType = SharedData.getAppType();
        if (appType.equals("exchange")) {
            softAssert.assertEquals(ob834Entity.getInterchange_sender_id(), "CNCT4HLTHCO");
        } else if (appType.equals("coco")) {
            softAssert.assertEquals(ob834Entity.getInterchange_sender_id(), "COLOCONNECT");
        }
        softAssert.assertEquals(ob834Entity.getApplication_date(), date.replace("-", ""), "Application date does not match in ob834 entity");
        softAssert.assertEquals(ob834Entity.getUpdated_by(), "JAVA_OB834", "Ob834 updated_by does not match");
        softAssert.assertEquals(ob834Entity.getAck_requested(), "0", "Ob834 Ack_requested does not match");
        softAssert.assertEquals(ob834Entity.getUsage_indicator(), "T", "Ob834 Usage_indicator does not match");
        softAssert.assertEquals(ob834Entity.getInterchange_date(), date.replace("-", ""), "Interchange_date does not match in with date ob834 entity");
        softAssert.assertEquals(ob834Entity.getDate_created().substring(0, 10), date, "Date_created does not match with date in ob834 entity");
        softAssert.assertEquals(ob834Entity.getDate_updated().substring(0, 10), date, "Date_updated does not match with date in ob834 entity");
    }

    private void medValidationsCommonForAllMembers(Ob834DetailsEntity ob834Entity, List<Map<String, String>> expectedValues, MemberDetails member) {
       String name = getName(ob834Entity, member);
        getMedicalPlanDbDataMap(name);
        String formatPlanStartDate = SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyStartDate().replaceAll("-", "");
        String formatMedicalPlanEndDate = SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyEndDate().replaceAll("-", "");
        String formatedFinStartDate = SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialStartDate().replaceAll("-", "");

        softAssert.assertEquals(ob834Entity.getHios_plan_id(), medicalPlanDbDataMap.get(name).getBaseId(), "Medical Hios id did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_name(), medicalPlanDbDataMap.get(name).getIssuerName(), "Medical Insurer Name did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_id(), medicalPlanDbDataMap.get(name).getIssuerId(), "Medical Insurer Id did not match!");

        softAssert.assertEquals(ob834Entity.getBenefit_begin_date(), formatPlanStartDate, "Medical plan start date is not correct");
        softAssert.assertEquals(ob834Entity.getBenefit_end_date(), formatMedicalPlanEndDate, "Medical plan end date is not correct");
        softAssert.assertEquals(ob834Entity.getFinancial_effective_date(), formatedFinStartDate, "Financial start date is not correct");

        validateDetailsFromStep(ob834Entity, expectedValues.get(0));
        validateIndivMedPremAmt(ob834Entity);
        setMedGrpCtrlNums(ob834Entity.getGroup_ctrl_number());
    }

    private void setMedGrpCtrlNums(String grpCtrlNum){
        List<String> medGrpCtrlNums = SharedData.getMedGroupCtlNumbers();
        if(medGrpCtrlNums==null){
            medGrpCtrlNums = new ArrayList<>();
        }
        medGrpCtrlNums.add(grpCtrlNum);
        SharedData.setMedGroupCtlNumbers(medGrpCtrlNums);
    }

    private void setDenGrpCtrlNums(String grpCtrlNum){
        List<String> denGrpCtrlNums = SharedData.getDenGroupCtlNumbers();
        if(denGrpCtrlNums==null){
            denGrpCtrlNums = new ArrayList<>();
        }
        denGrpCtrlNums.add(grpCtrlNum);
        SharedData.setDenGroupCtlNumbers(denGrpCtrlNums);
    }

    private void denValidationsCommonForAllMembers(Ob834DetailsEntity ob834Entity, List<Map<String, String>> expectedValues, MemberDetails member) {
       String name = getName(ob834Entity, member);
        getDentalPlanDbDataMap(name);
        String formatPlanStartDate = SharedData.getExpectedCalculatedDates_dentalPlan().getPolicyStartDate().replaceAll("-", "");
        String formatMedicalPlanEndDate = SharedData.getExpectedCalculatedDates_dentalPlan().getPolicyEndDate().replaceAll("-", "");
        String formatedFinStartDate = SharedData.getExpectedCalculatedDates_dentalPlan().getFinancialStartDate().replaceAll("-", "");

        softAssert.assertEquals(ob834Entity.getHios_plan_id(), dentalPlanDbDataMap.get(name).getBaseId(), "Dental Hios id did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_name(), dentalPlanDbDataMap.get(name).getIssuerName(), "Dental Insurer Name did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_id(), dentalPlanDbDataMap.get(name).getIssuerId(), "Dental Insurer Id did not match!");

        softAssert.assertEquals(ob834Entity.getBenefit_begin_date(), formatPlanStartDate, "Medical plan start date is not correct");
        softAssert.assertEquals(ob834Entity.getBenefit_end_date(), formatMedicalPlanEndDate, "Medical plan end date is not correct");
        softAssert.assertEquals(ob834Entity.getFinancial_effective_date(), formatedFinStartDate, "Financial start date is not correct");

        validateDetailsFromStep(ob834Entity, expectedValues.get(0));
        validateIndivDenPremAmt(ob834Entity);
        setDenGrpCtrlNums(ob834Entity.getGroup_ctrl_number());
    }

    private void medDenValidationsCommonForAllMem(Ob834DetailsEntity ob834Entity, MemberDetails member){
       String name = getName(ob834Entity, member);
        validateConstantFields(ob834Entity);
        validateBrokerDetails(ob834Entity);
        validateResponsiblePersonDetails(ob834Entity, member);
        getDbDataMap(name);
        String enrollees = getTotalEnrollees(ob834Entity);
        softAssert.assertEquals(primaryMember.getEmailId(), ob834Entity.getPrimary_email(), "primary email did not match");
        softAssert.assertEquals(primaryMember.getPhoneNumber().replace("-",""), ob834Entity.getPrimary_phone(), "primary phone did not match");
        softAssert.assertEquals(primaryMember.getSpokenLanguage(), ob834Entity.getSpoken_language(), "spoken language did not match");
        softAssert.assertEquals(primaryMember.getWrittenLanguage(), ob834Entity.getWritten_language(), "written language did not match");
        softAssert.assertEquals(ob834Entity.getPlan_year(), SharedData.getPlanYear(), "Plan Year is not correct");
        softAssert.assertEquals("1", ob834Entity.getTotal_subscribers(), "total subscribers did not match");
        softAssert.assertEquals(SharedData.getPlanYear(), ob834Entity.getPlan_year(), "plan year did not match");
        softAssert.assertTrue(dbDataMap.get(name).getRatingAreaName().contains(ob834Entity.getRate_area()));
        softAssert.assertEquals(ob834Entity.getCsr_level(), SharedData.getRecType()!=null && SharedData.getRecType().contains("medical")&&SharedData.getIsAiAn()?"03":dbDataMap.get(name).getCsrLevel(), "CSR level does not match");
        softAssert.assertEquals(enrollees, ob834Entity.getTotal_enrollees().trim(), "Total enrollees does not match");
        softAssert.assertEquals(String.valueOf(Integer.parseInt(enrollees)-1), ob834Entity.getTotal_dependents().toString().trim(), "total dependents did not match");
        softAssert.assertEquals(getGrpNum(ob834Entity), ob834Entity.getMember_group(), "member group did not match");
   }

   private String getGrpNum(Ob834DetailsEntity ob834DetailsEntity){
     return ob834DetailsEntity.getInsurance_line_code().equals("HLT")? getMemberMedGrp(ob834DetailsEntity.getMember_first_name()): getMemberDenGrp(ob834DetailsEntity.getMember_first_name());
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

    private String getTotalEnrollees(Ob834DetailsEntity ob834DetailsEntity){
      return ob834DetailsEntity.getInsurance_line_code().equals("HLT")? basicActions.getTotalMedEnrollees(ob834DetailsEntity.getMember_first_name()) : basicActions.getTotalDentalEnrollees(ob834DetailsEntity.getMember_first_name());
   }

    private void subscriberOnlyMedValidations(Ob834DetailsEntity ob834Entity, MemberDetails subscriber) {
        // Subscriber Only Fields
        getMedicalPlanDbDataMap(getName(ob834Entity, subscriber));
        double amt = Double.parseDouble(subscriber.getMedicalAptcAmt());
        String expectedPMMedicalAptcAmt = String.format("%.2f", amt);
        softAssert.assertEquals(expectedPMMedicalAptcAmt, ob834Entity.getPremium_reduction_amt(), "Medical Plan premium reduction amount does not match");
        softAssert.assertEquals(medicalPlanDbDataMap.get(subscriber.getFirstName()).getCsrAmt() != null ? medicalPlanDbDataMap.get(subscriber.getFirstName()).getCsrAmt() : "0.00", ob834Entity.getCsr_amount(), "Medical CSR amount does not match");
        softAssert.assertEquals(subscriber.getTotalMedAmtAfterReduction().replace("$", "").replace(",", ""), ob834Entity.getTotal_responsible_amount(), "Medical Total Responsible amount does not match");
        softAssert.assertEquals(subscriber.getMedicalPremiumAmt().replace("$", "").replace(",", ""), ob834Entity.getTotal_premium_amount(), "Medical Total Premium amount does not match");
        softAssert.assertEquals(getCodeForRelationship("SELF"), ob834Entity.getIndividual_rel_code(), "RelationshipCode did not match for "+subscriber.getFirstName());
        subscriberOnlyMedDenFields(ob834Entity, subscriber);
        setMedicalFileName(ob834Entity);
    }

    private void setMedicalFileName(Ob834DetailsEntity ob834Entity){
        List<String> medFileNames = SharedData.getMedicalFileName_grp();
        if(medFileNames==null){
            medFileNames = new ArrayList<>();
        }
        medFileNames.add(ob834Entity.getFilename());

        Set<String> set = new LinkedHashSet<>(medFileNames);
        medFileNames = new ArrayList<>(set);
        SharedData.setMedicalFileName_grp(medFileNames);
    }

    private void setDentalFileName(Ob834DetailsEntity ob834Entity){
        List<String> denFileNames = SharedData.getDentalFileName_grp();
        if(denFileNames==null){
            denFileNames = new ArrayList<>();
        }
        denFileNames.add(ob834Entity.getFilename());

        Set<String> set = new LinkedHashSet<>(denFileNames);
        denFileNames = new ArrayList<>(set);
        SharedData.setDentalFileName_grp(denFileNames);
    }

    private void subscriberOnlyDenValidations(Ob834DetailsEntity ob834Entity, MemberDetails subscriber) {
        // Subscriber Only Fields
        softAssert.assertEquals("0.00", ob834Entity.getPremium_reduction_amt(), "Dental Plan premium reduction amount does not match");
        softAssert.assertEquals("0.00", ob834Entity.getCsr_amount(), "Medical CSR amount does not match");
        softAssert.assertEquals(subscriber.getTotalDentalPremAfterReduction().replace("$", "").replace(",",""), ob834Entity.getTotal_responsible_amount(), "Dental Total Responsible amount does not match");
        softAssert.assertEquals(subscriber.getDentalPremiumAmt().replace("$", "").replace(",", ""), ob834Entity.getTotal_premium_amount(), "Medical Total Premium amount does not match");
        subscriberOnlyMedDenFields(ob834Entity, subscriber);
        setDentalFileName(ob834Entity);
    }

    private void subscriberOnlyMedDenFields(Ob834DetailsEntity ob834Entity, MemberDetails subscriber){
       if(basicActions.getAge(subscriber.getDob())<18) {
           softAssert.assertEquals(ob834Entity.getPlan_sponsor_name(), SharedData.getPrimaryMember().getSignature(), "plan sponsor name mismatch for minor");
       }else {
           softAssert.assertEquals(ob834Entity.getPlan_sponsor_name(), subscriber.getSignature(), "plan sponsor name did not match");
       }
        softAssert.assertEquals(primaryMember.getAlternatePhNum() != null ? primaryMember.getAlternatePhNum().replace("-","") : primaryMember.getPhoneNumber().replace("-",""), ob834Entity.getAlternate_phone(), "alternate phone did not match");
        softAssert.assertEquals(ob834Entity.getSubscriber_id(), ob834Entity.getMember_id(), "Subscriber_id and Member_id in ob834 entity does not match");
        softAssert.assertEquals(ob834Entity.getPremium_reduction_type(), "APTC", "Plan premium reduction type does not match");
        validateSponsorId(ob834Entity, subscriber);
        validateResidentialAddress(ob834Entity, subscriber);
        if((subscriber.getMailingAddress()!=null&&!subscriber.getMailingAddress().equals(subscriber.getResAddress())) || subscriber.getIsProfileChange()){
            validateMailingAddress(ob834Entity, subscriber);
        } else {
            validateMailingAddressIsNull(ob834Entity, subscriber);
        }
    }

    private void validateIndivMedPremAmt(Ob834DetailsEntity ob834Entity){
        medicalPolicyEnitities.stream().filter(medEntity -> medEntity.getFirst_name().equals(ob834Entity.getMember_first_name())).findFirst().ifPresent(medEntity ->
                softAssert.assertEquals(medEntity.getPlan_premium_amt(), ob834Entity.getPremium_amount(), "Medical Individual Plan premium amount does not match for "+medEntity.getFirst_name()));
        softAssert.assertAll();
    }

    private void validateIndivDenPremAmt(Ob834DetailsEntity ob834Entity){
        dentalPolicyEnitities.stream().filter(denEntity -> denEntity.getFirst_name().equals(ob834Entity.getMember_first_name())).findFirst().ifPresent(denEntity ->
                softAssert.assertEquals(denEntity.getPlan_premium_amt(), ob834Entity.getPremium_amount(), "Dental Individual Plan premium amount does not match for "+denEntity.getFirst_name()));
    }

    private void validateDetailsFromStep(Ob834DetailsEntity ob834Entity, Map<String, String> expectedValues) {
        if(ob834Entity.getSubscriber_indicator().equals("N")&& !basicActions.getMember(ob834Entity.getMember_first_name()).getIsProfileChange() && SharedData.getPrimaryMember().getIsProfileChange() ){
            softAssert.assertEquals(ob834Entity.getAddl_maint_reason(), "NO CHANGE", "addl_maint_reason mismatched");
        } else {
            softAssert.assertEquals(ob834Entity.getAddl_maint_reason(), expectedValues.get("addl_maint_reason")!=null? expectedValues.get("addl_maint_reason").replace(" or ", "|") : expectedValues.get("addl_maint_reason"), "addl_maint_reason mismatched");
        }
        softAssert.assertEquals(ob834Entity.getMaintenance_type_code(), expectedValues.get("maintenance_type_code"), "maintenance_type_code mismatched");
        softAssert.assertEquals(ob834Entity.getHd_maint_type_code(), expectedValues.get("hd_maint_type_code"), "hd_maint_type_code mismatched");
        softAssert.assertEquals(ob834Entity.getMaintenance_reas_code(), expectedValues.get("maintenance_reas_code"), "maintenance_reas_code mismatched");
        softAssert.assertTrue(expectedValues.get("sep_reason") == null ? ob834Entity.getSep_reason().isEmpty() : ob834Entity.getSep_reason().equals(expectedValues.get("sep_reason")), "Sep_reason mismatch or expected blank but was: " + ob834Entity.getSep_reason());
    }

    private void setMedicalData(){
        SharedData.setMedicalFileName_grp(null);
        ob834DetailsMedEntities = exchDbDataProvider.getOb834Details("HLT");
        SharedData.setOb834DetailsMedEntities(ob834DetailsMedEntities);
        subscribers = basicActions.getAllSubscribers();
        dbDataMapList = SharedData.getDbDataNew();
        medicalPlanDbDataMapList = SharedData.getMedicalPlanDbDataNew();
        medicalPolicyEnitities = SharedData.getMedicalPolicyTablesEntities();
    }

    private void setDentalData() {
        SharedData.setDentalFileName_grp(null);
        ob834DetailsDenEntities = exchDbDataProvider.getOb834Details("DEN");
        SharedData.setOb834DetailsDenEntities(ob834DetailsDenEntities);
        ob834DetailsDenEntities = SharedData.getOb834DetailsDenEntities();
        subscribers = basicActions.getAllDenSubscribers();
        dbDataMapList = SharedData.getDbDataNew();
        dentalPlanDbDataMapList = SharedData.getDentalPlanDbDataNew();
        dentalPolicyEnitities = SharedData.getDentalPolicyTablesEntities();
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

    private String getName(Ob834DetailsEntity ob834Entity, MemberDetails member){
        String name = "";
        if(member.getIsSubscriber().equals("Y")){
            name = member.getFirstName();
        } else if(ob834Entity.getInsurance_line_code().equals("HLT")){
            name = member.getMedSubscriberName();
        } else {
            name = member.getDenSubscriberName();
        }
        return name;
    }
}
