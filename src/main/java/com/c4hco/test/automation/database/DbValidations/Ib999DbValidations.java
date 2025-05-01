package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ib999Entity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Ib999DbValidations {
    SoftAssert softAssert = new SoftAssert();
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    List<Ib999Entity> ib999MedEntities;
    List<Ib999Entity> ib999DenEntities;

    private void setIb999MedicalData(){
        Set<String> medGrpCtrlNums = SharedData.getMedGroupCtlNumbers();
        for(String medGrpCtrlNum: medGrpCtrlNums){
            ib999MedEntities = exchDbDataProvider.getIb999Details(medGrpCtrlNum);
        }

        SharedData.setIb999MedDetailsEntities(ib999MedEntities);
        List<String> medFileNames = setIb999FileNames(ib999MedEntities);
        SharedData.setMedicalIb999FileNames(medFileNames);
    }

    private void setIb999DentalData(){
        List<String> denGrpCtrlNums = SharedData.getDenGroupCtlNumbers();
        for(String denGrpCtrlNum: denGrpCtrlNums){
            ib999DenEntities = exchDbDataProvider.getIb999Details(denGrpCtrlNum);
        }
        SharedData.setIb999DenDetailsEntities(ib999DenEntities);
        List<String> denFileNames = setIb999FileNames(ib999DenEntities);
        SharedData.setDentalIb999FileNames(denFileNames);
    }

    private List<String> setIb999FileNames(List<Ib999Entity> ib999Entities){
        List<String> fileNames = new ArrayList<>();
        for(Ib999Entity ib999Entity: ib999Entities){
            fileNames.add(ib999Entity.getFilename());
        }
        return fileNames;
    }

    public void ib999RecordsValidations(String recordType) {
        switch (recordType) {
            case "medical":
                setIb999MedicalData();
                for(Ib999Entity med999Entity: ib999MedEntities){
                    ib999MedRecordsValidations(Integer.parseInt(SharedData.getTransForGrpCtrlNum().get(med999Entity.getAk1_group_ctrl_number())), med999Entity);
                }
                break;
            case "dental":
                setIb999DentalData();
                for(Ib999Entity den999Entity: ib999DenEntities){
                    ib999DenRecordsValidations(Integer.parseInt(SharedData.getTransForGrpCtrlNum().get(den999Entity.getAk1_group_ctrl_number())), den999Entity);
                }
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
        softAssert.assertTrue(SharedData.getMedGroupCtlNumbers().contains(medEntity.getGroup_ctrl_number()), "Medical group control number mismatch"); // works for multiple groups but only 1 file
        softAssert.assertAll();
    }

    public void ib999DenRecordsValidations(int groups, Ib999Entity denEntity){
        softAssert.assertEquals("A", denEntity.getAk9_funct_group_ack_code(), "Dental, total groups expected and actual mismatch" );
        softAssert.assertEquals(groups, Integer.parseInt(denEntity.getAk9_number_of_ts_included()), "groups, ak9 number of ts included mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(denEntity.getAk9_number_of_received_ts()), "groups, ak9 number of received_ts mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(denEntity.getAk9_number_of_accepted_ts()), "groups, ak9 number of accepted_ts mismatch");
        softAssert.assertEquals(SharedData.getDenGroupCtlNumbers().get(0), denEntity.getGroup_ctrl_number(), "Dental group control number");
        softAssert.assertAll();
    }

}
