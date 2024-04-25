package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostgresHandler {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();
    public String getResultFor(String columnValue, String query) {
        String result = "";
        try {
            ResultSet rs =executor.executeQuery(query);
            if (rs.next()) {
                result = rs.getString(columnValue);
            } else {
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Error with db occurred: " + e.getMessage());
        }
        return result;
    }

    public List<String> getResultListFor(String columnValue,String columnValue2, String query) {
        List<String> resultList = new ArrayList<>();

        try {
            ResultSet rs =executor.executeQuery(query);
            while (rs.next()) {
                resultList.add(rs.getString(columnValue) != null ? rs.getString(columnValue).trim() : "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Error with db occurred: " + e.getMessage());
        }
        return resultList;
    }

    public Map<String,String> getResultForTwoColumnValuesInMap(String columnValue1, String columnValue2, String query) {
        Map<String,String> results=new HashMap<String,String>();
        try {
            ResultSet rs =executor.executeQuery(query);
            while (rs.next()) {
                results.put(rs.getString(columnValue1), rs.getString(columnValue2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Error with db occurred: " + e.getMessage());
        }
        return results;
    }

    public String[] getResultForTwoColumnValues(String columnValue1, String columnValue2, String query) {
        String[] results = new String[2];
        try{
            ResultSet rs =executor.executeQuery(query);
            if (rs.next()) {
                results = new String[]{rs.getString(columnValue1), rs.getString(columnValue2)};
            }
        } catch (SQLException e) {
            e.printStackTrace();
           Assert.fail("Error with db occurred: " + e.getMessage());
        }
        return results;
    }

    public Boolean dbRecordsExisting(String query) {
        ResultSet rs = null;
        Boolean hasRecords = null;
        try {
            rs =executor.executeQuery(query);
            if (rs.next()) {
                hasRecords = true;
            } else {
                hasRecords = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Error with db occurred: " + e.getMessage());
        }
        return hasRecords;
    }
}
