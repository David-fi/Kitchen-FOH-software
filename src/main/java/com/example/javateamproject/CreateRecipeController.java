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


public class CreateRecipeController {

    @FXML
    private TextArea CreateRecipeEnterRecipeID;
    @FXML
    private TextArea CreateRecipeEnterName;
    @FXML
    private TextArea CreateRecipeEnterDescription;
    @FXML
    private TextArea CreateRecipeEnterChefID;
    @FXML
    private TextArea CreateRecipeEnterApprovalStatus;
    @FXML
    private TextArea CreateRecipeEnterStatus;
    @FXML
    private TextArea CreateRecipeEnterCustomerComments;
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

    public void addRecipeToDatabase(int RecipeID, String Name, String Description, int ChefID, String ApprovalStatus, String Status, String Comments) {

        try {
            Connection connection = null;
            connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO Recipes (RecipeID, Name, Description, ApprovalStatus, Status, Comments) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            {
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
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    public void HandleSaveRecipe(){
        int createRecipeEnterRecipeID = Integer.parseInt(CreateRecipeEnterRecipeID.getText());
        String createRecipeEnterName=CreateRecipeEnterName.getText();
        String createRecipeEnterDescription=CreateRecipeEnterDescription.getText();
        int createRecipeEnterChefID=Integer.parseInt(CreateRecipeEnterChefID.getText());
        String createRecipeEnterApprovalStatus=CreateRecipeEnterApprovalStatus.getText();
        String createRecipeEnterStatus=CreateRecipeEnterStatus.getText();
        String createRecipeEnterCustomerComments=CreateRecipeEnterCustomerComments.getText();
        addRecipeToDatabase(createRecipeEnterRecipeID,createRecipeEnterName,createRecipeEnterDescription,createRecipeEnterChefID,createRecipeEnterApprovalStatus,createRecipeEnterStatus,createRecipeEnterCustomerComments);
    }
}
