package com.project.common;
import com.project.model.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.net.URL;
import java.util.Iterator;
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
        col1.setCellValueFactory(new PropertyValueFactory<Car,String>("brand"));
        col2.setCellValueFactory(new PropertyValueFactory<Car,String>("model"));

        data  =  FXCollections.observableArrayList();
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session sess  =sf.openSession();
        Query qee = sess.createQuery("from Car ");
        Iterator ite  =qee.iterate();
        while(ite.hasNext())
        {
            Car obj = (Car)ite.next();

            data.add(obj);
        }
        table.setItems(data);
    }


}