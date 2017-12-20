package com.project.common.table.helper;

import com.project.common.util.AlertDialog;
import com.project.common.util.FieldValidator;
import com.project.dao.AreaDao;
import com.project.dao.jpa.AreaJpaDao;
import com.project.dto.Area;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class TableAreaHelper implements TableHelper<Area> {

    private final ObservableList<Area> data;
    private TableView<Area> areaTable;
    private AreaDao areaDao = new AreaJpaDao();

    public TableAreaHelper(TableView areaTable) {
        this.areaTable = areaTable;
        this.data = loadData();
        setUp();
    }

    private ObservableList<Area> loadData() {
        return FXCollections.observableArrayList(areaDao.getAll());
    }

    private void setUp() {
        areaTable.getColumns().clear();
        areaTable.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<Area, Integer>("idArea"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<Area, String>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Area, String>>) t -> {
                    if (FieldValidator.validate(t.getNewValue())) {
                        Area area = t.getTableView().getItems().get(t.getTablePosition().getRow());
                        area.setName(t.getNewValue().toUpperCase());
                        edit(area);
                    } else {
                        AlertDialog.display("Error", "Invalid value");
                    }
                }
        );

        areaTable.setItems(data);
        areaTable.getColumns().addAll(idCol, nameCol);
    }

    public void add(Area area) {
        areaDao.save(area);
        data.add(area);
    }

    private void edit(Area area) {
        areaDao.update(area);
    }

    public void delete(Area area) {
        areaDao.delete(area);
        data.remove(area);
    }
}
