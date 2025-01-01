package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostgresHandler {
    private static PostgresStatementExecutor executor = new PostgresStatementExecutor();

    public String getResultFor(String columnValue, String query) {
        String result = "";
        try {
            ResultSet rs = executor.executeQuery(query);
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

    public List<String> getResultListFor(String columnValue, String query) {
        List<String> resultList = new ArrayList<>();

        try {
            ResultSet rs = executor.executeQuery(query);
            while (rs.next()) {
                resultList.add(rs.getString(columnValue) != null ? rs.getString(columnValue).trim() : "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Error with db occurred: " + e.getMessage());
        }
        return resultList;
    }

    public Map<String, String> getResultForTwoColumnValuesInMap(String columnValue1, String columnValue2, String query) {
        Map<String, String> results = new HashMap<String, String>();
        try {
            ResultSet rs = executor.executeQuery(query);
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
        try {
            ResultSet rs = executor.executeQuery(query);
            if (rs.next()) {
                results = new String[]{rs.getString(columnValue1), rs.getString(columnValue2)};
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Error with db occurred: " + e.getMessage());
        }
        return results;
    }

    public String[] getResultForThreeColumnValues(String columnValue1, String columnValue2, String columnValue3, String query) {
        String[] results = new String[3];
        try {
            ResultSet rs = executor.executeQuery(query);
            if (rs.next()) {
                results = new String[]{rs.getString(columnValue1), rs.getString(columnValue2), rs.getString(columnValue3)};
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Error with db occurred: " + e.getMessage());
        }
        return results;
    }

    public String[] getResultForFiveColumnValues(String columnValue1, String columnValue2, String columnValue3, String columnValue4, String columnValue5, String query) {
        String[] results = new String[5];
        try {
            ResultSet rs = executor.executeQuery(query);
            if (rs.next()) {
                results = new String[]{rs.getString(columnValue1), rs.getString(columnValue2), rs.getString(columnValue3), rs.getString(columnValue4), rs.getString(columnValue5)};
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
            rs = executor.executeQuery(query);
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

    public static Map<String, List<String>> getResultForMultipleColumnValuesInMap(String query, String[] columnValues) {
        Map<String, List<String>> results = new HashMap<>();
        try {
            ResultSet rs = executor.executeQuery(query);
            while (rs.next()) {
                StringBuilder keyBuilder = new StringBuilder();
                for (String columnValue : columnValues) {
                    keyBuilder.append(rs.getString(columnValue)).append("_");
                }
                String key = keyBuilder.toString();
                key = key.substring(0, key.length() - 1);

                List<String> rowValues = new ArrayList<>();
                for (String columnValue : columnValues) {
                    rowValues.add(rs.getString(columnValue));
                }
                results.put(key, rowValues);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Error with db occurred: " + e.getMessage());
        }
        return results;
    }

    public boolean setRec(String query){
        Boolean  recordIsSet =  executor.setRecord(query);
        return recordIsSet;
    }

    public static List<Map<String, Object>> retrieveResults(String query) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        try  {
            ResultSet rs = executor.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> rowMap = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = rs.getObject(i);
                    rowMap.put(columnName, columnValue);
                }
                resultList.add(rowMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public String[] getResultForSixColumnValues(String columnValue1, String columnValue2, String columnValue3, String columnValue4, String columnValue5, String columnValue6, String query) {
        String[] results = new String[5];
        try {
            ResultSet rs = executor.executeQuery(query);
            if (rs.next()) {
                results = new String[]{rs.getString(columnValue1), rs.getString(columnValue2), rs.getString(columnValue3), rs.getString(columnValue4), rs.getString(columnValue5), rs.getString(columnValue6)};
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Error with db occurred: " + e.getMessage());
        }
        return results;
    }

}


