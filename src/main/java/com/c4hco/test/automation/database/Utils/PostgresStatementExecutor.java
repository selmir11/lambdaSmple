package com.c4hco.test.automation.database.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresStatementExecutor {
    public ResultSet executeQuery(String sql) {
        Connection connection = PostgresSQLConnection.getInstance();
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

}
