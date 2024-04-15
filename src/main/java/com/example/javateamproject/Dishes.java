package com.example.javateamproject;

import com.sun.net.httpserver.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dishes {
    public Connection connection;

    public Dishes(Connection connection) {
        this.connection = connection; //To implement a connection
    }

    public void addDishesToDatabase(int DishesID,String Name, int RecipeID, String PhotoPath,int PreparationTime) {
        String sql = "INSERT INTO Dishes WHERE DishID = ?AND Name=? AND RecipeID=? AND PhotoPath=? AND PreparationTime=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, DishesID);
            statement.setString(2, Name);
            statement.setInt(3, RecipeID);
            statement.setString(4, PhotoPath);
            statement.setInt(5, PreparationTime);
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
    public void addDishesAllergens(int DishesID,int AllergenID) {
        String sql = "INSERT INTO Dishes WHERE DishID = ? AND AllergenID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, DishesID);
            statement.setInt(2, AllergenID);
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
    public void addDishesSpecialRequest(int DishesID, int CanAccommodateSpecialRequest, String SpecialRequest) {
        String sql = "INSERT INTO Dishes WHERE DishID = ? AND AllergenID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, DishesID);
            statement.setInt(2, CanAccommodateSpecialRequest);
            statement.setString(3, SpecialRequest);
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
        String sql = "DELETE FROM Menus WHERE DishID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, DishesId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }



}