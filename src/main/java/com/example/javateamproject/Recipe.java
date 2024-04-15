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



}