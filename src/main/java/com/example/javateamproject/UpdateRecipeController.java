package com.example.javateamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.w3c.dom.Text;


import java.sql.*;


public class UpdateRecipeController {
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password ="3h058sqxPaI";
    public Connection connection;
    @FXML
    private TextArea UpdateRecipeEnterNewName;
    @FXML
    private TextArea UpdateRecipeEnterRecipeID;
    @FXML
    private TextArea UpdateRecipeEnterNewStatus;
    @FXML
    private TextArea UpdateRecipeEnterNewComments;
    @FXML
    private TextArea UpdateRecipeEnterNewDescription;

    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void editRecipe(int RecipeId, String newRecipeName, String Description, String ApprovalStatus, String Comments) {

        try {
            Connection connection = null;
            connection = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE Recipes SET Name = ?, Description = ?, Status = ?, Comments = ? WHERE RecipeId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);{
                statement.setString(1, newRecipeName);
                statement.setString(2, Description);
                statement.setString(3, ApprovalStatus);
                statement.setString(4, Comments);
                statement.setInt(5, RecipeId);
                int rowsUpdated = statement.executeUpdate();
                if(rowsUpdated>0){
                    System.out.println("Rows Updated");
                }else{
                    System.out.println("No rows updated");
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();

        }
    }
    public void HandleUpdateRecipe(){
        String updateRecipeEnterNewName=UpdateRecipeEnterNewName.getText();
        String updateRecipeEnterDescription=UpdateRecipeEnterNewDescription.getText();
        String updateRecipeEnterNewStatus=UpdateRecipeEnterNewStatus.getText();
        String updateRecipeEnterNewComment=UpdateRecipeEnterNewComments.getText();
        int updateRecipeEnterRecipeID=Integer.parseInt(UpdateRecipeEnterRecipeID.getText());
        editRecipe(updateRecipeEnterRecipeID,updateRecipeEnterNewName,updateRecipeEnterDescription,updateRecipeEnterNewStatus,updateRecipeEnterNewComment);
    }

}
