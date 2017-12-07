package com.project.common.table.helper;

import com.project.dao.PackageInfoDao;
import com.project.dao.jpa.PackageInfoJpaDao;
import com.project.dto.PackageInfo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablePackageInfoHelper {

    private final ObservableList<PackageInfo> data;
    private TableView<PackageInfo> packageInfoTable;
    private PackageInfoDao packageInfoDao = new PackageInfoJpaDao();

    public TablePackageInfoHelper(TableView packageInfoTable) {
        this.packageInfoTable = packageInfoTable;
        this.data = loadPackageInfoData();
        setUp();
    }

    private ObservableList<PackageInfo> loadPackageInfoData() {
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

        TableColumn categoryCol = new TableColumn("Category");
        categoryCol.setMinWidth(100);
        categoryCol.setCellValueFactory(new PropertyValueFactory<PackageInfo, String>("category"));

        packageInfoTable.setItems(data);
        packageInfoTable.getColumns().addAll(idCol, vulnerabilityCol, categoryCol);
    }

    public void addPackageInfo(PackageInfo packageInfo) {
        packageInfoDao.save(packageInfo);
        data.add(packageInfo);
    }

    public void deletePackageInfo(PackageInfo packageInfo) {
        packageInfoDao.delete(packageInfo);
        data.remove(packageInfo);
    }

}
