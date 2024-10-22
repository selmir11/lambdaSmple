package com.c4hco.test.automation.stepDefinitions.databaseSteps.POL;

import com.c4hco.test.automation.database.DbValidations.Ob834PreEdiDbValidations;
import com.c4hco.test.automation.database.DbValidations.PolicyDbValidations_new;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class DbStepsE2E {
    private final PolicyDbValidations_new policyTableDBValidations_new = new PolicyDbValidations_new();
    private final Ob834PreEdiDbValidations ob834PreEdiDbValidations = new Ob834PreEdiDbValidations();


    @And("I validate {string} entities from policy tables")
    public void validateMedicalRecords(String recordType){
        policyTableDBValidations_new.recordsValidations(recordType);
    }

    @And("I validate {string} entities from pre edi db tables")
    public void validateOb834MedicalRecords(String recordType, List<Map<String, String>> expectedValues){
        ob834PreEdiDbValidations.recordsValidations(recordType, expectedValues);
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
