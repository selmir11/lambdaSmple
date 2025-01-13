package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.*;
import com.c4hco.test.automation.database.dbDataProvider.COCO_DbDataProvider;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class COCO_DbValidations {
    COCO_DbDataProvider cocoDbDataProvider = new COCO_DbDataProvider();
    SoftAssert softAssert = new SoftAssert();
    String formattedDate; //formatted in YYYY-MM-DD

    public String getCurrentdate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter dateCreateUpdateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formattedDate = currentDate.format(dateCreateUpdateformat);
        return currentDate.format(formatter);
    }
    public void validatePolicyDqCheck(int keysetSize) {
        Map<String, String> policyAhId = cocoDbDataProvider.getPolicyDqCheckAndPolicyAhId();
        softAssert.assertEquals(policyAhId.keySet().size(), keysetSize, "Policy Ah Id keyset size does not match");
        for (String key : policyAhId.keySet()) {
            softAssert.assertEquals(policyAhId.get(key), "0", "Doesn't match policyAhId.get(key)");
        }
        softAssert.assertAll();
    }
    public void validateBookOfBusinessQ(String eventType) {
        getCurrentdate();
        List<BookOfBusinessQEntity> bookOfBusinessQList = cocoDbDataProvider.getBookOfBusinessQ(eventType);
        List<String> policyIdListFromBookOfBusinessDb = new ArrayList<>();
        List<String> applicationIdListFromBob = new ArrayList<>();

        // WIP - get these from existing policyTables instead of new tables/queries.
        List<String> applicationIdListFromPolicyAh = cocoDbDataProvider.getApplicationId();
        List<String> policyIdFromPolicyDB = cocoDbDataProvider.getPolicyId();

        for (BookOfBusinessQEntity bookOfBusinessQEntity : bookOfBusinessQList) {
            softAssert.assertEquals(bookOfBusinessQEntity.getExchange(), "c4hco_direct_exchange", "Bob exchange mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getRouting_key(), "book_of_business_q", "Bob routing key mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getPolicyplanyr(), SharedData.getPlanYear(), "Bob plan year mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getStatus(), "PROCESSED", "BOB Status mismatch");
            softAssert.assertTrue(bookOfBusinessQEntity.getCreated_ts().contains(formattedDate), "Bob created date mismatch");
            softAssert.assertEquals(bookOfBusinessQEntity.getEventtype(), eventType, "Bob, event type updated does not match " + eventType);
            policyIdListFromBookOfBusinessDb.add(bookOfBusinessQEntity.getPolicyid());
            applicationIdListFromBob.add(bookOfBusinessQEntity.getApplicationid());
        }
        softAssert.assertEquals(applicationIdListFromPolicyAh.size(), bookOfBusinessQList.size(), "No of records does not match for event type " + eventType);
        softAssert.assertTrue(new HashSet<>(applicationIdListFromBob).containsAll(applicationIdListFromPolicyAh), "application id mismatch");
        softAssert.assertTrue(new HashSet<>(policyIdListFromBookOfBusinessDb).containsAll(policyIdFromPolicyDB), "Policy Id mismatch ");
        softAssert.assertAll();

    }
 }
