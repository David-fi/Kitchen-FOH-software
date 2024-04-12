package com.example.javateamproject;

import java.sql.*;

public class DatabaseConnection {

    public Connection connection;
    public Statement statement;

    public DatabaseConnection() {
        createConnection();
    }
    public int addIngredient(String ingredientName) {
        String insertString = "INSERT INTO Ingredient VALUES (?)";
        try (PreparedStatement insertStmt = this.connection.prepareStatement(insertString)) {
            insertStmt.setString(1, ingredientName);
            int affectedRows = insertStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating ingredient failed, no rows affected.");
            }

            try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating ingredient failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Create Ingredient Error: " + e.getMessage());
        }
        return -1;
    }
     public void createConnection() {
        try {
            //Class.forName("com.mysql.cj.jbdc.Driver");
            String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
            String user = "in2033t35_d";
            String password = "pSRHdoIqm74";
            this.connection = DriverManager.getConnection(url, user, password);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
}
    }
    public static void main(String[] args) {
        DatabaseConnection pro = new DatabaseConnection();
        pro.createConnection();
    }
}
