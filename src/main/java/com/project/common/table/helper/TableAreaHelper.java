package com.project.common.table.helper;

import com.project.dao.AreaDao;
import com.project.dao.jpa.AreaJpaDao;
import com.project.dto.Area;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableAreaHelper {

    private final ObservableList<Area> data;
    private TableView<Area> areaTable;
    private AreaDao areaDao = new AreaJpaDao();

    public TableAreaHelper(TableView areaTable) {
        this.areaTable = areaTable;
        this.data = loadAreaData();
        setUp();
    }

    private ObservableList<Area> loadAreaData() {
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

        areaTable.setItems(data);
        areaTable.getColumns().addAll(idCol, nameCol);
    }

    public void addArea(Area area) {
        areaDao.save(area);
        data.add(area);
    }

    public void deleteArea(Area area) {
        areaDao.delete(area);
        data.remove(area);
    }
}
