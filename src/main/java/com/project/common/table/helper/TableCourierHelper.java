package com.project.common.table.helper;

import com.project.dao.CourierDao;
import com.project.dao.jpa.CourierJpaDao;
import com.project.dto.Courier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class TableCourierHelper implements TableHelper<Courier> {

    private final ObservableList<Courier> data;
    private TableView<Courier> courierTable;
    private CourierDao courierDao = new CourierJpaDao();

    public TableCourierHelper(TableView courierTable) {
        this.courierTable = courierTable;
        this.data = loadData();
        setUp();
    }

    private ObservableList<Courier> loadData() {
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
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Courier, String>>) t -> {
                    Courier courier = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    courier.setName(t.getNewValue());
                    edit(courier);
                }
        );

        TableColumn surnameCol = new TableColumn("Surname");
        surnameCol.setMinWidth(100);
        surnameCol.setCellValueFactory(new PropertyValueFactory<Courier, String>("surname"));
        surnameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Courier, String>>) t -> {
                    Courier courier = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    courier.setSurname(t.getNewValue());
                    edit(courier);
                }
        );

        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(new PropertyValueFactory<Courier, String>("address"));
        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Courier, String>>) t -> {
                    Courier courier = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    courier.setAddress(t.getNewValue());
                    edit(courier);
                }
        );

        TableColumn phoneNumberCol = new TableColumn("Phone number");
        phoneNumberCol.setMinWidth(100);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Courier, Integer>("phoneNumber"));
        // TODO phone edit handler

        courierTable.setItems(data);
        courierTable.getColumns().addAll(idCol, nameCol, surnameCol, addressCol, phoneNumberCol);
    }

    public void add(Courier courier) {
        courierDao.save(courier);
        data.add(courier);
    }

    private void edit(Courier courier) {
        courierDao.update(courier);
    }

    public void delete(Courier courier) {
        courierDao.delete(courier);
        data.remove(courier);
    }

}
