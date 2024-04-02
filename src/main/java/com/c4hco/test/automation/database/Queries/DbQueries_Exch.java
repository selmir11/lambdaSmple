package com.c4hco.test.automation.database.Queries;

import com.c4hco.test.automation.Dto.SharedData;

public class DbQueries_Exch {
    // Find OUT -- if both exch and coco has same tables and columns - if yes - get appType and pass. If not, keep coco and exch queries seperate.
    // get the env and pass it dynamically. So this works for both qa and staging - findOut the table names for qa_exch and qa_staging is correct
    // Find Out: Will the commented out columns be used in tests later? - For all the queries

    String acctId = String.valueOf(SharedData.getPrimaryMember().getAccount_id());

    public String combinedQuery() {
        return "select eph.account_id, eph.application_id, em.first_name, em.last_name, em.birth_date, em.tobacco_use, epmh.relation_to_subscriber, eph.plan_year, eph.coverage_type, ep2.hios_plan_id, eph.rating_area_id, eph.policy_id,\n" +
                "eph.policy_status, eph.current_ind, eph.effectuated_ind, eph.policy_start_date, eph.policy_end_date, epfh.csr_level, epfh.financial_period_start_date, epfh.financial_period_end_date, epfh.total_plan_premium_amt,\n" +
                "epfh.total_premium_reduction_amt, epfh.premium_reduction_type, epfh.total_csr_amt, epmch.policy_member_coverage_status, epmh.effectuated_ind, epmch.coverage_start_date, epmch.coverage_end_date, epmch.disenrollment_reason,\n" +
                "emcfh.csr_level, emcfh.member_financial_start_date, emcfh.member_financial_end_date,  emcfh.plan_premium_amt, emcfh.premium_reduction_amt, emcfh.premium_reduction_type, emcfh.responsible_amt, eph.policy_submitted_ts, eph.policy_submitted_by\n" +
                "from qa_exch.es_household eh, qa_exch.es_application ea, qa_exch.es_member em, qa_exch.en_policy_ah eph, qa_exch.en_plan ep2, qa_exch.en_policy_member_ah epmh,\n" +
                "qa_exch.en_policy_member_coverage_ah epmch, qa_exch.en_member_coverage_financial_ah emcfh, qa_exch.en_policy_financial_ah epfh, qa_exch.en_policy ep\n" +
                "where eh.household_id = ea.household_id\n" +
                "and ea.application_id = eph.application_id\n" +
                "and ep.plan_id = ep2.plan_id\n" +
                "and em.member_id = epmh.member_id\n" +
                "and em.household_id = eh.household_id\n" +
                "and em.exch_person_id = epmh.exch_person_id\n" +
                "and epmh.policy_member_id = epmch.policy_member_id\n" +
                "and eph.policy_id = epmh.policy_id\n" +
                "and epmch.policy_member_coverage_id = emcfh.policy_member_coverage_id\n" +
                "and ep.policy_id = eph.policy_id\n" +
                "and ep.policy_id = epfh.policy_id\n" +
                "and eh.account_id = '"+acctId+"'\n" +
                "and eph.current_ind = '1'\n" +
                "ORDER BY eph.coverage_type ASC";

    }

    public String ob834Details(){
     return "select * from qa_exch.ob834_detail\n"+
             "where account_id = '"+acctId+"'\n"+
             "and current_ind = '1'";
    }

}
