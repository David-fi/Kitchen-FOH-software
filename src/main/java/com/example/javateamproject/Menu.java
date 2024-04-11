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

    public void addMenuToDatabase(String menuName) {
        String sql = "INSERT INTO Menus (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, menuName);
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
    public boolean removeMenuFromDatabase(int menuId) {
        String sql = "DELETE FROM Menus WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, menuId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public boolean updateMenuName(int menuId, String newMenuName) {
        String sql = "UPDATE Menus SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newMenuName);
            statement.setInt(2, menuId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public ResultSet getMenuItems(int menuId) {
        String sql = "SELECT i.* FROM MenuItems mi JOIN Items i ON mi.item_id = i.id WHERE mi.menu_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, menuId);
            return statement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}