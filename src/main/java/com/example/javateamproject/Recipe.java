package com.example.javateamproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Recipe {
    private Connection connection;

    public Recipe(Connection connection) {
        this.connection = connection;
    }

    public boolean updateRecipeName(int recipeId, String newRecipeName) {
        String sql = "UPDATE Recipes SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newRecipeName);
            statement.setInt(2, recipeId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addIngredientToRecipe(int recipeId, int ingredientId) {
        String sql = "INSERT INTO RecipeIngredients (recipe_id, ingredient_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recipeId);
            statement.setInt(2, ingredientId);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean removeIngredientFromRecipe(int recipeId, int ingredientId) {
        String sql = "DELETE FROM RecipeIngredients WHERE recipe_id = ? AND ingredient_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recipeId);
            statement.setInt(2, ingredientId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ResultSet getRecipeIngredients(int recipeId) {
        String sql = "SELECT i.* FROM RecipeIngredients ri JOIN Ingredients i ON ri.ingredient_id = i.id WHERE ri.recipe_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recipeId);
            return statement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean addRecipeToMenu(int recipeId, int menuId) {
        String sql = "INSERT INTO RecipeMenus (recipe_id, menu_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recipeId);
            statement.setInt(2, menuId);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean removeRecipeFromMenu(int recipeId, int menuId) {
        String sql = "DELETE FROM RecipeMenus WHERE recipe_id = ? AND menu_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recipeId);
            statement.setInt(2, menuId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
