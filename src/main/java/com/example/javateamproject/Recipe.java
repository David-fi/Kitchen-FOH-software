package com.example.javateamproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Recipe {
    public Connection connection;

    public Recipe(Connection connection) {
        this.connection = connection;
    }

    public void addRecipeToDatabase(int RecipeID) {
        String sql = "INSERT INTO Menus WHERE MenuID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, RecipeID);
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
    public boolean removeRecipeFromDatabase(int RecipeId) {
        String sql = "DELETE FROM Menus WHERE RecipeID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, RecipeId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean editRecipeName(int RecipeId, String newRecipeName) {
        String sql = "UPDATE Recipe SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newRecipeName);
            statement.setInt(2, RecipeId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


}