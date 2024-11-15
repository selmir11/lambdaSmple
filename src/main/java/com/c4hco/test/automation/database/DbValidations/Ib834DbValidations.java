package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.Ib834Entity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.c4hco.test.automation.utils.BasicActions.isSSNValid;

public class Ib834DbValidations {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    List<Ib834Entity> ib834MedEntities = new ArrayList<>();
    List<Ib834Entity> ib834DenEntities = new ArrayList<>();
    SoftAssert softAssert = new SoftAssert();
    MemberDetails subscriber = SharedData.getPrimaryMember();
    DbData dbData;
    private void setIb834Data(){
        List<Ib834Entity> ib834MedEntity = exchDbDataProvider.getIb834Details(SharedData.getMedGroupCtlNumber());
        SharedData.setIb834MedDetailsEntities(ib834MedEntity);
        List<Ib834Entity> ib834DenEntity = exchDbDataProvider.getIb834Details(SharedData.getDenGroupCtlNumber());
        SharedData.setIb834DenDetailsEntities(ib834DenEntity);

        ib834MedEntities = SharedData.getIb834MedDetailsEntities();
        ib834DenEntities = SharedData.getIb834DenDetailsEntities();
    }

    public void ib834DbRecordsValidations(String recordType, List<Map<String, String>> expectedValues) {
        setIb834Data();
        Ib834Entity medIb834Entity  = SharedData.getIb834MedDetailsEntities().get(0);
        SharedData.setMedicalIb834FileName(medIb834Entity.getFilename());
        Ib834Entity denIb834Entity  = SharedData.getIb834DenDetailsEntities().get(0);
        SharedData.setDentalIb834FileName(denIb834Entity.getFilename());
        switch (recordType) {
            case "medical":
                ib834MedRecordsValidations(medIb834Entity, expectedValues);
                break;
            case "dental":
//                ib834DenRecordsValidations(denIb834Entity, expectedValues);
                break;
            default:
                Assert.fail("Record Type entered is not valid");
        }
        softAssert.assertAll();
    }

    private void ib834MedRecordsValidations(Ib834Entity ib834MedEntity, List<Map<String, String>> expectedValues) {
        for (Ib834Entity ib834Entity : ib834MedEntities) {
            if (ib834Entity.getSubscriber_indicator().equals("Y")) {
                subscriberOnlyMedDenFields(ib834MedEntity);
                // validateMedDenForSubscriberAndMem(ib834MedEntity, subscriber);
            } else {
                //   validateDependentMedDenDetails(ib834MedEntity);
            }
            //medDenValidationsCommonForAllMem(ib834MedEntity);
            //medValidationsCommonForAllMembers(ib834MedEntity, expectedValues);
        }
        softAssert.assertAll();
    }
    private void subscriberOnlyMedDenFields(Ib834Entity ib834MedEntity) {
        // Subscriber Only Fields
        softAssert.assertEquals(subscriber.getFullName(), ib834MedEntity.getPlan_sponsor_name(), "Plan sponsor name did not match");
        softAssert.assertEquals(subscriber.getAlternatePhNum() != null ? subscriber.getAlternatePhNum() : subscriber.getPhoneNumber(), ib834MedEntity.getAlternate_phone(), "alternate phone did not match");
        softAssert.assertEquals(ib834MedEntity.getSubscriber_id(), ib834MedEntity.getMember_id(), "Subscriber_id and Member_id in ob834 entity does not match");
        validateSponsorId(ib834MedEntity);
        validateResidentialAddress(ib834MedEntity);
        validateMailingAddress(ib834MedEntity);
        softAssert.assertAll();
    }
    private void validateSponsorId(Ib834Entity ib834MedEntity){
        boolean validSSN = isSSNValid(SharedData.getPrimaryMember().getSsn());
        if (validSSN) {
            softAssert.assertEquals(subscriber.getSsn(), ib834MedEntity.getSponsor_id(), "Sponsor_id did not match");
        }
        softAssert.assertAll();
    }
    private void validateResidentialAddress(Ib834Entity ib834MedEntity) {
        dbData  = SharedData.getDbData();
        softAssert.assertEquals(subscriber.getResAddress().getAddressLine1(), ib834MedEntity.getResidence_street_line1(), "Residential address line 1 does not match");
        if (subscriber.getResAddress().getAddressLine2() != null) {
            softAssert.assertEquals(subscriber.getResAddress().getAddressLine2(), ib834MedEntity.getResidence_street_line2(), "Residential line2 is null");
        } else {
            softAssert.assertNull(ib834MedEntity.getResidence_street_line2(), "Residential address line 2 is not null");
        }
        softAssert.assertEquals(subscriber.getResAddress().getAddressCity(), ib834MedEntity.getResidence_city(), "Residential address city does not match");
        softAssert.assertEquals(subscriber.getResAddress().getAddressState(), ib834MedEntity.getResidence_st(), "Residential address state does not match");
        softAssert.assertEquals(subscriber.getResAddress().getAddressZipcode(), ib834MedEntity.getResidence_zip_code(), "Residential address zipcode does not match");
        softAssert.assertEquals(dbData.getFipcode(), ib834MedEntity.getResidence_fip_code(), "Residential address fipcode does not match");
        softAssert.assertAll();
    }
    private void validateMailingAddress(Ib834Entity ib834MedEntity) {
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressLine1(), ib834MedEntity.getMail_street_line1(), "Mailing address street line 1 does not match");
        if (subscriber.getMailingAddress().getAddressLine2() != null) {
            softAssert.assertEquals(subscriber.getMailingAddress().getAddressLine2(), ib834MedEntity.getMail_street_line2(), "Mailing address street line 2 does not match");
        } else {
            softAssert.assertNull(ib834MedEntity.getMail_street_line2(), "Mailing address street line 2 is not null");
        }
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressCity(), ib834MedEntity.getMail_city(), "Mailing city does not match");
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressState(), ib834MedEntity.getMail_st(), "Mailing state does not match");
        softAssert.assertEquals(subscriber.getMailingAddress().getAddressZipcode(), ib834MedEntity.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertNull(ib834MedEntity.getMail_fip_code(), "Mailing fipcode is not null");
        softAssert.assertAll("Mailing Address did not match for "+subscriber.getFirstName());
        softAssert.assertAll();
    }

}
