package com.project.common.table.helper;

import com.project.dao.CarDao;
import com.project.dao.jpa.CarJpaDao;
import com.project.dto.Car;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableCarHelper {

    private final ObservableList<Car> data;
    private TableView<Car> carTable;
    private CarDao carDao = new CarJpaDao();

    public TableCarHelper(TableView carTable) {
        this.carTable = carTable;
        this.data = loadCarData();
        setUp();
    }

    private ObservableList<Car> loadCarData() {
        return FXCollections.observableArrayList(carDao.getAll());
    }

    private void setUp() {
        carTable.getColumns().clear();
        carTable.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<Car, Integer>("idCar"));

        TableColumn brandCol = new TableColumn("Brand");
        brandCol.setMinWidth(100);
        brandCol.setCellValueFactory(new PropertyValueFactory<Car, String>("brand"));

        TableColumn modelCol = new TableColumn("Model");
        modelCol.setMinWidth(100);
        modelCol.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));

        TableColumn loadCol = new TableColumn("Load");
        loadCol.setMinWidth(50);
        loadCol.setCellValueFactory(new PropertyValueFactory<Car, Double>("load"));

        TableColumn capacityCol = new TableColumn("Capacity");
        capacityCol.setMinWidth(50);
        capacityCol.setCellValueFactory(new PropertyValueFactory<Car, Double>("capacity"));

        carTable.setItems(data);
        carTable.getColumns().addAll(idCol, brandCol, modelCol, loadCol, capacityCol);
    }

    public void addCar(Car car) {
        carDao.save(car);
        data.add(car);
    }

    public void deleteCar(Car car) {
        carDao.delete(car);
        data.remove(car);
    }

}
