package com.example.javateamproject;

import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Waste {

    public Connection connection;

    public Waste (Connection connection) {
        this.connection = connection;
    }

    public void addWasteToDatabase(int WasteID,int IngredientID, int Quantity, String Reason,String DateLogged, int WasteTypeID) {
        String sql = "INSERT INTO Waste (WasteID, IngredientID, Quantity, Reason, DateLogged, WasteTypeID) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, WasteID);
            statement.setInt(2, IngredientID);
            statement.setInt(3, Quantity);
            statement.setString(4, Reason);
            statement.setString(5, DateLogged);
            statement.setInt(6, WasteTypeID);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Waste added successfully!");
            } else {
                System.out.println("Failed to add Waste.");
            }
        } catch (SQLException ex) {
            System.err.println("Error adding Waste: " + ex.getMessage());
        }
    }










    public boolean removeWasteFromDatabase(int WasteID) {
        String sql = "DELETE FROM Waste WHERE WasteID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, WasteID);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.getMessage();
            return false;
        }
    }

    public boolean editWasteQuantity(int WasteID,int IngredientID, int newQuantity, String Reason,String DateLogged, int WasteTypeID) {
        String sql = "UPDATE Waste SET Quantity = ? AND IngredientID=? AND Reason=? And DateLogged=? And WasteTypeID=? WHERE WasteID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, newQuantity);
            statement.setInt(2, IngredientID);
            statement.setString(3, Reason);
            statement.setString(4, DateLogged);
            statement.setInt(5, WasteTypeID);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.getMessage();
            return false;
        }
    }
}
