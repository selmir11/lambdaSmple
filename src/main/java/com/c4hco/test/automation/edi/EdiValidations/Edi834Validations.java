package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.Ob834FileDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Edi834Validations {
    SoftAssert softAssert = new SoftAssert();

    public void validateOb834Record(List<Map<String, String>> expectedValues){
        // TO DO - Adjust the format - actual vs expected.
        MemberDetails subscriber = SharedData.getPrimaryMember();
        Map<String, String> medicalRecord = expectedValues.get(0);
        Map<String, String> dentalRecord = expectedValues.get(1);
        List<Ob834FileDetails> ob834Records = SharedData.getOb834FileDetails();

        Optional<Ob834FileDetails> actualMedicalFileDataOptional = ob834Records.stream().filter(e-> e.getInsurance_line_code().equals("HLT")).findFirst();
        if(actualMedicalFileDataOptional.isPresent()){
            Ob834FileDetails actualMedicalFileData = actualMedicalFileDataOptional.get();
            validateMedicalRecord(actualMedicalFileData, medicalRecord);
        }
        Optional<Ob834FileDetails> actualDentalFileDataOptional = ob834Records.stream().filter(e-> e.getInsurance_line_code().equals("DEN")).findFirst();
        if(actualDentalFileDataOptional.isPresent()){
            Ob834FileDetails actualDentalFileData = actualDentalFileDataOptional.get();
            validateMedicalRecord(actualDentalFileData, medicalRecord);
            validateDentalRecord(actualDentalFileData, dentalRecord);
        }

        // validate the common data for both the records below - TO DO
        for(Ob834FileDetails record: ob834Records){
            softAssert.assertEquals(subscriber.getFirstName(), record.getFirstName(), "First name did not match" );
            softAssert.assertEquals(subscriber.getLastName(), record.getLastName(), "First name did not match" );
            softAssert.assertEquals(subscriber.getSsn(), record.getSsn(), "SSN did not match" );
            softAssert.assertEquals(subscriber.getMedicalPlanStartDate(), record.getBenefit_startDate(), "benefit start date did not match");
            softAssert.assertEquals(subscriber.getMedicalPlanEndDate(), record.getBenefit_endDate(), "benefit end date did not match");
            softAssert.assertEquals(subscriber.getMedicalFinancialStartDate(), record.getFinancial_effectiveDate());
            //  softAssert.assertAll();
        }
    }

    public void validateMedicalRecord( Ob834FileDetails ob834Record, Map<String, String> expectedResult){
        softAssert.assertEquals(expectedResult.get("maintenance_type_code"), ob834Record.getMaint_type_code(), "maint type code did not match");
        softAssert.assertEquals(expectedResult.get("hd_maint_type_code"), ob834Record.getHd_maint_typeCode());
        softAssert.assertEquals(expectedResult.get("maintenance_reas_code"), ob834Record.getMaint_reasCode());
        softAssert.assertEquals(expectedResult.get("incorrect_entity_id_code"), ob834Record.getIncorrectEntityIdCode());
        softAssert.assertEquals(expectedResult.get("incorrect_id_code_qualifier"), ob834Record.getIncorrectIdCodeQualifier());
        softAssert.assertEquals(expectedResult.get("incorrect_entity_id_code"), ob834Record.getIncorrectEntityIdCode());
        softAssert.assertEquals(expectedResult.get("addl_maint_reason"), ob834Record.getAddtl_maintreason());
        //  sponsor_id  | incorrect_id_code - Any other validations?
        //  softAssert.assertAll();
    }

    public void validateDentalRecord(Ob834FileDetails ob834Record, Map<String, String> expectedResult){
    }
}
