package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.EsMemberOhiEntity;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class DbValidations {
  DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
  SoftAssert softAssert = new SoftAssert();

    public void validateDataFromPolicyTables(){

      MemberDetails subscriber = SharedData.getPrimaryMember();
      List<PolicyTablesEntity> policyEntities = exchDbDataProvider.getDataFromPolicyTables();

      for(PolicyTablesEntity policyTablesEntity: policyEntities){

        if(policyTablesEntity.getCoverage_type().equals("1")){

          // validate medical specific details
//        softAssert.assertEquals(subscriber.getMedicalPlanStartDate(), policyTablesEntity.getPolicy_start_date(), "Policy start date did not match");
//        softAssert.assertEquals(subscriber.getMedicalPlanEndDate(), policyTablesEntity.getPolicy_end_date(), "Policy end date did not match");
//        softAssert.assertEquals(subscriber.getFinancialStartDate(), policyTablesEntity.getFinancial_period_start_date(), "Financial start date did not match");
//        softAssert.assertEquals(subscriber.getFinancialEndDate(), policyTablesEntity.getFinancial_period_end_date(), "Policy start date did not match");
          // financial period start date or member financial start date?
        } else{
          // validate dental specific detail
        }

        // To DO:: Add more validations here
        softAssert.assertEquals( String.valueOf(subscriber.getAccount_id()), policyTablesEntity.getAccount_id(), "acc id did not match");
        softAssert.assertEquals( subscriber.getFirstName(), policyTablesEntity.getFirst_name(), "First Name did not match");
        softAssert.assertEquals( subscriber.getLastName(), policyTablesEntity.getLast_name(), "Last Name did not match");
        softAssert.assertTrue(policyTablesEntity.getPolicy_status().equals("SUBMITTED"));
        softAssert.assertAll();
      }
    }

    public void validateOb834FromDb(List<Map<String, String>> expectedValues){
      MemberDetails subscriber = SharedData.getPrimaryMember();


        List<Ob834DetailsEntity> ob834DetailsEntities = exchDbDataProvider.getOb83Db4Details();
      SharedData.setOb834DetailsEntities(ob834DetailsEntities);


      for(Ob834DetailsEntity ob834Entity: ob834DetailsEntities){

          if(ob834Entity.getInsurance_line_code().equals("HLT")){
          // validate medical records

       exchDbDataProvider.setDataFromDb(subscriber.getMedicalPlan());
       DbData dbData = SharedData.getDbData();

        softAssert.assertTrue(dbData.getRatingAreaName().contains(ob834Entity.getRate_area()));
        softAssert.assertEquals(ob834Entity.getHios_plan_id(), dbData.getBaseId(), "Hios id did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_name(), dbData.getIssuerName(), "Insurer Name did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_id(), dbData.getIssuerId(), "Insurer Id did not match!");
        softAssert.assertEquals(ob834Entity.getBenefit_begin_date(), subscriber.getMedicalPlanStartDate());
        softAssert.assertEquals(ob834Entity.getBenefit_end_date(), subscriber.getMedicalPlanEndDate());
        softAssert.assertEquals(ob834Entity.getFinancial_effective_date(), subscriber.getMedicalFinancialStartDate());
        softAssert.assertEquals(ob834Entity.getPlan_year(), SharedData.getPlanYear());

              validateDetailsFromStep(ob834Entity, expectedValues.get(0));
              validateResidentialAddress(subscriber, ob834Entity, dbData);
        //softAssert.assertAll();

        } else {
         // validate dental records
          softAssert.assertTrue(ob834Entity.getInsurance_line_code().equals("DEN"));
        }
          softAssert.assertEquals(SharedData.getPrimaryMemberId(), ob834Entity.getMember_id(), "member id did not match"); // WIP - set member id
          softAssert.assertEquals(SharedData.getTotalSubscribers(), ob834Entity.getTotal_subscribers(), "total subscribers did not match"); // WIP - set total subscribers from a step
          softAssert.assertEquals(SharedData.getTotalDependents(), ob834Entity.getTotal_dependants(), "total dependents did not match"); // WIP - set total dependants from a step
          softAssert.assertEquals(subscriber.getFullName(), ob834Entity.getPlan_sponsor_name(), "plan sponsor name did not match"); // WIP - sponsor is the subscriber?
          softAssert.assertEquals("ssn or memberId - check and write a method to set", ob834Entity.getSponsor_id(), "sponsor id did not match"); // WIP
          softAssert.assertEquals(SharedData.getPlanYear(), ob834Entity.getPlan_year(), "plan year did not match"); //WIP - setPlan Year
          softAssert.assertEquals(subscriber.getIsSubscriber(), ob834Entity.getSubscriber_indicator(), "Subscriber indicator did not match"); //WIP - set value
          softAssert.assertEquals("if same as sponsorId - can compare from entity", ob834Entity.getSubscriber_id(), "subscriber id did not match"); //WIP - based on sponsorID?
          softAssert.assertEquals(subscriber.getMemberGroup(), ob834Entity.getMember_group(), "member group did not match"); //WIP - set data


          validateConstantFields(ob834Entity);
          validatePersonalDetails(subscriber, ob834Entity);
          validateResponsiblePersonDetails(subscriber, ob834Entity);
          validateBrokerDetails(subscriber, ob834Entity);
          validateIncorrectEntities(subscriber, ob834Entity);
          validateMailingAddress(subscriber, ob834Entity); // WIP
          validateRelCode(subscriber, ob834Entity); //WIP
          validateTotalEnrollees(subscriber.getMemberGroup(), ob834Entity); // WIP - set the values

      }
    }

    public void validateTotalEnrollees(String memberGroup, Ob834DetailsEntity ob834Entity){
     String totalEnrollees = SharedData.getGroupDetails().getGroupNumAndEnrollees().get(memberGroup);
     softAssert.assertEquals(totalEnrollees, ob834Entity.getTotal_enrollees());

        //  softAssert.assertAll();
    }

    public void validateRelCode(MemberDetails subscriber, Ob834DetailsEntity ob834Entity){
        subscriber.getRelation_to_subscriber();
        // Based on relationship to subscriber - get the code based on the requirement and validate.
        //  softAssert.assertAll();
    }

    public void validateConstantFields(Ob834DetailsEntity ob834Entity){
        softAssert.assertEquals(ob834Entity.getApplication_date(), "set this for today"); // WIP
        softAssert.assertEquals(ob834Entity.getUpdated_by(), "JAVA_OB834");
        softAssert.assertEquals(ob834Entity.getAck_requested(), "0");
        softAssert.assertEquals(ob834Entity.getUsage_indicator(), "T");
        softAssert.assertEquals(ob834Entity.getInterchange_sender_id(), "get the value for assertion"); // WIP
        softAssert.assertEquals(ob834Entity.getInterchange_date(), "get the value for assertion"); // WIP
        softAssert.assertEquals(ob834Entity.getDate_created(), "get the value for assertion"); // WIP
        softAssert.assertEquals(ob834Entity.getDate_updated(), "get the value for assertion"); // WIP
        //  softAssert.assertAll();
    }

    public void validatePersonalDetails(MemberDetails subscriber, Ob834DetailsEntity ob834Entity){
        softAssert.assertEquals(subscriber.getFirstName(), ob834Entity.getMember_first_name(), "member firstname did not match");
        softAssert.assertEquals(subscriber.getLastName(), ob834Entity.getMember_last_name(), "member firstname did not match");
        softAssert.assertEquals(subscriber.getMiddleName(), ob834Entity.getMember_middle_name(), "member middle did not match");
        softAssert.assertEquals(subscriber.getSsn(), ob834Entity.getMember_ssn(), "ssn did not match");
        softAssert.assertEquals(subscriber.getDob(), ob834Entity.getMember_dob(), "dob did not match");
        softAssert.assertEquals(subscriber.getGender(), ob834Entity.getMember_gender(), "Gender did not match");
        softAssert.assertEquals(subscriber.getRace(), ob834Entity.getMember_race(), "Race did not match");
        softAssert.assertEquals(subscriber.getPhoneNumber(), ob834Entity.getPrimary_phone(), "primary phone did not match");
        softAssert.assertEquals(subscriber.getEmailId(), ob834Entity.getPrimary_email(), "primary email did not match");
        softAssert.assertEquals(subscriber.getAlternatePhNum(), ob834Entity.getAlternate_phone(), "alternate phone did not match");
        softAssert.assertEquals(subscriber.getTobacco_user(), ob834Entity.getTobacco_use(), "isTobacco did not match");
        softAssert.assertEquals(ob834Entity.getMarital_status_code(), "I"); // update - always constant?
        softAssert.assertEquals(subscriber.getSpokenLanguage(), ob834Entity.getSpoken_language(), "spoken language did not match");
        softAssert.assertEquals(subscriber.getWrittenLanguage(), ob834Entity.getWritten_language(), "written language did not match");
        //  softAssert.assertAll();
    }


    public void validateResidentialAddress(MemberDetails subscriber, Ob834DetailsEntity ob834Entity, DbData dbData){
        softAssert.assertEquals(subscriber.getResAddress().getResidentialAddressLine1(), ob834Entity.getResidence_street_line1());
        softAssert.assertEquals(subscriber.getResAddress().getResidentialAddressLine2(), ob834Entity.getResidence_street_line2());
        softAssert.assertEquals(subscriber.getResAddress().getResidentialAddressCity(), ob834Entity.getResidence_city());
        softAssert.assertEquals(subscriber.getResAddress().getResidentialAddressState(), ob834Entity.getResidence_st());
        softAssert.assertEquals(subscriber.getResAddress().getResidentialAddressZipcode(), ob834Entity.getResidence_zip_code());
        softAssert.assertEquals(dbData.getFipcode(), ob834Entity.getResidence_fip_code()); // Check if this will give proper value
        //  softAssert.assertAll();
    }


    public void validateMailingAddress(MemberDetails subsciber, Ob834DetailsEntity ob834Entity){
        if(subsciber.getIsMailingAddressDifferent()){

        } else {

        }
        //  softAssert.assertAll();
    }

    public void validateResponsiblePersonDetails(MemberDetails subscriber, Ob834DetailsEntity ob834Entity){
       if( subscriber.getIsMinor()){
           // Validate Responsible Person details
           // update the entire method for optimal use - may not need if else blocks.
       } else{
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
           softAssert.assertEquals(ob834Entity.getRepsonsibe_person_zip_code(), null);
       }
        //  softAssert.assertAll();
    }

    public void validateBrokerDetails(MemberDetails subscriber, Ob834DetailsEntity ob834Entity){
        if(subscriber.getHasBroker()){
            // validate broker details
            // update the entire method for optimal use - may not need if else blocks.
        } else{
            softAssert.assertEquals(ob834Entity.getTpa_broker_name(), null);
            softAssert.assertEquals(ob834Entity.getTpa_broker_id(), null);
            softAssert.assertEquals(ob834Entity.getTpa_broker_lic_num(), null);
        }
        //  softAssert.assertAll();
    }

    public void validateIncorrectEntities(MemberDetails subscriber, Ob834DetailsEntity ob834Entity){
        if(subscriber.getHasIncorrectEntities()){
            // validate the entities - set them from step.
            // update the entire method for optimal use - may not need if else blocks.
        } else{
            softAssert.assertEquals(ob834Entity.getIncorrect_entity_id_code(), null);
            softAssert.assertEquals(ob834Entity.getIncorrect_entity_type_qualifier(), null);
            softAssert.assertEquals(ob834Entity.getIncorrect_first_name(), null);
            softAssert.assertEquals(ob834Entity.getIncorrect_middle_name(), null);
            softAssert.assertEquals(ob834Entity.getIncorrect_last_name(), null);
            softAssert.assertEquals(ob834Entity.getIncorrect_id_code_qualifier(), null);
            softAssert.assertEquals(ob834Entity.getIncorrect_id_code(), null);
            softAssert.assertEquals(ob834Entity.getIncorrect_dob(), null);
            softAssert.assertEquals(ob834Entity.getIncorrect_gender(), null);
            softAssert.assertEquals(ob834Entity.getIncorrect_marital_status_code(), null);
            softAssert.assertEquals(ob834Entity.getIncorrect_race(), null);
        }
        //  softAssert.assertAll();
    }


  public void validateDetailsFromStep(Ob834DetailsEntity ob834Entity, Map<String, String> expectedValues){
          softAssert.assertEquals(ob834Entity.getMaintenance_type_code(), expectedValues.get("maintenance_type_code"));
          softAssert.assertEquals(ob834Entity.getHd_main_type_code(), expectedValues.get("hd_maint_type_code"));
          softAssert.assertEquals(ob834Entity.getMaintenacne_res_code(), expectedValues.get("maintenance_reas_code"));
          softAssert.assertEquals("", expectedValues.get("addl_maint_reason")); // WIP
          softAssert.assertEquals(ob834Entity.getSep_reason(), expectedValues.get("sep_reason"));
         // softAssert.assertAll();
  }

  public void validateMemberExistsInPolicyTable(){
    List<PolicyTablesEntity> policyEntity = exchDbDataProvider.getDataFromPolicyTables();
    Assert.assertFalse(policyEntity.isEmpty(), "No records exists with this account number in Policy table");
  }

  public void validateOhiDetails(){
      Boolean hasRecords = exchDbDataProvider.getDataFromOhiTables();
      Assert.assertFalse(hasRecords, "Query returned records");
  }

    public void validateOhiOptions(List<Map<String, String>> expectedValues) {
        EsMemberOhiEntity actualResult = exchDbDataProvider.getOptionsFromOhiDbTables();
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
        softAssert.assertAll();
    }





















}
