package com.example.javateamproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;

public class SqlConnection {

    Connection conn = null;

    private static String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private static String user = "in2033t35_a" ;
    private static String pass = "3h058sqxPaI";

    public static Connection ConnectDb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pass);
//            JOptionPane.showMessageDialog(null,"ConnectionEstablished");
            return conn;

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;

        }
    }

    public static ObservableList<users> getDatausers(){

        Connection conn = ConnectDb();
        ObservableList<users> list = FXCollections.observableArrayList();

        try{
            PreparedStatement ps = conn.prepareStatement("SELECT \n" +
                    "    Menus.MenuID,\n" +
                    "    Menus.WeekStartDate,\n" +
                    "    Dishes.Name AS DishName\n" +
                    "FROM Menus\n" +
                    "JOIN MenuDishes ON Menus.MenuID = MenuDishes.MenuID\n" +
                    "JOIN Dishes ON MenuDishes.DishID = Dishes.DishID\n" +
                    "ORDER BY Menus.MenuID, Dishes.Name;");
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                list.add(new users(Integer.parseInt(rs.getString("MenuID")), rs.getDate("WeekStartDate").toLocalDate(),rs.getString("DishName")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;
    }

    public static ObservableList<WasteEntry> getWasteData(){

        Connection conn = ConnectDb();
        ObservableList<WasteEntry> list = FXCollections.observableArrayList();

        try{
            PreparedStatement ps = conn.prepareStatement("SELECT " +
                    "WasteID, " +
                    "IngredientID, " +
                    "Quantity, " +
                    "Reason, " +
                    "DateLogged, " +
                    "WasteTypeID " +
                    "FROM Waste;");
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                list.add(new WasteEntry((
                        rs.getInt("WasteID")),
                        rs.getInt("IngredientID"),
                        rs.getDouble("Quantity"),
                        rs.getString("Reason"),
                        rs.getDate("DateLogged").toLocalDate()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;
    }

}
