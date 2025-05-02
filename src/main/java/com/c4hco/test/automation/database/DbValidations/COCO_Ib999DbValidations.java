package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ib999Entity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class COCO_Ib999DbValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    List<Ib999Entity> ib999MedEntities = new ArrayList<>();
    ;
    SoftAssert softAssert = new SoftAssert();
    String matchingKey = null;
    public void ib999RecordsValidations() {
        setCocoIb999MedicalData();
        validateIb999Files();
    }

    private void validateIb999Files() {
        List<String> ib999Files = SharedData.getMedicalIb999FileNames();
        for (String ib999File : ib999Files) {
            for (Ib999Entity med999Entity : ib999MedEntities) {
                if (med999Entity.getFilename().equals(ib999File)) {
                    ib999MedRecordsValidations(Integer.parseInt(SharedData.getTransForGrpCtrlNum().get(med999Entity.getAk1_group_ctrl_number())), med999Entity);
                }
            }
        }
    }

    private void setCocoIb999MedicalData() {
        Set<String> medGrpCtrlNums =  SharedData.getMedGroupCtlNumbers();

        for (String medGrpCtrlNum : medGrpCtrlNums) {
            ib999MedEntities.addAll(exchDbDataProvider.getIb999Details(medGrpCtrlNum));
        }
        SharedData.setIb999MedDetailsEntities(ib999MedEntities);
        List<String> cocoMedFileNames = setIb999FileNames(ib999MedEntities);
        SharedData.setMedicalIb999FileNames(cocoMedFileNames);
    }
    private List<String> setIb999FileNames(List<Ib999Entity> ib999Entities) {
        List<String> ib999FileNames = new ArrayList<>();
        for (Ib999Entity ib999Entity : ib999Entities) {
            ib999FileNames.add(ib999Entity.getFilename());
        }
        return ib999FileNames;
    }

    public void ib999MedRecordsValidations(int groups, Ib999Entity medEntity) {
        softAssert.assertEquals("A", medEntity.getAk9_funct_group_ack_code(), "Medical, total groups expected and actual mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_ts_included()), "groups, ak9 number of ts included mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_received_ts()), "groups, ak9 number of received_ts mismatch");
        softAssert.assertEquals(groups, Integer.parseInt(medEntity.getAk9_number_of_accepted_ts()), "groups, ak9 number of accepted_ts mismatch");
        softAssert.assertTrue(SharedData.getMedGroupCtlNumbers().contains(medEntity.getGroup_ctrl_number()), "Medical group control number mismatch");
        softAssert.assertAll();
    }

}
