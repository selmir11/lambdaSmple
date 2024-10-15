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
    public ResultSet executeQueryPs(String sql, Object[] parameters) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            // Prepare the SQL statement
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters dynamically, including handling null values
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    if (parameters[i] == null) {
                        preparedStatement.setObject(i + 1, null);  // Set SQL NULL
                    } else {
                        preparedStatement.setObject(i + 1, parameters[i]);  // Set the parameter value
                    }
                }
            }
            // Execute the query
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the prepared statement to avoid memory leaks
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
