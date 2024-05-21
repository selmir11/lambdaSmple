package com.c4hco.test.automation.database.Queries;

import com.c4hco.test.automation.Dto.SharedData;

public class DbQueries_Exch {
    String acctId = String.valueOf(SharedData.getPrimaryMember().getAccount_id());
    String dbName = SharedData.getDbName();

    public String policyTablesQuery() {

        return "select eph.account_id, eph.application_id, em.first_name, em.last_name, em.birth_date, em.tobacco_use, epmh.relation_to_subscriber, eph.plan_year, eph.coverage_type, ep2.hios_plan_id, eph.rating_area_id, eph.policy_id,\n" +
                "eph.policy_status, eph.current_ind, eph.effectuated_ind, eph.policy_start_date, eph.policy_end_date, epfh.csr_level, epfh.financial_period_start_date, epfh.financial_period_end_date, epfh.total_plan_premium_amt,\n" +
                "epfh.total_premium_reduction_amt, epfh.premium_reduction_type, epfh.total_csr_amt, epmch.policy_member_coverage_status, epmh.effectuated_ind, epmch.coverage_start_date, epmch.coverage_end_date, epmch.disenrollment_reason,\n" +
                "emcfh.csr_level, emcfh.member_financial_start_date, emcfh.member_financial_end_date,  emcfh.plan_premium_amt, emcfh.premium_reduction_amt, emcfh.premium_reduction_type, emcfh.responsible_amt, eph.policy_submitted_ts, eph.policy_submitted_by\n" +
                "from "+dbName+".es_household eh, "+dbName+".es_application ea,  "+dbName+".es_member em,  "+dbName+".en_policy_ah eph,  "+dbName+".en_plan ep2,  "+dbName+".en_policy_member_ah epmh,\n" +
                " "+dbName+".en_policy_member_coverage_ah epmch,  "+dbName+".en_member_coverage_financial_ah emcfh,  "+dbName+".en_policy_financial_ah epfh,  "+dbName+".en_policy ep\n" +
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
                "and eph.current_ind = '1'";
    }

    public String ob834Details(){
     return "select * from  "+dbName+".ob834_detail\n"+
             "where account_id = '"+acctId+"'\n"+
             "and current_ind = '1'";
    }

    public String getEAPID(){
        return "select exchange_assigned_policy_id, coverage_type from  "+dbName+".en_policy\n" +
                "where account_id = '"+acctId+"'"+ " and policy_status='SUBMITTED'";
    }

    public String getOhiRecords(){
        return "select ohi.*\n" +
                "From  "+dbName+".es_member_other_health_ins ohi\n" +
                "where member_id = '"+SharedData.getPrimaryMemberId()+"'";
    }

    public String getRatingArea(String fipcode){
        return "select * from"+dbName+"en_rating_area"+
                "where fips = '"+fipcode+"'";
    }

    public String getFipcode(String zipCode){
        return "select fip_code from qa_exch.es_zip_codes \n" +
                "where code = '"+zipCode+"'";
    }

    public String en_plan(String planName){
        return "select * from qa_exch.en_plan ep \n" +
                "where plan_marketing_name = '"+planName+"'" +
                "and plan_year = '2024'\n" +
                "limit 1";
    }

    public String en_issuer(String hiosIssuerId){
        return "select name, tin_num from qa_exch.en_issuer ei\n" +
                "where hios_issuer_id = '"+hiosIssuerId+"'"+
                "and plan_year = '2024'";
    }

}
