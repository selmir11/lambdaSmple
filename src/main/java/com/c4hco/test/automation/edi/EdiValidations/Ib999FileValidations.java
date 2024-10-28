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
            softAssert.assertEquals(entry.getInterchange_sender_id(), "CNCT4HLTHCO");
        } else if (appType.equals("coco")) {
            softAssert.assertEquals(entry.getInterchange_receiver_id(), "COLOCONNECT");
        }
        softAssert.assertEquals(entry.getInterchange_sender_id().contains((CharSequence) isaSeg.get(5)),"Sender Id mismatch");
        softAssert.assertEquals(entry.getInterchange_receiver_id(),isaSeg.get(7),"Receiver Id mismatch");
        softAssert.assertEquals(entry.getGroup_ctrl_number(),"Receiver Id mismatch");
        softAssert.assertAll();
    }
    public void validateIEASegment(Ib999Entity entry){

    }
    public void validateGSSegment(Ib999Entity entry){

    }
    public void validateGESegment(Ib999Entity entry){

    }
    public void validateSTSegment(Ib999Entity entry){

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
