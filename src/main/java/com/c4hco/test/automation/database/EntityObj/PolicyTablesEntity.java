package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

@Data
public class PolicyTablesEntity
{
    String account_id;
    String application_id;
    String first_name;
    String last_name;
    String birth_date;
    String tobacco_use;
    String relation_to_subscriber;
    String plan_year;
    String coverage_type;
    String hios_plan_id;
    String rating_area_id;
    String policy_id;
    String exchange_assigned_policy_id;
    String policy_status;
    String current_ind;
    String policy_start_date;
    String policy_end_date;
    String financial_period_start_date;
    String financial_period_end_date;
    String total_plan_premium_amt;
    String total_premium_reduction_amt;
    String total_responsible_amt;
    String total_csr_amt;
    String premium_reduction_type;
    String policy_member_coverage_status;
    String coverage_start_date;
    String coverage_end_date;
    String disenrollment_reason;
    String member_financial_start_date;
    String member_financial_end_date;
    String plan_premium_amt;
    String premium_reduction_amt;
    String responsible_amt;
    String policy_submitted_ts;
    String policy_submitted_by;
    String effectuated_ind_eph;
    String effectuated_ind_epmh;
    String premium_reduction_type_emcfh;
    String premium_reduction_type_epfh;
    String csr_level_epfh;
    String csr_level_emcfh;
    String subscriber_ind;
    String responsible_adult_ind;
    String created_by;
    String exch_person_id;
}
