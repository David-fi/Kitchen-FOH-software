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

    public boolean editRecipe(int RecipeId, String newRecipeName, String Description,String ApprovalStatus,String Comments) {
        String sql = "UPDATE Recipe SET Name = ? AND Description=? AND Status=? AND Comments=? WHERE RecipeId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newRecipeName);
            statement.setString(2, Description);
            statement.setString(3, ApprovalStatus);
            statement.setString(4, Comments);
            statement.setInt(5, RecipeId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.getMessage();
            return false;
        }
    }


}