package com.c4hco.test.automation.database.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
