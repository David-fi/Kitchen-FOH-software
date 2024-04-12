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

    public void addRecipeToDatabase(int RecipeID,String Name,String Description,int ChefID,String ApprovalStatus,String Status,String Comments) {
        String sql = "INSERT INTO Recipes WHERE RecipeID = ? AND Name = ? AND Description = ? AND ApprovalStatus = ? AND Status = ? AND Comments = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, RecipeID);
            statement.setString(2, Name);
            statement.setString(3, Description);
            statement.setString(4, ApprovalStatus);
            statement.setString(5, Status);
            statement.setString(6, Comments);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Menu added successfully!");
            } else {
                System.out.println("Failed to add menu.");
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    public boolean removeRecipeFromDatabase(int RecipeId) {
        String sql = "DELETE FROM Recipes WHERE RecipeID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, RecipeId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.getMessage();
            return false;
        }
    }

    public boolean editRecipeName(int RecipeId, String newRecipeName, String Description,String ApprovalStatus,String Comments) {
        String sql = "UPDATE Recipe SET Name = ? AND Description=? AND Status=? AND Comments=? WHERE RecipeId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newRecipeName);
            statement.setString(2, Description);
            statement.setString(3, ApprovalStatus);
            statement.setString(5, Comments);
            statement.setInt(5, RecipeId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.getMessage();
            return false;
        }
    }


}