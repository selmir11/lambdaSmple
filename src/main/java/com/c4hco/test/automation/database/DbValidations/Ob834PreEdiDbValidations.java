package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.EntityObj.PlanDbData;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.utils.BasicActions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.c4hco.test.automation.utils.BasicActions.isSSNValid;
import static com.c4hco.test.automation.utils.EnumRelationship.getCodeForRelationship;
import static org.hamcrest.MatcherAssert.assertThat;

public class Ob834PreEdiDbValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    BasicActions basicActions = new BasicActions();
    SoftAssert softAssert = new SoftAssert();
    List<Ob834DetailsEntity> ob834DetailsMedEntities = new ArrayList<>();
    List<Ob834DetailsEntity> ob834DetailsDenEntities = new ArrayList<>();
    PlanDbData medicalDbData = SharedData.getMedicalPlanDbData().get("group1");
    PlanDbData dentalDbData = SharedData.getDentalPlanDbData().get("group1");
    MemberDetails subscriber = new MemberDetails();
    DbData dbData = SharedData.getDbData();

    public Ob834PreEdiDbValidations() {
        setData();
    }

    public void recordsValidations(String recordType, List<Map<String, String>> expectedValues) {
        switch (recordType) {
            case "medical":
                ob834MedRecordsValidations(expectedValues);
                break;
            case "dental":
                ob834DenRecordsValidations();
                break;
            default:
                Assert.fail("Record Type entered is not valid");
        }
    }

    private void ob834MedRecordsValidations(List<Map<String, String>> expectedValues){
        for (Ob834DetailsEntity ob834DetailsEntity : ob834DetailsMedEntities) {
            if (ob834DetailsEntity.getSubscriber_indicator().equals("Y")) {
                validateSubscriberMedDetails(ob834DetailsEntity, expectedValues);
                validateMedDenForSubscriber(ob834DetailsEntity);
            } else {
              //  validateDependentMedDetails(ob834DetailsEntity);
            }
          //  medValidationsCommonForAllMembers(ob834DetailsEntity);
        }
        softAssert.assertAll();
    }

    private void validateMedDenForSubscriber(Ob834DetailsEntity ob834Entity){
        softAssert.assertTrue(dbData.getRatingAreaName().contains(ob834Entity.getRate_area()));
        softAssert.assertEquals(SharedData.getExchPersonId().get(subscriber.getFirstName()), ob834Entity.getMember_id(), "Member Id did not match");
        softAssert.assertTrue(SharedData.getScenarioDetails().getEnrollees().equals(ob834Entity.getTotal_enrollees()), "total enrollees does not match");
        softAssert.assertEquals(SharedData.getScenarioDetails().getSubscribers(), ob834Entity.getTotal_subscribers(), "total subscribers did not match");
        softAssert.assertTrue(SharedData.getScenarioDetails().getDependents().equals(ob834Entity.getTotal_dependents()), "total dependents did not match");
        softAssert.assertEquals(subscriber.getFullName(), ob834Entity.getPlan_sponsor_name(), "plan sponsor name did not match");
        softAssert.assertEquals(SharedData.getPlanYear(), ob834Entity.getPlan_year(), "plan year did not match");
        softAssert.assertEquals(subscriber.getIsSubscriber(), ob834Entity.getSubscriber_indicator(), "Subscriber indicator did not match");
        softAssert.assertEquals(ob834Entity.getSubscriber_id(), ob834Entity.getMember_id(), "Subscriber_id and Member_id in ob834 entity does not match");
        softAssert.assertEquals(SharedData.getExchPersonId().get(subscriber.getFirstName()), ob834Entity.getSubscriber_id(), "subscriber id did not match");
        softAssert.assertEquals(String.valueOf(SharedData.getScenarioDetails().getTotalGroups()), ob834Entity.getMember_group(), "member group did not match");
        softAssert.assertEquals(String.valueOf(SharedData.getScenarioDetails().getTotalMembers()), ob834Entity.getTotal_enrollees(), "Total members mismatch");
        softAssert.assertEquals(ob834Entity.getPremium_reduction_type(), "APTC", "Plan premium reduction type does not match");
        softAssert.assertEquals(ob834Entity.getCsr_level(), dbData.getCsrLevel(), "CSR level does not match");
        softAssert.assertEquals(subscriber.getPrior_subscriber_id(), ob834Entity.getPrior_subscriber_id(), "Prior subscriber id did not match");
        validateSponsorId(ob834Entity);
        validateConstantFields(ob834Entity);
        validatePersonalDetails(ob834Entity);
        validateResponsiblePersonDetails(ob834Entity);
        validateBrokerDetails(ob834Entity);
        validateIncorrectEntities(ob834Entity);
        validateMailingAddress(ob834Entity);
        // validateRelCode(subscriber, ob834Entity);   //WIP
        validateMemberCountDetails(ob834Entity); // WIP
        validateResidentialAddress(ob834Entity);
    }

    private void validateResidentialAddress(Ob834DetailsEntity ob834Entity) {
        softAssert.assertEquals(subscriber.getResAddress().getAddressLine1(), ob834Entity.getResidence_street_line1(), "Residential address line 1 does not match");
        if (subscriber.getResAddress().getAddressLine2() != null) {
            softAssert.assertEquals(subscriber.getResAddress().getAddressLine2(), ob834Entity.getResidence_street_line2(), "Residential line2 is null");
        } else {
            softAssert.assertNull(ob834Entity.getResidence_street_line2(), "Residential address line 2 is not null");
        }
        softAssert.assertEquals(subscriber.getResAddress().getAddressCity(), ob834Entity.getResidence_city(), "Residential address city does not match");
        softAssert.assertEquals(subscriber.getResAddress().getAddressState(), ob834Entity.getResidence_st(), "Residential address state does not match");
        softAssert.assertEquals(subscriber.getResAddress().getAddressZipcode(), ob834Entity.getResidence_zip_code(), "Residential address zipcode does not match");
        softAssert.assertEquals(dbData.getFipcode(), ob834Entity.getResidence_fip_code(), "Residential address fipcode does not match");
    }

    private void validateMemberCountDetails(Ob834DetailsEntity ob834Entity) {
        // WIP - refactor
        int totalGroups = SharedData.getScenarioDetails().getTotalGroups();
        List<MemberDetails> memberList = SharedData.getMembers();
        if (totalGroups == 1 && memberList != null) {
            softAssert.assertEquals(String.valueOf(memberList.size() + 1), ob834Entity.getTotal_enrollees(), "Total Enrollees does not match.");
            softAssert.assertEquals(String.valueOf(memberList.size()), ob834Entity.getTotal_dependents(), "Total dependents does not match.");
            softAssert.assertEquals("1", ob834Entity.getTotal_subscribers(), "Total subscribers does not match.");
        } else if (totalGroups == 1 && memberList == null) {
            softAssert.assertEquals("1", ob834Entity.getTotal_enrollees(), "Total Enrollees does not match.");
            softAssert.assertEquals("0", ob834Entity.getTotal_dependents(), "Total dependents does not match.");
            softAssert.assertEquals("1", ob834Entity.getTotal_subscribers(), "Total subscribers does not match.");
        } else {
            //WIP
        }
    }

    private void validateMailingAddress(Ob834DetailsEntity ob834Entity) {
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
    }

    private void validateIncorrectEntities(Ob834DetailsEntity ob834Entity) {
        softAssert.assertEquals(ob834Entity.getIncorrect_entity_id_code(), subscriber.getIncorrectEntityIdCode(), "Incorrect_entity_id_code did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_id_code(), subscriber.getIncorrectIdCode(), "Incorrect_id_code did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_entity_type_qualifier(), subscriber.getIncorrectEntityTypeQualifier(), "Incorrect_entity_type_qualifier did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_first_name(), subscriber.getIncorrect_first_name(), "Incorrect_first_name did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_last_name(), subscriber.getIncorrect_last_name(), "Incorrect_last_name did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_id_code_qualifier(), subscriber.getIncorrectIdCodeQualifier(), "Incorrect_id_code_qualifier did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_dob(), subscriber.getIncorrect_dob(), "Incorrect_dob did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_gender(), subscriber.getIncorrect_gender(), "Incorrect_gender did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_marital_status_code(), subscriber.getIncorrect_marital_status_code(), "Incorrect_marital_status_code did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_race(), subscriber.getIncorrect_race(), "Incorrect_race did not match!");
        softAssert.assertEquals(ob834Entity.getIncorrect_middle_name(), subscriber.getIncorrect_middle_name(), "Incorrect_middle_name did not match!");
    }

    private void validateBrokerDetails(Ob834DetailsEntity ob834Entity) {
        BrokerDetails broker = SharedData.getBroker();
        if (SharedData.getHasBroker()) {
            softAssert.assertEquals(broker.getBroker_name(), ob834Entity.getTpa_or_broker_name(), "Broker name is incorrect");
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_id(), dbData.getBrokerTinNum(), "Broker Tin Number is incorrect");
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_lic_num(), broker.getBroker_lic_num(), "Broker license number is incorrect");
        } else {
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_name(), null, "Broker name is incorrect");
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_id(), null, "Broker Tin Number is incorrect");
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_lic_num(), null, "Broker license number is incorrect");
        }
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
        }
    }

    private void validatePersonalDetails(Ob834DetailsEntity ob834Entity) {
        String dateFormatted = subscriber.getDob().substring(4, 8) + subscriber.getDob().substring(0, 2) + subscriber.getDob().substring(2, 4);
        softAssert.assertEquals(subscriber.getFirstName(), ob834Entity.getMember_first_name(), "member firstname did not match");
        softAssert.assertEquals(subscriber.getLastName(), ob834Entity.getMember_last_name(), "member firstname did not match");
        softAssert.assertEquals(subscriber.getMiddleName(), ob834Entity.getMember_middle_name(), "member middle did not match");
        softAssert.assertEquals(subscriber.getSsn(), ob834Entity.getMember_ssn(), "ssn did not match");
        softAssert.assertEquals(dateFormatted, ob834Entity.getMember_dob(), "dob did not match");
        softAssert.assertEquals(ob834Entity.getMember_gender(), subscriber.getGender().substring(0, 1), "gender did not match");
      //  softAssert.assertEquals(subscriber.getRace() != null ? getCodeForRace(subscriber.getRace()) : "7", ob834Entity.getMember_race(), "Race did not match");
        softAssert.assertEquals(subscriber.getPhoneNumber(), ob834Entity.getPrimary_phone(), "primary phone did not match");
        softAssert.assertEquals(subscriber.getEmailId(), ob834Entity.getPrimary_email(), "primary email did not match");
        softAssert.assertEquals(subscriber.getAlternatePhNum() != null ? subscriber.getAlternatePhNum() : subscriber.getPhoneNumber(), ob834Entity.getAlternate_phone(), "alternate phone did not match");
        softAssert.assertEquals(subscriber.getTobacco_user().equals("Yes") ? "T" : subscriber.getTobacco_user().substring(0, 1), ob834Entity.getTobacco_use(), "Tobacco usage did not match");
        softAssert.assertEquals(ob834Entity.getMarital_status_code(), "I", "Marital Status did not match");
        softAssert.assertEquals(subscriber.getSpokenLanguage(), ob834Entity.getSpoken_language(), "spoken language did not match");
        softAssert.assertEquals(subscriber.getWrittenLanguage(), ob834Entity.getWritten_language(), "written language did not match");
        softAssert.assertEquals(getCodeForRelationship(subscriber.getRelation_to_subscriber()), ob834Entity.getIndividual_rel_code(), "RelationshipCode did not match");
    }

    private void validateSponsorId(Ob834DetailsEntity ob834Entity) {
        boolean validSSN = isSSNValid(SharedData.getPrimaryMember().getSsn());
        if (validSSN) {
            softAssert.assertEquals(SharedData.getPrimaryMember().getSsn(), ob834Entity.getSponsor_id(), "Sponsor_id did not match");
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

    private void validateSubscriberMedDetails(Ob834DetailsEntity ob834Entity, List<Map<String, String>> expectedValues){
        // same for all members within a group
        String formatPlanStartDate = SharedData.getExpectedCalculatedDates().getPolicyStartDate().replaceAll("-", "");
        String formatMedicalPlanEndDate = SharedData.getExpectedCalculatedDates().getPolicyEndDate().replaceAll("-", "");
        String formatedFinStartDate = SharedData.getExpectedCalculatedDates().getFinancialStartDate().replaceAll("-", "");

        SharedData.setMedGroupCtlNumber(ob834Entity.getGroup_ctrl_number());
        softAssert.assertEquals(ob834Entity.getHios_plan_id(), medicalDbData.getBaseId(), "Hios id did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_name(), medicalDbData.getIssuerName(), "Insurer Name did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_id(), medicalDbData.getIssuerId(), "Insurer Id did not match!");
        softAssert.assertEquals(ob834Entity.getBenefit_begin_date(), formatPlanStartDate, "Medical plan start date is not correct");
        softAssert.assertEquals(ob834Entity.getBenefit_end_date(), formatMedicalPlanEndDate, "Medical plan end date is not correct");
        softAssert.assertEquals(ob834Entity.getFinancial_effective_date(), formatedFinStartDate, "Financial start date is not correct");
        softAssert.assertEquals(ob834Entity.getPlan_year(), SharedData.getPlanYear(), "Plan Year is not correct");
        softAssert.assertEquals(medicalDbData.getPremiumAmt(), ob834Entity.getPremium_amount(), "Medical Plan premium amount does not match for subscriber.");
        validateDetailsFromStep(ob834Entity, expectedValues.get(0));
        validateMedicalAPTCAmount(ob834Entity);
    }

    private void validateMedicalAPTCAmount(Ob834DetailsEntity ob834Entity) {
        double amt = Double.parseDouble(SharedData.getPrimaryMember().getMedicalAptcAmt());
        String ExpectedPMMedicalAptcAmt = String.format("%.2f", amt);
            softAssert.assertEquals(ExpectedPMMedicalAptcAmt, ob834Entity.getPremium_reduction_amt(), "Medical Plan premium reduction amount does not match");
            softAssert.assertEquals(medicalDbData.getCsrAmt() != null ? medicalDbData.getCsrAmt() : "0.00", ob834Entity.getCsr_amount(), "Medical CSR amount does not match");
            softAssert.assertEquals(SharedData.getPrimaryMember().getTotalMedAmtAfterReduction().replace("$", ""), ob834Entity.getTotal_responsible_amount(), "Medical Total Responsible amount does not match");
            softAssert.assertEquals(SharedData.getPrimaryMember().getMedicalPremiumAmt().replace("$", ""), ob834Entity.getTotal_premium_amount(), "Medical Total Premium amount does not match");

    }

    private void validateDetailsFromStep(Ob834DetailsEntity ob834Entity, Map<String, String> expectedValues) {
        softAssert.assertEquals(ob834Entity.getMaintenance_type_code(), expectedValues.get("maintenance_type_code"), "maintenance_type_code mismatched");
        softAssert.assertEquals(ob834Entity.getHd_maint_type_code(), expectedValues.get("hd_maint_type_code"), "hd_maint_type_code mismatched");
        softAssert.assertEquals(ob834Entity.getMaintenance_reas_code(), expectedValues.get("maintenance_reas_code"), "maintenance_reas_code mismatched");
        softAssert.assertEquals(ob834Entity.getAddl_maint_reason(), expectedValues.get("addl_maint_reason"), "addl_maint_reason mismatched");
        softAssert.assertEquals(expectedValues.get("sep_reason") == null ? ob834Entity.getSep_reason().isEmpty() : ob834Entity.getSep_reason(), expectedValues.get("sep_reason"), "Sep_reason mismatch or expected blank but was: " + ob834Entity.getSep_reason());
    }

    private void ob834DenRecordsValidations(){

    }

    private void setData() {
        List<Ob834DetailsEntity> medicalOb834Records = exchDbDataProvider.getOb834Details("HLT");
        List<Ob834DetailsEntity> dentalOb834Records = exchDbDataProvider.getOb834Details("DEN");
        SharedData.setOb834DetailsMedEntities(medicalOb834Records);
        SharedData.setOb834DetailsDenEntities(dentalOb834Records);

        ob834DetailsMedEntities = SharedData.getOb834DetailsMedEntities();
        ob834DetailsDenEntities = SharedData.getOb834DetailsDenEntities();
        subscriber = SharedData.getPrimaryMember();
    }
}
