package com.example.javateamproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dishes {
    public Connection connection;

    public Dishes(Connection connection) {
        this.connection = connection; //To implement a connection
    }

    public void addDishesToDatabase(int DishesID) {
        String sql = "INSERT INTO Dishes WHERE DishesID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, DishesID);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Menu added successfully!");
            } else {
                System.out.println("Failed to add menu.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean removeDishesFromDatabase(int DishesId) {
        String sql = "DELETE FROM Menus WHERE DishesID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, DishesId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean editDishes(int DishesId, String newDishesName) {
        String sql = "UPDATE Dishes SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newDishesName);
            statement.setInt(2, DishesId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}