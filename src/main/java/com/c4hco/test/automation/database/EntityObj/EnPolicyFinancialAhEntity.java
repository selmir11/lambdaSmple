package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

@Data
public class EnPolicyFinancialAhEntity {
    String policy_financial_ah_id;
    String policy_ah_id;
    String policy_financial_id;
    String policy_id;
    String financial_period_start_date;
    String financial_period_end_date;
    String total_plan_premium_amt;
    String total_premium_reduction_amt;
    String total_responsible_amt;
    String total_csr_amt;
    String total_slcsp_amt;
    String created_ts;
    String updated_ts;
    String created_by;
    String updated_by;
    String current_ind;
    String premium_reduction_type;
    String csr_level;
}
