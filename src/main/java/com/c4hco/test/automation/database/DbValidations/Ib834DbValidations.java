package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.Ib834Entity;
import com.c4hco.test.automation.database.EntityObj.PlanDbData;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.c4hco.test.automation.utils.BasicActions.isSSNValid;
import static com.c4hco.test.automation.utils.EnumRelationship.getCodeForRelationship;
import static com.c4hco.test.automation.utils.Race.getCodeForRace;

public class Ib834DbValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    List<Ib834Entity> ib834MedEntities = new ArrayList<>();
    List<Ib834Entity> ib834DenEntities = new ArrayList<>();
    SoftAssert softAssert = new SoftAssert();
    MemberDetails subscriber = SharedData.getPrimaryMember();
    DbData dbData = new DbData();
    PlanDbData medicalDbData = new PlanDbData();
    PlanDbData dentalDbData = new PlanDbData();

    private void setIb834Data(){
        ib834MedEntities =  exchDbDataProvider.getIb834Details(SharedData.getMedGroupCtlNumber());
        SharedData.setIb834MedDetailsEntities(ib834MedEntities);

        ib834DenEntities = exchDbDataProvider.getIb834Details(SharedData.getDenGroupCtlNumber());
        SharedData.setIb834DenDetailsEntities(ib834DenEntities);

        medicalDbData = SharedData.getMedicalPlanDbData().get("group1");
        dentalDbData = SharedData.getDentalPlanDbData().get("group1");
        dbData  = SharedData.getDbData();

        SharedData.setMedicalIb834FileName(ib834MedEntities.get(0).getFilename());
        SharedData.setDentalIb834FileName(ib834DenEntities.get(0).getFilename());
    }

    public void ib834DbRecordsValidations(String recordType, List<Map<String, String>> expectedValues) {
        setIb834Data();
        switch (recordType) {
            case "medical":
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

    private void ib834MedRecordsValidations(List<Map<String, String>> expectedValues) {
        for (Ib834Entity ib834Entity : ib834MedEntities) {
            if (ib834Entity.getSubscriber_indicator().equals("Y")) {
                subscriberOnlyMedDenFields(ib834Entity);
                validateMedDenForSubscriberAndMem(ib834Entity, subscriber);
            } else {
                   validateDependentMedDenDetails(ib834Entity);
            }
            medDenValidationsCommonForAllMem(ib834Entity);
            medValidationsCommonForAllMembers(ib834Entity, expectedValues);
        }
        softAssert.assertAll();
    }

    private void ib834DenRecordsValidations(List<Map<String, String>> expectedValues){
        for (Ib834Entity ib834DenEntity : ib834DenEntities) {
            if (ib834DenEntity.getSubscriber_indicator().equals("Y")) {
                subscriberOnlyMedDenFields(ib834DenEntity);
                validateMedDenForSubscriberAndMem(ib834DenEntity, subscriber);
            } else {
                validateDependentMedDenDetails(ib834DenEntity);
            }
            medDenValidationsCommonForAllMem(ib834DenEntity);
            denValidationsCommonForAllMembers(ib834DenEntity, expectedValues);
        }
        softAssert.assertAll();
    }

    private void subscriberOnlyMedDenFields(Ib834Entity ib834MedEntity) {
        // Subscriber Only Fields
        softAssert.assertEquals(subscriber.getFullName(), ib834MedEntity.getPlan_sponsor_name(), "Plan sponsor name did not match");
        softAssert.assertEquals(subscriber.getAlternatePhNum() != null ? subscriber.getAlternatePhNum() : subscriber.getPhoneNumber(), ib834MedEntity.getAlternate_phone(), "alternate phone did not match");
        softAssert.assertEquals(ib834MedEntity.getSubscriber_id(), ib834MedEntity.getMember_id(), "Subscriber_id and Member_id in ib834 entity does not match");
        softAssert.assertEquals(subscriber.getIsSubscriber(), "Y", "Subscriber indicator did not match for "+subscriber.getFirstName());
        softAssert.assertEquals(subscriber.getEmailId(), ib834MedEntity.getPrimary_email(), "primary email did not match");
        softAssert.assertEquals(subscriber.getPhoneNumber(), ib834MedEntity.getPrimary_phone(), "primary phone did not match");
        softAssert.assertEquals(subscriber.getSpokenLanguage(), ib834MedEntity.getSpoken_language(), "spoken language did not match");
        softAssert.assertEquals(subscriber.getWrittenLanguage(), ib834MedEntity.getWritten_language(), "written language did not match");
        validateResidentialAddress(ib834MedEntity);
        validateMailingAddress(ib834MedEntity);
    }
    private void validateSponsorId(Ib834Entity ib834MedEntity){
        boolean validSSN = isSSNValid(SharedData.getPrimaryMember().getSsn());
        if (validSSN) {
            softAssert.assertEquals(subscriber.getSsn(), ib834MedEntity.getSponsor_id(), "Sponsor_id did not match");
        }
        softAssert.assertAll();
    }
    private void validateResidentialAddress(Ib834Entity ib834MedEntity) {
        softAssert.assertEquals(subscriber.getResAddress().getAddressLine1(), ib834MedEntity.getResidence_street_line1(), "Residential address line 1 does not match");
        if (subscriber.getResAddress().getAddressLine2() != null) {
            softAssert.assertEquals(subscriber.getResAddress().getAddressLine2(), ib834MedEntity.getResidence_street_line2(), "Residential line2 is null");
        } else {
            softAssert.assertNull(ib834MedEntity.getResidence_street_line2(), "Residential address line 2 is not null");
        }
        softAssert.assertEquals(subscriber.getResAddress().getAddressCity(), ib834MedEntity.getResidence_city(), "Residential address city does not match");
        softAssert.assertEquals(subscriber.getResAddress().getAddressState(), ib834MedEntity.getResidence_st(), "Residential address state does not match");
        softAssert.assertEquals(subscriber.getResAddress().getAddressZipcode(), ib834MedEntity.getResidence_zip_code(), "Residential address zipcode does not match");
        softAssert.assertEquals(dbData.getFipcode(), ib834MedEntity.getResidence_fip_code(), "Residential address fipcode does not match");
        softAssert.assertAll();
    }
    private void validateMailingAddress(Ib834Entity ib834MedEntity) {
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressLine1(), ib834MedEntity.getMail_street_line1(), "Mailing address street line 1 does not match");
        if (subscriber.getMailingAddress().getAddressLine2() != null) {
            softAssert.assertEquals(subscriber.getMailingAddress().getAddressLine2(), ib834MedEntity.getMail_street_line2(), "Mailing address street line 2 does not match");
        } else {
            softAssert.assertNull(ib834MedEntity.getMail_street_line2(), "Mailing address street line 2 is not null");
        }
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressCity(), ib834MedEntity.getMail_city(), "Mailing city does not match");
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressState(), ib834MedEntity.getMail_st(), "Mailing state does not match");
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressZipcode(), ib834MedEntity.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertNull(ib834MedEntity.getMail_fip_code(), "Mailing fipcode is not null");
        softAssert.assertAll("Mailing Address did not match for "+subscriber.getFirstName());
    }
    private void validateMedDenForSubscriberAndMem(Ib834Entity ib834MedEntity , MemberDetails member) {
        softAssert.assertEquals(String.valueOf(subscriber.getAccount_id()),ib834MedEntity.getSsap_id(), "Account id and ssap_id mismatch" );
        softAssert.assertEquals(subscriber.getPrior_subscriber_id(), ib834MedEntity.getPrior_subscriber_id(), "Prior subscriber id did not match for "+subscriber.getFirstName());
        softAssert.assertEquals(SharedData.getExchPersonId().get(member.getFirstName()), ib834MedEntity.getMember_id(), "Member Id did not match for "+member.getFirstName());
        softAssert.assertEquals(SharedData.getExchPersonId().get(subscriber.getFirstName()), ib834MedEntity.getSubscriber_id(), "subscriber id did not match "+subscriber.getFirstName());
        validatePersonalDetails(ib834MedEntity, member);
    }
    private void validatePersonalDetails(Ib834Entity ib834MedEntity, MemberDetails member) {
        String dateFormatted = member.getDob().substring(4, 8) + member.getDob().substring(0, 2) + member.getDob().substring(2, 4);
        softAssert.assertEquals(member.getFirstName(), ib834MedEntity.getMember_first_name(), "member firstname did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getLastName(), ib834MedEntity.getMember_last_name(), "member firstname did not match for "+member.getFirstName());
        softAssert.assertTrue(ib834MedEntity.getMember_middle_name() == null || ib834MedEntity.getMember_middle_name().isEmpty()
                        || ib834MedEntity.getMember_middle_name().equals(member.getMiddleName()),"Member middle name did not match");
        softAssert.assertEquals(dateFormatted, ib834MedEntity.getMember_dob(), "dob did not match for "+member.getFirstName());
        softAssert.assertEquals(ib834MedEntity.getMember_gender(), member.getGender().substring(0, 1), "gender did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getTobacco_user().equals("Yes") ? "T" : member.getTobacco_user().substring(0, 1), ib834MedEntity.getTobacco_use(), "Tobacco usage did not match for "+member.getFirstName());
        softAssert.assertTrue(ib834MedEntity.getMarital_status_code().equals("I") ||ib834MedEntity.getMarital_status_code().isEmpty(), "Marital Status did not match for "+member.getFirstName());
        softAssert.assertEquals(getCodeForRelationship(member.getRelation_to_subscriber()), ib834MedEntity.getIndividual_rel_code(), "RelationshipCode did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getSsn()!=null? member.getSsn(): "000000000", ib834MedEntity.getMember_ssn(), "ssn did not match for "+member.getFirstName());
        softAssert.assertEquals(getCodeForRace(member.getRace()), ib834MedEntity.getMember_race(), "Race did not match");
        softAssert.assertAll("Personal Details for Member::"+member.getFirstName()+" did not match");
        softAssert.assertAll();
    }

    private void validateDependentMedDenDetails(Ib834Entity ib834MedEntity){
        List<MemberDetails> members = SharedData.getMembers();
        for(MemberDetails member: members){
            if(member.getFirstName().equals(ib834MedEntity.getMember_first_name())){
                System.out.println("VALIDATING FOR THE MEMBER - MEMBER's FIRST NAME::"+ib834MedEntity.getMember_first_name());
                validateMemberOnlyMedDenFields(ib834MedEntity);
                validateMedDenForSubscriberAndMem(ib834MedEntity, member);
            }
        }
    }

    private void validateMemberOnlyMedDenFields(Ib834Entity ib834MedEntity) {
        softAssert.assertNull(ib834MedEntity.getPremium_reduction_amt(), "Member Medical Plan premium reduction amount does not match");
        softAssert.assertNull(ib834MedEntity.getCsr_amount(), "Member Medical CSR amount does not match");
        softAssert.assertNull(ib834MedEntity.getTotal_responsible_amount(), "MemberMedical Total Responsible amount does not match");
        softAssert.assertNull(ib834MedEntity.getTotal_premium_amount(), "Member Medical Total Premium amount does not match");
        softAssert.assertNull(ib834MedEntity.getMail_street_line1(), "Mailing address street line 1 does not match");
        softAssert.assertNull(ib834MedEntity.getMail_street_line2(), "Mailing address street line 2 is not null");
        softAssert.assertNull(ib834MedEntity.getMail_city(), "Mailing city does not match");
        softAssert.assertNull(ib834MedEntity.getMail_st(), "Mailing state does not match");
        softAssert.assertNull(ib834MedEntity.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertNull(ib834MedEntity.getMail_fip_code(), "Mailing fipcode is not null");
        softAssert.assertNull(ib834MedEntity.getResidence_street_line2(), "Residential address line 2 is not null");
        softAssert.assertNull(ib834MedEntity.getResidence_city(), "Residential address city does not match");
        softAssert.assertNull(ib834MedEntity.getResidence_st(), "Residential address state does not match");
        softAssert.assertNull(ib834MedEntity.getResidence_zip_code(), "Residential address zipcode does not match");
        softAssert.assertNull(ib834MedEntity.getResidence_fip_code(), "Residential address fipcode does not match");
        softAssert.assertNull(ib834MedEntity.getPremium_reduction_type(),"Plan premium reduction type does not match");
        softAssert.assertEquals("N", ib834MedEntity.getSubscriber_indicator(), "Subscriber indicator did not match for member");
    }
    private void medDenValidationsCommonForAllMem(Ib834Entity ib834MedEntity){
        validateConstantFields(ib834MedEntity);
        validateBrokerDetails(ib834MedEntity);
        validateResponsiblePersonDetails(ib834MedEntity);
        validateSponsorId(ib834MedEntity);

        softAssert.assertEquals(String.valueOf(SharedData.getScenarioDetails().getTotalMembers()), ib834MedEntity.getTotal_enrollees(), "Total members mismatch");
        softAssert.assertEquals(SharedData.getScenarioDetails().getSubscribers(), ib834MedEntity.getTotal_subscribers(), "total subscribers did not match");
        softAssert.assertEquals(Integer.parseInt(SharedData.getScenarioDetails().getEnrollees().trim()), Integer.parseInt(ib834MedEntity.getTotal_enrollees().trim()), "Total enrollees does not match");
        softAssert.assertEquals(SharedData.getScenarioDetails().getDependents().toString().trim(), ib834MedEntity.getTotal_dependents().toString().trim(), "total dependents did not match");
       // softAssert.assertTrue(dbData.getRatingAreaName().contains(ib834MedEntity.getRate_area()),"" );
        softAssert.assertEquals(ib834MedEntity.getCsr_level(), dbData.getCsrLevel(), "CSR level does not match");
    }
    private void validateConstantFields(Ib834Entity ib834MedEntity) {
        String date = LocalDate.now().toString();

        String appType = SharedData.getAppType();
        if (appType.equals("exchange")) {
            softAssert.assertEquals(ib834MedEntity.getInterchange_receiver_id(), "CNCT4HLTHCO");
        } else if (appType.equals("coco")) {
            softAssert.assertEquals(ib834MedEntity.getInterchange_receiver_id(), "COLOCONNECT");
        }
        softAssert.assertEquals(ib834MedEntity.getCreated_by(), "JAVA_IB834", "Ib834 updated_by does not match");
        softAssert.assertEquals(ib834MedEntity.getEdi_status(), "EDI_COMPLETE", "Edi status mismatch");
        softAssert.assertEquals(ib834MedEntity.getAck_requested(), "0", "Ib834 Ack_requested does not match");
        softAssert.assertEquals(ib834MedEntity.getUsage_indicator(), "T", "Ib834 Usage_indicator does not match");
        softAssert.assertEquals("20"+ib834MedEntity.getInterchange_date(), date.replace("-", ""), "Interchange_date does not match in with date Ib834 entity");
        softAssert.assertEquals(ib834MedEntity.getCreated_ts().substring(0, 10), date, "Date_created does not match with date in Ib834 entity");
        softAssert.assertEquals(ib834MedEntity.getUpdated_ts().substring(0, 10), date, "Date_updated does not match with date in Ib834 entity");
    }
    private void validateBrokerDetails(Ib834Entity ib834MedEntity) {
        BrokerDetails broker = SharedData.getBroker();
        if (SharedData.getHasBroker()) {
            softAssert.assertEquals(broker.getBroker_name(), ib834MedEntity.getTpa_or_broker_name(), "Broker name is incorrect");
            softAssert.assertEquals(ib834MedEntity.getTpa_or_broker_id(), dbData.getBrokerTinNum(), "Broker Tin Number is incorrect");
            softAssert.assertEquals(ib834MedEntity.getTpa_or_broker_lic_num(), broker.getBroker_lic_num(), "Broker license number is incorrect");
        } else {
            softAssert.assertEquals(ib834MedEntity.getTpa_or_broker_name(), null, "Broker name is incorrect");
            softAssert.assertEquals(ib834MedEntity.getTpa_or_broker_id(), null, "Broker Tin Number is incorrect");
            softAssert.assertEquals(ib834MedEntity.getTpa_or_broker_lic_num(), null, "Broker license number is incorrect");
        }
    }
    private void validateResponsiblePersonDetails(Ib834Entity ib834MedEntity) {
        if (!subscriber.getIsMinor()) {
            softAssert.assertEquals(ib834MedEntity.getResponsible_person_first_name(), null);
            softAssert.assertEquals(ib834MedEntity.getResponsible_person_last_name(), null);
            softAssert.assertEquals(ib834MedEntity.getResponsible_person_rel_code(), null);
            softAssert.assertEquals(ib834MedEntity.getResponsible_person_ssn(), null);
            softAssert.assertEquals(ib834MedEntity.getResponsible_person_phone(), null);
            softAssert.assertEquals(ib834MedEntity.getResponsible_person_email(), null);
            softAssert.assertEquals(ib834MedEntity.getResponsible_person_alt_phone(), null);
            softAssert.assertEquals(ib834MedEntity.getResponsible_person_street_line1(), null);
            softAssert.assertEquals(ib834MedEntity.getResidence_street_line2(), null);
            softAssert.assertEquals(ib834MedEntity.getResponsible_person_city(), null);
            softAssert.assertEquals(ib834MedEntity.getResponsible_person_st(), null);
            softAssert.assertEquals(ib834MedEntity.getResponsible_person_zip_code(), null);
        } else{
            Assert.fail("WRITE CODE TO HANDLE THIS BLOCK");
        }
    }
    private void medValidationsCommonForAllMembers(Ib834Entity ib834MedEntity, List<Map<String, String>> expectedValues) {
        String formatPlanStartDate = SharedData.getExpectedCalculatedDates().getPolicyStartDate().replaceAll("-", "");
        String formatMedicalPlanEndDate = SharedData.getExpectedCalculatedDates().getPolicyEndDate().replaceAll("-", "");
        String[] sender = SharedData.getMedicalIb834FileName().split("_");
        softAssert.assertEquals(ib834MedEntity.getInterchange_sender_id(), sender[1] , "Medical Sender Id mismatch");

        SharedData.setMedGroupCtlNumber(ib834MedEntity.getGroup_ctrl_number());
        softAssert.assertEquals(ib834MedEntity.getHios_plan_id(), medicalDbData.getBaseId(), "Hios id did not match!");
        softAssert.assertEquals(ib834MedEntity.getInsurer_name(), medicalDbData.getIssuerName(), "Insurer Name did not match!");
        softAssert.assertEquals(ib834MedEntity.getInsurer_id(), medicalDbData.getIssuerId(), "Insurer Id did not match!");

        softAssert.assertEquals(ib834MedEntity.getBenefit_begin_date(), formatPlanStartDate, "Medical plan start date is not correct");
        softAssert.assertEquals(ib834MedEntity.getBenefit_end_date(), formatMedicalPlanEndDate, "Medical plan end date is not correct");
        softAssert.assertNull(ib834MedEntity.getFinancial_effective_date(), "Financial start date is not null");

        validateDetailsFromStep(ib834MedEntity, expectedValues.get(0));
    }

    private void validateDetailsFromStep(Ib834Entity ib834MedEntity, Map<String, String> expectedValues) {
        softAssert.assertEquals(ib834MedEntity.getMaintenance_type_code(), expectedValues.get("maintenance_type_code"), "maintenance_type_code mismatched");
        softAssert.assertEquals(ib834MedEntity.getHd_maint_type_code(), expectedValues.get("hd_maint_type_code"), "hd_maint_type_code mismatched");
        softAssert.assertEquals(ib834MedEntity.getMaintenance_reas_code(), expectedValues.get("maintenance_reas_code"), "maintenance_reas_code mismatched");
        softAssert.assertEquals(ib834MedEntity.getAddl_maint_reason(), expectedValues.get("addl_maint_reason"), "addl_maint_reason mismatched");
    }

    private void denValidationsCommonForAllMembers(Ib834Entity ib834DenEntity, List<Map<String, String>> expectedValues) {
        String formatPlanStartDate = SharedData.getExpectedCalculatedDates().getPolicyStartDate().replaceAll("-", "");
        String formatMedicalPlanEndDate = SharedData.getExpectedCalculatedDates().getPolicyEndDate().replaceAll("-", "");
        String[] sender = SharedData.getDentalFileName().split("_");
        softAssert.assertEquals(ib834DenEntity.getInterchange_sender_id(), sender[1], "Dental Sender Id mismatch");
        SharedData.setDenGroupCtlNumber(ib834DenEntity.getGroup_ctrl_number());
        softAssert.assertEquals(ib834DenEntity.getHios_plan_id(), dentalDbData.getBaseId(), "Hios id did not match!");
        softAssert.assertEquals(ib834DenEntity.getInsurer_name(), dentalDbData.getIssuerName(), "Insurer Name did not match!");
        softAssert.assertEquals(ib834DenEntity.getInsurer_id(), dentalDbData.getIssuerId(), "Insurer Id did not match!");
        softAssert.assertEquals(ib834DenEntity.getBenefit_begin_date(), formatPlanStartDate, "Medical plan start date is not correct");
        softAssert.assertEquals(ib834DenEntity.getBenefit_end_date(), formatMedicalPlanEndDate, "Medical plan end date is not correct");
        softAssert.assertNull(ib834DenEntity.getFinancial_effective_date(), "Financial start date is not correct");
        validateDetailsFromStep(ib834DenEntity, expectedValues.get(0));
    }


}
