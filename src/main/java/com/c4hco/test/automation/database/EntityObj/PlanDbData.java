package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlanDbData {
    // WIP- need to add primary key for group/member ?
    String planName;
    String baseId;
    String hiosIssuerId;
    String issuerName;
    String issuerId;
    String csrAmt;
    BigDecimal premiumAmt;
}
