package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.Edi.Edi999.Edi999Segments;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ib999Entity;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class COCO_Ib999FileValidations {
    Edi999Segments ib999Segment = new Edi999Segments();
    SoftAssert softAssert = new SoftAssert();
    List<Ib999Entity> ib999MedEntityList = new ArrayList<>();
    List<String> ak2GrpCtrlNum_file = new ArrayList<>();
    List<String> ak2GrpCtrlNum_db = new ArrayList<>();

    public void ib999FilesValidations(String fileName) {
        ib999MedEntityList = SharedData.getIb999MedDetailsEntities();
        for (Ib999Entity ib999MedEntity : ib999MedEntityList) {
            if (ib999MedEntity.getFilename().equals(fileName)) {
                validateIb999File(ib999MedEntity);
            }
        }
        validateAk2GrpCtrlNum();
    }

    private void validateIb999File(Ib999Entity entry) {
        ib999Segment = SharedData.getIb999Segments();
        validateISASegment(entry);
        validateIEASegment(entry);
        validateGSSegment(entry);
        validateGESegment(entry);
        validateSTSegment(entry);
        validateSESegment(entry);
        validateAK1Segment(entry);
        validateAK9Segment(entry);
        for (int i = 0; i < Integer.parseInt(entry.getAk9_number_of_accepted_ts()); i++) {
            validateAK2Segment(entry, i);
            validateIK5Segment(entry, i);
        }
    }

    private void validateAk2GrpCtrlNum() {
        Assert.assertEquals(new HashSet<>(ak2GrpCtrlNum_file), new HashSet<>(ak2GrpCtrlNum_db), "AK2 group control numbers doesn't match");
    }

    private void validateISASegment(Ib999Entity entry) {
        JSONArray isaSeg = ib999Segment.getISA();
        softAssert.assertEquals(entry.getInterchange_receiver_id(), "COLOCONNECT");
        softAssert.assertEquals("00", isaSeg.get(0), "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals("00", isaSeg.get(2), "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals("ZZ", isaSeg.get(4), "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertTrue(entry.getInterchange_sender_id().equals(isaSeg.get(5).toString().trim()), "Sender Id mismatch");
        softAssert.assertEquals("ZZ", isaSeg.get(6), "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(entry.getInterchange_receiver_id(), isaSeg.get(7).toString().trim(), "Receiver Id mismatch");
        softAssert.assertEquals(entry.getInterchange_date(), isaSeg.get(8), "Interchange date does not match");
        softAssert.assertEquals(entry.getInterchange_time(), isaSeg.get(9), "Interchange time does not match");
        softAssert.assertTrue(isaSeg.get(10).equals("^"));
        softAssert.assertEquals(isaSeg.get(11), "00501", "Code specifying the version number of the interchange control segments");
        softAssert.assertEquals(isaSeg.get(12), entry.getInterchange_ctrl_number(), "Interchange control number does not match");
        softAssert.assertEquals(isaSeg.get(13), entry.getAck_requested(), "No Interchange Acknowledgment Requested");
        softAssert.assertEquals(isaSeg.get(14), entry.getUsage_indicator(), "End of ISA segment, 'T' for Test Data, does not match");
        softAssert.assertAll();
    }

    private void validateIEASegment(Ib999Entity entry) {
        JSONArray ieaSeg = ib999Segment.getIEA();
        softAssert.assertEquals(ieaSeg.get(0), "1", "functional group mismatch");
        softAssert.assertEquals(ieaSeg.get(1), entry.getInterchange_ctrl_number(), "Interchange control number mismatch");
        softAssert.assertAll();
    }

    private void validateGSSegment(Ib999Entity entry) {
        JSONArray gsSeg = ib999Segment.getGS().getJSONArray(0);
        softAssert.assertEquals(gsSeg.get(0), "FA", "FA mismatch");
        softAssert.assertEquals(entry.getInterchange_sender_id(), gsSeg.get(1), "Sender Id mismatch");
        softAssert.assertEquals(entry.getInterchange_receiver_id(), gsSeg.get(2), "Receiver Id mismatch");
        softAssert.assertEquals("20" + entry.getInterchange_date(), gsSeg.get(3), "Interchange date mismatch");
        softAssert.assertEquals(entry.getInterchange_time(), gsSeg.get(4), "Interchange time mismatch");
        softAssert.assertEquals(entry.getGroup_ctrl_number(), gsSeg.get(5), "Group control number mismatch");
        softAssert.assertEquals(gsSeg.get(6), "X", "Code identifying the issuer of the standard; this code is used in conjunction with Data, X\n" +
                "Accredited Standards Committee ");
        softAssert.assertEquals(gsSeg.get(7), "005010X231A1", "Code indicating the version, release, subrelease, and industry identifier of the EDI standard being used does not match");
        softAssert.assertAll();
    }

    private void validateGESegment(Ib999Entity entry) {
        JSONArray geSeg = ib999Segment.getGE().getJSONArray(0);
        softAssert.assertEquals(geSeg.get(1), entry.getGroup_ctrl_number(), "Group control number in GS segment mismatch");
        softAssert.assertAll();
    }

    private void validateSTSegment(Ib999Entity entry) {
        JSONArray stSeg = ib999Segment.getST().getJSONArray(0);
        softAssert.assertEquals(stSeg.get(0), entry.getTs_id_code(), "Ts_id_code mismatch");
        softAssert.assertEquals(stSeg.get(1), entry.getTs_control_number(), "Ts_control_number mismatch");
        softAssert.assertEquals(stSeg.get(2), entry.getImple_conv_reference(), "Imple_conv_reference() mismatch");
        softAssert.assertAll();
    }

    private void validateSESegment(Ib999Entity entry) {
        JSONArray seSeg = ib999Segment.getSE().getJSONArray(0);
        softAssert.assertEquals(seSeg.get(1), entry.getTs_control_number(), "Ts control number mismatch");
        softAssert.assertAll();
    }

    private void validateAK1Segment(Ib999Entity entry) {
        JSONArray ak1Seg = ib999Segment.getAK1().getJSONArray(0);
        softAssert.assertEquals(ak1Seg.get(0), entry.getAk1_functional_id_code(), "Ak1_functional_id_code mismatch");
        softAssert.assertEquals(ak1Seg.get(1), entry.getGroup_ctrl_number(), "Group control number mismatch");
        softAssert.assertEquals(ak1Seg.get(2), entry.getAk1_ver_id_code(), "Ak1 verification id code mismatch");
        softAssert.assertAll();
    }

    private void validateAK9Segment(Ib999Entity entry) {
        JSONArray ak9Seg = ib999Segment.getAK9().getJSONArray(0);
        softAssert.assertEquals(ak9Seg.get(0), entry.getAk9_funct_group_ack_code(), "Ak9_funct_group_ack_code mismatch");
        softAssert.assertEquals(ak9Seg.get(1), entry.getAk9_number_of_ts_included(), "Ak9_number_of_ts_included mismatch");
        softAssert.assertEquals(ak9Seg.get(2), entry.getAk9_number_of_received_ts(), "Ak9_number_of_received_ts mismatch");
        softAssert.assertEquals(ak9Seg.get(2), entry.getAk9_number_of_accepted_ts(), "Ak9_number_of_accepted_ts() mismatch");
        softAssert.assertAll();
    }

    private void validateAK2Segment(Ib999Entity entry, int i) {
        JSONArray ak2Seg = ib999Segment.getAK2().getJSONArray(i);

        softAssert.assertEquals(ak2Seg.get(0), entry.getAk2_ts_id_code(), "Ak2_ts_id_code mismatch");
        softAssert.assertEquals(ak2Seg.get(2), entry.getAk2_imple_conv_reference(), "Ak2_imple_conv_reference mismatch");

        ak2GrpCtrlNum_file.add((String) ak2Seg.get(1));
        ak2GrpCtrlNum_db.add(entry.getAk2_ts_control_number());
        softAssert.assertAll();
    }

    private void validateIK5Segment(Ib999Entity entry, int i) {
        JSONArray ik5Seg = ib999Segment.getIK5().getJSONArray(i);
        softAssert.assertEquals(ik5Seg.get(0), entry.getIk5_ts_ack_code(), "Ik5_ts_ack_code mismatch");
        softAssert.assertAll();
    }

}
