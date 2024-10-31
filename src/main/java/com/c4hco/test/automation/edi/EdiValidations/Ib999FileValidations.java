package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.Edi.Ib999Segments;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ib999Entity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.json.JSONArray;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Ib999FileValidations {
    Ib999Segments ib999MedSegment= null;
    SoftAssert softAssert = new SoftAssert();
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();

    public void setIb999DetailsEntity() {
        List<Ib999Entity> ib999MedEntity = exchDbDataProvider.getIb999Details(SharedData.getMedGroupCtlNumber());
        SharedData.setIb999MedDetailsEntities(ib999MedEntity);
        List<Ib999Entity> ib999DenEntity = exchDbDataProvider.getIb999Details(SharedData.getDenGroupCtlNumber());
        SharedData.setIb999DenDetailsEntities(ib999DenEntity);
    }
    public void validateib999File(Ib999Entity entry){
        ib999MedSegment = SharedData.getIb999Segments();
        validateISASegment(entry);
        validateIEASegment(entry);
        validateGSSegment(entry);
        validateGESegment(entry);
        validateSTSegment(entry);
        validateSESegment(entry);
        validateAK1Segment(entry);
        validateAK2Segment(entry);
        validateAK9Segment(entry);
        validateIK5Segment(entry);
    }
    public void validateISASegment(Ib999Entity entry){
        JSONArray isaSeg = ib999MedSegment.getISA();
        String appType = SharedData.getAppType();
        if (appType.equals("exchange")) {
            softAssert.assertEquals(entry.getInterchange_receiver_id(), "CNCT4HLTHCO");
        } else if (appType.equals("coco")) {
            softAssert.assertEquals(entry.getInterchange_receiver_id(), "COLOCONNECT");
        }
        softAssert.assertEquals("00", isaSeg.get(0), "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals("00", isaSeg.get(2), "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals("ZZ", isaSeg.get(4), "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertTrue(entry.getInterchange_sender_id().equals(isaSeg.get(5).toString().trim()),"Sender Id mismatch");
        softAssert.assertEquals("ZZ", isaSeg.get(6), "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(entry.getInterchange_receiver_id(),isaSeg.get(7).toString().trim(),"Receiver Id mismatch");
        softAssert.assertEquals(entry.getInterchange_date(), isaSeg.get(8), "Interchange date does not match");
        softAssert.assertEquals(entry.getInterchange_time(), isaSeg.get(9), "Interchange time does not match");
        softAssert.assertTrue(isaSeg.get(10).equals("^"));
        softAssert.assertEquals(isaSeg.get(11), "00501", "Code specifying the version number of the interchange control segments");
        softAssert.assertEquals(isaSeg.get(12), entry.getInterchange_ctrl_number(), "Interchange control number does not match");
        softAssert.assertEquals(isaSeg.get(13), entry.getAck_requested(), "No Interchange Acknowledgment Requested");
        softAssert.assertEquals(isaSeg.get(14), entry.getUsage_indicator(),"End of ISA segment, 'T' for Test Data, does not match");
        softAssert.assertAll();
    }
    public void validateIEASegment(Ib999Entity entry){
        JSONArray ieaSeg = ib999MedSegment.getIEA();
        softAssert.assertEquals(ieaSeg.get(0),"1", "functional group mismatch");
        softAssert.assertEquals(ieaSeg.get(1), entry.getInterchange_ctrl_number(), "Interchange control number mismatch");
        softAssert.assertAll();
    }
    public void validateGSSegment(Ib999Entity entry){
        JSONArray gsSeg = ib999MedSegment.getGS().getJSONArray(0);
        softAssert.assertEquals(gsSeg.get(0),"FA", "FA mismatch");
        softAssert.assertEquals(entry.getInterchange_sender_id(), gsSeg.get(1), "Sender Id mismatch");
        softAssert.assertEquals(entry.getInterchange_receiver_id(), gsSeg.get(2), "Receiver Id mismatch");
        softAssert.assertEquals("20"+entry.getInterchange_date(), gsSeg.get(3), "Interchange date mismatch");
        softAssert.assertEquals(entry.getInterchange_time(), gsSeg.get(4), "Interchange time mismatch");
        softAssert.assertEquals(entry.getGroup_ctrl_number(), gsSeg.get(5), "Group control number mismatch");
        softAssert.assertEquals(gsSeg.get(6), "X", "Code identifying the issuer of the standard; this code is used in conjunction with Data, X\n" +
                "Accredited Standards Committee ");
        softAssert.assertEquals(gsSeg.get(7), "005010X231A1", "Code indicating the version, release, subrelease, and industry identifier of the EDI standard being used does not match");
        softAssert.assertAll();
    }
    public void validateGESegment(Ib999Entity entry){
        JSONArray geSeg = ib999MedSegment.getGE();
    }
    public void validateSTSegment(Ib999Entity entry){
        JSONArray stSeg = ib999MedSegment.getST();
    }
    public void validateSESegment(Ib999Entity entry){

    }
    public void validateAK1Segment(Ib999Entity entry){

    }
    public void validateAK2Segment(Ib999Entity entry){

    }
    public void validateAK9Segment(Ib999Entity entry){

    }
    public void validateIK5Segment(Ib999Entity entry){

    }

}
