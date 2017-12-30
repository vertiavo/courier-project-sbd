package com.project.common.table.helper;

import com.project.common.util.AlertDialog;
import com.project.common.util.FieldValidator;
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
import javafx.util.converter.DoubleStringConverter;

import java.util.List;

@SuppressWarnings("unchecked")
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
        brandCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<Car, String>>) t -> {
            if (FieldValidator.validateText(t.getNewValue().toUpperCase())) {
                Car car = t.getTableView().getItems().get(t.getTablePosition().getRow());
                car.setBrand(t.getNewValue());
                edit(car);
            } else {
                AlertDialog.display("Error", "Invalid value");
            }
        });

        TableColumn modelCol = new TableColumn("Model");
        modelCol.setMinWidth(100);
        modelCol.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
        modelCol.setCellFactory(TextFieldTableCell.forTableColumn());
        modelCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<Car, String>>) t -> {
            Car car = t.getTableView().getItems().get(t.getTablePosition().getRow());
            if (FieldValidator.validateText(t.getNewValue().toUpperCase())) {
                car.setModel(t.getNewValue());
                edit(car);
            } else {
                AlertDialog.display("Error", "Invalid value");
            }
        });

        TableColumn loadCol = new TableColumn("Load");
        loadCol.setMinWidth(50);
        loadCol.setCellValueFactory(new PropertyValueFactory<Car, Double>("load"));
        loadCol.setCellFactory(TextFieldTableCell.<Car, Double>forTableColumn(new DoubleStringConverter()));
        loadCol.setEditable(true);
        loadCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<Car, Double>>) t -> {
            Car car = t.getTableView().getItems().get(t.getTablePosition().getRow());
            car.setLoad(t.getNewValue());
            edit(car);
        });

        TableColumn capacityCol = new TableColumn("Capacity");
        capacityCol.setMinWidth(50);
        capacityCol.setCellValueFactory(new PropertyValueFactory<Car, Double>("capacity"));
        capacityCol.setCellFactory(TextFieldTableCell.<Car, Double>forTableColumn(new DoubleStringConverter()));
        capacityCol.setEditable(true);
        capacityCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<Car, Double>>) t -> {
            Car car = t.getTableView().getItems().get(t.getTablePosition().getRow());
            car.setCapacity(t.getNewValue());
            edit(car);
        });

        carTable.setItems(data);
        carTable.getColumns().addAll(idCol, brandCol, modelCol, loadCol, capacityCol);
    }

    @Override
    public void add(Car car) {
        carDao.save(car);
        data.add(car);
    }

    @Override
    public void add(List<String> items) {
        Car car = new Car(
                items.get(0),
                items.get(1),
                Double.valueOf(items.get(2)),
                Double.valueOf(items.get(3)));
        carDao.save(car);
        data.add(car);
    }

    private void edit(Car car) {
        carDao.update(car);
    }

    @Override
    public void delete(Car car) {
        carDao.delete(car);
        data.remove(car);
    }

}
