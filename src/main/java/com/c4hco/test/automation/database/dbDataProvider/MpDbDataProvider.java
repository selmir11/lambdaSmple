package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.database.Queries.DbMpQueries;
import com.c4hco.test.automation.database.Queries.DbQueries_Exch;
import com.c4hco.test.automation.database.dbHandler.*;

import java.util.List;

public class MpDbDataProvider {
    private DbQueries_Exch exchDbQueries = new DbQueries_Exch();
    DbMpQueries dbMpQueries = new DbMpQueries();
    PostgresHandler postgresHandler = new PostgresHandler();



    public List<List<String>> getManagePlansMemberDetails(String planType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansDetails(planType), "exch_person_id", "first_name", "last_name", "birth_date", "relation_to_subscriber", "prior_6_months_tobacco_use_ind", "coverage_end_date");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansCoverageDetails(String planType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansDetails(planType), "coverage_start_date", "coverage_end_date", "policy_member_coverage_status", "effectuated_ind", "disenrollment_reason", "first_name");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansFinancialDetails(String planType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansDetails(planType), "member_financial_start_date", "member_financial_end_date", "plan_premium_amt", "premium_reduction_amt", "first_name", "coverage_end_date");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansPlanSummary(String planType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansDetails(planType), "exchange_assigned_policy_id", "policy_start_date", "first_name", "plan_marketing_name", "policy_end_date", "policy_submitted_ts", "member_financial_start_date", "ehb_percent_of_total_premium", "plan_premium_amt", "member_financial_end_date", "csr_amt", "lce_type", "lce_event_date", "premium_reduction_amt", "name", "service_area_id", "av_calculator_output", "hios_plan_id");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }
}
