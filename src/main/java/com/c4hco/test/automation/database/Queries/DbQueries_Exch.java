package com.c4hco.test.automation.database.Queries;

import com.c4hco.test.automation.Dto.SharedData;

public class DbQueries_Exch {
    String acctId = String.valueOf(SharedData.getPrimaryMember().getAccount_id());
    String applicationId = SharedData.getPrimaryMember().getApplication_id();
    String agencyName = (SharedData.getBroker() != null) ? SharedData.getBroker().getAgencyName() : null;

    String dbName = SharedData.getDbName();

    public String policyTablesQuery() {

        return "select eph.account_id, eph.application_id, em.first_name, em.last_name, em.birth_date, em.tobacco_use, epmh.relation_to_subscriber, eph.plan_year, eph.coverage_type, ep2.hios_plan_id, eph.rating_area_id, eph.policy_id,\n" +
                "eph.policy_status, eph.current_ind, eph.effectuated_ind, eph.policy_start_date, eph.policy_end_date, epfh.csr_level, epfh.financial_period_start_date, epfh.financial_period_end_date, epfh.total_plan_premium_amt,\n" +
                "epfh.total_premium_reduction_amt, epfh.premium_reduction_type, epfh.total_csr_amt, epmch.policy_member_coverage_status,epmh.member_id, epmh.effectuated_ind, epmch.coverage_start_date, epmch.coverage_end_date, epmch.disenrollment_reason,\n" +
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
     return "select * from  "+dbName+".ob834_detail\n "+
             "where account_id = '"+acctId+"'\n "+
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

    public String getPrimaryHraRecords(){
        return "select *\n" +
                "From  "+dbName+".es_member_hra\n" +
                "where member_id = '"+SharedData.getPrimaryMemberId()+"'";
    }

    public String getRatingArea(String fipcode){
        return "select name from "+dbName+".en_rating_area "+
                "where fips = '"+fipcode+"'";
    }

    public String getFipcode(String zipCode){
        return "select fip_code from "+dbName+".es_zip_codes " +
                "where code = '"+zipCode+"'";
    }

    public String en_plan(String planName){
        return "select * from "+dbName+".en_plan ep \n" +
                "where plan_marketing_name = '"+planName+"'" +
                "and plan_year = '2024'\n" +
                "limit 1";
    }

    public String en_issuer(String hiosIssuerId){
        return "select name, tin_num from "+dbName+".en_issuer ei\n" +
                "where hios_issuer_id = '"+hiosIssuerId+"'"+
                "and plan_year = '2024'";
    }

    public String exchPersonId(){
        return "select  exch_person_id from "+dbName+".es_member where member_id='"+SharedData.getPrimaryMemberId()+"'";
    }
    public String csrLevel(){
        return "SELECT csr_level FROM "+dbName+".en_member_coverage_financial_ah\n" +
                "\twhere application_id='"+applicationId+"' limit 1";
    }
    public String brokerId() {
        return "SELECT agency_tin_ein FROM "+dbName+".bp_agency where agency_name = '"+agencyName+"'";
    }
    public String getMemberMedFinancialRecords(){
        return "SELECT mcf.member_financial_start_date, mcf.member_financial_end_date, mcf.plan_premium_amt, mcf.premium_reduction_amt, \n" +
                "mcf.responsible_amt, mcf.csr_amt, mcf.premium_reduction_type, mcf.csr_level, p.coverage_type\n" +
                "FROM  "+dbName+".en_member_coverage_financial_ah mcf\n" +
                "JOIN "+dbName+".en_policy_member_coverage_ah pmc ON mcf.policy_member_coverage_id = pmc.policy_member_coverage_id\n" +
                "JOIN "+dbName+".en_policy_member_ah pm ON pmc.policy_member_id = pm.policy_member_id\n" +
                "JOIN "+dbName+".en_policy_ah p ON pm.policy_id = p.policy_id\n" +
                "WHERE p.account_id = '"+acctId+"'"+ " and coverage_type=1";
    }

    public String getCSRRecords(){
        return "SELECT mcf.csr_amt, p.coverage_type\n" +
                "FROM  "+dbName+".en_member_coverage_financial_ah mcf\n" +
                "JOIN "+dbName+".en_policy_member_coverage_ah pmc ON mcf.policy_member_coverage_id = pmc.policy_member_coverage_id\n" +
                "JOIN "+dbName+".en_policy_member_ah pm ON pmc.policy_member_id = pm.policy_member_id\n" +
                "JOIN "+dbName+".en_policy_ah p ON pm.policy_id = p.policy_id\n" +
                "WHERE p.account_id = '"+acctId+"'";
    }

    public String getPolicyDqCheck(){
        return "select eph.policy_ah_id, "+dbName+".en_policy_dq_check(policy_ah_id) from en_policy_ah eph where account_id = "+acctId;
    }

    public String setEnvForDataQuality(){
        return  "set search_path ="+dbName;
    }

    public String getBookOfBusinessQ(){
        return "select status, message->> 'applicationId' as applicationId, message->> 'policyPlanYr' as policyPlanYr, message->> 'eventType' as eventType, message->> 'policyId' as policyId, created_ts, routing_key, exchange from "+dbName+".rq_queue_messages\n" +
                "where application_id = 'book_of_business_q:policy-svc'\n" +
                "and message->>'householdAccountId' = '"+acctId+"'\n" +
                "ORDER BY created_ts desc";
    }
    public String policyId(){
        return "select ep.policy_id, ep.coverage_type from "+dbName+".en_policy ep \n" +
                "where account_id =  '"+acctId+"' ORDER BY created_ts desc";
    }

    public String getAcct_holder_fnFromBOB(){
        return "select acct_holder_fn from  "+dbName+".bp_book_of_business\n "+
                "where account_id = '"+acctId+"'";
    }
    //Policy table queries
    public String enPolicyAh(){
        return "select eph.policy_id, eph.application_id, eph.plan_id, eph.plan_year, eph.coverage_type, eph.rating_area_id, eph.policy_status, eph.current_ind, eph.effectuated_ind, eph.policy_start_date, eph.policy_end_date from "+dbName+".en_policy_ah eph \n" +
                "where account_id = '"+ acctId+"'";
    }

    public String enMem_Coverage_FinancialAh(){
        return "select emcfh.member_coverage_financial_ah_id, emcfh.policy_member_coverage_ah_id, emcfh.member_coverage_financial_id, emcfh.policy_member_coverage_id, \n" +
                "emcfh.submission_id, emcfh.member_financial_start_date, emcfh.member_financial_end_date, emcfh.plan_premium_amt, emcfh.premium_reduction_amt, \n" +
                "emcfh.responsible_amt, emcfh.csr_amt, emcfh.slcsp_amt, emcfh.premium_reduction_type, emcfh.csr_level \n"+
                "from "+dbName+".en_member_coverage_financial_ah emcfh \n"+
                "where application_id = '"+ applicationId+"'";
    }

    public String enPolicy_Mem_CoverageAh(){
        return "select epmch.policy_member_coverage_ah_id, epmch.policy_member_ah_id, epmch.policy_member_coverage_id, epmch.policy_member_id, epmch.submission_id, epmch.coverage_start_date, \n" +
                "epmch.coverage_end_date, epmch.policy_member_coverage_status, epmch.lost_insurance_due_to_non_pmt_ind, epmch.disenrollment_reason, epmch.current_ind \n" +
                "from "+dbName+".en_policy_member_coverage_ah epmch \n"+
                "where application_id = '"+ applicationId+"'";
    }
    public String enPolicyFinancialAh(){
        return "select * from "+dbName+".en_policy_financial_ah\n " +
                "where policy_id in (select policy_id from "+dbName+".en_policy where account_id = '"+acctId+"')";
    }
    public String enPolicyMemberAh(){
        return "select * from "+dbName+".en_policy_member_ah \n" +
                "where application_id = '"+applicationId+"'";
    }
}
