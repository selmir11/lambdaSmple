package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;
@Data
public class EnPolicyMemberCoverageAhEntity {

    String policy_member_coverage_ah_id;
    String policy_member_ah_id;
    String policy_member_coverage_id;
    String policy_member_id;
    String submission_id;
    String coverage_start_date;
    String coverage_end_date;
    String policy_member_coverage_status;
    String lost_insurance_due_to_non_pmt_ind;
    String disenrollment_reason;
    String current_ind;
}
