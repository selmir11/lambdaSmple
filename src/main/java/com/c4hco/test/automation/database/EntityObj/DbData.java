package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DbData {
    String fipcode;
    String baseId;
    String ratingAreaName;
    String ratingAreaId;
    String hiosIssuerId;
    String issuerName;
    String issuerId;
    String exchPersonId;
    String csrLevel;
    String brokerTinNum;
    String csrAmtMed;
    BigDecimal premiumAmtMed;
    String csrAmtDen;
    BigDecimal premiumAmtDen;
}
