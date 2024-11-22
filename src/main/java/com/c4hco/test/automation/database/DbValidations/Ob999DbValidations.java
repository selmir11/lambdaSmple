package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ob999Entity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Ob999DbValidations {
    SoftAssert softAssert = new SoftAssert();
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();


    private void setOb999Data(){
        List<Ob999Entity> ob999MedEntity = exchDbDataProvider.getOb999Details(SharedData.getMedGroupCtlNumber());
        SharedData.setOb999MedDetailsEntities(ob999MedEntity);
        SharedData.setMedicalOb999FileName(ob999MedEntity.get(0).getFilename());
        List<Ob999Entity> ob999DenEntity = exchDbDataProvider.getOb999Details(SharedData.getDenGroupCtlNumber());
        SharedData.setOb999DenDetailsEntities(ob999DenEntity);
        SharedData.setDentalOb999FileName(ob999DenEntity.get(0).getFilename());
    }

    public void ob999RecordsValidations(String recordType) {
        setOb999Data();
        int groups = SharedData.getScenarioDetails().getTotalGroups();
        Ob999Entity med999Entity  = SharedData.getOb999MedDetailsEntities().get(0);
        Ob999Entity den999Entity  = SharedData.getOb999DenDetailsEntities().get(0);
        switch (recordType) {
            case "medical":
                ob999MedRecordsValidations(groups, med999Entity);
                break;
            case "dental":
                ob999DenRecordsValidations(groups, den999Entity);
                break;
            default:
                Assert.fail("Record Type entered is not valid");
        }
        softAssert.assertAll();
    }

    private void ob999MedRecordsValidations(int groups, Ob999Entity medEntity){
        softAssert.assertEquals("A",medEntity.getAk9_funct_group_ack_code(), "Medical, total groups expected and actual mismatch" );
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_ts_included()), "groups, ak9 number of ts included mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_received_ts()), "groups, ak9 number of received_ts mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_accepted_ts()), "groups, ak9 number of accepted_ts mismatch");
        softAssert.assertAll();
    }

    private void ob999DenRecordsValidations(int groups, Ob999Entity denEntity){
        softAssert.assertEquals("A", denEntity.getAk9_funct_group_ack_code(), "Dental, total groups expected and actual mismatch" );
        softAssert.assertEquals(groups, Integer.parseInt(denEntity.getAk9_number_of_ts_included()), "groups, ak9 number of ts included mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(denEntity.getAk9_number_of_received_ts()), "groups, ak9 number of received_ts mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(denEntity.getAk9_number_of_accepted_ts()), "groups, ak9 number of accepted_ts mismatch");
        softAssert.assertAll();
    }

}
