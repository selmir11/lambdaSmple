package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.Edi.Edi834.CommonEDISegments;
import com.c4hco.test.automation.Dto.Edi.Edi834.Edi834TransactionDetails;
import com.c4hco.test.automation.Dto.Edi.Edi834.Transaction;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ib834Entity;
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
//        validateMemSeg(medicalEntityList);
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
        ib834TransactionDetails = SharedData.getEdi834TransactionDetails();
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
        SharedData.setEdi834TransactionDetails(ib834TransactionDetails);
        ib834TransactionDetails = SharedData.getEdi834TransactionDetails();

        transactionList = ib834TransactionDetails.getTransactionList();
        transaction = transactionList.get(0);
    }
    private void validateSubscriberSegments(Ib834Entity entry) {
        validateCtrlFnGrpSegment(entry);
//        validateSponsorPayerDetails(entry);
//        validatePerSeg(entry);
//        validateBgnSeg(entry);
//        validateQtySeg(entry);
//        validateLUISeg(entry);
//        validateN3N4Segments(entry);
//        validateTrnSeg(entry);
//        validateSubscriberRefSeg();
//        softAssert.assertAll();
    }

    private void validateCtrlFnGrpSegment(Ib834Entity entry) {
        CommonEDISegments commonEDISegments = SharedData.getCommonEDISegments();
        //ISA Segment
        JSONArray isaSeg = commonEDISegments.getISA();
        String senderId = isaSeg.get(5).toString().trim();
        String receiverId = isaSeg.get(7).toString().trim();
        softAssert.assertEquals(isaSeg.get(4), "ZZ", "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(senderId, entry.getInterchange_sender_id(), "Interchange Sender ID does not match");
        softAssert.assertEquals(isaSeg.get(6), "ZZ", "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(receiverId, entry.getInterchange_receiver_id(), "Interchange receiver id does not match");
        softAssert.assertEquals("20" + isaSeg.get(8), entry.getInterchange_date(), "Interchange date does not match");
        softAssert.assertEquals(isaSeg.get(9), entry.getInterchange_time(), "Interchange time does not match");
        softAssert.assertEquals(isaSeg.get(11), "00501", "Code specifying the version number of the interchange control segments");
        softAssert.assertEquals(isaSeg.get(12), entry.getInterchange_ctrl_number(), "Interchange control number does not match");
        softAssert.assertEquals(isaSeg.get(13), "0", "No Interchange Acknowledgment Requested");
        softAssert.assertEquals(isaSeg.get(14), "T", "End of ISA segment, 'T' for Test Data, does not match");
        //IEA Segment
        JSONArray ieaSeg = commonEDISegments.getIEA();
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
        softAssert.assertEquals(geSeg.get(1), entry.getGroup_ctrl_number(), "Control number assigned by the interchange sender does not match");
    }
}
