package com.c4hco.test.automation.database.DbValidations;
import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.*;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import com.c4hco.test.automation.utils.BasicActions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import static com.c4hco.test.automation.utils.BasicActions.isSSNValid;
import static com.c4hco.test.automation.utils.EnumRelationship.getCodeForRelationship;
import static com.c4hco.test.automation.utils.Race.getCodeForRace;

public class DbValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();
    String formattedDate; //formatted in YYYY-MM-DD
    Calendar calendar = Calendar.getInstance();
    int currentYear = calendar.get(Calendar.YEAR);
    BasicActions basicActions = new BasicActions();

    public void validateOb834FromDb(List<Map<String, String>> expectedValues) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        List<Ob834DetailsEntity> ob834DetailsEntities = exchDbDataProvider.getOb83Db4Details();
        SharedData.setOb834DetailsEntities(ob834DetailsEntities);
        for (Ob834DetailsEntity ob834Entity : ob834DetailsEntities) {
            exchDbDataProvider.setDataFromDb();
            DbData dbData = SharedData.getDbData();
            if (ob834Entity.getInsurance_line_code().equals("HLT")) {
                PlanDbData medicalDbData = SharedData.getMedicalPlanDbData().get("group1");
                validateMedicalDbRecord_ob834Detail(ob834Entity, medicalDbData, expectedValues);
            } else {
                PlanDbData dentalPlanDbData = SharedData.getDentalPlanDbData().get("group1");
                validateDentalDbRecord_ob834Detail(ob834Entity, dentalPlanDbData);
            }
            validateMedDenRec_ob834Detail(subscriber, ob834Entity, dbData);
            softAssert.assertAll();
        }
    }

    public void validateMedicalDbRecord_ob834Detail(Ob834DetailsEntity ob834Entity, PlanDbData medicalDbData, List<Map<String, String>> expectedValues) {
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
        validateMedicalAPTCAmount(ob834Entity, medicalDbData);
        softAssert.assertAll();
    }

    public void validateDentalDbRecord_ob834Detail(Ob834DetailsEntity ob834Entity, PlanDbData dentalDbData) {
       // WIP:: not all validations from medical method are in dental??
        softAssert.assertTrue(ob834Entity.getInsurance_line_code().equals("DEN"));
        softAssert.assertEquals(dentalDbData.getPremiumAmt(), ob834Entity.getPremium_amount(), "Dental Plan premium amount does not match for subscriber.");
        SharedData.setDenGroupCtlNumber(ob834Entity.getGroup_ctrl_number());
        validateDentalAPTCAmount(ob834Entity, dentalDbData);
    }

    public void validateMedDenRec_ob834Detail(MemberDetails subscriber, Ob834DetailsEntity ob834Entity, DbData dbData) {
        softAssert.assertTrue(dbData.getRatingAreaName().contains(ob834Entity.getRate_area()));
        softAssert.assertEquals(SharedData.getExchPersonId().get(subscriber.getFirstName()), ob834Entity.getMember_id(), "Member Id did not match");
        softAssert.assertEquals(SharedData.getScenarioDetails().getEnrollees(), ob834Entity.getTotal_enrollees(), "total enrollees does not match");
        softAssert.assertEquals(SharedData.getScenarioDetails().getSubscribers(), ob834Entity.getTotal_subscribers(), "total subscribers did not match");
        softAssert.assertEquals(SharedData.getScenarioDetails().getDependents(), ob834Entity.getTotal_dependents(), "total dependents did not match");
        softAssert.assertEquals(subscriber.getFullName(), ob834Entity.getPlan_sponsor_name(), "plan sponsor name did not match");
        softAssert.assertEquals(SharedData.getPlanYear(), ob834Entity.getPlan_year(), "plan year did not match");
        softAssert.assertEquals(subscriber.getIsSubscriber(), ob834Entity.getSubscriber_indicator(), "Subscriber indicator did not match");
        softAssert.assertEquals(ob834Entity.getSubscriber_id(), ob834Entity.getMember_id(), "Subscriber_id and Member_id in ob834 entity does not match");
        softAssert.assertEquals(SharedData.getExchPersonId().get(subscriber.getFirstName()), ob834Entity.getSubscriber_id(), "subscriber id did not match");
        softAssert.assertEquals(String.valueOf(SharedData.getScenarioDetails().getTotalGroups()), ob834Entity.getMember_group(), "member group did not match");
        softAssert.assertEquals(String.valueOf(SharedData.getScenarioDetails().getTotalMembers()), ob834Entity.getTotal_enrollees(), "Total members mismatch");
        softAssert.assertEquals(ob834Entity.getPremium_reduction_type(), "APTC", "Plan premium reduction type does not match");
        softAssert.assertEquals(ob834Entity.getCsr_level(), dbData.getCsrLevel(), "CSR level does not match");
        validateSponsorId(ob834Entity);
        validateConstantFields(ob834Entity);
        validatePersonalDetails(subscriber, ob834Entity);
        validateResponsiblePersonDetails(subscriber, ob834Entity);
        validateBrokerDetails(ob834Entity, dbData);
        validateIncorrectEntities(subscriber, ob834Entity);
        validateMailingAddress(subscriber, ob834Entity);
        // validateRelCode(subscriber, ob834Entity);   //WIP
        validateMemberCountDetails(ob834Entity);
        ValidatePriorSubscriber(subscriber, ob834Entity);
        validateResidentialAddress(subscriber, ob834Entity, dbData);
    }

    public void validateSponsorId(Ob834DetailsEntity ob834Entity) {
        boolean validSSN = isSSNValid(SharedData.getPrimaryMember().getSsn());
        if (validSSN) {
            softAssert.assertEquals(SharedData.getPrimaryMember().getSsn(), ob834Entity.getSponsor_id(), "Sponsor_id did not match");
        }
    }

    public void validateMedicalAPTCAmount(Ob834DetailsEntity ob834Entity, PlanDbData medicalDbData) {
        double amt = Double.parseDouble(SharedData.getPrimaryMember().getMedicalAptcAmt());
        String ExpectedPMMedicalAptcAmt = String.format("%.2f", amt);
        if (ob834Entity.getSubscriber_indicator().equals("Y")) {
            softAssert.assertEquals(ExpectedPMMedicalAptcAmt, ob834Entity.getPremium_reduction_amt(), "Medical Plan premium reduction amount does not match");
            softAssert.assertEquals(medicalDbData.getCsrAmt() != null ? medicalDbData.getCsrAmt() : "0.00", ob834Entity.getCsr_amount(), "Medical CSR amount does not match");
            softAssert.assertEquals(SharedData.getPrimaryMember().getTotalMedAmtAfterReduction().replace("$", ""), ob834Entity.getTotal_responsible_amount(), "Medical Total Responsible amount does not match");
            softAssert.assertEquals(SharedData.getPrimaryMember().getMedicalPremiumAmt().replace("$", ""), ob834Entity.getTotal_premium_amount(), "Medical Total Premium amount does not match");
        } else {
            validateAptcValuesForNonSubscriber(ob834Entity);
        }
        softAssert.assertAll();
    }

    public void validateDentalAPTCAmount(Ob834DetailsEntity ob834Entity, PlanDbData dentalDbData) {
        double amt = Double.parseDouble(SharedData.getPrimaryMember().getDentalAptcAmt().replace("$", ""));
        String ExpectedPMDentalAptcAmt = String.format("%.2f", amt);
        if (ob834Entity.getSubscriber_indicator().equals("Y")) {
            softAssert.assertEquals(ExpectedPMDentalAptcAmt, ob834Entity.getPremium_reduction_amt(), "Dental Plan premium reduction amount does not match");
            softAssert.assertEquals(dentalDbData.getCsrAmt() != null ? dentalDbData.getCsrAmt() : "0.00", ob834Entity.getCsr_amount(), "Dental CSR amount does not match");
            softAssert.assertEquals(SharedData.getPrimaryMember().getTotalDentalPremAfterReduction().replace("$", "").split("/")[0].trim(), ob834Entity.getTotal_responsible_amount(), "Dental Total Responsible amount does not match");
            softAssert.assertEquals(SharedData.getPrimaryMember().getDentalPremiumAmt().replace("$", ""), ob834Entity.getTotal_premium_amount(), "Dental Total Premium amount does not match");
        } else {
            validateAptcValuesForNonSubscriber(ob834Entity);

        }
        softAssert.assertAll();
    }

    private void validateAptcValuesForNonSubscriber(Ob834DetailsEntity ob834Entity) {
        softAssert.assertEquals(ob834Entity.getPremium_reduction_amt(), null, "Plan premium reduction amount does not match");
        softAssert.assertEquals(ob834Entity.getCsr_amount(), null, "CSR amount does not match");
        softAssert.assertEquals(ob834Entity.getPremium_reduction_type(), null, "Plan premium reduction type does not match");
        softAssert.assertEquals(ob834Entity.getTotal_responsible_amount(), null, "TotalResponsible amount does not match");
        softAssert.assertEquals(ob834Entity.getTotal_premium_amount(), null, "TotalPremium amount does not match");
        softAssert.assertAll();
    }

    public void validateMemberCountDetails(Ob834DetailsEntity ob834Entity) {
        int totalGroups = SharedData.getScenarioDetails().getTotalGroups();
        List<MemberDetails> memberList = SharedData.getMembers();
        if (totalGroups == 1 && memberList != null) {
            softAssert.assertEquals(memberList.size() + 1, ob834Entity.getTotal_enrollees(), "Total Enrollees does not match.");
            softAssert.assertEquals(memberList.size(), ob834Entity.getTotal_dependents(), "Total dependents does not match.");
            softAssert.assertEquals("1", ob834Entity.getTotal_subscribers(), "Total subscribers does not match.");
        } else if (totalGroups == 1 && memberList == null) {
            softAssert.assertEquals("1", ob834Entity.getTotal_enrollees(), "Total Enrollees does not match.");
            softAssert.assertEquals("0", ob834Entity.getTotal_dependents(), "Total dependents does not match.");
            softAssert.assertEquals("1", ob834Entity.getTotal_subscribers(), "Total subscribers does not match.");
        } else {
            //WIP
        }
        softAssert.assertAll();
    }
    /*
    public void validateRelCode(MemberDetails subscriber, Ob834DetailsEntity ob834Entity) {
        List<MemberDetails> memberList = SharedData.getMembers();
        if (memberList != null) {
            for (MemberDetails member : memberList) {
                softAssert.assertEquals(!ob834Entity.getIndividual_rel_code().equals("18") ? getCodeForRelationship(member.getRelation_to_subscriber()) : getCodeForRelationship(subscriber.getRelation_to_subscriber()), ob834Entity.getIndividual_rel_code(), "Relationship Code is Incorrect");
            }
        } softAssert.assertAll();
    } */

    public String getCurrentdate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter dateCreateUpdateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formattedDate = currentDate.format(dateCreateUpdateformat);
        return currentDate.format(formatter);
    }

    public void validateConstantFields(Ob834DetailsEntity ob834Entity) {
        String date = getCurrentdate();

        String appType = SharedData.getAppType();
        if (appType.equals("exchange")) {
            softAssert.assertEquals(ob834Entity.getInterchange_sender_id(), "CNCT4HLTHCO");
        } else if (appType.equals("coco")) {
            softAssert.assertEquals(ob834Entity.getInterchange_sender_id(), "COLOCONNECT");
        }
        softAssert.assertEquals(ob834Entity.getApplication_date(), date, "Application date does not match in ob834 entity");
        softAssert.assertEquals(ob834Entity.getUpdated_by(), "JAVA_OB834", "Ob834 updated_by does not match");
        softAssert.assertEquals(ob834Entity.getAck_requested(), "0", "Ob834 Ack_requested does not match");
        softAssert.assertEquals(ob834Entity.getUsage_indicator(), "T", "Ob834 Usage_indicator does not match");
        softAssert.assertEquals(ob834Entity.getInterchange_date(), date, "Interchange_date does not match in with date ob834 entity");
        softAssert.assertEquals(ob834Entity.getDate_created().substring(0, 10), formattedDate, "Date_created does not match with date in ob834 entity");
        softAssert.assertEquals(ob834Entity.getDate_updated().substring(0, 10), formattedDate, "Date_updated does not match with date in ob834 entity");
        softAssert.assertAll();
    }

    public void validatePersonalDetails(MemberDetails subscriber, Ob834DetailsEntity ob834Entity) {
        String dateFormatted = subscriber.getDob().substring(4, 8) + subscriber.getDob().substring(0, 2) + subscriber.getDob().substring(2, 4);
        softAssert.assertEquals(subscriber.getFirstName(), ob834Entity.getMember_first_name(), "member firstname did not match");
        softAssert.assertEquals(subscriber.getLastName(), ob834Entity.getMember_last_name(), "member firstname did not match");
        softAssert.assertEquals(subscriber.getMiddleName(), ob834Entity.getMember_middle_name(), "member middle did not match");
        softAssert.assertEquals(subscriber.getSsn(), ob834Entity.getMember_ssn(), "ssn did not match");
        softAssert.assertEquals(dateFormatted, ob834Entity.getMember_dob(), "dob did not match");
        softAssert.assertEquals(ob834Entity.getMember_gender(), subscriber.getGender().substring(0, 1), "gender did not match");
        softAssert.assertEquals(subscriber.getRace() != null ? getCodeForRace(subscriber.getRace()) : "7", ob834Entity.getMember_race(), "Race did not match");
        softAssert.assertEquals(subscriber.getPhoneNumber(), ob834Entity.getPrimary_phone(), "primary phone did not match");
        softAssert.assertEquals(subscriber.getEmailId(), ob834Entity.getPrimary_email(), "primary email did not match");
        softAssert.assertEquals(subscriber.getAlternatePhNum() != null ? subscriber.getAlternatePhNum() : subscriber.getPhoneNumber(), ob834Entity.getAlternate_phone(), "alternate phone did not match");
        softAssert.assertEquals(subscriber.getTobacco_user().equals("Yes") ? "T" : subscriber.getTobacco_user().substring(0, 1), ob834Entity.getTobacco_use(), "Tobacco usage did not match");
        softAssert.assertEquals(ob834Entity.getMarital_status_code(), "I", "Marital Status did not match");
        softAssert.assertEquals(subscriber.getSpokenLanguage(), ob834Entity.getSpoken_language(), "spoken language did not match");
        softAssert.assertEquals(subscriber.getWrittenLanguage(), ob834Entity.getWritten_language(), "written language did not match");
        softAssert.assertEquals(getCodeForRelationship(subscriber.getRelation_to_subscriber()), ob834Entity.getIndividual_rel_code(), "RelationshipCode did not match");
        softAssert.assertAll();
    }


    public void validateResidentialAddress(MemberDetails subscriber, Ob834DetailsEntity ob834Entity, DbData dbData) {
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
        softAssert.assertAll();
    }


    public void validateMailingAddress(MemberDetails subscriber, Ob834DetailsEntity ob834Entity) {
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
        softAssert.assertAll();
    }

    public void validateResponsiblePersonDetails(MemberDetails subscriber, Ob834DetailsEntity ob834Entity) {
        if (subscriber.getIsMinor()) { /*
            MemberDetails responsiblePerson = SharedData.getPrimaryMember();
            softAssert.assertEquals(ob834Entity.getResponsible_person_first_name(), responsiblePerson.getFirstName(), "responsiblePerson firstname did not match");
            softAssert.assertEquals(ob834Entity.getResponsible_person_last_name(), responsiblePerson.getLastName(), "responsiblePerson lastname did not match");
            softAssert.assertEquals(responsiblePerson.getRelation_to_subscriber().equals("Daughter") || responsiblePerson.getRelation_to_subscriber().equals("Son")  ? "S1" : "QD" ,ob834Entity.getResponsible_person_rel_code(), "responsiblePerson relationcode did not match");
            softAssert.assertEquals(ob834Entity.getResponsible_person_ssn(), responsiblePerson.getSsn(), "responsiblePerson ssn did not match");
            softAssert.assertEquals(ob834Entity.getResponsible_person_phone(), responsiblePerson.getPhoneNumber(), "responsiblePerson phonenumber did not match");
            softAssert.assertEquals(ob834Entity.getResponsible_person_email(), responsiblePerson.getEmailId(), "responsiblePerson email did not match");
            softAssert.assertEquals(responsiblePerson.getAlternatePhNum() != null ? responsiblePerson.getAlternatePhNum() : responsiblePerson.getPhoneNumber(),ob834Entity.getResponsible_person_alt_phone(),  "responsiblePerson alt phonenumber did not match");
            softAssert.assertEquals(ob834Entity.getResponsible_person_street_line1(), responsiblePerson.getResAddress().getAddressLine1(), "responsiblePerson address streetline 1 did not match");
            softAssert.assertEquals(ob834Entity.getResidence_street_line2(), responsiblePerson.getResAddress().getAddressLine2(), "responsiblePerson address streetline 2 did not match");
            softAssert.assertEquals(ob834Entity.getResponsible_person_city(), responsiblePerson.getResAddress().getAddressCity(), "responsiblePerson city did not match");
            softAssert.assertEquals(ob834Entity.getResponsible_person_st(), responsiblePerson.getResAddress().getAddressState(), "responsiblePerson state did not match");
            softAssert.assertEquals(ob834Entity.getResponsible_person_zip_code(), responsiblePerson.getResAddress().getAddressZipcode(), "responsiblePerson Zipcode did not match");
            softAssert.assertAll(); */
        } else {
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
        softAssert.assertAll();
    }

    public void validateBrokerDetails(Ob834DetailsEntity ob834Entity, DbData dbData) {
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
        softAssert.assertAll();
    }

    public void validateIncorrectEntities(MemberDetails subscriber, Ob834DetailsEntity ob834Entity) {
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
        softAssert.assertAll();
    }

    public void validateDetailsFromStep(Ob834DetailsEntity ob834Entity, Map<String, String> expectedValues) {
        softAssert.assertEquals(ob834Entity.getMaintenance_type_code(), expectedValues.get("maintenance_type_code"), "maintenance_type_code mismatched");
        softAssert.assertEquals(ob834Entity.getHd_maint_type_code(), expectedValues.get("hd_maint_type_code"), "hd_maint_type_code mismatched");
        softAssert.assertEquals(ob834Entity.getMaintenance_reas_code(), expectedValues.get("maintenance_reas_code"), "maintenance_reas_code mismatched");
        softAssert.assertEquals(ob834Entity.getAddl_maint_reason(), expectedValues.get("addl_maint_reason"), "addl_maint_reason mismatched");
        validateSepReason(ob834Entity, expectedValues);
        softAssert.assertAll();
    }

    public void validateSepReason(Ob834DetailsEntity ob834Entity, Map<String, String> expectedValues) {
        // If expectedSepReason is null and actualSepReason is blank
        if (expectedValues.get("sep_reason") == null) {
            softAssert.assertTrue(ob834Entity.getSep_reason().isEmpty(), "Expected sep_reason to be blank, but was: " + ob834Entity.getSep_reason());
        } else { //else, checking if they are equal
            softAssert.assertEquals(ob834Entity.getSep_reason(), expectedValues.get("sep_reason"), "Sep_reason mismatch");
        }

    }

    public void validateMemberExistsInPolicyTable() {
        List<PolicyTablesEntity> policyEntity = exchDbDataProvider.getDataFromPolicyTables();
        Assert.assertFalse(policyEntity.isEmpty(), "No records exists with this account number in Policy table");
        softAssert.assertAll();
    }

    public void validateOhiDetails(String memberId) {
        Boolean hasRecords = exchDbDataProvider.getDataFromOhiTables(memberId);
        Assert.assertFalse(hasRecords, "Query returned records");
        softAssert.assertAll();
    }

    public void validateOhiOptions(String memPrefix, List<Map<String, String>> expectedValues) {
        EsMemberOhiEntity actualResult = exchDbDataProvider.getOptionsFromOhiDbTables(basicActions.getMemberId(memPrefix));
        System.out.println(actualResult);

        softAssert.assertEquals(actualResult.getEmp_sponsored_covg_ind(), expectedValues.get(0).get("emp_sponsored_covg_ind"));
        softAssert.assertEquals(actualResult.getMedicare_ind(), expectedValues.get(0).get("medicare_ind"));
        softAssert.assertEquals(actualResult.getVa_health_care_ind(), expectedValues.get(0).get("va_health_care_ind"));
        softAssert.assertEquals(actualResult.getCobra_ind(), expectedValues.get(0).get("cobra_ind"));
        softAssert.assertEquals(actualResult.getRetiree_health_plan_ind(), expectedValues.get(0).get("retiree_health_plan_ind"));
        softAssert.assertEquals(actualResult.getTricare_ind(), expectedValues.get(0).get("tricare_ind"));
        softAssert.assertEquals(actualResult.getPeace_corps_ind(), expectedValues.get(0).get("peace_corps_ind"));
        softAssert.assertEquals(actualResult.getHealth_plus_plan_ind(), expectedValues.get(0).get("health_plus_plan_ind"));
        softAssert.assertEquals(actualResult.getChild_health_plan_plus_ind(), expectedValues.get(0).get("child_health_plan_plus_ind"));
        softAssert.assertEquals(actualResult.getIndividual_insurance_ind(), expectedValues.get(0).get("individual_insurance_ind"));
        softAssert.assertEquals(actualResult.getHra_ind(), expectedValues.get(0).get("hra_ind"));
        softAssert.assertEquals(actualResult.getMedicare_parta_ind(), expectedValues.get(0).get("medicare_parta_ind"));
        softAssert.assertEquals(actualResult.getMedicare_partb_ind(), expectedValues.get(0).get("medicare_partb_ind"));
        softAssert.assertEquals(actualResult.getMedicare_premium_amount(), expectedValues.get(0).get("medicare_premium_amount"));
        softAssert.assertEquals(actualResult.getMedicare_prem_parta_ind3(), expectedValues.get(0).get("medicare_prem_parta_ind3"));
        softAssert.assertEquals(actualResult.getMedicare_parta_end_soon_ind3(), expectedValues.get(0).get("medicare_parta_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getMedicare_partb_end_soon_ind3(), expectedValues.get(0).get("medicare_partb_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getMedicare_no_premium_paid_ind(), expectedValues.get(0).get("medicare_no_premium_paid_ind"));
        softAssert.assertEquals(actualResult.getIndv_ins_enrl_covg_ind3(), expectedValues.get(0).get("indv_ins_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getIndv_ins_covg_end_soon_ind3(), expectedValues.get(0).get("indv_ins_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getIndv_ins_end_voluntary_ind3(), expectedValues.get(0).get("indv_ins_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_end_soon_ind3(), expectedValues.get(0).get("emp_coverage_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_min_std_ind3(), expectedValues.get(0).get("emp_coverage_min_std_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_monthly_prem_amt(), expectedValues.get(0).get("emp_coverage_monthly_prem_amt"));
        softAssert.assertEquals(actualResult.getEnrl_emp_sponsored_covg_ind3(), expectedValues.get(0).get("enrl_emp_sponsored_covg_ind3"));
        softAssert.assertEquals(actualResult.getEmp_end_voluntary_ind3(), expectedValues.get(0).get("emp_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_family_plan_offered_ind3(), expectedValues.get(0).get("emp_coverage_family_plan_offered_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_family_prem_amount(), expectedValues.get(0).get("emp_coverage_family_prem_amount"));
        softAssert.assertEquals(actualResult.getCobra_enrl_covg_ind3(), expectedValues.get(0).get("cobra_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getCobra_covg_end_soon_ind3(), expectedValues.get(0).get("cobra_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getCobra_end_voluntary_ind3(), expectedValues.get(0).get("cobra_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getVa_enrl_covg_ind3(), expectedValues.get(0).get("va_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getVa_covg_end_soon_ind3(), expectedValues.get(0).get("va_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getVa_end_voluntary_ind3(), expectedValues.get(0).get("va_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getRetiree_enrl_covg_ind3(), expectedValues.get(0).get("retiree_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getRetiree_covg_end_soon_ind3(), expectedValues.get(0).get("retiree_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getRetiree_end_voluntary_ind3(), expectedValues.get(0).get("retiree_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getTricare_enrl_covg_ind3(), expectedValues.get(0).get("tricare_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getTricare_covg_end_soon_ind3(), expectedValues.get(0).get("tricare_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getTricare_end_voluntary_ind3(), expectedValues.get(0).get("tricare_end_voluntary_ind3"));
        softAssert.assertEquals(actualResult.getPeace_corps_enrl_covg_ind3(), expectedValues.get(0).get("peace_corps_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getPeace_corps_covg_end_soon_ind3(), expectedValues.get(0).get("peace_corps_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getCurr_year_esi_afford_ind3(), expectedValues.get(0).get("curr_year_esi_afford_ind3"));
        softAssert.assertEquals(actualResult.getNext_year_esi_afford_ind3(), expectedValues.get(0).get("next_year_esi_afford_ind3"));
        softAssert.assertEquals(actualResult.getCurr_year_esi_family_afford_ind3(), expectedValues.get(0).get("curr_year_esi_family_afford_ind3"));
        softAssert.assertEquals(actualResult.getNext_year_esi_family_afford_ind3(), expectedValues.get(0).get("next_year_esi_family_afford_ind3"));
        softAssert.assertAll();
    }

    public void validateHraOptions(List<Map<String, String>> expectedValues) {
        EsMemberHraEntity actualResult = exchDbDataProvider.getOptionsFromHraDbTables();
        System.out.println(actualResult);

        softAssert.assertEquals(actualResult.getPlan_year(), expectedValues.get(0).get("plan_year"));
        softAssert.assertEquals(actualResult.getEmplr_hra_ctb(), expectedValues.get(0).get("emplr_hra_ctb"));
        softAssert.assertEquals(actualResult.getHra_type(), expectedValues.get(0).get("hra_type"));
        softAssert.assertEquals(actualResult.getEmplr_ctb_optout_ind(), expectedValues.get(0).get("emplr_ctb_optout_ind"));
        softAssert.assertEquals(actualResult.getHra_not_affordable_ind(), expectedValues.get(0).get("hra_not_affordable_ind"));
        softAssert.assertAll();
    }

    public void ValidatePriorSubscriber(MemberDetails subscriber, Ob834DetailsEntity ob834Entity) {
        softAssert.assertEquals(subscriber.getPrior_subscriber_id(), ob834Entity.getPrior_subscriber_id(), "Prior subscriber id did not match");
        softAssert.assertAll();
    }


    public void validatePolicyDqCheck(int keysetSize) {
        Map<String, String> policyAhId = exchDbDataProvider.getPolicyDqCheckAndPolicyAhId();
        softAssert.assertEquals(policyAhId.keySet().size(), keysetSize, "Policy Ah Id keyset size does not match");
        for (String key : policyAhId.keySet()) {
            softAssert.assertEquals(policyAhId.get(key), "0", "Doesn't match policyAhId.get(key)");
        }
        softAssert.assertAll();
    }

    public void validateBookOfBusinessQ(String eventType) {
        getCurrentdate();
        List<BookOfBusinessQEntity> bookOfBusinessQList = exchDbDataProvider.getBookOfBusinessQ(eventType);
        List<String> policyIdListFromBookOfBusinessDb = new ArrayList<>();
        List<String> applicationIdListFromBob = new ArrayList<>();

        // WIP - get these from existing policyTables instead of new tables/queries.
        List<String> applicationIdListFromPolicyAh = exchDbDataProvider.getApplicationId();
        List<String> policyIdFromPolicyDB = exchDbDataProvider.getPolicyId();

        for (BookOfBusinessQEntity bookOfBusinessQEntity : bookOfBusinessQList) {
            softAssert.assertEquals(bookOfBusinessQEntity.getExchange(), "c4hco_direct_exchange", "Bob exchange mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getRouting_key(), "book_of_business_q", "Bob routing key mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getPolicyplanyr(), String.valueOf(currentYear), "Bob plan year mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getStatus(), "PROCESSED", "BOB Status mismatch");
            softAssert.assertTrue(bookOfBusinessQEntity.getCreated_ts().contains(formattedDate), "Bob created date mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getEventtype(), eventType, "Bob, event type updated does not match " + eventType);
            policyIdListFromBookOfBusinessDb.add(bookOfBusinessQEntity.getPolicyid());
            applicationIdListFromBob.add(bookOfBusinessQEntity.getApplicationid());
        }
        softAssert.assertEquals(applicationIdListFromPolicyAh.size(), bookOfBusinessQList.size(), "No of records does not match for event type " + eventType);
        softAssert.assertTrue(new HashSet<>(applicationIdListFromBob).containsAll(applicationIdListFromPolicyAh), "application id mismatch");
        softAssert.assertTrue(new HashSet<>(policyIdListFromBookOfBusinessDb).containsAll(policyIdFromPolicyDB), "Policy Id mismatch ");
        softAssert.assertAll();

    }

    public void validateAccountHolderNameFromBOB() {
        List<String> acct_holderBOB = exchDbDataProvider.getAccount_holder_fn();
        softAssert.assertEquals(SharedData.getMembers().get(0).getFirstName(), acct_holderBOB.get(0));
        softAssert.assertAll();
    }

    public void verifyUpdatedEmailAddressBOB() {
        List<String> clientEmailBOB = exchDbDataProvider.getClientEmailInBoB();
        softAssert.assertEquals(SharedData.getPrimaryMember().getEmailId(), clientEmailBOB.get(0));
        softAssert.assertAll();
    }

    public void validateBrokerAuthorizationBob(String expectedBrokerName) {
        String clientFirstName = SharedData.getPrimaryMember().getFirstName();
        List<String> brokerAuthBOB = exchDbDataProvider.getBrokerAuthorizationInBoB(clientFirstName);
        softAssert.assertEquals(brokerAuthBOB.get(0), expectedBrokerName);
        softAssert.assertAll();
    }

    public void validateApplicationSubmissionBob() {
        List<String> applicationSubmissionBOB = exchDbDataProvider.getApplicationSubmissionInBoB();
        softAssert.assertEquals(applicationSubmissionBOB.size(), 1);
        softAssert.assertAll();
    }

    public void validatePolicySubmissionBob(int expectedRecords, int coverageType) {
        List<String> policySubmissionBOB = exchDbDataProvider.getPolicySubmissionInBoB(coverageType);
        softAssert.assertEquals(policySubmissionBOB.size(), expectedRecords);
        softAssert.assertAll();
    }

    public void validateNoMedicalPolicySubmissionBob() {
        Boolean hasRecords = exchDbDataProvider.getNoMedicalPolicySubmissionInBoB();
        Assert.assertFalse(hasRecords, "Query returned records");
        softAssert.assertAll();
    }

    public void verifyAgencyCommissionTinDb() {
        String expectedAgencyTin = SharedData.getAgencyOwner().getAgencyTin();
        List<String> agencyTinDb = exchDbDataProvider.getAgencyCommissionTinDb();
        softAssert.assertEquals(agencyTinDb.get(0), expectedAgencyTin);
        softAssert.assertAll();
    }

    public void verifyExchHouseholdIdDb() {
        Boolean hasRecords = exchDbDataProvider.getExchHouseholdIdBoB();
        Assert.assertTrue(hasRecords, "Query returned no records");
        softAssert.assertAll();
    }

    public void verifyBrokerAuthorizationStatusDb() {
        List<String> authorizationStatusDB = exchDbDataProvider.getBrokerAuthorizationStatusBoB();
        Assert.assertEquals(authorizationStatusDB.get(0), "AUTHORIZATION_REVOKED_CLIENT");
        softAssert.assertAll();
    }

    public void verifyBrokerAuthorizationTypeDb(String expectedBrokerType) {
        List<String> authorizationStatusDB = exchDbDataProvider.getBrokerAuthorizationTypeBoB();
        Assert.assertEquals(authorizationStatusDB.get(0), expectedBrokerType);
        softAssert.assertAll();
    }

    public void validateHraAhOptions(List<Map<String, String>> expectedValues) {
        EsMemberHraAhEntity actualResult = exchDbDataProvider.getOptionsFromHraAhDbTables();
        System.out.println(actualResult);

        softAssert.assertEquals(actualResult.getPlan_year(), expectedValues.get(0).get("plan_year"));
        softAssert.assertEquals(actualResult.getEmplr_hra_ctb(), expectedValues.get(0).get("emplr_hra_ctb"));
        softAssert.assertEquals(actualResult.getHra_type(), expectedValues.get(0).get("hra_type"));
        softAssert.assertEquals(actualResult.getEmplr_ctb_optout_ind(), expectedValues.get(0).get("emplr_ctb_optout_ind"));
        softAssert.assertEquals(actualResult.getHra_not_affordable_ind(), expectedValues.get(0).get("hra_not_affordable_ind"));
        softAssert.assertAll();
    }

    public void validateDatabaseEmail() {
        EsHouseholdContactEntity actualResult = exchDbDataProvider.getEsHouseholdContactDetails();

        softAssert.assertEquals(actualResult.getEmail(), SharedData.getPrimaryMember().getEmailId());
        System.out.println("Account  Email " + SharedData.getPrimaryMember().getEmailId());
        System.out.println("Database Email " + actualResult.getEmail());
        softAssert.assertAll();
    }

    
    public void validateDatabaseMedicalPlanList() {
        List<String> medicalPlanList = exchDbDataProvider.getDBMedicalPlanList();
        List<String> expectedMedicalPlanList = SharedData.getMedicalPlansList();
        softAssert.assertEquals(medicalPlanList, expectedMedicalPlanList, "Medical plan lists do not match!");
        softAssert.assertAll();}
    public void validateCurrentDentalPlanNameForTheYear(String year) {
        String dbdentalPlanName = exchDbDataProvider.getPlanMarketingName(year);
        softAssert.assertEquals(dbdentalPlanName,SharedData.getManagePlanDentalMedicalPlan().getPlanMarketingName());
        softAssert.assertAll();

    }

    public void validateCurrentDentalPolicyStartAndEndDateForTheYearDB() {
        String [] policyDate = exchDbDataProvider.getDentalPolicyDate();

        String dateStr = policyDate[0];
        String dateEnd = policyDate[1];
        String formattedDateSTR = basicActions.changeDateFormat(dateStr ,"yyyy-MM-dd","MM/dd/yyyy");
        String formattedDateEnd = basicActions.changeDateFormat(dateEnd ,"yyyy-MM-dd","MM/dd/yyyy");
        String coverageDate = formattedDateSTR+" to "+formattedDateEnd;
        softAssert.assertTrue(SharedData.getManagePlanDentalMedicalPlan().getPolicyCoverageDate().contains(coverageDate));
        softAssert.assertAll();
    }


    public void validateDatabaseRaceEthnicity(String expectedRaceEthnicity, String expectedRaceOtherText) {
        String[] dbValues = exchDbDataProvider.getEsMemberRaceEthnicityDetails();
        softAssert.assertEquals(dbValues[0], expectedRaceEthnicity, "Race/Ethnicity mismatch");

        if (expectedRaceOtherText.equals("null")) {
            softAssert.assertNull(dbValues[1], "Race Other Text is null");
        } else {
            softAssert.assertEquals(dbValues[1], expectedRaceOtherText, "Race Other Text mismatch");
        }}

    public void validateTheLatestApplicationDateForTheYearDB() {
       String medLatestAppDateDB = exchDbDataProvider.getMedLatestApplicationDate();
       softAssert.assertTrue(medLatestAppDateDB.contains(SharedData.getManagePlanDentalMedicalPlan().getMedLatestAppDate()));
        softAssert.assertAll();
    }

    public void validateTheSecondMedicalPoliciyForTheYearDB(String year) {
        String[] medSecondPolicy = exchDbDataProvider.getMedSecondPolicy(year);
        String inputDate = medSecondPolicy[1];
        String formattedDate = basicActions.changeDateFormat(inputDate,"yyyy-MM-dd","MM/dd/yyyy");
        System.out.println("Formatted Date: " + formattedDate);
        String SecondMedicalPolicyDB = medSecondPolicy[0]+ " - " + formattedDate +" - " +medSecondPolicy[2];
        softAssert.assertEquals(SecondMedicalPolicyDB,SharedData.getManagePlanDentalMedicalPlan().getSelectMedSecondPolicyDrp());
        softAssert.assertAll();
    }

    public void validateTheSecondDentalPoliciyForTheYearDB(String year) {
        String[] denSecondPolicy = exchDbDataProvider.getDentSecondPolicy(year);
        String inputDate = denSecondPolicy[1];
        String formattedDate = basicActions.changeDateFormat(inputDate,"yyyy-MM-dd","MM/dd/yyyy");
        System.out.println("Formatted Date: " + formattedDate);
        String SecondMedicalPolicyDB = denSecondPolicy[0]+ " - " + formattedDate +" - " +denSecondPolicy[2];
        softAssert.assertEquals(SecondMedicalPolicyDB,SharedData.getManagePlanDentalMedicalPlan().getSelectDenSecondPolicyDrp());
        softAssert.assertAll();
    }

    public void validateMVR(List<Map<String, String>> expectedValues) {
        for (int i = 0; i < expectedValues.size(); i++) {
            Map<String, String> row = expectedValues.get(i);
            String manualVerificationType = row.get("manual_verification_type");

            EsManualVerifRequestEntity actualResult = exchDbDataProvider.getEsMVR_options(manualVerificationType);
            System.out.println(actualResult);

            softAssert.assertEquals(actualResult.getManual_verification_type(), manualVerificationType, "Validation failed for manual_verification_type at row " + (i + 1));
            if (row.containsKey("manual_verif_status")) {
                softAssert.assertEquals(actualResult.getManual_verif_status(), row.get("manual_verif_status"), "Validation failed for manual_verif_status at row " + (i + 1));
            }
            if (row.containsKey("manual_verif_date_set")) {
                softAssert.assertTrue(actualResult.getManual_verif_date_set().contains(addDaysDate(Integer.parseInt(row.get("manual_verif_date_set")))), "Validation failed for manual_verif_date_set at row " + (i + 1));
            }
            if (row.containsKey("manual_verif_due_date")) {
                softAssert.assertTrue(actualResult.getManual_verif_due_date().contains(addDaysDate(Integer.parseInt(row.get("manual_verif_due_date")))), "Validation failed for manual_verif_due_date at row " + (i + 1));
            }
            if (row.containsKey("manual_verif_date_expired")) {
                softAssert.assertTrue(actualResult.getManual_verif_date_expired().contains(addDaysDate(Integer.parseInt(row.get("manual_verif_date_expired")))), "Validation failed for manual_verif_date_expired at row " + (i + 1));
            }
            if (row.containsKey("manual_verif_date_closed")) {
                softAssert.assertEquals(actualResult.getManual_verif_date_closed(), row.get("manual_verif_date_closed"), "Validation failed for manual_verif_date_closed at row " + (i + 1));
            }
        }
        softAssert.assertAll();
    }

    public String addDaysDate(int daysAdded) {
        LocalDate currentDate = LocalDate.now();
        LocalDate newDate = currentDate.plusDays(daysAdded);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return newDate.format(outputFormatter);
    }

    public void verifySsaResponseCodeDb(String code, String memPrefix){
        EsSsaVerificationReqEntity actualResult = exchDbDataProvider.getSsaResponseCode(basicActions.getMemberId(memPrefix));
        System.out.println(actualResult);
        softAssert.assertEquals(actualResult.getRsp_tx_return_code(),code);
        softAssert.assertAll();
    }




}
