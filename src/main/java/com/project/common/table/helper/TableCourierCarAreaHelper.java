package com.project.common.table.helper;

import com.project.dao.CourierCarAreaDao;
import com.project.dao.jpa.CourierCarAreaJpaDao;
import com.project.dto.CourierCarArea;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DateStringConverter;

import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class TableCourierCarAreaHelper implements TableHelper<CourierCarArea> {

    private final ObservableList<CourierCarArea> data;
    private TableView<CourierCarArea> courierCarAreaTable;
    private CourierCarAreaDao courierCarAreaDao = new CourierCarAreaJpaDao();

    public TableCourierCarAreaHelper(TableView courierCarAreaTable) {
        this.courierCarAreaTable = courierCarAreaTable;
        this.data = loadData();
        setUp();
    }

    private ObservableList<CourierCarArea> loadData() {
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
        // TODO dropdown for choosing desired car

        TableColumn idAreaCol = new TableColumn("Area ID");
        idAreaCol.setMinWidth(50);
        idAreaCol.setCellValueFactory(new PropertyValueFactory<CourierCarArea, String>("idArea"));
        // TODO dropdown for choosing desired area

        TableColumn endDaterCol = new TableColumn("End date");
        endDaterCol.setMinWidth(150);
        endDaterCol.setCellValueFactory(new PropertyValueFactory<CourierCarArea, Date>("endDate"));
        endDaterCol.setCellFactory(TextFieldTableCell.<CourierCarArea, Date>forTableColumn(new DateStringConverter()));
        endDaterCol.setEditable(true);
        endDaterCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<CourierCarArea, Date>>) t -> {
            CourierCarArea courierCarArea = t.getTableView().getItems().get(t.getTablePosition().getRow());
            courierCarArea.setEndDate(t.getNewValue());
            edit(courierCarArea);
        });
        courierCarAreaTable.setItems(data);
        courierCarAreaTable.getColumns().addAll(idCourierCol, idCarCol, idAreaCol, endDaterCol);
    }

    @Override
    public void add(CourierCarArea courierCarArea) {
        courierCarAreaDao.save(courierCarArea);
        data.add(courierCarArea);
    }

    @Override
    public void add(List<String> items) {
        throw new UnsupportedOperationException("Adding new CourierCarArea not supported!");
    }

    private void edit(CourierCarArea courierCarArea) {
        courierCarAreaDao.update(courierCarArea);
    }

    @Override
    public void delete(CourierCarArea courierCarArea) {
        courierCarAreaDao.delete(courierCarArea);
        data.remove(courierCarArea);
    }

}
