package com.example.javateamproject;


import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    private TableColumn<users, Integer> col_id;

    @FXML
    private TableColumn<users, String> col_name;

    @FXML
    private TableColumn<users, LocalDate> col_weekstartdate;

    @FXML
    private TableView<users> table_users;

    @FXML
    private TextField keywordTextField;

    ObservableList<users> listM;

//    int index = -1;

    Connection conn = null;

    ResultSet rs = null;

    PreparedStatement pst = null;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        col_id.setCellValueFactory(new PropertyValueFactory<users,Integer>("id"));
        col_weekstartdate.setCellValueFactory(new PropertyValueFactory<users,LocalDate>("WeekStartDate"));

        col_name.setCellValueFactory(new PropertyValueFactory<users,String>("Name"));

        listM = SqlConnection.getDatausers();
        table_users.setItems(listM);

        FilteredList<users> filteredData = new FilteredList<>(listM,b->true);

//        keywordTextField.textProperty().addListener((observable,oldValue,newValue) -> {
//            filteredData.setPredicate(users -> {
//                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
//                    return true;
//                }
//                String specificKeyword = newValue.toLowerCase();
//
//                if(users.getName().toLowerCase().indexOf(specificKeyword) > -1){
//                    return true;
//                } else if (String.valueOf(users.getId()).toLowerCase().indexOf(specificKeyword) > -1){
//                    return true;
//                } else if(users.getWeekStartDate().toString().indexOf(specificKeyword) > -1){
//                    return true;
//                } else
//                    return false;
//            });
//        });

        SortedList<users> sortedData = new SortedList<>(filteredData);

        //update table with sorted result and bind it
        sortedData.comparatorProperty().bind(table_users.comparatorProperty());

        table_users.setItems(sortedData);


    }
}