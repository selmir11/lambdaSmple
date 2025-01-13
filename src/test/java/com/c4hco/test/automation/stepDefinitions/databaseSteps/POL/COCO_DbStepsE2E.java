package com.c4hco.test.automation.stepDefinitions.databaseSteps.POL;

import com.c4hco.test.automation.database.DbValidations.*;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class COCO_DbStepsE2E {
    private final COCO_PolicyTableDbValidations policyTableDBValidations = new COCO_PolicyTableDbValidations();
    private final COCO_Ob834PreEdiDbValidations ob834PreEdiDbValidations = new COCO_Ob834PreEdiDbValidations();
    private final Ib999DbValidations ib999DbValidations = new Ib999DbValidations();
    private final Ib834DbValidations ib834DbValidations = new Ib834DbValidations();
    private final Ob999DbValidations ob999DbValidations = new Ob999DbValidations();



    @And("I validate Medical entities from COCO policy tables")
    public void validateCOCOMedicalRecords(){
        policyTableDBValidations.recordsValidations();
    }
    @And("I validate Medical entities from COCO pre edi db tables")
    public void validateCOCOOb834MedicalRecords(List<Map<String, String>> expectedValues){
        ob834PreEdiDbValidations.recordsValidations(expectedValues);
    }
    @And("I validate Medical entities from COCO ib999_details db table")
    public void validateIb999DetailsDB(String recordType){
        ib999DbValidations.ib999RecordsValidations(recordType);
    }
    @And("I validate ib834 Medical details in COCO database")
    public void validateIb834DetailsDb(String recordType, List<Map<String, String>> expectedValues){
        ib834DbValidations.ib834DbRecordsValidations(recordType, expectedValues);
    }
    @And("I validate Medical entities from COCO ob999_details db table")
    public void validateOb999DetailsDB(String recordType){
        ob999DbValidations.ob999RecordsValidations(recordType);
    }


}
