package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

@Data
public class EnMemberEffectiveDatesEntity {
    String member_effective_dates_id;
    String application_id;
    String member_id;
    String plan_year;
    String new_policy_start_date;
    String plan_change_start_date;
    String policy_change_effective_date;
    String coverage_end_date;
    String financial_end_date;
    String run_date;
    String new_policy_start_date_code;
    String exch_person_id;
    String created_ts;
    String updated_ts;
    String created_by;
    String updated_by;

}
