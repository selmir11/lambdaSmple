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
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansDetails(planType), "exch_person_id", "first_name", "last_name", "birth_date", "relation_to_subscriber", "prior_6_months_tobacco_use_ind", "financial_period_start_date", "financial_period_end_date");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansCoverageDetails(String planType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansDetails(planType), "coverage_start_date", "coverage_end_date", "policy_member_coverage_status", "effectuated_ind", "disenrollment_reason", "exch_person_id", "financial_period_end_date");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansFinancialDetails(String planType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansDetails(planType), "member_financial_start_date", "member_financial_end_date", "plan_premium_amt", "premium_reduction_amt", "exch_person_id", "coverage_end_date", "financial_period_end_date");
        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansMemberDetailsLce(String planType, String lceType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansLceTypeDetails(planType, lceType), "exch_person_id", "first_name", "last_name", "birth_date", "relation_to_subscriber", "prior_6_months_tobacco_use_ind", "financial_period_start_date", "financial_period_end_date");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansCoverageDetailsLce(String planType, String lceType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansLceTypeDetails(planType, lceType), "coverage_start_date", "coverage_end_date", "policy_member_coverage_status", "effectuated_ind", "disenrollment_reason", "exch_person_id", "financial_period_end_date");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansFinancialDetailsLce(String planType, String lceType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansLceTypeDetails(planType, lceType), "member_financial_start_date", "member_financial_end_date", "plan_premium_amt", "premium_reduction_amt", "exch_person_id", "coverage_end_date", "financial_period_end_date");
        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansPlanSummary(String planType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansDetails(planType), "exchange_assigned_policy_id", "policy_start_date", "first_name", "plan_marketing_name", "policy_end_date", "policy_submitted_ts", "member_financial_start_date", "ehb_percent_of_total_premium", "plan_premium_amt", "member_financial_end_date", "csr_amt", "lce_type", "lce_event_date", "premium_reduction_amt", "name", "service_area_id", "av_calculator_output", "hios_plan_id","financial_period_end_date", "financial_period_start_date");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansPlanSummaryLce(String planType, String lceType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansLceTypeDetails(planType, lceType), "exchange_assigned_policy_id", "policy_start_date", "first_name", "plan_marketing_name", "policy_end_date", "policy_submitted_ts", "member_financial_start_date", "ehb_percent_of_total_premium", "plan_premium_amt", "member_financial_end_date", "csr_amt", "lce_type", "lce_event_date", "premium_reduction_amt", "name", "service_area_id", "av_calculator_output", "hios_plan_id","financial_period_end_date", "financial_period_start_date", "total_plan_premium_amt", "total_premium_reduction_amt", "total_responsible_amt", "total_csr_amt");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansTermedMemberDetails(String planType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansTermedDetails(planType), "exch_person_id", "first_name", "last_name", "birth_date", "relation_to_subscriber", "prior_6_months_tobacco_use_ind", "coverage_end_date");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlansTermedCoverageDetails(String planType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansTermedDetails(planType), "coverage_start_date", "coverage_end_date", "policy_member_coverage_status", "effectuated_ind", "disenrollment_reason", "first_name");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }

    public List<List<String>> getManagePlanstermedFinancialDetails(String planType) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansTermedDetails(planType), "member_financial_start_date", "member_financial_end_date", "plan_premium_amt", "premium_reduction_amt", "first_name", "coverage_end_date");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }


    ////////////////////////////Plans Container//////////////////////////
    public List<List<String>> getManagePlanContainerDetails(String planType, String planYear) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansDetailsYear(planType, planYear), "policy_start_date", "policy_end_date", "plan_marketing_name", "first_name", "plan_premium_amt", "premium_reduction_amt");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }
    public List<List<String>> getManagePlanContainerDetailsCoCo(String planType, String planYear) {
        List<List<String>> results = postgresHandler.getResultForMultipleDynamicColumns(dbMpQueries.getManagePlansDetailsYearCoCo(planType, planYear), "policy_start_date", "policy_end_date", "plan_marketing_name", "first_name", "plan_premium_amt", "premium_reduction_amt");

        System.out.println("Number of rows retrieved: " + results.size());
        return results;
    }
}
