package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

@Data
public class EnPolicyAhEntity {
    String policy_id;
    String application_id;
    String plan_id;
    String plan_year;
    String coverage_type;
    String rating_area_id;
    String policy_status;
    String current_ind;
    String effectuated_ind;
    String policy_start_date;
    String policy_end_date;
}
