package com.c4hco.test.automation.database.Utils;

import com.c4hco.test.automation.utils.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgresSQLConnection {

    private static Connection connection;

    private PostgresSQLConnection(){

    }

    public static Connection getInstance(){
        if(connection == null){
            initializeDBConnection();
        }
        return connection;
    }

    private static void initializeDBConnection(){
        System.out.println("initializing db connection");
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Set the PostgreSQL connection properties
            String host = ApplicationProperties.getInstance().getProperty("host");
            String port = ApplicationProperties.getInstance().getProperty("port");
            String database = ApplicationProperties.getInstance().getProperty("database");
            String url = "jdbc:postgresql://"+host+":"+port+"/"+database;
            String username = ApplicationProperties.getInstance().getProperty("dbUsername");
            String password = ApplicationProperties.getInstance().getProperty("dbPassword");

            System.out.println("dbUname::"+username);
            System.out.println("url::"+url
            );
            // Create the database connection
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to PostgreSQL database!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize database connection");
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Closed PostgreSQL database connection!");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to close database connection");
            }
        }
    }
}
