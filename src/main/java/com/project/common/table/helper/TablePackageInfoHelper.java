package com.project.common.table.helper;

import com.project.common.util.FieldValidator;
import com.project.dao.PackageInfoDao;
import com.project.dao.jpa.PackageInfoJpaDao;
import com.project.dto.PackageInfo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class TablePackageInfoHelper implements TableHelper<PackageInfo> {

    private final ObservableList<PackageInfo> data;
    private TableView<PackageInfo> packageInfoTable;
    private PackageInfoDao packageInfoDao = new PackageInfoJpaDao();

    public TablePackageInfoHelper(TableView packageInfoTable) {
        this.packageInfoTable = packageInfoTable;
        this.data = loadData();
        setUp();
    }

    private ObservableList<PackageInfo> loadData() {
        return FXCollections.observableArrayList(packageInfoDao.getAll());
    }

    private void setUp() {
        packageInfoTable.getColumns().clear();
        packageInfoTable.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<PackageInfo, Integer>("idPackage"));

        TableColumn vulnerabilityCol = new TableColumn("Vulnerability");
        vulnerabilityCol.setMinWidth(100);
        vulnerabilityCol.setCellValueFactory(new PropertyValueFactory<PackageInfo, String>("vulnerability"));
        vulnerabilityCol.setCellFactory(TextFieldTableCell.forTableColumn());
        vulnerabilityCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<PackageInfo, String>>) t -> {
                    if (FieldValidator.validate(t.getNewValue())) {
                        PackageInfo packageInfo = t.getTableView().getItems().get(t.getTablePosition().getRow());
                        packageInfo.setVulnerability(t.getNewValue().toUpperCase());
                        edit(packageInfo);
                    }
                }
        );

        TableColumn categoryCol = new TableColumn("Category");
        categoryCol.setMinWidth(100);
        categoryCol.setCellValueFactory(new PropertyValueFactory<PackageInfo, String>("category"));
        // TODO dropdown for choosing desired category

        packageInfoTable.setItems(data);
        packageInfoTable.getColumns().addAll(idCol, vulnerabilityCol, categoryCol);
    }

    public void add(PackageInfo packageInfo) {
        packageInfoDao.save(packageInfo);
        data.add(packageInfo);
    }

    private void edit(PackageInfo packageInfo) {
        packageInfoDao.update(packageInfo);
    }

    public void delete(PackageInfo packageInfo) {
        packageInfoDao.delete(packageInfo);
        data.remove(packageInfo);
    }

}
