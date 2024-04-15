package com.example.javateamproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditWasteController {

    @FXML
    private TextArea currentWasteID;
    @FXML
    private TextArea newQuantity;
    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password = "3h058sqxPaI";


    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void updateWasteQuantity(int wasteID, int newQuantity) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE Waste SET Quantity = ? WHERE WasteID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, newQuantity);
                statement.setInt(2, wasteID);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Waste quantity updated successfully!");
                } else {
                    System.out.println("No waste found with ID: " + wasteID);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error updating waste quantity: " + ex.getMessage());
        } finally {
            if (connection != null) {
                connection.close(); // Close the connection
            }
        }
    }

        @FXML
        public void updateWaste() {
            try {
                int wasteIDv = Integer.parseInt(currentWasteID.getText());
                int newQuantityv = Integer.parseInt(newQuantity.getText());

                updateWasteQuantity(wasteIDv, newQuantityv);
            } catch (NumberFormatException | SQLException e) {
                // Handle parsing errors or SQL exceptions
                System.err.println("Error updating waste quantity: " + e.getMessage());
            }
        }






    }

