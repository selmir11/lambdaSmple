package com.c4hco.test.automation.database.Queries;

import com.c4hco.test.automation.Dto.SharedData;

public class DbMpQueries {
    String dbName = SharedData.getDbName();



    public String getManagePlansDetails(String planType) {
        String planCode = "";
        if ("Medical".equalsIgnoreCase(planType)) {
            planCode = "1";
        } else if ("Dental".equalsIgnoreCase(planType)) {
            planCode = "2";
        }
        String query = "SELECT DISTINCT b.exch_person_id AS exch_person_id,b.first_name AS first_name, b.last_name AS last_name, b.birth_date AS birth_date, m.relation_to_subscriber AS relation_to_subscriber, b.household_contact AS household_contact,prior_6_months_tobacco_use_ind,coverage_start_date,coverage_end_date,policy_member_coverage_status, p.effectuated_ind AS effectuated_ind, disenrollment_reason, member_financial_start_date, member_financial_end_date, plan_premium_amt, premium_reduction_amt, p.policy_submitted_ts, exchange_assigned_policy_id, plan_marketing_name, policy_start_date, policy_end_date, ehb_percent_of_total_premium, csr_amt, lce_type, lce_event_date, service_area_id, av_calculator_output, hios_plan_id, name, financial_period_end_date, financial_period_start_date\n" +
                "FROM "+dbName+".en_policy_ah p\n" +
                "inner join "+dbName+".en_policy_member_ah m on m.policy_ah_id=p.policy_ah_id\n" +
                "inner join "+dbName+".en_policy_member_coverage_ah c on c.policy_member_ah_id=m.policy_member_ah_id\n" +
                "inner join "+dbName+".en_member_coverage_financial_ah f on f.policy_member_coverage_ah_id=c.policy_member_coverage_ah_id\n" +
                "inner join "+dbName+".es_member_ah b on m.exch_person_id = b.exch_person_id\n"+
                "inner join "+dbName+".en_plan d on d.plan_id = p.plan_id\n"+
                "inner join "+dbName+".es_member_lce k on k.member_id = b.member_id\n"+
                "inner join "+dbName+".en_rating_area n on n.rating_area_id = p.rating_area_id\n"+
                "inner join "+dbName+".en_policy_financial a on a.policy_id = p.policy_id\n"+
                "where account_id = '"+SharedData.getPrimaryMember().getAccount_id()+"'\n" +
                "and p.current_ind=1 \n" +
                "and f.current_ind=1 \n" +
                "and p.coverage_type = '"+planCode+"'\n" +
                "and policy_status = 'SUBMITTED'\n" +
                "order by \n" +
                "b.household_contact DESC,\n" +
                "b.birth_date ASC,\n" +
                "member_financial_start_date DESC;";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getManagePlansLceTypeDetails(String planType, String lceType) {
        String planCode = "";
        if ("Medical".equalsIgnoreCase(planType)) {
            planCode = "1";
        } else if ("Dental".equalsIgnoreCase(planType)) {
            planCode = "2";
        }
        String query = "SELECT DISTINCT b.exch_person_id AS exch_person_id,b.first_name AS first_name, b.last_name AS last_name, b.birth_date AS birth_date, m.relation_to_subscriber AS relation_to_subscriber, b.household_contact AS household_contact,prior_6_months_tobacco_use_ind,coverage_start_date,coverage_end_date,policy_member_coverage_status, p.effectuated_ind AS effectuated_ind, disenrollment_reason, member_financial_start_date, member_financial_end_date, plan_premium_amt, premium_reduction_amt, p.policy_submitted_ts, exchange_assigned_policy_id, plan_marketing_name, policy_start_date, policy_end_date, ehb_percent_of_total_premium, csr_amt, lce_type, lce_event_date, service_area_id, av_calculator_output, hios_plan_id, name, financial_period_end_date, financial_period_start_date, total_plan_premium_amt, total_premium_reduction_amt, total_responsible_amt, total_csr_amt\n" +
                "FROM "+dbName+".en_policy_ah p\n" +
                "inner join "+dbName+".en_policy_member_ah m on m.policy_ah_id=p.policy_ah_id\n" +
                "inner join "+dbName+".en_policy_member_coverage_ah c on c.policy_member_ah_id=m.policy_member_ah_id\n" +
                "inner join "+dbName+".en_member_coverage_financial_ah f on f.policy_member_coverage_ah_id=c.policy_member_coverage_ah_id\n" +
                "inner join "+dbName+".es_member_ah b on m.exch_person_id = b.exch_person_id\n"+
                "inner join "+dbName+".en_plan d on d.plan_id = p.plan_id\n"+
                "inner join "+dbName+".es_member_lce k on k.member_id = b.member_id\n"+
                "inner join "+dbName+".en_rating_area n on n.rating_area_id = p.rating_area_id\n"+
                "inner join "+dbName+".en_policy_financial a on a.policy_id = p.policy_id\n"+
                "where account_id = '"+SharedData.getPrimaryMember().getAccount_id()+"'\n" +
                "and p.current_ind=1 \n" +
                "and f.current_ind=1 \n" +
                "and p.coverage_type = '"+planCode+"'\n" +
                "and policy_status = 'SUBMITTED'\n" +
                "and lce_type like '"+lceType.toUpperCase()+"%'\n" +
                "order by \n" +
                "b.household_contact DESC,\n" +
                "b.birth_date ASC,\n" +
                "member_financial_end_date DESC,\n" +
                "financial_period_end_date DESC;";
        System.out.println("Executing Query: " + query);
        return query;
    }

    public String getManagePlansDetailsYear(String planType, String planYear) {
        String planCode = "";
        if ("Medical".equalsIgnoreCase(planType)) {
            planCode = "1";
        } else if ("Dental".equalsIgnoreCase(planType)) {
            planCode = "2";
        }
        String query = "SELECT DISTINCT b.exch_person_id AS exch_person_id,b.first_name AS first_name, b.last_name AS last_name, b.birth_date AS birth_date, m.relation_to_subscriber AS relation_to_subscriber, b.household_contact AS household_contact,prior_6_months_tobacco_use_ind,coverage_start_date,coverage_end_date,policy_member_coverage_status, p.effectuated_ind AS effectuated_ind, disenrollment_reason, member_financial_start_date, member_financial_end_date, plan_premium_amt, premium_reduction_amt, p.policy_submitted_ts, exchange_assigned_policy_id, plan_marketing_name, policy_start_date, policy_end_date, ehb_percent_of_total_premium, csr_amt, lce_type, lce_event_date, service_area_id, av_calculator_output, hios_plan_id, name, financial_period_end_date, financial_period_start_date\n" +
                "FROM "+dbName+".en_policy_ah p\n" +
                "inner join "+dbName+".en_policy_member_ah m on m.policy_ah_id=p.policy_ah_id\n" +
                "inner join "+dbName+".en_policy_member_coverage_ah c on c.policy_member_ah_id=m.policy_member_ah_id\n" +
                "inner join "+dbName+".en_member_coverage_financial_ah f on f.policy_member_coverage_ah_id=c.policy_member_coverage_ah_id\n" +
                "inner join "+dbName+".es_member_ah b on m.exch_person_id = b.exch_person_id\n"+
                "inner join "+dbName+".en_plan d on d.plan_id = p.plan_id\n"+
                "inner join "+dbName+".es_member_lce k on k.member_id = b.member_id\n"+
                "inner join "+dbName+".en_rating_area n on n.rating_area_id = p.rating_area_id\n"+
                "inner join "+dbName+".en_policy_financial a on a.policy_id = p.policy_id\n"+
                "where account_id = '"+SharedData.getPrimaryMember().getAccount_id()+"'\n" +
                "and p.current_ind=1 \n" +
                "and f.current_ind=1 \n" +
                "and p.coverage_type = '"+planCode+"'\n" +
                "and policy_status = 'SUBMITTED'\n" +
                "and p.plan_year = '"+planYear+"'\n" +
                "order by \n" +
                "b.household_contact DESC,\n" +
                "b.birth_date ASC,\n" +
                "member_financial_start_date DESC;";
        System.out.println("Executing Query: " + query);
        return query;
    }

    //query for termed - cancelled policy
    public String getManagePlansTermedDetails(String planType) {
            String planCode = "";
            if ("Medical".equalsIgnoreCase(planType)) {
                planCode = "1";
            } else if ("Dental".equalsIgnoreCase(planType)) {
                planCode = "2";
            }
            String query = "SELECT DISTINCT b.exch_person_id AS exch_person_id,b.first_name AS first_name, b.last_name AS last_name, b.birth_date AS birth_date, m.relation_to_subscriber AS relation_to_subscriber, b.household_contact AS household_contact,prior_6_months_tobacco_use_ind,coverage_start_date,coverage_end_date,policy_member_coverage_status, p.effectuated_ind AS effectuated_ind, disenrollment_reason, member_financial_start_date, member_financial_end_date, plan_premium_amt, premium_reduction_amt, p.policy_submitted_ts, exchange_assigned_policy_id, plan_marketing_name, policy_start_date, policy_end_date, ehb_percent_of_total_premium, csr_amt, lce_type, lce_event_date, service_area_id, av_calculator_output, hios_plan_id, name, financial_period_end_date, financial_period_start_date\n" +
                "FROM "+dbName+".en_policy_ah p\n" +
                "inner join "+dbName+".en_policy_member_ah m on m.policy_ah_id=p.policy_ah_id\n" +
                "inner join "+dbName+".en_policy_member_coverage_ah c on c.policy_member_ah_id=m.policy_member_ah_id\n" +
                "inner join "+dbName+".en_member_coverage_financial_ah f on f.policy_member_coverage_ah_id=c.policy_member_coverage_ah_id\n" +
                "inner join "+dbName+".es_member_ah b on m.exch_person_id = b.exch_person_id\n"+
                "inner join "+dbName+".en_plan d on d.plan_id = p.plan_id\n"+
                "inner join "+dbName+".es_member_lce k on k.member_id = b.member_id\n"+
                "inner join "+dbName+".en_rating_area n on n.rating_area_id = p.rating_area_id\n"+
                "inner join "+dbName+".en_policy_financial a on a.policy_id = p.policy_id\n"+
                "where account_id = '"+SharedData.getPrimaryMember().getAccount_id()+"'\n" +
                "and p.current_ind=1 \n" +
                "and f.current_ind=1 \n" +
                "and p.coverage_type = '"+planCode+"'\n" +
                "and policy_status = 'CANCELLED'\n" +
                "order by \n" +
                "b.household_contact DESC,\n" +
                "b.birth_date ASC,\n" +
                "member_financial_start_date DESC;";
        System.out.println("Executing Query: " + query);
        return query;
        }
    public String getManagePlansDetailsYearCoCo(String planType, String planYear) {
        String planCode = "";
        if ("Medical".equalsIgnoreCase(planType)) {
            planCode = "1";
        } else if ("Dental".equalsIgnoreCase(planType)) {
            planCode = "2";
        }
        String query = "SELECT DISTINCT b.exch_person_id AS exch_person_id,b.first_name AS first_name, b.last_name AS last_name, b.birth_date AS birth_date, m.relation_to_subscriber AS relation_to_subscriber, b.household_contact AS household_contact,prior_6_months_tobacco_use_ind,coverage_start_date,coverage_end_date,policy_member_coverage_status, p.effectuated_ind AS effectuated_ind, disenrollment_reason, member_financial_start_date, member_financial_end_date, plan_premium_amt, premium_reduction_amt, p.policy_submitted_ts, exchange_assigned_policy_id, plan_marketing_name, policy_start_date, policy_end_date, ehb_percent_of_total_premium, csr_amt, service_area_id, av_calculator_output, hios_plan_id, name, financial_period_end_date, financial_period_start_date\n" +
                "FROM "+dbName+".en_policy_ah p\n" +
                "inner join "+dbName+".en_policy_member_ah m on m.policy_ah_id=p.policy_ah_id\n" +
                "inner join "+dbName+".en_policy_member_coverage_ah c on c.policy_member_ah_id=m.policy_member_ah_id\n" +
                "inner join "+dbName+".en_member_coverage_financial_ah f on f.policy_member_coverage_ah_id=c.policy_member_coverage_ah_id\n" +
                "inner join "+dbName+".es_member_ah b on m.exch_person_id = b.exch_person_id\n"+
                "inner join "+dbName+".en_plan d on d.plan_id = p.plan_id\n"+

                "inner join "+dbName+".en_rating_area n on n.rating_area_id = p.rating_area_id\n"+
                "inner join "+dbName+".en_policy_financial a on a.policy_id = p.policy_id\n"+
                "where account_id = '"+SharedData.getPrimaryMember().getAccount_id()+"'\n" +
                "and p.current_ind=1 \n" +
                "and f.current_ind=1 \n" +
                "and p.coverage_type = '"+planCode+"'\n" +
                "and policy_status = 'SUBMITTED'\n" +
                "and p.plan_year = '"+planYear+"'\n" +
                "order by \n" +
                "b.household_contact DESC,\n" +
                "b.birth_date ASC,\n" +
                "member_financial_start_date DESC;";
        System.out.println("Executing Query: " + query);
        return query;
    }
}

