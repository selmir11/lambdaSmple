package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

@Data
public class BookOfBusinessQEntity {
    String status;
    String applicationid;
    String policyplanyr;
    String eventtype;
    String policyid;
    String created_ts;
    String routing_key;
    String exchange;
}
