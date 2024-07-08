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
        edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        transaction = edi834TransactionDetails.getTransactionList().get(0);
//        validateCtrlFnGrpSegment();
//        validateSponsorPayerDetails();
        validateAddlMaintReason(entry);
        validateInsSegment(entry);
        validateDtpSegment(entry);
        validateHierarchyLevelSeg(entry);
        validateNM1Seg(entry);
        validatePerSeg(entry);
        validateBgnSeg(entry);
//        validateTrnSeg();
        validateQtySeg(entry);
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

    public void validateAddlMaintReason(Ob834DetailsEntity entry){
        List<List<String>> refSegList = transaction.getMembersList().get(0).getREF();
        for (List<String> refSeg : refSegList) {
            if (refSeg.get(0).equals("LX1") && refSeg.get(1).equals("17")){
                softAssert.assertEquals(refSeg.get(3), entry.getAddl_maint_reason(),"Additional Maintenance reason does not match");
            }
        }
        softAssert.assertAll();
    }

    public void validateInsSegment(Ob834DetailsEntity entry){
        List<String> insSegment  = transaction.getMembersList().get(0).getINS().get(0);

        softAssert.assertEquals(insSegment.get(0), entry.getSubscriber_indicator(), "In INS segment, Subscriber indicator does not match");
        softAssert.assertEquals(insSegment.get(1), entry.getIndividual_rel_code(), "In INS segment,Individual rel code does not match");
        softAssert.assertEquals(insSegment.get(2), entry.getMaintenance_type_code(), "In INS segment, Maintenance type code does not match");
        softAssert.assertEquals(insSegment.get(3), entry.getMaintenance_reas_code(), "In INS segment, Maintenance reason code does not match");
        softAssert.assertEquals(insSegment.get(4), "A", "Active does not match");
        softAssert.assertEquals(insSegment.get(7), "AC", "Active does not match");
        softAssert.assertAll();
    }

    public void validateDtpSegment(Ob834DetailsEntity entry){
       System.out.println("DTP::"+transaction.getMembersList().get(0).getDTP());
       List<List<String>> dtpSegList = transaction.getMembersList().get(0).getDTP();
       for(List<String> dtpSeg: dtpSegList){
           if(dtpSeg.get(0).contains("348")){
               softAssert.assertEquals(dtpSeg.get(2),entry.getBenefit_begin_date(),"DTP 348 does not match with benefit start date.");
           }else if(dtpSeg.get(0).contains("349")){
               softAssert.assertEquals(dtpSeg.get(2),entry.getBenefit_end_date(),"DTP 349 does not match with benefit end date.");
           }else if(dtpSeg.get(0).contains("303")){
               softAssert.assertEquals(dtpSeg.get(2),entry.getFinancial_effective_date(),"DTP 303 doe not match with financial effective date.");
           }
       }
        softAssert.assertAll();
    }

    public void validateHierarchyLevelSeg(Ob834DetailsEntity entry){
        List<String> hdSeg = transaction.getMembersList().get(0).getHD().get(0);
            softAssert.assertEquals(hdSeg.get(0), entry.getHd_maint_type_code(), "HD maintenance type code does not match");
            softAssert.assertEquals(hdSeg.get(1), "", "Empty");
            softAssert.assertEquals(hdSeg.get(2), entry.getInsurance_line_code(),"Insurance line code does not match");
            softAssert.assertAll();
    }

    public void validateNM1Seg(Ob834DetailsEntity entry){
       List<List<String>> nm1Seg1  = transaction.getMembersList().get(0).getNM1();
       if(SharedData.getPrimaryMember().getHasIncorrectEntities()){
           softAssert.assertEquals(nm1Seg1.get(0).get(0),"74","Entity Identifier Code does not match");
           softAssert.assertEquals(nm1Seg1.get(2).get(0),"31","NM1 segment with value 31");
           softAssert.assertEquals(nm1Seg1.get(2).get(1),"1","NM1 segment with value 1");
           softAssert.assertEquals(nm1Seg1.get(0).get(1), entry.getIncorrect_entity_type_qualifier(),"Incorrect entity type qualifier does not match");
           softAssert.assertEquals(nm1Seg1.get(0).get(7), entry.getIncorrect_id_code_qualifier(),"Incorrect id code qualifier does not match");
           softAssert.assertEquals(nm1Seg1.get(1).get(0), entry.getIncorrect_entity_id_code(),"Incorrect entity id code.");
           softAssert.assertEquals(nm1Seg1.get(1).get(8), entry.getIncorrect_id_code(),"Incorrect id code");
           softAssert.assertEquals(String.valueOf(nm1Seg1.size()),"3" , "NM1 segment size is not equal to 3");
       }else{
           softAssert.assertEquals(nm1Seg1.get(0).get(0),"IL","Entity Identifier Code does not match");
           softAssert.assertEquals(nm1Seg1.get(1).get(0),"31","NM1 segment with value 31");
           softAssert.assertEquals(nm1Seg1.get(1).get(1),"1","NM1 segment with value 1");
           softAssert.assertEquals(String.valueOf(nm1Seg1.size()),"2" , "NM1 segment size is not equal to 2");
       }
            softAssert.assertEquals(nm1Seg1.get(0).get(2), entry.getMember_last_name(),"Member Last name does not match");
            softAssert.assertEquals(nm1Seg1.get(0).get(3), entry.getMember_first_name(), "Member first name does not match");
            softAssert.assertEquals(nm1Seg1.get(0).get(8),entry.getMember_ssn(), "Member SSN does not match");
            softAssert.assertAll();
    }

    public void validatePerSeg(Ob834DetailsEntity entry){
        List<String> perSeg = transaction.getMembersList().get(0).getPER().get(0);
        softAssert.assertEquals(perSeg.get(0), "IP", "code identifying the Insured Party, IP does not match");
        softAssert.assertEquals(perSeg.get(2), "TE", "Telephone code TE does not match");
        softAssert.assertEquals(perSeg.get(3), entry.getPrimary_phone(), "Primary Phone number does not match");
        softAssert.assertEquals(perSeg.get(4), "EM", "Electronic mail code EM does not match");
        softAssert.assertEquals(perSeg.get(5), entry.getPrimary_email(), "Primary email does not match");
        softAssert.assertEquals(perSeg.get(6), "AP", "Alternate phone code does not match");
        softAssert.assertEquals(perSeg.get(7), entry.getAlternate_phone(), "Alternate phone number does not match");
        softAssert.assertAll();
    }

    public void validateBgnSeg(Ob834DetailsEntity entry){
        List<String> bgnSeg = transaction.getCommonSegments().getBGN().get(0);
        softAssert.assertEquals(bgnSeg.get(0), entry.getTs_purpose_code(), "ts purpose code does not match");
        softAssert.assertEquals(bgnSeg.get(1), entry.getBgn_reference_ident(),"BGN reference identification does not match");
        softAssert.assertEquals(bgnSeg.get(2), entry.getInterchange_date(), "Interchange date does not match");
        softAssert.assertEquals(bgnSeg.get(3), entry.getInterchange_time(), "Interchange time does not match");
        softAssert.assertEquals(bgnSeg.get(4), "MT", "Interchange time does not match");
        softAssert.assertEquals(bgnSeg.get(7), entry.getBgn_action_code(),"BGN action code does not match");
        softAssert.assertAll();
    }

    public void validateTrnSeg(){
        transaction.getCommonSegments().getST();
        // Include SE in commonSegments
        // transaction.getCommonSegments();
    }

    public void validateQtySeg(Ob834DetailsEntity entry) {
        List<List<String>> qtySeg = transaction.getCommonSegments().getQTY();
        List<List<String>> insSegment = transaction.getMembersList().get(0).getINS();
        softAssert.assertEquals(qtySeg.get(0).get(0), "TO", "Total enrolls ");
        softAssert.assertEquals(qtySeg.get(0).get(1), entry.getTotal_enrollees(), "Total enrolls does not match");
        softAssert.assertEquals(qtySeg.get(0).get(1), String.valueOf(insSegment.size()), "Total enrolls does not match with the size of INS segment");
        softAssert.assertEquals(qtySeg.get(1).get(0), "DT", "Total dependents");
        softAssert.assertEquals(qtySeg.get(1).get(1), entry.getTotal_dependents(), "Total dependents doe not match");
        softAssert.assertEquals(qtySeg.get(2).get(0), "ET", "Total subscribers");
        softAssert.assertEquals(qtySeg.get(2).get(1), entry.getTotal_subscribers(), "Total subscribers does not match");
        softAssert.assertAll();
    }

}
