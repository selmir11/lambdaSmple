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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static com.c4hco.test.automation.utils.BasicActions.isSSNValid;

public class DbValidations {
  DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
  SoftAssert softAssert = new SoftAssert();
 String formattedDate; //formatted in YYYY-MM-DD

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
          exchDbDataProvider.setDataFromDb(subscriber.getMedicalPlan());
          DbData dbData = SharedData.getDbData();
          if(ob834Entity.getInsurance_line_code().equals("HLT")){
        // validate medical records
              String[] PlanStartDateArr = subscriber.getMedicalPlanStartDate().split("/");
              String formatPlanStartDate = PlanStartDateArr[2]+PlanStartDateArr[0]+PlanStartDateArr[1];

              String[] dateArr = subscriber.getMedicalPlanEndDate().split("/");
              String formatMedicalPlanEndDate  =dateArr[2]+dateArr[0]+dateArr[1];

              String[] finStartDate = subscriber.getMedicalFinancialStartDate().split("/");
              String formatedFinStartDate = finStartDate[2]+finStartDate[0]+finStartDate[1];


        softAssert.assertTrue(dbData.getRatingAreaName().contains(ob834Entity.getRate_area()));
        softAssert.assertEquals(ob834Entity.getHios_plan_id(), dbData.getBaseId(), "Hios id did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_name(), dbData.getIssuerName(), "Insurer Name did not match!");
        softAssert.assertEquals(ob834Entity.getInsurer_id(), dbData.getIssuerId(), "Insurer Id did not match!");
        softAssert.assertEquals(ob834Entity.getBenefit_begin_date(), subscriber.getMedicalPlanStartDate(),"Medical plan start date is not correct");
        softAssert.assertEquals(ob834Entity.getBenefit_end_date(), subscriber.getMedicalPlanEndDate(),"Medical plan end date is not correct");
        softAssert.assertEquals(ob834Entity.getFinancial_effective_date(), subscriber.getMedicalFinancialStartDate(), "Financial start date is not correct");
        softAssert.assertEquals(ob834Entity.getPlan_year(), SharedData.getPlanYear(),"Plan Year is not correct");

              validateDetailsFromStep(ob834Entity, expectedValues.get(0));
              validateResidentialAddress(subscriber, ob834Entity, dbData);
        softAssert.assertAll();

        } else {
         // validate dental records
          softAssert.assertTrue(ob834Entity.getInsurance_line_code().equals("DEN"));
        }
          softAssert.assertEquals(dbData.getExchPersonId(), ob834Entity.getMember_id(), "Member Id did not match");
//          softAssert.assertEquals(SharedData.getTotalSubscribers(), ob834Entity.getTotal_subscribers(), "total subscribers did not match"); // WIP - set total subscribers from a step
//          softAssert.assertEquals(SharedData.getTotalDependents(), ob834Entity.getTotal_dependents(), "total dependents did not match"); // WIP - set total dependants from a step
//          softAssert.assertEquals(subscriber.getFullName(), ob834Entity.getPlan_sponsor_name(), "plan sponsor name did not match"); // WIP - sponsor is the subscriber?
          boolean validSSN = isSSNValid(SharedData.getPrimaryMember().getSsn());
          if(validSSN){
              softAssert.assertEquals(SharedData.getPrimaryMember().getSsn(),ob834Entity.getSponsor_id(),"Sponsor_id did not match");
          }
          softAssert.assertEquals(SharedData.getPlanYear(), ob834Entity.getPlan_year(), "plan year did not match");
          softAssert.assertEquals(subscriber.getIsSubscriber(), ob834Entity.getSubscriber_indicator(), "Subscriber indicator did not match");
          softAssert.assertEquals(ob834Entity.getSubscriber_id(),ob834Entity.getMember_id(),"Subscriber_id and Member_id in ob834 entity does not match");
          softAssert.assertEquals(dbData.getExchPersonId(), ob834Entity.getSubscriber_id(), "subscriber id did not match");
        //  softAssert.assertEquals(subscriber.getMemberGroup(), ob834Entity.getMember_group(), "member group did not match"); //WIP - set data

          validateConstantFields(ob834Entity);
          validatePersonalDetails(subscriber, ob834Entity);
          validateResponsiblePersonDetails(subscriber, ob834Entity);
          validateBrokerDetails(subscriber, ob834Entity);
          validateIncorrectEntities(subscriber, ob834Entity);
          validateMailingAddress(subscriber, ob834Entity);
       //   validateRelCode(subscriber, ob834Entity); //WIP
       //   validateTotalEnrollees(subscriber.getMemberGroup(), ob834Entity); // WIP - set the values

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
    public String getCurrentdate(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter dateCreateUpdateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formattedDate = currentDate.format(dateCreateUpdateformat);
        return currentDate.format(formatter);
    }

    public void validateConstantFields(Ob834DetailsEntity ob834Entity){
        String date = getCurrentdate();

        String appType = SharedData.getAppType();
        if(appType.equals("exchange")){
            softAssert.assertEquals(ob834Entity.getInterchange_sender_id(), "CNCT4HLTHCO");
        }else if(appType.equals("coco")){
            softAssert.assertEquals(ob834Entity.getInterchange_sender_id(), "COLOCONNECT");
        }
        softAssert.assertEquals(ob834Entity.getApplication_date(), date,"Application date does not match in ob834 entity");
        softAssert.assertEquals(ob834Entity.getUpdated_by(), "JAVA_OB834", "Ob834 updated_by does not match");
        softAssert.assertEquals(ob834Entity.getAck_requested(), "0", "Ob834 Ack_requested does not match");
        softAssert.assertEquals(ob834Entity.getUsage_indicator(), "T", "Ob834 Usage_indicator does not match");
        softAssert.assertEquals(ob834Entity.getInterchange_date(), date,"Interchange_date does not match in with date ob834 entity");
        softAssert.assertEquals(ob834Entity.getDate_created().substring(0,10), formattedDate,"Date_created does not match with date in ob834 entity");
        softAssert.assertEquals(ob834Entity.getDate_updated().substring(0, 10), formattedDate, "Date_updated does not match with date in ob834 entity");
        softAssert.assertAll();
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
        softAssert.assertEquals(subscriber.getResAddress().getAddressLine1(), ob834Entity.getResidence_street_line1());
        softAssert.assertEquals(subscriber.getResAddress().getAddressLine2(), ob834Entity.getResidence_street_line2());
        softAssert.assertEquals(subscriber.getResAddress().getAddressCity(), ob834Entity.getResidence_city());
        softAssert.assertEquals(subscriber.getResAddress().getAddressState(), ob834Entity.getResidence_st());
        softAssert.assertEquals(subscriber.getResAddress().getAddressZipcode(), ob834Entity.getResidence_zip_code());
        softAssert.assertEquals(dbData.getFipcode(), ob834Entity.getResidence_fip_code()); // Check if this will give proper value
        //  softAssert.assertAll();
    }


    public void validateMailingAddress(MemberDetails subscriber, Ob834DetailsEntity ob834Entity){
            softAssert.assertEquals(subscriber.getMailingAddress().getAddressLine1(), ob834Entity.getMail_street_line1(),"Mailing address street line 1 does not match");
            if(subscriber.getMailingAddress().getAddressLine2() != null){
                softAssert.assertEquals(subscriber.getMailingAddress().getAddressLine2(),ob834Entity.getMail_street_line2(), "Mailing address street line 2 does not match");
            }else{
                softAssert.assertNull(ob834Entity.getMail_street_line2(), "Mailing address street line 2 is not null");
            }
            softAssert.assertEquals(subscriber.getMailingAddress().getAddressCity(),ob834Entity.getMail_city(), "Mailing city does not match");
            softAssert.assertEquals(subscriber.getMailingAddress().getAddressState(),ob834Entity.getMail_st(),"Mailing state does not match");
            softAssert.assertEquals(subscriber.getMailingAddress().getAddressZipcode(),ob834Entity.getMail_zip_code(),"Mailing zipcode does not match");
            softAssert.assertAll();
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
           softAssert.assertEquals(ob834Entity.getResponsible_person_zip_code(), null);
       }
        //  softAssert.assertAll();
    }

    public void validateBrokerDetails(MemberDetails subscriber, Ob834DetailsEntity ob834Entity){
        if(SharedData.getHasBroker()){
            // validate broker details
            // update the entire method for optimal use - may not need if else blocks.
        } else{
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_name(), null);
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_id(), null);
            softAssert.assertEquals(ob834Entity.getTpa_or_broker_lic_num(), null);
        }
        //  softAssert.assertAll();
    }

    public void validateIncorrectEntities(MemberDetails subscriber, Ob834DetailsEntity ob834Entity){
            softAssert.assertEquals(ob834Entity.getIncorrect_entity_id_code(), subscriber.getIncorrectEntityIdCode(), "Incorrect_entity_id_code did not match!");
            softAssert.assertEquals(ob834Entity.getIncorrect_id_code(), subscriber.getIncorrectIdCode(), "Incorrect_id_code did not match!");
            softAssert.assertEquals(ob834Entity.getIncorrect_entity_type_qualifier(), subscriber.getIncorrectEntityTypeQualifier(), "Incorrect_entity_type_qualifier did not match!");
            softAssert.assertEquals(ob834Entity.getIncorrect_first_name(),subscriber.getIncorrect_first_name(), "Incorrect_first_name did not match!");
            softAssert.assertEquals(ob834Entity.getIncorrect_last_name(), subscriber.getIncorrect_last_name(), "Incorrect_last_name did not match!");
            softAssert.assertEquals(ob834Entity.getIncorrect_id_code_qualifier(), subscriber.getIncorrectIdCodeQualifier(), "Incorrect_id_code_qualifier did not match!");
            softAssert.assertEquals(ob834Entity.getIncorrect_dob(), subscriber.getIncorrect_dob(), "Incorrect_dob did not match!");
            softAssert.assertEquals(ob834Entity.getIncorrect_gender(), subscriber.getIncorrect_gender(), "Incorrect_gender did not match!");
            softAssert.assertEquals(ob834Entity.getIncorrect_marital_status_code(), subscriber.getIncorrect_marital_status_code(), "Incorrect_marital_status_code did not match!");
            softAssert.assertEquals(ob834Entity.getIncorrect_race(), subscriber.getIncorrect_race(), "Incorrect_race did not match!");
            softAssert.assertEquals(ob834Entity.getIncorrect_middle_name(), subscriber.getIncorrect_middle_name(), "Incorrect_middle_name did not match!");
            softAssert.assertAll();
    }
    public void validateDetailsFromStep(Ob834DetailsEntity ob834Entity, Map<String, String >expectedValues){
        softAssert.assertEquals(ob834Entity.getMaintenance_type_code(), expectedValues.get("maintenance_type_code"),"maintenance_type_code mismatched");
        softAssert.assertEquals(ob834Entity.getHd_maint_type_code(), expectedValues.get("hd_maint_type_code"),"hd_maint_type_code mismatched");
        softAssert.assertEquals(ob834Entity.getMaintenance_reas_code(), expectedValues.get("maintenance_reas_code"),"maintenance_reas_code mismatched");
        // If expectedSepReason is null and actualSepReason is blank
        if (expectedValues.get("sep_reason") == null)
        {softAssert.assertTrue (ob834Entity.getSep_reason().isEmpty(), "Expected sep_reason to be blank, but was: " + ob834Entity.getSep_reason()) ;}
        else { //else, checking if they are equal
            softAssert.assertEquals (ob834Entity.getSep_reason(), expectedValues.get("sep_reason"),"Sep_reason mismatch");}
        softAssert.assertEquals(ob834Entity.getAddl_maint_reason(), expectedValues.get("addl_maint_reason"),"addl_maint_reason mismatched");
        softAssert.assertAll();
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
        softAssert.assertEquals(actualResult.getMedicare_parta_ind(), expectedValues.get(0).get("medicare_parta_ind"));
        softAssert.assertEquals(actualResult.getMedicare_partb_ind(), expectedValues.get(0).get("medicare_partb_ind"));
        softAssert.assertEquals(actualResult.getMedicare_premium_amount(), expectedValues.get(0).get("medicare_premium_amount"));
        softAssert.assertEquals(actualResult.getMedicare_prem_parta_ind3(), expectedValues.get(0).get("medicare_prem_parta_ind3"));
        softAssert.assertEquals(actualResult.getMedicare_parta_end_soon_ind3(), expectedValues.get(0).get("medicare_parta_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getMedicare_partb_end_soon_ind3(), expectedValues.get(0).get("medicare_partb_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getIndv_ins_enrl_covg_ind3(), expectedValues.get(0).get("indv_ins_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getIndv_ins_covg_end_soon_ind3(), expectedValues.get(0).get("indv_ins_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_end_soon_ind3(), expectedValues.get(0).get("emp_coverage_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_min_std_ind3(), expectedValues.get(0).get("emp_coverage_min_std_ind3"));
        softAssert.assertEquals(actualResult.getEmp_coverage_monthly_prem_amt(), expectedValues.get(0).get("emp_coverage_monthly_prem_amt"));
        softAssert.assertEquals(actualResult.getCobra_enrl_covg_ind3(), expectedValues.get(0).get("cobra_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getCobra_covg_end_soon_ind3(), expectedValues.get(0).get("cobra_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getVa_enrl_covg_ind3(), expectedValues.get(0).get("va_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getVa_covg_end_soon_ind3(), expectedValues.get(0).get("va_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getRetiree_enrl_covg_ind3(), expectedValues.get(0).get("retiree_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getRetiree_covg_end_soon_ind3(), expectedValues.get(0).get("retiree_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getTricare_enrl_covg_ind3(), expectedValues.get(0).get("tricare_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getTricare_covg_end_soon_ind3(), expectedValues.get(0).get("tricare_covg_end_soon_ind3"));
        softAssert.assertEquals(actualResult.getPeace_corps_enrl_covg_ind3(), expectedValues.get(0).get("peace_corps_enrl_covg_ind3"));
        softAssert.assertEquals(actualResult.getPeace_corps_covg_end_soon_ind3(), expectedValues.get(0).get("peace_corps_covg_end_soon_ind3"));
        softAssert.assertAll();
    }





















}
