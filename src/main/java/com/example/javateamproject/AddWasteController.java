package com.example.javateamproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddWasteController {

    @FXML
    private TextArea createWasteID;
    @FXML
    private TextArea createIngredientID;
    @FXML
    private TextArea createQuantity;
    @FXML
    private TextArea createReason;
    @FXML
    private TextArea createDateLogged;
    @FXML
    private TextArea createWasteTypeID;

    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password = "3h058sqxPaI";

    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }


    public void addWasteToDatabase(int WasteID,int IngredientID, int Quantity, String Reason,String DateLogged, int WasteTypeID) throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO Waste (WasteID, IngredientID, Quantity, Reason, DateLogged, WasteTypeID) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, WasteID);
            statement.setInt(2, IngredientID);
            statement.setInt(3, Quantity);
            statement.setString(4, Reason);
            statement.setString(5, DateLogged);
            statement.setInt(6, WasteTypeID);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Waste added successfully!");
            } else {
                System.out.println("Failed to add Waste.");
            }
        } catch (SQLException ex) {
            System.err.println("Error adding Waste: " + ex.getMessage());
        }
    }

    @FXML
    public void wasteSave() {
        try {
            int wasteID = Integer.parseInt(createWasteID.getText());
            int ingredientID = Integer.parseInt(createIngredientID.getText());
            int quantity = Integer.parseInt(createQuantity.getText());
            String reason = createReason.getText();
            String dateLogged = createDateLogged.getText();
            int wasteTypeID = Integer.parseInt(createWasteTypeID.getText());

    // Call the method to add waste data to database
            addWasteToDatabase(wasteID, ingredientID, quantity, reason, dateLogged, wasteTypeID);
        } catch (NumberFormatException | SQLException e) {
            // Handle parsing errors
            System.err.println("Error parsing input: " + e.getMessage());
        }
    }
}
