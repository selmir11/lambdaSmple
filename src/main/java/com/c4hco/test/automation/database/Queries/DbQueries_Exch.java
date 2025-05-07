package com.c4hco.test.automation.database.Queries;

import com.c4hco.test.automation.Dto.SharedData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DbQueries_Exch {
    String acctId = SharedData.getPrimaryMember() != null ? String.valueOf(SharedData.getPrimaryMember().getAccount_id()) : "";
    String applicationId = SharedData.getPrimaryMember() != null ? SharedData.getPrimaryMember().getApplication_id() : "";
    String dbName = SharedData.getDbName();

    public String policyTablesQuery() {

        return "select eph.account_id, eph.application_id,em.exch_person_id, em.first_name, em.last_name, em.birth_date, em.tobacco_use, epmh.relation_to_subscriber, eph.plan_year, eph.coverage_type, ep2.hios_plan_id, eph.rating_area_id, eph.policy_id,\n" +
                "eph.policy_status, eph.current_ind, eph.effectuated_ind as effectuated_ind_eph, eph.policy_start_date, eph.policy_end_date, epfh.csr_level as csr_level_epfh, epfh.financial_period_start_date, epfh.financial_period_end_date, epfh.total_plan_premium_amt,\n" +
                "epfh.total_premium_reduction_amt, epfh.total_responsible_amt, epfh.premium_reduction_type as premium_reduction_type_epfh, epfh.total_csr_amt, epmch.policy_member_coverage_status,epmh.member_id, epmh.responsible_adult_ind, epmh.subscriber_ind, epmh.created_by, epmh.effectuated_ind as effectuated_ind_epmh, epmch.coverage_start_date, epmch.coverage_end_date, epmch.disenrollment_reason,\n" +
                "emcfh.csr_level as csr_level_emcfh, emcfh.member_financial_start_date, emcfh.member_financial_end_date,  emcfh.plan_premium_amt, emcfh.premium_reduction_amt, emcfh.premium_reduction_type as premium_reduction_type_emcfh, emcfh.responsible_amt, eph.policy_submitted_ts, eph.policy_submitted_by\n" +
                "from " + dbName + ".es_household eh, " + dbName + ".es_application ea,  " + dbName + ".es_member em,  " + dbName + ".en_policy_ah eph,  " + dbName + ".en_plan ep2,  " + dbName + ".en_policy_member_ah epmh,\n" +
                dbName + ".en_policy_member_coverage_ah epmch,  " + dbName + ".en_member_coverage_financial_ah emcfh,  " + dbName + ".en_policy_financial_ah epfh,  " + dbName + ".en_policy ep, \n" +
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
                "and eh.account_id = '" + acctId + "'\n" +
                "and eph.current_ind = '1'";
    }

    public String policyTablesCombinedQuery(String coverageType) {
        String query = "SELECT eph.account_id, eph.application_id, epmh.exch_person_id, first_name, middle_name, last_name, birth_date::date AS birth_date, tobacco_use, \n" +
                "relation_to_subscriber, eph.plan_year, eph.coverage_type, hios_plan_id, rating_area_id, eph.policy_id,  policy_status, eph.current_ind,\n" +
                "eph.effectuated_ind AS effectuated_ind_eph, policy_start_date, policy_end_date, csr_level_epfh, financial_period_start_date, \n" +
                "financial_period_end_date, total_plan_premium_amt,  total_premium_reduction_amt, total_responsible_amt, premium_reduction_type_epfh, total_csr_amt,\n" +
                "policy_member_coverage_status, epmh.member_id, responsible_adult_ind, subscriber_ind, epmh.created_by, epmh.effectuated_ind AS effectuated_ind_epmh, \n" +
                "coverage_start_date, coverage_end_date, disenrollment_reason, emcfh.csr_level AS csr_level_emcfh, member_financial_start_date, member_financial_end_date, \n" +
                "plan_premium_amt, premium_reduction_amt, emcfh.premium_reduction_type AS premium_reduction_type_emcfh, responsible_amt, policy_submitted_ts, \n" +
                "policy_submitted_by FROM " + dbName + ".en_policy_ah eph \n" +
                "INNER JOIN " + dbName + ".en_plan ep ON eph.plan_id = ep.plan_id \n" +
                "INNER JOIN " + dbName + ".en_policy_member_ah epmh ON eph.policy_ah_id = epmh.policy_ah_id \n" +
                "INNER JOIN (SELECT ROW_NUMBER() OVER (PARTITION BY policy_member_ah_id \n" +
                "ORDER BY CASE WHEN coverage_end_date > coverage_start_date THEN 1 ELSE 2 END,\n" +
                "coverage_end_date DESC, coverage_start_date DESC, policy_member_coverage_ah_id DESC) AS mySeq, * \n" +
                "FROM " + dbName + ".en_policy_member_coverage_ah) epmch ON epmh.policy_member_ah_id = epmch.policy_member_ah_id \n" +
                "AND epmch.mySeq = 1 INNER JOIN (SELECT ROW_NUMBER() OVER (\n" +
                "PARTITION BY policy_member_coverage_ah_id ORDER BY \n" +
                "CASE WHEN member_financial_end_date > member_financial_start_date THEN 1 ELSE 2 END, \n" +
                "member_financial_end_date DESC, member_financial_start_date DESC, member_coverage_financial_ah_id DESC) AS mySeq, * \n" +
                "FROM " + dbName + ".en_member_coverage_financial_ah) emcfh ON \n" +
                "epmch.policy_member_coverage_ah_id = emcfh.policy_member_coverage_ah_id \n" +
                "AND emcfh.mySeq = 1 \n" +
                "INNER JOIN " + dbName + ".es_member em ON epmh.member_id = em.member_id \n" +
                "LEFT JOIN( SELECT ROW_NUMBER() OVER(PARTITION BY policy_ah_id ORDER BY \n" +
                "CASE WHEN financial_period_end_date > financial_period_start_date THEN 1 ELSE 2 END, \n" +
                "financial_period_end_date DESC, financial_period_start_date DESC, policy_financial_ah_id DESC) AS mySeq,\n" +
                "policy_ah_id, financial_period_start_date, financial_period_end_date, total_premium_reduction_amt,\n" +
                "total_plan_premium_amt, total_csr_amt, total_responsible_amt,\n" +
                "csr_level AS csr_level_epfh, premium_reduction_type AS premium_reduction_type_epfh \n" +
                "FROM " + dbName + ".en_policy_financial_ah) pf \n" +
                "ON eph.policy_ah_id = pf.policy_ah_id \n" +
                "AND epmh.relation_to_subscriber = 'SELF' \n" +
                "AND pf.mySeq = 1\n" +
                "where eph.account_id = '" + acctId + "' \n" +
                "AND eph.current_ind = '1' \n" +
                "AND eph.coverage_type = '" + coverageType + "'";
        return query;
    }

    public String ob834Details() {
        return "select * from  " + dbName + ".ob834_detail\n " +
                "where account_id = '" + acctId + "'\n " +
                "and current_ind = '1'";
    }

    public String ob834DetailsRecords(String insurance_line_code) {
        return "select * from  " + dbName + ".ob834_detail\n " +
                "where account_id = '" + acctId + "'\n " +
                "and current_ind = '1'\n" +
                "and insurance_line_code = '" + insurance_line_code + "'";
    }

    public String ib999Details(String grpCtlNum) {
        return "SELECT * FROM " + dbName + ".ib999_detail \n" +
                "where ak1_group_ctrl_number = '" + grpCtlNum + "'\n" +
                "and created_ts >= '" + getFormattedCurrentDate() + " 00:00:00'";
    }

    public String ob999Details(String grpCtlNum) {
        return "SELECT * FROM " + dbName + ".ob999_detail \n" +
                "where ak1_group_ctrl_number = '" + grpCtlNum + "'\n" +
                "and created_ts >= '" + getFormattedCurrentDate() + " 00:00:00'";
    }

    public String ib834Details(String grpCtlNum) {
        return "SELECT * FROM " + dbName + ".ib834_detail \n " +
                "where group_ctrl_number = '" + grpCtlNum + "'\n " +
                "and created_ts >= '" + getFormattedCurrentDate() + " 00:00:00'";
    }

    private String getFormattedCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(dateFormat);
    }

    public String getEAPID() {
        return "select exchange_assigned_policy_id, shopping_group_number from  " + dbName + ".en_policy_ah\n" +
                "where account_id = '" + acctId + "'" + " and policy_status='SUBMITTED'";
    }

    public String getMedicalEAPID() {
        return "select exchange_assigned_policy_id, shopping_group_number from  " + dbName + ".en_policy_ah\n" +
                "where account_id = '" + acctId + "'" + " and policy_status='SUBMITTED' and coverage_type ='1'";
    }

    public String getDentalEAPID() {
        return "select exchange_assigned_policy_id, shopping_group_number from  " + dbName + ".en_policy_ah\n" +
                "where account_id = '" + acctId + "'" + " and policy_status='SUBMITTED'\n" +
                "and coverage_type = '2'";
    }

    public String getOhcRecordsAll(String memberId) {
        return "select ohi.*\n" +
                "From  " + dbName + ".es_member_other_health_ins ohi\n" +
                "where member_id = '" + memberId + "'";
    }

    public String getPrimaryHraRecords() {
        return "select *\n" +
                "From  " + dbName + ".es_member_hra\n" +
                "where member_id = '" + SharedData.getPrimaryMember().getMemberId() + "'";
    }

    public String getRatingArea(String fipcode) {
        return "select name from " + dbName + ".en_rating_area " +
                "where fips = '" + fipcode + "'";
    }

    public String getRatingAreaId(String fipcode) {
        return "select rating_area_id from " + dbName + ".en_rating_area " +
                "where fips = '" + fipcode + "'";
    }

    public String getFipcode(String zipCode, String county) {
        return "select fips from " + dbName + ".en_county " +
                "where zip = '" + zipCode + "' and county_name ='"+county+"'";
    }
    public String en_plan(String planName) {
        return "select * from " + dbName + ".en_plan ep \n" +
                "where plan_marketing_name = '" + planName + "'\n" +
                "and plan_year = '" + SharedData.getPlanYear() + "'\n" +
                "limit 1";
    }

    public String en_Dentalplan(String planName) {
        return "select * from " + dbName + ".en_plan ep \n" +
                "where plan_marketing_name = '" + planName + "'\n" +
                "and plan_year = '" + SharedData.getPlanYear() + "'\n" +
                "and qhp_type = '1'\n" +
                "limit 1";
    }

    public String en_issuer(String hiosIssuerId) {
        return "select name, tin_num from " + dbName + ".en_issuer ei\n" +
                "where hios_issuer_id = '" + hiosIssuerId + "'" +
                "and plan_year = '2024'";
    }

    public String exchPersonId(String memId) {
        return "select  exch_person_id from " + dbName + ".es_member where member_id='" + memId + "'";
    }

    public String csrLevel() {
        return "SELECT csr_level FROM " + dbName + ".en_member_coverage_financial_ah\n" +
                "where application_id='" + applicationId + "' \n" +
                "and current_ind = 1 " +
                "limit 1";
    }

    public String commissionTin() {
        return "SELECT bpa.commission_tin\n" +
                "FROM " + dbName + ".bp_client_authorization bpa\n" +
                "JOIN " + dbName + ".es_household eh\n" +
                " ON bpa.household_id = eh.household_id\n" +
                "WHERE eh.account_id = '" + acctId + "'";
    }

    public String getCSRRecords() {
        return "SELECT DISTINCT mcf.csr_amt, p.coverage_type\n" +
                "FROM  " + dbName + ".en_member_coverage_financial_ah mcf\n" +
                "JOIN " + dbName + ".en_policy_member_coverage_ah pmc ON mcf.policy_member_coverage_id = pmc.policy_member_coverage_id\n" +
                "JOIN " + dbName + ".en_policy_member_ah pm ON pmc.policy_member_id = pm.policy_member_id\n" +
                "JOIN " + dbName + ".en_policy_ah p ON pm.policy_id = p.policy_id\n" +
                "WHERE p.account_id = '" + acctId + "'";
    }

    public String getMedCSRRecords_aian() {
        return "SELECT DISTINCT mcf.csr_amt, p.coverage_type\n" +
                "FROM  " + dbName + ".en_member_coverage_financial_ah mcf\n" +
                "JOIN " + dbName + ".en_policy_member_coverage_ah pmc ON mcf.policy_member_coverage_id = pmc.policy_member_coverage_id \n" +
                "JOIN " + dbName + ".en_policy_member_ah pm ON pmc.policy_member_id = pm.policy_member_id \n" +
                "JOIN " + dbName + ".en_policy_ah p ON pm.policy_id = p.policy_id \n" +
                "WHERE p.account_id = '" + acctId + "' \n" +
                "AND mcf.csr_amt >0";
    }

    public String getPolicyDqCheck() {
        return "select eph.policy_ah_id, " + dbName + ".en_policy_dq_check(policy_ah_id) from en_policy_ah eph where account_id = " + acctId + " and eph.current_ind = '1'";
    }

    public String setEnvForDataQuality() {
        return "set search_path =" + dbName;
    }

    public String getBookOfBusinessQ(String eventType) {
        return "select status, message->> 'applicationId' as applicationId, message->> 'policyPlanYr' as policyPlanYr, message->> 'eventType' as eventType, message->> 'policyId' as policyId, created_ts, routing_key, exchange from " + dbName + ".rq_queue_messages " + " where application_id = 'book_of_business_q:policy-svc' " + " and message->>'householdAccountId' = '" + acctId + "' " + " and message->>'eventType' ='" + eventType + "' ORDER BY created_ts desc";
    }
    public String getBookOfBusinessByApplicationId(String eventType) {
        return "select status, message->> 'applicationId' as applicationId, message->> 'policyPlanYr' as policyPlanYr, message->> 'eventType' as eventType, message->> 'policyId' as policyId, created_ts, routing_key, exchange from " + dbName + ".rq_queue_messages " + " where application_id = 'book_of_business_q:policy-svc' " + " and message->>'householdAccountId' = '" + acctId + "' " + "and message->>'applicationId' ='"+ SharedData.getPrimaryMember().getApplication_id() +"' and message->>'eventType' ='" + eventType + "' ORDER BY created_ts desc";
    }

    public String policyId() {
        return "select ep.policy_id, ep.coverage_type from " + dbName + ".en_policy_ah ep " +
                "where account_id =  '" + acctId + "' " +
                "and current_ind = '1'";
    }

    public String getAcct_holder_fnFromBOB() {
        return "select acct_holder_fn from  " + dbName + ".bp_book_of_business\n " +
                "where account_id = '" + acctId + "'";
    }

    public String getClientEmailFromBOB() {
        return "select email from  " + dbName + ".bp_book_of_business\n " +
                "where account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'";
    }

    public String verifyBrokerAuthorizationInBOB(String clientFirstName) {
        return "select broker_name from  " + dbName + ".bp_book_of_business\n " +
                "where acct_holder_fn = '" + clientFirstName + "' and curr_yr_app_id is null and curr_pol_policy_status is null and nxt_yr_app_id is null and next_pol_policy_status is null";
    }

    public String verifyApplicationSubmissionInBOB() {
        return "select account_id from  " + dbName + ".bp_book_of_business\n " +
                "where account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "' and (curr_yr_app_id is not null or nxt_yr_app_id is not null)";
    }

    public String verifyPolicySubmissionInBOB(int coverageType) {
        return "select account_id from  " + dbName + ".bp_book_of_business\n " +
                "where account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "' and (curr_pol_coverage_type = '" + coverageType + "' or next_pol_coverage_type = '" + coverageType + "')";
    }

    public String verifyAgencyCommissionTinDb() {
        return "select bca.commission_tin from  " + dbName + ".bp_client_authorization bca\n " +
                "join " + dbName + ".bp_agency ba on bca.agency_id = ba.agency_id\n" +
                "join " + dbName + ".bp_agency_staff bas on bas.agency_id = ba.agency_id \n" +
                "join " + dbName + ".bp_staff bs on bs.staff_id = bas.staff_id \n" +
                "group by ba.agency_name,bca.agency_id, authorization_status,ba.agency_status, ba.agency_tin_ein, bca.commission_tin, bs.first_name\n" +
                "having authorization_status = 'APPROVED' and ba.agency_status = 'ACTIVE' and ba.agency_name = 'Sidney Armstrong Agency' and bs.first_name = 'Sidney';";
    }

    public String verifyExchHouseholdIdBOB() {
        return "select ehc.household_id from " + dbName + ".es_household_contact ehc\n" +
                "join " + dbName + ".es_member em on em.household_id  = ehc.household_id \n" +
                "where ehc.email = '" + SharedData.getPrimaryMember().getEmailId() + "';";
    }

    public String verifyPasswordResetNotArchivedDb(String currentDate) {
        return "select *\n" +
                "from " + dbName + ".ds_item di \n" +
                "where account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "' and item_name = 'IND_Reset Password (AM-016-07) - " + currentDate + "';";
    }

    public String verifyBrokerAuthorizationStatusBOB() {
        return "select bca.authorization_status from " + dbName + ".es_household_contact ehc\n" +
                "join " + dbName + ".bp_client_authorization bca on bca.household_id  = ehc.household_id \n" +
                "where ehc.email = '" + SharedData.getPrimaryMember().getEmailId() + "';";
    }

    public String verifyBrokerAuthorizationTypeBOB() {
        return "select bs.staff_type from " + dbName + ".es_member em\n" +
                "join " + dbName + ".es_household_contact hc on hc.household_id = em.household_id\n" +
                "join " + dbName + ".bp_client_authorization bca on bca.household_id = em.household_id\n" +
                "join " + dbName + ".bp_staff bs on bs.staff_id = bca.staff_id\n" +
                "where hc.username = '" + SharedData.getPrimaryMember().getEmailId() + "' and bca.authorization_status = 'APPROVED';";
    }

    //Policy table queries
    public String enPolicyAh() {
        return "select eph.policy_id, eph.application_id, eph.plan_id, eph.plan_year, eph.coverage_type, eph.rating_area_id, eph.policy_status, eph.current_ind, eph.effectuated_ind, eph.policy_start_date, eph.policy_end_date from " + dbName + ".en_policy_ah eph " +
                "where account_id = '" + acctId + "'";
    }

    public String appIdFromEnPolicyAh() {
        return "select application_id from " + dbName + ".en_policy_ah " +
                "where account_id = '" + acctId + "' and current_ind = 1";
    }


    public String enMem_Coverage_FinancialAh() {
        return "select emcfh.member_coverage_financial_ah_id, emcfh.policy_member_coverage_ah_id, emcfh.member_coverage_financial_id, emcfh.policy_member_coverage_id, \n" +
                "emcfh.submission_id, emcfh.member_financial_start_date, emcfh.member_financial_end_date, emcfh.plan_premium_amt, emcfh.premium_reduction_amt, \n" +
                "emcfh.responsible_amt, emcfh.csr_amt, emcfh.slcsp_amt, emcfh.premium_reduction_type, emcfh.csr_level \n" +
                "from " + dbName + ".en_member_coverage_financial_ah emcfh \n" +
                "where application_id = '" + applicationId + "'";
    }

    public String enPolicy_Mem_CoverageAh() {
        return "select epmch.policy_member_coverage_ah_id, epmch.policy_member_ah_id, epmch.policy_member_coverage_id, epmch.policy_member_id, epmch.submission_id, epmch.coverage_start_date, \n" +
                "epmch.coverage_end_date, epmch.policy_member_coverage_status, epmch.lost_insurance_due_to_non_pmt_ind, epmch.disenrollment_reason, epmch.current_ind \n" +
                "from " + dbName + ".en_policy_member_coverage_ah epmch \n" +
                "where application_id = '" + applicationId + "'";
    }

    public String enPolicyFinancialAh() {
        return "select * from " + dbName + ".en_policy_financial_ah\n " +
                "where policy_id in (select policy_id from " + dbName + ".en_policy where account_id = '" + acctId + "')";
    }

    public String enPolicyMemberAh() {
        return "select * from " + dbName + ".en_policy_member_ah \n" +
                "where application_id = '" + applicationId + "'";
    }

    public String esMVR(String manualVerificationType) {
        return "select *\n" +
                "from " + dbName + ".es_manual_verif_request\n" +
                "where account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'\n" +
                "and manual_verification_type = '" + manualVerificationType + "'";
    }

    public String esMVRFullAccount() {
        return "select *\n" +
                "from " + dbName + ".es_manual_verif_request\n" +
                "where account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'\n";
    }

    public String esSsaVerification(String memberId) {
        return "select *\n" +
                "from " + dbName + ".es_ssa_verification_req_resp\n" +
                "where member_id = '" + memberId + "'";
    }

    public String esSsaVerificationCreatedby() {
        return "select *\n" +
                "from " + dbName + ".es_ssa_verification_req_resp\n" +
                "where created_by = '" + SharedData.getPrimaryMember().getEmailId() + "'";
    }

    public String enMemberEffectiveDates() {
        return "select * from " + dbName + ".en_member_effective_dates \n" +
                "where application_id = '" + applicationId + "'";
    }

    public String countOfPersonIds() {
        return "Select count(exch_person_id)\n" +
                "From " + dbName + ".ES_MEMBER\n" +
                "Where exch_person_id in (\n" +
                "Select exch_person_id \n " +
                "from " + dbName + ".ES_MEMBER mcf\n" +
                "JOIN " + dbName + ".ES_HOUSEHOLD pmc ON mcf.household_id = pmc.household_id\n" +
                "and pmc.account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "')";
    }

    public String esHousehold() {
        return "select * from " + dbName + ".ES_MEMBER mcf\n" +
                "JOIN " + dbName + ".ES_HOUSEHOLD pmc ON mcf.household_id = pmc.household_id\n" +
                "and pmc.account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'";
    }

    public String esMemberWithMemberId(String memId) {
        return "select * from " + dbName + ".es_member em\n" +
                "where member_id = '" + memId + "'";
    }

    public String getEmailStored() {
        return "select * from " + dbName + ".es_household p\n" +
                "join " + dbName + ".es_household_contact m on m.household_id=p.household_id\n" +
                "where p.account_id = '" + acctId + "' \n" +
                "order by p.created_ts desc limit 1";
    }

    public String getPrimaryHraAhRecords() {
        return "select *\n" +
                "From  " + dbName + ".es_member_hra_ah\n" +
                "where member_id = '" + SharedData.getPrimaryMember().getMemberId() + "' \n" +
                "order by updated_ts asc limit 1";
    }

    public String getDBMedicalPlanList() {
        return "SELECT p.plan_marketing_name " +
                "FROM " + dbName + ".en_plan p " +
                "INNER JOIN " + dbName + ".en_issuer i ON i.issuer_id=p.issuer_id " +
                "WHERE p.plan_year='2024' " +
                "AND p.level_of_coverage IN('Platinum','Gold','Silver','Silver Enhanced','Bronze','Expanded Bronze','LOW','HIGH') " +
                "AND p.market_coverage=1 " +
                "AND i.active=TRUE " +
                "AND p.coverage_type=1 " +
                "AND p.plan_source_id='1' " +
                "AND p.csr_level='01' " +
                "AND p.service_area_id IN( " +
                "SELECT sa.service_area_id " +
                "FROM " + dbName + ".en_issuer_service_area sa " +
                "WHERE sa.plan_year=CAST(p.plan_year AS INTEGER) " +
                "AND sa.hios_issuer_id=p.hios_issuer_id " +
                "AND sa.fips='08001' " +
                "AND(sa.partial_county_ind=FALSE OR sa.zip='80030') " +
                ") " +
                "AND NOT EXISTS( " +
                "SELECT 1 " +
                "FROM " + dbName + ".en_plan p2 " +
                "INNER JOIN " + dbName + ".en_plan_source ps ON ps.plan_source_id=p.plan_source_id " +
                "INNER JOIN " + dbName + ".en_issuer i2 ON i2.issuer_id=p2.issuer_id " +
                "WHERE p2.coverage_type=p.coverage_type " +
                "AND p2.plan_year=p.plan_year " +
                "AND p2.csr_level NOT IN('01','00','07') " +
                "AND p2.market_coverage=p.market_coverage " +
                "AND i2.active=TRUE " +
                "AND p2.plan_source_id=p.plan_source_id " +
                "AND p2.service_area_id IN( " +
                "SELECT sa1.service_area_id " +
                "FROM " + dbName + ".en_issuer_service_area sa1 " +
                "WHERE p2.hios_issuer_id=sa1.hios_issuer_id " +
                "AND p2.plan_year='2024' " +
                "AND(sa1.entire_state_ind=TRUE OR(sa1.fips='08001' AND (NOT sa1.partial_county_ind=TRUE OR sa1.zip='80030'))) " +
                ") " +
                ");";
    }

    public String getRaceEthnicityStored() {
        return "select em.race_ethnicity, em.race_other_text " +
                "from " + dbName + ".es_member em " +
                "join " + dbName + ".es_household eh on eh.household_id = em.household_id " +
                "join " + dbName + ".es_household_contact hc on hc.household_id = eh.household_id " +
                "where hc.email = '" + SharedData.getPrimaryMember().getEmailId() + "' " +
                "order by em.member_id";
    }


    public String getPlan_marketing_name(String planYear) {
        return "SELECT P.plan_marketing_name FROM " + dbName + ".en_policy_ah ESH JOIN " + dbName + ".en_plan P ON ESH.plan_id = P.plan_id WHERE ESH.account_id = '" + acctId + "' " +
                "AND ESH.plan_year = '" + planYear + "' AND ESH.coverage_type = '" + SharedData.getManagePlanDentalMedicalPlan().getPlanType() + "' ORDER BY ESH.created_ts DESC LIMIT 1";
    }

    public String householdIdQuery() {
        return "SELECT household_id " +
                "FROM " + dbName + ".es_household " +
                "WHERE account_id = " + acctId;
    }


    public String memberIdQuery(String householdId) {
        return "SELECT member_id " +
                "FROM " + dbName + ".es_member " +
                "WHERE household_id = " + householdId + " " +
                "AND household_contact = 1";
    }

    public String reasonCodeQuery(String memberId, String determination) {
        return "SELECT reason_code " +
                "FROM " + dbName + ".es_member_rules_result " +
                "WHERE determination = '" + determination + "' " +
                "AND member_id = " + memberId;
    }

    public String createdByQuery(String memberId, String determination) {
        return "SELECT created_by " +
                "FROM " + dbName + ".es_member_rules_result " +
                "WHERE determination = '" + determination + "' " +
                "AND member_id = " + memberId +
                " and created_ts::TEXT LIKE CURRENT_DATE || '%'";
    }


    public String getDental_policy_date() {
        return "Select policy_start_date , policy_end_date From " + dbName + ".en_policy_ah ESH Where ESH.account_id = '" + acctId + "' and coverage_type = '1' and policy_status != 'CANCELLED' order by created_ts desc limit 1;";
    }

    public String getMedCurrentLatestAppDate() {
        return "SELECT ESH.policy_submitted_ts\n" +
                "FROM " + dbName + ".en_policy_ah ESH\n" +
                "JOIN " + dbName + ".en_policy EP ON ESH.application_id = EP.application_id\n" +
                "WHERE ESH.account_id = '" + acctId + "' \n" +
                "  AND ESH.coverage_type = '" + SharedData.getManagePlanDentalMedicalPlan().getPlanType() + "' \n" +
                "ORDER BY ESH.created_ts DESC \n" +
                "LIMIT 1;";
    }

    public String getMedSecondPolicyDB(String year) {
        return "SELECT EPH.exchange_assigned_policy_id,EPH.policy_start_date, ESH.first_name \n" +
                " FROM " + dbName + ".es_member_ah ESH\n" +
                "FULL JOIN " + dbName + ".en_policy_ah EPH ON ESH.submission_id = EPH.submission_id\n" +
                "WHERE EPH.account_id = '" + acctId + "'\n" +
                "AND EPH.coverage_type = '1'\n" +
                "AND EPH.policy_status != 'CANCELLED'\n" +
                "AND EPH.plan_year ='" + year + "'\n" +
                "ORDER BY EPH.exchange_assigned_policy_id ASC\n" +
                "LIMIT 1;";
    }

    public String getDentalSecondPolicyDB(String year) {
        return "SELECT ESH.exchange_assigned_policy_id, ESH.policy_start_date , EMH.first_name\n" +
                "FROM " + dbName + ".en_policy_ah ESH\n" +
                "JOIN " + dbName + ".en_policy_member_ah PMH ON PMH.policy_ah_id = ESH.policy_ah_id\n" +
                "JOIN " + dbName + ".en_policy_member_coverage_ah PMC ON PMC.policy_member_ah_id = PMH.policy_member_ah_id\n" +
                "JOIN " + dbName + ".en_member_coverage_financial_ah MCF ON MCF.policy_member_coverage_ah_id = PMC.policy_member_coverage_ah_id\n" +
                "JOIN " + dbName + ".es_member_ah EMH ON EMH.submission_id = MCF.submission_id AND EMH.household_contact = '1'\n" +
                "WHERE \n" +
                "    ESH.account_id = '" + acctId + "'\n" +
                "    AND ESH.coverage_type = '2'\n" +
                "    AND ESH.plan_year = '" + year + "'\n" +
                "ORDER BY \n" +
                "    ESH.created_ts DESC\n" +
                "LIMIT 1;";
    }

    public String getEventLogIdDB(String event, String eventLogId) {
        return "Select event_log_id \n" +
                "From " + dbName + ".event_log \n" +
                "Where account_id = '" + acctId + "' \n" +
                "and event_cd = '" + event + "' \n" +
                "and event_log_id != '" + eventLogId + "'";
    }

    public String getHouseholdId() {
        return "select household_id from " + dbName + ".es_household where account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'";
    }

    public String getHouseholdIdForOldAccount() {
        return "select household_id from " + dbName + ".es_household where account_id = '" + SharedData.getOldAccountId() + "'";
    }

    public String getLceTpePlanYear(String householId) {
        return "Select lce_type, plan_year from " + dbName + ".es_member_lce\n" +
                "where household_id  = '" + householId + "'";
    }


    public String getMemberNonAIAn(String reasonCode) {
        return "SELECT DISTINCT t1.* " +
                "FROM " + dbName + ".es_member_rules_result t1 " +
                "JOIN " + dbName + ".es_member_rules_result t2 ON t1.member_id = t2.member_id " +
                "WHERE t1.member_id = '" + SharedData.getPrimaryMember().getMemberId() + "' " +
                "AND t1.eligibility_type = 'CSR' " +
                "AND t1.determination = 'CSR' " +
                "AND t1.reason_code LIKE '%AIAN%' " +
                "AND t2.reason_code = '" + reasonCode + "' " +
                "ORDER BY t1.effective_date";
    }


    public String getMedicalDental_policy_date() {
        return "Select policy_start_date , policy_end_date From " + dbName + ".en_policy_ah ESH Where ESH.account_id = '" + acctId + "' and coverage_type = '" + SharedData.getManagePlanDentalMedicalPlan().getPlanType() + "' and policy_status != 'CANCELLED' order by created_ts desc limit 1;";
    }

    public String getMedDentalCurrentLatestAppDate() {
        return "SELECT ESH.policy_submitted_ts\n" +
                "FROM " + dbName + ".en_policy_ah ESH\n" +
                "JOIN " + dbName + ".en_policy EP ON ESH.application_id = EP.application_id\n" +
                "WHERE ESH.account_id = '" + acctId + "' \n" +
                "  AND ESH.coverage_type = '" + SharedData.getManagePlanDentalMedicalPlan().getPlanType() + "' \n" +
                "ORDER BY ESH.created_ts DESC \n" +
                "LIMIT 1;";
    }

    public String nameRatingPolicy() {
        return "SELECT ESH2.name FROM " + dbName + ".en_policy_ah ESH1 JOIN " + dbName + ".en_rating_area ESH2 ON ESH1.rating_area_id = ESH2.rating_area_id WHERE ESH1.account_id = '" + acctId + "' AND ESH1.coverage_type = '" + SharedData.getManagePlanDentalMedicalPlan().getPlanType() + "' ORDER BY ESH1.created_ts DESC LIMIT 1;";
    }

    public String ehb_percent_of_total_premiumForYear(String year) {
        return "SELECT ep.ehb_percent_of_total_premium \n" +
                "FROM " + dbName + ".en_policy_ah ESH\n" +
                "JOIN " + dbName + ".en_plan EP\n" +
                "ON ESH.plan_id = EP.plan_id WHERE \n" +
                "    ESH.account_id = '" + acctId + "'AND ESH.coverage_type = '" + SharedData.getManagePlanDentalMedicalPlan().getPlanType() + "' AND ESH.plan_year = '" + year + "' \n" +
                "ORDER BY ESH.created_ts DESC LIMIT 1;";
    }

    public String lCEEventTypeAndLCEDateTypeForTheYearDB() {
        return "SELECT LCE.lce_type, LCE.lce_event_date \n" +
                "FROM exch.en_policy_ah ESH \n" +
                "JOIN exch.es_application EVAL \n" +
                "    ON EVAL.application_id = ESH.application_id \n" +
                "JOIN exch.es_member_lce MLC \n" +
                "    ON MLC.evaluation_id = CAST(EVAL.evaluation_id AS varchar) \n" +
                "    AND MLC.lce_type != 'NEWLY_APTC_ELIGIBLE' \n" +
                "JOIN exch.es_member_lce_ah LCE \n" +
                "    ON LCE.member_lce_id = MLC.member_lce_id \n" +
                "WHERE ESH.account_id = '" + acctId + "' \n" +
                "  AND ESH.coverage_type = '" + SharedData.getManagePlanDentalMedicalPlan().getPlanType() + "' \n" +
                "ORDER BY ESH.created_ts DESC LIMIT 1;";
    }

    public String serviceAreaForTheYearDB() {
        return "select service_area_id From exch.en_plan ESH \n" +
                "join exch.en_policy_ah EPA on ESH.plan_id = EPA.plan_id\n" +
                "where EPA.account_id = '" + acctId + "'\n" +
                "and EPA.coverage_type = '" + SharedData.getManagePlanDentalMedicalPlan().getPlanType() + "' order by EPA.created_ts desc limit 1;";
    }

    public String prior_6_months_tobacco_use_ind() {
        return "SELECT ESH_POL.prior_6_months_tobacco_use_ind\n" +
                "FROM exch.en_policy_ah ESH_PO\n" +
                "JOIN exch.es_member_ah ESH_MEM \n" +
                " ON ESH_PO.submission_id = ESH_MEM.submission_id\n" +
                "JOIN exch.en_policy_member_ah ESH_POL \n" +
                " ON ESH_MEM.member_ah_id = ESH_POL.member_ah_id\n" +
                "WHERE ESH_PO.account_id = '" + acctId + "'\n" +
                "    AND ESH_PO.coverage_type = '" + SharedData.getManagePlanDentalMedicalPlan().getPlanType() + "'\n" +
                "    AND ESH_PO.policy_status != 'CANCELLED'\n" +
                "ORDER BY \n" +
                "    ESH_PO.policy_submitted_ts DESC\n" +
                "LIMIT 1;";
    }

    public String getAv_calculator_outputDB() {
        return "SELECT ESH.av_calculator_output\n" +
                "FROM " + dbName + ".en_plan ESH\n" +
                "JOIN " + dbName + ".en_policy_ah ESH2\n" +
                " ON ESH.plan_id = ESH2.plan_id\n" +
                "WHERE ESH2.account_id = '" + acctId + "'\n" +
                " AND ESH2.coverage_type = '" + SharedData.getManagePlanDentalMedicalPlan().getPlanType() + "'\n" +
                "ORDER BY ESH2.created_ts DESC\n LIMIT 1;";
    }

    public String getEnrollmentPeriodEndDate() {
        String query = "SELECT * from " + dbName + ".es_enrollment_period_end_date\n" +
                "where application_id = '" + applicationId + "'";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getMultipleEnrollmentPeriodEndDate() {
        String query = "SELECT c.enrollment_period_end_date AS enrollment_period_end_date, c.qlce_present_ind AS qlce_present_ind, c.plan_year AS plan_year\n" +
                "From " + dbName + ".es_household a\n" +
                "Join " + dbName + ".es_application b on a.household_id = b.household_id\n" +
                "Join " + dbName + ".es_enrollment_period_end_date c on c.application_id = b.application_id\n" +
                "where account_id = '" + acctId + "'";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getEnrollmentPeriodEndDateCount() {
        String query = "Select count(enrollment_period_end_date)\n" +
                "From " + dbName + ".es_household a\n" +
                "Join " + dbName + ".es_application b on a.household_id = b.household_id\n" +
                "Join " + dbName + ".es_enrollment_period_end_date c on c.application_id = b.application_id\n" +
                "where account_id = '" + acctId + "'";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getBrokerEmailIn() {
        return "SELECT CI.email FROM " + dbName + ".bp_staff AS ST JOIN " + dbName + ".bp_contact_info AS CI ON ST.contact_info_id = CI.contact_info_id " +
                "WHERE ST.account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "';";
    }

    public String getTaxFilingDataDB(String memberId) {
        return "SELECT * from " + dbName + ".es_member\n" +
                "where member_id = '" + memberId + "'";
    }

    public String getTaxReturnDataDB(String memberId) {
        return "SELECT p.tax_filing_type, p.claimed_as_dep_on_othr_ftr_ind, m.tax_filing_status, m.exceptional_circumstance,m.tax_return_id\n" +
                "from " + dbName + ".es_member p\n" +
                "inner join " + dbName + ".es_tax_return m on m.tax_return_id=p.tax_return_id\n" +
                "where member_id = '" + memberId + "'";
    }

    public String getRqQueMsg() {
        return "SELECT status, message -> 'changeEvent' as changeEvent, message -> 'requestType' as requestType \n" +
                "FROM " + dbName + ".rq_queue_messages where correlation_id like '" + SharedData.getPrimaryMember().getAccount_id() + "-REASSIGN-PRIMARY-CONTACT'";
    }

    public String getMemberId(String memFname) {
        return "select member_id from " + dbName + ".es_member\n" +
                "where first_name = '" + memFname + "'";
    }

    public String geApplicationId(String householId) {
        return "select application_id from " + dbName + ".es_application\n" +
                "where household_id  = '" + householId + "'\n" +
                "and plan_year = '" + SharedData.getPlanYear() + "'";
    }

    public String geAllApplicationIds(String householId) {
        return "select application_id from " + dbName + ".es_application\n" +
                "where household_id  = '" + householId + "'";
    }

    public String getSelfAttestationDetails(String householdID) {
        return "select * from " + dbName + ".es_self_attestation\n" +
                "where household_id = '" + householdID + "'";
    }

    public String dorTaxHousehold(String taxpayerKey) {
        return "select b.event_cd\n" +
                "from " + dbName + ".dor_tax_household a\n" +
                "join " + dbName + ".easy_enrollment_event_log b\n" +
                "on a.id = b.dor_tax_household_id\n" +
                "join " + dbName + ".dor_tax_household_member c\n" +
                "on a.id = c.dor_tax_household_id\n" +
                "where a.taxpayer_key = '" + taxpayerKey + "'";
    }

    public String easyEnrollmentEventLog(String taxpayerKey) {
        return "select event_cd \n" +
                "from " + dbName + ".easy_enrollment_event_log where taxpayer_key = '" + taxpayerKey + "'";
    }

    public String getExchPersonIdFields_esMem(String householdId) {
        return "select member_id, exch_person_id, exch_person_id_review_id, exch_person_id_review_status from " + dbName + ".es_member em \n" +
                "where household_id = '" + householdId + "'";
    }

    public String getAddressDetails(String memberId) {
        return "SELECT address_line1,address_line2, city, state, zip, county FROM " + dbName + ".es_address\n" +
                "where address_id = (SELECT residence_address_id FROM " + dbName + ".es_member where member_id = " + memberId + ")";
    }

    public String getTellAboutAdditionalInformation(String memberId) {
        return "SELECT first_name, middle_name, last_name, gender, birth_date, applying_for_coverage_ind FROM " + dbName + ".es_member\n" +
                "where member_id = " + memberId + "";
    }

    public String getMailingAddressDetails(String memberId) {
        return "SELECT address_line1, city, state, zip, county FROM " + dbName + ".es_address\n" +
                "where address_id = (SELECT hc.mailing_address_id FROM " + dbName + ".es_household_contact hc join " + dbName + ".es_member m on hc.household_id = m.household_id where m.member_id = " + memberId + ")";
    }

    public String getStateDetails(String memberId) {
        return "SELECT co_resident_ind FROM " + dbName + ".es_member where member_id = '" + memberId + "'";
    }


    public String fplPercentDetails() {
        return "select err.fpl_percent \n" +
                "from " + dbName + ".es_member esm \n" +
                "join " + dbName + ".es_member_rules_result err \n" +
                "  on esm.member_id = err.member_id \n" +
                "join " + dbName + ".es_household esh \n" +
                "  on esm.household_id = esh.household_id \n" +
                "where err.determination = 'MA_INCOME_MET' \n" +
                "  and err.eligibility_type = 'MA' \n" +
                "  and esh.account_id = '" + acctId + "'";
    }

    public String fplEsTaxReturn(){
        return "select calculated_fpl \n" +
                "from " + dbName + ".es_tax_return_aptc \n" +
                "where created_by = '" + SharedData.getPrimaryMember().getEmailId() +"'";
    }

    public String compareExchPersonIds() {
        return "Select esm.exch_person_id\n" +
                "From " + dbName + ".ES_MEMBER esm\n" +
                "JOIN " + dbName + ".ES_HOUSEHOLD esh ON esm.household_id = esh.household_id\n" +
                "Where esh.account_id = '" + SharedData.getPrimaryMember().getAccount_id() + "'";
    }

    public String getArpIndicator() {
        return "Select ES.arp_quick_submit_ind\n" +
                "FROM " + dbName + ".ES_HOUSEHOLD ESH, " + dbName + ".ES_MEMBER ESM, " + dbName + ".es_submission es \n" +
                "WHERE ESH.HOUSEHOLD_ID = ESM.HOUSEHOLD_ID\n" +
                "and ESH.household_id = es.household_id \n" +
                "AND ESH.ACCOUNT_ID = '" + acctId + "'\n" +
                "order by es.updated_ts desc \n" +
                "limit 1";
    }

    public String getMemberReasonCodeByAccountId() {
        return "SELECT err.reason_code " +
                "FROM " + dbName + ".ES_MEMBER esm " +
                "JOIN " + dbName + ".ES_MEMBER_RULES_RESULT err ON esm.member_id = err.member_id " +
                "JOIN " + dbName + ".ES_HOUSEHOLD esh ON esm.household_id = esh.household_id " +
                "WHERE err.determination = 'CSR' " +
                "AND err.eligibility_type = 'CSR' " +
                "AND esh.account_id = '" + acctId + "'";
    }


    public String getCyaEligibility() {
        return "Select err.outcome_ind \n" +
                "From " + dbName + ".ES_MEMBER esm, " + dbName + ".ES_MEMBER_RULES_RESULT err, " + dbName + ".es_household esh \n" +
                "Where esm.member_id = err.member_id And esm.household_id = esh.household_id \n" +
                "And esh.account_id ='" + acctId + "' and err.determination = 'CYA'";
    }

    public String getVLPResponseCodeInfo(String requestType) {
        return "SELECT response_code FROM " + dbName + ".es_vlp_resp\n" +
                "WHERE member_id = '"+SharedData.getPrimaryMember().getMemberId()+"'\n" +
                "AND request_type = '"+requestType+"'";
    }

    public String getFDSHRetryType() {
        return "select service_type from " + dbName + ".es_fdsh_retry_control\n" +
                " where account_id = '" + acctId + "'";
    }

    public String getFDSHRetryStatus() {
        return "select status from " + dbName + ".es_fdsh_retry_control\n" +
                " where account_id = '" + acctId + "'";
    }

    public String getMedSubscribers(String memId) {
        return "select subscriber_ind  from " + dbName + ".en_shop_group_member esgm \n" +
                "where application_id = '" + applicationId + "'\n" +
                "and coverage_type = '1'\n" +
                "and member_ah_id = '" + memId + "'";
    }

    public String getFDSHRetryDetails(){
        return "SELECT *\n" +
                "FROM "+dbName+".es_fdsh_retry_control\n" +
                "WHERE account_id = '"+SharedData.getPrimaryMember().getAccount_id()+"'";
    }

    public String getIncomeDataDetails() {
        String query = "SELECT DISTINCT a.member_id AS member_id, d.employer_ah_id AS employer_ah_id, f.employer_id AS employer_id, d.employer_name AS employer_name, a.type AS type, a.kind AS kind, a.amount AS amount, a.period AS period, a.annual_amount AS annual_amount, d.future_income_changes_ind AS future_income_changes_ind, f.self_employed_ind AS self_employed_ind, d.season_comm_tip_ind AS season_comm_tip_ind, d.season_comm_tip_samelower_ind AS season_comm_tip_samelower_ind, f.created_by AS created_by, a.monthly_amount AS monthly_amount\n" +
                "FROM " + dbName + ".es_income a\n" +
                "JOIN " + dbName + ".es_income_ah b ON a.member_id = b.member_id\n" +
                "JOIN " + dbName + ".es_employer c ON a.member_id = c.member_id\n" +
                "JOIN " + dbName + ".es_employer_ah d ON c.member_id = d.member_id\n" +
                "JOIN " + dbName + ".es_job_title e ON c.employer_id = e.employer_id\n" +
                "JOIN " + dbName + ".es_job_title_ah f ON e.member_id = f.member_id\n" +
                "WHERE a.member_id = '" + SharedData.getPrimaryMember().getMemberId() + "';";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getMemberIncomeDetailsQuery() {
        return "SELECT count(employer_name) " +
                "FROM " + dbName + ".es_member m " +
                "JOIN " + dbName + ".es_household h ON m.household_id = h.household_id " +
                "LEFT JOIN " + dbName + ".es_income i ON i.member_id = m.member_id " +
                "LEFT JOIN " + dbName + ".es_employer e ON i.employer_id = e.employer_id " +
                "LEFT JOIN " + dbName + ".es_job_title jt ON jt.employer_id = e.employer_id " +
                "LEFT JOIN " + dbName + ".es_address a ON e.address_id = a.address_id " +
                "WHERE h.account_id = '" + acctId + "'";
    }

    public String getDeductionamountDetails(String memberId, String kindValue) {
        return "SELECT m.member_id, i.income_id, i.type, i.kind, i.amount, i.period " +
                "FROM " + dbName + ".es_member m " +
                "JOIN " + dbName + ".es_income i ON m.member_id = i.member_id " +
                "WHERE m.member_id = '" + memberId + "' " +
                "AND i.type = 'DEDUCTION' " +
                "AND i.kind = '" + kindValue + "';";
    }

    public String getDeductionAmountCount(String memberId) {
        String query =  "SELECT count(i.kind)" +
                "FROM " + dbName + ".es_member m " +
                "JOIN " + dbName + ".es_income i ON m.member_id = i.member_id " +
                "WHERE m.member_id = '" + memberId + "' " +
                "AND i.type = 'DEDUCTION';";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getApplicationIdFromHouseholdTable(){
        return "select esh.account_id, esh.household_id, esa.created_ts, esa.application_id\n" +
                "from "+dbName+".es_household esh, "+dbName+".es_application esa\n" +
                "where esh.household_id = esa.household_id\n" +
                "and esh.account_id = '"+acctId+"'" + "order by created_ts desc";

    }

    public String getOverriddenAmountDetails(){
        String query = "Select ind_ssap_data\n" +
                "From "+dbName+".ssap_data ss, "+dbName+".es_household esh\n" +
                "Where security_token_id = CAST(esh.household_id AS varchar(25))\n" +
                "And esh.account_id = '"+acctId+"';";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getVlpRequestCountQuery() {
        return "select count(evr.*) from " + dbName + ".es_member em, " + dbName + ".es_household eh, " + dbName + ".es_vlp_req evr \n" +
                "where eh.household_id = em.household_id and em.member_id = evr.member_id \n" +
                "and eh.account_id = '" + acctId + "'";
    }

    public String getEligibilityTypeQuery() {
        String query = "Select d.eligibility_type \n" +
                "From " + dbName + ".es_household a\n" +
                "join " + dbName + ".es_member b on b.household_id = a.household_id\n" +
                "join " + dbName + ".es_application c on c.household_id = b.household_id\n" +
                "join " + dbName + ".es_member_rules_result d on d.evaluation_id = c.evaluation_id\n" +
                "join " + dbName + ".es_member e on d.member_id = e.member_id\n" +
                "where account_id = '" + acctId + "'\n" +
                "and b.household_contact = 1\n" +
                "and d.ref_obj_id is not null order by d.evaluation_id asc";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getgetDeterminationEffectiveDateDetails() {
        String query = "Select d.effective_date, d.determination \n" +
                "From " + dbName + ".es_household a\n" +
                "join " + dbName + ".es_member b on a.household_id = b.household_id\n" +
                "join " + dbName + ".es_application c on b.household_id = c.household_id\n" +
                "join " + dbName + ".es_member_rules_result d on c.evaluation_id = d.evaluation_id\n" +
                "where a.account_id = " + acctId + "\n" +
                "and b.household_contact = 1\n" +
                "and d.ref_obj_id is not null order by d.created_ts desc limit 1";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getOutcomeIndQuery() {
        String query = "Select d.outcome_ind\n" +
                "From " + dbName + ".es_household a\n" +
                "join " + dbName + ".es_member b on a.household_id = b.household_id\n" +
                "join " + dbName + ".es_application c on b.household_id = c.household_id\n" +
                "join " + dbName + ".es_member_rules_result d on d.member_id = b.member_id and d.evaluation_id =c.evaluation_id\n" +
                "Where account_id = " + acctId + "\n" +
                "And household_contact = 1\n" +
                "And d.ref_obj_id is not null order by d.evaluation_id asc limit 1";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getRemovedEffectiveDateQuery() {
        String query = "Select b.removed_effective_date \n" +
                "From " + dbName + ".es_household a\n" +
                "join " + dbName + ".es_member b on a.household_id = b.household_id\n" +
                "where a.account_id = " + acctId + "\n" +
                "and b.household_contact = 0";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getEsMemberLceAhDetails(String memberId) {
        String query = "select l.member_lce_id lce_member_lce_id, lah.member_lce_id lce_ah_member_lce_id,l.evaluation_id lce_evaluation_id, lah.evaluation_id lce_ah_evaluation_id, l.lce_report_date lce_report_date, lah.lce_report_date lce_ah_report_date,l.lce_event_date lce_event_date, lah.lce_event_date lce_ah_event_date\n" +
                "from " + dbName + ".es_member_lce l \n" +
                "join " + dbName + ".es_member_lce_ah lah on l.member_lce_id = lah.member_lce_id\n" +
                "where l.member_id = " + memberId;
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getLatestForm8962DocumentQuery() {
        String query = "SELECT * \n" +
                "FROM " + dbName + ".ds_item \n" +
                "WHERE account_id = '" + acctId + "' \n" +
                "AND document_display_name = 'Form 8962' \n" +
                "ORDER BY item_date DESC \n" +
                "LIMIT 1";
        return query;
    }

    public String getAssistNetEmailIn() {
        return  "Select email From "+ dbName+ ".an_staff ESH Where account_id = '"+acctId+"'";
    }

    public String getCoCoIncomeDataDetails() {
        String query = "SELECT DISTINCT i.amount, i.period, e.season_comm_tip_ind, e.season_comm_tip_samelower_ind, m.updated_by\n" +
                "FROM " + dbName + ".es_member m\n" +
                "JOIN " + dbName + ".es_income i on m.member_id = i.member_id\n" +
                "JOIN " + dbName + ".es_employer e on i.member_id = e.member_id\n" +
                "WHERE m.member_id = '" + SharedData.getPrimaryMember().getMemberId() + "' and i.type = 'JOB_INCOME';";
        System.out.println("Executing Query: " + query);
        return query;
    }
}
