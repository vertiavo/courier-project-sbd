package com.project.common.table.helper;

import com.project.common.util.AlertDialog;
import com.project.common.util.FieldValidator;
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
import javafx.util.converter.NumberStringConverter;

import java.util.List;

@SuppressWarnings("unchecked")
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
        nameCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<Courier, String>>) t -> {
            if (FieldValidator.validateText(t.getNewValue())) {
                Courier courier = t.getTableView().getItems().get(t.getTablePosition().getRow());
                courier.setName(t.getNewValue().toUpperCase());
                edit(courier);
            } else {
                AlertDialog.display("Error", "Invalid value");
            }
        });

        TableColumn surnameCol = new TableColumn("Surname");
        surnameCol.setMinWidth(100);
        surnameCol.setCellValueFactory(new PropertyValueFactory<Courier, String>("surname"));
        surnameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<Courier, String>>) t -> {
            if (FieldValidator.validateText(t.getNewValue())) {
                Courier courier = t.getTableView().getItems().get(t.getTablePosition().getRow());
                courier.setSurname(t.getNewValue().toUpperCase());
                edit(courier);
            } else {
                AlertDialog.display("Error", "Invalid value");
            }
        });

        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(new PropertyValueFactory<Courier, String>("address"));
        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<Courier, String>>) t -> {
            Courier courier = t.getTableView().getItems().get(t.getTablePosition().getRow());
            courier.setAddress(t.getNewValue());
            edit(courier);
        });

        TableColumn phoneNumberCol = new TableColumn("Phone number");
        phoneNumberCol.setMinWidth(100);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Courier, Integer>("phoneNumber"));
        phoneNumberCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        phoneNumberCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<Courier, Integer>>) t -> {
            Courier courier = t.getTableView().getItems().get(t.getTablePosition().getRow());
            courier.setPhoneNumber(t.getNewValue());
            edit(courier);
        });
        courierTable.setItems(data);
        courierTable.getColumns().addAll(idCol, nameCol, surnameCol, addressCol, phoneNumberCol);
    }

    @Override
    public void add(Courier courier) {
        courierDao.save(courier);
        data.add(courier);
    }

    @Override
    public void add(List<String> items) {
        Courier courier = new Courier(
                items.get(0),
                items.get(1),
                items.get(2),
                Integer.valueOf(items.get(3)));
        courierDao.save(courier);
        data.add(courier);
    }

    private void edit(Courier courier) {
        courierDao.update(courier);
    }

    @Override
    public void delete(Courier courier) {
        courierDao.delete(courier);
        data.remove(courier);
    }

}
