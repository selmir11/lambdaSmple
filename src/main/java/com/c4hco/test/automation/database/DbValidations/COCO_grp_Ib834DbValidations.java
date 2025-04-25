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
import static com.c4hco.test.automation.utils.Race.getCodeForRace;

public class COCO_grp_Ib834DbValidations {
        DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
        SoftAssert softAssert = new SoftAssert();
        BasicActions basicActions = new BasicActions();
        MemberDetails primaryMember = SharedData.getPrimaryMember();
        List<Ib834Entity> ib834MedEntities = new ArrayList<>();
        List<MemberDetails> subscribers = new ArrayList<>();
        Set<Map<String, DbData>> dbDataMapList = new HashSet<>();
        List<Map<String, PlanDbData>> medicalPlanDbDataMapList = new ArrayList<>();
        Map<String, PlanDbData> medicalPlanDbDataMap = new HashMap<>();
        Map<String, DbData> dbDataMap = new HashMap<>();
        List<PolicyTablesEntity> medicalPolicyEnitities = new ArrayList<>();

        public void coco_ib834DbRecordsValidations(List<Map<String, String>> expectedValues) {
                setCocoIb834Data();
                ib834MedRecordsValidations(expectedValues);
                softAssert.assertAll();
    }

        private void ib834MedRecordsValidations(List<Map<String, String>> expectedValues){
        subscribers = basicActions.getAllSubscribers();
        for (Ib834Entity ib834Entity : ib834MedEntities) {
            System.out.println("Validating the entity for ::::"+ib834Entity.getMember_first_name());
            if (ib834Entity.getSubscriber_indicator().equals("Y")) {
                for(MemberDetails subscriber: subscribers){
                    setMedicalFileName(ib834Entity);
                    if(subscriber.getFirstName().equals(ib834Entity.getMember_first_name())){
                        subscriberOnlyMedDenFields(ib834Entity, subscriber);
                        validateMedDenForSubscriberAndMem(ib834Entity, subscriber);
                        break;
                    }
                }
            } else {
                validateDependentMedDenDetails(ib834Entity);
            }
            medDenValidationsCommonForAllMem(ib834Entity);
            medValidationsCommonForAllMembers(ib834Entity, expectedValues);
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
                softAssert.assertNull(ib834Entity.getPrimary_email(), "primary email did not match");
                softAssert.assertNull(ib834Entity.getPrimary_phone(), "primary phone did not match");
                softAssert.assertNull(ib834Entity.getSpoken_language(), "spoken language did not match");
                softAssert.assertNull(ib834Entity.getWritten_language(), "written language did not match");
            }
        }
    }


        private void validateMemberOnlyMedDenFields(Ib834Entity ib834Entity){
        softAssert.assertNull(ib834Entity.getPremium_reduction_amt(), "Member Medical Plan premium reduction amount does not match");
        softAssert.assertNull(ib834Entity.getCsr_amount(), "Member Medical CSR amount does not match");
        softAssert.assertNull(ib834Entity.getTotal_responsible_amount(), "MemberMedical Total Responsible amount does not match");
        softAssert.assertNull(ib834Entity.getTotal_premium_amount(), "Member Medical Total Premium amount does not match");
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
        softAssert.assertEquals(String.valueOf(SharedData.getPrimaryMember().getAccount_id()),ib834Entity.getSsap_id(), "Account id and ssap_id mismatch" );
        softAssert.assertEquals(member.getPrior_subscriber_id(), ib834Entity.getPrior_subscriber_id(), "Prior subscriber id did not match for "+member.getFirstName());
        softAssert.assertEquals(SharedData.getExchPersonId().get(member.getFirstName()), ib834Entity.getMember_id(), "Member Id did not match for "+member.getFirstName());
        validateSubscriberId(ib834Entity, member);
        validatePersonalDetails(ib834Entity, member);
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
        softAssert.assertAll("Mailing Address did not match for "+subscriber.getFirstName());
    }

        private void validateBrokerDetails(Ib834Entity ib834Entity) {
        BrokerDetails broker = SharedData.getBroker();
        getDbDataMap(primaryMember.getFirstName());
        if (SharedData.getHasBroker()) {
            softAssert.assertEquals(broker.getBroker_name(), ib834Entity.getTpa_or_broker_name(), "Broker name is incorrect");
            softAssert.assertEquals(ib834Entity.getTpa_or_broker_id(), dbDataMap.get(primaryMember.getFirstName()).getBrokerTinNum().replace("-",""), "Broker Tin Number is incorrect");
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
            if(ib834Entity.getSubscriber_indicator().equals("Y")) {
                validateResPerDetailsForMinorSubscriber(ib834Entity);
            }else{
                validateResPerDetailsForMinor(ib834Entity, member);
            }
        }
    }
        private void validateResPerDetailsForMinorSubscriber(Ib834Entity ib834Entity){
        MemberDetails primaryMember = SharedData.getPrimaryMember();
        softAssert.assertEquals(ib834Entity.getResponsible_person_first_name(), primaryMember.getFirstName(), "Responsible person first name mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_last_name(), primaryMember.getLastName(), "Responsible person last name mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_rel_code(), "S1", "Responsible person rel_code mismatch");
        softAssert.assertNull(ib834Entity.getResponsible_person_ssn(), "Responsible person SSN is not null");
        softAssert.assertEquals(ib834Entity.getResponsible_person_phone(), primaryMember.getPhoneNumber() ,"Responsible person phone mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_email(), primaryMember.getEmailId(),"Responsible person email mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_alt_phone(), primaryMember.getPhoneNumber(),"Responsible person alt phone");
        softAssert.assertEquals(ib834Entity.getResponsible_person_street_line1(), primaryMember.getMailingAddress().getAddressLine1(), "Responsible person mailing street line 1");
        softAssert.assertEquals(ib834Entity.getResidence_street_line2(),primaryMember.getMailingAddress().getAddressLine2() , "Responsible person mailing street line 2");
        softAssert.assertEquals(ib834Entity.getResponsible_person_city(), primaryMember.getMailingAddress().getAddressCity(), "Responsible person mailing city mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_st(), primaryMember.getMailingAddress().getAddressState(),"State mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_zip_code(),primaryMember.getMailingAddress().getAddressZipcode(), "Zipcode mismatch");
        softAssert.assertAll();
    }

        private void validateResPerDetailsForMinor(Ib834Entity ib834Entity, MemberDetails member) {
        MemberDetails subscriber = basicActions.getMember(getName(ib834Entity, member));
        softAssert.assertEquals(ib834Entity.getResponsible_person_first_name(), subscriber.getFirstName());
        softAssert.assertEquals(ib834Entity.getResponsible_person_last_name(), subscriber.getLastName());
        softAssert.assertEquals(ib834Entity.getResponsible_person_rel_code(), "1", "Responsible_person_rel_code mismatch");
        softAssert.assertNull(ib834Entity.getResponsible_person_ssn(), "Responsible_person_ssn mistatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_phone(), subscriber.getAlternatePhNum(),"Responsible person phone mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_email(), subscriber.getEmailId(),"Responsible person email id mismatch" );
        softAssert.assertEquals(ib834Entity.getResponsible_person_alt_phone(), subscriber.getAlternatePhNum(), "Responsible person alternate phone mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_street_line1(), subscriber.getMailingAddress().getAddressLine1(), "Responsible person mail addressline 1 mismatch");
        softAssert.assertEquals(ib834Entity.getResidence_street_line2(), subscriber.getMailingAddress().getAddressLine2(),"Responsible person mail addressline 2 mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_city(), subscriber.getMailingAddress().getAddressCity(), "Responsible person mail city mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_st(), subscriber.getMailingAddress().getAddressState(),"Responsible person mail state mismatch" );
        softAssert.assertEquals(ib834Entity.getResponsible_person_zip_code(), subscriber.getMailingAddress().getAddressZipcode(), "Responsible person mail zipcode mismatch");
    }

        private void validateResPersonDetailsForMember(Ib834Entity ib834Entity){
        softAssert.assertEquals(ib834Entity.getResponsible_person_first_name(), null, "Responsible_person_first_name mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_last_name(), null, "Responsible_person_last_name mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_rel_code(), null, "Responsible_person_rel-code mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_ssn(), null,"Responsible_person_ssn mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_phone(), null,"Responsible_person_phone");
        softAssert.assertEquals(ib834Entity.getResponsible_person_email(), null,"Responsible_person_email mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_alt_phone(), null,"Responsible_person_alt_phone mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_street_line1(), null, "Responsible_person_street_line1 mismatch");
        softAssert.assertEquals(ib834Entity.getResidence_street_line2(), null, "Responsible_person_street_line2 mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_city(), null, "Responsible_person_city mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_st(), null, "Responsible_person_street mismatch");
        softAssert.assertEquals(ib834Entity.getResponsible_person_zip_code(), null, "Responsible_person_zip_code mismatch");
    }

        private void validatePersonalDetails(Ib834Entity ib834Entity, MemberDetails member) {
        String dateFormatted = member.getDob().substring(4, 8) + member.getDob().substring(0, 2) + member.getDob().substring(2, 4);
        softAssert.assertEquals(member.getFirstName(), ib834Entity.getMember_first_name(), "member firstname did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getLastName(), ib834Entity.getMember_last_name(), "member firstname did not match for "+member.getFirstName());
        softAssert.assertTrue(ib834Entity.getMember_middle_name() == null || ib834Entity.getMember_middle_name().isEmpty()
                || ib834Entity.getMember_middle_name().equals(member.getMiddleName()),"Member middle name did not match");
        softAssert.assertEquals(dateFormatted, ib834Entity.getMember_dob(), "dob did not match for "+member.getFirstName());
        softAssert.assertEquals(ib834Entity.getMember_gender(), member.getGender().substring(0, 1), "gender did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getTobacco_user().equals("Yes") ? "T" : member.getTobacco_user().substring(0, 1), ib834Entity.getTobacco_use(), "Tobacco usage did not match for "+member.getFirstName());
        softAssert.assertTrue(ib834Entity.getMarital_status_code().equals("I") ||ib834Entity.getMarital_status_code().isEmpty(), "Marital Status did not match for "+member.getFirstName());
        //  softAssert.assertEquals(getCodeForRelationship(member.getRelation_to_subscriber()), ib834Entity.getIndividual_rel_code(), "RelationshipCode did not match for "+member.getFirstName());
        softAssert.assertEquals(member.getSsn()!=null? member.getSsn(): "000000000", ib834Entity.getMember_ssn(), "ssn did not match for "+member.getFirstName());
        softAssert.assertEquals(getCodeForRace(member.getRace()), ib834Entity.getMember_race(), "Race did not match");
        softAssert.assertAll("Personal Details for Member::"+member.getFirstName()+" did not match");
    }

        private void validateSponsorId(Ib834Entity ib834Entity) {
        MemberDetails member = basicActions.getMember(ib834Entity.getMember_first_name());
        MemberDetails subscriber = basicActions.getMember(getName(ib834Entity, member));
        softAssert.assertEquals(SharedData.getExchPersonId().get(subscriber.getFirstName()), ib834Entity.getSponsor_id(), "Sponsor_id did not match");
    }

        private void validateConstantFields(Ib834Entity ib834Entity) {
        String date = LocalDate.now().toString();

        String appType = SharedData.getAppType();
        if (appType.equals("exchange")) {
            softAssert.assertEquals(ib834Entity.getInterchange_receiver_id(), "CNCT4HLTHCO");
        } else if (appType.equals("coco")) {
            softAssert.assertEquals(ib834Entity.getInterchange_receiver_id(), "COLOCONNECT");
        }
        softAssert.assertEquals(ib834Entity.getCreated_by(), "JAVA_IB834", "Ib834 updated_by does not match");
        softAssert.assertEquals(ib834Entity.getEdi_status(), "EDI_COMPLETE", "Edi status mismatch");
        softAssert.assertEquals(ib834Entity.getAck_requested(), "0", "Ib834 Ack_requested does not match");
        softAssert.assertEquals(ib834Entity.getUsage_indicator(), "T", "Ib834 Usage_indicator does not match");
        softAssert.assertEquals("20"+ib834Entity.getInterchange_date(), date.replace("-", ""), "Interchange_date does not match in with date Ib834 entity");
        softAssert.assertEquals(ib834Entity.getCreated_ts().substring(0, 10), date, "Date_created does not match with date in Ib834 entity");
        softAssert.assertEquals(ib834Entity.getUpdated_ts().substring(0, 10), date, "Date_updated does not match with date in Ib834 entity");
    }

        private void medValidationsCommonForAllMembers(Ib834Entity ib834Entity, List<Map<String, String>> expectedValues) {
        MemberDetails member = basicActions.getMember(ib834Entity.getMember_first_name());
        String name = getName(ib834Entity, member);
        getMedicalPlanDbDataMap(name);
        String formatPlanStartDate = SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyStartDate().replaceAll("-", "");
        String formatMedicalPlanEndDate = SharedData.getExpectedCalculatedDates_medicalPlan().getPolicyEndDate().replaceAll("-", "");

        softAssert.assertEquals(ib834Entity.getInterchange_sender_id(), ib834Entity.getFilename().split("_")[1], "Medical Sender Id mismatch");

        softAssert.assertEquals(ib834Entity.getHios_plan_id(), medicalPlanDbDataMap.get(name).getBaseId(), "Hios id did not match!");
        softAssert.assertEquals(ib834Entity.getInsurer_name(), medicalPlanDbDataMap.get(name).getIssuerName(), "Insurer Name did not match!");
        softAssert.assertEquals(ib834Entity.getInsurer_id(), medicalPlanDbDataMap.get(name).getIssuerId(), "Insurer Id did not match!");

        softAssert.assertEquals(ib834Entity.getBenefit_begin_date(), formatPlanStartDate, "Medical plan start date is not correct");
        softAssert.assertEquals(ib834Entity.getBenefit_end_date(), formatMedicalPlanEndDate, "Medical plan end date is not correct");
        softAssert.assertNull(ib834Entity.getFinancial_effective_date(), "Financial start date is not null");

        validateDetailsFromStep(ib834Entity, expectedValues.get(0));
    }

        private void medDenValidationsCommonForAllMem(Ib834Entity ib834Entity) {
        MemberDetails member = basicActions.getMember(ib834Entity.getMember_first_name());
        String name = getName(ib834Entity, member);
        validateConstantFields(ib834Entity);
        validateBrokerDetails(ib834Entity);
        validateResponsiblePersonDetails(ib834Entity, member);
        getDbDataMap(name);
        String enrollees = getTotalEnrollees(ib834Entity);
        softAssert.assertEquals("1", ib834Entity.getTotal_subscribers(), "total subscribers did not match");
        softAssert.assertNull(ib834Entity.getRate_area(), "Rating area is not null");
        softAssert.assertEquals(ib834Entity.getCsr_level(), dbDataMap.get(name).getCsrLevel(), "CSR level does not match");
        softAssert.assertEquals(enrollees, ib834Entity.getTotal_enrollees().trim(), "Total enrollees does not match");
        softAssert.assertEquals(String.valueOf(Integer.parseInt(enrollees) - 1), ib834Entity.getTotal_dependents().toString().trim(), "total dependents did not match");
        validateSponsorId(ib834Entity);
        softAssert.assertAll();
    }


        private String getTotalEnrollees(Ib834Entity ib834Entity){
        return ib834Entity.getInsurance_line_code().equals("HLT")? basicActions.getTotalMedEnrollees(ib834Entity.getMember_first_name()) : basicActions.getTotalDentalEnrollees(ib834Entity.getMember_first_name());
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

        private void subscriberOnlyMedDenFields(Ib834Entity ib834MedEntity, MemberDetails subscriber){
        if(basicActions.getAge(subscriber.getDob())<18) {
            softAssert.assertEquals(ib834MedEntity.getPlan_sponsor_name(), SharedData.getPrimaryMember().getSignature(), "plan sponsor name mismatch for minor");
        }else {
            softAssert.assertEquals(ib834MedEntity.getPlan_sponsor_name(), subscriber.getSignature(), "plan sponsor name did not match");
        }
        softAssert.assertEquals(subscriber.getAlternatePhNum() != null ? subscriber.getAlternatePhNum() : subscriber.getPhoneNumber(), ib834MedEntity.getAlternate_phone(), "alternate phone did not match");
        softAssert.assertEquals(ib834MedEntity.getSubscriber_id(), ib834MedEntity.getMember_id(), "Subscriber_id and Member_id in ib834 entity does not match");
        softAssert.assertEquals(subscriber.getIsSubscriber(), "Y", "Subscriber indicator did not match for "+subscriber.getFirstName());
        softAssert.assertEquals(subscriber.getEmailId(), ib834MedEntity.getPrimary_email(), "primary email did not match");
        softAssert.assertEquals(subscriber.getPhoneNumber(), ib834MedEntity.getPrimary_phone(), "primary phone did not match");
        softAssert.assertEquals(subscriber.getSpokenLanguage(), ib834MedEntity.getSpoken_language(), "spoken language did not match");
        softAssert.assertEquals(subscriber.getWrittenLanguage(), ib834MedEntity.getWritten_language(), "written language did not match");
        validateResidentialAddress(ib834MedEntity, subscriber);

        if(subscriber.getMailingAddress()!=null&&!subscriber.getMailingAddress().equals(subscriber.getResAddress())){
            validateMailingAddress(ib834MedEntity, subscriber);
        } else {
            validateMailingAddressIsNull(ib834MedEntity, subscriber);
        }
    }

        private void validateDetailsFromStep(Ib834Entity ib834Entity, Map<String, String> expectedValues) {
        softAssert.assertEquals(ib834Entity.getMaintenance_type_code(), expectedValues.get("maintenance_type_code"), "maintenance_type_code mismatched");
        softAssert.assertEquals(ib834Entity.getHd_maint_type_code(), expectedValues.get("hd_maint_type_code"), "hd_maint_type_code mismatched");
        softAssert.assertEquals(ib834Entity.getMaintenance_reas_code(), expectedValues.get("maintenance_reas_code"), "maintenance_reas_code mismatched");
        softAssert.assertEquals(ib834Entity.getAddl_maint_reason(), expectedValues.get("addl_maint_reason")!=null? expectedValues.get("addl_maint_reason").replace(" or ", "|") : expectedValues.get("addl_maint_reason"), "addl_maint_reason mismatched");
    }

        private void setCocoIb834Data() {
        subscribers = basicActions.getAllSubscribers();

        List<String> medGrpCtrlNums = SharedData.getMedGroupCtlNumbers();
        Set<String> uniqueMedGrpCtrlNum = new HashSet<>(medGrpCtrlNums);
        for(String medGrpCtrlNum: uniqueMedGrpCtrlNum){
            ib834MedEntities.addAll(exchDbDataProvider.getIb834Details(medGrpCtrlNum));
        }
        SharedData.setIb834MedDetailsEntities(ib834MedEntities);

        dbDataMapList = SharedData.getDbDataNew();
        medicalPlanDbDataMapList = SharedData.getMedicalPlanDbDataNew();

        SharedData.setMedicalIb834FileName(ib834MedEntities.get(0).getFilename());

        medicalPolicyEnitities = SharedData.getMedicalPolicyTablesEntities();
    }

        private void getMedicalPlanDbDataMap(String name){
        for(Map<String, PlanDbData> map: medicalPlanDbDataMapList){
            if(map.containsKey(name)){
                medicalPlanDbDataMap = map;
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
