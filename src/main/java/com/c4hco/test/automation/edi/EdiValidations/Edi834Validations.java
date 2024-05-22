package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.Edi.CommonEDISegments;
import com.c4hco.test.automation.Dto.Edi.Edi834TransactionDetails;
import com.c4hco.test.automation.Dto.Edi.Transaction;
import com.c4hco.test.automation.Dto.Ob834FileDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class Edi834Validations {
    SoftAssert softAssert = new SoftAssert();
    SftpUtil sftpUtil = new SftpUtil();

    Edi834TransactionDetails edi834TransactionDetails = null;
    Transaction transaction = null;


//    public void validateOb834MedicalRecord(){
//
//       // readTheDataFromEDIModel();
//        Edi834TransactionDetails edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
//        List<Transaction> transactionList = edi834TransactionDetails.getTransactionList();
//        for(Transaction transaction : transactionList){
//            List<Member> memberList = transaction.getMembersList();
//            CommonSegments commonSegments = transaction.getCommonSegments(); // rename to common segments for each transaction
//        }
////        CommonEDISegments commonEDISegments = edi834TransactionDetails.getCommonEDISegments(); // common for a file - rename - ISA/GS/QTY/BGN
////        List<List<String>> ISA = commonEDISegments.getISA();
//
//    }

//    public void readAndValidateOb834File(){
//        // read the file downloaded from sftp
//        List<Ob834DetailsEntity> ob834Entries = SharedData.getOb834DetailsEntities();
//
//        for (Ob834DetailsEntity entry : ob834Entries) {
//            if (entry.getInsurance_line_code().equals("HLT")) {
//
//                sftpUtil.readEdiFile(SharedData.getMedicalFileName());
//                // ----- validations --- //
//
//                validateConstantsFromOb834File();
//
//            } else if (entry.getInsurance_line_code().equals("DEN")) {
//                sftpUtil.readEdiFile(SharedData.getDentalFileName());
//            }
//            validateCtrlFnGrpSegment();
//        }
//    }

    public void validateCtrlFnGrpSegment(){
        // ISA and IEA Segments
        // GS and GE segments
        CommonEDISegments commonEDISegments = SharedData.getCommonEDISegments();
    }

    public void validateSponsorPayerDetails(){
         edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
         transaction =  edi834TransactionDetails.getTransactionList().get(0);
       // Edi834TransactionDetails edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        edi834TransactionDetails.getTransactionList(); // WIP - loop for all transactions
       // Transaction transaction =  edi834TransactionDetails.getTransactionList().get(0);
        // Name segment will have the sponsor details
        transaction.getMembersList(); // WIP - loop for multiple members
       System.out.println("commo transaction--"+transaction.getCommonSegments().getN1());
        List<List<String>> n1Seg =  transaction.getCommonSegments().getN1();

       System.out.println("n1Seg --"+n1Seg);
    }

    public void validateAddlMaintReason(){
     //   Transaction transaction =  edi834TransactionDetails.getTransactionList().get(0);
         List<List<String>> n1Seg = transaction.getMembersList().get(0).getN1();

    }

    public void validateInsSegment(){
     //   Transaction transaction =  edi834TransactionDetails.getTransactionList().get(0);
        transaction.getMembersList().get(0).getINS();
    }

    public void validateDtpSegment(){
        // Benefit begin and end date and others
       System.out.println("DTP::"+transaction.getMembersList().get(0).getDTP());
       List<List<String>> dtpSegList = transaction.getMembersList().get(0).getDTP();
       for(List<String> dtpSeg: dtpSegList){
           if(dtpSeg.contains("348")){
               // validate benefit start date
           }
       }

    }

    public void validateHierarchyLevelSeg(){
        transaction.getMembersList().get(0).getHD();
    }

    public void validateNM1Seg(){
        transaction.getMembersList().get(0).getNM1();
    }

    public void validatePerSeg(){
        transaction.getMembersList().get(0).getPER();
    }

    public void validateBgnSeg(){
        transaction.getCommonSegments().getBGN();
    }

    public void validateTrnSeg(){
        transaction.getCommonSegments().getST();
        // Include SE in commonSegments
        // transaction.getCommonSegments();
    }

    public void validateQtySeg(){
        transaction.getCommonSegments().getQTY();

    }

//
//
//    public void validateOb834Record(List<Map<String, String>> expectedValues){
//        // TO DO - Adjust the format - actual vs expected.
//        MemberDetails subscriber = SharedData.getPrimaryMember();
//        Map<String, String> medicalRecord = expectedValues.get(0);
//        Map<String, String> dentalRecord = expectedValues.get(1);
//        List<Ob834FileDetails> ob834Records = SharedData.getOb834FileDetails();
//
//        Optional<Ob834FileDetails> actualMedicalFileDataOptional = ob834Records.stream().filter(e-> e.getInsurance_line_code().equals("HLT")).findFirst();
//        if(actualMedicalFileDataOptional.isPresent()){
//            Ob834FileDetails actualMedicalFileData = actualMedicalFileDataOptional.get();
//            validateMedicalRecord(actualMedicalFileData, medicalRecord);
//        }
//        Optional<Ob834FileDetails> actualDentalFileDataOptional = ob834Records.stream().filter(e-> e.getInsurance_line_code().equals("DEN")).findFirst();
//        if(actualDentalFileDataOptional.isPresent()){
//            Ob834FileDetails actualDentalFileData = actualDentalFileDataOptional.get();
//            validateMedicalRecord(actualDentalFileData, medicalRecord);
//            validateDentalRecord(actualDentalFileData, dentalRecord);
//        }
//
//        // validate the common data for both the records below - TO DO
//        for(Ob834FileDetails record: ob834Records){
//            softAssert.assertEquals(subscriber.getFirstName(), record.getFirstName(), "First name did not match" );
//            softAssert.assertEquals(subscriber.getLastName(), record.getLastName(), "First name did not match" );
//            softAssert.assertEquals(subscriber.getSsn(), record.getSsn(), "SSN did not match" );
//            softAssert.assertEquals(subscriber.getMedicalPlanStartDate(), record.getBenefit_startDate(), "benefit start date did not match");
//            softAssert.assertEquals(subscriber.getMedicalPlanEndDate(), record.getBenefit_endDate(), "benefit end date did not match");
//            softAssert.assertEquals(subscriber.getMedicalFinancialStartDate(), record.getFinancial_effectiveDate());
//            //  softAssert.assertAll();
//        }
//    }

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
