package com.c4hco.test.automation.stepDefinitions.databaseSteps.POL;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.DbValidations.*;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class DbStepsE2E {
    private final Ib999DbValidations ib999DbValidations = new Ib999DbValidations();
    private final Ob999DbValidations ob999DbValidations = new Ob999DbValidations();
    private final PolicyTableDbValidations policyTableDbValidations = new PolicyTableDbValidations();
    private final Ob834PreEdiDbValidations ob834PreEdiDbValidations = new Ob834PreEdiDbValidations();
    private final Ob834DbValForMember ob834DbValForMember = new Ob834DbValForMember();
    private final Ib834DbValidations ib834DbValidations = new Ib834DbValidations();
    private final PolicyTableMemberDbValidations policyTableMemberDbValidations = new PolicyTableMemberDbValidations();
    private final COCO_grp_Ib834DbValidations coco_grp_Ib834DbValidations = new COCO_grp_Ib834DbValidations();

    @And("I validate {string} entities from policy tables")
    public void validateMedicalRecordsForGroups(String recordType){
        policyTableDbValidations.groupRecordsValidations(recordType);
    }
    @And("I validate {string} entities for {string} from policy tables")
    public void validateMedicalRecordsForMem(String recordType, String memberPrefix){
        policyTableMemberDbValidations.MemberMedicalRecordsValidations(recordType, memberPrefix);
    }

    @And("I validate {string} entities from pre edi db tables")
    public void validateOb834MedicalRecords(String recordType, List<Map<String, String>> expectedValues){
        ob834PreEdiDbValidations.groupRecordsValidations(recordType, expectedValues);
    }
    @And("I validate {string} entities for {string} from pre edi db tables")
    public void validateOb834MedicalRecordForMember(String recordType,String memPrefix, List<Map<String, String>> expectedValues){
        ob834DbValForMember.ob834MedRecordsValForMember(recordType, memPrefix, expectedValues);
    }

    @And("I validate {string} entities from ib999_details db table")
    public void validateIb999DetailsDB(String recordType){
        ib999DbValidations.ib999RecordsValidations(recordType);
    }

    @And("I reset the previous file names in shared data")
    public void resetFiles(){
        SharedData.setMedicalFileName_grp(null);
        SharedData.setDentalFileName_grp(null);
        SharedData.setOb834DetailsMedEntities(null);
        SharedData.setOb834DetailsDenEntities(null);
    }

    @And("I validate ib834 {string} details in database for groups")
    public void validateIb834DetailsDb_grps(String recordType, List<Map<String, String>> expectedValues){
        ib834DbValidations.ib834DbRecordsValidations(recordType, expectedValues);
    }
    @And("I validate coco ib834 file for groups")
    public void validateCocoIb834DetailsDb(List<Map<String, String>> expectedValues){
        coco_grp_Ib834DbValidations.coco_ib834DbRecordsValidations(expectedValues);
    }

    @And("I validate {string} entities from ob999_details db table")
    public void validateOb999DetailsDB(String recordType){
        ob999DbValidations.ob999RecordsValidations(recordType);
    }

    //   @And("I validate Individual member policy table queries")
//   public void ivalidateIndPolicyTableQueries(){
//
//      policyTableValidations.validateEnPolicyTableDetails();
//      policyTableValidations.validateEnMemberCoverageFinancialAh();
//      policyTableValidations.validateEnPolicyMemberCoverageAh();
//      policyTableValidations.validateEnPolicyFinancialAh();
//      policyTableValidations.validateEnPolicyMemberAh();
//
//   }
}
