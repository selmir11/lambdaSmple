package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ib999Entity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Ib999DbValidations {
    SoftAssert softAssert = new SoftAssert();
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    private void setib999Data(){
        List<Ib999Entity> ib999MedEntity = exchDbDataProvider.getIb999Details(SharedData.getMedGroupCtlNumber());
        SharedData.setIb999MedDetailsEntities(ib999MedEntity);
        SharedData.setMedicalIb999FileName(ib999MedEntity.get(0).getFilename());
        List<Ib999Entity> ib999DenEntity = exchDbDataProvider.getIb999Details(SharedData.getDenGroupCtlNumber());
        SharedData.setIb999DenDetailsEntities(ib999DenEntity);
        SharedData.setDentalIb999FileName(ib999DenEntity.get(0).getFilename());
    }

    public void ib999RecordsValidations(String recordType) {
        setib999Data();
        int groups = SharedData.getScenarioDetails().getTotalGroups();
        Ib999Entity med999Entity  = SharedData.getIb999MedDetailsEntities().get(0);
        Ib999Entity den999Entity  = SharedData.getIb999DenDetailsEntities().get(0);
        switch (recordType) {
            case "medical":
                ib999MedRecordsValidations(groups, med999Entity);
                break;
            case "dental":
                ib999DenRecordsValidations(groups, den999Entity);
                break;
            default:
                Assert.fail("Record Type entered is not valid");
        }
        softAssert.assertAll();
    }

    public void ib999MedRecordsValidations(int groups, Ib999Entity medEntity){
        softAssert.assertEquals("A",medEntity.getAk9_funct_group_ack_code(), "Medical, total groups expected and actual mismatch" );
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_ts_included()), "groups, ak9 number of ts included mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_received_ts()), "groups, ak9 number of received_ts mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_accepted_ts()), "groups, ak9 number of accepted_ts mismatch");
        softAssert.assertEquals(SharedData.getMedGroupCtlNumber(), medEntity.getGroup_ctrl_number(), "Medical group control number mismatch");
        softAssert.assertAll();
    }

    public void ib999DenRecordsValidations(int groups, Ib999Entity denEntity){
        softAssert.assertEquals("A", denEntity.getAk9_funct_group_ack_code(), "Dental, total groups expected and actual mismatch" );
        softAssert.assertEquals(groups, Integer.parseInt(denEntity.getAk9_number_of_ts_included()), "groups, ak9 number of ts included mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(denEntity.getAk9_number_of_received_ts()), "groups, ak9 number of received_ts mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(denEntity.getAk9_number_of_accepted_ts()), "groups, ak9 number of accepted_ts mismatch");
        softAssert.assertEquals(SharedData.getDenGroupCtlNumber(), denEntity.getGroup_ctrl_number(), "Dental group control number");
        softAssert.assertAll();
    }

}
