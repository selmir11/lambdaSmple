package com.c4hco.test.automation.database.Queries;

import com.c4hco.test.automation.Dto.SharedData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DbQueries_Exch {
    String acctId = String.valueOf(SharedData.getPrimaryMember().getAccount_id());
    String applicationId = SharedData.getPrimaryMember().getApplication_id();
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
        String query = "SELECT account_id, application_id, exch_person_id, first_name, middle_name, last_name, birth_date, tobacco_use, relation_to_subscriber,\n" +
                " plan_year, coverage_type, hios_plan_id, rating_area_id, policy_id, policy_status, current_ind,\n" +
                " effectuated_ind_eph, policy_start_date, policy_end_date, csr_level_epfh, financial_period_start_date, financial_period_end_date, \n" +
                " total_plan_premium_amt, total_premium_reduction_amt, total_responsible_amt, premium_reduction_type_epfh, total_csr_amt,\n" +
                " policy_member_coverage_status, member_id, responsible_adult_ind, subscriber_ind, created_by, effectuated_ind_epmh, \n" +
                " coverage_start_date, coverage_end_date, disenrollment_reason, csr_level_emcfh, member_financial_start_date, member_financial_end_date,\n" +
                " plan_premium_amt, premium_reduction_amt, premium_reduction_type_emcfh, responsible_amt, policy_submitted_ts, policy_submitted_by\n" +
                " FROM (select emcfh.member_financial_start_date, emcfh.member_financial_end_date, emcfh.premium_reduction_amt, \n" +
                " emcfh.responsible_amt, eph.account_id, eph.application_id, em.first_name, em.middle_name, em.last_name, em.birth_date, \n" +
                " em.tobacco_use, epmh.relation_to_subscriber, eph.plan_year, eph.coverage_type, ep2.hios_plan_id, eph.rating_area_id, \n" +
                " eph.policy_id, eph.policy_status, eph.current_ind, eph.effectuated_ind AS effectuated_ind_eph,\n" +
                " eph.policy_start_date, eph.policy_end_date, epmh.member_id, epmh.responsible_adult_ind, epmh.created_by,\n" +
                " epmch.policy_member_coverage_status, epmh.effectuated_ind as effectuated_ind_epmh, epmch.coverage_start_date, epmch.coverage_end_date, \n" +
                " epmch.disenrollment_reason, epmh.subscriber_ind, emcfh.csr_level as csr_level_emcfh, emcfh.plan_premium_amt, emcfh.premium_reduction_type as premium_reduction_type_emcfh , \n" +
                " eph.policy_submitted_ts, eph.policy_submitted_by, eph.policy_ah_id, eph.exchange_assigned_policy_id, em.exch_person_id\n" +
                " from " + dbName + ".es_household eh, " + dbName + ".es_application ea, " + dbName + ".es_member em, " + dbName + ".en_policy_ah eph, " + dbName + ".en_plan ep2, " + dbName + ".en_policy_member_ah epmh,\n" +
                " " + dbName + ".en_policy_member_coverage_ah epmch, " + dbName + ".en_member_coverage_financial_ah emcfh, " + dbName + ".en_policy ep\n" +
                " where eh.household_id = ea.household_id\n" +
                " and ea.application_id = eph.application_id\n" +
                " and ep.plan_id = ep2.plan_id\n" +
                " and em.member_id = epmh.member_id\n" +
                " and em.household_id = eh.household_id\n" +
                " and em.exch_person_id = epmh.exch_person_id\n" +
                " and epmh.policy_member_id = epmch.policy_member_id\n" +
                " and eph.policy_id = epmh.policy_id\n" +
                " and epmch.policy_member_coverage_id = emcfh.policy_member_coverage_id\n" +
                " and ep.policy_id = eph.policy_id) pmc\n" +
                "LEFT JOIN( select  epfh.policy_ah_id, epfh.financial_period_start_date, epfh.financial_period_end_date, epfh.total_premium_reduction_amt,\n" +
                " epfh.total_plan_premium_amt, epfh.total_csr_amt, epfh.total_responsible_amt,\n" +
                " epfh.csr_level AS csr_level_epfh, epfh.premium_reduction_type AS premium_reduction_type_epfh\n" +
                " FROM " + dbName + ".en_policy_financial_ah epfh) pf ON pmc.policy_ah_id = pf.policy_ah_id \n" +
                "AND pmc.relation_to_subscriber = 'SELF'\n" +
                "AND pmc.member_financial_start_date BETWEEN pf.financial_period_start_date AND pf.financial_period_end_date\n" +
                "AND pmc.member_financial_end_date BETWEEN pf.financial_period_start_date AND pf.financial_period_end_date\n" +
                "WHERE pmc.account_id = '"+acctId+"'\n" +
                "and pmc.current_ind = '1'\n" +
                "AND pmc.coverage_type = '"+coverageType+"'";
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
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(dateFormat);

        return "SELECT * FROM " + dbName + ".ib999_detail \n" +
                "where ak1_group_ctrl_number = '" + grpCtlNum + "'\n"+
                "and created_ts >= '"+formattedDate+" 00:00:00'";
    }

    public String ob999Details(String grpCtlNum) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(dateFormat);

        return "SELECT * FROM " + dbName + ".ob999_detail \n" +
                "where ak1_group_ctrl_number = '" + grpCtlNum + "'\n"+
                "and created_ts >= '"+formattedDate+" 00:00:00'";
    }

    public String ib834Details(String grpCtlNum) {
        return "SELECT * FROM " + dbName + ".ib834_detail \n " +
                "where group_ctrl_number = '" + grpCtlNum + "'\n " +
                "ORDER BY created_ts DESC";
    }

    public String getEAPID() {
        return "select exchange_assigned_policy_id, coverage_type from  " + dbName + ".en_policy_ah\n" +
                "where account_id = '" + acctId + "'" + " and policy_status='SUBMITTED'";
    }

    public String getOhiRecordsAll(String memberId) {
        return "select ohi.*\n" +
                "From  " + dbName + ".es_member_other_health_ins ohi\n" +
                "where member_id = '" + memberId + "'";
    }

    public String getPrimaryHraRecords() {
        return "select *\n" +
                "From  " + dbName + ".es_member_hra\n" +
                "where member_id = '" + SharedData.getPrimaryMemberId() + "'";
    }

    public String getRatingArea(String fipcode) {
        return "select name from " + dbName + ".en_rating_area " +
                "where fips = '" + fipcode + "'";
    }

    public String getRatingAreaId(String fipcode) {
        return "select rating_area_id from " + dbName + ".en_rating_area " +
                "where fips = '" + fipcode + "'";
    }

    public String getFipcode(String zipCode) {
        return "select fip_code from " + dbName + ".es_zip_codes " +
                "where code = '" + zipCode + "'";
    }

    public String en_plan(String planName) {
        return "select * from " + dbName + ".en_plan ep \n" +
                "where plan_marketing_name = '" + planName + "'" +
                "and plan_year = '2024'\n" +
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
                "and current_ind = 1 limit 1";
    }

    public String brokerId() {
        return "SELECT agency_tin_ein FROM " + dbName + ".bp_agency where agency_name = '" + SharedData.getBroker().getAgencyName() + "'";
    }

    public String getCSRRecords() {
        return "SELECT mcf.csr_amt, p.coverage_type\n" +
                "FROM  " + dbName + ".en_member_coverage_financial_ah mcf\n" +
                "JOIN " + dbName + ".en_policy_member_coverage_ah pmc ON mcf.policy_member_coverage_id = pmc.policy_member_coverage_id\n" +
                "JOIN " + dbName + ".en_policy_member_ah pm ON pmc.policy_member_id = pm.policy_member_id\n" +
                "JOIN " + dbName + ".en_policy_ah p ON pm.policy_id = p.policy_id\n" +
                "WHERE p.account_id = '" + acctId + "'";
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
                "where account_id = '" + acctId + "'\n" +
                "and manual_verification_type = '" + manualVerificationType + "'";
    }

    public String esSsaVerification(String memberId) {
        return "select *\n" +
                "from " + dbName + ".es_ssa_verification_req_resp\n" +
                "where member_id = '" + memberId + "'";
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

    public String getEmailStored() {
        return "select * from " + dbName + ".es_household p\n" +
                "join " + dbName + ".es_household_contact m on m.household_id=p.household_id\n" +
                "where p.account_id = '" + acctId + "' \n" +
                "order by p.created_ts desc limit 1";
    }

    public String getPrimaryHraAhRecords() {
        return "select *\n" +
                "From  " + dbName + ".es_member_hra_ah\n" +
                "where member_id = '" + SharedData.getPrimaryMemberId() + "' \n" +
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
                "where eh.account_id = '" + acctId + "' " +
                "order by em.member_id";
    }


    public String getPlan_marketing_name(String planYear) {
        return "SELECT P.plan_marketing_name FROM " + dbName + ".en_policy_ah ESH JOIN " + dbName + ".en_plan P ON ESH.plan_id = P.plan_id WHERE ESH.account_id = '" + acctId + "' " +
                "AND ESH.plan_year = '" + planYear + "' AND ESH.coverage_type = '2' ORDER BY ESH.created_ts DESC LIMIT 1";
    }

    public String getDental_policy_date() {
        return "Select policy_start_date , policy_end_date From " + dbName + ".en_policy_ah ESH Where ESH.account_id = '" + acctId + "' and coverage_type = '1' and policy_status != 'CANCELLED' order by created_ts desc limit 1;";
    }

    public String getMedCurrentLatestAppDate() {
        return "SELECT ESH.policy_submitted_ts\n" +
                "FROM " + dbName + ".en_policy_ah ESH\n" +
                "JOIN " + dbName + ".en_policy EP ON ESH.application_id = EP.application_id\n" +
                "WHERE ESH.account_id = '" + acctId + "' \n" +
                "  AND ESH.coverage_type = '1' \n" +
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
                "From "+dbName+".event_log \n" +
                "Where account_id = '"+acctId+"' \n" +
                "and event_cd = '"+event+"' \n" +
                "and event_log_id != '"+eventLogId+"'";
    }
}
