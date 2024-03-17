package com.c4hco.test.automation.database.dbDataProvider;

import com.c4hco.test.automation.database.EntityObj.PolicyTableEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PolicyTableDbHandler {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();

    public List<PolicyTableEntity> getPolicyTableDetails(String query, String appType)  {
        List<PolicyTableEntity> dbDataList = new ArrayList<>();
        ResultSet rs;
        try {
            rs = executor.executeQuery(query);
            while (rs.next()) {
                PolicyTableEntity policyTableEntity = new PolicyTableEntity();
                System.out.println("--db entries--"+rs.getString("first_name"));
                System.out.println("policy table entries---"+policyTableEntity);
                // ---- Set all the values from db ---- //
                dbDataList.add(policyTableEntity);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return dbDataList;
    }
}
