package com.project.common.table.helper;

import com.project.dao.CourierDao;
import com.project.dao.jpa.CourierJpaDao;
import com.project.dto.Courier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableCourierHelper {

    private final ObservableList<Courier> data;
    private TableView<Courier> courierTable;
    private CourierDao courierDao = new CourierJpaDao();

    public TableCourierHelper(TableView courierTable) {
        this.courierTable = courierTable;
        this.data = loadCourierData();
        setUp();
    }

    private ObservableList<Courier> loadCourierData() {
        return FXCollections.observableArrayList(courierDao.getAll());
    }

    private void setUp() {
        courierTable.getColumns().clear();
        courierTable.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<Courier, Integer>("idCourier"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<Courier, String>("name"));

        TableColumn surnameCol = new TableColumn("Surname");
        surnameCol.setMinWidth(100);
        surnameCol.setCellValueFactory(new PropertyValueFactory<Courier, String>("surname"));

        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(new PropertyValueFactory<Courier, String>("address"));

        TableColumn phoneNumberCol = new TableColumn("Phone number");
        phoneNumberCol.setMinWidth(100);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Courier, Integer>("phoneNumber"));

        courierTable.setItems(data);
        courierTable.getColumns().addAll(idCol, nameCol, surnameCol, addressCol, phoneNumberCol);
    }

    public void addCourier(Courier courier) {
        courierDao.save(courier);
        data.add(courier);
    }

    public void deleteCourier(Courier courier) {
        courierDao.delete(courier);
        data.remove(courier);
    }

}
