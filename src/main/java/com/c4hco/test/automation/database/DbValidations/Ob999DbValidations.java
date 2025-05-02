package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ob999Entity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ob999DbValidations {
    SoftAssert softAssert = new SoftAssert();
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    List<Ob999Entity> ob999MedEntities;
    List<Ob999Entity> ob999DenEntities;

    private void setOb999MedicalData(){
        Set<String> medGrpCtrlNums = SharedData.getMedGroupCtlNumbers();
        for(String medGrpCtrlNum: medGrpCtrlNums){
            ob999MedEntities = exchDbDataProvider.getOb999Details(medGrpCtrlNum);
        }

        SharedData.setOb999MedDetailsEntities(ob999MedEntities);
        List<String> medFileNames = setOb999FileNames(ob999MedEntities);
        SharedData.setMedicalOb999FileNames(medFileNames);
    }

    private void setOb999DentalData(){
        List<String> denGrpCtrlNums = SharedData.getDenGroupCtlNumbers();
        Set<String> uniqueDenGrpCtrlNum = new HashSet<>(denGrpCtrlNums);
        for(String denGrpCtrlNum: uniqueDenGrpCtrlNum){
            ob999DenEntities = exchDbDataProvider.getOb999Details(denGrpCtrlNum);
        }
        SharedData.setOb999DenDetailsEntities(ob999DenEntities);
        List<String> denFileNames = setOb999FileNames(ob999DenEntities);
        SharedData.setDentalOb999FileNames(denFileNames);
    }

    private List<String> setOb999FileNames(List<Ob999Entity> ob999Entities){
        List<String> fileNames = new ArrayList<>();
        for(Ob999Entity ob999Entity: ob999Entities){
            fileNames.add(ob999Entity.getFilename());
        }
        return fileNames;
    }

    public void ob999RecordsValidations(String recordType) {
        switch (recordType) {
            case "medical":
                setOb999MedicalData();
                for(Ob999Entity medOb999Entity: ob999MedEntities){
                    ob999MedRecordsValidations(Integer.parseInt(SharedData.getIb834transForGrpCtrlNum().get(medOb999Entity.getAk1_group_ctrl_number())), medOb999Entity);
                }

                break;
            case "dental":
                setOb999DentalData();
                for(Ob999Entity den999Entity: ob999MedEntities) {
                    ob999DenRecordsValidations(Integer.parseInt(SharedData.getIb834transForGrpCtrlNum().get(den999Entity.getAk1_group_ctrl_number())), den999Entity);
                }
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
