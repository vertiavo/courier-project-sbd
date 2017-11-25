package com.project.common;
import com.project.model.Car;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView<Car> table;

    @FXML
    private TableColumn<Car, String> col1; //brand

    @FXML
    private TableColumn<Car, String> col2; //model

    public ObservableList<Car> data;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
    }


}