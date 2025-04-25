package com.c4hco.test.automation.stepDefinitions.databaseSteps.POL;

import com.c4hco.test.automation.database.DbValidations.*;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;

public class COCO_DbStepsE2E {
    private final COCO_PolicyTableDbValidations policyTableDBValidations_coco = new COCO_PolicyTableDbValidations();
    private final COCO_Ob834PreEdiDbValidations ob834PreEdiDbValidations_coco = new COCO_Ob834PreEdiDbValidations();
    private final COCO_Grp_PolicyTable_Val cOCO_Grp_PolicyTable_Val = new COCO_Grp_PolicyTable_Val();
    private final COCO_Ob834_Grp_PreEdiDbValidations coco_Ob834_Grp_PreEdiDbValidations = new COCO_Ob834_Grp_PreEdiDbValidations();

    @And("I validate {string} Medical entities from COCO policy tables")
    public void validateCOCOMedicalRecords(String policyStatus){
        policyTableDBValidations_coco.recordsValidationsPolicyTable(policyStatus);
    }
    @And("I validate Medical entities from COCO pre edi db tables")
    public void validateOb834MedicalRecords(List<Map<String, String>> expectedValues){
        ob834PreEdiDbValidations_coco.recordsValidations(expectedValues);
    }
    @And("I validate Medical entities for groups from COCO pre edi db tables")
    public void validateOb834MedicalRecordsForGrp(List<Map<String, String>> expectedValues){
        coco_Ob834_Grp_PreEdiDbValidations.grpsRecordsValidations(expectedValues);
    }
    @And("I validate {string} policy table entities for groups in COCO")
    public void validateCOCOMedGrpRecords(String status){
        cOCO_Grp_PolicyTable_Val.grpRecordsValidationsPolicyTable(status);
    }

}
