module com.example.javateamproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javateamproject to javafx.fxml;
    exports com.example.javateamproject;
}