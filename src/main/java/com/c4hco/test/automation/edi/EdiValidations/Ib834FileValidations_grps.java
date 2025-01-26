package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.Edi.Edi834.Edi834TransactionDetails;
import com.c4hco.test.automation.Dto.Edi.Edi834.Transaction;
import com.c4hco.test.automation.database.EntityObj.Ib834Entity;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Ib834FileValidations_grps {

    Edi834TransactionDetails ib834TransactionDetails = null;
    Transaction transaction = null;
    Ib834Entity subscriberMedEntity = new Ib834Entity();
    Ib834Entity subscriberDenEntity = new Ib834Entity();

    List<String> n1ListWithAddtlMaintReas = new ArrayList<>();

    List<String> n1ListWithAddtlMaintReasMem = new ArrayList<>();
    int segCount = 0;
    int insSegCount = 0;
    SoftAssert softAssert = new SoftAssert();
//    public Ib834FileValidations(){
//        setN1SegList();
//    }


    public void validateIb834MedFile(String medFile) {
//        getIb834MedEntityForSubscriber();
//        List<Ib834Entity> medicalEntityList = SharedData.getIb834MedDetailsEntities();
//        getIb834DataByEmailAndAccNum();
//        segCount = 0;
//        insSegCount = 0;
//        validateSubscriberSegments(subscriberMedEntity);
//        validateMemSeg(medicalEntityList);
//        validateSegCount();
    }
    public void validateIb834DenFile(String denFile){
//        getIb834DenEntityForSubscriber();
//        List<Ib834Entity> dentalEntityList = SharedData.getIb834DenDetailsEntities();
//        getIb834DataByEmailAndAccNum();
//        segCount = 0;
//        insSegCount = 0;
//        validateSubscriberSegments(subscriberDenEntity);
//        validateMemSeg(dentalEntityList);
//        validateSegCount();
    }
}



