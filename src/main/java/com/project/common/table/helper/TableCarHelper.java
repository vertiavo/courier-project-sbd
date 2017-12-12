package com.project.common.table.helper;

import com.project.dao.CarDao;
import com.project.dao.jpa.CarJpaDao;
import com.project.dto.Car;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class TableCarHelper implements TableHelper<Car> {

    private final ObservableList<Car> data;
    private TableView<Car> carTable;
    private CarDao carDao = new CarJpaDao();

    public TableCarHelper(TableView carTable) {
        this.carTable = carTable;
        this.data = loadData();
        setUp();
    }

    private ObservableList<Car> loadData() {
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
        brandCol.setCellFactory(TextFieldTableCell.forTableColumn());
        brandCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Car, String>>) t -> {
                    Car car = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    car.setBrand(t.getNewValue());
                    edit(car);
                }
        );

        TableColumn modelCol = new TableColumn("Model");
        modelCol.setMinWidth(100);
        modelCol.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
        modelCol.setCellFactory(TextFieldTableCell.forTableColumn());
        modelCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Car, String>>) t -> {
                    Car car = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    car.setModel(t.getNewValue());
                    edit(car);
                }
        );

        TableColumn loadCol = new TableColumn("Load");
        loadCol.setMinWidth(50);
        loadCol.setCellValueFactory(new PropertyValueFactory<Car, Double>("load"));
        // TODO load edit handler

        TableColumn capacityCol = new TableColumn("Capacity");
        capacityCol.setMinWidth(50);
        capacityCol.setCellValueFactory(new PropertyValueFactory<Car, Double>("capacity"));
        // TODO capacity edit handler

        carTable.setItems(data);
        carTable.getColumns().addAll(idCol, brandCol, modelCol, loadCol, capacityCol);
    }

    public void add(Car car) {
        carDao.save(car);
        data.add(car);
    }

    private void edit(Car car) {
        carDao.update(car);
    }

    public void delete(Car car) {
        carDao.delete(car);
        data.remove(car);
    }

}
