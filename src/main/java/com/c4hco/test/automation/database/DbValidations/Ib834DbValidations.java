package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.Edi.Edi834TransactionDetails;
import com.c4hco.test.automation.Dto.Edi.Transaction;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ib834Entity;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Ib834DbValidations {
    SoftAssert softAssert = new SoftAssert();
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    Ib834Entity subscriberIb834MedEntity = new Ib834Entity();
    Ib834Entity subscriberIb834DenEntity = new Ib834Entity();
    Edi834TransactionDetails edi834TransactionDetails = null;
    Transaction transaction = null;
    private void setIb834Data(){
        List<Ib834Entity> ib834MedEntity = exchDbDataProvider.getIb834Details(SharedData.getMedGroupCtlNumber());
        SharedData.setIb834MedDetailsEntities(ib834MedEntity);
        List<Ib834Entity> ib834DenEntity = exchDbDataProvider.getIb834Details(SharedData.getDenGroupCtlNumber());
        SharedData.setIb834DenDetailsEntities(ib834DenEntity);
    }

    public void ib834DbRecordsValidations(String recordType) {
        setIb834Data();
        Ib834Entity medIb834Entity  = SharedData.getIb834MedDetailsEntities().get(0);
        Ib834Entity denIb834Entity  = SharedData.getIb834DenDetailsEntities().get(0);
        switch (recordType) {
            case "medical":
                ib834MedRecordsValidations(medIb834Entity);
                break;
            case "dental":
                ib834DenRecordsValidations(denIb834Entity);
                break;
            default:
                Assert.fail("Record Type entered is not valid");
        }
        softAssert.assertAll();
    }

    public void ib834MedRecordsValidations(Ib834Entity medIb834Entity){
        System.out.println("medIb834Entity:: "+medIb834Entity);
        SharedData.setMedicalIb834FileName(medIb834Entity.getFilename());

        getib834MedEntityForSubscriber();
        List<Ib834Entity> medEntityList = SharedData.getIb834MedDetailsEntities();
        getDataByEmailAndAccNum();
//        validateSubscriberSegments(subscriberIb834MedEntity);
//        validateMemSeg(medEntityList);
    }

    private void getDataByEmailAndAccNum() {

    }

    private void getib834MedEntityForSubscriber() {
        List<Ib834Entity> medIb834EntityList = SharedData.getIb834MedDetailsEntities();
        for(Ib834Entity medEntity:medIb834EntityList){
            if(medEntity.getMember_first_name().toLowerCase().contains("primary")){
                subscriberIb834MedEntity = medEntity;
                break;
            }
        }
    }

    private void ib834DenRecordsValidations(Ib834Entity denIb834Entity) {

   }
}
