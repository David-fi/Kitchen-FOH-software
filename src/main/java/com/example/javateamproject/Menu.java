package com.example.javateamproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu {
    public Connection connection;

    public Menu(Connection connection) {
        this.connection = connection;
    }

    public void addMenuToDatabase(int menuID,String WeekStartDate,int ChefID) {
        String sql = "INSERT INTO Menus (MenuID, WeekStartDate, ChefID) VALUES (menuID, WeekStartDate, ChefID)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, menuID);
            statement.setInt(2, ChefID);
            statement.setString(3, WeekStartDate);
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
    public void addDishesToMenu(int menuID,int DishID) {
        String sql = "INSERT INTO MenuDishes WHERE MenuID = ?,WHERE DishID= ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, menuID);
            statement.setInt(2, DishID);
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
    public void removeDishesFromMenu(int DishID) {
        String sql = "DELETE FROM MenuDishes WHERE MenuID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,DishID);
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

    public boolean removeMenuFromDatabase(int menuId) {
        String sql = "DELETE FROM Menus WHERE MenuID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, menuId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.getMessage();
            return false;
        }
    }


}