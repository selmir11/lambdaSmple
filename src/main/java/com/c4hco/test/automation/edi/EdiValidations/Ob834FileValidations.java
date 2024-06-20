package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.Edi.CommonEDISegments;
import com.c4hco.test.automation.Dto.Edi.Edi834TransactionDetails;
import com.c4hco.test.automation.Dto.Edi.Transaction;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.sftpConfig.SftpUtil;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Ob834FileValidations {
    SoftAssert softAssert = new SoftAssert();
    SftpUtil sftpUtil = new SftpUtil();

    Edi834TransactionDetails edi834TransactionDetails = null;
    Transaction transaction = null;

    public void validateOb834File(Ob834DetailsEntity entry){
        validateCtrlFnGrpSegment();
        validateSponsorPayerDetails();
        validateAddlMaintReason();
        validateInsSegment(entry);
        validateDtpSegment();
        validateHierarchyLevelSeg();
        validateNM1Seg();
        validatePerSeg();
        validateTrnSeg();
        validateQtySeg();

    }

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

    public void validateInsSegment(Ob834DetailsEntity entry){
        edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        List<String> insSegment  = edi834TransactionDetails.getTransactionList().get(0).getMembersList().get(0).getINS().get(0);

        softAssert.assertEquals(insSegment.get(0), entry.getSubscriber_indicator(), "In INS segment, Subscriber indicator does not match");
        softAssert.assertEquals(insSegment.get(1), entry.getIndividual_rel_code(), "In INS segment,Individual rel code does not match");
        softAssert.assertEquals(insSegment.get(2), entry.getMaintenance_type_code(), "In INS segment, Maintenance type code does not match");
        softAssert.assertEquals(insSegment.get(3), entry.getMaintenance_reas_code(), "In INS segment, Maintenance reason code does not match");
        softAssert.assertEquals(insSegment.get(4), "A", "Active does not match");
        softAssert.assertEquals(insSegment.get(7), "AC", "Active does not match");
        softAssert.assertAll();
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

    public void validateQtySeg() {
        transaction.getCommonSegments().getQTY();

    }

}
