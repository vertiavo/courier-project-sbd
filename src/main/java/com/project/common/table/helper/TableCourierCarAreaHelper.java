package com.project.common.table.helper;

import com.project.dao.CourierCarAreaDao;
import com.project.dao.jpa.CourierCarAreaJpaDao;
import com.project.dto.CourierCarArea;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class TableCourierCarAreaHelper {

    private final ObservableList<CourierCarArea> data;
    private TableView<CourierCarArea> courierCarAreaTable;
    private CourierCarAreaDao courierCarAreaDao = new CourierCarAreaJpaDao();

    public TableCourierCarAreaHelper(TableView courierCarAreaTable) {
        this.courierCarAreaTable = courierCarAreaTable;
        this.data = loadCourierCarAreaData();
        setUp();
    }

    private ObservableList<CourierCarArea> loadCourierCarAreaData() {
        return FXCollections.observableArrayList(courierCarAreaDao.getAll());
    }

    private void setUp() {
        courierCarAreaTable.getColumns().clear();
        courierCarAreaTable.setEditable(true);

        TableColumn idCourierCol = new TableColumn("CID/BDATE"); // CID - Courier ID / BDATE - Begin Date
        idCourierCol.setMinWidth(50);
        idCourierCol.setCellValueFactory(new PropertyValueFactory<CourierCarArea, String>("idCourierCarArea"));

        TableColumn idCarCol = new TableColumn("Car ID");
        idCarCol.setMinWidth(50);
        idCarCol.setCellValueFactory(new PropertyValueFactory<CourierCarArea, String>("idCar"));

        TableColumn idAreaCol = new TableColumn("Area ID");
        idAreaCol.setMinWidth(50);
        idAreaCol.setCellValueFactory(new PropertyValueFactory<CourierCarArea, String>("idArea"));

        TableColumn endDaterCol = new TableColumn("End date");
        endDaterCol.setMinWidth(150);
        endDaterCol.setCellValueFactory(new PropertyValueFactory<CourierCarArea, Date>("endDate"));

        courierCarAreaTable.setItems(data);
        courierCarAreaTable.getColumns().addAll(idCourierCol, idCarCol, idAreaCol, endDaterCol);
    }

    public void addCourierCarArea(CourierCarArea courierCarArea) {
        courierCarAreaDao.save(courierCarArea);
        data.add(courierCarArea);
    }

    public void deleteCourierCarArea(CourierCarArea courierCarArea) {
        courierCarAreaDao.delete(courierCarArea);
        data.remove(courierCarArea);
    }

}
