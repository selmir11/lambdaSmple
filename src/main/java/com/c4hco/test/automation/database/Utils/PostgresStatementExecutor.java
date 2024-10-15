package com.c4hco.test.automation.database.Utils;

import java.sql.*;

import static org.testng.Assert.fail;


public class PostgresStatementExecutor {
    Connection connection = PostgresSQLConnection.getInstance();

    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Note: It's generally better to close the connection outside this class,
            // for example, in a higher-level module or test class.
         //   PostgresSQLConnection.closeConnection();
        }
        return resultSet;
    }

    // Method to execute a parameterized query and handle null values
    public ResultSet executeQueryPs(String sql, Object... params) {
        ResultSet resultSet = null;
        try {
            // Use a PreparedStatement to prevent SQL injection and handle nulls
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set parameters in the prepared statement
            for (int i = 0; i < params.length; i++) {
                if (params[i] == null) {
                    // If parameter is null, use setNull with the appropriate SQL type (e.g., Types.INTEGER)
                    preparedStatement.setNull(i + 1, java.sql.Types.NULL); // Use proper SQL type based on the column
                } else {
                    // Otherwise, set the parameter normally
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }

            // Execute the query
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public boolean setRecord(String sql){
        boolean isExecuted = false;
        try{
            Statement statement = connection.createStatement();
            isExecuted = statement.execute(sql);
        } catch(SQLException e){
            e.printStackTrace();
            fail("Error with db occured::"+e.getMessage());
            return false;
        }
        return isExecuted;
    }

}
