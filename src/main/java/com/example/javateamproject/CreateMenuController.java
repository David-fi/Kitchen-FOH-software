package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CreateMenuController {

    @FXML
    private TextArea CreateMenuEnterMenuID;
    @FXML
    private TextField CreateMenuEnterDate;
    @FXML
    private TextArea CreateMenuEnterChefID;

    public Connection connection;
    @FXML
    private Button signinButton;
    @FXML
    private ImageView chefImage;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView signinImage;
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password ="3h058sqxPaI";


    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }


    public void addMenuToDatabase(int menuID,int WeekStartDate,int ChefID) {

        try {
                Connection connection = null;
                connection=DriverManager.getConnection(url,user,password);
            String sql = "INSERT INTO Menus (MenuID, WeekStartDate, ChefID) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            {
                statement.setInt(1, menuID);
                statement.setInt(2, WeekStartDate);
                statement.setInt(3, ChefID);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Menu added successfully!");
                } else {
                    System.out.println("Failed to add menu.");
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    public void HandleSaveMenu(){
      int createMenuEnterMenuID=Integer.parseInt(CreateMenuEnterMenuID.getText());
      int createMenuEnterDate=Integer.parseInt(CreateMenuEnterDate.getText());
      int createMenuEnterChefID=Integer.parseInt(CreateMenuEnterChefID.getText());
      addMenuToDatabase(createMenuEnterMenuID,createMenuEnterDate,createMenuEnterChefID);
    }
}
