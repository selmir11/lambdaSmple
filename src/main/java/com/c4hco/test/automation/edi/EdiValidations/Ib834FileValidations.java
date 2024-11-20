package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.Edi.Edi834.CommonEDISegments;
import com.c4hco.test.automation.Dto.Edi.Edi834.Edi834TransactionDetails;
import com.c4hco.test.automation.Dto.Edi.Edi834.Member;
import com.c4hco.test.automation.Dto.Edi.Edi834.Transaction;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ib834Entity;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import org.json.JSONArray;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Ib834FileValidations {
    Edi834TransactionDetails ib834TransactionDetails = null;
    Transaction transaction = null;
    Ib834Entity subscriberMedEntity = new Ib834Entity();
    Ib834Entity subscriberDenEntity = new Ib834Entity();
    int segCount = 0;
    int insSegCount = 0;
    SoftAssert softAssert = new SoftAssert();
    public void validateIb834MedFile() {
        getIb834MedEntityForSubscriber();
        List<Ib834Entity> medicalEntityList = SharedData.getIb834MedDetailsEntities();
        getIb834DataByEmailAndAccNum();
        segCount = 0;
        insSegCount = 0;
        validateSubscriberSegments(subscriberMedEntity);
        validateMemSeg(medicalEntityList);
//        validateSegCount();
    }

    private void getIb834MedEntityForSubscriber() {
        List<Ib834Entity> medicalEntityList = SharedData.getIb834MedDetailsEntities();
        for (Ib834Entity medIb834Entity : medicalEntityList) {
            if (medIb834Entity.getMember_first_name().toLowerCase().contains("primary")) {
                subscriberMedEntity = medIb834Entity;
                break;
            }
        }
    }
    private void getIb834DataByEmailAndAccNum() {
        ib834TransactionDetails = SharedData.getIb834TransactionDetails();
        String email = SharedData.getPrimaryMember().getEmailId();
        List<Transaction> updatedTransactionList = new ArrayList<>();
        List<Transaction> transactionList = ib834TransactionDetails.getTransactionList();
        for (Transaction trans : transactionList) {
            String primaryEmailFromEdiFile = trans.getMembersList().get(0).getPER().get(0).get(5);
            if (primaryEmailFromEdiFile.equals(email)) {
                updatedTransactionList.add(trans);
            }
        }
        ib834TransactionDetails.setTransactionList(updatedTransactionList);
        SharedData.setIb834TransactionDetails(ib834TransactionDetails);
        ib834TransactionDetails = SharedData.getIb834TransactionDetails();

        transactionList = ib834TransactionDetails.getTransactionList();
        transaction = transactionList.get(0);
    }
    private void validateSubscriberSegments(Ib834Entity entry) {
        validateCtrlFnGrpSegment(entry);
        validateSponsorPayerDetails(entry);
        validatePerSeg(entry);
        validateBgnSeg(entry);
        validateQtySeg(entry);
        validateLUISeg(entry);
        validateN3N4Segments(entry);
        validateTrnSeg(entry);
        validateSubscriberRefSeg();
        softAssert.assertAll();
    }
    private void validateCtrlFnGrpSegment(Ib834Entity entry) {
        CommonEDISegments commonIb834EDISegments = SharedData.getIb834Segments();
        //ISA Segment
        JSONArray isaSeg = commonIb834EDISegments.getISA();
        String senderId = isaSeg.get(5).toString().trim();
        String receiverId = isaSeg.get(7).toString().trim();
        softAssert.assertEquals(isaSeg.get(4), "ZZ", "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(senderId, entry.getInterchange_sender_id(), "Interchange Sender ID does not match");
        softAssert.assertEquals(isaSeg.get(6), "ZZ", "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(receiverId, entry.getInterchange_receiver_id(), "Interchange receiver id does not match");
        softAssert.assertEquals( isaSeg.get(8), entry.getInterchange_date().replace("20",""), "ISA Seg, Interchange date does not match");
        softAssert.assertEquals(isaSeg.get(9), entry.getInterchange_time(), "ISA Seg,Interchange time does not match");
        softAssert.assertEquals(isaSeg.get(11), "00501", "Code specifying the version number of the interchange control segments");
        softAssert.assertEquals(isaSeg.get(12), entry.getInterchange_ctrl_number(), "Interchange control number does not match");
        softAssert.assertEquals(isaSeg.get(13), "0", "No Interchange Acknowledgment Requested");
        softAssert.assertEquals(isaSeg.get(14), "T", "End of ISA segment, 'T' for Test Data, does not match");
        //IEA Segment
        JSONArray ieaSeg = commonIb834EDISegments.getIEA();
        softAssert.assertEquals(ieaSeg.get(1), entry.getInterchange_ctrl_number(), "Interchange control number does not match");
        //GS Segment
        JSONArray gsSeg = commonIb834EDISegments.getGS().getJSONArray(0);
        softAssert.assertEquals(gsSeg.get(0), "BE", "Benefit Enrollment and Maintenance, Code identifying a group of application related transaction sets");
        softAssert.assertEquals(gsSeg.get(1), entry.getInterchange_sender_id(), "Sender's code does not match");
        softAssert.assertEquals(gsSeg.get(2), entry.getInterchange_receiver_id(), "Receiver's code does not match");
        softAssert.assertEquals(gsSeg.get(3), "20"+entry.getInterchange_date(), "GS Seg,Interchange date does not match");
        softAssert.assertEquals(gsSeg.get(4), entry.getInterchange_time(), "GS Seg,Interchange time does not match");
        softAssert.assertEquals(gsSeg.get(5), entry.getGroup_ctrl_number(), "Group control number does not match");
        softAssert.assertEquals(gsSeg.get(6), "X", "Code identifying the issuer of the standard; this code is used in conjunction with Data, X\n" +
                "Accredited Standards Committee ");
        softAssert.assertEquals(gsSeg.get(7), "005010X220A1", "Code indicating the version, release, subrelease, and industry identifier of the EDI standard being used does not match");
        //GE Segment
        JSONArray geSeg = commonIb834EDISegments.getGE().getJSONArray(0);
        softAssert.assertEquals(geSeg.get(1), entry.getGroup_ctrl_number(), "Control number assigned by the interchange sender does not match");
    }

    private void validateSponsorPayerDetails(Ib834Entity entry) {
        List<List<String>> n1Segment = transaction.getCommonSegments().getN1();
        segCount = segCount + n1Segment.size();
        //Sponsor Details
        softAssert.assertEquals(n1Segment.get(0).get(0), "P5", "P5 does not match");
        softAssert.assertEquals(n1Segment.get(0).get(1), entry.getMember_first_name() + " " + entry.getMember_last_name(), "Sponsor full name does not match.");
        softAssert.assertEquals(n1Segment.get(0).get(2), "FI", "FI, Federal Taxpayer's Identification Number");
        softAssert.assertEquals(n1Segment.get(0).get(3), entry.getSponsor_id(), "Sponsor Id does not match");
        //Payer Details
        softAssert.assertEquals(n1Segment.get(1).get(0), "IN", "Insurer");
        softAssert.assertEquals(n1Segment.get(1).get(1), entry.getInsurer_name(), "Insurer Name does not match");
        softAssert.assertEquals(n1Segment.get(1).get(2), "94", "Code assigned by the organization that is the ultimate destination of the transaction set");
        softAssert.assertEquals(n1Segment.get(1).get(3), entry.getInsurer_id(), "Insurer Identification Code");
    }
    private void validatePerSeg(Ib834Entity entry) {
        List<String> perSeg = transaction.getMembersList().get(0).getPER().get(0);
        segCount = segCount + 1;
        softAssert.assertEquals(perSeg.get(0), "IP", "code identifying the Insured Party, IP does not match");
        softAssert.assertEquals(perSeg.get(2), "TE", "Telephone code TE does not match");
        softAssert.assertEquals(perSeg.get(3), entry.getPrimary_phone(), "Primary Phone number does not match");
        softAssert.assertEquals(perSeg.get(4), "EM", "Electronic mail code EM does not match");
        softAssert.assertEquals(perSeg.get(5), entry.getPrimary_email(), "Primary email does not match");
        softAssert.assertEquals(perSeg.get(6), "AP", "Alternate phone code does not match");
        softAssert.assertEquals(perSeg.get(7), entry.getAlternate_phone(), "Alternate phone number does not match");
    }
    private void validateBgnSeg(Ib834Entity entry) {
        List<String> bgnSeg = transaction.getCommonSegments().getBGN().get(0);
        segCount = segCount + 1;
        softAssert.assertEquals(bgnSeg.get(0), entry.getTs_purpose_code(), "ts purpose code does not match");
        softAssert.assertEquals(bgnSeg.get(2).replace("20",""), entry.getInterchange_date(), "BGN Seg,Interchange date does not match");
      //  softAssert.assertEquals(bgnSeg.get(3), entry.getInterchange_time(), "BGN Seg, Interchange time does not match");
        softAssert.assertEquals(bgnSeg.get(4), "MT", "Interchange time does not match");
        softAssert.assertEquals(bgnSeg.get(7), entry.getBgn_action_code(), "BGN action code does not match");
    }
    private void validateQtySeg(Ib834Entity entry) {
        List<List<String>> qtySeg = transaction.getCommonSegments().getQTY();
        segCount = segCount + qtySeg.size();
        softAssert.assertEquals(qtySeg.get(0).get(0), "TO", "Total enrolls ");
        softAssert.assertEquals(qtySeg.get(0).get(1), entry.getTotal_enrollees(), "Total enrolls does not match");
        softAssert.assertEquals(qtySeg.get(1).get(0), "DT", "Total dependents");
        softAssert.assertEquals(qtySeg.get(1).get(1), entry.getTotal_dependents(), "Total dependents doe not match");
        softAssert.assertEquals(qtySeg.get(2).get(0), "ET", "Total subscribers");
        softAssert.assertEquals(qtySeg.get(2).get(1), entry.getTotal_subscribers(), "Total subscribers does not match");
    }
    private void validateLUISeg(Ib834Entity entry) {
        List<List<String>> luiSeg = transaction.getMembersList().get(0).getLUI();
        segCount = segCount + luiSeg.size();
        softAssert.assertEquals(luiSeg.get(0).get(2), entry.getWritten_language(), "Written Language does not match.");
        softAssert.assertEquals(luiSeg.get(0).get(3), String.valueOf(6), "Written Language Use Indicator does not match");
        softAssert.assertEquals(luiSeg.get(1).get(2), entry.getSpoken_language(), "Spoken Language does not match.");
        softAssert.assertEquals(luiSeg.get(1).get(3), String.valueOf(7), "Spoken Language Use Indicator does not match");
    }


    private void validateN3N4Segments(Ib834Entity entry) {
        //N3 Segment
        List<List<String>> n3Seg = transaction.getMembersList().get(0).getN3();
        softAssert.assertEquals(n3Seg.get(0).get(0), entry.getResidence_street_line1(), "Residence street address line1 does not match");
        softAssert.assertEquals(n3Seg.get(1).get(0), entry.getMail_street_line1(), "Mailing address street line 1 does not match");
        //N4 Segment
        List<List<String>> n4Seg = transaction.getMembersList().get(0).getN4();
        segCount = segCount + n3Seg.size() + n4Seg.size();
        softAssert.assertEquals(n4Seg.get(0).get(0), entry.getResidence_city(), "Residence city does not match");
        softAssert.assertEquals(n4Seg.get(0).get(1), entry.getResidence_st(), "Residence state does not match");
        softAssert.assertEquals(n4Seg.get(0).get(2), entry.getResidence_zip_code(), "Residence zipcode does not match");
        softAssert.assertEquals(n4Seg.get(0).get(4), "CY", "Country Code");
        softAssert.assertEquals(n4Seg.get(0).get(5), entry.getResidence_fip_code(), "Residence fipcode does not match");

        softAssert.assertEquals(n4Seg.get(1).get(0), entry.getMail_city(), "Mailing city does not match");
        softAssert.assertEquals(n4Seg.get(1).get(1), entry.getMail_st(), "Mailing State does not match");
        softAssert.assertEquals(n4Seg.get(1).get(2), entry.getMail_zip_code(), "Mailing zipcode does not match");
    }


    private void validateTrnSeg(Ib834Entity entry) {
        // ST Segment
        List<String> stSeg = transaction.getCommonSegments().getST().get(0);
        softAssert.assertEquals(stSeg.get(0), "834", "Transaction Set Identifier Code does not match");
        softAssert.assertEquals(stSeg.get(1), "1000", "Transaction Set Control Number does not match");
        softAssert.assertEquals(stSeg.get(2), "005010X220A1", "Implementation Convention Reference does not match");
        // SE Segment
        List<String> seSeg = transaction.getCommonSegments().getSE().get(0);
        softAssert.assertEquals(seSeg.get(1), entry.getTs_control_number(), "Ts control number does not match");
        segCount = segCount + 2;
    }

    private void validateSubscriberRefSeg() {
        List<String> refSeg = transaction.getCommonSegments().getREF().get(0);
        segCount = segCount + 1;
        softAssert.assertEquals(String.valueOf(refSeg.get(0)), "38", "Subscriber ref is not 38");
        softAssert.assertEquals(String.valueOf(refSeg.get(1)), "COH-INDV1", "subscriber ref is not COH-INDV1");
    }
    private void validateMemSeg(List<Ib834Entity> entityList) {
        for (Ib834Entity entity : entityList) {
            List<Member> memberSegmentsList = transaction.getMembersList();
            for (Member member : memberSegmentsList) {
                if (entity.getMember_first_name().contains(member.getNM1().get(0).get(3))) {
                    System.out.println("validating the member segments for :::::::::::::" + member.getNM1().get(0).get(3));
                    validateSegments(member, entity);
                    break;
                }
            }
        }
    }
    private void validateSegments(Member member, Ib834Entity entry) {
        validateDMGSegment(member, entry);
        validateHLHSeg(member, entry);
        validateInsSegment(member, entry);
        validateNM1Seg(member, entry);
        validateHierarchyLevelSeg(member, entry);
        validateLSLESegment(member);
        validateAddlMaintReason(member, entry);
        validateDtpSegment(member, entry);
        validateLxRefN1Segment(member, entry);
        validateMemberRefSeg(member, entry);
        softAssert.assertAll();
    }

    private void validateDMGSegment(Member member, Ib834Entity entry) {
    }

    private void validateHLHSeg(Member member, Ib834Entity entry) {
    }

    private void validateInsSegment(Member member, Ib834Entity entry) {
    }

    private void validateNM1Seg(Member member, Ib834Entity entry) {
    }

    private void validateHierarchyLevelSeg(Member member, Ib834Entity entry) {
    }

    private void validateLSLESegment(Member member) {
    }

    private void validateAddlMaintReason(Member member, Ib834Entity entry) {
    }

    private void validateDtpSegment(Member member, Ib834Entity entry) {
    }

    private void validateLxRefN1Segment(Member member, Ib834Entity entry) {
    }

    private void validateMemberRefSeg(Member member, Ib834Entity entry) {
    }


}
