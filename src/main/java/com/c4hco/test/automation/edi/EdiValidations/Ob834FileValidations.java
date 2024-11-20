package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.Edi.Edi834.CommonEDISegments;
import com.c4hco.test.automation.Dto.Edi.Edi834.Edi834TransactionDetails;
import com.c4hco.test.automation.Dto.Edi.Edi834.Transaction;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import org.json.JSONArray;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ob834FileValidations {
    SoftAssert softAssert = new SoftAssert();

    Edi834TransactionDetails edi834TransactionDetails = null;
    Transaction transaction = null;



    private void getDataByEmailAndAccNum(){
        String email = SharedData.getPrimaryMember().getEmailId();
        List<Transaction> updatedTransactionList = new ArrayList<>();
        edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        List<Transaction> transactionList = edi834TransactionDetails.getTransactionList();
        for(Transaction trans: transactionList) {
            String primaryEmailFromEdiFile = trans.getMembersList().get(0).getPER().get(0).get(5);
            if( primaryEmailFromEdiFile.equals(email)) {
                updatedTransactionList.add(trans);
            }
        }
        edi834TransactionDetails.setTransactionList(updatedTransactionList);
        SharedData.setEdi834TransactionDetails(edi834TransactionDetails);
    }

    public void validateOb834File(Ob834DetailsEntity entry){
        getDataByEmailAndAccNum();
        edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        List<Transaction> transactionList = edi834TransactionDetails.getTransactionList();
        for(Transaction trnsaction: transactionList){
            String primaryEmailFromEdiFile = trnsaction.getMembersList().get(0).getPER().get(0).get(5);
           if( primaryEmailFromEdiFile.equals(entry.getPrimary_email())){
               transaction = trnsaction;
               validateCtrlFnGrpSegment(entry );
               validateLSLESegment();
               validateSponsorPayerDetails(entry);
               validateAddlMaintReason(entry);
               validateInsSegment(entry);
               validateDtpSegment(entry);
               validateHierarchyLevelSeg(entry);
               validateNM1Seg(entry);
               validatePerSeg(entry);
               validateBgnSeg(entry);
               validateTrnSeg(entry);
               validateQtySeg(entry);
               validateHLHSeg(entry);
               validateLUISeg(entry);
               validateN3N4Segments(entry);
               validateDMGSegment(entry);
            }
        }
    }
    public void validateMed_LXREFSeg(List<Map<String, String>> lxExpectedDetailsFromStep){
        //LX segement
        List<List<String>> lxSegment = transaction.getMembersList().get(0).getLX();
        int lxSegmentSize = lxSegment.size();
        softAssert.assertEquals(String.valueOf(lxSegmentSize), "8", "LX segment size 8 mismatch");
        //REF Segment
        for (Map<String, String> segment : lxExpectedDetailsFromStep) {

        List<List<String>> refSegListOfList = transaction.getMembersList().get(0).getREF();
        List<List<String>> n1SegListOfList = transaction.getMembersList().get(0).getN1();
            int lx = Integer.parseInt(segment.get("LX"));
            String n1Expected = segment.get("N1 75");
            String refExpected = segment.get("REF");

            if (refSegListOfList.get(lx + 5).get(0).equals("LX" + lx)) {
                softAssert.assertEquals(n1SegListOfList.get(lx - 1).get(3), n1Expected, n1Expected + ", N1 segment mismatch for LX " + lx);
                softAssert.assertEquals(refSegListOfList.get(lx + 5).get(3), refExpected, "REF segment, " + n1Expected + " mismatch for LX " + lx);
            }
        }
        softAssert.assertAll();
    }

    public void validateDen_LXREFSeg(List<Map<String, String>> lxExpectedDetailsFromStep){
        edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        transaction = edi834TransactionDetails.getTransactionList().get(0);
        //LX segement
        List<List<String>> lxSegment = transaction.getMembersList().get(0).getLX();
        int lxSegmentSize = lxSegment.size();
        softAssert.assertEquals(String.valueOf(lxSegmentSize), "8", "LX segment size 8 mismatch");
        //REF Segment
        for (Map<String, String> segment : lxExpectedDetailsFromStep) {

            List<List<String>> refSegListOfList = transaction.getMembersList().get(0).getREF();
            List<List<String>> n1SegListOfList = transaction.getMembersList().get(0).getN1();
            int lx = Integer.parseInt(segment.get("LX"));
            String n1Expected = segment.get("N1 75");
            String refDenExpected = segment.get("REFDEN");

            if (refSegListOfList.get(lx + 5).get(0).equals("LX" + lx)) {
                softAssert.assertEquals(n1SegListOfList.get(lx - 1).get(3), n1Expected, n1Expected + ",Den N1 segment mismatch for LX " + lx);
                softAssert.assertEquals(refSegListOfList.get(lx + 5).get(3), refDenExpected, "DEN REF segment, " + n1Expected + " mismatch for LX " + lx);
            }
        }
        softAssert.assertAll();
    }


    private void validateHLHSeg(Ob834DetailsEntity entry){
        List<String> HLHSeg = transaction.getMembersList().get(0).getHLH().get(0);
        softAssert.assertEquals(HLHSeg.get(0), entry.getTobacco_use());
        softAssert.assertAll();
    }
    private void validateLSLESegment(){
        List<String> lsSegment = transaction.getMembersList().get(0).getLS().get(0);
        List<String> leSegment = transaction.getMembersList().get(0).getLE().get(0);
        softAssert.assertEquals(lsSegment.get(1), "2700", "Loop Header, the loop ID number given on the transaction set does not match");
        softAssert.assertEquals(leSegment.get(0), "2700", "Loop trailer, The loop ID number given on the transaction set does not match");
        softAssert.assertAll();
    }

    private void validateCtrlFnGrpSegment(Ob834DetailsEntity entry){
        CommonEDISegments commonEDISegments = SharedData.getCommonEDISegments();
        //ISA Segment
        JSONArray isaSeg = commonEDISegments.getISA();
        String senderId = isaSeg.get(5).toString().trim();
        String receiverId = isaSeg.get(7).toString().trim();
        softAssert.assertEquals(isaSeg.get(4), "ZZ", "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(senderId, entry.getInterchange_sender_id() , "Interchange Sender ID does not match");
        softAssert.assertEquals(isaSeg.get(6), "ZZ", "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(receiverId, entry.getInterchange_receiver_id(),"Interchange receiver id does not match");
        softAssert.assertEquals("20"+isaSeg.get(8), entry.getInterchange_date(), "Interchange date does not match");
        softAssert.assertEquals(isaSeg.get(9), entry.getInterchange_time(), "Interchange time does not match");
        softAssert.assertEquals(isaSeg.get(11), "00501", "Code specifying the version number of the interchange control segments");
        softAssert.assertEquals(isaSeg.get(12), entry.getInterchange_ctrl_number(), "Interchange control number does not match");
        softAssert.assertEquals(isaSeg.get(13), "0", "No Interchange Acknowledgment Requested");
        softAssert.assertEquals(isaSeg.get(14), "T","End of ISA segment, 'T' for Test Data, does not match");
        //IEA Segment
        JSONArray ieaSeg = commonEDISegments.getIEA();
        softAssert.assertEquals(ieaSeg.get(0), entry.getMember_group(), "Number of functional groups included does not match");
        softAssert.assertEquals(ieaSeg.get(1), entry.getInterchange_ctrl_number(), "Interchange control number does not match");
        //GS Segment
        JSONArray gsSeg = commonEDISegments.getGS().getJSONArray(0);
        softAssert.assertEquals(gsSeg.get(0), "BE", "Benefit Enrollment and Maintenance, Code identifying a group of application related transaction sets");
        softAssert.assertEquals(gsSeg.get(1), entry.getInterchange_sender_id(), "Sender's code does not match");
        softAssert.assertEquals(gsSeg.get(2), entry.getInterchange_receiver_id(), "Receiver's code does not match");
        softAssert.assertEquals(gsSeg.get(3), entry.getInterchange_date(), "Interchange date does not match");
        softAssert.assertEquals(gsSeg.get(4), entry.getInterchange_time(), "Interchange time does not match");
        softAssert.assertEquals(gsSeg.get(5), entry.getGroup_ctrl_number(), "Group control number does not match");
        softAssert.assertEquals(gsSeg.get(6), "X", "Code identifying the issuer of the standard; this code is used in conjunction with Data, X\n" +
                "Accredited Standards Committee ");
        softAssert.assertEquals(gsSeg.get(7), "005010X220A1", "Code indicating the version, release, subrelease, and industry identifier of the EDI standard being used does not match");
        //GE Segment
        JSONArray geSeg = commonEDISegments.getGE().getJSONArray(0);
        //softAssert.assertEquals(geSeg.get(0), entry.getMember_group(), "Count of the number of functional groups included in an interchange does not match");
        softAssert.assertEquals(geSeg.get(1), entry.getGroup_ctrl_number(), "Control number assigned by the interchange sender does not match");
        softAssert.assertAll();
    }
    private void validateSponsorPayerDetails(Ob834DetailsEntity entry){
        edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        transaction =  edi834TransactionDetails.getTransactionList().get(0);
        List<List<String>> n1Segment = transaction.getCommonSegments().getN1();
        //Sponsor Details
        softAssert.assertEquals(n1Segment.get(0).get(0), "P5", "P5 does not match");
        softAssert.assertEquals(n1Segment.get(0).get(1), entry.getMember_first_name()+" "+entry.getMember_last_name(), "Sponsor full name does not match.");
        softAssert.assertEquals(n1Segment.get(0).get(2), "FI", "FI, Federal Taxpayer's Identification Number");
        softAssert.assertEquals(n1Segment.get(0).get(3), entry.getSponsor_id(), "Sponsor Id does not match");
        //Payer Details
        softAssert.assertEquals(n1Segment.get(1).get(0), "IN", "Insurer");
        softAssert.assertEquals(n1Segment.get(1).get(1), entry.getInsurer_name(), "Insurer Name does not match");
        softAssert.assertEquals(n1Segment.get(1).get(2), "94", "Code assigned by the organization that is the ultimate destination of the transaction set");
        softAssert.assertEquals(n1Segment.get(1).get(3), entry.getInsurer_id(), "Insurer Identification Code");
        softAssert.assertAll();
    }
    private void validateAddlMaintReason(Ob834DetailsEntity entry){
        List<List<String>> refSegList = transaction.getMembersList().get(0).getREF();
        for (List<String> refSeg : refSegList) {
            if (refSeg.get(0).equals("LX1") && refSeg.get(1).equals("17")){
                softAssert.assertEquals(refSeg.get(3), entry.getAddl_maint_reason(),"Additional Maintenance reason does not match");
            }
        }
        softAssert.assertAll();
    }

    private void validateInsSegment(Ob834DetailsEntity entry){
        List<String> insSegment  = transaction.getMembersList().get(0).getINS().get(0);

        softAssert.assertEquals(insSegment.get(0), entry.getSubscriber_indicator(), "In INS segment, Subscriber indicator does not match");
        softAssert.assertEquals(insSegment.get(1), entry.getIndividual_rel_code(), "In INS segment,Individual rel code does not match");
        softAssert.assertEquals(insSegment.get(2), entry.getMaintenance_type_code(), "In INS segment, Maintenance type code does not match");
        softAssert.assertEquals(insSegment.get(3), entry.getMaintenance_reas_code(), "In INS segment, Maintenance reason code does not match");
        softAssert.assertEquals(insSegment.get(4), "A", "Active does not match");
        softAssert.assertEquals(insSegment.get(7), "AC", "Active does not match");
        softAssert.assertAll();
    }

    private void validateDtpSegment(Ob834DetailsEntity entry){
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

    private void validateHierarchyLevelSeg(Ob834DetailsEntity entry){
        List<String> hdSeg = transaction.getMembersList().get(0).getHD().get(0);
            softAssert.assertEquals(hdSeg.get(0), entry.getHd_maint_type_code(), "HD maintenance type code does not match");
            softAssert.assertEquals(hdSeg.get(1), "", "Empty");
            softAssert.assertEquals(hdSeg.get(2), entry.getInsurance_line_code(),"Insurance line code does not match");
            softAssert.assertAll();
    }

    private void validateNM1Seg(Ob834DetailsEntity entry){
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

    private void validatePerSeg(Ob834DetailsEntity entry){
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

    private void validateBgnSeg(Ob834DetailsEntity entry){
        List<String> bgnSeg = transaction.getCommonSegments().getBGN().get(0);
        softAssert.assertEquals(bgnSeg.get(0), entry.getTs_purpose_code(), "ts purpose code does not match");
        softAssert.assertEquals(bgnSeg.get(1), entry.getBgn_reference_ident(),"BGN reference identification does not match");
        softAssert.assertEquals(bgnSeg.get(2), entry.getInterchange_date(), "Interchange date does not match");
        softAssert.assertEquals(bgnSeg.get(3), entry.getInterchange_time(), "Interchange time does not match");
        softAssert.assertEquals(bgnSeg.get(4), "MT", "Interchange time does not match");
        softAssert.assertEquals(bgnSeg.get(7), entry.getBgn_action_code(),"BGN action code does not match");
        softAssert.assertAll();
    }

    private void validateTrnSeg(Ob834DetailsEntity entry){
        // ST Segment
      List<String> stSeg  = transaction.getCommonSegments().getST().get(0);
      softAssert.assertEquals(stSeg.get(0), "834", "Transaction Set Identifier Code does not match");
      softAssert.assertEquals(stSeg.get(1), "1000", "Transaction Set Control Number does not match");
      softAssert.assertEquals(stSeg.get(2), "005010X220A1", "Implementation Convention Reference does not match");
        // SE Segment
      int segCount = segmentCount();
      List<String> seSeg = transaction.getCommonSegments().getSE().get(0);
      softAssert.assertEquals(seSeg.get(0), String.valueOf(segCount), "Total number of segments included in a transaction set including ST and SE segments does not match");
      softAssert.assertEquals(seSeg.get(1), entry.getTs_control_number(), "Ts control number does not match");
      softAssert.assertAll();
    }

    private void validateQtySeg(Ob834DetailsEntity entry) {
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
    private void validateLUISeg(Ob834DetailsEntity entry){
       List<List<String>> luiSeg = transaction.getMembersList().get(0).getLUI();
       softAssert.assertEquals(luiSeg.get(0).get(2), entry.getWritten_language(), "Written Language does not match.");
       softAssert.assertEquals(luiSeg.get(0).get(3), String.valueOf(6), "Written Language Use Indicator does not match");
       softAssert.assertEquals(luiSeg.get(1).get(2), entry.getSpoken_language(), "Spoken Language does not match.");
       softAssert.assertEquals(luiSeg.get(1).get(3), String.valueOf(7), "Spoken Language Use Indicator does not match");
       softAssert.assertAll();
    }
    private void validateN3N4Segments(Ob834DetailsEntity entry){
        //N3 Segment
        List<List<String>> n3Seg = transaction.getMembersList().get(0).getN3();
        softAssert.assertEquals(n3Seg.get(0).get(0), entry.getResidence_street_line1(), "Residence street address line1 does not match");
        softAssert.assertEquals(n3Seg.get(1).get(0), entry.getMail_street_line1(), "Mailing address street line 1 does not match");
        //N4 Segment
        List<List<String>> n4Seg = transaction.getMembersList().get(0).getN4();
        softAssert.assertEquals(n4Seg.get(0).get(0), entry.getResidence_city(), "Residence city does not match");
        softAssert.assertEquals(n4Seg.get(0).get(1), entry.getResidence_st(), "Residence state does not match");
        softAssert.assertEquals(n4Seg.get(0).get(2), entry.getResidence_zip_code(), "Residence zipcode does not match");
        softAssert.assertEquals(n4Seg.get(0).get(4), "CY", "Country Code");
        softAssert.assertEquals(n4Seg.get(0).get(5), entry.getResidence_fip_code(),"Residence fipcode does not match");

        softAssert.assertEquals(n4Seg.get(1).get(0), entry.getMail_city(), "Mailing city does not match");
        softAssert.assertEquals(n4Seg.get(1).get(1), entry.getMail_st(), "Mailing State does not match");
        softAssert.assertEquals(n4Seg.get(1).get(2), entry.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertAll();
    }
    private void validateDMGSegment(Ob834DetailsEntity entry){
        List<List<String>> dmgSeg = transaction.getMembersList().get(0).getDMG();
        softAssert.assertEquals(dmgSeg.get(0).get(0), "D8", "D8, Date Expressed in Format CCYYMMDD");
        softAssert.assertEquals(dmgSeg.get(0).get(1), entry.getMember_dob(), "Member date of birth does not match");
        softAssert.assertEquals(dmgSeg.get(0).get(2), entry.getMember_gender(), "Member gender does not match");
        softAssert.assertAll();
    }
    private int segmentCount(){
        int memberSegCount  =
                        transaction.getMembersList().get(0).getN1().size()+
                        transaction.getMembersList().get(0).getN4().size()+
                        transaction.getMembersList().get(0).getLS().size()+
                        transaction.getMembersList().get(0).getHD().size()+
                        transaction.getMembersList().get(0).getDTP().size()+
                        transaction.getMembersList().get(0).getLUI().size()+
                        transaction.getMembersList().get(0).getN3().size()+
                        transaction.getMembersList().get(0).getHLH().size()+
                        transaction.getMembersList().get(0).getLX().size()+
                        transaction.getMembersList().get(0).getINS().size()+
                        transaction.getMembersList().get(0).getREF().size()+
                        transaction.getMembersList().get(0).getNM1().size()+
                        transaction.getMembersList().get(0).getLE().size()+
                        transaction.getMembersList().get(0).getPER().size()+
                        transaction.getMembersList().get(0).getDMG().size()+
                        transaction.getCommonSegments().getDTP().size()+
                        transaction.getCommonSegments().getST().size()+
                        transaction.getCommonSegments().getSE().size()+
                        transaction.getCommonSegments().getREF().size()+
                        transaction.getCommonSegments().getN1().size()+
                        transaction.getCommonSegments().getQTY().size()+
                        transaction.getCommonSegments().getBGN().size();
        return memberSegCount;
    }

}
