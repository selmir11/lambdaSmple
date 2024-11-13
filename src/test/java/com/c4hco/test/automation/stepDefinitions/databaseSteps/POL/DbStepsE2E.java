package com.c4hco.test.automation.stepDefinitions.databaseSteps.POL;

import com.c4hco.test.automation.database.DbValidations.Ib834DbValidations;
import com.c4hco.test.automation.database.DbValidations.Ib999DbValidations;
import com.c4hco.test.automation.database.DbValidations.Ob834PreEdiDbValidations;
import com.c4hco.test.automation.database.DbValidations.PolicyTableDbValidations;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class DbStepsE2E {
    private final PolicyTableDbValidations policyTableDBValidations = new PolicyTableDbValidations();
    private final Ob834PreEdiDbValidations ob834PreEdiDbValidations = new Ob834PreEdiDbValidations();
    private final Ib999DbValidations ib999DbValidations = new Ib999DbValidations();
    private final Ib834DbValidations ib834DbValidations = new Ib834DbValidations();


    @And("I validate {string} entities from policy tables")
    public void validateMedicalRecords(String recordType){
        policyTableDBValidations.recordsValidations(recordType);
    }

    @And("I validate {string} entities from pre edi db tables")
    public void validateOb834MedicalRecords(String recordType, List<Map<String, String>> expectedValues){
        ob834PreEdiDbValidations.recordsValidations(recordType, expectedValues);
    }
    @And("I validate {string} entities from ib999_details db table")
    public void validateIb999DetailsDB(String recordType){
        ib999DbValidations.ib999RecordsValidations(recordType);
    }
    @And("I validate ib834 {string} details in database")
    public void validateIb834DetailsDb(String recordType){
        ib834DbValidations.ib834DbRecordsValidations(recordType);
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
