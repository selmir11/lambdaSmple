package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

@Data
public class EnMemberCoverageFinancialAhEntity {
    String member_coverage_financial_ah_id;
    String policy_member_coverage_ah_id;
    String member_coverage_financial_id;
    String policy_member_coverage_id;
    String submission_id;
    String member_financial_start_date;
    String member_financial_end_date;
    String plan_premium_amt;
    String premium_reduction_amt;
    String responsible_amt;
    String csr_amt;
    String slcsp_amt;
    String premium_reduction_type;
    String csr_level;
}
