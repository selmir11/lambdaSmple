package com.c4hco.test.automation.stepDefinitions.databaseSteps.POL;

import com.c4hco.test.automation.database.DbValidations.*;
import io.cucumber.java.en.And;

public class COCO_DbStepsE2E {
    private final COCO_PolicyTableDbValidations policyTableDBValidations_coco = new COCO_PolicyTableDbValidations();

    @And("I validate {string} Medical entities from COCO policy tables")
    public void validateCOCOMedicalRecords(String policyStatus){
        policyTableDBValidations_coco.recordsValidations(policyStatus);
    }

}
