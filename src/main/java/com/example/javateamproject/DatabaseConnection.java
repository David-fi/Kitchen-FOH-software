package com.example.javateamproject;

import java.sql.*;

public class DatabaseConnection {

    public Connection connection;
    public Statement statement;

    public DatabaseConnection() {
        createConnection();
    }
    public void createConnection() {
        try {
            String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
            String user = "in2033t35_d";
            String password = "pSRHdoIqm74";
            this.connection = DriverManager.getConnection(url, user, password);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
}
    }
}
