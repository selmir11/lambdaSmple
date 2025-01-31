package com.c4hco.test.automation.stepDefinitions.databaseSteps.POL;

import com.c4hco.test.automation.database.DbValidations.*;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;

public class COCO_DbStepsE2E {
    private final COCO_PolicyTableDbValidations policyTableDBValidations_coco = new COCO_PolicyTableDbValidations();
    private final COCO_Ob834PreEdiDbValidations ob834PreEdiDbValidations_coco = new COCO_Ob834PreEdiDbValidations();

    @And("I validate {string} Medical entities from COCO policy tables")
    public void validateCOCOMedicalRecords(String policyStatus){
        policyTableDBValidations_coco.recordsValidations(policyStatus);
    }
    @And("I validate Current Medical entities from COCO pre edi db tables")
    public void validateOb834MedicalRecords(List<Map<String, String>> expectedValues){
        ob834PreEdiDbValidations_coco.recordsValidations(expectedValues);
    }

}
