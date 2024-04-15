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

public class DeleteWasteController {

    @FXML
    private TextArea theWasteID;

    private String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t35";
    private String user = "in2033t35_a";
    private String password = "3h058sqxPaI";


    public void handleCloseButton(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void deleteWasteEntry(int wasteID) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM Waste WHERE WasteID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, wasteID);

                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Waste entry deleted successfully!");
                } else {
                    System.out.println("No waste entry found with ID: " + wasteID);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error deleting waste entry: " + ex.getMessage());
        } finally {
            if (connection != null) {
                connection.close(); // Close the connection
            }
        }
    }
    @FXML
    public void deleteWaste() {
        try {
            int wasteID = Integer.parseInt(theWasteID.getText());

            deleteWasteEntry(wasteID);
        } catch (NumberFormatException | SQLException e) {
            // Handle parsing errors or SQL exceptions
            System.err.println("Error deleting waste entry: " + e.getMessage());
        }
    }


}
