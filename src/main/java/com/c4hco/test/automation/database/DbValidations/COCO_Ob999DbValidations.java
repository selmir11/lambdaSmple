package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.EntityObj.Ob999Entity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class COCO_Ob999DbValidations {

    SoftAssert softAssert = new SoftAssert();
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    List<Ob999Entity> ob999MedEntities = new ArrayList<>();

    public void cocoOb999RecordsValidations() {
        setOb999MedicalData();
        for (Ob999Entity medOb999Entity : ob999MedEntities) {
            ob999MedRecordsValidations(Integer.parseInt(SharedData.getIb834transForGrpCtrlNum().get(medOb999Entity.getAk1_group_ctrl_number())), medOb999Entity);
        }
    }

    private void setOb999MedicalData() {
        Set<String> medGrpCtrlNums = SharedData.getMedGroupCtlNumbers();
        List<Ob999Entity> ob999Ent = new ArrayList<>();
        for (String medGrpCtrlNum : medGrpCtrlNums) {
            ;
            ob999MedEntities = exchDbDataProvider.getOb999Details(medGrpCtrlNum);
            ob999Ent.addAll(ob999MedEntities);
        }

        SharedData.setOb999MedDetailsEntities(ob999Ent);
        List<String> medFileNames = setOb999FileNames(ob999Ent);
        SharedData.setMedicalOb999FileNames(medFileNames);
    }

    private List<String> setOb999FileNames(List<Ob999Entity> ob999Entities) {
        List<String> fileNames = new ArrayList<>();
        for (Ob999Entity ob999Entity : ob999Entities) {
            fileNames.add(ob999Entity.getFilename());
        }
        return fileNames;
    }

    private void ob999MedRecordsValidations(int groups, Ob999Entity medEntity) {
        softAssert.assertEquals("A", medEntity.getAk9_funct_group_ack_code(), "Medical, total groups expected and actual mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_ts_included()), "groups, ak9 number of ts included mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_received_ts()), "groups, ak9 number of received_ts mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_accepted_ts()), "groups, ak9 number of accepted_ts mismatch");
        softAssert.assertAll();
    }
}
