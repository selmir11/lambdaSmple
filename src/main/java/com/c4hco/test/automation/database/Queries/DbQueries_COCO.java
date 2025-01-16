package com.c4hco.test.automation.database.Queries;

import com.c4hco.test.automation.Dto.SharedData;

public class DbQueries_COCO {
    String acctId = SharedData.getPrimaryMember()!=null ? String.valueOf(SharedData.getPrimaryMember().getAccount_id()): "";
    String dbName = SharedData.getDbName();


public String policyTablesCombinedQuery(String coverageType){
    String query = "SELECT eph.account_id, eph.application_id, epmh.exch_person_id, first_name, middle_name, last_name, birth_date::date AS birth_date, tobacco_use, \n" +
            "relation_to_subscriber, eph.plan_year, eph.coverage_type, hios_plan_id, rating_area_id, eph.policy_id,  policy_status, eph.current_ind,\n" +
            "eph.effectuated_ind AS effectuated_ind_eph, policy_start_date, policy_end_date, csr_level_epfh, financial_period_start_date, \n" +
            "financial_period_end_date, total_plan_premium_amt,  total_premium_reduction_amt, total_responsible_amt, premium_reduction_type_epfh, total_csr_amt,\n" +
            "policy_member_coverage_status, epmh.member_id, responsible_adult_ind, subscriber_ind, epmh.created_by, epmh.effectuated_ind AS effectuated_ind_epmh, \n" +
            "coverage_start_date, coverage_end_date, disenrollment_reason, emcfh.csr_level AS csr_level_emcfh, member_financial_start_date, member_financial_end_date, \n" +
            "plan_premium_amt, premium_reduction_amt, emcfh.premium_reduction_type AS premium_reduction_type_emcfh, responsible_amt, policy_submitted_ts, \n" +
            "policy_submitted_by FROM "+dbName+".en_policy_ah eph \n" +
            "INNER JOIN "+dbName+".en_plan ep ON eph.plan_id = ep.plan_id \n" +
            "INNER JOIN "+dbName+".en_policy_member_ah epmh ON eph.policy_ah_id = epmh.policy_ah_id \n" +
            "INNER JOIN (SELECT ROW_NUMBER() OVER (PARTITION BY policy_member_ah_id \n" +
            "ORDER BY CASE WHEN coverage_end_date > coverage_start_date THEN 1 ELSE 2 END,\n" +
            "coverage_end_date DESC, coverage_start_date DESC, policy_member_coverage_ah_id DESC) AS mySeq, * \n" +
            "FROM "+dbName+".en_policy_member_coverage_ah) epmch ON epmh.policy_member_ah_id = epmch.policy_member_ah_id \n" +
            "AND epmch.mySeq = 1 INNER JOIN (SELECT ROW_NUMBER() OVER (\n" +
            "PARTITION BY policy_member_coverage_ah_id ORDER BY \n" +
            "CASE WHEN member_financial_end_date > member_financial_start_date THEN 1 ELSE 2 END, \n" +
            "member_financial_end_date DESC, member_financial_start_date DESC, member_coverage_financial_ah_id DESC) AS mySeq, * \n" +
            "FROM "+dbName+".en_member_coverage_financial_ah) emcfh ON \n" +
            "epmch.policy_member_coverage_ah_id = emcfh.policy_member_coverage_ah_id \n" +
            "AND emcfh.mySeq = 1 \n" +
            "INNER JOIN "+dbName+".es_member em ON epmh.member_id = em.member_id \n" +
            "LEFT JOIN( SELECT ROW_NUMBER() OVER(PARTITION BY policy_ah_id ORDER BY \n" +
            "CASE WHEN financial_period_end_date > financial_period_start_date THEN 1 ELSE 2 END, \n" +
            "financial_period_end_date DESC, financial_period_start_date DESC, policy_financial_ah_id DESC) AS mySeq,\n" +
            "policy_ah_id, financial_period_start_date, financial_period_end_date, total_premium_reduction_amt,\n" +
            "total_plan_premium_amt, total_csr_amt, total_responsible_amt,\n" +
            "csr_level AS csr_level_epfh, premium_reduction_type AS premium_reduction_type_epfh \n" +
            "FROM "+dbName+".en_policy_financial_ah) pf \n" +
            "ON eph.policy_ah_id = pf.policy_ah_id \n" +
            "AND epmh.relation_to_subscriber = 'SELF' \n" +
            "AND pf.mySeq = 1\n" +
            "where eph.account_id = '"+acctId+"' \n" +
            "AND eph.current_ind = '1' \n" +
            "AND eph.coverage_type = '"+coverageType+"'" +
            "and eph.policy_status != 'CANCELLED'";
    return query;
}
    public String getFipcode(String zipCode) {
        return "select fips from " + dbName + ".en_county " +
                "where zip = '" + zipCode + "'";
    }

}
