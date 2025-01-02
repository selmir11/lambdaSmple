package com.c4hco.test.automation.database.EntityObj;
import lombok.Data;

@Data
public class EsSelfAttestationEntity {
    String attests_to_income;
    String attests_to_aptc_received;
    String attests_to_aptc_tax_reporting;
    String attests_to_aptc_future_tax_reporting;
    String outcome;
}
