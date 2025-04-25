
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.c4hco.test.automation.utils.BasicActions.isSSNValid;
import static com.c4hco.test.automation.utils.EnumRelationship.getCodeForRelationship;
import static com.c4hco.test.automation.utils.Race.getCodeForRace;


public class COCO_Ob834PreEdiDbValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();
    BasicActions basicActions = new BasicActions();
    List<Ob834DetailsEntity> ob834DetailsMedEntities = new ArrayList<>();
    MemberDetails subscriber = new MemberDetails();
    DbData dbData = new DbData();
    PlanDbData medicalDbData = new PlanDbData();
    List<PolicyTablesEntity> medicalPolicyEnitities = new ArrayList<>();

    public void recordsValidations(List<Map<String, String>> expectedValues) {
        setData(expectedValues);
        ob834MedRecordsValidations(expectedValues);
        softAssert.assertAll();
    }

    private void setData(List<Map<String, String>> expectedValues) {
        List<Ob834DetailsEntity> medicalOb834RecordsList = exchDbDataProvider.getOb834Details("HLT");
        List<Ob834DetailsEntity> medicalOb834Records = medicalOb834RecordsList.stream().filter(record -> record.getMaintenance_type_code().equals(expectedValues.get(0).get("maintenance_type_code"))).collect(Collectors.toList());
        SharedData.setOb834DetailsMedEntities(medicalOb834Records);

        ob834DetailsMedEntities = SharedData.getOb834DetailsMedEntities();
        subscriber = SharedData.getPrimaryMember();

        medicalDbData = SharedData.getMedicalPlanDbData().get("group1");
        dbData = SharedData.getDbData();

        medicalPolicyEnitities = SharedData.getMedicalPolicyTablesEntities();
    }
    private void ob834MedRecordsValidations(List<Map<String, String>> expectedValues){
        for (Ob834DetailsEntity ob834DetailsEntity : ob834DetailsMedEntities) {
            if (ob834DetailsEntity.getSubscriber_indicator().equals("Y")) {
                subscriberOnlyMedValidations(ob834DetailsEntity);
            } else {
                validateDependentMedDetails(ob834DetailsEntity);
            }
               medValidationsCommonForAllMem(ob834DetailsEntity);
               medValidationsCommonForAllMembers(ob834DetailsEntity, expectedValues.get(0));
        }
        softAssert.assertAll();
    }

    private void subscriberOnlyMedValidations(Ob834DetailsEntity ob834Entity) {
        // Subscriber Only Fields
        double amt = Double.parseDouble(SharedData.getPrimaryMember().getAptcAmt());
        String ExpectedPMMedicalAptcAmt = String.format("%.2f", amt);
        SharedData.setMedicalFileName(ob834Entity.getFilename());
        softAssert.assertEquals(ExpectedPMMedicalAptcAmt, ob834Entity.getPremium_reduction_amt(), "Medical Plan premium reduction amount does not match");
        softAssert.assertEquals(medicalDbData.getCsrAmt() != null ? medicalDbData.getCsrAmt() : "0.00", ob834Entity.getCsr_amount(), "Medical CSR amount does not match");
        softAssert.assertEquals(SharedData.getPrimaryMember().getTotalMedAmtAfterReduction().replace("$", "").replace(",", ""), ob834Entity.getTotal_responsible_amount(), "Medical Total Responsible amount does not match");
        softAssert.assertEquals(SharedData.getPrimaryMember().getMedicalPremiumAmt().replace("$", "").replace(",", ""), ob834Entity.getTotal_premium_amount(), "Medical Total Premium amount does not match");
        softAssert.assertEquals( ob834Entity.getPlan_sponsor_name(), subscriber.getSignature(), "plan sponsor name did not match");
        softAssert.assertEquals(subscriber.getAlternatePhNum() != null ? subscriber.getAlternatePhNum() : subscriber.getPhoneNumber(), ob834Entity.getAlternate_phone(), "alternate phone did not match");
        softAssert.assertEquals(ob834Entity.getSubscriber_id(), ob834Entity.getMember_id(), "Subscriber_id and Member_id in ob834 entity does not match");
        softAssert.assertEquals(ob834Entity.getPremium_reduction_type(), "SES", "Plan premium reduction type does not match");
        boolean validSSN = isSSNValid(SharedData.getPrimaryMember().getSsn());
        if (validSSN) {softAssert.assertEquals(subscriber.getSsn(), ob834Entity.getSponsor_id(), "Sponsor_id did not match");}
        validateResidentialAddress(ob834Entity, subscriber);
        if(!subscriber.getMailingAddress().equals(subscriber.getResAddress())){
            validateMailingAddress(ob834Entity, subscriber);
        } else {
            validateMailingAddressIsNull(ob834Entity);
        }
        validateMedForSubscriberAndMem(ob834Entity,subscriber);
    }
    private void validateResidentialAddress(Ob834DetailsEntity ob834Entity, MemberDetails member) {
        softAssert.assertEquals(member.getResAddress().getAddressLine1(), ob834Entity.getResidence_street_line1(), "Residential address line 1 does not match");
        if (member.getResAddress().getAddressLine2() != null) {
            softAssert.assertEquals(member.getResAddress().getAddressLine2(), ob834Entity.getResidence_street_line2(), "Residential line2 is null");
        } else {
            softAssert.assertNull(ob834Entity.getResidence_street_line2(), "Residential address line 2 is not null");
        }
        softAssert.assertEquals(member.getResAddress().getAddressCity(), ob834Entity.getResidence_city(), "Residential address city does not match");
        softAssert.assertEquals(member.getResAddress().getAddressState(), ob834Entity.getResidence_st(), "Residential address state does not match");
        softAssert.assertEquals(member.getResAddress().getAddressZipcode(), ob834Entity.getResidence_zip_code(), "Residential address zipcode does not match");
        softAssert.assertEquals(dbData.getFipcode(), ob834Entity.getResidence_fip_code(), "Residential address fipcode does not match");
        softAssert.assertAll();
    }
    private void validateMailingAddressIsNull(Ob834DetailsEntity ob834Entity){
        softAssert.assertNull(ob834Entity.getMail_street_line1(), "Mailing address street line 1 does not match");
        softAssert.assertNull(ob834Entity.getMail_street_line2(), "Mailing address street line 2 is not null");
        softAssert.assertNull(ob834Entity.getMail_city(), "Mailing city does not match");
        softAssert.assertNull(ob834Entity.getMail_st(), "Mailing state does not match");
        softAssert.assertNull(ob834Entity.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertNull(ob834Entity.getMail_fip_code(), "Mailing fipcode is not null");
        softAssert.assertAll("Mailing Address did not match for "+subscriber.getFirstName());
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
        softAssert.assertAll("Mailing Address did not match for "+subscriber.getFirstName());
    }
    private void validateMedForSubscriberAndMem(Ob834DetailsEntity ob834Entity, MemberDetails member){
        softAssert.assertEquals(member.getPrior_subscriber_id(), ob834Entity.getPrior_subscriber_id(), "Prior subscriber id did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getIsSubscriber(), ob834Entity.getSubscriber_indicator(), "Subscriber indicator did not match for "+member.getFirstName());
        softAssert.assertEquals(SharedData.getExchPersonId().get(member.getFirstName()), ob834Entity.getMember_id(), "Member Id did not match for "+member.getFirstName());
        softAssert.assertEquals(SharedData.getExchPersonId().get(subscriber.getFirstName()), ob834Entity.getSubscriber_id(), "subscriber id did not match "+member.getFirstName());
        validatePersonalDetails(ob834Entity, member);
        validateIncorrectEntities(ob834Entity, member);
        softAssert.assertAll();
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
    private void validateIncorrectEntities(Ob834DetailsEntity ob834Entity, MemberDetails member) {
        softAssert.assertEquals(ob834Entity.getIncorrect_entity_id_code(), member.getIncorrectEntityIdCode(), "Incorrect_entity_id_code did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_id_code(), member.getIncorrectIdCode(), "Incorrect_id_code did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_entity_type_qualifier(), member.getIncorrectEntityTypeQualifier(), "Incorrect_entity_type_qualifier did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_first_name(), member.getIncorrect_first_name(), "Incorrect_first_name did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_last_name(), member.getIncorrect_last_name(), "Incorrect_last_name did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_dob(), member.getIncorrect_dob(), "Incorrect_dob did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_gender(), member.getIncorrect_gender(), "Incorrect_gender did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_marital_status_code(), member.getIncorrect_marital_status_code(), "Incorrect_marital_status_code did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_race(), member.getIncorrect_race(), "Incorrect_race did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_middle_name(), member.getIncorrect_middle_name()!=null && !member.getIncorrect_middle_name().isEmpty()? member.getIncorrect_middle_name(): null, "Incorrect_middle_name did not match!");
        softAssert.assertAll();
    }
    private void validateDependentMedDetails(Ob834DetailsEntity ob834Entity){
        List<MemberDetails> members = SharedData.getMembers();
        for(MemberDetails member: members){
            if(member.getFirstName().equals(ob834Entity.getMember_first_name())){
                System.out.println("VALIDATING FOR THE MEMBER - MEMBER's FIRST NAME::"+ob834Entity.getMember_first_name());
                validateMemberOnlyMedFields(ob834Entity);
                validateMedForSubscriberAndMem(ob834Entity, member);
            }
        }
    }
    private void validateMemberOnlyMedFields(Ob834DetailsEntity ob834Entity){
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
        softAssert.assertNull(ob834Entity.getPremium_reduction_type(),"Plan premium reduction type does not match");
        softAssert.assertAll();
    }
    private void medValidationsCommonForAllMembers(Ob834DetailsEntity ob834Entity, Map<String, String> expectedValues) {
        SharedData.setMedGroupCtlNumber(ob834Entity.getGroup_ctrl_number());
        softAssert.assertEquals(ob834Entity.getHios_plan_id(), medicalDbData.getBaseId(), "Hios id did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_name(), medicalDbData.getIssuerName(), "Insurer Name did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_id(), medicalDbData.getIssuerId(), "Insurer Id did not match!");

        softAssert.assertEquals(ob834Entity.getBenefit_begin_date(),SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyStartDate().replaceAll("-", ""), "Medical plan start date is not correct");
        softAssert.assertEquals(ob834Entity.getBenefit_end_date(),SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyEndDate().replaceAll("-", ""), "Medical plan end date is not correct");
        softAssert.assertEquals(ob834Entity.getFinancial_effective_date(), SharedData.getExpectedCalculatedDates_medicalPlan().getFinancialStartDate().replaceAll("-", ""), "Financial start date is not correct");

        validateDetailsFromStep(ob834Entity, expectedValues);
        validateIndivMedPremAmt(ob834Entity);
    }
    private void validateDetailsFromStep(Ob834DetailsEntity ob834Entity, Map<String, String> expectedValues) {
        softAssert.assertEquals(ob834Entity.getMaintenance_type_code(), expectedValues.get("maintenance_type_code"), "maintenance_type_code mismatched");
        softAssert.assertEquals(ob834Entity.getHd_maint_type_code(), expectedValues.get("hd_maint_type_code"), "hd_maint_type_code mismatched");
        softAssert.assertEquals(ob834Entity.getMaintenance_reas_code(), expectedValues.get("maintenance_reas_code"), "maintenance_reas_code mismatched");
        softAssert.assertEquals(ob834Entity.getAddl_maint_reason(), expectedValues.get("addl_maint_reason")!=null? expectedValues.get("addl_maint_reason").replace(" or ", "|") : expectedValues.get("addl_maint_reason"), "addl_maint_reason mismatched");
        softAssert.assertTrue(expectedValues.get("sep_reason") == null ? ob834Entity.getSep_reason().isEmpty() : ob834Entity.getSep_reason().equals(expectedValues.get("sep_reason")), "Sep_reason mismatch or expected blank but was: " + ob834Entity.getSep_reason());
    }
    private void validateIndivMedPremAmt(Ob834DetailsEntity ob834Entity){
        medicalPolicyEnitities.stream().filter(medEntity -> medEntity.getFirst_name().equals(ob834Entity.getMember_first_name())).findFirst().ifPresent(medEntity ->
                softAssert.assertEquals(medEntity.getPlan_premium_amt(), ob834Entity.getPremium_amount(), "Medical Individual Plan premium amount does not match for "+medEntity.getFirst_name()));
    }
    private void medValidationsCommonForAllMem(Ob834DetailsEntity ob834Entity){
        validateConstantFields(ob834Entity);
        validateBrokerDetails(ob834Entity);
        validateResponsiblePersonDetails(ob834Entity);
        softAssert.assertEquals(subscriber.getEmailId(), ob834Entity.getPrimary_email(), "primary email did not match");
        softAssert.assertEquals(subscriber.getPhoneNumber(), ob834Entity.getPrimary_phone(), "primary phone did not match");
        softAssert.assertEquals(subscriber.getSpokenLanguage(), ob834Entity.getSpoken_language(), "spoken language did not match");
        softAssert.assertEquals(subscriber.getWrittenLanguage(), ob834Entity.getWritten_language(), "written language did not match");
        softAssert.assertEquals(String.valueOf(SharedData.getScenarioDetails().getTotalMembers()), ob834Entity.getTotal_enrollees(), "Total members mismatch");
        softAssert.assertEquals(ob834Entity.getPlan_year(), SharedData.getPlanYear(), "Plan Year is not correct");
        softAssert.assertEquals(SharedData.getScenarioDetails().getSubscribers(), ob834Entity.getTotal_subscribers(), "total subscribers did not match");
        softAssert.assertEquals(Integer.parseInt(SharedData.getScenarioDetails().getEnrollees().trim()), Integer.parseInt(ob834Entity.getTotal_enrollees().trim()), "Total enrollees does not match");
        softAssert.assertEquals(SharedData.getScenarioDetails().getDependents().toString().trim(), ob834Entity.getTotal_dependents().toString().trim(), "total dependents did not match");
        softAssert.assertEquals(SharedData.getPlanYear(), ob834Entity.getPlan_year(), "plan year did not match");
        softAssert.assertTrue(dbData.getRatingAreaName().contains(ob834Entity.getRate_area()));
        softAssert.assertEquals(ob834Entity.getCsr_level(), "00", "CSR level does not match");
        softAssert.assertEquals(String.valueOf(SharedData.getScenarioDetails().getTotalGroups()), ob834Entity.getMember_group(), "member group did not match");
    }
    private void validateConstantFields(Ob834DetailsEntity ob834Entity) {
        String date = LocalDate.now().toString();
        softAssert.assertEquals(ob834Entity.getInterchange_sender_id(), "COLOCONNECT");
        softAssert.assertEquals(ob834Entity.getApplication_date(), date.replace("-", ""), "Application date does not match in ob834 entity");
        softAssert.assertEquals(ob834Entity.getUpdated_by(), "JAVA_OB834", "Ob834 updated_by does not match");
        softAssert.assertEquals(ob834Entity.getAck_requested(), "0", "Ob834 Ack_requested does not match");
        softAssert.assertEquals(ob834Entity.getUsage_indicator(), "T", "Ob834 Usage_indicator does not match");
        softAssert.assertEquals(ob834Entity.getInterchange_date(), date.replace("-", ""), "Interchange_date does not match in with date ob834 entity");
        softAssert.assertEquals(ob834Entity.getDate_created().substring(0, 10), date, "Date_created does not match with date in ob834 entity");
        softAssert.assertEquals(ob834Entity.getDate_updated().substring(0, 10), date, "Date_updated does not match with date in ob834 entity");
    }
    private void validateBrokerDetails(Ob834DetailsEntity ob834Entity) {
        BrokerDetails broker = SharedData.getBroker();
        if (SharedData.getHasBroker()) {
            softAssert.assertEquals(broker.getBroker_name(), ob834Entity.getTpa_or_broker_name(), "Broker name is incorrect");
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_id(), dbData.getBrokerTinNum().replace("-",""), "Broker Tin Number is incorrect");
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_lic_num(), broker.getBroker_lic_num().replaceAll("[^0-9]", ""), "Broker license number is incorrect");
        } else {
            softAssert.assertNull(ob834Entity.getTpa_or_broker_name(), "Broker name is incorrect");
            softAssert.assertNull(ob834Entity.getTpa_or_broker_id(), "Broker Tin Number is incorrect");
            softAssert.assertNull(ob834Entity.getTpa_or_broker_lic_num(), "Broker license number is incorrect");       }
    }
    private void validateResponsiblePersonDetails(Ob834DetailsEntity ob834Entity) {
        if (!subscriber.getIsMinor()) {
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
        } else{
            Assert.fail("WRITE CODE TO HANDLE THIS BLOCK");
        }
    }

}